package com.muscatinecode.rapids.services;


import com.muscatinecode.rapids.commands.AllergenCommand;

import com.muscatinecode.rapids.domain.Allergen;

import java.util.List;
import java.util.Set;

/**
 * Created by jt on 6/27/17.
 */
public interface AllergenService {
    public Set<Allergen> listAllAllergen();
    Set<AllergenCommand> listAllAllergensCommands();

    Allergen findById(Long l);

    AllergenCommand findCommandById(Long l);

    AllergenCommand saveAllergenCommand(AllergenCommand command);

    void deleteById(Long idToDelete);
    List<Allergen> findAllByNameLike(String description);










}
