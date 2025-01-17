public class Teacher extends Person {
    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public String getDetails() {
        return "Teacher{name='" + getName() + "', subject='" + subject + "'}";
    }
}
