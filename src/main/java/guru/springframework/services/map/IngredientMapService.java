package guru.springframework.services.map;

import guru.springframework.domain.Ingredient;
import guru.springframework.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class IngredientMapService extends AbstractMapService<Ingredient,Long> implements IngredientService {

    @Override
    public Set<Ingredient> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Ingredient object) {

    }

    @Override
    public Ingredient save(Ingredient object) {
        return null;
    }

    @Override
    public Ingredient findById(Long id) {
        return super.findById(id);
    }
}
