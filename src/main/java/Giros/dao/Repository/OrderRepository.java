package Giros.dao.Repository;

import Giros.dao.Entity.GiroOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<GiroOrder, Long> {
}
