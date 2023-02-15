package com.igr.commonSearch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.igr.commonUtility.CommonHelper;
import com.igr.hibernate.model.provisionalTokenTypeModel;
//import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchFirstTokenforSecondToken extends ActionSupport implements
		ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private static final Logger log = Logger.getLogger(SearchFirstTokenforSecondToken.class);
	HibernateManager manager = new HibernateManager();

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String language = "";
	private boolean edit;
	List<provisionalTokenTypeModel> tokenModelList = new ArrayList<provisionalTokenTypeModel>();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private static CommonHelper helper = new CommonHelper();
	
	
	public List<provisionalTokenTypeModel> getTokenModelList() {
		return tokenModelList;
	}

	public void setTokenModelList(List<provisionalTokenTypeModel> tokenModelList) {
		this.tokenModelList = tokenModelList;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String execute() throws Exception {
		empID = (String) request.getSession().getAttribute("_EMPCODE");
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");

		String returnMessage = "";
		boolean operationFlag = false;
		//userLogModel logModel = new userLogModel();
		try {

			
			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);
			
			if ((empID == null) 
					|| (language == null) || (empID.trim().length() == 0)
					|| (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));
				operationFlag = false;
			
			} else {
				
				
				
				
				
				Date currentDateValue = new Date();
				
			
				tokenModelList = manager.searchFirstTokenForSecondToken(Integer.parseInt(language), tokenModelList,sdf.parse(sdf.format(currentDateValue)),empID);
				if (tokenModelList.size() > 0) {
					operationFlag = true;
				}

				else {
					operationFlag = false;
					returnMessage = "No Data Found.";
				}
			}

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));
		}

		if (operationFlag) {
			return "success";
		} else {
			this.addActionError(returnMessage);
			return "home";
		}

	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;

	}



	@SkipValidation
	public String exitSearchFirstTokenForSecondToken() throws Exception {
		return "home";
	}
}
