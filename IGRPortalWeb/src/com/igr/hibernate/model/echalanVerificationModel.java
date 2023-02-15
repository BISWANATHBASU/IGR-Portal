package com.igr.hibernate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "echalan_verification_details")
public class echalanVerificationModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int echalan_verify_id;
	private String token_no;
	private Date taken_date;
	private int dsr_location;
	private String echalan_no;
	private Date echalan_date;
	private BigDecimal echalan_value ;
	private String epanjiyan_id;
	private String e_result_code;
	private String payee;
	private String dept;
	private String tin_cin;
	private String address1;
	private String address2;
	private String purpose;
	private String from_period;
	private String to_period;
	private String bank;
	private String tr_refno;
	private String tr_refno_old;
	private String amount;
	private String entrydate;
	private String sc_slno;
	private String userid;
	private String date_ac;
	private String majorhead;
	private String submajorhead;
	private String minorhead;
	private String subhead;
	
	
	
	
	
	@Id
	@Column(name = "echalan_verify_id")
	@SequenceGenerator(name = "echalan_verification_id_seq", sequenceName = "echalan_verification_details_echalan_verify_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "echalan_verification_id_seq")
	public int getEchalan_verify_id() {
		return echalan_verify_id;
	}
	public void setEchalan_verify_id(int echalan_verify_id) {
		this.echalan_verify_id = echalan_verify_id;
	}
	
	@Column(name = "token_no")
	public String getToken_no() {
		return token_no;
	}
	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}
	
	
	@Column(name = "taken_date")
	public Date getTaken_date() {
		return taken_date;
	}
	public void setTaken_date(Date taken_date) {
		this.taken_date = taken_date;
	}
	
	
	@Column(name = "dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	

	@Column(name = "echalan_no")
	public String getEchalan_no() {
		return echalan_no;
	}
	public void setEchalan_no(String echalan_no) {
		this.echalan_no = echalan_no;
	}
	
	
	@Column(name = "echalan_date")
	public Date getEchalan_date() {
		return echalan_date;
	}
	public void setEchalan_date(Date echalan_date) {
		this.echalan_date = echalan_date;
	}
	
	
	@Column(name = "echalan_value")
	public BigDecimal getEchalan_value() {
		return echalan_value;
	}
	public void setEchalan_value(BigDecimal echalan_value) {
		this.echalan_value = echalan_value;
	}
	
	@Column(name = "epanjiyan_id")
	public String getEpanjiyan_id() {
		return epanjiyan_id;
	}
	public void setEpanjiyan_id(String epanjiyan_id) {
		this.epanjiyan_id = epanjiyan_id;
	}
	
	@Column(name = "e_result_code")
	public String getE_result_code() {
		return e_result_code;
	}
	public void setE_result_code(String e_result_code) {
		this.e_result_code = e_result_code;
	}
	
	@Column(name = "payee")
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	
	@Column(name = "dept")
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Column(name = "tin_cin")
	public String getTin_cin() {
		return tin_cin;
	}
	public void setTin_cin(String tin_cin) {
		this.tin_cin = tin_cin;
	}
	
	@Column(name = "address1")
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	
	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
	@Column(name = "purpose")
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
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
	
	@Column(name = "bank")
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	@Column(name = "tr_refno")
	public String getTr_refno() {
		return tr_refno;
	}
	public void setTr_refno(String tr_refno) {
		this.tr_refno = tr_refno;
	}
	
	@Column(name = "tr_refno_old")
	public String getTr_refno_old() {
		return tr_refno_old;
	}
	public void setTr_refno_old(String tr_refno_old) {
		this.tr_refno_old = tr_refno_old;
	}
	
	
	@Column(name = "amount")
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Column(name = "entrydate")
	public String getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}
	
	@Column(name = "sc_slno")
	public String getSc_slno() {
		return sc_slno;
	}
	public void setSc_slno(String sc_slno) {
		this.sc_slno = sc_slno;
	}
	
	
	@Column(name = "userid")
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	@Column(name = "date_ac")
	public String getDate_ac() {
		return date_ac;
	}
	public void setDate_ac(String date_ac) {
		this.date_ac = date_ac;
	}
	
	@Column(name = "majorhead")
	public String getMajorhead() {
		return majorhead;
	}
	public void setMajorhead(String majorhead) {
		this.majorhead = majorhead;
	}
	
	
	@Column(name = "submajorhead")
	public String getSubmajorhead() {
		return submajorhead;
	}
	public void setSubmajorhead(String submajorhead) {
		this.submajorhead = submajorhead;
	}
	
	
	@Column(name = "minorhead")
	public String getMinorhead() {
		return minorhead;
	}
	public void setMinorhead(String minorhead) {
		this.minorhead = minorhead;
	}
	
	
	@Column(name = "subhead")
	public String getSubhead() {
		return subhead;
	}
	public void setSubhead(String subhead) {
		this.subhead = subhead;
	}
}