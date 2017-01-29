FROM nginx:1.11.9-alpine
MAINTAINER cxpqwvtj

WORKDIR /app

ENV VERSION="2.2.8"
ENV ARCHIVE_FILE="v$VERSION.tar.gz" \
    FOLDER="swagger-ui-$VERSION" \
    DOC_ROOT="/app/swagger"

COPY default.conf /etc/nginx/conf.d/default.conf

RUN apk add --no-cache openssl && \
    wget -qO- https://github.com/swagger-api/swagger-ui/archive/${ARCHIVE_FILE} | tar xvz && \
    mkdir -p $DOC_ROOT && \
    cp -r $FOLDER/dist/* $DOC_ROOT && rm -rf $FOLDER && \
    apk del openssl && \
    sed -i "s|http://petstore.swagger.io/v2/swagger.json|swagger.yml|g" $DOC_ROOT/index.html
