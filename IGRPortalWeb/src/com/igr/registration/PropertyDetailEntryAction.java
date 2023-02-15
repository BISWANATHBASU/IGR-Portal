package com.igr.registration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.commonUtility.CommonFourOptionsVO;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonThriceOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.propertyDetailModel;
//import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.igr.optionVO.CommonNineOptionsVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.igr.commonUtility.CommonFiveOptionsVO;

import java.math.BigDecimal;

public class PropertyDetailEntryAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String locationName = "";
	private String language = "";

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
	private int district_id;
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
	
	private String total_area_volume;
	private String total_area_unit;
	private String its_revenue_district;
	private String its_village_code;
	
	
	private String nazoolTahasil;
	private String nazoolVillage;
	private String nazoolWard;
	private String nazoolSheetID;
	
	
	
	private String dummyPresenterName;
	private String dummyFirstPartyExecutantCapacity;
	private String dummyDeedCategoryId;
	private String dummyConsideredAmount;
	private String dummyERegistrationId;
	private String dummyStampNoWithVal;
	private String dummyOriginalDeedTotalPageNo;
	private String dummyTotalStampValue;
	private String tcp_permission;
	private String property_permission;
	private String rda_permission;
	private String khasra_type;
	private String block_no;
	
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
	private List optionVOList;
	private List<CommonOptionsVO> configurationLandList;
	private List<CommonOptionsVO> purposeLandList;
	private List<CommonOptionsVO> areaUnitList;
	private List<CommonNineOptionsVO> savedPropertyList;
	private List<CommonOptionsVO> itsRevenueDistrictList;
	private List<CommonOptionsVO> itsVillageList;
	private List<CommonOptionsVO> khasraTypeList;
	
	private List<CommonOptionsVO> total_areaUnitList;

	private List<CommonOptionsVO>nazoolTahasilList;
	private List<CommonOptionsVO>nazoolVillageList;
	private List<CommonOptionsVO>nazoolWardList;
	private List<CommonOptionsVO>nazoolSheetIDList;
	
	
	
	
	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();

	private static final Logger log = Logger
			.getLogger(PropertyDetailEntryAction.class);
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

	public void setOptionVOList(List optionVOList) {
		this.optionVOList = optionVOList;
	}
	
	
	public String getNazoolTahasil() {
		return nazoolTahasil;
	}

	public void setNazoolTahasil(String nazoolTahasil) {
		this.nazoolTahasil = nazoolTahasil;
	}

	public String getNazoolVillage() {
		return nazoolVillage;
	}

	public void setNazoolVillage(String nazoolVillage) {
		this.nazoolVillage = nazoolVillage;
	}

	public String getNazoolWard() {
		return nazoolWard;
	}

	public void setNazoolWard(String nazoolWard) {
		this.nazoolWard = nazoolWard;
	}

	public String getNazoolSheetID() {
		return nazoolSheetID;
	}

	public void setNazoolSheetID(String nazoolSheetID) {
		this.nazoolSheetID = nazoolSheetID;
	}

	public List<CommonOptionsVO> getNazoolTahasilList() {
		return nazoolTahasilList;
	}

	public void setNazoolTahasilList(List<CommonOptionsVO> nazoolTahasilList) {
		this.nazoolTahasilList = nazoolTahasilList;
	}

	public List<CommonOptionsVO> getNazoolVillageList() {
		return nazoolVillageList;
	}

	public void setNazoolVillageList(List<CommonOptionsVO> nazoolVillageList) {
		this.nazoolVillageList = nazoolVillageList;
	}

	public List<CommonOptionsVO> getNazoolWardList() {
		return nazoolWardList;
	}

	public void setNazoolWardList(List<CommonOptionsVO> nazoolWardList) {
		this.nazoolWardList = nazoolWardList;
	}

	public List<CommonOptionsVO> getNazoolSheetIDList() {
		return nazoolSheetIDList;
	}

	public void setNazoolSheetIDList(List<CommonOptionsVO> nazoolSheetIDList) {
		this.nazoolSheetIDList = nazoolSheetIDList;
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
	
	public String getTotal_area_volume() {
		return total_area_volume;
	}

	public void setTotal_area_volume(String total_area_volume) {
		this.total_area_volume = total_area_volume;
	}

	public String getTotal_area_unit() {
		return total_area_unit;
	}

	public void setTotal_area_unit(String total_area_unit) {
		this.total_area_unit = total_area_unit;
	}

	public List<CommonOptionsVO> getTotal_areaUnitList() {
		return total_areaUnitList;
	}

	public void setTotal_areaUnitList(List<CommonOptionsVO> total_areaUnitList) {
		this.total_areaUnitList = total_areaUnitList;
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

	public int getDistrict_id() {
		return district_id;
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

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
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

	public List<CommonNineOptionsVO> getSavedPropertyList() {
		return savedPropertyList;
	}

	public void setSavedPropertyList(List<CommonNineOptionsVO> savedPropertyList) {
		this.savedPropertyList = savedPropertyList;
	}


	
	public String getTcp_permission() {
		return tcp_permission;
	}

	public void setTcp_permission(String tcp_permission) {
		this.tcp_permission = tcp_permission;
	}
	


	public String getIts_revenue_district() {
		return its_revenue_district;
	}

	public void setIts_revenue_district(String its_revenue_district) {
		this.its_revenue_district = its_revenue_district;
	}

	public String getIts_village_code() {
		return its_village_code;
	}

	public void setIts_village_code(String its_village_code) {
		this.its_village_code = its_village_code;
	}

	public List<CommonOptionsVO> getItsRevenueDistrictList() {
		return itsRevenueDistrictList;
	}

	public void setItsRevenueDistrictList(
			List<CommonOptionsVO> itsRevenueDistrictList) {
		this.itsRevenueDistrictList = itsRevenueDistrictList;
	}

	public List<CommonOptionsVO> getItsVillageList() {
		return itsVillageList;
	}

	public void setItsVillageList(List<CommonOptionsVO> itsVillageList) {
		this.itsVillageList = itsVillageList;
	}


	public List<CommonOptionsVO> getKhasraTypeList() {
		return khasraTypeList;
	}

	public void setKhasraTypeList(List<CommonOptionsVO> khasraTypeList) {
		this.khasraTypeList = khasraTypeList;
	}
	

	public String getKhasra_type() {
		return khasra_type;
	}

	public void setKhasra_type(String khasra_type) {
		this.khasra_type = khasra_type;
	}
	
	

	public String getBlock_no() {
		return block_no;
	}

	public void setBlock_no(String block_no) {
		this.block_no = block_no;
	}
	


	public String getProperty_permission() {
		return property_permission;
	}

	public void setProperty_permission(String property_permission) {
		this.property_permission = property_permission;
	}
	
	


	public String getRda_permission() {
		return rda_permission;
	}

	public void setRda_permission(String rda_permission) {
		this.rda_permission = rda_permission;
	}

	@SkipValidation
	public String execute() throws Exception {

		String returnValue = SUCCESS;

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language =  (String)
					 request.getSession().getAttribute("_LANGUAGE");
		locationName = (String) request.getSession().getAttribute(
				"LOCATIONNAME");
		//userLogModel logModel = new userLogModel();
		int returnMessage = 1;
        log.fatal("tcp_permission = "+district_id);
		
		
		
		
		try {
			

			
			areaTypeList = new ArrayList<CommonOptionsVO>();
			areaTypeList = manager.searchAreaMaster(Integer.parseInt(language),
					district_id,Integer.parseInt(dsr_location));
		    
			itsRevenueDistrictList = new ArrayList<CommonOptionsVO>();
			itsRevenueDistrictList = manager.searchRIITSForLR(district_id);
					
			itsVillageList= new ArrayList<CommonOptionsVO>();
			if ((this.its_revenue_district != null) && (this.its_revenue_district.length() > 0)) {
				itsVillageList = manager.searchVillageITSForLR(its_revenue_district,district_id);
			}
			
			nazoolTahasilList = new ArrayList<CommonOptionsVO>();
			if((this.khasra_type!=null)&&(this.khasra_type.length()>0)
			&&(!this.khasra_type.equalsIgnoreCase("global_khasra_type_1"))) {
			nazoolTahasilList = manager.searchNazoolTahasilForLR(district_id,khasra_type);
			}
			
			nazoolVillageList= new ArrayList<CommonOptionsVO>();
			if ((this.nazoolTahasil != null) && (this.nazoolTahasil.length() > 0)&&(this.khasra_type!=null)&&(this.khasra_type.length()>0)
					&&(!this.khasra_type.equalsIgnoreCase("global_khasra_type_1"))) {
				nazoolVillageList = manager.searchNazoolVillageForLR(nazoolTahasil,district_id,this.khasra_type);
			}
			
			nazoolWardList= new ArrayList<CommonOptionsVO>();
			if ((this.nazoolTahasil != null) && (this.nazoolTahasil.length() > 0)
				&&(this.nazoolVillage != null) && (this.nazoolVillage.length() > 0)
				&&(this.khasra_type!=null)&&(this.khasra_type.length()>0)
				&&(!this.khasra_type.equalsIgnoreCase("global_khasra_type_1"))) {
				nazoolWardList = manager.searchNazoolWardForLR(nazoolTahasil,nazoolVillage,district_id,this.khasra_type);
			}
			
			nazoolSheetIDList= new ArrayList<CommonOptionsVO>();
			if ((this.nazoolTahasil != null) && (this.nazoolTahasil.length() > 0)
					&&(this.nazoolVillage != null) && (this.nazoolVillage.length() > 0)
					&&(this.nazoolWard != null) && (this.nazoolWard.length() > 0)
					&&(this.khasra_type!=null)&&(this.khasra_type.length()>0)
					&&(!this.khasra_type.equalsIgnoreCase("global_khasra_type_1"))) {
				nazoolSheetIDList = manager.searchNazoolSheetIDForLR(nazoolTahasil,nazoolVillage,nazoolWard,district_id,this.khasra_type);
				}
			

			areaTypeNameList = new ArrayList<CommonOptionsVO>();
			if((area_master_id!=null)&&(area_master_id.trim().length()>0))
			{
				String areaID[] = area_master_id.split("~");
				areaTypeNameList= manager.getAreaTypeName(areaID[1].trim(),
				district_id,Integer.parseInt(dsr_location));
			}
			wardVillNameList = new ArrayList<CommonOptionsVO>();
			if((area_master_id!=null)&&(area_master_id.trim().length()>0)
			&&(area_type_name!=null)&&(area_type_name.trim().length()>0))
			{
				String areaID[] = area_master_id.split("~");
				wardVillNameList=  manager.getNewWardVillName(areaID[1].trim(),
						area_type_name.trim(), district_id,Integer.parseInt(dsr_location));
			}
			
			mohallaVillList = new ArrayList<CommonOptionsVO>();
			if ((area_master_id != null) && (area_master_id.length() > 0)
					&& (area_type_name != null)
					&& (area_type_name.length() > 0)
					&& (ward_vill_name != null)
					&& (ward_vill_name.length() > 0)
					) {
				String areaID[] = area_master_id.split("~");
				mohallaVillList= manager.getNewMahallaName(areaID[1].trim(),
						area_type_name.trim(),
						ward_vill_name.trim(), district_id,Integer.parseInt(dsr_location));
			}
			
			
			propertyTypeList = new ArrayList<CommonOptionsVO>();
			if ((area_master_id != null) && (area_master_id.length() > 0)
					&& (area_type_name != null)
					&& (area_type_name.length() > 0)
					&& (ward_vill_name != null)
					&& (ward_vill_name.length() > 0)
					&& (mohalla_vill_name != null)
					&& (mohalla_vill_name.length() > 0)) {

				String areaID[] = area_master_id.split("~");
				
				int areaIDValue = manager.getNewAreaID(areaID[1].trim(),
						area_type_name.trim(),
						ward_vill_name.trim(),
						mohalla_vill_name, district_id,Integer.parseInt(dsr_location));
				
				
				propertyTypeList = manager.getNonZeroPropertyType(areaIDValue);
			}
			
			
			wardHallNoList = new ArrayList<CommonOptionsVO>();
			
			localityNameList = new ArrayList<CommonOptionsVO>();
			
			
			tahaseelList= new ArrayList<CommonOptionsVO>();
			revenueDistrictList= new ArrayList<CommonOptionsVO>();
			savedPropertyList= new ArrayList<CommonNineOptionsVO>();	

			List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
			allFirstPartyCapacityList = (List) context.getAttribute("GLOBALDROPDOWNLOV");

			

			if (isEdit()) {
				Date currentDateValue = new Date();
				/*int message = helper.userLogActin(
						Integer.parseInt(token_no), sdf.parse(sdf.format(token_date)),
						Integer.parseInt(dsr_location),
						Integer.parseInt(empID), "Property_Detail_Entry", "START");
				*/
				this.setEdit(false);
			}
			

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
			
			total_areaUnitList= new ArrayList<CommonOptionsVO>();
			total_areaUnitList= helper.extractFourData("global_area_unit",
					this.language, allFirstPartyCapacityList);
			
			
			khasraTypeList=new ArrayList<CommonOptionsVO>();
			khasraTypeList= helper.extractFourData("global_khasra_type",
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

	public String addPropertyDetail() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;
		boolean litigatedProperty;
		boolean objectionalProperty;
		
		
		log.fatal("Bisu = "+this.property_permission +"<<"+ this.rda_permission +">>"+ this.tcp_permission);
		
		try {

			propertyDetailModel propertyModel = new propertyDetailModel();
			String areaID[] = area_master_id.split("~");
			int areaIDValue = manager.getAreaID(areaID[1].trim(),
					area_type_name.trim(),
					Integer.parseInt(ward_hal_no.trim()),
					ward_vill_name.trim(), locality_name, mohalla_vill_name,
					district_id,tahaseel,revenue_district,Integer.parseInt(dsr_location));
			
			
			litigatedProperty=manager.getLitigatedProperty(areaID[1].trim(),
					area_type_name.trim(),
					Integer.parseInt(ward_hal_no.trim()),
					ward_vill_name.trim(), locality_name, mohalla_vill_name,khasra_no,
					district_id,tahaseel,revenue_district,Integer.parseInt(dsr_location));
			
			objectionalProperty=manager.getObjectionalProperty(areaID[1].trim(),
					area_type_name.trim(),
					Integer.parseInt(ward_hal_no.trim()),
					ward_vill_name.trim(), locality_name, mohalla_vill_name,khasra_no,
					district_id,tahaseel,revenue_district,Integer.parseInt(dsr_location));
			

			if((litigatedProperty)&&(objectionalProperty)){
			Date currentDate = new Date();
			propertyModel.setArea_master_id(areaIDValue);
			propertyModel.setLang_code(Integer.parseInt(language));
			propertyModel.setDistrict_id(district_id);
			propertyModel.setArea_type(areaID[1].trim());
			propertyModel.setArea_type_name(area_type_name.trim());
			propertyModel.setWard_hal_no(Integer.parseInt(ward_hal_no.trim()));
			propertyModel.setWard_vill_name(ward_vill_name.trim());
			propertyModel.setLocality_name(locality_name);
			propertyModel.setMohalla_vill_name(mohalla_vill_name);
			propertyModel.setKhata_no(khata_no);
			propertyModel.setPlot_no(plot_no);
			propertyModel.setArea_volume(new BigDecimal(area_volume));
			propertyModel.setMin_val(new BigDecimal(min_val));
			propertyModel.setPropert_type(Integer.parseInt(propert_type));
			propertyModel.setToken_no(token_no);
			propertyModel.setDsr_location(Integer.parseInt(dsr_location));
			propertyModel.setToken_date(token_date);
			propertyModel.setTahaseel(tahaseel.trim());
			propertyModel.setRevenue_district(revenue_district.trim());
			propertyModel.setCreated_by(Integer.parseInt(empID));
			propertyModel.setUpdated_by(Integer.parseInt(empID));
			propertyModel.setCreated_date(currentDate);
			propertyModel.setUpdated_date(currentDate);
			propertyModel.setKhasra_no(this.khasra_no.trim());
			propertyModel.setLoan_book_no(this.loan_book_no.trim());
			propertyModel.setNorth_boundary(this.north_boundary.trim());
			propertyModel.setEast_boundary(this.east_boundary.trim());
			propertyModel.setSouth_boundary(this.south_boundary.trim());
			propertyModel.setWest_boundary(this.west_boundary.trim());
			propertyModel.setConfiguration_land(this.configuration_land.trim().length()>0?this.configuration_land:"OTHERS");
			propertyModel.setPurpose_land(this.purpose_land.trim().length()>0?this.purpose_land:"OTHERS");
			propertyModel.setArea_unit(area_unit);
			propertyModel.setNo_of_tubewell(no_of_tubewell.trim().length()>0?Integer.parseInt(no_of_tubewell):0);
			propertyModel.setNo_of_well(no_of_well.trim().length()>0?Integer.parseInt(no_of_well):0);
			propertyModel.setTotal_area_volume(new BigDecimal(total_area_volume));
			propertyModel.setTotal_area_unit(total_area_unit);
			propertyModel.setLr_ri_code(this.its_revenue_district==null?"":this.its_revenue_district);
			propertyModel.setLr_vill_code(this.its_village_code==null?"":this.its_village_code);
			propertyModel.setKhasra_type(this.khasra_type);
			propertyModel.setBlock_no(this.block_no.toString().length()>0?this.block_no:"");
			propertyModel.setLr_najool_tahaseel(this.nazoolTahasil==null?"":this.nazoolTahasil.toString().trim());
			propertyModel.setLr_najool_village(this.nazoolVillage==null?"":this.nazoolVillage.toString().trim());
			propertyModel.setLr_najool_ward(this.nazoolWard==null?"":this.nazoolWard.toString().trim());
			propertyModel.setLr_najool_sheet(this.nazoolSheetID==null?"":this.nazoolSheetID.toString().trim());
			propertyModel.setRemaining_area(new BigDecimal(helper.differenceArea(Float.parseFloat(this.area_volume), this.area_unit,Float.parseFloat(this.total_area_volume), this.total_area_unit)));
			

			insertOperationMessage = insertOperation.insertPropertyDeatil(
					propertyModel, token_no, token_date, dsr_location,Integer.parseInt(empID),currentDate);

			if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("1")) {
				optionVOList = manager.getPropertyDetailsToDisplay(token_no,
						sdf.parse(sdf.format(token_date)),
						Integer.parseInt(dsr_location));
			
				
				ListIterator listItrProperty = optionVOList
						.listIterator();
				 
				while (listItrProperty.hasNext()) {
					Object[] object = (Object[]) listItrProperty.next();
					CommonNineOptionsVO optionVO= new CommonNineOptionsVO(
					object[0].toString(),object[1].toString(),object[2].toString(),
					object[3].toString(),object[4].toString(),object[5].toString(),
					object[6].toString(),object[7].toString(),"");
					
					savedPropertyList.add(optionVO);
				}
				
				
				operationFlag = true;
			}

			else if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("0")) {
				operationFlag = false;
			}

			returnMessage = insertOperationMessage.substring(1,
					insertOperationMessage.trim().length());
			}
			else
			{
				this.addActionError("This property is in Litigated/Objectional. Can't be entered");
				return "home";
				
				
			}

		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		if (operationFlag) {
			this.emptyField(this.anotherProperty.equals("true") ? true : false);
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
          
			log.fatal("tcp_permission in validation ="+tcp_permission); 
			log.fatal("property_permission in validation ="+property_permission); 
			log.fatal(rda_permission + " rda_permission");
			
			if ((empID == null) 
					|| (language == null) || (empID.trim().length() == 0)
					|| (language.trim().length() == 0)
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

			
		/* else if((khata_no!=null)&&(khata_no.trim().length()>0)&&(!validator.languageValidate(khata_no.trim(), "1"))) {
				this.addFieldError("khata_no", "Khata No in English Language");
			
			As per SD on 27/04/2018 the hindi character allowed in Khasra No
			
			}
*/
		

		 else if (!validator.requiredFiledValidate(khasra_no.trim())) {
				this.addFieldError("khasra_no",
						"Khasra No can't be empty");
			}
			
			
			else if ((this.rda_permission.equalsIgnoreCase("false"))&&((khasra_no.trim().contains("~"))
					|| (khasra_no.trim().contains("!"))
					|| (khasra_no.trim().contains("@"))
					|| (khasra_no.trim().contains("#"))
					|| (khasra_no.trim().contains("$"))
					|| (khasra_no.trim().contains("^"))
					|| (khasra_no.trim().contains("&"))
					|| (khasra_no.trim().contains("*"))
					|| (khasra_no.trim().contains("("))
					|| (khasra_no.trim().contains(":"))
					|| (khasra_no.trim().contains(")"))
					|| (khasra_no.trim().contains("."))
					||(khasra_no.trim().contains(","))
					||(khasra_no.trim().contains(" "))
					||(khasra_no.trim().contains("|"))
					||(khasra_no.trim().contains("\\"))
					||(khasra_no.trim().contains("="))
					||(khasra_no.trim().contains("_"))
					||(khasra_no.trim().contains("-"))
					||(khasra_no.trim().contains(";"))
					||(khasra_no.trim().contains("à¤•à¤¾ à¤­à¤¾à¤—"))
					||(khasra_no.trim().contains("à¤­à¤¾à¤—"))
					||(khasra_no.trim().toUpperCase().contains("KA BHAG"))
					||(khasra_no.trim().toUpperCase().contains("BHAG"))
					||(khasra_no.trim().toUpperCase().contains("OTHER"))
					||(khasra_no.trim().contains("à¤®à¥‡à¤‚ à¤¸à¥‡"))
					||(khasra_no.trim().contains("à¤¸à¥‡"))
					||(khasra_no.trim().contains("à¤¤à¤•"))
					||(khasra_no.trim().contains("à¤•à¤¾ à¤Ÿà¥�à¤•à¥œà¤¾"))
					||(khasra_no.trim().contains("à¤Ÿà¥�à¤•à¥œà¤¾"))
					||(khasra_no.trim().contains("à¤•à¤¾à¤­à¤¾à¤—"))
					||(khasra_no.trim().toUpperCase().contains("KABHAG"))
					||(khasra_no.trim().contains("à¤®à¥‡à¤‚à¤¸à¥‡"))
					||(khasra_no.trim().contains("à¤•à¤¾à¤Ÿà¥�à¤•à¥œà¤¾")))) {
					this.addFieldError("khasra_no",
							"Khasra No. is not properly entered");
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
			
			
			else if (!validator.requiredFiledValidate(total_area_unit.trim())) {
				this.addFieldError("total_area_unit",
						"Total Area Unit can't be empty");
			}
			
			else if ((this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_1"))&&(!validator.requiredFiledValidate(its_revenue_district.trim()))) {
				this.addFieldError("its_revenue_district",
						"Revenue District for LR can't be empty");
			}
			
			else if ((this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_1"))&&(!validator.requiredFiledValidate(its_village_code.trim()))) {
				this.addFieldError("its_village_code",
						"Village for LR can't be empty");
			}
			
			else if ((this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_1"))&&(!validator.requiredFiledValidate(area_unit.trim()))) {
				this.addFieldError("its_village_code",
						"Village for LR can't be empty");
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
			
			// As per suvendu da , on telephone on 22/05/2018
		
			else if (( (tcp_permission.toString().equalsIgnoreCase("false"))&& (rda_permission.toString().equalsIgnoreCase("false")) ) &&(Float.parseFloat(area_volume.trim())<=0)) {
				this.addFieldError("area_volume",
						"Area Volume should be greater than zero.");
			}
			
		/*	else if ((property_permission.toString().equalsIgnoreCase("false"))&&(Float.parseFloat(area_volume.trim())<=0)) {
				this.addFieldError("area_volume",
						"Area Volume should be greater than zero.");
			}*/
			
			
			
		
			else if (!validator.requiredFiledValidate(total_area_volume.trim())) {
				this.addFieldError("total_area_volume", "Total Area Volume can't be empty");
			}
			else if (!validator.languageValidate(total_area_volume.trim(), "1")) {
				this.addFieldError("total_area_volume", "Total Area Volume in English Language");
			}
			/*else if (this.total_area_volume == "0" || this.total_area_volume.equals("0")) {
				this.addFieldError("total_area_volume", "Total Area Volume should be greater than zero.");
			}*/
			else if (!validator.neumericFiledValidate(total_area_volume.trim())) {
				this.addFieldError("total_area_volume", "Total Area Volume is not a Neumeric Value");
			}
			else if (( (tcp_permission.toString().equalsIgnoreCase("false")) && (rda_permission.toString().equalsIgnoreCase("false"))  )&&(Float.parseFloat(total_area_volume.trim())<=0)) {
				this.addFieldError("total_area_volume", "Total Area Volume should be greater than zero.");
			}
			/*else if ((property_permission.toString().equalsIgnoreCase("false"))&&(Float.parseFloat(total_area_volume.trim())<=0)) {
				this.addFieldError("total_area_volume",
						"Total Area Volume should be greater than zero.");
			}
			*/
			
			/*
			else if (Float.parseFloat(total_area_volume.trim())<=0) {
				this.addFieldError("total_area_volume",
						"Total Area Volume should be greater than zero.");
			}
			*/
			else if (!validator.requiredFiledValidate(propert_type.trim())) {
				this.addFieldError("propert_type", "Property Type can't be empty");
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
			
			
			else if(!validator.compareTwoArea(Float.parseFloat(this.area_volume), this.area_unit,Float.parseFloat(this.total_area_volume), this.total_area_unit)) {
				this.addActionError("Total Area Volume can't be Less Than Area Volume");
			}
			
		
			/*else if(((tcp_permission.toString().equalsIgnoreCase("false")) && (property_permission.toString().equalsIgnoreCase("false")&&(rda_permission.toString().equalsIgnoreCase("false")))&&(this.configuration_land!=null)&&(this.configuration_land.trim().length()>0))) {//&&(!validator.areaLessFiveDecimal(this.area_master_id, this.configuration_land,this.dummyDeedID ,Float.parseFloat(this.area_volume), this.area_unit,Float.parseFloat(this.total_area_volume), this.total_area_unit))
				this.addActionError("Less Than Five Decimal Area can't be Registered");
			}
			
			else if(((tcp_permission.toString().equalsIgnoreCase("false")) && (property_permission.toString().equalsIgnoreCase("false")&&(rda_permission.toString().equalsIgnoreCase("false")))&&(this.configuration_land!=null)&&(this.configuration_land.trim().length()>0))) {//&&(!validator.areaLessHundredSqureFeet( this.configuration_land,this.dummyDeedID ,Float.parseFloat(this.area_volume), this.area_unit,Float.parseFloat(this.total_area_volume), this.total_area_unit))
				this.addActionError("Less Than Hundred Squre Feet Area can't be Registered");
			}*/
			
			
			
		/*	else if(((property_permission.toString().equalsIgnoreCase("false"))&&(this.configuration_land!=null)&&(this.configuration_land.trim().length()>0)&&(!validator.areaLessFiveDecimal(this.area_master_id, this.configuration_land,this.dummyDeedID ,Float.parseFloat(this.area_volume), this.area_unit,Float.parseFloat(this.total_area_volume), this.total_area_unit)))) {
				this.addActionError("Less Than Five Decimal Area can't be Registered");
			}
			
			else if(((property_permission.toString().equalsIgnoreCase("false"))&&(this.configuration_land!=null)&&(this.configuration_land.trim().length()>0)&&(!validator.areaLessHundredSqureFeet( this.configuration_land,this.dummyDeedID ,Float.parseFloat(this.area_volume), this.area_unit,Float.parseFloat(this.total_area_volume), this.total_area_unit)))) {
				this.addActionError("Less Than Hundred Squre Feet Area can't be Registered");
			}*/
			
			
			else if((property_permission.toString().equalsIgnoreCase("true"))&&(!validator.compareDifferenceArea(Float.parseFloat(this.area_volume), this.area_unit,Float.parseFloat(this.total_area_volume), this.total_area_unit))){
				this.addActionError("Remaining area is less than 5 decimal. Registration can't be process");
			}
			
			
			else if(( (rda_permission.toString().equalsIgnoreCase("true"))||(tcp_permission.toString().equalsIgnoreCase("true")))&&(!validator.compareEqualArea(Float.parseFloat(this.area_volume), this.area_unit,Float.parseFloat(this.total_area_volume), this.total_area_unit))){
				this.addActionError("Total Land Area  and Purchesed Land Area is not equal. Registration can't be process");
			}
			
			
			
			else if(rda_permission.toString().equalsIgnoreCase("true")&&(this.plot_no.toString().length()==0)){
				this.addFieldError("plot_no", "Plot no is required");
			}

			
			else if(this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_2")&&(this.block_no.toString().length()==0)){
				this.addFieldError("block_no", "Block no is required");
			}
			
			else if(this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_2")&&(this.nazoolTahasil.toString().length()==0)){
				this.addFieldError("nazoolTahasil", "NazoolTahasil is required");
			}
			
			else if(this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_2")&&(this.nazoolVillage.toString().length()==0)){
				this.addFieldError("nazoolVillage", "NazoolVillage is required");
			}
			
			else if(this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_2")&&(this.nazoolWard.toString().length()==0)){
				this.addFieldError("nazoolWard", "NazoolWard is required");
			}
			
			else if(this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_2")&&(this.nazoolSheetID.toString().length()==0)){
				this.addFieldError("nazoolSheetID", "NazoolSheetID is required");
			}
			
			
			
			
			
			
			else if(this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_3")&&(this.block_no.toString().length()==0)){
				this.addFieldError("block_no", "Block no is required");
			}
			
			else if(this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_3")&&(this.nazoolTahasil.toString().length()==0)){
				this.addFieldError("nazoolTahasil", "NazoolTahasil is required");
			}
			
			else if(this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_3")&&(this.nazoolVillage.toString().length()==0)){
				this.addFieldError("nazoolVillage", "NazoolVillage is required");
			}
			
			else if(this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_3")&&(this.nazoolWard.toString().length()==0)){
				this.addFieldError("nazoolWard", "NazoolWard is required");
			}
			
			else if(this.khasra_type.toString().equalsIgnoreCase("global_khasra_type_3")&&(this.nazoolSheetID.toString().length()==0)){
				this.addFieldError("nazoolSheetID", "NazoolSheetID is required");
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
	public void emptyField(boolean choice) throws Exception {
		try {
			
			
			Date currentDateValue = new Date();
			/*int message = helper.userLogActin(
					Integer.parseInt(token_no), sdf.parse(sdf.format(token_date)),
					Integer.parseInt(dsr_location),
					Integer.parseInt(empID), "Property_Detail_Entry", "END");
			*/
			
			if (!choice) {
			String Sqlresult= manager
					.searchNavigationForPropertyStructure(
							Integer.parseInt(language),
							Integer.parseInt(dsr_location),
							this.token_date, "STRUCTURE_DETAIL",this.token_no);
			
			if((Sqlresult!=null)&&(Sqlresult.trim().length()>0)){
				this.setDummyNavigationFlag(true);
			    this.setDummyCallNature(true);	
			}
			else{
				this.setDummyNavigationFlag(false);
				this.setDummyCallNature(false);
			}
			this.setDummyDistrictID(String.valueOf(this.district_id));
			this.setDummyDsrLocation(this.dsr_location);
			this.setDummyTokenNo(this.token_no);
			this.setDummyTokenDate(this.token_date);
			this.setDummyDeedID(this.dummyDeedID);
            this.setDummyFirstPartyName(this.dummyFirstPartyName);
            this.setDummyDeedCategoryId(this.dummyDeedCategoryId);
            this.setDummyPresenterName(this.dummyPresenterName);
            this.setDummyFirstPartyExecutantCapacity(this.dummyFirstPartyExecutantCapacity);
            this.setDummyDeedCategoryId(this.dummyDeedCategoryId);
            this.setDummyConsideredAmount(this.dummyConsideredAmount);
			this.setDummyERegistrationId(this.dummyERegistrationId);
            this.setDummyStampNoWithVal(this.dummyStampNoWithVal);
            this.setDummyOriginalDeedTotalPageNo(this.dummyOriginalDeedTotalPageNo);
           
            this.setDummyTotalStampValue(this.dummyTotalStampValue);
			this.setPrintFlag(true);
			}
			
			
			
			
			
			
			this.setKhata_no("");
			this.setPlot_no("");
			this.setArea_volume("");
			this.setMin_val("");
			this.setAnotherProperty("");
			this.setKhasra_no("");
			this.setLoan_book_no("");
			this.setConfiguration_land("");
			this.setPurpose_land("");
			this.setArea_unit("");
			this.setTotal_area_unit("");
			this.setTotal_area_volume("");
			this.setRent("");
			this.setNo_of_tubewell("");
			this.setNo_of_well("");	
			this.setNazoolSheetID("");
			this.setNazoolTahasil("");
			this.setNazoolVillage("");
            this.setNazoolWard("");
			
			
			
			
		if (!choice) {
			
			
			
			this.setToken_no("");
			this.setToken_date(null);
			this.setDsr_location("");
			this.setEdit(false);
			this.setArea_master_id("");
			this.setArea_type_name("");
			this.setWard_hal_no("");
			this.setWard_vill_name("");
			this.setLocality_name("");
			this.setMohalla_vill_name("");
			this.setPropert_type("");
			this.setTahaseel("");
			this.setRevenue_district("");
			this.setNorth_boundary("");
			this.setEast_boundary("");
			this.setSouth_boundary("");
			this.setWest_boundary("");
			
			this.setNazoolSheetID("");
			this.setNazoolTahasil("");
			this.setNazoolVillage("");
            this.setNazoolWard("");
			
		
		}
		
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
	}

	@SkipValidation
	public String exitPropertyDetail() throws Exception {
		return "home";
	}

	@SkipValidation
	public String globalAjax() throws Exception {
		globalList = new ArrayList<CommonOptionsVO>();
		log.fatal(methodName+","+district_id+","+area_master_id+","+area_type_name);
		try {
			if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("AREA_TYPE"))
					&& (district_id != 0)
					&& (dsr_location != null)&& (dsr_location.trim().length()> 0)) {
				if ((area_master_id != null) && (area_master_id.length() > 0)) {
					String areaID[] = area_master_id.split("~");
					globalList = manager.getAreaTypeName(areaID[1].trim(),
							district_id,Integer.parseInt(dsr_location));

				}
				
				
			}
 
			else if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("WARD_VILL_NAME"))
					&& (district_id != 0)&& (dsr_location != null)&& (dsr_location.trim().length()> 0)) {
				if ((area_master_id != null) && (area_master_id.length() > 0)
						&& (area_type_name != null)
						&& (area_type_name.length() > 0)) {
					String areaID[] = area_master_id.split("~");
					globalList = manager.getNewWardVillName(areaID[1].trim(),
							area_type_name.trim(), district_id,Integer.parseInt(dsr_location));
				}

			}

			else if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("MOHALLA_VILL_NAME"))
					&& (district_id != 0)&& (dsr_location != null)&& (dsr_location.trim().length()> 0)) {
				if ((area_master_id != null) && (area_master_id.length() > 0)
						&& (area_type_name != null)
						&& (area_type_name.length() > 0)
						&& (ward_vill_name != null)
						&& (ward_vill_name.length() > 0)
						) {
					String areaID[] = area_master_id.split("~");
					globalList = manager.getNewMahallaName(areaID[1].trim(),
							area_type_name.trim(),
							ward_vill_name.trim(), district_id,Integer.parseInt(dsr_location));
				}

			} else if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("PROPERTY_TYPE"))
					&& (district_id != 0)&& (dsr_location != null)&& (dsr_location.trim().length()> 0)) {

				if ((area_master_id != null) && (area_master_id.length() > 0)
						&& (area_type_name != null)
						&& (area_type_name.length() > 0)
						&& (ward_vill_name != null)
						&& (ward_vill_name.length() > 0)
						&& (mohalla_vill_name != null)
						&& (mohalla_vill_name.length() > 0)) {

					String areaID[] = area_master_id.split("~");
					
					int areaIDValue = manager.getNewAreaID(areaID[1].trim(),
							area_type_name.trim(),
							ward_vill_name.trim(),
							mohalla_vill_name, district_id,Integer.parseInt(dsr_location));
					
					
					globalList = manager.getNonZeroPropertyType(areaIDValue);

				}

			}
			
			
			
			else if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("FOUR_VALUE"))
					&& (district_id != 0)&& (dsr_location != null)&& (dsr_location.trim().length()> 0)) {
				
				if ((area_master_id != null) && (area_master_id.length() > 0)
						&& (area_type_name != null)
						&& (area_type_name.length() > 0)
						&& (ward_vill_name != null)
						&& (ward_vill_name.length() > 0)
						&& (mohalla_vill_name != null)
						&& (mohalla_vill_name.length() > 0))
			
			 {
					String areaID[] = area_master_id.split("~");
					String fourValue = manager.searchFourValue(areaID[1].trim(),area_type_name,ward_vill_name,mohalla_vill_name,district_id,Integer.parseInt(dsr_location));
					this.four_value = fourValue;
				}

			}
			
			

			else if ((methodName != null) && (methodName.length() > 0)
					&& (methodName.equalsIgnoreCase("VALUATION"))
					&& (district_id != 0)) {
				if ((area_volume != null) && (area_volume.length() > 0)
						&& (propert_type != null)
						&& (propert_type.length() > 0)
	
								&& (area_unit != null)
								&& (area_unit.length() > 0)) {
					String valuationAmount = manager.getValuation(
							Float.parseFloat(area_volume.trim()),
							Integer.parseInt(propert_type), district_id,area_unit);
					this.min_val = String.valueOf(new BigDecimal(valuationAmount).setScale(0, BigDecimal.ROUND_HALF_UP));
				}

			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));

		}

		return SUCCESS;

	}
	
	
	@SkipValidation
	public String loadITSVillageEntry() throws Exception {

		try {
			itsVillageList = new ArrayList<CommonOptionsVO>();
			log.fatal("I am Here"+district_id);
			if ((this.its_revenue_district != null) && (this.its_revenue_district.length() > 0)) {
				itsVillageList = manager.searchVillageITSForLR(its_revenue_district,district_id);
				
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		return SUCCESS;

	}
	
	
	
	
	
	@SkipValidation
	public String loadNazoolVillageEntry() throws Exception {

		try {
			nazoolVillageList= new ArrayList<CommonOptionsVO>();
			if ((this.nazoolTahasil != null) && (this.nazoolTahasil.length() > 0)
					&&(this.khasra_type!=null)&&(this.khasra_type.length()>0)) {
				nazoolVillageList = manager.searchNazoolVillageForLR(nazoolTahasil,district_id,khasra_type);
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		return SUCCESS;

	}

	
	
	@SkipValidation
	public String loadNazoolTahasil() throws Exception {

		try {
			
			nazoolTahasilList= new ArrayList<CommonOptionsVO>();
			if ((this.khasra_type!=null)&&(this.khasra_type.length()>0)) {
				
				nazoolTahasilList = manager.searchNazoolTahasilForLR(district_id,khasra_type);
				
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		return SUCCESS;

	}

	
	
	
	@SkipValidation
	public String loadNazoolWardEntry() throws Exception {

		try {
			nazoolWardList= new ArrayList<CommonOptionsVO>();
			if ((this.nazoolTahasil != null) && (this.nazoolTahasil.length() > 0)
				&&(this.nazoolVillage != null) && (this.nazoolVillage.length() > 0)
				&(this.khasra_type!=null)&&(this.khasra_type.length()>0)) {
				nazoolWardList = manager.searchNazoolWardForLR(nazoolTahasil,nazoolVillage,district_id,khasra_type);
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		return SUCCESS;

	}
	
	
	@SkipValidation
	public String loadNazoolSheetIDEntry() throws Exception {

		try {
			nazoolSheetIDList= new ArrayList<CommonOptionsVO>();
			if ((this.nazoolTahasil != null) && (this.nazoolTahasil.length() > 0)
					&&(this.nazoolVillage != null) && (this.nazoolVillage.length() > 0)
					&&(this.nazoolWard != null) && (this.nazoolWard.length() > 0)
					&(this.khasra_type!=null)&&(this.khasra_type.length()>0)) {
				nazoolSheetIDList = manager.searchNazoolSheetIDForLR(nazoolTahasil,nazoolVillage,nazoolWard,district_id,this.khasra_type);
				}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		return SUCCESS;

	}
}
