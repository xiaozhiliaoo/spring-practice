#!/bin/bash
curl -s --connect-timeout 3 localhost/offline
sleep 10
ps -ef|grep java|grep spring-training-base |awk '{print $2}'|xargs kill -9 > /dev/null 2>&1