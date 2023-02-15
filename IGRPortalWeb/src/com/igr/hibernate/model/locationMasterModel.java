package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dsr_location")
public class locationMasterModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int dsr_location;
	private String location_desc;
	private int district_id;
	private int lang_code;
	private int created_by;
	private Date created_datetime;
	private int updated_by;
	private Date updated_datetime;
	private boolean isactive;
	
	
	@Id
	@Column(name = "dsr_location")
	@SequenceGenerator(name = "dsr_location_seq", sequenceName = "dsr_location_dsr_location_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dsr_location_seq")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	
	@Column(name = "location_desc")
	public String getLocation_desc() {
		return location_desc;
	}
	public void setLocation_desc(String location_desc) {
		this.location_desc = location_desc;
	}
	
	@Column(name = "district_id")
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	
	
	@Column(name = "lang_code")
	public int getLang_code() {
		return lang_code;
	}
	public void setLang_code(int lang_code) {
		this.lang_code = lang_code;
	}
	
	@Column(name = "created_by")
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	
	@Column(name = "created_datetime")
	public Date getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}
	
	@Column(name = "updated_by")
	public int getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}
	
	@Column(name = "updated_datetime")
	public Date getUpdated_datetime() {
		return updated_datetime;
	}
	public void setUpdated_datetime(Date updated_datetime) {
		this.updated_datetime = updated_datetime;
	}
	@Column(name = "isactive")
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	
	
	
	
	
	
}