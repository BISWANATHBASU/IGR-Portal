package com.igr.hibernate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class PaymentModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7891189832187065394L;
	
	private String token_no;
	private String e_registration_id;
	private int dsr_location;
	private BigDecimal total_amount;
	private BigDecimal reg_fee;
	private BigDecimal other_fee;
	private BigDecimal sp_fee;
	private BigDecimal total_fees_final;
	private Date token_date;
	private	Date tran_datetime;
	private String	tran_status;
	private String	tran_status_desc;
	private String	bank_name;
	private String	payment_method;
	private String tran_status_sbi;
	private Boolean checksum_match;
	private String sbi_ref_no;
	private Boolean dv_status;
	
	@Id
	@Column(name="token_no")
	public String getToken_no() {
		return token_no;
	}
	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}
	
	@Column(name="e_registration_id")
	public String getE_registration_id() {
		return e_registration_id;
	}
	public void setE_registration_id(String e_registration_id) {
		this.e_registration_id = e_registration_id;
	}
	
	@Column(name="dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	@Column(name="total_amount")
	public BigDecimal getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}
	
	@Column(name="reg_fee")
	public BigDecimal getReg_fee() {
		return reg_fee;
	}
	public void setReg_fee(BigDecimal reg_fee) {
		this.reg_fee = reg_fee;
	}
	
	@Column(name="other_fee")
	public BigDecimal getOther_fee() {
		return other_fee;
	}
	public void setOther_fee(BigDecimal other_fee) {
		this.other_fee = other_fee;
	}
	
	@Column(name="sp_fee")
	public BigDecimal getSp_fee() {
		return sp_fee;
	}
	public void setSp_fee(BigDecimal sp_fee) {
		this.sp_fee = sp_fee;
	}
	
	@Column(name="total_fees_final")
	public BigDecimal getTotal_fees_final() {
		return total_fees_final;
	}
	public void setTotal_fees_final(BigDecimal total_fees_final) {
		this.total_fees_final = total_fees_final;
	}
	
	@Column(name="token_date")
	public Date getToken_date() {
		return token_date;
	}
	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}
	
	@Column(name="tran_datetime")
	public Date getTran_datetime() {
		return tran_datetime;
	}
	public void setTran_datetime(Date tran_datetime) {
		this.tran_datetime = tran_datetime;
	}
	
	@Column(name="tran_status")
	public String getTran_status() {
		return tran_status;
	}
	public void setTran_status(String tran_status) {
		this.tran_status = tran_status;
	}
	
	@Column(name="tran_status_desc")
	public String getTran_status_desc() {
		return tran_status_desc;
	}
	public void setTran_status_desc(String tran_status_desc) {
		this.tran_status_desc = tran_status_desc;
	}
	
	@Column(name="bank_name")
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	
	@Column(name="payment_method")
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	
	@Column(name="tran_status_sbi")
	public String getTran_status_sbi() {
		return tran_status_sbi;
	}
	public void setTran_status_sbi(String tran_status_sbi) {
		this.tran_status_sbi = tran_status_sbi;
	}
	
	@Column(name="checksum_match")
	public Boolean getChecksum_match() {
		return checksum_match;
	}
	public void setChecksum_match(Boolean checksum_match) {
		this.checksum_match = checksum_match;
	}
	
	@Column(name="sbi_ref_no")
	public String getSbi_ref_no() {
		return sbi_ref_no;
	}
	public void setSbi_ref_no(String sbi_ref_no) {
		this.sbi_ref_no = sbi_ref_no;
	}
	
	@Column(name="dv_status")
	public Boolean isDv_status() {
		return dv_status;
	}
	public void setDv_status(Boolean dv_status) {
		this.dv_status = dv_status;
	}
}
