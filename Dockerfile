#Build
FROM openjdk:8-jdk-alpine as builder
LABEL builder=true

MAINTAINER goodnessd

WORKDIR /source

#COPY ./gradle/ ./gradle/
#COPY ./gradlew ./
#
#
#COPY ./build.gradle ./

COPY ./ ./
RUN ./gradlew build --no-daemon

#App
FROM openjdk:8u131-jdk-alpine
LABEL builder=false

WORKDIR /deploy

EXPOSE 8080

COPY --from=builder /source/build/libs ./

ENTRYPOINT java -jar demo-0.1.0.jar
