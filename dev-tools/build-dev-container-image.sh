#!/bin/bash -e

cd $(dirname ${BASH_SOURCE:-$0})/..

docker build -f docker/ruby/Dockerfile -t cxpqwvtj/himawarirubylib .
