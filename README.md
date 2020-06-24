# Expense REST API

## Requirements
To build and run the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [MySQL](https://https://dev.mysql.com/downloads/installer/)

## Method 1
1. Clone this repo into your computer
2. Open project directory in a terminal
3. Run the command 
  - (for Windows users) mvnw spring-boot:run
  - (for MacOS/Linux users) ./mvnw spring-boot:run
4. Application is started on http://localhost:8080
5. If port 8080 is already used by another application in your computer, open the application.properties file and change port with 'server.port=8181'

## Method 2
1. Clone the repository into your computer
2. Open the project directory in a terminal
3. run "mvn package",  a .jar file will be generated in the target directory of the project
4. Navigate to target directory, cd target
5. Run java -jar [name_of_file_file]
6. Application is started on http://localhost:8080
7. If port 8080 is already used by another application in your computer, open the application.properties file and change port with 'server.port=8181'

## Method 3
The application is hosted on https://expenseapi.herokuapp.com

