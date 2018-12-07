package com.muscatinecode.rapids.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {
private String zipCode;
	private String street;
	private String city;
	private String state;
	private String nation;
	@Email
	private String email;

// default constructor
public Address() {
}
// args constructor


	public Address(String zipCode, String street, String city, String state, String nation, @Email String email) {
		this.zipCode = zipCode;
		this.street = street;
		this.city = city;
		this.state = state;
		this.nation = nation;
		this.email = email;
	}

	// getters and setters

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// equauls and hashcode

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
		return Objects.equals(zipCode, address.zipCode) &&
				Objects.equals(street, address.street) &&
				Objects.equals(city, address.city) &&
				Objects.equals(state, address.state) &&
				Objects.equals(nation, address.nation) &&
				Objects.equals(email, address.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(zipCode, street, city, state, nation, email);

	}
	// toString

	@Override
	public String toString() {
		return "Address{" +
				"zipCode='" + zipCode + '\'' +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", nation='" + nation + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
