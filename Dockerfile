FROM openjdk:17-jdk-slim
ADD target/electronic-devices-service-0.0.1-SNAPSHOT.jar /testservice.jar
ENTRYPOINT ["java", "-jar", "/testservice.jar"]
#FROM openjdk:17
#VOLUME /tmp
#EXPOSE 8080
#COPY electronic-devices-service-0.0.1-SNAPSHOT.jar testservice.jar
#ENTRYPOINT ["java","-jar","/testservice.jar"]
