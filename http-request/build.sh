#!/bin/bash

../gradlew build
# docker build --tag http-request:0.1 .
docker buildx build --push \
                    --platform linux/arm64/v8,linux/amd64 \
                    --tag scdean/http-request:0.2 .