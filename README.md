# API Crud with rabbitMQ

>  API using Spring Boot, RabbitMQ, Docker, Postgres, Flyway, JUnity 5, Swagger

## Required global dependencies
- Docker

## Up & Running

Copy the `.env.dev` file to a new `.env` file:

### Docker
```
docker-compose up
```
Stop docker:

```
docker-compose down
```
Destroy all:

```
docker-compose down -v
```
## Docker Hub
```
docker push wandersondavid/java-springboot_backend:tagname
```

## Docs API
```
http://localhost:8080/api/v1/swagger-ui/index.html
```