<a name="readme-top"></a>

# Challenge GAPSI
### Product Api on GCP
## Table of Contents
<details open>
   <ol>
      <li><a href="#prerequisites">Prerequisites</a></li>
      <li><a href="#getting-started">Getting Started</a></li>
      <li><a href="#built-with">Built With</a></li>
      <li><a href="#running-the-tests-and-coverage">Running the Tests and Coverage</a></li>
   </ol>
</details>

## Prerequisites

* Install Java 21
* Install Docker Compose

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

1. Clone the repo
   ```sh
   gh repo clone drupalio/gapsiprueba
   ```
2. Import the project in your IDE
3. Sync maven dependencies
4. Setup dev environment
    ```sh
    docker-compose -f docker-compose.yml up
    ```
5. Teardown dev environment
    ```sh
    docker-compose -f docker-compose.yml down
    ```

## Actuator - Swagger ui
* Actuator - http://localhost:8080/actuator
* swagger-ui - http://localhost:8080/swagger-ui/index.html

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Request
* Register user
    ```postman
    curl --location 'localhost:8080/auth/register' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "username":"test@test.com",
   "password":"test"
   }'
    ```
* Access User with JWT
    ```postman
   curl --location 'localhost:8080/auth/login' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "username":"test@test.com",
   "password":"test"
   }'
    ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>
## Built With

* [Java 21][java-url] - Runtime and programming language.
* [Maven 3.9.6 ][maven-url] - Main build tool management.
* [Docker][docker-url] - Containerize applications for consistency.
* [H2DB][h2db-url] - In memory database dbms writed on java
* [Redis ][redis-url] - Cache Manager tool
* [Spring Boot][spring-boot-url] - Production-grade Spring based Applications that you can "just run".

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Running the Tests and Coverage

* [JUnit 5][junit5-url]


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[java-url]: https://openjdk.org/projects/jdk/17/
[maven-url]: https://maven.apache.org/
[docker-url]: https://www.docker.com/
[h2db-url]: https://www.h2database.com/
[redis-url]: https://redis.io/
[spring-boot-url]: https://spring.io/projects/spring-boot
[junit5-url]: https://junit.org/junit5/
[jacoco-url]: https://www.jacoco.org/jacoco/
