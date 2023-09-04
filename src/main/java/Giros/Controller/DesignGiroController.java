package Giros.Controller;

import Giros.dao.Entity.Giro;
import Giros.dao.Entity.GiroOrder;
import Giros.dao.Entity.Ingredient;
import Giros.dao.Entity.Ingredient.Type;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
@Controller
@RequestMapping("/design")
@SessionAttributes("giroOrder")
public class DesignGiroController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLPI", "Flour Pita", Type.WRAP),
                new Ingredient("COPI", "Corn Pita", Type.WRAP),
                new Ingredient("GRCH", "Ground Chicken", Type.PROTEIN),
                new Ingredient("CHIC", "Chicken", Type.PROTEIN),
                new Ingredient("SLTO", "Sliced Tomatoes", Type.VEGGIES),
                new Ingredient("SLCU", "Sliced Cucumber", Type.VEGGIES),
                new Ingredient("BRCH", "Brynza cheese", Type.CHEESE),
                new Ingredient("PACH", "Parmesan cheese", Type.CHEESE),
                new Ingredient("SOCR", "Sour Cream", Type.SAUCE),
                new Ingredient("TZSA", "Tzatziki sauce", Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for(Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
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

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
