package java4web.entity;

import org.springframework.stereotype.Component;


@Component
public class Tyres {

    private Integer id;

    private Double size;

    private String name;

    private Integer wheelId;

    public Tyres(Double size, String name) {
        this.size = size;
        this.name = name;
    }

    public Tyres() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getWheelId() {
        return wheelId;
    }

    public void setWheelId(Integer wheelId) {
        this.wheelId = wheelId;
    }

    @Override
    public String toString() {
        return "\tsize: " + size + "\n\tname: " + name;
    }
}
