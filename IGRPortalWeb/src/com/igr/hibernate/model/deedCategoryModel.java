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
@Table(name = "deed_category")
public class deedCategoryModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int deed_category_id;
	private int deed_type_id;
	private String category_name;
	private BigDecimal stamp_fee;
	private String stamp_unit;
	private int created_by;
	private Date created_datetime;
	private int updated_by;
	private Date updated_datetime;
	private int lang_id;
	private boolean is_active;
	private BigDecimal addl_stamp_value;
	private BigDecimal cess_value;
	private String addl_stamp_unit;
	private boolean stamp_val_required;
	private BigDecimal max_stamp_value;
	private boolean guideline_val_required;
	
	
	
	
	

	@Id
	@Column(name = "deed_category_id")
	@SequenceGenerator(name = "deed_category_seq", sequenceName = "deed_category_deed_category_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deed_category_seq")
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
	
	@Column(name = "category_name")
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	@Column(name = "stamp_fee")
	public BigDecimal getStamp_fee() {
		return stamp_fee;
	}
	public void setStamp_fee(BigDecimal stamp_fee) {
		this.stamp_fee = stamp_fee;
	}
	
	@Column(name = "stamp_unit")
	public String getStamp_unit() {
		return stamp_unit;
	}
	public void setStamp_unit(String stamp_unit) {
		this.stamp_unit = stamp_unit;
	}
	
	@Column(name = "created_by")
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	@Column(name = "created_datetime")
	public Date getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}
	@Column(name = "updated_by")
	public int getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	@Column(name = "updated_datetime")
	public Date getUpdated_datetime() {
		return updated_datetime;
	}
	public void setUpdated_datetime(Date updated_datetime) {
		this.updated_datetime = updated_datetime;
	}
	
	@Column(name = "lang_id")
	public int getLang_id() {
		return lang_id;
	}
	public void setLang_id(int lang_id) {
		this.lang_id = lang_id;
	}
	@Column(name = "is_active")
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	
	@Column(name = "addl_stamp_value")
	public BigDecimal getAddl_stamp_value() {
		return addl_stamp_value;
	}
	public void setAddl_stamp_value(BigDecimal addl_stamp_value) {
		this.addl_stamp_value = addl_stamp_value;
	}
	@Column(name = "cess_value")
	public BigDecimal getCess_value() {
		return cess_value;
	}
	public void setCess_value(BigDecimal cess_value) {
		this.cess_value = cess_value;
	}
	@Column(name = "addl_stamp_unit")
	public String getAddl_stamp_unit() {
		return addl_stamp_unit;
	}
	public void setAddl_stamp_unit(String addl_stamp_unit) {
		this.addl_stamp_unit = addl_stamp_unit;
	}
	
	@Column(name = "stamp_val_required")
	public boolean isStamp_val_required() {
		return stamp_val_required;
	}
	public void setStamp_val_required(boolean stamp_val_required) {
		this.stamp_val_required = stamp_val_required;
	}
	
	@Column(name = "max_stamp_value")
	public BigDecimal getMax_stamp_value() {
		return max_stamp_value;
	}
	public void setMax_stamp_value(BigDecimal max_stamp_value) {
		this.max_stamp_value = max_stamp_value;
	}
	
	@Column(name = "guideline_val_required")
	public boolean isGuideline_val_required() {
		return guideline_val_required;
	}
	public void setGuideline_val_required(boolean guideline_val_required) {
		this.guideline_val_required = guideline_val_required;
	}
	
	
}