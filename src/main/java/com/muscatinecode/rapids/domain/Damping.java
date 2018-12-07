package com.muscatinecode.rapids.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;
//////////// done //////////////////
@Entity
@Table(name = "damping")
public class Damping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private LocalDate dampingDate;


    // default constructor

    public Damping() {
    }

    //args constructor

    public Damping(@NotNull String name, @NotNull LocalDate dampingDate) {
        this.name = name;
        this.dampingDate = dampingDate;
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

    public LocalDate getDampingDate() {
        return dampingDate;
    }

    public void setDampingDate(LocalDate dampingDate) {
        this.dampingDate = dampingDate;
    }

    // equal and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Damping damping = (Damping) o;
        return id == damping.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // toString


    @Override
    public String toString() {
        return "Damping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dampingDate=" + dampingDate +
                '}';
    }
}
