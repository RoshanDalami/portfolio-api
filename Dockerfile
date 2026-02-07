FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /workspace

# copy only what we need first to leverage Docker layer cache
COPY pom.xml .
RUN mvn -B -q dependency:go-offline

COPY src ./src

# build the application (skip tests to speed up CI builds in Coolify)
RUN mvn -B -DskipTests package

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# copy the built jar from the builder stage
COPY --from=builder /workspace/target/portfolio-api.jar /app/portfolio-api.jar

# allow overriding JVM options and server port
ENV JAVA_OPTS=""
ENV SERVER_PORT=8020

EXPOSE 8020

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/portfolio-api.jar"]