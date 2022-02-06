# Tripmap API

API part of Tripmap service

## Quickstart

IntelliJ IDEA configurations can be found in [.idea/runConfigurations](.idea/runConfigurations), for running the API with PostgreSQL or H2 databases. The configuration is done by environment variables, there are no configuration files, since everything is configured from Kotlin code look for files in [Ktor Plugins directory](src/main/kotlin/com/tripmap/plugins/). By default the server runs in HTTP mode (no ssl here) on [0.0.0.0:8080](0.0.0.0:8080).

## Environment Variables

Available configuration environment vars are listed below, together with default values assigned to them in default PostgreSQL run configuration:

- JWT config:
  - JWT_AUDIENCE:      "0.0.0.0:8080/admin"
  - JWT_REALM:         "Access to admin panel"
  - JWT_ISSUER:        "0.0.0.0:8080"
  - JWT_SECRET:        "secret"
- Database connection:
  - DATABASE_DRIVER:   "org.postgresql.Driver"
  - DATABASE_URL:      "jdbc:postgresql://localhost:5432/tripmap"
  - DATABASE_USERNAME: "postgres"
  - DATABASE_PASSWORD: "postpass"
