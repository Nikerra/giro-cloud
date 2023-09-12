package Giros.Service;

import Giros.dao.Entity.Giro;
import Giros.dao.Entity.GiroOrder;
import Giros.dao.Entity.IngredientRef;
import Giros.dao.Repo.OrderRepository;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public GiroOrder save(GiroOrder order) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into Giro_Order "
                + "(delivery_name, delivery_street, delivery_city, " +
                        "cc_number, cc_expiration, cc_cvv, placed_at) " +
                        "values (?,?,?,?,?,?,?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);

        order.setPlacedAt(new Date());
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        order.getDeliveryName(),
                        order.getDeliveryStreet(),
                        order.getDeliveryCity(),
                        order.getCcNumber(),
                        order.getCcExpiration(),
                        order.getCcCVV(),
                        order.getPlacedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);

        List<Giro> giros = order.getGiros();
        int i =0;
        for (Giro giro : giros) {
            saveGiro(orderId, i++, giro);
        }
        return order;
    }

    private long saveGiro(long orderId, int orderKey, Giro giro) {

        giro.setCreateAt(new Date());
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert  into Giro " +
                        "(name, created_at, giro_order, giro_order_key) " +
                        "values (?,?,?,?)",
                Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG
        );
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        giro.getName(),
                        giro.getCreateAt(),
                        orderId,
                        orderKey));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long giroId = keyHolder.getKey().longValue();
        giro.setId(giroId);

        saveIngredientRefs(giroId, giro.getIngredients());

        return giroId;
    }

    private void saveIngredientRefs(long giroId, List<IngredientRef> ingredientRefs) {
        int key = 0;
        for (IngredientRef ingredientRef : ingredientRefs) {
            jdbcOperations.update(
                    "insert into Ingredient_Ref (ingredient, giro, giro_key) " +
                            "values (?,?,?)",
                    ingredientRef.getIngredient(), giroId, key++);
        }
    }
}
