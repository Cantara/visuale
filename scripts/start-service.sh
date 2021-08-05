#!/bin/sh
source $HOME/scripts/semantic_update_service.properties
jar=$ARTIFACT_ID
jvm_args=$JVM_ARGS
nohup java $jvmargs -jar $jar.jar &