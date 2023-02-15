package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorywise_working_day")
public class appointmentWorkingDay implements Serializable {

	private static final long serialVersionUID = -1L;

	private String office_category;
    private Date working_date;

	//@Id
	@Column(name = "office_category")
	public String getOffice_category() {
		return office_category;
	}
	public void setOffice_category(String office_category) {
		this.office_category = office_category;
	}

	@Column(name = "working_date")
	public Date getWorking_date() {
		return working_date;
	}
	public void setWorking_date(Date working_date) {
		this.working_date = working_date;
	}
}
