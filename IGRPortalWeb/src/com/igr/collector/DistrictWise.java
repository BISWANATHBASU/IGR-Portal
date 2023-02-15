package com.igr.collector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.commonUtility.CommonHelper;
import com.opensymphony.xwork2.ActionSupport;

public class DistrictWise extends ActionSupport implements ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private static CommonHelper helper = new CommonHelper();

	private String empID = "";
	private String language = "";

	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	private ServletContext context;
	private HttpServletRequest request;


	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
	
	private String locationList;
	public String getLocationList() {
		return locationList;
	}
	public void setLocationList(String locationList) {
		this.locationList = locationList;
	}
	
	@SkipValidation
	public String execute() throws Exception {

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
        System.out.println("DistrictWise language===>>>"+language);
		int returnMessage = 1;
		String returnValue = SUCCESS;

		try {
			//locationList = helper.getOfficeList("63");
		} catch (Exception e) {
			returnMessage = 0;
			throw new Exception(getText("global.system.error"));
		}
		return returnValue;
	}
	
	public String TahasilWise(){
		System.out.println("TahasilWise()");
		return SUCCESS;
	}
	
	public String RaniMandalWise(){
		System.out.println("RaniMandalWise()");
		return SUCCESS;
	}
	
	public String PatwariHalkaNoWise(){
		System.out.println("PatwariHalkaNoWise()");
		return SUCCESS;
	}
}
