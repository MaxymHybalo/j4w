package ua.j4w.entity;


public class Tyres {

    private Double size;

    private String name;

    public Tyres(Double size, String name) {
        this.size = size;
        this.name = name;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\tsize: " + size + "\n\tname: " + name;
    }
}
