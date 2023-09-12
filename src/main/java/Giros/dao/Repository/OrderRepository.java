package Giros.dao.Repository;

import Giros.dao.Entity.GiroOrder;

public interface OrderRepository {
    GiroOrder save(GiroOrder order);
}
