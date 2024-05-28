FROM maven:3.9-eclipse-temurin-21-jammy as builder
WORKDIR /app
COPY mvnw pom.xml ./
COPY ./src ./src
RUN mvn clean install -DskipTests

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/target/*.jar /app/*.jar
ENTRYPOINT ["java", "-jar", "/app/*.jar"]