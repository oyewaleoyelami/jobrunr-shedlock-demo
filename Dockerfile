FROM openjdk:17-slim
VOLUME /app
ADD target/demo-service-0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]