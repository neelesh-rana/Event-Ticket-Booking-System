# 🎫 Event Ticket Booking System

A full-stack **Event Ticket Booking System** built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **MySQL**, and a simple **HTML, CSS & JavaScript** frontend.

The application allows users to securely register, log in, manage events, and book tickets while demonstrating industry-standard backend development practices such as DTO mapping, validation, exception handling, and REST API design.

---

## 🚀 Features

### 🔐 Authentication & Authorization
- User Registration
- User Login
- JWT Authentication
- BCrypt Password Encryption
- Role-Based Access (USER / ADMIN)
- Spring Security Integration

### 🎉 Event Management
- Create Event
- View All Events
- View Event by ID
- Update Event
- Delete Event

### 🎟 Ticket Booking
- Book Tickets
- View All Bookings
- View Booking by ID
- Cancel Booking

### ⚙ Backend Features
- RESTful APIs
- DTO Pattern
- ModelMapper
- Global Exception Handling
- Custom Exceptions
- Bean Validation
- ResponseEntity
- Swagger (OpenAPI)

### 💻 Frontend
- User Registration
- User Login
- Event Dashboard
- Event Management
- Ticket Booking

---

# 🛠 Tech Stack

### Backend
- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Hibernate
- JWT Authentication
- ModelMapper
- Lombok
- Maven

### Database
- MySQL

### Frontend
- HTML5
- CSS3
- JavaScript

### API Testing
- Swagger UI
- Postman

---

# 🏗 Project Architecture

```
Frontend (HTML, CSS, JavaScript)
            │
            ▼
     Spring Boot REST APIs
            │
            ▼
 Spring Security + JWT
            │
            ▼
        MySQL Database
```

---

# 📂 Project Structure

```
src
│
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── exception
├── config
├── enums
│
└── resources
    ├── static
    ├── templates
    └── application.properties
```

---

# 🔑 Authentication

The application uses **JWT Authentication**.

### Register

```
POST /api/auth/register
```

### Login

```
POST /api/auth/login
```

After a successful login, the API returns a JWT token.

Use the token in every protected request:

```
Authorization: Bearer YOUR_JWT_TOKEN
```

---

# 📌 REST APIs

## Authentication

| Method | Endpoint |
|---------|----------|
| POST | /api/auth/register |
| POST | /api/auth/login |

## Event APIs

| Method | Endpoint |
|---------|----------|
| POST | /api/events |
| GET | /api/events |
| GET | /api/events/{id} |
| PUT | /api/events/{id} |
| DELETE | /api/events/{id} |

## Booking APIs

| Method | Endpoint |
|---------|----------|
| POST | /api/bookings |
| GET | /api/bookings |
| GET | /api/bookings/{id} |
| DELETE | /api/bookings/{id} |

---

# 📖 API Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

---

# ⚙️ Getting Started

## Clone the Repository

```bash
git clone https://github.com/neelesh-rana/Event-Ticket-Booking-System.git
```

## Configure Database

Update the following properties inside:

```
src/main/resources/application.properties
```

```
spring.datasource.url
spring.datasource.username
spring.datasource.password

jwt.secret
jwt.expiration
```

## Run the Application

Run

```
EventTicketBookingSystemApplication.java
```

or

```bash
mvn spring-boot:run
```

---

# 📸 Screenshots

> Screenshots will be added after frontend completion.

- Login Page
- Registration Page
- Dashboard
- Swagger UI

---

# 🔮 Future Enhancements

- React Frontend
- Admin Dashboard
- Seat Selection
- Email Notifications
- Payment Gateway Integration
- Docker Support
- Redis Caching
- Microservices Architecture
- AWS Deployment

---

# 👨‍💻 Author

**Neelesh Rana**

GitHub: https://github.com/neelesh-rana


---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.