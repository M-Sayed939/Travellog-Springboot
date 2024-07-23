# Travel Log App

## Overview

The Travel Log App is a Spring Boot-based web application designed for managing travel destinations and user accounts. It allows users to create, view, and manage travel destinations, along with providing user authentication and form validation features.

## Features

- **User Management**: Sign up, login, and manage user accounts.
- **Destination Management**: Create, view, and manage travel destinations.
- **Form Validation**: Ensure data integrity and validation for user inputs.
- **Database Integration**: Uses PostgreSQL for robust data storage.

## Technologies

- **Backend Framework**: Spring Boot
- **Database**: PostgreSQL
- **Java Version**: 17
- **Build Tool**: Maven

## Getting Started

### Prerequisites

Ensure you have the following installed:

- Java 17
- PostgreSQL
- Maven

### Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/M-Sayed939/Travellog-Springboot.git
   cd Travellog-Springboot
   ```

2. **Configure Database Settings**:

   Update the `application.properties` file in `src/main/resources` with your PostgreSQL configuration:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
   spring.datasource.username=your_db_user
   spring.datasource.password=your_db_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build the Project**:

   ```bash
   mvn clean install
   ```

4. **Run the Application**:

   ```bash
   mvn spring-boot:run
   ```

   The application will be available at `http://localhost:8080/`.

## Running Tests

To ensure everything is working correctly, run the test suite:

```bash
mvn test
```

## Acknowledgements

- **Spring Boot Documentation**: [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- **PostgreSQL Documentation**: [PostgreSQL Official Documentation](https://www.postgresql.org/docs/)
