FROM openjdk:11
ADD target/eureka-server.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","eureka-server.jar","--spring.profiles.active=docker"]