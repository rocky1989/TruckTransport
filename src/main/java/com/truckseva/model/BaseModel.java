package com.truckseva.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "created_on")
	private Timestamp createdOn;

	@Column(name = "last_modified_by")
	private String lastModifiedBy;

	@Column(name = "last_modified_on")
	private Timestamp lastModifiedOn;

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Timestamp getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Timestamp lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

}
