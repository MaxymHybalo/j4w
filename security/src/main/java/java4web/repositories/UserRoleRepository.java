package java4web.repositories;

import java4web.entity.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Long>{

    @Query("select a.role from java4web.entity.UserRole a, java4web.entity.User b where b.name=?1 and b.id = a.userId")
    String findRoleByUserName(String name);

}
