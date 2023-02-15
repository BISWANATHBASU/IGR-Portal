package com.igr.enquiry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
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
import com.igr.commonUtility.CommonFiveOptionsVO;

import java.math.BigDecimal;

public class PropertyDetailEnquiryAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware,SessionAware {

	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String locationName = "";
	private String language ;

	private String area_master_id;
	private String area_type;
	private String area_type_name;
	private String ward_hal_no;
	private String ward_vill_name;
	private String locality_name;
	private String mohalla_vill_name;
	private String khata_no;
	private String plot_no;
	private String area_volume;
	private String min_val;
	private String propert_type;
	private String tahaseel;
	private String revenue_district;
	private String token_no;
	private String dsr_location;
	private Date token_date;
	private int created_by;
	private Date created_date;
	private int updated_by;
	private Date updated_date;
	private boolean edit;
	private String district_id;
	private String page_id;
	
	private String methodName;
	private String anotherProperty;
	private String khasra_no;
	private String loan_book_no;
	private String north_boundary;
	private String east_boundary;
	private String south_boundary;
	private String west_boundary;
	private String configuration_land;
	private String purpose_land;
	private String area_unit;
	private String rent;
	private boolean printFlag;
	private String dummyTokenNo;
	private String dummyDistrictID;
	private String dummyDsrLocation;
	private boolean dummyNavigationFlag;
	private Date dummyTokenDate;
	private String dummyDeedID;
	private String dummyFirstPartyName;
    private String four_value;
	private String no_of_tubewell;
	private String no_of_well;
	private String stamp_value;
	private String addl_stamp_value;
	private String cess_value;
	
	private String dummyPresenterName;
	private String dummyFirstPartyExecutantCapacity;
	private String dummyDeedCategoryId;
	private String dummyConsideredAmount;
	private String dummyERegistrationId;
	private String dummyStampNoWithVal;
	private String dummyOriginalDeedTotalPageNo;
	private String dummyTotalStampValue;
	
	private boolean dummyCallNature;
	
	private ServletContext context;
	private HttpServletRequest request;

	private List<CommonOptionsVO> areaTypeList;
	private List<CommonOptionsVO> areaTypeNameList;
	private List<CommonOptionsVO> tahaseelList;
	private List<CommonOptionsVO> revenueDistrictList;
	private List<CommonOptionsVO> wardHallNoList;
	private List<CommonOptionsVO> wardVillNameList;
	private List<CommonOptionsVO> localityNameList;
	private List<CommonOptionsVO> mohallaVillList;
	private List<CommonOptionsVO> propertyTypeList;
	private List<CommonOptionsVO> globalList;
	private List<CommonOptionsVO> anatherPropertyList;
	private List<CommonOptionsVO> districtList;
	private List optionVOList;
	private List<CommonOptionsVO> configurationLandList;
	private List<CommonOptionsVO> purposeLandList;
	private List<CommonOptionsVO> areaUnitList;
	private List<CommonFiveOptionsVO> savedPropertyList;
	private List<CommonOptionsVO> dsrLocationList;
	
	private SessionMap<String,Object> sessionMap;

	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();

	/*private static final Logger log = Logger
			.getLogger(PropertyDetailEnquiryAction.class);*/
	private static Logger log = Logger.getLogger(PropertyDetailEnquiryAction.class);
	private static InsertOperation insertOperation = new InsertOperation();

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}


	public List getOptionVOList() {
		return optionVOList;
	}
	

	public List<CommonOptionsVO> getDsrLocationList() {
		return dsrLocationList;
	}

	public void setDsrLocationList(List<CommonOptionsVO> dsrLocationList) {
		this.dsrLocationList = dsrLocationList;
	}

	public String getDistrict_id() {
		return district_id;
	}
	
	
	

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setDistrict_id(String district_id) {
		this.district_id = district_id;
	}

	public void setOptionVOList(List optionVOList) {
		this.optionVOList = optionVOList;
	}

	public boolean isPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(boolean printFlag) {
		this.printFlag = printFlag;
	}

	public String getDummyTokenNo() {
		return dummyTokenNo;
	}

	public String getDummyDeedID() {
		return dummyDeedID;
	}
	
	

	public String getStamp_value() {
		return stamp_value;
	}

	public void setStamp_value(String stamp_value) {
		this.stamp_value = stamp_value;
	}

	public String getAddl_stamp_value() {
		return addl_stamp_value;
	}

	public void setAddl_stamp_value(String addl_stamp_value) {
		this.addl_stamp_value = addl_stamp_value;
	}

	public String getCess_value() {
		return cess_value;
	}

	public void setCess_value(String cess_value) {
		this.cess_value = cess_value;
	}

	public String getNo_of_tubewell() {
		return no_of_tubewell;
	}

	public void setNo_of_tubewell(String no_of_tubewell) {
		this.no_of_tubewell = no_of_tubewell;
	}

	public String getNo_of_well() {
		return no_of_well;
	}

	public void setNo_of_well(String no_of_well) {
		this.no_of_well = no_of_well;
	}

	public String getFour_value() {
		return four_value;
	}

	public void setFour_value(String four_value) {
		this.four_value = four_value;
	}

	public boolean isDummyCallNature() {
		return dummyCallNature;
	}

	public void setDummyCallNature(boolean dummyCallNature) {
		this.dummyCallNature = dummyCallNature;
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

	public void setDummyDeedID(String dummyDeedID) {
		this.dummyDeedID = dummyDeedID;
	}

	public String getDummyFirstPartyName() {
		return dummyFirstPartyName;
	}

	public void setDummyFirstPartyName(String dummyFirstPartyName) {
		this.dummyFirstPartyName = dummyFirstPartyName;
	}

	public void setDummyTokenNo(String dummyTokenNo) {
		this.dummyTokenNo = dummyTokenNo;
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

	public boolean isDummyNavigationFlag() {
		return dummyNavigationFlag;
	}

	public void setDummyNavigationFlag(boolean dummyNavigationFlag) {
		this.dummyNavigationFlag = dummyNavigationFlag;
	}

	public Date getDummyTokenDate() {
		return dummyTokenDate;
	}

	public void setDummyTokenDate(Date dummyTokenDate) {
		this.dummyTokenDate = dummyTokenDate;
	}

	public List<CommonOptionsVO> getAnatherPropertyList() {
		return anatherPropertyList;
	}

	
	
	
	public String getDummyTotalStampValue() {
		return dummyTotalStampValue;
	}

	public void setDummyTotalStampValue(String dummyTotalStampValue) {
		this.dummyTotalStampValue = dummyTotalStampValue;
	}

	public void setAnatherPropertyList(List<CommonOptionsVO> anatherPropertyList) {
		this.anatherPropertyList = anatherPropertyList;
	}

	public String getArea_master_id() {
		return area_master_id;
	}

	public void setArea_master_id(String area_master_id) {
		this.area_master_id = area_master_id;
	}
	
	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getArea_type() {
		return area_type;
	}

	public String getAnotherProperty() {
		return anotherProperty;
	}

	public void setAnotherProperty(String anotherProperty) {
		this.anotherProperty = anotherProperty;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	
	
	

	public String getTahaseel() {
		return tahaseel;
	}

	public void setTahaseel(String tahaseel) {
		this.tahaseel = tahaseel;
	}

	public String getRevenue_district() {
		return revenue_district;
	}

	public void setRevenue_district(String revenue_district) {
		this.revenue_district = revenue_district;
	}

	
	public void setArea_type(String area_type) {
		this.area_type = area_type;
	}

	public String getArea_type_name() {
		return area_type_name;
	}

	public void setArea_type_name(String area_type_name) {
		this.area_type_name = area_type_name;
	}

	public String getWard_hal_no() {
		return ward_hal_no;
	}

	public void setWard_hal_no(String ward_hal_no) {
		this.ward_hal_no = ward_hal_no;
	}

	public String getWard_vill_name() {
		return ward_vill_name;
	}

	public void setWard_vill_name(String ward_vill_name) {
		this.ward_vill_name = ward_vill_name;
	}

	public String getLocality_name() {
		return locality_name;
	}

	public void setLocality_name(String locality_name) {
		this.locality_name = locality_name;
	}

	public String getMohalla_vill_name() {
		return mohalla_vill_name;
	}

	public void setMohalla_vill_name(String mohalla_vill_name) {
		this.mohalla_vill_name = mohalla_vill_name;
	}

	public String getKhata_no() {
		return khata_no;
	}

	public void setKhata_no(String khata_no) {
		this.khata_no = khata_no;
	}

	public String getPlot_no() {
		return plot_no;
	}

	public void setPlot_no(String plot_no) {
		this.plot_no = plot_no;
	}

	public String getArea_volume() {
		return area_volume;
	}

	public void setArea_volume(String area_volume) {
		this.area_volume = area_volume;
	}

	public String getMin_val() {
		return min_val;
	}

	public void setMin_val(String min_val) {
		this.min_val = min_val;
	}

	public String getPropert_type() {
		return propert_type;
	}

	public void setPropert_type(String propert_type) {
		this.propert_type = propert_type;
	}
	
	public String getArea_unit() {
		return area_unit;
	}

	public void setArea_unit(String area_unit) {
		this.area_unit = area_unit;
	}

	public List<CommonOptionsVO> getAreaUnitList() {
		return areaUnitList;
	}

	public void setAreaUnitList(List<CommonOptionsVO> areaUnitList) {
		this.areaUnitList = areaUnitList;
	}

	public String getToken_no() {
		return token_no;
	}

	public void setToken_no(String token_no) {
		this.token_no = token_no;
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

	public String getKhasra_no() {
		return khasra_no;
	}

	public void setKhasra_no(String khasra_no) {
		this.khasra_no = khasra_no;
	}

	public String getLoan_book_no() {
		return loan_book_no;
	}

	public void setLoan_book_no(String loan_book_no) {
		this.loan_book_no = loan_book_no;
	}

	public String getNorth_boundary() {
		return north_boundary;
	}

	public void setNorth_boundary(String north_boundary) {
		this.north_boundary = north_boundary;
	}

	public String getEast_boundary() {
		return east_boundary;
	}

	public void setEast_boundary(String east_boundary) {
		this.east_boundary = east_boundary;
	}

	public String getSouth_boundary() {
		return south_boundary;
	}

	public void setSouth_boundary(String south_boundary) {
		this.south_boundary = south_boundary;
	}

	public String getWest_boundary() {
		return west_boundary;
	}

	public void setWest_boundary(String west_boundary) {
		this.west_boundary = west_boundary;
	}
	
	public String getConfiguration_land() {
		return configuration_land;
	}

	public void setConfiguration_land(String configuration_land) {
		this.configuration_land = configuration_land;
	}

	public String getPurpose_land() {
		return purpose_land;
	}

	public void setPurpose_land(String purpose_land) {
		this.purpose_land = purpose_land;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}

	public List<CommonOptionsVO> getAreaTypeNameList() {
		return areaTypeNameList;
	}

	public void setAreaTypeNameList(List<CommonOptionsVO> areaTypeNameList) {
		this.areaTypeNameList = areaTypeNameList;
	}

	public List<CommonOptionsVO> getWardHallNoList() {
		return wardHallNoList;
	}

	public void setWardHallNoList(List<CommonOptionsVO> wardHallNoList) {
		this.wardHallNoList = wardHallNoList;
	}

	public List<CommonOptionsVO> getWardVillNameList() {
		return wardVillNameList;
	}

	public void setWardVillNameList(List<CommonOptionsVO> wardVillNameList) {
		this.wardVillNameList = wardVillNameList;
	}

	public List<CommonOptionsVO> getLocalityNameList() {
		return localityNameList;
	}

	public void setLocalityNameList(List<CommonOptionsVO> localityNameList) {
		this.localityNameList = localityNameList;
	}

	public List<CommonOptionsVO> getMohallaVillList() {
		return mohallaVillList;
	}

	public void setMohallaVillList(List<CommonOptionsVO> mohallaVillList) {
		this.mohallaVillList = mohallaVillList;
	}

	public List<CommonOptionsVO> getPropertyTypeList() {
		return propertyTypeList;
	}

	public List<CommonOptionsVO> getGlobalList() {
		return globalList;
	}

	public void setGlobalList(List<CommonOptionsVO> globalList) {
		this.globalList = globalList;
	}

	public void setPropertyTypeList(List<CommonOptionsVO> propertyTypeList) {
		this.propertyTypeList = propertyTypeList;
	}

	public List<CommonOptionsVO> getAreaTypeList() {
		return areaTypeList;
	}

	public void setAreaTypeList(List<CommonOptionsVO> areaTypeList) {
		this.areaTypeList = areaTypeList;
	}

	public List<CommonOptionsVO> getTahaseelList() {
		return tahaseelList;
	}

	public void setTahaseelList(List<CommonOptionsVO> tahaseelList) {
		this.tahaseelList = tahaseelList;
	}

	public List<CommonOptionsVO> getRevenueDistrictList() {
		return revenueDistrictList;
	}
	
	public void setRevenueDistrictList(List<CommonOptionsVO> revenueDistrictList) {
		this.revenueDistrictList = revenueDistrictList;
	}
	
	public List<CommonOptionsVO> getConfigurationLandList() {
		return configurationLandList;
	}

	public void setConfigurationLandList(List<CommonOptionsVO> configurationLandList) {
		this.configurationLandList = configurationLandList;
	}

	public List<CommonOptionsVO> getPurposeLandList() {
		return purposeLandList;
	}

	public void setPurposeLandList(List<CommonOptionsVO> purposeLandList) {
		this.purposeLandList = purposeLandList;
	}

	public List<CommonFiveOptionsVO> getSavedPropertyList() {
		return savedPropertyList;
	}

	public void setSavedPropertyList(List<CommonFiveOptionsVO> savedPropertyList) {
		this.savedPropertyList = savedPropertyList;
	}

	
	public List<CommonOptionsVO> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<CommonOptionsVO> districtList) {
		this.districtList = districtList;
	}

	@SkipValidation
	public String execute() throws Exception {
		log.fatal(min_val);
		String returnValue = SUCCESS;
/*
		empID = (String) request.getSession().getAttribute("_EMPCODE");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language =  (String)
					 request.getSession().getAttribute("_LANGUAGE");
		
		*/
		int returnMessage = 1;

		language="2";
		try {
			
			districtList = new ArrayList();
			districtList=manager.searchDistrictAll(Integer.parseInt(language));

		
			areaTypeList = new ArrayList<CommonOptionsVO>();
			
			dsrLocationList = new ArrayList();
			areaTypeNameList = new ArrayList<CommonOptionsVO>();
			wardHallNoList = new ArrayList<CommonOptionsVO>();
			wardVillNameList = new ArrayList<CommonOptionsVO>();
			localityNameList = new ArrayList<CommonOptionsVO>();
			mohallaVillList = new ArrayList<CommonOptionsVO>();
			propertyTypeList = new ArrayList<CommonOptionsVO>();
			tahaseelList= new ArrayList<CommonOptionsVO>();
			revenueDistrictList= new ArrayList<CommonOptionsVO>();
			savedPropertyList= new ArrayList<CommonFiveOptionsVO>();	

			List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
			allFirstPartyCapacityList = (List) context
					.getAttribute("GLOBALDROPDOWNLOV");

			

			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);

			anatherPropertyList = new ArrayList<CommonOptionsVO>();
			anatherPropertyList = helper.extractFourData("yes_no",
					this.language, allFirstPartyCapacityList);
			
					
			configurationLandList= new ArrayList<CommonOptionsVO>();
			configurationLandList = helper.extractFourData("global_land_type",
					this.language, allFirstPartyCapacityList);
			purposeLandList= new ArrayList<CommonOptionsVO>();
			purposeLandList= helper.extractFourData("global_purpose",
					this.language, allFirstPartyCapacityList);
			
			areaUnitList= new ArrayList<CommonOptionsVO>();
			areaUnitList= helper.extractFourData("global_area_unit",
					this.language, allFirstPartyCapacityList);
			

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

	

	public void validate() {
		try {

			this.setEdit(false);
			this.execute();

			if ((empID == null) || (groupID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (groupID.trim().length() == 0)
					|| (language.trim().length() == 0) || (token_date == null)
					|| (dsr_location == null)
					|| (dsr_location.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));

			} else if (!validator.requiredFiledValidate(token_no.trim())) {
				this.addFieldError("token_no", "Token No can't be empty");

			} else if (!validator.requiredFiledValidate(area_master_id.trim())) {
				this.addFieldError("area_master_id", "Area Type can't be empty");
			}

			else if (!validator.requiredFiledValidate(area_type_name.trim())) {
				this.addFieldError("area_type_name",
						"Area Type Name can't be empty");
			}
			
			else if (!validator.requiredFiledValidate(tahaseel.trim())) {
				this.addFieldError("tahaseel",
						"Tahaseel can't be empty");
			}
			
			
			else if (!validator.requiredFiledValidate(revenue_district.trim())) {
				this.addFieldError("revenue_district",
						"Revenue District can't be empty");
			}

			else if (!validator.requiredFiledValidate(ward_hal_no.trim())) {
				this.addFieldError("ward_hal_no", "Ward_Hal_No can't be empty");
			}

			else if (!validator.requiredFiledValidate(ward_vill_name.trim())) {
				this.addFieldError("ward_vill_name",
						"Ward_Vill_Name can't be empty");
			}

			else if (!validator.requiredFiledValidate(locality_name.trim())) {
				this.addFieldError("locality_name",
						"Locality_Name can't be empty");
			}

			else if (!validator.requiredFiledValidate(mohalla_vill_name.trim())) {
				this.addFieldError("mohalla_vill_name",
						"Mohalla_Vill_name_Name can't be empty");
			}

			
		 else if((khata_no!=null)&&(khata_no.trim().length()>0)&&(!validator.languageValidate(khata_no.trim(), "1"))) {
				this.addFieldError("khata_no", "Khata No in English Language");
			}

		 else if((plot_no!=null)&&(plot_no.trim().length()>0)&&(!validator.languageValidate(plot_no.trim(), "1"))) {
				this.addFieldError("plot_no", "Plot No in English Language");
			}

		 else if (!validator.requiredFiledValidate(khasra_no.trim())) {
				this.addFieldError("khasra_no",
						"Khasra No can't be empty");
			}
			
			else if (!validator.languageValidate(khasra_no.trim(), "1")) {
				this.addFieldError("khasra_no", "Khasra No in English Language");
			}

			else if ((loan_book_no != null)
					&& (loan_book_no.trim().length() > 0)
					&& (!validator.languageValidate(loan_book_no.trim(), "1"))) {
				this.addFieldError("loan_book_no",
						"Loan Book No in English Language");
			}
			
			else if (!validator.requiredFiledValidate(area_unit.trim())) {
				this.addFieldError("area_unit",
						"Area Unit can't be empty");
			}
			
			
			

			else if ((north_boundary != null)
					&& (north_boundary.trim().length() > 0)
					&& (!validator.languageValidate(north_boundary.trim(), "2"))) {
				this.addFieldError("north_boundary",
						"North Boundary should be in proper Language");
			}

			else if ((east_boundary != null)
					&& (east_boundary.trim().length() > 0)
					&& (!validator.languageValidate(east_boundary.trim(), "2"))) {
				this.addFieldError("east_boundary",
						"East Boundary should be in proper Language");
			}

			else if ((south_boundary != null)
					&& (south_boundary.trim().length() > 0)
					&& (!validator.languageValidate(south_boundary.trim(), "2"))) {
				this.addFieldError("south_boundary",
						"South Boundary should be in proper Language");
			}

			else if ((west_boundary != null)
					&& (west_boundary.trim().length() > 0)
					&& (!validator.languageValidate(west_boundary.trim(), "2"))) {
				this.addFieldError("west_boundary",
						"West Boundary should be in proper Language");
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

			else if (!validator.requiredFiledValidate(propert_type.trim())) {
				this.addFieldError("propert_type",
						"Property Type can't be empty");
			} else if (!validator.requiredFiledValidate(min_val.trim())) {
				this.addFieldError("min_val", "valuation Amount can't be empty");
			} else if (!validator.amountFiledValidate(min_val.trim())) {
				this.addFieldError("min_val", "Valuation Amount is not Valid");
			}
			
			else if((this.rent!=null)&&(this.rent.trim().length()>0)&& (!validator.amountFiledValidate(rent.trim()))) {
				this.addFieldError("rent", "Rent Amount is not Valid");
			}
			
			else if((this.no_of_tubewell!=null)&&(this.no_of_tubewell.trim().length()>0)&& (!validator.neumericFiledValidate(no_of_tubewell.trim()))) {
				this.addFieldError("no_of_tubewell", "No. of Tubewell is not Valid");
			}
			
			else if((this.no_of_well!=null)&&(this.no_of_well.trim().length()>0)&& (!validator.neumericFiledValidate(no_of_well.trim()))) {
				this.addFieldError("no_of_well", "No. of Well is not Valid");
			}
			
			

			else if (!validator.requiredFiledValidate(anotherProperty.trim())) {
				this.addFieldError("anotherProperty", "Pl. select your choice");
			}

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));

		}
	}



	@SkipValidation
	public String exitPropertyDetailEnquiry() throws Exception {
		return "home";
	}

	@SkipValidation
	public String globalAjaxEnquiry() throws Exception {
		globalList = new ArrayList<CommonOptionsVO>();
		log.fatal(methodName+","+district_id+","+area_master_id+","+area_type_name);
		try {
			String dsr[]=dsr_location.split("~");
			
			if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("AREA_TYPE"))
					&& (district_id != null)&&(district_id.trim().length()>0)) {
				if ((area_master_id != null) && (area_master_id.length() > 0)) {
					globalList = manager.getAreaTypeName(area_master_id.trim(),
							Integer.parseInt(district_id),Integer.parseInt(dsr[0].trim()));

				}
				
				
			}
 
			else if ((methodName != null)&& (district_id != null)&&(district_id.trim().length()>0)&& (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("WARD_VILL_NAME"))) {
				
				
				
				
				if ((area_master_id != null) && (area_master_id.length() > 0)
						&& (area_type_name != null)
						&& (area_type_name.length() > 0)) {
					log.fatal(methodName+","+district_id+","+area_master_id+","+area_type_name);
					
					globalList = manager.getNewWardVillName(area_master_id.trim(),
							area_type_name.trim(), Integer.parseInt(district_id),Integer.parseInt(dsr[0].trim()));
				}

			}

			else if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("MOHALLA_VILL_NAME"))
					&&  (district_id != null)&&(district_id.trim().length()>0)) {
				if ((area_master_id != null) && (area_master_id.length() > 0)
						&& (area_type_name != null)
						&& (area_type_name.length() > 0)
						&& (ward_vill_name != null)
						&& (ward_vill_name.length() > 0)
						) {
					
					globalList = manager.getNewMahallaName(area_master_id.trim(),
							area_type_name.trim(),
							ward_vill_name.trim(), Integer.parseInt(district_id),Integer.parseInt(dsr[0].trim()));
				}

			} else if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("PROPERTY_TYPE"))
					&&  (district_id != null)&&(district_id.trim().length()>0)) {
				
				log.fatal("I am Here "+methodName+","+district_id);
				
				log.fatal(area_master_id.trim()+","+area_type_name.trim()+","+ward_vill_name.trim()+","+mohalla_vill_name+","+district_id);
				

				if ((area_master_id != null) && (area_master_id.length() > 0)
						&& (area_type_name != null)
						&& (area_type_name.length() > 0)
						&& (ward_vill_name != null)
						&& (ward_vill_name.length() > 0)
						&& (mohalla_vill_name != null)
						&& (mohalla_vill_name.length() > 0)) {

					
					
					int areaIDValue = manager.getNewAreaID(area_master_id.trim(),
							area_type_name.trim(),
							ward_vill_name.trim(),
							mohalla_vill_name, Integer.parseInt(district_id),Integer.parseInt(dsr[0].trim()));
					
					log.fatal(area_master_id.trim()+","+area_type_name.trim()+","+ward_vill_name.trim()+","+mohalla_vill_name+","+district_id+","+areaIDValue);
					
					globalList = manager.getNonZeroPropertyType(areaIDValue);

					log.fatal(globalList.size());
					
				}

			}
			
			
			
			else if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("FOUR_VALUE"))
					&&  (district_id != null)&&(district_id.trim().length()>0)) {
				
				if ((area_master_id != null) && (area_master_id.length() > 0)
						&& (area_type_name != null)
						&& (area_type_name.length() > 0)
						&& (ward_vill_name != null)
						&& (ward_vill_name.length() > 0)
						&& (mohalla_vill_name != null)
						&& (mohalla_vill_name.length() > 0))
			
			 {
					
					String fourValue = manager.searchFourValue(area_master_id.trim(),area_type_name,ward_vill_name,mohalla_vill_name,Integer.parseInt(district_id),Integer.parseInt(dsr[0].trim()));
					this.four_value = fourValue;
				}

			}
			
			

			else if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("VALUATION"))
					&&  (district_id != null)&&(district_id.trim().length()>0)) {
				if ((area_volume != null) && (area_volume.length() > 0)
						&& (propert_type != null)
						&& (propert_type.length() > 0)
	
								&& (area_unit != null)
								&& (area_unit.length() > 0)) {
					String valuationAmount = manager.getValuation(
							Float.parseFloat(area_volume.trim()),
							Integer.parseInt(propert_type), Integer.parseInt(district_id),area_unit);
					this.min_val = String.valueOf(new BigDecimal(valuationAmount).setScale(0, BigDecimal.ROUND_HALF_UP));
					this.stamp_value=String.valueOf((new BigDecimal(min_val).multiply(new BigDecimal(0.05f))).setScale(0, BigDecimal.ROUND_HALF_UP));
					this.addl_stamp_value=String.valueOf((new BigDecimal(min_val).multiply(new BigDecimal(0.01f))).setScale(0, BigDecimal.ROUND_HALF_UP));
					this.cess_value=String.valueOf((new BigDecimal(stamp_value).multiply(new BigDecimal(0.05f))).setScale(0, BigDecimal.ROUND_HALF_UP));
					log.fatal("Page_id="+page_id);
					sessionMap.put("min_val", min_val);
					sessionMap.put("stamp_value", stamp_value);
					sessionMap.put("cess_value", cess_value);
				}

			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));

		}

		return SUCCESS;

	}

	
	
	
	@SkipValidation
	public String loadAreaMaster() throws Exception {

		try {
			areaTypeList = new ArrayList<CommonOptionsVO>();
			log.fatal(district_id);
			String dsr[]=dsr_location.split("~");
			
			log.fatal("I am Here "+district_id+","+dsr[0].trim());
			
			if ((this.district_id != null) && (this.district_id.length() > 0)) {
				areaTypeList =  manager.searchAreaMasterForPortal(2,
						Integer.parseInt(district_id),Integer.parseInt(dsr[0].trim()));
				log.fatal(areaTypeList.size());
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		return SUCCESS;

	}
	
	@SkipValidation
	public String loadDSRLocationForProperty() throws Exception {

		try {
			dsrLocationList = new ArrayList<CommonOptionsVO>();
		
			log.fatal(district_id+","+language);
			
			if ((this.district_id != null) && (this.district_id.length() > 0)
					&& (this.language != null) && (this.language.length() > 0)) {
				
				dsrLocationList = manager.searchLocationbyDistrictIDForUpload(
						Integer.parseInt(language),Integer.parseInt(district_id));
				log.fatal(dsrLocationList.size());
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		return SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		sessionMap=(SessionMap<String, Object>)arg0;
	}

	public String getPage_id() {
		return page_id;
	}

	public void setPage_id(String page_id) {
		this.page_id = page_id;
	}
	
}
