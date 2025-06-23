
# Book Management API

A simple CRUD API built using Java Spring Boot and MySQL.

## Endpoints
- `GET /api/books`
- `GET /api/books/{id}`
- `POST /api/books`
- `PUT /api/books/{id}`
- `DELETE /api/books/{id}`

## How to Run

1. Create a MySQL database named `bookdb`
2. Update DB credentials in `application.properties`
3. Run the app:
```bash
mvn spring-boot:run
```

## Sample JSON

```json
{
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "genre": "Fiction",
  "yearPublished": 1988
}
```
