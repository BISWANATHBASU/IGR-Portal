package com.igr.registration;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;









//import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.commonUtility.CommonFourOptionsVO;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.commonUtility.Datasource;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.deedDetailModel;
import com.igr.hibernate.model.deedDetailPKModel;
import com.igr.hibernate.model.deedTypeModel;
import com.igr.hibernate.model.lrTransactionDetailModel;
import com.igr.hibernate.model.partyDetailModel;
import com.igr.hibernate.model.partyTypeModel;
import com.igr.hibernate.model.propertyDetailModel;
import com.igr.hibernate.model.structureValuationModel;
//import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.igr.webservice.LR.DiversionOwnerDetails;
import com.igr.webservice.LR.DiversionPlotDetails;
import com.igr.webservice.LR.KhasraDetails;
import com.igr.webservice.LR.NajoolOwnerDetails;
import com.igr.webservice.LR.OwnerDetails;
import com.igr.webservice.LR.PlotDetails;
import com.igr.webservice.LR.WebServiceForRegistrationDeptNewLocator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DeedDetailEntryAction extends ActionSupport implements
		ServletContextAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String locationName = "";
	private String districtID = "";
	private String districtName = "";
	private BigDecimal stampValue = new BigDecimal(0);

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
	private String dummyTokenNo;
	private String dummyTokenDate;
	private String dummyDSRLocation;
	private Date token_date;
	private Date token_time;
	private String deed_category_id;
	private String deed_type_id;
	private BigDecimal doc_min_amount;
	private String applicable_stamp_value;
	private String presented_stamp_value;
	private String no_total_pages;
	private String new_no_of_total_pages;
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
	private String remarks;
	private BigDecimal otherFee;
	
	private Date app_date;
	private String mm;
	private String hh;
	private String hhmm;
	private String app_date1;
	
	//private String dummyDSRLocation; 

	/*public String getDummyDSRLocation() {
		return dummyDSRLocation;
	}

	public void setDummyDSRLocation(String dummyDSRLocation) {
		this.dummyDSRLocation = dummyDSRLocation;
	}*/

	public Date getApp_date() {
		return app_date;
	}

	public void setApp_date(Date app_date) {
		this.app_date = app_date;
	}

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	public String getHh() {
		return hh;
	}

	public void setHh(String hh) {
		this.hh = hh;
	}

	public String getHhmm() {
		return hhmm;
	}

	public void setHhmm(String hhmm) {
		this.hhmm = hhmm;
	}

	public String getApp_date1() {
		return app_date1;
	}

	public void setApp_date1(String app_date1) {
		this.app_date1 = app_date1;
	}

	private ServletContext context;
	private HttpServletRequest request;

	//private List<CommonOptionsVO> dsrLocationList;
	//private List<CommonOptionsVO> districtList;
	private List<CommonOptionsVO> firstPartyCapacityList;
	private List<CommonOptionsVO> deedCategoryList;
	private List<CommonOptionsVO> deedTypeList;
	private List<CommonOptionsVO> specialDeedDetailList;

	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
	private static SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy");

	private static final Logger log = Logger.getLogger(DeedDetailEntryAction.class);
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

	public String getNew_no_of_total_pages() {
		return new_no_of_total_pages;
	}

	public void setNew_no_of_total_pages(String new_no_of_total_pages) {
		this.new_no_of_total_pages = new_no_of_total_pages;
	}

	public boolean isPrintFlag() {
		return printFlag;
	}

	public String getDummyTokenNo() {
		return dummyTokenNo;
	}

	public void setDummyTokenNo(String dummyTokenNo) {
		this.dummyTokenNo = dummyTokenNo;
	}

	public String getDummyTokenDate() {
		return dummyTokenDate;
	}

	public void setDummyTokenDate(String dummyTokenDate) {
		this.dummyTokenDate = dummyTokenDate;
	}

	public String getDummyDSRLocation() {
		return dummyDSRLocation;
	}

	public void setDummyDSRLocation(String dummyDSRLocation) {
		this.dummyDSRLocation = dummyDSRLocation;
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

	public String getSpecial_deed_detail() {
		return special_deed_detail;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	/*public List<CommonOptionsVO> getDsrLocationList() {
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
	}*/

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

	public List<CommonOptionsVO> getSpecialDeedDetailList() {
		return specialDeedDetailList;
	}

	public void setSpecialDeedDetailList(
			List<CommonOptionsVO> specialDeedDetailList) {
		this.specialDeedDetailList = specialDeedDetailList;
	}

	public BigDecimal getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	@SkipValidation
	public String execute() throws Exception {
		
		log.fatal("");
		
		String returnValue = SUCCESS;

		this.dummyTokenNo = token_no;
		this.dummyTokenDate = sdf3.format(token_date);
		this.dummyDSRLocation = dsr_location;

		empID = (String) request.getSession().getAttribute("_EMPCODE");
		//branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		//groupID = (String) request.getSession().getAttribute("_USERGROUP");
		language = (String) request.getSession().getAttribute("_LANGUAGE");
		//locationName = (String) request.getSession().getAttribute("LOCATIONNAME");
		//districtID = (String) request.getSession().getAttribute("DISTRICT_CODE");
		//districtName = (String) request.getSession().getAttribute("DISTRICT_NAME");
		int i = 0;
		// BigDecimal propertyValue = new BigDecimal(0);
		// BigDecimal structureValue = new BigDecimal(0);
		BigDecimal totalValuationAmount = new BigDecimal(0);
		boolean partyGenderFlag = false;
		String partyType = "";
		//userLogModel logModel = new userLogModel();
		int returnMessage = 1;
		int stNispadkCount = 0;
		int nonSTclaimantCount = 0;

		int nispadkCount = 0;
		int claimantCount = 0;
		int witnessCount = 0;
		BigDecimal oldStampValue = new BigDecimal(0);
		

		//JasperReport jasperReport = null;
		//Connection con = null;

		try {
			

			/*
			JasperPrint jasperPrint = null;

			File reportFile = new File(request.getSession(false)
					.getServletContext()
					.getRealPath("/report/IGR_CHECKSLIP_PORTAL.jasper"));
			
			
			log.fatal("Testing "+language+" "+token_no+" "+dsr_location+" "+token_date);

			Map<String, String> reportParams = new HashMap<String, String>(2,
					1.0f);
			reportParams.put("lang_code", language);
			reportParams.put("token_no", token_no);
			reportParams.put("dsr_location", dsr_location);
			reportParams.put("token_date", sdf1.format(token_date));
			reportParams.put("SUBREPORT_DIR", reportFile.getParentFile()
					.getAbsolutePath());

			jasperReport = (JasperReport) JRLoader.loadObject(reportFile
					.getPath());

			con = Datasource.getDataSource();
			jasperPrint = JasperFillManager.fillReport(jasperReport,
					reportParams, con);

			request.setAttribute("reportBody", jasperPrint);
			
			*/

			//Locale locale = new Locale(language);
			//ActionContext.getContext().setLocale(locale);
			
			/*=============================*/

			List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
			allFirstPartyCapacityList = (List) context.getAttribute("GLOBALDROPDOWNLOV");

			log.fatal(" presented_stamp_value " + presented_stamp_value);


			//districtList = new ArrayList();
            //districtList = manager.searchDistrictAll(Integer.parseInt(language));
			
			List<partyDetailModel> partyList = new ArrayList<partyDetailModel>();
			partyList = manager.getPartyDetails(token_no,token_date, Integer.parseInt(dsr_location));

			List<partyTypeModel> partyTypeList = manager.searchPartyTypeOnDeedID(Integer.parseInt(deed_type_id),Integer.parseInt(language));
			
			

			ListIterator<partyDetailModel> listItrParty = partyList.listIterator();
			while (listItrParty.hasNext()) {
				partyDetailModel partyModel = (partyDetailModel) listItrParty.next();

				ListIterator<partyTypeModel> listItrPartyType = partyTypeList.listIterator();
				while (listItrPartyType.hasNext()) {
					partyTypeModel partyTypeModel = (partyTypeModel) listItrPartyType.next();

					if ((partyModel.getParty_type_id() == partyTypeModel.getParty_type_id())
							&& (partyTypeModel.getParty_type().equalsIgnoreCase("global_party_type_nispadk")))
						nispadkCount = nispadkCount + 1;

					else if ((partyModel.getParty_type_id() == partyTypeModel.getParty_type_id())
							&& (partyTypeModel.getParty_type().equalsIgnoreCase("global_party_type_claimant")))
						claimantCount = claimantCount + 1;

					else if ((partyModel.getParty_type_id() == partyTypeModel.getParty_type_id())
							&& (partyTypeModel.getParty_type().equalsIgnoreCase("global_party_type_witness")))
						witnessCount = witnessCount + 1;

				}

			}

			if (((!deed_type_id.equals("86")) && (!deed_type_id.equals("150"))
					&& (!deed_type_id.equals("73"))
					&& (!deed_type_id.equals("76"))
					&& (!deed_type_id.equals("89"))
					&& (!deed_type_id.equals("151"))
					&& (!deed_type_id.equals("90"))
					&& (!deed_type_id.equals("118")) && (!deed_type_id
						.equals("152")))
					&& ((nispadkCount <= 0) || (claimantCount <= 0) || (witnessCount <= 0))) {

				this.addActionError("At Least one nispadk, one claimant and one witness is required");
				return "home";
			}

			log.fatal("deed_type_id  At Deed Detail " + deed_type_id);

			if (this.presented_stamp_value.trim().length() == 0)
				this.setPresented_stamp_value("0");

			//dsrLocationList = new ArrayList();
			//CommonOptionsVO optionVO = new CommonOptionsVO(branchCode,locationName);
			//dsrLocationList.add(optionVO);

			/*districtList = new ArrayList();
			CommonOptionsVO optionVO1 = new CommonOptionsVO(districtID,districtName);
			districtList.add(optionVO1);
			*/

			firstPartyCapacityList = new ArrayList<CommonOptionsVO>();
			firstPartyCapacityList = helper.extractParticularFourData(
					first_party_executant_capacity.trim(), this.language,
					allFirstPartyCapacityList);

			specialDeedDetailList = new ArrayList<CommonOptionsVO>();
			specialDeedDetailList = helper.extractFourData("global_commission",this.language, allFirstPartyCapacityList);

			deedTypeModel deedModel = manager.searchSingleRowDeedType(Integer.parseInt(language), Integer.parseInt(deed_type_id));
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

			deedCategoryModel deedCategoryModel = manager.searchSingleRowDeedCategory(Integer.parseInt(language),Integer.parseInt(deed_category_id));

			log.fatal("deed_category_id " + deed_category_id);

			deedCategoryList = new ArrayList<CommonOptionsVO>();
			CommonOptionsVO optionVO3 = new CommonOptionsVO(String.valueOf(deedCategoryModel.getDeed_category_id()),deedCategoryModel.getCategory_name());
			deedCategoryList.add(optionVO3);

			/*String oldDeedVale = manager.getOldDeedData(
					token_no, token_date,
					Integer.parseInt(dsr_location));
			if ((oldDeedVale != null) && (oldDeedVale.trim().length() > 0)) {
				String olddDeedValueArray[] = oldDeedVale.split("~");
				oldStampValue = new BigDecimal(olddDeedValueArray[1]);
			}*/

			if ((deed_type_id.trim().equalsIgnoreCase("74")) || (deed_type_id.trim().equalsIgnoreCase("153"))) {
				log.fatal("I am in Lease Deed");

				String feeValues = helper.feeValuesForLeaseDeed(token_no, token_date,Integer.parseInt(dsr_location));
				String feeValuesArray[] = feeValues.split("-");
				//String feeValuesArray[] = feeValues.split("~");
				this.doc_min_amount = new BigDecimal(0);

				this.baseFee = new BigDecimal(feeValuesArray[0]).setScale(0,RoundingMode.CEILING);
				this.additionalFee = new BigDecimal(feeValuesArray[3]).setScale(0, RoundingMode.CEILING);
				this.cess = new BigDecimal(feeValuesArray[1]).setScale(0,RoundingMode.CEILING);

				this.otherFee = new BigDecimal(feeValuesArray[2]).setScale(0,RoundingMode.CEILING);

				log.fatal(baseFee + "," + additionalFee + "," + cess + "," + otherFee + " , " + oldStampValue);

				this.setApplicable_stamp_value(String.valueOf((baseFee.add(additionalFee).add(cess).add(otherFee)).subtract(oldStampValue)));

			}

			else if ((!deed_type_id.trim().equalsIgnoreCase("74"))
					&& (!deed_type_id.trim().equalsIgnoreCase("153"))) {

				log.fatal("I am in non-Lease Deed");

				List<structureValuationModel> structureList = new ArrayList<structureValuationModel>();
				structureList = manager.getStructureDetails(token_no, token_date,Integer.parseInt(dsr_location));

				/*
				 * List<propertyDetailModel> propertyDetailList = new
				 * ArrayList<propertyDetailModel>();
				 * 
				 * propertyDetailList =
				 * manager.getPropertyDetails(token_no,
				 * token_date, Integer.parseInt(dsr_location));
				 * 
				 * ListIterator<propertyDetailModel> listItrProperty =
				 * propertyDetailList.listIterator(); while
				 * (listItrProperty.hasNext()) { propertyDetailModel
				 * propertyModel = (propertyDetailModel) listItrProperty.next();
				 * propertyValue =
				 * propertyValue.add(propertyModel.getMin_val()); }
				 */

				/*
				 * propertyValue = helper.propertyValueFromProcedure(
				 * token_no, token_date,
				 * Integer.parseInt(dsr_location));
				 * 
				 * log.fatal("Bisur Property Value = " +
				 * propertyValue);
				 */

				/*
				 * ListIterator<structureValuationModel> listItrStructure =
				 * structureList.listIterator(); while
				 * (listItrStructure.hasNext()) { structureValuationModel
				 * structureModel = (structureValuationModel)
				 * listItrStructure.next(); structureValue =
				 * structureValue.add(structureModel.getValuation()); /}
				 */

				/*
				 * structureValue = helper.structureValueFromProcedure(
				 * token_no, token_date,
				 * Integer.parseInt(dsr_location));
				 * 
				 * log.fatal("Bisur Structure Value = " +
				 * structureValue);
				 */

				if ((deedModel.getDeed_name().equalsIgnoreCase("Sale Deed"))
						|| (deedModel.getDeed_name()
								.equalsIgnoreCase("à¤¹à¤¸à¥�à¤¤à¤¾à¤‚à¤¤à¤°à¤£ à¤ªà¤¤à¥�à¤° (à¤µà¤¿à¤•à¥�à¤°à¤¯ à¤µà¤¿à¤²à¥‡à¤–)"))) {

					listItrParty = partyList.listIterator();
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

				if (deedModel.isProperty_details()) {

					listItrParty = partyList.listIterator();
					while (listItrParty.hasNext()) {
						partyDetailModel partyModel = (partyDetailModel) listItrParty
								.next();

						ListIterator<partyTypeModel> listItrPartyType = partyTypeList
								.listIterator();
						while (listItrPartyType.hasNext()) {
							partyTypeModel partyTypeModel = (partyTypeModel) listItrPartyType
									.next();

							if ((partyModel.getParty_type_id() == partyTypeModel
									.getParty_type_id())
									&& (partyTypeModel.getParty_type()
											.equalsIgnoreCase("global_party_type_nispadk"))
									&& (partyModel.getCaste()
											.equalsIgnoreCase("global_caste_st")))
								stNispadkCount = stNispadkCount + 1;

							else if ((partyModel.getParty_type_id() == partyTypeModel
									.getParty_type_id())
									&& (partyTypeModel.getParty_type()
											.equalsIgnoreCase("global_party_type_claimant"))
									&& (!partyModel
											.getCaste()
											.equalsIgnoreCase("global_caste_st")))
								nonSTclaimantCount = nonSTclaimantCount + 1;

						}

					}
				}
				if ((stNispadkCount > 0) && (nonSTclaimantCount > 0))
					this.setPermission_no_required(true);

				if ((!deedModel.isConsidered_amount())
						&& (deedCategoryModel.getStamp_unit()
								.equalsIgnoreCase("global.f")))
					totalValuationAmount = new BigDecimal(0);
				else
					totalValuationAmount = helper.valuationFromProcedure(
							token_no, token_date,
							Integer.parseInt(dsr_location));

				log.fatal("Total Valuation Amount Comming from Procedure "
						+ totalValuationAmount);

				log.fatal("this.considered_amount=" + this.considered_amount+", totalValuationAmount="+totalValuationAmount);
				
				this.doc_min_amount = totalValuationAmount;
				
				if (deedCategoryModel.isGuideline_val_required()) {
					this.maximumValuation = (new BigDecimal(this.considered_amount))
							.compareTo(totalValuationAmount) >= 0 ? (new BigDecimal(
							this.considered_amount)) : totalValuationAmount;
				} else if (!deedCategoryModel.isGuideline_val_required()) {
					this.maximumValuation = new BigDecimal(
							this.considered_amount);
				}

				log.fatal("maximumValuation " + maximumValuation);

				this.baseFee = deedCategoryModel.getStamp_unit()
						.equalsIgnoreCase("global.p") ? (maximumValuation
						.multiply(deedCategoryModel.getStamp_fee())
						.divide(new BigDecimal(100))) : deedCategoryModel
						.getStamp_fee();

				if ((deedCategoryModel.getMax_stamp_value().compareTo(
						new BigDecimal(0)) > 0)
						&& (this.baseFee.compareTo(deedCategoryModel
								.getMax_stamp_value()) >= 0))
					this.baseFee = deedCategoryModel.getMax_stamp_value();

				if (partyGenderFlag) {
					baseFee = (baseFee.subtract(baseFee
							.multiply(new BigDecimal(0.2))));
				}
				this.additionalFee = deedCategoryModel.getAddl_stamp_unit()
						.equalsIgnoreCase("global.p") ? (maximumValuation
						.multiply(deedCategoryModel.getAddl_stamp_value())
						.divide(new BigDecimal(100))) : deedCategoryModel
						.getAddl_stamp_value();

				if (((deedModel.isCess_amount()) && (structureList.isEmpty()))
						|| ((deedModel.isCess_amount()) && (deedCategoryModel
								.getDeed_category_id() == 115))) {
					log.fatal("NIRMALY1 " + baseFee + ","
							+ deedCategoryModel.getCess_value());
					this.cess = (baseFee.multiply(deedCategoryModel
							.getCess_value()).divide(new BigDecimal(100)));
					log.fatal("NIRMALY1 " + this.cess);
				}

				else
					this.cess = new BigDecimal(0);

				this.setApplicable_stamp_value(String.valueOf(
						(baseFee.setScale(0, RoundingMode.CEILING).add(additionalFee.setScale(0, RoundingMode.CEILING))
								.add(cess.setScale(0, RoundingMode.CEILING))).setScale(0, RoundingMode.CEILING).subtract(oldStampValue)));

			}

			log.fatal(baseFee + "," + additionalFee + "," + cess + "," + otherFee+ " , "+oldStampValue);
			if (isEdit()) {

				//Date currentDateValue = new Date();
				/*returnMessage = helper.userLogActin(token_no,
						sdf1.parse(sdf1.format(token_date)), Integer.parseInt(dsr_location),
						Integer.parseInt(empID), "Deed_Detail_Entry", "START");
				*/
				this.setEdit(false);
			}

			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);

		} catch (Exception e) {
			returnMessage = 0;
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		/*finally {

			if (null != con)
				try {
					con.close();
				} catch (Exception e) {
					log.fatal(helper.writeLogInUpperCase(e));
					throw new Exception("System Error Occured");
				}
		}*/

		if (returnMessage == 1)
			returnValue = SUCCESS;

		else if (returnMessage == 0) {
			this.addActionError(getText("global.system.error"));
			return "home";
		}

		return returnValue;
	}

	public String addDeedDetail() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;
		List<propertyDetailModel> propertyModelList = new ArrayList<propertyDetailModel>();
		
		
		
		try {
			
			district_id = token_no.substring(1, 3);

			log.fatal("My DSR Location " + this.dsr_location + "," + this.token_no + "," + this.token_date+", "+this.district_id);
			deedDetailModel deedModel = new deedDetailModel();
			Date currentDateValue1 = new Date();

			deedDetailPKModel deedDetailPK = new deedDetailPKModel();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
			String app_timestamp=null;
			if(app_date1!=null && app_date1.length()>0){
				app_timestamp=app_date1+" "+hhmm;
				log.fatal("app_timestamp:--------->>>>>"+app_timestamp);
				/*this.app_date=formatter.format(app_timestamp);*/
				/*Calendar c=Calendar.getInstance();
				c.set(c.t, value);*/
				this.app_date=formatter.parse(app_timestamp);
			}
			else{
				this.app_date=null;
			}

			deedDetailPK.setToken_no(this.token_no);
			deedDetailPK.setDsr_location(Integer.parseInt(this.dsr_location));
			deedDetailPK.setToken_date(this.token_date);

			deedModel.setDeedDetailPK(deedDetailPK);

			deedModel.setPresenter_name(this.presenter_name);
			deedModel.setFirstparty_executant_name(this.first_party_executant_name);
			deedModel.setFirstparty_executant_capacity(this.first_party_executant_capacity);
			deedModel.setDistrict_id(Integer.parseInt(this.district_id));
			deedModel.setDsr_location_desc(locationName);
			deedModel.setToken_time(sdf2.parse(sdf2.format(currentDateValue1)));
			deedModel.setDeed_category_id(Integer.parseInt(this.deed_category_id));
			deedModel.setDeed_type_id(Integer.parseInt(this.deed_type_id));
			deedModel.setConsidered_amount(new BigDecimal(this.considered_amount));
			deedModel.setDoc_min_amount(this.doc_min_amount);
			deedModel.setApplicable_stamp_value(new BigDecimal(this.applicable_stamp_value));
			deedModel.setPresented_stamp_value(new BigDecimal(this.presented_stamp_value));
			deedModel.setNo_total_pages(Integer.parseInt(this.no_total_pages));
			deedModel.setSpecial_deed_detail(this.special_deed_detail);
			deedModel.setE_registration_code(this.e_registration_code);
			deedModel.setRel_last_reg_record(this.rel_last_reg_record.trim().length() > 0 ? this.rel_last_reg_record.trim() : null);
			deedModel
					.setRel_last_reg_no(this.rel_last_reg_no.trim().length() > 0 ? this.rel_last_reg_no
							.trim() : null);
			deedModel.setRel_last_reg_pow_of_atr(this.rel_last_reg_pow_of_atr
					.trim().length() > 0 ? this.rel_last_reg_pow_of_atr.trim()
					: null);
			deedModel
					.setRel_last_reg_pow_of_atr_reg_no(this.rel_last_reg_pow_of_atr_reg_no
							.trim().length() > 0 ? this.rel_last_reg_pow_of_atr_reg_no
							.trim() : null);
			deedModel
					.setRel_last_reg_pow_of_atr_date(this.rel_last_reg_pow_of_atr_date
							.trim().length() > 0 ? sdf
							.parse(this.rel_last_reg_pow_of_atr_date) : null);
			deedModel.setRel_last_reg_date(this.rel_last_reg_date.trim()
					.length() > 0 ? sdf.parse(this.rel_last_reg_date.trim())
					: null);
			deedModel.setLang_code(Integer.parseInt(language));
			deedModel.setCreated_by(Integer.parseInt(empID));
			deedModel.setUpdated_by(Integer.parseInt(empID));
			deedModel.setCreated_date(currentDateValue1);
			deedModel.setUpdated_date(currentDateValue1);
			deedModel.setPermission_no(this.permission_no);
			deedModel.setRemarks(this.remarks);

			log.fatal("Test  " + baseFee + "," + additionalFee + "," + cess + "," + otherFee);

			deedModel.setBase_stamp_fee(this.baseFee.setScale(0,RoundingMode.CEILING));
			deedModel.setAddl_stamp_fee(this.additionalFee.setScale(0,RoundingMode.CEILING));
			deedModel.setCess(this.cess.setScale(0, RoundingMode.CEILING));
			deedModel.setOther_stamp_fee(this.otherFee == null ? new BigDecimal(0) : this.otherFee.setScale(0, RoundingMode.CEILING));

			File reportFile = new File(request.getSession(false).getServletContext().getRealPath("/report/IGR_CHECKSLIP_TOTAL_WSP_INDEX.jasper"));

			insertOperationMessage = insertOperation.insertDeedDeatil(deedModel, this.token_no, this.token_date,
					Integer.parseInt(this.dsr_location), reportFile,Integer.parseInt(language), Integer.parseInt(empID),this.app_date);//,currentDateValue1

			if (insertOperationMessage.trim().substring(0, 1).equalsIgnoreCase("1")) {
				operationFlag = true;
			}

			else if (insertOperationMessage.trim().substring(0, 1).equalsIgnoreCase("0")) {
				operationFlag = false;
			}

			returnMessage = insertOperationMessage.substring(1,insertOperationMessage.trim().length());

		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		if (operationFlag) {
			/*
			StringBuffer khasraValue = new StringBuffer("");
			 
			try{
		
			
					propertyModelList = manager.getPropertyDetails(token_no,sdf1.parse(sdf1.format(token_date)), Integer.parseInt(dsr_location));
					
					ListIterator<propertyDetailModel> listItrProperty = propertyModelList.listIterator();
				
					
					
					String districtCode="";
					String riCode="";
					String thCode="";
					String villageCode="";
					String villageName="";
					String khasraNo="";
					String areaValue="";
					String plotNo="";
					String recordCode="";
					
					WebServiceForRegistrationDeptNewLocator lrService = new WebServiceForRegistrationDeptNewLocator();
				
					while (listItrProperty.hasNext()){
						propertyDetailModel model = (propertyDetailModel) listItrProperty.next();
						
						khasraNo=model.getKhasra_no();
						areaValue=model.getTotal_area_volume().toString();
						
						
						if(model.getKhasra_type().equalsIgnoreCase("global_khasra_type_1")){
						districtCode=model.getLr_vill_code().substring(0,2);
						thCode=model.getLr_vill_code().substring(2,4);
						riCode=model.getLr_vill_code().substring(4,6);
						villageCode=model.getLr_vill_code().substring(7,10);
						
						
						
						log.fatal(" Data Before Calling Service districtCode"+districtCode+" riCode "+riCode+" thCode "+thCode+" villageCode "+villageCode+" khasraNo "+khasraNo+" Area Value "+areaValue);
						
						log.fatal(" Data Before Calling Service districtCode"+districtCode+" riCode "+riCode+" thCode "+thCode+" villageCode "+villageCode+" khasraNo "+khasraNo+" Area Value "+areaValue);
						
						if(Float.parseFloat(areaValue.trim().length()>0?areaValue:"0")>0){
						
						KhasraDetails[] array=lrService.getWebServiceForRegistrationDeptNewSoap().toGetDataofKhasra(districtCode, thCode, riCode, villageCode, khasraNo);
						
					log.fatal(" Khasra Detail from Service "+array.length);
					
						 if(array!=null){
							 
						
						
						log.fatal(" Token_no "+token_no+" khasra.length "+array.length);
						
						
						for(int j=0;j<array.length;j++){
							Date currentDateValue = new Date();
							khasraValue.append("true,");
							
							
							log.fatal(" Token_no "+token_no+" Date "+this.token_date+" Location "+dsr_location+" Khasra_No "+array[j].getKhasra_No());	 
							
							log.fatal(" Token_no "+token_no+" Date "+this.token_date+" Location "+dsr_location+" Khasra_No "+array[j].getKhasra_No());
							
							
							lrTransactionDetailModel lrModel =new lrTransactionDetailModel();
							lrModel.setToken_no(token_no);
							lrModel.setToken_date(this.token_date);
							lrModel.setDsr_location(Integer.parseInt(dsr_location));
							lrModel.setArea(array[j].getArea());
							lrModel.setKhasra_no(array[j].getKhasra_No());
							lrModel.setNakshaurl(array[j].getNakshaURL());
							lrModel.setVillage_code(array[j].getVillageCode());
							lrModel.setB1PDFurl(array[j].getSignedB1PdfURL());
							lrModel.setP2PDFurl(array[j].getSignedP2PdfURL());
						
							
							log.fatal(" Area "+array[j].getArea()+" Khasra No "+array[j].getKhasra_No()+" NakshaURL "+array[j].getNakshaURL()+" Village Code "+array[j].getVillageCode());

							
							OwnerDetails ownerDetail[]=array[j].getOwnerdetails();
							
							log.fatal("ownerDetail "+ownerDetail==null?"NULL":ownerDetail.length);
			                  
							log.fatal("ownerDetail "+ownerDetail.length);
							
							if(ownerDetail!=null){
							for(int x=0;x<ownerDetail.length;x++)
							{
								
								log.fatal("ownerDetail "+ownerDetail[x].getOcdname());
								log.fatal("ownerDetail "+ownerDetail[x].getOcdname1());
								
								
								lrModel.setAadharno(ownerDetail[x].getAadharno());	
								lrModel.setGender(ownerDetail[x].getGender());
								lrModel.setLoanpassbook(ownerDetail[x].getLoanbook());
								lrModel.setMobileno(ownerDetail[x].getMobileno());
								lrModel.setOaddr1(ownerDetail[x].getOaddr1());
								lrModel.setOcaste_code(ownerDetail[x].getOcaste_code());
								lrModel.setOcdname(ownerDetail[x].getOcdname());
								lrModel.setOcastenm(ownerDetail[x].getOcastenm());
								lrModel.setOcdname1(ownerDetail[x].getOcdname1());
								lrModel.setOfather(ownerDetail[x].getOfather());
								lrModel.setOfather1(ownerDetail[x].getOfather1());
								lrModel.setCreated_by(Integer.parseInt(empID));
								lrModel.setUpdated_by(Integer.parseInt(empID));
								lrModel.setCreated_date(currentDateValue);
								lrModel.setUpdated_date(currentDateValue);
								manager.addLRTransaction(lrModel,1);
								
								
								
								
							}
							}
							else{
							manager.addLRTransaction(lrModel,2);
							}
							log.fatal("Hi I am here i");
							
						}
						
					}
						 else
							{
								khasraValue.append("false,");
							}
						}
						 else
							{
								khasraValue.append("false,");
							}
					}
						
						else if(model.getKhasra_type().equalsIgnoreCase("global_khasra_type_2"))
						{
							
							plotNo=model.getPlot_no();
							recordCode=model.getLr_najool_sheet();
							
							 
								if(Float.parseFloat(areaValue.trim().length()>0?areaValue:"0")>0){
									
									 PlotDetails[] plotArray=	lrService.getWebServiceForRegistrationDeptNewSoap().toGetNajoolDetails(plotNo, recordCode);
									
								log.fatal(" Nazool Detail from Service "+plotArray.length);
								
									 if(plotArray!=null){
										 
									
									
									log.fatal(" Token_no "+token_no+" Nazool.length "+plotArray.length);
									
									
									for(int j=0;j<plotArray.length;j++){
										Date currentDateValue = new Date();
										khasraValue.append("true,");
										
										
										log.fatal(" Token_no "+token_no+" Date "+this.token_date+" Location "+dsr_location+" Khasra_No "+plotArray[j].getArea_foot());	 
										
										log.fatal(" Token_no "+token_no+" Date "+this.token_date+" Location "+dsr_location+" Khasra_No "+plotArray[j].getArea_foot());
										
										
										lrTransactionDetailModel lrModel =new lrTransactionDetailModel();
										lrModel.setToken_no(token_no);
										lrModel.setToken_date(this.token_date);
										lrModel.setDsr_location(Integer.parseInt(dsr_location));
										lrModel.setArea(plotArray[j].getArea_foot());
										lrModel.setKhasra_no(plotArray[j].getPlotno());
										lrModel.setNakshaurl("");
										lrModel.setVillage_code(villageCode);
										
										
										

										
										NajoolOwnerDetails[] najoolOwnerDetail=plotArray[j].getNajoolOwnerDetails();
										
										log.fatal("ownerDetail "+najoolOwnerDetail==null?"NULL":najoolOwnerDetail.length);
						                  
										log.fatal("ownerDetail "+najoolOwnerDetail.length);
										
										if(najoolOwnerDetail.length<=0){
											
											lrModel.setOcdname(plotArray[j].getDepartment());
											lrModel.setOcdname1(plotArray[j].getDepartment());
											manager.addLRTransaction(lrModel,2);
										
										}
										if(najoolOwnerDetail!=null){
										for(int x=0;x<najoolOwnerDetail.length;x++)
										{
											
											log.fatal("ownerDetail "+najoolOwnerDetail[x].getOwnerName());
											log.fatal("ownerDetail "+najoolOwnerDetail[x].getOwnerName());
											
											
											lrModel.setAadharno("");	
											lrModel.setGender("");
											lrModel.setLoanpassbook("");
											lrModel.setMobileno(najoolOwnerDetail[x].getMobileno());
											lrModel.setOaddr1(najoolOwnerDetail[x].getAddress());
											lrModel.setOcaste_code("");
											lrModel.setOcdname(najoolOwnerDetail[x].getOwnerName());
											lrModel.setOcastenm("");
											lrModel.setOcdname1(najoolOwnerDetail[x].getOwnerName());
											lrModel.setOfather("");
											lrModel.setOfather1("");
											lrModel.setCreated_by(Integer.parseInt(empID));
											lrModel.setUpdated_by(Integer.parseInt(empID));
											lrModel.setCreated_date(currentDateValue);
											lrModel.setUpdated_date(currentDateValue);
											manager.addLRTransaction(lrModel,1);
										}
										}
										
										log.fatal("Hi I am here i");
										
									}
									
								}
									 else
										{
											khasraValue.append("false,");
										}
									}
									 else
										{
											khasraValue.append("false,");
										}
							 
							 
							 
							 
							 
							 
							
						}
						
						
						
						
						
						
						
						else if(model.getKhasra_type().equalsIgnoreCase("global_khasra_type_3"))
						{
							
							plotNo=model.getPlot_no();
							recordCode=model.getLr_najool_sheet();
							
							 
								if(Float.parseFloat(areaValue.trim().length()>0?areaValue:"0")>0){
									
									DiversionPlotDetails[] plotArray=	lrService.getWebServiceForRegistrationDeptNewSoap().toGetDiversionDetails(plotNo, recordCode) ;
									
								log.fatal(" Diversion Detail from Service "+plotArray.length);
								
									 if(plotArray!=null){
										 
									
									
									log.fatal(" Token_no "+token_no+" Diversion.length "+plotArray.length);
									
									
									for(int j=0;j<plotArray.length;j++)
									{
										Date currentDateValue = new Date();
										khasraValue.append("true,");
										
										
										log.fatal(" Token_no "+token_no+" Date "+this.token_date+" Location "+dsr_location+" Khasra_No "+plotArray[j].getArea_foot());	 
										
										log.fatal(" Token_no "+token_no+" Date "+this.token_date+" Location "+dsr_location+" Khasra_No "+plotArray[j].getArea_foot());
										
										
										lrTransactionDetailModel lrModel =new lrTransactionDetailModel();
										lrModel.setToken_no(token_no);
										lrModel.setToken_date(this.token_date);
										lrModel.setDsr_location(Integer.parseInt(dsr_location));
										lrModel.setArea(plotArray[j].getArea_foot());
										lrModel.setKhasra_no(plotArray[j].getPlotno());
										lrModel.setNakshaurl("");
										lrModel.setVillage_code(villageCode);
										
										
										

										
										DiversionOwnerDetails[] najoolOwnerDetail=plotArray[j].getDiversionOwnerDetails();
										
										log.fatal("Diversion ownerDetail "+najoolOwnerDetail==null?"NULL":najoolOwnerDetail.length);
						                  
										log.fatal("Diversion ownerDetail "+najoolOwnerDetail.length);
										
										if(najoolOwnerDetail.length<=0){
											
											lrModel.setOcdname(plotArray[j].getDepartment());
											lrModel.setOcdname1(plotArray[j].getDepartment());
											manager.addLRTransaction(lrModel,2);
										
										}
										if(najoolOwnerDetail!=null){
										for(int x=0;x<najoolOwnerDetail.length;x++)
										{
											
											log.fatal("Diversion ownerDetail "+najoolOwnerDetail[x].getOwnerName());
											log.fatal("Diversion ownerDetail "+najoolOwnerDetail[x].getOwnerName());
											
											
											lrModel.setAadharno("");	
											lrModel.setGender("");
											lrModel.setLoanpassbook("");
											lrModel.setMobileno(najoolOwnerDetail[x].getMobileno());
											lrModel.setOaddr1(najoolOwnerDetail[x].getAddress());
											lrModel.setOcaste_code("");
											lrModel.setOcdname(najoolOwnerDetail[x].getOwnerName());
											lrModel.setOcastenm("");
											lrModel.setOcdname1(najoolOwnerDetail[x].getOwnerName());
											lrModel.setOfather("");
											lrModel.setOfather1("");
											lrModel.setCreated_by(Integer.parseInt(empID));
											lrModel.setUpdated_by(Integer.parseInt(empID));
											lrModel.setCreated_date(currentDateValue);
											lrModel.setUpdated_date(currentDateValue);
											manager.addLRTransaction(lrModel,1);
										}
										}
										
										log.fatal("Hi I am here i");
										
									}
									
								}
									 else
										{
											khasraValue.append("false,");
										}
									}
									 else
										{
											khasraValue.append("false,");
										}
							 
							 
							 
							 
							 
							 
							
						}

						
						
						
						
						
					}
				
			
			    }
				catch(Exception e){
					log.fatal(helper.writeLogInUpperCase(e));
				}
			*/
			this.setPrintFlag(true);
			this.emptyField();
			this.addActionMessage(returnMessage);
			return "success";
		} else {
			this.setPrintFlag(true);
			this.emptyField();
			this.addActionMessage(returnMessage);
			//this.addActionError(returnMessage);
			return "success";
		}

	}

	@SkipValidation
	public String exitDeedDetail() throws Exception {
		return "home";
	}

	public void validate() {
		try {

			this.setEdit(false);
			this.execute();

			deedCategoryModel deedCategoryModel = manager
					.searchSingleRowDeedCategory(Integer.parseInt(language),
							Integer.parseInt(deed_category_id));

			if ((empID == null) 
					|| (language == null) || (empID.trim().length() == 0)
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

			else if (!validator.requiredFiledValidate(new_no_of_total_pages
					.trim())) {
				this.addFieldError("new_no_of_total_pages",
						"Total Page can't be empty");
			} else if (!validator.validateIntegerField(String.valueOf(
					new_no_of_total_pages).trim())) {
				this.addFieldError("new_no_of_total_pages",
						"Total Page is not Valid");

			} else if (Integer.parseInt(this.no_total_pages) != Integer.parseInt(this.new_no_of_total_pages)) {
				this.addFieldError("new_no_of_total_pages",
						"Total Page mismatch, Can't Proceed");

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

			else if ((isPermission_no_required())
					&& (!validator.requiredFiledValidate(permission_no.trim()))) {
				this.addFieldError("permission_no",
						"Permission No. is required");
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

			} /*else if (!validator.validateNameField(remarks.trim(),
					this.language)) {
				this.addFieldError("remarks", "Remarks is not valid");

			}*/
			
		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));
		}
	}

	@SkipValidation
	public void emptyField() throws Exception {
		try {

			//Date currentDateValue = new Date();
			/*int returnMessage = helper.userLogActin(token_no,
					sdf1.parse(sdf1.format(token_date)), Integer.parseInt(dsr_location),
					Integer.parseInt(empID), "Deed_Detail_Entry", "END");
*/
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
			//this.districtList.clear();
			//this.dsrLocationList.clear();
			this.deedTypeList.clear();
			this.deedCategoryList.clear();
			this.setNew_no_of_total_pages("");
			this.setPermission_no("");
			this.setRemarks("");
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
	}

}
