package com.igr.commonUtility;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.igr.hibernate.model.appointmentOTPModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionSupport;

public class OfficeAppoimentCancelAction extends ActionSupport implements SessionAware, ServletRequestAware {
	
    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(OfficeAppoimentCancelAction.class);

	private HttpServletRequest request;
	private Map<String, Object> session = null;
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();

	private String appointmentNoFinal;
	private String mobileNo;
    private String otpText;
    private String otpVarify;
	private String getData;

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
    
    public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
    
	public String getAppointmentNoFinal() {
		return appointmentNoFinal;
	}
	public void setAppointmentNoFinal(String appointmentNoFinal) {
		this.appointmentNoFinal = appointmentNoFinal;
	}

	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOtpText() {
		return otpText;
	}
	public void setOtpText(String otpText) {
		this.otpText = otpText;
	}
	
	public String getOtpVarify() {
		return otpVarify;
	}
	public void setOtpVarify(String otpVarify) {
		this.otpVarify = otpVarify;
	}

	public String getGetData() {
		return getData;
	}
	public void setGetData(String getData) {
		this.getData = getData;
	}

	public String execute() throws Exception {
        log.fatal("Office Appointment Cancel execute....");
        
        try{
            
        }catch(Exception e){
            log.fatal("Office Appointment Cancel Exception "+e);
        }
        return "success";
    }
	
	public String verifyAppointmentNo() throws Exception {
		log.fatal("Office Appointment Cancel verifyAppointmentNo....");
		
		String verifyAppointmentNo = ERROR;
        
        try{
        	String[] searchData = manager.searchAppointeeMobileNo(appointmentNoFinal,"Cancel").split("#");
        	
        	if(!searchData[1].equalsIgnoreCase("No Data")){
        		
        		mobileNo = searchData[1];
        		
        		log.fatal("generateOTP mobileNo="+mobileNo);
	            System.out.println("generateOTP mobileNo="+mobileNo);
	            otpText = getData = helper.generateOPT();
	            
	            log.fatal("OTP Integer="+Double.parseDouble(otpText));
	            
	            appointmentOTPModel appOTPModel = new appointmentOTPModel();
				appOTPModel.setMobile_no(mobileNo);
				appOTPModel.setOtp(Integer.parseInt(otpText));
				appOTPModel.setSource_booking("O");
				appOTPModel.setType_booking("N");
				appOTPModel.setActive_tag(true);
				
				if(manager.InsertOTPAppointment(appOTPModel)){
					
		            String msg = "Dear Your OTP is "+otpText+"   CGIGRS";
		            String template_id = "1207162573105228218";
		            
		            helper.sendSMS(this.mobileNo, msg, template_id);
				}

				session.put("sessionNewOTP", otpText);
				session.put("sessionNewUserName", this.mobileNo);
				session.put("sessionNewMobilNo", this.mobileNo);
	            
        		verifyAppointmentNo = SUCCESS;
        	}else{
        		log.fatal("This Appointment No is Not Valid. Please Enter Valid Appointment No.");
        		this.addActionError("This Appointment No is Not Valid. Please Enter Valid Appointment No.");
        	}
        }catch(Exception e){
            log.fatal("Office Appointment Cancel Exception "+e);
        }
        return verifyAppointmentNo;
	}

	public String cancelAppointmentNo() throws Exception{
		String returnValue = ERROR;
		try{
			log.fatal("cancelAppointmentNo Entred OTP="+this.otpVarify);

			String sessionOTP = (String) request.getSession().getAttribute("sessionNewOTP");
			
			if(sessionOTP.equalsIgnoreCase(this.otpVarify)){
				log.fatal("Please Cancel Appointment.....mobileNo="+mobileNo+",otpVarify="+otpVarify);
				if(manager.updateAppointmentOTPDetail(mobileNo,this.otpVarify)){

					if(manager.updateAppointmentCancel(appointmentNoFinal)){
						returnValue = SUCCESS;
					}
					
					
				}else{
					returnValue = ERROR;
				}
			}else{
				this.addActionError("Please Enter Valide OTP");
				returnValue = ERROR;
			}
			
		}catch(Exception e){
			log.fatal(helper.writeLogInUpperCase(e));
			returnValue = ERROR;
		}
		
		return returnValue;
	}
}