FROM openjdk:17-ea-11-jdk-slim
ADD ./build/libs/*.jar apigateway.jar
ENTRYPOINT ["java", "-jar", "apigateway.jar"]