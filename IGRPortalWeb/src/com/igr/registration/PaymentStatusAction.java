package com.igr.registration;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.util.ServletContextAware;

//import Encryption.AESEncrypt;
//import Encryption.ChecksumMD5;

import com.igr.commonUtility.CommonHelper;
import com.igr.commonUtility.CommonValidation;
import com.igr.hibernate.model.PaymentModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentStatusAction extends ActionSupport implements
ServletContextAware, ServletRequestAware, SessionAware {
	
	private static final long serialVersionUID = -157839338650220236L;
	private String merchant_code;
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
	
	
	private String spFee;
	private String registrationFee;
	

	
	private ServletContext context;
	private HttpServletRequest request;

	

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");

	private static CommonValidation validator = new CommonValidation();
	private static CommonHelper helper = new CommonHelper();
	HibernateManager manager = new HibernateManager();
	/*private static final Logger log = Logger.getLogger(PaymentStatusAction.class);*/
	private static Logger log = Logger.getLogger(PaymentStatusAction.class);
	private Map<String,Object> sessionMap;
	
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

	public Boolean getChecksum_match() {
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

	public String getToken_no() {
		return token_no;
	}

	public void setToken_no(String token_no) {
		this.token_no = token_no;
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

	@SkipValidation
	public String paymentStatus()throws Exception{
		//log.fatal("in payment status final");
		String actionValue="home";
		try{
			
			/*
			AESEncrypt encrpt=new Encryption.AESEncrypt();
			String path=ServletActionContext.getServletContext().getRealPath("/key/CG_LAND.key");
			encrpt.setSecretKey(path);
			log.fatal("encdata:"+encdata);
			log.fatal(encdata);
			String decData=encrpt.decryptFile(encdata);
			log.fatal(decData);
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
			
			if(new HibernateManager().updatePayment(ob)){
				actionValue=SUCCESS;
			}
			*/
			actionValue=SUCCESS;
		}catch(Exception e){
			this.addActionError(getText("global.system.error"));
			log.fatal(helper.writeLogInUpperCase(e));
		}
		return actionValue;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		sessionMap=arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.context=arg0;
		
	}

}
