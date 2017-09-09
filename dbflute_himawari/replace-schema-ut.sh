#!/bin/bash

cd `dirname $0`

export DBFLUTE_ENVIRONMENT_TYPE=ut
export answer=y

./manage.sh 0
