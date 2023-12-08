#!/bin/sh

# JSON="`wget -qO-  http://localhost:8080/health`";wget --method=PUT --body-data="${JSON}"   https://visuale.cantara.no/status/test/visuale/demo

$(dirname $BASH_SOURCE)/semantic_update_service.sh

if [ $? -eq 0 ]
then
  $(dirname $BASH_SOURCE)/kill-service.sh
  $(dirname $BASH_SOURCE)/start-service.sh
  echo "Successfully updated service"
else
  echo "No updates found"
  source $(dirname $BASH_SOURCE)/semantic_update_service.properties
  artifactFile=${ARTIFACT_ID}.jar
  if ps -ef | grep java | grep ${artifactFile}; then
     echo "Running process found - doing nothing"
  else
     echo "Running process not found - restarting process"
     $(dirname $BASH_SOURCE)/start-service.sh
  fi

fi
