#🎬 Movie REST API (Spring Boot + PostgreSQL)
This project is a full-stack Movie Management System built with Spring Boot and PostgreSQL. It includes a RESTful API for managing movie data, and a front-end UI that supports search, pagination, sorting, and CRUD operations.

📸 Screenshots
🔍 Movie List (with pagination and sorting)
![image](https://github.com/user-attachments/assets/665a3ea0-fbdf-488d-9841-3cec290b48d3)

Display movies with sorting by columns (like Release Year) and pagination. Each entry has Edit/Delete options.

➕ Add New Movie
(screenshot of add form here)
![image](https://github.com/user-attachments/assets/d5e5fa7e-aaf5-4905-b879-b524739a343d)

Add a new movie with title, genre, description, actors, and release year.

✏️ Update Movie
(screenshot of update form here)
![image](https://github.com/user-attachments/assets/0cd2fd9f-55df-4064-bf32-da7fa919f7d4)

Edit existing movie information.

#🧰 Technologies Used
Backend: Java, Spring Boot (Spring Data JPA, Spring Web)

Database: PostgreSQL

Frontend: HTML, Bootstrap, jQuery, AJAX

API Testing: Postman

🔗 REST API Endpoints
Method	Endpoint	Description
GET	/api/movies	Get all movies (with pagination & sorting)
GET	/api/movies/{id}	Get a movie by ID
POST	/api/movies	Add a new movie
PUT	/api/movies/{id}	Update movie details
DELETE	/api/movies/{id}	Delete a movie

🧪 Postman Testing
You can test the backend API using Postman. Example requests:

GET http://localhost:8080/api/movies

POST http://localhost:8080/api/movies

PUT http://localhost:8080/api/movies/1

DELETE http://localhost:8080/api/movies/1

You can also pass query parameters:
GET /api/movies?page=0&size=10&sort=releaseYear,desc
⚙️ Setup Instructions
Clone the Repository


git clone https://github.com/yourusername/movie-rest-api.git
cd movie-rest-api
Configure PostgreSQL Database

Create a database:

CREATE DATABASE moviesdb;
Update application.properties

properties

spring.datasource.url=jdbc:postgresql://localhost:5432/moviesdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Run the Application

./mvnw spring-boot:run
or if using IntelliJ/IDEA, run the main() method in MovieApiApplication.java.

📁 Project Structure (Spring Boot)
src/
├── main/
│   ├── java/com/example/movieapi/
│   │   ├── controller/
│   │   │   └── MovieController.java
│   │   ├── model/
│   │   │   └── Movie.java
│   │   ├── repository/
│   │   │   └── MovieRepository.java
│   │   ├── service/
│   │   │   └── MovieService.java
│   │   └── MovieApiApplication.java
│   └── resources/
│       ├── application.properties
├── test/
✅ Features
Create, update, delete, and retrieve movie records

Pagination and sorting via Spring Data JPA

Input validation

Connected to PostgreSQL

Frontend integration for managing movies

API tested with Postman



