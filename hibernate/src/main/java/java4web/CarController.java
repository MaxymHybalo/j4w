package java4web;

import java4web.entity.Car;
import java4web.entity.Tyres;
import java4web.entity.Wheel;
import java4web.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService service;

    @GetMapping("/car")
    public Car car(){
        Car car = new Car();
        car.setName("BMW");
        List<Wheel> wheels = new ArrayList<>();
        wheels.add(new Wheel(new Tyres(15d, "Stock")));
        wheels.add(new Wheel(new Tyres(15d, "Stock")));
        wheels.add(new Wheel(new Tyres(15d, "Stock")));
        wheels.add(new Wheel(new Tyres(15d, "Stock")));
        car.setWheel(wheels);
        service.save(car);
        return car;
    }

    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable int id){
        return service.find(id);
    }

}
