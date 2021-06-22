FROM maven:3.5-jdk-11

COPY ./ ./

RUN mvn package -q

ENTRYPOINT ["java", "-jar", "./target/empik-task-0.0.1-SNAPSHOT.jar"]