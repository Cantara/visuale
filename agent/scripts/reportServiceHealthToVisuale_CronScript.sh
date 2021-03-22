#!/bin/sh
#  FROM
#     https://raw.githubusercontent.com/Cantara/visuale/master/agent/scripts/reportServiceHealthToVisuale_CronScript.sh
#

source ./scripts/reportServiceHealthToVisuale.properties
for n in 1 2 3 4 5 6 7 8 9 10; do
  if JSON=$(curl --silent  ${healthUrl}) ;
  then
    echo "UP" ${JSON}
    curl  -i -X PUT -H "Content-Type: application/json"  "${reportToUrl1}" -d "${JSON}"
    curl  -i -X PUT -H "Content-Type: application/json"  "${reportToUrl2}" -d "${JSON}"
    #    wget --method=PUT --body-data="${JSON}" $reportToUrl2
  else
    echo "Down"
    JSON=$(<./scripts/Visuale_SERVICE_FAIL.json)
    curl -i -X PUT -H "Content-Type: application/json" "${reportToUrl1}" -d "${JSON}"
    curl -i -X PUT -H "Content-Type: application/json" "${reportToUrl2}" -d "${JSON}"
    #    wget --method=PUT --body-data="${JSON}" $reportToUrl2
  fi
  sleep 4
done
