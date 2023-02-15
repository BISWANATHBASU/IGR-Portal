package com.igr.registration;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.commonUtility.CommonHelper;
import com.igr.databaseOperation.InsertOperation;
import com.opensymphony.xwork2.ActionSupport;

public class AppoimentAction extends ActionSupport implements ServletContextAware, ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(AppoimentAction.class);
	private static CommonHelper helper = new CommonHelper();
	private static InsertOperation insertOperation = new InsertOperation();

	private ServletContext context;
	private HttpServletRequest request;
	
	private String empID = "";
	
	private String token_no;
	private Date token_date;
	private String district_id;
	private String dsr_location;
	private String dsr_location_desc;
	private String considered_amount;
	private String e_registration_code;
	private String presented_stamp_value;
	private String no_total_pages;
	private double doc_min_amount;
	private String applicable_stamp_value;
	private String check_slip_count;
	private String presenter_name;
	private String first_party_executant_name;
	private String deed_type_id;
	private String deed_category_id;
	private String app_date1;
	

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getToken_no() {
		return token_no;
	}

	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}

	public Date getToken_date() {
		return token_date;
	}

	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}

	public String getDistrict_id() {
		return district_id;
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

	public String getConsidered_amount() {
		return considered_amount;
	}

	public void setConsidered_amount(String considered_amount) {
		this.considered_amount = considered_amount;
	}

	public String getE_registration_code() {
		return e_registration_code;
	}

	public void setE_registration_code(String e_registration_code) {
		this.e_registration_code = e_registration_code;
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

	public double getDoc_min_amount() {
		return doc_min_amount;
	}

	public void setDoc_min_amount(double doc_min_amount) {
		this.doc_min_amount = doc_min_amount;
	}

	public String getApplicable_stamp_value() {
		return applicable_stamp_value;
	}

	public void setApplicable_stamp_value(String applicable_stamp_value) {
		this.applicable_stamp_value = applicable_stamp_value;
	}

	public String getCheck_slip_count() {
		return check_slip_count;
	}

	public void setCheck_slip_count(String check_slip_count) {
		this.check_slip_count = check_slip_count;
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

	public String getDeed_type_id() {
		return deed_type_id;
	}

	public void setDeed_type_id(String deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	public String getDeed_category_id() {
		return deed_category_id;
	}

	public void setDeed_category_id(String deed_category_id) {
		this.deed_category_id = deed_category_id;
	}

	public String getApp_date1() {
		return app_date1;
	}

	public void setApp_date1(String app_date1) {
		this.app_date1 = app_date1;
	}



	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
    
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@SkipValidation
	public String execute() throws Exception {
		String returnValue = SUCCESS;
		int returnMessage = 1;
		try {
			 
			//if((this.reportTokenDate!=null)&&(this.reportTokenDate.trim().length()>=1))
				//this.token_date=sdf1.parse(this.reportTokenDate);
			
			//this.dummyTokenDate = sdf.format(token_date);

			empID = (String) request.getSession().getAttribute("_EMPCODE");
			language = (String) request.getSession().getAttribute("_LANGUAGE");
			
		} catch (Exception e) {
			returnMessage = 0;
			log.fatal(helper.writeLogInUpperCase(e));
			this.addActionError(getText("global.system.error"));
		}
		if (returnMessage == 1)
			returnValue = SUCCESS;
		else if (returnMessage == 0) {
			this.addActionError(getText("global.system.error"));
			return "home";
		}
		return returnValue;
	}
	
	public String addAppoimentEntry() throws Exception {
		
		String insertOperationMessage = "0";
		try{
			
			
			empID = (String) request.getSession().getAttribute("_EMPCODE");
			language = (String) request.getSession().getAttribute("_LANGUAGE");
		
			log.fatal("Inserting Cash Payment Data");
			log.fatal("this.token_no="+this.token_no+",this.token_date="+this.token_date+",this.dsr_location="+this.dsr_location+",language="+language+",empID="+empID+",this.app_date1="+this.app_date1);
			log.fatal("this.token_no="+this.token_no+",this.token_date="+this.token_date+",Integer.parseInt(this.dsr_location)="+Integer.parseInt(this.dsr_location)+",Integer.parseInt(language)="+Integer.parseInt(language)+",Integer.parseInt(empID)="+Integer.parseInt(empID)+",this.app_date1="+this.app_date1);
			
			insertOperationMessage = insertOperation.insertAppoimentDeatil(this.token_no, this.token_date,Integer.parseInt(this.dsr_location),Integer.parseInt(language), Integer.parseInt(empID),sdf.parse(this.app_date1) );
			
			log.fatal("paymentConfirm Updation ............"+insertOperationMessage);
			
		}catch(Exception e){
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			this.addActionError("System Error. Contact IT");
		}
		
		this.addActionMessage(insertOperationMessage);
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
}
