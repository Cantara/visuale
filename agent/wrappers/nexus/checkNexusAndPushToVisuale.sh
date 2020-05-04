#!/bin/bash

INDEXRESULT="`wget -qO- http://localhost`"
echo $INDEXRESULT

if [[ $INDEXRESULT =~ "Nexus" ]]; then
  echo "Nexus OK!"
  JSON=$(<Nexus_OK.json ); wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/status
  exit
fi
echo "Nexus DOWN!"
JSON=$(<Nexus_FAIL.json ); wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/status


