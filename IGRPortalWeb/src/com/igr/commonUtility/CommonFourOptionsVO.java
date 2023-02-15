/**
 * Class Name  : OptionsVO
 * Description : Can Store the Options in a Drop down List
 * Created by  : TCS/Sabyasachi Bhattacharya
 * Created on  : 7-SEP-04
 * Modified    : [Who , When , What]
 */
package com.igr.commonUtility;

import java.io.Serializable;

public class CommonFourOptionsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typeCode_1;
	private String typeDesc_1;
	private String typeCode_2;
	private String typeDesc_2;

	public CommonFourOptionsVO(String code_1, String desc_1, String code_2,
			String desc_2) {
		setTypeCode_1(code_1);
		setTypeDesc_1(desc_1);
		setTypeCode_2(code_2);
		setTypeDesc_2(desc_2);

	}

	public String getTypeCode_1() {
		return typeCode_1;
	}

	public void setTypeCode_1(String typeCode_1) {
		this.typeCode_1 = typeCode_1;
	}

	public String getTypeDesc_1() {
		return typeDesc_1;
	}

	public void setTypeDesc_1(String typeDesc_1) {
		this.typeDesc_1 = typeDesc_1;
	}

	public String getTypeCode_2() {
		return typeCode_2;
	}

	public void setTypeCode_2(String typeCode_2) {
		this.typeCode_2 = typeCode_2;
	}

	public String getTypeDesc_2() {
		return typeDesc_2;
	}

	public void setTypeDesc_2(String typeDesc_2) {
		this.typeDesc_2 = typeDesc_2;
	}
}