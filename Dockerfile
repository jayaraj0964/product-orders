# Use a lightweight Java base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Install Maven to build the project
RUN apt-get update && apt-get install -y maven

# Copy the project files
COPY . .

# Build the project with Maven
RUN mvn clean package

# Copy the generated JAR file dynamically (ensuring correct file name)
COPY target/*.jar app.jar

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
