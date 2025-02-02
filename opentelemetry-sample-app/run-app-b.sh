#!/bin/bash

found_cont=$(podman ps --noheading --filter name=app-b --format "{{.Names}}")
if [ "${found_cont}" ]
then
  echo "stop an existing container: ${found_cont}"
  podman stop ${found_cont}
fi

podman run --rm -d --name app-b \
           -p 18080:8080 \
           -e TARGET_ONE_HOST=192.168.64.129:8080 \
           -e TARGET_TWO_HOST=192.168.64.129:28080 \
           -e MANAGEMENT_METRICS_TAGS_APPLICATION=app-b \
           -e OTEL_METRICS_EXPORTER=none \
           -e OTEL_EXPORTER_OTLP_TRACES_ENDPOINT=http://192.168.64.128:4318/v1/traces \
           -e OTEL_EXPORTER_OTLP_TRACES_PROTOCOL=http/protobuf \
           -e OTEL_EXPORTER_OTLP_LOGS_ENDPOINT=http://192.168.64.128:4318/v1/logs \
           -e OTEL_EXPORTER_OTLP_LOGS_PROTOCOL=http/protobuf \
           -e OTEL_LOGS_EXPORTER=otlp \
           -e OTEL_RESOURCE_ATTRIBUTES=service.name=app-b \
           localhost/opentelemetry-sample-app:latest