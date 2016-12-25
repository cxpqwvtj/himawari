#!/bin/bash -e

cd $(dirname ${BASH_SOURCE:-$0})/..

bundle exec prmd combine --meta docs/schema/meta.yml docs/schema/schemata/ > docs/schema/schema.json
