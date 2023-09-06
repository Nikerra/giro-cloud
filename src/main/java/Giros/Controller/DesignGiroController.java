package Giros.Controller;

import Giros.dao.Entity.Giro;
import Giros.dao.Entity.GiroOrder;
import Giros.dao.Entity.Ingredient;
import Giros.dao.Entity.Ingredient.Type;
import Giros.dao.Repo.IngredientRepository;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
@Controller
@RequestMapping("/design")
@SessionAttributes("giroOrder")
public class DesignGiroController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignGiroController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {

        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

    }

    @ModelAttribute(name="giroOrder")
    public GiroOrder order(){
        return new GiroOrder();
    }

    @ModelAttribute(name="giro")
    public Giro giro(){
        return new Giro();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    @PostMapping
    public String processGiro(@Valid Giro giro, Errors errors, @ModelAttribute GiroOrder giroOrder) {

        if (errors.hasErrors()) {
            return "design";
        }

        giroOrder.addGiro(giro);
        log.info("Processing giro: {}", giro);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
        return ((List<Ingredient>) ingredients)
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
