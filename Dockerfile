FROM openjdk:8-jdk

WORKDIR /app

COPY target/magha-aplication.jar /app/magha-aplication.jar

EXPOSE 8080

CMD ["java", "-jar", "magha-aplication.jar"]