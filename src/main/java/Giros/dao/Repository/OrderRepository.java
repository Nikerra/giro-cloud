package Giros.dao.Repository;

import Giros.dao.Entity.GiroOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<GiroOrder, Long> {
}
