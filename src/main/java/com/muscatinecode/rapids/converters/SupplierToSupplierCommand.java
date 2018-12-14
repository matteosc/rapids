package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.SupplierCommand;
import com.muscatinecode.rapids.domain.Supplier;
import com.muscatinecode.rapids.domain.SupplierInvoice;
import com.muscatinecode.rapids.domain.SupplierOrder;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class SupplierToSupplierCommand implements Converter<Supplier, SupplierCommand>{
@Autowired private  AddressToAddressCommand addConv;
   @Autowired private  SupplierInvoiceToSupplierInvoiceCommand invConveter;
 @Autowired   private  SupplierOrderToSupplierOrderCommand   ordConveter;


    @Synchronized
    @Nullable
    @Override
    public SupplierCommand convert(Supplier source) {
        if (source == null) {
            return null;
        }

        final SupplierCommand command = new SupplierCommand();
        command.setId(source.getId());
        command.setAddress(addConv.convert(source.getAddress()));
        command.setName(source.getName());
        command.setSocialSecurityNumber(source.getSocialSecurityNumber());
        command.setTelephone(source.getTelephone());
        command.setVatNumber(source.getVatNumber());
        command.setWebSite(source.getWebSite());


        if (source.getSupplierInvoices() != null && source.getSupplierInvoices().size() > 0){
            source.getSupplierInvoices()
                    .forEach((SupplierInvoice invoice) -> command.getSupplierInvoices().add(invConveter.convert(invoice)));
        }


        if (source.getSupplierOrders() != null && source.getSupplierOrders().size() > 0){
            source.getSupplierOrders()
                    .forEach((SupplierOrder order) -> command.getSupplierOrders().add(ordConveter.convert(order)));
        }



        return command;
    }
}
