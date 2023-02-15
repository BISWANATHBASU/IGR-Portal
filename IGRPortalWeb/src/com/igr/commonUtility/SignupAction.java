package com.igr.commonUtility;

import java.io.IOException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionSupport;


public class SignupAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8506983103161968749L;
	private String language;
	private String user_name;
	private String user_password;
	private String name;
	private String fatherName;
	private String address;
	private String confirmPassword;
	private String birthDate;
	private String gender;
	private String mobileNo;
	private String mailID;
	private String cardType;
	private String cardNo;
	private String captcha;
	
	private Map<String, Object> session;
	private static CommonHelper helper = new CommonHelper();
	private static CommonValidation validator = new CommonValidation();
	HibernateManager manager = new HibernateManager();
	//private static final Logger log = Logger.getLogger(LoginAction.class);
	private static Logger log = Logger.getLogger(LoginAction.class);
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String home() {

		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.session=sessionMap;
		
	}
	
	public Map<String, Object> getSession() {
		return session;
		
	}
	
	public String signup(){
		/*System.out.println("1");*/
		String loginValue = LOGIN;
		System.out.println(this.confirmPassword);
		System.out.println(this.user_password);
		System.out.println(this.cardNo);
		try {
			if(!captcha.equals(session.get("captcha_key_name"))){
				this.cardNo = "";
				this.user_password = "";
				this.confirmPassword = "";
				this.addActionError("Captcha Not Matched. Try Again");
				//System.out.println("Captcha Not Matched. Try Again");
				log.fatal("Captcha Not Matched");
				loginValue = LOGIN;
			} 
			else if (!manager.checkUserName(this.user_name.trim())) {
				//System.out.println("User Name Already ");
				this.cardNo = "";
				this.user_password = "";
				this.confirmPassword = "";
				this.addActionError("User Name Already Exists, Pl. chose another.");
			}
			else if (helper.createNewWebUser(this.user_name,
					this.user_password, this.name, this.fatherName,
					this.address, this.birthDate, this.mobileNo,
					this.mailID, this.gender, this.cardType,
					this.cardNo) == 1) {
				System.out.println("New User Created");
				log.fatal("new user created");
				this.cardNo = "";
				this.user_password = "";
				this.confirmPassword = "";
				this.address="";
				this.birthDate="";
				this.captcha="";
				this.fatherName="";
				this.name="";
				this.user_name="";
				this.mailID="";
				this.mobileNo="";
				this.addActionMessage("New User Created. Now Login");
				log.fatal("New User Created");
				loginValue = SUCCESS;
			} else {
				System.out.println("Sysstem error");
				this.addActionError("System Error Occured. Pl. try again");
				loginValue = LOGIN;

			}
		}catch(Exception e){
			log.fatal(helper.writeLogInUpperCase(e));
			System.out.println(e);
		}
		return loginValue;
	}
	
	public void validate() {
		System.out.println("in validation...");
		if(this.captcha.trim().length()==0) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("captcha", "Captcha Is Required");
		}
		else if (this.user_name.trim().length() == 0) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("user_name", "User Name is Required");
		}
		else if (this.name.trim().length() == 0) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("name","Name is Required");
		}
		else if (!validator.languageValidate(name.trim(),
				this.language)) {
			System.out.println("language error:"+this.language);
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("name",
					"Pl. Input in Proper Language");
		}

		else if (this.fatherName.trim().length() == 0) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("fatherName","Father's / Husband Name is Required");
		}
		
		else if (!validator.languageValidate(fatherName.trim(),
				this.language)) {
			System.out.println("language error");
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("fatherName",
					"Pl. Input in Proper Language");
		}

		else if (this.address.trim().length() == 0) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("address","Address is Required");
		}

		else if (this.confirmPassword.trim().length() == 0) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("confirmPassword","Confirm Password is Required");
		}
		else if (!this.confirmPassword.equals(this.user_password)) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("confirmPassword","Password and Confirm Password Mismatch");
		}
		/*else if(!validator.passwordStrengthValidate(this.user_password))
			this.addFieldError("user_password","Password must contain one letter, one digit and one special character(!@#$)");*/

		else if (this.birthDate.trim().length() == 0) {
			
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("birthDate","Birth Date is Required");
		}
		else if (!validator.dateFormate(this.birthDate.trim())) {
			
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("birthDate","Birth Date is not in Proper Format");
		}
		else if (this.mobileNo.trim().length() == 0) {
		
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("mobileNo","Mobile No. is Required");
		}
		else if (!validator.neumericFiledValidate(this.mobileNo.trim(),
				10)) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("mobileNo","Mobile No. is not Correct");
		}
		else if (this.mailID.trim().length() == 0) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("mailID","Mail id is Required");
		}
		else if (!validator.mailFiledValidate(this.mailID.trim())) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("mailID","Mail id is not valid");
		}
		else if (this.cardNo.trim().length() == 0) {
			this.cardNo = "";
			this.user_password = "";
			this.confirmPassword = "";
			this.addFieldError("cardNo","Identity Card No is Required");
		}
		/*try {
			this.user_password=helper.passwordEncoder(this.user_password);
			this.confirmPassword=helper.passwordEncoder(this.confirmPassword);
			this.cardNo=helper.passwordEncoder(this.cardNo);
		}catch(Exception e) {
			System.out.println(e);
		}*/
		
	}
	
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
}
