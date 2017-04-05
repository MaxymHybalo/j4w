package java4web.dao.impl;

import java4web.dao.EngineDao;
import java4web.entity.Engine;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EngineDaoImpl implements EngineDao {

    private DataSource source;
    private SimpleJdbcInsert insert;
    private JdbcTemplate template;

    public EngineDaoImpl(DataSource source){
        this.source = source;
        this.template = new JdbcTemplate(source);
        this.insert = new SimpleJdbcInsert(source)
                .withTableName("engine")
                .usingGeneratedKeyColumns("id");
    }
    @Override
    public void save(Engine engine) {
        Map<String, Object> params = new HashMap<>();
        params.put("capacity", engine.getCapacity());
        params.put("car_id", engine.getCarId());
        Integer id = insert.executeAndReturnKey(params).intValue();
        engine.setId(id);
    }

    @Override
    public Engine findByCarId(int id) {
        Engine engine = this.template.queryForObject("select * from engine where car_id = ?",
                new Object[]{id},
                new RowMapper<Engine>() {
                    @Override
                    public Engine mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Engine e = new Engine();
                        e.setId(rs.getInt("id"));
                        e.setCapacity(rs.getDouble("capacity"));
                        e.setCarId(rs.getInt("car_id"));
                        return e;
                    }
                });
        return engine;
    }
}
