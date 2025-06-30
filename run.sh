#!/bin/bash

# Exit immediately if a command exits with a non-zero status
set -e

# Compile the project and skip tests
mvn clean package -DskipTests

# Run the Spring Boot application
java -jar target/demo-0.0.1-SNAPSHOT.jar