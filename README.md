# Ticket System Management

Multi-Module Project with [Maven](https://maven.apache.org/guides/mini/guide-multiple-modules.html) to reserve a seat for an event. The Core module communicates with the H2 database using JDBC, and
also it contains the schema.sql and data.sql which are automatically called in starts.
In the Api module there are three end points:
* /getEvents -> return all Event [GET]
* /getEvent/id -> return a specific event with details [GET]
* /pay [POST] requires: eventId, seatId, cardId
<br>
In the headers we get a Base64 encoded token for validate the user.
<br>
For security we are using basic authentication with [Spring Security](https://spring.io/projects/spring-security)
The Ticket module has the same endpoints like Api module, just before these we use /ticket. The functionality is almost 
the same, but we set a key-value pair in headers to every response, the value is the API-KEY, whose Hash code is stored in 
[Partner Module](https://github.com/tamasgyenese/partner_module).

## Built With
* [Spring Boot 2](https://spring.io/projects/spring-boot)

## Database

* [H2 Memory DB](https://www.h2database.com/html/main.html)

Structure of the database

![Alt text](dbs.jpg?raw=true)


## Authors
* Tamas Gyenese
