FROM java:8
FROM maven:alpine

WORKDIR /app

COPY . /app

RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
ADD ./target/docker-mysql-spring-0.0.1-SNAPSHOT.jar docker-mysql-spring-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","docker-mysql-spring-0.0.1-SNAPSHOT.jar"]