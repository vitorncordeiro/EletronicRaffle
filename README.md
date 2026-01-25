# Eletronic Raffle API

Eletronic Raffle is a RESTful API built with Java and Spring Boot that provides a complete system for managing electronic raffles.
It allows creating raffles, registering participants, and performing random draws to select winners in a simple and scalable way.

## Features

- Create raffles  
- List all raffles  
- Get raffle details  
- Register participants  
- Perform raffle draws  
- RESTful JSON API  

## Technologies

- Java 17+
- Spring Boot 3+
- Maven
- JWT

## API Endpoints

| Method | Endpoint                | Description                  |
|--------|-------------------------|------------------------------|
| GET    | `/raffles`              | List all raffles             |
| GET    | `/raffles/{id}`         | Get raffle by ID             |
| POST   | `/raffles`              | Create a new raffle          |
| POST   | `/raffles/{id}/entries` | Register a participant       |
| POST   | `/raffles/{id}/draw`    | Draw a winner for the raffle |

## Example Requests

### Create a raffle

POST `/raffles`

```json
{
  "title": "Christmas Raffle",
  "description": "Special holiday giveaway",
  "drawDate": "2025-12-25T18:00:00"
}
```

### Register a participant

POST `/raffles/{id}/entries`

```json
{
  "name": "John Doe",
  "email": "john@example.com"
}
```

### Draw a winner

POST `/raffles/{id}/draw`

```json
{
  "raffleId": 1,
  "winner": {
    "name": "John Doe",
    "email": "john@example.com"
  }
}
```

## Running Locally

### Requirements

- Java 17 or higher  
- Maven  
- Git  

### Steps

Clone the repository:

```bash
git clone https://github.com/vitorncordeiro/EletronicRaffle.git
```

Enter the project folder:

```bash
cd EletronicRaffle
```

Build and run:

```bash
mvn clean install
mvn spring-boot:run
```

The API will be available at:

```
http://localhost:8080
```

## Best Practices

- Use DTOs for request and response objects  
- Validate inputs using Bean Validation  
- Provide API documentation with Swagger/OpenAPI  
- Implement global exception handling  
- Write unit and integration tests  

## Contributing

1. Fork the repository  
2. Create a feature branch  
3. Commit your changes  
4. Push to your branch  
5. Open a Pull Request  

## License

This project is available under the MIT License or as specified in the repository.
