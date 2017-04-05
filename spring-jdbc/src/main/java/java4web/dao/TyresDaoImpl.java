package java4web.dao;

import java4web.entity.Tyres;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TyresDaoImpl implements BaseDao {

    private JdbcTemplate template;
    private DataSource source;
    private SimpleJdbcInsert insert;

    @Autowired
    public TyresDaoImpl(DataSource source){
        this.source = source;
        this.template = new JdbcTemplate(source);
        this.insert = new SimpleJdbcInsert(source)
                .withTableName("tyres")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public <T> T find(int id) {
        return null;
    }

    @Override
    public <T> void save(T type) {
        Tyres tyres = (Tyres) type;
        
    }
}
