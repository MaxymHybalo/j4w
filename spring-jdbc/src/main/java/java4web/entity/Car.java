package java4web.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class Car {

    private Integer id;

    private List<Wheel> wheels;

    private Engine engine;

    public Car(List<Wheel> wheels , Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Injected car with:" +
                 "\n\tEngine:\n\t\t" + engine.toString() +
                "\n\tWheels:" + representWheels();
    }

    private String representWheels(){
        String result = "";
        int counter = 0;
        for(Wheel wheel: wheels){
            counter++;
            result+= "\n" + counter + ". " + wheel.toString();
        }
        return result;
    }
}
