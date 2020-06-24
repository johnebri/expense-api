# Expense REST API
Expense REST API is an api that allows a use to perform CRUD operations on expenses. The user can 
- Add an Expense
- Retrieve all expenses
- Retrieve an expense
- Update an expense
- Delete an expense

## Development tools
- The application was developed with Spring boot 2.3.1
- Test Framework used: Mockito
- Server: Tomcat
- Database used: PostgreSQL (remote elephant sql)
- Hosted on Heroku

## Requirements to build and run expense REST API
To build and run the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Apache Maven 3.6](https://maven.apache.org/download.cgi)

## Method 1 (running with maven mvnw command)
1. Clone the repository
2. Navigate to project directory in a terminal
3. Run the command 
  - (for Windows users using windows command prompt app) mvnw spring-boot:run
  - (for MacOS/Linux users) ./mvnw spring-boot:run
4. Application is started on http://localhost:8080
5. If port 8080 is already used by another application in your computer, open the application.properties file and change port with 'server.port=8181'

## Method 2 (building a jar file with mvn package)
1. Clone the repository
2. Open the project directory in a terminal
3. Run "mvn package", to build a jar file in the target directory of the project
4. Navigate to target directory
5. Run java -jar expenseapi-0.0.1-SNAPSHOT.jar to execute the jar file
6. Application is started on http://localhost:8080
7. If port 8080 is already used by another application in your computer, open the application.properties file and change port with 'server.port=8181'

## Method 3 (running hoted app)
The application is hosted on https://expenseapi.herokuapp.com