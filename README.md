# Todoapp01 — Java Servlet/JSP Based Task Management Application

Todoapp01 is a full-stack Java web application that provides a lightweight Task Management (To-Do List) system.  
The project demonstrates **Servlet + JSP + JDBC + MVC architecture**, implemented cleanly for learning and production-level understanding.

This project is built entirely using **Core Java Web Technologies (no Spring, no Maven)** to give hands-on experience with the internal working of Servlets, JSP, HTTP sessions, and JDBC.

---

## 1. Overview

This application allows users to:

- Register with username, email, and password  
- Log in securely  
- Add new tasks  
- Edit tasks  
- Update task status (Pending/Completed)  
- Delete tasks  
- View their own task list  
- Maintain login session until logout  

It is ideal for anyone learning:

- Java Web Development  
- JSP/Servlet backend  
- JDBC connectivity  
- MVC pattern  
- Working with Tomcat server  
- Session management  

---

## 2. Key Highlights of the Project

### ✔ Pure Servlets — No Framework  
You understand how HTTP requests are processed without shortcuts.

### ✔ Clean MVC Structure  
- **Model (DTO)** → User, Task  
- **DAO Layer** → Database operations  
- **Controller (Servlets)** → AddTask, Login, Registration etc.  
- **View (JSP)** → login.jsp, tasklist.jsp  

### ✔ Secure Session Handling  
- Prevents accessing task pages without login  
- Uses `HttpSession` to store logged-in user  

### ✔ Professional Folder Structure  
Matches standard Java EE practices.  

---

## 3. Project Structure (Matches Your Repository)

```
Todoapp01
 ├── build/classes/com           -> Compiled .class files
 ├── src/main/java/com
 │       ├── controller
 │       │      AddTask.java
 │       │      ChangeStatus.java
 │       │      DeleteTask.java
 │       │      EditTask.java
 │       │      Login.java
 │       │      Logout.java
 │       │      Registration.java
 │       │      UpdateTask.java
 │       ├── dao
 │       ├── dto
 │       └── utility
 │             DbConnection.java
 │
 ├── src/main/resources/sql
 │       todo_tables.sql
 │
 ├── src/main/webapp
 │       META-INF/
 │       WEB-INF/
 │           lib/
 │             jakarta.servlet-api-6.1.0.jar
 │             mysql-connector-java-8.0.21.jar
 │       addtask.jsp
 │       index.jsp
 │       login.jsp
 │       register.jsp
 │       tasklist.jsp
 │       updatetask.jsp
 │       web.xml
 │
 ├── .classpath
 ├── .project
 └── README.md
```

---

## 4. Detailed Architecture

### 🔷 4.1 MVC FLOW

```
Browser → JSP → Servlet → DAO → MySQL
                            ↑
                       (DTO Model)
```

### 🔷 4.2 Explanation

| Layer | Responsibility |
|-------|----------------|
| **View (JSP)** | Display UI, forms |
| **Controller (Servlets)** | Process HTTP requests, call DAO |
| **DAO** | Interact with MySQL DB |
| **DTO** | Hold user/task data |
| **Utility** | Provide DB connection |

---

## 5. Database Design

### 5.1 Users Table
Stores user account info.

Columns:
- id (PK)
- username
- email
- password

### 5.2 Tasks Table
Stores tasks created by users.

Columns:
- id (PK)
- title
- description
- status
- userid (FK → users.id)

Relation:  
**One user → many tasks**

---

## 6. Servlet Flow Explanation (Important for Recruiters)

### ➤ Registration Flow
- register.jsp → Registration servlet → DAO → Insert user → login.jsp

### ➤ Login Flow
- login.jsp → Login servlet  
  - verifies credentials  
  - creates session:  
    ```java
    session.setAttribute("user", userObject);
    ```
  - redirects to `tasklist.jsp`

### ➤ Add Task Flow
- addtask.jsp → AddTask servlet  
  - Reads form data  
  - Stores in DB  
  - Redirects to tasklist.jsp  

### ➤ Edit Task Flow
- tasklist.jsp → EditTask servlet  
  - Fetch specific task  
  - Show in updatetask.jsp  
  - UpdateTask servlet updates DB  

### ➤ Change Status Flow
- changeStatus?id=XX → marks task as completed or pending  

### ➤ Delete Task Flow
- DeleteTask servlet deletes a row by ID  

### ➤ Logout Flow
- session.invalidate()  
- redirect to login.jsp  

---

## 7. How to Run the Project

### Step 1 — Import Project in Eclipse
```
File → Import → Existing Projects into Workspace
```

### Step 2 — Add Tomcat Server  
Use Tomcat 9 or 10.

### Step 3 — Configure Database
Import SQL file:
```
src/main/resources/sql/todo_tables.sql
```

### Step 4 — Update DB credentials (if needed)
`DbConnection.java`

### Step 5 — Run on Server
Right-click project → Run on Server

### Step 6 — Open in Browser
```
http://localhost:8080/Todoapp01/login.jsp
```

---

## 8. Complete Database Script

```sql
CREATE DATABASE todo;

USE todo;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200),
    description TEXT,
    status VARCHAR(20),
    userid INT,
    FOREIGN KEY (userid) REFERENCES users(id) ON DELETE CASCADE
);
```

---

## 9. Future Enhancements (Good for Resume)

- Pagination for task list  
- Forgot password  
- Priority levels for tasks  
- Task deadlines  
- User profile update  
- Switch to Spring Boot + JPA  
- Bootstrap UI  
- REST API version  

---

## 10. Troubleshooting

### ❗ Database connection error
- Check MySQL is running  
- Verify username/password in `DbConnection.java`

### ❗ 404 or 405 Errors
- Check servlet mapping in `web.xml`

### ❗ ClassNotFound: com.mysql.jdbc.Driver
- Make sure MySQL connector JAR is in:
```
WEB-INF/lib/
```

---

## Author

**Yugesh Erukula**  
GitHub: https://github.com/Yugesherukula0

---

## License
Open-source. Free for learning and academic use.

