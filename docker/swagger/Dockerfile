FROM nginx:1.11.9-alpine
MAINTAINER cxpqwvtj

WORKDIR /app

ENV UI_VERSION="2.2.8"
ENV UI_ARCHIVE_FILE="v$UI_VERSION.tar.gz" \
    UI_FOLDER="swagger-ui-$UI_VERSION" \
    UI_DOC_ROOT="/app/swagger-ui"

COPY default.conf /etc/nginx/conf.d/default.conf

RUN apk add --no-cache openssl && \
    wget -qO- https://github.com/swagger-api/swagger-ui/archive/${UI_ARCHIVE_FILE} | tar xvz && \
    mkdir -p $UI_DOC_ROOT && \
    cp -r $UI_FOLDER/dist/* $UI_DOC_ROOT && rm -rf $UI_FOLDER && \
    apk del openssl && \
    sed -i "s|http://petstore.swagger.io/v2/swagger.json|swagger.yml|g" $UI_DOC_ROOT/index.html
