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
@Table(name = "appointment_party_detail")
public class appointmentPartyModel implements Serializable {
	
	private static final long serialVersionUID = -1L;
	
	private int appointment_party_detail_id;
	private String party_name;
	private String mobile_no;
	private String party_type;
	private String appointment_no;
	private String party_father_name;
	private String address;
	

	@Id
	@Column(name = "appointment_party_detail_id")
	@SequenceGenerator(name="appointment_party_detail_id_seq", sequenceName="appointment_party_detail_type_appointment_party_detail_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_party_detail_id_seq")
	public int getAppointment_party_detail_id() {
		return appointment_party_detail_id;
	}
	public void setAppointment_party_detail_id(int appointment_party_detail_id) {
		this.appointment_party_detail_id = appointment_party_detail_id;
	}
	
	@Column(name = "party_name")
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	
	@Column(name = "mobile_no")
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	@Column(name = "party_type")
	public String getParty_type() {
		return party_type;
	}
	public void setParty_type(String party_type) {
		this.party_type = party_type;
	}
	
	@Column(name = "appointment_no")
	public String getAppointment_no() {
		return appointment_no;
	}
	public void setAppointment_no(String appointment_no) {
		this.appointment_no = appointment_no;
	}
	
	@Column(name = "party_father_name")
	public String getParty_father_name() {
		return party_father_name;
	}
	public void setParty_father_name(String party_father_name) {
		this.party_father_name = party_father_name;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}