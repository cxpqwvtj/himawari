FROM java:openjdk-8-jdk-alpine
LABEL maintainer="cxpqwvtj@gmail.com"

RUN apk add --no-cache bash libstdc++ nodejs
RUN echo -e 'http://dl-cdn.alpinelinux.org/alpine/edge/main\nhttp://dl-cdn.alpinelinux.org/alpine/edge/community\nhttp://dl-cdn.alpinelinux.org/alpine/edge/testing' > /etc/apk/repositories && \
    apk add --no-cache yarn

WORKDIR /app

ADD gradle /app/gradle
ADD build.gradle /app/build.gradle
ADD settings.gradle /app/settings.gradle
ADD gradlew /app/gradlew
ADD src/main/kotlin/app/himawari/Application.kt /app/src/main/kotlin/app/himawari/Application.kt
RUN ./gradlew build -x test

ADD package.json /app/package.json
ADD .babelrc /app/.babelrc
ADD .eslintrc.js /app/.eslintrc.js
ADD webpack.config.js /app/webpack.config.js
RUN yarn --no-progress --no-emoji

ADD src /app/src

ADD docker/himawari/entrypoint.sh /app/entrypoint.sh

RUN npm run package && \
    ./gradlew build -x test && \
    cp ./build/libs/himawari.jar . && \
    rm -rf ./node_modules && \
    rm -rf ./build && \
    rm -rf /root/.gradle && \
    rm -rf /root/.npm

ENTRYPOINT ["/app/entrypoint.sh"]

CMD ["java", "-jar", "himawari.jar"]
