package com.igr.commonUtility;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;  

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;  

import com.opensymphony.xwork2.Action;  
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionInvocation;  
import com.opensymphony.xwork2.interceptor.Interceptor;  

public class IGRFilter implements Interceptor{  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(IGRFilter.class);
	//private static final Logger log = Logger.getLogger(LogInterceptor.class);
//	private static final Logger log = Logger.getLogger(IGRFilter.class);
	private List<?> grpEventMap;
    public void destroy() {  
      
    }  
    public void init() {  
        
    }  

       
    @SuppressWarnings("deprecation")
	public String intercept(ActionInvocation invocation) throws Exception {  
        log.fatal("IGRFilter");
        ActionContext context = invocation.getInvocationContext();  
        HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);  
        String path = request.getRequestURI();  
       // log.fatal("Request URI in IGRFilter:"+path);
        log.fatal("Request URI in IGRFilter:"+path);
       
     
        
    	String userGroup =(String)request.getSession().getAttribute("_USERGROUP");
    	String empID = (String) request.getSession().getAttribute("_EMPCODE");
		String branchCode = (String) request.getSession().getAttribute("_LOCATIONID");
		
		 log.fatal("Request URI in IGRFilter:"+path+" userGroup "+userGroup);
  
    	Map<?, ?> application = invocation.getInvocationContext().getApplication();
    	grpEventMap=  (List<?>)application.get("USERLOV");  
    	
    	
    	
    	
        if((userGroup== null)||(empID==null)||(branchCode==null)){  
        	 request.setAttribute("error", "Session Invalid. Try to Login again");  
        	// log.fatal("IGR Filter Error1");
        	 log.fatal("IGR Filter Error...User not logged in");
        	 log.fatal("IGR Filter Error...User not logged in");
        	 return Action.ERROR;  
        }else{
        	log.fatal("IGR Filter Error...path="+path);
        	log.fatal("IGR Filter extractEventCodeFromUrl...path="+extractEventCodeFromUrl(path));
            StringBuffer groups=extractPermissibleGroups(grpEventMap,extractEventCodeFromUrl(path));
            
            log.fatal("IGR Filter Error...groups="+groups);            
            
            if(groups.indexOf(userGroup)<0){  
                    request.setAttribute("error", "You are not authorized to do this operation"); 
                    //log.fatal("IGR Filter Error2");
                    log.fatal("IGR Filter Error...user not authorized to do this operation");
                    log.fatal("IGR Filter Error...user not authorized to do this operation");
                    return Action.ERROR;  
            }  
            else
            {
                log.fatal("IGR Filter Error...user getting Session");
            	request.getSession().putValue("_USERGROUP", userGroup);
            	request.getSession().putValue("_EMPCODE", empID);
            	request.getSession().putValue("_LOCATIONID", branchCode);
            }
        }
        
        return invocation.invoke();  
    }
	private String extractEventCodeFromUrl(String url) {
		int beginIndex = url.indexOf('/',1);
		StringBuffer eventCode = new StringBuffer(url.substring(beginIndex+1,url.length()-7));
		eventCode.append(".action");
		return eventCode.toString();
	}
	
	private StringBuffer extractPermissibleGroups(List<?> grpEvent,String actualPath)
	{
		StringBuffer permissibleGroups=new StringBuffer();
		ListIterator<?> listItr = grpEvent.listIterator();
		while (listItr.hasNext()) {
		CommonOptionsVO optionVO = (CommonOptionsVO) listItr.next();
		if(optionVO.getTypeDesc().equals(actualPath))
			permissibleGroups.append(optionVO.getTypeCode());
		}
		return permissibleGroups;
	}
	
}  
