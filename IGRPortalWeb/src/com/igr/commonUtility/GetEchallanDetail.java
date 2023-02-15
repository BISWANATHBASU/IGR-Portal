package com.igr.commonUtility;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class GetEchallanDetail {
	private static Logger log = Logger.getLogger(GetEchallanDetail.class);
	
	public List<CommonThriceOptionsVO> getAllDataForIssueSecondToken(
			HttpServletRequest request, String rowNumber) {

		
		List<CommonThriceOptionsVO> allstamp = new ArrayList<CommonThriceOptionsVO>();
		try {
			if((rowNumber!=null)&&(rowNumber.trim().length()>0)){
				String getChallanNo[] = request.getParameterValues("chalan_no");
				String getChallanValue[] = request.getParameterValues("chalan_value");
				String getChallanDate[] = request.getParameterValues("echallan_date");

				for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
					CommonThriceOptionsVO optionVo = new CommonThriceOptionsVO(getChallanNo[row],getChallanValue[row],getChallanDate[row]);
					allstamp.add(optionVo);
				}
			}
		} catch (Exception e) {
			 log.fatal("ERROR ",e);
		}

		return allstamp;
	}
}
