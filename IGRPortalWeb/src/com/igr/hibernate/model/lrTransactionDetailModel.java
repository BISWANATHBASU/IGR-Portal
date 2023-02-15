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

@Entity
@Table(name = "lr_transaction")
public class lrTransactionDetailModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int created_by;
	private Date created_date;
	private int updated_by;
	private Date updated_date;
	private int dsr_location;
	private String token_no;
	private Date token_date;
	private String village_code;
	private String khasra_no;
	private String area;
	private String ocdname;
	private String ocdname1;
	private String ofather;
	private String ofather1;
	private String gender;
	private String ocaste_code;
	private String ocastenm;
	private String oaddr1;
	private String mobileno;
	private String aadharno;
	private String loanpassbook;
	private String nakshaurl;
	private int lr_transaction_id;
	private String b1PDFurl;
	private String p2PDFurl;
	
	
	
	@Id
	@Column(name = "lr_transaction_id")
	@SequenceGenerator(name = "lr_transaction_id_seq", sequenceName = "lr_transaction_lr_transaction_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lr_transaction_id_seq")
	public int getLr_transaction_id() {
		return lr_transaction_id;
	}

	public void setLr_transaction_id(int lr_transaction_id) {
		this.lr_transaction_id = lr_transaction_id;
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

	@Column(name = "village_code")
	public String getVillage_code() {
		return village_code;
	}

	public void setVillage_code(String village_code) {
		this.village_code = village_code;
	}

	@Column(name = "khasra_no")
	public String getKhasra_no() {
		return khasra_no;
	}

	public void setKhasra_no(String khasra_no) {
		this.khasra_no = khasra_no;
	}

	@Column(name = "area")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "ocdname")
	public String getOcdname() {
		return ocdname;
	}

	public void setOcdname(String ocdname) {
		this.ocdname = ocdname;
	}

	@Column(name = "ocdname1")
	public String getOcdname1() {
		return ocdname1;
	}

	public void setOcdname1(String ocdname1) {
		this.ocdname1 = ocdname1;
	}

	@Column(name = "ofather")
	public String getOfather() {
		return ofather;
	}

	public void setOfather(String ofather) {
		this.ofather = ofather;
	}

	@Column(name = "ofather1")
	public String getOfather1() {
		return ofather1;
	}

	public void setOfather1(String ofather1) {
		this.ofather1 = ofather1;
	}

	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "ocaste_code")
	public String getOcaste_code() {
		return ocaste_code;
	}

	public void setOcaste_code(String ocaste_code) {
		this.ocaste_code = ocaste_code;
	}

	@Column(name = "ocastenm")
	public String getOcastenm() {
		return ocastenm;
	}

	public void setOcastenm(String ocastenm) {
		this.ocastenm = ocastenm;
	}

	@Column(name = "oaddr1")
	public String getOaddr1() {
		return oaddr1;
	}

	public void setOaddr1(String oaddr1) {
		this.oaddr1 = oaddr1;
	}

	@Column(name = "mobileno")
	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	@Column(name = "aadharno")
	public String getAadharno() {
		return aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}

	@Column(name = "loanpassbook")
	public String getLoanpassbook() {
		return loanpassbook;
	}

	public void setLoanpassbook(String loanpassbook) {
		this.loanpassbook = loanpassbook;
	}

	@Column(name = "nakshaurl")
	public String getNakshaurl() {
		return nakshaurl;
	}

	public void setNakshaurl(String nakshaurl) {
		this.nakshaurl = nakshaurl;
	}

	
	
	@Column(name = "b1pdfurl")
	public String getB1PDFurl() {
		return b1PDFurl;
	}

	public void setB1PDFurl(String b1pdFurl) {
		b1PDFurl = b1pdFurl;
	}
	@Column(name = "p2pdfurl")
	public String getP2PDFurl() {
		return p2PDFurl;
	}

	public void setP2PDFurl(String p2pdFurl) {
		p2PDFurl = p2pdFurl;
	}
	
	
	

}