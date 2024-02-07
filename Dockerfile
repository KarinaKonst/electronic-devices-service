FROM openjdk:17-jdk-slim
ADD target/electronic-devices-service-0.0.1-SNAPSHOT.jar /testservice.jar
ENTRYPOINT ["java", "-jar", "/testservice.jar"]
