package com.igr.commonUtility;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;

public class Test extends ActionSupport{
	
	@Override
	public String execute(){
		
	    HttpServletResponse response = ServletActionContext.getResponse();
	    System.out.println(response.getHeader("server"));
	    System.out.println(response.getHeaderNames());
	    for(String s:response.getHeaderNames()){
	    	System.out.println(s);
	    }
		return SUCCESS;
	}
}
