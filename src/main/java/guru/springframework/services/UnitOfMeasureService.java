package guru.springframework.services;

import guru.springframework.domain.UnitOfMeasure;


public interface UnitOfMeasureService extends CrudService<UnitOfMeasure, Long> {
    public UnitOfMeasure findByDescription(String description);
}
