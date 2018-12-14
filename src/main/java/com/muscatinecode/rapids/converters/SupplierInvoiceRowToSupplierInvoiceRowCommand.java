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
public class SupplierInvoiceRowToSupplierInvoiceRowCommand
        implements Converter<SupplierInvoiceRow, SupplierInvoiceRowCommand>{
 @Autowired private  ProductToProductCommand prodConverter;
   @Autowired private  StockMovimentToStockMovimentCommand stokMovementConverter;
  @Autowired  private  SupplierInvoiceToSupplierInvoiceCommand supplierInvoiceConverter;



    @Synchronized
    @Nullable
    @Override
    public SupplierInvoiceRowCommand convert(SupplierInvoiceRow source) {
        if (source == null) {
            return null;
        }

        final SupplierInvoiceRowCommand command = new SupplierInvoiceRowCommand();
        command.setId(source.getId());
        command.setPrice(source.getPrice());
        command.setProduct(prodConverter.convert(source.getProduct()));
        command.setQuantity(source.getQuantity());
        command.setStokMovement(stokMovementConverter.convert(source.getStockMoviment()));
        command.setSupplierInvoice(supplierInvoiceConverter.convert(source.getSupplierInvoice()));
        command.setTotal(source.getTotal());
        command.setTotalWhitVat(source.getTotalWhitVat());
        command.setVat(source.getVat());
        command.setVatCoeff(source.getVatCoeff());
        command.setNotes(source.getNotes());


        return command;
    }
}
