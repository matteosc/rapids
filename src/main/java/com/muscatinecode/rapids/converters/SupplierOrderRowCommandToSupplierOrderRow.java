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
public class SupplierOrderRowCommandToSupplierOrderRow
        implements Converter<SupplierOrderRowCommand, SupplierOrderRow> {
@Autowired
private   SupplierOrderCommandToSupplierOrder supOrderConverter;
@Autowired
private  UnitOfMeasureCommandToUnitOfMeasure uomConverter;
@Autowired
private  ProductCommandToProduct prodConverter;


    @Synchronized
    @Nullable
    @Override
    public SupplierOrderRow convert(SupplierOrderRowCommand source) {
        if (source == null) {
            return null;
        }

        final SupplierOrderRow supplierOrderRow = new SupplierOrderRow();
        supplierOrderRow.setId(source.getId());
        supplierOrderRow.setSupplierOrder(supOrderConverter.convert(source.getSupplierOrder()));
        supplierOrderRow.setMeasurementUnit(uomConverter.convert(source.getMeasurementUnit()));
supplierOrderRow.setNote(source.getNotes());
supplierOrderRow.setProduct(prodConverter.convert(source.getProduct()));
supplierOrderRow.setQuantity(source.getQuantity());

        return supplierOrderRow;
    }
}
