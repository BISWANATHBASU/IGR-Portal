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
@Table(name = "appointment_detail")
public class appointmentModel implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int appointment_detail_id;
	private String appointee_name;
	private String appointee_phone_no;
    private int dsr_location;
    private Date appointment_date;
    private String appointment_slot;
    private String mode_booking;
    private String appointment_no;
    private int district_id;
	private String party_father_name;
	private String address;
	private String party_type;
	private String active_tag;
	
	private String estamp_no;
	private BigDecimal estamp_amount;
	private String check_agree;
	
	private int deed_type_id;
	private int deed_category_id;
	private BigDecimal considered_amount;
	private BigDecimal stamp_value;
	
	private Date cancel_date;
	private String rel_token_no ;

	@Id
	@Column(name = "appointment_detail_id")
	@SequenceGenerator(name="appointment_detail_id_seq", sequenceName="appointment_detail_appointment_detail_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_detail_id_seq")
	public int getAppointment_detail_id() {
		return appointment_detail_id;
	}
	public void setAppointment_detail_id(int appointment_detail_id) {
		this.appointment_detail_id = appointment_detail_id;
	}
	
	@Column(name = "appointee_name")
	public String getAppointee_name() {
		return appointee_name;
	}
	public void setAppointee_name(String appointee_name) {
		this.appointee_name = appointee_name;
	}
	
	@Column(name = "appointee_phone_no")
	public String getAppointee_phone_no() {
		return appointee_phone_no;
	}
	public void setAppointee_phone_no(String appointee_phone_no) {
		this.appointee_phone_no = appointee_phone_no;
	}
	
	@Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	@Column(name = "appointment_date")
	public Date getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(Date appointment_date) {
		this.appointment_date = appointment_date;
	}
	
	@Column(name = "appointment_slot")
	public String getAppointment_slot() {
		return appointment_slot;
	}
	public void setAppointment_slot(String appointment_slot) {
		this.appointment_slot = appointment_slot;
	}
	
	@Column(name = "mode_booking")
	public String getMode_booking() {
		return mode_booking;
	}
	public void setMode_booking(String mode_booking) {
		this.mode_booking = mode_booking;
	}
	
	@Column(name = "appointment_no")
	public String getAppointment_no() {
		return appointment_no;
	}
	public void setAppointment_no(String appointment_no) {
		this.appointment_no = appointment_no;
	}
	
	@Column(name = "district_id")
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
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
	
	@Column(name = "party_type")
	public String getParty_type() {
		return party_type;
	}
	public void setParty_type(String party_type) {
		this.party_type = party_type;
	}
	
	@Column(name = "active_tag")
	public String getActive_tag() {
		return active_tag;
	}
	public void setActive_tag(String active_tag) {
		this.active_tag = active_tag;
	}
	
	@Column(name = "estamp_no")
	public String getEstamp_no() {
		return estamp_no;
	}
	public void setEstamp_no(String estamp_no) {
		this.estamp_no = estamp_no;
	}
	
	@Column(name = "estamp_amount")
	public BigDecimal getEstamp_amount() {
		return estamp_amount;
	}
	public void setEstamp_amount(BigDecimal estamp_amount) {
		this.estamp_amount = estamp_amount;
	}
	
	@Column(name = "check_agree")
	public String getCheck_agree() {
		return check_agree;
	}
	public void setCheck_agree(String check_agree) {
		this.check_agree = check_agree;
	}

	@Column(name = "deed_type_id")
	public int getDeed_type_id() {
		return deed_type_id;
	}
	public void setDeed_type_id(int deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	@Column(name = "deed_category_id")
	public int getDeed_category_id() {
		return deed_category_id;
	}
	public void setDeed_category_id(int deed_category_id) {
		this.deed_category_id = deed_category_id;
	}

	@Column(name = "considered_amount")
	public BigDecimal getConsidered_amount() {
		return considered_amount;
	}
	public void setConsidered_amount(BigDecimal considered_amount) {
		this.considered_amount = considered_amount;
	}

	@Column(name = "e_stamp_value")
	public BigDecimal getStamp_value() {
		return stamp_value;
	}
	public void setStamp_value(BigDecimal stamp_value) {
		this.stamp_value = stamp_value;
	}

	@Column(name = "cancel_date")
	public Date getCancel_date() {
		return cancel_date;
	}
	public void setCancel_date(Date cancel_date) {
		this.cancel_date = cancel_date;
	}
	
	@Column(name = "rel_token_no")
	public String getRel_token_no() {
		return rel_token_no;
	}
	public void setRel_token_no(String rel_token_no) {
		this.rel_token_no = rel_token_no;
	}
	
	
	
}