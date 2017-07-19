# VideoStore_FenixFramework

This is a step by step example of adding persistence to a java application using the FenixFramework (https://fenix-framework.github.io/), it uses MySQL for the data access layer.

Requirements:
 - Maven 3.3.9+
 - JDK 1.8+
 - MySQL 5.7+  
 Or  
 - Docker 17.0+


DB preparation:  
A database named 'videostore' needs to be created before running the test suite in MySQL. The configuration file named fenix-framework.properties should work by default.

To run the test suite:  
In the project root folder 'mvn clean compile test'.

To run App.java:  
In the project root folder 'mvn clean compile exec:java'.


If you have Docker:
1) Create a MySQL container with the expected parameters:  
   'docker run --name db -e MYSQL_USER=root -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=videostore  -d mysql:latest'
2) Build the app image, in the project root folder:  
   'docker build -t videostore_fenixframework .'
3) Run the container and link it with the MySQL container (the Dockerfile runs the automated tests using the 'db' container):  
   'docker run -it --rm --name videostore_fenixframework_mysql --link db:localhost  videostore_fenixframework'  

Alternative (if you have Docker, Maven and JDK but don't want to install MySQL), create a MySQL container with the expected parameters and maps a port for access via host machine:  
In the project root folder, 'docker-compose -f local.dev.yml up'
