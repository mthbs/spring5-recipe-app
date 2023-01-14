package guru.springframework.services.map;

import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.services.RecipeService;
import guru.springframework.services.UnitOfMeasureService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class RecipeMapService extends AbstractMapService<Recipe,Long> implements RecipeService {

    @Override
    public Set<Recipe> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Recipe save(Recipe object) {
        return null;
    }

    @Override
    public void delete(Recipe object) {

    }

    @Override
    public Recipe findById(Long id) {
        return super.findById(id);
    }
}
