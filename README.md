Safran Dashboard
Welcome to the Safran Dashboard project! This repository contains the source code for a web-based dashboard designed to manage programs, formations, and employee grille. The backend is powered by Spring Boot.

Table of Contents
Overview
Features
Architecture
Installation
Usage
API Documentation
Contributing
License
Overview
The Safran Dashboard is a comprehensive solution for managing the various programs, formations, and employee schedules within Safran. It is designed to provide a user-friendly interface for administrators and employees to interact with the system efficiently.

Features
Program Management: Create, update, delete, and view programs.
Formation Management: Manage formation schedules, instructors, and participants.
Employee Grille: View and manage employee schedules and availability.
Authentication & Authorization: Secure access to different parts of the dashboard based on user roles.
Responsive Design: Accessible on both desktop and mobile devices.
Architecture
The project follows a multi-tier architecture:

Backend: Spring Boot application providing RESTful APIs.
Database: MSSQL.
Backend Structure
src/main/java/com/safran/dashboard: Contains the main application code.
controller: REST controllers for handling HTTP requests.
service: Business logic and services.
repository: Interfaces for database operations.
model: Entity classes representing the database tables.
dto: Data Transfer Objects for transferring data between layers.
security: Configuration for authentication and authorization.
Installation
Prerequisites
Java 11 or higher
Maven
(Specify any other prerequisites, e.g., Node.js if using a specific frontend framework)
Steps
Clone the repository:

bash
Copy code
git clone LINK
cd dashboard
Build the project:

bash
Copy code
mvn clean install
Configure the database:
Update the application.properties file in src/main/resources with your database configuration.

Run the application:

bash
Copy code
mvn spring-boot:run
Usage
Accessing the Dashboard
Once the application is running, you can access the dashboard at http://localhost:8080.

API Endpoints
The API documentation is available at http://localhost:8080/swagger-ui.html (if Swagger is configured) or provide a detailed list of endpoints here.

API Documentation
For detailed API documentation, refer to the Swagger UI or the docs directory.

Contributing
We welcome contributions to improve the Safran Dashboard. Please follow these steps to contribute:

Fork the repository.
Create a new branch (git checkout -b feature/your-feature-name).
Commit your changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature/your-feature-name).
Create a new Pull Request.
Please ensure your code adheres to our coding standards and includes appropriate tests.

License
This project is licensed under the MIT License - see the LICENSE file for details.
