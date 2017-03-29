package java4web.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Engine {

    private Double capacity;

    private Integer carId;

    public Engine(Double capacity) {
        this.capacity = capacity;
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
