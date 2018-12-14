package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.SupplierInvoiceCommand;
import com.muscatinecode.rapids.domain.Category;
import com.muscatinecode.rapids.domain.SupplierInvoice;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class SupplierInvoiceToSupplierInvoiceCommand implements Converter<SupplierInvoice, SupplierInvoiceCommand>{
 @Autowired private  SupplierOrderToSupplierOrderCommand supOrdConverer;
  @Autowired  private  SupplierToSupplierCommand supConverer;


    @Synchronized
    @Nullable
    @Override
    public SupplierInvoiceCommand convert(SupplierInvoice source) {
        if (source == null) {
            return null;
        }

        final SupplierInvoiceCommand command = new SupplierInvoiceCommand();
        command.setId(source.getId());
        command.setInternalNumber(source.getInternalNumber());
        command.setInvoiceNumber(source.getInvoiceNumber());
        command.setOrder(supOrdConverer.convert(source.getOrder()));
        command.setPurchaseDate(source.getPurchaseDate());
        command.setSupplier(supConverer.convert(source.getSupplier()));
        command.setTotal(source.getTotal());
        command.setTotalWithVat(source.getTotalWithVat());
        command.setVat(source.getVat());



        return command;
    }
}
