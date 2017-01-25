#!/bin/bash -e

cd $(dirname ${BASH_SOURCE:-$0})/..

COMPOSE_FILE=`pwd`/docker/mysql/docker-compose.yml
DOCKER_PJ_NAME=himawaridb

docker-compose -f $COMPOSE_FILE -p $DOCKER_PJ_NAME up -d

echo ""
echo "Command for stop..."
echo "docker-compose -f $COMPOSE_FILE -p $DOCKER_PJ_NAME stop"
