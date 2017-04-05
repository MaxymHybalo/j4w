package java4web.entity;

import org.springframework.stereotype.Component;


@Component
public class Engine {

    private Integer id;

    private Double capacity;

    private Integer carId;

    public Engine(Double capacity) {
        this.capacity = capacity;
    }

    public Engine() {
    }

    public Integer getCarId() {
        return carId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public void start(){
        System.out.println("Engine started...");
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
