#!/bin/sh
source $HOME/scripts/semantic_update_service.properties
source $HOME/scripts/start-service.properties
jar=$ARTIFACT_ID
jvmargs=$JVM_ARGS
nohup java $jvmargs -jar "$jar.jar" &
