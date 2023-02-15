package com.igr.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "e_challan_response")

public class eChallanRequestModel implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private int slno;
	private String userid;
	private String usrname;
	private String name;
	private String dept;

	private String major_head;
	private String submajor_head;
	private String minor_head;
	private String sub_head;
	private String add_line1;

	private String add_line2;
	private String add_line3;
	private String add_line4;
	private String dist_add;
	private String state;

	private String pincode;
	private String email;
	private String ph_no;
	private String district;
	private String assmt_year;

	private String from_period;
	private String to_period;
	private String purpose;
	private String office;
	private String engine_no;

	private String chasis_no;
	private String ddocode;
	private String int_code;
	private String deptref_no;
	private String entry_datetime;

	private Date entry_date;
	private String tin;

	@Id
	@Column(name = "slno")
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}

	@Column(name = "userid")
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "usrname")
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "dept")
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(name = "major_head")
	public String getMajor_head() {
		return major_head;
	}
	public void setMajor_head(String major_head) {
		this.major_head = major_head;
	}

	@Column(name = "submajor_head")
	public String getSubmajor_head() {
		return submajor_head;
	}
	public void setSubmajor_head(String submajor_head) {
		this.submajor_head = submajor_head;
	}

	@Column(name = "minor_head")
	public String getMinor_head() {
		return minor_head;
	}
	public void setMinor_head(String minor_head) {
		this.minor_head = minor_head;
	}

	@Column(name = "sub_head")
	public String getSub_head() {
		return sub_head;
	}
	public void setSub_head(String sub_head) {
		this.sub_head = sub_head;
	}

	@Column(name = "add_line1")
	public String getAdd_line1() {
		return add_line1;
	}
	public void setAdd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}

	@Column(name = "add_line2")
	public String getAdd_line2() {
		return add_line2;
	}
	public void setAdd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}

	@Column(name = "add_line3")
	public String getAdd_line3() {
		return add_line3;
	}
	public void setAdd_line3(String add_line3) {
		this.add_line3 = add_line3;
	}

	@Column(name = "add_line4")
	public String getAdd_line4() {
		return add_line4;
	}
	public void setAdd_line4(String add_line4) {
		this.add_line4 = add_line4;
	}

	@Column(name = "dist_add")
	public String getDist_add() {
		return dist_add;
	}
	public void setDist_add(String dist_add) {
		this.dist_add = dist_add;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "pincode")
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ph_no")
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}

	@Column(name = "district")
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "assmt_year")
	public String getAssmt_year() {
		return assmt_year;
	}
	public void setAssmt_year(String assmt_year) {
		this.assmt_year = assmt_year;
	}

	@Column(name = "from_period")
	public String getFrom_period() {
		return from_period;
	}
	public void setFrom_period(String from_period) {
		this.from_period = from_period;
	}

	@Column(name = "to_period")
	public String getTo_period() {
		return to_period;
	}
	public void setTo_period(String to_period) {
		this.to_period = to_period;
	}

	@Column(name = "purpose")
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "office")
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}

	@Column(name = "engine_no")
	public String getEngine_no() {
		return engine_no;
	}
	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}

	@Column(name = "chasis_no")
	public String getChasis_no() {
		return chasis_no;
	}
	public void setChasis_no(String chasis_no) {
		this.chasis_no = chasis_no;
	}

	@Column(name = "ddocode")
	public String getDdocode() {
		return ddocode;
	}
	public void setDdocode(String ddocode) {
		this.ddocode = ddocode;
	}

	@Column(name = "int_code")
	public String getInt_code() {
		return int_code;
	}
	public void setInt_code(String int_code) {
		this.int_code = int_code;
	}

	@Column(name = "deptref_no")
	public String getDeptref_no() {
		return deptref_no;
	}
	public void setDeptref_no(String deptref_no) {
		this.deptref_no = deptref_no;
	}

	@Column(name = "entry_datetime")
	public String getEntry_datetime() {
		return entry_datetime;
	}
	public void setEntry_datetime(String entry_datetime) {
		this.entry_datetime = entry_datetime;
	}

	@Column(name = "entry_date")
	public Date getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	@Column(name = "tin")
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
}