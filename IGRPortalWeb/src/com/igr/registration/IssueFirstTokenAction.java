
package com.igr.registration;

import com.igr.commonUtility.CommonFourOptionsVO;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonThriceOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.util.HibernateManager;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
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

public class IssueFirstTokenAction extends ActionSupport implements ServletContextAware, ServletRequestAware {
    
    private static final long serialVersionUID = 1L;
    
    private static CommonValidation validator = new CommonValidation();
    private static Logger log = Logger.getLogger(IssueFirstTokenAction.class);
    HibernateManager manager = new HibernateManager();
    private static CommonHelper helper = new CommonHelper();
    private static InsertOperation insertOperation = new InsertOperation();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private String language;

    public String getLanguage() {
            return language;
    }
    public void setLanguage(String language) {
            this.language = language;
    }
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
    
    private String presenterName;
    private String party_type;
    private List<CommonOptionsVO> party_type_List;
    private String relativeType;
    private List<CommonOptionsVO> relativeTypeList;
    private String relativeName;
    private String presenterAddress;
    private String presenterState;
    private List<CommonOptionsVO> stateList;
    private String presenterPinCode;
    private String district_id;
    private List<CommonOptionsVO> districtList;
    private String presenterMobileNo;
    private String presentereMailId;
    private String dsrLocation;
    private List<CommonOptionsVO> dsrLocationList;
    private String deedType;
    private List<CommonOptionsVO> deedTypeList;
    private String totalPages;
    private File uploadDoc;

    public String getPresenterName() {
        return presenterName;
    }
    public void setPresenterName(String presenterName) {
        this.presenterName = presenterName;
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

    public String getRelativeType() {
        return relativeType;
    }
    public void setRelativeType(String relativeType) {
        this.relativeType = relativeType;
    }

    public List<CommonOptionsVO> getRelativeTypeList() {
        return relativeTypeList;
    }
    public void setRelativeTypeList(List<CommonOptionsVO> relativeTypeList) {
        this.relativeTypeList = relativeTypeList;
    }

    public String getRelativeName() {
        return relativeName;
    }
    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getPresenterAddress() {
        return presenterAddress;
    }
    public void setPresenterAddress(String presenterAddress) {
        this.presenterAddress = presenterAddress;
    }

    public String getPresenterState() {
        return presenterState;
    }
    public void setPresenterState(String presenterState) {
        this.presenterState = presenterState;
    }

    public List<CommonOptionsVO> getStateList() {
        return stateList;
    }
    public void setStateList(List<CommonOptionsVO> stateList) {
        this.stateList = stateList;
    }

    public String getPresenterPinCode() {
        return presenterPinCode;
    }
    public void setPresenterPinCode(String presenterPinCode) {
        this.presenterPinCode = presenterPinCode;
    }

    public String getDistrict_id() {
        return district_id;
    }
    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public List<CommonOptionsVO> getDistrictList() {
        return districtList;
    }
    public void setPDistrictList(List<CommonOptionsVO> districtList) {
        this.districtList = districtList;
    }

    public String getPresenterMobileNo() {
        return presenterMobileNo;
    }
    public void setPresenterMobileNo(String presenterMobileNo) {
        this.presenterMobileNo = presenterMobileNo;
    }

    public String getPresentereMailId() {
        return presentereMailId;
    }
    public void setPresentereMailId(String presentereMailId) {
        this.presentereMailId = presentereMailId;
    }

    public String getDsrLocation() {
        return dsrLocation;
    }
    public void setDsrLocation(String dsrLocation) {
        this.dsrLocation = dsrLocation;
    }

    public List<CommonOptionsVO> getDsrLocationList() {
        return dsrLocationList;
    }
    public void setDsrLocationList(List<CommonOptionsVO> dsrLocationList) {
        this.dsrLocationList = dsrLocationList;
    }

    public String getDeedType() {
        return deedType;
    }
    public void setDeedType(String deedType) {
        this.deedType = deedType;
    }

    public List<CommonOptionsVO> getDeedTypeList() {
        return deedTypeList;
    }
    public void setDeedTypeList(List<CommonOptionsVO> deedTypeList) {
        this.deedTypeList = deedTypeList;
    }

    public String getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public File getUploadDoc() {
        return uploadDoc;
    }
    public void setUploadDoc(File uploadDoc) {
        this.uploadDoc = uploadDoc;
    }
    
    private String empID;
    private String locationName;
    private String token_no;
    
    public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getToken_no() {
		return token_no;
	}
	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}
	
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	
	@SkipValidation
    @Override
    public String execute() throws Exception {
        log.fatal("addFirstToken....");
        empID = (String) request.getSession().getAttribute("_EMPCODE");
        //groupID = (String) request.getSession().getAttribute("_USERGROUP");
        language = (String) request.getSession().getAttribute("_LANGUAGE");
        log.fatal("language==="+language);
        
        try{
            log.fatal("firstTokenLoad() Try");
            
            deedTypeList = manager.searchDeedTypeForAmount(Integer.parseInt(language));
            
            List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
            allFirstPartyCapacityList = (List) context.getAttribute("GLOBALDROPDOWNLOV");

            party_type_List= new ArrayList<CommonOptionsVO>();
            party_type_List = helper.extractFourData("party_type",this.language, allFirstPartyCapacityList);

            relativeTypeList = new ArrayList<CommonOptionsVO>();
            relativeTypeList = helper.extractFourData("presenter_relation",this.language, allFirstPartyCapacityList);

            //stateList = new ArrayList<CommonOptionsVO>();
            //List<CommonThriceOptionsVO> allStateList = new ArrayList<CommonThriceOptionsVO>();

			stateList = new ArrayList<CommonOptionsVO>();
			stateList = helper.extractThriceData(this.language,(List) context.getAttribute("STATELOV"));
            //allStateList = (List) context.getAttribute("STATELOV");
            //stateList = helper.extractThriceData(this.language, allStateList);

            districtList = new ArrayList();
            districtList = manager.searchDistrictAll(Integer.parseInt(language));

            dsrLocationList = new ArrayList();
            
            deedTypeList = manager.searchDeedTypeForAmount(Integer.parseInt(language));
            

			//int returnMessage = helper.userLogActin(token_no, sdf1.parse(sdf1.format(token_date)),
					//Integer.parseInt("0"),Integer.parseInt(empID), "First_Token", "START");

            // END INITIALIZATION OF ARRAYLISTS AND VARIABLES
            Locale locale = new Locale(language);
            ActionContext.getContext().setLocale(locale);
            
            log.fatal("addFirstToken() Try finish");
        }catch(Exception e){
            log.fatal("addFirstToken() Exception "+e);
        }
        return "success";
    }
    
    public String addFirstToken(){
    	Date currentDateValue = new Date();
    	
    	log.fatal("addFirstToken() Function");
    	String insertOperationMessage = "0-System error Occured ";
        language = (String) request.getSession().getAttribute("_LANGUAGE");
        empID = (String) request.getSession().getAttribute("_EMPCODE");
        log.fatal("addFirstToken token"+language);
        token_no = "ABC001";
        try{
            log.fatal("addFirstToken() trying deedType="+deedType+"<<"+getParty_type_List()+">>");
            deedTypeList = manager.searchDeedTypeForAmount(Integer.parseInt(language));
            log.fatal("deedTypeList=================="+deedTypeList);
            String deedType_array[] = deedType.split("-");
            log.fatal("ABC===");
            
            String bookID = manager.searchBookIdWithDeed(Integer.parseInt(language), Integer.parseInt(deedType_array[0]));
            locationName=manager.searchSingleRowDSRName(Integer.parseInt(this.dsrLocation));
            
            String bookIDArray[]=bookID.split("~");
            if( bookIDArray.length>0){
                bookID=bookIDArray[0];
            }
            
            PDDocument mainDoc = PDDocument.load(uploadDoc);
            int count = mainDoc.getNumberOfPages();
            
            totalPages = ""+count;
            
            //if (count == (Integer.parseInt(this.totalPages))) {
            if (count % 2 == 0) {
            	
            	insertOperationMessage = insertOperation.insertFirstToken(
            			presenterName, relativeType, relativeName,
            			presenterAddress, presenterState, (presenterPinCode.trim().length()>0?Integer.parseInt(presenterPinCode):0),
    					district_id, dsrLocation, empID, language, locationName,
    					"global_p",party_type,Integer.parseInt(deedType_array[0]),Integer.parseInt(bookID),
    					uploadDoc,presenterMobileNo,presentereMailId,token_no,totalPages);
            	
            	log.fatal("insertOperationMessage=="+insertOperationMessage);
            	
                log.fatal("presenterName="+this.getPresenterName());
                log.fatal("party_type="+this.party_type);
                log.fatal("relativeType="+this.relativeType);
                log.fatal("relativeName="+this.relativeName);
                log.fatal("presenterAddress="+presenterAddress);

                log.fatal("presenterState="+presenterState);
                log.fatal("presenterPinCode="+presenterPinCode);
                log.fatal("district_id="+district_id);
                log.fatal("presenterMobileNo="+presenterMobileNo);
                log.fatal("presentereMailId="+presentereMailId);

                log.fatal("dsrLocation="+dsrLocation);
                log.fatal("deedType="+deedType);
                log.fatal("totalPages="+totalPages);
                log.fatal("uploadDoc="+uploadDoc);
                
                String[] arrayData = insertOperationMessage.split("-");
                if(arrayData[0].equals("1")) {
                	this.setDummyTokenNo(arrayData[1]);
                	this.setDummyPresenterName(this.getPresenterName());
                	this.setDummyDistrictID(district_id);
                	this.setDummyDsrLocation(dsrLocation);
                	this.setDummyTokenDate(sdf.parse(sdf.format(currentDateValue)));
                	//this.setDummyTokenDate(sdf.format(sdf.parse(""+currentDateValue)));
                	this.setDummyDeedID(deedType_array[0]);

                	this.setDummyPartyType(this.party_type);
                	this.setDummyPropertyPermission("");
                	this.setDummyDsrLocationDesc(locationName);
                	
                	this.addActionMessage("Generated Application ID "+arrayData[1]);

                	//helper.sendSMS(presenterMobileNo, "Your Token No "+arrayData[1]);
                	
                	//helper.sendSMS(presenterMobileNo, "Aapka Pre-Reg. Application ID("+arrayData[1]+") hai.");
                	
                	log.fatal("Aapka Pre-Reg. Application ID("+arrayData[1]+") hai.");
                	
                	this.emptyField();
                }else {
                	this.addActionError(arrayData[1]);
                }
            }
            else {
                //log.fatal("Total No. of Pages and Uploaded PDF file Page Count Mismatch, Page Count Should be "+this.totalPages+" and Selected PDF Page count is "+count);
                //this.addActionError("Total No. of Pages and Uploaded PDF file Page Count Mismatch, Page Count Should be "+this.totalPages+" and Selected PDF Page count is "+count);
                log.fatal("Uploaded PDF Pages Cont in Odd No."+count+", Please Upload PDF Pages Count in Even No.");
                this.addActionError("Uploaded PDF Pages Cont in Odd No."+count+", Please Upload PDF Pages Count in Even No.");
            }
            //this.emptyField();
            return "success";
        }catch(Exception e){
            log.fatal("execute Exception="+e);
            return "input";
        }
    }
    
    @SkipValidation
    public String loadDSRLocation() throws Exception {
        log.fatal("dsrlocation");
        log.fatal(district_id);
        try {
            dsrLocationList = new ArrayList<CommonOptionsVO>();
            if ((this.district_id != null) && (this.district_id.length() > 0) && (this.language != null) && (this.language.length() > 0)) {
            log.fatal("district id and language is not null");
            dsrLocationList = manager.searchLocationbyDistrictID(Integer.parseInt(language),Integer.parseInt(district_id));
            }
        } catch (Exception e) {
            log.fatal(e);
            log.fatal(helper.writeLogInUpperCase(e));
            throw new Exception(getText("global.system.error"));
        }
        log.fatal(dsrLocationList.size());
        return SUCCESS;
    }


    @SkipValidation
    public String exitFirstToken() throws Exception {
        log.fatal("First Token Exit");
        return "home";
    }

    public void validate() {
		try {

			//this.setEdit(false);
			this.execute();

			if ((empID == null) || (language == null) || (empID.trim().length() == 0) || (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));
			} else if (!validator.requiredFiledValidate(presenterName.trim())) {
				this.addFieldError("presenter_name", "Name can't be empty");
			} else if (!validator.languageValidate(presenterName.trim(),this.language)) {
				this.addFieldError("presenter_name","Pl. Input in Proper Language");
			} else if (!validator.validateNameField(presenterName.trim(),this.language)) {
				this.addFieldError("presenter_name","Presenter Name is not valid");
			} else if (!validator.requiredFiledValidate(relativeType.trim())) {
				this.addFieldError("relativeType", "Relation is Required");
			} else if (!validator.requiredFiledValidate(party_type.trim())) {
				this.addFieldError("party_type", "Party Type is Required");
			} else if (!validator.requiredFiledValidate(relativeName.trim())) {
				this.addFieldError("relativeName", "Father/Husband Name can't be empty");
			} else if (!validator.languageValidate(relativeName.trim(),this.language)) {
				this.addFieldError("relativeName","Pl. Input in Proper Language");
			} else if (!validator.validateNameField(relativeName.trim(),this.language)) {
				this.addFieldError("relativeName","Father/Husband Name is not valid");
			} else if (!validator.requiredFiledValidate(presenterAddress.trim())) {
				this.addFieldError("presenterAddress","Address can't be empty");
			} else if (!validator.languageValidate(presenterAddress.trim(),this.language)) {
				this.addFieldError("presenterAddress","Pl. Input in Proper Language");
			} else if (!validator.requiredFiledValidate(String.valueOf(presenterState).trim())) {
				this.addFieldError("presenterState", "State can't be empty");
			} else if (!validator.requiredFiledValidate(presenterPinCode.trim())) {
					this.addFieldError("presenterPinCode", "Pin can't be empty");
			} else if ((presenterPinCode!=null)&& (presenterPinCode.trim().length() > 0) && (!validator.validateIntegerField(String.valueOf(presenterPinCode).trim()))) {
				this.addFieldError("presenterPinCode", "PIN is not Valid");
			} else if (!validator.requiredFiledValidate(String.valueOf(deedType).trim())) {
				this.addFieldError("deedType", "Deed can't be empty");
			} else if ((presenterPinCode!=null)&& (presenterPinCode.trim().length() > 0) &&(!validator.neumericFiledValidate(String.valueOf(presenterPinCode).trim(), 6))) {
				this.addFieldError("presenterPinCode", "PIN is not Valid");
			} else if ((uploadDoc == null) || (uploadDoc.toString().trim().length() == 0)) {
				this.addFieldError("uploadDoc", "Scan Document is required");
			}/* else if (!validator.requiredFiledValidate(totalPages.trim())) {
				this.addFieldError("totalPages", "Total Page can't be empty");
			} else if (!validator.validateIntegerField(String.valueOf(totalPages).trim())) {
				this.addFieldError("totalPages", "Total Page is not Valid");
			}*/ else if (!validator.requiredFiledValidate(presenterMobileNo.trim())) {
				this.addFieldError("presenterMobileNo","Phone no can't be empty");
			} else if ((presenterMobileNo!=null)&& (presenterMobileNo.trim().length() > 0) &&(!validator.neumericFiledValidate(String.valueOf(presenterMobileNo).trim(), 6))) {
				this.addFieldError("presenterMobileNo", "Phn NO is not Valid");
			} else if ((presentereMailId.trim()!=null) && (presentereMailId.trim().trim().length() > 0) &&!validator.mailFiledValidate(presentereMailId.trim())) {
				this.addFieldError("presentereMailId", "mail id not valid");
			}

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));

		}
        /*log.fatal("First Token Validate");
        try {
            
        } catch (Exception e) {
            this.addActionError(getText("global.system.error"));
            log.fatal(helper.writeLogInUpperCase(e));
        }*/
    
    }
    @SkipValidation
    public void emptyField() throws Exception {
        try {
            this.setPresenterName("");
            this.setParty_type("");
            this.setRelativeType("");
			this.setPresenterState("0");
			this.setPresenterPinCode("");
			this.setRelativeName("");
			this.setParty_type("");
			this.setDeedType("");
			this.setUploadDoc(null);
			this.setTotalPages("");
			this.setNextFlag(true);
			this.setPresenterAddress("");
			this.setDistrict_id("0");
			this.setPresenterMobileNo("");
			this.setPresentereMailId("");
        } catch (Exception e) {
            log.fatal(helper.writeLogInUpperCase(e));
            throw new Exception(getText("global.system.error"));
        }
    }
    
    public String addDummyToken() throws Exception{
        log.fatal("presenterName="+presenterName);
        log.fatal("party_type="+party_type);
        return SUCCESS;
    }

	private boolean nextFlag;
	private String dummyTokenNo;
	private String dummyPresenterName;
	private String dummyDistrictID;
	private String dummyDsrLocation;
	private Date dummyTokenDate;
	private String dummyDeedID;

	private String dummyPartyType;
	private String dummyPropertyPermission;
	private String dummyDsrLocationDesc;

	public boolean isNextFlag() {
		return nextFlag;
	}
	public void setNextFlag(boolean nextFlag) {
		this.nextFlag = nextFlag;
	}
	public String getDummyTokenNo() {
		return dummyTokenNo;
	}
	public void setDummyTokenNo(String dummyTokenNo) {
		this.dummyTokenNo = dummyTokenNo;
	}
	public String getDummyPresenterName() {
		return dummyPresenterName;
	}
	public void setDummyPresenterName(String dummyPresenterName) {
		this.dummyPresenterName = dummyPresenterName;
	}
	public String getDummyDistrictID() {
		return dummyDistrictID;
	}
	public void setDummyDistrictID(String dummyDistrictID) {
		this.dummyDistrictID = dummyDistrictID;
	}
	public String getDummyDsrLocation() {
		return dummyDsrLocation;
	}
	public void setDummyDsrLocation(String dummyDsrLocation) {
		this.dummyDsrLocation = dummyDsrLocation;
	}
	public Date getDummyTokenDate() {
		return dummyTokenDate;
	}
	public void setDummyTokenDate(Date dummyTokenDate) {
		this.dummyTokenDate = dummyTokenDate;
	}
	public String getDummyDeedID() {
		return dummyDeedID;
	}
	public void setDummyDeedID(String dummyDeedID) {
		this.dummyDeedID = dummyDeedID;
	}
	public String getDummyPartyType() {
		return dummyPartyType;
	}
	public void setDummyPartyType(String dummyPartyType) {
		this.dummyPartyType = dummyPartyType;
	}
	public String getDummyPropertyPermission() {
		return dummyPropertyPermission;
	}
	public void setDummyPropertyPermission(String dummyPropertyPermission) {
		this.dummyPropertyPermission = dummyPropertyPermission;
	}
	public String getDummyDsrLocationDesc() {
		return dummyDsrLocationDesc;
	}
	public void setDummyDsrLocationDesc(String dummyDsrLocationDesc) {
		this.dummyDsrLocationDesc = dummyDsrLocationDesc;
	}
}