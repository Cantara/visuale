#!/bin/bash

source ./scripts/reportServiceHealthToVisuale_CronScript.properties

for n in 1 2 3 4 5 6 7 8 9 10; do
  if
    JSON="$(wget -qO- $healthUrl)"
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl1}" -d ${JSON} | sed -e 's/^"//' -e 's/"$//'
  then
    JSON="$(wget -qO- $healthUrl)"
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl2}" -d ${JSON} | sed -e 's/^"//' -e 's/"$//'

    #    wget --method=PUT --body-data="${JSON}" $reportToUrl2
  else
    JSON=$(<./scripts/ConfigService_FAIL.json)
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl1}" -d ${JSON} | sed -e 's/^"//' -e 's/"$//'
    JSON=$(<./scripts/ConfigService_FAIL.json)
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl2}" -d ${JSON} | sed -e 's/^"//' -e 's/"$//'
    #    wget --method=PUT --body-data="${JSON}" $reportToUrl2
  fi
  sleep 4
done
