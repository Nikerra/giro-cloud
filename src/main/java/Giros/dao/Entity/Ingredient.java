package Giros.dao.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Table(name = "ingredient", schema = "giro-cloud")
public class Ingredient {

    @Id
    private final String id;

    @Column(name = "name")
    private final String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private final Type type;


    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
