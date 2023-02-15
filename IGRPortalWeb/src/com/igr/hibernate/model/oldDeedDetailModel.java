package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "old_deed_detail")
public class oldDeedDetailModel implements Serializable {

	private static final long serialVersionUID = -1L;

	
	private String old_deed_no;
	private Date old_deed_date;
	private String old_receipt_no;
	private BigDecimal old_registration_fee;
	private BigDecimal old_stamp_fee;
	private oldDeedDetailPKModel oldDeedDetailPK;
	
	
	
	
	 @EmbeddedId
	public oldDeedDetailPKModel getOldDeedDetailPK() {
		return oldDeedDetailPK;
	}

	public void setOldDeedDetailPK(oldDeedDetailPKModel oldDeedDetailPK) {
		this.oldDeedDetailPK = oldDeedDetailPK;
	}

	
	@Column(name = "old_deed_no")
	public String getOld_deed_no() {
		return old_deed_no;
	}

	public void setOld_deed_no(String old_deed_no) {
		this.old_deed_no = old_deed_no;
	}

	@Column(name = "old_deed_date")
	public Date getOld_deed_date() {
		return old_deed_date;
	}

	public void setOld_deed_date(Date old_deed_date) {
		this.old_deed_date = old_deed_date;
	}

	@Column(name = "old_receipt_no")
	public String getOld_receipt_no() {
		return old_receipt_no;
	}

	public void setOld_receipt_no(String old_receipt_no) {
		this.old_receipt_no = old_receipt_no;
	}

	@Column(name = "old_registration_fee")
	public BigDecimal getOld_registration_fee() {
		return old_registration_fee;
	}

	public void setOld_registration_fee(BigDecimal old_registration_fee) {
		this.old_registration_fee = old_registration_fee;
	}

	@Column(name = "old_stamp_fee")
	public BigDecimal getOld_stamp_fee() {
		return old_stamp_fee;
	}

	public void setOld_stamp_fee(BigDecimal old_stamp_fee) {
		this.old_stamp_fee = old_stamp_fee;
	}

	

	
	
	
	
	
	

}