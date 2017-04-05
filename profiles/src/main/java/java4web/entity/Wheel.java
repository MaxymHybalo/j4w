package java4web.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Wheel {

    @Autowired
    private Tyres tyres;

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
