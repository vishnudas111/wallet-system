# Digital Wallet system
📌 Overview
* The Digital Wallet System is a secure, scalable, and efficient platform for managing digital transactions, storing funds, and facilitating seamless payments. Built using Java, Spring Boot, and MySQL, the system supports real-time balance tracking, transaction history, and role-based access control (RBAC) to ensure security and compliance.

🚀 Key Features

* User Management – Secure authentication & role-based access (Admin, User).
*  Fund Transactions – Deposit, withdrawal, and transfer with real-time balance updates.
* Transaction History – Full ledger with timestamps and verification.
* curity & Authentication – Uses JWT-based authentication & password encryption.
* Caching for Performance – Utilizes Redis to optimize transaction processing.
* Event-Driven Architecture – Kafka integration for scalable transaction handling.
* RESTful API – Exposes endpoints for external integrations and mobile applications.

🛠️ Tech Stack
 - Layer	Technology
 - Backend	Java, Spring Boot (Spring Security, Spring Data JPA)
 - Database	MySQL, PostgreSQL
 - Caching	Redis
 - Message Queue	Kafka (Event-Driven Architecture)
 - Authentication	JWT, BCrypt
 - Infrastructure	Docker, Kubernetes
 - Testing	JUnit, Mockito

   
📌 System Architecture
The system follows a microservices-based architecture with high availability and fault tolerance.


🔒 Security Measures
* JWT-Based Authentication – Secure access tokens for API requests.
* Role-Based Access Control (RBAC) – Prevents unauthorized actions.
* Data Encryption – Passwords stored using BCrypt hashing.
* API Rate Limiting – Prevents abuse and fraud.
