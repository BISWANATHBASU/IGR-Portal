package com.igr.commonUtility;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.igr.hibernate.model.newsModel;
import com.igr.hibernate.model.noticeModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;


@SuppressWarnings("serial")
public class IndexAction extends ActionSupport {
	
	private List<newsModel> newsList;
	private List<noticeModel> noticeList;
	private String name="hello";
	private int news_id;
	private int notice_id;
	private newsModel news;
	private noticeModel notice;
	private static Logger log = Logger.getLogger(IndexAction.class);
	
	public String execute()throws Exception{
		log.fatal("news action");
		/*name="hello";
		newsList=HibernateManager.getAllNews();
		setNoticeList(HibernateManager.getAllNotices());
		log.fatal(newsList);
		log.fatal(noticeList);*/
		return SUCCESS;
	}
	
	public String getNewsDetails(){
		log.fatal("news details action");
		news=HibernateManager.getNews(news_id);
		log.fatal(news.getFile_name());
		if(news==null)
			return ERROR;
		else
			return SUCCESS;
	}
	
	public String getNoticeDetails(){
		notice=HibernateManager.getNotice(notice_id);
		//notice.getDate_posted().toString();
		if(notice==null)
			return ERROR;
		else
			return SUCCESS;
	}


	public List<newsModel> getNewsList() {
		return newsList;
	}


	public void setNewsList(List<newsModel> newsList) {
		this.newsList = newsList;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<noticeModel> getNoticeList() {
		return noticeList;
	}


	public void setNoticeList(List<noticeModel> noticeList) {
		this.noticeList = noticeList;
	}


	public int getNews_id() {
		return news_id;
	}


	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public newsModel getNews() {
		return news;
	}

	public void setNews(newsModel news) {
		this.news = news;
	}

	public noticeModel getNotice() {
		return notice;
	}

	public void setNotice(noticeModel notice) {
		this.notice = notice;
	}

	
	

}
