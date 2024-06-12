FROM openjdk:17-ea-11-jdk-slim
ADD ./build/libs/*.jar catalog-service.jar
ENTRYPOINT ["java", "-jar", "catalog-service.jar"]