FROM adoptopenjdk/openjdk11:alpine

ARG APP_JAR=upstream-0.0.1-SNAPSHOT.jar
EXPOSE 8080

COPY build/libs/${APP_JAR} /app/${APP_JAR}
WORKDIR /app
ENTRYPOINT ["java", "-jar", "upstream-0.0.1-SNAPSHOT.jar"]