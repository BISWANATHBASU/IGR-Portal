<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>टोकन सूची</title>
<s:head theme="igr" />
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<body oncontextmenu="return false;">
	<s:form action="SearchForTransactionDetailsEdit" validate="true"
		namespace="/" method="post">

		<div align="center" class="formCaption">Search Details</div>
		<s:actionerror cssClass="errorMsg" />
		<s:actionmessage cssClass="infoMsg" />
		<div align="center"
			style="height: 100px; width: 100%; overflow-x: hidden">
			<s:if test="%{!propertyModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Property Detail :~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.Token_No')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.khata_no')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.plot_no')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.valuation')" /></TD>

					</tr>
					<s:iterator value="propertyModelList" id="propertyModelList">
						<tr>
							<td class="fieldrowwise" align="center"><s:url
									action="PropertyDetailEditAction.action" id="propertyDetail">
									<s:param name="token_date">
										<s:property value="token_date" />
									</s:param>
									<s:param name="token_no">
										<s:property value="token_no" />
									</s:param>
									<s:param name="dsr_location">
										<s:property value="dsr_location" />
									</s:param>

									<s:param name="district_id">
										<s:property value="district_id" />
									</s:param>

									<s:param name="propertyID">
										<s:property value="property_detail_id" />
									</s:param>



									<s:param name="areaIDValue">
										<s:property value="area_master_id" />
									</s:param>


									<s:param name="area_master_id">
										<s:property value="area_type" />
									</s:param>


									<s:param name="area_type_name">
										<s:property value="area_type_name" />
									</s:param>

									<s:param name="ward_hal_no">
										<s:property value="ward_hal_no" />
									</s:param>

									<s:param name="ward_vill_name">
										<s:property value="ward_vill_name" />
									</s:param>

									<s:param name="locality_name">
										<s:property value="locality_name" />
									</s:param>


									<s:param name="mohalla_vill_name">
										<s:property value="mohalla_vill_name" />
									</s:param>


									<s:param name="propert_type">
										<s:property value="propert_type" />
									</s:param>

									<s:param name="area_volume">
										<s:property value="area_volume" />
									</s:param>


									<s:param name="min_val">
										<s:property value="min_val" />
									</s:param>

									<s:param name="khata_no">
										<s:property value="khata_no" />
									</s:param>

									<s:param name="plot_no">
										<s:property value="plot_no" />
									</s:param>

									<s:param name="deed_type_id">
										<s:property value="deed_type_id" />
									</s:param>

									<s:param name="deed_category_id">
										<s:property value="deed_category_id" />
									</s:param>

									<s:param name="considered_amount">
										<s:property value="considered_amount" />
									</s:param>

									<s:param name="khasra_no">
										<s:property value="khasra_no" />
									</s:param>

									<s:param name="loan_book_no">
										<s:property value="loan_book_no" />
									</s:param>

									<s:param name="north_boundary">
										<s:property value="north_boundary" />
									</s:param>

									<s:param name="east_boundary">
										<s:property value="east_boundary" />
									</s:param>

									<s:param name="south_boundary">
										<s:property value="south_boundary" />
									</s:param>

									<s:param name="west_boundary">
										<s:property value="west_boundary" />
									</s:param>
									
									
									
									<s:param name="configuration_land">
										<s:property value="configuration_land" />
									</s:param>
									
									
									
									<s:param name="purpose_land">
										<s:property value="purpose_land" />
									</s:param>
									
									
										<s:param name="tahaseel">
										<s:property value="tahaseel" />
									</s:param>

									<s:param name="revenue_district">
										<s:property value="revenue_district" />
									</s:param>
									
										<s:param name="area_unit">
										<s:property value="area_unit" />
									</s:param>
									
									<s:param name="rent">
										<s:property value="rent" />
									</s:param>
									
									<s:param name="no_of_tubewell">
										<s:property value="no_of_tubewell" />
									</s:param>
									
									<s:param name="no_of_well">
										<s:property value="no_of_well" />
									</s:param>
									

								</s:url> <s:a href="%{propertyDetail}">
									<font color="BLUE"><s:property value="token_no" /></font>
								</s:a></td>
							<td class="longfieldrowwise" align="left"><s:property
									value="khata_no" /></td>

							<td class="longfieldrowwise" align="left"><s:property
									value="plot_no" /></td>

							<td class="fieldrowwise" align="left"><s:property
									value="min_val" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>







			<s:if test="%{!structureModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Structure Detail :~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.Token_No')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.structure_name')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.structure_no')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.valuation')" /></TD>

					</tr>
					<s:iterator value="structureModelList" id="structureModelList">
						<tr>
							<td class="fieldrowwise" align="center"><s:url
									action="StructureDetailEditAction.action" id="structureDetail">
									<s:param name="token_date">
										<s:property value="token_date" />
									</s:param>
									<s:param name="token_no">
										<s:property value="token_no" />
									</s:param>
									<s:param name="district_id">
										<s:property value="district_id" />
									</s:param>
									<s:param name="dsr_location">
										<s:property value="dsr_location" />
									</s:param>


									<s:param name="structureID">
										<s:property value="structure_valuation_id" />
									</s:param>


									<s:param name="area_type">
										<s:property value="area_type" />
									</s:param>



									<s:param name="use_construction">
										<s:property value="use_construction" />
									</s:param>



									<s:param name="type_construction">
										<s:property value="type_construction" />
									</s:param>


									<s:param name="structure_name">
										<s:property value="structure_name" />
									</s:param>


									<s:param name="structure_no">
										<s:property value="structure_no" />
									</s:param>
									
									
										<s:param name="ageOfStructure">
										<s:property value="ageOfStructure" />
									</s:param>
									
									
										<s:param name="structure">
										<s:property value="structure" />
									</s:param>
									
									
									

									<s:param name="floor">
										<s:property value="floor" />
									</s:param>

									<s:param name="area_volume">
										<s:property value="area_volume" />
									</s:param>


									<s:param name="valuation">
										<s:property value="valuation" />
									</s:param>

									<s:param name="deed_type_id">
										<s:property value="deed_type_id" />
									</s:param>

									<s:param name="deed_category_id">
										<s:property value="deed_category_id" />
									</s:param>

									<s:param name="considered_amount">
										<s:property value="considered_amount" />
									</s:param>
									
									
									<s:param name="structure_unit">
										<s:property value="structure_unit" />
									</s:param>
									
									
									<s:param name="structure_owner">
										<s:property value="structure_owner" />
									</s:param>



								</s:url> <s:a href="%{structureDetail}">
									<font color="BLUE"><s:property value="token_no" /></font>
								</s:a></td>
							<td class="longfieldrowwise" align="left"><s:property
									value="structure_no" /></td>

							<td class="longfieldrowwise" align="left"><s:property
									value="structure_name" /></td>

							<td class="fieldrowwise" align="left"><s:property
									value="valuation" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>








			<s:if test="%{!partyModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Party Detail :~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.Token_No')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.party_name')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.gurdianname')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.pan')" /></TD>

					</tr>
					<s:iterator value="partyModelList" id="partyModelList">
						<tr>
							<td class="fieldrowwise" align="center"><s:url
									action="PartyDetailEditAction.action" id="partyDetail">
									<s:param name="token_date">
										<s:property value="token_date" />
									</s:param>
									<s:param name="token_no">
										<s:property value="token_no" />
									</s:param>
									<s:param name="district_id">
										<s:property value="district_id" />
									</s:param>
									<s:param name="dsr_location">
										<s:property value="dsr_location" />
									</s:param>


									<s:param name="partyID">
										<s:property value="party_detail_id" />
									</s:param>


									<s:param name="party_type_id">
										<s:property value="party_type_id" />
									</s:param>

									<s:param name="party_name">
										<s:property value="party_name" />
									</s:param>

									<s:param name="party_fh_rel">
										<s:property value="party_fh_rel" />
									</s:param>


									<s:param name="party_fh_rel_name">
										<s:property value="party_fh_rel_name" />
									</s:param>


									<s:param name="profession">
										<s:property value="profession" />
									</s:param>

									<s:param name="gender">
										<s:property value="gender" />
									</s:param>


									<s:param name="caste">
										<s:property value="caste" />
									</s:param>

									<s:param name="pan_no">
										<s:property value="pan_no" />
									</s:param>


									<s:param name="address">
										<s:property value="address" />
									</s:param>


									<s:param name="ph_no">
										<s:property value="ph_no" />
									</s:param>

									<s:param name="deed_type_id">
										<s:property value="deed_type_id" />
									</s:param>



									<s:param name="addressProofArray">
										<s:property value="address_proof" />
									</s:param>


									<s:param name="deed_type_id">
										<s:property value="deed_type_id" />
									</s:param>

									<s:param name="deed_category_id">
										<s:property value="deed_category_id" />
									</s:param>

									<s:param name="considered_amount">
										<s:property value="considered_amount" />
									</s:param>

									<s:param name="party_name_hindi">
										<s:property value="party_name_hindi" />
									</s:param>
									
									
									
									<s:param name="sub_cast">
										<s:property value="sub_cast" />
									</s:param>
									
									
										<s:param name="biometric_required">
										<s:property value="biometric_required" />
									</s:param>
								


								</s:url> <s:a href="%{partyDetail}">
									<font color="BLUE"><s:property value="token_no" /></font>
								</s:a></td>
							<td class="longfieldrowwise" align="left"><s:property
									value="party_name" /></td>

							<td class="longfieldrowwise" align="left"><s:property
									value="party_fh_rel_name" /></td>

							<td class="fieldrowwise" align="left"><s:property
									value="pan_no" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>






			<s:if test="%{!deedDetailModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Deed Detail :~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.Token_No')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.name')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.first_party_name')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.considered_amount')" /></TD>

					</tr>
					<s:iterator value="deedDetailModelList" id="deedDetailModelList">
						<tr>
							<td class="fieldrowwise" align="center"><s:url
									action="DeedDetailEditAction.action" id="deedDetail">
									<s:param name="token_date">
										<s:property value="deedDetailPK.token_date" />
									</s:param>
									<s:param name="token_no">
										<s:property value="deedDetailPK.token_no" />
									</s:param>
									<s:param name="district_id">
										<s:property value="district_id" />
									</s:param>
									<s:param name="dsr_location">
										<s:property value="deedDetailPK.dsr_location" />
									</s:param>

									<s:param name="presenter_name">
										<s:property value="presenter_name" />
									</s:param>


									<s:param name="first_party_executant_name">
										<s:property value="firstparty_executant_name" />
									</s:param>


									<s:param name="first_party_executant_capacity">
										<s:property value="firstparty_executant_capacity" />
									</s:param>


									<s:param name="considered_amount">
										<s:property value="considered_amount" />
									</s:param>

									<s:param name="deed_category_id">
										<s:property value="deed_category_id" />
									</s:param>


									<s:param name="deed_type_id">
										<s:property value="deed_type_id" />
									</s:param>

									<s:param name="doc_min_amount">
										<s:property value="doc_min_amount" />
									</s:param>

									<s:param name="applicable_stamp_value">
										<s:property value="applicable_stamp_value" />
									</s:param>


									<s:param name="presented_stamp_value">
										<s:property value="presented_stamp_value" />
									</s:param>


									<s:param name="no_total_pages">
										<s:property value="no_total_pages" />
									</s:param>

									<s:param name="special_deed_detail">
										<s:property value="special_deed_detail" />
									</s:param>


									<s:param name="e_registration_code">
										<s:property value="e_registration_code" />
									</s:param>

									<s:param name="rel_last_reg_record">
										<s:property value="rel_last_reg_record" />
									</s:param>

									<s:param name="rel_last_reg_date">
										<s:property value="rel_last_reg_date" />
									</s:param>

									<s:param name="rel_last_reg_no">
										<s:property value="rel_last_reg_no" />
									</s:param>

									<s:param name="rel_last_reg_pow_of_atr">
										<s:property value="rel_last_reg_pow_of_atr" />
									</s:param>

									<s:param name="rel_last_reg_pow_of_atr_date">
										<s:property value="rel_last_reg_pow_of_atr_date" />
									</s:param>


									<s:param name="rel_last_reg_pow_of_atr_reg_no">
										<s:property value="rel_last_reg_pow_of_atr_reg_no" />
									</s:param>


									<s:param name="rel_last_reg_pow_of_atr_reg_no">
										<s:property value="rel_last_reg_pow_of_atr_reg_no" />
									</s:param>
									
									<s:param name="rel_last_reg_pow_of_atr_reg_no">
										<s:property value="rel_last_reg_pow_of_atr_reg_no" />
									</s:param>


									<s:param name="permission_no">
										<s:property value="permission_no" />
									</s:param>


								</s:url> <s:a href="%{deedDetail}">
									<font color="BLUE"><s:property value="deedDetailPK.token_no" /></font>
								</s:a></td>
							<td class="longfieldrowwise" align="left"><s:property
									value="presenter_name" /></td>

							<td class="longfieldrowwise" align="left"><s:property
									value="firstparty_executant_name" /></td>

							<td class="longfieldrowwise" align="left"><s:property
									value="considered_amount" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>

			<s:hidden name="event" id="event" />
			<s:hidden name="deed_type_id" id="deed_type_id" />
			<s:hidden name="deed_category_id" id="deed_category_id" />
			<s:hidden name="considered_amount" id="considered_amount" />



			<br> <br>
			<div align="center">
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitEditDetails';">
			</div>
		</div>
		<s:hidden name="event" />
	</s:form>
</body>

</html>
<%@include file="../commonJsp/footer.inc"%>
