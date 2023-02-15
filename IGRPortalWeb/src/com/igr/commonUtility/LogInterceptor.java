package com.igr.commonUtility;

import java.util.Map;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LogInterceptor  implements Interceptor {


	private static final long serialVersionUID = 1L;
	/*private static final Logger log = Logger.getLogger(LogInterceptor.class);*/
	private final Logger log = Logger.getLogger(LogInterceptor.class);
	private static CommonHelper helper = new CommonHelper();

		@Override
        public String intercept(ActionInvocation invocation) throws Exception {
                
			Map<String, Object> sessionAttributes = invocation.getInvocationContext().getSession();
		
			
		       String empID = (String) sessionAttributes.get("_EMPCODE");
               String branchCode =(String) sessionAttributes.get("_LOCATIONID");
               String groupID =(String) sessionAttributes.get("_USERGROUP");
               String language =(String) sessionAttributes.get("_LANGUAGE");
           
                
               // log.fatal(empID+" "+branchCode+" "+);
              /*if(branchCode==null) {
            	  branchCode=" ";
              }*/
             
               
                if ((empID == null)||(branchCode == null)||(groupID == null)||(language == null))
                {
                    log.fatal("Login Interceptor: Session timeout");    
                    log.fatal("Session timeout");
                	return Action.LOGIN;
                } 
                else 
                {
                    log.fatal("Login Interceptor: invocation.invoke()");   
                	    return invocation.invoke();
                }
        }

		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void init() {
			// TODO Auto-generated method stub
			
		}
}