package java4web.services;

import java4web.entity.Car;

import java.util.List;

public interface CarService {

    void save(Car car);

    Car find(int id);

    List<Car>  findAll();

    void delete(int id);

}
