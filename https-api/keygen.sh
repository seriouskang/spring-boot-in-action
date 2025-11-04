#!/bin/bash

keytool -genkey -alias https-test \
                -keyalg RSA \
                -storetype PKCS12 \
                -keystore keystore.p12 \
                -keysize 2048 \
                -validity 3650 \
		-storepass changeit \
		-dname "CN=localhost, OU=MyRoom, O=MyHome, L=Seoul, ST=Seoul, C=KR"
