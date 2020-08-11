#!/usr/bin/env bash
# Script to download deployment unit from a Maven artifact repository.
# Version matching in this script assumes that the Maven artifact repository follows https://docs.oracle.com/middleware/1212/core/MAVEN/maven_version.htm#MAVEN402
# as Nexus' sorting of artifacts is used as the source for finding latest versions.
#
# Features:
# Semantic versioning configuration. The following patterns are valid:
#  - 1.2.2             -> specific release
#  - 1.2.*             -> latest release patch
#  - 1.*               -> latest release minor and patch
#  - *                 -> latest release major, minor and patch
#  - 1.2.2-SNAPSHOT    -> latest snapshot of exact version
#  - 1.2.*-SNAPSHOT    -> latest snapshot patch
#  - 1.*-SNAPSHOT      -> latest snapshot minor and patch
#  - SNAPSHOT          -> latest snapshot major, minor and patch
# Setting a delay for deploying an artifact. Checks that a given period of time has passed since the artifact was uploaded until the script will download the artifact.
# Supports hours 'h' and minutes 'm', e.g. '24h' or '90m'
#
# Exit codes:
# 1: Error or no update available - i.e. the latest version is running
# 0: New artifact has been downloaded and symlink has been updated.
# You can leverage the exit codes in a cron job if you e.g. want automatic restarting of the service if the .jar file has been updated.
# The following cron job only runs the initctl commands if the script exited with exit code 0:
# - "* * * * * su -c '/home/great-application-userEntity/update-service.sh; exit $?' -s /bin/bash - great-application && /sbin/initctl stop great-application && /sbin/initctl start great-application"
#

# Set trace variable for run in debug mode, e.g. 'TRACE=1 ./update-service-template.sh'
[[ "$TRACE" ]] && set -x
set -eo pipefail

VERSION_PATTERN=*
RELEASE_REPO=https://mvnrepo.cantara.no/content/repositories/releases
SNAPSHOT_REPO=https://mvnrepo.cantara.no/content/repositories/snapshots
GROUP_ID=no/cantara/tools
ARTIFACT_ID=visuale
CLASSIFIER=
DELAY= #hours or minutes support, e.g. '100m' and '24h'. Optional
USERNAME=
PASSWORD=

# Allow for property override, to simplify deployment and configuration
source ./scripts/semantic_update_service.properties

CURL_AUTH= #-u$USERNAME:$PASSWORD

function usage() {
    echo "Downloads deployment unit matching a given pattern from a Maven artifact repository."
    echo
    echo "Usage: update-service-template.sh"
    echo "  --help                      This small usage guide."
    echo "  --version-pattern=<value>   The version pattern you want to match. See script code for details"
    echo "  --release-repo=<value>      The Maven release repository to download artifact from"
    echo "  --snapshot-repo=<value>     The Maven snapshot repository to download artifact from"
    echo "  --group-id=<value>          Group ID of artifact to download, e.g. 'com.companyEntity.product'"
    echo "  --artifact-id=<value>       Artifact ID of artifact to download"
    echo "  --classifier=<value>        Classifier of artifact to download. Optional"
    echo "  --delay=<value>             Delay after an artifact has been published to the repository until this script will download it. Supports 'm' for minutes and 'h' for hours, e.g. '90m' or '24h'"
    echo "  --username=<value>          Username to Maven repo. Leave blank if no auth required"
    echo "  --password=<value>          Password to Maven repo. Leave blank if no auth required"
    echo
    echo "  Note that all of these params can be set directly in the script instead if you prefer."
    exit 1
}

function echoerr() { echo "$@" 1>&2; }

# Checks timestamp from Last Modified header from Nexus against current time to determine if update delay has passed.
function check_expired_delay() {
    declare url="$1"

    if [[ "$DELAY" == "" ]]; then
        echo "No download delay set. Continuing..."
        return;
    fi

    if [[ "$DELAY" == *h ]]; then
        declare delay_parsed=$(($(echo "$DELAY" | sed 's/h//') * 3600))
    fi

    if [[ "$DELAY" == *m ]]; then
        declare delay_parsed=$(($(echo "$DELAY" | sed 's/m//') * 60))
    fi

    last_modified=$(curl $CURL_AUTH --fail --show-error -sI "$url" | grep 'Last-Modified:' | sed 's/[Ll]ast-[Mm]odified: //' | { read gmt;
        date +%s -d "$gmt"; })
    lm_with_delay=$(($last_modified + $delay_parsed))

    now=$(date +%s)
    if [ "$lm_with_delay" -gt "$now" ]; then
        echo "Delay required since publishing of artifact has not passed. Will not update until after '$(date --iso-8601=minutes -d @${lm_with_delay})'. Exiting script."
        exit 1
    fi
}

function check_version_validity() {
    declare version="$1"
    if [[ "$version" == "" ]]; then
        echoerr "No file found. Possible reasons include incorrect path to maven-metadata.xml, unavailable repository or no matching artifacts found."
        echoerr "Aborting update of application, no new files downloaded"
        exit 1;
    fi
}

function verify_new_download() {
    declare jarfile="$1"
    #Check if file exists, and contains data (is not empty)
    if [[ -s "$jarfile" ]]; then
        echo "$jarfile exists, and is not empty"
    else
        echo "$jarfile is empty. Deleting it."
        rm -f "$jarfile"
        echoerr "Aborting update"
        exit 1
    fi
}

function create_or_replace_symlink() {
    declare jarfile="$1"
    verify_new_download "$jarfile"
    if [ -h "$ARTIFACT_ID".jar ]; then
        unlink "$ARTIFACT_ID".jar
    fi
    ln -s "$jarfile" "${ARTIFACT_ID}.jar"
    echo "Updated symlink '$ARTIFACT_ID.jar' to point to '$jarfile'."
}


function download_artifact() {
    declare jarfile="$1"; url="$2"

    local sha_from_remote=$(curl $CURL_AUTH --fail --show-error --silent ${url}.sha1)
    # check if file exists locally and has same hash
    if [ -f $jarfile ]; then
        local_sha=$(sha1sum "$jarfile" | awk '{print $1}')
    else
        echo "No local app file found"
        local_sha=-1
    fi

    if [ "$sha_from_remote" == "$local_sha" ]; then
        echo "Local file is same as remote"
        running_application=$(basename $(readlink -f ${ARTIFACT_ID}.jar))
        if [ "$running_application" == "$jarfile" ]; then
            echo "Newest version is running. Not doing anything."
            exit 1;
        else
            echo "Got newest version locally, but it's not the one running. Updating symlink."
            create_or_replace_symlink "$jarfile"
        fi
    else
        # Check if update delay has passed, download file and update symlink
        check_expired_delay "$url"

        echo "Downloading $url"
        curl $CURL_AUTH --fail --show-error --silent -o "$jarfile" "$url"

        create_or_replace_symlink "$jarfile"

        # Delete old jar files
        jar=${ARTIFACT_ID}*.jar
        number_of_jar_files_to_keep=$(ls ${jar} -A1t | tail -n +6 | wc -l) || true
        if [[ "$number_of_jar_files_to_keep" > 0 ]]; then
            echo "Deleting ${number_of_jar_files_to_keep} old jar files. Keep the 4 newest + the symlink."
            ls $jar -A1t | tail -n +6 | xargs rm
        fi
    fi

}

function pad_input_to_match_specific_version() {
    declare version="$1"

    if [[ "$version" != *. ]]; then
        version="${1}<" # add < to match specific version, i.e. '<version>0.8.1</version>' and not prefix '<version>0.8.1' which may match '0.8.11', '0.8.12' etc.
    fi

    eval $2="'$version'"
}

# Fetches latest, i.e. input "SNAPSHOT"
function fetch_latest_snapshot() {
    path="$SNAPSHOT_REPO/$GROUP_ID/$ARTIFACT_ID"
    # Nexus returns artifacts sorted from old to new ascending. Pick last line
    version=$(curl $CURL_AUTH --fail --show-error --silent "$path/maven-metadata.xml" | grep "<version>" | sed "s/.*<version>\([^<]*\)<\/version>.*/\1/" | tail -n 1) || true

    # version may be empty if there is only one snapshot in the repo. In the case, the <latest> tag will not be set.
    check_version_validity "$version"

    build=$(curl $CURL_AUTH --fail --show-error --silent "$path/$version/maven-metadata.xml" | grep '<value>' | head -1 | sed "s/.*<value>\([^<]*\)<\/value>.*/\1/") || true
    if [[ -n "$CLASSIFIER" ]]; then
        prepended_classifier="-${CLASSIFIER}"
    fi
    jarfile="${ARTIFACT_ID}-${build}${prepended_classifier}.jar"
    url="$path/$version/$jarfile"

    eval $1="'$jarfile'"
    eval $2="'$url'"
}

# Supports both wildcard "1.2." and specific "1.2.3"
function fetch_snapshot_of_specific_version() {
    pad_input_to_match_specific_version "$1" input_version

    path="$SNAPSHOT_REPO/$GROUP_ID/$ARTIFACT_ID"
    # Nexus returns artifacts sorted from old to new ascending. Pick last line
    version=$(curl $CURL_AUTH --fail --show-error --silent "$path/maven-metadata.xml" | grep "<version>${input_version}" | sed "s/.*<version>\([^<]*\)<\/version>.*/\1/" | tail -n 1) || true
    check_version_validity "$version"

    build=$(curl $CURL_AUTH --fail --show-error --silent "$path/$version/maven-metadata.xml" | grep '<value>' | head -1 | sed "s/.*<value>\([^<]*\)<\/value>.*/\1/") || true
    if [[ -n "$CLASSIFIER" ]]; then
        prepended_classifier="-${CLASSIFIER}"
    fi
    jarfile="${ARTIFACT_ID}-${build}${prepended_classifier}.jar"
    url="$path/$version/$jarfile"

    eval $2="'$jarfile'"
    eval $3="'$url'"
}

# Fetch latest release '*'
function fetch_latest_release() {
    path="$RELEASE_REPO/$GROUP_ID/$ARTIFACT_ID"
    version=$(curl $CURL_AUTH --fail --show-error --silent "$path/maven-metadata.xml" | grep "<release>" | sed "s/.*<release>\([^<]*\)<\/release>.*/\1/" | tail -n 1) || true
    check_version_validity "$version"

    if [[ -n "$CLASSIFIER" ]]; then
        prepended_classifier="-${CLASSIFIER}"
    fi
    jarfile="${ARTIFACT_ID}-${version}${prepended_classifier}.jar"
    url="$path/$version/$jarfile"

    eval $1="'$jarfile'"
    eval $2="'$url'"
}

# Supports both wildcard "1.2." and specific "1.2.3"
function fetch_specific_release() {
    pad_input_to_match_specific_version "$1" input_version

    path="$RELEASE_REPO/$GROUP_ID/$ARTIFACT_ID"
    # Nexus returns artifacts sorted from old to new ascending. Pick last line
    version=$(curl $CURL_AUTH --silent --fail --show-error "$path/maven-metadata.xml" | grep -F "<version>${input_version}" | sed "s/.*<version>\([^<]*\)<\/version>.*/\1/" | tail -n 1) || true
    check_version_validity "$version"

    if [[ -n "$CLASSIFIER" ]]; then
        prepended_classifier="-${CLASSIFIER}"
    fi
    jarfile="${ARTIFACT_ID}-${version}${prepended_classifier}.jar"
    url="$path/$version/$jarfile"

    eval $2="'$jarfile'"
    eval $3="'$url'"
}

function find_artifact() {
    declare input_version=$1

    if [[ -z "${input_version//}" ]]; then
        echo "Parameter is empty. Run like './update-service-template.sh \"./1.0.*-SNAPSHOT\"'"
        return 1;
    fi

    # just wildcard
    if [[ "$input_version" == '*' ]]; then
        echo "Fetching latest release"
        fetch_latest_release JARFILE URL

    # just snapshot
    elif [[ "$input_version" == 'SNAPSHOT' ]]; then
        echo "Fetching latest snapshot"
        fetch_latest_snapshot JARFILE URL

    # Contains wildcard
    elif [[ "$input_version" == *'*'* ]]; then
        # Strip wildcard and -SNAPSHOT from version
        version_stripped=$(echo "$input_version" | sed -e 's/*//' -e 's/-SNAPSHOT//')

        # Contains snapshot as well
        if [[ "$input_version" == *"SNAPSHOT" ]]; then
            echo "Fetching latest snapshot of version ${input_version}"
            fetch_snapshot_of_specific_version "$version_stripped" JARFILE URL
        else
            # Just wildcard. Must be release
            echo "Fetching latest release of version ${input_version}"
            fetch_specific_release "$version_stripped" JARFILE URL
        fi

    # specific snapshot
    elif [[ "$input_version" != '*' ]] && [[ "$input_version" == *SNAPSHOT ]]; then
        echo "Fetching specific snapshot ${input_version}"
        fetch_snapshot_of_specific_version "$input_version" JARFILE URL

    # specific release
    elif [[ "$input_version" != '*' ]] && [[ "$input_version" != "SNAPSHOT" ]]; then
        echo "Fetching specific release ${input_version}"
        fetch_specific_release "$input_version" JARFILE URL
    fi

    eval $2="'$JARFILE'"
    eval $3="'$URL'"
}

function main() {
    while [ $# -ge 1 ]; do
        case $1 in
            --help)
                usage
            ;;
            --version-pattern=?*)
                VERSION_PATTERN=${1#--version-pattern=}
            ;;
            --release-repo=?*)
                RELEASE_REPO=${1#--release-repo=}
            ;;
            --snapshot-repo=?*)
                SNAPSHOT_REPO=${1#--snapshot-repo=}
            ;;
            --group-id=?*)
                GROUP_ID=${1#--group-id=}
            ;;
            --artifact-id=?*)
                ARTIFACT_ID=${1#--artifact-id=}
            ;;
            --classifier=?*)
                CLASSIFIER=${1#--classifier=}
            ;;
            --delay=?*)
                DELAY=${1#--delay=}
            ;;
            --username=?*)
                USERNAME=${1#--username=}
            ;;
            --password=?*)
                PASSWORD=${1#--password=}
            ;;
            *)
                usage
            ;;
        esac
        shift
    done

    if [[ ! ${VERSION_PATTERN} ]]; then
        echo "Missing version pattern (e.g. --version-pattern='1.0.*')"
        exit
    fi

    if [[ -n "$PASSWORD" || -n "$USERNAME" ]]; then
        CURL_AUTH="-u$USERNAME:$PASSWORD"
    fi

    GROUP_ID=$(echo "$GROUP_ID" | sed -e 's,\.,/,g')

    find_artifact "$VERSION_PATTERN" jarfile url
    echo "Latest matching artifact found is '${jarfile}'"
    download_artifact "$jarfile" "$url"
}

# Do not execute main if 'sourced' is used as param
if [[ ! $1 = "sourced" ]]; then
    main "$@"
fi
