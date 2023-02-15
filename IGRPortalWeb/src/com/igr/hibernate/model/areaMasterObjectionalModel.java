package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "area_master_objectional")
public class areaMasterObjectionalModel implements Serializable {

	private static final long serialVersionUID = -1L;

	
	private int area_master_id;
	private int lang_code;
	private int district_id;
	private String area_type;
	private String area_type_name;
	private int ward_hal_no;
	private String ward_vill_name;
	private String locality_name;
	private String mohalla_vill_name;
	private int created_by;
	private Date created_date;
	private int updated_by;
	private Date updated_date;
	private String tahaseel;
	private String revenue_district;
    private String global_area_master;
    private String khasra_no;
	private int dsr_location;
	private boolean is_active;
	
	
	
	@Id
	@Column(name = "area_master_id")
	@SequenceGenerator(name = "area_master_objectional_seq", sequenceName = "area_master_objectional_area_master_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_master_objectional_seq")
	public int getArea_master_id() {
		return area_master_id;
	}
	public void setArea_master_id(int area_master_id) {
		this.area_master_id = area_master_id;
	}
	
	
	@Column(name = "lang_code")
	public int getLang_code() {
		return lang_code;
	}
	
	public void setLang_code(int lang_code) {
		this.lang_code = lang_code;
	}
	
	@Column(name = "district_id")
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	
	@Column(name = "area_type")
	public String getArea_type() {
		return area_type;
	}
	public void setArea_type(String area_type) {
		this.area_type = area_type;
	}
	
	
	@Column(name = "area_type_name")
	public String getArea_type_name() {
		return area_type_name;
	}
	public void setArea_type_name(String area_type_name) {
		this.area_type_name = area_type_name;
	}
	
	@Column(name = "ward_hal_no")
	public int getWard_hal_no() {
		return ward_hal_no;
	}
	public void setWard_hal_no(int ward_hal_no) {
		this.ward_hal_no = ward_hal_no;
	}
	
	@Column(name = "ward_vill_name")
	public String getWard_vill_name() {
		return ward_vill_name;
	}
	public void setWard_vill_name(String ward_vill_name) {
		this.ward_vill_name = ward_vill_name;
	}
	
	@Column(name = "locality_name")
	public String getLocality_name() {
		return locality_name;
	}
	public void setLocality_name(String locality_name) {
		this.locality_name = locality_name;
	}
	
	@Column(name = "mohalla_vill_name")
	public String getMohalla_vill_name() {
		return mohalla_vill_name;
	}
	public void setMohalla_vill_name(String mohalla_vill_name) {
		this.mohalla_vill_name = mohalla_vill_name;
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
	
	@Column(name = "tahaseel")
	public String getTahaseel() {
		return tahaseel;
	}
	public void setTahaseel(String tahaseel) {
		this.tahaseel = tahaseel;
	}
	@Column(name = "revenue_district")
	public String getRevenue_district() {
		return revenue_district;
	}
	public void setRevenue_district(String revenue_district) {
		this.revenue_district = revenue_district;
	}
	
	
	@Column(name = "global_area_master")
	public String getGlobal_area_master() {
		return global_area_master;
	}
	public void setGlobal_area_master(String global_area_master) {
		this.global_area_master = global_area_master;
	}
	
	
	@Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	
	@Column(name = "is_active")
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	
	@Column(name = "khasra_no")
	public String getKhasra_no() {
		return khasra_no;
	}
	public void setKhasra_no(String khasra_no) {
		this.khasra_no = khasra_no;
	}
	
	
}