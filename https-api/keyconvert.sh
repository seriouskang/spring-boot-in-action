#!/bin/bash

# crt -> pfx
openssl pkcs12 -inkey test-domain.com.key \
               -in test-domain.com.crt \
               -certfile rootca.crt \
               -export -out converted.pfx


# pfx -> jks
keytool -importkeystore -srckeystore converted.pfx \
                        -srcstoretype pkcs12 \
                        -destkeystore converted.jks \
                        -deststoretype jks