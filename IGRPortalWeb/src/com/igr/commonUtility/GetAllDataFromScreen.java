package com.igr.commonUtility;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class GetAllDataFromScreen {

	private static Logger log = Logger.getLogger(GetAllDataFromScreen.class);
	
	public List<CommonThriceOptionsVO> getAllDataForIssueSecondToken(
			HttpServletRequest request, String rowNumber) {

		log.fatal("e-Stamp Row===="+rowNumber);
		List<CommonThriceOptionsVO> allstamp = new ArrayList<CommonThriceOptionsVO>();
		try {
			if((rowNumber!=null)&&(rowNumber.trim().length()>0)){
				
				log.fatal("request.getParameterValues(stamp_no)==="+request.getParameterValues("stamp_no"));
				String getStampNo[] = request.getParameterValues("stamp_no");
				String getStampValue[] = request.getParameterValues("stamp_value");
				String getStampDate[] = request.getParameterValues("stamp_date");
		
				for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
	
					log.fatal("e-Stamp No===="+getStampNo[row]);
					log.fatal("e-Stamp Amount===="+getStampValue[row]);
					log.fatal("e-Stamp Date===="+getStampDate[row]);
					
					CommonThriceOptionsVO optionVo = new CommonThriceOptionsVO(getStampNo[row],
							getStampValue[row],getStampDate[row]);
					allstamp.add(optionVo);
				}
			}
		} catch (Exception e) {
			 log.fatal("ERROR ",e);
		}

		return allstamp;
	}

	public List<String> getAllDataForDeedType(HttpServletRequest request,String rowNumber) {

		List<String> allPartyName = new ArrayList<String>();
		try {
			String getPartyTypeValue[] = request.getParameterValues("partyTypeValue");
			String getPartyType[] = request.getParameterValues("party_type");

			for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
				String partyName = getPartyTypeValue[row]+"-"+getPartyType[row];
				allPartyName.add(partyName);
			}
		} catch (Exception e) {
			 log.fatal("ERROR ",e);
		}

		return allPartyName;
	}
	
	
	
	public List<String> getAllDataForFeeMasterEntry(HttpServletRequest request,String rowNumber) {

		List<String> allPartyName = new ArrayList<String>();
		try {
			String fee_start_slab[] = request.getParameterValues("fee_start_slab");
			String fee_end_slab[] = request.getParameterValues("fee_end_slab");
			String fee_rate[] = request.getParameterValues("fee_rate");
			String fee_end_flag[] = request.getParameterValues("fee_end_flag");
			String fee_calc_type[] = request.getParameterValues("fee_calc_type");

			for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
				String partyName = fee_start_slab[row]+"-"+fee_end_slab[row]+"-"+fee_rate[row]+"-"+fee_end_flag[row]+"-"+fee_calc_type[row];
				allPartyName.add(partyName);
			}
		} catch (Exception e) {
			 log.fatal("ERROR ",e);
		}

		return allPartyName;
	}
	
	public List<String> getAllDataForFeeMasterEdit(HttpServletRequest request,String rowNumber) {

		List<String> allPartyName = new ArrayList<String>();
		try {
			String fee_start_slab[] = request.getParameterValues("fee_start_slab");
			String fee_end_slab[] = request.getParameterValues("fee_end_slab");
			String fee_rate[] = request.getParameterValues("fee_rate");
			String fee_end_flag[] = request.getParameterValues("fee_end_flag");
			String fee_id[] = request.getParameterValues("fee_id");
			String fee_calc_type[] = request.getParameterValues("fee_calc_type");

			for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
				String partyName = fee_start_slab[row]+"-"+fee_end_slab[row]+"-"+fee_rate[row]+"-"+fee_end_flag[row]+"-"+fee_id[row]+"-"+fee_calc_type[row];
				allPartyName.add(partyName);
			}
		} catch (Exception e) {
			 log.fatal("ERROR ",e);
		}

		return allPartyName;
	}
	
	public List<CommonThriceOptionsVO> getAllDataForDeedTypeEdit(HttpServletRequest request, String rowNumber) {
		List<CommonThriceOptionsVO> allPartyName = new ArrayList<CommonThriceOptionsVO>();

		String getPartyTypeName[] = request.getParameterValues("partyTypeValue");
		String getPartyTypeValue[] = request.getParameterValues("partyTypeID");
		String getPartyType[] = request.getParameterValues("party_type");

		if ((getPartyTypeValue != null) && (getPartyTypeValue.length > 0)
				&& (getPartyTypeName != null) && (getPartyTypeName.length > 0)
				&& (getPartyType != null) && (getPartyType.length > 0)) {
			for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
				CommonThriceOptionsVO optionVO = new CommonThriceOptionsVO(
						getPartyTypeValue[row], getPartyTypeName[row], getPartyType[row]);
				allPartyName.add(optionVO);
			}
		}
		return allPartyName;
	}

	public List<String> getDataForDeedEdit(HttpServletRequest request,String rowNumber) {
		List<String> allPartyName = new ArrayList<String>();
		String getPartyTypeValue[] = request.getParameterValues("partyTypeValue");

		if ((getPartyTypeValue != null) && (getPartyTypeValue.length > 0)) {
			for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
				String partyName = getPartyTypeValue[row];
				allPartyName.add(partyName);
			}
		}
		return allPartyName;
	}

	public List<CommonFiveOptionsVO> getAllDataForAppointment(HttpServletRequest request, String rowNumber) {

		log.fatal("e-Stamp Row===="+rowNumber);
		List<CommonFiveOptionsVO> allParty = new ArrayList<CommonFiveOptionsVO>();
		try {
			if((rowNumber!=null)&&(rowNumber.trim().length()>0)){
				
				log.fatal("request.getParameterValues(partyName)==="+request.getParameterValues("partyName"));
				String getPartyName[] = request.getParameterValues("partyName");
				String getPartyMobileNo[] = request.getParameterValues("partyMobileNo");
				String getPartyType[] = request.getParameterValues("partyType");
	
				String getPartyFather[] = request.getParameterValues("partyFather");
				String getPartyAddress[] = request.getParameterValues("partyAddress");
				
		
				for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
	
					log.fatal("Party Name===="+getPartyName[row]);
					log.fatal("Party Mobile No.===="+getPartyMobileNo[row]);
					log.fatal("Party Type===="+getPartyType[row]);
	
					log.fatal("Party Father===="+getPartyFather[row]);
					log.fatal("Party Address===="+getPartyAddress[row]);
					
					CommonFiveOptionsVO optionVo = new CommonFiveOptionsVO(getPartyName[row],getPartyMobileNo[row],getPartyType[row],getPartyFather[row],getPartyAddress[row]);
					
					allParty.add(optionVo);
				}
			}
		} catch (Exception e) {
			 log.fatal("ERROR ",e);
		}

		return allParty;
	}
	
	
	
	public List<CommonFiveOptionsVO> getAllDataForAppointment1(HttpServletRequest request, String rowNumber) {

		log.fatal("e-Stamp Row11===="+rowNumber);
		List<CommonFiveOptionsVO> allParty = new ArrayList<CommonFiveOptionsVO>();
		try {
			if((rowNumber!=null)&&(rowNumber.trim().length()>0)){
				
				log.fatal("request.getParameterValues(partyName1)==="+request.getParameterValues("partyName1"));
				String getPartyName[] = request.getParameterValues("partyName1");
				String getPartyMobileNo[] = request.getParameterValues("partyMobileNo1");
				String getPartyType[] = request.getParameterValues("partyType1");
	
				String getPartyFather[] = request.getParameterValues("partyFather1");
				String getPartyAddress[] = request.getParameterValues("partyAddress1");
				
		
				for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
	
					log.fatal("Party Name===="+getPartyName[row]);
					log.fatal("Party Mobile No.===="+getPartyMobileNo[row]);
					log.fatal("Party Type===="+getPartyType[row]);
	
					log.fatal("Party Father===="+getPartyFather[row]);
					log.fatal("Party Address===="+getPartyAddress[row]);
					
					CommonFiveOptionsVO optionVo = new CommonFiveOptionsVO(getPartyName[row],getPartyMobileNo[row],getPartyType[row],getPartyFather[row],getPartyAddress[row]);
					
					allParty.add(optionVo);
				}
			}
		} catch (Exception e) {
			 log.fatal("ERROR ",e);
		}

		return allParty;
	}

	public List<CommonFiveOptionsVO> getStampList(HttpServletRequest request, String rowNumber) {

		log.fatal("getStampList e-Stamp Row===="+rowNumber);
		List<CommonFiveOptionsVO> allParty = new ArrayList<CommonFiveOptionsVO>();
		try {
			if((rowNumber!=null)&&(rowNumber.trim().length()>0)){
				
				log.fatal("request.getParameterValues(estampNo)==="+request.getParameterValues("estampNo"));
				String getEStampNo[] = request.getParameterValues("estampNo");
				String getEStampDate[] = request.getParameterValues("estampDate");
				String getEStampAmount[] = request.getParameterValues("estampAmount");
				
				for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
	
					log.fatal("e-Stamp No===="+getEStampNo[row]);
					log.fatal("e-Stamp Date===="+getEStampDate[row]);
					log.fatal("e-Stamp Amount===="+getEStampAmount[row]);
					
					CommonFiveOptionsVO optionVo = new CommonFiveOptionsVO(getEStampNo[row],getEStampDate[row],getEStampAmount[row],null,null);
					
					allParty.add(optionVo);
				}
			}
		} catch (Exception e) {
			 log.fatal("ERROR ",e);
		}

		return allParty;
	}
	
	
	
	public List<CommonFiveOptionsVO> getStampList1(HttpServletRequest request, String rowNumber) {

		log.fatal("getStampList e-Stamp Row===="+rowNumber);
		List<CommonFiveOptionsVO> allParty = new ArrayList<CommonFiveOptionsVO>();
		try {
			if((rowNumber!=null)&&(rowNumber.trim().length()>0)){
				
				log.fatal("request.getParameterValues(estampNo)==="+request.getParameterValues("estampNo"));
				String getEStampNo[] = request.getParameterValues("estampNo1");
				String getEStampDate[] = request.getParameterValues("estampDate1");
				String getEStampAmount[] = request.getParameterValues("estampAmount1");
				
				for (int row = 0; row < Integer.parseInt(rowNumber); row++) {
	
					log.fatal("e-Stamp No===="+getEStampNo[row]);
					log.fatal("e-Stamp Date===="+getEStampDate[row]);
					log.fatal("e-Stamp Amount===="+getEStampAmount[row]);
					
					CommonFiveOptionsVO optionVo = new CommonFiveOptionsVO(getEStampNo[row],getEStampDate[row],getEStampAmount[row],null,null);
					
					allParty.add(optionVo);
				}
			}
		} catch (Exception e) {
			 log.fatal("ERROR ",e);
		}

		return allParty;
	}
}