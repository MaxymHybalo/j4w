package java4web.dao.impl;

import java4web.dao.CarDao;
import java4web.dao.EngineDao;
import java4web.dao.WheelDao;
import java4web.entity.Car;
import java4web.entity.Wheel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CarDaoImpl implements CarDao {

    private DataSource source;
    private JdbcTemplate template;
    private SimpleJdbcInsert insert;
    private EngineDao engineDao;
    private WheelDao wheelDao;

    public CarDaoImpl(DataSource source){
        this.source = source;
        this.template = new JdbcTemplate(source);
        this.engineDao = new EngineDaoImpl(source);
        this.wheelDao = new WheelDaoImpl(source);
        this.insert = new SimpleJdbcInsert(source)
                .withTableName("car")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(Car car) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("name", car.getName());
            int id = insert.executeAndReturnKey(params).intValue();
            car.setId(id);
            car.getEngine().setCarId(id);
            for (Wheel wheel : car.getWheels()) {
                wheel.setCarId(id);
                wheelDao.save(wheel);
            }
            engineDao.save(car.getEngine());
        }catch (Exception e){
            System.out.println("Transaction was rolled back");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @Override
    public Car find(int id) {
        Car car = this.template.queryForObject("select * from car where id = ?",
                new Object[]{id},
                new RowMapper<Car>() {
                    @Override
                    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Car c = new Car();
                        c.setId(rs.getInt("id"));
                        c.setName(rs.getString("name"));
                        c.setEngine(engineDao.findByCarId(id));
                        c.setWheels(wheelDao.findByCarId(id));
                        return c;
                    }
                });
        return car;

    }
}
