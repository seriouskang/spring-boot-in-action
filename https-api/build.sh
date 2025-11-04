#!/bin/bash

../gradlew build
podman build --tag docker.io/scdean/https-api:0.1 .
