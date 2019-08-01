FROM java:8

EXPOSE 8080


ADD /target/shortener-0.0.1-SNAPSHOT.jar shortener-0.0.1-SNAPSHOT.jar




RUN chmod 777 shortener-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java", "-jar", "shortener-0.0.1-SNAPSHOT.jar"]
