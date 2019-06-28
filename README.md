# Douban-Lite

## Coding standards

[Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

## Tech stack

* Java 11
* Spring Boot 2.1.6
* Eureka
* CI
* Feign
* Hystrix
* Zuul

## Idea

* Our project contains three main service.
* One is planed to handle the information of user.
  * give a userId then get the user and the books he has rated
* The second is planned to handle the information of book.
  * give a bookId then get the book information.
  * we use a open-source website bookdb to get real information.
* The last is planned to handle the rating infomation.
  * give a userId then get the user and the books he has rated with their detail information.

## How to use

* First, edit every project's **src/main/resources/application.yml** and change profiles, hostname and defaultZone to the # one if you want to run them in docker, if not, don't modify them.

* Second, clean and install four service and dockerize them by excuting the following command in each project folder.

  ```
  docker build -f Dockerfile -t <service-name> .
  ```

  * service-name should be eureka-server/book-info-service/rating-data-service/book-catalog-service seperately.

* Then in the root folder, which contains docker-compose.yml, excuse the following command.

  ```
  docker-compose up
  ```

  * wait patiently...

* After four docker images have loaded completely, you can access:

  * eureka:<localhost:8761>
  * book-catalog-service:<localhost:8761/api/book-catalog-service/catalog?userid=123>
  * The following two services is supposed to be not accessible to user but we still exposed them just for fun.
  * book-info-service:<localhost:8761/api/book-info-service/book/100>

  * rating-data-service:<localhost:8761/api/rating-data-service/user/456>

* By the way you may notice that our main service runs slow in some area, that's because we used an API from themoviedb which is blocked by some network provider, just use your VPN and every thing will be fine.

