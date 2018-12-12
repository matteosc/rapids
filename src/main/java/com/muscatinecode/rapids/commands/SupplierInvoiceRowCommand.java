package com.muscatinecode.rapids.commands;


import com.muscatinecode.rapids.domain.Product;
import com.muscatinecode.rapids.domain.StokMovement;
import com.muscatinecode.rapids.domain.SupplierInvoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class SupplierInvoiceRowCommand {

    private long id;

    private StokMovementCommand stokMovement;


    private SupplierInvoiceCommand supplierInvoice;

    private ProductCommand product;

    private float quantity;

    private float vatCoeff;
    private float price;


    private float total;

    private float vat;


    private float totalWhitVat;


}