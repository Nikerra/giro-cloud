package Giros.dao.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "role", schema = "giro-cloud")
public class Role {

    @Id
    private Long id;
    private String name;
}
