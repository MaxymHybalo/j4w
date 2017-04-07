package java4web.services;

import java4web.entity.Car;
import java4web.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Override
    public List<Car> findAll() {
        Iterator<Car> iterator = repository.findAll().iterator();
        List<Car> cars = new ArrayList<>();
        while (iterator.hasNext()){
            cars.add(iterator.next());
        }
        return cars;
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }


}
