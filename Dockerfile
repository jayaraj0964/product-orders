# Stage 1: Build the application with Maven
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app

# Copy all project files
COPY . .

# Build the application
RUN mvn clean package

# Stage 2: Run the built application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the generated JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the default port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
