package com.igr.commonUtility;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;



import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;



public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
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
	private String js_enabled;
	private String ch;
	

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	private Map<String, Object> session = null;
	private static CommonHelper helper = new CommonHelper();
	private static CommonValidation validator = new CommonValidation();
	HibernateManager manager = new HibernateManager();

	//private static final Logger log = Logger.getLogger(LoginAction.class);
	
	private final Logger log = Logger.getLogger(LoginAction.class);

	public String home() {
		log.fatal("Home Action");
		return SUCCESS;
	}
	
	public String loginForm(){
		log.fatal("loginForm()");
		byte[] salt=SecurePassword.getSalt();
		SessionMap<String, Object> session = (SessionMap<String, Object>) ActionContext.getContext().getSession();
		log.fatal("loginform:"+salt);
		session.invalidate();
		//session.put("captcha_key_name", ch);
		session.put("salt", salt);
		log.fatal("loginForm()"+salt);
		
		
		System.out.println("This is initiate "+this.userName);
		
		return SUCCESS;
	}

	// Log Out user
	public String logOut() {

		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Expires", "0");
		//response.setHeader("Cache-Control", "no-store");

		session.remove("_EMPCODE");
		session.remove("_LOCATIONID");
		session.remove("_USERGROUP");
		session.remove("_LANGUAGE");
		session.remove("DISPLAYNAME");
		session.remove("LOCATIONNAME");
		session.clear();
		SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();
		/*log.fatal(sessionMap.get("a"));*/
		//invalidate
		sessionMap.invalidate();
		
		//renew servlet session
		sessionMap.put("renewServletSession", null);
		sessionMap.remove("renewServletSession");
		/*log.fatal(sessionMap.get("a"));
		sessionMap.put("a", "x");*/
		addActionMessage("You have been Successfully Logged Out");
		return SUCCESS;
	}

	public String login() {
		log.fatal("1");
		log.fatal("ID:"+userName);
		log.fatal("Password:"+password);
		log.fatal(session.get("captcha_key_name"));
		log.fatal("js_enabled==="+js_enabled);
		String loginValue = LOGIN;

		try {
			/*userName = "sirsendu";
			password = "sirsendu";*/
			
			if (captcha==null || captcha.isEmpty() || captcha.trim().equalsIgnoreCase("")){
				this.addActionError("Please Enter Captcha");
				loginValue = LOGIN;
			}
			
			else if(!captcha.equals(session.get("captcha_key_name"))){
				this.addActionError("Captcha Not Matched. Try Again");
				loginValue = LOGIN;
			} 

			else if ((!this.userName.isEmpty()) && (!this.password.isEmpty()) && (!this.language.equalsIgnoreCase("0"))) {
				//log.fatal(2);
				//log.fatal("Password:"+password);
				//String path=ServletActionContext.getServletContext().getRealPath("/key/CG_LAND.key");
				//encrpt.setSecretKey(path);
				//String decPassword=encrpt.decryptFile(this.password);
				//log.fatal("Dec Password:"+decPassword);
				
				byte[] salt=(byte[])session.get("salt");
				log.fatal("Salt value in login:"+salt);
				
				String returnMap[] = helper.cheekUserValidity(userName,
						password, Integer.parseInt(language),salt);
				
				/*if(js_enabled.equals("false")){
					this.addActionError("To Login You need to enable JavaScript");
					loginValue = LOGIN;
				}
				else */
				if(returnMap[0]==null) {
					this.addActionError("Error. Pease try later.");
					loginValue = LOGIN;
				}
				else if ((returnMap[0]).equals("99999XXXXXX")) {
					this.addActionError("Username  and Password mismatch!");
					loginValue = LOGIN;
				} else if (!returnMap[0].equals("99999XXXXXX")) {
					
					SessionMap<String, Object> sessionMap = (SessionMap<String, Object>) ActionContext.getContext().getSession();
					/*log.fatal(sessionMap.get("a"));*/
					//invalidate
					sessionMap.invalidate();
					log.fatal("Session about to renew");
					//renew servlet session
					sessionMap.put("renewServletSession", null);
					sessionMap.remove("renewServletSession");
					/*log.fatal(sessionMap.get("a"));
					sessionMap.put("a", "x");*/

					session.put("_EMPCODE", returnMap[0]);
					session.put("_LOCATIONID", returnMap[1]);
					session.put("_USERGROUP", returnMap[2]);
					session.put("_LANGUAGE", returnMap[3]);
					session.put("DISPLAYNAME", this.userName);
					session.put("LOCATIONNAME", returnMap[5]);
					session.put("DISTRICT_CODE", returnMap[6]);
					session.put("DISTRICT_NAME", returnMap[7]);
					loginValue = SUCCESS;
					log.fatal("Session renewed");
				}

			}else{
				if (userName==null || userName.isEmpty() || userName.trim().equalsIgnoreCase("")){
					this.addActionError("Username is required for Login");
					loginValue = LOGIN;
				}
				if (password==null || password.isEmpty() || password.trim().equalsIgnoreCase("")){
					this.addActionError("Password is required for Login");
					loginValue = LOGIN;
				}
				if (language==null || language.isEmpty() || language.trim().equalsIgnoreCase("0")){
					this.addActionError("Please Select a language");
					loginValue = LOGIN;
				}
			}

			

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal("Exception ", e);
		}
		log.fatal(loginValue);
		return loginValue;

	}
	
	/*public String encrytAction(){
		
	}*/

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



	public String getUserName() {
		return userName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getJs_enabled() {
		return js_enabled;
	}

	public void setJs_enabled(String js_enabled) {
		this.js_enabled = js_enabled;
	}
	
	@SkipValidation
	public String changePass(){
		try{
			log.fatal("in pass change hello");
			this.password=helper.passwordEncoder(password);
			log.fatal("Actual Password:"+this.password);
			byte[] salt=(byte[])session.get("salt");
			this.password=SecurePassword.getSecurePassword(this.password, salt);
			log.fatal("Password after salting: "+this.password);
		}catch(Exception e){
			log.fatal(helper.writeLogInUpperCase(e));
			return ERROR;
		}
		return SUCCESS;
	}
	

	
}