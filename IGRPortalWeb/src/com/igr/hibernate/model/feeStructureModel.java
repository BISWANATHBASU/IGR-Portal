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
@Table(name = "fee_structure")
public class feeStructureModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int fee_id;
	private int deed_category_id;
	private int deed_type_id;
	private String fee_name;
	private BigDecimal start_slab;
	private BigDecimal end_slab;
	private BigDecimal rate;
	private boolean slab_end;
	private int created_by;
	private Date created_datetime;
	private int updated_by;
	private Date updated_datetime;
	private int lang_id;
	private boolean is_active;
	private String calc_type;
	
	
	
	
	
	
	
	@Id
	@Column(name = "fee_id")
	@SequenceGenerator(name = "fee_structure_seq", sequenceName = "fee_structure_fee_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_structure_seq")
	public int getFee_id() {
		return fee_id;
	}
	public void setFee_id(int fee_id) {
		this.fee_id = fee_id;
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
	
	
	@Column(name = "fee_name")
	public String getFee_name() {
		return fee_name;
	}
	public void setFee_name(String fee_name) {
		this.fee_name = fee_name;
	}
	
	@Column(name = "start_slab")
	public BigDecimal getStart_slab() {
		return start_slab;
	}
	public void setStart_slab(BigDecimal start_slab) {
		this.start_slab = start_slab;
	}
	
	@Column(name = "end_slab")
	public BigDecimal getEnd_slab() {
		return end_slab;
	}
	public void setEnd_slab(BigDecimal end_slab) {
		this.end_slab = end_slab;
	}
	
	@Column(name = "rate")
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	
	@Column(name = "slab_end")
	public boolean isSlab_end() {
		return slab_end;
	}
	public void setSlab_end(boolean slab_end) {
		this.slab_end = slab_end;
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
	

	@Column(name = "calc_type")
	public String getCalc_type() {
		return calc_type;
	}
	public void setCalc_type(String calc_type) {
		this.calc_type = calc_type;
	}
	
}