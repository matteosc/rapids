package com.muscatinecode.rapids.services;


import com.muscatinecode.rapids.commands.SupplierCommand;
import com.muscatinecode.rapids.commands.SupplierCommand;
import com.muscatinecode.rapids.domain.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by jt on 6/27/17.
 */

public interface SupplierService {
     Set<Supplier> listAllSuppliers();
      Set<SupplierCommand> listAllSuppliersCommands();

    Supplier findById(Long l);

SupplierCommand findCommandById(Long l);

    SupplierCommand saveSupplierCommand(SupplierCommand command);

    void deleteById(Long idToDelete);
    List<Supplier> findAllByNameLike(String description);







}
