# Nexus — API Service

Central hub for routing, discovery, and governance of APIs. Built with Spring Boot
(Java 17).

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

- **API ping:** <http://localhost:8080/api/v1/ping>
- **Swagger UI:** <http://localhost:8080/swagger-ui.html>
- **Actuator index:** <http://localhost:8080/actuator>

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
- Keep secrets out of the repository; use env vars or Spring profiles.

---

## PR Checks to Add (Info Only)

- **Build & Test (CI):** Compile and run unit tests on every PR and non-main
  push.
- **CodeQL Code Scanning:** Static analysis to flag security and vulnerability
  issues on PRs.
- **Dependabot:** Weekly PRs to update Maven dependencies and GitHub Actions.
- **Repository Linting (optional):** Lint Markdown/YAML/JSON to maintain
  repository hygiene.
- **Coverage Gate (optional):** Enforce a minimum test coverage threshold
  before merge.
- **Branch Protection (main):**
  - Require pull request before merging
  - Require status checks (CI, CodeQL, Lint) to pass
  - Require branches to be up to date
  - Require review from Code Owners
  - Require conversation resolution
  - (Optional) Restrict who can push; require linear history
- **Secret Scanning (public repositories):** Enable in “Code security & analysis”
  for automatic secret detection.
- **Auto-merge (optional):** Allow auto-merge of Dependabot PRs after checks
  pass.

## License

MIT (or your choice)
