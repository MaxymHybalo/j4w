package java4web.repositories;

import java4web.entity.Wheel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface WheelRepository extends CrudRepository<Wheel, Integer>{
}
