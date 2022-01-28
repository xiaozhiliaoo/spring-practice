#!/bin/bash

# support core dump
ulimit -c unlimited
sudo /sbin/sysctl -w kernel.core_pattern=/home/admin/spring-training-base/logs/%e.core.%p > /dev/null 2>&1

cd /home/admin/spring-training-base

# start java service
nohup java -server -Xms2g -Xmx2g -Dproject.name=spring-training-base \
-XX:+UseG1GC -XX:MaxGCPauseMillis=200 \
-XX:-HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/home/admin/spring-training-base/logs/heapdump.hprof \
-XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=512m \
-jar spring-training-base.jar > /dev/null 2>&1 &