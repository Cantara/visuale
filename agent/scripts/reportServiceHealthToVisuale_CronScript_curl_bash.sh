#!/bin/bash
#  FROM
#     wget https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale_CronScript_curl_bash.sh
#

source $(dirname $BASH_SOURCE)/reportServiceHealthToVisuale.properties

for n in 1 2 3 4 5 6 7 8 9 10; do
  if JSON=$(curl --silent $healthUrl) ;
  then
    echo "UP"
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl1}" -d '${JSON}' | sed -e 's/^"//' -e 's/"$//'
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl2}" -d '${JSON}' | sed -e 's/^"//' -e 's/"$//'
  else
    echo "Down"
    JSON=$(<./scripts/Visuale_SERVICE_FAIL.json)
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl1}" -d '${JSON}' | sed -e 's/^"//' -e 's/"$//'
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl2}" -d '${JSON}' | sed -e 's/^"//' -e 's/"$//'
  fi
  sleep 4
done
