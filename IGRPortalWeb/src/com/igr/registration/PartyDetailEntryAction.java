package com.igr.registration;

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

import com.igr.commonUtility.CommonFourOptionsVO;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.partyDetailModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PartyDetailEntryAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	
	
	
	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String locationName = "";
	private String districtID = "";
	private String districtName = "";
	private float stampValue = 0f;

	private boolean edit;
	private String party_type_id;
	private String party_name;
	private String party_fh_rel;
	private String party_fh_rel_name;
	private String profession;
	private String gender;
	private String caste;
	private String pan_no;
	private String address;
	private String ph_no;
	private String address_proof;
	private int created_by;
	private Date created_date;
	private int updated_by;
	private Date updated_date;
	private String language;
	private String deed_type_id;
	private String address_proof_value;
	private String dsr_location;
	private String token_no;
	private Date token_date;
	private String deedID;
	private String district_id;
	private String anotherParty;
	private String party_name_hindi;
	private String sub_cast;
	private boolean printFlag;
	private String dummyTokenNo;
	private Date dummyTokenDate;
	private String dummyDeedID;
	private String dummyFirstPartyName;
	private String dummyDistrictID;
	private boolean dummyNavigationFlag;
	private String dummyDsrLocation;
	private String dummyPresenterName;
	private String dummyFirstPartyExecutantCapacity;
	private String dummyDeedCategoryId;
	private String dummyConsideredAmount;
	private String dummyERegistrationId;
	private String dummyStampNoWithVal;
	private String dummyOriginalDeedTotalPageNo;
	private String dummyTotalStampValue;
	private String castValue;
	private String biometric_required;
	
	private boolean dummyCallNature;
	
	private ServletContext context;
	private HttpServletRequest request;
	
	
	private List<CommonOptionsVO> partyTypeList;
	private List<CommonOptionsVO> deedTypeList;
	private List<CommonOptionsVO> relationList;
	private List<CommonOptionsVO> professionList;
	private List<CommonOptionsVO> sexList;
	private List<CommonOptionsVO> casteList;
	private List<CommonOptionsVO> addressprooftypeList;
	private List<CommonOptionsVO> anatherPartyList;
	private List<CommonOptionsVO> partyDetailList;
	private List<CommonOptionsVO> subCasteList;
	private List<CommonOptionsVO> biometric_required_list;
	
	 
	 private static CommonValidation validator = new CommonValidation();
		private static CommonHelper helper = new CommonHelper();
		HibernateManager manager = new HibernateManager();
		private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		/*private static final Logger log = Logger
				.getLogger(PartyDetailEntryAction.class);*/
		private static Logger log = Logger.getLogger(PartyDetailEntryAction.class);
		private static InsertOperation insertOperation = new InsertOperation();

	
	
	

	public String getCastValue() {
			return castValue;
		}

		public void setCastValue(String castValue) {
			this.castValue = castValue;
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

		public String getDummyDeedID() {
			return dummyDeedID;
		}

		public void setDummyDeedID(String dummyDeedID) {
			this.dummyDeedID = dummyDeedID;
		}

		public String getDummyFirstPartyName() {
			return dummyFirstPartyName;
		}

		public void setDummyFirstPartyName(String dummyFirstPartyName) {
			this.dummyFirstPartyName = dummyFirstPartyName;
		}

		public String getDummyDistrictID() {
			return dummyDistrictID;
		}

		public void setDummyDistrictID(String dummyDistrictID) {
			this.dummyDistrictID = dummyDistrictID;
		}

		public boolean getDummyNavigationFlag() {
			return dummyNavigationFlag;
		}
		
		

		public String getDummyTotalStampValue() {
			return dummyTotalStampValue;
		}

		public void setDummyTotalStampValue(String dummyTotalStampValue) {
			this.dummyTotalStampValue = dummyTotalStampValue;
		}

		public void setDummyNavigationFlag(boolean dummyNavigationFlag) {
			this.dummyNavigationFlag = dummyNavigationFlag;
		}

		public String getDummyDsrLocation() {
			return dummyDsrLocation;
		}

		public void setDummyDsrLocation(String dummyDsrLocation) {
			this.dummyDsrLocation = dummyDsrLocation;
		}
		
		

	public String getDistrict_id() {
			return district_id;
		}

		public void setDistrict_id(String district_id) {
			this.district_id = district_id;
		}

	public String getDeedID() {
		return deedID;
	}
	
	public String getBiometric_required() {
		return biometric_required;
	}

	public void setBiometric_required(String biometric_required) {
		this.biometric_required = biometric_required;
	}

	public List<CommonOptionsVO> getBiometric_required_list() {
		return biometric_required_list;
	}

	public void setBiometric_required_list(
			List<CommonOptionsVO> biometric_required_list) {
		this.biometric_required_list = biometric_required_list;
	}

	public void setDeedID(String deedID) {
		this.deedID = deedID;
	}

	public String getAddress_proof_value() {
		return address_proof_value;
	}

	public void setAddress_proof_value(String address_proof_value) {
		this.address_proof_value = address_proof_value;
	}
	
	public String getSub_cast() {
		return sub_cast;
	}
	

	public boolean isDummyCallNature() {
		return dummyCallNature;
	}

	public void setDummyCallNature(boolean dummyCallNature) {
		this.dummyCallNature = dummyCallNature;
	}

	public void setSub_cast(String sub_cast) {
		this.sub_cast = sub_cast;
	}
	
	
	

	

	public boolean isPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(boolean printFlag) {
		this.printFlag = printFlag;
	}

	public String getDummyPresenterName() {
		return dummyPresenterName;
	}

	public void setDummyPresenterName(String dummyPresenterName) {
		this.dummyPresenterName = dummyPresenterName;
	}

	public String getDummyFirstPartyExecutantCapacity() {
		return dummyFirstPartyExecutantCapacity;
	}

	public void setDummyFirstPartyExecutantCapacity(
			String dummyFirstPartyExecutantCapacity) {
		this.dummyFirstPartyExecutantCapacity = dummyFirstPartyExecutantCapacity;
	}

	public String getDummyDeedCategoryId() {
		return dummyDeedCategoryId;
	}

	public void setDummyDeedCategoryId(String dummyDeedCategoryId) {
		this.dummyDeedCategoryId = dummyDeedCategoryId;
	}

	public String getDummyConsideredAmount() {
		return dummyConsideredAmount;
	}

	public void setDummyConsideredAmount(String dummyConsideredAmount) {
		this.dummyConsideredAmount = dummyConsideredAmount;
	}

	public String getDummyERegistrationId() {
		return dummyERegistrationId;
	}

	public void setDummyERegistrationId(String dummyERegistrationId) {
		this.dummyERegistrationId = dummyERegistrationId;
	}

	public String getDummyStampNoWithVal() {
		return dummyStampNoWithVal;
	}

	public void setDummyStampNoWithVal(String dummyStampNoWithVal) {
		this.dummyStampNoWithVal = dummyStampNoWithVal;
	}

	public String getDummyOriginalDeedTotalPageNo() {
		return dummyOriginalDeedTotalPageNo;
	}

	public void setDummyOriginalDeedTotalPageNo(String dummyOriginalDeedTotalPageNo) {
		this.dummyOriginalDeedTotalPageNo = dummyOriginalDeedTotalPageNo;
	}


	public String getParty_name_hindi() {
		return party_name_hindi;
	}

	public void setParty_name_hindi(String party_name_hindi) {
		this.party_name_hindi = party_name_hindi;
	}

	public String getParty_type_id() {
		return party_type_id;
	}

	public void setParty_type_id(String party_type_id) {
		this.party_type_id = party_type_id;
	}

	public String getParty_name() {
		return party_name;
	}

	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}

	public String getParty_fh_rel() {
		return party_fh_rel;
	}

	public void setParty_fh_rel(String party_fh_rel) {
		this.party_fh_rel = party_fh_rel;
	}

	public String getParty_fh_rel_name() {
		return party_fh_rel_name;
	}

	public void setParty_fh_rel_name(String party_fh_rel_name) {
		this.party_fh_rel_name = party_fh_rel_name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDsr_location() {
		return dsr_location;
	}

	public void setDsr_location(String dsr_location) {
		this.dsr_location = dsr_location;
	}

	public Date getToken_date() {
		return token_date;
	}

	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}

	public String getPh_no() {
		return ph_no;
	}

	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}

	public String getAddress_proof() {
		return address_proof;
	}

	public void setAddress_proof(String address_proof) {
		this.address_proof = address_proof;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<CommonOptionsVO> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<CommonOptionsVO> relationList) {
		this.relationList = relationList;
	}

	

	
	public List<CommonOptionsVO> getAnatherPartyList() {
		return anatherPartyList;
	}

	public void setAnatherPartyList(List<CommonOptionsVO> anatherPartyList) {
		this.anatherPartyList = anatherPartyList;
	}

	public String getAnotherParty() {
		return anotherParty;
	}

	
	public List<CommonOptionsVO> getSubCasteList() {
		return subCasteList;
	}

	public void setSubCasteList(List<CommonOptionsVO> subCasteList) {
		this.subCasteList = subCasteList;
	}
	
	
	public List<CommonOptionsVO> getPartyDetailList() {
		return partyDetailList;
	}

	public void setPartyDetailList(List<CommonOptionsVO> partyDetailList) {
		this.partyDetailList = partyDetailList;
	}

	public void setAnotherParty(String anotherParty) {
		this.anotherParty = anotherParty;
	}

	

	

	public List<CommonOptionsVO> getAddressprooftypeList() {
		return addressprooftypeList;
	}

	public void setAddressprooftypeList(
			List<CommonOptionsVO> addressprooftypeList) {
		this.addressprooftypeList = addressprooftypeList;
	}

	public List<CommonOptionsVO> getProfessionList() {
		return professionList;
	}

	public void setProfessionList(List<CommonOptionsVO> professionList) {
		this.professionList = professionList;
	}

	public List<CommonOptionsVO> getSexList() {
		return sexList;
	}

	public void setSexList(List<CommonOptionsVO> sexList) {
		this.sexList = sexList;
	}

	public List<CommonOptionsVO> getCasteList() {
		return casteList;
	}

	public void setCasteList(List<CommonOptionsVO> casteList) {
		this.casteList = casteList;
	}

	public List<CommonOptionsVO> getDeedTypeList() {
		return deedTypeList;
	}

	public void setDeedTypeList(List<CommonOptionsVO> deedTypeList) {
		this.deedTypeList = deedTypeList;
	}

	public List<CommonOptionsVO> getPartyTypeList() {
		return partyTypeList;
	}

	public void setPartyTypeList(List<CommonOptionsVO> partyTypeList) {
		this.partyTypeList = partyTypeList;
	}

	public String getToken_no() {
		return token_no;
	}

	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	

	public String getDistrictID() {
		return districtID;
	}

	public void setDistrictID(String districtID) {
		this.districtID = districtID;
	}

	public String getDeed_type_id() {
		return deed_type_id;
	}

	public void setDeed_type_id(String deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

	@SkipValidation
	public String execute() throws Exception {

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		log.fatal("District_id:"+district_id);
		/*districtID = (String) request.getSession()
				.getAttribute("DISTRICT_CODE");*/
		/*districtName = (String) request.getSession().getAttribute(
				"DISTRICT_NAME");*/
		//this.setDummyDistrictID(this.district_id);
		int returnMessage = 1;
		String returnValue = SUCCESS;
	

		try {

		List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
		allFirstPartyCapacityList = (List) context
				.getAttribute("GLOBALDROPDOWNLOV");
		
		/*List<CommonOptionsVO> subCastList = new ArrayList<CommonOptionsVO>();
		subCastList = (List) context
				.getAttribute("SUBCASTLOV");	*/
	
			relationList = new ArrayList<CommonOptionsVO>();
			relationList = helper.extractFourData("presenter_relation",
					this.language, allFirstPartyCapacityList);

			professionList = new ArrayList<CommonOptionsVO>();
			professionList = helper.extractFourData("party_profession",
					this.language, allFirstPartyCapacityList);

			sexList = new ArrayList<CommonOptionsVO>();
			sexList = helper.extractFourData("party_sex", this.language,
					allFirstPartyCapacityList);

			casteList = new ArrayList<CommonOptionsVO>();
			casteList = helper.extractFourData("party_caste", this.language,
					allFirstPartyCapacityList);

			addressprooftypeList = new ArrayList<CommonOptionsVO>();
			addressprooftypeList = helper.extractFourData("party_addressproof",
					this.language, allFirstPartyCapacityList);

			anatherPartyList = new ArrayList<CommonOptionsVO>();
			anatherPartyList = helper.extractFourData("yes_no", this.language,
					allFirstPartyCapacityList);
			
			
			biometric_required_list= new ArrayList<CommonOptionsVO>();
			biometric_required_list = helper.extractFourData("yes_no", this.language,
					allFirstPartyCapacityList);
			
			//  AS PER SKM ON 20/08/2016 SUB-CAST WILL BE DEPENDENT ON CAST AND IN DATABASE 
		   //   THE ROW VALUE OF SUB-CASTE WILL BE STORED NOT THE GLOBAL VALUE
			
			subCasteList = new ArrayList<CommonOptionsVO>();
		//	loadSubCast();
			/*subCasteList = helper.extractSubCastData( this.language,
					subCastList);
			*/

			log.fatal("In the Party "+this.dummyPresenterName+","+this.dummyFirstPartyExecutantCapacity);
			partyDetailList=manager.getPartyDetailsWithName(token_no,sdf.parse(sdf.format(token_date)),Integer.parseInt(dsr_location));
			
			
			// END INITIALIZATION OF ARRAYLISTS AND VARIABLES
			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);

			deedTypeList = manager.searchDeedTypewithID(
					Integer.parseInt(language), Integer.parseInt(this.deedID));
			
			log.fatal("DEED ID For Party search:"+this.deedID);

			partyTypeList = manager.searchPartyTypewithDeedID(
					Integer.parseInt(language), Integer.parseInt(this.deedID));
			
		} catch (Exception e) {
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

	public String addPartyDetail() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;

		try {

			Date currentDateValue1 = new Date();
			partyDetailModel partyModel = new partyDetailModel();
			partyModel.setParty_type_id(Integer.parseInt(this.party_type_id));
			partyModel.setParty_name(this.party_name);
			partyModel.setParty_name_hindi(this.party_name_hindi==null?"":this.party_name_hindi.trim());
			partyModel.setParty_fh_rel(this.party_fh_rel);
			partyModel.setParty_fh_rel_name(this.party_fh_rel_name);
			partyModel.setProfession(this.profession);
			partyModel.setGender(this.gender);
			partyModel.setCaste(this.caste);
			partyModel.setPan_no(this.pan_no);
			partyModel.setAddress(this.address);
			partyModel.setPh_no(this.ph_no);
			partyModel.setAddress_proof(this.address_proof + "~"
					+ this.address_proof_value);
			partyModel.setCreated_by(Integer.parseInt(empID));
			partyModel.setCreated_date(currentDateValue1);
			partyModel.setUpdated_by(Integer.parseInt(empID));
			partyModel.setUpdated_date(currentDateValue1);
			partyModel.setDsr_location(Integer.parseInt(this.dsr_location));
			partyModel.setToken_no(this.token_no);
			partyModel.setToken_date(this.token_date);
			partyModel.setSub_cast(this.sub_cast);
			partyModel.setBiometric_required(this.biometric_required.equals("true") ? true
					: false);
			

			 insertOperationMessage = insertOperation.insertPartyDeatil(partyModel,this.token_no,this.token_date,this.dsr_location);

			if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("1")) {
				operationFlag = true;
				partyDetailList=manager.getPartyDetailsWithName(token_no,sdf.parse(sdf.format(token_date)),Integer.parseInt(dsr_location));
			}

			else if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("0")) {
				operationFlag = false;
				
			}

			returnMessage = insertOperationMessage.substring(1,
					insertOperationMessage.trim().length());

		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		if (operationFlag) {
			this.emptyField(this.anotherParty.equals("true") ? true : false);
			this.addActionMessage(returnMessage);
			return "success";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}

	}

	
	@SkipValidation
	public String exitPartyDetail() throws Exception {
		return "home";
	}

	public void validate() {
		try {

			String partyType=manager.searchSingleRowPartyType(Integer.parseInt(party_type_id));
			
			this.setEdit(false);
			this.execute();
			
			log.fatal(empID+","+branchCode+","+groupID+","+language+","+token_no+", "+token_date+", "+dsr_location);

			if ((empID == null) || (groupID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (groupID.trim().length() == 0)
					|| (language.trim().length() == 0) || (token_date == null)
					|| (dsr_location == null) || (dsr_location.trim().length() == 0)){
				this.addActionError(getText("session.invalied"));

			} else if (!validator.requiredFiledValidate(token_no.trim())) {
				this.addActionError("Token No can't be empty");

			} else if (!validator.requiredFiledValidate(anotherParty.trim())) {
				this.addFieldError("anotherParty", "Pl. select your choice");
			} else if (!validator.requiredFiledValidate(this.deed_type_id
					.trim())) {
				this.addFieldError("deed_type_id", "Deed Type can't be empty");

			} else if (!validator.requiredFiledValidate(this.party_type_id
					.trim())) {
				this.addFieldError("party_type_id", "Party Type can't be empty");
			} else if (!validator.requiredFiledValidate(this.party_name.trim())) {
				this.addFieldError("party_name", "Party Name can't be empty");
			} else if (!validator.languageValidate(this.party_name.trim(),
					this.language)) {
				this.addFieldError("party_name", "Pl. Input in Proper Language");

			} else if (!validator.validateNameField(this.party_name.trim(),
					this.language)) {
				this.addFieldError("party_name", "Party Name is not valid");

			} else if (!validator.requiredFiledValidate(party_fh_rel.trim())) {
				this.addFieldError("party_fh_rel", "Relation is Required");
			} else if (!validator.requiredFiledValidate(party_fh_rel_name
					.trim())) {
				this.addFieldError("party_fh_rel_name",
						"Father/Husband Name can't be empty");
			} else if (!validator.languageValidate(party_fh_rel_name.trim(),
					this.language)) {
				this.addFieldError("party_fh_rel_name",
						"Pl. Input in Proper Language");

			} else if (!validator.validateNameField(party_fh_rel_name.trim(),
					this.language)) {
				this.addFieldError("party_fh_rel_name",
						"Father/Husband Name is not valid");
				
			}else if (!validator.requiredFiledValidate(address.trim())) {
				this.addFieldError("address", "Address can't be empty");
			} else if (!validator.languageValidate(address.trim(),
					this.language)) {
				this.addFieldError("address",
						"Pl. Input in Proper Language");

			} /*else if (!validator.requiredFiledValidate(pan_no.trim())) {
				this.addFieldError("pan_no", "PAN/Form 60/61 can't be empty");
			}*/ else if((pan_no!=null)&&(pan_no.trim().length()>0)&& (!validator.languageValidate(pan_no.trim(),
					"1"))) {
				this.addFieldError("pan_no",
						"PAN/Form 60/61 Should be in English Language");
				
			}else if  ((pan_no!=null)&&(pan_no.trim().length()>0)&&(!validator.panFiledValidate(pan_no.trim()))) {
				this.addFieldError("pan_no","PAN/Form 60/61 is not valid");
			
			}
			
			 else if (!validator.requiredFiledValidate(ph_no.trim())) {
					this.addFieldError("ph_no", "Phone No. can't be empty");
				}
			
			 else if (!validator.languageValidate(ph_no.trim(),
						"1")) {
					this.addFieldError("ph_no",
							"Phone No. Should be in English Language");
				}
			 else if (!validator.neumericFiledValidate(ph_no.trim())) {
					this.addFieldError("ph_no","Phone No. is not Valid");
				}
			 else if (!validator.requiredFiledValidate(this.profession
						.trim())) {
					this.addFieldError("profession", "Profession can't be empty");
				}
			 else if (!validator.requiredFiledValidate(this.gender
						.trim())) {
					this.addFieldError("gender", "Gender can't be empty");
				}
			
			 else if (!validator.requiredFiledValidate(this.caste
						.trim())) {
					this.addFieldError("caste", "Caste can't be empty");
				}
			 else if (!validator.requiredFiledValidate(this.address_proof
						.trim())) {
					this.addFieldError("address_proof", "Address Proof can't be empty");
				}
			
			 else if (!validator.requiredFiledValidate(this.address_proof_value
						.trim())) {
					this.addFieldError("address_proof_value", "Address Proof Value can't be empty");
				}
			 else if (!validator.languageValidate(address_proof_value.trim(),
						"1")) {
					this.addFieldError("address_proof_value",
							"Address Proof value Should be in English Language");
				}
			
			 else if((this.language.equalsIgnoreCase("1"))&&(!validator.requiredFiledValidate(this.party_name_hindi.trim())))
					 {
				 this.addFieldError("party_name_hindi",
							"In case of English Hindi Party Name is required");
				 	 }
			
			 else if ((this.language.equalsIgnoreCase("1"))&&(!validator.validateNameField(this.party_name_hindi.trim(),"2"))) {
					this.addFieldError("party_name_hindi", "Party Name is not valid");

				}
			 else if ((this.language.equalsIgnoreCase("1"))&&(!validator.languageValidate(this.party_name_hindi.trim(),"2"))) {
					this.addFieldError("party_name_hindi", "Pl. Input in Proper Language");

				}

				else if(((partyType.equalsIgnoreCase("global_party_type_claimant")) || (partyType.equalsIgnoreCase("global_party_type_nispadk")))
					&&(!validator.requiredFiledValidate(this.ph_no.trim()))){
								this.addFieldError("ph_no", "Phone No. is required");
				}
			
			
			
			
		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));
			
		}
	}
	
	
	
	
	@SkipValidation
	public String loadValue() throws Exception {
		try {
			List<CommonFourOptionsVO> subCastList = new ArrayList<CommonFourOptionsVO>();
			subCastList = (List) context
					.getAttribute("SUBCASTLOV");	
			
			subCasteList = new ArrayList<CommonOptionsVO>();
			
			if ((this.castValue != null) && (this.castValue.length() > 0)
					&& (this.language != null) && (this.language.length() > 0)) {
				subCasteList = helper.extractSubCastData( this.language,
						subCastList,castValue);
			}
			
			log.fatal(subCasteList.size());
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		return SUCCESS;
	}

	
	

	@SkipValidation
	public void emptyField(boolean choice) throws Exception {
		try {
			
			
			
			
			if (!choice) {
				
				this.setDummyNavigationFlag(true);
				this.setDummyDistrictID(String.valueOf(this.districtID));
				this.setDummyDsrLocation(this.dsr_location);
				this.setDummyTokenNo(this.token_no);
				this.setDummyTokenDate(this.token_date);
				this.setDummyDeedID(this.deedID);
	            this.setDummyFirstPartyName(this.party_name);
	            this.setDummyPresenterName(this.dummyPresenterName);
	            this.setDummyFirstPartyExecutantCapacity(this.dummyFirstPartyExecutantCapacity);
	            this.setDummyDeedCategoryId(this.dummyDeedCategoryId);
	            this.setDummyConsideredAmount(this.dummyConsideredAmount);
				this.setDummyERegistrationId(this.dummyERegistrationId);
	            this.setDummyStampNoWithVal(this.dummyStampNoWithVal);
	            this.setDummyOriginalDeedTotalPageNo(this.dummyOriginalDeedTotalPageNo);
	            this.setDummyCallNature(this.dummyCallNature);
	            this.setDummyTotalStampValue(this.dummyTotalStampValue);
				this.setPrintFlag(true);
				}
			
			
			
			
			this.setAnotherParty("");
			this.setParty_type_id("");
			this.setParty_name("");
			this.setParty_fh_rel("");
			this.setParty_fh_rel_name("");
			this.setAddress("");
			this.setPan_no("");
			this.setPh_no("");
			this.setProfession("");
			this.setGender("");
			this.setCaste("");
			this.setAddress_proof("");
			this.setParty_name_hindi("");
			this.setAddress_proof_value("");
			this.setSub_cast("");
			
			if (!choice) {
				
			
				
				this.setToken_no("");
				this.setToken_date(null);
				this.setDsr_location("");
			}

		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
			
		}

	}

}
