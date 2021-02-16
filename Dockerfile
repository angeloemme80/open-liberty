FROM openjdk:8-jdk
EXPOSE 9080
CMD ["mvn", "liberty:run"]
