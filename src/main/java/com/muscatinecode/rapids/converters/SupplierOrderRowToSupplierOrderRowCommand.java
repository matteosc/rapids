package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.SupplierOrderRowCommand;
import com.muscatinecode.rapids.domain.SupplierOrderRow;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class SupplierOrderRowToSupplierOrderRowCommand implements Converter<SupplierOrderRow, SupplierOrderRowCommand>{
@Autowired
    private  UnitOfMeasureToUnitOfMeasureCommand uomConv;
@Autowired
    private  SupplierOrderToSupplierOrderCommand supConv;
    @Autowired
    private  ProductToProductCommand prodConv;



    @Synchronized
    @Nullable
    @Override
    public SupplierOrderRowCommand convert(SupplierOrderRow source) {
        if (source == null) {
            return null;
        }

        final SupplierOrderRowCommand command = new SupplierOrderRowCommand();
        command.setId(source.getId());
        command.setMeasurementUnit(uomConv.convert(source.getMeasurementUnit()));
        command.setNotes(source.getNote());
        command.setSupplierOrder(supConv.convert(source.getSupplierOrder()));
        command.setQuantity(source.getQuantity());
        command.setProduct(prodConv.convert(source.getProduct()));



        return command;
    }
}
