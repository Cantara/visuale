#!/bin/bash

source ./scripts/reportServiceHealthToVisuale.properties

for n in 1 2 3 4 5 6 7 8 9 10; do
  if JSON="$(wget -qO- $healthUrl)" ;
  then
    echo "UP"
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl1}" -d ${JSON} | sed -e 's/^"//' -e 's/"$//'
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl2}" -d ${JSON} | sed -e 's/^"//' -e 's/"$//'
    #    wget --method=PUT --body-data="${JSON}" $reportToUrl2
  else
    echo "Down"
    JSON=$(<./scripts/Visuale_FAIL.json)
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl1}" -d ${JSON} | sed -e 's/^"//' -e 's/"$//'
    curl --silent -X PUT -H "Content-Type: application/json" "${reportToUrl2}" -d ${JSON} | sed -e 's/^"//' -e 's/"$//'
    #    wget --method=PUT --body-data="${JSON}" $reportToUrl2
  fi
  sleep 4
done
