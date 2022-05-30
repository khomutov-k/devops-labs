# Simple Java application

This project shows application written solely using Vaadin Framework with Spring Boot.

The basic functionality are the same as for Python app task. It shows current host time and time for Russia/Moscow locale.

## 1.Framework choice justification 

### Spring 

Spring is one of the most popular frameworks used for backend development in Java. According to HotFrameworks,
which has ranked various popular Java frameworks by getting an overall score from GitHub and StackOverflow.

In 2020, the [rating](https://hotframeworks.com/languages/java) of top Java frameworks includes Spring with an overall score of 90.

Main advantages of this framework are following:
* Dependency injection support
* Vast amount of modules and integration with various technologies (SQL/NoSQL databases, JPA, 
messaging, Vault, etc)
* Spring Boot project helps to develop ready for production application seamlessly and fast due 
to numerous Autoconfiguration beans
* Spring Cloud helps to stick to best practice related to deployment and configuration in a cloud 

### Vaadin

Vaadin is a web app development platform for Java.
Vaadin Flow is an open-source framework for building web apps in Java. One can build app from UI components without ever having to touch HTML or JavaScript.

### Why to use it in Lab project

Spring Framework is highly used in Enterprise development, also it is mature and one of key players in the Java world. 

## 2. Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw spring-boot:run` (Windows), or `./mvnw spring-boot:run` (Mac & Linux), then open
http://localhost:8080 in the browser.

You can also import the project to the IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different 
IDEs](https://vaadin.com/docs/latest/flow/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

## 3. Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/devops-lab-1.0-SNAPSHOT.jar`

## 4. Project structure

- `views` package in `src/main/java` contains the server-side Java views of the application.
- `themes` folder in `frontend/` contains the custom CSS styles.

## 5. Useful links

- Read the documentation at [vaadin.com/docs](https://vaadin.com/docs).
