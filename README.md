# Demo-UrlShortener-API

This is an API for Url shortener service like Bit.ly url. 

Url shortener is service that converts long urls into short aliases to save space when sharing urls in messages, twitter, presentations etc.
When user opens short url, it will be automatically redirected to original (long) url.

# Using 
This project in built on in-memory H2 relational database to persist data for demo purpose.


# Getting started 

```sh
$ git clone https://github.com/wilkom2009/demo-urlshortener-api.git
```
- Open the project in your favorite editor

## Database configuration

+ With H2 in-memory relational database

    This project in built on in-memory H2 relational database to persist data for demo purpose.
    In this case, just go to running instructions

+ With MySQL database

    In production, you can use MySQL database. To do so:

    - Add dependency in pom.xml file

    ```xml
    <dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<scope>runtime</scope>
	</dependency>
    ```
    - Remove H2 dependency in pom.xml file
    - In application.yaml file, add the connection instructions
    ```yaml
    spring:
      datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: #database endpoint
        username: #database user
        password: #databse password
    ```

## Running    
- Build Spring project
- Run __DemoUrlshortenerApiApplication.java__ class
- Open http://localhost:8080/swagger-ui/index.html# to see endpoints. 
    

