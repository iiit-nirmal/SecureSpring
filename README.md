
# 🔐 SpringSecurity2

A simple and clean **Spring Boot + Spring Security** application demonstrating secure user registration, login, and JWT-based stateless authentication.

---

## 📁 Project Structure

```
SpringSecurity2/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.tulesko.SpringSecurity/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── dao/
│   │   │       ├── model/
│   │   │       └── config/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── ...
└── pom.xml
```

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 17+
- Maven
- PostgreSQL (or update DB config for your DB)

---

### 🛠️ How to Run

1. **Clone the repository**

```bash
git clone https://github.com/iiit-nirmal/SpringSecurity2.git
cd SpringSecurity2
```

2. **Configure your DB**

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

> 💡 You can also change the DB type, port, or use `spring.jpa.hibernate.ddl-auto=create` for fresh schema creation.

3. **Run the application**

```bash
./mvnw spring-boot:run
```

Or use your IDE's Run button.

---

## 🔐 API Endpoints

| Method | Endpoint      | Description        | Auth Required |
|--------|---------------|--------------------|---------------|
| POST   | `/register`   | Register new user  | ❌ No         |
| POST   | `/login`      | Authenticate user  | ❌ No         |
| GET    | `/welcome`    | Protected resource | ✅ Yes        |

> Replace `/welcome` with your secured endpoint.

---

## 📦 Example Request

### 🔸 Register

```http
POST /register
Content-Type: application/json

{
  "username": "john",
  "password": "pass123"
}
```

### 🔸 Login

```http
POST /login
Content-Type: application/json

{
  "username": "john",
  "password": "pass123"
}
```

---

## 🛡️ Security Configuration

- ✅ CSRF disabled
- ✅ HTTP Basic Auth or JWT (depending on your config)
- ✅ Stateless sessions using `SessionCreationPolicy.STATELESS`
- ✅ BCrypt password hashing

---

## 🧠 Technologies Used

- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

---

## 💡 To Do / Enhancements

- [ ] Add JWT Authentication
- [ ] Exception Handling & Logging
- [ ] Swagger UI for API testing
- [ ] Frontend Integration (React/Angular)

---

## 🧑‍💻 Author

**Nirmal Bharadwaj**  
🔗 [GitHub](https://github.com/iiit-nirmal)

---

## 📜 License

This project is open-source under the [MIT License](LICENSE).
