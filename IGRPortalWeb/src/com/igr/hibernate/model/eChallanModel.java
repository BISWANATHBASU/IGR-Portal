package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "echallan_detail")

public class eChallanModel implements Serializable {


	private static final long serialVersionUID = -1L;

	private String token_no;
	private Date token_date;
	private int dsr_location;
	
	private String payee;
	private String dept;
	private String tin_cin;
	private String address1;
	private String address2;

	private String purpose;
	private String from_period;
	private String to_period;
	private String bank;
	private String tr_refno;

	private String tr_refno_old;
	private Double amount;
	private String entrydate;
	private String sc_slno;
	private String userid;

	private String date_ac;
	private String majorhead;
	private String submajorhead;
	private String minorhead;
	private String subhead;
	
	private String request_time;
	private String response_time;
	
	@Id
	@Column(name = "token_no")
	public String getToken_no() {
		return token_no;
	}
	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}
	
	@Column(name = "token_date")
	public Date getToken_date() {
		return token_date;
	}
	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}
	
	@Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	@Column(name = "payee")
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	
	@Column(name = "dept")
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "tin_cin")
	public String getTin_cin() {
		return tin_cin;
	}
	public void setTin_cin(String tin_cin) {
		this.tin_cin = tin_cin;
	}

	@Column(name = "address1")
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "purpose")
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "from_period")
	public String getFrom_period() {
		return from_period;
	}
	public void setFrom_period(String from_period) {
		this.from_period = from_period;
	}

	@Column(name = "to_period")
	public String getTo_period() {
		return to_period;
	}
	public void setTo_period(String to_period) {
		this.to_period = to_period;
	}

	@Column(name = "bank")
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "tr_refno")
	public String getTr_refno() {
		return tr_refno;
	}
	public void setTr_refno(String tr_refno) {
		this.tr_refno = tr_refno;
	}

	@Column(name = "tr_refno_old")
	public String getTr_refno_old() {
		return tr_refno_old;
	}
	public void setTr_refno_old(String tr_refno_old) {
		this.tr_refno_old = tr_refno_old;
	}

	@Column(name = "amount")
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "entrydate")
	public String getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	@Column(name = "sc_slno")
	public String getSc_slno() {
		return sc_slno;
	}
	public void setSc_slno(String sc_slno) {
		this.sc_slno = sc_slno;
	}

	@Column(name = "userid")
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "date_ac")
	public String getDate_ac() {
		return date_ac;
	}
	public void setDate_ac(String date_ac) {
		this.date_ac = date_ac;
	}

	@Column(name = "majorhead")
	public String getMajorhead() {
		return majorhead;
	}
	public void setMajorhead(String majorhead) {
		this.majorhead = majorhead;
	}

	@Column(name = "submajorhead")
	public String getSubmajorhead() {
		return submajorhead;
	}
	public void setSubmajorhead(String submajorhead) {
		this.submajorhead = submajorhead;
	}

	@Column(name = "minorhead")
	public String getMinorhead() {
		return minorhead;
	}
	public void setMinorhead(String minorhead) {
		this.minorhead = minorhead;
	}

	@Column(name = "subhead")
	public String getSubhead() {
		return subhead;
	}
	public void setSubhead(String subhead) {
		this.subhead = subhead;
	}

	@Column(name = "request_time")
	public String getRequest_time() {
		return request_time;
	}
	public void setRequest_time(String request_time) {
		this.request_time = request_time;
	}

	@Column(name = "response_time")
	public String getResponse_time() {
		return response_time;
	}
	public void setResponse_time(String response_time) {
		this.response_time = response_time;
	}
	
	
}