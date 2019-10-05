package com.truckseva.model;

import javax.persistence.*;

/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
public class Vehicle extends BaseModel {

	private static final long serialVersionUID = 1319612958200988511L;

	@Id
	@SequenceGenerator(name = "VEHICLE_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEHICLE_ID_GENERATOR")
	private int id;

	private String capacity;

	private String type;

	public Vehicle() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCapacity() {
		return this.capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}