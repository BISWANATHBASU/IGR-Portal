package com.igr.registration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.commonUtility.CommonFourOptionsVO;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.deedDetailModel;
import com.igr.hibernate.model.deedDetailPKModel;
import com.igr.hibernate.model.deedTypeModel;
import com.igr.hibernate.model.feeStructureModel;
import com.igr.hibernate.model.partyDetailModel;
import com.igr.hibernate.model.partyTypeModel;
import com.igr.hibernate.model.secondTokenTypeModel;
import com.igr.hibernate.model.structureValuationModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DateEditAction extends ActionSupport implements ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String locationName = "";
	private String districtID = "";
	private String districtName = "";
	private BigDecimal stampValue = new BigDecimal(0);
	private String token_no;
	private String presenter_name;
	private String first_party_executant_name;
	private String first_party_executant_capacity;
	private String district_id;
	private String dsr_location;
	private String dsr_location_desc;
	private String considered_amount;
	private String due_amount;
	private boolean edit;
	private String dummyTokenDate;
	private Date token_date;
	private Date token_time;
	private String deed_category_id;
	private String deed_type_id;
	private String doc_min_amount;
	private String applicable_stamp_value;
	private String presented_stamp_value;
	private String no_total_pages;
	private String new_no_of_total_pages;
	private String special_deed_detail;
	private String e_registration_code;
	private String rel_last_reg_record;
	private String rel_last_reg_date;
	private String rel_last_reg_no;
	private String rel_last_reg_pow_of_atr;
	private String rel_last_reg_pow_of_atr_date;
	private String rel_last_reg_pow_of_atr_reg_no;
	private String language;
	private BigDecimal maximumValuation;
	private boolean printFlag;
	private BigDecimal baseFee;
	private BigDecimal additionalFee;
	private BigDecimal cess;
	private String permission_no;
	private boolean permission_no_required;
	private BigDecimal otherFee;
	private ServletContext context;
	private HttpServletRequest request;
	private String bookID;
	private String deed_name;
	private String spFee;
	private String registrationFee;
	private Date app_date;
	private String mm;
	private String hh;
	private String hhmm;
	private String app_date1;
	
	
	public String getHhmm() {
		return hhmm;
	}

	public void setHhmm(String hhmm) {
		this.hhmm = hhmm;
	}

	private List<CommonOptionsVO> dsrLocationList;
	private List<CommonOptionsVO> districtList;
	private List<CommonOptionsVO> firstPartyCapacityList;
	private List<CommonOptionsVO> deedCategoryList;
	private List<CommonOptionsVO> deedTypeList;
	private List<CommonOptionsVO> specialDeedDetailList;
	private String calculation_on;
	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
	private String check_slip_count;
	//private static final Logger log = Logger.getLogger(DateEditAction.class);
	 private static Logger log = Logger.getLogger(DateEditAction.class);
	private static InsertOperation insertOperation = new InsertOperation();

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getConsidered_amount() {
		return considered_amount;
	}
	
	

	public String getSpFee() {
		return spFee;
	}

	public void setSpFee(String spFee) {
		this.spFee = spFee;
	}

	public String getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(String registrationFee) {
		this.registrationFee = registrationFee;
	}

	public String getCheck_slip_count() {
		return check_slip_count;
	}

	public void setCheck_slip_count(String check_slip_count) {
		this.check_slip_count = check_slip_count;
	}

	public String getCalculation_on() {
		return calculation_on;
	}

	public void setCalculation_on(String calculation_on) {
		this.calculation_on = calculation_on;
	}

	public void setConsidered_amount(String considered_amount) {
		this.considered_amount = considered_amount;
	}

	public String getDoc_min_amount() {
		return doc_min_amount;
	}

	public void setDoc_min_amount(String doc_min_amount) {
		this.doc_min_amount = doc_min_amount;
	}

	public boolean isPrintFlag() {
		return printFlag;
	}

	public String getDummyTokenDate() {
		return dummyTokenDate;
	}
	
	
	

	public String getDeed_name() {
		return deed_name;
	}

	public void setDeed_name(String deed_name) {
		this.deed_name = deed_name;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public BigDecimal getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	public List<CommonOptionsVO> getSpecialDeedDetailList() {
		return specialDeedDetailList;
	}

	public void setSpecialDeedDetailList(List<CommonOptionsVO> specialDeedDetailList) {
		this.specialDeedDetailList = specialDeedDetailList;
	}

	public String getNew_no_of_total_pages() {
		return new_no_of_total_pages;
	}

	public void setNew_no_of_total_pages(String new_no_of_total_pages) {
		this.new_no_of_total_pages = new_no_of_total_pages;
	}

	public void setDummyTokenDate(String dummyTokenDate) {
		this.dummyTokenDate = dummyTokenDate;
	}

	public void setPrintFlag(boolean printFlag) {
		this.printFlag = printFlag;
	}

	public BigDecimal getMaximumValuation() {
		return maximumValuation;
	}

	public void setMaximumValuation(BigDecimal maximumValuation) {
		this.maximumValuation = maximumValuation;
	}

	public String getApplicable_stamp_value() {
		return applicable_stamp_value;
	}

	public void setApplicable_stamp_value(String applicable_stamp_value) {
		this.applicable_stamp_value = applicable_stamp_value;
	}

	public String getPresented_stamp_value() {
		return presented_stamp_value;
	}

	public void setPresented_stamp_value(String presented_stamp_value) {
		this.presented_stamp_value = presented_stamp_value;
	}

	public String getNo_total_pages() {
		return no_total_pages;
	}

	public void setNo_total_pages(String no_total_pages) {
		this.no_total_pages = no_total_pages;
	}

	public boolean isPermission_no_required() {
		return permission_no_required;
	}

	public void setPermission_no_required(boolean permission_no_required) {
		this.permission_no_required = permission_no_required;
	}

	public String getPermission_no() {
		return permission_no;
	}

	public void setPermission_no(String permission_no) {
		this.permission_no = permission_no;
	}

	public String getSpecial_deed_detail() {
		return special_deed_detail;
	}

	public void setSpecial_deed_detail(String special_deed_detail) {
		this.special_deed_detail = special_deed_detail;
	}

	public String getRel_last_reg_record() {
		return rel_last_reg_record;
	}

	public void setRel_last_reg_record(String rel_last_reg_record) {
		this.rel_last_reg_record = rel_last_reg_record;
	}

	public String getRel_last_reg_no() {
		return rel_last_reg_no;
	}

	public void setRel_last_reg_no(String rel_last_reg_no) {
		this.rel_last_reg_no = rel_last_reg_no;
	}

	public String getRel_last_reg_pow_of_atr() {
		return rel_last_reg_pow_of_atr;
	}

	public void setRel_last_reg_pow_of_atr(String rel_last_reg_pow_of_atr) {
		this.rel_last_reg_pow_of_atr = rel_last_reg_pow_of_atr;
	}

	public String getRel_last_reg_date() {
		return rel_last_reg_date;
	}

	public void setRel_last_reg_date(String rel_last_reg_date) {
		this.rel_last_reg_date = rel_last_reg_date;
	}

	public String getRel_last_reg_pow_of_atr_date() {
		return rel_last_reg_pow_of_atr_date;
	}

	public void setRel_last_reg_pow_of_atr_date(String rel_last_reg_pow_of_atr_date) {
		this.rel_last_reg_pow_of_atr_date = rel_last_reg_pow_of_atr_date;
	}

	public String getRel_last_reg_pow_of_atr_reg_no() {
		return rel_last_reg_pow_of_atr_reg_no;
	}

	public void setRel_last_reg_pow_of_atr_reg_no(String rel_last_reg_pow_of_atr_reg_no) {
		this.rel_last_reg_pow_of_atr_reg_no = rel_last_reg_pow_of_atr_reg_no;
	}

	public List<CommonOptionsVO> getDeedCategoryList() {
		return deedCategoryList;
	}

	public void setDeedCategoryList(List<CommonOptionsVO> deedCategoryList) {
		this.deedCategoryList = deedCategoryList;
	}

	public List<CommonOptionsVO> getDeedTypeList() {
		return deedTypeList;
	}

	public void setDeedTypeList(List<CommonOptionsVO> deedTypeList) {
		this.deedTypeList = deedTypeList;
	}

	public List<CommonOptionsVO> getDsrLocationList() {
		return dsrLocationList;
	}

	public void setDsrLocationList(List<CommonOptionsVO> dsrLocationList) {
		this.dsrLocationList = dsrLocationList;
	}

	public List<CommonOptionsVO> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<CommonOptionsVO> districtList) {
		this.districtList = districtList;
	}

	public String getToken_no() {
		return token_no;
	}

	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}

	public String getE_registration_code() {
		return e_registration_code;
	}

	public void setE_registration_code(String e_registration_code) {
		this.e_registration_code = e_registration_code;
	}

	public String getPresenter_name() {
		return presenter_name;
	}

	public void setPresenter_name(String presenter_name) {
		this.presenter_name = presenter_name;
	}

	public String getFirst_party_executant_name() {
		return first_party_executant_name;
	}

	public void setFirst_party_executant_name(String first_party_executant_name) {
		this.first_party_executant_name = first_party_executant_name;
	}

	public String getFirst_party_executant_capacity() {
		return first_party_executant_capacity;
	}

	public void setFirst_party_executant_capacity(String first_party_executant_capacity) {
		this.first_party_executant_capacity = first_party_executant_capacity;
	}

	public String getDistrict_id() {
		return district_id;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public void setDistrict_id(String district_id) {
		this.district_id = district_id;
	}

	public String getDsr_location() {
		return dsr_location;
	}

	public void setDsr_location(String dsr_location) {
		this.dsr_location = dsr_location;
	}

	public String getDsr_location_desc() {
		return dsr_location_desc;
	}

	public void setDsr_location_desc(String dsr_location_desc) {
		this.dsr_location_desc = dsr_location_desc;
	}

	public String getDue_amount() {
		return due_amount;
	}

	public void setDue_amount(String due_amount) {
		this.due_amount = due_amount;
	}

	public List<CommonOptionsVO> getFirstPartyCapacityList() {
		return firstPartyCapacityList;
	}

	public void setFirstPartyCapacityList(List<CommonOptionsVO> firstPartyCapacityList) {
		this.firstPartyCapacityList = firstPartyCapacityList;
	}

	public Date getToken_date() {
		return token_date;
	}

	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}

	public Date getToken_time() {
		return token_time;
	}

	public void setToken_time(Date token_time) {
		this.token_time = token_time;
	}

	public String getDeed_category_id() {
		return deed_category_id;
	}

	public void setDeed_category_id(String deed_category_id) {
		this.deed_category_id = deed_category_id;
	}

	public String getDeed_type_id() {
		return deed_type_id;
	}

	public void setDeed_type_id(String deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	public BigDecimal getBaseFee() {
		return baseFee;
	}

	public void setBaseFee(BigDecimal baseFee) {
		this.baseFee = baseFee;
	}

	public BigDecimal getAdditionalFee() {
		return additionalFee;
	}

	public void setAdditionalFee(BigDecimal additionalFee) {
		this.additionalFee = additionalFee;
	}

	public BigDecimal getCess() {
		return cess;
	}

	public void setCess(BigDecimal cess) {
		this.cess = cess;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
	
	public void setParameters(){
		empID = (String) request.getSession().getAttribute("_EMPCODE");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		Locale locale = new Locale(language);
		ActionContext.getContext().setLocale(locale);
	}

	@SkipValidation
	public String execute() throws Exception {
		String returnValue = SUCCESS;

		this.dummyTokenDate = sdf.format(token_date);

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		
		int returnMessage = 1;
		log.fatal(token_no);
		try {
			
			CommonOptionsVO ob=manager.getDateAndTime(token_no);
			
			if(ob!=null){
			app_date1=ob.getTypeCode();
			hhmm=ob.getTypeDesc();
			}
			
			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);

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

	//@SkipValidation
	public String updateAppDate() throws Exception {
		this.setParameters();
		log.fatal("update");
		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;
		int updateMessage=0;
		Locale locale = new Locale(language);
		ActionContext.getContext().setLocale(locale);
		try {

			log.fatal("My DSR Location " + this.dsr_location + "," + this.token_no + "," + this.token_date);
			
			Date currentDateValue1 = new Date();
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
			String app_timestamp=null;
			if(app_date1!=null && app_date1.length()>0){
			app_timestamp=app_date1+" "+hhmm;
			log.fatal("app_timestamp:"+app_timestamp);
			/*this.app_date=formatter.format(app_timestamp);*/
			/*Calendar c=Calendar.getInstance();
			c.set(c.t, value);*/
			this.app_date=formatter.parse(app_timestamp);
			}
			else{
				this.app_date=null;
			}
			
			//log.fatal("app_date:"+app_date.toString());
			
			updateMessage=manager.updateAppDate(token_no, app_date);

			
			if (updateMessage==1) {
				operationFlag = true;
				returnMessage = "Appointment Date Updated";
			}

			else if (updateMessage==0) {
				returnMessage = insertOperationMessage;
				operationFlag = false;
			}

			

		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		if (operationFlag) {
			this.setPrintFlag(true);
			this.addActionMessage(returnMessage);
			return "home";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}

	}

	@SkipValidation
	public String exitDateEdit() throws Exception {
		return "home";
	}

	public void validate() {
		log.fatal("validate");
		try {

			this.setEdit(false);
			this.setParameters();

			

			if ((empID == null)  || (groupID == null) || (language == null)
					|| (empID.trim().length() == 0) 
					|| (groupID.trim().length() == 0) || (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));

			} else if (!validator.requiredFiledValidate(app_date1.trim())) {
				this.addFieldError("app_date1", "Date can't be empty");

			} 
			else if(!validator.requiredFiledValidate(hhmm.trim())){
				this.addFieldError("hhmm", "Time Cannot be empty");
			}else if(!Pattern.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d",app_date1)){
				this.addFieldError("app_date1", "Invalid Date Format");
			}else if(!Pattern.matches("\\d\\d:\\d\\d",hhmm)){
				this.addFieldError("hhmm", "Invalid Time Format");
			}else{
				String arr[]=hhmm.split(":");
				int hour=Integer.parseInt(arr[0]);
				int min=Integer.parseInt(arr[1]);
				if(!(hour>=10 && hour<=15))
					this.addFieldError("hhmm", "Time Limit between 10:00 Hrs and 15:59 hrs");
				else if(!(min>=0 && min<=59))
					this.addFieldError("hhmm", "Time Limit between 10:00 Hrs and 15:59 hrs");
			}
			
			/*else if((app_date1==null || app_date1.length()>0) &&
					(hhmm!=null && hhmm.length()<=0)){
				this.addFieldError("hhmm", "Hour Minute cannot be empty");
			}*/

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));
		}
	}

	/*@SkipValidation
	public void emptyField() throws Exception {
		try {
			
			
			
			
			this.setToken_no("");
			this.setPresenter_name("");
			this.setFirst_party_executant_name("");
			this.setFirst_party_executant_capacity("");
			this.setDistrict_id("");
			this.setDsr_location("");
			this.setDsr_location_desc("");
			this.setConsidered_amount("");
			this.setDue_amount("");
			this.setDeed_category_id("");
			this.setDeed_type_id("");
			this.setDoc_min_amount("");
			this.setApplicable_stamp_value("");
			this.setPresented_stamp_value("");
			this.setNo_total_pages("");
			this.setSpecial_deed_detail("");
			this.setE_registration_code("");
			this.setRel_last_reg_record("");
			this.setRel_last_reg_date("");
			this.setRel_last_reg_no("");
			this.setRel_last_reg_pow_of_atr("");
			this.setRel_last_reg_pow_of_atr_date("");
			this.setRel_last_reg_pow_of_atr_reg_no("");
			this.firstPartyCapacityList.clear();
		//	this.districtList.clear();
		//	this.dsrLocationList.clear();
			this.deedTypeList.clear();
			this.deedCategoryList.clear();
			this.setPermission_no("");
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
	}
*/
	public String getHh() {
		return hh;
	}

	public void setHh(String hh) {
		this.hh = hh;
	}

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	public String getApp_date1() {
		return app_date1;
	}

	public void setApp_date1(String app_date1) {
		this.app_date1 = app_date1;
	}

}
