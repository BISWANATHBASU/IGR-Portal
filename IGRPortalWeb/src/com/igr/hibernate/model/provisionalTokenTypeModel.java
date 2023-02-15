package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provisional_token")
public class provisionalTokenTypeModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private String token_no;
	private String presenter_name;
	private String presenter_fh_rel;
	private String presenter_fh_name;
	private String presenter_address;
	private int presenter_state;
	private int presenter_pin;
	private int district_id;
	private int dsr_location;
	private String dsr_location_desc;
	private Date token_date;
	private Date token_time;
	private String time_slot;
	private int lang_code;
	private String token_status;
	private int created_by;
	private Date created_date;
	private int updated_by;
	private Date updated_date;
	private String party_type;
	private int deed_type;
	private int book_no;
	private String presenter_phone_no;
	private String presenter_email_id;
	private int original_deed_total_page_no;
	private String property_permission;
	
	private provisionalTokenPKModel firstTokenPK;
	
	
	@Id
	@Column(name = "token_no")
	public String getToken_no() {
		return token_no;
	}
	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}
	

	@Column(name = "presenter_name")
	public String getPresenter_name() {
		return presenter_name;
	}
	public void setPresenter_name(String presenter_name) {
		this.presenter_name = presenter_name;
	}
	
	@Column(name = "presenter_fh_rel")
	public String getPresenter_fh_rel() {
		return presenter_fh_rel;
	}
	public void setPresenter_fh_rel(String presenter_fh_rel) {
		this.presenter_fh_rel = presenter_fh_rel;
	}
	
	@Column(name = "presenter_fh_name")
	public String getPresenter_fh_name() {
		return presenter_fh_name;
	}
	public void setPresenter_fh_name(String presenter_fh_name) {
		this.presenter_fh_name = presenter_fh_name;
	}
	
	@Column(name = "presenter_address")
	public String getPresenter_address() {
		return presenter_address;
	}
	public void setPresenter_address(String presenter_address) {
		this.presenter_address = presenter_address;
	}
	
	@Column(name = "presenter_state")
	public int getPresenter_state() {
		return presenter_state;
	}
	public void setPresenter_state(int presenter_state) {
		this.presenter_state = presenter_state;
	}
	

	@Column(name = "presenter_pin")
	public int getPresenter_pin() {
		return presenter_pin;
	}
	public void setPresenter_pin(int presenter_pin) {
		this.presenter_pin = presenter_pin;
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
	
	@Column(name = "token_date")
	public Date getToken_date() {
		return token_date;
	}
	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}
	@Column(name = "token_time")
	public Date getToken_time() {
		return token_time;
	}
	public void setToken_time(Date token_time) {
		this.token_time = token_time;
	}
	@Column(name = "time_slot")
	public String getTime_slot() {
		return time_slot;
	}
	public void setTime_slot(String time_slot) {
		this.time_slot = time_slot;
	}
	@Column(name = "lang_code")
	public int getLang_code() {
		return lang_code;
	}
	public void setLang_code(int lang_code) {
		this.lang_code = lang_code;
	}
	@Column(name = "token_status")
	public String getToken_status() {
		return token_status;
	}
	public void setToken_status(String token_status) {
		this.token_status = token_status;
	}
	@Column(name = "created_by")
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	@Column(name = "created_date")
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
	@Column(name = "updated_by")
	public int getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	@Column(name = "updated_date")
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	
	@Column(name = "party_type")
	public String getParty_type() {
		return party_type;
	}
	public void setParty_type(String party_type) {
		this.party_type = party_type;
	}
	
	@Column(name = "deed_type")
	public int getDeed_type() {
		return deed_type;
	}
	public void setDeed_type(int deed_type) {
		this.deed_type = deed_type;
	}
	
	
	@Column(name = "book_no")
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	@Column(name = "presenter_phone_no")
	public String getPresenter_phone_no() {
		return presenter_phone_no;
	}
	public void setPresenter_phone_no(String presenter_phone_no) {
		this.presenter_phone_no = presenter_phone_no;
	}
	@Column(name = "presenter_email_id")
	public String getPresenter_email_id() {
		return presenter_email_id;
	}
	public void setPresenter_email_id(String presenter_email_id) {
		this.presenter_email_id = presenter_email_id;
	}
	
	
	
	@Column(name = "original_deed_total_page_no")
	public int getOriginal_deed_total_page_no() {
		return original_deed_total_page_no;
	}
	public void setOriginal_deed_total_page_no(int original_deed_total_page_no) {
		this.original_deed_total_page_no = original_deed_total_page_no;
	}
	
	@Column(name = "property_permission")
	public String getProperty_permission() {
		return property_permission;
	}
	public void setProperty_permission(String property_permission) {
		this.property_permission = property_permission;
	}
	
	/*@EmbeddedId
	public provisionalTokenPKModel getFirstTokenPK() {
		return firstTokenPK;
	}

	public void setFirstTokenPK(provisionalTokenPKModel firstTokenPK) {
		this.firstTokenPK = firstTokenPK;
	}*/
}