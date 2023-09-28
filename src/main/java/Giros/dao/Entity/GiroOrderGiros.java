package Giros.dao.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "giro_order_giros", schema = "giro-cloud")
public class GiroOrderGiros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "giro_id")
    private Long giroId;

    @Column(name = "giro_order_id")
    private Long giroOrderId;
}
