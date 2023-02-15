package com.igr.commonUtility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.appointmentEStampModel;
import com.igr.hibernate.model.appointmentModel;
import com.igr.hibernate.model.appointmentOTPModel;
import com.igr.hibernate.model.appointmentPartyModel;
import com.igr.hibernate.util.HibernateManager;
//import com.igr.hibernate.util.String;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.util.PDFMergerUtility;

public class OfficeAppoimentAction extends ActionSupport implements SessionAware, ServletRequestAware {
	
    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(OfficeAppoimentAction.class);

	private HttpServletRequest request;
	private Map<String, Object> session = null;
	private static CommonHelper helper = new CommonHelper();
	private static CommonValidation validator = new CommonValidation();
	HibernateManager manager = new HibernateManager();
	
	private static InsertOperation insertOperation = new InsertOperation();
	private static GetAllDataFromScreen datafromScreen = new GetAllDataFromScreen();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
	
	private String another_entry;
	private String fullName;
	private String fullName1;
	private String mobileNo;
	private String mobileNo1;
	private String district_id;
	private String dsr_location;
	private String getData;
	private String otpVarify;
	private String verifyStatus;
	private String appointmentDate;
	
	private String rowNo;
	private String rowNo1;
	private String appointmentTime;
	private String appointmentTime1;
	private String appointmentNoFinal;
	private String appointmentNoFinal1;
	private String appointmentTimeFinal;
	private String dsrName;
	
	private String fatherName;
	private String complateAddress;
	private String party_type;
	private String fatherName1;
	private String complateAddress1;
	private String party_type1;
	
	private String language;
	private String e_stamp_no;
	private String e_stamp_amount;
	private String firstPartyMobileNo;
	private String secondPartyMobileNo;
	
	private String e_stamp_no1;
	private String e_stamp_amount1;
	private String firstPartyMobileNo1;
	private String secondPartyMobileNo1;
	
	private String deedType;
	
	private String fileName;
	private String fileName1;

	private List<CommonOptionsVO> districtList;
    private List<CommonOptionsVO> dsrLocationList;
    private List<CommonOptionsVO> partyTypeList;
    private List<CommonOptionsVO> appointmentDateList;
    
    private List<CommonOptionsVO> appointmentTimeList;
    private List<CommonOptionsVO> tahsilList;

    private List<CommonFiveOptionsVO> otherPartyList = new ArrayList<CommonFiveOptionsVO>();
    private List<CommonFiveOptionsVO> otherPartyList1 = new ArrayList<CommonFiveOptionsVO>();
    private List<CommonFiveOptionsVO> stampList = new ArrayList<CommonFiveOptionsVO>();
    private List<CommonOptionsVO> deedTypeList;
    
    private String rowStampNo;
    private String rowStampNo1;
    
    private List<CommonOptionsVO> deed_typeList;
    private List<CommonOptionsVO> deed_categoryList;
    
    private List<CommonOptionsVO> deed_typeList1;
    private List<CommonOptionsVO> deed_categoryList1;
    
    
    private String deed_type;
    private String deed_category;
   
    private String deed_type1;
    private String deed_category1;
   
    
    private String considered_amount;
    private String considered_amount1;
    private String stamp_value;
    private String stamp_value1;
    private BigDecimal calculate_stamp_value;
    private BigDecimal calculate_stamp_value1;
    
    private String considered_amount_req;
    private String considered_amount_req1;
    private String otpText;
    private String tahsilName;
    private String secondAppointmentNo;
    private String tahsil_view_tag;
    private String view_tag;
    
    
    
    
    
    
    
    
	public String getTahsil_view_tag() {
		return tahsil_view_tag;
	}

	public void setTahsil_view_tag(String tahsil_view_tag) {
		this.tahsil_view_tag = tahsil_view_tag;
	}

	public String getView_tag() {
		return view_tag;
	}

	public void setView_tag(String view_tag) {
		this.view_tag = view_tag;
	}

	public String getAppointmentNoFinal1() {
		return appointmentNoFinal1;
	}

	public void setAppointmentNoFinal1(String appointmentNoFinal1) {
		this.appointmentNoFinal1 = appointmentNoFinal1;
	}

	public String getSecondAppointmentNo() {
		return secondAppointmentNo;
	}

	public void setSecondAppointmentNo(String secondAppointmentNo) {
		this.secondAppointmentNo = secondAppointmentNo;
	}

	public List<CommonFiveOptionsVO> getOtherPartyList1() {
		return otherPartyList1;
	}

	public void setOtherPartyList1(List<CommonFiveOptionsVO> otherPartyList1) {
		this.otherPartyList1 = otherPartyList1;
	}

	public String getFileName1() {
		return fileName1;
	}

	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}

	public String getRowNo1() {
		return rowNo1;
	}

	public void setRowNo1(String rowNo1) {
		this.rowNo1 = rowNo1;
	}

	public String getAnother_entry() {
		return another_entry;
	}

	public void setAnother_entry(String another_entry) {
		this.another_entry = another_entry;
	}

	public String getConsidered_amount1() {
		return considered_amount1;
	}

	public void setConsidered_amount1(String considered_amount1) {
		this.considered_amount1 = considered_amount1;
	}

	public String getStamp_value1() {
		return stamp_value1;
	}

	public void setStamp_value1(String stamp_value1) {
		this.stamp_value1 = stamp_value1;
	}

	public BigDecimal getCalculate_stamp_value1() {
		return calculate_stamp_value1;
	}

	public void setCalculate_stamp_value1(BigDecimal calculate_stamp_value1) {
		this.calculate_stamp_value1 = calculate_stamp_value1;
	}

	public String getConsidered_amount_req1() {
		return considered_amount_req1;
	}

	public void setConsidered_amount_req1(String considered_amount_req1) {
		this.considered_amount_req1 = considered_amount_req1;
	}

	public String getFullName1() {
		return fullName1;
	}

	public void setFullName1(String fullName1) {
		this.fullName1 = fullName1;
	}

	public String getMobileNo1() {
		return mobileNo1;
	}

	public void setMobileNo1(String mobileNo1) {
		this.mobileNo1 = mobileNo1;
	}

	public String getAppointmentTime1() {
		return appointmentTime1;
	}

	public void setAppointmentTime1(String appointmentTime1) {
		this.appointmentTime1 = appointmentTime1;
	}

	public String getFatherName1() {
		return fatherName1;
	}

	public void setFatherName1(String fatherName1) {
		this.fatherName1 = fatherName1;
	}

	public String getComplateAddress1() {
		return complateAddress1;
	}

	public void setComplateAddress1(String complateAddress1) {
		this.complateAddress1 = complateAddress1;
	}

	public String getParty_type1() {
		return party_type1;
	}

	public void setParty_type1(String party_type1) {
		this.party_type1 = party_type1;
	}

	public String getE_stamp_no1() {
		return e_stamp_no1;
	}

	public void setE_stamp_no1(String e_stamp_no1) {
		this.e_stamp_no1 = e_stamp_no1;
	}

	public String getE_stamp_amount1() {
		return e_stamp_amount1;
	}

	public void setE_stamp_amount1(String e_stamp_amount1) {
		this.e_stamp_amount1 = e_stamp_amount1;
	}

	public String getFirstPartyMobileNo1() {
		return firstPartyMobileNo1;
	}

	public void setFirstPartyMobileNo1(String firstPartyMobileNo1) {
		this.firstPartyMobileNo1 = firstPartyMobileNo1;
	}

	public String getSecondPartyMobileNo1() {
		return secondPartyMobileNo1;
	}

	public void setSecondPartyMobileNo1(String secondPartyMobileNo1) {
		this.secondPartyMobileNo1 = secondPartyMobileNo1;
	}

	public String getRowStampNo1() {
		return rowStampNo1;
	}

	public void setRowStampNo1(String rowStampNo1) {
		this.rowStampNo1 = rowStampNo1;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
    
    public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public String getGetData() {
		return getData;
	}

	public void setGetData(String getData) {
		this.getData = getData;
	}

	public String getOtpVarify() {
		return otpVarify;
	}

	public void setOtpVarify(String otpVarify) {
		this.otpVarify = otpVarify;
	}

	public List<CommonOptionsVO> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<CommonOptionsVO> districtList) {
		this.districtList = districtList;
	}

	public List<CommonOptionsVO> getDsrLocationList() {
		return dsrLocationList;
	}

	public void setDsrLocationList(List<CommonOptionsVO> dsrLocationList) {
		this.dsrLocationList = dsrLocationList;
	}

	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public List<CommonOptionsVO> getPartyTypeList() {
		return partyTypeList;
	}

	public void setPartyTypeList(List<CommonOptionsVO> partyTypeList) {
		this.partyTypeList = partyTypeList;
	}

	public String getRowNo() {
		return rowNo;
	}

	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public List<CommonOptionsVO> getAppointmentDateList() {
		return appointmentDateList;
	}

	public void setAppointmentDateList(List<CommonOptionsVO> appointmentDateList) {
		this.appointmentDateList = appointmentDateList;
	}

	public List<CommonOptionsVO> getAppointmentTimeList() {
		return appointmentTimeList;
	}

	public void setAppointmentTimeList(List<CommonOptionsVO> appointmentTimeList) {
		this.appointmentTimeList = appointmentTimeList;
	}

	public String getAppointmentNoFinal() {
		return appointmentNoFinal;
	}

	public void setAppointmentNoFinal(String appointmentNoFinal) {
		this.appointmentNoFinal = appointmentNoFinal;
	}

	public String getAppointmentTimeFinal() {
		return appointmentTimeFinal;
	}

	public void setAppointmentTimeFinal(String appointmentTimeFinal) {
		this.appointmentTimeFinal = appointmentTimeFinal;
	}

	public String getDsrName() {
		return dsrName;
	}

	public void setDsrName(String dsrName) {
		this.dsrName = dsrName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getComplateAddress() {
		return complateAddress;
	}

	public void setComplateAddress(String complateAddress) {
		this.complateAddress = complateAddress;
	}

	public String getParty_type() {
		return party_type;
	}

	public void setParty_type(String party_type) {
		this.party_type = party_type;
	}

	public List<CommonFiveOptionsVO> getOtherPartyList() {
		return otherPartyList;
	}

	public void setOtherPartyList(List<CommonFiveOptionsVO> otherPartyList) {
		this.otherPartyList = otherPartyList;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getE_stamp_no() {
		return e_stamp_no;
	}

	public void setE_stamp_no(String e_stamp_no) {
		this.e_stamp_no = e_stamp_no;
	}

	public String getE_stamp_amount() {
		return e_stamp_amount;
	}

	public void setE_stamp_amount(String e_stamp_amount) {
		this.e_stamp_amount = e_stamp_amount;
	}

	public String getFirstPartyMobileNo() {
		return firstPartyMobileNo;
	}

	public void setFirstPartyMobileNo(String firstPartyMobileNo) {
		this.firstPartyMobileNo = firstPartyMobileNo;
	}

	public String getSecondPartyMobileNo() {
		return secondPartyMobileNo;
	}

	public void setSecondPartyMobileNo(String secondPartyMobileNo) {
		this.secondPartyMobileNo = secondPartyMobileNo;
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

	public List<CommonFiveOptionsVO> getStampList() {
		return stampList;
	}

	public void setStampList(List<CommonFiveOptionsVO> stampList) {
		this.stampList = stampList;
	}

	public String getRowStampNo() {
		return rowStampNo;
	}

	public void setRowStampNo(String rowStampNo) {
		this.rowStampNo = rowStampNo;
	}

	public List<CommonOptionsVO> getDeed_typeList() {
		return deed_typeList;
	}

	public void setDeed_typeList(List<CommonOptionsVO> deed_typeList) {
		this.deed_typeList = deed_typeList;
	}

	public List<CommonOptionsVO> getDeed_categoryList() {
		return deed_categoryList;
	}

	public void setDeed_categoryList(List<CommonOptionsVO> deed_categoryList) {
		this.deed_categoryList = deed_categoryList;
	}

	public String getDeed_type() {
		return deed_type;
	}

	public void setDeed_type(String deed_type) {
		this.deed_type = deed_type;
	}

	public String getDeed_category() {
		return deed_category;
	}

	public void setDeed_category(String deed_category) {
		this.deed_category = deed_category;
	}

	public String getConsidered_amount() {
		return considered_amount;
	}

	public void setConsidered_amount(String considered_amount) {
		this.considered_amount = considered_amount;
	}

	public String getStamp_value() {
		return stamp_value;
	}

	public void setStamp_value(String stamp_value) {
		this.stamp_value = stamp_value;
	}

	public BigDecimal getCalculate_stamp_value() {
		return calculate_stamp_value;
	}

	public void setCalculate_stamp_value(BigDecimal calculate_stamp_value) {
		this.calculate_stamp_value = calculate_stamp_value;
	}

	public String getConsidered_amount_req() {
		return considered_amount_req;
	}

	public void setConsidered_amount_req(String considered_amount_req) {
		this.considered_amount_req = considered_amount_req;
	}

	public String getOtpText() {
		return otpText;
	}

	public void setOtpText(String otpText) {
		this.otpText = otpText;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public String getTahsilName() {
		return tahsilName;
	}

	public void setTahsilName(String tahsilName) {
		this.tahsilName = tahsilName;
	}
	

	public List<CommonOptionsVO> getTahsilList() {
		return tahsilList;
	}

	public void setTahsilList(List<CommonOptionsVO> tahsilList) {
		this.tahsilList = tahsilList;
	}
	
	
	

	
	
	public List<CommonOptionsVO> getDeed_typeList1() {
		return deed_typeList1;
	}

	public void setDeed_typeList1(List<CommonOptionsVO> deed_typeList1) {
		this.deed_typeList1 = deed_typeList1;
	}

	public List<CommonOptionsVO> getDeed_categoryList1() {
		return deed_categoryList1;
	}

	public void setDeed_categoryList1(List<CommonOptionsVO> deed_categoryList1) {
		this.deed_categoryList1 = deed_categoryList1;
	}

	public String getDeed_type1() {
		return deed_type1;
	}

	public void setDeed_type1(String deed_type1) {
		this.deed_type1 = deed_type1;
	}

	public String getDeed_category1() {
		return deed_category1;
	}

	public void setDeed_category1(String deed_category1) {
		this.deed_category1 = deed_category1;
	}

	public String execute() throws Exception {
        log.fatal("Office Appointment execute....");
        
        try{
        	
        
        	appointmentDateList = new ArrayList<CommonOptionsVO>();
        	appointmentDateList = manager.getAppDateList();
        	
        
			districtList = new ArrayList();
            districtList = manager.searchDistrictAppointment(2);
            
			
        	partyTypeList = new ArrayList();
        	partyTypeList = manager.getPartyList();
        	
            dsrLocationList = new ArrayList();
            appointmentTimeList = new ArrayList();
            tahsilList = new ArrayList();
            
            
            deed_typeList = manager.searchTempDeedType();
            deed_categoryList = new ArrayList();
            
            deed_typeList1 = manager.searchTempDeedTypeParameter(74);
            deed_categoryList1 = manager.searchTempDeedCategory(74);
            
            //deedTypeList = manager.getDeedTypeList();
            
        }catch(Exception e){
            log.fatal("addFirstToken() Exception "+e);
        }
        return "success";
    }
	
	public String generateOTP() throws Exception{
        System.out.println("generateOTP=========");
        String returnString = "";
        try{
			log.fatal("generateOTP==>stampNo="+e_stamp_no+",stampAmount="+e_stamp_amount+",deedType="+deedType);
			System.out.println("generateOTP==>stampNo="+e_stamp_no+",stampAmount="+e_stamp_amount+",deedType="+deedType);
			
			boolean stampCheck = false;
			//String eStampAllNo = "";
			
			List<CommonFiveOptionsVO> stampList = datafromScreen.getStampList(request, this.rowStampNo);
			if ((stampList != null) && (stampList.size() > 0)) {
				ListIterator<CommonFiveOptionsVO> listItr = stampList.listIterator();

				while (listItr.hasNext()) {
					CommonFiveOptionsVO optionVO = (CommonFiveOptionsVO) listItr.next();
					
					String eStampNo = optionVO.getTypeCode_1();

					log.fatal("=>e-Stamp No="+eStampNo+",e-Stamp Date="+optionVO.getTypeCode_2()+",e-Stamp Amount="+optionVO.getTypeCode_3());
					System.out.println("=>e-Stamp No="+eStampNo+",e-Stamp Date="+optionVO.getTypeCode_2()+",e-Stamp Amount="+optionVO.getTypeCode_3());
					
					/*if(optionVO.getTypeCode_1() != "" && !optionVO.getTypeCode_1().equalsIgnoreCase("")){
						eStampAllNo = eStampAllNo +",'"+ optionVO.getTypeCode_1()+"'";
					}*/
					
					if(helper.checkeStampNo(eStampNo,appointmentDate)){
						stampCheck = true;
					}else{
						stampCheck = false;
						break;
					}
				}
			}

			/*log.fatal("=====eStampAllNo="+eStampAllNo+"==>eStampAllNo.length()="+eStampAllNo.length());
			System.out.println("=====eStampAllNo="+eStampAllNo+"==>eStampAllNo.length()="+eStampAllNo.length());
			
			if(eStampAllNo.length() > 1){
				eStampAllNo = eStampAllNo.substring(1, eStampAllNo.length());
				
				if(helper.checkeStampNo(eStampAllNo,appointmentDate)){
					stampCheck = false;
				}else{
					stampCheck = true;
				}
			}else{
				stampCheck = true;
			}
			
			log.fatal("<<<<<"+eStampAllNo);
			System.out.println("<<<<<"+eStampAllNo);*/
			
			/*if(deedType.equalsIgnoreCase("false")){
				if(helper.checkeStampNo(e_stamp_no)){
					stampCheck = false;
				}else{
					stampCheck = true;
				}
			}else{
				stampCheck = true;
			}*/
			
			/*if(helper.checkeStampNo(eStampAllNo)){
				stampCheck = false;
			}else{
				stampCheck = true;
			}*/
			
			log.fatal("====================>>>>>>>>>>>>>>>>>>"+stampCheck);
			System.out.println("====================>>>>>>>>>>>>>>>>>>"+stampCheck);
			
			if(stampCheck){
	        	if(helper.checkAppointmentMobileNo(firstPartyMobileNo, secondPartyMobileNo, appointmentDate, Integer.parseInt(district_id))){
	        		
		            log.fatal("generateOTP");
		            System.out.println("generateOTP");
		            otpText = getData = helper.generateOPT();
		            
		            log.fatal("OTP Integer="+Double.parseDouble(otpText));
		            
		            appointmentOTPModel appOTPModel = new appointmentOTPModel();
					appOTPModel.setMobile_no(mobileNo);
					appOTPModel.setOtp(Integer.parseInt(otpText));
					appOTPModel.setSource_booking("O");
					appOTPModel.setType_booking("N");
					appOTPModel.setActive_tag(true);
					
					if(manager.InsertOTPAppointment(appOTPModel)){
			            //String msg = otpText+" is your OTP for Appointment.";
			            
			            String msg = "Dear Appointee , "+otpText+"  is your OTP for Appointment - CGIGRS";
			            String template_id = "1207161538031975884";
			            
			            helper.sendSMS(this.mobileNo, msg, template_id);
			        	
			        	log.fatal(msg);
			        	
						session.put("sessionNewOTP", otpText);
						session.put("sessionNewUserName", this.mobileNo);
						session.put("sessionNewMobilNo", this.mobileNo);
						
						getData = "1";
						returnString = "success";
					}
	        	}else{
					
					
		            
		            
		            appointmentDateList = new ArrayList<CommonOptionsVO>();
		        	appointmentDateList = manager.getAppDateList();
		        	
					districtList = new ArrayList();
		            districtList = manager.searchDistrictAppointment(2);
		            
					
		        	partyTypeList = new ArrayList();
		        	partyTypeList = manager.getPartyList();
		        	
		            dsrLocationList = new ArrayList();
		            appointmentTimeList = new ArrayList();
		            tahsilList = new ArrayList();
		            
		            
		            deed_typeList = manager.searchTempDeedType();
		            deed_categoryList = new ArrayList();
		            
		            deed_typeList1 = manager.searchTempDeedTypeParameter(74);
		            deed_categoryList1 = manager.searchTempDeedCategory(74);
		            
					
		            log.fatal("All Data is reset");
		            
	        		this.addActionError("Appointment Booked with this Mobile No, Please Select Another Appointment Date");
	        		returnString = "input";
	        	}
        	}else{
				
        		appointmentDateList = new ArrayList<CommonOptionsVO>();
            	appointmentDateList = manager.getAppDateList();
            	
    			districtList = new ArrayList();
                districtList = manager.searchDistrictAppointment(2);
                
    			
            	partyTypeList = new ArrayList();
            	partyTypeList = manager.getPartyList();
            	
                dsrLocationList = new ArrayList();
                appointmentTimeList = new ArrayList();
                tahsilList = new ArrayList();
                
                
                deed_typeList = manager.searchTempDeedType();
                deed_categoryList = new ArrayList();
                
                deed_typeList1 = manager.searchTempDeedTypeParameter(74);
                deed_categoryList1 = manager.searchTempDeedCategory(74);
				
	            log.fatal("All Data is reset");
	            
        		this.addActionError("This E-Stamp No is Already Used, Please Enter Another E-Stamp No");
        		returnString = "input";
        	}
        }
        catch(Exception e){
        	getData = "0";
        	returnString = "input";
            log.fatal("generateOPT="+helper.writeLogInUpperCase(e));
            System.out.println("generateOPT="+helper.writeLogInUpperCase(e));
            throw new Exception(getText("global.system.error"));
        }
        log.fatal("generateOPT= returnString="+returnString);
        System.out.println("generateOPT= returnString="+returnString);
        return returnString;
    }
	
	public String VerifyOTP() throws Exception{
		try{
			log.fatal("Entred OTP="+this.otpVarify);

			String sessionOTP = (String) request.getSession().getAttribute("sessionNewOTP");
			
			log.fatal("=>>stampNo="+this.e_stamp_no+",stampAmount="+this.e_stamp_amount);
			System.out.println("=>>stampNo="+this.e_stamp_no+",stampAmount="+this.e_stamp_amount);
			
			if(sessionOTP.equalsIgnoreCase(this.otpVarify)){
				log.fatal("Please Take Appointment.....mobileNo="+mobileNo+",otpVarify="+otpVarify);
				if(manager.updateAppointmentOTPDetail(mobileNo,this.otpVarify)){
					String appString = TakeAppointment();
					if(appString.equalsIgnoreCase("SUCCESS")){
						return SUCCESS;
					}else{
						return INPUT;
					}
				}else{
					return ERROR;
				}
			}else{
				this.addActionError("Please Enter Valide OTP");
				return ERROR;
			}
			
		}catch(Exception e){
			log.fatal(helper.writeLogInUpperCase(e));
			return ERROR;
		}
		
	}
	
	public String TakeAppointment() throws Exception{
		String takeAppointment = "";
		boolean operationFlag = false;
		try{
			log.fatal("==>stampNo="+e_stamp_no+",stampAmount="+e_stamp_amount);
			System.out.println("==>stampNo="+e_stamp_no+",stampAmount="+e_stamp_amount);

			log.fatal("==>deed_type="+deed_type+",deed_category="+deed_category+",considered_amount"+considered_amount);
			System.out.println("==>deed_type="+deed_type+",deed_category="+deed_category+",considered_amount"+considered_amount);
			
			String filePath="";
			String filePath1="";

			//Date currentDateValue = new Date();
			
			dsr_location = String.format("%03d", Integer.parseInt(dsr_location));
			
			String createDate = sdf3.format(sdf.parse(appointmentDate));

			log.fatal("createDate="+createDate);
			System.out.println("createDate="+createDate);
			
		
			log.fatal("Appointment Date ="+appointmentDate+",dsr_location="+dsr_location);
			System.out.println("Appointment Date ="+appointmentDate+",dsr_location="+dsr_location);
			

			boolean stampCheck = false;
			boolean stampCheck1 = false;
			boolean secondAppointmentInsert = false;
			
			List<CommonFiveOptionsVO> stampList_1 = datafromScreen.getStampList(request, this.rowStampNo);
			
			List<CommonFiveOptionsVO> stampList_2 = datafromScreen.getStampList(request, this.rowStampNo1);
			
			if ((stampList_1 != null) && (stampList_1.size() > 0)) {
				ListIterator<CommonFiveOptionsVO> listItr_1 = stampList_1.listIterator();

				while (listItr_1.hasNext()) {
					CommonFiveOptionsVO optionVO_1 = (CommonFiveOptionsVO) listItr_1.next();
					
					String eStampNo =  optionVO_1.getTypeCode_1();

					log.fatal("=>e-Stamp No="+eStampNo+",e-Stamp Date="+optionVO_1.getTypeCode_2()+",e-Stamp Amount="+optionVO_1.getTypeCode_3());
					System.out.println("=>e-Stamp No="+eStampNo+",e-Stamp Date="+optionVO_1.getTypeCode_2()+",e-Stamp Amount="+optionVO_1.getTypeCode_3());
					
					/*if(optionVO_1.getTypeCode_1() != "" && !optionVO_1.getTypeCode_1().equalsIgnoreCase("")){
						eStampAllNo = eStampAllNo +",'"+ optionVO_1.getTypeCode_1()+"'";
					}*/
					
					if(helper.checkeStampNo(eStampNo,appointmentDate)){
						stampCheck = true;
					}else{
						stampCheck = false;
						break;
					}
				}
			}
			
			
			if ((stampList_2 != null) && (stampList_2.size() > 0)) {
				ListIterator<CommonFiveOptionsVO> listItr_2 = stampList_2.listIterator();

				while (listItr_2.hasNext()) {
					CommonFiveOptionsVO optionVO_2 = (CommonFiveOptionsVO) listItr_2.next();
					
					String eStampNo =  optionVO_2.getTypeCode_1();

					
					
					/*if(optionVO_1.getTypeCode_1() != "" && !optionVO_1.getTypeCode_1().equalsIgnoreCase("")){
						eStampAllNo = eStampAllNo +",'"+ optionVO_1.getTypeCode_1()+"'";
					}*/
					
					if(helper.checkeStampNo(eStampNo,appointmentDate)){
						stampCheck1 = true;
					}else{
						stampCheck1 = false;
						break;
					}
				}
			}

			
			
			helper.checkAppointmentMobileNo(firstPartyMobileNo, secondPartyMobileNo, appointmentDate, Integer.parseInt(dsr_location));
			
			if ((firstPartyMobileNo1 != null) && (firstPartyMobileNo1.length()>0)) {
			helper.checkAppointmentMobileNo(firstPartyMobileNo1, secondPartyMobileNo1, appointmentDate, Integer.parseInt(dsr_location));
			}
			
			if(stampCheck){
			
			//if(helper.checkAppointmentMobileNo(firstPartyMobileNo, secondPartyMobileNo, appointmentDate, Integer.parseInt(dsr_location))){
				
				if(manager.checkValieAppDate(Integer.parseInt(dsr_location),appointmentDate)){
					log.fatal("Appointment Date Valid");
					System.out.println("Appointment Valid");
					
					
					if(manager.checkValieAppTime(Integer.parseInt(dsr_location),appointmentDate, appointmentTime)){
						
						String appointmentNo = "CGAP"+dsr_location+""+createDate;

						log.fatal("appointmentNo="+appointmentNo);
						System.out.println("appointmentNo="+appointmentNo);
						
						String appointmentNoNew = manager.generateNo(appointmentNo);
						appointmentNoFinal = appointmentNo+""+String.format("%03d", Integer.parseInt(appointmentNoNew));

						log.fatal("Final appointmentNoFinal="+appointmentNoFinal);
						System.out.println("Final appointmentNoFinal="+appointmentNoFinal);
					
					String appTime = appointmentTime;//arrayData[0];
	
					dsrName = helper.DsrName(dsr_location, 2);//arrayData[1];
					appointmentModel appModel = new appointmentModel();
					
					appModel.setAppointee_name(fullName);
					appModel.setAppointee_phone_no(mobileNo);
					appModel.setDsr_location(Integer.parseInt(dsr_location));
					appModel.setAppointment_date(sdf1.parse(sdf1.format(sdf.parse(appointmentDate))));
					appModel.setAppointment_slot(appTime);
					appModel.setMode_booking("Online");
					appModel.setAppointment_no(appointmentNoFinal);
					appModel.setDistrict_id(Integer.parseInt(district_id));
					
					appModel.setParty_father_name(fatherName);
					appModel.setAddress(complateAddress);
					appModel.setParty_type(party_type);
					appModel.setActive_tag("A");

					log.fatal("stampNo="+this.e_stamp_no+",stampAmount="+this.e_stamp_amount);
					System.out.println("stampNo="+e_stamp_no+",stampAmount="+e_stamp_amount);
					
					appModel.setEstamp_no("");
					
				
					
					appModel.setCheck_agree("false");//deedType

					appModel.setDeed_type_id(Integer.parseInt(deed_type));
					appModel.setDeed_category_id(Integer.parseInt(deed_category));
					appModel.setConsidered_amount(new BigDecimal(considered_amount));
					appModel.setStamp_value(new BigDecimal(stamp_value));
					
					String insertOperationMessage = manager.InsertAppointment(appModel);
					
					log.fatal("====>>"+insertOperationMessage+"<<====");
					
					//if(Integer.parseInt(stamp_value) > 0){
						
					//}
					
					appointmentEStampModel appEstampModel = new appointmentEStampModel();
					
					List<CommonFiveOptionsVO> stampList = datafromScreen.getStampList(request, this.rowStampNo);
					if ((stampList != null) && (stampList.size() > 0)) {
						ListIterator<CommonFiveOptionsVO> listItr = stampList.listIterator();

						while (listItr.hasNext()) {
							CommonFiveOptionsVO optionVO = (CommonFiveOptionsVO) listItr.next();

							log.fatal("=>e-Stamp No="+optionVO.getTypeCode_1()+",e-Stamp Date="+optionVO.getTypeCode_2()+",e-Stamp Amount="+optionVO.getTypeCode_3());
							System.out.println("=>e-Stamp No="+optionVO.getTypeCode_1()+",e-Stamp Date="+optionVO.getTypeCode_2()+",e-Stamp Amount="+optionVO.getTypeCode_3());
							
							if(optionVO.getTypeCode_1() == "" && optionVO.getTypeCode_1().equalsIgnoreCase("")){
								
							}else{
								appEstampModel.setE_stamp_no(optionVO.getTypeCode_1());
								appEstampModel.setE_stamp_date(sdf1.parse(sdf1.format(sdf.parse(optionVO.getTypeCode_2()))));
								appEstampModel.setE_stamp_value(new BigDecimal(optionVO.getTypeCode_3()));
								
								appEstampModel.setAppointment_no(appointmentNoFinal);
								appEstampModel.setAppointment_date(sdf1.parse(sdf1.format(sdf.parse(appointmentDate))));
								
								manager.AppointmentEStamp(appEstampModel);
							}
						}
					}
					
					
					
				
					
					
					
					if(insertOperationMessage.trim().equals("1")){
						//this.addActionMessage("Appointment Booked Successfully.          \n"
						
						String[] arrayAppTime = appTime.split("-");
						
						//String msg = "Aap ka Appointment Data " + appointmentDate + " and Time " + arrayAppTime[0];
						
						//String msg = "ई पंजीयन हेतु दर्ज अपॉइंटमेंट आईडी "+appointmentNoFinal+" दिनांक :" + appointmentDate + " समय   :"+arrayAppTime[0]+" उक्त समय पर सम्बंधित व्यक्तियो के संग "+dsrName+" पंजीयन कार्यालय में उपस्थित होवे";
						String msg = "ई पंजीयन हेतु दर्ज अपॉइंटमेंट आईडी "+appointmentNoFinal+"   दिनांक : " + appointmentDate + "  समय "+arrayAppTime[0]+"  उक्त समय पर सम्बंधित व्यक्तियो के संग "+dsrName+"  पंजीयन कार्यालय में उपस्थित होवे  CGIGRS";
						
						//String msg = "ई पंजीयन हेतु दर्ज अपॉइंटमेंट दिनांक :" + appointmentDate + " समय   :"+arrayAppTime[0]+" उक्त समय पर सम्बंधित व्यक्तियो के साथ "+dsrName+" पंजीयन कार्यालय में उपस्थित होवे | कृपया निर्देशों का पालन करें ।  Appointment ID : "+appointmentNoFinal+"";
						log.fatal("Appointy Sending Mobile Message="+msg+" on "+mobileNo);
						System.out.println("Appointy Sending Mobile Message="+msg+" on "+mobileNo);
						
						String template_id = "1207161795946758346";
						
			            
			            helper.sendSMSAppointment(this.mobileNo, msg, template_id);
			            
						appointmentTimeFinal = arrayAppTime[0];
						
						this.addActionMessage("आपका अपॉइंटमेंट दिनांक  "+appointmentDate+" को  "+appointmentTimeFinal+" बजे का बुक किया गया |  "
							+ "अतः समय पर अपने मूल दस्तावेजों के साथ "+dsrName+" कार्यालय में उपस्थित हों ");
						
						appointmentPartyModel appPartyModel = new appointmentPartyModel();
						
						List<CommonFiveOptionsVO> partyList = datafromScreen.getAllDataForAppointment(request, this.rowNo);
						if ((partyList != null) && (partyList.size() > 0)) {
							ListIterator<CommonFiveOptionsVO> listItr = partyList.listIterator();
	
							while (listItr.hasNext()) {
								CommonFiveOptionsVO optionVO = (CommonFiveOptionsVO) listItr.next();
	
								log.fatal("=>Party Name="+optionVO.getTypeCode_1()+",Mobile No="+optionVO.getTypeCode_2()+",Party Type="+optionVO.getTypeCode_3()+",Party Father="+optionVO.getTypeCode_4()+",Party Address="+optionVO.getTypeCode_5());
								System.out.println("=>Party Name="+optionVO.getTypeCode_1()+",Mobile No="+optionVO.getTypeCode_2()+",Party Type="+optionVO.getTypeCode_3()+",Party Father="+optionVO.getTypeCode_4()+",Party Address="+optionVO.getTypeCode_5());
								
								appPartyModel.setParty_name(optionVO.getTypeCode_1());
								appPartyModel.setMobile_no(optionVO.getTypeCode_2());
								appPartyModel.setParty_type(optionVO.getTypeCode_3());
								
								appPartyModel.setParty_father_name(optionVO.getTypeCode_4());
								appPartyModel.setAddress(optionVO.getTypeCode_5());
								
								appPartyModel.setAppointment_no(appointmentNoFinal);
								
								manager.AppointmentParty(appPartyModel);
								
								CommonFiveOptionsVO optionVO1 = new CommonFiveOptionsVO(optionVO.getTypeCode_1(),optionVO.getTypeCode_2(),
										optionVO.getTypeCode_3(),optionVO.getTypeCode_4(),optionVO.getTypeCode_5());
								
								otherPartyList.add(optionVO1);
								
								if(optionVO.getTypeCode_2() != "" || !optionVO.getTypeCode_2().equalsIgnoreCase("")){
	
									String[] arrayAppTimep = appTime.split("-");
									
									//String msg = "Aap ka Appointment Data " + appointmentDate + " and Time " + arrayAppTime[0];
									
									//String msgp = "ई पंजीयन हेतु दर्ज अपॉइंटमेंट आईडी "+appointmentNoFinal+" दिनांक :" + appointmentDate + " समय   :"+arrayAppTimep[0]+" उक्त समय पर सम्बंधित व्यक्तियो के संग "+dsrName+" पंजीयन कार्यालय में उपस्थित होवे";
									String msgp = "ई पंजीयन हेतु दर्ज अपॉइंटमेंट आईडी "+appointmentNoFinal+"   दिनांक : " + appointmentDate + "  समय "+arrayAppTimep[0]+"  उक्त समय पर सम्बंधित व्यक्तियो के संग "+dsrName+"  पंजीयन कार्यालय में उपस्थित होवे  CGIGRS";
									
									//String msg = "ई पंजीयन हेतु दर्ज अपॉइंटमेंट दिनांक :" + appointmentDate + " समय   :"+arrayAppTime[0]+" उक्त समय पर सम्बंधित व्यक्तियो के साथ "+dsrName+" पंजीयन कार्यालय में उपस्थित होवे | कृपया निर्देशों का पालन करें ।  Appointment ID : "+appointmentNoFinal+"";
									log.fatal("Annay Party Detail Sending Mobile Message="+msgp+" on "+optionVO.getTypeCode_2());
									System.out.println("Annay Party Detail Sending Mobile Message="+msgp+" on "+optionVO.getTypeCode_2());
						            
						            helper.sendSMSAppointment(optionVO.getTypeCode_2(), msgp, template_id);
								}
							}
						}
						
						
						
						System.out.println("another_entry "+getAnother_entry());
					   
						
						if(another_entry != null && another_entry.equalsIgnoreCase("yes"))
						{
						if((appointmentTime1 != null) && (appointmentTime1.length() > 0)) 
						secondAppointmentInsert = manager.checkValieAppTime(Integer.parseInt(dsr_location),appointmentDate, appointmentTime1);
						System.out.println("secondAppointmentInsert ="+secondAppointmentInsert);
						
						
						if(secondAppointmentInsert)
						{
							
							
							
							String appointmentNo1 = "CGAP"+dsr_location+""+createDate;
	                        String appointmentNoNew1 = manager.generateNo(appointmentNo);
	                        
							 appointmentNoFinal1 = appointmentNo1+""+String.format("%03d", Integer.parseInt(appointmentNoNew1));

							 System.out.println("appointmentNoFinal1 ="+appointmentNoFinal1+"mobileNo1 ="+mobileNo1+"  fullName1 "+fullName1 + " fatherName1 "+fatherName1+" party_type1"+party_type1+" deed_type1 "+deed_type1+" deed_category1"+deed_category1);
							String appTime1 = appointmentTime1;
							
							dsrName = helper.DsrName(dsr_location, 2);
							appointmentModel appModel1 = new appointmentModel();
							
							appModel1.setAppointee_name(fullName1);
							appModel1.setAppointee_phone_no(mobileNo1);
							appModel1.setDsr_location(Integer.parseInt(dsr_location));
							appModel1.setAppointment_date(sdf1.parse(sdf1.format(sdf.parse(appointmentDate))));
							appModel1.setAppointment_slot(appTime1);
							appModel1.setMode_booking("Online");
							appModel1.setAppointment_no(appointmentNoFinal1);
							appModel1.setDistrict_id(Integer.parseInt(district_id));
							
							appModel1.setParty_father_name(fatherName1);
							appModel1.setAddress(complateAddress1);
							appModel1.setParty_type(party_type1);
							appModel1.setActive_tag("A");
							appModel1.setEstamp_no("");
							appModel1.setCheck_agree("false");

							appModel1.setDeed_type_id(Integer.parseInt(deed_type1));
							appModel1.setDeed_category_id(Integer.parseInt(deed_category1));
							appModel1.setConsidered_amount(new BigDecimal(considered_amount1));
							appModel1.setStamp_value(new BigDecimal(stamp_value1));
							appModel1.setRel_token_no(appointmentNoFinal);

							
							String insertOperationMessage1 = manager.InsertAppointment(appModel1);
							System.out.println("insertOperationMessage1 ="+insertOperationMessage1);
							
							appointmentEStampModel appEstampModel1 = new appointmentEStampModel();
							
							List<CommonFiveOptionsVO> stampList1 = datafromScreen.getStampList1(request, this.rowStampNo1);
							if ((stampList1 != null) && (stampList1.size() > 0)) {
								ListIterator<CommonFiveOptionsVO> listItr = stampList1.listIterator();

								while (listItr.hasNext()) {
									CommonFiveOptionsVO optionVO = (CommonFiveOptionsVO) listItr.next();

								
									if(optionVO.getTypeCode_1() == "" && optionVO.getTypeCode_1().equalsIgnoreCase("")){
										
									}else{
										appEstampModel1.setE_stamp_no(optionVO.getTypeCode_1());
										appEstampModel1.setE_stamp_date(sdf1.parse(sdf1.format(sdf.parse(optionVO.getTypeCode_2()))));
										appEstampModel1.setE_stamp_value(new BigDecimal(optionVO.getTypeCode_3()));
										
										appEstampModel1.setAppointment_no(appointmentNoFinal1);
										appEstampModel1.setAppointment_date(sdf1.parse(sdf1.format(sdf.parse(appointmentDate))));
										
										manager.AppointmentEStamp(appEstampModel1);
										System.out.println("E stamp - 2 updated");
									}
								}
							}
							
						
							
						
						    appointmentPartyModel appPartyModel1 = new appointmentPartyModel();
						    List<CommonFiveOptionsVO> partyList1 = datafromScreen.getAllDataForAppointment1(request, this.rowNo1);
						
						
						    
						    if ((partyList1 != null) && (partyList1.size() > 0)) {
								ListIterator<CommonFiveOptionsVO> listItr = partyList1.listIterator();
		
								while (listItr.hasNext()) {
									CommonFiveOptionsVO optionVO = (CommonFiveOptionsVO) listItr.next();
		
									
									appPartyModel1.setParty_name(optionVO.getTypeCode_1());
									appPartyModel1.setMobile_no(optionVO.getTypeCode_2());
									appPartyModel1.setParty_type(optionVO.getTypeCode_3());
									
									appPartyModel1.setParty_father_name(optionVO.getTypeCode_4());
									appPartyModel1.setAddress(optionVO.getTypeCode_5());
									
									appPartyModel1.setAppointment_no(appointmentNoFinal1);
									
									manager.AppointmentParty(appPartyModel1);
									System.out.println("Party Detail - 2 updated");
									
								}
							}
							
						}
						    
						}   
						    
						    

						
						
						partyTypeList = manager.getPartyList();
						
						dsrLocationList = new ArrayList();
						//dsrLocationList = manager.searchDSRLocationAll(2);
						
						//fullName = "";
						mobileNo = "";
	
			            appointmentDateList = new ArrayList();
			            
			            appointmentTimeList = new ArrayList();
			            
			            districtList = manager.searchDistrictAll(2);
			            tahsilList =  new ArrayList();
			            deed_typeList = manager.searchTempDeedType();
			            deed_categoryList = new ArrayList();
			            
			            deed_typeList1 = manager.searchTempDeedTypeParameter(74);
			            deed_categoryList1 = manager.searchTempDeedCategory(74);
			            
			            filePath = generateReport(appointmentNoFinal);
			            
			            System.out.println("fileName in filePath -"+filePath);
			            request.setAttribute("fileName", filePath);
			            fileName = filePath;
			            
			            if(appointmentNoFinal1!=null && appointmentNoFinal.toString().length()>0)
			            	 
			            	{
			            	   filePath1 = generateReport(appointmentNoFinal1);
			            	   request.setAttribute("fileName1", filePath1);
			            	   request.setAttribute("appointmentNoFinal1", appointmentNoFinal1);
			            	  
			            	   fileName1 = filePath1;
			            	}
						
			         
						
			         
						
			            takeAppointment = "success";
			            operationFlag = true;
					}else{
						this.addActionError("Error");
						partyTypeList = manager.getPartyList();
						tahsilList = new ArrayList();
						
						dsrLocationList = new ArrayList();
						//dsrLocationList = manager.searchDSRLocationAll(2);
	
						appointmentDateList = new ArrayList<CommonOptionsVO>();
			        	appointmentDateList = manager.getAppDateList();
			            
			            appointmentTimeList = new ArrayList();
			            
			            districtList = new ArrayList();
			            districtList = manager.searchDistrictAppointment(2);
			            
			            deed_typeList = manager.searchTempDeedType();
			            deed_categoryList = new ArrayList();
			            
			            deed_typeList1 = manager.searchTempDeedTypeParameter(74);
			            deed_categoryList1 = manager.searchTempDeedCategory(74);
			            
			            
			            takeAppointment = "error";
			            operationFlag = false;
					}
				//}
					}else{
					log.fatal("Appointment Time Not Valid");
					System.out.println("Appointment Timete Not Valid");
					
					this.addActionError("Please Select Valide Time");
					
					tahsilList = new ArrayList();
					
					districtList = new ArrayList();
		            districtList = manager.searchDistrictAll(2);
		            
		        	partyTypeList = new ArrayList();
		        	partyTypeList = manager.getPartyList();
		        	
		            dsrLocationList = new ArrayList();
	
		            appointmentDateList = new ArrayList<CommonOptionsVO>();
		        	appointmentDateList = manager.getAppDateList();
		            
		            appointmentTimeList = new ArrayList();
		            
		            deed_typeList = manager.searchTempDeedType();
		            deed_categoryList = new ArrayList();
		            
		            deed_typeList1 = manager.searchTempDeedTypeParameter(74);
		            deed_categoryList1 = manager.searchTempDeedCategory(74);
					
		            log.fatal("All Data is reset");
		            takeAppointment = "errortime";
		            operationFlag = false;
					}
	
				}else{
					log.fatal("Appointment Date Not Valid");
					System.out.println("Appointment Date Not Valid");
					
					this.addActionError("Please Select Valide Date");
					
                    tahsilList = new ArrayList();
					
					districtList = new ArrayList();
		            districtList = manager.searchDistrictAll(2);
		            
		        	partyTypeList = new ArrayList();
		        	partyTypeList = manager.getPartyList();
		        	
		            dsrLocationList = new ArrayList();
	
		            appointmentDateList = new ArrayList<CommonOptionsVO>();
		        	appointmentDateList = manager.getAppDateList();
		            
		            appointmentTimeList = new ArrayList();
		            
		            deed_typeList = manager.searchTempDeedType();
		            deed_categoryList = new ArrayList();
					
		            deed_typeList1 = manager.searchTempDeedTypeParameter(74);
		            deed_categoryList1 = manager.searchTempDeedCategory(74);
	
		            log.fatal("All Data is reset");
		            takeAppointment = "error";
		            operationFlag = false;
				}
			}else{
				
				log.fatal("Appointment Mobile Already Used");
				System.out.println("Appointment Mobile Already Used");
				
				//this.addActionError("Your Appointment Already Booked With "+appointmentNoFinal+" Download Appointment Slip.");
				
				tahsilList = new ArrayList();
				
				districtList = new ArrayList();
	            districtList = manager.searchDistrictAll(2);
	            
	        	partyTypeList = new ArrayList();
	        	partyTypeList = manager.getPartyList();
	        	
	            dsrLocationList = new ArrayList();

	            appointmentDateList = new ArrayList<CommonOptionsVO>();
	        	appointmentDateList = manager.getAppDateList();
	            
	            appointmentTimeList = new ArrayList();
	            
	            deed_typeList = manager.searchTempDeedType();
	            deed_categoryList = new ArrayList();
	            
	            deed_typeList1 = manager.searchTempDeedTypeParameter(74);
	            deed_categoryList1 = manager.searchTempDeedCategory(74);
				

				
	            log.fatal("All Data is reset");
	            takeAppointment = "errorestamp";
	            operationFlag = false;
			}
			
		}catch(Exception e){
			log.fatal(helper.writeLogInUpperCase(e));
			this.addActionError("------------");
			takeAppointment = "error";
		}
		log.fatal("==>>takeAppointment="+takeAppointment);
		System.out.println("==>>takeAppointment="+takeAppointment);
		
		
		if (operationFlag) {

			this.addActionMessage("Data Saved Successfully");
			System.out.println("In true");
			return SUCCESS;
		} else {
			if(takeAppointment.equalsIgnoreCase("errortime")){
				this.addActionError("Appointment slot already booked. Try another slot.");
			}if(takeAppointment.equalsIgnoreCase("errorestamp")){
				this.addActionError("Your Appointment Already Booked, Please Download Appointment Slip.");
			}else{
				this.addActionError("Data is not Valid.Please Re entry with proper data");
			}
			System.out.println("In false");
			return INPUT;
		}
		
	
	}
	
	/*
	 * public String fetchAppDateList() throws Exception {
	 * log.fatal("getAppDateList");
	 * 
	 * log.fatal("dsr_location====="+dsr_location); try { appointmentDateList = new
	 * ArrayList<CommonOptionsVO>(); if ((this.dsr_location != null) &&
	 * (this.dsr_location.length() > 0)) {
	 * log.fatal("district id and language is not null"); appointmentDateList =
	 * manager.getAppDateList(Integer.parseInt(dsr_location)); } } catch (Exception
	 * e) { log.fatal(e); log.fatal(helper.writeLogInUpperCase(e)); throw new
	 * Exception(getText("global.system.error")); }
	 * log.fatal("getAppDateList.size()====="+appointmentDateList.size()); return
	 * SUCCESS; }
	 */
	
	public String fetchAppTimeList() throws Exception {
		log.fatal("getAppTimeList");

		log.fatal("dsr_location====="+dsr_location+","+appointmentDate);
		try {
			appointmentTimeList = new ArrayList<CommonOptionsVO>();
			if ((this.dsr_location != null) && (this.dsr_location.length() > 0)) {
			log.fatal("district id and language is not null");
			appointmentTimeList = manager.getAppTimeList(Integer.parseInt(dsr_location),appointmentDate);
			}
		} catch (Exception e) {
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		log.fatal("getAppTimeList.size()====="+appointmentTimeList.size());
		return SUCCESS;
	}
	
	public String AppointmentPrint() throws Exception {
		try {
			
			appointmentNoFinal = this.appointmentNoFinal;
			
		} catch (Exception e) {
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		log.fatal("AppointmentPrint.size()=====");
		return SUCCESS;
	}
	
	 public String generateReport(String appointmentNoFinal)  throws Exception 
	    {
	    	JasperPrint jasperPrint = null;
	    	Connection con = null;
			String printFileName = "";
			
			String repPath = "/report/APPOINTMENT_SLIP.jasper";
			String token_no = appointmentNoFinal;
			String reportName = "APPOINTMENT_SLIP";
			String filePath = "";
			
			
		    File reportFile = new File(request.getSession(false).getServletContext().getRealPath(repPath));

			Map<String, String> reportParams = new HashMap<String, String>(2, 1.0f);
			reportParams.put("SUBREPORT_DIR", reportFile.getParentFile().getAbsolutePath());
			Date currentDate = new Date();

		
			reportParams.put("token_no", token_no);
			reportParams.put("event", "NEW");
		
			log.fatal("generateReport================");
		
			if (!reportFile.exists())
				throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
			JasperReport jasperReport = null;

			try {
				jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
			} catch (JRException e) {
				throw new RuntimeException("Exception while loading the report", e);
			}
			con = Datasource.getDataSource();

			try {

				jasperPrint = JasperFillManager.fillReport(jasperReport,reportParams, con);
				
			//	DefaultJasperReportsContext.getInstance();
				JasperPrintManager printManager = new JasperPrintManager();
				BufferedImage rendered_image = null;
				PDXObjectImage ximage = null;
				PDFMergerUtility merger = new PDFMergerUtility();
				//long currentMiliSecond = System.currentTimeMillis();
				
				//String fileLocation = "/home/jboss/download/";
				//String fileLocation ="D://PDF//";
				
				String fileLocation = helper.appointmentPDFPath();
				log.fatal("generateReport========Location="+fileLocation);

				for (int i = 0; i < jasperPrint.getPages().size(); i++) {
					rendered_image = (BufferedImage) printManager.printPageToImage(jasperPrint, i, 1);

				/*	ouputStream = new FileOutputStream(file);
				
					ImageIO.write(rendered_image, "gif", ouputStream);
	*/
					PDDocument doc = new PDDocument();
					PDPage page = new PDPage();
					page.setMediaBox(PDPage.PAGE_SIZE_A4);
					// page.setRotation(90);
					doc.addPage(page);

					/*BufferedImage awtImage = ImageIO.read(new File(fileLocation
							+ reportName + "_" + token_no + "~"
							+ sdf.format(sdf1.parse(token_date)) + "~"
							+ dsr_location + "~" + currentMiliSecond + ".gif"));*/

					ximage = new PDPixelMap(doc, rendered_image);

					PDPageContentStream contentStream = new PDPageContentStream(doc, page);

					Dimension scaledDim = getScaledDimension(
							new Dimension(ximage.getWidth(), ximage.getHeight()),
							page.getMediaBox().createDimension());

					contentStream.drawXObject(ximage, 1, 1, scaledDim.width,
							scaledDim.height);

					contentStream.close();

					//doc.save(fileLocation + reportName + "_" + token_no + "~" + currentMiliSecond + "_" + i + ".pdf");
					doc.save(fileLocation + reportName + "_" + token_no + "~"  + "_" + i + ".pdf");

					//merger.addSource(fileLocation + reportName + "_" + token_no+"~" + currentMiliSecond + "_" + i + ".pdf");
					merger.addSource(fileLocation + reportName + "_" + token_no+"~"  + "_" + i + ".pdf");
					doc.close();
					log.fatal("generateReport======PDF");
				}

				//merger.setDestinationFileName(fileLocation + reportName + "_" + token_no +  "~" + currentMiliSecond + ".pdf");
				merger.setDestinationFileName(fileLocation + reportName + "_" + token_no + ".pdf");

				merger.mergeDocuments();

				//filePath = fileLocation + reportName + "_" + token_no + "~"  + currentMiliSecond + ".pdf";
				filePath = fileLocation + reportName + "_" + token_no + ".pdf";
				
				System.out.println("In Bisu File created at :"+ filePath);
				log.fatal("generateReport==========PDF Created...."+filePath);
			
			} catch (Exception e) {
				log.fatal(helper.writeLogInUpperCase(e));
				log.fatal(helper.writeLogInUpperCase(e));
				throw new Exception(getText("global.system.error"));
			
			} finally {
				if (null != con)
					try {
						con.close();
					} catch (Exception e) {
						log.fatal(helper.writeLogInUpperCase(e));
						log.fatal(helper.writeLogInUpperCase(e));
						throw new Exception(getText("global.system.error"));
					}
			}

			return filePath;
	    	
	    }
	    
	    
	    
	    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

			int original_width = imgSize.width;
			int original_height = imgSize.height;
			int bound_width = boundary.width;
			int bound_height = boundary.height;
			int new_width = original_width;
			int new_height = original_height;

			// first check if we need to scale width
			if (original_width > bound_width) {
				// scale width to fit
				new_width = bound_width;
				// scale height to maintain aspect ratio
				new_height = (new_width * original_height) / original_width;
			}

			// then check if we need to scale even with the new height
			if (new_height > bound_height) {
				// scale height to fit instead
				new_height = bound_height;
				// scale width to maintain aspect ratio
				new_width = (new_height * original_width) / original_height;
			}

			return new Dimension(new_width + 100, new_height);
			//return new Dimension(new_width, new_height);
		}
	
	
    /*public void validate() {
		try {
			if (e_stamp_no.trim().length() == 0) {
				this.addFieldError("e_stamp_no",  "EStamp No. is required");
			}
			else if (e_stamp_no.trim().length() !=20) {
				this.addFieldError("e_stamp_no",  "EStamp No. is not valid");
			}
			else if (!e_stamp_no.trim().toUpperCase().startsWith("IN-CG")) {
				this.addFieldError("e_stamp_no",  "EStamp No. is not valid");
			}

			else if (!validator.estampValidate(e_stamp_no.trim().toUpperCase())) {
				this.addFieldError("e_stamp_no",  "EStamp No. is not valid");
			}

			else if (e_stamp_amount.trim().length() == 0) {
				this.addFieldError("e_stamp_amount",  "EStamp Amount is required");
			}

			else if (!validator.amountFiledValidate(e_stamp_amount.trim())) {
				this.addFieldError("e_stamp_amount",  "EStamp Amount is not valid");
			}
		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));

		}
    }*/
	
    public String fetchLocationName()throws Exception{
        System.out.println("fetchLocationName=========");
        try
        {
            log.fatal("fetchLocationName");
            System.out.println("fetchLocationName");
            //getData = manager.getRegistryReportNew(dsr_location);
            dsrName = helper.DsrName(dsr_location, 2);
            
            //generateOTP();
            log.fatal("fetchLocationName==>>"+dsrName);
            System.out.println("fetchLocationName==>>"+dsrName);
        }
        catch(Exception e)
        {
            log.fatal("fetchLocationName===="+helper.writeLogInUpperCase(e));
            System.out.println(helper.writeLogInUpperCase(e));
            throw new Exception(getText("global.system.error"));
        }
        return "success";
    }

	/*
	 * @SkipValidation public String loadDSRLocationApp() throws Exception {
	 * log.fatal("loadDSRLocationApp");
	 * 
	 * //language = (String) request.getSession().getAttribute("_LANGUAGE");
	 * log.fatal("district_id====="+district_id+",tahsilName="+
	 * language+" appointmentDate "+appointmentDate); try { dsrLocationList = new
	 * ArrayList<CommonOptionsVO>(); if ((this.district_id != null) &&
	 * (this.district_id.length() > 0) && (this.tahsilName != null) &&
	 * (this.tahsilName.length() > 0) && (this.appointmentDate !=null)&&
	 * (this.appointmentDate.length()>0)) {
	 * log.fatal("district id and language is not null"); dsrLocationList =
	 * manager.getAppDsrList(
	 * Integer.parseInt(district_id),tahsilName,appointmentDate); } } catch
	 * (Exception e) { log.fatal(e); log.fatal(helper.writeLogInUpperCase(e)); throw
	 * new Exception(getText("global.system.error")); }
	 * log.fatal("dsrLocationList.size()====="+dsrLocationList.size()); return
	 * SUCCESS; }
	 */
	
	
	
	@SkipValidation
	public String loadDSRLocationApp() throws Exception {
		
		
		//language = (String) request.getSession().getAttribute("_LANGUAGE");
		log.fatal("district_id====="+district_id+",tahsilName="+language+" appointmentDate "+appointmentDate);
		try {
			
			if(tahsil_view_tag==null) 
				tahsil_view_tag = "N";
			
			if(view_tag==null) 
				view_tag = "N";
			
			System.out.println("tahsil_view_tag "+tahsil_view_tag+" view_tag ="+view_tag);
			if ((this.district_id != null) && (this.district_id.length() > 0)
					&& (this.tahsilName != null) && (this.tahsilName.length() > 0)
					&& (this.appointmentDate !=null)&& (this.appointmentDate.length()>0)
					&& (this.tahsil_view_tag !=null)&& (this.view_tag !=null)) {
			log.fatal("district id and language is not null");
			dsr_location = manager.getAppDsr(
						Integer.parseInt(district_id),tahsilName,appointmentDate,tahsil_view_tag,view_tag);
			
			System.out.println("dsr_location"+dsr_location);			}
		} catch (Exception e) {
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		
		return SUCCESS;
	}
	
	
	
	
	
	@SkipValidation
	public String loadTahsilApp() throws Exception {
		log.fatal("loadTahsilApp");

		//language = (String) request.getSession().getAttribute("_LANGUAGE");
		log.fatal("district_id====="+district_id+",language="+language);
		try {
			tahsilList = new ArrayList<CommonOptionsVO>();
			if ((this.district_id != null) && (this.district_id.length() > 0)
					&& (this.language != null) && (this.language.length() > 0)) {
			log.fatal("district id and language is not null");
			tahsilList = manager.searchtahsilbyDistrictIDApp(
						Integer.parseInt(language),
						Integer.parseInt(district_id));
			}
		} catch (Exception e) {
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		log.fatal("tahsilList.size()====="+tahsilList.size());
		return SUCCESS;
	}
	
	
	

	@SkipValidation
	public String regeneratePDF() throws Exception {
		//String returnData = "0";
		try {
			log.fatal("Regeration PDF appointmentNoFinal="+appointmentNoFinal);
			
			String[] appointmentStatus = manager.searchAppointeeMobileNo(appointmentNoFinal,"Appointment").split("#");
			if(appointmentStatus[1].equalsIgnoreCase("No Data")){
				getData = "0";
			}else{
				generateReport(appointmentNoFinal);
				getData = "1";
			}
		}catch(Exception e){
			log.fatal("regeneratePDF="+helper.writeLogInUpperCase(e));
		}
		System.out.println("regeneratePDF returnData="+getData);
		log.fatal("regeneratePDF returnData="+getData);
		return SUCCESS;
    }

	@SkipValidation
	public String loadDeedCategory() throws Exception {
		log.fatal("loadDeedCategory");

		log.fatal("deed_type====="+deed_type);
		try {
			deed_categoryList = new ArrayList<CommonOptionsVO>();
			if ((this.deed_type != null) && (this.deed_type.length() > 0)) {
			log.fatal("deed_type is not null");
				dsrLocationList = manager.searchTempDeedCategory(Integer.parseInt(deed_type));
			}
		} catch (Exception e) {
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		log.fatal("deed_categoryList.size()====="+deed_categoryList.size());
		return SUCCESS;
	}
	
	@SkipValidation
	public String calculateStampAmount() throws Exception {
		log.fatal("calculateStampAmount");

		log.fatal("deed_type====="+deed_type);
		log.fatal("deed_category====="+deed_category);
		log.fatal("considered_amount====="+considered_amount);
		try {
			
			String[] searchStampRate = manager.searchStampRate(Integer.parseInt(deed_type),Integer.parseInt(deed_category)).split("#");
			
			log.fatal(searchStampRate[0]+"<=>"+searchStampRate[1]);
			
			if(searchStampRate[0].equalsIgnoreCase("fixed")){
				calculate_stamp_value = new BigDecimal(searchStampRate[1]);
			}else{
				calculate_stamp_value = new BigDecimal((Double.parseDouble(considered_amount) / 100) * (Double.parseDouble(searchStampRate[1])));
			}
			
			//stamp_value
			
		} catch (Exception e) {
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		log.fatal("calculate_stamp_value====="+calculate_stamp_value);
		return SUCCESS;
	}
	
	@SkipValidation
	public String consideredAmountReq() throws Exception {
		log.fatal("consideredAmountReq");

		log.fatal("deed_type====="+deed_type);
		log.fatal("deed_category====="+deed_category);
		//log.fatal("considered_amount====="+considered_amount);
		try {
			
			considered_amount_req = manager.searchConsideredAmountReq(Integer.parseInt(deed_type),Integer.parseInt(deed_category));
			
		} catch (Exception e) {
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		log.fatal("considered_amount_req====="+considered_amount_req);
		return SUCCESS;
	}
	
	public String successPage() throws Exception {
		
		log.fatal("appointmentNoFinal="+appointmentNoFinal);
      
		String fileLocation = helper.appointmentPDFPath();
		String reportName = "APPOINTMENT_SLIP";
		String token_no = appointmentNoFinal;
		
		String reportName1 = "APPOINTMENT_SLIP_1";
		String token_no1 = appointmentNoFinal1;
		
		System.out.println("fileName in successPage()  is -" +fileName)	;
		fileName = fileLocation + reportName + "_" + token_no + ".pdf";
		fileName1 = fileLocation + reportName + "_" + token_no1 + ".pdf";
		
		otherPartyList = manager.getAppointmentPartyList(appointmentNoFinal);
		
		if(appointmentNoFinal1!=null && appointmentNoFinal1.toString().length()>0)
			otherPartyList1 = manager.getAppointmentPartyList(appointmentNoFinal1);
		
		return SUCCESS;
	}
	
	
	
}