# Start with OL runtime.
FROM openliberty/open-liberty:kernel-java8-openj9-ubi

ARG VERSION=1.0
ARG REVISION=SNAPSHOT

ENV KEYSTORE_REQUIRED "false" 

LABEL \
  org.opencontainers.image.authors="Angelo Massaro" \
  org.opencontainers.image.vendor="IBM" \
  org.opencontainers.image.url="local" \
  org.opencontainers.image.source="https://github.com/angeloemme80/open-liberty" \
  org.opencontainers.image.version="$VERSION" \
  org.opencontainers.image.revision="$REVISION" \
  vendor="Open Liberty" \
  name="system" \
  version="$VERSION-$REVISION" \
  summary="The system microservice from the Docker Guide" \
  description="This image contains the system microservice running with the Open Liberty runtime."

USER root

COPY --chown=1001:0 src/main/liberty/config/server.xml /config/
COPY --chown=1001:0 /resources/CustomConfigSource.json /opt/ol/wlp/output/defaultServer/resources/
#COPY --chown=1001:0 target/io.openliberty.sample.getting.started.war /config/dropins/
COPY --chown=1001:0 target/io.openliberty.sample.getting.started.war /config/apps/

USER 1001
