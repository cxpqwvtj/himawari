#!/bin/bash

$(dirname ${BASH_SOURCE:-$0})/project.sh

IMAGE_NAME="cxpqwvtj/himawari-dev-client-image"

IMAGES=`docker images | grep -c $IMAGE_NAME`

if [ $IMAGES -lt 1 ]; then
  docker build -f dev-tools/docker/dev-client-image/Dockerfile -t $IMAGE_NAME .
fi

docker run --rm -v `pwd`:/app $IMAGE_NAME
