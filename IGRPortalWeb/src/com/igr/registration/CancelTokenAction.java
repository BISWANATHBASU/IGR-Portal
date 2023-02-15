package com.igr.registration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class CancelTokenAction extends ActionSupport implements
ServletContextAware, ServletRequestAware {

	private ServletContext context;
	private HttpServletRequest request;

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
	
	private static final Logger log = Logger.getLogger(CancelTokenAction.class);
	
	@SkipValidation
	public String execute() throws Exception {
		String returnValue = SUCCESS;
		return returnValue;
	}
}
