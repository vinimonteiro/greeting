FROM eclipse-temurin:19
RUN mkdir /opt/app
COPY target/greeting-1.0-SNAPSHOT.jar /opt/app
COPY greeting.yml /opt/app
WORKDIR /opt/app
RUN java -version
CMD ["java", "-jar", "/opt/app/greeting-1.0-SNAPSHOT.jar", "server", "/opt/app/greeting.yml"]
EXPOSE 8090-8091