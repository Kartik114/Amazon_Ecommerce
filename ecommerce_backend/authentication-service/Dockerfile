FROM openjdk:17-slim
COPY target/authentication-service-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 7000