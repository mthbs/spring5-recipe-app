package guru.springframework.bootstrap;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.IngredientRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.IngredientService;
import guru.springframework.services.RecipeService;
import guru.springframework.services.UnitOfMeasureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(
            RecipeService recipeService,
            IngredientService ingredientService,
            UnitOfMeasureService unitOfMeasureService,
            RecipeRepository recipeRepository, IngredientRepository ingredientRepository, UnitOfMeasureRepository unitOfMeasureRepository
    ) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n----DATALOADER----\n\n");

        UnitOfMeasure unit_null = new UnitOfMeasure();
        unit_null.setDescription("null");
        unitOfMeasureRepository.save(unit_null);

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        Optional<UnitOfMeasure> pinch = unitOfMeasureRepository.findByDescription("Pinch");
        Optional<UnitOfMeasure> ripe = unitOfMeasureRepository.findByDescription("Ripe");
        Optional<UnitOfMeasure> piece = unitOfMeasureRepository.findByDescription("Piece");
        Optional<UnitOfMeasure> aPackage = unitOfMeasureRepository.findByDescription("Package");


        Recipe guacamole = new Recipe();
        guacamole.setDescription("The word \"guacamole\" and the dip, are both originally from Mexico, where avocados have been cultivated for thousands of years. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(10);
        guacamole.setServings(2);
        guacamole.setSource("Simply-Resources");
        guacamole.setUrl("guacamole/index.html");
        guacamole.setDirections("vegan");

        // All ingredients
        Set<Ingredient> guacamoleIngredients = new HashSet<>();

        Ingredient avocado = new Ingredient();
        avocado.setDescription("ripe avocados");
        avocado.setAmount(new BigDecimal(2));
        avocado.setUom(piece.orElse(unit_null));
//        Ingredient savedAvocado = ingredientService.save(avocado);
        guacamoleIngredients.add(avocado);

        Ingredient salt = new Ingredient();
        salt.setDescription("kosher salt");
        salt.setAmount(new BigDecimal(0.5));
        salt.setUom(teaspoon.orElse(unit_null));
//        Ingredient savedSalt = ingredientService.save(salt);
        guacamoleIngredients.add(salt);

        Ingredient juice = new Ingredient();
        juice.setDescription("lime juice or lemon juice");
        juice.setAmount(new BigDecimal(1));
        juice.setUom(tablespoon.orElse(unit_null));
//        Ingredient savedJuice = ingredientService.save(juice);
        guacamoleIngredients.add(juice);

        Ingredient onion = new Ingredient();
        onion.setDescription("minced red onion or thnly sliced green onion");
        onion.setAmount(new BigDecimal(2));
        onion.setUom(tablespoon.orElse(unit_null));
//        Ingredient savedOnion = ingredientService.save(onion);
        guacamoleIngredients.add(onion);

        Ingredient chile = new Ingredient();
        chile.setDescription("serrano chile, stems and seeds removed, minced");
        chile.setAmount(new BigDecimal(1.5));
        chile.setUom(piece.orElse(unit_null));
//        Ingredient savedChile = ingredientService.save(chile);
        guacamoleIngredients.add(chile);

        Ingredient cilantro = new Ingredient();
        cilantro.setDescription("cilantro, finely chopped");
        cilantro.setAmount(new BigDecimal(2));
        cilantro.setUom(tablespoon.orElse(unit_null));
//        Ingredient savedCilantro = ingredientService.save(cilantro);
        guacamoleIngredients.add(cilantro);

        Ingredient pepper = new Ingredient();
        pepper.setDescription("freshly grated black pepper");
        pepper.setAmount(new BigDecimal(1));
        pepper.setUom(pinch.orElse(unit_null));
//        Ingredient savedPepper = ingredientService.save(pepper);
        guacamoleIngredients.add(pepper);

        Ingredient tomato = new Ingredient();
        tomato.setDescription("ripe tomato, seeds and pulp removed, chopped");
        tomato.setAmount(new BigDecimal(0.5));
        tomato.setUom(piece.orElse(unit_null));
//        Ingredient savedTomato = ingredientService.save(tomato);
        guacamoleIngredients.add(tomato);

        guacamole.setIngredients(guacamoleIngredients);

        recipeRepository.save(guacamole);

        avocado.setRecipe(guacamole);
        salt.setRecipe(guacamole);
        juice.setRecipe(guacamole);
        onion.setRecipe(guacamole);
        chile.setRecipe(guacamole);
        cilantro.setRecipe(guacamole);
        pepper.setRecipe(guacamole);
        tomato.setRecipe(guacamole);

        ingredientRepository.save(avocado);
        ingredientRepository.save(salt);
        ingredientRepository.save(juice);
        ingredientRepository.save(onion);
        ingredientRepository.save(chile);
        ingredientRepository.save(cilantro);
        ingredientRepository.save(pepper);
        ingredientRepository.save(tomato);

    }
}
