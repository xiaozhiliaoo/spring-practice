#!/bin/bash
if [ -n "$(curl -s localhost/health)" ]; then
    exit 0
else
    echo "FAIL TO CHECK HEALTH"
    exit 1
fi