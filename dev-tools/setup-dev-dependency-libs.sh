#!/bin/bash -e

cd $(dirname ${BASH_SOURCE:-$0})/..

bundle install --path vendor/bundle
npm install
