# Online Advertising Service - Listing Management REST Service
This project is a REST service for managing listings for an online advertising service.
It provides endpoints to perform following operations on listings :
* Create a listing
* Update a listing
* Get listings of a dealer with a given state
* Publish a listing
* Unpublish a listing

## Technologies
* [Java](https://www.java.com/fr/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Gradle](https://gradle.org/)
* [PostgreSql](https://www.postgresql.org/)
* [JOOQ](https://www.jooq.org/)

## Getting Started

Follow these instructions to get the project up and running on your local machine.

### Prerequisites

* Java JDK 11 
* Gradle 7.6 or higher
* PostgreSQL Database installed and running

### Database Setup
 
1. Create a new database using pgAdmin gui or you can run the following SQL command in psql:
```bash 
CREATE DATABASE "listing-manager"
   WITH
   OWNER = postgres
   ENCODING = 'UTF8'
   LC_COLLATE = 'fr_FR.UTF-8'
   LC_CTYPE = 'fr_FR.UTF-8'
   TABLESPACE = pg_default
   CONNECTION LIMIT = -1
   IS_TEMPLATE = False; 
```
2. Create the necessary tables in the database following SQL command below :
```bash
CREATE TABLE IF NOT EXISTS public.dealer(
        id serial NOT NULL,
        name character varying(158) NOT NULL,
        CONSTRAINT dealer_pk PRIMARY KEY (id)
        );
		
		
CREATE TABLE IF NOT EXISTS public.tier_limit(
        dealer_id integer NOT NULL,
	    listing_limit integer NOT NULL,
        created_at timestamp(6) without time zone NOT NULL DEFAULT now(),
    CONSTRAINT tier_limit_pk PRIMARY KEY (dealer_id),
	CONSTRAINT tier_limit_fk FOREIGN KEY (dealer_id)
        REFERENCES dealer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        );


CREATE TABLE IF NOT EXISTS public.listing(
	
        id serial NOT NULL,
        dealer_id integer NOT NULL,
	    vehicule character varying(255) NOT NULL,
        price bigint NOT NULL,
        created_at timestamp(6) without time zone NOT NULL DEFAULT now(),
        state character varying(158) NOT NULL,
        CONSTRAINT listing_pk PRIMARY KEY (id),
	CONSTRAINT listing_fk FOREIGN KEY (dealer_id)
        REFERENCES dealer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        );
```
3. Update the database configuration in the `application.properties` file located in the `src/main/resources` directory. Replace the placeholders with your database credentials:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5433/listing-manager
spring.datasource.username=postgres
spring.datasource.password=postgres
```
4. Update the database configuration in `build.gradle` for JOOQ sources generations:
```bash
        .withDriver("org.postgresql.Driver")
        .withUrl("jdbc:postgresql://localhost:5433/listing-manager")
        .withUser("postgres")
        .withPassword("postgres"))
```
# Installation

1. Clone the repository :
```bash
https://github.com/Mr-abdoulraouf/listing-manager.git
```
2. Navigate to the project directory and build the project using Gradle:
```bash 
cd listing-manager
```
```bash 
gradle compileJava
```
3. Generate jOOQ sources from the main jOOQ configuration in `build.gradle`
```bash
gradle generate
```
JOOQ sources code will be generated in `src/main/java/com/agency36/listing/model`
4. Run the application:
```bash
gradle bootRun
```
The REST service will be accessible at http://localhost:8080/api/.
5. The project includes unit tests to ensure the functionality of the REST service. You can run the tests by using the command below :
```bash
gradle test
```

6. Build the application for production.
  ```bash
gradle build
```
The build jar will be located in `build/libs/`


## Exception Handling

The REST service includes basic error handling. If an unexpected exception occurs, the service will return NOT_FOUND HTTP response with an error message.


##  Rest APIs Endpoints

The important APIs endpoints are as follows :

    GET /api/listing/{dealerId}/{state} : Retrieves listings by dealer ID and state (draft or published).
    
    POST /api/listing/save : Creates a new listing.
    
    PUT /api/listing/update/{listingId} : Updates a listing by ID.
    
    PUT /api/listing/publish/{listingId} : Publishes a listing by ID.
    
    PUT /api/listing/unpublish/{listingId}: Unpublishes a listing by ID.

