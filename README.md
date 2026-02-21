📘 Student Management System (Secure Enterprise Version)

A secure, role-based Student Management System built using Spring Boot, Spring Security, JPA (Hibernate), and MySQL, enhanced with authentication, authorization, audit logging, and enterprise-level security features.

🚀 Project Overview

This project started as a basic CRUD-based student management system and was enhanced into a secure, enterprise-style web application featuring:

Database-based authentication

BCrypt password encryption

Role-based access control (RBAC)

CSRF protection

Session management

Audit logging system

Custom login/logout handling

File-based logging with Logback

🛠️ Tech Stack
Layer	Technology
Backend	Spring Boot
Security	Spring Security
ORM	Hibernate (JPA)
Database	MySQL
Frontend	JSP + CSS
Logging	Logback
Build Tool	Maven
🔐 Security Implementations
1️⃣ Database Authentication

Users stored in app_user table

Roles stored as ROLE_ADMIN and ROLE_USER

Custom UserDetailsService implementation

2️⃣ BCrypt Password Encryption

Passwords hashed using BCrypt

One-way encryption with salt

Production-level secure storage

Example stored password:

$2a$10$EpIIzOWJkYLMOkCn.Mi6cOBKe9d/vytCF3p8psWkD/RFpzwrVjYHq
3️⃣ Role-Based Access Control (RBAC)
ADMIN:

Add Student

Update Student

Delete Student

View Students

USER:

View Students only

Authorization enforced at:

Controller level

UI level (menu hiding via Spring Security JSP tags)

4️⃣ CSRF Protection

CSRF tokens included in all forms

Spring Security CSRF filter enabled

Prevents Cross-Site Request Forgery attacks

5️⃣ Session Management

Custom session timeout configured

Automatic logout after inactivity

Secure session handling

6️⃣ Audit Logging System

A dedicated audit_log table tracks:

Username

Action performed

Timestamp

IP Address

Logged events include:

ADD STUDENT

UPDATE STUDENT

DELETE STUDENT

LOGIN SUCCESS

LOGOUT

This ensures:

Accountability

Traceability

Administrative monitoring

7️⃣ File-Based Logging

Logback configuration generates:

student-security.log

Tracks:

Security events

Validation failures

Duplicate entries

System startup/shutdown

📂 Project Structure
src/
 ├── config/
 │    ├── SecurityConfig.java
 │    ├── CustomUserDetailsService.java
 │    ├── CustomLoginSuccessHandler.java
 │    ├── CustomLogoutSuccessHandler.java
 │
 ├── controller/
 │    └── StudentController.java
 │
 ├── model/
 │    ├── StudentRegistration.java
 │    ├── AppUser.java
 │    └── AuditLog.java
 │
 ├── repository/
 │    ├── StudentRepository.java
 │    ├── UserRepository.java
 │    └── AuditLogRepository.java
 │
 └── webapp/views/jsp/
      ├── login.jsp
      ├── addStudent.jsp
      ├── updateStudent.jsp
      ├── deleteStudent.jsp
      ├── viewAllStudent.jsp
      └── accessDenied.jsp
🧪 How to Run the Project
1️⃣ Clone Repository
git clone https://github.com/yourusername/student-management-system-withlotsof-authentication.git
2️⃣ Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/student
spring.datasource.username=root
spring.datasource.password=your_password
3️⃣ Run Application
mvn spring-boot:run

Open in browser:

http://localhost:8080
👥 Default Users (Example)
Username	Password	Role
admin	admin123	ADMIN
user	user123	USER

(Passwords are BCrypt encrypted in DB.)

📊 Security Architecture Evolution
Feature	Initial Version	Current Version
Authentication	In-memory	Database-based
Password Storage	Plain	BCrypt encrypted
Authorization	Basic	Full RBAC
Audit Trail	None	Full DB audit logging
CSRF	Disabled	Enabled
Session Control	Default	Configured timeout
Login Monitoring	None	Logged
Logout Monitoring	None	Logged
🔮 Future Enhancements

Account lock after failed attempts

Password policy enforcement

Admin dashboard for audit logs

REST API version with JWT

Docker containerization

Cloud deployment (AWS/Azure)

Two-factor authentication (2FA)

🎯 Learning Outcomes

Through this project:

Implemented Spring Security from scratch

Built custom authentication flow

Integrated secure password hashing

Applied role-based UI control

Designed audit logging mechanism

Understood enterprise-grade security practices

📌 Author

Sonu George
Secure Backend Development | Spring Boot | Security Engineering
