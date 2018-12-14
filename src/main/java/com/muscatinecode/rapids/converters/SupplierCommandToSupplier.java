package com.muscatinecode.rapids.converters;


import com.muscatinecode.rapids.commands.SupplierCommand;
import com.muscatinecode.rapids.domain.Supplier;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class SupplierCommandToSupplier implements Converter<SupplierCommand, Supplier> {
    @Autowired
    private SupplierInvoiceCommandToSupplierInvoice supplierInvoiceConveter;
    @Autowired
    private SupplierOrderCommandToSupplierOrder supplierOrderConveter;
    @Autowired
    private AddressCommandToAddress addressConverter;


    @Synchronized
    @Nullable
    @Override
    public Supplier convert(SupplierCommand source) {
        if (source == null) {
            return null;
        }

        final Supplier supplier = new Supplier();
        supplier.setId(source.getId());

        supplier.setName(source.getName());
        supplier.setSocialSecurityNumber(source.getSocialSecurityNumber());
        supplier.setTelephone(source.getTelephone());
        supplier.setVatNumber(source.getVatNumber());
        supplier.setWebSite(source.getWebSite());
        supplier.setAddress(addressConverter.convert(source.getAddress()));

/*
        private Set<SupplierOrderCommand> supplierOrders = new HashSet<>();



        private Set<SupplierInvoiceCommand> supplierInvoices = new HashSet<>();
*/

        if (source.getSupplierInvoices() != null && source.getSupplierInvoices().size() > 0) {
            source.getSupplierInvoices()
                    .forEach(invoice -> supplier.getSupplierInvoices().add(supplierInvoiceConveter.convert(invoice)));
        }

        if (source.getSupplierOrders() != null && source.getSupplierOrders().size() > 0) {
            source.getSupplierOrders()
                    .forEach(supplierOrder -> supplier.getSupplierOrders().add(supplierOrderConveter.convert(supplierOrder)));
        }

        return supplier;
    }
}
