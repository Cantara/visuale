#!/bin/bash

source ./scripts/reportServiceHealthToVisuale_CronScript.properties

for n in 1 2 3 4 5 6 7 8 9 10; do
  if JSON="$(wget -qO- $healthUrl)" ;
  then
    echo "UP"
#    echo $JSON
#  Supporting larhe json loads
    echo $JSON | wget --method=PUT --body-data=@- $reportToUrl1
    echo $JSON | wget --method=PUT --body-data=@- $reportToUrl2
#  Old version, will break with too many argumnets if json is too big
#    wget --method=PUT --body-data="$JSON" $reportToUrl1
#    wget --method=PUT --body-data="$JSON" $reportToUrl2
  else
    echo "down"
    JSON=$(<./scripts/Visuale_FAIL.json)
    wget --method=PUT --body-data="${JSON}" $reportToUrl1
    wget --method=PUT --body-data="${JSON}" $reportToUrl2
  fi
  sleep 4
done

