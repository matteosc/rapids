package com.muscatinecode.rapids.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

///////// done ////////////
@Entity
@Table(name="tax_depreciation")
public class TaxDepreciation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @NotNull
    private String name;

    // default contructor

    public TaxDepreciation() {
    }
    // complete constructor

    public TaxDepreciation(@NotNull String name) {
        this.name = name;
    }

    // getter and setter

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

    // equal and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxDepreciation that = (TaxDepreciation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString

    @Override
    public String toString() {
        return "TaxDepreciation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
