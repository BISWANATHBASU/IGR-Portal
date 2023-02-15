package com.igr.commonUtility;

import com.igr.databaseOperation.InsertOperation;
import com.igr.hibernate.model.feedBackModel;
import com.igr.hibernate.util.HibernateManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

public class FeedBackFormAction extends ActionSupport
    implements ServletContextAware, ServletRequestAware, SessionAware
{

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(FeedBackFormAction.class);
    private ServletContext context;
    private HttpServletRequest request;
    private Map session;
    private static CommonHelper helper = new CommonHelper();
    private static CommonValidation validator = new CommonValidation();
    HibernateManager manager;
    private static InsertOperation insertOperation = new InsertOperation();
    SimpleDateFormat sdf;
    
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
    private String getIndexData;
    
    private List subComplainList;
    
    private String fromDate;
    private String toDate;

    public FeedBackFormAction()
    {
        manager = new HibernateManager();
        sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss a");
    }

    public List getDsrLocationList()
    {
        return dsrLocationList;
    }

    public void setDsrLocationList(List dsrLocationList)
    {
        this.dsrLocationList = dsrLocationList;
    }

    public String getFull_name()
    {
        return full_name;
    }

    public void setFull_name(String full_name)
    {
        this.full_name = full_name;
    }

    public String getMobile_no()
    {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no)
    {
        this.mobile_no = mobile_no;
    }

    public String getE_mail_id()
    {
        return e_mail_id;
    }

    public void setE_mail_id(String e_mail_id)
    {
        this.e_mail_id = e_mail_id;
    }

    public Map getSession()
    {
        return session;
    }

    public void setSession(Map map)
    {
        session = map;
    }

    public String getEmpID()
    {
        return empID;
    }

    public void setEmpID(String empID)
    {
        this.empID = empID;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public void setServletRequest(HttpServletRequest arg0)
    {
        request = arg0;
    }

    public void setServletContext(ServletContext arg0)
    {
        context = arg0;
    }

    public String getWebSiteRating()
    {
        return webSiteRating;
    }

    public void setWebSiteRating(String webSiteRating)
    {
        this.webSiteRating = webSiteRating;
    }

    public String getEnterComment()
    {
        return enterComment;
    }

    public void setEnterComment(String enterComment)
    {
        this.enterComment = enterComment;
    }

    public String getCreated_by()
    {
        return created_by;
    }

    public void setCreated_by(String created_by)
    {
        this.created_by = created_by;
    }

    public String getCreated_datetime()
    {
        return created_datetime;
    }

    public void setCreated_datetime(String created_datetime)
    {
        this.created_datetime = created_datetime;
    }

    public String getGetData()
    {
        return getData;
    }

    public void setGetData(String getData)
    {
        this.getData = getData;
    }

    public String getFeed_back_category()
    {
        return feed_back_category;
    }

    public void setFeed_back_category(String feed_back_category)
    {
        this.feed_back_category = feed_back_category;
    }

    public String getDsr_location()
    {
        return dsr_location;
    }

    public void setDsr_location(String dsr_location)
    {
        this.dsr_location = dsr_location;
    }

    public String getE_registration_id()
    {
        return e_registration_id;
    }

    public void setE_registration_id(String e_registration_id)
    {
        this.e_registration_id = e_registration_id;
    }

    public String getComplain_detail()
    {
        return complain_detail;
    }

    public void setComplain_detail(String complain_detail)
    {
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

	public String getGetIndexData() {
		return getIndexData;
	}

	public void setGetIndexData(String getIndexData) {
		this.getIndexData = getIndexData;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String home()
    {
        return "success";
    }

    public String execute() throws Exception{
		log.fatal("I am in Feedback Form Action Execute Method");
		System.out.println("I am in Feedback Form Action Execute Method");
		
        dsrLocationList = new ArrayList();
        dsrLocationList = manager.searchDSRLocationAll(2);
        
        complainDetailList = new ArrayList();
        complainDetailList = manager.getComplainDetailList();
        
        subComplainList = new ArrayList();
        
        int returnMessage = 1;
        String returnValue = "success";
        return returnValue;
    }

    public String addFeedBackForm()
        throws Exception
    {
        SessionMap session = (SessionMap)ActionContext.getContext().getSession();
        log.fatal("addFeedBackForm()");
        System.out.println("addFeedBackForm()");
        Date currentDateValue = new Date();
        String returnMessage = "";
        String insertOperationMessage = "0-System error Occured ";
        boolean operationFlag = false;
        String stampNoValue = "";
        int eStampCount = 0;
        try
        {
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
            addActionMessage("Thanks Your Feed Back.");
        }
        catch(Exception e)
        {
            log.fatal(helper.writeLogInUpperCase(e));
            System.out.println(helper.writeLogInUpperCase(e));
            throw new Exception(getText("global.system.error"));
        }
        if(operationFlag){
            return "success";
        } else{
            addActionError(returnMessage);
            return "success";
        }
    }

    public String getRegistryReport()
        throws Exception
    {
        System.out.println("getRegistryReport=========");
        try
        {
            log.fatal("getRegistryReport");
            System.out.println("getRegistryReport");
            getData = manager.getRegistryReportNew();
        }
        catch(Exception e)
        {
            log.fatal(helper.writeLogInUpperCase(e));
            System.out.println(helper.writeLogInUpperCase(e));
            throw new Exception(getText("global.system.error"));
        }
        log.fatal("getRegistryReport=getData="+getData);
        return "success";
    }
    
    public String getIndexReport() throws Exception{
    	System.out.println("getIndexReport=========");
        try{
            log.fatal("getIndexReport");
            System.out.println("getIndexReport");
            String lastWorkingDate = manager.getLastWorkingDate();
            log.fatal("fromDate="+fromDate+",toDate="+toDate+",lastWorkingDate="+lastWorkingDate);
            
            if((this.fromDate != null) && (this.fromDate.length() > 0)
					&& (this.toDate != null) && (this.toDate.length() > 0)){
            	getIndexData = manager.getIndexReportNew(fromDate,toDate);
            }else{
            	getIndexData = manager.getIndexReportNew(lastWorkingDate,lastWorkingDate);
            }
            
        }
        catch(Exception e){
            log.fatal(helper.writeLogInUpperCase(e));
            System.out.println(helper.writeLogInUpperCase(e));
            throw new Exception(getText("global.system.error"));
        }
        log.fatal("getIndexReport=getIndexData="+getIndexData);
        return "success";
    }

}
