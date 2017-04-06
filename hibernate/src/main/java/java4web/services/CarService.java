package java4web.services;

import java4web.entity.Car;

public interface CarService {

    void save(Car car);

    Car find(int id);

}
