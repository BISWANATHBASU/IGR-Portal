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
@Table(name = "property_detail")
public class propertyDetailModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int  property_detail_id;
	private int  area_master_id; 
	private int  lang_code;
	private int  district_id;
	private String  area_type;
	private String  area_type_name;
	private int  ward_hal_no;
	private String  ward_vill_name;
	private String  locality_name;
	private String  mohalla_vill_name;
	private String  khata_no;
	private String  plot_no;
	private BigDecimal  area_volume;
	private BigDecimal  min_val;
	private int  propert_type;
	private String  token_no;
	private int dsr_location;
	private Date  token_date;
	private int  created_by;
	private Date  created_date;
	private int  updated_by;
	private Date  updated_date;
	private String khasra_no;
	private String loan_book_no;
	private String north_boundary;
	private String east_boundary;
	private String south_boundary;
	private String west_boundary;
	private String tahaseel;
	private String revenue_district;
	private String configuration_land;
	private String purpose_land;
	private String area_unit;
	private BigDecimal  rent;
	private int no_of_tubewell;
	private int no_of_well;
	private BigDecimal  total_area_volume;
	private String total_area_unit;
	private String lr_ri_code;
	private String lr_vill_code;
	private String block_no;
	private String khasra_type;
	private String lr_najool_tahaseel;
	private String lr_najool_village;
	private String lr_najool_ward;
	private String lr_najool_sheet;
	private BigDecimal  remaining_area;
	
	
	
	
	
	@Id
	@Column(name = "property_detail_id")
	@SequenceGenerator(name = "property_detail_seq", sequenceName = "property_detail_property_detail_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_detail_seq")
	public int getProperty_detail_id() {
		return property_detail_id;
	}
	public void setProperty_detail_id(int property_detail_id) {
		this.property_detail_id = property_detail_id;
	}
	
	@Column(name = "area_master_id")
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
	
	@Column(name = "khata_no")
	public String getKhata_no() {
		return khata_no;
	}
	public void setKhata_no(String khata_no) {
		this.khata_no = khata_no;
	}
	
	@Column(name = "plot_no")
	public String getPlot_no() {
		return plot_no;
	}
	public void setPlot_no(String plot_no) {
		this.plot_no = plot_no;
	}
	
	@Column(name = "area_volume")
	public BigDecimal getArea_volume() {
		return area_volume;
	}
	public void setArea_volume(BigDecimal area_volume) {
		this.area_volume = area_volume;
	}
	
	@Column(name = "min_val")
	public BigDecimal getMin_val() {
		return min_val;
	}
	public void setMin_val(BigDecimal min_val) {
		this.min_val = min_val;
	}
	

	@Column(name = "propert_type")
	public int getPropert_type() {
		return propert_type;
	}
	public void setPropert_type(int propert_type) {
		this.propert_type = propert_type;
	}
	
	@Column(name = "token_no")
	public String getToken_no() {
		return token_no;
	}
	
	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}
	
	@Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	@Column(name = "token_date")
	public Date getToken_date() {
		return token_date;
	}
	public void setToken_date(Date token_date) {
		this.token_date = token_date;
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
	
	@Column(name = "khasra_no")
	public String getKhasra_no() {
		return khasra_no;
	}
	public void setKhasra_no(String khasra_no) {
		this.khasra_no = khasra_no;
	}
	
	@Column(name = "loan_book_no")
	public String getLoan_book_no() {
		return loan_book_no;
	}
	public void setLoan_book_no(String loan_book_no) {
		this.loan_book_no = loan_book_no;
	}
	
	
	@Column(name = "north_boundary")
	public String getNorth_boundary() {
		return north_boundary;
	}
	public void setNorth_boundary(String north_boundary) {
		this.north_boundary = north_boundary;
	}
	
	
	@Column(name = "east_boundary")
	public String getEast_boundary() {
		return east_boundary;
	}
	public void setEast_boundary(String east_boundary) {
		this.east_boundary = east_boundary;
	}
	
	@Column(name = "south_boundary")
	public String getSouth_boundary() {
		return south_boundary;
	}
	public void setSouth_boundary(String south_boundary) {
		this.south_boundary = south_boundary;
	}
	
	@Column(name = "west_boundary")
	public String getWest_boundary() {
		return west_boundary;
	}
	public void setWest_boundary(String west_boundary) {
		this.west_boundary = west_boundary;
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
	
	@Column(name = "configuration_land")
	public String getConfiguration_land() {
		return configuration_land;
	}
	public void setConfiguration_land(String configuration_land) {
		this.configuration_land = configuration_land;
	}
	
	@Column(name = "purpose_land")
	public String getPurpose_land() {
		return purpose_land;
	}
	public void setPurpose_land(String purpose_land) {
		this.purpose_land = purpose_land;
	}
	
	@Column(name = "area_unit")
	public String getArea_unit() {
		return area_unit;
	}
	public void setArea_unit(String area_unit) {
		this.area_unit = area_unit;
	}
	
	@Column(name = "rent")
	public BigDecimal getRent() {
		return rent;
	}
	public void setRent(BigDecimal rent) {
		this.rent = rent;
	}
	
	@Column(name = "no_of_tubewell")
	public int getNo_of_tubewell() {
		return no_of_tubewell;
	}
	public void setNo_of_tubewell(int no_of_tubewell) {
		this.no_of_tubewell = no_of_tubewell;
	}
	
	@Column(name = "no_of_well")
	public int getNo_of_well() {
		return no_of_well;
	}
	public void setNo_of_well(int no_of_well) {
		this.no_of_well = no_of_well;
	}
	
	@Column(name = "total_area_volume")
	public BigDecimal getTotal_area_volume() {
		return total_area_volume;
	}
	public void setTotal_area_volume(BigDecimal total_area_volume) {
		this.total_area_volume = total_area_volume;
	}
	
	@Column(name = "total_area_unit")
	public String getTotal_area_unit() {
		return total_area_unit;
	}
	public void setTotal_area_unit(String total_area_unit) {
		this.total_area_unit = total_area_unit;
	}
	
	@Column(name = "lr_ri_code")
	public String getLr_ri_code() {
		return lr_ri_code;
	}
	public void setLr_ri_code(String lr_ri_code) {
		this.lr_ri_code = lr_ri_code;
	}
	
	@Column(name = "lr_vill_code")
	public String getLr_vill_code() {
		return lr_vill_code;
	}
	public void setLr_vill_code(String lr_vill_code) {
		this.lr_vill_code = lr_vill_code;
	}
	
	@Column(name = "block_no")
	public String getBlock_no() {
		return block_no;
	}
	public void setBlock_no(String block_no) {
		this.block_no = block_no;
	}
	
	
	
	@Column(name = "khasra_type")
	public String getKhasra_type() {
		return khasra_type;
	}
	public void setKhasra_type(String khasra_type) {
		this.khasra_type = khasra_type;
	}
	
	
	@Column(name = "lr_najool_tahaseel")
	public String getLr_najool_tahaseel() {
		return lr_najool_tahaseel;
	}
	public void setLr_najool_tahaseel(String lr_najool_tahaseel) {
		this.lr_najool_tahaseel = lr_najool_tahaseel;
	}
	
	
	@Column(name = "lr_najool_village")
	public String getLr_najool_village() {
		return lr_najool_village;
	}
	public void setLr_najool_village(String lr_najool_village) {
		this.lr_najool_village = lr_najool_village;
	}
	
	@Column(name = "lr_najool_ward")
	public String getLr_najool_ward() {
		return lr_najool_ward;
	}
	public void setLr_najool_ward(String lr_najool_ward) {
		this.lr_najool_ward = lr_najool_ward;
	}
	
	
	@Column(name = "lr_najool_sheet")
	public String getLr_najool_sheet() {
		return lr_najool_sheet;
	}
	public void setLr_najool_sheet(String lr_najool_sheet) {
		this.lr_najool_sheet = lr_najool_sheet;
	}
	
	
	@Column(name = "remaining_area")
	public BigDecimal getRemaining_area() {
		return remaining_area;
	}
	public void setRemaining_area(BigDecimal remaining_area) {
		this.remaining_area = remaining_area;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}