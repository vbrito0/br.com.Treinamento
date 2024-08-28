FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/Pessoa-api.jar /app/Pessoa.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "Pessoa.jar"