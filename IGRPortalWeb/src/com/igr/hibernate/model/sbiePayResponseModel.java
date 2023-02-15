package com.igr.hibernate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sbi_response")

public class sbiePayResponseModel implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int slno;
	private String dept_tran_id;
	private String bank_tran_id;
	
	private String response_txt;
	private BigDecimal tran_amount;
	private String tran_crancy;
	
	private String tran_type;
	private String tran_other;
	private String tran_response;
	
	private String tran_bank;
	private String tran_no;
	private Date tran_date;

	private String tran_datetime;
	private String full_response_text;

	@Id
	@Column(name = "slno")
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}

	@Column(name = "dept_tran_id")
	public String getDept_tran_id() {
		return dept_tran_id;
	}
	public void setDept_tran_id(String dept_tran_id) {
		this.dept_tran_id = dept_tran_id;
	}

	@Column(name = "bank_tran_id")
	public String getBank_tran_id() {
		return bank_tran_id;
	}
	public void setBank_tran_id(String bank_tran_id) {
		this.bank_tran_id = bank_tran_id;
	}

	@Column(name = "response_txt")
	public String getResponse_txt() {
		return response_txt;
	}
	public void setResponse_txt(String response_txt) {
		this.response_txt = response_txt;
	}

	@Column(name = "tran_amount")
	public BigDecimal getTran_amount() {
		return tran_amount;
	}
	public void setTran_amount(BigDecimal tran_amount) {
		this.tran_amount = tran_amount;
	}

	@Column(name = "tran_crancy")
	public String getTran_crancy() {
		return tran_crancy;
	}
	public void setTran_crancy(String tran_crancy) {
		this.tran_crancy = tran_crancy;
	}

	@Column(name = "tran_type")
	public String getTran_type() {
		return tran_type;
	}
	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}

	@Column(name = "tran_other")
	public String getTran_other() {
		return tran_other;
	}
	public void setTran_other(String tran_other) {
		this.tran_other = tran_other;
	}

	@Column(name = "tran_response")
	public String getTran_response() {
		return tran_response;
	}
	public void setTran_response(String tran_response) {
		this.tran_response = tran_response;
	}

	@Column(name = "tran_bank")
	public String getTran_bank() {
		return tran_bank;
	}
	public void setTran_bank(String tran_bank) {
		this.tran_bank = tran_bank;
	}

	@Column(name = "tran_no")
	public String getTran_no() {
		return tran_no;
	}
	public void setTran_no(String tran_no) {
		this.tran_no = tran_no;
	}

	@Column(name = "tran_date")
	public Date getTran_date() {
		return tran_date;
	}
	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}

	@Column(name = "tran_datetime")
	public String getTran_datetime() {
		return tran_datetime;
	}
	public void setTran_datetime(String tran_datetime) {
		this.tran_datetime = tran_datetime;
	}

	@Column(name = "full_response_text")
	public String getFull_response_text() {
		return full_response_text;
	}
	public void setFull_response_text(String full_response_text) {
		this.full_response_text = full_response_text;
	}
}