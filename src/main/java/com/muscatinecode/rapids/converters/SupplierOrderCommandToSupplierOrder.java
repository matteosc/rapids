package com.muscatinecode.rapids.converters;


import com.muscatinecode.rapids.commands.SupplierOrderCommand;
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
public class SupplierOrderCommandToSupplierOrder implements Converter<SupplierOrderCommand, SupplierOrder> {
@Autowired
 private  SupplierCommandToSupplier supConverter;
@Autowired
private  SupplierOrderRowCommandToSupplierOrderRow supOrderRowConverter;


    @Synchronized
    @Nullable
    @Override
    public SupplierOrder convert(SupplierOrderCommand source) {
        if (source == null) {
            return null;
        }

        final SupplierOrder supplierOrder = new SupplierOrder();
        supplierOrder.setId(source.getId());
        supplierOrder.setOrderDate(source.getOrderDate());
        supplierOrder.setOrderNumber(source.getOrderNumber());
        supplierOrder.setRequestDeliveryDate(source.getRequestDeliveryDate());
        supplierOrder.setSupplier(supConverter.convert(source.getSupplier()));


        if (source.getSupplierOrderRows() != null && source.getSupplierOrderRows().size() > 0) {
            source.getSupplierOrderRows()
                    .forEach(supplierOrderRow -> supplierOrder.getSupplierOrderRows().add(supOrderRowConverter.convert(supplierOrderRow)));
        }


        return supplierOrder;
    }
}
