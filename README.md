# Spring REST API Demo

This project demonstrates how to design and build **RESTful APIs** with the **Spring Framework**.  
It connects to a **MySQL database**, retrieves and manipulates data, converts it into **JSON**, and exposes it through REST endpoints that can be consumed by web applications or other clients.  

The application showcases key backend development skills, including:  
- 🚀 **Building REST APIs with Spring Boot**  
- 🗄️ **CRUD operations (Create, Read, Update, Delete)**  
- 🛢️ **Database integration with MySQL using Spring Data JPA**  
- 🔄 **Object Relational Mapping (ORM)**  
- 📦 **Data serialization with Jackson (JSON)**  
- ⚠️ **Exception handling & validation**  
- 🏗️ **Layered architecture (Controller → Service → Repository)**  
- 🛠️ **API testing with Postman**
---

## 🚀 Tech Stack
- ☕ **Java 21**
- 🌱 **Spring Boot 3 / Spring Framework 6**
- 🛢️ **MySQL**

## 📦 Dependencies
- 🌐 **Spring Web** – RESTful API development  
- 🗄️ **Spring Data JPA** – ORM and database queries  
- 🔗 **MySQL Connector/J** – JDBC driver for MySQL  
- 📦 **Jackson** – JSON serialization/deserialization  
- 🧪 **Spring Boot Starter Test** – unit & integration testing  

## 🛠️ Development Tools
- 🧑‍💻 **VS Code** – IDE for coding  
- 🛠️ **Postman** – testing and documenting REST endpoints  
- 🔗 **Git & GitHub** – version control & collaboration  

---

## 📂 Project Details

### 📌 API Requirements
The API provides a simple **Employee Directory** service where REST clients can:  
- 📋 Get a list of employees  
- 🔍 Get a single employee by ID  
- ➕ Add a new employee  
- ✏️ Update an existing employee  
- ❌ Delete an employee  

### 🌐 API Endpoints
| HTTP Method | URL | CRUD Action | Description |
| ----------- | --- | ----------- | ----------- |
| **POST**   | `/api/employees` | **Create** | ➕ Add a new employee |
| **GET**    | `/api/employees` | **Read**   | 📋 Fetch all employees |
| **GET**    | `/api/employees/{employeeID}` | **Read** | 🔍 Fetch employee by ID |
| **PUT**    | `/api/employees/{employeeID}` | **Update** | ✏️ Update employee details |
| **DELETE** | `/api/employees/{employeeID}` | **Delete** | ❌ Remove employee |
