FROM openjdk:17-ea-11-jdk-slim
ADD ./build/libs/*.jar side-project.jar
ENTRYPOINT ["java", "-jar", "side-project.jar"]