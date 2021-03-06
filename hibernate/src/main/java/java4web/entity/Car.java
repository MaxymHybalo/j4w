package java4web.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="name")
    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="car_id")
    private List<Wheel> wheel;

    public List<Wheel> getWheel() {
        return wheel;
    }

    public void setWheel(List<Wheel> wheel) {
        this.wheel = wheel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
