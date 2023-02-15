package com.igr.hibernate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionModel implements Serializable {
	
	String token_no;
    Date token_date;
    int dsr_location;
    BigDecimal amount;
    Date tran_date;
    Date tran_time;
    Date tran_date_sbi;
    Date tran_time_sbi;
    String checksum;
    String in_param;
    String out_param;
    String tran_status;
    
    @Id
    @Column(name="token_no")
	public String getToken_no() {
		return token_no;
	}
	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}
	
	@Column(name="token_date")
	public Date getToken_date() {
		return token_date;
	}
	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}
	
	@Column(name="dsr_location")
	public int getDsr_location() {
		return dsr_location;
	}
	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}
	
	@Column(name="amount")
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Column(name="tran_date")
	public Date getTran_date() {
		return tran_date;
	}
	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}
	
	@Column(name="tran_time")
	public Date getTran_time() {
		return tran_time;
	}
	public void setTran_time(Date tran_time) {
		this.tran_time = tran_time;
	}
	
	@Column(name="tran_date_sbi")
	public Date getTran_date_sbi() {
		return tran_date_sbi;
	}
	public void setTran_date_sbi(Date tran_date_sbi) {
		this.tran_date_sbi = tran_date_sbi;
	}
	
	@Column(name="tran_time_sbi")
	public Date getTran_time_sbi() {
		return tran_time_sbi;
	}
	public void setTran_time_sbi(Date tran_time_sbi) {
		this.tran_time_sbi = tran_time_sbi;
	}
	
	@Column(name="checksum")
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	
	@Column(name="in_param")
	public String getIn_param() {
		return in_param;
	}
	public void setIn_param(String in_param) {
		this.in_param = in_param;
	}
	
	@Column(name="out_param")
	public String getOut_param() {
		return out_param;
	}
	public void setOut_param(String out_param) {
		this.out_param = out_param;
	}
	
	@Column(name="tran_status")
	public String getTran_status() {
		return tran_status;
	}
	public void setTran_status(String tran_status) {
		this.tran_status = tran_status;
	}
    
    
	

}
