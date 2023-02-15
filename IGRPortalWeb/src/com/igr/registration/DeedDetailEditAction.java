package com.igr.registration;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
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
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.deedTypeModel;
import com.igr.hibernate.model.partyDetailModel;
import com.igr.hibernate.model.partyTypeModel;
import com.igr.hibernate.model.structureValuationModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeedDetailEditAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String locationName = "";
	private String districtID = "";
	private String districtName = "";
	private float stampValue = 0f;

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
	private Date token_date;
	private Date token_time;
	private String deed_category_id;
	private String deed_type_id;
	private BigDecimal doc_min_amount;
	private String applicable_stamp_value;
	private String presented_stamp_value;
	private String no_total_pages;
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

	private ServletContext context;
	private HttpServletRequest request;

	private List<CommonOptionsVO> dsrLocationList;
	private List<CommonOptionsVO> districtList;
	private List<CommonOptionsVO> firstPartyCapacityList;
	private List<CommonOptionsVO> deedCategoryList;
	private List<CommonOptionsVO> deedTypeList;

	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");

	private static final Logger log = Logger
			.getLogger(DeedDetailEditAction.class);
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

	public void setConsidered_amount(String considered_amount) {
		this.considered_amount = considered_amount;
	}

	public BigDecimal getDoc_min_amount() {
		return doc_min_amount;
	}

	public void setDoc_min_amount(BigDecimal doc_min_amount) {
		this.doc_min_amount = doc_min_amount;
	}

	public boolean isPrintFlag() {
		return printFlag;
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

	public String getSpecial_deed_detail() {
		return special_deed_detail;
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

	public void setRel_last_reg_pow_of_atr_date(
			String rel_last_reg_pow_of_atr_date) {
		this.rel_last_reg_pow_of_atr_date = rel_last_reg_pow_of_atr_date;
	}

	public String getRel_last_reg_pow_of_atr_reg_no() {
		return rel_last_reg_pow_of_atr_reg_no;
	}

	public void setRel_last_reg_pow_of_atr_reg_no(
			String rel_last_reg_pow_of_atr_reg_no) {
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

	@SkipValidation
	public String execute() throws Exception {
		String returnValue = SUCCESS;

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

		int i = 0;
		BigDecimal propertyValue = new BigDecimal(0);
		BigDecimal structureValue = new BigDecimal(0);
		BigDecimal totalValuationAmount = new BigDecimal(0);
		boolean partyGenderFlag = false;
		String partyType = "";
		int stNispadkCount=0;
		int nonSTclaimantCount=0;

		try {
			List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
			allFirstPartyCapacityList = (List) context
					.getAttribute("GLOBALDROPDOWNLOV");

			/*if ((presented_stamp_value != null)
					&& (presented_stamp_value.length() > 0)
					&& (presented_stamp_value.contains("_"))) {
				if (presented_stamp_value.contains("~")) {
					String value[] = presented_stamp_value.split("~");
					for (i = 0; i < value.length; i++) {
						String allStampValue[] = value[i].split("_");
						stampValue += Float.parseFloat(allStampValue[1]);
					}
				} else if (presented_stamp_value.contains("_")) {
					String allStampValue[] = presented_stamp_value.split("_");
					stampValue += Float.parseFloat(allStampValue[1]);
				}

				this.setPresented_stamp_value(String.valueOf(stampValue));

			}*/
			if (this.presented_stamp_value.trim().length() == 0)
				this.setPresented_stamp_value("0");

			dsrLocationList = new ArrayList();
			CommonOptionsVO optionVO = new CommonOptionsVO(branchCode,
					locationName);
			dsrLocationList.add(optionVO);

			districtList = new ArrayList();
			CommonOptionsVO optionVO1 = new CommonOptionsVO(districtID,
					districtName);
			districtList.add(optionVO1);

			firstPartyCapacityList = new ArrayList<CommonOptionsVO>();
			firstPartyCapacityList = helper.extractParticularFourData(
					first_party_executant_capacity.trim(), this.language,
					allFirstPartyCapacityList);

			deedTypeModel deedModel = manager.searchSingleRowDeedType(
					Integer.parseInt(language), Integer.parseInt(deed_type_id));
			deedTypeList = new ArrayList<CommonOptionsVO>();

			CommonOptionsVO optionVO2 = new CommonOptionsVO(
					String.valueOf(deedModel.getDeed_type_id()),
					deedModel.getDeed_name());
			deedTypeList.add(optionVO2);

			if ((deedModel.getDeed_name().equalsIgnoreCase("Sale Deed"))
					|| (deedModel.getDeed_name()
							.equalsIgnoreCase("à¤¹à¤¸à¥�à¤¤à¤¾à¤‚à¤¤à¤°à¤£ à¤ªà¤¤à¥�à¤° (à¤µà¤¿à¤•à¥�à¤°à¤¯ à¤µà¤¿à¤²à¥‡à¤–)"))) {
				partyType = manager.searchPartyTypeOnDeedID(
						Integer.parseInt(deed_type_id), partyType);

			}

			deedCategoryModel deedCategoryModel = manager
					.searchSingleRowDeedCategory(Integer.parseInt(language),
							Integer.parseInt(deed_category_id));
			log.fatal(" Test " + deed_category_id);

			deedCategoryList = new ArrayList<CommonOptionsVO>();
			CommonOptionsVO optionVO3 = new CommonOptionsVO(
					String.valueOf(deedCategoryModel.getDeed_category_id()),
					deedCategoryModel.getCategory_name());
			deedCategoryList.add(optionVO3);
			
			 if(deed_type_id.trim().equalsIgnoreCase("74")){
				 log.fatal("I am in Lease Deed");
					
					String feeValues =helper.feeValuesForLeaseDeed(token_no, token_date, Integer.parseInt(dsr_location));
					String feeValuesArray[]=feeValues.split("-");
					this.doc_min_amount=new BigDecimal(0);
					this.baseFee =new BigDecimal(feeValuesArray[0]).setScale(0, BigDecimal.ROUND_HALF_UP);
					this.additionalFee =new BigDecimal(feeValuesArray[1]).setScale(0, BigDecimal.ROUND_HALF_UP);
					this.cess = new BigDecimal(feeValuesArray[2]).setScale(0, BigDecimal.ROUND_HALF_UP);
					
					this.setApplicable_stamp_value(String.valueOf((baseFee
							.add(additionalFee)
							.add(cess))));

				}
			 else if(!deed_type_id.trim().equalsIgnoreCase("74"))
				{

			List<structureValuationModel> structureList = new ArrayList<structureValuationModel>();
			List<partyDetailModel> partyList = new ArrayList<partyDetailModel>();

			structureList = manager.getStructureDetails(
					token_no, token_date,
					Integer.parseInt(dsr_location));

			partyList = manager.getPartyDetails(token_no,
					token_date, Integer.parseInt(dsr_location));

			/*List<propertyDetailModel> propertyDetailList = new ArrayList<propertyDetailModel>();

			propertyDetailList = manager.getPropertyDetails(
					Integer.parseInt(token_no), token_date,
					Integer.parseInt(dsr_location));

			ListIterator<propertyDetailModel> listItrProperty = propertyDetailList
					.listIterator();
			while (listItrProperty.hasNext()) {
				propertyDetailModel propertyModel = (propertyDetailModel) listItrProperty
						.next();
				propertyValue = propertyValue.add(propertyModel.getMin_val());
			}*/
			
			
			
			propertyValue=helper.propertyValueFromProcedure(token_no, token_date, Integer.parseInt(dsr_location));

			/*ListIterator<structureValuationModel> listItrStructure = structureList
					.listIterator();
			while (listItrStructure.hasNext()) {
				structureValuationModel structureModel = (structureValuationModel) listItrStructure
						.next();
				structureValue = structureValue.add(structureModel
						.getValuation());
			}*/
			
			
			structureValue=helper.structureValueFromProcedure(token_no, token_date, Integer.parseInt(dsr_location));
			
			
			if(deedModel.isProperty_details()){
				List<partyTypeModel> partyTypeList=manager.searchPartyTypeOnDeedID(Integer.parseInt(deed_type_id), Integer.parseInt(language));
				ListIterator<partyDetailModel> listItrParty = partyList.listIterator();
				while (listItrParty.hasNext()) {
					partyDetailModel partyModel = (partyDetailModel) listItrParty.next();
					
					ListIterator<partyTypeModel> listItrPartyType = partyTypeList.listIterator();
					while (listItrPartyType.hasNext()) {
						partyTypeModel partyTypeModel = (partyTypeModel) listItrPartyType.next();
					
						if((partyModel.getParty_type_id()==partyTypeModel.getParty_type_id())&&(partyTypeModel.getParty_type().equalsIgnoreCase("global_party_type_nispadk"))
							&&(partyModel.getCaste().equalsIgnoreCase("global_caste_st")))
							stNispadkCount=stNispadkCount+1;
						
						
						else if((partyModel.getParty_type_id()==partyTypeModel.getParty_type_id())&&(partyTypeModel.getParty_type().equalsIgnoreCase("global_party_type_claimant"))
								&&(!partyModel.getCaste().equalsIgnoreCase("global_caste_st")))
							nonSTclaimantCount=nonSTclaimantCount+1;
				
					}
				
				}
				}
				if((stNispadkCount>0)&&(nonSTclaimantCount>0))
					this.setPermission_no_required(true);
			
			
			

			if ((deedModel.getDeed_name().equalsIgnoreCase("Sale Deed"))
					|| (deedModel.getDeed_name()
							.equalsIgnoreCase("à¤¹à¤¸à¥�à¤¤à¤¾à¤‚à¤¤à¤°à¤£ à¤ªà¤¤à¥�à¤° (à¤µà¤¿à¤•à¥�à¤°à¤¯ à¤µà¤¿à¤²à¥‡à¤–)"))) {

				ListIterator<partyDetailModel> listItrParty = partyList
						.listIterator();
				while (listItrParty.hasNext()) {
					partyDetailModel partyModel = (partyDetailModel) listItrParty
							.next();

					if (partyType.contains(String.valueOf(partyModel
							.getParty_type_id()))) {

						if (partyModel.getGender().trim()
								.equalsIgnoreCase("global_sex_f")) {
							partyGenderFlag = true;
						} else {
							partyGenderFlag = false;
							break;
						}
					}

				}
			}

			if ((!deedModel.isConsidered_amount())
					&& (deedCategoryModel.getStamp_unit()
							.equalsIgnoreCase("global.f")))
				totalValuationAmount = new BigDecimal(0);
			else
				totalValuationAmount = propertyValue.add(structureValue);

			this.doc_min_amount = totalValuationAmount;
			
			
			if(deedCategoryModel.isGuideline_val_required()){
				this.maximumValuation = (new BigDecimal(this.considered_amount)).compareTo(totalValuationAmount) >= 0
						? (new BigDecimal(this.considered_amount)) : totalValuationAmount;
				}
				else if(!deedCategoryModel.isGuideline_val_required()){
					this.maximumValuation = new BigDecimal(this.considered_amount);	
				}
			
			
			this.baseFee = deedCategoryModel.getStamp_unit().equalsIgnoreCase(
					"global.p") ? (maximumValuation.multiply(deedCategoryModel
					.getStamp_fee()).divide(new BigDecimal(100)))
					: deedCategoryModel.getStamp_fee();
					
					
					if((deedCategoryModel.getMax_stamp_value().compareTo(new BigDecimal(0))>0)&&(this.baseFee.compareTo(deedCategoryModel.getMax_stamp_value())>=0))
						this.baseFee =deedCategoryModel.getMax_stamp_value();
			
					
					

			if (partyGenderFlag) {
				baseFee = (baseFee.subtract(baseFee
						.multiply(new BigDecimal(0.2))));
			}
			this.additionalFee = deedCategoryModel.getAddl_stamp_unit()
					.equalsIgnoreCase("global.p") ? (maximumValuation
					.multiply(deedCategoryModel.getAddl_stamp_value())
					.divide(new BigDecimal(100))) : deedCategoryModel
					.getAddl_stamp_value();

			if ((deedModel.isCess_amount()) && (structureList.isEmpty()))
				this.cess = (baseFee
						.multiply(deedCategoryModel.getCess_value())
						.divide(new BigDecimal(100)));
			else
				this.cess = new BigDecimal(0);
			this.setApplicable_stamp_value(String.valueOf((baseFee.setScale(0,
					BigDecimal.ROUND_HALF_UP).add(
					additionalFee.setScale(0, BigDecimal.ROUND_HALF_UP))
					.add(cess.setScale(0, BigDecimal.ROUND_HALF_UP))).setScale(
					0, BigDecimal.ROUND_HALF_UP)));
			
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

	public String editDeedDetail() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;

		try {

			File reportFile = new File(request.getSession(false)
					.getServletContext()
					.getRealPath("/report/IGR_CHECKSLIP.jasper"));

			
			log.fatal("My Permission No="+permission_no);
			
			insertOperationMessage = insertOperation
					.updateFinalDeedDeatil(
							doc_min_amount,
							applicable_stamp_value,
							empID,
							this.token_no,
							this.token_date,
							this.dsr_location,
							special_deed_detail,
							this.rel_last_reg_record.trim().length() > 0 ? this.rel_last_reg_record
									.trim() : null,
							this.rel_last_reg_no.trim().length() > 0 ? this.rel_last_reg_no
									.trim() : null,
							this.rel_last_reg_pow_of_atr.trim().length() > 0 ? this.rel_last_reg_pow_of_atr
									.trim() : null,
							this.rel_last_reg_pow_of_atr_reg_no.trim().length() > 0 ? this.rel_last_reg_pow_of_atr_reg_no
									.trim() : null,
							this.rel_last_reg_pow_of_atr_date.trim().length() > 0 ? sdf
									.parse(this.rel_last_reg_pow_of_atr_date)
									: null,
							this.rel_last_reg_date.trim().length() > 0 ? sdf
									.parse(this.rel_last_reg_date.trim())
									: null, this.baseFee.setScale(0,
									BigDecimal.ROUND_HALF_UP),
							this.additionalFee.setScale(0,
									BigDecimal.ROUND_HALF_UP), this.cess
									.setScale(0, BigDecimal.ROUND_HALF_UP),
							reportFile, Integer.parseInt(language),permission_no);

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
	public String exitDeedDetailEdit() throws Exception {
		return "home";
	}

	public void validate() {
		try {

			this.setEdit(false);
			this.execute();

			deedCategoryModel deedCategoryModel = manager
					.searchSingleRowDeedCategory(Integer.parseInt(language),
							Integer.parseInt(deed_category_id));

			if ((empID == null) || (branchCode == null) || (groupID == null)
					|| (language == null) || (empID.trim().length() == 0)
					|| (branchCode.trim().length() == 0)
					|| (groupID.trim().length() == 0)
					|| (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));

			} else if (!validator.requiredFiledValidate(token_no.trim())) {
				this.addFieldError("token_no", "Token No can't be empty");

			} else if (!validator.requiredFiledValidate(presenter_name.trim())) {
				this.addFieldError("presenter_name", "Name can't be empty");
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
					.requiredFiledValidate(first_party_executant_name.trim())) {
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
			}

			else if (!validator
					.requiredFiledValidate(first_party_executant_capacity
							.trim())) {
				this.addFieldError("first_party_executant_capacity",
						"Capacity can't be empty");
			}

			else if (!validator.requiredFiledValidate(deed_category_id.trim())) {
				this.addFieldError("deed_category_id",
						"Deed Category can't be empty");
			}

			else if (!validator.requiredFiledValidate(deed_type_id.trim())) {
				this.addFieldError("deed_type_id", "Deed Type can't be empty");
			}

			else if (!validator.requiredFiledValidate(considered_amount.trim())) {
				this.addFieldError("considered_amount",
						"Considered Amount can't be empty");
			} else if (!validator.amountFiledValidate(considered_amount.trim())) {
				this.addFieldError("considered_amount",
						"Considered Amount is not Valid");
			} else if (!validator.requiredFiledValidate(applicable_stamp_value
					.trim())) {
				this.addFieldError("applicable_stamp_value",
						"Applicable Stamp Value can't be empty");
			} else if (!validator.amountFiledValidate(applicable_stamp_value
					.trim())) {
				this.addFieldError("applicable_stamp_value",
						"Applicable Stamp Value is not Valid");
			}

			else if ((deedCategoryModel.isStamp_val_required())
					&& (!validator.requiredFiledValidate(presented_stamp_value
							.trim()))) {
				this.addFieldError("presented_stamp_value",
						"Presented Stamp Value can't be empty");
			} else if ((deedCategoryModel.isStamp_val_required())
					&& (!validator.amountFiledValidate(presented_stamp_value
							.trim()))) {

				this.addFieldError("presented_stamp_value",
						"Presented Stamp Value is not Valid");
			}

			
			else if (!validator.requiredFiledValidate(no_total_pages.trim())) {
				this.addFieldError("no_total_pages",
						"No. of Total Pages can't be empty");

			} else if((special_deed_detail!=null)&&(special_deed_detail.trim().length()>0)&&(!validator.languageValidate(special_deed_detail.trim(), this.language))) {
				this.addFieldError("special_deed_detail", "Pl. Input in Proper Language");

			} else if ((rel_last_reg_record.trim().length() > 0)
					&& (!validator.languageValidate(rel_last_reg_record.trim(),
							"1"))) {
				this.addFieldError("rel_last_reg_record",
						"RELATED LAST REGISTRY RECORD in English Language");

			}

			else if ((rel_last_reg_date.trim().length() > 0)
					&& (!validator.languageValidate(rel_last_reg_date.trim(),
							"1"))) {
				this.addFieldError("rel_last_reg_date",
						"RELATED LAST REGISTRY RECORD DATE in English Language");

			} else if ((rel_last_reg_date.trim().length() > 0)
					&& (!validator.dateFormate(rel_last_reg_date.trim()))) {
				this.addFieldError("rel_last_reg_date",
						"RELATED LAST REGISTRY RECORD DATE Format is dd/MM/yyyy");

			}

			else if ((rel_last_reg_date.trim().length() > 0)
					&& (!validator.futureDateFiledValidate(sdf
							.parse(rel_last_reg_date)))) {
				this.addFieldError("rel_last_reg_date",
						"Future date is not allowed");

			} else if ((rel_last_reg_no.trim().length() > 0)
					&& (!validator
							.languageValidate(rel_last_reg_no.trim(), "1"))) {
				this.addFieldError("rel_last_reg_no",
						"RELATED LAST REGISTRY RECORD REGISTRATION NO in English Language");

			} else if ((rel_last_reg_pow_of_atr.trim().length() > 0)
					&& (!validator.languageValidate(
							rel_last_reg_pow_of_atr.trim(), "1"))) {
				this.addFieldError("rel_last_reg_pow_of_atr",
						"RELATED LAST REGISTRY RECORD POWER OF ATTORNEY in English Language");

			} else if ((rel_last_reg_pow_of_atr_date.trim().length() > 0)
					&& (!validator.languageValidate(
							rel_last_reg_pow_of_atr_date.trim(), "1"))) {
				this.addFieldError("rel_last_reg_pow_of_atr_date",
						"RELATED LAST REGISTRY RECORD POWER OF ATTORNEY DATEE in English Language");

			}

			else if ((rel_last_reg_pow_of_atr_date.trim().length() > 0)
					&& (!validator.dateFormate(rel_last_reg_pow_of_atr_date
							.trim()))) {
				this.addFieldError("rel_last_reg_pow_of_atr_date",
						"RELATED LAST REGISTRY RECORD POWER OF ATTORNEY DATE Format is dd/MM/yyyy");

			}

			else if ((rel_last_reg_pow_of_atr_date.trim().length() > 0)
					&& (!validator.futureDateFiledValidate(sdf
							.parse(rel_last_reg_pow_of_atr_date)))) {
				this.addFieldError("rel_last_reg_pow_of_atr_date",
						"Future date is not allowed");

			} else if ((rel_last_reg_pow_of_atr_reg_no.trim().length() > 0)
					&& (!validator.languageValidate(
							rel_last_reg_pow_of_atr_reg_no.trim(), "1"))) {
				this.addFieldError(
						"rel_last_reg_pow_of_atr_reg_no",
						"RELATED LAST REGISTRY RECORD POWER OF ATTORNEY REGISTRATION NO in English Language");

			}
			
			
			
			else if((isPermission_no_required())&&(!validator.requiredFiledValidate(permission_no.trim())))
			{
				this.addFieldError("permission_no",
						"Permission No. is required");
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
				
			
			this.setToken_no("");
			this.setToken_date(null);
			this.setDsr_location("");
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
			this.setDoc_min_amount(new BigDecimal(0.0));
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
			this.districtList.clear();
			this.dsrLocationList.clear();
			this.deedTypeList.clear();
			this.deedCategoryList.clear();
			this.setPermission_no("");
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
	}

}
