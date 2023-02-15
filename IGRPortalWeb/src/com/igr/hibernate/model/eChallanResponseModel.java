package com.igr.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "e_challan_response")

public class eChallanResponseModel implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int slno;
	private String tr_ref_no;
	private String bank_ref_no;
	
	private String date_ac;
	private String date_and_time;
	private String statusflag;
	
	private String deptref_no;
	private Date entry_date;
	private String entry_datetime;

	private String bankname;
	private BigDecimal depositamount;
	
	@Id
	@Column(name = "slno")
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	
	@Column(name = "tr_ref_no")
	public String getTr_ref_no() {
		return tr_ref_no;
	}
	public void setTr_ref_no(String tr_ref_no) {
		this.tr_ref_no = tr_ref_no;
	}

	@Column(name = "bank_ref_no")
	public String getBank_ref_no() {
		return bank_ref_no;
	}
	public void setBank_ref_no(String bank_ref_no) {
		this.bank_ref_no = bank_ref_no;
	}

	@Column(name = "date_ac")
	public String getDate_ac() {
		return date_ac;
	}
	public void setDate_ac(String date_ac) {
		this.date_ac = date_ac;
	}

	@Column(name = "date_and_time")
	public String getDate_and_time() {
		return date_and_time;
	}
	public void setDate_and_time(String date_and_time) {
		this.date_and_time = date_and_time;
	}

	@Column(name = "statusflag")
	public String getStatusflag() {
		return statusflag;
	}
	public void setStatusflag(String statusflag) {
		this.statusflag = statusflag;
	}

	@Column(name = "deptref_no")
	public String getDeptref_no() {
		return deptref_no;
	}
	public void setDeptref_no(String deptref_no) {
		this.deptref_no = deptref_no;
	}

	@Column(name = "entry_date")
	public Date getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	@Column(name = "entry_datetime")
	public String getEntry_datetime() {
		return entry_datetime;
	}
	public void setEntry_datetime(String entry_datetime) {
		this.entry_datetime = entry_datetime;
	}

	@Column(name = "bankname")
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	@Column(name = "depositamount")
	public BigDecimal getDepositamount() {
		return depositamount;
	}
	public void setDepositamount(BigDecimal depositamount) {
		this.depositamount = depositamount;
	}
}