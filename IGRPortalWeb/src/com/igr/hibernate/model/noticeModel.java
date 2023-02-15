package com.igr.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="noticeModel")
@Table(name="notice_master")
public class noticeModel {
	@Id
	@Column(name="notice_id",length=10)
	@SequenceGenerator(name = "notice_id_seq", sequenceName = "notice_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_id_seq")
	private int notice_id;
	
	@Column(name="notice_about",length=50)
	private String notice_about;
	
	@Column(name="date_posted")
	private Date date_posted;
	
	@Column(name="notice_status",nullable=false)
	private boolean notice_status;
	
	@Column(name="file_name", length=100)
	private String file_name;

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public String getNotice_about() {
		return notice_about;
	}

	public void setNotice_about(String notice_about) {
		this.notice_about = notice_about;
	}

	public Date getDate_posted() {
		return date_posted;
	}

	public void setDate_posted(Date date_posted) {
		this.date_posted = date_posted;
	}

	public boolean isNotice_status() {
		return notice_status;
	}

	public void setNotice_status(boolean notice_status) {
		this.notice_status = notice_status;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	
	
	
	

}
