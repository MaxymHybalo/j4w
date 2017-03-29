package java4web.entity;


public class Engine {

    private Double capacity;

    public Engine(Double capacity) {
        this.capacity = capacity;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "capacity: " + capacity;
    }
}
