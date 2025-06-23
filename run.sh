#!/usr/bin/env bash
# ==========================================================
# run.sh - Build and run the Java Spring Boot application

set -e  # Exit immediately if any command fails
set -o pipefail  # Treat any error in a pipeline as a fail
set -u  # Treat unset variables as errors

echo "🚀 Building the project..."
mvn clean install -DskipTests

echo "✅ Build complete. Starting the app..."
mvn spring-boot:run
