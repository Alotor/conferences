#!/bin/bash

./api_get.sh attendee
./api_get.sh attendee/1
./api_post.sh attendee '{"name":"Test"}'
./api_post.sh attendee/1 '{"name":"Test"}'

