package com.truckseva.model;

import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the vehicle_owner database table.
 * 
 */
@Entity
@Table(name = "vehicle_owner")
@NamedQuery(name = "VehicleOwner.findAll", query = "SELECT v FROM VehicleOwner v")
public class VehicleOwner extends BaseModel {

	private static final long serialVersionUID = 3544878347332501958L;

	@Id
	@SequenceGenerator(name = "VEHICLE_OWNER_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEHICLE_OWNER_ID_GENERATOR")
	private int id;

	@Column(name = "country_code")
	private String countryCode;

	private String email;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "land_line_phone_no")
	private String landLinePhoneNo;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "pan_no")
	private String panNo;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "vehicleOwner")
	private Set<Transaction> transactions;

	// bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	public VehicleOwner() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLandLinePhoneNo() {
		return this.landLinePhoneNo;
	}

	public void setLandLinePhoneNo(String landLinePhoneNo) {
		this.landLinePhoneNo = landLinePhoneNo;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPanNo() {
		return this.panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setVehicleOwner(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setVehicleOwner(null);

		return transaction;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}