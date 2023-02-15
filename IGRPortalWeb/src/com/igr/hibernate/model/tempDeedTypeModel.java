package com.igr.hibernate.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deed_category_type")
public class tempDeedTypeModel implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int deed_type_id;	
	private String deed_name;
	private int deed_category_id;
	private String category_name;
	private BigDecimal stamp_fee;
	private String stamp_unit;
	private String considered_amount;

 	@Id
	@Column(name = "deed_type_id")
	public int getDeed_type_id() {
		return deed_type_id;
	}
	public void setDeed_type_id(int deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	@Column(name = "deed_name")
	public String getDeed_name() {
		return deed_name;
	}
	public void setDeed_name(String deed_name) {
		this.deed_name = deed_name;
	}

	@Column(name = "deed_category_id")
	public int getDeed_category_id() {
		return deed_category_id;
	}
	public void setDeed_category_id(int deed_category_id) {
		this.deed_category_id = deed_category_id;
	}

	@Column(name = "category_name")
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Column(name = "stamp_fee")
	public BigDecimal getStamp_fee() {
		return stamp_fee;
	}
	public void setStamp_fee(BigDecimal stamp_fee) {
		this.stamp_fee = stamp_fee;
	}
	
	@Column(name = "stamp_unit")
	public String getStamp_unit() {
		return stamp_unit;
	}
	public void setStamp_unit(String stamp_unit) {
		this.stamp_unit = stamp_unit;
	}
	
	@Column(name = "considered_amount")
	public String getConsidered_amount() {
		return considered_amount;
	}
	public void setConsidered_amount(String considered_amount) {
		this.considered_amount = considered_amount;
	}
}