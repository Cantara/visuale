#!/bin/bash
#  FROM
#     wget https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale_CronScript_curl_bash.sh
#

source $(dirname $BASH_SOURCE)/reportServiceHealthToVisuale.properties

for n in 1 2 3 4 5 6 7 8 9 10; do
  if json=$(curl --silent $healthUrl) ;
  then
    echo "UP"
  else
    echo "Down"
    json=$(<./scripts/Visuale_SERVICE_FAIL.json)
  fi
  printf "%s" "$json" | curl --silent -X PUT -H "Content-Type: application/json" -X PUT --data-binary @- "$reportToUrl1"
  printf "%s" "$json" | curl --silent -X PUT -H "Content-Type: application/json" -X PUT --data-binary @- "$reportToUrl2"
  sleep 4
done
