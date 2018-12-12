package com.muscatinecode.rapids.commands;

import com.muscatinecode.rapids.domain.Product;
import com.muscatinecode.rapids.domain.SupplierOrder;
import com.muscatinecode.rapids.domain.UnitOfMeasure;

import javax.persistence.*;
import java.util.Objects;

public class SupplierOrderRowCommand {

    private long id;

    private String note;
    private float quantity;

    private SupplierOrderCommand supplierOrder;

    private ProductCommand product;

    private UnitOfMeasureCommand measurementUnit;


}
