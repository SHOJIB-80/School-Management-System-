import java.util.ArrayList;
import java.util.Scanner;

// Main Class
public class SchoolManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final ArrayList<Teacher> teachers = new ArrayList<>();
    private static final ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== School Management System ===");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Teachers");
            System.out.println("3. Manage Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> manageStudents();
                case 2 -> manageTeachers();
                case 3 -> manageCourses();
                case 4 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    // Manage Students
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

    // Manage Teachers
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

    // Manage Courses
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
}

// Student Class
class Student {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

// Teacher Class
class Teacher {
    private final String name;
    private final String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{name='" + name + "', subject='" + subject + "'}";
    }
}

// Course Class
class Course {
    private final String name;
    private final ArrayList<Student> students;
    private Teacher teacher;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{name='" + name + "', teacher=" + (teacher != null ? teacher : "None") +
                ", students=" + students + "}";
    }
}

