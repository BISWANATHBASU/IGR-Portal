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
import java.math.BigDecimal;

@Entity
@Table(name = "fee_collection_portal")
public class feeCollectionPortalModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int fee_collection_id;
	private String token_no;
	private Date token_date;
	private int dsr_location;
	private String party_name;
	private int district_id;
	private String dsr_location_desc;
	private Date token_time;
	private BigDecimal fee1_amount;
	private BigDecimal fee2_amount;
	private int lang_code;
	private int created_by;
	private Date created_date;
	private int updated_by;
	private Date updated_date;
	private String scroll_no;
	private BigDecimal visit_fee;
	private String cancel_cause;
	private String verification_signature;
	private BigDecimal digar_tahasil_fee;
	private BigDecimal calculation_on;
	private BigDecimal paid_amount;
	private String remarks;

	@Id
	@Column(name = "fee_collection_id")
	@SequenceGenerator(name = "fee_collection_id_seq", sequenceName = "fee_collection_fee_collection_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_collection_id_seq")
	public int getFee_collection_id() {
		return fee_collection_id;
	}

	public void setFee_collection_id(int fee_collection_id) {
		this.fee_collection_id = fee_collection_id;
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

	@Column(name = "party_name")
	public String getParty_name() {
		return party_name;
	}

	public void setParty_name(String party_name) {
		this.party_name = party_name;
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

	@Column(name = "fee1_amount")
	public BigDecimal getFee1_amount() {
		return fee1_amount;
	}

	public void setFee1_amount(BigDecimal fee1_amount) {
		this.fee1_amount = fee1_amount;
	}

	@Column(name = "fee2_amount")
	public BigDecimal getFee2_amount() {
		return fee2_amount;
	}

	public void setFee2_amount(BigDecimal fee2_amount) {
		this.fee2_amount = fee2_amount;
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

	@Column(name = "scroll_no")
	public String getScroll_no() {
		return scroll_no;
	}

	public void setScroll_no(String scroll_no) {
		this.scroll_no = scroll_no;
	}

	
	@Column(name = "visit_fee")
	public BigDecimal getVisit_fee() {
		return visit_fee;
	}

	public void setVisit_fee(BigDecimal visit_fee) {
		this.visit_fee = visit_fee;
	}

	
	@Column(name = "cancel_cause")
	public String getCancel_cause() {
		return cancel_cause;
	}

	public void setCancel_cause(String cancel_cause) {
		this.cancel_cause = cancel_cause;
	}

	@Column(name = "verification_signature")
	public String getVerification_signature() {
		return verification_signature;
	}

	public void setVerification_signature(String verification_signature) {
		this.verification_signature = verification_signature;
	}

	
	@Column(name = "digar_tahasil_fee")
	public BigDecimal getDigar_tahasil_fee() {
		return digar_tahasil_fee;
	}

	public void setDigar_tahasil_fee(BigDecimal digar_tahasil_fee) {
		this.digar_tahasil_fee = digar_tahasil_fee;
	}

	@Column(name = "calculation_on")
	public BigDecimal getCalculation_on() {
		return calculation_on;
	}

	public void setCalculation_on(BigDecimal calculation_on) {
		this.calculation_on = calculation_on;
	}

	
	@Column(name = "paid_amount")
	public BigDecimal getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(BigDecimal paid_amount) {
		this.paid_amount = paid_amount;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	
	

}