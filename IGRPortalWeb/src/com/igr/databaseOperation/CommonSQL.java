package com.igr.databaseOperation;

public class CommonSQL {

	public static final StringBuffer GENERATE_ISSUE_FIRST_TOKEN_NO = new StringBuffer(
			 " select pipl_cgr_portal.create_portal_token(?,to_date(?,'YYYY-MM-DD')  ) as token_no  ");
	
	public static final StringBuffer GET_PROPERTY_VALUE_FROM_PROC = new StringBuffer(
			"select calc_document_value(?,to_date(?,'YYYY-MM-DD'),?) ");
	
	public static final StringBuffer GET_STRUCTURE_VALUE_FROM_PROC = new StringBuffer(
			"select calc_structure_document_value(?,to_date(?,'YYYY-MM-DD'),?) ");
	
	public static final StringBuffer GET_FEE_VALUE_FOR_LEASE_DEED = new StringBuffer(
			"select calc_lease_stamp(?,to_date(?,'YYYY-MM-DD'),?) ");
	
	public static final StringBuffer GET_REGISTRATION_FEE_FOR_LEASE_DEED = new StringBuffer(
			"select calc_lease_fee(?,to_date(?,'YYYY-MM-DD'),?) ");
	
	public static final StringBuffer GET_LR_VERIFICATION_DATA = new StringBuffer(
			"select lr_verification(?,to_date(?,'YYYY-MM-DD'),?) ");
	
	
	public static final StringBuffer GET_VALUATION_FROM_PROC = new StringBuffer(
			"select calc_upbandh(?,to_date(?,'YYYY-MM-DD'),?) ");
	
	public static final StringBuffer PARTY_NAME_CHECK_PROC = new StringBuffer(
			"select pipl_cgr_portal.check_party_name(?,?)");
}
