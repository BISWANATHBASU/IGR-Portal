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
@Table(name = "appointment_otp_detail")
public class appointmentOTPModel implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int appointment_otp_detail_id;
    private String mobile_no;
    private int otp;
    private String source_booking;
    private String type_booking;
    private boolean active_tag;
    
	@Id
	@Column(name = "appointment_otp_detail_id")
	@SequenceGenerator(name="appointment_otp_detail_id", sequenceName="appointment_otp_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_otp_detail_id")
	public int getAppointment_otp_detail_id() {
		return appointment_otp_detail_id;
	}
	public void setAppointment_otp_detail_id(int appointment_otp_detail_id) {
		this.appointment_otp_detail_id = appointment_otp_detail_id;
	}
	
	@Column(name = "mobile_no")
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	@Column(name = "otp")
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	@Column(name = "source_booking")
	public String getSource_booking() {
		return source_booking;
	}
	public void setSource_booking(String source_booking) {
		this.source_booking = source_booking;
	}
	
	@Column(name = "type_booking")
	public String getType_booking() {
		return type_booking;
	}
	public void setType_booking(String type_booking) {
		this.type_booking = type_booking;
	}
	
	@Column(name = "active_tag")
	public boolean isActive_tag() {
		return active_tag;
	}
	public void setActive_tag(boolean active_tag) {
		this.active_tag = active_tag;
	}
}
