/**
 * Class Name  : OptionsVO
 * Description : Can Store the Options in a Drop down List
 * Created by  : TCS/Sabyasachi Bhattacharya
 * Created on  : 7-SEP-04
 * Modified    : [Who , When , What]
 */
package com.igr.optionVO;

import java.io.Serializable;


public class CommonNineOptionsVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typeCode1;
	private String typeCode2;
	private String typeCode3;
	private String typeCode4;
	private String typeCode5;
	private String typeCode6;
	private String typeCode7;
	private String typeCode8;
	private String typeCode9;

	public CommonNineOptionsVO(String typeCode1, String typeCode2,String typeCode3,
			String typeCode4, String typeCode5,String typeCode6,
			String typeCode7, String typeCode8,String typeCode9) {
		
		setTypeCode1(typeCode1);
		setTypeCode2(typeCode2);
		setTypeCode3(typeCode3);
		setTypeCode4(typeCode4);
		setTypeCode5(typeCode5);
		setTypeCode6(typeCode6);
		setTypeCode7(typeCode7);
		setTypeCode8(typeCode8);
		setTypeCode9(typeCode9);
	}

	
	
	
	public String getTypeCode1() {
		return typeCode1;
	}

	public void setTypeCode1(String typeCode1) {
		this.typeCode1 = typeCode1;
	}

	public String getTypeCode2() {
		return typeCode2;
	}

	public void setTypeCode2(String typeCode2) {
		this.typeCode2 = typeCode2;
	}

	public String getTypeCode3() {
		return typeCode3;
	}

	public void setTypeCode3(String typeCode3) {
		this.typeCode3 = typeCode3;
	}

	public String getTypeCode4() {
		return typeCode4;
	}

	public void setTypeCode4(String typeCode4) {
		this.typeCode4 = typeCode4;
	}

	public String getTypeCode5() {
		return typeCode5;
	}

	public void setTypeCode5(String typeCode5) {
		this.typeCode5 = typeCode5;
	}

	public String getTypeCode6() {
		return typeCode6;
	}

	public void setTypeCode6(String typeCode6) {
		this.typeCode6 = typeCode6;
	}

	public String getTypeCode7() {
		return typeCode7;
	}

	public void setTypeCode7(String typeCode7) {
		this.typeCode7 = typeCode7;
	}

	public String getTypeCode8() {
		return typeCode8;
	}

	public void setTypeCode8(String typeCode8) {
		this.typeCode8 = typeCode8;
	}

	public String getTypeCode9() {
		return typeCode9;
	}

	public void setTypeCode9(String typeCode9) {
		this.typeCode9 = typeCode9;
	}
}