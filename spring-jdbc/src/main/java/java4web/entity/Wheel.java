package java4web.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Wheel {

    private Integer id;

    private Tyres tyres;

    private Integer carId;

    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    @Override
    public String toString() {
        return "tyres:\n" + tyres.toString();
    }
}
