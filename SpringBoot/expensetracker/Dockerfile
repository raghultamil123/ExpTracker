FROM maven:3.8.1-openjdk as build
WORKDIR /app/code
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:8
COPY --from=build /app/code/target/*.jar app.jar
EXPOSE 8080
CMD ["java" ,"-jar","app.jar"]