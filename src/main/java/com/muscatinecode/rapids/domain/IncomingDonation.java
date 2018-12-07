package com.muscatinecode.rapids.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;
///////////// DONE ////////////////////
@Entity
@Table(name="incoming_donation")
public class IncomingDonation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private LocalDate donationDate;

    // default constructor

    public IncomingDonation() {
    }

    //args constructor

    public IncomingDonation(@NotNull String name, @NotNull LocalDate donationDate) {
        this.name = name;
        this.donationDate = donationDate;
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

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    // equal and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomingDonation incomingDonation = (IncomingDonation) o;
        return id == incomingDonation.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString


    @Override
    public String toString() {
        return "IncomingDonation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", donationDate=" + donationDate +
                '}';
    }
}

