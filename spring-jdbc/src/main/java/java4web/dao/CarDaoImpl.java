package java4web.dao;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CarDaoImpl implements BaseDao {


    @Override
    public <Car> Car find(int id) {
        return null;
    }

    @Override
    public <Car> void save(Car type) {

    }
}
