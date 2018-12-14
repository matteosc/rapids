package com.muscatinecode.rapids.domain;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import java.util.Objects;
/////////// done ////////////
@Entity
@Table(name="stok_moviment")
public class StockMoviment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private LocalDate movimentDate;
    private float quantity;
    private  float value;

    @Nullable
    @OneToOne
    @JoinColumn(name="fk_supplier_invoice_row")
    private SupplierInvoiceRow supplierInvoiceRow;
    @ManyToOne
    @JoinColumn(name="fk_good")
    private Good good;
    @ManyToOne
    @JoinColumn(name="fk_product")
    private Product product;
    @Nullable
    @ManyToOne
    @JoinColumn(name="fk_damping")
    private Damping damping;
    @Nullable
    @ManyToOne
    @JoinColumn(name="fk_donation")
    private IncomingDonation donation;

    @ManyToOne
    @JoinColumn(name="fk_measurement_unit")
    private UnitOfMeasure measurementUnit;


    // default constructor

    public StockMoviment() {
    }

    //args contructor

    public StockMoviment(@NotNull String name, @NotNull LocalDate movimentDate, float quantity, float value,
                         @Nullable SupplierInvoiceRow supplierInvoiceRow, Good good, Product product,
                         @Nullable Damping damping, @Nullable IncomingDonation donation,
                         UnitOfMeasure measurementUnit) {
        this.name = name;
        this.movimentDate = movimentDate;
        this.quantity = quantity;
        this.value = value;
        this.supplierInvoiceRow = supplierInvoiceRow;
        this.good = good;
        this.product = product;
        this.damping = damping;
        this.donation = donation;
        this.measurementUnit = measurementUnit;
    }


    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getMovimentDate() {
        return movimentDate;
    }

    public void setMovimentDate(LocalDate movimentDate) {
        this.movimentDate = movimentDate;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Nullable
    public Damping getDamping() {
        return damping;
    }

    public void setDamping(@Nullable Damping damping) {
        this.damping = damping;
    }

    @Nullable
    public IncomingDonation getDonation() {
        return donation;
    }

    public void setDonation(@Nullable IncomingDonation donation) {
        this.donation = donation;
    }

    @Nullable
    public SupplierInvoiceRow getSupplierInvoiceRow() {
        return supplierInvoiceRow;
    }

    public void setSupplierInvoiceRow(@Nullable SupplierInvoiceRow supplierInvoiceRow) {

        this.supplierInvoiceRow = supplierInvoiceRow;
    }

    public UnitOfMeasure getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(UnitOfMeasure measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


    // equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockMoviment that = (StockMoviment) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // toString


    @Override
    public String toString() {
        return "StockMoviment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movimentDate=" + movimentDate +
                ", good=" + good +
                ", product=" + product +
                ", damping=" + damping +
                ", donation=" + donation +
                ", supplierInvoiceRow=" + supplierInvoiceRow +
                ", measurementUnit=" + measurementUnit +
                ", quantity=" + quantity +
                ", value=" + value +
                '}';
    }
}
