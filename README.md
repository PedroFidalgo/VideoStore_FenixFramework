# VideoStore_FenixFramework

This is a step by step example of adding persistence to a java application using the FenixFramework (https://fenix-framework.github.io/), it uses MySQL for the data access layer.

Requirements:
 - Maven 3.3.9+
 - JDK 1.8+
 - MySQL 5.7+

DB preparation:  
A database named 'videostore' needs to be created before running the test suite in MySQL. The configuration file named fenix-framework.properties should work by default.

To run the test suite:  
In the project root folder 'mvn clean compile test'.

To run App.java:  
In the project root folder 'mvn clean compile exec:java'.
