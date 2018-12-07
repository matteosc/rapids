package com.muscatinecode.rapids.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "cost_center")
public class CostCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @NotNull
    private String name;

    @OneToMany(mappedBy = "costCenter")
    private Set<Good> goods=new HashSet<Good>();



    // default constructor
    public CostCenter() {
    }


    // args constructor
    public CostCenter(@NotNull String name) {
        this.name = name;
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

    public Set<Good> getGoods() {
        return goods;
    }

    public void setGoods(Set<Good> goods) {
        this.goods = goods;
    }

////////////////////////////
    public CostCenter addGood(Good good){
        good.setCostCenter(this);
        this.goods.add(good);
        return this;
    }

//equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostCenter that = (CostCenter) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString

    @Override
    public String toString() {
        return "CostCenter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goods=" + goods +
                '}';
    }
}
