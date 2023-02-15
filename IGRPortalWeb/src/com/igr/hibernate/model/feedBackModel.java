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
@Table(name = "feed_back_detail")
public class feedBackModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int user_id;
	private int feed_back_id;
	
	private String full_name;
	private String mobile_no;
	private String e_mail_id;

	private String website_rating;
	private String enter_comment;

	private int created_by;
	private String created_datetime;
	
	private String feed_back_category;
	private int dsr_location;
	private String e_registration_id;
	private String complain_detail;

	private String sub_complain_detail;

	@Id
	@Column(name = "feed_back_id")
	@SequenceGenerator(name="feed_back_id_seq", sequenceName="feed_back_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feed_back_id_seq")
	public int getFeed_back_id() {
		return feed_back_id;
	}
	public void setFeed_back_id(int feed_back_id) {
		this.feed_back_id = feed_back_id;
	}
	
	@Column(name = "user_id")
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Column(name = "full_name")
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	@Column(name = "mobile_no")
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	@Column(name = "e_mail_id")
	public String getE_mail_id() {
		return e_mail_id;
	}
	public void setE_mail_id(String e_mail_id) {
		this.e_mail_id = e_mail_id;
	}
	
	@Column(name = "website_rating")
	public String getWebsite_rating() {
		return website_rating;
	}
	public void setWebsite_rating(String website_rating) {
		this.website_rating = website_rating;
	}
	
	@Column(name = "enter_comment")
	public String getEnter_comment() {
		return enter_comment;
	}
	public void setEnter_comment(String enter_comment) {
		this.enter_comment = enter_comment;
	}

	@Column(name = "created_by")
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	@Column(name = "created_datetime")
	public String getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(String created_datetime) {
		this.created_datetime = created_datetime;
	}

	@Column(name = "feed_back_category")
	public String getFeed_back_category() {
		return feed_back_category;
	}
	public void setFeed_back_category(String feed_back_category) {
		this.feed_back_category = feed_back_category;
	}

	@Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}

	@Column(name = "e_registration_id")
	public String getE_registration_id() {
		return e_registration_id;
	}
	public void setE_registration_id(String e_registration_id) {
		this.e_registration_id = e_registration_id;
	}

	@Column(name = "complain_detail")
	public String getComplain_detail() {
		return complain_detail;
	}
	public void setComplain_detail(String complain_detail) {
		this.complain_detail = complain_detail;
	}
	

	@Column(name = "sub_complain_detail")
	public String getSub_complain_detail() {
		return sub_complain_detail;
	}
	public void setSub_complain_detail(String sub_complain_detail) {
		this.sub_complain_detail = sub_complain_detail;
	}
}
