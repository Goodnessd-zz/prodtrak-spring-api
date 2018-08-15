#App
FROM openjdk:8u131-jdk-alpine
LABEL builder=false
VOLUME tmp/
WORKDIR /deploy

COPY --from=builder /source/build/libs ./

EXPOSE 8080

ENTRYPOINT java -jar -Dspring.mongodb.uri=mongodb://mongo/demo -Dspring.profiles.active=container demo.jar