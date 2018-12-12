package com.muscatinecode.rapids.commands;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StokMovementCommand {

    private long id;

    private String name;

    private LocalDate movimentDate;
    private float quantity;
    private  float value;

    private SupplierInvoiceRowCommand supplierInvoiceRow;

    private GoodCommand good;

    private ProductCommand product;

    private DampingCommand damping;

    private IncomingDonationCommand donation;


    private UnitOfMeasureCommand measurementUnit;

}
