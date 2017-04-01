package java4web.dao.impl;

import java4web.dao.TyresDao;
import java4web.entity.Tyres;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TyresDaoImpl implements TyresDao {

    private DataSource source;
    private JdbcTemplate template;
    private SimpleJdbcInsert insert;

    public TyresDaoImpl(DataSource source){
        this.source = source;
        this.template = new JdbcTemplate(source);
        this.insert = new SimpleJdbcInsert(source)
                .withTableName("tyres")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(Tyres tyres) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", tyres.getName());
        params.put("size", tyres.getSize());
        params.put("wheel_id", tyres.getWheelId());
        Integer id = insert.executeAndReturnKey(params).intValue();
        tyres.setId(id);
    }

    @Override
    public Tyres findByWheelId(int id) {
        Tyres tyres = this.template.queryForObject(
                "select * from tyres where wheel_id = ?",
                new Object[]{id},
                new RowMapper<Tyres>() {
                    @Override
                    public Tyres mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Tyres t = new Tyres();
                        t.setId(rs.getInt("id"));
                        t.setSize(rs.getDouble("size"));
                        t.setName(rs.getString("name"));
                        t.setWheelId(rs.getInt("wheel_id"));
                        return t;
                    }
                }
        );
        return tyres;
    }
}
