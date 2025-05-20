FROM openjdk:17-jdk-slim
COPY target/postgres-demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]