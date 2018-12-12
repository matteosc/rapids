package com.muscatinecode.rapids.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SupplierOrderRowCommand {

    private long id;

    private String note;
    private float quantity;

    private SupplierOrderCommand supplierOrder;

    private ProductCommand product;

    private UnitOfMeasureCommand measurementUnit;


}
