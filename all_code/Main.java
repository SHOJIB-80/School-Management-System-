import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SchoolManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final ArrayList<Teacher> teachers = new ArrayList<>();
    private static final ArrayList<Course> courses = new ArrayList<>();
    private static final HashMap<String, User> users = new HashMap<>();
    private static User loggedInUser;

    public static void main(String[] args) {
        initializeUsers(); // Preload some users for testing
        login(); // Authenticate user

        if (loggedInUser == null) {
            System.out.println("Exiting system. Goodbye!");
            return;
        }

        int choice;
        do {
            System.out.println("\n=== School Management System ===");
            if ("admin".equals(loggedInUser.getRole())) {
                System.out.println("1. Manage Students");
                System.out.println("2. Manage Teachers");
                System.out.println("3. Manage Courses");
            } else if ("teacher".equals(loggedInUser.getRole())) {
                System.out.println("1. View Assigned Courses");
            } else if ("student".equals(loggedInUser.getRole())) {
                System.out.println("1. View Enrolled Courses");
            }
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    if ("admin".equals(loggedInUser.getRole())) manageStudents();
                    else if ("teacher".equals(loggedInUser.getRole())) viewAssignedCourses();
                    else if ("student".equals(loggedInUser.getRole())) viewEnrolledCourses();
                }
                case 2 -> {
                    if ("admin".equals(loggedInUser.getRole())) manageTeachers();
                    else System.out.println("Invalid choice!");
                }
                case 3 -> {
                    if ("admin".equals(loggedInUser.getRole())) manageCourses();
                    else System.out.println("Invalid choice!");
                }
                case 4 -> System.out.println("Logging out. Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    private static void initializeUsers() {
        users.put("admin", new User("admin", "password", "admin"));
        users.put("teacher1", new User("teacher1", "password", "teacher"));
        users.put("student1", new User("student1", "password", "student"));
    }

    
    private static void login() {
        System.out.println("\n=== Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            loggedInUser = users.get(username);
            System.out.println("Login successful! Welcome, " + loggedInUser.getUsername());
        } else {
            System.out.println("Invalid credentials. Exiting system.");
            loggedInUser = null;
        }
    }


    private static void manageStudents() {
        int choice;
        do {
            System.out.println("\n=== Manage Students ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    private static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        students.add(new Student(name, age));
        System.out.println("Student added successfully!");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n=== Students List ===");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

 
    private static void manageTeachers() {
        int choice;
        do {
            System.out.println("\n=== Manage Teachers ===");
            System.out.println("1. Add Teacher");
            System.out.println("2. Display All Teachers");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTeacher();
                case 2 -> displayTeachers();
                case 3 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    private static void addTeacher() {
        System.out.print("Enter Teacher Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Teacher Subject: ");
        String subject = scanner.nextLine();
        teachers.add(new Teacher(name, subject));
        System.out.println("Teacher added successfully!");
    }

    private static void displayTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
        } else {
            System.out.println("\n=== Teachers List ===");
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }
        }
    }

    
    private static void manageCourses() {
        int choice;
        do {
            System.out.println("\n=== Manage Courses ===");
            System.out.println("1. Add Course");
            System.out.println("2. Display All Courses");
            System.out.println("3. Assign Students and Teachers to Course");
            System.out.println("4. Go Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> displayCourses();
                case 3 -> assignToCourse();
                case 4 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    private static void addCourse() {
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();
        courses.add(new Course(name));
        System.out.println("Course added successfully!");
    }

    private static void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            System.out.println("\n=== Courses List ===");
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }

    private static void assignToCourse() {
        if (courses.isEmpty()) {
            System.out.println("No courses available to assign.");
            return;
        }
        System.out.println("\n=== Assign to Course ===");
        displayCourses();
        System.out.print("Select Course by Index (1 to " + courses.size() + "): ");
        int courseIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course index!");
            return;
        }

        Course course = courses.get(courseIndex);

        System.out.println("Assign Students to Course:");
        displayStudents();
        System.out.print("Enter Student Index (1 to " + students.size() + " or 0 to Skip): ");
        int studentIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (studentIndex >= 0 && studentIndex < students.size()) {
            course.addStudent(students.get(studentIndex));
            System.out.println("Student assigned successfully!");
        }

        System.out.println("Assign Teacher to Course:");
        displayTeachers();
        System.out.print("Enter Teacher Index (1 to " + teachers.size() + " or 0 to Skip): ");
        int teacherIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (teacherIndex >= 0 && teacherIndex < teachers.size()) {
            course.addTeacher(teachers.get(teacherIndex));
            System.out.println("Teacher assigned successfully!");
        }
    }

   
    private static void viewAssignedCourses() {
        System.out.println("\n=== Your Assigned Courses ===");
        for (Course course : courses) {
            if (course.getTeacher() != null && course.getTeacher().getName().equals(loggedInUser.getUsername())) {
                System.out.println(course);
            }
        }
    }

   
    private static void viewEnrolledCourses() {
        System.out.println("\n=== Your Enrolled Courses ===");
        for (Course course : courses) {
            for (Student student : course.getStudents()) {
                if (student.getName().equals(loggedInUser.getUsername())) {
                    System.out.println(course);
                }
            }
        }
    }
}


class User {
    private final String username;
    private final String password;
    private final String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}

class Student {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

class Teacher {
    private final String name;
    private final String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Teacher{name='" + name + "', subject='" + subject + "'}";
    }
}

class Course {
    private final String name;
    private final ArrayList<Student> students = new ArrayList<>();
    private Teacher teacher;

    public Course(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Course{name='" + name + "', teacher=" + (teacher != null ? teacher : "None") +
                ", students=" + students + "}";
    }
}
