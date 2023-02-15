package com.igr.report;

import org.apache.log4j.Logger;


import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

public class InitiateReportAction extends ActionSupport implements
		ServletRequestAware, ServletContextAware {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMM");
	private static final long serialVersionUID = 1L;
	private Date currentDate = new Date();
	private static Logger log = Logger.getLogger(InitiateReportAction.class);

	private String empID;
	private String branchCode = "";
	private String groupID = "";

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	private String heading;
	private String reportPath;
	private String reportName;
	private String event;
	private String tokenNo;
	private String tokenDate;
	private String employeeCode;
	private ServletContext context;
	private String yearMonth;
	private List<String> quaterList;
	private String quater;
	private List<String> yearList;
	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public String getYearValue() {
		return yearValue;
	}

	public void setYearValue(String yearValue) {
		this.yearValue = yearValue;
	}

	private String yearValue;

	@Override
	public void setServletContext(ServletContext arg0) {
		this.context = arg0;

	}



	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	
	

	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

	public String getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(String tokenDate) {
		this.tokenDate = tokenDate;
	}

	public String getReportPath() {
		return reportPath;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}



	public List<String> getQuaterList() {
		return quaterList;
	}

	public void setQuaterList(List<String> quaterList) {
		this.quaterList = quaterList;
	}

	public String getQuater() {
		return quater;
	}

	public void setQuater(String quater) {
		this.quater = quater;
	}

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	
	
	
	
	
	
	

	private HttpServletRequest request;

	public String execute() throws Exception {

		this.empID = (String) request.getSession().getAttribute("_EMPCODE");
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		tokenDate = sdf.format(currentDate);
		yearMonth = sdf1.format(currentDate);

		this.reportPath="/report/IGR_CHECKSLIP_PORTAL.jasper";
		//this.reportPath="/report/IGR_DEED_SCANNED.jasper";
		
		quaterList = new ArrayList<String>();
		quaterList.add("Q1");
		quaterList.add("Q2");
		quaterList.add("Q3");
		quaterList.add("Q4");
		
		
		
		yearList = new ArrayList<String>();
		yearList.add("2013-2014");
		yearList.add("2014-2015");
		yearList.add("2015-2016");
		yearList.add("2016-2017");

		return SUCCESS;

	}

	public String exitReport() throws Exception {
		return "home";
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}