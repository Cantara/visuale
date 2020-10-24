#!/bin/sh

# JSON="`wget -qO-  http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/status/test/visuale/demo

./scripts/semantic_update_service.sh

if [ $? -eq 0 ]
then
  ./scripts/kill-service.sh
  ./scripts/start-service.sh
  echo "Successfully updated service"
else
  echo "No updates found"
  if ps -ef | grep java | grep visuale.jar; then
     echo "Running process found - doing nothing"
  else
     echo "Running process not found - restarting process"
    ./scripts/start-service.sh
  fi

fi