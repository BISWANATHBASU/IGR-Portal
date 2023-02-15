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
@Table(name = "structure_master")
public class propertyStructureMasterModel implements Serializable {

	private static final long serialVersionUID = -1L;
    
	private int structure_master_id;
	private String area_type;
	private String use_construction;
	private String type_construction;
    private BigDecimal rate_per_sqft;
	private int lang_code;
	private int created_by;
	private Date created_date;
	private int update_by;
	private Date update_date;
	private boolean is_active;
	
	
	@Id
	@Column(name = "structure_master_id")
	@SequenceGenerator(name = "structure_seq", sequenceName = "structure_master_structure_master_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "structure_seq")
	public int getStructure_master_id() {
		return structure_master_id;
	}
	
	public void setStructure_master_id(int structure_master_id) {
		this.structure_master_id = structure_master_id;
	}
		
	
	@Column(name = "area_type")
	public String getArea_type() {
		return area_type;
	}
	
	public void setArea_type(String area_type) {
		this.area_type = area_type;
	}
	

	
	@Column(name = "use_construction")
	public String getUse_construction() {
		return use_construction;
	}
	public void setUse_construction(String use_construction) {
		this.use_construction = use_construction;
	}
	
	@Column(name = "type_construction")
	public String getType_construction() {
		return type_construction;
	}
	public void setType_construction(String type_construction) {
		this.type_construction = type_construction;
	}
	

	@Column(name = "rate_per_sqft")
	public BigDecimal getRate_per_sqft() {
		return rate_per_sqft;
	}
	public void setRate_per_sqft(BigDecimal rate_per_sqft) {
		this.rate_per_sqft = rate_per_sqft;
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
	
	@Column(name = "update_by")
	public int getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(int updated_by) {
		this.update_by = updated_by;
	}
	

	@Column(name = "update_date")
	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	@Column(name = "is_active")
   public boolean isIs_active() {
		return is_active;
	}
	

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	
}