package com.igr.hibernate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estamp_details")
public class estampDetailModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int estamp_id;
	private String token_no;
	private Date taken_date;
	private int dsr_location;
	private String e_stamp_no;
	private Date e_stamp_date;
	private BigDecimal e_stamp_value;
	private String epanjiyan_id;
	
	
	
	@Id
	@Column(name = "estamp_id")
	//@SequenceGenerator(name = "estamp_id_seq", sequenceName = "estamp_detail_estamp_id_seq", allocationSize = 1)
	@SequenceGenerator(name = "estamp_id_seq", sequenceName = "estamp_details_estamp_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estamp_id_seq")
	public int getEstamp_id() {
		return estamp_id;
	}
	public void setEstamp_id(int estamp_id) {
		this.estamp_id = estamp_id;
	}
	
	@Column(name = "token_no")
	public String getToken_no() {
		return token_no;
	}
	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}
	
	@Column(name = "taken_date")
	public Date getTaken_date() {
		return taken_date;
	}
	public void setTaken_date(Date taken_date) {
		this.taken_date = taken_date;
	}
	
	@Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	@Column(name = "e_stamp_no")
	public String getE_stamp_no() {
		return e_stamp_no;
	}
	public void setE_stamp_no(String e_stamp_no) {
		this.e_stamp_no = e_stamp_no;
	}
	
	@Column(name = "e_stamp_date")
	public Date getE_stamp_date() {
		return e_stamp_date;
	}
	public void setE_stamp_date(Date e_stamp_date) {
		this.e_stamp_date = e_stamp_date;
	}
	
	@Column(name = "e_stamp_value")
	public BigDecimal getE_stamp_value() {
		return e_stamp_value;
	}
	public void setE_stamp_value(BigDecimal e_stamp_value) {
		this.e_stamp_value = e_stamp_value;
	}
	
	@Column(name = "epanjiyan_id")
	public String getEpanjiyan_id() {
		return epanjiyan_id;
	}
	public void setEpanjiyan_id(String epanjiyan_id) {
		this.epanjiyan_id = epanjiyan_id;
	}
	
	

	
		
	
	
	
	
	

	
}