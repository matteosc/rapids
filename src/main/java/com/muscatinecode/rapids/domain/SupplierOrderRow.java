package com.muscatinecode.rapids.domain;

import javax.persistence.*;
import java.util.Objects;
////////// done ////////////////
@Entity
@Table(name="supplier_order_row")
public class SupplierOrderRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Lob
    private String note;
    private float quantity;

    @ManyToOne
    @JoinColumn(name = "fk_supplier_order")
    private SupplierOrder supplierOrder;
    @ManyToOne
    @JoinColumn(name = "fk_product")
    private Product product;
    @ManyToOne
    @JoinColumn(name="fk_measurement_unit")
    private UnitOfMeasure measurementUnit;



    // default constructor


    public SupplierOrderRow() {
    }
    // args construcotr


    public SupplierOrderRow(Product product, float quantity, UnitOfMeasure measurementUnit, String note) {
        this.product = product;
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
        this.note = note;
    }

    // complete constructor
    public SupplierOrderRow(SupplierOrder supplierOrder, Product product, float quantity, UnitOfMeasure measurementUnit, String note) {
        this.supplierOrder = supplierOrder;
        this.product = product;
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
        this.note = note;
    }

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SupplierOrder getSupplierOrder() {
        return supplierOrder;
    }

    public void setSupplierOrder(SupplierOrder supplierOrder) {
        this.supplierOrder = supplierOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public UnitOfMeasure getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(UnitOfMeasure measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // equals and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierOrderRow that = (SupplierOrderRow) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString

    @Override
    public String toString() {
        return "SupplierOrderRow{" +
                "id=" + id +
                ", supplierOrder=" + supplierOrder +
                ", product=" + product +
                ", quantity=" + quantity +
                ", measurementUnit=" + measurementUnit +
                ", note='" + note + '\'' +
                '}';
    }
}
