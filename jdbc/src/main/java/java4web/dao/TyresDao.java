package java4web.dao;

import java4web.entity.Tyres;

public interface TyresDao {
    void save(Tyres tyres);
    Tyres findByWheelId(int id);
}
