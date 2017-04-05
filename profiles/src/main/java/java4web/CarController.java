package java4web;

import java4web.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    public Car car;

    @GetMapping("/")
    public Car testCar(){
        return car;
    }

}
