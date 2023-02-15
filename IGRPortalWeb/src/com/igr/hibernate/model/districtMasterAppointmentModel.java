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
@Table(name = "pipl_cgr_portal.district_tahsil_dsr_mapping")
public class districtMasterAppointmentModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int district_tahsil_dsr_mapping_id;
	private int district_id ;
	private String district_name;
	private String tehsil_name;
	private String mapping_tag;
	private String dsr_location;
	private String view_tag;
	
	
	@Id
	@Column(name = "district_tahsil_dsr_mapping_id")
	@SequenceGenerator(name = "district_tahsil_dsr_mapping_id_seq_seq", sequenceName = "district_tahsil_dsr_mapping_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "district_tahsil_dsr_mapping_id_seq_seq")
	public int getDistrict_tahsil_dsr_mapping_id() {
		return district_tahsil_dsr_mapping_id;
	}
	public void setDistrict_tahsil_dsr_mapping_id(int district_tahsil_dsr_mapping_id) {
		this.district_tahsil_dsr_mapping_id = district_tahsil_dsr_mapping_id;
	}
	
	
	
	@Column(name = "district_id")
	public int getDistrict_id() {
		return district_id;
	}
	
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
		
	}
	
	
	@Column(name = "tehsil_name")
	public String getTehsil_name() {
		return tehsil_name;
	}
	public void setTehsil_name(String tehsil_name) {
		this.tehsil_name = tehsil_name;
	}
	
	
	@Column(name = "mapping_tag")
	public String getMapping_tag() {
		return mapping_tag;
	}
	public void setMapping_tag(String mapping_tag) {
		this.mapping_tag = mapping_tag;
	}
	
	
	@Column(name = "dsr_location")
	public String getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(String dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	@Column(name = "district_name")
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	
	
	@Column(name = "view_tag")
	public String getView_tag() {
		return view_tag;
	}
	public void setView_tag(String view_tag) {
		this.view_tag = view_tag;
	}
	
	
	
	
	
	
	
}