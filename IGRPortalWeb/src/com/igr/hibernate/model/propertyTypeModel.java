package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "property_type")
public class propertyTypeModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int property_type_id;
	private String property_type;
	private BigDecimal property_type_val;
	private boolean is_active;
	private int lang_code;
	private int created_by;
	private int update_by;
	private Date update_date;
	private Date created_date;
	private Date valid_upto;
	private int district_id;
	private areaMasterModel areaModel;

	@Id
	@Column(name = "property_type_id")
	@SequenceGenerator(name = "property_type_seq", sequenceName = "property_type_property_type_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_type_seq")
	public int getProperty_type_id() {
		return property_type_id;
	}

	public void setProperty_type_id(int property_type_id) {
		this.property_type_id = property_type_id;
	}

	

	@Column(name = "property_type")
	public String getProperty_type() {
		return property_type;
	}

	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}

	@Column(name = "property_type_val")
	public BigDecimal getProperty_type_val() {
		return property_type_val;
	}

	public void setProperty_type_val(BigDecimal property_type_val) {
		this.property_type_val = property_type_val;
	}

	@Column(name = "is_active")
	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
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

	@Column(name = "update_by")
	public int getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(int update_by) {
		this.update_by = update_by;
	}

	@Column(name = "update_date")
	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	@Column(name = "created_date")
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Column(name = "district_id")
	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "area_master_id", nullable = false)
	public areaMasterModel getAreaModel() {
		return areaModel;
	}

	public void setAreaModel(areaMasterModel areaModel) {
		this.areaModel = areaModel;
	}

	@Column(name="valid_upto")
	public Date getValid_upto() {
		return valid_upto;
	}

	public void setValid_upto(Date valid_upto) {
		this.valid_upto = valid_upto;
	}
	
	
	

}