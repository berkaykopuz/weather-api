# weather-api
Project is not mine actually developed for learning professional production struct. Thanks to @FolksDev.

Used prometheus to filtering actuator metrics, grafana for easily accessing stats from prometheus.
OpenAPI documentation is available.
App service is replicated as docker containers.
There is rate limit access. Grateful for Resilience4j.

# How to use
type "docker-compose up -d" in project terminal for initializing docker container project. 

# deficiencies
Unit test is required for production-ready
