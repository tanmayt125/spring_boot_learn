# Use a base image with JDK 17 (or adjust the version based on your project)
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from your local machine into the container
COPY target/demo-0.0.1-SNAPSHOT.jar /app/my-spring-boot-app.jar

# Expose the port that your Spring Boot application runs on (default is 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/my-spring-boot-app.jar"]
