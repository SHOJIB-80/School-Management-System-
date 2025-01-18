public class Person {
    protected String name;
    protected String role;

    public Person(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', role='" + role + "'}";
    }
}