package Giros.dao.Entity;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "ingredient_ref", schema = "giro-cloud")
public class IngredientRef {

    private final String ingredient;
}
