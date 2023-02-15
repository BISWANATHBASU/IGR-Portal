package com.igr.registration;

import java.math.BigDecimal;
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

public class StructureDetailEditAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	
	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String locationName = "";
	private String districtName = "";
	private String language = "";
	
	
	private boolean edit;
	private String use_construction;
	private String type_construction;
	private String area_type;
	private String dsr_location;
	private String token_no;
	private Date token_date;
	private String structure_name;
	private String structure_no;
	private String floor;
	private int created_by;
	private Date created_date;
	private int updated_by;
	private Date updated_date;
	private String area_volume;
	private String valuation;
	private int district_id;
	private String structureID;
	private int deed_type_id;
	private int deed_category_id;
	private float considered_amount;
	private String ageOfStructure;
	private String structure;
	private String structure_unit;

    private String structure_owner;
	private ServletContext context;
	private HttpServletRequest request;
	
	private List<CommonOptionsVO> areaTypeList;
	private List<CommonOptionsVO> constractionTypeList;
	private List<CommonOptionsVO> usesTypeList;
    private List<CommonOptionsVO> structureList;
    private List<CommonOptionsVO> structureUnitList;
	
	
	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();
	private static final Logger log = Logger
			.getLogger(StructureDetailEditAction.class);
	private static InsertOperation insertOperation = new InsertOperation();

	
	public boolean isEdit() {
		return edit;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	

	public String getStructure_unit() {
		return structure_unit;
	}

	public void setStructure_unit(String structure_unit) {
		this.structure_unit = structure_unit;
	}

	public List<CommonOptionsVO> getStructureUnitList() {
		return structureUnitList;
	}

	public void setStructureUnitList(List<CommonOptionsVO> structureUnitList) {
		this.structureUnitList = structureUnitList;
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

	public float getConsidered_amount() {
		return considered_amount;
	}

	public void setConsidered_amount(float considered_amount) {
		this.considered_amount = considered_amount;
	}

	public String getStructureID() {
		return structureID;
	}
	
	public String getStructure_owner() {
		return structure_owner;
	}

	public void setStructure_owner(String structure_owner) {
		this.structure_owner = structure_owner;
	}

	public void setStructureID(String structureID) {
		this.structureID = structureID;
	}

	public String getUse_construction() {
		return use_construction;
	}

	public void setUse_construction(String use_construction) {
		this.use_construction = use_construction;
	}

	
	public String getType_construction() {
		return type_construction;
	}

	public void setType_construction(String type_construction) {
		this.type_construction = type_construction;
	}

	public String getArea_type() {
		return area_type;
	}

	public void setArea_type(String area_type) {
		this.area_type = area_type;
	}

	public String getDsr_location() {
		return dsr_location;
	}

	public void setDsr_location(String dsr_location) {
		this.dsr_location = dsr_location;
	}

	public String getToken_no() {
		return token_no;
	}

	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}

	public String getArea_volume() {
		return area_volume;
	}

	public void setArea_volume(String area_volume) {
		this.area_volume = area_volume;
	}

	public String getValuation() {
		return valuation;
	}
	
	

	public String getAgeOfStructure() {
		return ageOfStructure;
	}

	public void setAgeOfStructure(String ageOfStructure) {
		this.ageOfStructure = ageOfStructure;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public List<CommonOptionsVO> getStructureList() {
		return structureList;
	}

	public void setStructureList(List<CommonOptionsVO> structureList) {
		this.structureList = structureList;
	}

	public void setValuation(String valuation) {
		this.valuation = valuation;
	}

	public Date getToken_date() {
		return token_date;
	}

	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}

	public String getStructure_name() {
		return structure_name;
	}

	public void setStructure_name(String structure_name) {
		this.structure_name = structure_name;
	}

	public String getStructure_no() {
		return structure_no;
	}

	public void setStructure_no(String structure_no) {
		this.structure_no = structure_no;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
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

	public List<CommonOptionsVO> getAreaTypeList() {
		return areaTypeList;
	}

	public void setAreaTypeList(List<CommonOptionsVO> areaTypeList) {
		this.areaTypeList = areaTypeList;
	}

	public List<CommonOptionsVO> getConstractionTypeList() {
		return constractionTypeList;
	}

	public void setConstractionTypeList(
			List<CommonOptionsVO> constractionTypeList) {
		this.constractionTypeList = constractionTypeList;
	}

	public List<CommonOptionsVO> getUsesTypeList() {
		return usesTypeList;
	}

	public void setUsesTypeList(List<CommonOptionsVO> usesTypeList) {
		this.usesTypeList = usesTypeList;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;

	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;

	}

	@SkipValidation
	public String execute() throws Exception {
		String returnValue = SUCCESS;

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = "2";//(String) request.getSession().getAttribute("_LANGUAGE");
		locationName = (String) request.getSession().getAttribute(
				"LOCATIONNAME");
		
		int returnMessage = 1;

		try{

		List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
		allFirstPartyCapacityList = (List) context
				.getAttribute("GLOBALDROPDOWNLOV");

		areaTypeList = new ArrayList<CommonOptionsVO>();
		areaTypeList = helper.extractFourData("area_type_structure",
				this.language, allFirstPartyCapacityList);

		constractionTypeList = new ArrayList<CommonOptionsVO>();
		constractionTypeList = helper.extractFourData("type_construction",
				this.language, allFirstPartyCapacityList);

		usesTypeList = new ArrayList<CommonOptionsVO>();
		usesTypeList = helper.extractFourData("use_construction",
				this.language, allFirstPartyCapacityList);

		structureList= new ArrayList<CommonOptionsVO>();
		structureList = helper.extractFourData("global_structure", this.language,
				allFirstPartyCapacityList);
		
		structureUnitList=new ArrayList<CommonOptionsVO>();
		structureUnitList = helper.extractFourData("global_structure_unit", this.language,
				allFirstPartyCapacityList);
		
		
	
		
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

	public String editStructureDetail() throws Exception {
		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;

		try {
			

				log.fatal(deed_type_id +" "+deed_category_id+" "+considered_amount);
			
			String deedValuationAmount = helper.calculateDeedDetailValue(
					deed_type_id, deed_category_id, language, token_no,
					token_date, dsr_location, considered_amount);

			String valuationValue[] = deedValuationAmount.split("~");

			/*if ((Float.parseFloat(valuationValue[0]) > 0)
					|| (Float.parseFloat(valuationValue[1]) > 0)) {
					
						AS per Guidence bu SKM an AR 19/08/2016 the Condition is commented
					
*/
				insertOperationMessage = insertOperation.updateStructureDeatil(
						use_construction, type_construction, area_type,
						structure_name, structure_no, floor,
						area_volume, valuation, token_no, dsr_location,
						token_date, empID, structureID, valuationValue[0],
						valuationValue[1],valuationValue[2],valuationValue[3],valuationValue[4],ageOfStructure,structure,structure_unit,structure_owner);

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

			if ((empID == null) || (branchCode == null) || (groupID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (branchCode.trim().length() == 0)
					|| (groupID.trim().length() == 0)
					|| (language.trim().length() == 0) || (token_date == null)
					|| (dsr_location == null)
					|| (dsr_location.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));

			} else if (!validator.requiredFiledValidate(token_no.trim())) {
				this.addFieldError("token_no", "Token No can't be empty");

			} else if (!validator.requiredFiledValidate(area_type.trim())) {
				this.addFieldError("area_type", "Area Type can't be empty");
			}

			else if (!validator.requiredFiledValidate(type_construction.trim())) {
				this.addFieldError("type_construction",
						"Construction Type Name can't be empty");
			}

			else if (!validator.requiredFiledValidate(use_construction.trim())) {
				this.addFieldError("use_construction", "Uses can't be empty");
			}

			else if (!validator.requiredFiledValidate(structure_name.trim())) {
				this.addFieldError("structure_name",
						"Structure_Name can't be empty");
			}
			
			else if (!validator.requiredFiledValidate(structure_unit.trim())) {
				this.addFieldError("structure_unit", "Structure Unit can't be empty");
			}


			else if (!validator.languageValidate(structure_name.trim(),
					this.language)) {
				this.addFieldError("structure_name",
						"Structure_Name in proper Language");
			}

			else if (!validator.requiredFiledValidate(structure_no.trim())) {
				this.addFieldError("structure_no",
						"Structure No. can't be empty");
			}

			else if (!validator.languageValidate(structure_no.trim(),
					"1")) {
				this.addFieldError("structure_no",
						"Structure No. in proper Language");
			}

			else if (!validator.requiredFiledValidate(floor.trim())) {
				this.addFieldError("floor", "Floor can't be empty");
			}

			else if (!validator.languageValidate(floor.trim(), "1")) {
				this.addFieldError("floor", "Floor in English Language");
			}
			else if (!validator.neumericFiledValidate(floor.trim())) {
				this.addFieldError("floor",
						"Floor is not a Neumeric Value");
			}

			else if (!validator.requiredFiledValidate(area_volume.trim())) {
				this.addFieldError("area_volume", "Area Volume can't be empty");
			} else if (!validator.languageValidate(area_volume.trim(), "1")) {
				this.addFieldError("area_volume",
						"Area Volume in English Language");
			}

			else if (!validator.neumericFiledValidate(area_volume.trim())) {
				this.addFieldError("area_volume",
						"Area Volume is not a Neumeric Value");
			}
			
			
			else if (!validator.requiredFiledValidate(structure.trim())) {
				this.addFieldError("structure", "Structure can't be empty");
			}
			
			
			
			else if (!validator.requiredFiledValidate(structure_owner.trim())) {
				this.addFieldError("structure_owner",
						"Structure Owner can't be empty");
			}

		/*	else if (!validator.languageValidate(structure_owner.trim(),
					this.language)) {
				this.addFieldError("structure_owner",
						"Structure Owner in proper Language");
			}
			*/
			
			else if (!validator.requiredFiledValidate(ageOfStructure.trim())) {
				this.addFieldError("ageOfStructure", "Structure age can't be empty");
			} else if (!validator.languageValidate(ageOfStructure.trim(), "1")) {
				this.addFieldError("ageOfStructure",
						"Structure Age in English Language");
			}

			else if (!validator.neumericFiledValidate(ageOfStructure.trim())) {
				this.addFieldError("ageOfStructure",
						"Structure Age is not a Neumeric Value");
			}
			

			else if (!validator.requiredFiledValidate(valuation.trim())) {
				this.addFieldError("valuation", "valuation Amount can't be empty");
			} else if (!validator.neumericFiledValidate(valuation.trim())) {
				this.addFieldError("valuation", "Valuation Amount is not Valid");
			}

			else if (!validator.neumericFiledValidate(structureID.trim())) {
				this.addActionError("Master ID not Found");
			}
			

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));

		}
	}

	@SkipValidation
	public void emptyField() throws Exception {
		try {
			
			Date currentDateValue = new Date();
			
			
			this.setUse_construction("");
			this.setType_construction("");
			this.setArea_type("");
			this.setStructure_name("");
			this.setStructure_no("");
			this.setFloor("");
			this.setArea_volume("");
			this.setValuation("");
			this.setToken_no("");
			this.setToken_date(null);
			this.setDsr_location("");
		    this.setStructureID(""); 
		    this.setAgeOfStructure("");
		    this.setStructure("");
		    this.setStructure_unit("");
		    this.setStructure_owner("");
			
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
	}

	@SkipValidation
	public String exitStructureDetailEdit() throws Exception {
		return "home";
	}

	@SkipValidation
	public String structureValuationEdit() throws Exception {

		try{
		if ((area_type != null) && (area_type.length() > 0)
				&& (type_construction != null)
				&& (type_construction.length() > 0)
				&& (use_construction != null)
				&& (use_construction.length() > 0) && (area_volume != null)
				&& (area_volume.length() > 0)&& (structure_unit != null)
				&& (structure_unit.length() > 0)) {
			String valuationAmount = manager.getStructureValuation(
					Float.parseFloat(area_volume.trim()), area_type,
					type_construction, use_construction,structure_unit);
			this.valuation =  String.valueOf(new BigDecimal(valuationAmount).setScale(0, BigDecimal.ROUND_HALF_UP));
		}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		return SUCCESS;

	}

}
