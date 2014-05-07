#!/bin/bash
OUT=`curl -sS -X DELETE -H "Authorization: Basic YWRtaW46YWRtaW4=" -H "Content-Type: application/json" -d "$2" http://localhost:8080/conferences/ddd/api/$1`

echo "$OUT"
