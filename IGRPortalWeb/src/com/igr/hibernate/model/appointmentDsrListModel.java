package com.igr.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "appointment_dsr_list")
public class appointmentDsrListModel implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int appointment_dsr_list_id;
	private int district_id;
	private int dsr_location;
	private String dsr_location_desc;
	private boolean isactive;
	
	
	@Id
	@Column(name = "appointment_detail_id")
	@SequenceGenerator(name="appointment_dsr_list_seq", sequenceName="appointment_dsr_list_dsr_list_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_dsr_list_seq")
	public int getAppointment_dsr_list_id() {
		return appointment_dsr_list_id;
	}
	public void setAppointment_dsr_list_id(int appointment_dsr_list_id) {
		this.appointment_dsr_list_id = appointment_dsr_list_id;
	}
	
	@Column(name = "district_id")
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	
	@Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	@Column(name = "dsr_location_desc")
	public String getDsr_location_desc() {
		return dsr_location_desc;
	}
	public void setDsr_location_desc(String dsr_location_desc) {
		this.dsr_location_desc = dsr_location_desc;
	}
	
	@Column(name = "isactive")
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	

}