package com.muscatinecode.rapids.repositories;


import com.muscatinecode.rapids.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
    List<UnitOfMeasure> findAllByDescriptionLike(String description);
}
