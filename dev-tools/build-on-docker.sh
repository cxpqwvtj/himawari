#!/bin/bash

usage_exit() {
  echo "Usage: $0 [-s] [-c]" 1>&2
  exit 1
}

BUILD_CLIENT=1
BUILD_SERVER=1

while getopts scx:h OPT
do
  case $OPT in
    s)  BUILD_CLIENT=0
        BUILD_SERVER=1
      ;;
    c)  BUILD_CLIENT=1
        BUILD_SERVER=0
      ;;
    x)  SKIP_TASK=$OPTARG
      ;;
    h)  usage_exit
      ;;
    \?) usage_exit
      ;;
  esac
done

shift $((OPTIND - 1))

$(dirname ${BASH_SOURCE:-$0})/project.sh

if [ $BUILD_CLIENT -eq 1 ]; then
  # クライアントビルド
  CLIENT_DEV_IMAGE_NAME="cxpqwvtj/himawari-dev-client-image"
  CLIENT_DEV_IMAGES=`docker images | grep -c $CLIENT_DEV_IMAGE_NAME`
  if [ $CLIENT_DEV_IMAGES -lt 1 ]; then
    docker build -f dev-tools/docker/dev-client-image/Dockerfile -t $CLIENT_DEV_IMAGE_NAME .
  fi

  docker run --rm -v `pwd`:/app $CLIENT_DEV_IMAGE_NAME
fi

if [ $BUILD_SERVER -eq 1 ]; then
  # サーバビルド
  SERVER_DEV_IMAGE_NAME="cxpqwvtj/himawari-dev-server-image"
  SERVER_DEV_IMAGES=`docker images | grep -c $SERVER_DEV_IMAGE_NAME`
  if [ $SERVER_DEV_IMAGES -lt 1 ]; then
    docker build -f dev-tools/docker/dev-server-image/Dockerfile -t $SERVER_DEV_IMAGE_NAME .
  fi

  docker run --rm -v `pwd`:/app $SERVER_DEV_IMAGE_NAME
fi
