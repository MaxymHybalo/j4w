package java4web.entity;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Car {

    private Integer id;

    private String name;

    private List<Wheel> wheels;

    private Engine engine;

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

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Car(List<Wheel> wheels , Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    public Car(){

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
