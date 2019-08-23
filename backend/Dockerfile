FROM gradle:jdk10 as builder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle clean build -x test

FROM openjdk:10-jre-slim as finalApp

ENTRYPOINT ["sudo", "mkdir", "/app/"]

WORKDIR app

COPY --from=builder /home/gradle/src/build/libs/Catalog-0.0.1-SNAPSHOT.jar /app

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "/app/Catalog-0.0.1-SNAPSHOT.jar"]