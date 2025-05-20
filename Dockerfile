# Use a Java base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Install Maven to build the project
RUN apt-get update && apt-get install -y maven

# Copy the project files
COPY . .

# Build the project with Maven
RUN mvn clean install

# Copy the generated JAR file (use the correct name)
COPY target/postgres-demo-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
CMD ["java", "-jar", "app.jar"]