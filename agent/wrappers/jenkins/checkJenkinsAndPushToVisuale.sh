#!/bin/bash

LOGINRESULT="`wget -qO- http://localhost:8080/login`"
echo $LOGINRESULT

if [[ $LOGINRESULT =~ "Jenkins" ]]; then
  echo "Nexus OK!"
  JSON=$(<Jenkins_OK.json ); wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/status
  exit
fi
echo "Nexus DOWN!"
JSON=$(<Jenkins_FAIL.json ); wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/status


