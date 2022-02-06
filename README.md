# Tripmap

Self-hosted map of visited places (with a very fancy stack underneath)

## Features

- [ ] Sharing custom map-view with pins in locations marked by user. Acces to the map should be authorized with some short of short-lived token.
- [ ] Aditional tools to filter out locations and differentiate between trips on map-view
- [ ] REST API to manage and read trip/location data
- [ ] CRUD admin panel for editing list of visited locations and trips

## Fancy Stack

### API

- Written fully in Kotlin
- Ktor as a web framework, with Netty web server
- JWT auth system with Auth0 JWT solution for Ktor
- Exposed for database support, with PostgreSQL database
- Kotlinx.serialization for JSON handling

### Map View

- Flutter for Web (most probably, because Jetpack Compose for Web doesn't yet support any map frameworks)

### Admin Panel

- Jetpack Compose UI
- Written with Kotlin, compiled to JS
