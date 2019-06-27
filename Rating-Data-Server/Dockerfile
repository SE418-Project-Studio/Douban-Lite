FROM openjdk:11
ADD target/rating-data-service.jar rating-data-service.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","rating-data-service.jar"]