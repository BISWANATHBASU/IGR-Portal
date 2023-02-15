package com.igr.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="newsModel")
@Table(name="news_master")
public class newsModel {
	@Id
	@Column(name="news_id",length=10)
	@SequenceGenerator(name = "news_id_seq", sequenceName = "news_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_id_seq")
	private int news_id;
	
	@Column(name="news_headline",length=50)
	private String news_headline;
	
	@Column(name="date_posted")
	private Date date_posted;
	
	@Column(name="news_status",nullable=false)
	private boolean news_status;
	
	@Column(name="brief_content",length=100)
	private String brief_content;
	
	@Column(name="file_name", length=100)
	private String file_name;

	public int getNews_id() {
		return news_id;
	}

	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	public Date getDate_posted() {
		return date_posted;
	}

	public void setDate_posted(Date date_posted) {
		this.date_posted = date_posted;
	}

	public boolean isNews_status() {
		return news_status;
	}

	public void setNews_status(boolean news_status) {
		this.news_status = news_status;
	}

	public String getBrief_content() {
		return brief_content;
	}

	public void setBrief_content(String brief_content) {
		this.brief_content = brief_content;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getNews_headline() {
		return news_headline;
	}

	public void setNews_headline(String news_headline) {
		this.news_headline = news_headline;
	}
	
	
	

}
