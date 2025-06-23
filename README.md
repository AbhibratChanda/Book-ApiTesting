# Book API 📚

This is a Spring Boot API for managing a collection of books. It supports CRUD operations and includes both unit and integration tests.

## 🔌 API Overview

The API exposes the following endpoints:

| Method | Endpoint           | Description               |
|--------|--------------------|---------------------------|
| GET    | `/api/books`       | Get all books             |
| GET    | `/api/books/{id}`  | Get book by ID            |
| POST   | `/api/books`       | Add a new book            |
| PUT    | `/api/books/{id}`  | Update an existing book   |
| DELETE | `/api/books/{id}`  | Delete a book             |

---

## 🛠 Tech Stack

- **Java 20**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL** (for persistence)
- **H2** (for testing)
- **JUnit 5** (for unit & integration testing)
- **Mockito** (for mocking in unit tests)
- **MockMvc** (for controller tests)

---

## 🚀 How to Run

### 🧱 Prerequisites:
- JDK 20
- Maven
- MySQL running locally on port 3306 with a database named `bookdb`

### 🏃 Run the application:
```bash
mvn spring-boot:run

✅ In Eclipse:
Open the test class in the editor.
Right-click anywhere inside the file.
Select Run As → JUnit Test.

📸 Test Coverage
![image alt](https://github.com/AbhibratChanda/Book-ApiTesting/blob/bba50f3ac6c6a668a743ea24943bf7b75f699ef6/Screenshot%202025-06-24%20042527.png?raw=true)
