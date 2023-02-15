package com.igr.commonUtility;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		name="hello";
		return SUCCESS;
	}
	
}
