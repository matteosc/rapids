package com.muscatinecode.rapids.converters;

import com.muscatinecode.rapids.commands.SupplierOrderCommand;
import com.muscatinecode.rapids.domain.SupplierOrder;
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
public class SupplierOrderToSupplierOrderCommand implements Converter<SupplierOrder, SupplierOrderCommand>{
@Autowired private  SupplierOrderRowToSupplierOrderRowCommand rowConverter;
@Autowired private  SupplierToSupplierCommand supConverter;



    @Synchronized
    @Nullable
    @Override
    public SupplierOrderCommand convert(SupplierOrder source) {
        if (source == null) {
            return null;
        }

        final SupplierOrderCommand command = new SupplierOrderCommand();
        command.setId(source.getId());

        command.setOrderDate(source.getOrderDate());
        command.setOrderNumber(source.getOrderNumber());
        command.setRequestDeliveryDate(source.getRequestDeliveryDate());
        command.setSupplier(supConverter.convert(source.getSupplier()));


        if (source.getSupplierOrderRows() != null && source.getSupplierOrderRows().size() > 0){
            source.getSupplierOrderRows()
                    .forEach((SupplierOrderRow row) -> command.getSupplierOrderRows().add(rowConverter.convert(row)));
        }



        return command;
    }
}
