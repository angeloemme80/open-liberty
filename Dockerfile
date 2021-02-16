FROM redhat-openjdk18-openshift:1.8
EXPOSE 9080
CMD mvn liberty:run
