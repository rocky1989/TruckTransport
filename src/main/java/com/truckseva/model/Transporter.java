package com.truckseva.model;

import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the transporter database table.
 * 
 */
@Entity
@NamedQuery(name = "Transporter.findAll", query = "SELECT t FROM Transporter t")
public class Transporter extends BaseModel {

	private static final long serialVersionUID = -5630694966570290607L;

	@Id
	@SequenceGenerator(name = "TRANSPORTER_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSPORTER_ID_GENERATOR")
	private int id;

	@Column(name = "address_id")
	private int addressId;

	@Column(name = "country_code")
	private String countryCode;

	private String email;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "land_line_phone_no")
	private String landLinePhoneNo;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "tin_no")
	private String tinNo;

	// bi-directional many-to-many association to Vehicle
	@OneToMany
	@JoinTable(name = "OWNER_VEHICLE_MAPPING", joinColumns = {
			@JoinColumn(name = "vehicle_owner_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "vehicle_id", referencedColumnName = "id") })
	private Set<Vehicle> vehicles;

	public Transporter() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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

	public String getTinNo() {
		return this.tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public Set<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}