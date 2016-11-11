  This is **_easy_** demo to show how to create web server using Jetty engine. The build script packages server into an executable jar file.
  
## Build

- mvn install


## Usage

- java -jar target/easyjetty.jar

Connect to http://localhost:8060/hello to see response from HelloServlet handler. Rest of endpoint like http://localhost:8060/testing is handled by DefaultServlet handler.



  
