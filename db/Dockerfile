FROM eclipse-temurin:21-jre

WORKDIR /opt/h2

ENV H2_VERSION=2.2.224
ENV H2_TCP_PORT=9092
ENV H2_WEB_PORT=8082

RUN mkdir -p /opt/h2-data

ADD https://repo1.maven.org/maven2/com/h2database/h2/${H2_VERSION}/h2-${H2_VERSION}.jar /opt/h2/h2.jar

EXPOSE 9092
EXPOSE 8082

CMD ["sh", "-c", "java -cp /opt/h2/h2.jar org.h2.tools.Server -tcp -tcpAllowOthers -tcpPort ${H2_TCP_PORT} -web -webAllowOthers -webPort ${H2_WEB_PORT} -ifNotExists -baseDir /opt/h2-data"]