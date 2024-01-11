#
# Build stage
#
FROM gradle:jdk17-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

LABEL org.name="JanLken"
#
# Package stage
#
FROM eclipse-temurin:17-jdk-jammy
ENTRYPOINT {"java","-jar","/app.jar"]
