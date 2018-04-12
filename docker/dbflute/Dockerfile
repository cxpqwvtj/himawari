FROM java:openjdk-8-jdk-alpine
LABEL maintainer "cxpqwvtj <cxpqwvtj@gmail.com>"

RUN apk add --no-cache bash libstdc++ curl

WORKDIR /app

ENV DBFLUTE_VERSION="1.1.2" \
    DBFLUTE_ENVIRONMENT_TYPE="docker"

RUN mkdir -p mydbflute/dbflute-${DBFLUTE_VERSION} && \
    cd mydbflute/dbflute-${DBFLUTE_VERSION} && \
    curl -fSL http://dbflute.seasar.org/download/dbflute/dbflute-${DBFLUTE_VERSION}.zip -o dbflute.zip && \
    unzip dbflute.zip && \
    rm -rf dbflute.zip && \
    cd etc/client-template && \
    unzip dbflute_dfclient.zip dbflute_dfclient/manage.sh dbflute_dfclient/_project.sh && \
    mkdir -p /app/dbflute_himawari && \
    mv dbflute_dfclient/_project.sh /app/dbflute_himawari/_project.sh && \
    mv dbflute_dfclient/manage.sh /app/dbflute_himawari/manage.sh && \
    chmod 755 /app/dbflute_himawari/*.sh

ADD docker/dbflute/entrypoint.sh /app/entrypoint.sh

ENTRYPOINT ["/app/entrypoint.sh"]

CMD ["/app/dbflute_himawari/manage.sh"]
