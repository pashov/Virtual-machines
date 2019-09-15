FROM openjdk:8

COPY target/application-1.0-SNAPSHOT.jar ./application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Dspring.datasource.url=jdbc:postgresql://postgres-db:5432/postgres", "application.jar"]