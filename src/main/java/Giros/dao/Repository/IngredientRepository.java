package Giros.dao.Repository;

import Giros.dao.Entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
