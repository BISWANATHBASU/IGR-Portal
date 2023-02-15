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
import com.igr.hibernate.model.partyDetailModel;
import com.igr.hibernate.model.propertyDetailModel;
import com.igr.hibernate.model.structureValuationModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchForTransactionDetailsEdit extends ActionSupport implements
		ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private static final Logger log = Logger.getLogger(SearchForTransactionDetailsEdit.class);
	HibernateManager manager = new HibernateManager();
	private static CommonHelper helper = new CommonHelper();
	
	

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String language = "";
	private boolean edit;
	private String event;
	private String tokenNo;
	private String dsrLocation;
	private Date tokenDate;
	private int deed_type_id;
	private int deed_category_id;
	private float considered_amount;
	
	List<propertyDetailModel> propertyModelList = new ArrayList<propertyDetailModel>();
	List<structureValuationModel> structureModelList = new ArrayList<structureValuationModel>();
	List<partyDetailModel> partyModelList = new ArrayList<partyDetailModel>();
	List<deedDetailModel> deedDetailModelList = new ArrayList<deedDetailModel>();
	//List<partyDetailModel> signatureModelList = new ArrayList<partyDetailModel>();
	
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	
	

	

	public float getConsidered_amount() {
		return considered_amount;
	}

	public void setConsidered_amount(float considered_amount) {
		this.considered_amount = considered_amount;
	}

	public int getDeed_type_id() {
		return deed_type_id;
	}

	public void setDeed_type_id(int deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	public int getDeed_category_id() {
		return deed_category_id;
	}

	public void setDeed_category_id(int deed_category_id) {
		this.deed_category_id = deed_category_id;
	}

	public String getDsrLocation() {
		return dsrLocation;
	}

	public void setDsrLocation(String dsrLocation) {
		this.dsrLocation = dsrLocation;
	}

	public Date getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(Date tokenDate) {
		this.tokenDate = tokenDate;
	}

	public List<propertyDetailModel> getPropertyModelList() {
		return propertyModelList;
	}

	public void setPropertyModelList(List<propertyDetailModel> propertyModelList) {
		this.propertyModelList = propertyModelList;
	}

	public List<structureValuationModel> getStructureModelList() {
		return structureModelList;
	}

	public void setStructureModelList(
			List<structureValuationModel> structureModelList) {
		this.structureModelList = structureModelList;
	}

	public List<partyDetailModel> getPartyModelList() {
		return partyModelList;
	}

	public void setPartyModelList(List<partyDetailModel> partyModelList) {
		this.partyModelList = partyModelList;
	}

	public List<deedDetailModel> getDeedDetailModelList() {
		return deedDetailModelList;
	}


	public void setDeedDetailModelList(List<deedDetailModel> deedDetailModelList) {
		this.deedDetailModelList = deedDetailModelList;
	}

	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
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
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");

		String returnMessage = "";
		boolean operationFlag = false;
	
		try {

			
			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);
			
			if ((empID == null) || (branchCode == null) || (groupID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (branchCode.trim().length() == 0)
					|| (groupID.trim().length() == 0)
					|| (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));
				operationFlag = false;
			
			} else {
				
				
				
				Date currentDateValue = new Date();
				
				
				log.fatal("EX   "+tokenNo+","+tokenDate+","+dsrLocation);
				

				if(event.equalsIgnoreCase("PROPERTY_DETAIL"))
					propertyModelList = manager.getPropertyDetails(tokenNo,sdf.parse(sdf.format(tokenDate)),Integer.parseInt(dsrLocation));
				else if(event.equalsIgnoreCase("STRUCTURE_DETAIL"))
					structureModelList = manager.getStructureDetails(tokenNo,sdf.parse(sdf.format(tokenDate)),Integer.parseInt(dsrLocation));
				else if(event.equalsIgnoreCase("PARTY_DETAIL"))
					partyModelList = manager.getPartyDetails(tokenNo,sdf.parse(sdf.format(tokenDate)),Integer.parseInt(dsrLocation));
				else if(event.equalsIgnoreCase("DEED_DETAIL"))
					deedDetailModelList = manager.getDeedDetails(tokenNo,sdf.parse(sdf.format(tokenDate)),Integer.parseInt(dsrLocation));
				/*else if(event.equalsIgnoreCase("BIOMETRIC"))
					biometricModelList = manager.getPartyDetailsForBiometric(Integer.parseInt(tokenNo),sdf.parse(sdf.format(tokenDate)),Integer.parseInt(dsrLocation));
				else if(event.equalsIgnoreCase("SIGNATURE"))
					signatureModelList = manager.getPartyDetailsSignature(Integer.parseInt(tokenNo),sdf.parse(sdf.format(tokenDate)),Integer.parseInt(dsrLocation));
				 */
				
				
				if(event.equalsIgnoreCase("PROPERTY_DETAIL")&&(propertyModelList.size() > 0))
				{
					operationFlag = true;
				}
				else if(event.equalsIgnoreCase("STRUCTURE_DETAIL")&&(structureModelList.size() > 0))
				{
					operationFlag = true;
				}
				else if(event.equalsIgnoreCase("PARTY_DETAIL")&&(partyModelList.size() > 0))
				{
					operationFlag = true;
				}
				else if(event.equalsIgnoreCase("DEED_DETAIL")&&(deedDetailModelList.size() > 0))
				{
					operationFlag = true;
				}
				/*else if(event.equalsIgnoreCase("BIOMETRIC")&&(biometricModelList.size() > 0))
				{
					operationFlag = true;
				}
				else if(event.equalsIgnoreCase("SIGNATURE")&&(signatureModelList.size() > 0))
				{
					operationFlag = true;
				}*/
				
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
	public String exitEditDetails() throws Exception {
		return "home";
	}
}
