package p0015;

public class Employee {

    private final long id;
    private final String name;
    private final String department;
    private final double salary;
    private final boolean active;

    public Employee(long id, String name, String department, double salary, boolean active) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return active;
    }
}
