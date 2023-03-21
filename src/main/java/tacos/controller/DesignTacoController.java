package tacos.controller;


import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import tacos.entity.Ingredient;
import tacos.entity.Ingredient.Type;
import tacos.entity.Taco;
import tacos.entity.TacoOrder;
import tacos.repository.IngredientRepository;


/*@Slf4j a Lombok-provided annotation that, at compilation time,
 will automatically generate an SLF4J (Simple Logging Facade for Java)
 This is the same effect:
 private static final org.slf4j.Logger log =
 org.slf4j.LoggerFactory.getLogger(DesignTacoController.class)*/
@Slf4j
@Controller
@RequestMapping(path = "/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
    private final IngredientRepository ingredientRepository;
    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }
    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, TacoOrder tacoOrder) {

        if (errors.hasErrors()) {
            for(FieldError fieldError : errors.getFieldErrors())
                log.error("Validation error: "+ fieldError.getField());
            return "design";
        }

        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(Model model) {
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")
    public Taco taco(Model model) {
        return new Taco();
    }
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType((List<Ingredient>) ingredients, type));
        }
        //Or this type of code...
        /*Arrays.stream(Type.values())
                .forEach(type -> model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type)));*/
    }
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
