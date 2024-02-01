#!/bin/bash

../gradlew build
docker build --tag http-request:0.1 .
