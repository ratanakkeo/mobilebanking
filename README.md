# Banking Middleware README

## Overview
This project is a banking middleware application built using Java and Spring Boot. It serves as an intermediary between the front-end application and various banking services, providing a set of APIs for handling banking operations such as account management, transactions, user authentication, and more.

## Features
- User Authentication and Authorization
- Account Management (Create, Update, Delete Accounts)
- Transaction Management (Transfer, Deposit, Withdraw)
- Balance Inquiry
- Transaction History
- Error Handling and Logging
- Secure API with JWT Authentication

## Technologies Used
- Java 22
- Spring Boot 2.7.x
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- JWT (JSON Web Token)
- Swagger for API Documentation
- Thymleaf

## Prerequisites
- Java 22 or higher
- Maven 3.6.0 or higher
- MySQL 8.0 or higher
- Postman (for API testing)

## Setup and Installation
1. **Clone the repository**
   ```sh
   git clone https://github.com/yourusername/banking-middleware.git
   cd banking-middleware
   ```

2. **Configure the Database**
   - Create a MySQL database named `banking_db`.
   - Update the database configuration in `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build and Run the Application**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints

### Authentication
- **Login**
  - `POST /api/auth/login`
  - Request Body:
    ```json
    {
      "username": "user",
      "password": "password"
    }
    ```
  - Response:
    ```json
    {
      "token": "jwt-token"
    }
    ```

- **Register**
  - `POST /api/auth/register`
  - Request Body:
    ```json
    {
      "username": "user",
      "password": "password",
      "email": "user@example.com"
    }
    ```

### Accounts
- **Create Account**
  - `POST /api/accounts`
  - Request Body:
    ```json
    {
      "accountType": "SAVINGS",
      "initialDeposit": 1000.0
    }
    ```
  - Response:
    ```json
    {
      "accountId": "123456789",
      "accountType": "SAVINGS",
      "balance": 1000.0
    }
    ```

- **Get Account Details**
  - `GET /api/accounts/{accountId}`
  - Response:
    ```json
    {
      "accountId": "123456789",
      "accountType": "SAVINGS",
      "balance": 1000.0
    }
    ```

- **Delete Account**
  - `DELETE /api/accounts/{accountId}`
  - Response:
    ```json
    {
      "message": "Account deleted successfully"
    }
    ```

### Transactions
- **Deposit**
  - `POST /api/transactions/deposit`
  - Request Body:
    ```json
    {
      "accountId": "123456789",
      "amount": 500.0
    }
    ```
  - Response:
    ```json
    {
      "transactionId": "txn123",
      "accountId": "123456789",
      "amount": 500.0,
      "type": "DEPOSIT",
      "date": "2024-05-19T12:34:56"
    }
    ```

- **Withdraw**
  - `POST /api/transactions/withdraw`
  - Request Body:
    ```json
    {
      "accountId": "123456789",
      "amount": 200.0
    }
    ```
  - Response:
    ```json
    {
      "transactionId": "txn124",
      "accountId": "123456789",
      "amount": 200.0,
      "type": "WITHDRAW",
      "date": "2024-05-19T12:35:56"
    }
    ```

- **Transfer**
  - `POST /api/transactions/transfer`
  - Request Body:
    ```json
    {
      "fromAccountId": "123456789",
      "toAccountId": "987654321",
      "amount": 300.0
    }
    ```
  - Response:
    ```json
    {
      "transactionId": "txn125",
      "fromAccountId": "123456789",
      "toAccountId": "987654321",
      "amount": 300.0,
      "type": "TRANSFER",
      "date": "2024-05-19T12:36:56"
    }
    ```

- **Get Transaction History**
  - `GET /api/transactions/{accountId}`
  - Response:
    ```json
    [
      {
        "transactionId": "txn123",
        "accountId": "123456789",
        "amount": 500.0,
        "type": "DEPOSIT",
        "date": "2024-05-19T12:34:56"
      },
      {
        "transactionId": "txn124",
        "accountId": "123456789",
        "amount": 200.0,
        "type": "WITHDRAW",
        "date": "2024-05-19T12:35:56"
      }
    ]
    ```

## Error Handling
The API uses standard HTTP status codes to indicate the success or failure of an API request. The response body contains details about the error in case of failure.

- **400 Bad Request**: Invalid request parameters or data.
- **401 Unauthorized**: Authentication failure.
- **403 Forbidden**: Authorization failure.
- **404 Not Found**: Resource not found.
- **500 Internal Server Error**: Server error.

## Security
The application uses JWT for securing the APIs. Each request must include a valid JWT token in the `Authorization` header.

Example:
```http
Authorization: Bearer your-jwt-token
```

## Logging
The application uses SLF4J with Logback for logging. Log files are stored in the `logs` directory.

## API Documentation
Swagger is used for API documentation. Once the application is running, you can access the API documentation at `http://localhost:8080/swagger-ui.html`.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

For any questions or support, please contact keoratanak.official@gmial.com
