FROM gradle:7.2.0-jdk17
WORKDIR "/app"
COPY . .
CMD ["gradle", "run"]
EXPOSE 8888

# FROM maven:3.8.3-openjdk-17
# WORKDIR "/app"
# COPY . .
# RUN mvn clean package
# CMD ["mvn", "exec:java"]
# EXPOSE 8888