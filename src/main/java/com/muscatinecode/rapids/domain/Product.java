package com.muscatinecode.rapids.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//////////////////////////////////////// done ////////////////////////////////
@Entity
@Table(name = "product")
public class Product {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @NotNull
    private String name;
    private String supplierCode;
    private boolean collection;
    private int articlePerCollection;
    private double kgPerMu;
    private String barCode;


    @OneToMany(mappedBy = "product")
    private Set<SupplierInvoiceRow> supplierInvoiceRows;

    @OneToMany(mappedBy = "product")
    private Set<SupplierOrderRow> supplierOrderRows;


    @ManyToOne
    @JoinColumn(name = "fk_good")
    private Good good;
    @ManyToOne
    @JoinColumn(name = "fk_mesurement_unit")
    private UnitOfMeasure  measurementUnit;

    @ManyToOne
    @JoinColumn(name = "fk_supplier")
    private Supplier supplier;
    // product does the mapping
    @ManyToMany
    @JoinTable(name = "allergen_product", joinColumns = @JoinColumn(name = "product_id")
            , inverseJoinColumns = @JoinColumn(name = "allergen_id"))
    private Set<Allergen> allergens = new HashSet<Allergen>();


    // default constructor
    public Product() {
    }

    // args constructor

    public Product(@NotNull String name, String supplierCode, boolean collection, int articlePerCollection,
                   double kgPerMu, String barCode, Good good, UnitOfMeasure measurementUnit, Supplier supplier) {
        this.name = name;
        this.supplierCode = supplierCode;
        this.collection = collection;
        this.articlePerCollection = articlePerCollection;
        this.kgPerMu = kgPerMu;
        this.barCode = barCode;
        this.good = good;
        this.measurementUnit = measurementUnit;
        this.supplier = supplier;
    }


    // complete constructor

    public Product(@NotNull String name, String supplierCode, boolean collection, int articlePerCollection,
                   double kgPerMu, String barCode, Set<SupplierInvoiceRow> supplierInvoiceRows,
                   Set<SupplierOrderRow> supplierOrderRows,
                   Good good, UnitOfMeasure measurementUnit, Supplier supplier, Set<Allergen> allergens) {
        this.name = name;
        this.supplierCode = supplierCode;
        this.collection = collection;
        this.articlePerCollection = articlePerCollection;
        this.kgPerMu = kgPerMu;
        this.barCode = barCode;
        this.supplierInvoiceRows = supplierInvoiceRows;
        this.supplierOrderRows = supplierOrderRows;
        this.good = good;
        this.measurementUnit = measurementUnit;
        this.supplier = supplier;
        this.allergens = allergens;
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

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public boolean isCollection() {
        return collection;
    }

    public void setCollection(boolean collection) {
        this.collection = collection;
    }

    public int getArticlePerCollection() {
        return articlePerCollection;
    }

    public void setArticlePerCollection(int articlePerCollection) {
        this.articlePerCollection = articlePerCollection;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public UnitOfMeasure getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(UnitOfMeasure measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public double getKgPerMu() {
        return kgPerMu;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setKgPerMu(double kgPerMu) {
        this.kgPerMu = kgPerMu;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<Allergen> getAllergens() {
        return allergens;
    }

    public void setAllergens(Set<Allergen> allergens) {
        this.allergens = allergens;
    }

    public Set<SupplierInvoiceRow> getSupplierInvoiceRows() {
        return supplierInvoiceRows;
    }

    public Set<SupplierOrderRow> getSupplierOrderRows() {
        return supplierOrderRows;
    }

    public void setSupplierOrderRows(Set<SupplierOrderRow> supplierOrderRows) {
        this.supplierOrderRows = supplierOrderRows;
    }

    public void setSupplierInvoiceRows(Set<SupplierInvoiceRow> supplierInvoiceRows) {
        this.supplierInvoiceRows = supplierInvoiceRows;

    }
// equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // toString


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", supplierCode='" + supplierCode + '\'' +
                ", collection=" + collection +
                ", articlePerCollection=" + articlePerCollection +
                ", kgPerMu=" + kgPerMu +
                ", barCode='" + barCode + '\'' +
                ", supplierInvoiceRows=" + supplierInvoiceRows +
                ", supplierOrderRows=" + supplierOrderRows +
                ", good=" + good +
                ", measurementUnit=" + measurementUnit +
                ", supplier=" + supplier +
                ", allergens=" + allergens +
                '}';
    }
}

