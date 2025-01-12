
package schoolmanagementsystem;

import java.util.ArrayList;

public class Course {
    private String name;
    private Teacher teacher;
    private final ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Course Name: " + name + 
               ", Teacher: " + (teacher != null ? teacher.getName() : "Not Assigned") + 
               ", Students: " + students.size();
    }
}