# Nexus — API Service

Central hub for routing, discovery, and governance of APIs. Built with Spring Boot
(Java 17).

## Features

- Versioned REST endpoints (`/api/v1/...`)
- OpenAPI/Swagger UI at `/swagger-ui.html`
- Health, metrics, and probes via Spring Boot Actuator
- Simple security (permit-all for dev; easy to harden)
- Structured logging with trace IDs (MDC-friendly)

## Quickstart

### Prerequisites

- Java 21
- Maven 3.9+ (or the Maven Wrapper `./mvnw`)

### Run (dev)

```bash
./mvnw spring-boot:run
# or
mvn spring-boot:run
```

### Open

- API ping: <http://localhost:8080/api/v1/ping>
- Swagger UI: <http://localhost:8080/swagger-ui.html>
- Actuator index: <http://localhost:8080/actuator>

## Validate Endpoints

### Ping (GET)

```bash
curl -s http://localhost:8080/api/v1/ping | jq .
```

### Example response\*\*

```json
{
  "status": "UP",
  "service": "Nexus",
  "time": "2025-09-27T21:42:10Z",
  "traceId": "n/a"
}
```

## API Docs (Swagger/OpenAPI)

Open:

- Swagger UI: `/swagger-ui.html`
- OpenAPI JSON: `/v3/api-docs`

## Actuator

Useful endpoints:

- `/actuator/health`
- `/actuator/health/liveness`
- `/actuator/health/readiness`
- `/actuator/metrics`
- `/actuator/info`

## Build

```bash
./mvnw clean package
java -jar target/nexus-*.jar
```

## Tech

- Spring Boot (Web, Actuator)
- springdoc-openapi (Swagger UI)
- Java 21

## Notes

- Version APIs under `/api/v1/...`
- Keep secrets out of the repository; use env vars or Spring profiles.

## PR Checks to Add (Info Only)

- Build & Test (CI): Run unit tests and compile on every PR and non-main push.
- CodeQL Code Scanning: Flag security and vulnerability issues on PRs.
- Dependabot: Update Maven dependencies and GitHub Actions weekly.
- Repository Linting (optional): Lint Markdown, YAML, JSON for repository hygiene.
- Coverage Gate (optional): Enforce minimum test coverage before merge.
- Branch Protection (main):
  - Require pull request before merging
  - Require passing status checks (CI, CodeQL, Lint)
  - Require branches to be up to date
  - Require review from Code Owners
  - Require conversation resolution
  - (Optional) Restrict push access; enforce linear history
- Secret Scanning (public repositories): Enable in "Code security & analysis".
- Auto-merge (optional): Enable for Dependabot PRs after checks pass.

## License

MIT (or your choice)
