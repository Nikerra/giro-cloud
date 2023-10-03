package Giros.dao.Repository;

import Giros.dao.Entity.GiroOrder;

import Giros.dao.Entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<GiroOrder, Long> {


}
