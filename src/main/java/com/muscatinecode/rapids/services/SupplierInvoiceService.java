package com.muscatinecode.rapids.services;


import com.muscatinecode.rapids.commands.SupplierCommand;
import com.muscatinecode.rapids.commands.SupplierInvoiceCommand;
import com.muscatinecode.rapids.domain.Supplier;
import com.muscatinecode.rapids.domain.SupplierInvoice;

import java.util.List;
import java.util.Set;

/**
 * Created by jt on 6/27/17.
 */

public interface SupplierInvoiceService {
     Set<SupplierInvoice> listAllSupplierInvoice();
      Set<SupplierInvoiceCommand> listAllSuppliersInvoiceCommands();

    SupplierInvoice findById(Long l);

SupplierInvoiceCommand findCommandById(Long l);

    SupplierInvoiceCommand saveSupplierInvoiceCommand(SupplierInvoiceCommand command);

    void deleteById(Long idToDelete);
    List<SupplierInvoice> findAllByNameLike(String description);







}
