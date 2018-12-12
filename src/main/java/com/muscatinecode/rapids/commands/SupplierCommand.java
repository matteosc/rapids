package com.muscatinecode.rapids.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class SupplierCommand {

    private Long id;

    private String name;
    private String vatNumber;
    private String socialSecurityNumber;
    private String telephone;
    private String webSite;

    private AddressCommand address;


    private Set<SupplierOrderCommand> supplierOrders = new HashSet<>();



    private Set<SupplierInvoiceCommand> supplierInvoices = new HashSet<>();

}
