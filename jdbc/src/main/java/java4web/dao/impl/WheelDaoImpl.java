package java4web.dao.impl;

import java4web.dao.WheelDao;
import java4web.entity.Wheel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WheelDaoImpl implements WheelDao {

    private DataSource source;
    private JdbcTemplate template;
    private TyresDaoImpl tyresDao;
    private SimpleJdbcInsert insert;


    public WheelDaoImpl(DataSource source){
        this.source = source;
        this.template = new JdbcTemplate(source);
        this.tyresDao = new TyresDaoImpl(source);
        this.insert = new SimpleJdbcInsert(source)
                .withTableName("wheel")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(Wheel wheel) {
        Map<String, Object> params = new HashMap<>();
        params.put("car_id", wheel.getCarId());
        wheel.getTyres().getWheelId();
        Integer id = insert.executeAndReturnKey(params).intValue();
        wheel.getTyres().setWheelId(id);
        tyresDao.save(wheel.getTyres());
    }

    @Override
    public List<Wheel> findByCarId(int id) {
        List<Wheel> wheels = this.template
                .query(
                        "select * from wheel where car_id = ?",
                        new Object[]{id},
                        new RowMapper<Wheel>() {
                            @Override
                            public Wheel mapRow(ResultSet rs, int rowNum) throws SQLException {
                                Wheel w = new Wheel();
                                w.setId(rs.getInt("id"));
                                w.setCarId(rs.getInt("car_id"));
                                w.setTyres(tyresDao.findByWheelId(w.getId()));
                                return w;
                            }
                        }
                );
        return wheels;
    }
}
