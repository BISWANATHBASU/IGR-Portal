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
@Table(name = "appointment_estamp_detail")
public class appointmentEStampModel implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int appointment_id;
	private String appointment_no;
    private Date appointment_date;
    private String e_stamp_no;
    private Date e_stamp_date;
    private BigDecimal e_stamp_value;
    //create_datetime timestamp without time zone,
    
	@Id
	@Column(name = "appointment_id")
	@SequenceGenerator(name="appointment_id_seq", sequenceName="appointment_estamp_detail_type_appointment_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id_seq")
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	
	@Column(name = "appointment_no")
	public String getAppointment_no() {
		return appointment_no;
	}
	public void setAppointment_no(String appointment_no) {
		this.appointment_no = appointment_no;
	}
	
	@Column(name = "appointment_date")
	public Date getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(Date appointment_date) {
		this.appointment_date = appointment_date;
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
}