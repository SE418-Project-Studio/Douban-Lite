FROM openjdk:11
ADD target/book-catalog-service.jar book-catalog-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-jar","book-catalog-service.jar","--spring.profiles.active=docker"]