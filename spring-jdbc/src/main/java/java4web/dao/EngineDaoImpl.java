package java4web.dao;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EngineDaoImpl implements BaseDao {
    @Override
    public <Engine> Engine find(int id) {
        return null;
    }

    @Override
    public <Engine> void save(Engine type) {

    }
}
