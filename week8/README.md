# 📦 Smart Package Delivery Tracking System

A comprehensive Spring Boot MVC web application for tracking package deliveries with real-time status updates.

## 🚀 Tech Stack

- **Spring Boot 3.2.0** - Application framework
- **Spring MVC** - Web layer
- **Spring Data JPA** - Data persistence with Hibernate
- **H2 Database** - In-memory database (configurable to MySQL)
- **Thymeleaf** - Server-side template engine
- **Maven** - Dependency management and build tool
- **Java 17** - Programming language

## ✨ Features

### Core Functionality
- ✅ Register new packages with tracking information
- ✅ View all registered packages in a clean table format
- ✅ Unique tracking ID validation (prevents duplicates)
- ✅ Mandatory delivery status selection
- ✅ Auto-generated timestamp for package creation
- ✅ Real-time validation with error messages
- ✅ Success/error feedback after operations
- ✅ Responsive and modern UI design

### Data Validation
- Tracking ID uniqueness check
- Ensures all required fields are filled
- Validates delivery status values
- Prevents empty or null values

## 📁 Project Structure

```
package-tracker/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/packagetracker/
│   │   │       ├── PackageTrackerApplication.java (Main class)
│   │   │       ├── controller/
│   │   │       │   └── PackageController.java
│   │   │       ├── service/
│   │   │       │   └── PackageService.java
│   │   │       ├── repository/
│   │   │       │   └── PackageRepository.java
│   │   │       └── model/
│   │   │           └── Package.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   └── index.html
│   │       └── application.properties
└── pom.xml
```

## 🏗️ Architecture

### Model Layer (`Package.java`)
- JPA Entity with auto-generated ID
- Fields: id, trackingId, senderName, receiverName, destinationCity, deliveryStatus, createdTime
- Annotations: `@Entity`, `@Id`, `@GeneratedValue`, `@PrePersist`

### Repository Layer (`PackageRepository.java`)
- Extends `JpaRepository<Package, Long>`
- Custom query method: `findByTrackingId(String trackingId)`
- Built-in CRUD operations

### Service Layer (`PackageService.java`)
- Business logic and validation
- Prevents duplicate tracking IDs
- Validates mandatory fields
- Methods: `savePackage()`, `getAllPackages()`, `getPackageByTrackingId()`

### Controller Layer (`PackageController.java`)
- Handles HTTP requests
- **GET /** - Display home page with form and package list
- **POST /save** - Save new package and redirect

### View Layer (`index.html`)
- Thymeleaf template with modern, responsive design
- Registration form with validation
- Dynamic table showing all packages
- Color-coded delivery status badges

## 🛠️ Setup and Installation

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- Git (optional)

### Installation Steps

1. **Navigate to project directory:**
   ```bash
   cd "c:\Users\suman\OneDrive\Documents\College\3rd year\6th sem\Subjects\OOAD\Labs\week8"
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
   
   Or run the JAR file:
   ```bash
   java -jar target/package-tracker-1.0.0.jar
   ```

4. **Access the application:**
   - Main Application: http://localhost:8080
   - H2 Console (for database inspection): http://localhost:8080/h2-console

## 🗄️ Database Configuration

### H2 Database (Default)
The application uses H2 in-memory database by default. Configuration in `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:packagetracker
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
```

### MySQL Database (Optional)
To switch to MySQL, uncomment the MySQL configuration in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/package_tracker_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

Also uncomment the MySQL dependency in `pom.xml`.

## 📝 Usage Guide

### Registering a Package

1. Fill out the registration form:
   - **Tracking ID**: Enter a unique identifier (e.g., TRK123456)
   - **Sender Name**: Name of the person sending the package
   - **Receiver Name**: Name of the person receiving the package
   - **Destination City**: City where package will be delivered
   - **Delivery Status**: Select from Dispatched, In Transit, or Delivered

2. Click "Register Package" button

3. View success/error message

4. See the new package in the table below

### Viewing All Packages

- All registered packages are displayed in a table on the home page
- Table columns show: ID, Tracking ID, Sender, Receiver, City, Status, Created Time
- Status is displayed with color-coded badges for easy identification

## 🎨 Delivery Status Types

- **Dispatched** (Yellow badge) - Package has been sent
- **In Transit** (Blue badge) - Package is on its way
- **Delivered** (Green badge) - Package has reached destination

## 🔍 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /        | Display home page with form and package list |
| POST   | /save    | Save new package to database |

## ⚙️ Configuration

### Application Properties
Key configurations in `application.properties`:

```properties
server.port=8080
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
```

## 🧪 Testing the Application

### Manual Testing Steps:

1. **Test successful package registration:**
   - Enter valid data in all fields
   - Submit form
   - Verify package appears in table

2. **Test duplicate tracking ID:**
   - Try to register a package with an existing tracking ID
   - Verify error message is displayed

3. **Test mandatory field validation:**
   - Leave a field empty
   - Submit form
   - Verify validation error

4. **Test delivery status options:**
   - Register packages with different statuses
   - Verify correct badge colors in table

## 🛡️ Validation Rules

- **Tracking ID**: Required, must be unique
- **Sender Name**: Required, cannot be empty
- **Receiver Name**: Required, cannot be empty
- **Destination City**: Required, cannot be empty
- **Delivery Status**: Required, must be one of: Dispatched, In Transit, Delivered
- **Created Time**: Auto-generated, cannot be modified

## 📊 Database Schema

### packages table
| Column          | Type         | Constraints                    |
|-----------------|--------------|--------------------------------|
| id              | BIGINT       | PRIMARY KEY, AUTO_INCREMENT    |
| tracking_id     | VARCHAR(255) | UNIQUE, NOT NULL               |
| sender_name     | VARCHAR(255) | NOT NULL                       |
| receiver_name   | VARCHAR(255) | NOT NULL                       |
| destination_city| VARCHAR(255) | NOT NULL                       |
| delivery_status | VARCHAR(255) | NOT NULL                       |
| created_time    | TIMESTAMP    | NOT NULL                       |

## 🚨 Troubleshooting

### Port Already in Use
If port 8080 is already in use, change it in `application.properties`:
```properties
server.port=8081
```

### Build Errors
1. Ensure Java 17 is installed: `java -version`
2. Ensure Maven is installed: `mvn -version`
3. Clean and rebuild: `mvn clean install`

### Database Issues
- For H2: Access H2 console at http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:packagetracker`
- Username: `sa`
- Password: (leave empty)

## 📚 Learning Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Guide](https://spring.io/guides/gs/accessing-data-jpa/)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [Maven Guide](https://maven.apache.org/guides/)

## 👨‍💻 Development

### Adding New Features

1. **Add new entity field:**
   - Update `Package.java`
   - Add getter/setter
   - Update form in `index.html`
   - Add validation in `PackageService.java`

2. **Add new endpoint:**
   - Add method in `PackageController.java`
   - Create corresponding view template
   - Update navigation if needed

## 📄 License

This project is created for educational purposes as part of OOAD Lab coursework.

## 🙋‍♂️ Support

For issues or questions:
1. Check the troubleshooting section
2. Review Spring Boot logs in console
3. Inspect database using H2 console

---

**Created Date:** March 9, 2026  
**Version:** 1.0.0  
**Subject:** Object-Oriented Analysis and Design (OOAD) - Lab Week 8
