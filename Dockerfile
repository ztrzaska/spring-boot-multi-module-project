FROM openjdk:11-jre

COPY target/spring-batch-file-handler-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "spring-batch-file-handler-0.0.1-SNAPSHOT.jar"]