package Giros.dao.Repository;

import Giros.dao.Entity.GiroOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<GiroOrder, UUID> {
}
