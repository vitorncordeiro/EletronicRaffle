FROM eclipse-temurin:17
LABEL maintainer="vitornc31@gmail.com"
WORKDIR /app
COPY target/EletronicRaffle-0.0.1-SNAPSHOT.jar /app/eraffle.jar
ENTRYPOINT ["java", "-jar", "eraffle.jar"]
