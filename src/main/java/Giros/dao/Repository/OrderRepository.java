package Giros.dao.Repository;

import Giros.dao.Entity.GiroOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<GiroOrder, UUID> {
}
