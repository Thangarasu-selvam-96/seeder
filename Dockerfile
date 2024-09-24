# Use an official OpenJDK 17 image as the base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
# Assuming the JAR file is built and located in the target directory
COPY target/your-application-name.jar /app/application.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 8080

# Set the default command to run the JAR file
ENTRYPOINT ["java", "-jar", "application.jar"]
