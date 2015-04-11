# shop
Sample application built using <b>Spring Boot</b> and <b>Mongodb</b>.  

This application simulates a shop where one can buy things. It provides REST interfaces for adding, updating, fetching and deleting Customers, Products and Orders.  


Each Order must have a single Customer, and one or more Products. However, Customers and Products can exist standalone in the system, without being linked to any Order.  


The application uses <b>MongoRepsitory</b> to connect to mongodb, and uses the default configurations to do so (using the test database), i.e. to use this application, <b>mongodb must be present and running on a machine, and must have a database named test</b>.  

The various dependencies like Junit, Spring dependencies, Mockito etc. are automatically included by including the Spring Boot dependencies (present in the pom.xml file).  


It can be <b>run</b> by running the following commands in order :  
<b>1) mvn clean install</b>  
<b>2) mvn package && java -jar target/shop-1.0-SNAPSHOT.jar</b>  

The (1) command builds the application, while the (2) command packages and runs the created jar in a standalone (and embedded) instance of Apache Tomcat.  

Once the two commands are run, the REST services can be accessed by hitting the URLs.  

Eg.  

<b>http://<server-name>:<port>/customers (GET request)</b>  
http://localhost:8080/customers (GET request)  
