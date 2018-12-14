package com.muscatinecode.rapids.converters;


import com.muscatinecode.rapids.commands.SupplierInvoiceRowCommand;
import com.muscatinecode.rapids.domain.SupplierInvoiceRow;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class SupplierInvoiceRowCommandToSupplierInvoiceRow
        implements Converter<SupplierInvoiceRowCommand, SupplierInvoiceRow> {
@Autowired
private  SupplierInvoiceCommandToSupplierInvoice suppConv;
@Autowired
private  ProductCommandToProduct prodConv;
@Autowired
private  StockMovimentCommandToStockMoviment stockConv;


    @Synchronized
    @Nullable
    @Override
    public SupplierInvoiceRow convert(SupplierInvoiceRowCommand source) {
        if (source == null) {
            return null;
        }

        final SupplierInvoiceRow supplierInvoiceRow = new SupplierInvoiceRow();
        supplierInvoiceRow.setId(source.getId());
        supplierInvoiceRow.setNotes(source.getNotes());
        supplierInvoiceRow.setQuantity(source.getQuantity());
supplierInvoiceRow.setSupplierInvoice(suppConv.convert(source.getSupplierInvoice()));
supplierInvoiceRow.setPrice(source.getPrice());
supplierInvoiceRow.setProduct(prodConv.convert(source.getProduct()));
supplierInvoiceRow.setStockMoviment(stockConv.convert(source.getStokMovement()));








        return supplierInvoiceRow;
    }
}
