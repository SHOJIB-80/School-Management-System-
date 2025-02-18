import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final ArrayList<Teacher> teachers = new ArrayList<>();
    private static final ArrayList<Course> courses = new ArrayList<>();
    private static final ArrayList<Staff> staffMembers = new ArrayList<>();
    private static final AcademicCalendar academicCalendar = new AcademicCalendar();
    private static final Library library = new Library();
    private static Admin admin;

    public static void main(String[] args) {
        // Initialize admin credentials
        admin = new Admin("admin", "1234");

        // Admin authentication
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (!admin.authenticate(username, password)) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }
        System.out.println("Welcome, Admin!");

        // Load data from files
        loadData();

        // Main menu
        int choice;
        do {
            System.out.println("\n=== School Management System ===");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Teachers");
            System.out.println("3. Manage Courses");
            System.out.println("4. Manage Staff");
            System.out.println("5. Manage Academic Calendar");
            System.out.println("6. Manage Library");
            System.out.println("7. Save Data");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> manageStudents(scanner);
                    case 2 -> manageTeachers(scanner);
                    case 3 -> manageCourses(scanner);
                    case 4 -> manageStaff(scanner);
                    case 5 -> manageAcademicCalendar(scanner);
                    case 6 -> manageLibrary(scanner);
                    case 7 -> saveData();
                    case 8 -> System.out.println("Exiting system...");
                    default -> System.out.println("Invalid choice! Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                choice = -1; // Reset choice to continue the loop
            }
        } while (choice != 8);
    }

    private static void manageStudents(Scanner scanner) {
        System.out.println("\n1. Add Student");
        System.out.println("2. View All Students");
        System.out.print("Enter your choice: ");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    students.add(new Student(name, age));
                    System.out.println("Student added successfully.");
                }
                case 2 -> {
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        students.forEach(System.out::println);
                    }
                }
                default -> System.out.println("Invalid choice!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private static void manageTeachers(Scanner scanner) {
        System.out.println("\n1. Add Teacher");
        System.out.println("2. View All Teachers");
        System.out.print("Enter your choice: ");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter teacher name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter teacher subject: ");
                    String subject = scanner.nextLine();
                    teachers.add(new Teacher(name, subject));
                    System.out.println("Teacher added successfully.");
                }
                case 2 -> {
                    if (teachers.isEmpty()) {
                        System.out.println("No teachers found.");
                    } else {
                        teachers.forEach(System.out::println);
                    }
                }
                default -> System.out.println("Invalid choice!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private static void manageCourses(Scanner scanner) {
        System.out.println("\n1. Add Course");
        System.out.println("2. View All Courses");
        System.out.print("Enter your choice: ");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter course name: ");
                    String name = scanner.nextLine();
                    courses.add(new Course(name));
                    System.out.println("Course added successfully.");
                }
                case 2 -> {
                    if (courses.isEmpty()) {
                        System.out.println("No courses found.");
                    } else {
                        courses.forEach(System.out::println);
                    }
                }
                default -> System.out.println("Invalid choice!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private static void manageStaff(Scanner scanner) {
        System.out.println("\n1. Add Staff");
        System.out.println("2. View All Staff");
        System.out.print("Enter your choice: ");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter staff name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter staff position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter staff department: ");
                    String department = scanner.nextLine();
                    staffMembers.add(new Staff(name, position, department));
                    System.out.println("Staff added successfully.");
                }
                case 2 -> {
                    if (staffMembers.isEmpty()) {
                        System.out.println("No staff found.");
                    } else {
                        staffMembers.forEach(System.out::println);
                    }
                }
                default -> System.out.println("Invalid choice!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private static void manageAcademicCalendar(Scanner scanner) {
        System.out.println("\n1. Add Event");
        System.out.println("2. View All Events");
        System.out.print("Enter your choice: ");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter event name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter event date: ");
                    String date = scanner.nextLine();
                    academicCalendar.addEvent(name, date);
                    System.out.println("Event added successfully.");
                }
                case 2 -> academicCalendar.displayEvents();
                default -> System.out.println("Invalid choice!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private static void manageLibrary(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Library Management ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        library.addBook(title, author);
                    }
                    case 2 -> library.displayBooks();
                    case 3 -> {
                        System.out.print("Enter the title of the book to borrow: ");
                        String title = scanner.nextLine();
                        library.lendBook(title);
                    }
                    case 4 -> {
                        System.out.print("Enter the title of the book to return: ");
                        String title = scanner.nextLine();
                        library.returnBook(title);
                    }
                    case 5 -> System.out.println("Exiting the library system. Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                choice = -1; // Reset choice to continue the loop
            }
        } while (choice != 5);
    }

    private static void saveData() {
        FileHandler.writeToFile("data/students.txt", students);
        FileHandler.writeToFile("data/teachers.txt", teachers);
        FileHandler.writeToFile("data/courses.txt", courses);
        FileHandler.writeToFile("data/staff.txt", staffMembers);
        System.out.println("Data saved successfully.");
    }

    private static void loadData() {
        List<String> studentData = FileHandler.readFromFile("data/students.txt");
        for (String data : studentData) {
            students.add(Student.fromString(data));
        }

        List<String> teacherData = FileHandler.readFromFile("data/teachers.txt");
        for (String data : teacherData) {
            teachers.add(Teacher.fromString(data));
        }

        List<String> courseData = FileHandler.readFromFile("data/courses.txt");
        for (String data : courseData) {
            courses.add(new Course(data));
        }

        List<String> staffData = FileHandler.readFromFile("data/staff.txt");
        for (String data : staffData) {
            staffMembers.add(Staff.fromString(data));
        }

        System.out.println("Data loaded successfully.");
    }
}