# Etapa 1: build da aplicação com Gradle e Java 21
FROM gradle:8.14.3-jdk21 AS builder

WORKDIR /build

COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY gradlew ./

RUN chmod +x ./gradlew

COPY src ./src

RUN ./gradlew clean bootJar -x test


# Etapa 2: execução da aplicação
FROM eclipse-temurin:21-jre

WORKDIR /app

RUN apt-get update \
    && apt-get install -y netcat-openbsd \
    && rm -rf /var/lib/apt/lists/*

RUN groupadd -r agrostellar && useradd -r -g agrostellar agrostellar

COPY --from=builder /build/build/libs/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=docker
ENV SERVER_PORT=8080

EXPOSE 8080

USER agrostellar

ENTRYPOINT ["sh", "-c", "echo 'Aguardando H2 em agrostellar-db:9092...'; until nc -z agrostellar-db 9092; do echo 'H2 ainda indisponível, aguardando...'; sleep 2; done; echo 'H2 disponível. Iniciando API...'; java -jar app.jar"]