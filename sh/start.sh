#!/usr/bin/env bash
BASE_START_CMD='java -server -Xms1g -Xmx1g
-XX:+UseG1GC -XX:MaxGCPauseMillis=200
-XX:-HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=~/heapdump.hprof
-XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=512m
-jar ..'

RUN=${BASE_START_CMD}/chars-api/target/chainup-api.jar

nohup ${RUN} > chars-api.log 2>&1 &