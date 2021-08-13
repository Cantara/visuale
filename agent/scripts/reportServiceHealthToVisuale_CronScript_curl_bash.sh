#!/bin/bash
#  FROM
#     wget https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale_CronScript_curl_bash.sh
#

source $(dirname $BASH_SOURCE)/reportServiceHealthToVisuale.properties
source $(dirname $BASH_SOURCE)/semantic_update_service.properties

function urldecode() { : "${*//+/ }"; echo -e "${_//%/\\x}"; }

# Extract actual version from the name of jar file that is linked to
artifactFile=$(dirname $BASH_SOURCE)/../${ARTIFACT_ID}.jar
artifactVersion=$(readlink -f ${artifactFile} | xargs basename -s .jar | cut -c$((${#ARTIFACT_ID}+2))-)

# Extract name from pattern in report-url to ensure that failure reporting uses same name as
# This can be replaced with static name put in json template or the name variable here.
name=$(urldecode $(printf "%s" "$reportToUrl1" | perl -n -e'/https?:\/\/(?<host>[^\/]+)\/(api\/)?status\/(?<env>[^\/]+)\/(?<name>[^\/]+)\/(?<node>[^\/?]+).*/ && print "$+{name}"'))

# This can be replaced with static ip-address put in json fail template or the ip variable here.
#ip=$(/usr/sbin/ip -f inet address show dev eth0 | grep inet | awk '{print $2;}' | cut -d"/" -f1)
ip=$(hostname -i)

runtime="1 minute"
endtime=$(date -ud "$runtime" +%s)

while [[ $(date -u +%s) -le $endtime ]]
do
  # Attempt to get health status from application
  if json=$(curl --silent "$healthUrl") ;
  then
    echo "UP"
  else
    echo "Down"
    # Iso 8601 timestamp
    now=$(date -u +'%Y-%m-%dT%H:%M:%S.%3NZ')
    # Use failure json-template and replace dynamic values with sed
    json=$(cat $(dirname $BASH_SOURCE)/Visuale_SERVICE_FAIL.json | sed -e "s/#NAME#/${name}/" | sed -e "s/#VERSION#/${artifactVersion}/" | sed -e "s/#NOW#/${now}/" | sed -e "s/#IP#/${ip}/")
  fi

  # Report to all urls set in properties file
  for r in $reportToUrl1 $reportToUrl2 $reportToUrl3 $reportToUrl4 $reportToUrl5; do
    printf "%s" "$json" | curl --silent -H "Content-Type: application/json" -X PUT --data-binary @- "$r"
  done

  sleep 4
done
