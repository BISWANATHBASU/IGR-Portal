package com.igr.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "office_category_master")
public class appointmentOfficeCategory implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int dsr_location;
	private String office_category;

	//@Id
	@Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}

	@Column(name = "office_category")
	public String getOffice_category() {
		return office_category;
	}
	public void setOffice_category(String office_category) {
		this.office_category = office_category;
	}
	
	
}
