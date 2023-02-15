package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "executed_token")
public class secondTokenTypeModel implements Serializable {

	private static final long serialVersionUID = -1L;

	
	private String presenter_name;
	private String first_party_executant_name;
	private String first_party_executant_capacity;
	private int district_id;
	private String dsr_location_desc;
	private Date token_time;
	private String stamp_type;
	private int stamp_pages_no;
	private String stamp_no_with_val;
	private int original_deed_total_page_no;
	private String e_registration_id;
	private BigDecimal considered_amount;
	private BigDecimal paid_amount;
	private BigDecimal deal_amount;
	private BigDecimal due_amount;
	private BigDecimal total_stamp_value;
	private int lang_code;
	private String token_status;
	private int created_by;
	private Date created_date;
	private int updated_by;
	private Date updated_date;
	private int deed_category_id;
	private int deed_type_id;
	private BigDecimal aa_rent;
	private BigDecimal premium_amount;
	private BigDecimal cost_of_building;
	private secondTokenPKModel secondTokenPK;
	private int chalan_page_count;
	private BigDecimal chalan_amount;
    private int treasury_stamp_page_no;
	private String extra_stamp_type;
	private int extra_stamp_count;
	private String t_cp_permission;
	private String t_cp_no;
	private Date t_cp_date;
	private String property_permission;
	private String property_permission_no;
	private Date property_permission_date;
	private String rda_permission;
	private String rda_permission_no;
	private Date rda_permission_date;

	private Date app_date;
	private String app_time;
	
	
	 @EmbeddedId
	public secondTokenPKModel getSecondTokenPK() {
		return secondTokenPK;
	}

	public void setSecondTokenPK(secondTokenPKModel secondTokenPK) {
		this.secondTokenPK = secondTokenPK;
	}

	@Column(name = "presenter_name")
	public String getPresenter_name() {
		return presenter_name;
	}

	public void setPresenter_name(String presenter_name) {
		this.presenter_name = presenter_name;
	}

	@Column(name = "first_party_executant_name")
	public String getFirst_party_executant_name() {
		return first_party_executant_name;
	}

	public void setFirst_party_executant_name(String first_party_executant_name) {
		this.first_party_executant_name = first_party_executant_name;
	}

	@Column(name = "first_party_executant_capacity")
	public String getFirst_party_executant_capacity() {
		return first_party_executant_capacity;
	}

	public void setFirst_party_executant_capacity(
			String first_party_executant_capacity) {
		this.first_party_executant_capacity = first_party_executant_capacity;
	}

	@Column(name = "district_id")
	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	
	

	@Column(name = "dsr_location_desc")
	public String getDsr_location_desc() {
		return dsr_location_desc;
	}

	public void setDsr_location_desc(String dsr_location_desc) {
		this.dsr_location_desc = dsr_location_desc;
	}
	
	
	

	@Column(name = "token_time")
	public Date getToken_time() {
		return token_time;
	}

	public void setToken_time(Date token_time) {
		this.token_time = token_time;
	}

	@Column(name = "stamp_type")
	public String getStamp_type() {
		return stamp_type;
	}

	public void setStamp_type(String stamp_type) {
		this.stamp_type = stamp_type;
	}

	@Column(name = "stamp_pages_no")
	public int getStamp_pages_no() {
		return stamp_pages_no;
	}

	public void setStamp_pages_no(int stamp_pages_no) {
		this.stamp_pages_no = stamp_pages_no;
	}

	@Column(name = "stamp_no_with_val")
	public String getStamp_no_with_val() {
		return stamp_no_with_val;
	}

	public void setStamp_no_with_val(String stamp_no_with_val) {
		this.stamp_no_with_val = stamp_no_with_val;
	}



	@Column(name = "original_deed_total_page_no")
	public int getOriginal_deed_total_page_no() {
		return original_deed_total_page_no;
	}

	public void setOriginal_deed_total_page_no(int original_deed_total_page_no) {
		this.original_deed_total_page_no = original_deed_total_page_no;
	}
	
	@Column(name = "deal_amount")
	public BigDecimal getDeal_amount() {
		return deal_amount;
	}

	public void setDeal_amount(BigDecimal deal_amount) {
		this.deal_amount = deal_amount;
	}

	@Column(name = "e_registration_id")
	public String getE_registration_id() {
		return e_registration_id;
	}

	public void setE_registration_id(String e_registration_id) {
		this.e_registration_id = e_registration_id;
	}

	@Column(name = "considered_amount")
	public BigDecimal getConsidered_amount() {
		return considered_amount;
	}

	public void setConsidered_amount(BigDecimal considered_amount) {
		this.considered_amount = considered_amount;
	}

	@Column(name = "paid_amount")
	public BigDecimal getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(BigDecimal paid_amount) {
		this.paid_amount = paid_amount;
	}

	@Column(name = "due_amount")
	public BigDecimal getDue_amount() {
		return due_amount;
	}

	public void setDue_amount(BigDecimal due_amount) {
		this.due_amount = due_amount;
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

	@Column(name = "deed_category_id")
	public int getDeed_category_id() {
		return deed_category_id;
	}

	public void setDeed_category_id(int deed_category_id) {
		this.deed_category_id = deed_category_id;
	}
	@Column(name = "deed_type_id")
	public int getDeed_type_id() {
		return deed_type_id;
	}

	public void setDeed_type_id(int deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	@Column(name = "total_stamp_value")
	public BigDecimal getTotal_stamp_value() {
		return total_stamp_value;
	}

	public void setTotal_stamp_value(BigDecimal total_stamp_value) {
		this.total_stamp_value = total_stamp_value;
	}

	
	
	@Column(name = "aa_rent")
	public BigDecimal getAa_rent() {
		return aa_rent;
	}

	public void setAa_rent(BigDecimal aa_rent) {
		this.aa_rent = aa_rent;
	}

	@Column(name = "premium_amount")
	public BigDecimal getPremium_amount() {
		return premium_amount;
	}

	public void setPremium_amount(BigDecimal premium_amount) {
		this.premium_amount = premium_amount;
	}

	@Column(name = "cost_of_building")
	public BigDecimal getCost_of_building() {
		return cost_of_building;
	}

	public void setCost_of_building(BigDecimal cost_of_building) {
		this.cost_of_building = cost_of_building;
	}

	
	@Column(name = "chalan_page_count")
	public int getChalan_page_count() {
		return chalan_page_count;
	}

	public void setChalan_page_count(int chalan_page_count) {
		this.chalan_page_count = chalan_page_count;
	}

	@Column(name = "chalan_amount")
	public BigDecimal getChalan_amount() {
		return chalan_amount;
	}

	public void setChalan_amount(BigDecimal chalan_amount) {
		this.chalan_amount = chalan_amount;
	}

	@Column(name = "treasury_stamp_page_no")
	public int getTreasury_stamp_page_no() {
		return treasury_stamp_page_no;
	}

	public void setTreasury_stamp_page_no(int treasury_stamp_page_no) {
		this.treasury_stamp_page_no = treasury_stamp_page_no;
	}

	@Column(name = "extra_stamp_type")
	public String getExtra_stamp_type() {
		return extra_stamp_type;
	}

	public void setExtra_stamp_type(String extra_stamp_type) {
		this.extra_stamp_type = extra_stamp_type;
	}

	@Column(name = "extra_stamp_count")
	public int getExtra_stamp_count() {
		return extra_stamp_count;
	}

	public void setExtra_stamp_count(int extra_stamp_count) {
		this.extra_stamp_count = extra_stamp_count;
	}

	@Column(name = "t_cp_permission")
	public String getT_cp_permission() {
		return t_cp_permission;
	}
	public void setT_cp_permission(String t_cp_permission) {
		this.t_cp_permission = t_cp_permission;
	}

	@Column(name = "t_cp_no")
	public String getT_cp_no() {
		return t_cp_no;
	}
	public void setT_cp_no(String t_cp_no) {
		this.t_cp_no = t_cp_no;
	}
	
	@Column(name = "t_cp_date")
	public Date getT_cp_date() {
		return t_cp_date;
	}
	public void setT_cp_date(Date t_cp_date) {
		this.t_cp_date = t_cp_date;
	}
	
	@Column(name = "property_permission")
	public String getProperty_permission() {
		return property_permission;
	}
	public void setProperty_permission(String property_permission) {
		this.property_permission = property_permission;
	}
	
	@Column(name = "property_permission_no")
	public String getProperty_permission_no() {
		return property_permission_no;
	}
	public void setProperty_permission_no(String property_permission_no) {
		this.property_permission_no = property_permission_no;
	}
    
	
	@Column(name = "property_permission_date")
	public Date getProperty_permission_date() {
		return property_permission_date;
	}
	public void setProperty_permission_date(Date property_permission_date) {
		this.property_permission_date = property_permission_date;
	}

	
	@Column(name = "rda_permission")
	public String getRda_permission() {
		return rda_permission;
	}
	public void setRda_permission(String rda_permission) {
		this.rda_permission = rda_permission;
	}
	
	@Column(name = "rda_permission_no")
	public String getRda_permission_no() {
		return rda_permission_no;
	}
	public void setRda_permission_no(String rda_permission_no) {
		this.rda_permission_no = rda_permission_no;
	}
	
	@Column(name = "rda_permission_date")
	public Date getRda_permission_date() {
		return rda_permission_date;
	}
	public void setRda_permission_date(Date rda_permission_date) {
		this.rda_permission_date = rda_permission_date;
	}

	
	@Column(name="app_date")
	public Date getApp_date() {
		return app_date;
	}
	public void setApp_date(Date app_date) {
		this.app_date = app_date;
	}

	@Column(name="app_time")
	public String getApp_time() {
		return app_time;
	}
	public void setApp_time(String app_time) {
		this.app_time = app_time;
	}
}