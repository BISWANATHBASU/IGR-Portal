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
@Table(name = "user_log_portal_1")
public class userLogModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int user_log_id;
	private int user_id;
	private String token_no;
	private Date token_date;
	private int dsr_location;
	private String user_action;
	private Date start_time;
	private Date end_time;
	
	
	
	
	
	
	

	@Id
	@Column(name = "user_log_id")
	@SequenceGenerator(name="user_log_id_seq", sequenceName="user_log_user_log_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_log_id_seq")
	public int getUser_log_id() {
		return user_log_id;
	}

	public void setUser_log_id(int user_log_id) {
		this.user_log_id = user_log_id;
	}

	@Column(name = "user_id")
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Column(name = "user_action")
	public String getUser_action() {
		return user_action;
	}

	public void setUser_action(String user_action) {
		this.user_action = user_action;
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

	@Column(name = "start_time")
	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	@Column(name = "end_time")
	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	

}