#!/bin/sh
SEMANTIC_PROPERTIES_FILE=$(dirname $BASH_SOURCE)/semantic_update_service.properties
if [ -f "$SEMANTIC_PROPERTIES_FILE" ]; then
    . $SEMANTIC_PROPERTIES_FILE
fi
START_PROPERTIES_FILE=$(dirname $BASH_SOURCE)/start-service.properties
if [ -f "$START_PROPERTIES_FILE" ]; then
    . $START_PROPERTIES_FILE
fi
jar=$ARTIFACT_ID
jvmargs=$JVM_ARGS
nohup java $jvmargs -jar "$jar.jar" &
