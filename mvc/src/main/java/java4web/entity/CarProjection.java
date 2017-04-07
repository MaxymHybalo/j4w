package java4web.entity;

import java.util.ArrayList;
import java.util.List;

public class CarProjection {

    private String name;
    private Double engineCapacity;
    private String engineModel;
    private String tyresBrand;
    private Double tyresSize;

    public CarProjection() {
    }

    public Car getCar(){
        Car car = new Car();
        car.setName(this.name);
        car.setEngine(new Engine(this.engineCapacity, this.engineModel));
        List<Wheel> wheelList = new ArrayList<>();
        wheelList.add(new Wheel(new Tyres(this.tyresSize, this.tyresBrand)));
        wheelList.add(new Wheel(new Tyres(this.tyresSize, this.tyresBrand)));
        wheelList.add(new Wheel(new Tyres(this.tyresSize, this.tyresBrand)));
        wheelList.add(new Wheel(new Tyres(this.tyresSize, this.tyresBrand)));
        car.setWheel(wheelList);
        return car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public String getTyresBrand() {
        return tyresBrand;
    }

    public void setTyresBrand(String tyresBrand) {
        this.tyresBrand = tyresBrand;
    }

    public Double getTyresSize() {
        return tyresSize;
    }

    public void setTyresSize(Double tyresSize) {
        this.tyresSize = tyresSize;
    }

    @Override
    public String toString() {
        return "CarProjection{" +
                "name='" + name + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", engineModel='" + engineModel + '\'' +
                ", tyresBrand='" + tyresBrand + '\'' +
                ", tyresSize=" + tyresSize +
                '}';
    }
}
