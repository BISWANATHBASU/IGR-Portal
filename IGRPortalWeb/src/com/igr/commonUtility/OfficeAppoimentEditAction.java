package com.igr.commonUtility;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.appointmentEStampModel;
import com.igr.hibernate.model.appointmentOTPModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class OfficeAppoimentEditAction extends ActionSupport implements SessionAware, ServletRequestAware {

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(OfficeAppoimentEditAction.class);

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
	
	private String appointmentID;
	private String appointmentDate;
	private String appointmentTime;
	private String appointmentNoFinal;
	private String appointmentTimeFinal;
	
	private String dsr_location;
	private String mobileNo;
	
	private String pdfPath;
	
	private String getData;
	private String otpVarify;
	private String verifyStatus;

    private List<CommonOptionsVO> appointmentDateList;
    private List<CommonOptionsVO> appointmentTimeList;
	
	List<CommonNineOptionsVO> appointmentDetailList = new ArrayList<CommonNineOptionsVO>();
	List<CommonNineOptionsVO> otherPartyList = new ArrayList<CommonNineOptionsVO>();

    private String rowStampNo;
    
    private List<CommonOptionsVO> deed_typeList;
    private List<CommonOptionsVO> deed_categoryList;
    private List<CommonOptionsVO> deedCategoryList;
    private String deed_type;
    private String deed_category;
    private String considered_amount;
    private String stamp_value;
    private BigDecimal calculate_stamp_value;
    
    private String considered_amount_req;
	
	public String getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public List<CommonNineOptionsVO> getAppointmentDetailList() {
		return appointmentDetailList;
	}

	public void setAppointmentDetailList(List<CommonNineOptionsVO> appointmentDetailList) {
		this.appointmentDetailList = appointmentDetailList;
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

	public String getDsr_location() {
		return dsr_location;
	}

	public void setDsr_location(String dsr_location) {
		this.dsr_location = dsr_location;
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

	public List<CommonNineOptionsVO> getOtherPartyList() {
		return otherPartyList;
	}

	public void setOtherPartyList(List<CommonNineOptionsVO> otherPartyList) {
		this.otherPartyList = otherPartyList;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
    
    public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
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

	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
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

	public List<CommonOptionsVO> getDeedCategoryList() {
		return deedCategoryList;
	}

	public void setDeedCategoryList(List<CommonOptionsVO> deedCategoryList) {
		this.deedCategoryList = deedCategoryList;
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

	public String execute() throws Exception {
        log.fatal("Office Appointment Edit execute....");
        
        try{
        	appointmentDateList = new ArrayList<CommonOptionsVO>();
        	appointmentTimeList = new ArrayList<CommonOptionsVO>();
        	
        	pdfPath = helper.appointmentPDFPath();
        }catch(Exception e){
            log.fatal("Office Appointment Edit Exception "+e);
        }
        log.fatal("execute return success");
        return "success";
    }
    
    public String searchAppointmentDetail() throws Exception{
    	log.fatal("Search Office Appointment Edit execute....");
        
        try{
        	log.fatal("Search Office Appointment ID="+appointmentID);
        	
        	String[] searchData = manager.searchAppointeeMobileNo(appointmentID,"Reappointment").split("#");
        	if(!searchData[1].equalsIgnoreCase("No Data")){
	        	mobileNo = searchData[1];
	        	log.fatal("searchAppointmentDetail mobileNo="+mobileNo);
	        	
	        	String otp = generateOPT();
        	}else{
        		this.addActionError("Please Enter Valid Appointment No");
        		return "error";
        	}
        	
        }catch(Exception e){
            log.fatal("Search Office Appointment Edit Exception "+e);
        }
    	
    	return "success";
    }
	
	public String generateOPT() throws Exception{
        System.out.println("generateOPT=========");
        try{
            log.fatal("generateOPT");
            System.out.println("generateOPT");
            String otpText = getData = helper.generateOPT();

            appointmentOTPModel appOTPModel = new appointmentOTPModel();
			appOTPModel.setMobile_no(mobileNo);
			appOTPModel.setOtp(Integer.parseInt(otpText));
			appOTPModel.setSource_booking("O");
			appOTPModel.setType_booking("R");
			appOTPModel.setActive_tag(true);
			
			if(manager.InsertOTPAppointment(appOTPModel)){
	            
	            //String msg = otpText+" is your OTP for Reappointment.";
	            
	            String msg = otpText+" is your OTP for Appointment CGIGRS";
	            String template_id = "1207161538031975884";
	            
	            helper.sendSMS(this.mobileNo, msg, template_id);
	        	
	        	log.fatal(msg);
	        	
				session.put("sessionOTP", otpText);
				session.put("sessionUserName", this.mobileNo);
				session.put("sessionMobilNo", this.mobileNo);
				
				getData = "1";
			}
        }
        catch(Exception e){
        	getData = "0";
            log.fatal("generateOPT="+helper.writeLogInUpperCase(e));
            System.out.println("generateOPT="+helper.writeLogInUpperCase(e));
            throw new Exception(getText("global.system.error"));
        }
        return "success";
    }
	
	public String VerifyOTP() throws Exception{
		try{
			log.fatal("Entred OTP="+this.otpVarify);

			String sessionOTP = (String) request.getSession().getAttribute("sessionOTP");
			
			if(sessionOTP.equalsIgnoreCase(this.otpVarify)){
				log.fatal("Please Take Appointment.....");

	        	appointmentDateList = new ArrayList<CommonOptionsVO>();
	        	appointmentTimeList = new ArrayList<CommonOptionsVO>();
	        	
	        	appointmentDetailList = manager.searchAppointmentDetailList(appointmentID);
	        	
	        	dsr_location = appointmentID.substring(4, 7);
	        	log.fatal("Search Office Appointment ID location Code="+dsr_location);
	        	
	        	//appointmentDateList = manager.getAppDateList(Integer.parseInt(dsr_location));
	            
	            deed_typeList = manager.searchTempDeedType();
	            deed_categoryList = new ArrayList();
	        	
	        	if(manager.updateAppointmentOTPDetail(mobileNo,this.otpVarify)){
					return SUCCESS;
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
	
	public String VerifyOTPReschedule() throws Exception{
		try{
			log.fatal("Entred OTP="+this.otpVarify);

			String sessionOTP = (String) request.getSession().getAttribute("sessionOTP");
			
			if(sessionOTP.equalsIgnoreCase(this.otpVarify)){
				log.fatal("Please Take Appointment.....");

	        	appointmentDateList = new ArrayList<CommonOptionsVO>();
	        	appointmentTimeList = new ArrayList<CommonOptionsVO>();
	        	
	        	appointmentDetailList = manager.searchAppointmentDetailListReschedule(appointmentID);
	        	
	        	dsr_location = appointmentID.substring(4, 7);
	        	log.fatal("Search Office Appointment ID location Code="+dsr_location);
	        	
	        	appointmentDateList = manager.getAppDateRescheduleList(Integer.parseInt(dsr_location));
	            
	            deed_typeList = manager.searchTempDeedType();
	            deed_categoryList = new ArrayList();
	        	
	        	if(manager.updateAppointmentOTPDetail(mobileNo,this.otpVarify)){
					return SUCCESS;
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
    
    public String updateAppointmentDetail() throws Exception{
    	String updateAppointmentDetail = "";
    	String filePath = "";
    	
    	try{
    		//String[] arrayAppTime = appointmentTime.split("-");
    		//appointmentTimeFinal = arrayAppTime[0];
    		
    		appointmentNoFinal = appointmentID;
    		
    		log.fatal("Update Office Appointment Edit Datail AppointmentID="+appointmentID+",AppointmentDate="+appointmentDate+",AppointmentTime"+appointmentTime+",appointmentNoFinal="+appointmentNoFinal);
    		
			log.fatal("Appointment Date ="+appointmentDate+",dsr_location="+dsr_location);
			System.out.println("Appointment Date ="+appointmentDate+",dsr_location="+dsr_location);

			log.fatal("deed_type====="+deed_type+",deed_category====="+deed_category+",considered_amount====="+considered_amount);
			System.out.println("deed_type====="+deed_type+",deed_category====="+deed_category+",considered_amount====="+considered_amount);
			

			boolean stampCheck = false;
			String eStampAllNo = "";
			
			List<CommonFiveOptionsVO> stampListVer = datafromScreen.getStampList(request, this.rowStampNo);
			if ((stampListVer != null) && (stampListVer.size() > 0)) {
				ListIterator<CommonFiveOptionsVO> listItr = stampListVer.listIterator();

				while (listItr.hasNext()) {
					CommonFiveOptionsVO optionVO = (CommonFiveOptionsVO) listItr.next();

					log.fatal("=>e-Stamp No="+optionVO.getTypeCode_1()+",e-Stamp Date="+optionVO.getTypeCode_2()+",e-Stamp Amount="+optionVO.getTypeCode_3());
					System.out.println("=>e-Stamp No="+optionVO.getTypeCode_1()+",e-Stamp Date="+optionVO.getTypeCode_2()+",e-Stamp Amount="+optionVO.getTypeCode_3());
					
					if(optionVO.getTypeCode_1() != "" && !optionVO.getTypeCode_1().equalsIgnoreCase("")){
						eStampAllNo = eStampAllNo +",'"+ optionVO.getTypeCode_1()+"'";
					}
				}
			}

			log.fatal("=====eStampAllNo="+eStampAllNo+"==>eStampAllNo.length()="+eStampAllNo.length());
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
			System.out.println("<<<<<"+eStampAllNo);
			
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
				
				if(manager.updateAppointmentDetailNew(appointmentID,deed_type,deed_category,considered_amount,stamp_value)){
					
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
								
								appEstampModel.setAppointment_no(appointmentID);
								appEstampModel.setAppointment_date(sdf1.parse(appointmentDate));//sdf.parse(appointmentDate)
								
								manager.AppointmentEStamp(appEstampModel);
							}
						}
					}
					String msg = "आपके द्वारा चयन किया गया ई-पंजीयन कि अपाईन्टमेंट आईडी  "+appointmentNoFinal+" का  ई-स्टाम्प  विवरण सफलता पुर्वक सम्पन्न हुआ |";
					log.fatal("Appointy Sending Mobile Message="+msg+" on "+mobileNo);
					System.out.println("Appointy Sending Mobile Message="+msg+" on "+mobileNo);
		            
		            //helper.sendSMS(this.mobileNo, msg);
					
		            filePath = generateReport(appointmentNoFinal);
					
		            request.setAttribute("fileName", filePath);
		            updateAppointmentDetail = "success";
		    	}else{
		    		
		        	appointmentDateList = new ArrayList<CommonOptionsVO>();
		        	appointmentTimeList = new ArrayList<CommonOptionsVO>();
		        	
		        	appointmentDetailList = manager.searchAppointmentDetailList(appointmentID);
		        	
		        	dsr_location = appointmentID.substring(4, 7);
		        	log.fatal("Search Office Appointment ID location Code="+dsr_location);
		        	
		        	//appointmentDateList = manager.getAppDateList(Integer.parseInt(dsr_location));
		            
		            deed_typeList = manager.searchTempDeedType();
		            deed_categoryList = new ArrayList();
		            
		    		updateAppointmentDetail = "error";
		    	}
			}else{
	    		
	        	appointmentDateList = new ArrayList<CommonOptionsVO>();
	        	appointmentTimeList = new ArrayList<CommonOptionsVO>();
	        	
	        	appointmentDetailList = manager.searchAppointmentDetailList(appointmentID);
	        	
	        	dsr_location = appointmentID.substring(4, 7);
	        	log.fatal("Search Office Appointment ID location Code="+dsr_location);
	        	
	        	//appointmentDateList = manager.getAppDateList(Integer.parseInt(dsr_location));
	            
	            deed_typeList = manager.searchTempDeedType();
	            deed_categoryList = new ArrayList();
	            
	            this.addActionError("This E-Stamp No is Already Used, Please Enter Another E-Stamp No");
	            
	    		updateAppointmentDetail = "error";
	    	}
			
			
			/*if(manager.checkValieAppDate(Integer.parseInt(dsr_location),appointmentDate)){
				log.fatal("Appointment Date Valid");
				System.out.println("Appointment Valid");
				
				if(manager.checkValieAppTime(Integer.parseInt(dsr_location),appointmentDate, appointmentTime)){
	    		
		    		manager.updateAppointmentDetail(appointmentID, appointmentDate, appointmentTime);
		
					//String msg = "ई पंजीयन हेतु दर्ज अपॉइंटमेंट आईडी "+appointmentNoFinal+" दिनांक :" + appointmentDate + " समय   :"+arrayAppTime[0]+" उक्त समय पर सम्बंधित व्यक्तियो के संग "+dsrName+" पंजीयन कार्यालय में उपस्थित होवे";
		    		String msg = "आपके द्वारा चयन किया गया ई-पंजीयन कि अपाईन्टमेंट आईडी  "+appointmentNoFinal+"  पुनः निर्धारित   दिनांक  "+appointmentDate+"  समय  "+arrayAppTime[0]+"  बजे सफलता पुर्वक सम्पन्न हुआ |";
					log.fatal("Appointy Sending Mobile Message="+msg+" on "+mobileNo);
					System.out.println("Appointy Sending Mobile Message="+msg+" on "+mobileNo);
		            
		            helper.sendSMS(this.mobileNo, msg);
		    		
		    		//otherPartyList = manager.searchOtherPartyDetailList(appointmentID);
		    		
		            filePath = generateReport(appointmentNoFinal);
					
		            request.setAttribute("fileName", filePath);
		            updateAppointmentDetail = "success";
		            
		            log.fatal("updateAppointmentDetail===========");
		            
				}else{
					log.fatal("Appointment Time Not Valid");
					System.out.println("Appointment Time Not Valid");
					
					this.addActionError("Appointment slot already booked. Try another slot.");
					//this.addActionError("Please Select Valide Time");
					
		        	appointmentDateList = new ArrayList<CommonOptionsVO>();
		        	appointmentTimeList = new ArrayList<CommonOptionsVO>();
		        	
		        	pdfPath = helper.appointmentPDFPath();
		        	
		        	appointmentDetailList = manager.searchAppointmentDetailList(appointmentID);
		        	
		        	dsr_location = appointmentID.substring(4, 7);
		        	log.fatal("Search Office Appointment ID location Code="+dsr_location);
		        	
		        	appointmentDateList = manager.getAppDateList(Integer.parseInt(dsr_location));
					
					updateAppointmentDetail = "error";
		            
		            log.fatal("updateAppointmentDetail===========");
				}
			}else{
				log.fatal("Appointment Date Not Valid");
				System.out.println("Appointment Date Not Valid");
				
				this.addActionError("Data is not Valid.Please Re entry with proper data");
				//this.addActionError("Please Select Valide Date");
				
	        	appointmentDateList = new ArrayList<CommonOptionsVO>();
	        	appointmentTimeList = new ArrayList<CommonOptionsVO>();
	        	
	        	pdfPath = helper.appointmentPDFPath();
	        	
	        	appointmentDetailList = manager.searchAppointmentDetailList(appointmentID);
	        	
	        	dsr_location = appointmentID.substring(4, 7);
	        	log.fatal("Search Office Appointment ID location Code="+dsr_location);
	        	
	        	appointmentDateList = manager.getAppDateList(Integer.parseInt(dsr_location));
				
				updateAppointmentDetail = "error";
	            
	            log.fatal("updateAppointmentDetail===========");
			}*/
    		
    	}catch(Exception e){
            log.fatal("Update Office Appointment Edit Exception "+e);
        }
    	log.fatal("return updateAppointmentDetail ="+updateAppointmentDetail);
    	System.out.println("return updateAppointmentDetail ="+updateAppointmentDetail);
    	return updateAppointmentDetail;
    }
    
    public void validate() {
		try {
			
		} catch (Exception e) {
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));

		}
    }
    

	
	 public String generateReport(String appointmentNoFinal)  throws Exception {
    	JasperPrint jasperPrint = null;
    	Connection con = null;
		String printFileName = "";
		
		String repPath = "/report/APPOINTMENT_SLIP.jasper";
		String token_no =appointmentNoFinal;
		String reportName = "APPOINTMENT_SLIP";
		String filePath = "";
		
		
	    File reportFile = new File(request.getSession(false).getServletContext().getRealPath(repPath));

		Map<String, String> reportParams = new HashMap<String, String>(2, 1.0f);
		reportParams.put("SUBREPORT_DIR", reportFile.getParentFile().getAbsolutePath());
		Date currentDate = new Date();

	
		reportParams.put("token_no", token_no);
		reportParams.put("event", "OLD");
	

	
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

				contentStream.drawXObject(ximage, 1, 1, scaledDim.width,scaledDim.height);

				contentStream.close();

				//doc.save(fileLocation + reportName + "_" + token_no + "~" + currentMiliSecond + "_" + i + ".pdf");
				doc.save(fileLocation + reportName + "_" + token_no + "~" + "_" + i + ".pdf");

				//merger.addSource(fileLocation + reportName + "_" + token_no+"~" + currentMiliSecond + "_" + i + ".pdf");
				merger.addSource(fileLocation + reportName + "_" + token_no+"~" + "_" + i + ".pdf");
				doc.close();

			}

			//merger.setDestinationFileName(fileLocation + reportName + "_" + token_no +  "~" + currentMiliSecond + ".pdf");
			merger.setDestinationFileName(fileLocation + reportName + "_" + token_no + ".pdf");

			merger.mergeDocuments();

			//filePath = fileLocation + reportName + "_" + token_no + "~"  + currentMiliSecond + ".pdf";
			filePath = fileLocation + reportName + "_" + token_no + ".pdf";
		
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
    


	@SkipValidation
	public String loadDeedCategory() throws Exception {
		log.fatal("Edit loadDeedCategory");

		log.fatal("Edit deed_type====="+deed_type);
		try {
			deed_categoryList = new ArrayList<CommonOptionsVO>();
			if ((this.deed_type != null) && (this.deed_type.length() > 0)) {
			log.fatal("Edit deed_type is not null");
				deedCategoryList = manager.searchTempDeedCategory(Integer.parseInt(deed_type));
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
	
	public String searchAppointmentReschedule() throws Exception{
    	log.fatal("Search Office Appointment Reschedule....");
        
        try{
        	log.fatal("Search Office Appointment ID="+appointmentID);
        	
        	String[] searchData = manager.searchAppointeeReschedule(appointmentID).split("#");
        	if(!searchData[1].equalsIgnoreCase("No Data")){
	        	mobileNo = searchData[1];
	        	log.fatal("searchAppointmentReschedule mobileNo="+mobileNo);
	        	
	        	String otp = generateOPT();
        	}else{
        		this.addActionError("Please Enter Valid Appointment No");
        		return "error";
        	}
        	
        }catch(Exception e){
            log.fatal("Search Office Appointment Reschedule Exception "+e);
        }
    	
    	return "success";
    }
	
	public String fetchAppTimeRescheduleList() throws Exception {
		log.fatal("fetchAppTimeRescheduleList");

		log.fatal("dsr_location====="+dsr_location+","+appointmentDate);
		try {
			appointmentTimeList = new ArrayList<CommonOptionsVO>();
			if ((this.dsr_location != null) && (this.dsr_location.length() > 0)) {
				log.fatal("district id and language is not null");
				appointmentTimeList = manager.getAppTimeRescheduleList(Integer.parseInt(dsr_location),appointmentDate);
			}
		} catch (Exception e) {
			log.fatal(e);
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		log.fatal("fetchAppTimeRescheduleList.size()====="+appointmentTimeList.size());
		return SUCCESS;
	}
    
    public String updateAppointmentDetailReschedule() throws Exception{
    	String updateAppointmentDetailReschedule = "";
    	String filePath = "";
    	
    	try{
    		String[] arrayAppTime = appointmentTime.split("-");
    		appointmentTimeFinal = arrayAppTime[0];
    		
    		appointmentNoFinal = appointmentID;
    		
    		log.fatal("Update Office Appointment Edit Datail AppointmentID="+appointmentID+",AppointmentDate="+appointmentDate+",AppointmentTime"+appointmentTime+",appointmentNoFinal="+appointmentNoFinal);
    		
			log.fatal("Appointment Date ="+appointmentDate+",dsr_location="+dsr_location);
			System.out.println("Appointment Date ="+appointmentDate+",dsr_location="+dsr_location);
			
			if(manager.checkValieAppDateReschedule(Integer.parseInt(dsr_location),appointmentDate)){
				log.fatal("Appointment Date Valid");
				System.out.println("Appointment Valid");
				
				if(manager.checkValieAppTimeReschedule(Integer.parseInt(dsr_location),appointmentDate, appointmentTime)){
	    		
		    		manager.updateAppointmentDetail(appointmentID, appointmentDate, appointmentTime);
		    		
					//String msg = "ई पंजीयन हेतु दर्ज अपॉइंटमेंट आईडी "+appointmentNoFinal+" दिनांक :" + appointmentDate + " समय   :"+arrayAppTime[0]+" उक्त समय पर सम्बंधित व्यक्तियो के संग "+dsrName+" पंजीयन कार्यालय में उपस्थित होवे";
		    		
		    		String msg = "आपके द्वारा चयन किया गया ई-पंजीयन कि अपाईन्टमेंट आईडी  "+appointmentNoFinal+"  पुनः निर्धारित   दिनांक  "+appointmentDate+"  समय  "+arrayAppTime[0]+"  बजे सफलता पुर्वक सम्पन्न हुआ | CGIGRS";
					
		    		log.fatal("Appointy Sending Mobile Message="+msg+" on "+mobileNo);
					System.out.println("Appointy Sending Mobile Message="+msg+" on "+mobileNo);
					
					String template_id = "1207161795946758346";
		            
		            helper.sendSMS(this.mobileNo, msg, template_id);
		    		
		    		//otherPartyList = manager.searchOtherPartyDetailList(appointmentID);
		    		
		            filePath = generateReport(appointmentNoFinal);
					
		            request.setAttribute("fileName", filePath);
		            updateAppointmentDetailReschedule = "success";
		            
		            log.fatal("updateAppointmentDetailReschedule===========");
		            
				}else{
					log.fatal("Appointment Time Not Valid");
					System.out.println("Appointment Time Not Valid");
					
					this.addActionError("Appointment slot already booked. Try another slot.");
					//this.addActionError("Please Select Valide Time");
					
		        	appointmentDateList = new ArrayList<CommonOptionsVO>();
		        	appointmentTimeList = new ArrayList<CommonOptionsVO>();
		        	
		        	pdfPath = helper.appointmentPDFPath();
		        	
		        	appointmentDetailList = manager.searchAppointmentDetailListReschedule(appointmentID);
		        	
		        	dsr_location = appointmentID.substring(4, 7);
		        	log.fatal("Search Office Appointment ID location Code="+dsr_location);
		        	
		        	appointmentDateList = manager.getAppDateRescheduleList(Integer.parseInt(dsr_location));
					
		        	updateAppointmentDetailReschedule = "error";
		            
		            log.fatal("updateAppointmentDetailReschedule===========");
				}
			}else{
				log.fatal("Appointment Date Not Valid");
				System.out.println("Appointment Date Not Valid");
				
				this.addActionError("Data is not Valid.Please Re entry with proper data");
				//this.addActionError("Please Select Valide Date");
				
	        	appointmentDateList = new ArrayList<CommonOptionsVO>();
	        	appointmentTimeList = new ArrayList<CommonOptionsVO>();
	        	
	        	pdfPath = helper.appointmentPDFPath();
	        	
	        	appointmentDetailList = manager.searchAppointmentDetailListReschedule(appointmentID);
	        	
	        	dsr_location = appointmentID.substring(4, 7);
	        	log.fatal("Search Office Appointment ID location Code="+dsr_location);
	        	
	        	appointmentDateList = manager.getAppDateRescheduleList(Integer.parseInt(dsr_location));
				
	        	updateAppointmentDetailReschedule = "error";
	            
	            log.fatal("updateAppointmentDetailReschedule===========");
			}
    		
    	}catch(Exception e){
            log.fatal("Update Office Appointment Edit Exception "+e);
        }
    	log.fatal("return updateAppointmentDetailReschedule ="+updateAppointmentDetailReschedule);
    	System.out.println("return updateAppointmentDetailReschedule ="+updateAppointmentDetailReschedule);
    	return updateAppointmentDetailReschedule;
    }
}
