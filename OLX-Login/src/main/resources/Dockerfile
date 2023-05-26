#This is the docker file
FROM openjdk:8
ADD target/olx-login.jar olx-login.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "olx-login"]