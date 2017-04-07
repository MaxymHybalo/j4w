package java4web.repositories;

import java4web.entity.Tyres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TyresRepository extends CrudRepository<Tyres, Integer>{
}
