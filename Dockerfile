# Use an official JDK 17 runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/seeder-0.0.1-SNAPSHOT.jar /app/seeder.jar

# Expose the port that the Spring Boot application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "seeder.jar"]
