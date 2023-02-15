package com.igr.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disputed_land_master")
public class disputedLandModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7891189832187065394L;
	
	private int district_id;
	private String pdf_file_name;
	
	@Column(name="pdf_file_name")
	public String getPdf_file_name() {
		return pdf_file_name;
	}
	public void setPdf_file_name(String pdf_file_name) {
		this.pdf_file_name = pdf_file_name;
	}
	
	@Id
	@Column(name="district_id")
	public int getDistrict_id() {
		return district_id;
	}
	
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	

}
