package com.truckseva.model;

import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the job_details database table.
 * 
 */
@Entity
@Table(name = "job_details")
@NamedQuery(name = "JobDetail.findAll", query = "SELECT j FROM JobDetail j")
public class JobDetail extends BaseModel {

	private static final long serialVersionUID = 6175141338853791993L;

	@Id
	@SequenceGenerator(name = "JOB_DETAILS_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_DETAILS_ID_GENERATOR")
	private int id;

	@Column(name = "consignment_from_location")
	private String consignmentFromLocation;

	@Column(name = "consignment_size")
	private String consignmentSize;

	@Column(name = "consignment_to_location")
	private String consignmentToLocation;

	@Column(name = "rate_per_km")
	private String ratePerKm;

	@Column(name = "vehicle_types_required")
	private String vehicleTypesRequired;

	// bi-directional many-to-one association to Transporter
	@ManyToOne
	private Transporter transporter;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "jobDetail")
	private Set<Transaction> transactions;

	public JobDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConsignmentFromLocation() {
		return this.consignmentFromLocation;
	}

	public void setConsignmentFromLocation(String consignmentFromLocation) {
		this.consignmentFromLocation = consignmentFromLocation;
	}

	public String getConsignmentSize() {
		return this.consignmentSize;
	}

	public void setConsignmentSize(String consignmentSize) {
		this.consignmentSize = consignmentSize;
	}

	public String getConsignmentToLocation() {
		return this.consignmentToLocation;
	}

	public void setConsignmentToLocation(String consignmentToLocation) {
		this.consignmentToLocation = consignmentToLocation;
	}

	public String getRatePerKm() {
		return this.ratePerKm;
	}

	public void setRatePerKm(String ratePerKm) {
		this.ratePerKm = ratePerKm;
	}

	public String getVehicleTypesRequired() {
		return this.vehicleTypesRequired;
	}

	public void setVehicleTypesRequired(String vehicleTypesRequired) {
		this.vehicleTypesRequired = vehicleTypesRequired;
	}

	public Transporter getTransporter() {
		return this.transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setJobDetail(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setJobDetail(null);

		return transaction;
	}

}