FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar office.jar
ENTRYPOINT ["java","-jar","/office.jar"]
EXPOSE 8090