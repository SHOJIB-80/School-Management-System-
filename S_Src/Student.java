public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Convert to string for saving to file
    @Override
    public String toString() {
        return name + "," + age;
    }

    // Create Student object from string
    public static Student fromString(String data) {
        String[] parts = data.split(",");
        return new Student(parts[0], Integer.parseInt(parts[1]));
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

