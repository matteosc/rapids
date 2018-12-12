package com.muscatinecode.rapids.commands;

import com.muscatinecode.rapids.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class ProductCommand {


    private long id;

    private String name;
    private String supplierCode;
    private boolean collection;
    private int articlePerCollection;
    private double kgPerMu;
    private String barCode;
    private Set<SupplierInvoiceRowCommand> supplierInvoiceRows;
    private Set<SupplierOrderRowCommand> supplierOrderRows;



    private GoodCommand good;

    private UnitOfMeasureCommand measurementUnit;

    private SupplierCommand supplier;

    private Set<AllergenCommand> allergens = new HashSet<>();
}