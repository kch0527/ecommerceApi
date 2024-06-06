FROM openjdk:17-ea-11-jdk-slim
ADD ./build/libs/*.jar user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]