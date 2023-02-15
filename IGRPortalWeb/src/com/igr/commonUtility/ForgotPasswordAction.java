package com.igr.commonUtility;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport implements SessionAware, ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(ForgotPasswordAction.class);
	private static CommonHelper helper = new CommonHelper();
	
	HibernateManager manager = new HibernateManager();
	
	private String userName;
	private String mobileNo;
	private String otpText;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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

	private Map<String, Object> session = null;
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	private String newPassword;
	private String confirmPassword;

	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String generateOTP(){
		try{
			log.fatal("Entered Username="+this.userName);
			log.fatal("Entered Mobile="+this.mobileNo);
			
			String otp = helper.matchUserNameMpbile(userName, mobileNo);
			log.fatal(otp);
			
			if(!otp.equalsIgnoreCase("0")){
				String msg = otp+" is your OTP for Pre-Reg. Reset Password";
				
	        	//helper.sendSMS(this.mobileNo, msg);
	        	
	        	log.fatal(msg);
	        	
				session.put("sessionOTP", otp);
				session.put("sessionUserName", this.userName);
				session.put("sessionMobilNo", this.mobileNo);
				return SUCCESS;
			}else{
				this.addActionError("Please Enter Valide User Name and Mobile No.");
				return ERROR;
			}
		}catch(Exception e){
			log.fatal(helper.writeLogInUpperCase(e));
			return ERROR;
		}
	}
	
	public String verifyOTP(){
		try{
			log.fatal("Entred OTP="+this.otpText);

			String sessionOTP = (String) request.getSession().getAttribute("sessionOTP");
			
			if(sessionOTP.equalsIgnoreCase(this.otpText)){
				log.fatal("Password is Updating.....");
			}else{
				this.addActionError("Please Enter Valide OTP");
				return ERROR;
			}
			
		}catch(Exception e){
			log.fatal(helper.writeLogInUpperCase(e));
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String resetPassword(){
		try{
			log.fatal("New Password="+this.newPassword);

			String sessionUserName = (String) request.getSession().getAttribute("sessionUserName");
			String sessionMobilNo = (String) request.getSession().getAttribute("sessionMobilNo");
			
			if(helper.resetPassword(this.newPassword,sessionUserName,sessionMobilNo)){
				log.fatal("Password is Updated.....");
				this.addActionError("Please Login with New Password");
				return SUCCESS;
			}else{
				this.addActionError("Please Enter Valide OTP");
				return ERROR;
			}
			
		}catch(Exception e){
			log.fatal(helper.writeLogInUpperCase(e));
			return ERROR;
		}
	}

}
