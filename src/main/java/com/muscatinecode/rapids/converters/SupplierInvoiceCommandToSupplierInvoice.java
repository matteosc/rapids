package com.muscatinecode.rapids.converters;


import com.muscatinecode.rapids.commands.SupplierInvoiceCommand;
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
public class SupplierInvoiceCommandToSupplierInvoice implements Converter<SupplierInvoiceCommand, SupplierInvoice> {

    @Autowired
    private SupplierCommandToSupplier suppConverter;
    @Autowired
    private SupplierOrderCommandToSupplierOrder suppOrderConverter;
    @Autowired
    private SupplierInvoiceRowCommandToSupplierInvoiceRow rowConverter;


    @Synchronized
    @Nullable
    @Override
    public SupplierInvoice convert(SupplierInvoiceCommand source) {
        if (source == null) {
            return null;
        }

        final SupplierInvoice supplierInvoice = new SupplierInvoice();
        supplierInvoice.setId(source.getId());
        supplierInvoice.setInternalNumber(source.getInternalNumber());
        supplierInvoice.setInvoiceNumber(source.getInvoiceNumber());
        supplierInvoice.setOrder(suppOrderConverter.convert(source.getOrder()));
        supplierInvoice.setPurchaseDate(source.getPurchaseDate());

        supplierInvoice.setSupplier(suppConverter.convert(source.getSupplier()));
        supplierInvoice.setTotal(source.getTotal());
        supplierInvoice.setTotalWithVat(source.getTotalWithVat());
        supplierInvoice.setVat(source.getVat());


        if (source.getRows() != null && source.getRows().size() > 0) {
            source.getRows()
                    .forEach(row -> supplierInvoice.getRows().add(rowConverter.convert(row)));
        }


        return supplierInvoice;
    }
}
