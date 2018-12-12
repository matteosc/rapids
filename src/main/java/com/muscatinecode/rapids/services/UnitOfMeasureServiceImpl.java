package com.muscatinecode.rapids.services;

import com.muscatinecode.rapids.commands.UnitOfMeasureCommand;
import com.muscatinecode.rapids.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.muscatinecode.rapids.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.muscatinecode.rapids.domain.UnitOfMeasure;
import com.muscatinecode.rapids.repositories.UnitOfMeasureRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by jt on 6/28/17.
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;
    private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand, UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
        this.unitOfMeasureCommandToUnitOfMeasure = unitOfMeasureCommandToUnitOfMeasure;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                .collect(Collectors.toSet());
    }


    @Override
    public UnitOfMeasure findById(Long l) {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findById(l);



        if (!unitOfMeasureOptional.isPresent()) {
            throw new RuntimeException("uom Not Found!");
        }

        return unitOfMeasureOptional.get();

    }











    @Override
    @Transactional
    public UnitOfMeasureCommand findCommandById(Long l) {

        return unitOfMeasureToUnitOfMeasureCommand.convert(findById(l));


    }

    @Override
    @Transactional
    public UnitOfMeasureCommand saveUnitOfMeasureCommand(UnitOfMeasureCommand command) {
       System.out.println("save in serv "+command.getId());

        UnitOfMeasure detachedUnitOfMeasure = unitOfMeasureCommandToUnitOfMeasure.convert(command);

        UnitOfMeasure savedUnitOfMeasure = unitOfMeasureRepository.save(detachedUnitOfMeasure);
UnitOfMeasureCommand ret=unitOfMeasureToUnitOfMeasureCommand.convert(savedUnitOfMeasure);

        return ret;
    }

    @Override
    public void deleteById(Long idToDelete) {
unitOfMeasureRepository.deleteById(idToDelete);

    }

    @Override
    public List<UnitOfMeasure> findAllByDescriptionLike(String description) {
        return unitOfMeasureRepository.findAllByDescriptionLike(description);
    }
}
