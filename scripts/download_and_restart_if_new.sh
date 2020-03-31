#!/bin/sh
./scripts/semantic_update_service.sh

if [ $? -eq 0 ]
then
  ./scripts/kill-service.sh
  ./scripts/start-service.sh
  echo "Successfully updated service"
else
  echo "No updates found, doing nothing"
fi