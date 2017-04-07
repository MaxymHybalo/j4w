package java4web.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="engine")
public class Engine {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="capacity")
    private Double capacity;

    @Column(name="model")
    private String model;

    public Engine(Double capacity, String model) {
        this.capacity = capacity;
        this.model = model;
    }

    public Engine() {
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "capacity: " + capacity;
    }
}
