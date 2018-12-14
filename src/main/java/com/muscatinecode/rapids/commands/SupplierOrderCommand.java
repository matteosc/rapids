package com.muscatinecode.rapids.commands;

import com.muscatinecode.rapids.domain.Supplier;
import com.muscatinecode.rapids.domain.SupplierOrderRow;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class SupplierOrderCommand {

    private long id;

    private LocalDate orderDate;
    private LocalDate requestDeliveryDate;
    private String orderNumber;

    private Set<SupplierOrderRowCommand> supplierOrderRows=new HashSet<>();

    SupplierCommand supplier;

}
