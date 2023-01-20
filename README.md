# MARIKI 
##Spring Boot, JWT Authentication, Spring Security & Spring Data JPA

### User Registration, User Login and Authorization process.
```
curl --location --request POST 'localhost:8080/api/auth/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
"username" : "username",
"email" : "user@email.com",
"password" : "userPass"
}'
```

```
curl --location --request POST 'localhost:8080/api/auth/signin' \
--header 'Content-Type: application/json' \
--data-raw '{
"username" : "username",
"password" : "userPass"
}'
```

### Dependency
– If you want to use PostgreSQL:
```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>
```
– or MySQL:
```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
```
### Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`
- For PostgreSQL:
```
spring.datasource.url= jdbc:postgresql://localhost:5432/mariki
spring.datasource.username= postgres
spring.datasource.password= 123

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update

# App Properties
mariki.app.jwtSecret= marikiSecretKey
mariki.app.jwtExpirationMs= 86400000
```
- For MySQL
```
spring.datasource.url= jdbc:mysql://localhost:3306/mariki?useSSL=false
spring.datasource.username= root
spring.datasource.password= 123456

spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto= update

# App Properties
mariki.app.jwtSecret= marikiSecretKey
mariki.app.jwtExpirationMs= 86400000
```
### Run Spring Boot application
```
mvn spring-boot:run
```

### Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```





### spring boot spring security jwt-authentication

> [good example](https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication)
