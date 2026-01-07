# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build and Run Commands

```bash
# Build everything (compiles Java backend + builds Nuxt frontend)
mvn clean package

# Run the application
java -jar target/visuale.jar

# Run tests
mvn test

# Run a single test class
mvn test -Dtest=StatusServiceTest

# Run a single test method
mvn test -Dtest=StatusServiceTest#testMethodName

# Frontend development (requires cd to nuxt-spa directory first)
cd src/main/resources/nuxt-spa
npm run dev      # Start dev server on localhost:3000
npm run lint     # Run ESLint
npm run test     # Run Jest tests
npm run generate # Build static site (done automatically during mvn package)
```

## Architecture Overview

Visuale is a real-time dashboard for monitoring microservice health across environments. It has two main components:

### Backend (Java 11 + Helidon)

**Entry point:** `no.cantara.tools.visuale.Main`

**Core components:**

- **StatusService** (`status/StatusService.java`): Event-driven service that maintains environment state using a
  blocking queue pattern. Processes health updates asynchronously and publishes changes to a cached JSON string. Handles
  throttling (min 1s between updates) and batch processing (every 25 events when backlogged).
- **StatusResource** (`status/StatusResource.java`): REST API endpoints for receiving health data via PUT requests and
  serving environment status via GET.
- **HealthCheckProber** (`healthchecker/HealthCheckProber.java`): Scheduled polling service that probes configured
  health endpoints every 10 seconds.
- **NotificationService** (`notifications/NotificationService.java`): Slack alerting integration for service health
  notifications.

**Domain model:**

- `Environment` contains `Service` objects, which contain `Node` objects
- `Health` represents a single health check response with status, version, IP, and running_since
- `HealthMapper` normalizes various health JSON formats from different services into the standard Health format

**API endpoints:**

- `GET /status` or `/api/status` - Returns full environment JSON
- `PUT /status` or `/api/status` - Update health (requires service_name, service_tag, service_type, name in body)
- `PUT /status/{env}/{service}/{node}` - Update specific node health

### Frontend (Nuxt 2 + Vue)

Located in `src/main/resources/nuxt-spa/`

**Key components:**

- `PollingService.vue` - Fetches status data from backend periodically
- `Service.vue` - Renders a service with its nodes
- `ServiceBattery.vue` - Visual indicator of service health/availability
- `Node.vue` and subcomponents - Display individual node status with traffic light indicators
- `groupedServicesOverTag.vue` / `groupTagOverService.vue` - Alternative grouping views

**UI extensions** (via query params):

- `?ui_extension=groupByTag` - Group services by tag
- `?ui_extension=groupByService` - Group by service
- `&servicetype=true` - Show service type icons

## Configuration

**Environment config:** `./environment_config.json` - Define services and their health endpoints
**Properties override:** `./local_override.properties` - Override server.port (default 8080), enable access tokens,
configure Slack alerts

## Key Patterns

- Services and nodes are identified by name + tag combination (tags are case-insensitive)
- Nodes are matched by name first, then IP address for disambiguation
- Health updates can come via push (PUT to API) or pull (HealthCheckProber polling configured URLs)
- Frontend is built during Maven package phase and served as static content
