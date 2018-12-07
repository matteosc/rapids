package com.muscatinecode.rapids.domain;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
////////////////// done//////////////////////////
@Entity
@Table(name = "supplier")
public class Supplier {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @NotNull
    private String name;
    private String vatNumber;
    private String socialSecurityNumber;
    private String telephone;
    private String webSite;
    @Embedded
    private Address address;


    @OneToMany(mappedBy = "supplier")
      private Set<SupplierOrder> supplierOrders = new HashSet<SupplierOrder>();


    @OneToMany(mappedBy = "supplier")
    private Set<SupplierInvoice> supplierInvoices = new HashSet<SupplierInvoice>();

    // default constructor

    public Supplier() {
    }

    // args constructor

    public Supplier(@NotNull String name, String vatNumber, String webSite,String socialSecurityNumber, String telephone, Address address) {
        this.name = name;
        this.vatNumber = vatNumber;
        this.socialSecurityNumber = socialSecurityNumber;
        this.telephone = telephone;
        this.address = address;
    }


    // complete constructor

    public Supplier(@NotNull String name, String vatNumber, String webSite,String socialSecurityNumber, String telephone, Address address, Set<SupplierOrder> supplierOrders, Set<SupplierInvoice> supplierInvoices) {
        this.name = name;
        this.vatNumber = vatNumber;
        this.socialSecurityNumber = socialSecurityNumber;
        this.telephone = telephone;
        this.address = address;
        this.supplierOrders = supplierOrders;
        this.supplierInvoices = supplierInvoices;
    }


    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }



    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<SupplierOrder> getSupplierOrders() {
        return supplierOrders;
    }

    public void setSupplierOrders(Set<SupplierOrder> supplierOrders) {
        this.supplierOrders = supplierOrders;
    }

    public Set<SupplierInvoice> getSupplierInvoices() {
        return supplierInvoices;
    }

    public void setSupplierInvoices(Set<SupplierInvoice> supplierInvoices) {
        this.supplierInvoices = supplierInvoices;
    }


    // equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // toString


    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", telephone='" + telephone + '\'' +
                ", webSite='" + webSite + '\'' +
                ", address=" + address +
                ", supplierOrders=" + supplierOrders +
                ", supplierInvoices=" + supplierInvoices +
                '}';
    }
}