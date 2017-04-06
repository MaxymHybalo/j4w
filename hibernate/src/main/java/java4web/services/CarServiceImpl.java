package java4web.services;

import java4web.entity.Car;
import java4web.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    public CarRepository repository;

    @Override
    public void save(Car car) {
        repository.save(car);
    }

    @Override
    public Car find(int id) {
        return repository.findOne(id);
    }
}
