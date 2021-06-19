FROM maven:3.8.1-openjdk as build
WORKDIR /app/code
ADD pom.xml /app/code
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]
COPY . .
RUN ["mvn", "package","-DskipTests"]

FROM openjdk:8
COPY --from=build /app/code/target/*.jar app.jar
EXPOSE 8080
CMD ["java" ,"-jar","app.jar"]