#!/bin/sh

source ./reportServiceHealthToVisuale_CronScript.properties
for n in 1 2 3 4 5 6 7 8 9 10; do
  if
    JSON="$(wget -qO- $healthUrl)"
    wget --method=PUT --body-data="${JSON}" $reportToUrl1
  then
    JSON="$(wget -qO- $healthUrl)"
    wget --method=PUT --body-data="${JSON}" $reportToUrl2
  else
    JSON=$(<Visuale_FAIL.json)
    wget --method=PUT --body-data="${JSON}" $reportToUrl1
    JSON=$(<Visuale_FAIL.json)
    wget --method=PUT --body-data="${JSON}" $reportToUrl2
  fi
  sleep 4
done
