package com.igr.search;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.commonUtility.CommonFiveOptionsVO;
import com.igr.commonUtility.CommonFourOptionsVO;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonNineOptionsVO;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.secondTokenTypeModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.math.BigDecimal;

public class SearchModule extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String language;
	private boolean edit;
	private String districtCode;

	private boolean printFlag; 
	private String searchCriteria;
	private String searchValue;
	private String fromDate;
	private String toDate;
	
	
	private ServletContext context;
	private HttpServletRequest request;

	List<CommonOptionsVO> dsrLocationList;
	List<CommonNineOptionsVO> secondTokenTypeList;
	private List<CommonOptionsVO> districtList;
	

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

	private static CommonValidation validator = new CommonValidation();
	HibernateManager manager = new HibernateManager();
	private static CommonHelper helper = new CommonHelper();
	/*private static final Logger log = Logger.getLogger(SearchModule.class);*/
	private static Logger log = Logger.getLogger(SearchModule.class);

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getLanguage() {
		return language;
	}
	
		

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public boolean isPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(boolean printFlag) {
		this.printFlag = printFlag;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

	public String getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<CommonOptionsVO> getDsrLocationList() {
		return dsrLocationList;
	}

	public void setDsrLocationList(List<CommonOptionsVO> dsrLocationList) {
		this.dsrLocationList = dsrLocationList;
	}

	public List<CommonNineOptionsVO> getSecondTokenTypeList() {
		return secondTokenTypeList;
	}

	public void setSecondTokenTypeList(
			List<CommonNineOptionsVO> secondTokenTypeList) {
		this.secondTokenTypeList = secondTokenTypeList;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	
	
	public List<CommonOptionsVO> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<CommonOptionsVO> districtList) {
		this.districtList = districtList;
	}

	@SkipValidation
	public String execute() throws Exception {

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
	
		int returnMessage = 1;
		String returnValue = SUCCESS;
	

		try {

			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);

			districtList = new ArrayList();
			districtList=manager.searchDistrictAllForPortal(Integer.parseInt(language));

			dsrLocationList = new ArrayList<CommonOptionsVO>();
			
			if(language.equalsIgnoreCase("1"))
			{
				CommonOptionsVO	optionVo = new CommonOptionsVO("2","First Party/Executant Name");
				dsrLocationList.add(optionVo);
				optionVo = new CommonOptionsVO("3","Area Type");
				dsrLocationList.add(optionVo);
				optionVo = new CommonOptionsVO("3","Khasra No.");
				dsrLocationList.add(optionVo);
			}
			else if(language.equalsIgnoreCase("2"))
			{
				CommonOptionsVO optionVo = new CommonOptionsVO("2","à¤¨à¤¿à¤·à¥�à¤ªà¤¾à¤¦à¤•");
				dsrLocationList.add(optionVo);
				optionVo = new CommonOptionsVO("3","à¤·à¥‡à¤¤à¥�à¤°_à¤ªà¥�à¤°à¤•à¤¾à¤°");
				dsrLocationList.add(optionVo);
				optionVo = new CommonOptionsVO("3","à¤–à¤¸à¤°à¤¾ à¤¨0");
				dsrLocationList.add(optionVo);
			}
			

		} catch (Exception e) {
			returnMessage = 0;
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		if (returnMessage == 1)
			returnValue = SUCCESS;

		else if (returnMessage == 0) {
			this.addActionError(getText("global.system.error"));
			return "home";
		}

		return returnValue;
	}

	@SkipValidation
	public String exitModuleData() throws Exception {
		return "home";
	}

	public String searchModuleData() throws Exception {
		boolean operationFlag = false;
		try {

			
			secondTokenTypeList = new ArrayList<CommonNineOptionsVO>();
			
			log.fatal(this.fromDate+","+this.toDate);
			log.fatal(sdf1.parse(sdf1.format(sdf.parse(this.fromDate)))+","+
					sdf1.parse(sdf1.format(sdf.parse(this.toDate))));
			
			
			
			if(this.districtCode.startsWith("0"))
			{
				if(this.searchCriteria.equalsIgnoreCase("3"))
			secondTokenTypeList = manager.searchDataForSearchModuleByPropertyWithoutDistrict(this.searchValue,0,sdf1.parse(sdf1.format(sdf.parse(this.fromDate))),
					sdf1.parse(sdf1.format(sdf.parse(this.toDate))));
				else if(this.searchCriteria.equalsIgnoreCase("2"))
					secondTokenTypeList = manager.searchDataForSearchModuleByPartyWithoutDistrict(this.searchValue,0,sdf1.parse(sdf1.format(sdf.parse(this.fromDate))),
							sdf1.parse(sdf1.format(sdf.parse(this.toDate))));
			}
			else 	if(!this.districtCode.startsWith("0"))
			{
				String district[]=this.districtCode.split(",");
				log.fatal(this.districtCode+","+district[0]);
				
				if(this.searchCriteria.equalsIgnoreCase("3"))
			secondTokenTypeList = manager.searchDataForSearchModuleByPropertyWithDistrict(this.searchValue,Integer.parseInt(district[0].trim()),sdf1.parse(sdf1.format(sdf.parse(this.fromDate))),
					sdf1.parse(sdf1.format(sdf.parse(this.toDate))));
				else if(this.searchCriteria.equalsIgnoreCase("2"))
					secondTokenTypeList = manager.searchDataForSearchModuleByPartyWithDistrict(this.searchValue,Integer.parseInt(district[0].trim()),sdf1.parse(sdf1.format(sdf.parse(this.fromDate))),
							sdf1.parse(sdf1.format(sdf.parse(this.toDate))));
			}
			if (secondTokenTypeList.size() > 0) {
				operationFlag = true;

			}

			else if (secondTokenTypeList.size() == 0) {
				operationFlag = false;
			}

		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		if (operationFlag) {
			this.setPrintFlag(true);
			return "success";
		} else {
			this.setPrintFlag(false);
			this.addActionError("No Data Found");
			return "home";
		}

	}

	public void validate() {
		try {

			this.setEdit(false);
			this.execute();

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));
		}
	}



}