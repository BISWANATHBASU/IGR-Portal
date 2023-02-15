package com.igr.registration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.report.InitiateReportAction;
import com.opensymphony.xwork2.ActionSupport;

public class TokenStatusAction extends ActionSupport implements
ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(TokenStatusAction.class);
	
	private String empID;
	private String language;

    private ServletContext context;
    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest arg0) {
            this.request = arg0;
    }
    @Override
    public void setServletContext(ServletContext arg0) {
            this.context = arg0;
    }
    
	@SkipValidation
	public String execute() throws Exception {
		log.fatal("Getting Token List");
		String returnValue = SUCCESS;
		
        empID = (String) request.getSession().getAttribute("_EMPCODE");
        language = (String) request.getSession().getAttribute("_LANGUAGE");
		
        log.fatal("Return From Token List="+returnValue);
		return returnValue;
	}
}
