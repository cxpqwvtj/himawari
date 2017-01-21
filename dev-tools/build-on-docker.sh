#!/bin/bash

$(dirname ${BASH_SOURCE:-$0})/project.sh

# クライアントビルド
CLIENT_DEV_IMAGE_NAME="cxpqwvtj/himawari-dev-client-image"
CLIENT_DEV_IMAGES=`docker images | grep -c $CLIENT_DEV_IMAGE_NAME`
if [ $CLIENT_DEV_IMAGES -lt 1 ]; then
  docker build -f dev-tools/docker/dev-client-image/Dockerfile -t $CLIENT_DEV_IMAGE_NAME .
fi

#docker run --rm -v `pwd`:/app $CLIENT_DEV_IMAGE_NAME

# サーバビルド
SERVER_DEV_IMAGE_NAME="cxpqwvtj/himawari-dev-server-image"
SERVER_DEV_IMAGES=`docker images | grep -c $SERVER_DEV_IMAGE_NAME`
if [ $SERVER_DEV_IMAGES -lt 1 ]; then
  docker build -f dev-tools/docker/dev-server-image/Dockerfile -t $SERVER_DEV_IMAGE_NAME .
fi

docker run --rm -v `pwd`:/app $SERVER_DEV_IMAGE_NAME
