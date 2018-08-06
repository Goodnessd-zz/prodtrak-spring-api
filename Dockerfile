#Build
FROM openjdk:8-jdk-alpine as builder
LABEL builder=true

WORKDIR /source

COPY ./ ./
RUN ./gradlew build --no-daemon

#App
FROM openjdk:8u131-jdk-alpine
LABEL builder=false
VOLUME tmp/
WORKDIR /deploy

COPY --from=builder /source/build/libs ./

EXPOSE 8080

ENTRYPOINT java -jar demo-0.1.0.jar
