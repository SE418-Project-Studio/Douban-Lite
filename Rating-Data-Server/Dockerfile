FROM openjdk:11
ADD target/rating-data-service.jar rating-data-service.jar
EXPOSE 8083
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","rating-data-service.jar","--spring.profiles.active=docker"]