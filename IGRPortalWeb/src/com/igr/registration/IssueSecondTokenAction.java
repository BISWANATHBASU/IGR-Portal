package com.igr.registration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.igr.commonUtility.CommonFourOptionsVO;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonThriceOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.commonUtility.GetAllDataFromScreen;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.oldDeedDetailModel;
import com.igr.hibernate.model.oldDeedDetailPKModel;
import com.igr.hibernate.model.secondTokenPKModel;
import com.igr.hibernate.model.secondTokenTypeModel;
import com.igr.hibernate.model.provisionalTokenTypeModel;
//import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.igr.webservice.eChallan;
import com.igr.webservice.SH.CommonWebServiceStub;
import com.igr.webservice.SH.CommonWebServiceStub.EsiResponse;
import com.igr.webservice.SH.CommonWebServiceStub.EsiVerifyCert;
import com.igr.webservice.SH.CommonWebServiceStub.GetSingleCertificateDetails;
import com.igr.webservice.SH.CommonWebServiceStub.GetSingleCertificateDetailsE;
import com.igr.webservice.SH.CommonWebServiceStub.GetSingleCertificateDetailsResponse;
import com.igr.webservice.SH.CommonWebServiceStub.GetSingleCertificateDetailsResponseE;
import com.igr.webservice.SH.CommonWebServiceStub.LockCertRequest;
import com.igr.webservice.SH.CommonWebServiceStub.LockEStampCertificate;
import com.igr.webservice.SH.CommonWebServiceStub.LockEStampCertificateE;
import com.igr.webservice.SH.CommonWebServiceStub.LockEStampCertificateResponse;
import com.igr.webservice.SH.CommonWebServiceStub.LockEStampCertificateResponseE;
import com.igr.webservice.eChalan.EchallanLocator;
import com.igr.webservice.eChalan.Echallan_DS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.math.BigDecimal;

public class IssueSecondTokenAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private String empID = "";
	//private String branchCode = "";
	//private String groupID = "";
	private String locationName = "";
	//private String districtID = "";
	//private String districtName = "";
	private String district_id_name;
	private String deed_type_name;
	private String deed_type_data;

	private String token_no;
	private String presenter_name;
	private String first_party_executant_name;
	private String first_party_executant_capacity;
	private String district_id;
	private String dsr_location;
	private String dsr_location_desc;
	private String stamp_type;
	private String stamp_pages_no;
	private String stamp_no;
	private String chalan_no;
	private String treasury_stamp_page_no;
	private String chalan_page_no;
	private String stamp_value;
	private String chalan_value;
	private String original_deed_total_page_no;
	private String e_registration_id;
	private String considered_amount;
	private String dealing_amount;
	private String paid_amount;
	private String due_amount;
	private boolean edit;
	private String rowNumber;
	private String deed_category_id;
	private String deed_type_id;
	private String language;
	private Date firstTokenDate;
	private String party_type;
	private String total_stamp_value;
	private String total_page_no;
	private String aa_rent;
	private String premium_amount;
	private String cost_of_building;
	//private String input_form;
	//private String complete_document;
	//private File fileUpload;

	private boolean printFlag;
	private String dummyTokenNo;
	private String dummyDistrictID;
	private String dummyDsrLocation;
	private boolean dummyNavigationFlag;
	private Date dummyTokenDate;
	private String dummyDeedID;
	private String dummyFirstPartyName;

	private String dummyPresenterName;
	private String dummyFirstPartyExecutantCapacity;
	private String dummyDeedCategoryId;
	private String dummyConsideredAmount;
	private String dummyERegistrationId;
	private String dummyStampNoWithVal;
	private String dummyOriginalDeedTotalPageNo;
	private String dummyTotalStampValue;
	private String dummyAa_rent;
	private String dummyPremium_amount;
	private String dummyCost_of_building;
	private String messageValue;
	
	
	private String old_deed_no;
	private String old_deed_date;
	private String old_registration_fee;
	private String old_receipt_no;
	private String old_stamp_fee;
	
	private String t_cp_permission;
	private String t_cp_no;
	private String t_cp_date;
	private File memofileUpload;
	private File nakshafileUpload;
	private String dummytcppermission;
	
	
	
	private String property_permission;
	private String  property_permission_no ;
	private String  property_permission_date ;
	private File propertymemofileUpload;
	private File propertynakshafileUpload;
	private String dummypropertypermission;
	
	private String rda_permission;
	private String rda_permission_no ;
	private String rda_permission_date ;
	private File rdamemofileUpload;
	private File rdanakshafileUpload;
	private String dummyrdapermission;
	
	private static eChallan echlan = new eChallan(); 
	
	public String getDistrict_id_name() {
		return district_id_name;
	}

	public void setDistrict_id_name(String district_id_name) {
		this.district_id_name = district_id_name;
	}

	public String getDeed_type_name() {
		return deed_type_name;
	}

	public void setDeed_type_name(String deed_type_name) {
		this.deed_type_name = deed_type_name;
	}

	public String getDeed_type_data() {
		return deed_type_data;
	}

	public void setDeed_type_data(String deed_type_data) {
		this.deed_type_data = deed_type_data;
	}

	private String deedState;
	

	public Date getDummyTokenDate() {
		return dummyTokenDate;
	}

	public void setDummyTokenDate(Date dummyTokenDate) {
		this.dummyTokenDate = dummyTokenDate;
	}

	private ServletContext context;
	private HttpServletRequest request;
	final int dpi = 150;

	private List<CommonOptionsVO> stateList;
	private List<CommonOptionsVO> dsrLocationList;
	private List<CommonOptionsVO> districtList;
	private List<CommonOptionsVO> firstPartyCapacityList;
	private List<CommonOptionsVO> stampTypeList;
	private List<CommonThriceOptionsVO> stampNoValueList = new ArrayList<CommonThriceOptionsVO>();
	private List<CommonOptionsVO> deedCategoryList;
	private List<CommonOptionsVO> deedTypeList;
	private List<CommonOptionsVO> deedStateList;
	
	
	
	private List<CommonOptionsVO> inputFormList;
	private List<CommonOptionsVO> completeDocumentList;
	private List<CommonOptionsVO> tcpselectionList;

	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();

	private static GetAllDataFromScreen datafromScreen = new GetAllDataFromScreen();
	HibernateManager manager = new HibernateManager();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
	SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("a");


	private static final Logger log = Logger.getLogger(IssueSecondTokenAction.class);
	private static InsertOperation insertOperation = new InsertOperation();

	public List<CommonOptionsVO> getDeedCategoryList() {
		return deedCategoryList;
	}

	public void setDeedCategoryList(List<CommonOptionsVO> deedCategoryList) {
		this.deedCategoryList = deedCategoryList;
	}

	public String getDealing_amount() {
		return dealing_amount;
	}

	public void setDealing_amount(String dealing_amount) {
		this.dealing_amount = dealing_amount;
	}

	public List<CommonOptionsVO> getDeedTypeList() {
		return deedTypeList;
	}

	public void setDeedTypeList(List<CommonOptionsVO> deedTypeList) {
		this.deedTypeList = deedTypeList;
	}

	public List<CommonOptionsVO> getStampTypeList() {
		return stampTypeList;
	}

	public String getAa_rent() {
		return aa_rent;
	}

	public void setAa_rent(String aa_rent) {
		this.aa_rent = aa_rent;
	}
	
	
	

	public String getChalan_no() {
		return chalan_no;
	}

	public void setChalan_no(String chalan_no) {
		this.chalan_no = chalan_no;
	}

	public String getChalan_value() {
		return chalan_value;
	}

	public void setChalan_value(String chalan_value) {
		this.chalan_value = chalan_value;
	}

	/*public String getInput_form() {
		return input_form;
	}

	public void setInput_form(String input_form) {
		this.input_form = input_form;
	}

	public String getComplete_document() {
		return complete_document;
	}

	public void setComplete_document(String complete_document) {
		this.complete_document = complete_document;
	}*/

	public List<CommonOptionsVO> getInputFormList() {
		return inputFormList;
	}

	public void setInputFormList(List<CommonOptionsVO> inputFormList) {
		this.inputFormList = inputFormList;
	}

	public List<CommonOptionsVO> getCompleteDocumentList() {
		return completeDocumentList;
	}
	
	
	

	/*public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}*/

	public void setCompleteDocumentList(List<CommonOptionsVO> completeDocumentList) {
		this.completeDocumentList = completeDocumentList;
	}

	public String getOld_deed_no() {
		return old_deed_no;
	}

	public void setOld_deed_no(String old_deed_no) {
		this.old_deed_no = old_deed_no;
	}

	public String getOld_deed_date() {
		return old_deed_date;
	}

	public void setOld_deed_date(String old_deed_date) {
		this.old_deed_date = old_deed_date;
	}

	public String getOld_registration_fee() {
		return old_registration_fee;
	}

	public void setOld_registration_fee(String old_registration_fee) {
		this.old_registration_fee = old_registration_fee;
	}

	public String getOld_receipt_no() {
		return old_receipt_no;
	}

	public void setOld_receipt_no(String old_receipt_no) {
		this.old_receipt_no = old_receipt_no;
	}

	public String getOld_stamp_fee() {
		return old_stamp_fee;
	}

	public void setOld_stamp_fee(String old_stamp_fee) {
		this.old_stamp_fee = old_stamp_fee;
	}

	public String getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}
	
	public String getChalan_page_no() {
		return chalan_page_no;
	}

	public void setChalan_page_no(String chalan_page_no) {
		this.chalan_page_no = chalan_page_no;
	}

	public String getPremium_amount() {
		return premium_amount;
	}
	
	
	public String getTreasury_stamp_page_no() {
		return treasury_stamp_page_no;
	}

	public void setTreasury_stamp_page_no(String treasury_stamp_page_no) {
		this.treasury_stamp_page_no = treasury_stamp_page_no;
	}

	public void setPremium_amount(String premium_amount) {
		this.premium_amount = premium_amount;
	}

	public String getCost_of_building() {
		return cost_of_building;
	}

	public void setCost_of_building(String cost_of_building) {
		this.cost_of_building = cost_of_building;
	}

	public String getDummyAa_rent() {
		return dummyAa_rent;
	}

	public void setDummyAa_rent(String dummyAa_rent) {
		this.dummyAa_rent = dummyAa_rent;
	}

	public String getDummyPremium_amount() {
		return dummyPremium_amount;
	}

	public void setDummyPremium_amount(String dummyPremium_amount) {
		this.dummyPremium_amount = dummyPremium_amount;
	}

	public String getDummyCost_of_building() {
		return dummyCost_of_building;
	}

	public void setDummyCost_of_building(String dummyCost_of_building) {
		this.dummyCost_of_building = dummyCost_of_building;
	}

	public String getDummyTotalStampValue() {
		return dummyTotalStampValue;
	}

	public void setDummyTotalStampValue(String dummyTotalStampValue) {
		this.dummyTotalStampValue = dummyTotalStampValue;
	}

	public boolean getDummyNavigationFlag() {
		return dummyNavigationFlag;
	}

	public String getDummyDeedID() {
		return dummyDeedID;
	}

	public void setDummyDeedID(String dummyDeedID) {
		this.dummyDeedID = dummyDeedID;
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

	public String getTotal_stamp_value() {
		return total_stamp_value;
	}

	public void setTotal_stamp_value(String total_stamp_value) {
		this.total_stamp_value = total_stamp_value;
	}

	public String getDummyConsideredAmount() {
		return dummyConsideredAmount;
	}

	public void setDummyConsideredAmount(String dummyConsideredAmount) {
		this.dummyConsideredAmount = dummyConsideredAmount;
	}

	public String getTotal_page_no() {
		return total_page_no;
	}

	public void setTotal_page_no(String total_page_no) {
		this.total_page_no = total_page_no;
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

	public void setDummyOriginalDeedTotalPageNo(
			String dummyOriginalDeedTotalPageNo) {
		this.dummyOriginalDeedTotalPageNo = dummyOriginalDeedTotalPageNo;
	}

	public String getDummyFirstPartyName() {
		return dummyFirstPartyName;
	}

	public void setDummyFirstPartyName(String dummyFirstPartyName) {
		this.dummyFirstPartyName = dummyFirstPartyName;
	}

	public void setDummyNavigationFlag(boolean dummyNavigationFlag) {
		this.dummyNavigationFlag = dummyNavigationFlag;
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

	public String getParty_type() {
		return party_type;
	}

	public void setParty_type(String party_type) {
		this.party_type = party_type;
	}

	public Date getFirstTokenDate() {
		return firstTokenDate;
	}

	public void setFirstTokenDate(Date firstTokenDate) {
		this.firstTokenDate = firstTokenDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setStampTypeList(List<CommonOptionsVO> stampTypeList) {
		this.stampTypeList = stampTypeList;
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

	public List<CommonOptionsVO> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<CommonOptionsVO> districtList) {
		this.districtList = districtList;
	}

	public String getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}

	public List<CommonThriceOptionsVO> getStampNoValueList() {
		return stampNoValueList;
	}

	public void setStampNoValueList(List<CommonThriceOptionsVO> stampNoValueList) {
		this.stampNoValueList = stampNoValueList;
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

	public String getToken_no() {
		return token_no;
	}

	public void setToken_no(String token_no) {
		this.token_no = token_no;
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

	public void setFirst_party_executant_capacity(
			String first_party_executant_capacity) {
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

	public String getStamp_type() {
		return stamp_type;
	}

	public void setStamp_type(String stamp_type) {
		this.stamp_type = stamp_type;
	}

	public String getStamp_pages_no() {
		return stamp_pages_no;
	}

	public void setStamp_pages_no(String stamp_pages_no) {
		this.stamp_pages_no = stamp_pages_no;
	}

	public String getStamp_no() {
		return stamp_no;
	}

	public void setStamp_no(String stamp_no) {
		this.stamp_no = stamp_no;
	}

	public String getStamp_value() {
		return stamp_value;
	}

	public void setStamp_value(String stamp_value) {
		this.stamp_value = stamp_value;
	}

	public String getOriginal_deed_total_page_no() {
		return original_deed_total_page_no;
	}

	public void setOriginal_deed_total_page_no(
			String original_deed_total_page_no) {
		this.original_deed_total_page_no = original_deed_total_page_no;
	}

	public String getE_registration_id() {
		return e_registration_id;
	}

	public void setE_registration_id(String e_registration_id) {
		this.e_registration_id = e_registration_id;
	}

	public String getConsidered_amount() {
		return considered_amount;
	}

	public void setConsidered_amount(String considered_amount) {
		this.considered_amount = considered_amount;
	}

	public String getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(String paid_amount) {
		this.paid_amount = paid_amount;
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

	public void setFirstPartyCapacityList(
			List<CommonOptionsVO> firstPartyCapacityList) {
		this.firstPartyCapacityList = firstPartyCapacityList;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
	
	


	public String getT_cp_permission() {
		return t_cp_permission;
	}

	public void setT_cp_permission(String t_cp_permission) {
		this.t_cp_permission = t_cp_permission;
	}

	public String getT_cp_no() {
		return t_cp_no;
	}

	public void setT_cp_no(String t_cp_no) {
		this.t_cp_no = t_cp_no;
	}

	public String getT_cp_date() {
		return t_cp_date;
	}

	public void setT_cp_date(String t_cp_date) {
		this.t_cp_date = t_cp_date;
	}

	public File getMemofileUpload() {
		return memofileUpload;
	}

	public void setMemofileUpload(File memofileUpload) {
		this.memofileUpload = memofileUpload;
	}

	public File getNakshafileUpload() {
		return nakshafileUpload;
	}

	public void setNakshafileUpload(File nakshafileUpload) {
		this.nakshafileUpload = nakshafileUpload;
	}


	public List<CommonOptionsVO> getTcpselectionList() {
		return tcpselectionList;
	}

	public void setTcpselectionList(List<CommonOptionsVO> tcpselectionList) {
		this.tcpselectionList = tcpselectionList;
	}


	public String getDummytcppermission() {
		return dummytcppermission;
	}

	public void setDummytcppermission(String dummytcppermission) {
		this.dummytcppermission = dummytcppermission;
	}
	


	public String getProperty_permission() {
		return property_permission;
	}

	public void setProperty_permission(String property_permission) {
		this.property_permission = property_permission;
	}

	public String getProperty_permission_no() {
		return property_permission_no;
	}

	public void setProperty_permission_no(String property_permission_no) {
		this.property_permission_no = property_permission_no;
	}

	public String getProperty_permission_date() {
		return property_permission_date;
	}

	public void setProperty_permission_date(String property_permission_date) {
		this.property_permission_date = property_permission_date;
	}
	
	
	

	public File getPropertymemofileUpload() {
		return propertymemofileUpload;
	}

	public void setPropertymemofileUpload(File propertymemofileUpload) {
		this.propertymemofileUpload = propertymemofileUpload;
	}

	public File getPropertynakshafileUpload() {
		return propertynakshafileUpload;
	}

	public void setPropertynakshafileUpload(File propertynakshafileUpload) {
		this.propertynakshafileUpload = propertynakshafileUpload;
	}
	

	public String getDummypropertypermission() {
		return dummypropertypermission;
	}

	public void setDummypropertypermission(String dummypropertypermission) {
		this.dummypropertypermission = dummypropertypermission;
	}

	
	
	
	
	public String getDeedState() {
		return deedState;
	}

	public void setDeedState(String deedState) {
		this.deedState = deedState;
	}

	public List<CommonOptionsVO> getDeedStateList() {
		return deedStateList;
	}

	public void setDeedStateList(List<CommonOptionsVO> deedStateList) {
		this.deedStateList = deedStateList;
	}
	
	
	
	
	

	public String getRda_permission() {
		return rda_permission;
	}

	public void setRda_permission(String rda_permission) {
		this.rda_permission = rda_permission;
	}

	public String getRda_permission_no() {
		return rda_permission_no;
	}

	public void setRda_permission_no(String rda_permission_no) {
		this.rda_permission_no = rda_permission_no;
	}

	public String getRda_permission_date() {
		return rda_permission_date;
	}

	public void setRda_permission_date(String rda_permission_date) {
		this.rda_permission_date = rda_permission_date;
	}

	public File getRdamemofileUpload() {
		return rdamemofileUpload;
	}

	public void setRdamemofileUpload(File rdamemofileUpload) {
		this.rdamemofileUpload = rdamemofileUpload;
	}

	public File getRdanakshafileUpload() {
		return rdanakshafileUpload;
	}

	public void setRdanakshafileUpload(File rdanakshafileUpload) {
		this.rdanakshafileUpload = rdanakshafileUpload;
	}
	


	public String getDummyrdapermission() {
		return dummyrdapermission;
	}

	public void setDummyrdapermission(String dummyrdapermission) {
		this.dummyrdapermission = dummyrdapermission;
	}
	
	private File uploadDoc;

	public File getUploadDoc() {
		return uploadDoc;
	}
	public void setUploadDoc(File uploadDoc) {
		this.uploadDoc = uploadDoc;
	}

    private List<CommonOptionsVO> party_type_List;
    private String relativeType;
    private List<CommonOptionsVO> relativeTypeList;
    private String presenterMobileNo;
    private String presentereMailId;
    
    private String relativeName;
    private String presenterAddress;
    private String presenterState;
    private String presenterPinCode;
    

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

	public String getPresenterPinCode() {
		return presenterPinCode;
	}

	public void setPresenterPinCode(String presenterPinCode) {
		this.presenterPinCode = presenterPinCode;
	}

	@SkipValidation
	public String execute() throws Exception {

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		//branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		//groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		//locationName = (String) request.getSession().getAttribute("LOCATIONNAME");
		//districtID = (String) request.getSession().getAttribute("DISTRICT_CODE");
		//districtName = (String) request.getSession().getAttribute("DISTRICT_NAME");
		//userLogModel logModel = new userLogModel();
		//locationName = helper.DsrName(dsr_location, Integer.parseInt(language));
		int returnMessage = 1;
		String returnValue = SUCCESS;

		try {
			
		/*String limit = manager.getOperationTime("SECOND TOKEN");
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
			
			
		
		
		
			
			List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
			allFirstPartyCapacityList = (List) context.getAttribute("GLOBALDROPDOWNLOV");

			//stateList = new ArrayList<CommonOptionsVO>();
			//List<CommonThriceOptionsVO> allStateList = new ArrayList<CommonThriceOptionsVO>();
			//allStateList = (List) context.getAttribute("STATELOV");
			//stateList = helper.extractThriceData(this.language, allStateList);

			dsrLocationList = new ArrayList();
			//CommonOptionsVO optionVO = new CommonOptionsVO(branchCode,locationName);
			//dsrLocationList.add(optionVO);

			//district_id_name = helper.DisrictName(district_id,Integer.parseInt(language));
			//total_page_no = ""+Integer.parseInt(this.total_page_no) / 2;
			
			//String[] deed_type_name_val = helper.deedTypeName(deed_type_id,Integer.parseInt(language)).split("<>");
			//deed_type_name = deed_type_name_val[0];
			//deed_type_data = deed_type_name_val[1];
			
			districtList = new ArrayList();
            districtList = manager.searchDistrictAll(Integer.parseInt(language));
			//CommonOptionsVO optionVO1 = new CommonOptionsVO(districtID,districtName);
			//districtList.add(optionVO1);


            party_type_List= new ArrayList<CommonOptionsVO>();
            party_type_List = helper.extractFourData("party_type",this.language, allFirstPartyCapacityList);

            relativeTypeList = new ArrayList<CommonOptionsVO>();
            relativeTypeList = helper.extractFourData("presenter_relation",this.language, allFirstPartyCapacityList);
			
			
			inputFormList= new ArrayList<CommonOptionsVO>();
			inputFormList  = helper.extractFourData("yes_no",this.language, allFirstPartyCapacityList);
			
			completeDocumentList=new ArrayList<CommonOptionsVO>();
			completeDocumentList  = helper.extractFourData("yes_no",this.language, allFirstPartyCapacityList);
			
			tcpselectionList=new ArrayList<CommonOptionsVO>();
			tcpselectionList  = helper.extractFourData("yes_no",this.language, allFirstPartyCapacityList);
			

			firstPartyCapacityList = new ArrayList<CommonOptionsVO>();
			firstPartyCapacityList = helper.extractFourData("firstParty_capacity", this.language,allFirstPartyCapacityList);

			stampTypeList = new ArrayList<CommonOptionsVO>();
			stampTypeList = helper.extractFourData("stamp_type", this.language,allFirstPartyCapacityList);

			deedCategoryList = new ArrayList<CommonOptionsVO>();
			deedTypeList = manager.searchDeedTypeForAmount(Integer.parseInt(language));

			stateList = new ArrayList<CommonOptionsVO>();
			stateList = helper.extractThriceData(this.language,(List) context.getAttribute("STATELOV"));
			
			
			deedStateList= new ArrayList<CommonOptionsVO>();
			deedStateList = helper.extractFourData("global_deed_type", this.language,allFirstPartyCapacityList);
			
			firstTokenDate = new Date();

			//e_registration_id = helper.eRegistrationNumberGenerate(this.token_no);//this.districtID, this.dsr_location, 
			
			//total_page_no = ""+manager.searchPageNo(this.token_no,sdf.parse(sdf.format(firstTokenDate)),Integer.parseInt(this.dsr_location))/2;

			//if (party_type.equalsIgnoreCase("global_party_type_nispadk"))
				//this.setFirst_party_executant_name(this.presenter_name);
			
			
			
			
			if (isEdit()) {
				//Date currentDateValue = new Date();
			//	String tokenArray[] = this.token_no.split("-");
				/*returnMessage = helper.userLogActin(
						Integer.parseInt(this.token_no), sdf.parse(sdf.format(firstTokenDate)),
						Integer.parseInt(dsr_location),
						Integer.parseInt(empID), "Issue_Second_Token", "START");
				*/
				this.setEdit(false);
			}
			// END INITIALIZATION OF ARRAYLISTS AND VARIABLES
			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);

			loadStampNoValueFromScreen();
			// LoadInitialStampNoValueList();
			loadCategory();

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
	public String loadDSRLocation() throws Exception {
		log.fatal("dsrlocation");

		//language = (String) request.getSession().getAttribute("_LANGUAGE");
		log.fatal("district_id====="+district_id+",language="+language);
		try {
			dsrLocationList = new ArrayList<CommonOptionsVO>();
			if ((this.district_id != null) && (this.district_id.length() > 0)
					&& (this.language != null) && (this.language.length() > 0)) {
			log.fatal("district id and language is not null");
				dsrLocationList = manager.searchLocationbyDistrictID(
						Integer.parseInt(language),
						Integer.parseInt(district_id));
			}
		} catch (Exception e) {
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		log.fatal("dsrLocationList.size()====="+dsrLocationList.size());
		return SUCCESS;

	}

	public String addSecondToken() throws Exception {
		
		log.fatal("addSecondToken()");
		
		Date currentDateValue = new Date();

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;
		String stampNoValue = "";
		String deed_type_id_array[] = deed_type_id.split("-");
		int eStampCount = 0;
		try {
			
			token_no = helper.sequenceNo(dsr_location);
			
			dsr_location_desc = helper.DsrName(dsr_location,Integer.parseInt(language));

			String tokenStatus = "global_p";
            
            String bookID = manager.searchBookIdWithDeed(Integer.parseInt(language), Integer.parseInt(deed_type_id_array[0]));
            locationName=manager.searchSingleRowDSRName(Integer.parseInt(this.dsr_location));
            
            String bookIDArray[]=bookID.split("~");
            if( bookIDArray.length>0){
                bookID=bookIDArray[0];
            }
            
            first_party_executant_name = presenter_name;
            
            PDDocument mainDoc = PDDocument.load(uploadDoc);
            int count = mainDoc.getNumberOfPages();
            
            total_page_no = ""+count;
            
            e_registration_id = helper.eRegistrationNumberGenerate(this.token_no);//this.districtID, this.dsr_location, 
            
            log.fatal("Token No="+token_no+",PDF Pages="+count+", e-Panjeeyan No="+e_registration_id+",dsr_location_desc="+dsr_location_desc+",total_page_no="+total_page_no);
			
			//int count = manager.searchPageNo(this.token_no,sdf.parse(sdf.format(firstTokenDate)),Integer.parseInt(this.dsr_location));

			//if (count == Integer.parseInt(this.total_page_no)*2){
            if (count % 2 == 0) {
            	
            	log.fatal("PDF Pages===Correct===True");
            
			//if (count == Integer.parseInt(this.total_page_no)){

			//Date currentDateValue = new Date();
			List<CommonThriceOptionsVO> partyName = datafromScreen.getAllDataForIssueSecondToken(request, this.rowNumber);

			if ((partyName != null) && (partyName.size() > 0)) {
				ListIterator<CommonThriceOptionsVO> listItr = partyName.listIterator();

				while (listItr.hasNext()) {
					CommonThriceOptionsVO optionVO = (CommonThriceOptionsVO) listItr.next();

					log.fatal(optionVO.getTypeCodeDesc());
					stampNoValue += optionVO.getTypeCode() + "_" + optionVO.getTypeDesc() + "~";
				}
			}
			if (stampNoValue.trim().length() > 0) {
				stampNoValue = stampNoValue.substring(0,stampNoValue.length() - 1);
				eStampCount = StringUtils.countMatches(stampNoValue,"global-estamp");
				log.fatal("eStampCount " + eStampCount);
			}
			String returnValueChallan = "";
			log.fatal(stampNoValue);
			log.fatal("chalan_no="+chalan_no+", stamp_type="+stamp_type);
			
			/*
			
			if(stamp_type == "global-chalan" || stamp_type.equalsIgnoreCase("global-chalan")){
				log.fatal("chalan_no="+chalan_no);
				String eChallanValue = echlan.getE_Challan(chalan_no, "05");
				log.fatal("eChallanValue="+eChallanValue);
				
				returnValueChallan = helper.eChallan(eChallanValue,this.token_no,sdf.parse(sdf.format(firstTokenDate)),Integer.parseInt(this.dsr_location));
			}
			
			log.fatal("returnValueChallan="+returnValueChallan);
			*/
			
		//	String SecondaryToken[] = this.token_no.split("-");
			secondTokenPKModel secondTokenPK = new secondTokenPKModel();
			secondTokenPK.setToken_no(this.token_no);
			secondTokenPK.setToken_date(sdf.parse(sdf.format(firstTokenDate)));
			secondTokenPK.setDsr_location(Integer.parseInt(this.dsr_location));

			secondTokenTypeModel tokenModel = new secondTokenTypeModel();
			
			EchallanLocator echallanStub = new EchallanLocator();
			Echallan_DS eChallanDs= new Echallan_DS();  

			tokenModel.setSecondTokenPK(secondTokenPK);
			tokenModel.setPresenter_name(this.presenter_name);
			//tokenModel.setFirst_party_executant_name(this.first_party_executant_name);
			tokenModel.setFirst_party_executant_name(this.presenter_name);
			tokenModel.setFirst_party_executant_capacity(this.first_party_executant_capacity);
			tokenModel.setDistrict_id(Integer.parseInt(this.district_id));
			tokenModel.setDsr_location_desc(this.dsr_location_desc);
			tokenModel.setDeed_category_id(Integer.parseInt(this.deed_category_id));//
			//tokenModel.setDeed_type_id(Integer.parseInt(deed_type_id));
			tokenModel.setDeed_type_id(Integer.parseInt(deed_type_id_array[0]));
			
			//tokenModel.setPresenter_fh_rel(this.relativeType);
			//tokenModel.setPresenter_phone_no(this.presenterMobileNo);
			//tokenModel.setPresenter_email_id(this.presentereMailId);
			
			log.fatal("this.relativeType="+this.relativeType+",this.presenterMobileNo="+this.presenterMobileNo+",this.presentereMailId"+this.presentereMailId);
			log.fatal("this.relativeName="+this.relativeName+",this.presenterAddress="+this.presenterAddress+",this.presenterState="+this.presenterState+",this.presenterPinCode="+this.presenterPinCode);
			
			provisionalTokenTypeModel provisModel = new provisionalTokenTypeModel();
			
			provisModel.setToken_no(this.token_no);
			provisModel.setToken_date(sdf.parse(sdf.format(firstTokenDate)));
			provisModel.setDsr_location(Integer.parseInt(this.dsr_location));

			provisModel.setPresenter_name(this.presenter_name);
			provisModel.setPresenter_fh_rel(relativeType);
			provisModel.setPresenter_fh_name(relativeName);
			provisModel.setPresenter_address(presenterAddress);
			log.fatal("presenterName.....insertFirstToken Insert="+this.presenter_name);
			provisModel.setPresenter_state(Integer.parseInt(presenterState));
			provisModel.setPresenter_pin((presenterPinCode.trim().length()>0?Integer.parseInt(presenterPinCode):0));
			provisModel.setDistrict_id(Integer.parseInt(district_id));
			provisModel.setDsr_location(Integer.parseInt(dsr_location));
			provisModel.setDsr_location_desc(locationName);
			provisModel.setToken_date(sdf.parse(sdf.format(currentDateValue)));
			provisModel.setToken_time(sdf2.parse(sdf2.format(currentDateValue)));
			provisModel.setTime_slot(sdf1.format(currentDateValue).equals("PM") ? "AFTER NOON" : "FORE NOON");
			provisModel.setLang_code(Integer.parseInt(language));
			log.fatal("language.....insertFirstToken Insert="+language);
			provisModel.setToken_status(tokenStatus);
			log.fatal("tokenStatus.....insertFirstToken Insert="+tokenStatus);
			provisModel.setCreated_by(Integer.parseInt(empID));
			log.fatal("empID.....insertFirstToken Insert="+empID);
			provisModel.setCreated_date(currentDateValue);
			provisModel.setUpdated_by(Integer.parseInt(empID));
			provisModel.setUpdated_date(currentDateValue);
			provisModel.setParty_type(party_type);
			log.fatal("party_type.....insertFirstToken Insert="+party_type);
			provisModel.setDeed_type(Integer.parseInt(deed_type_id_array[0]));
			provisModel.setBook_no(Integer.parseInt(bookID));
			provisModel.setPresenter_email_id(presentereMailId);
			provisModel.setPresenter_phone_no(presenterMobileNo);
			provisModel.setOriginal_deed_total_page_no(Integer.parseInt(this.total_page_no));
			log.fatal("token_no=="+token_no+"<<<");

			tokenModel.setTreasury_stamp_page_no(this.treasury_stamp_page_no.trim().length() > 0 ? Integer
					.parseInt(this.treasury_stamp_page_no) : 0);
			
			String eResponseCode;
			String cerificateStatus;
			
			CommonOptionsVO optionVO = null;// = new CommonOptionsVO(String abc, String def);
			
			if (this.stamp_pages_no.trim().length() == 0) 
				this.stamp_pages_no = "0";
			else if (this.stamp_pages_no.trim().length() > 0)
				this.setStamp_pages_no(String.valueOf(Integer.parseInt(this.stamp_pages_no) + eStampCount));

			log.fatal("eStampCount " + this.getStamp_pages_no());

			tokenModel.setStamp_type(this.stamp_type);
			tokenModel.setStamp_pages_no(this.stamp_pages_no.trim().length() > 0 ? Integer.parseInt(this.stamp_pages_no) : 0);
			tokenModel.setStamp_no_with_val(stampNoValue);
			tokenModel.setTotal_stamp_value(new BigDecimal(this.total_stamp_value));

			tokenModel.setOriginal_deed_total_page_no(Integer.parseInt(this.total_page_no));

			tokenModel.setE_registration_id(this.e_registration_id);

			if (deed_type_id_array[1].trim().startsWith("t")) {
				tokenModel.setConsidered_amount(new BigDecimal(this.considered_amount));
			} else if (deed_type_id_array[1].trim().startsWith("f")) {
				tokenModel.setConsidered_amount(new BigDecimal("0"));
			}
			/*if (deed_type_data.startsWith("t")) {
				tokenModel.setConsidered_amount(new BigDecimal(this.considered_amount));
			} else if (deed_type_data.startsWith("f")) {
				tokenModel.setConsidered_amount(new BigDecimal("0"));
			}*/

			tokenModel.setDue_amount(new BigDecimal(Double.parseDouble(this.dealing_amount) - Double.parseDouble(this.paid_amount)));
			tokenModel.setPaid_amount(new BigDecimal(this.paid_amount));
			tokenModel.setLang_code(Integer.parseInt(language));
			tokenModel.setDeal_amount(new BigDecimal(this.dealing_amount));
			tokenModel.setToken_status("global_p");
			tokenModel.setCreated_by(Integer.parseInt(empID));
			tokenModel.setUpdated_by(Integer.parseInt(empID));
			tokenModel.setAa_rent(new BigDecimal(this.aa_rent));
			tokenModel.setPremium_amount(new BigDecimal(this.premium_amount));
			tokenModel.setCost_of_building(new BigDecimal(this.cost_of_building));

			tokenModel.setChalan_page_count(0);
			tokenModel.setChalan_amount(new BigDecimal(0));
			
			tokenModel.setExtra_stamp_type("");
			tokenModel.setExtra_stamp_count(0);

			log.fatal("this.t_cp_permission ="+ this.t_cp_permission + " this.property_permission = " + this.property_permission);
			
			
			tokenModel.setT_cp_permission(this.t_cp_permission);
			tokenModel.setT_cp_no(this.t_cp_no!=null?this.t_cp_no:" ");
			tokenModel.setT_cp_date(sdf4.parse(this.t_cp_date.trim().length()>0?this.t_cp_date:"00/00/0000"));
			
			tokenModel.setProperty_permission(this.property_permission);
			tokenModel.setProperty_permission_date(sdf4.parse(this.property_permission_date.trim().length()>0?this.property_permission_date:"00/00/0000"));
			tokenModel.setProperty_permission_no(this.property_permission_no!=null?this.property_permission_no:" ");
			
			
			tokenModel.setRda_permission(this.rda_permission);
			tokenModel.setRda_permission_date(sdf4.parse(this.rda_permission_date.trim().length()>0?this.rda_permission_date:"00/00/0000"));
			tokenModel.setRda_permission_no(this.rda_permission_no!=null?this.rda_permission_no:" ");
			
			List<CommonThriceOptionsVO> eStampList = datafromScreen
					.getAllDataForIssueSecondToken(request, this.rowNumber);
			
	        oldDeedDetailPKModel oldDeedDetailModel = new oldDeedDetailPKModel();
			
			oldDeedDetailModel oldDeedModel = new oldDeedDetailModel();
			if((this.old_deed_no!=null)&&(this.old_deed_no.trim().length()>0)){
				
				
				oldDeedDetailModel.setToken_no(Integer.parseInt(this.token_no));
				oldDeedDetailModel
						.setToken_date(sdf.parse(sdf.format(firstTokenDate)));
				oldDeedDetailModel.setDsr_location(Integer.parseInt(this.dsr_location));
			
				oldDeedModel.setOldDeedDetailPK(oldDeedDetailModel);
				oldDeedModel.setOld_deed_no(this.old_deed_no);
				oldDeedModel.setOld_receipt_no(this.old_receipt_no);
				oldDeedModel.setOld_registration_fee(this.old_registration_fee.trim().length()>0?new BigDecimal(this.old_registration_fee):new BigDecimal(0));
				oldDeedModel.setOld_stamp_fee(this.old_stamp_fee.trim().length()>0?new BigDecimal(this.old_stamp_fee):new BigDecimal(0));
				oldDeedModel.setOld_deed_date(sdf4.parse(this.old_deed_date));
			}
			
			
			

			insertOperationMessage = insertOperation.insertSecondToken(
					tokenModel, this.token_no, this.dsr_location,
					this.firstTokenDate, this.token_no, eStampList,oldDeedModel,this.e_registration_id,memofileUpload,nakshafileUpload,
					propertymemofileUpload,propertynakshafileUpload,rdamemofileUpload,rdanakshafileUpload,uploadDoc,provisModel);//,fileUpload
			String dummyTokenNo[] = insertOperationMessage.split("-");

			if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("1")) {

				String Sqlresult = manager
						.searchNavigationForPropertyStructure(
								Integer.parseInt(language),
								Integer.parseInt(dsr_location),
								this.firstTokenDate, "PROPERTY_DETAIL",
								dummyTokenNo[1].trim());
				log.fatal("Sqlresult " + Sqlresult);

				if ((Sqlresult != null) && (Sqlresult.trim().length() > 0)
						&& (!Sqlresult.trim().equalsIgnoreCase("null"))) {
					this.setDummyNavigationFlag(true);
					log.fatal("I am here");
				} else{
					this.setDummyNavigationFlag(false);
				}

				log.fatal("dummyNavigationFlag1 " + dummyNavigationFlag);

				this.setDummyDistrictID(this.district_id);
				this.setDummyDsrLocation(this.dsr_location);
				this.setDummyTokenNo(dummyTokenNo[1]);
				this.setDummyTokenDate(this.firstTokenDate);
				//this.setDummyDeedID(deed_type_id);
				this.setDummyDeedID(deed_type_id_array[0]);
				//this.setDummyFirstPartyName(this.first_party_executant_name);
				this.setDummyFirstPartyName(this.presenter_name);

				this.setDummyPresenterName(this.presenter_name);
				this.setDummyFirstPartyExecutantCapacity(this.first_party_executant_capacity);
				this.setDummyDeedCategoryId(this.deed_category_id);
				
				if (deed_type_id_array[1].trim().startsWith("t")) {
					this.setDummyConsideredAmount(this.considered_amount);
				} else if (deed_type_id_array[1].trim().startsWith("f")) {
					this.setDummyConsideredAmount("0");
				}
				
				/*if (deed_type_data.startsWith("t")) {
					this.setDummyConsideredAmount(this.considered_amount);
				} else if (deed_type_data.startsWith("f")) {
					this.setDummyConsideredAmount("0");
				}*/
				
				//this.setDummyERegistrationId(this.e_registration_id);
				this.setDummyStampNoWithVal(stampNoValue);
				this.setDummyOriginalDeedTotalPageNo(this.total_page_no);
				this.setDummyTotalStampValue(this.total_stamp_value);
				this.setDummyAa_rent(this.aa_rent);
				this.setDummyCost_of_building(this.cost_of_building);
				this.setDummyPremium_amount(this.premium_amount);
                this.setDummytcppermission(this.t_cp_permission);
                this.setDummypropertypermission(this.property_permission);
                this.setDummyrdapermission(this.rda_permission);
				this.setPrintFlag(true);
				operationFlag = true;
			}

			else if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("0")) {
				operationFlag = false;
			}

			
			returnMessage = insertOperationMessage.substring(1,insertOperationMessage.trim().length());
			if(operationFlag)
				messageValue= insertOperationMessage.substring(1,insertOperationMessage.trim().length());
			}
			else {
				operationFlag=false;
				returnMessage="Total No. of Pages and Uploaded PDF file Page Count Mismatch, Page Count Should be "+(count)/2+" and Input Page count is "+this.total_page_no;
                 
			}
			
			
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		if (operationFlag) {
			this.emptyField();
			// this.addActionMessage(returnMessage);
        	
        	//helper.sendSMS(presenterMobileNo, "Aapka Pre-Reg. Application ID("+token_no+") hai.");
        	
        	log.fatal("Aapka Pre-Reg. Application ID("+token_no+") hai.");
			
			return "success";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}

	}

	@SkipValidation
	public String exitSecondToken() throws Exception {
		return "home";
	}

	public void validate() {
		try {
			
			first_party_executant_name = presenter_name;

			this.setEdit(false);
			this.execute();
			String deed_type_id_array[] = deed_type_id.split("-");
			log.fatal("deed_category_id=" + deed_category_id + ", deed_type_id " + deed_type_id+",deed_type_id_array[0]="+deed_type_id_array[0]);
			deedCategoryModel deedCategoryModel = manager
					.searchSingleRowDeedCategory(Integer.parseInt(language),
							Integer.parseInt(deed_category_id));

			log.fatal("Data Validation....."+first_party_executant_capacity);
			
			
			if ((empID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));

			}/* else if (!validator.requiredFiledValidate(token_no.trim())) {
				this.addFieldError("token_no", "Token No can't be empty");

			}*/ else if (!validator.requiredFiledValidateSecondToken(presenter_name.trim(),"1469")) {
				this.addFieldError("presenter_name", "Name can't be empty");
			}
			 else if (!validator.requiredFiledValidateSecondToken(deedState.trim(),"1472")) {
					this.addFieldError("deedState", "Deed State can't be empty");
			}

			else if (!validator.languageValidate(presenter_name.trim(),
					this.language)) {
				this.addFieldError("presenter_name",
						"Pl. Input in Proper Language");

			} else if (!validator.validateNameField(presenter_name.trim(),
					this.language)) {
				this.addFieldError("presenter_name",
						"Presenter Name is not valid");

			} else if (!validator
					.requiredFiledValidateSecondToken(first_party_executant_name.trim(),"1487")) {
				this.addFieldError("first_party_executant_name",
						"First Party/Executant Name can't be empty");
			} else if (!validator.languageValidate(
					first_party_executant_name.trim(), this.language)) {
				this.addFieldError("first_party_executant_name",
						"Pl. Input in Proper Language");

			} else if (!validator.validateNameField(
					first_party_executant_name.trim(), this.language)) {
				this.addFieldError("first_party_executant_name",
						"First Party/Executant Name is not valid");
			}/*

			else if (!validator
					.requiredFiledValidate(first_party_executant_capacity
							.trim())) {
				this.addFieldError("first_party_executant_capacity",
						"Capacity can't be empty");
			}*/

			else if ((deedCategoryModel.isStamp_val_required())
					&& (!validator.requiredFiledValidate(stamp_type.trim()))) {
				this.addFieldError("stamp_type", "Stamp Type can't be empty");
			}

			else if ((deedCategoryModel.isStamp_val_required())
					&& (!validator.requiredFiledValidate(total_stamp_value
							.trim()))) {
				this.addFieldError("total_stamp_value",
						"Total Stamp Value can't be empty");
			}

			else if ((deedCategoryModel.isStamp_val_required())
					&& (!validator.amountFiledValidate(total_stamp_value))) {
				this.addFieldError("total_stamp_value",
						"Total Stamp Value is not Valid");
			}
			

			else if ((stamp_type.trim().equals("global_estamp"))
					&& (Integer.parseInt(stamp_pages_no) > 2)) {
				this.addFieldError("stamp_pages_no",
						"In case of e-Stamp, No. of page is maxmum 2");
			}
			
			
			
			
			else if(((stamp_type.trim().equals("global-treasurystamp"))
				||(stamp_type.trim().equals("global-estamp-treasurystamp")))
				&&(!validator.requiredFiledValidate(treasury_stamp_page_no.trim())))
					
					{
				this.addFieldError("treasury_stamp_page_no",
						"Treasury Stamp Page No can't be empty");
			}
			
			else if(((stamp_type.trim().equals("global-treasurystamp"))
					||(stamp_type.trim().equals("global-estamp-treasurystamp")))
					&&(!validator.validateIntegerField(String.valueOf(treasury_stamp_page_no.trim()))))
						
						{
					this.addFieldError("treasury_stamp_page_no",
							"Treasury Stamp Page No is not valid");
				}
				
			
			

			else if (!validator.requiredFiledValidate(total_page_no.trim())) {
				this.addFieldError("total_page_no", "Total Page can't be empty");
			} else if (!validator.validateIntegerField(String.valueOf(
					total_page_no).trim())) {
				this.addFieldError("total_page_no", "Total Page is not Valid");
				}
			
			
			
			else if(((this.stamp_pages_no.trim().length()>0?Integer.parseInt(this.stamp_pages_no.trim()):0)
					+(this.treasury_stamp_page_no.trim().length()>0?Integer.parseInt(this.treasury_stamp_page_no.trim()):0))
			         >Integer.parseInt(total_page_no)){
				
				this.addFieldError("total_page_no", "Total Page No. Can't be less than Stamp Page No");
			}

			else if ((!deed_type_id_array[0].trim().equalsIgnoreCase("74"))
					&&(!deed_type_id_array[0].trim().equalsIgnoreCase("153"))
					&& (deed_type_id_array[1].trim().startsWith("t"))
					&& (!validator.requiredFiledValidate(considered_amount
							.trim()))) {
				this.addFieldError("considered_amount",
						"Considered Amount can't be empty");
			} else if ((!deed_type_id_array[0].trim().equalsIgnoreCase("74"))
					&&(!deed_type_id_array[0].trim().equalsIgnoreCase("153"))
					&& (deed_type_id_array[1].trim().startsWith("t"))
					&& (!validator.amountFiledValidate(String.valueOf(
							considered_amount).trim()))) {
				this.addFieldError("considered_amount",
						"Considered Amount is not Valid");

			} else if ((!deed_type_id_array[0].trim().equalsIgnoreCase("74"))
					&&(!deed_type_id_array[0].trim().equalsIgnoreCase("153"))
					&& (!validator.requiredFiledValidate(dealing_amount.trim()))) {
				this.addFieldError("dealing_amount",
						"Deal Amount can't be empty");
			} else if ((!deed_type_id_array[0].trim().equalsIgnoreCase("74"))
					&&(!deed_type_id_array[0].trim().equalsIgnoreCase("153"))
					&& (!validator.amountFiledValidate(String.valueOf(
							dealing_amount).trim()))) {
				this.addFieldError("dealing_amount", "Deal Amount is not Valid");

			} else if ((!deed_type_id_array[0].trim().equalsIgnoreCase("74"))
					&&(!deed_type_id_array[0].trim().equalsIgnoreCase("153"))
					&& (Float.parseFloat(paid_amount) > Float
							.parseFloat(dealing_amount))) {
				this.addFieldError("paid_amount",
						"Paid Amount can't greater than Deal Amount");
			}

			else if ((!deed_type_id_array[0].trim().equalsIgnoreCase("74"))
					&&(!deed_type_id_array[0].trim().equalsIgnoreCase("153"))
					&& (!validator.requiredFiledValidate(paid_amount.trim()))) {
				this.addFieldError("paid_amount", "Paid Amount can't be empty");
			}

			else if ((!deed_type_id_array[0].trim().equalsIgnoreCase("74"))
					&&(!deed_type_id_array[0].trim().equalsIgnoreCase("153"))
					&& (!validator.amountFiledValidate(String.valueOf(
							paid_amount).trim()))) {
				this.addFieldError("paid_amount", "Paid Amount is not Valid");
			}

			else if ( ((deed_type_id_array[0].trim().equalsIgnoreCase("74"))||
					(deed_type_id_array[0].trim().equalsIgnoreCase("153")))
					&& (!validator.requiredFiledValidate(aa_rent.trim()))) {
				this.addFieldError("aa_rent", "Annual Area Rent can't be empty");
			}

			else if ( ((deed_type_id_array[0].trim().equalsIgnoreCase("74"))||
					(deed_type_id_array[0].trim().equalsIgnoreCase("153")))
					&& (!validator.amountFiledValidate(String.valueOf(aa_rent)
							.trim()))) {
				this.addFieldError("aa_rent", "Annual Area Rent is not Valid");
			}

			else if( ((deed_type_id_array[0].trim().equalsIgnoreCase("74"))||
					(deed_type_id_array[0].trim().equalsIgnoreCase("153")))
					&& (!validator.requiredFiledValidate(premium_amount.trim()))) {
				this.addFieldError("premium_amount",
						"Premium Amount can't be empty");
			}

			else if( ((deed_type_id_array[0].trim().equalsIgnoreCase("74"))||
					(deed_type_id_array[0].trim().equalsIgnoreCase("153")))
					&& (!validator.amountFiledValidate(String.valueOf(
							premium_amount).trim()))) {
				this.addFieldError("premium_amount",
						"Premium Amount is not Valid");
			}

			else if ( ((deed_type_id_array[0].trim().equalsIgnoreCase("74"))||
					(deed_type_id_array[0].trim().equalsIgnoreCase("153")))
					&& (!validator.requiredFiledValidate(cost_of_building
							.trim()))) {
				this.addFieldError("cost_of_building",
						"Cost of Building  can't be empty");
			}

			else if ( ((deed_type_id_array[0].trim().equalsIgnoreCase("74"))||
					(deed_type_id_array[0].trim().equalsIgnoreCase("153")))
					&& (!validator.amountFiledValidate(String.valueOf(
							cost_of_building).trim()))) {
				this.addFieldError("cost_of_building",
						"Cost of Building  is not Valid");
			}

			/*============================*/
			/*
			else if ((!deed_type_id.equalsIgnoreCase("74"))
					&&(!deed_type_id.equalsIgnoreCase("153"))
					&& (deed_type_data.startsWith("t"))
					&& (!validator.requiredFiledValidate(considered_amount
							.trim()))) {
				this.addFieldError("considered_amount",
						"Considered Amount can't be empty");
			} else if ((!deed_type_id.equalsIgnoreCase("74"))
					&&(!deed_type_id.equalsIgnoreCase("153"))
					&& (deed_type_data.startsWith("t"))
					&& (!validator.amountFiledValidate(String.valueOf(
							considered_amount).trim()))) {
				this.addFieldError("considered_amount",
						"Considered Amount is not Valid");

			} else if ((!deed_type_id.equalsIgnoreCase("74"))
					&&(!deed_type_id.equalsIgnoreCase("153"))
					&& (!validator.requiredFiledValidate(dealing_amount.trim()))) {
				this.addFieldError("dealing_amount",
						"Deal Amount can't be empty");
			} else if ((!deed_type_id.equalsIgnoreCase("74"))
					&&(!deed_type_id.equalsIgnoreCase("153"))
					&& (!validator.amountFiledValidate(String.valueOf(dealing_amount).trim()))) {
				this.addFieldError("dealing_amount", "Deal Amount is not Valid");

			} else if ((!deed_type_id.equalsIgnoreCase("74"))
					&&(!deed_type_id.equalsIgnoreCase("153"))
					&& (Float.parseFloat(paid_amount) > Float.parseFloat(dealing_amount))) {
				this.addFieldError("paid_amount",
						"Paid Amount can't greater than Deal Amount");
			}

			else if ((!deed_type_id.equalsIgnoreCase("74"))
					&&(!deed_type_id.equalsIgnoreCase("153"))
					&& (!validator.requiredFiledValidate(paid_amount.trim()))) {
				this.addFieldError("paid_amount", "Paid Amount can't be empty");
			}

			else if ((!deed_type_id.equalsIgnoreCase("74"))
					&&(!deed_type_id.equalsIgnoreCase("153"))
					&& (!validator.amountFiledValidate(String.valueOf(
							paid_amount).trim()))) {
				this.addFieldError("paid_amount", "Paid Amount is not Valid");
			}

			else if ( ((deed_type_id.equalsIgnoreCase("74"))||
					(deed_type_id.equalsIgnoreCase("153")))
					&& (!validator.requiredFiledValidate(aa_rent.trim()))) {
				this.addFieldError("aa_rent", "Annual Area Rent can't be empty");
			}

			else if ( ((deed_type_id.equalsIgnoreCase("74"))||
					(deed_type_id.equalsIgnoreCase("153")))
					&& (!validator.amountFiledValidate(String.valueOf(aa_rent)
							.trim()))) {
				this.addFieldError("aa_rent", "Annual Area Rent is not Valid");
			}

			else if( ((deed_type_id.equalsIgnoreCase("74"))||
					(deed_type_id.equalsIgnoreCase("153")))
					&& (!validator.requiredFiledValidate(premium_amount.trim()))) {
				this.addFieldError("premium_amount",
						"Premium Amount can't be empty");
			}

			else if( ((deed_type_id.equalsIgnoreCase("74"))||
					(deed_type_id.equalsIgnoreCase("153")))
					&& (!validator.amountFiledValidate(String.valueOf(
							premium_amount).trim()))) {
				this.addFieldError("premium_amount",
						"Premium Amount is not Valid");
			}

			else if ( ((deed_type_id.equalsIgnoreCase("74"))||
					(deed_type_id.equalsIgnoreCase("153")))
					&& (!validator.requiredFiledValidate(cost_of_building
							.trim()))) {
				this.addFieldError("cost_of_building",
						"Cost of Building  can't be empty");
			}

			else if ( ((deed_type_id.equalsIgnoreCase("74"))||
					(deed_type_id.equalsIgnoreCase("153")))
					&& (!validator.amountFiledValidate(String.valueOf(
							cost_of_building).trim()))) {
				this.addFieldError("cost_of_building",
						"Cost of Building  is not Valid");
			}*/
			
			/*=========================*/

			/*else if (!validator.requiredFiledValidate(e_registration_id.trim())) {
				this.addFieldError("e_registration_id",
						"e-Registration ID can't be empty");
			}*/

			else if (!validator.requiredFiledValidate(deed_category_id.trim())) {
				this.addFieldError("deed_category_id",
						"Deed Category can't be empty");
			}

			else if (!validator.requiredFiledValidate(deed_type_id.trim())) {
				this.addFieldError("deed_type_id", "Deed Type can't be empty");
			}
			
			
			/*else if (!validator.requiredFiledValidate(this.input_form.trim())) {
				this.addFieldError("input_form", "Input Form can't be empty");
			}
			
			else if (!validator.requiredFiledValidate(this.complete_document.trim())) {
				this.addFieldError("complete_document", "Complete Document can't be empty");
			}
			
			else if (!this.input_form.equalsIgnoreCase("true")) {
				this.addFieldError("input_form", "Input Form should be received");
			}
			
			else if (!this.complete_document.equalsIgnoreCase("true")) {
				this.addFieldError("complete_document", "Complete Document should be received");
			}
			
			else if ((fileUpload == null)
					|| (fileUpload.toString().trim().length() == 0)) {
				this.addFieldError("fileUpload", "Input Form is required for Upload");
			}*/
			
			
			else if((old_deed_no!=null)&&(old_deed_no.trim().length()>0)&&
					(!validator.requiredFiledValidate(old_deed_date))){
				this.addActionError("Old Deed Date is required ");
				}
			
			else if((old_deed_date!=null)&&(old_deed_date.trim().length()>0)&&
					(!validator.dateFormate(old_deed_date))){
				this.addActionError("Old Deed Date is not valid ");
				}
			
			else if((old_deed_no!=null)&&(old_deed_no.trim().length()>0)&&
					(!validator.requiredFiledValidate(old_registration_fee))){
				this.addActionError("Old Registration Fee is required ");
				}
			
			else if((old_deed_no!=null)&&(old_deed_no.trim().length()>0)&&
					(!validator.requiredFiledValidate(old_receipt_no))){
				this.addActionError("Old Receipt No. is required ");
				}
			
			else if((old_deed_no!=null)&&(old_deed_no.trim().length()>0)&&
					(!validator.requiredFiledValidate(old_stamp_fee))){
				this.addActionError("Old Stamp Fee is required ");
				}
			
			else if((old_deed_no!=null)&&(old_deed_no.trim().length()>0)&&
					(!validator.amountFiledValidate(old_registration_fee))){
				this.addActionError("Old Registration Fee is not valid ");
				}
			
			else if((old_deed_no!=null)&&(old_deed_no.trim().length()>0)&&
					(!validator.amountFiledValidate(old_stamp_fee))){
				this.addActionError("Old Stamp Fee is not valid ");
				}
	
			

			else if ((!deed_type_id_array[0].trim().equalsIgnoreCase("70"))
					&& (!validator.requiredFiledValidate(t_cp_permission.trim()))) {
				this.addFieldError("t_cp_permission",
						"T&amp;CP permission can't be empty");
			}
			/*else if ((!deed_type_id.equalsIgnoreCase("70"))
					&& (!validator.requiredFiledValidate(t_cp_permission.trim()))) {
				this.addFieldError("t_cp_permission","T&amp;CP permission can't be empty");
			}*/
           
			else if (((t_cp_permission.toString().equalsIgnoreCase("true"))
					&& (!validator.requiredFiledValidate(t_cp_no.trim())))) {
				this.addFieldError("t_cp_no",
						"T&amp;CP no can't be empty");
			}
			
			else if (((t_cp_permission.toString().equalsIgnoreCase("true"))
					&& (!validator.requiredFiledValidate(t_cp_date.trim())))) {
				this.addFieldError("t_cp_date",
						"T&amp;CP date can't be empty");
			}
			
			else if (((t_cp_permission.toString().equalsIgnoreCase("true"))
					&& ((memofileUpload == null)
							|| (memofileUpload.toString().trim().length() == 0)))) {
				this.addFieldError("memofileUpload",
						"memofileUpload can't be empty");
			}
			else if (((t_cp_permission.toString().equalsIgnoreCase("true"))
					&& ((nakshafileUpload == null)
							|| (nakshafileUpload.toString().trim().length() == 0)))) {
				this.addFieldError("nakshafileUpload",
						"nakshafileUpload can't be empty");
			}
			
			else if((t_cp_date!=null)&&(t_cp_date.trim().length()>0)&&
					(!validator.dateFormate(t_cp_date))){
				this.addActionError("t&cp date is not valid ");
				}

			else if (((rda_permission.toString().equalsIgnoreCase("true"))
					&& (!validator.requiredFiledValidate(rda_permission_no.trim())))) {
				this.addFieldError("rda_permission_no",
						"RDA permission no can't be empty");
			}
			
			else if (((rda_permission.toString().equalsIgnoreCase("true"))
					&& (!validator.requiredFiledValidate(rda_permission_date.trim())))) {
				this.addFieldError("rda_permission_date",
						"RDA permission date can't be empty");
			}
			
			else if (((rda_permission.toString().equalsIgnoreCase("true"))
					&& ((rdamemofileUpload == null)
							|| (rdamemofileUpload.toString().trim().length() == 0)))) {
				this.addFieldError("rdamemofileUpload",
						"rdamemofileUpload can't be empty");
			}
			else if (((rda_permission.toString().equalsIgnoreCase("true"))
					&& ((rdanakshafileUpload == null)
							|| (rdanakshafileUpload.toString().trim().length() == 0)))) {
				this.addFieldError("rdanakshafileUpload",
						"rdanakshafileUpload can't be empty");
			}
			
			else if((rda_permission.toString().equalsIgnoreCase("true"))&&(rda_permission_date.trim().length()>0)&&
					(!validator.dateFormate(rda_permission_date))){
				this.addActionError("RDA permission date is not valid ");
				}
			
			
			
			
			else if (((property_permission.toString().equalsIgnoreCase("true"))
					&& (!validator.requiredFiledValidate(property_permission_no.trim())))) {
				this.addFieldError("property_permission_no",
						"Property permission no can't be empty");
			}
			
			else if (((property_permission.toString().equalsIgnoreCase("true"))
					&& (!validator.requiredFiledValidate(property_permission_date.trim())))) {
				this.addFieldError("property_permission_date",
						"Property permission date can't be empty");
			}
			
			else if (((property_permission.toString().equalsIgnoreCase("true"))
					&& ((propertymemofileUpload == null)
							|| (propertymemofileUpload.toString().trim().length() == 0)))) {
				this.addFieldError("propertymemofileUpload",
						"propertymemofileUpload can't be empty");
			}
			else if (((property_permission.toString().equalsIgnoreCase("true"))
					&& ((propertynakshafileUpload == null)
							|| (propertynakshafileUpload.toString().trim().length() == 0)))) {
				this.addFieldError("propertynakshafileUpload",
						"propertynakshafileUpload can't be empty");
			}
			
			else if((property_permission.toString().equalsIgnoreCase("true"))&&(property_permission_date.trim().length()>0)&&
					(!validator.dateFormate(property_permission_date))){
				this.addActionError("property permission date is not valid ");
				}

				
				
				
				
				

			else if ((deedCategoryModel.isStamp_val_required())
					&& ((this.stamp_type
							.equalsIgnoreCase("global-estamp"))
						||(this.stamp_type
								.equalsIgnoreCase("global-estamp-treasurystamp")))	
					&& ((rowNumber == null)
							|| (!validator.validateIntegerField(String
									.valueOf(rowNumber))) || (Integer
							.parseInt(rowNumber) <= 0))) {
				this.addActionError("e-Stamp No and e-Stamp Value can't be empty ");
			}
			
			else if ((deedCategoryModel.isStamp_val_required())
					&& (this.stamp_type
							.equalsIgnoreCase("global-chalan"))	
					&& ((rowNumber == null)
							|| (!validator.validateIntegerField(String
									.valueOf(rowNumber))) || (Integer
							.parseInt(rowNumber) <= 0))) {
				this.addActionError("Chalan No and Chalan Value can't be empty ");
			}

			else if((this.stamp_type
					.equalsIgnoreCase("global-estamp"))
					||(this.stamp_type
							.equalsIgnoreCase("global-estamp-treasurystamp")))
					{
				List<CommonThriceOptionsVO> partyName = datafromScreen
						.getAllDataForIssueSecondToken(request, this.rowNumber);
				ListIterator<CommonThriceOptionsVO> listItr = partyName
						.listIterator();
				int counter = 0;
				
				
				if (partyName != null && partyName.size()>0){
			
				
				while (listItr.hasNext()) {
					CommonThriceOptionsVO optionVO = (CommonThriceOptionsVO) listItr
							.next();
					if ((deedCategoryModel.isStamp_val_required())
							&& (!this.stamp_type
									.equalsIgnoreCase("global-treasurystamp"))
							&& (!validator.requiredFiledValidate(optionVO
									.getTypeCode().trim()))) {
						this.addActionError("Stamp No. Can't be empty");
						break;
					} else if ((deedCategoryModel.isStamp_val_required())
							&& (!this.stamp_type
									.equalsIgnoreCase("global-treasurystamp"))
							&& (!validator.languageValidate(
									optionVO.getTypeCode(), "1"))) {
						this.addActionError("Pl. Input Stamp No. in English Language");
						break;
					} else if ((deedCategoryModel.isStamp_val_required())
							&& (!this.stamp_type
									.equalsIgnoreCase("global-treasurystamp"))
							&& (!validator.requiredFiledValidate(optionVO
									.getTypeDesc().trim()))) {
						this.addActionError("Stamp Value Can't be empty");
						break;
					} else if ((deedCategoryModel.isStamp_val_required())
							&& (!this.stamp_type
									.equalsIgnoreCase("global-treasurystamp"))
							&& (!validator.amountFiledValidate(optionVO
									.getTypeDesc().trim()))) {
						this.addActionError("Stamp Value is not valid");
						break;
					} else if ((deedCategoryModel.isStamp_val_required())
							&& (!this.stamp_type
									.equalsIgnoreCase("global-treasurystamp"))
							&& (!validator.languageValidate(
									optionVO.getTypeDesc(), "1"))) {
						this.addActionError("Pl. Input Stamp Value in English Language");
						break;

					} else if ((deedCategoryModel.isStamp_val_required())
							&& (!this.stamp_type
									.equalsIgnoreCase("global-treasurystamp"))
							&& (!validator.requiredFiledValidate(optionVO
									.getTypeCodeDesc().trim()))) {
						this.addActionError("Stamp Date is Required");
						break;

					} else if ((deedCategoryModel.isStamp_val_required())
							&& (!this.stamp_type
									.equalsIgnoreCase("global-treasurystamp"))
							&& (!validator.dateFormate(optionVO
									.getTypeCodeDesc().trim()))) {
						this.addActionError("Stamp Date is not Valid");
						break;

					}

					else if (optionVO.getTypeCodeDesc().trim().equalsIgnoreCase("global-estamp")) {
						counter += 1;
					}

				}
				}
				else if ((partyName == null || partyName.size()==0) && (!this.stamp_type.equalsIgnoreCase("global-treasurystamp")) )					
			    {
					
					this.addActionError("E-Stamp Details Required");
				}

				}

			log.fatal("Validation Complete");

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));

		}
	}

	@SkipValidation
	public void LoadInitialStampNoValueList() throws Exception {
		try {
			if (stampNoValueList.isEmpty()) {
				CommonThriceOptionsVO option = new CommonThriceOptionsVO("",
						"", "");
				stampNoValueList.add(option);

			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
	}

	@SkipValidation
	public String loadStampNoValue() throws Exception {
		if ((stamp_pages_no != null) && (stamp_pages_no.trim().length() > 0)
				&& (Integer.parseInt(stamp_pages_no) > 0)) {
			try {

				this.rowNumber = stamp_pages_no;
			} catch (Exception e) {
				log.fatal(helper.writeLogInUpperCase(e));
				throw new Exception(getText("global.system.error"));
			}
		}
		return SUCCESS;
	}

	@SkipValidation
	public String loadStampNoValueFromScreen() throws Exception {

		try {
			if ((rowNumber != null)
					&& (validator.neumericFiledValidate(String
							.valueOf(rowNumber)))
					&& (Integer.parseInt(rowNumber) > 0)) {

				List<CommonThriceOptionsVO> partyName = datafromScreen
						.getAllDataForIssueSecondToken(request, rowNumber);
				ListIterator<CommonThriceOptionsVO> listItr = partyName
						.listIterator();

				while (listItr.hasNext()) {
					CommonThriceOptionsVO optionVO = (CommonThriceOptionsVO) listItr
							.next();
					CommonThriceOptionsVO optionVO1 = new CommonThriceOptionsVO(
							optionVO.getTypeCode(), optionVO.getTypeDesc(),
							optionVO.getTypeCodeDesc());
					stampNoValueList.add(optionVO1);

				}
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		return SUCCESS;
	}

	@SkipValidation
	public String loadCategory() throws Exception {

		try {
			deedCategoryList = new ArrayList<CommonOptionsVO>();
			if ((this.deed_type_id != null) && (this.deed_type_id.length() > 0)
					&& (this.language != null) && (this.language.length() > 0)) {
				String deed_type_id_array[] = deed_type_id.split("-");
				deedCategoryList = manager.searchDeedCategoryOnDeedType(
						Integer.parseInt(deed_type_id_array[0]),
						Integer.parseInt(language));
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		return SUCCESS;

	}

	@SkipValidation
	public void emptyField() throws Exception {
		try {
			
			//Date currentDateValue = new Date();
		//	String tokenArray[] = this.token_no.split("-");
			
			/*int returnMessage = helper.userLogActin(
					Integer.parseInt(this.token_no), firstTokenDate,
					Integer.parseInt(dsr_location),
					Integer.parseInt(empID), "Issue_Second_Token", "END");
			*/
			
			
			
			
			//this.setToken_no("");
			this.setPresenter_name("");
			this.setFirst_party_executant_name("");
			this.setFirst_party_executant_capacity("");
			this.setDistrict_id("");
			this.setDsr_location("");
			this.setDsr_location_desc("");
			this.setStamp_type("");
			this.setStamp_pages_no("");
			this.setOriginal_deed_total_page_no("");
			//this.setE_registration_id("");
			this.setConsidered_amount("");
			this.setPaid_amount("");
			this.setDue_amount("");
			this.setDealing_amount("");
			this.setDeed_category_id("");
			this.setDeed_type_id("");
			this.setTotal_page_no("");
			this.setTotal_stamp_value("");
			this.setAa_rent("");
			this.setCost_of_building("");
			this.setPremium_amount("");
			this.setTreasury_stamp_page_no("");
			//this.setInput_form("");
			//this.setComplete_document("");
			//this.setFileUpload(null);
			this.setT_cp_date("");
			this.setT_cp_no("");
			this.setT_cp_permission("");
			this.setMemofileUpload(null);
			this.setNakshafileUpload(null);
			this.setProperty_permission_date("");
			this.setProperty_permission_no("");
			this.setPropertymemofileUpload(null);
			this.setPropertynakshafileUpload(null);
			this.setDeedState("");
			
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

	}
}
