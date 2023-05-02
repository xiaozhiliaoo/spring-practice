#!/usr/bin/env bash
ps -ef | grep 'chars-api.jar' | grep -v grep | awk '{print $2}' | xargs kill -9