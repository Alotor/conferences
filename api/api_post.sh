#!/bin/bash
OUT=`curl -sS -X POST -H "Authorization: Basic YWRtaW46YWRtaW4=" -H "Content-Type: application/json" -d "$2" http://localhost:8080/conferences/myadmin/api/$1`

echo "$OUT" | python -mjson.tool
