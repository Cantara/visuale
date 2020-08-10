#!/bin/sh
for n in 1 2 3 4 5 6 7 8 9 10; do
  if
    JSON="$(wget -qO- http://localhost:8080/health)"
    wget --method=PUT --body-data="${JSON}" https://visuale-devtest.cantara.no/api/status/devtest/Visuale%20DEVTEST%20Dash
    board/node?service_tag=SoftwareFactory
  then
    JSON="$(wget -qO- http://localhost:8080/health)"
    wget --method=PUT --body-data="${JSON}" https://visuale.cantara.no/api/status/prod/isuale%20DEVTEST%20Dashboard/nod
    e?service_tag=SoftwareFactory
  else
    JSON=$(<Visuale_FAIL.json)
    wget --method=PUT --body-data="${JSON}" https://visuale-devtest.cantara.no/api/status/devtest/Visuale%20DEVTEST%20Dashboard/node?service_t
    ag=SoftwareFactory
    JSON=$(<Visuale_FAIL.json)
    wget --method=PUT --body-data="${JSON}" https://visuale.cantara.no/api/status/prod/Visuale%20DEVTEST%20Dashboard/node?service_tag=Softw
    areFactory
  fi
  sleep 4
done
