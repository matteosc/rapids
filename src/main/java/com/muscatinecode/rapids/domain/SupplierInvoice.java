package com.muscatinecode.rapids.domain;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

///////////////// done //////////////////////
@Entity
@Table(name="supplier_invoice")
public class SupplierInvoice {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @NotNull
// think about create a contraint validator classs
    private LocalDate purchaseDate;


    @OneToMany(mappedBy = "supplierInvoice")
   private List<SupplierInvoiceRow> rows=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "fk_supplier")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "fk_supplier_order")

    @Nullable
    private SupplierOrder order;
    private String invoiceNumber;
    private String internalNumber;
    @Transient
    private float total;
    @Transient
    private float vat;
    @Transient
    private float totalWithVat;

    // default constructor


    public SupplierInvoice() {
    }
    // args constructor

    public SupplierInvoice(@NotNull LocalDate purchaseDate, Supplier supplier, @Nullable SupplierOrder order, String invoiceNumber, String internalNumber) {
        this.purchaseDate = purchaseDate;
        this.supplier = supplier;
        this.order = order;
        this.invoiceNumber = invoiceNumber;
        this.internalNumber = internalNumber;
    }

    // complete constructor without transients

    public SupplierInvoice(@NotNull LocalDate purchaseDate, Supplier supplier, @Nullable SupplierOrder order, String invoiceNumber, String internalNumber, List<SupplierInvoiceRow> rows) {
        this.purchaseDate = purchaseDate;
        this.supplier = supplier;
        this.order = order;
        this.invoiceNumber = invoiceNumber;
        this.internalNumber = internalNumber;
        this.rows = rows;
    }
    // complete constructor

    public SupplierInvoice(@NotNull LocalDate purchaseDate, Supplier supplier, @Nullable SupplierOrder order, String invoiceNumber, String internalNumber, float total, float vat, float totalWithVat, List<SupplierInvoiceRow> rows) {
        this.purchaseDate = purchaseDate;
        this.supplier = supplier;
        this.order = order;
        this.invoiceNumber = invoiceNumber;
        this.internalNumber = internalNumber;
        this.total = total;
        this.vat = vat;
        this.totalWithVat = totalWithVat;
        this.rows = rows;
    }

    // getters and setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Nullable
    public SupplierOrder getOrder() {
        return order;
    }

    public void setOrder(@Nullable SupplierOrder order) {
        this.order = order;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(String internalNumber) {
        this.internalNumber = internalNumber;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public float getTotalWithVat() {
        return totalWithVat;
    }

    public void setTotalWithVat(float totalWithVat) {
        this.totalWithVat = totalWithVat;
    }

    public List<SupplierInvoiceRow> getRows() {
        return rows;
    }

    public void setRows(List<SupplierInvoiceRow> rows) {
        this.rows = rows;
    }

    // add methods

    public  SupplierInvoice addRow(SupplierInvoiceRow supplierInvoiceRow){
        supplierInvoiceRow.setSupplierInvoice(this);
    rows.add(supplierInvoiceRow);
        return  this;
    }


    // equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierInvoice that = (SupplierInvoice) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toSstring

    @Override
    public String toString() {
        return "SupplierInvoice{" +
                "id=" + id +
                ", purchaseDate=" + purchaseDate +
                ", supplier=" + supplier +
                ", order=" + order +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", internalNumber='" + internalNumber + '\'' +
                ", total=" + total +
                ", vat=" + vat +
                ", totalWithVat=" + totalWithVat +
                ", rows=" + rows +
                '}';
    }
}
