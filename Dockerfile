FROM maven:3.8.3-openjdk-17 as build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app

RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-alpine

COPY --from=build /app/target/*.jar /app/app.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "app.jar"]
