FROM hirokimatsumoto/alpine-openjdk-11

WORKDIR /

COPY target/JacksonJsonViewSpringRest-0.0.1-SNAPSHOT.jar JacksonJsonViewSpringRest-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "JacksonJsonViewSpringRest-0.0.1-SNAPSHOT.jar"]