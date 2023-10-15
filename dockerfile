FROM openjdk
WORKDIR /Backend
COPY . .
ENTRYPOINT ["java","-jar","/Backend/target/job-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 9000