package java4web.dao;


import java4web.entity.Wheel;

import java.util.List;

public interface WheelDao {
    void save(Wheel wheel);
    List<Wheel> findByCarId(int id);
}
