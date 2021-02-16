FROM redhat-openjdk18-openshift:1.8
RUN apt-get update && apt-get install -y maven
EXPOSE 9080
CMD mvn liberty:run
