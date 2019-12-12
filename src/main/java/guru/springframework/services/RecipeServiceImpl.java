package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining((recipeSet::add));
        log.debug("getRecipes requested...");
        return recipeSet;
    }

    @Override
    public Recipe findById(Long l){
        Optional<Recipe> optionalRecipe = recipeRepository.findById(l);
        if (optionalRecipe.isPresent()){
            return optionalRecipe.get();
        }
        throw new RuntimeException("Recipe Not Found!");
    }
}
