public class Staff {
    private String name;
    private String position;
    private String department;

    // Constructor
    public Staff(String name, String position, String department) {
        this.name = name;
        this.position = position;
        this.department = department;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Convert Staff object to string
    @Override
    public String toString() {
        return name + "," + position + "," + department;
    }

    // Create Staff object from string
    public static Staff fromString(String data) {
        String[] parts = data.split(",");
        return new Staff(parts[0], parts[1], parts[2]);
    }
}