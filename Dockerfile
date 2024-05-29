FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY ./coosmet.jar /app/coosmet.jar

EXPOSE 8080

CMD ["java", "-jar", "/backend-java.jar"]
