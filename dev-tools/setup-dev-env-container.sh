#!/bin/bash -e

cd $(dirname ${BASH_SOURCE:-$0})/..

docker-compose -f `pwd`/dev-tools/docker/docker-compose.yml -p himawaridev up -d

echo ""
echo "Command for stop..."
echo "docker-compose -f `pwd`/dev-tools/docker/docker-compose.yml -p himawaridev stop"
