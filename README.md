# planner
Spring Boot backend for planning meetings.

- [x] Commands for setup and running the microservice

- Do a gradle build
`gradlew clean build`

- Run junits
`gradlew test`

- Run the application
`java -jar build\libs\planner-0.0.1-SNAPSHOT.jar`

- [x] Link to Postman Collection - https://www.postman.com/collections/5420fb26819a5ba8e9f7

- Docker commands for setup
`docker build -f Dockerfile -t image-planner .` -- building the Dockerfile and generating an image
`docker run -p 8993:8994 image-planner` -- run the docker image on port number 8993 inside container, and port number 8994 on host machine

- Docker compose commands for setup
`docker-compose up` -- run up the docker compose images
`docker-compose down` -- run down the docker compose images