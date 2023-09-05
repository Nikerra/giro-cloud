package Giros.Convertor;

import Giros.dao.Entity.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConvertor implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConvertor() {
        ingredientMap.put("FLPI",new Ingredient("FLPI", "Flour Pita", Ingredient.Type.WRAP));
        ingredientMap.put("COPI",new Ingredient("COPI", "Corn Pita", Ingredient.Type.WRAP));
        ingredientMap.put("GRCH",new Ingredient("GRCH", "Ground Chicken", Ingredient.Type.PROTEIN));
        ingredientMap.put("CHIC",new Ingredient("CHIC", "Chicken", Ingredient.Type.PROTEIN));
        ingredientMap.put("SLTO",new Ingredient("SLTO", "Sliced Tomatoes", Ingredient.Type.VEGGIES));
        ingredientMap.put("SLCU",new Ingredient("SLCU", "Sliced Cucumber", Ingredient.Type.VEGGIES));
        ingredientMap.put("BRCH",new Ingredient("BRCH", "Brynza cheese", Ingredient.Type.CHEESE));
        ingredientMap.put("PACH",new Ingredient("PACH", "Parmesan cheese", Ingredient.Type.CHEESE));
        ingredientMap.put("SOCR",new Ingredient("SOCR", "Sour Cream", Ingredient.Type.SAUCE));
        ingredientMap.put("TZSA",new Ingredient("TZSA", "Tzatziki sauce", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }

}
