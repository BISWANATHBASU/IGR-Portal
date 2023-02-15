package com.igr.registration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

//import Encryption.AESEncrypt;
//import Encryption.ChecksumMD5;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import com.igr.commonUtility.CommonFourOptionsVO;
import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonValidation;
import com.igr.commonUtility.Datasource;
import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.PaymentModel;
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.deedDetailModel;
//import com.igr.hibernate.model.feeCollectionModel;
//import com.igr.hibernate.model.userLogModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.toml.dp.util.AES128Bit;
import com.igr.hibernate.model.feeStructureModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PaymentAction1 extends ActionSupport implements
		ServletContextAware, ServletRequestAware, SessionAware {
	
	private static final long serialVersionUID = 1L;
	private Map<String,Object> sessionMap;
	private String req_param;
	private String encElement;
	private String merchant_code;
	private String empID = "";
	private String branchCode = "";
	private String groupID = "";
	private String locationName = "";
	private String districtID = "";
	private String districtName = "";
	private String language = "";
	private Date tran_datetime;
	private String encdata;
	private String sbi_ref_no;
	private String amount_paid;
	private String tran_status;
	private String tran_status_desc;
	private String payment_method;
	private String bank_name;
	private String checkSum;
	
	private String tran_status_sbi;
	private Boolean checksum_match;
	private Boolean dv_status;
	
	private String token_no;
	private Date token_date;
	private String district_id;
	private String dsr_location;
	private String dsr_location_desc;
	private String considered_amount;
	private String e_registration_code;
	private String presented_stamp_value;
	private String no_total_pages;
	private double doc_min_amount;
	private String applicable_stamp_value;
	private String check_slip_count;
	private String presenter_name;
	private String first_party_executant_name;
	private boolean edit;
	private String deed_type_id;
	private String deed_category_id;
	private double stampValue = 0f;
	private String spFee;
	private String registrationFee;
	private boolean printFlag;
	private String dummyTokenDate;
	private String visit_fee;
	private String digar_tahasil_fee;
	private String bookID;
	private String deed_name;
	private String calculation_on;
	private String fileName;

	private Date app_date1;

	public Date getApp_date1() {
		return app_date1;
	}

	public void setApp_date1(Date app_date1) {
		this.app_date1 = app_date1;
	}

	private static InsertOperation insertOperation = new InsertOperation();

	private String reportTokenDate;
	private ServletContext context;
	private HttpServletRequest request;

	private List<CommonOptionsVO> dsrLocationList;
	private List<CommonOptionsVO> districtList;
	private List<CommonOptionsVO> visit_fee_List;
	private List<CommonOptionsVO> digar_tahasil_fee_List;

	private List<CommonOptionsVO> registration_fee_List;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");

	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();
	/*private static final Logger log = Logger.getLogger(PaymentAction.class);*/
	private static Logger log = Logger.getLogger(PaymentAction1.class);

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCalculation_on() {
		return calculation_on;
	}

	public void setCalculation_on(String calculation_on) {
		this.calculation_on = calculation_on;
	}

	public String getDeed_name() {
		return deed_name;
	}

	public void setDeed_name(String deed_name) {
		this.deed_name = deed_name;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getDummyTokenDate() {
		return dummyTokenDate;
	}

	public void setDummyTokenDate(String dummyTokenDate) {
		this.dummyTokenDate = dummyTokenDate;
	}

	public String getReportTokenDate() {
		return reportTokenDate;
	}

	public void setReportTokenDate(String reportTokenDate) {
		this.reportTokenDate = reportTokenDate;
	}

	public boolean isPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(boolean printFlag) {
		this.printFlag = printFlag;
	}

	public String getToken_no() {
		return token_no;
	}

	public String getCheck_slip_count() {
		return check_slip_count;
	}

	public void setCheck_slip_count(String check_slip_count) {
		this.check_slip_count = check_slip_count;
	}

	public void setToken_no(String token_no) {
		this.token_no = token_no;
	}

	public String getDeed_type_id() {
		return deed_type_id;
	}

	public String getVisit_fee() {
		return visit_fee;
	}

	public void setVisit_fee(String visit_fee) {
		this.visit_fee = visit_fee;
	}

	public List<CommonOptionsVO> getVisit_fee_List() {
		return visit_fee_List;
	}

	public String getDigar_tahasil_fee() {
		return digar_tahasil_fee;
	}

	public void setDigar_tahasil_fee(String digar_tahasil_fee) {
		this.digar_tahasil_fee = digar_tahasil_fee;
	}

	public List<CommonOptionsVO> getDigar_tahasil_fee_List() {
		return digar_tahasil_fee_List;
	}

	public void setDigar_tahasil_fee_List(
			List<CommonOptionsVO> digar_tahasil_fee_List) {
		this.digar_tahasil_fee_List = digar_tahasil_fee_List;
	}

	public void setVisit_fee_List(List<CommonOptionsVO> visit_fee_List) {
		this.visit_fee_List = visit_fee_List;
	}

	public void setDeed_type_id(String deed_type_id) {
		this.deed_type_id = deed_type_id;
	}

	public String getDeed_category_id() {
		return deed_category_id;
	}

	public void setDeed_category_id(String deed_category_id) {
		this.deed_category_id = deed_category_id;
	}

	public Date getToken_date() {
		return token_date;
	}

	public void setToken_date(Date token_date) {
		this.token_date = token_date;
	}

	public String getSpFee() {
		return spFee;
	}

	public void setSpFee(String spFee) {
		this.spFee = spFee;
	}

	public String getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(String registrationFee) {
		this.registrationFee = registrationFee;
	}

	public String getDistrict_id() {
		return district_id;
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

	public String getConsidered_amount() {
		return considered_amount;
	}

	public void setConsidered_amount(String considered_amount) {
		this.considered_amount = considered_amount;
	}

	public String getE_registration_code() {
		return e_registration_code;
	}

	public void setE_registration_code(String e_registration_code) {
		this.e_registration_code = e_registration_code;
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

	public double getDoc_min_amount() {
		return doc_min_amount;
	}

	public void setDoc_min_amount(double doc_min_amount) {
		this.doc_min_amount = doc_min_amount;
	}

	public String getApplicable_stamp_value() {
		return applicable_stamp_value;
	}

	public void setApplicable_stamp_value(String applicable_stamp_value) {
		this.applicable_stamp_value = applicable_stamp_value;
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

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.context = arg0;
	}
	
	public Date getTran_datetime() {
		return tran_datetime;
	}

	public void setTran_datetime(Date tran_datetime) {
		this.tran_datetime = tran_datetime;
	}
	
	
	
	public List<CommonOptionsVO> getRegistration_fee_List() {
		return registration_fee_List;
	}

	public void setRegistration_fee_List(List<CommonOptionsVO> registration_fee_List) {
		this.registration_fee_List = registration_fee_List;
	}
	
	
	/*****************/
	private String DeptRefNo;
	private String userid;
	private String usrname;
	private String name;
	private String dept;
	private String major_head;
	private String submajor_head;
	private String minor_head;
	private String sub_head;
	private String add_line1;
	private String add_line2;
	private String add_line3;
	private String add_line4;
	private String dist_add;
	private String state;
	private String pincode;
	private String email;
	private String ph_no;
	private String TIN;
	private String district;
	private String assmt_year;
	private String from_period;
	private String to_period;
	private String purpose;
	private String office;
	private String engine_no;
	private String chasis_no;
	private String ddocode;
	private String int_code;

	public String getDeptRefNo() {
		return DeptRefNo;
	}

	public void setDeptRefNo(String deptRefNo) {
		DeptRefNo = deptRefNo;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getMajor_head() {
		return major_head;
	}

	public void setMajor_head(String major_head) {
		this.major_head = major_head;
	}

	public String getSubmajor_head() {
		return submajor_head;
	}

	public void setSubmajor_head(String submajor_head) {
		this.submajor_head = submajor_head;
	}

	public String getMinor_head() {
		return minor_head;
	}

	public void setMinor_head(String minor_head) {
		this.minor_head = minor_head;
	}

	public String getSub_head() {
		return sub_head;
	}

	public void setSub_head(String sub_head) {
		this.sub_head = sub_head;
	}

	public String getAdd_line1() {
		return add_line1;
	}

	public void setAdd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}

	public String getAdd_line2() {
		return add_line2;
	}

	public void setAdd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}

	public String getAdd_line3() {
		return add_line3;
	}

	public void setAdd_line3(String add_line3) {
		this.add_line3 = add_line3;
	}

	public String getAdd_line4() {
		return add_line4;
	}

	public void setAdd_line4(String add_line4) {
		this.add_line4 = add_line4;
	}

	public String getDist_add() {
		return dist_add;
	}

	public void setDist_add(String dist_add) {
		this.dist_add = dist_add;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPh_no() {
		return ph_no;
	}

	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}

	public String getTIN() {
		return TIN;
	}

	public void setTIN(String tIN) {
		TIN = tIN;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAssmt_year() {
		return assmt_year;
	}

	public void setAssmt_year(String assmt_year) {
		this.assmt_year = assmt_year;
	}

	public String getFrom_period() {
		return from_period;
	}

	public void setFrom_period(String from_period) {
		this.from_period = from_period;
	}

	public String getTo_period() {
		return to_period;
	}

	public void setTo_period(String to_period) {
		this.to_period = to_period;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getEngine_no() {
		return engine_no;
	}

	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}

	public String getChasis_no() {
		return chasis_no;
	}

	public void setChasis_no(String chasis_no) {
		this.chasis_no = chasis_no;
	}

	public String getDdocode() {
		return ddocode;
	}

	public void setDdocode(String ddocode) {
		this.ddocode = ddocode;
	}

	public String getInt_code() {
		return int_code;
	}

	public void setInt_code(String int_code) {
		this.int_code = int_code;
	}
	
	private String paymentFor;
	
	public String getPaymentFor() {
		return paymentFor;
	}
	public void setPaymentFor(String paymentFor) {
		this.paymentFor = paymentFor;
	}
	
	private String stamp_fee_type;
	private String payButton;

	public String getStamp_fee_type() {
		return stamp_fee_type;
	}

	public void setStamp_fee_type(String stamp_fee_type) {
		this.stamp_fee_type = stamp_fee_type;
	}

	public String getPayButton() {
		return payButton;
	}

	public void setPayButton(String payButton) {
		this.payButton = payButton;
	}

	@SkipValidation
	public String execute() throws Exception {
		String returnValue = SUCCESS;
		//userLogModel logModel = new userLogModel();
		int returnMessage = 1;
		BigDecimal registrationFeeValue = new BigDecimal(0);
        int eStampCount=0;   
        int tressuryStampCount=0;  
        BigDecimal currentUpperSlab=new BigDecimal(0);
		BigDecimal previousUpperSlab=new BigDecimal(0);
		BigDecimal tempValue=new BigDecimal(0);
		BigDecimal valuation =new BigDecimal(0);
		int endorsementPageCount=0;
		int non_stamp_page=0;
		int difference=0;
		try {
		 
			if((this.reportTokenDate!=null)&&(this.reportTokenDate.trim().length()>=1))
				this.token_date=sdf1.parse(this.reportTokenDate);
			
			this.dummyTokenDate = sdf.format(token_date);

			empID = (String) request.getSession().getAttribute("_EMPCODE");
			branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
			groupID = (String) request.getSession().getAttribute("_USERGROUP");
			language = (String) request.getSession().getAttribute("_LANGUAGE");
			locationName = (String) request.getSession().getAttribute("LOCATIONNAME");
			districtID = (String) request.getSession().getAttribute("DISTRICT_CODE");
			districtName = (String) request.getSession().getAttribute("DISTRICT_NAME");
			JasperReport jasperReport = null;
			Connection con = null;
			JasperPrint jasperPrint = null;
			

			File reportFile = new File(request.getSession(false).getServletContext().getRealPath("/report/IGR_CHECKSLIP_PORTAL_FEE.jasper"));

			Map<String, String> reportParams = new HashMap<String, String>(2,1.0f);
			reportParams.put("lang_code", language);
			reportParams.put("token_no", token_no);
			reportParams.put("dsr_location", dsr_location);
			reportParams.put("token_date", sdf1.format(token_date));
			reportParams.put("SUBREPORT_DIR", reportFile.getParentFile().getAbsolutePath());

			jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());

			con = Datasource.getDataSource();
			jasperPrint = JasperFillManager.fillReport(jasperReport,reportParams, con);

			request.setAttribute("reportBody", jasperPrint);

			Locale locale = new Locale(language);
			ActionContext.getContext().setLocale(locale);

			//this.setRegistration_fee_type("e_Challan");

			List<CommonFourOptionsVO> allFirstPartyCapacityList = new ArrayList<CommonFourOptionsVO>();
			allFirstPartyCapacityList = (List) context.getAttribute("GLOBALDROPDOWNLOV");
			
			
			visit_fee_List = new ArrayList<CommonOptionsVO>();
			visit_fee_List = helper.extractFourData("visit_fee", this.language, allFirstPartyCapacityList);
			
			
			
			digar_tahasil_fee_List = new ArrayList<CommonOptionsVO>();
			digar_tahasil_fee_List = helper.extractFourData("yes_no", this.language, allFirstPartyCapacityList);
			

			// START INITIALIZATION OF ARRAYLISTS AND VARIABLES

			dsrLocationList = new ArrayList();
			CommonOptionsVO optionVO = new CommonOptionsVO(branchCode, locationName);
			dsrLocationList.add(optionVO);

			districtList = new ArrayList();
			CommonOptionsVO optionVO1 = new CommonOptionsVO(districtID, districtName);
			districtList.add(optionVO1);

			List<feeStructureModel> feeList = manager.searchFeeList(Integer.parseInt(language),
					Integer.parseInt(this.deed_type_id),
					Integer.parseInt(this.deed_category_id));
			
			String all_pages = manager.searchPagesForFeeEntry(Integer.parseInt(language),
					this.token_no,this.token_date,
					Integer.parseInt(this.dsr_location));
			
			
			String all_party = manager.searchPartyForFeeEntry(this.token_no,this.token_date,
					Integer.parseInt(this.dsr_location));

			bookID = manager.searchBookIdWithDeed(Integer.parseInt(language), Integer.parseInt(deed_type_id));
			
			
			String bookIDArray[]=bookID.split("~");
			
			if( bookIDArray.length>0){
				bookID=bookIDArray[0];
			    deed_name=bookIDArray[1];
			}
			
			log.fatal("feeList.size() "+feeList.size()+" "+this.deed_type_id+" "+this.deed_category_id);
			if( (feeList.size() > 0)) {
				//String all_page_array[]=all_pages.split("\\+");
				
				deedCategoryModel deedCategoryModel = manager
						.searchSingleRowDeedCategory(Integer.parseInt(language),
								Integer.parseInt(deed_category_id));
				if (deedCategoryModel.isGuideline_val_required()) {
					log.fatal("I am compare");
					
				 valuation = (new BigDecimal(this.considered_amount))
						.compareTo((new BigDecimal(this.doc_min_amount))) >= 0 ? (new BigDecimal(
						this.considered_amount)) : (new BigDecimal(
						this.doc_min_amount));
				}
				
				else if (!deedCategoryModel.isGuideline_val_required()) {
					log.fatal("I am not compare");
					valuation = new BigDecimal(this.considered_amount);
				}
						calculation_on=String.valueOf(valuation);
						
					/*if(all_page_array[0].trim().length()>0)
						eStampCount=Integer.parseInt(all_page_array[1]);*/
						
					
					
					File reportFile1 = new File(request.getSession(false)
							.getServletContext()
							.getRealPath("/report/IGR_FIRST_TOKEN_WSP.jasper"));
					
					
					int biometricPageCount=manager.SearchBiometricPage(
							token_no, token_date,
							Integer.parseInt(dsr_location));	
				
					if(biometricPageCount==2)
					endorsementPageCount=(3+ Integer.parseInt(check_slip_count));
					else
					endorsementPageCount=(3+ Integer.parseInt(check_slip_count) + Integer.parseInt(all_party));	
					
					log.fatal("endorsementPageCount "+endorsementPageCount);
					
					
					/*String stampPageSum= manager.searchSumOfStampPage(Integer.parseInt(language),
							this.token_no, this.token_date, Integer.parseInt(this.dsr_location));*/

					
					/*String challanPageCount= manager.searchChallanPage(Integer.parseInt(language),
							this.token_no, this.token_date, Integer.parseInt(this.dsr_location));
					
					String treasuryStampPageCount= manager.searchTreasuryStampPage(Integer.parseInt(language),
							this.token_no, this.token_date, Integer.parseInt(this.dsr_location));*/
					
					//non_stamp_page=Integer.parseInt(all_page_array[0])-(eStampCount+Integer.parseInt(treasuryStampPageCount)+Integer.parseInt(challanPageCount));
					
					/*log.fatal("treasuryStampPageCount "+treasuryStampPageCount);
					log.fatal("endorsementPageCount "+endorsementPageCount);
					log.fatal("non_stamp_page "+non_stamp_page);*/
					//log.fatal("all_page_array[0] "+all_page_array[0]);
					/*log.fatal("eStampCount "+eStampCount);*/
					
					
					/*if(Integer.parseInt(treasuryStampPageCount)>=endorsementPageCount)
					{
						this.no_total_pages= String.valueOf(Integer.parseInt(stampPageSum)+(Integer.parseInt(challanPageCount)*2)+non_stamp_page);
						
					}

					else
					{
						
						difference=endorsementPageCount-Integer.parseInt(treasuryStampPageCount);
						this.no_total_pages= String.valueOf(Integer.parseInt(stampPageSum)+(Integer.parseInt(challanPageCount))*2+(difference*2)+(non_stamp_page-difference));
						
					}*/
					
                         
                           if(valuation.compareTo(new BigDecimal(1000))>0){
                           BigDecimal remainder[]= valuation.divideAndRemainder(new BigDecimal(500));
                           log.fatal("Size "+remainder.length+","+remainder[0]+" "+remainder[1]);
                           
                           if(remainder[1].compareTo(new BigDecimal(0))>0)
                           {
                        	     log.fatal("Size1 "+valuation.subtract(remainder[1]));
                        	   valuation=(valuation.subtract(remainder[1])).add(new BigDecimal(500));   
                        	   log.fatal("Size3 "+valuation);
                           }
                           }
                           
                           
                          
               /*String spFeeLocation=manager.getSPFeeLocation(Integer.parseInt(this.dsr_location));
               log.fatal("I got SPFeeLocation as "+spFeeLocation+" And DSR Location "+dsr_location);
                
           if((spFeeLocation!=null)&&(spFeeLocation.trim().length()>0)&&(spFeeLocation.equals(dsr_location))){
				this.spFee = String.valueOf(Double
						.parseDouble(this.no_total_pages)
						* Double.parseDouble("60".trim()));
           }     
           else               
               this.spFee ="0";*/
				
				if((!deed_type_id.trim().equalsIgnoreCase("74"))&&(!deed_type_id.trim().equalsIgnoreCase("153"))){
					

					 ListIterator<feeStructureModel> listItrFee =  feeList.listIterator();
					 while (listItrFee.hasNext()) {
						 tempValue= new BigDecimal(0);
						  feeStructureModel feeModel = (feeStructureModel) listItrFee.next(); 
						  if (feeModel.getFee_name().equalsIgnoreCase(
								  "global_registration_fee")){
							  
							  currentUpperSlab = feeModel.getEnd_slab();
							  if((valuation.compareTo(new BigDecimal(1000))>0)&&(currentUpperSlab.compareTo(new BigDecimal(1000))>=0)){
							  if(!feeModel.isSlab_end()) {
								  if((valuation.subtract(currentUpperSlab)).compareTo(new BigDecimal(0))>0) {
									  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
										  currentUpperSlab= currentUpperSlab.subtract(previousUpperSlab);
										  tempValue =currentUpperSlab.multiply(feeModel.getRate().divide(new BigDecimal(100)));
										  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);
									  }
									  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
										  tempValue =feeModel.getRate();
									  
								  valuation = valuation.subtract(currentUpperSlab);
								  previousUpperSlab =previousUpperSlab.add(currentUpperSlab);
								    }
								  else if((valuation.subtract(currentUpperSlab)).compareTo(new BigDecimal(0)) <= 0)
								  {
									  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
										  
										  tempValue =valuation.multiply(feeModel.getRate().divide(new BigDecimal(100)));
										  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);
									  }
									  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
										  tempValue =feeModel.getRate();
									  valuation = new BigDecimal(0); 
									  
								  }
							  
						  }
							  else if ((feeModel.isSlab_end()) &&(valuation.compareTo(new BigDecimal(0)) > 0)) { 
								  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
									  tempValue =valuation.multiply(feeModel.getRate().divide(new BigDecimal(100)));
									  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);  
									  
								  }
								  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
									  tempValue =feeModel.getRate();
							  }
					 
					
						  
						  registrationFeeValue= registrationFeeValue.add(tempValue);
						  
				
						  }
							  
							  
							  else    if((valuation.compareTo(new BigDecimal(1000))<=0)&&(currentUpperSlab.compareTo(new BigDecimal(1000))<0)){

								

								  if(!feeModel.isSlab_end()) {
									  if((valuation.subtract(currentUpperSlab)).compareTo(new BigDecimal(0))>0) {
										  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
											  currentUpperSlab= currentUpperSlab.subtract(previousUpperSlab);
											  tempValue =currentUpperSlab.multiply(feeModel.getRate().divide(new BigDecimal(100)));
											  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);
										  }
										  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
											  tempValue =feeModel.getRate();
										  
									  valuation = valuation.subtract(currentUpperSlab);
									  previousUpperSlab =previousUpperSlab.add(currentUpperSlab);
									    }
									  else if((valuation.subtract(currentUpperSlab)).compareTo(new BigDecimal(0)) <= 0)
									  {
										  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
											  
											  tempValue =valuation.multiply(feeModel.getRate().divide(new BigDecimal(100)));
											  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);
										  }
										  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
											  tempValue =feeModel.getRate();
										  valuation = new BigDecimal(0); 
										  
									  }
								  
							  }
								  else if ((feeModel.isSlab_end()) &&(valuation.compareTo(new BigDecimal(0)) >= 0)) { 
									  if(feeModel.getCalc_type().equalsIgnoreCase("global.p")){
										  tempValue =valuation.multiply(feeModel.getRate().divide(new BigDecimal(100)));
										  log.fatal(currentUpperSlab+","+feeModel.getRate()+","+feeModel.getRate().divide(new BigDecimal(100))+","+tempValue);  
										  
									  }
									  else if (feeModel.getCalc_type().equalsIgnoreCase("global.f"))
										  tempValue =feeModel.getRate();
								  }
						 
						
								  log.fatal("I am here at "+feeModel.getCalc_type()+","+feeModel.getRate()+","+tempValue);
								  
							  registrationFeeValue= registrationFeeValue.add(tempValue);
							  }			  
					 }
				}
				
				}else if((deed_type_id.trim().equalsIgnoreCase("74"))||(deed_type_id.trim().equalsIgnoreCase("153"))){
					
					
					String returnLeaseDeed=helper.getRegistrationFeeForLeaseDeed(token_no, token_date, Integer.parseInt(dsr_location));
					String returnLeaseDeedArray[]=returnLeaseDeed.split("~");
					registrationFeeValue=new BigDecimal(returnLeaseDeedArray[0]);
					calculation_on=returnLeaseDeedArray[1];
					
					log.fatal("I am in Lease DEEd "+returnLeaseDeed);
					
					log.fatal("I am in Lease DEEd "+returnLeaseDeedArray[0]+" "+returnLeaseDeedArray[1]);
				}
				
				
				this.registrationFee = String.valueOf(registrationFeeValue.setScale(0, RoundingMode.CEILING));
				log.fatal("in execute:"+registrationFee);
			}
			
			 /* ListIterator<feeStructureModel> listItrProperty = feeList
			  .listIterator(); while (listItrProperty.hasNext()) {
			  feeStructureModel feeModel = (feeStructureModel) listItrProperty
			  .next(); if
			  (feeModel.getFee_name().equalsIgnoreCase("global_sp_fee")) {
			  this.spFee = String.valueOf(Float
			  .parseFloat(this.no_total_pages) feeModel.getFee_rate()); }
			  
			  if (feeModel.getFee_name().equalsIgnoreCase(
			  "global_registration_fee")) { currentUpperSlab =
			  feeModel.getUpper_slab(); if
			  (feeModel.isSlab_end().trim().equalsIgnoreCase("false")) { if
			  ((valuation - currentUpperSlab) > 0) { registrationFeeValue +=
			  (((currentUpperSlab - previousUpperSlab) / 1000) * feeModel
			  .getFee_rate()); valuation = valuation - currentUpperSlab;
			  previousUpperSlab = currentUpperSlab; } else if ((valuation -
			  currentUpperSlab) <= 0) { registrationFeeValue += (valuation /
			  1000) * feeModel .getFee_rate(); valuation = 0; }
			  
			  } else if ((feeModel.isSlab_end().equalsIgnoreCase("true")) &&
			  (valuation > 0)) { registrationFeeValue += (valuation / 1000)
			  feeModel.getFee_rate();
			  
			  }
			  
			  }
			  
			  }*/
			
			fileName = "/home/jboss/DR/";

		//	fileName = "E://";
			
		
			
		/*String	result = manager.searchERegistrationID(this.token_no,this.token_date,
				Integer.parseInt(this.dsr_location));*/

			 /*if ((result!=null)&&(!result.trim().equalsIgnoreCase("null"))&&(result.trim().length() > 0)) {
				fileName=fileName+result+"_DR.pdf";
			}
			 else{
				 fileName ="";
			 }*/

			/*if (isEdit()) {

				Date currentDateValue = new Date();
				returnMessage = helper.userLogActin(
						Integer.parseInt(token_no), currentDateValue,
						Integer.parseInt(dsr_location),
						Integer.parseInt(empID), "Fee_Entry", "START");
				
				this.setEdit(false);
			}*/

			// END INITIALIZATION OF ARRAYLISTS AND VARIABLES
			Locale locale1 = new Locale(language);
			ActionContext.getContext().setLocale(locale);

		} catch (Exception e) {
			returnMessage = 0;
			log.fatal(helper.writeLogInUpperCase(e));
			this.addActionError(getText("global.system.error"));
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
	public String paymentFinal() throws Exception{
		


		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;
		
		
		
		
		try {

			empID = (String) request.getSession().getAttribute("_EMPCODE");
			language = (String) request.getSession().getAttribute("_LANGUAGE");
	
			
			log.fatal("My DSR Location " + this.dsr_location + "," + this.token_no + "," + this.token_date+", "+this.dsr_location+" "+language+" "+empID);
			
		
		
			/*insertOperationMessage = insertOperation.insertAppoimentDeatil(this.token_no, this.token_date, Integer.parseInt(this.dsr_location),Integer.parseInt(language), Integer.parseInt(empID),this.app_date1);

			if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("1")) {
				operationFlag = true;
			}

			else if (insertOperationMessage.trim().substring(0, 1)
					.equalsIgnoreCase("0")) {
				operationFlag = false;
			}*/
			insertOperationMessage = "1-";

			returnMessage = insertOperationMessage.substring(1,insertOperationMessage.trim().length());

		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

		if (operationFlag) {
			this.setPrintFlag(true);
			//this.emptyField();
			this.addActionMessage(returnMessage);
			return "success";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}

	
		
	}
	
	private String registration_fee_type;
	
	
	public String getRegistration_fee_type() {
		return registration_fee_type;
	}

	public void setRegistration_fee_type(String registration_fee_type) {
		this.registration_fee_type = registration_fee_type;
	}

	private String registrationFeeType;

	public String getRegistrationFeeType() {
		return registrationFeeType;
	}

	public void setRegistrationFeeType(String registrationFeeType) {
		this.registrationFeeType = registrationFeeType;
	}
	
	@SkipValidation
	public String paymentAcept(){
		log.fatal("Payment Acept Button Click");
		return SUCCESS;
	}
	
	/*public String paymentReject(){
		log.fatal("Payment Reject Button Click");
		return SUCCESS;
	}*/
	
	private String sendURL;
	public String getSendURL() {
		return sendURL;
	}

	public void setSendURL(String sendURL) {
		this.sendURL = sendURL;
	}

	@SkipValidation
	public String paymentConfirm(){
		log.fatal("in payment final");
		String actionValue="home";
		try{
		PaymentModel paymentModel=new PaymentModel();
		boolean returnValue=false;
		tran_datetime=new Date();
		try{
			log.fatal(this.registrationFee);
			paymentModel.setDsr_location(Integer.parseInt(dsr_location));
			log.fatal("in payment final 2");
			paymentModel.setToken_no(this.token_no);
			paymentModel.setTotal_amount(new BigDecimal(0));
			log.fatal("registrationFee="+new BigDecimal(this.registrationFee));
			paymentModel.setReg_fee(new BigDecimal(this.registrationFee));
			paymentModel.setOther_fee(new BigDecimal(0));
			paymentModel.setSp_fee(new BigDecimal(0));
			paymentModel.setToken_date(this.token_date);
			log.fatal("token_date"+this.token_date);
			paymentModel.setTran_datetime(tran_datetime);
			log.fatal(tran_datetime);
			paymentModel.setPayment_method(this.registrationFeeType);
			log.fatal("registration_fee_type====="+registrationFeeType);
			
			//paymentModel.setApp_Date(app_date1);
			//log.fatal(app_date1);
			
			/*if(app_date1!=null && app_date1.length()>0){
				app_timestamp=app_date1+" "+hhmm;
				log.fatal("app_timestamp:--------->>>>>"+app_timestamp);
				/*this.app_date=formatter.format(app_timestamp);*/
				/*Calendar c=Calendar.getInstance();
				c.set(c.t, value);*
				this.app_date=formatter.parse(app_timestamp);
				}
				else{
					this.app_date=null;
				}*/
			empID = (String) request.getSession().getAttribute("_EMPCODE");
			language = (String) request.getSession().getAttribute("_LANGUAGE");

			log.fatal("Data Updating With Appoiment Time="+this.token_no);
			log.fatal("Data Updating With Appoiment Time="+this.token_date);
			log.fatal("Data Updating With Appoiment Time="+Integer.parseInt(this.dsr_location));
			log.fatal("Data Updating With Appoiment Time="+Integer.parseInt(language));
			log.fatal("Data Updating With Appoiment Time="+Integer.parseInt(empID));
			log.fatal("Data Updating With Appoiment Time="+this.app_date1);
			
			String insertOperationMessage = "0";
			
			if(this.registrationFeeType == "Paid_at_Office" || this.registrationFeeType.equalsIgnoreCase("Paid_at_Office")){
				log.fatal("Inserting Cash Payment Data");
				insertOperationMessage = insertOperation.insertAppoimentDeatil(this.token_no, this.token_date,Integer.parseInt(this.dsr_location),Integer.parseInt(language), Integer.parseInt(empID),this.app_date1);
			}
			
			log.fatal("paymentConfirm Updation ............"+insertOperationMessage);
			
			returnValue = new HibernateManager().insertPayment(paymentModel);
			log.fatal(returnValue);
		}catch(Exception e){
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			this.addActionError("System Error. Contact IT");
		}
		
		log.fatal("sendURL="+sendURL);
		
		
		
		if(returnValue){
			
			log.fatal("sendURL="+sendURL);
			
			
			if(sendURL == "bank" || sendURL.equalsIgnoreCase("bank")){
				AES128Bit a = new AES128Bit();
				
				String MerchantId = "1000356";
				String OperatingMode = "DOM";
				String MerchantCountry = "IN";
				String MerchantCurrency = "INR";
				String PostingAmount = "100";
		
				String OtherDetails = "other";
				String SuccessURL = "https://epanjeeyan.cg.gov.in/SBITesting/success.jsp";
				String FailURL = "https://epanjeeyan.cg.gov.in/SBITesting/fail.jsp";
				String AggregatorId = "SBIEPAY";
				String MerchantOrderNo = helper.getPrimaryNo();//"Date Time";//Unique
		
				String MerchantCustomerID = "T44001";
				String Paymode = "NB";
				String Accesmedium = "ONLINE";
				String TransactionSource = "ONLINE";
				
				//String merchIdVal = MerchantId;
			
				
				//String MultiAccountInstructionDtls  = "50|INR|TCO||50|INR|AAT";
				String requestparameter = MerchantId+"|"+OperatingMode+"|"+MerchantCountry+"|"+MerchantCurrency+"|"+PostingAmount+"|"+OtherDetails+"|"+SuccessURL+"|"+FailURL+"|"+AggregatorId+"|"+MerchantOrderNo+"|"+MerchantCustomerID+"|"+Paymode+"|"+Accesmedium+"|"+TransactionSource;
				
				String MultiAccountInstructionDtls  = "50|INR|TCO||50|INR|AAT";
				
				String Key = "BUEPMt7xhYV/BxluRa39gQ==";

				String EncryptTrans = AES128Bit.encrypt(requestparameter, Key);
				String MultEncryptTrans = AES128Bit.encrypt(MultiAccountInstructionDtls, Key);
				
				EncryptTrans = EncryptTrans.replaceAll("\n","");
				MultEncryptTrans = MultEncryptTrans.replaceAll("\n","");
				
				log.fatal("Encript Trans Data="+EncryptTrans);
				log.fatal("Multipale Encript Trans Data="+MultEncryptTrans);
				
				actionValue=SUCCESS;
			}
			else{
			//this.req_param = "DeptRefNo="+DeptRefNo;
			String secret = "HSUBPMAKM2RCPSCB2K2A2";
			
			//String finalTxt = "DeptRefNo="+this.DeptRefNo+"|userid="+this.userid+"|usrname="+this.usrname+"|name="+this.name+"|dept="+this.dept+"|major_head="+this.major_head+"|submajor_head="+this.submajor_head+"|minor_head="+this.minor_head+"|sub_head="+this.sub_head+"|add_line1="+this.add_line1+"|add_line2="+this.add_line2+"|add_line3="+this.add_line3+"|add_line4="+this.add_line4+"|dist_add="+this.dist_add+"|state="+this.state+"|pincode="+this.pincode+"|email="+this.email+"|ph_no="+this.ph_no+"|TIN="+this.TIN+"|district="+this.district+"|assmt_year="+this.assmt_year+"|from_period="+this.from_period+"|to_period="+this.to_period+"|purpose="+this.purpose+"|office="+this.office+"|engine_no="+this.engine_no+"|chasis_no="+this.chasis_no+"|ddocode="+this.ddocode+"|int_code="+this.int_code;
			//String finalTxt = this.DeptRefNo+"|"+this.userid+"|"+this.usrname+"|"+this.name+"|"+this.dept+"|"+this.major_head+"|"+this.submajor_head+"|"+this.minor_head+"|"+this.sub_head+"|"+this.add_line1+"|"+this.add_line2+"|"+this.add_line3+"|"+this.add_line4+"|"+this.dist_add+"|"+this.state+"|"+this.pincode+"|"+this.email+"|"+this.ph_no+"|"+this.TIN+"|"+this.district+"|"+this.assmt_year+"|"+this.from_period+"|"+this.to_period+"|"+this.purpose+"|"+this.office+"|"+this.engine_no+"|"+this.chasis_no+"|"+this.ddocode+"|"+this.int_code;
			String finalTxt = this.DeptRefNo+"|"+this.userid+"|"+this.usrname+"|"+this.dept+"|"+this.major_head+"|"+this.submajor_head+"|"+this.minor_head+"|"+this.sub_head+"|"+this.add_line1+"|"+this.add_line2+"|"+this.add_line3+"|"+this.add_line4+"|"+this.dist_add+"|"+this.state+"|"+this.pincode+"|"+this.email+"|"+this.ph_no+"|"+this.TIN+"|"+this.district+"|"+this.assmt_year+"|"+this.from_period+"|"+this.to_period+"|"+this.purpose+"|"+this.office+"|"+this.engine_no+"|"+this.chasis_no+"|"+this.ddocode+"|"+this.int_code;
			

	    	
	    	Connection conGet = Datasource.getDataSource();//db.getcon();
	    	Statement stmtGet = conGet.createStatement();
	    	
	    	int slno = 0;
	    	
	    	String getSlno = "select count(slno)+1 as slno from e_challan_request";
	    	ResultSet rs = stmtGet.executeQuery(getSlno);
	    	if(rs.next()){
	    		slno = rs.getInt("slno");
	    	}
	    	rs.close();
	    	stmtGet.close();
	    	conGet.close();
	    	
	    	String entryDateTime = helper.getDataTime();
	    	
	    	Connection conIns = Datasource.getDataSource();//db.getcon();
	    	Statement stmtIns = conIns.createStatement();
	    	
	    	String sql = "insert into e_challan_request (slno,userid,deptref_no,usrname,name,dept,major_head,submajor_head,minor_head,sub_head,add_line1,add_line2,add_line3,add_line4,dist_add,state,pincode,email,ph_no,TIN,district,assmt_year,from_period,to_period,purpose,office,engine_no,chasis_no,ddocode,int_code,entry_date,entry_datetime) values("+slno+",'"+this.userid+"','"+this.DeptRefNo+"','"+this.usrname+"','"+this.name+"','"+this.dept+"','"+this.major_head+"','"+this.submajor_head+"','"+this.minor_head+"','"+this.sub_head+"','"+this.add_line1+"','"+this.add_line2+"','"+this.add_line3+"','"+this.add_line4+"','"+this.dist_add+"','"+this.state+"','"+this.pincode+"','"+this.email+"','"+this.ph_no+"','"+this.TIN+"','"+this.district+"','"+this.assmt_year+"','"+this.from_period+"','"+this.to_period+"','"+this.purpose+"','"+this.office+"','"+this.engine_no+"','"+this.chasis_no+"','"+this.ddocode+"','"+this.int_code+"',now(),'"+entryDateTime+"')";
	    	int ins = stmtIns.executeUpdate(sql);
	    	if(ins > 0){
	    		log.fatal("e_challan_request Data Inserted...");
	    	}
	    	stmtIns.close();
	    	conIns.close();
	    	
			
			log.fatal("finalTxt====="+finalTxt);
			
			String checksum = helper.getMD5(finalTxt);
			log.fatal("checksum====="+checksum);
			
			String stringChecksum = finalTxt+"|"+checksum;
			
			String finalString = helper.encrypt(stringChecksum,secret);
			this.encElement = finalString;
			log.fatal("finalString====="+encElement);

			String decString = helper.decrypt(this.encElement,secret);
			log.fatal("decString====="+decString);
			
			
			/*String t_date=sdf.format(token_date);
			this.req_param="ref_no="+token_no+"|amount="+this.registrationFee+"|dsr_location="+dsr_location+"|token_date="+t_date+"|tran_datetime="+tran_datetime+"|redirect_url=https://www.epanjeeyan.cg.gov.in/IGRPortalWeb/paymentStatus.action|epanjiyan_id=-|eregistration_fees="+registrationFee+"|other_fees=0";
			ChecksumMD5 checksum=new ChecksumMD5();
			String ceckSumValue=checksum.getValue(req_param);
			this.req_param=req_param+"|checkSum="+ceckSumValue;
			log.fatal("req param:"+req_param);
			AESEncrypt encrpt=new Encryption.AESEncrypt();
			String path=ServletActionContext.getServletContext().getRealPath("/key/CG_LAND.key");
			encrpt.setSecretKey(path);
			this.encElement=encrpt.encryptFile(req_param);
			log.fatal(encElement);
			this.merchant_code="CG_LAND";
			*/
			actionValue=SUCCESS;
		}
			
		}else{
			actionValue="home";
			this.addActionError("System Error. Contact IT");
		}
		}catch(Exception e){
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));
		}
		return actionValue;
	}
	
	@SkipValidation
	public String paymentFinalStatus()throws Exception{
		//log.fatal("in payment status final");
		String actionValue="home";
		try{
			
			/*
		AESEncrypt encrpt=new Encryption.AESEncrypt();
		String path=ServletActionContext.getServletContext().getRealPath("/key/CG_LAND.key");
		encrpt.setSecretKey(path);
		log.fatal("encdata:"+encdata);
		String decData=encrpt.decryptFile(encdata);
		log.fatal(decData);
		StringTokenizer tokens=new StringTokenizer(decData, "|");
		Map<String,String> map=new LinkedHashMap<String,String>();
		while(tokens.hasMoreElements()){
			String token=tokens.nextToken();
			map.put(token.substring(0,token.indexOf('=')),token.substring(token.indexOf('=')+1,token.length()));
		}
		//String res_param=encdata.substring(0,encdata.indexOf("checkSum")-1);
		ChecksumMD5 checksum=new ChecksumMD5();
		//String ceckSumValue=checksum.getValue(res_param);
		checksum_match=checksum.getValue(decData.substring(0,decData.indexOf("checkSum")-1)).equals(map.get("checkSum"));
		tran_status_sbi=map.get("payment_status");
		if(checksum_match && tran_status_sbi.equalsIgnoreCase("success")){
			this.tran_status="global.tran.success";
			this.tran_status_desc="Transaction Completed Successfully";
		}
		else if(!checksum_match){
			this.tran_status="global.tran.checksumError";
			this.tran_status_desc="Transaction Not Done Successfully";
		}
		else if(!tran_status_sbi.equalsIgnoreCase("success")){
			this.tran_status="global.tran.failed";
		}
		
		sbi_ref_no=map.get("sbi_ref_no");
		payment_method=map.get("payment_method");
		bank_name=map.get("bank_name");
		token_no=map.get("ref_no");
		amount_paid=map.get("amount");
		PaymentModel ob=new PaymentModel();
		ob.setBank_name(bank_name);
		ob.setChecksum_match(checksum_match);
		ob.setPayment_method(payment_method);
		ob.setTran_status(tran_status);
		ob.setTran_status_desc(tran_status_desc);
		ob.setSbi_ref_no(sbi_ref_no);
		ob.setTran_status_sbi(tran_status_sbi);
		ob.setToken_no(token_no);
		ob.setTotal_amount(new BigDecimal(amount_paid));
		if(new HibernateManager().updatePayment(ob))
			
			*/
			actionValue=SUCCESS;
		}catch(Exception e){
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));
		}
		return actionValue;
		
	}

	/*public String addFeeEntry() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;

		try {

			if ((this.reportTokenDate != null)
					&& (this.reportTokenDate.trim().length() >= 1))
				this.token_date = sdf1.parse(this.reportTokenDate);

			feeCollectionModel feeModel = new feeCollectionModel();
			Date currentDateValue1 = new Date();

			feeModel.setToken_no(Integer.parseInt(this.token_no));
			feeModel.setDsr_location(Integer.parseInt(this.dsr_location));
			feeModel.setToken_date(this.token_date);

			feeModel.setDsr_location_desc(locationName);

			feeModel.setToken_time(currentDateValue1);
			feeModel.setParty_name(this.first_party_executant_name);
			feeModel.setDistrict_id(Integer.parseInt(this.district_id));
			feeModel.setLang_code(Integer.parseInt(language));
			feeModel.setCreated_by(Integer.parseInt(empID));
			feeModel.setUpdated_by(Integer.parseInt(empID));
			feeModel.setCreated_date(currentDateValue1);
			feeModel.setUpdated_date(currentDateValue1);
			feeModel.setFee1_amount(new BigDecimal(this.spFee));
			feeModel.setFee2_amount(new BigDecimal(this.registrationFee));
			feeModel.setScroll_no("");
			if ((this.visit_fee != null)
					&& (this.visit_fee.trim().length() > 0)
					&& (this.visit_fee.equalsIgnoreCase("global_visit_jail")))
				feeModel.setVisit_fee(new BigDecimal(50));
			else if ((this.visit_fee != null)
					&& (this.visit_fee.trim().length() > 0)
					&& (this.visit_fee.equalsIgnoreCase("global_visit_unable")))
				feeModel.setVisit_fee(new BigDecimal(75));
			else if ((this.visit_fee != null)
					&& (this.visit_fee.trim().length() > 0)
					&& (this.visit_fee.equalsIgnoreCase("global_visit_other")))
				feeModel.setVisit_fee(new BigDecimal(150));
			else
				feeModel.setVisit_fee(new BigDecimal(0));
			
			feeModel.setCalculation_on(new BigDecimal(this.calculation_on));
			
			

			if ((this.digar_tahasil_fee != null)
					&& (this.digar_tahasil_fee.trim().length() > 0)
					&& (this.digar_tahasil_fee.equals("true")))
				feeModel.setDigar_tahasil_fee(new BigDecimal(210));

			insertOperationMessage = insertOperation.insertFeeCollection(
					feeModel, this.token_no, this.token_date,
					Integer.parseInt(this.dsr_location),Integer.parseInt(empID),currentDateValue1);

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
			this.setPrintFlag(true);
			this.emptyField();
			this.addActionMessage(returnMessage);
			return "success";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}

	}*/

	/*
	 * public String addDeclineEntry() throws Exception {
	 * 
	 * String returnMessage = ""; String insertOperationMessage =
	 * "0-System error Occured "; boolean operationFlag = false;
	 * 
	 * try {
	 * 
	 * 
	 * log.fatal("I am in Decline Module");
	 * 
	 * 
	 * insertOperationMessage = insertOperation.insertFeeCollection( feeModel,
	 * this.token_no, this.token_date, Integer.parseInt(this.dsr_location));
	 * 
	 * if (insertOperationMessage.trim().substring(0, 1) .equalsIgnoreCase("1"))
	 * { operationFlag = true; }
	 * 
	 * else if (insertOperationMessage.trim().substring(0, 1)
	 * .equalsIgnoreCase("0")) { operationFlag = false; }
	 * 
	 * returnMessage = insertOperationMessage.substring(1,
	 * insertOperationMessage.trim().length());
	 * 
	 * } catch (Exception e) { log.fatal(helper.writeLogInUpperCase(e)); throw
	 * new Exception(getText("global.system.error")); }
	 * 
	 * if (operationFlag) { this.setPrintFlag(true); this.emptyField();
	 * this.addActionMessage(returnMessage); return "success"; } else {
	 * this.addActionError(returnMessage); return "success"; } }
	 */

	@SkipValidation
	public String exitFeeEntry() throws Exception {
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
					|| (language.trim().length() == 0)) {
				this.addActionError(getText("session.invalied"));

			} else if (!validator.requiredFiledValidate(token_no.trim())) {
				this.addFieldError("token_no", "Token No can't be empty");
			} else if (!validator.requiredFiledValidate(spFee.trim())) {
				this.addFieldError("spFee", "SP Fee can't be empty");
			} else if (!validator.requiredFiledValidate(registrationFee.trim())) {
				this.addFieldError("registrationFee",
						"Registration Fee can't be empty");
			}

			else if ((new BigDecimal(this.presented_stamp_value))
					.compareTo(new BigDecimal(this.applicable_stamp_value)) < 0) {
				this.addFieldError("applicable_stamp_value",
						"Applicable Stamp Value and Presented Stamp Value Mismatch, Can't Proceed");
			}

		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));
		}
	}

	/*@SkipValidation
	public void emptyField() throws Exception {

		try {
			
			Date currentDateValue = new Date();
			int returnMessage = helper.userLogActin(
					Integer.parseInt(token_no), currentDateValue,
					Integer.parseInt(dsr_location),
					Integer.parseInt(empID), "Fee_Entry", "END");

			this.setDsr_location("");
			this.setPresenter_name("");
			this.setFirst_party_executant_name("");
			this.setDistrict_id("");
			this.setDsr_location_desc("");
			this.setConsidered_amount("");
			this.setDoc_min_amount(0f);
			this.setApplicable_stamp_value("");
			this.setPresented_stamp_value("");
			this.setNo_total_pages("");
			this.setE_registration_code("");
			this.districtList.clear();
			this.dsrLocationList.clear();
			this.setSpFee("");
			this.setRegistrationFee("");
			this.setVisit_fee("");
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}

	}*/
	
	
	/*@SkipValidation
	public String editPermissionFee() throws Exception {

		String returnMessage = "";
		String insertOperationMessage = "0-System error Occured ";
		boolean operationFlag = false;

		try {
			log.fatal("My Token Date "+token_date);
			
			empID = (String) request.getSession().getAttribute("_EMPCODE");
			insertOperationMessage = manager.updateEditPermission(this.token_no,
					this.token_date, this.dsr_location,empID,"global_es");

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
			return "home";
		} else {
			this.addActionError(returnMessage);
			return "success";
		}

	}*/

	@SkipValidation
	public String exitPayment() throws Exception {
		return "home";
	}

	public String getReq_param() {
		return req_param;
	}

	public void setReq_param(String req_param) {
		this.req_param = req_param;
	}

	public String getEncElement() {
		return encElement;
	}

	public void setEncElement(String encElement) {
		this.encElement = encElement;
	}

	public String getMerchant_code() {
		return merchant_code;
	}

	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
	}

	public String getEncdata() {
		return encdata;
	}

	public void setEncdata(String encdata) {
		this.encdata = encdata;
	}

	public String getSbi_ref_no() {
		return sbi_ref_no;
	}

	public void setSbi_ref_no(String sbi_ref_no) {
		this.sbi_ref_no = sbi_ref_no;
	}

	public String getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(String amount_paid) {
		this.amount_paid = amount_paid;
	}

	public String getTran_status() {
		return tran_status;
	}

	public void setTran_status(String tran_status) {
		this.tran_status = tran_status;
	}

	public String getTran_status_desc() {
		return tran_status_desc;
	}

	public void setTran_status_desc(String tran_status_desc) {
		this.tran_status_desc = tran_status_desc;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}

	public String getTran_status_sbi() {
		return tran_status_sbi;
	}

	public void setTran_status_sbi(String tran_status_sbi) {
		this.tran_status_sbi = tran_status_sbi;
	}

	public Boolean isChecksum_match() {
		return checksum_match;
	}

	public void setChecksum_match(Boolean checksum_match) {
		this.checksum_match = checksum_match;
	}

	public Boolean getDv_status() {
		return dv_status;
	}

	public void setDv_status(Boolean dv_status) {
		this.dv_status = dv_status;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.sessionMap=arg0;
	}
	
	public Map<String,Object> getSession() {
		// TODO Auto-generated method stub
		return sessionMap;
	}
}
