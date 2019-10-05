package com.truckseva.model;

import javax.persistence.*;

/**
 * The persistent class for the transactions database table.
 * 
 */
@Entity
@Table(name = "transactions")
@NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")
public class Transaction extends BaseModel {

	private static final long serialVersionUID = -3640739647456614724L;

	@Id
	@SequenceGenerator(name = "TRANSACTIONS_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTIONS_ID_GENERATOR")
	private int id;

	@Column(name = "consignment_size_accepted")
	private String consignmentSizeAccepted;

	@Column(name = "owner_commission")
	private double ownerCommission;

	@Column(name = "total_value")
	private double totalValue;

	@Column(name = "transporter_commission")
	private double transporterCommission;

	// bi-directional many-to-one association to JobDetail
	@ManyToOne
	@JoinColumn(name = "job_id")
	private JobDetail jobDetail;

	// bi-directional many-to-one association to VehicleOwner
	@ManyToOne
	@JoinColumn(name = "vehicle_owner_id")
	private VehicleOwner vehicleOwner;

	public Transaction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConsignmentSizeAccepted() {
		return this.consignmentSizeAccepted;
	}

	public void setConsignmentSizeAccepted(String consignmentSizeAccepted) {
		this.consignmentSizeAccepted = consignmentSizeAccepted;
	}

	public double getOwnerCommission() {
		return this.ownerCommission;
	}

	public void setOwnerCommission(double ownerCommission) {
		this.ownerCommission = ownerCommission;
	}

	public double getTotalValue() {
		return this.totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public double getTransporterCommission() {
		return this.transporterCommission;
	}

	public void setTransporterCommission(double transporterCommission) {
		this.transporterCommission = transporterCommission;
	}

	public JobDetail getJobDetail() {
		return this.jobDetail;
	}

	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}

	public VehicleOwner getVehicleOwner() {
		return this.vehicleOwner;
	}

	public void setVehicleOwner(VehicleOwner vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}

}