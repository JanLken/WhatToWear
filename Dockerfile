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
COPY --from=build /home/gradle/src/build/libs/whattowear-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
