FROM redhat-openjdk18-openshift:1.8
RUN yum update && yum install -y maven
EXPOSE 9080
CMD mvn liberty:run
