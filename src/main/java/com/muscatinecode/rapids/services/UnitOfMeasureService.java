package com.muscatinecode.rapids.services;


import com.muscatinecode.rapids.commands.UnitOfMeasureCommand;
import com.muscatinecode.rapids.domain.UnitOfMeasure;

import java.util.Set;

/**
 * Created by jt on 6/28/17.
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();

    UnitOfMeasure findById(Long l);

    UnitOfMeasureCommand findCommandById(Long l);

    UnitOfMeasureCommand saveUnitOfMeasureCommand(UnitOfMeasureCommand command);

    void deleteById(Long idToDelete);
}
