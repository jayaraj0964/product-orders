FROM openjdk:17
WORKDIR /app

# Copy only the already-built JAR
COPY target/mssql-demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
