#!/bin/bash -e

$(dirname ${BASH_SOURCE:-$0})/project.sh

RUBY_DEV_IMAGE_NAME="cxpqwvtj/himawari-ruby-libs"
RUBY_DEV_IMAGES=`docker images | grep -c $RUBY_DEV_IMAGE_NAME`
if [ $RUBY_DEV_IMAGES -lt 1 ]; then
  docker build -f docker/ruby-libs/Dockerfile -t $RUBY_DEV_IMAGE_NAME .
fi

docker run --rm -v `pwd`:/app $RUBY_DEV_IMAGE_NAME bundle exec prmd combine --meta docs/json-schema/meta.yml docs/json-schema/schemata/ > docs/json-schema/schema.json
docker run --rm -v `pwd`:/app $RUBY_DEV_IMAGE_NAME bundle exec prmd verify docs/json-schema/schema.json
docker run --rm -v `pwd`:/app $RUBY_DEV_IMAGE_NAME bundle exec prmd doc docs/schema/schema.json > docs/schema/schema.md
