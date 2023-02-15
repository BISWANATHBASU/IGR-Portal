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
@Table(name = "estamp_verification_details")
public class estampVerificationModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int estamp_verify_id;
	private String token_no;
	private Date taken_date;
	private int dsr_location;
	private String e_stamp_no;
	private Date e_stamp_date;
	private BigDecimal e_stamp_value;
	private String epanjiyan_id;
	private String e_result_code;
	private String e_result_desc;
	private String e_result;
	private String accountReference;
	private String uniqueDocReference;
	private String purchasedby;
	private String descriptionofDocument;
	private String propertyDescription;
	private String considerationPriceRs;
	private String firstParty;
	private String secondParty;
	private String stampDutyPaidBy;
	private String stampDutyAmountRs;
	
	
	
	@Id
	@Column(name = "estamp_verify_id")
	@SequenceGenerator(name = "estamp_verification_id_seq", sequenceName = "estamp_verification_details_estamp_verify_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estamp_verification_id_seq")
	public int getEstamp_verify_id() {
		return estamp_verify_id;
	}
	public void setEstamp_verify_id(int estamp_verify_id) {
		this.estamp_verify_id = estamp_verify_id;
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
	
	@Column(name = "e_stamp_no")
	public String getE_stamp_no() {
		return e_stamp_no;
	}
	public void setE_stamp_no(String e_stamp_no) {
		this.e_stamp_no = e_stamp_no;
	}
	
	@Column(name = "e_stamp_date")
	public Date getE_stamp_date() {
		return e_stamp_date;
	}
	public void setE_stamp_date(Date e_stamp_date) {
		this.e_stamp_date = e_stamp_date;
	}
	
	@Column(name = "e_stamp_value")
	public BigDecimal getE_stamp_value() {
		return e_stamp_value;
	}
	public void setE_stamp_value(BigDecimal e_stamp_value) {
		this.e_stamp_value = e_stamp_value;
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
	
	@Column(name = "e_result_desc")
	public String getE_result_desc() {
		return e_result_desc;
	}
	public void setE_result_desc(String e_result_desc) {
		this.e_result_desc = e_result_desc;
	}
	
	
	@Column(name = "e_result")
	public String getE_result() {
		return e_result;
	}
	public void setE_result(String e_result) {
		this.e_result = e_result;
	}
	
	
	@Column(name = "accountReference")
	public String getAccountReference() {
		return accountReference;
	}
	public void setAccountReference(String accountReference) {
		this.accountReference = accountReference;
	}
	
	@Column(name = "uniqueDocReference")
	public String getUniqueDocReference() {
		return uniqueDocReference;
	}
	public void setUniqueDocReference(String uniqueDocReference) {
		this.uniqueDocReference = uniqueDocReference;
	}
	
	@Column(name = "purchasedby")
	public String getPurchasedby() {
		return purchasedby;
	}
	public void setPurchasedby(String purchasedby) {
		this.purchasedby = purchasedby;
	}
	
	@Column(name = "descriptionofDocument")
	public String getDescriptionofDocument() {
		return descriptionofDocument;
	}
	public void setDescriptionofDocument(String descriptionofDocument) {
		this.descriptionofDocument = descriptionofDocument;
	}
	
	@Column(name = "propertyDescription")
	public String getPropertyDescription() {
		return propertyDescription;
	}
	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}
	
	@Column(name = "considerationPriceRs")
	public String getConsiderationPriceRs() {
		return considerationPriceRs;
	}
	public void setConsiderationPriceRs(String considerationPriceRs) {
		this.considerationPriceRs = considerationPriceRs;
	}
	
	@Column(name = "firstParty")
	public String getFirstParty() {
		return firstParty;
	}
	public void setFirstParty(String firstParty) {
		this.firstParty = firstParty;
	}
	
	@Column(name = "secondParty")
	public String getSecondParty() {
		return secondParty;
	}
	public void setSecondParty(String secondParty) {
		this.secondParty = secondParty;
	}
	
	@Column(name = "stampDutyPaidBy")
	public String getStampDutyPaidBy() {
		return stampDutyPaidBy;
	}
	public void setStampDutyPaidBy(String stampDutyPaidBy) {
		this.stampDutyPaidBy = stampDutyPaidBy;
	}
	
	@Column(name = "stampDutyAmountRs")
	public String getStampDutyAmountRs() {
		return stampDutyAmountRs;
	}
	public void setStampDutyAmountRs(String stampDutyAmountRs) {
		this.stampDutyAmountRs = stampDutyAmountRs;
	}
	
	

	
		
	
	
	
	
	
	
	
	
	
	

	
}