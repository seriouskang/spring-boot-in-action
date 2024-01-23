#!/bin/sh

../gradlew downstream:build upstream:build
docker-compose up --build
