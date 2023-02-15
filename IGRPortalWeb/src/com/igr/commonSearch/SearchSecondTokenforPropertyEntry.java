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
import com.igr.hibernate.model.deedDetailModel;
import com.igr.hibernate.model.secondTokenTypeModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchSecondTokenforPropertyEntry extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	/*private static final Logger log = Logger.getLogger(SearchSecondTokenforPropertyEntry.class);*/
	private static Logger log = Logger.getLogger(SearchSecondTokenforPropertyEntry.class);
	HibernateManager manager = new HibernateManager();
	
	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String language = "";
	private boolean edit;
	private String event;
	List<secondTokenTypeModel> tokenModelList = new ArrayList<secondTokenTypeModel>();
	List<deedDetailModel> deedModelList = new ArrayList<deedDetailModel>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static CommonHelper helper = new CommonHelper();

	public List<deedDetailModel> getDeedModelList() {
		return deedModelList;
	}

	public void setDeedModelList(List<deedDetailModel> deedModelList) {
		this.deedModelList = deedModelList;
	}




	
	public List<secondTokenTypeModel> getTokenModelList() {
		return tokenModelList;
	}

	public void setTokenModelList(List<secondTokenTypeModel> tokenModelList) {
		this.tokenModelList = tokenModelList;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String execute() throws Exception {
		empID = (String) request.getSession().getAttribute("_EMPCODE");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");

		String returnMessage = "";
		boolean operationFlag = false;
		
		try {

			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);

			if ((empID == null) || (language == null)
					|| (empID.trim().length() == 0) 
					|| (groupID.trim().length() == 0) || (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));
				operationFlag = false;

			} else {

				Date currentDateValue = new Date();
				

				if ((event.equalsIgnoreCase("PROPERTY_DETAIL")) || (event.equalsIgnoreCase("STRUCTURE_DETAIL"))
						|| (event.equalsIgnoreCase("PARTY_DETAIL")))
					tokenModelList = manager.searchSecondTokenForPartyEntry(Integer.parseInt(language), tokenModelList,
							 sdf.parse(sdf.format(currentDateValue)), event,empID);

				else if (event.equalsIgnoreCase("DEED_DETAIL"))
					tokenModelList = manager.searchSecondTokenForDeedEntry(Integer.parseInt(language), tokenModelList,
							 sdf.parse(sdf.format(currentDateValue)), event,empID);
				
				else if (event.equalsIgnoreCase("DATE_EDIT"))
					tokenModelList = manager.searchSecondTokenForDateEdit(Integer.parseInt(language), tokenModelList,
							 sdf.parse(sdf.format(currentDateValue)), event,empID);
				
				else if (event.equalsIgnoreCase("PAYMENT"))
					deedModelList = manager.getDataForFeeEntry(Integer.parseInt(language), deedModelList,
							 sdf.parse(sdf.format(currentDateValue)), event,empID);
				
				else if (event.equalsIgnoreCase("APPOIMENT"))
					deedModelList = manager.getDataForFeeEntry(Integer.parseInt(language), deedModelList,
							 sdf.parse(sdf.format(currentDateValue)), event,empID);
				
				/*else if (event.equalsIgnoreCase("DEED_DETAIL_SIGNATURE"))
					tokenModelList = manager.searchSecondTokenForSignatureOnDeedDetail(Integer.parseInt(language),
							tokenModelList, Integer.parseInt(branchCode), sdf.parse(sdf.format(currentDateValue)),event);*/
				
				else if (event.equalsIgnoreCase("DEED_DETAIL_SIGNATURE"))
					tokenModelList = manager.searchSecondTokenForSignatureOnDeedDetail(Integer.parseInt(language), tokenModelList,
							 sdf.parse(sdf.format(currentDateValue)), event,empID);
							

				if ((tokenModelList.size() > 0) || (deedModelList.size() > 0)) {
					
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
	public String exitSecondToken() throws Exception {
		return "home";
	}
}
