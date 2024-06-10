FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY ./build/libs/*.jar config-service.jar
COPY apiEncryptionKey.jks apiEncryptionKey.jks
ENTRYPOINT ["java", "-jar", "config-service.jar"]