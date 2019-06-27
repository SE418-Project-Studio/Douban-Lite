# Douban-Lite

## Coding standards

[Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

## Tech stack

* Java 11
* Spring Boot 2.1.4
* Vue-cli 3
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
