FROM openjdk:11

ARG APP_JAR=http-request-0.0.1-SNAPSHOT.jar
EXPOSE 8080

COPY build/libs/${APP_JAR} /app/${APP_JAR}
WORKDIR /app
ENTRYPOINT ["java", "-jar", "-Djava.net.preferIPv4Stack=true", "http-request-0.0.1-SNAPSHOT.jar"]