package ua.jdbc.domain;

public class Employee extends BaseEntity{
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(int id, String name) {
        setId(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
