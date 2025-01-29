#!/bin/bash

podman run --rm -d --name app-a \
           -p 8080:8080 \
           -e TARGET_ONE_HOST=localhost:18080 \
           -e TARGET_TWO_HOST=localhost:28080 \
           -e MANAGEMENT_METRICS_TAGS_APPLICATION=app-a \
           -e OTEL_METRICS_EXPORTER=none \
           -e OTEL_LOGS_EXPORTER=otlp \
           -e OTEL_EXPORTER_OTLP_ENDPOINT=http://192.168.64.128:4317 \
           -e OTEL_EXPORTER_OTLP_LOGS_ENDPOINT=http://192.168.64.128:4318/v1/logs \
           -e OTEL_EXPORTER_OTLP_LOGS_PROTOCOL=http/protobuf \
           -e OTEL_RESOURCE_ATTRIBUTES=service.name=app-a,compose_service=app-a \
           localhost/opentelemetry-sample-app:latest