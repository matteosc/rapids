package com.muscatinecode.rapids.repositories;

import com.muscatinecode.rapids.domain.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AllergenRepository extends CrudRepository<Allergen,Long> {
}
