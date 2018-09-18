FROM java:8
COPY hello/target/hello-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "hello-0.0.1-SNAPSHOT.jar"]
EXPOSE 8181
