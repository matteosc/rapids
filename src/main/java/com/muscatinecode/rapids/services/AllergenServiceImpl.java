package com.muscatinecode.rapids.services;

import com.muscatinecode.rapids.commands.AllergenCommand;
import com.muscatinecode.rapids.converters.AllergenCommandToAllergen;
import com.muscatinecode.rapids.converters.AllergenToAllergenCommand;
import com.muscatinecode.rapids.domain.Allergen;
import com.muscatinecode.rapids.repositories.AllergenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class AllergenServiceImpl implements AllergenService {
    private final AllergenRepository allergenRepository;
private final AllergenToAllergenCommand allergenToAllergenCommand;
    private final AllergenCommandToAllergen allergenCommandToAllergen;
    public AllergenServiceImpl(AllergenRepository allergenRepository, AllergenToAllergenCommand allergenToAllergenCommand, AllergenCommandToAllergen allergenCommandToAllergen) {
        this.allergenRepository = allergenRepository;
        this.allergenToAllergenCommand = allergenToAllergenCommand;
        this.allergenCommandToAllergen = allergenCommandToAllergen;
    }



    @Override
    public Set<AllergenCommand> listAllAllergensCommands() {
        return StreamSupport.stream(allergenRepository.findAll()
                .spliterator(), false)
                .map(allergenToAllergenCommand::convert)
                .collect(Collectors.toSet());
    }


    @Override
    public Allergen findById(Long l) {
        Optional<Allergen> allergenOptional = allergenRepository.findById(l);



        if (!allergenOptional.isPresent()) {
            throw new RuntimeException("uom Not Found!");
        }

        return allergenOptional.get();


    }


    @Override
    @Transactional
    public AllergenCommand findCommandById(Long l) {

        return allergenToAllergenCommand.convert(findById(l));
    }

    @Override
    @Transactional
    public AllergenCommand saveAllergenCommand(AllergenCommand command) {


        Allergen detachedAllergen = allergenCommandToAllergen.convert(command);

        Allergen savedAllergen = allergenRepository.save(detachedAllergen);
        AllergenCommand ret=allergenToAllergenCommand.convert(savedAllergen);

        return ret;
    }
    @Override
    public void deleteById(Long idToDelete) {
allergenRepository.deleteById(idToDelete);
    }

    @Override
    public List<Allergen> findAllByNameLike(String description) {
        return null;
    }
}
