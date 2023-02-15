package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;

@Embeddable
public class oldDeedDetailPKModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int token_no;
	private int dsr_location;
	private Date token_date;
	
	
	 @Column(name = "token_no")
	public int getToken_no() {
		return token_no;
	}
	public void setToken_no(int token_no) {
		this.token_no = token_no;
	}
	
	 @Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	
	 @Column(name = "token_date")
	public Date getToken_date() {
		return token_date;
	}
	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}
		


	
	
	
	

}