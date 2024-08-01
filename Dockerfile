# Use openjdk eclipse base image
FROM eclipse-temurin:22-jdk-alpine
VOLUME tmp
# Copy the packaged Spring Boot application JAR file into the container
COPY target/spring-3-keycloak-1.0-SNAPSHOT.jar app.jar
# Command to run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]
# Use port 9999
EXPOSE 8080