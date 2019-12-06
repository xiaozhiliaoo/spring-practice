#!/bin/bash

# support core dump
ulimit -c unlimited
sudo /sbin/sysctl -w kernel.core_pattern=/home/admin/spring-traning-base/logs/%e.core.%p > /dev/null 2>&1

cd /home/admin/spring-traning-base

# start java service
nohup java -server -Xms2g -Xmx2g -Dproject.name=spring-traning-base \
-XX:+UseG1GC -XX:MaxGCPauseMillis=200 \
-XX:-HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/home/admin/spring-traning-base/logs/heapdump.hprof \
-XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=512m \
-jar spring-traning-base.jar > /dev/null 2>&1 &