# Project
HackOn registration is web application for registration for the Java Hackathon.
User entered data is validated and error message displayed. Entered data is stored into memory and success message is shown with the entered details.

## Getting Started
This repository contains the code for the HackOn registration application. The code can be cloned to local directory.

Dependencies:
org.springframework.boot, 
org.glassfish.jersey.test-framework.providers
org.glassfish.jersey.core 
junit
Jasmine (https://jasmine.github.io)
Jasmine-JQuery.js(https://www.npmjs.com/package/jasmine-jquery)
JQuery.js (https://jquery.com/download/)

Open the project in IDE (Eclipse, Intellij) and resolve the dependencies issues if any. 
Execute the application as Java application by selecting ApplicationBootstrap for main(String[] args) method. Then goto browser and open http://localhost:8080/registration.html. PAT registration form will be displayed

 
## Features
PAT registration form can be used for registering for next Java Meetup. First Name, Last Name, Email Addess, Password, Address, Pincode, City and Country fields are mandatory. Phone number field is optional. 
Validations
* 	First Name & Last Name: Field can contain only alphabets, number and space.
* 	Emails Address: Field should be valid email ID like xxx.xx@xxx.com, xxxxx@xxx.com, xxxx.xxx@xx.co.in
* 	Password: Password should contain atleast 1 uppercase alphabet, 1 lowercase alphabet,1 number and 1 special character. Password should be minimum 8 character in length.
* 	Confirm Password : Entered value should be same as the Password
* 	Phone Number: Should be 10 digits
* 	Address: Field can contain alphabets, numbers, special characters (#,.) and space
* 	Pincode: Should be 5/6 digits
* 	City: Field can contain alphabets, numbers, special characters (.) and space
* 	Country: Should be selected from the list.

After all fields are entered user can click Submit. On successful registration, success message will be displayed with entered value.

## Deployment 
Execute java -jar registration-0.1.0.jar and start the page available under http://localhost:8080/registration.html
Fill the registration form fields and submit. 

## Technology used

The application is build on top of Spring Boot (http://projects.spring.io/spring-boot/) providing a runtime container.
Application uses Apache Velocity which is a Java-based template engine which separates Java code from the web pages,
 making the web site more maintainable over its lifespan. 

Eclipse Jersey is used for developing RESTful Web services. Jersey RESTful Web Services framework which is an open source,
 production quality, framework for developing RESTful Web Services in Java that provides support for JAX-RS APIs.
 
JQuery is used for form validations. Apache Maven is used for building and packaging the application as executable jar. 
Dependencies of Apache Tomcat is added to pom.xml to run the application in an embedded mode.

Jersey Test Framework is used for testing Jersey Jax-RS POST command with Jetty containers. 
Jetty container (org.eclipse.jetty) is another high-performance, light-weight HTTP server that integrates with Jersey and is 
supported by Jersey Test Framework. Jasmine-JQuery is used for unit testing JQuery form validations.
Junit test is used to test java code for saving to hashmap.

## Environment

Operation System: Windows 10

Java Version: Java 8
 
