# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.9-SNAPSHOT/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.9-SNAPSHOT/gradle-plugin/reference/html/#build-image)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Steps to run setup local environment

1. Run `docker pull wurstmeister/kafka` to retrieve a kafka container
2. Run `docker run -d --name zookeeper -p 2181:2181 wurstmeister/zookeeper` to retrieve zookeper container
3. Run `docker run -d --name kafka -p 9092:9092 --link zookeeper:zookeeper -e KAFKA_ADVERTISED_HOST_NAME=localhost -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 wurstmeister/kafka` to retrieve and connect kafka container to zookeper container
4. Also get a mysql docker image and run a container
5. Replace `spring.datasource.url=${DATASOURCE_URL}
   spring.datasource.username=${MYSQL_ROOT_USER}
   spring.datasource.password=${MYSQL_ROOT_PASSWORD}` with your mysql credentials