/**
 * Class Name  : OptionsVO
 * Description : Can Store the Options in a Drop down List
 * Created by  : TCS/Sabyasachi Bhattacharya
 * Created on  : 7-SEP-04
 * Modified    : [Who , When , What]
 */
package com.igr.commonUtility;

import java.io.Serializable;


public class CommonFiveOptionsVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typeCode_1;
	private String typeCode_2;
    private String typeCode_3;
    private String typeCode_4;
    private String typeCode_5;
    
    
    
    public CommonFiveOptionsVO(String typeCode_1, String typeCode_2,String typeCode_3,String typeCode_4,String typeCode_5) {
    	setTypeCode_1(typeCode_1);
    	setTypeCode_2(typeCode_2);
    	setTypeCode_3(typeCode_3);
    	setTypeCode_4(typeCode_4);
    	setTypeCode_5(typeCode_5);
	}
    
	public String getTypeCode_1() {
		return typeCode_1;
	}
	public void setTypeCode_1(String typeCode_1) {
		this.typeCode_1 = typeCode_1;
	}
	public String getTypeCode_2() {
		return typeCode_2;
	}
	public void setTypeCode_2(String typeCode_2) {
		this.typeCode_2 = typeCode_2;
		
	}
	public String getTypeCode_3() {
		return typeCode_3;
	}
	public void setTypeCode_3(String typeCode_3) {
		this.typeCode_3 = typeCode_3;
	}
	public String getTypeCode_4() {
		return typeCode_4;
	}
	public void setTypeCode_4(String typeCode_4) {
		this.typeCode_4 = typeCode_4;
	}
	public String getTypeCode_5() {
		return typeCode_5;
	}
	public void setTypeCode_5(String typeCode_5) {
		this.typeCode_5 = typeCode_5;
	}
    



	
	


}
