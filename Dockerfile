FROM gradle:jdk17 as builder

WORKDIR /app

COPY . .

RUN gradle --no-daemon clean bootJar

FROM eclipse-temurin:17-jre-alpine as runner
ARG JARFILE=*.jar
COPY --from=builder /app/build/libs/${JARFILE} application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]