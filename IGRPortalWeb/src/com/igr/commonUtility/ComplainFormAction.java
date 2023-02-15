package com.igr.commonUtility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.igr.hibernate.model.feedBackModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionSupport;

public class ComplainFormAction extends ActionSupport implements ServletContextAware, ServletRequestAware, SessionAware {

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(ComplainFormAction.class);
    private ServletContext context;
    private HttpServletRequest request;
    
    private static CommonHelper helper = new CommonHelper();
    HibernateManager manager = new HibernateManager();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss a");

    private List dsrLocationList;
    private List complainDetailList;

    private String full_name;
    private String mobile_no;
    private String e_mail_id;
    private String empID;
    private String language;
    private String webSiteRating;
    private String enterComment;
    private String created_by;
    private String created_datetime;
    private String getData;
    private String feed_back_category;
    private String dsr_location;
    private String e_registration_id;
    private String complain_detail;
    private String sub_complain_detail;
    
    private List subComplainList;
    
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

    public void setServletContext(ServletContext arg0){
        context = arg0;
    }
    public void setServletRequest(HttpServletRequest arg0){
        request = arg0;
    }
    
    public List getDsrLocationList() {
		return dsrLocationList;
	}
	public void setDsrLocationList(List dsrLocationList) {
		this.dsrLocationList = dsrLocationList;
	}
	
	public String getFull_name(){
        return full_name;
    }

    public void setFull_name(String full_name){
        this.full_name = full_name;
    }

    public String getMobile_no(){
        return mobile_no;
    }

    public void setMobile_no(String mobile_no){
        this.mobile_no = mobile_no;
    }

    public String getE_mail_id(){
        return e_mail_id;
    }

    public void setE_mail_id(String e_mail_id){
        this.e_mail_id = e_mail_id;
    }

    public String getEmpID(){
        return empID;
    }

    public void setEmpID(String empID){
        this.empID = empID;
    }

    public String getLanguage(){
        return language;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public String getWebSiteRating(){
        return webSiteRating;
    }

    public void setWebSiteRating(String webSiteRating){
        this.webSiteRating = webSiteRating;
    }

    public String getEnterComment(){
        return enterComment;
    }

    public void setEnterComment(String enterComment){
        this.enterComment = enterComment;
    }

    public String getCreated_by(){
        return created_by;
    }

    public void setCreated_by(String created_by){
        this.created_by = created_by;
    }

    public String getCreated_datetime(){
        return created_datetime;
    }

    public void setCreated_datetime(String created_datetime){
        this.created_datetime = created_datetime;
    }

    public String getGetData(){
        return getData;
    }

    public void setGetData(String getData){
        this.getData = getData;
    }

    public String getFeed_back_category(){
        return feed_back_category;
    }

    public void setFeed_back_category(String feed_back_category){
        this.feed_back_category = feed_back_category;
    }

    public String getDsr_location(){
        return dsr_location;
    }

    public void setDsr_location(String dsr_location){
        this.dsr_location = dsr_location;
    }

    public String getE_registration_id(){
        return e_registration_id;
    }

    public void setE_registration_id(String e_registration_id){
        this.e_registration_id = e_registration_id;
    }

    public String getComplain_detail(){
        return complain_detail;
    }

    public void setComplain_detail(String complain_detail){
        this.complain_detail = complain_detail;
    }
	
	public String getSub_complain_detail() {
		return sub_complain_detail;
	}

	public void setSub_complain_detail(String sub_complain_detail) {
		this.sub_complain_detail = sub_complain_detail;
	}

	public List getComplainDetailList() {
		return complainDetailList;
	}

	public void setComplainDetailList(List complainDetailList) {
		this.complainDetailList = complainDetailList;
	}

	public List getSubComplainList() {
		return subComplainList;
	}

	public void setSubComplainList(List subComplainList) {
		this.subComplainList = subComplainList;
	}

	public String execute() throws Exception{
		
		
		 int returnMessage = 1;
	        String returnValue = "success";
		try{
			log.fatal("I am in Complain Form Action Execute Method");
			System.out.println("I am in Complain Form Action Execute Method");
			
	        dsrLocationList = new ArrayList();
	        dsrLocationList = manager.searchDSRLocationAll(2);
	        
	        complainDetailList = new ArrayList();
	        complainDetailList = manager.getComplainDetailList();
	        
	        subComplainList = new ArrayList();
	        
	        System.out.println("=========="+returnValue);
			
		}
		catch(Exception e){
			e.printStackTrace();
			log.fatal(helper.writeLogInUpperCase(e));
		}
        
        return returnValue;
    }
	
	public String addComplainForm() throws Exception{

        String returnMessage = "";
        Date currentDateValue = new Date();
        
		try{

			System.out.println("Getting Session Data");
			empID = (String) request.getSession().getAttribute("_EMPCODE");
			System.out.println("id="+empID);
			
			language = (String) request.getSession().getAttribute("_LANGUAGE");
			log.fatal("id="+empID+",Language="+language);
			System.out.println("id="+empID+",Language="+language);

			log.fatal("webSiteRating="+webSiteRating+",enterComment="+enterComment);
			System.out.println("webSiteRating="+webSiteRating+",enterComment="+enterComment+",Current Date="+sdf.format(currentDateValue));
			
            feedBackModel feedModel = new feedBackModel();
            
            feedModel.setFeed_back_id(0);
            feedModel.setUser_id(0);
            feedModel.setFull_name(full_name);
            feedModel.setMobile_no(mobile_no);
            feedModel.setE_mail_id(e_mail_id);
            feedModel.setWebsite_rating(webSiteRating);
            feedModel.setEnter_comment(enterComment);
            feedModel.setCreated_by(0);
            feedModel.setCreated_datetime(sdf.format(currentDateValue));
            
            feedModel.setFeed_back_category(feed_back_category);
			
			if((dsr_location==null)||(dsr_location.toString().length()<=0))
			feedModel.setDsr_location(0);
			else
			feedModel.setDsr_location(Integer.parseInt(this.dsr_location));
			
            feedModel.setE_registration_id(e_registration_id);
            feedModel.setComplain_detail(complain_detail);
            feedModel.setSub_complain_detail(sub_complain_detail);
            
            manager.insertFeedBackDetail(feedModel);
            addActionMessage("Thanks Your Complain.");
            
            returnMessage = "success";
		}catch(Exception e){
            log.fatal(helper.writeLogInUpperCase(e));
            System.out.println(helper.writeLogInUpperCase(e));
            returnMessage = "error";
		}
		
		return returnMessage;
	}
	
	public String getSubComplain() throws Exception {
		
		log.fatal("getSubComplain method complain_detail="+this.complain_detail);

		try {
			subComplainList = new ArrayList<CommonOptionsVO>();
			if ((this.complain_detail != null) && (this.complain_detail.length() > 0)) {
				subComplainList = manager.getSubComplainList(this.complain_detail);
			}
		} catch (Exception e) {
			log.fatal(helper.writeLogInUpperCase(e));
			throw new Exception(getText("global.system.error"));
		}
		return SUCCESS;
	}
    
}