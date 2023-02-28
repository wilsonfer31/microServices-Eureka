# microServices-Eureka

Micro-Services Using Eureka Spring : https://www.baeldung.com/spring-cloud-netflix-eureka

******************************************
Limits MicroService : 8080

Spring cloud configuration server: 8888

Currency Exchange microservice : 8000,8001

Currency conversion microservice : 8100

Netflix Eureka naming server : 8761

Api Gateway : 8765

Zipkin Distributed Trancing Server : 9411
*******************************************


Currency-Exchange image: docker.io/wilsonfer31/mmv2-currency-exchange-service:currency-exchange-service

Naming-Server image :  docker.io/wilsonfer31/mmv2-naming-server:naming-server

currency-convertion image: docker.io/wilsonfer31/mmv2-currency-conversion-service:currency-conversion-service

Api-gateway image : docker.io/wilsonfer31/mmv2-api-gateway:api-gateway

open-zipkin - openzipkin/zipkin:2.23

Use Docker Compose:

Docker-compose up to start projet

Get currency-echange by gateway:

http://localhost:8765/currency-echange/from/USD/to/INR

Get currency-conversion by gateway:

http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
