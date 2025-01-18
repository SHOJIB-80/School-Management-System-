public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return name + "," + subject;
    }

    public static Teacher fromString(String data) {
        String[] parts = data.split(",");
        return new Teacher(parts[0], parts[1]);
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }
}
