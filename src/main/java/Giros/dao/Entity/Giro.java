package Giros.dao.Entity;

import lombok.Data;

import java.util.List;

@Data
public class Giro {
    private String name;
    private List<Ingredient> ingredients;
}
