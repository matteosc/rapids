package com.muscatinecode.rapids.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;

import java.util.Objects;
import java.util.Set;
/////// done/////////////
@Entity
@Getter
@Setter
@Table(name = "allergen")
public class Allergen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @NotNull
    private String name;
    @Nullable
    @ManyToMany(mappedBy = "allergens") // target side
    private Set<Product> products = new HashSet<Product>();
   @Nullable
    @ManyToMany(mappedBy = "allergens") // target side
    private Set<Recipe> recipes = new HashSet<>();
// default constructor

    public Allergen() {
    }
    // args constructor


    // getters and setters


    //equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergen allergen = (Allergen) o;
        return id == allergen.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //toStirng


    }

