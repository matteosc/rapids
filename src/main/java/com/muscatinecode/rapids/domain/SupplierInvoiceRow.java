package com.muscatinecode.rapids.domain;



import javax.persistence.*;
import java.util.Objects;

////////////// done //////////////////
@Entity
@Table(name = "supplier_invoce_row")
public class SupplierInvoiceRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @OneToOne(mappedBy = "supplierInvoiceRow")
    private StockMoviment stockMoviment;

    @ManyToOne
    @JoinColumn(name = "fk_supplier_invoice")
    private SupplierInvoice supplierInvoice;
    @ManyToOne
    @JoinColumn(name = "fk_product")
    private Product product;
    @Lob
private String notes;
    private float quantity;

    private float vatCoeff;
    private float price;


    @Transient
    private float total;
    @Transient
    private float vat;

    @Transient
    private float totalWhitVat;

    @PostLoad
    private void onLoad() {
        this.total = quantity * price;
        this.vat = this.total + (this.total * this.vatCoeff / 100);
        this.totalWhitVat = this.total + this.vat;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // default constructor
    public SupplierInvoiceRow() {
    }

// args constructor




// complete constructor

    public SupplierInvoiceRow(StockMoviment stockMoviment, SupplierInvoice supplierInvoice, Product product, String notes, float quantity, float vatCoeff, float price, float total, float vat, float totalWhitVat) {
        this.stockMoviment = stockMoviment;
        this.supplierInvoice = supplierInvoice;
        this.product = product;
        this.notes = notes;
        this.quantity = quantity;
        this.vatCoeff = vatCoeff;
        this.price = price;
        this.total = total;
        this.vat = vat;
        this.totalWhitVat = totalWhitVat;
    }


    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public SupplierInvoice getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(SupplierInvoice supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
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

    public float getVatCoeff() {
        return vatCoeff;
    }

    public void setVatCoeff(float vatCoeff) {
        this.vatCoeff = vatCoeff;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public float getTotalWhitVat() {
        return totalWhitVat;
    }

    public void setTotalWhitVat(float totalWhitVat) {
        this.totalWhitVat = totalWhitVat;
    }

    public StockMoviment getStockMoviment() {
        return stockMoviment;
    }

    public void setStockMoviment(StockMoviment stockMoviment) {
        stockMoviment.setSupplierInvoiceRow(this);
        this.stockMoviment = stockMoviment;
    }
    // equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierInvoiceRow that = (SupplierInvoiceRow) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString


    @Override
    public String toString() {
        return "SupplierInvoiceRow{" +
                "id=" + id +
                ", stockMoviment=" + stockMoviment +
                ", supplierInvoice=" + supplierInvoice +
                ", product=" + product +
                ", quantity=" + quantity +
                ", vatCoeff=" + vatCoeff +
                ", price=" + price +
                ", total=" + total +
                ", vat=" + vat +
                ", totalWhitVat=" + totalWhitVat +
                '}';
    }
}
