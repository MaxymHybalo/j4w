package java4web.dao;

import java4web.entity.Engine;

public interface EngineDao {
    void save(Engine engine);
    Engine findByCarId(int id);
}
