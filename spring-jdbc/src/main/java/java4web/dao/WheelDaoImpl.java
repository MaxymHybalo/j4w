package java4web.dao;

import java4web.entity.Wheel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class WheelDaoImpl implements WheelDao {
    @Override
    public <T> T find(int id) {
        return null;
    }

    @Override
    public <Wheel> void save(Wheel type) {

    }

    @Override
    public List<Wheel> getByCarId(int id) {
        return null;
    }
}
