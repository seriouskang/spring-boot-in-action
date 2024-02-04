FROM ubuntu:24.04

RUN apt-get -y update && apt-get -y upgrade
RUN apt-get install -y openjdk-11-jdk \
                       net-tools \
                       tcpdump \
                       curl

ARG APP_JAR=http-request-0.0.1-SNAPSHOT.jar
EXPOSE 8080

COPY build/libs/${APP_JAR} /app/${APP_JAR}
WORKDIR /app
ENTRYPOINT ["java", "-jar", "-Djava.net.preferIPv4Stack=true", "http-request-0.0.1-SNAPSHOT.jar"]
