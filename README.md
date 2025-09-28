# Nexus — API Service

Central hub for routing, discovery, and governance of APIs. Built with Spring Boot (Java 17).

## Features
- Versioned REST endpoints (`/api/v1/...`)
- OpenAPI/Swagger UI at `/swagger-ui.html`
- Health, metrics, and probes via Spring Boot Actuator
- Simple security (permit-all for dev; easy to harden)
- Structured logging with trace IDs (MDC-friendly)

---

## Quickstart

### Prerequisites
- Java 21
- Maven 3.9+ (or the Maven Wrapper `./mvnw`)

### Run (dev)
    ./mvnw spring-boot:run
    # or
    mvn spring-boot:run

### Open
- **API ping:** http://localhost:8080/api/v1/ping
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **Actuator index:** http://localhost:8080/actuator

---

## Validate Endpoints

### Ping (GET)
    curl -s http://localhost:8080/api/v1/ping | jq .

**Example response**
`{
"status": "UP",
"service": "Nexus",
"time": "2025-09-27T21:42:10Z",
"traceId": "n/a"
}`

## API Docs (Swagger/OpenAPI)

Open:
- **Swagger UI** → `/swagger-ui.html`
- **OpenAPI JSON** → `/v3/api-docs`

---

## Actuator

Useful endpoints:
- `/actuator/health`
- `/actuator/health/liveness`
- `/actuator/health/readiness`
- `/actuator/metrics`
- `/actuator/info`

---
## Build
    ./mvnw clean package
    java -jar target/nexus-*.jar

---

## Tech
- Spring Boot (Web, Actuator)
- springdoc-openapi (Swagger UI)
- Java 21

---

## Notes
- Version APIs under `/api/v1/...`
- Keep secrets out of the repo; use env vars or Spring profiles.

---

## License
MIT (or your choice)
