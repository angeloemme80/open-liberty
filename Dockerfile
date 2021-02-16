FROM openliberty/open-liberty
#COPY --chown=1001:0 src/main/liberty/config/ /config/
#COPY --chown=1001:0 target/*.war /config/apps/
#RUN configure.sh
RUN yum install maven && chgrp -R 0 /var/log && chmod -R g=u /var/log
USER 1001
CMD ["mvn","liberty:run"]
