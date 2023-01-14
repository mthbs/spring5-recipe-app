package guru.springframework.services.map;

import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.services.UnitOfMeasureService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UnitOfMeasureServiceMap extends AbstractMapService<UnitOfMeasure,Long> implements UnitOfMeasureService {

    @Override
    public Set<UnitOfMeasure> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(UnitOfMeasure object) {

    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure object) {
        return null;
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        return super.findById(id);
    }

    @Override
    public UnitOfMeasure findByDescription(String description) {
        return null;
    }
}
