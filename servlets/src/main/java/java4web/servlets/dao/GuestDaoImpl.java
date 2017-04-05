package java4web.servlets.dao;

import java4web.servlets.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GuestDaoImpl implements GuestDao {

    private DataSource source;
    private JdbcTemplate template;
    private SimpleJdbcInsert insert;

    public GuestDaoImpl(DataSource source){
        this.source = source;
        this.template = new JdbcTemplate(source);
        this.insert = new SimpleJdbcInsert(source)
                .withTableName("guest")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(Guest guest) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("name", guest.getName());
            params.put("message", guest.getMessage());
            params.put("rating", guest.getRating());
            int id = insert.executeAndReturnKey(params).intValue();
            guest.setId(id);
            System.out.println("New guest successful add");
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public Guest find(int id) {
        return null;
    }

    @Override
    public List<Guest> findAll() {
        List<Guest> guests = template.query(
                "select * from guest",
                new RowMapper<Guest>() {
                    @Override
                    public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Guest g = new Guest();
                        g.setId(rs.getInt("id"));
                        g.setName(rs.getString("name"));
                        g.setMessage(rs.getString("message"));
                        g.setRating(rs.getInt("rating"));
                        return g;
                    }
                });
        return guests;
    }
}
