package Giros.dao.Entity;


import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("ingredients")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Ingredient{

    @PrimaryKey
    private final String id;

    private final String name;

    private final Type type;


    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
