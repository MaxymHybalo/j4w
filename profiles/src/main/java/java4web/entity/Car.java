package java4web.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    private Wheel wheel;

    @Autowired
    private Engine engine;

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Injected car with:" +
                 "\n\tEngine:\n\t\t" + engine.toString() +
                "\n\tWheels:" + wheel.toString();
    }

}
