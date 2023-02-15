package com.igr.commonUtility;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class CoronaContentAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(CoronaContentAction.class);
    

	public String execute() throws Exception {
        log.fatal("Office Appointment execute....");
        
        try{
            
        }catch(Exception e){
            log.fatal("addFirstToken() Exception "+e);
        }
        return "success";
    }
}
