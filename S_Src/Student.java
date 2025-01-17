public class Student extends Person {
    private int age;

    public Student(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String getDetails() {
        return "Student{name='" + getName() + "', age=" + age + "}";
    }
}
