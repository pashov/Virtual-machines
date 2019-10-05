FROM openjdk:8

COPY target/application-1.0-SNAPSHOT.jar ./application.jar

EXPOSE 8080

EXPOSE 6006

ENTRYPOINT ["java", "-jar", "-Xdebug", "-Xrunjdwp:server=y,transport=dt_socket,address=6006,suspend=n", "-Dspring.datasource.url=jdbc:postgresql://postgres-db:5432/postgres", "application.jar"]