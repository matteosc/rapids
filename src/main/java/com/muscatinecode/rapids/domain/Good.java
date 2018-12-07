package com.muscatinecode.rapids.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


//////////////////// done ///////////////////
@Entity
@Table(name = "good")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected long id;
    @NotNull
    protected String name;

    @ManyToOne
    @JoinColumn(name ="fk_measurement_unit")
    private UnitOfMeasure measurementUnit;


    @ManyToOne
    @JoinColumn(name = "fk_cost_center")
    protected CostCenter costCenter;
    @ManyToOne
    @JoinColumn(name = "fk_tax_depreciation")
    protected TaxDepreciation taxDepreciation;
    //default constructor


    public Good() {
    }
    // args constructor

    public Good(@NotNull String name,   CostCenter costCenter,
                TaxDepreciation taxDepreciation , UnitOfMeasure measurementUnit) {
        this.name = name;
         this.costCenter = costCenter;
    this.measurementUnit=measurementUnit;
    this.taxDepreciation = taxDepreciation;
    }


    // getters and setter

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



    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public TaxDepreciation getTaxDepreciation() {
        return taxDepreciation;
    }

    public void setTaxDepreciation(TaxDepreciation taxDepreciation) {
        this.taxDepreciation = taxDepreciation;
    }

    public UnitOfMeasure getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(UnitOfMeasure measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
// equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return id == good.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString


    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measurementUnit=" + measurementUnit +

                ", costCenter=" + costCenter +
                ", taxDepreciation=" + taxDepreciation +
                '}';
    }
}
