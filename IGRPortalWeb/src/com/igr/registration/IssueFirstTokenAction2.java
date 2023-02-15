package com.igr.registration;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.commonUtility.CommonFourOptionsVO;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.databaseOperation.InsertOperation;
//import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IssueFirstTokenAction2 extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String language = "";
	private String locationName = "";
	private String districtID = "";
	private String districtName = "";
	private boolean edit;
    private String token_no;
	private String presenter_name;
	private String presenter_fh_rel;
	private String presenter_fh_name;
	private String presenter_address;
	private int presenter_state;
	private String presenter_pin;
	private int district_id;
	private int dsr_location;
	private String districtCode;
	private boolean printFlag;
	private String dummyTokenNo;
	private Date dummyTokenDate;
	private String dummyPresenterName;
	private String dummyDsrLocation;
	private String party_type;
	private String dummyPartyType;
	private String dummyTokenDateReport;
	private String deed_type_id;
	private File fileUpload;
	private String total_page_no;
	private String presenter_phone_no;
	private String presenter_email_id;
	

	private ServletContext context;
	private HttpServletRequest request;

	private List<CommonOptionsVO> stateList;
	private List<CommonOptionsVO> dsrLocationList;
	private List<CommonOptionsVO> districtList;
	private List<CommonOptionsVO> relationList;
	private List<CommonOptionsVO> party_type_List;
	private List<CommonOptionsVO> deedTypeList;

	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

	private static InsertOperation insertOperation = new InsertOperation();
	private static final Logger log = Logger
			.getLogger(IssueFirstTokenAction2.class);

	public String getPresenter_name() {
		return presenter_name;
	}

	public void setPresenter_name(String presenter_name) {
		this.presenter_name = presenter_name;
	}

	public String getPresenter_fh_rel() {
		return presenter_fh_rel;
	}
	
	
	
	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getTotal_page_no() {
		return total_page_no;
	}

	public void setTotal_page_no(String total_page_no) {
		this.total_page_no = total_page_no;
	}

	public String getDummyTokenDateReport() {
		return dummyTokenDateReport;
	}

	public void setDummyTokenDateReport(String dummyTokenDateReport) {
		this.dummyTokenDateReport = dummyTokenDateReport;
	}

	public void setPresenter_fh_rel(String presenter_fh_rel) {
		this.presenter_fh_rel = presenter_fh_rel;
	}
	
	public String getParty_type() {
		return party_type;
	}

	public void setParty_type(String party_type) {
		this.party_type = party_type;
	}

	public List<CommonOptionsVO> getParty_type_List() {
		return party_type_List;
	}

	public void setParty_type_List(List<CommonOptionsVO> party_type_List) {
		this.party_type_List = party_type_List;
	}

	public String getDummyPresenterName() {
		return dummyPresenterName;
	}

	public void setDummyPresenterName(String dummyPresenterName) {
		this.dummyPresenterName = dummyPresenterName;
	}

	public String getDummyDsrLocation() {
		return dummyDsrLocation;
	}

	public void setDummyDsrLocation(String dummyDsrLocation) {
		this.dummyDsrLocation = dummyDsrLocation;
	}

	public String getDummyTokenNo() {
		return dummyTokenNo;
	}

	public void setDummyTokenNo(String dummyTokenNo) {
		this.dummyTokenNo = dummyTokenNo;
	}

	public Date getDummyTokenDate() {
		return dummyTokenDate;
	}

	public void setDummyTokenDate(Date dummyTokenDate) {
		this.dummyTokenDate = dummyTokenDate;
	}

	public boolean isPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(boolean printFlag) {
		this.printFlag = printFlag;
	}

	public String getPresenter_fh_name() {
		return presenter_fh_name;
	}
	
	

	public String getDummyPartyType() {
		return dummyPartyType;
	}

	public void setDummyPartyType(String dummyPartyType) {
		this.dummyPartyType = dummyPartyType;
	}

	public void setPresenter_fh_name(String presenter_fh_name) {
		this.presenter_fh_name = presenter_fh_name;
	}

	public String getPresenter_address() {
		return presenter_address;
	}

	public void setPresenter_address(String presenter_address) {
		this.presenter_address = presenter_address;
	}

	public int getPresenter_state() {
		return presenter_state;
	}

	public void setPresenter_state(int presenter_state) {
		this.presenter_state = presenter_state;
	}

	public String getPresenter_pin() {
		return presenter_pin;
	}

	public void setPresenter_pin(String presenter_pin) {
		this.presenter_pin = presenter_pin;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public int getDsr_location() {
		return dsr_location;
	}

	public void setDsr_location(int dsr_location) {
		this.dsr_location = dsr_location;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public List<CommonOptionsVO> getStateList() {
		return stateList;
	}

	public void setStateList(List<CommonOptionsVO> stateList) {
		this.stateList = stateList;
	}

	public List<CommonOptionsVO> getDsrLocationList() {
		return dsrLocationList;
	}

	public void setDsrLocationList(List<CommonOptionsVO> dsrLocationList) {
		this.dsrLocationList = dsrLocationList;
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

	public List<CommonOptionsVO> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<CommonOptionsVO> relationList) {
		this.relationList = relationList;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

	
	
	
	
	public List<CommonOptionsVO> getDeedTypeList() {
		return deedTypeList;
	}

	public void setDeedTypeList(List<CommonOptionsVO> deedTypeList) {
		this.deedTypeList = deedTypeList;
	}
	


	public String getDeed_type_id() {
		return deed_type_id;
	}

	public void setDeed_type_id(String deed_type_id) {
		this.deed_type_id = deed_type_id;
	}
	

	public String getPresenter_phone_no() {
		return presenter_phone_no;
	}

	public void setPresenter_phone_no(String presenter_phone_no) {
		this.presenter_phone_no = presenter_phone_no;
	}

	public String getPresenter_email_id() {
		return presenter_email_id;
	}

	public void setPresenter_email_id(String presenter_email_id) {
		this.presenter_email_id = presenter_email_id;
	}


	
	public String getToken_no() {
		return token_no;
	}

	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}
	
	
	
	

	public IssueFirstTokenAction2()
	{
		
		
		
	}

    
    /*@SkipValidation
    public String loadDSRLocation() throws Exception {
        log.fatal("dsrlocation");
        log.fatal("district_id====="+district_id);
        try {
            dsrLocationList = new ArrayList<CommonOptionsVO>();
            //if ((this.district_id != null) && (this.district_id.length() > 0) && (this.language != null) && (this.language.length() > 0)) {
            log.fatal("district id and language is not null");
            dsrLocationList = manager.searchLocationbyDistrictID(Integer.parseInt(language),district_id);
            //}
        } catch (Exception e) {
            log.fatal(e);
            log.fatal(helper.writeLogInUpperCase(e));
            throw new Exception(getText("global.system.error"));
        }
        log.fatal(dsrLocationList.size());
        return SUCCESS;
    }*/
	
	
	@SkipValidation
	public String execute() throws Exception {

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		//branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		//groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
        log.fatal("language===>>>"+language);
		//locationName = (String) request.getSession().getAttribute("LOCATIONNAME");
		//districtID = (String) request.getSession().getAttribute("DISTRICT_CODE");
		//districtName = (String) request.getSession().getAttribute("DISTRICT_NAME");
		//userLogModel logModel = new userLogModel();
		int returnMessage = 1;
		String returnValue = SUCCESS;

		try {
			/*String limit = manager.getOperationTime("FIRST TOKEN");
	        Date limitTime=null;
			
	    	limitTime=sdf2.parse(limit);
			Date currentDate = new Date();
			String currentTime=sdf2.format(currentDate);
			Date currentDateTime=sdf2.parse(currentTime);
			log.fatal("limitTime "+limitTime+"  "+currentDateTime);
			if(currentDateTime.after(limitTime)){
				
				this.addActionError("Entry Time is over");
				return "home";
				
			}*/
			
			if((this.token_no==null)||(this.token_no.length()<=0))
			{
			//this.token_no = insertOperation.getFirstToken(Integer.parseInt(branchCode));
			/*Date currentDateValue = new Date();
			//	String tokenArray[] = this.token_no.split("-");
				returnMessage = helper.userLogActin(
						Integer.parseInt(this.token_no), sdf.parse(sdf.format(currentDate)),
						Integer.parseInt(branchCode),
						Integer.parseInt(empID), "Issue_First_Token", "START");
			*/
			
			}
			List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
			allFirstPartyCapacityList = (List) context
					.getAttribute("GLOBALDROPDOWNLOV");

			// START INITIALIZATION OF ARRAYLISTS AND VARIABLES
			stateList = new ArrayList<CommonOptionsVO>();
			stateList = helper.extractThriceData(this.language,(List) context.getAttribute("STATELOV"));
			
			dsrLocationList = new ArrayList();
			//CommonOptionsVO optionVO = new CommonOptionsVO(branchCode,locationName);
			//dsrLocationList.add(optionVO);

            districtList = new ArrayList();
            districtList = manager.searchDistrictAll(Integer.parseInt(language));

			/*districtList = new ArrayList();
			CommonOptionsVO optionVO1 = new CommonOptionsVO(districtID,districtName);
			districtList.add(optionVO1);*/

			relationList = new ArrayList<CommonOptionsVO>();
			relationList = helper.extractFourData("presenter_relation",
					this.language, allFirstPartyCapacityList);
			
			party_type_List= new ArrayList<CommonOptionsVO>();
			party_type_List = helper.extractFourData("party_type",
					this.language, allFirstPartyCapacityList);
			
			deedTypeList = manager.searchDeedTypeForAmount(Integer
					.parseInt(language));


			if (isEdit()) {
							
				this.setEdit(false);
			}

			// END INITIALIZATION OF ARRAYLISTS AND VARIABLES
			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);

		} catch (Exception e) {
			returnMessage = 0;
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		if (returnMessage == 1){
			returnValue = SUCCESS;
			
		}

		else if (returnMessage == 0) {
			this.addActionError(getText("global.system.error"));
			return "home";
		}
		return returnValue;
	}

	@SkipValidation
	public String exitFirstToken() throws Exception {
		return "home";
	}

	public String addFirstToken() throws Exception {

		String returnMessage = "";
		String bookID = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;
		String deed_type_id_array[] = deed_type_id.split("-");
		
	
	
		Date currentDateValue = new Date();
		
		bookID = manager.searchBookIdWithDeed(Integer.parseInt(language), Integer.parseInt(deed_type_id_array[0]));
		
		String bookIDArray[]=bookID.split("~");
		
		if( bookIDArray.length>0)
		{
			bookID=bookIDArray[0];
		}
		

		try {
		    
					PDDocument mainDoc = PDDocument.load(fileUpload);
					int count = mainDoc.getNumberOfPages();
					
					if ((Integer.parseInt(this.total_page_no)% 2 == 0)&&(count == (Integer.parseInt(this.total_page_no)))) {
						
		    	/*int returnVal = helper.userLogActin(
					Integer.parseInt(this.token_no), sdf.parse(sdf.format(currentDateValue)),
					Integer.parseInt(branchCode),
					Integer.parseInt(empID), "Scan_Document_Upload", "START"); */
						
						
						
			insertOperationMessage = "";/*insertOperation.insertFirstToken(
					presenter_name, presenter_fh_rel, presenter_fh_name,
					presenter_address, presenter_state, (presenter_pin.trim().length()>0?Integer.parseInt(presenter_pin):0),
					district_id, dsr_location, empID, language, locationName,
					"global_p",party_type,Integer.parseInt(deed_type_id_array[0]),Integer.parseInt(bookID),
					fileUpload,presenter_phone_no,presenter_email_id,token_no,total_page_no);
			/*
					presenter_name, presenter_fh_rel, presenter_fh_name,
					presenter_address, presenter_state, (presenter_pin.trim().length()>0?Integer.parseInt(presenter_pin):0),
					district_id, dsr_location, empID, language, locationName,
					"global_s",party_type,Integer.parseInt(deed_type_id_array[0]),Integer.parseInt(bookID),
					fileUpload,presenter_phone_no,presenter_email_id,token_no,total_page_no*/
			
	   	String tokenArray[]=insertOperationMessage.split("-");
			
			
			
			
			if (insertOperationMessage.trim().substring(0, 1).equalsIgnoreCase("1")) {
				
				this.setDummyTokenNo(this.token_no);
				this.setDummyTokenDate(currentDateValue);
				this.setDummyPresenterName(presenter_name);
				this.setDummyDsrLocation(String.valueOf(dsr_location));
				this.setDummyPartyType(party_type);
				this.setDummyTokenDateReport(sdf1.format(currentDateValue));
				
				this.setPrintFlag(true);	
				operationFlag = true;
				
				/*int returnVal1 = helper.userLogActin(
						Integer.parseInt(this.token_no), sdf.parse(sdf.format(currentDateValue)),
						Integer.parseInt(branchCode),
						Integer.parseInt(empID), "Scan_Document_Upload", "END"); 
							*/
				
				
			}

			else if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("0")) {
				operationFlag = false;
			}

			returnMessage = insertOperationMessage.substring(1,
					insertOperationMessage.trim().length());
					}
					else {
				this.addActionError("Either Page count entered is odd or Total No. of Pages and Uploaded PDF file Page Count Mismatch, Page Count Should be "+this.total_page_no+" and Selected PDF Page count is "+count);

			}

		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		if (operationFlag) {
			this.emptyField();
			this.addActionMessage(returnMessage);
			return "success";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}

	}

	public void validate() {
		try {

			this.setEdit(false);
			this.execute();

			if ((empID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));

			} else if (!validator.requiredFiledValidate(presenter_name.trim())) {
				this.addFieldError("presenter_name", "Name can't be empty");
			} else if (!validator.languageValidate(presenter_name.trim(),
					this.language)) {
				this.addFieldError("presenter_name",
						"Pl. Input in Proper Language");

			} else if (!validator.validateNameField(presenter_name.trim(),
					this.language)) {
				this.addFieldError("presenter_name",
						"Presenter Name is not valid");

			} else if (!validator
					.requiredFiledValidate(presenter_fh_rel.trim())) {
				this.addFieldError("presenter_fh_rel", "Relation is Required");
			}
			
			else if (!validator
					.requiredFiledValidate(party_type.trim())) {
				this.addFieldError("party_type", "Party Type is Required");
			}

			else if (!validator.requiredFiledValidate(presenter_fh_name.trim())) {
				this.addFieldError("presenter_fh_name",
						"Father/Husband Name can't be empty");
			} else if (!validator.languageValidate(presenter_fh_name.trim(),
					this.language)) {
				this.addFieldError("presenter_fh_name",
						"Pl. Input in Proper Language");

			} else if (!validator.validateNameField(presenter_fh_name.trim(),
					this.language)) {
				this.addFieldError("presenter_fh_name",
						"Father/Husband Name is not valid");

			}

			else if (!validator.requiredFiledValidate(presenter_address.trim())) {
				this.addFieldError("presenter_address",
						"Address can't be empty");
			} else if (!validator.languageValidate(presenter_address.trim(),
					this.language)) {
				this.addFieldError("presenter_address",
						"Pl. Input in Proper Language");

			}

			else if (!validator.requiredFiledValidate(String.valueOf(
					presenter_state).trim())) {
				this.addFieldError("presenter_state", "State can't be empty");
			}
				else if (!validator.requiredFiledValidate(presenter_pin.trim())) {
					this.addFieldError("presenter_pin", "Pin can't be empty");
				
			}  else if ((presenter_pin!=null)&&
					(presenter_pin.trim().length() > 0)
					&& (!validator.validateIntegerField(String.valueOf(
							presenter_pin).trim()))) {
				this.addFieldError("presenter_pin", "PIN is not Valid");
			}else if (!validator.requiredFiledValidate(String.valueOf(
					deed_type_id).trim())) {
				this.addFieldError("deed_type_id", "Deed can't be empty");
			}

			else if ((presenter_pin!=null)&&
					(presenter_pin.trim().length() > 0)
					&&(!validator.neumericFiledValidate(
					String.valueOf(presenter_pin).trim(), 6))) {
				this.addFieldError("presenter_pin", "PIN is not Valid");
			}
			
			else if ((fileUpload == null)
					|| (fileUpload.toString().trim().length() == 0)) {
				this.addFieldError("fileUpload", "Scan Document is required");
			}
			
			else if (!validator.requiredFiledValidate(total_page_no.trim())) {
				this.addFieldError("total_page_no", "Total Page can't be empty");
			} else if (!validator.validateIntegerField(String.valueOf(
					total_page_no).trim())) {
				this.addFieldError("total_page_no", "Total Page is not Valid");
			}
			else if (!validator.requiredFiledValidate(presenter_phone_no.trim())) {
				this.addFieldError("presenter_phone_no",
						"Phone no can't be empty");
			
			}
			else if ((presenter_phone_no!=null)&&
					(presenter_phone_no.trim().length() > 0)
					&&(!validator.neumericFiledValidate(
					String.valueOf(presenter_phone_no).trim(), 6))) {
				this.addFieldError("presenter_phone_no", "Phn NO is not Valid");
			}
			else if ((presenter_email_id.trim()!=null)&&
					(presenter_email_id.trim().trim().length() > 0)
					&&!validator.mailFiledValidate(presenter_email_id.trim())) {
				this.addFieldError("presenter_email_id",
						"mail id not valid");
			}

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));

		}
	}

	// END OF VALIDATION

	public void emptyField() throws Exception {
		try {
			
			//Date currentDateValue = new Date();
			
			/*int returnMessage = helper.userLogActin(
					Integer.parseInt(this.token_no), sdf.parse(sdf.format(currentDateValue)),
					Integer.parseInt(branchCode),
					Integer.parseInt(empID), "Issue_First_Token", "END");
			*/
			
			
			this.setPresenter_name("");
			this.setPresenter_fh_name("");
			this.setPresenter_address("");
			this.setPresenter_state(0);
			this.setPresenter_pin("");
			this.setPresenter_fh_rel("");
			this.setParty_type("");
			this.setDeed_type_id("");
			this.setFileUpload(null);
			this.setTotal_page_no("");
			this.setToken_no("");
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
	}

}