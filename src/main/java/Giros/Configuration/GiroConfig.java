package Giros.Configuration;

import Giros.dao.Entity.Ingredient;
import Giros.dao.Entity.Ingredient.Type;
import Giros.dao.Repository.IngredientRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GiroConfig {

    @Bean
    public ApplicationRunner dataLoader(IngredientRepository repository) {
        return args -> {
            repository.save(new Ingredient("FLPI", "Flour Pita", Type.WRAP));
            repository.save(new Ingredient("COPI", "Corn Pita", Type.WRAP));
            repository.save(new Ingredient("GRCH", "Ground Chicken", Type.PROTEIN));
            repository.save(new Ingredient("CHIC", "Chicken", Type.PROTEIN));
            repository.save(new Ingredient("SLTO", "Sliced Tomatoes", Type.VEGGIES));
            repository.save(new Ingredient("SLCU", "Sliced Cucumber", Type.VEGGIES));
            repository.save(new Ingredient("BRCH", "Brynza cheese", Type.CHEESE));
            repository.save(new Ingredient("PACH", "Parmesan cheese", Type.CHEESE));
            repository.save(new Ingredient("SOCR", "Sour Cream", Type.SAUCE));
            repository.save(new Ingredient("TZSA", "Tzatziki sauce", Type.SAUCE));
        };
    }
}
