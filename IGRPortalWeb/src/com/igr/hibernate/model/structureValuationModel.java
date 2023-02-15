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
@Table(name = "structure_valuation")
public class structureValuationModel implements Serializable {

	private static final long serialVersionUID = -1L;

	 private int structure_valuation_id;	
	 private String use_construction;
	 private String type_construction;	
	 private String area_type;		
	 private int lang_code;			
	 private int dsr_location; 		
	 private String token_no;			
	 private Date token_date;		
	 private String structure_name;		
	 private String structure_no;		
	 private String floor;			
	 private int created_by;		
	 private Date created_date;		
	 private int updated_by;		
	 private Date updated_date;
	 private BigDecimal area_volume;
	 private BigDecimal valuation;
	 private int ageOfStructure;
	 private String structure;
	 private String structure_unit;
	 private String structure_owner;
	 
	 
	 	@Id
		@Column(name = "structure_valuation_id")
		@SequenceGenerator(name = "structure_valuation_seq", sequenceName = "structure_valuation_structure_valuation_id_seq", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "structure_valuation_seq")
	public int getStructure_valuation_id() {
		return structure_valuation_id;
	}
	public void setStructure_valuation_id(int structure_valuation_id) {
		this.structure_valuation_id = structure_valuation_id;
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
	@Column(name = "area_type")
	public String getArea_type() {
		return area_type;
	}
	public void setArea_type(String area_type) {
		this.area_type = area_type;
	}
	@Column(name = "lang_code")
	public int getLang_code() {
		return lang_code;
	}
	public void setLang_code(int lang_code) {
		this.lang_code = lang_code;
	}
	@Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
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
	
	@Column(name = "structure_name")
	public String getStructure_name() {
		return structure_name;
	}
	public void setStructure_name(String structure_name) {
		this.structure_name = structure_name;
	}
	
	@Column(name = "structure_no")
	public String getStructure_no() {
		return structure_no;
	}
	public void setStructure_no(String structure_no) {
		this.structure_no = structure_no;
	}
	
	@Column(name = "floor")
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
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
	
	@Column(name = "area_volume")
	public BigDecimal getArea_volume() {
		return area_volume;
	}
	public void setArea_volume(BigDecimal area_volume) {
		this.area_volume = area_volume;
	}
	
	@Column(name = "valuation")
	public BigDecimal getValuation() {
		return valuation;
	}
	public void setValuation(BigDecimal valuation) {
		this.valuation = valuation;
	}
	
	@Column(name = "structure_age")
	public int getAgeOfStructure() {
		return ageOfStructure;
	}
	public void setAgeOfStructure(int ageOfStructure) {
		this.ageOfStructure = ageOfStructure;
	}
	
	@Column(name = "structure")
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	
	@Column(name = "structure_unit")
	public String getStructure_unit() {
		return structure_unit;
	}
	public void setStructure_unit(String structure_unit) {
		this.structure_unit = structure_unit;
	}
	
	@Column(name = "structure_owner")
	public String getStructure_owner() {
		return structure_owner;
	}
	public void setStructure_owner(String structure_owner) {
		this.structure_owner = structure_owner;
	}		


	
	
	
	
	
	
	
	
	

}