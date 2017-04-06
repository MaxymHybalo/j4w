package java4web.entity;

import javax.persistence.*;

@Entity
@Table(name="tyres")
public class Tyres {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="size")
    private Double size;

    @Column(name="name")
    private String name;

    public Tyres() {
    }

    public Tyres(Double size, String name) {
        this.size = size;
        this.name = name;
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

    @Override
    public String toString() {
        return "\tsize: " + size + "\n\tname: " + name;
    }
}
