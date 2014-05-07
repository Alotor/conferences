#!/bin/bash
OUT=`curl -sS -X GET -H "Authorization: Basic YWRtaW46YWRtaW4=" http://localhost:8080/conferences/ddd/api/$1`

echo "$OUT" | python -mjson.tool
