FROM openjdk:11
LABEL maintainer="MOZO TECH"
COPY ./target/*.jar /tmp/app.jar
WORKDIR /tmp/
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
