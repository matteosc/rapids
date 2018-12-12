package com.muscatinecode.rapids.commands;

import com.muscatinecode.rapids.domain.Supplier;
import com.muscatinecode.rapids.domain.SupplierInvoiceRow;
import com.muscatinecode.rapids.domain.SupplierOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
public class SupplierInvoiceCommand {

    private long id;

    private LocalDate purchaseDate;



   private List<SupplierInvoiceRowCommand> rows=new ArrayList<>();


    private SupplierCommand supplier;

    private SupplierOrderCommand order;
    private String invoiceNumber;
    private String internalNumber;

    private float total;

    private float vat;

    private float totalWithVat;

}
