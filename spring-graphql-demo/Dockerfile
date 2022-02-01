FROM gradle:7.1.1 as builder

COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src ./src

# Build a release artifact.
RUN gradle clean build --no-daemon

# actual container
FROM openjdk:8-jdk-alpine
ENV JAR_FILE="spring-demo-1.0.jar"

COPY --from=builder /home/gradle/build/libs/$JAR_FILE app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/app.jar"]