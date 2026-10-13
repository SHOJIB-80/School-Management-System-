# School Management System

A Java-based school administration application for managing students, teachers, courses, staff, academic events, and library records through a simple command-line interface.

## Overview

This project is a desktop-style console application built in Java. It provides an admin login and a menu-driven dashboard for handling school records. The system stores data in plain text files within the project and allows administrators to add, view, and manage information related to the school.

The application focuses on core administrative workflows such as student registration, teacher record management, course listing, staff management, academic calendar tracking, and library book operations.

## Features

- Admin authentication with username and password validation
- Student management with add and view functionality
- Teacher management with add and view functionality
- Course management with add and view functionality
- Staff management with add and view functionality
- Academic calendar management with event creation and display
- Library management with add, view, borrow, and return operations
- File-based persistence using Java I/O
- Interactive command-line interface

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Core application logic and interface |
| Java I/O | Reading and writing data from text files |
| Plain text files | Data persistence for school records |

## Project Structure

```text
School-Management-System-/
├── README.md
├── S_Src/
│   ├── AcademicCalendar.java
│   ├── Admin.java
│   ├── Course.java
│   ├── FileHandler.java
│   ├── Library.java
│   ├── Main.java
│   ├── Person.java
│   ├── Staff.java
│   ├── Student.java
│   ├── Teacher.java
│   └── data/
│       ├── calender.txt
│       ├── courses.txt
│       ├── library.txt
│       ├── person.txt
│       ├── staff.txt
│       ├── students.txt
│       └── teachers.txt
├── School Management System.docx
├── report (1).docx
└── ...
```

### Key Files

- `S_Src/Main.java`: Main entry point and menu logic
- `S_Src/Admin.java`: Admin authentication logic
- `S_Src/Student.java`: Student model and file conversion methods
- `S_Src/Teacher.java`: Teacher model and file conversion methods
- `S_Src/Staff.java`: Staff model and file conversion methods
- `S_Src/Course.java`: Course model
- `S_Src/AcademicCalendar.java`: Event management for academic schedule
- `S_Src/Library.java`: Book borrowing and returning logic
- `S_Src/FileHandler.java`: Reads and writes records to text files
- `S_Src/data/`: Persistent storage files for school records

## System Architecture

```text
User
  ↓
Java Console Application
  ↓
Main Menu and Controller Logic
  ↓
Model Classes
  ↓
Text File Storage (S_Src/data)
```

The application is organized around a central `Main` class that coordinates the menu flow, collects user input, and delegates actions to the relevant model classes. Each model class is responsible for a specific part of the school system, and file-based persistence is handled through `FileHandler`.

## Installation

1. Install the Java Development Kit (JDK) on your machine.
2. Clone or download the repository.
3. Open a terminal in the project folder.
4. Navigate to the `S_Src` directory:

```bash
cd S_Src
```

5. Compile the application:

```bash
javac *.java
```

6. Run the program:

```bash
java Main
```

## Configuration

This project does not use environment variables, `.env` files, or external database configuration. The application is configured directly in the Java source code.

### Default Admin Credentials

The admin login is created in `S_Src/Main.java` with the following values:

- Username: `admin`
- Password: `1234`

The `Admin.authenticate()` method compares the entered username and password against these hardcoded values.

## Database Setup

This project does not use a database management system such as MySQL, PostgreSQL, or SQLite.

Data is stored in plain text files inside the `S_Src/data` directory, including:

- `students.txt`
- `teachers.txt`
- `courses.txt`
- `staff.txt`
- `calender.txt`
- `library.txt`

The file handling logic is implemented in `S_Src/FileHandler.java`.

## Running the Project

1. Open a terminal.
2. Navigate to the project directory.
3. Change into `S_Src`.
4. Compile the Java files.
5. Run the application using `java Main`.
6. Enter the admin username and password.
7. Use the menu to manage school data.

## Application Usage

The user interacts with the system through a menu-driven command-line interface.

### Main workflows

1. Log in as the administrator.
2. Select a module from the main menu:
   - Manage Students
   - Manage Teachers
   - Manage Courses
   - Manage Staff
   - Manage Academic Calendar
   - Manage Library
3. Add or view records.
4. Save data when needed through the main menu option.

### Student management

The student menu allows the admin to:

- Add a student with a name and age
- View all students

### Teacher management

The teacher menu allows the admin to:

- Add a teacher with a name and subject
- View all teachers

### Course management

The course menu allows the admin to:

- Add a course name
- View all courses

### Staff management

The staff menu allows the admin to:

- Add staff using name, position, and department
- View all staff records

### Academic calendar management

The academic calendar menu allows the admin to:

- Add an event with a name and date
- View all calendar events

### Library management

The library menu allows the admin to:

- Add books
- View all books
- Borrow a book
- Return a book

## Authentication and Authorization

The project includes a basic admin authentication flow:

- The program creates a new `Admin` object with the username `admin` and password `1234`.
- The user is prompted to enter a username and password.
- `Admin.authenticate()` checks whether both values match the stored credentials.
- If the values do not match, the program exits.

This is a simple login mechanism and does not include password hashing, role-based access control, session management, or secure token-based authorization.

## Testing

There is no automated test suite or testing framework configured in this repository. No JUnit files or test scripts are present.

## Known Limitations

- The project is a console-based Java application and does not include a graphical user interface.
- The system uses plain text files instead of a database.
- Admin credentials are hardcoded directly in the source code.
- Passwords are compared as plain strings rather than hashed or encrypted.
- There is no role-based authorization model beyond the single admin account.
- Input validation is limited.
- The application does not provide a web API or network-based services.

## Security Considerations

This project does not implement a hardened security model. The current implementation includes:

- Simple username and password checking
- Hardcoded admin credentials
- Plain text storage in local files
- No encryption for stored records
- No session management or protected route logic

## License

License under SHOJIB-80

## Author

MD SIRAJUL ISLAM
