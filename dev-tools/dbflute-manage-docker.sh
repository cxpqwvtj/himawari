#!/bin/bash
set -e

$(dirname ${BASH_SOURCE:-$0})/project.sh

cd ./docker/dbflute

if [ ! "$1" = "" ]; then
  ENV1="-e ARG1=$1"
fi
if [ ! "$2" = "" ]; then
  ENV2="-e ARG2=$2"
fi
if [ ! "$answer" = "" ]; then
  ENV_ANSWER="-e answer=$answer"
fi

docker-compose run \
  --rm \
  $ENV1 \
  $ENV2 \
  $ENV_ANSWER \
  dbflute
