FROM java:openjdk-8-jdk-alpine
MAINTAINER cxpqwvtj

RUN apk add --no-cache bash libstdc++

WORKDIR /app

ADD gradle /app/gradle
ADD build.gradle /app/build.gradle
ADD settings.gradle /app/settings.gradle
ADD gradlew /app/gradlew
ADD src/main/kotlin/app/himawari/Application.kt /app/src/main/kotlin/app/himawari/Application.kt
RUN ./gradlew build -x test

CMD ["./gradlew", "build", "-x", "test"]
