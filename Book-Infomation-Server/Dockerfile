FROM openjdk:11
ADD target/book-info-service.jar book-info-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","book-info-service.jar","--spring.profiles.active=docker"]