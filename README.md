# Java Microservices Lab

## Task

Develop a microservice application to display Formula 1 statistics: drivers, teams, races and results.


### Stack
- Spring Boot (Web MVC, Jpa)
- Spring Cloud (Eureka, Feign)
- Docker Compose
- Postgres


### Services

- Discovery Service (Eureka)
- Api Gateway Service
- Driver Service
- Team Service
- Race Service


### Api

All communications are done using gateway.
Path pattern: `http://<host>/api/<service-name>/<endpoint>`

Driver Service:
- GET /drivers
-	POST /drivers
-	GET /drivers/{id}

Team Service:
-	GET /teams
-	POST /teams
-	GET /teams/{id}

Race Service:
-	GET /races/
-	POST /race
-	GET /races/{id}
-	GET /races/winner – Get inforamtion about the last race and the winner info
