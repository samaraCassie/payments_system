# Use a imagem base do OpenJDK
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Install Maven
RUN apk add --no-cache maven

# Copy the pom.xml file and download dependencies
COPY ../pom.xml ./
RUN mvn dependency:go-offline

# Copy the project files
COPY ../src ./src

# Package the application
RUN mvn package -DskipTests

# Expose the application port
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "target/payments_system-0.0.1-SNAPSHOT.jar"]