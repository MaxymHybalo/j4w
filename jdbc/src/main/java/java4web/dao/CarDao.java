package java4web.dao;

import java4web.entity.Car;

public interface CarDao {
    void save(Car car);
    Car find(int id);
}
