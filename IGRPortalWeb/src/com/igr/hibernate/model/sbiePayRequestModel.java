package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sbi_request")

public class sbiePayRequestModel implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int slno;
	private String dept_tran_id;
	private String token_no;

	private Date token_date;
	private int dsr_location;
	private Date tran_date;

	private String tran_datetime;

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
}