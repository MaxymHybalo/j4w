package java4web.entity;


import org.springframework.stereotype.Component;

@Component
public class Wheel {

    private Integer id;

    private Tyres tyres;

    private Integer carId;

    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    public Wheel() {
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

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "tyres:\n" + tyres.toString();
    }
}
