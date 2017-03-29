package java4web.dao;

public interface BaseDao {

    <T> T find(int id);

    <T> void save(T type);

}
