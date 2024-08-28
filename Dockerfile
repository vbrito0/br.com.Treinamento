FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/Pessoa-api.jar /app/Pessoa.jar
COPY wait-for-mysql.sh /app/wait-for-mysql.sh
RUN chmod +x /app/wait-for-mysql.sh
RUN apk --no-cache add mysql-client
EXPOSE 8090
ENTRYPOINT ["/app/wait-for-mysql.sh", "database", "victor", "123456", "java", "-jar", "/app/Pessoa.jar"]
