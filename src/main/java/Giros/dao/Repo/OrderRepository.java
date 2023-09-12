package Giros.dao.Repo;

import Giros.dao.Entity.GiroOrder;

public interface OrderRepository {
    GiroOrder save(GiroOrder order);
}
