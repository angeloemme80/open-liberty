FROM redhat-openjdk18-openshift:1.5
#FROM maven
#FROM openliberty/open-liberty

#COPY --chown=1001:0 src/main/liberty/config/ /config/
#COPY --chown=1001:0 target/*.war /config/apps/
#RUN configure.sh

#RUN yum install maven && chgrp -R 0 /var/log/rhsm && chmod -R g=u /var/log/rhsm

RUN mkdir -p /.m2/repository chgrp -R 0 /.m2/repository && chmod -R g=u /.m2/repository

USER 1001
CMD ["mvn","liberty:run"]
