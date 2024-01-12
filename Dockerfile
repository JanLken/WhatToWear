#
# Build stage
#
FROM gradle:jdk17 AS build
COPY . .
RUN gradle build --no-daemon

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
