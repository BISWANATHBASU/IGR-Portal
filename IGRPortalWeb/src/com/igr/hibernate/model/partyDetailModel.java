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
@Table(name = "party_detail")
public class partyDetailModel implements Serializable {

	private static final long serialVersionUID = -1L;

	private int party_detail_id;
	private int party_type_id;
	private String party_name;
	private String party_fh_rel;
	private String party_fh_rel_name;
	private String profession;
    private String gender;
	private String caste;
	private String pan_no;
	private String address;
	private String ph_no;
	private String address_proof;
	private int created_by;
	private Date created_date;
	private int updated_by;
    private Date updated_date;
    private int dsr_location; 		
	 private String token_no;			
	 private Date token_date;	
	 private String party_name_hindi;
	 private String sub_cast;
	 private boolean biometric_required;
	
    
    @Id
	@Column(name = "party_detail_id")
	@SequenceGenerator(name = "party_detail_id_seq", sequenceName = "party_detail_party_detail_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_detail_id_seq")
	public int getParty_detail_id() {
		return party_detail_id;
	}
	public void setParty_detail_id(int party_detail_id) {
		this.party_detail_id = party_detail_id;
	}
	
	@Column(name = "party_type_id")
	public int getParty_type_id() {
		return party_type_id;
	}
	public void setParty_type_id(int party_type_id) {
		this.party_type_id = party_type_id;
	}
	
	@Column(name = "party_name")
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	
	@Column(name = "party_fh_rel")
	public String getParty_fh_rel() {
		return party_fh_rel;
	}
	public void setParty_fh_rel(String party_fh_rel) {
		this.party_fh_rel = party_fh_rel;
	}
	
	@Column(name = "party_fh_rel_name")
	public String getParty_fh_rel_name() {
		return party_fh_rel_name;
	}
	public void setParty_fh_rel_name(String party_fh_rel_name) {
		this.party_fh_rel_name = party_fh_rel_name;
	}
	
	@Column(name = "profession")
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "caste")
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	
	@Column(name = "pan_no")
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "ph_no")
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	
	@Column(name = "address_proof")
	public String getAddress_proof() {
		return address_proof;
	}
	public void setAddress_proof(String address_proof) {
		this.address_proof = address_proof;
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
	
	@Column(name = "party_name_hindi")
	public String getParty_name_hindi() {
		return party_name_hindi;
	}
	public void setParty_name_hindi(String party_name_hindi) {
		this.party_name_hindi = party_name_hindi;
	}
	
	
	@Column(name = "sub_cast")
	public String getSub_cast() {
		return sub_cast;
	}
	public void setSub_cast(String sub_cast) {
		this.sub_cast = sub_cast;
	}
	
	
	@Column(name = "biometric_required")
	public boolean isBiometric_required() {
		return biometric_required;
	}
	public void setBiometric_required(boolean biometric_required) {
		this.biometric_required = biometric_required;
	}
	
	
	
	
	
	
	

}