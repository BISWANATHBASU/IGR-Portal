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
@Table(name = "user_master")
public class UserCreateModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int user_id;
	private String user_name;
	private String user_password;
	private String name;
	private String fatherName;
	private String address;
	private Date birthDate;
	private String gender;
	private String mobileNo;
	private String mailID;
	private String iCardType;
	private String iCardValue;
	private int user_type;
	
	
	@Id
	@Column(name = "user_id")
	@SequenceGenerator(name = "user_master_seq", sequenceName = "user_master_user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_master_seq")
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Column(name = "user_name")
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	@Column(name = "user_password")
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "fatherName")
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	@Column(name = "birthDate")
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "mobileNo")
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Column(name = "mailID")
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	
	@Column(name = "iCardType")
	public String getiCardType() {
		return iCardType;
	}
	public void setiCardType(String iCardType) {
		this.iCardType = iCardType;
	}
	
	@Column(name = "iCardValue")
	public String getiCardValue() {
		return iCardValue;
	}
	public void setiCardValue(String iCardValue) {
		this.iCardValue = iCardValue;
	}
	
	
	
	@Column(name = "user_type")
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	
	
	
	
	
	
	
	
	
	
}