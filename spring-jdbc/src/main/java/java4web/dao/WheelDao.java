package java4web.dao;

import java4web.entity.Wheel;

import java.util.List;

public interface WheelDao extends BaseDao{
    List<Wheel> getByCarId(int id);
}
