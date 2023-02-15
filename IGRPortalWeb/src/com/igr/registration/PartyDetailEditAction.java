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
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PartyDetailEditAction extends ActionSupport implements
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
	private String party_name_hindi;
	private String address_proof_value;
	private String dsr_location;
	private String token_no;
	private Date token_date;
	private String partyID;
	private String addressProofArray;
	private String deed_type_id;
	private String deed_category_id;
	private float considered_amount;
	private String sub_cast;
	private String biometric_required;
	
	
	private ServletContext context;
	private HttpServletRequest request;
	
	
	private List<CommonOptionsVO> partyTypeList;
	private List<CommonOptionsVO> deedTypeList;
	private List<CommonOptionsVO> relationList;
	private List<CommonOptionsVO> professionList;
	private List<CommonOptionsVO> sexList;
	private List<CommonOptionsVO> casteList;
	private List<CommonOptionsVO> addressprooftypeList;
	private List<CommonOptionsVO> subCasteList;
	private List<CommonOptionsVO> biometric_required_list;

	

	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	

	private static final Logger log = Logger
			.getLogger(PartyDetailEditAction.class);
	private static InsertOperation insertOperation = new InsertOperation();
	
	
	
	

	public String getDeed_category_id() {
		return deed_category_id;
	}

	public void setDeed_category_id(String deed_category_id) {
		this.deed_category_id = deed_category_id;
	}

	public String getParty_name_hindi() {
		return party_name_hindi;
	}

	public void setParty_name_hindi(String party_name_hindi) {
		this.party_name_hindi = party_name_hindi;
	}

	public float getConsidered_amount() {
		return considered_amount;
	}

	public void setConsidered_amount(float considered_amount) {
		this.considered_amount = considered_amount;
	}

	public String getAddressProofArray() {
		return addressProofArray;
	}

	public void setAddressProofArray(String addressProofArray) {
		this.addressProofArray = addressProofArray;
	}

	public String getPartyID() {
		return partyID;
	}

	public void setPartyID(String partyID) {
		this.partyID = partyID;
	}

	public String getAddress_proof_value() {
		return address_proof_value;
	}

	public void setAddress_proof_value(String address_proof_value) {
		this.address_proof_value = address_proof_value;
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

	

	public String getSub_cast() {
		return sub_cast;
	}

	public void setSub_cast(String sub_cast) {
		this.sub_cast = sub_cast;
	}



	public List<CommonOptionsVO> getSubCasteList() {
		return subCasteList;
	}

	public void setSubCasteList(List<CommonOptionsVO> subCasteList) {
		this.subCasteList = subCasteList;
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
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		locationName = (String) request.getSession().getAttribute(
				"LOCATIONNAME");
		districtID = (String) request.getSession()
				.getAttribute("DISTRICT_CODE");
		districtName = (String) request.getSession().getAttribute(
				"DISTRICT_NAME");
				int returnMessage = 1;
		String returnValue = SUCCESS;

		
		
		try {
		List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
		allFirstPartyCapacityList = (List) context
				.getAttribute("GLOBALDROPDOWNLOV");

		List<CommonOptionsVO> subCastList = new ArrayList<CommonOptionsVO>();
		subCastList = (List) context
				.getAttribute("SUBCASTLOV");	
		

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
			
			biometric_required_list= new ArrayList<CommonOptionsVO>();
			biometric_required_list = helper.extractFourData("yes_no", this.language,
					allFirstPartyCapacityList);
			
			subCasteList = new ArrayList<CommonOptionsVO>();
			loadSubCast();
			/*subCasteList = helper.extractSubCastData( this.language,
					subCastList);
			*/

		

		
			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);

			String address_proof_array[] = this.addressProofArray.split("~");

			if((this.address_proof==null)&&(this.address_proof_value==null)){
			this.address_proof = address_proof_array[0];
			this.address_proof_value = address_proof_array[1];
			}

			deedTypeList = manager.searchDeedTypewithID(
					Integer.parseInt(language),
					Integer.parseInt(this.deed_type_id));

			partyTypeList = manager.searchPartyTypewithDeedID(
					Integer.parseInt(language),
					Integer.parseInt(this.deed_type_id));
			
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

	public String editPartyDetail() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;

		try {

			String deedValuationAmount = helper.calculateDeedDetailValue(
					Integer.parseInt(deed_type_id),
					Integer.parseInt(deed_category_id), language, token_no,
					token_date, dsr_location, considered_amount);
			
			log.fatal("deedValuationAmount " +deedValuationAmount);

			String valuationValue[] = deedValuationAmount.split("~");

		/*	if ((Float.parseFloat(valuationValue[0]) > 0)
					|| (Float.parseFloat(valuationValue[1]) > 0)) {
					
					AS per Guidence bu SKM an AR 19/08/2016 the Condition is commented
*/
				insertOperationMessage = insertOperation.updatePartyDeatil(
						party_type_id, party_name, party_fh_rel,
						party_fh_rel_name, profession, gender, caste, pan_no,
						address, ph_no, address_proof, address_proof_value,
						token_no, dsr_location, token_date, empID, partyID,
						valuationValue[0], valuationValue[1],
						this.party_name_hindi == null ? ""
								: this.party_name_hindi.trim(),valuationValue[2],valuationValue[3],valuationValue[4],
								this.sub_cast,biometric_required);

				if (insertOperationMessage.trim().substring(0, 1)
						.equalsIgnoreCase("1")) {
					operationFlag = true;
				}

				else if (insertOperationMessage.trim().substring(0, 1)
						.equalsIgnoreCase("0")) {
					operationFlag = false;
				}

				returnMessage = insertOperationMessage.substring(1,
						insertOperationMessage.trim().length());
			/*} else
				returnMessage = "Structure Valuation Can't be Zero";
*/
			if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("1")) {
				operationFlag = true;
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
			this.emptyField();
			this.addActionMessage(returnMessage);
			return "success";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}

	}

	
	@SkipValidation
	public String loadSubCast() throws Exception {
		try {
			List<CommonFourOptionsVO> subCastList = new ArrayList<CommonFourOptionsVO>();
			subCastList = (List) context
					.getAttribute("SUBCASTLOV");	
			
			subCasteList = new ArrayList<CommonOptionsVO>();
			if ((this.caste != null) && (this.caste.length() > 0)
					&& (this.language != null) && (this.language.length() > 0)) {
				subCasteList = helper.extractSubCastData( this.language,
						subCastList,caste);
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		return SUCCESS;
	}

	
	
	
	
	@SkipValidation
	public String exitPartyDetailEdit() throws Exception {
		return "home";
	}

	public void validate() {
		try {

			this.setEdit(false);
			this.execute();

			if ((empID == null) || (branchCode == null) || (groupID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (branchCode.trim().length() == 0)
					|| (groupID.trim().length() == 0)
					|| (language.trim().length() == 0) || (token_date == null)
					|| (dsr_location == null)
					|| (dsr_location.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));

			} else if (!validator.requiredFiledValidate(token_no.trim())) {
				this.addActionError("Token No can't be empty");

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

			} else if (!validator.requiredFiledValidate(address.trim())) {
				this.addFieldError("address", "Address can't be empty");
			} else if (!validator.languageValidate(address.trim(),
					this.language)) {
				this.addFieldError("address", "Pl. Input in Proper Language");

			} 
			
			 /*else if (!validator.requiredFiledValidate(pan_no.trim())) {
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

			else if (!validator.languageValidate(ph_no.trim(), "1")) {
				this.addFieldError("ph_no",
						"Phone No. Should be in English Language");
			} else if (!validator.neumericFiledValidate(ph_no.trim())) {
				this.addFieldError("ph_no", "Phone No. is not Valid");
			} else if (!validator.requiredFiledValidate(this.profession.trim())) {
				this.addFieldError("profession", "Profession can't be empty");
			} else if (!validator.requiredFiledValidate(this.gender.trim())) {
				this.addFieldError("gender", "Gender can't be empty");
			}

			else if (!validator.requiredFiledValidate(this.caste.trim())) {
				this.addFieldError("caste", "Caste can't be empty");
			} else if (!validator.requiredFiledValidate(this.address_proof
					.trim())) {
				this.addFieldError("address_proof",
						"Address Proof can't be empty");
			}

			else if (!validator.requiredFiledValidate(this.address_proof_value
					.trim())) {
				this.addFieldError("address_proof_value",
						"Address Proof Value can't be empty");
			} else if (!validator.languageValidate(address_proof_value.trim(),
					"1")) {
				this.addFieldError("address_proof_value",
						"Address Proof value Should be in English Language");
			}

			else if (!validator.requiredFiledValidate(this.partyID.trim())) {
				this.addActionError("Master Key Not Found, Pl. try Again");
			}

			else if ((this.language.equalsIgnoreCase("1"))
					&& (!validator.requiredFiledValidate(this.party_name_hindi
							.trim()))) {
				this.addFieldError("party_name_hindi",
						"In case of English Hindi Party Name is required");
			}

			else if ((this.language.equalsIgnoreCase("1"))
					&& (!validator.validateNameField(
							this.party_name_hindi.trim(), "2"))) {
				this.addFieldError("party_name_hindi",
						"Party Name is not valid");

			} else if ((this.language.equalsIgnoreCase("1"))
					&& (!validator.languageValidate(
							this.party_name_hindi.trim(), "2"))) {
				this.addFieldError("party_name_hindi",
						"Pl. Input in Proper Language");

			}
		
			

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));

		}
	}

	@SkipValidation
	public void emptyField() throws Exception {
		try {
			
			
			
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
			this.setToken_no("");
			this.setToken_date(null);
			this.setDsr_location("");
			this.setPartyID("");
			this.setSub_cast("");
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));

		}

	}

}
