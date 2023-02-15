package com.igr.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "global_config")
public class globalConfigModel implements Serializable {

	private static final long serialVersionUID = -1L;

	
	private String  config_code;
	private String  config_val;
	private int lang_code;
	private String config_type;
	private int created_by;
	private Date created_datetime;
	private int updated_by;
	private Date updated_datetime;
	
	@Id
	@Column(name = "config_code")
	public String getConfig_code() {
		return config_code;
	}
	public void setConfig_code(String config_code) {
		this.config_code = config_code;
	}
	
	
	@Column(name = "config_val")
	public String getConfig_val() {
		return config_val;
	}
	public void setConfig_val(String config_val) {
		this.config_val = config_val;
	}
	
	
	@Column(name = "lang_code")
	public int getLang_code() {
		return lang_code;
	}
	public void setLang_code(int lang_code) {
		this.lang_code = lang_code;
	}
	
	@Column(name = "config_type")
	public String getConfig_type() {
		return config_type;
	}
	public void setConfig_type(String config_type) {
		this.config_type = config_type;
	}
	
	@Column(name = "created_by")
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	@Column(name = "created_datetime")
	public Date getCreated_datetime() {
		return created_datetime;
	}
	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}
	@Column(name = "updated_by")
	public int getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}
	@Column(name = "updated_datetime")
	public Date getUpdated_datetime() {
		return updated_datetime;
	}
	public void setUpdated_datetime(Date updated_datetime) {
		this.updated_datetime = updated_datetime;
	}
}