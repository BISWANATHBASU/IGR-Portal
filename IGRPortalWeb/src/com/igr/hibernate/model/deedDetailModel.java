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
@Table(name = "deed_detail")
public class deedDetailModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private String presenter_name;
	private String firstparty_executant_name;
	private String firstparty_executant_capacity;
	private int district_id;
	private String dsr_location_desc;
	private Date token_time;
	private int deed_category_id;
	private int deed_type_id;
	private BigDecimal considered_amount;
	private BigDecimal doc_min_amount;
	private BigDecimal applicable_stamp_value;
	private BigDecimal presented_stamp_value;
	private int no_total_pages;
	private String special_deed_detail;
	private String e_registration_code;
	private String rel_last_reg_record;
	private Date rel_last_reg_date;
	private String rel_last_reg_no;
	private String rel_last_reg_pow_of_atr;
	private Date rel_last_reg_pow_of_atr_date;
	private String rel_last_reg_pow_of_atr_reg_no;
	private int lang_code;
	private int created_by;
	private Date created_date;
	private int updated_by;
	private Date updated_date;
	private BigDecimal base_stamp_fee;
	private BigDecimal addl_stamp_fee;
	private BigDecimal cess;
	private int check_slip_count;
	private String remarks;

	private String first_party_signature;
	private String second_party_signature;
	private String identifier_signature;
	private String permission_no;
	private deedDetailPKModel deedDetailPK;
	
	private BigDecimal other_stamp_fee;
	

	@EmbeddedId
	public deedDetailPKModel getDeedDetailPK() {
		return deedDetailPK;
	}

	public void setDeedDetailPK(deedDetailPKModel deedDetailPK) {
		this.deedDetailPK = deedDetailPK;
	}

	@Column(name = "presenter_name")
	public String getPresenter_name() {
		return presenter_name;
	}

	public void setPresenter_name(String presenter_name) {
		this.presenter_name = presenter_name;
	}

	@Column(name = "firstparty_executant_name")
	public String getFirstparty_executant_name() {
		return firstparty_executant_name;
	}

	public void setFirstparty_executant_name(String firstparty_executant_name) {
		this.firstparty_executant_name = firstparty_executant_name;
	}

	@Column(name = "firstparty_executant_capacity")
	public String getFirstparty_executant_capacity() {
		return firstparty_executant_capacity;
	}

	public void setFirstparty_executant_capacity(String firstparty_executant_capacity) {
		this.firstparty_executant_capacity = firstparty_executant_capacity;
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

	@Column(name = "considered_amount")
	public BigDecimal getConsidered_amount() {
		return considered_amount;
	}

	public void setConsidered_amount(BigDecimal considered_amount) {
		this.considered_amount = considered_amount;
	}

	@Column(name = "doc_min_amount")
	public BigDecimal getDoc_min_amount() {
		return doc_min_amount;
	}

	public void setDoc_min_amount(BigDecimal doc_min_amount) {
		this.doc_min_amount = doc_min_amount;
	}

	@Column(name = "applicable_stamp_value")
	public BigDecimal getApplicable_stamp_value() {
		return applicable_stamp_value;
	}

	public void setApplicable_stamp_value(BigDecimal applicable_stamp_value) {
		this.applicable_stamp_value = applicable_stamp_value;
	}

	@Column(name = "presented_stamp_value")
	public BigDecimal getPresented_stamp_value() {
		return presented_stamp_value;
	}

	public void setPresented_stamp_value(BigDecimal presented_stamp_value) {
		this.presented_stamp_value = presented_stamp_value;
	}

	@Column(name = "no_total_pages")
	public int getNo_total_pages() {
		return no_total_pages;
	}

	public void setNo_total_pages(int no_total_pages) {
		this.no_total_pages = no_total_pages;
	}

	@Column(name = "special_deed_detail")
	public String getSpecial_deed_detail() {
		return special_deed_detail;
	}

	public void setSpecial_deed_detail(String special_deed_detail) {
		this.special_deed_detail = special_deed_detail;
	}

	@Column(name = "e_registration_code")
	public String getE_registration_code() {
		return e_registration_code;
	}

	public void setE_registration_code(String e_registration_code) {
		this.e_registration_code = e_registration_code;
	}

	@Column(name = "rel_last_reg_record")
	public String getRel_last_reg_record() {
		return rel_last_reg_record;
	}

	public void setRel_last_reg_record(String rel_last_reg_record) {
		this.rel_last_reg_record = rel_last_reg_record;
	}

	@Column(name = "rel_last_reg_date")
	public Date getRel_last_reg_date() {
		return rel_last_reg_date;
	}

	public void setRel_last_reg_date(Date rel_last_reg_date) {
		this.rel_last_reg_date = rel_last_reg_date;
	}

	@Column(name = "rel_last_reg_no")
	public String getRel_last_reg_no() {
		return rel_last_reg_no;
	}

	public void setRel_last_reg_no(String rel_last_reg_no) {
		this.rel_last_reg_no = rel_last_reg_no;
	}

	@Column(name = "rel_last_reg_pow_of_atr")
	public String getRel_last_reg_pow_of_atr() {
		return rel_last_reg_pow_of_atr;
	}

	public void setRel_last_reg_pow_of_atr(String rel_last_reg_pow_of_atr) {
		this.rel_last_reg_pow_of_atr = rel_last_reg_pow_of_atr;
	}

	@Column(name = "rel_last_reg_pow_of_atr_date")
	public Date getRel_last_reg_pow_of_atr_date() {
		return rel_last_reg_pow_of_atr_date;
	}

	public void setRel_last_reg_pow_of_atr_date(Date rel_last_reg_pow_of_atr_date) {
		this.rel_last_reg_pow_of_atr_date = rel_last_reg_pow_of_atr_date;
	}

	@Column(name = "rel_last_reg_pow_of_atr_reg_no")
	public String getRel_last_reg_pow_of_atr_reg_no() {
		return rel_last_reg_pow_of_atr_reg_no;
	}

	public void setRel_last_reg_pow_of_atr_reg_no(String rel_last_reg_pow_of_atr_reg_no) {
		this.rel_last_reg_pow_of_atr_reg_no = rel_last_reg_pow_of_atr_reg_no;
	}

	@Column(name = "lang_code")
	public int getLang_code() {
		return lang_code;
	}

	public void setLang_code(int lang_code) {
		this.lang_code = lang_code;
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

	@Column(name = "base_stamp_fee")
	public BigDecimal getBase_stamp_fee() {
		return base_stamp_fee;
	}

	public void setBase_stamp_fee(BigDecimal base_stamp_fee) {
		this.base_stamp_fee = base_stamp_fee;
	}

	@Column(name = "addl_stamp_fee")
	public BigDecimal getAddl_stamp_fee() {
		return addl_stamp_fee;
	}

	public void setAddl_stamp_fee(BigDecimal addl_stamp_fee) {
		this.addl_stamp_fee = addl_stamp_fee;
	}

	@Column(name = "cess")
	public BigDecimal getCess() {
		return cess;
	}

	public void setCess(BigDecimal cess) {
		this.cess = cess;
	}

	@Column(name = "check_slip_count")
	public int getCheck_slip_count() {
		return check_slip_count;
	}

	public void setCheck_slip_count(int check_slip_count) {
		this.check_slip_count = check_slip_count;
	}

	@Column(name = "first_party_signature")
	public String getFirst_party_signature() {
		return first_party_signature;
	}

	public void setFirst_party_signature(String first_party_signature) {
		this.first_party_signature = first_party_signature;
	}

	@Column(name = "second_party_signature")
	public String getSecond_party_signature() {
		return second_party_signature;
	}

	public void setSecond_party_signature(String second_party_signature) {
		this.second_party_signature = second_party_signature;
	}

	@Column(name = "identifier_signature")
	public String getIdentifier_signature() {
		return identifier_signature;
	}

	public void setIdentifier_signature(String identifier_signature) {
		this.identifier_signature = identifier_signature;
	}

	@Column(name = "permission_no")
	public String getPermission_no() {
		return permission_no;
	}

	public void setPermission_no(String permission_no) {
		this.permission_no = permission_no;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "other_stamp_fee")
	public BigDecimal getOther_stamp_fee() {
		return other_stamp_fee;
	}

	public void setOther_stamp_fee(BigDecimal other_stamp_fee) {
		this.other_stamp_fee = other_stamp_fee;
	}
	
	
	
	
	

}