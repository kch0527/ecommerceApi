FROM openjdk:17-ea-11-jdk-slim
ADD ./build/libs/*.jar order-service.jar
ENTRYPOINT ["java", "-jar", "order-service.jar"]