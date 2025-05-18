FROM openjdk:17
WORKDIR /app

# Build the Spring Boot app inside the Docker container
COPY . .
RUN mvn clean package

# Copy the generated JAR file
COPY target/mssql-demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
