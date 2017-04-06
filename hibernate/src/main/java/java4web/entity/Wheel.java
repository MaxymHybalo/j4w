package java4web.entity;

import javax.persistence.*;

@Entity
@Table(name="wheel")
public class Wheel {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="wheel_id")
    private Tyres tyres;

    public Wheel() {
    }

    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

    @Override
    public String toString() {
        return "tyres:\n" + tyres.toString();
    }
}
