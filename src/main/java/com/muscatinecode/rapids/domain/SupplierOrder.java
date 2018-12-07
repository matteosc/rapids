package com.muscatinecode.rapids.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

///////////////////// done //////////////
@Entity
@Table(name = "supplier_order")
public class SupplierOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @NotNull
    private LocalDate orderDate;
    private LocalDate requestDeliveryDate;
    private String orderNumber;

    @OneToMany(mappedBy = "supplierOrder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SupplierOrderRow> supplierOrderRows=new HashSet<SupplierOrderRow>();


    @ManyToOne
    @JoinColumn(name = "fk_supplier")
    Supplier supplier;

    // default constructor
    public SupplierOrder() {
    }

// args constructor

    public SupplierOrder(@NotNull LocalDate orderDate, LocalDate requestDeliveryDate,
                         String orderNumber, Supplier supplier) {
        this.orderDate = orderDate;
        this.requestDeliveryDate = requestDeliveryDate;
        this.orderNumber = orderNumber;
        this.supplier = supplier;
    }

// complete constructor

    public SupplierOrder(@NotNull LocalDate orderDate, LocalDate requestDeliveryDate, String orderNumber,
                         Set<SupplierOrderRow> supplierOrderRows, Supplier supplier) {
        this.orderDate = orderDate;
        this.requestDeliveryDate = requestDeliveryDate;
        this.orderNumber = orderNumber;
        this.supplierOrderRows = supplierOrderRows;
        this.supplier = supplier;
    }

    // getter and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequestDeliveryDate() {
        return requestDeliveryDate;
    }

    public void setRequestDeliveryDate(LocalDate requestDeliveryDate) {
        this.requestDeliveryDate = requestDeliveryDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<SupplierOrderRow> getSupplierOrderRows() {
        return supplierOrderRows;
    }

    public void setSupplierOrderRows(Set<SupplierOrderRow> supplierOrderRows) {
        this.supplierOrderRows = supplierOrderRows;
    }

    // add methods

    public SupplierOrder addRow(SupplierOrderRow supplierOrderRow){
        supplierOrderRow.setSupplierOrder(this);
        supplierOrderRows.add(supplierOrderRow);
        return  this;


    }

// equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierOrder that = (SupplierOrder) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString


    @Override
    public String toString() {
        return "SupplierOrder{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", requestDeliveryDate=" + requestDeliveryDate +
                ", orderNumber='" + orderNumber + '\'' +
                ", supplierOrderRows=" + supplierOrderRows +
                ", supplier=" + supplier +
                '}';
    }
}

