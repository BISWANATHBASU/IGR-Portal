<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>संपति विवरणी</title>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
	<br />
	<div id="workProgress">
		<ul>
			<li class="doneWind"><a href="#">प्रस्तुति विवरणी&#10004;</a></li>
			<li class="doneWind"><a href="#">स्टाम्प विवरणी&#10004;</a></li>
			
			<li class="workingWind"><a href="#">सम्पत्ति का विवरण &#9998;</a></li>
			
			<li class="waitingWind"><a href="#">संरचना का विवरण &#10006;</a></li>
			<li class="waitingWind"><a href="#">पक्षकार का प्रकार &#10006;</a></li>
			<li class="waitingWind"><a href="#">विलेख का विवरण &#10006;</a></li>
			<li class="waitingWind"><a href="#">अपॉइंटमेंट/ शुल्क &#10006;</a></li>
			<li class="waitingWind"><a href="#">पुनः अपॉइंटमेंट &#10006;</a></li>
		</ul>
	</div>
	<s:form action="addPropertyDetail" validate="true"
		namespace="/" method="post">
		<s:token />

		<div align="center" class="formCaption">
		<s:if test="printFlag!=true">
			<s:property value="getText('global.property_detail_head')" />
		</s:if>
		<s:if test="printFlag==true">
			<s:property value="getText('global.property_detail_head_success')" />
		</s:if>
		</div>
		<div align="center">
			<s:if test="%{!savedPropertyList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Property Detail:~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.MOHALLA_VILL_NAME')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.property_type')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.khasra_no')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.total_area_volumn')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.total_area_unit')" /></TD>						
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.area_volumn')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.area_unit')" /></TD>		
					</tr>
					<s:iterator value="savedPropertyList" var="savedPropertyList">
						<tr>
							<td class="fieldrowwise" align="center"><s:property
									value="typeCode2" /></td>
							<td class="fieldrowwise" align="center"><s:property
									value="typeCode3" /></td>
									
							<td class="fieldrowwise" align="center"><s:property
									value="typeCode5" /></td>		
							
							<td class="fieldrowwise" align="right"><s:property
									value="typeCode6" /></td>
							
							<td class="fieldrowwise" align="center"><s:property
									value="typeCode8" /></td>				
						
							<td class="fieldrowwise" align="right"><s:property
									value="typeCode4" /></td>
							<td class="fieldrowwise" align="right"><s:property
									value="typeCode7" /></td>		
						</tr>
					</s:iterator>
				</table>
			</s:if>


			<s:if test="printFlag!=true">
			<table class="appFormBlock" id="propertyDetailTable" align="center"
				cellspacing="2px" cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Token_No')" />*:</td>
					<td class="field"><s:textfield name="token_no"
							cssClass="readOnlyField" readonly="true"
							theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="token_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><s:property
							value="getText('global.AREA_TYPE')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="areaTypeList" listKey="typeCodeDesc" id="area_master_id"
							listValue="typeDesc" name="area_master_id"
							onchange="globalAjax(this.value,'AREA_TYPE');"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="area_master_id" theme="igr" cssClass="smallErrorMsg" /></td>

				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.AREA_TYPE_NAME')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="areaTypeNameList" listKey="typeCode"
							onchange="globalAjax(this.value,'WARD_VILL_NAME');"
							listValue="typeDesc" name="area_type_name" id="area_type_name"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="area_type_name" theme="igr" cssClass="smallErrorMsg" /></td>


					<td class="tdLabel"><s:property
							value="getText('global.WARD_VILL_NAME')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="wardVillNameList" listKey="typeCode" listValue="typeDesc"
							name="ward_vill_name"
							onchange="globalAjax(this.value,'MOHALLA_VILL_NAME');"
							id="ward_vill_name" cssClass="largecombobox" theme="simple"
							required="true" /> <s:fielderror fieldName="ward_vill_name"
							theme="igr" cssClass="smallErrorMsg" /></td>

				</tr>



				<tr>

					<td class="tdLabel"><s:property
							value="getText('global.MOHALLA_VILL_NAME')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="mohallaVillList" listKey="typeCode" id="mohalla_vill_name"
							listValue="typeDesc" name="mohalla_vill_name"
							cssClass="largecombobox"
							onchange="globalAjax(this.value,'PROPERTY_TYPE');" theme="simple"
							required="true" /> <s:fielderror fieldName="mohalla_vill_name"
							theme="igr" cssClass="smallErrorMsg" /></td>


					<td class="tdLabel"><s:property
							value="getText('global.property_type')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="propertyTypeList" id="propert_type" listKey="typeCode"
							listValue="typeDesc" name="propert_type" onchange="globalAjax(this.value,'FOUR_VALUE');"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="propert_type" theme="igr" cssClass="smallErrorMsg" /></td>



				</tr>


				<tr>

					<td class="tdLabel"><s:property
							value="getText('global.tahaseel')" />:</td>
					<td class="field"><s:textfield name="tahaseel" id="tahaseel"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" placeholder="तहसील">
							<s:fielderror fieldName="tahaseel" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>



					<td class="tdLabel"><s:property
							value="getText('global.revenue_district')" />:</td>
					<td class="field"><s:textfield name="revenue_district" id="revenue_district"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" placeholder="रा.नि.मंडल">
							<s:fielderror fieldName="revenue_district" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>



				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.WRD_HAL_NO')" />:</td>
					<td class="field"><s:textfield name="ward_hal_no" id="ward_hal_no"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" placeholder="वार्ड / हल्का न.">
							<s:fielderror fieldName="ward_hal_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


					<td class="tdLabel"><s:property
							value="getText('global.LOCALITY_NAME')" />:</td>
					<td class="field"><s:textfield name="locality_name" id="locality_name"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" placeholder="मोहल्ला  / कॉलोनी / सोसाइटी">
							<s:fielderror fieldName="locality_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>
				
				<tr>
				
					<td class="tdLabel"><s:property
							value="getText('global.khasra_type')" />:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="khasraTypeList" listKey="typeCode"
							listValue="typeDesc" name="khasra_type" id="khasra_type" 
							cssClass="combobox" theme="simple" required="true" onChange="nojulFunction(this.value)"/> <s:fielderror
							fieldName="khasra_type" theme="igr"
							cssClass="smallErrorMsg" /></td>
				
				  
				   <td class="tdLabel" id="blockno1"><s:property
							value="getText('global.block_no')" />:</td>
							
					<td class="field" id="blockno2"><s:textfield name="block_no"
							cssClass="field" readonly="false" theme="simple"
							maxlength="20" placeholder="ब्लाक न.">
							<s:fielderror fieldName="block_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				   
				
				
				
				</tr>

				
				<tr>

					<td class="tdLabel"><s:property
							value="getText('global.configuration_land')" />:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="configurationLandList" listKey="typeCode"
							listValue="typeDesc" name="configuration_land" id="configurationLandList" 
							cssClass="combobox" theme="simple" onChange="changeLabel(this.value)"/> <s:fielderror
							fieldName="configuration_land" theme="igr"
							cssClass="smallErrorMsg" /></td>


					<td class="tdLabel"><s:property
							value="getText('global.purpose_land')" />:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="purposeLandList" listKey="typeCode" listValue="typeDesc"
							name="purpose_land" cssClass="combobox" theme="simple" 
							 /> <s:fielderror fieldName="purpose_land"
							theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>
				
				
				
				<tr>
					<td class="tdLabel"><s:property 
							value="getText('global.khata_no')" />:</td>
					<td class="field"><s:textfield name="khata_no"
							cssClass="field" theme="simple" maxlength="20" placeholder="खाता न.">
							<s:fielderror fieldName="khata_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>



					<td class="tdLabel"  id="khasra1"><s:property 
							value="getText('global.khasra_no')" />*:</td>
							
				    <td class="tdLabel"  id="khasra2"><s:property 
							value="getText('global.sheet_no')" />*:</td>			
							
							
					<td class="field"><s:textfield name="khasra_no" id="khasra_no"
							cssClass="field" theme="simple" maxlength="50" required="true" placeholder="खसरा न.">
							<s:fielderror fieldName="khasra_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
				</tr>



				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.loan_book_no')" />:</td>
					<td class="field"><s:textfield name="loan_book_no"
							cssClass="field" theme="simple" maxlength="50" placeholder="ऋण पुस्तिका">
							<s:fielderror fieldName="loan_book_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>






					<td class="tdLabel"><s:property
							value="getText('global.plot_no')" />:</td>
					<td class="field"><s:textfield name="plot_no" cssClass="field"
							theme="simple" maxlength="20" placeholder="प्लोट न.">
							<s:fielderror fieldName="plot_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

				</tr>
				



                 <tr>

					<td class="tdLabel"><s:property
							value="getText('global.total_area_volumn')" />*:</td>
					<td class="field"><s:textfield name="total_area_volume"
							id="total_area_volume" cssClass="field" required="true" theme="simple"
							maxlength="10" placeholder="खसरा का कुल रकवा">
							<s:fielderror fieldName="total_area_volume" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><s:property
							value="getText('global.total_area_unit')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="total_areaUnitList" listKey="typeCode" listValue="typeDesc"
							name="total_area_unit" cssClass="combobox" theme="simple"
							required="true" />
						<s:fielderror fieldName="total_area_unit" theme="igr"
							cssClass="smallErrorMsg" /></td>

				</tr>


				<tr>

					<td class="tdLabel"><s:property
							value="getText('global.area_volumn')" />*:</td>
					<td class="field"><s:textfield name="area_volume"
							id="area_volume" cssClass="field" required="true" theme="simple"
							maxlength="10" placeholder="सोदा किया गया रकवा">
							<s:fielderror fieldName="area_volume" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><s:property
							value="getText('global.area_unit')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="areaUnitList" listKey="typeCode" listValue="typeDesc"
							name="area_unit" cssClass="combobox" theme="simple"
							required="true" onchange="globalAjax(this.value,'VALUATION');" />
						<s:fielderror fieldName="area_unit" theme="igr"
							cssClass="smallErrorMsg" /></td>

				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.valuation')" />*:</td>
					<td class="field"><s:textfield name="min_val" id="min_val"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" placeholder="दस्तावेज का न्यूनतम बाजार मूल्य">
							<s:fielderror fieldName="min_val" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


					<td class="tdLabel"><s:property value="getText('global.rent')" />:</td>
					<td class="field"><s:textfield name="rent" id="rent"
							cssClass="field" theme="simple" maxlength="20" placeholder="लगान">
							<s:fielderror fieldName="rent" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


				</tr>
				
				<tr>
				<td class="tdLabel"><s:property value="getText('global.no_of_tubewell')" />:</td>
					<td class="field"><s:textfield name="no_of_tubewell" id="no_of_tubewell"
							cssClass="field" theme="simple" maxlength="2" placeholder="नलकूप की संख्या">
							<s:fielderror fieldName="no_of_tubewell" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
						
				<td class="tdLabel"><s:property value="getText('global.no_of_well')" />:</td>
					<td class="field"><s:textfield name="no_of_well" id="no_of_well"
							cssClass="field" theme="simple" maxlength="2" placeholder="कुंआ की संख्या">
							<s:fielderror fieldName="no_of_well" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>		


				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.north_boundary')" />:</td>
					<td colspan="3" class="field"><s:textfield
							name="north_boundary" id="north_boundary" cssClass="longField"
							theme="simple" maxlength="500" required="true" placeholder="उत्तर चौहद्दी प्रविष्ट करें">
							<s:fielderror fieldName="north_boundary" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.south_boundary')" />:</td>
					<td colspan="3" class="field"><s:textfield
							name="south_boundary" id="south_boundary" cssClass="longField"
							theme="simple" maxlength="500" required="true" placeholder="दक्षिण चौहद्दी प्रविष्ट करें">
							<s:fielderror fieldName="south_boundary" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>



				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.east_boundary')" />:</td>
					<td colspan="3" class="field"><s:textfield
							name="east_boundary" id="east_boundary" cssClass="longField"
							theme="simple" maxlength="500" required="true" placeholder="पुरब चौहद्दी प्रविष्ट करें">
							<s:fielderror fieldName="east_boundary" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>


				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.west_boundary')" />:</td>
					<td colspan="3" class="field"><s:textfield
							name="west_boundary" id="west_boundary" cssClass="longField"
							theme="simple" maxlength="500" required="true" placeholder="पश्चिम चौहद्दी प्रविष्ट करें">
							<s:fielderror fieldName="west_boundary" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


				</tr>

              <tr>

	                 <td class="tdLabel" id="lr_bhuyia_ri_label"><s:property
							value="getText('global.bhuiyan_tehsil')" />:</td>
					<td class="field"  id="lr_bhuyia_ri"><s:select headerKey="" headerValue="Select"
							list="itsRevenueDistrictList" listKey="typeCode" id="its_revenue_district"
							listValue="typeDesc" name="its_revenue_district"
							cssClass="largecombobox"
							onchange="getitsVillage(this.value);" theme="simple"
							/> <s:fielderror fieldName="its_revenue_district"
							theme="igr" cssClass="smallErrorMsg" /></td>


					<td class="tdLabel" id="lr_bhuyia_vill_label"><s:property
							value="getText('global.bhuiyan_vill')" />:</td>
					<td class="field" id="lr_bhuyia_vill"><s:select headerKey="" headerValue="Select"
							list="itsVillageList" id="its_village_code" listKey="typeCode"
							listValue="typeDesc" name="its_village_code" 
							cssClass="largecombobox" theme="simple" /> <s:fielderror
							fieldName="its_village_code" theme="igr" cssClass="smallErrorMsg" /></td>



                  </tr>
                  
                  
                  <tr>
                  <td class="tdLabel" id="nazool_tahasil_label"><s:property
							value="getText('global.nazool_tahasil')" />:</td>
					<td class="field" id="nazool_tahasil"><s:select headerKey="" headerValue="Select"
							list="nazoolTahasilList" listKey="typeCode" id="nazoolTahasil"
							listValue="typeDesc" name="nazoolTahasil"
							cssClass="largecombobox"
							onchange="getNazoolVillage(this.value);" theme="simple"
							/> <s:fielderror fieldName="nazoolTahasil"
							theme="igr" cssClass="smallErrorMsg" /></td>
                  
                  
                  <td class="tdLabel" id="nazool_village_label"><s:property
							value="getText('global.nazool_village')" />:</td>
					<td class="field" id="nazool_village"><s:select headerKey="" headerValue="Select"
							list="nazoolVillageList" listKey="typeCode" id="nazoolVillage"
							listValue="typeDesc" name="nazoolVillage"
							cssClass="largecombobox"
							onchange="getNazoolWard(this.value);" theme="simple"
							/> <s:fielderror fieldName="nazoolVillage"
							theme="igr" cssClass="smallErrorMsg" /></td>
                  </tr>
                  
                  <tr>
                  <td class="tdLabel" id="nazool_ward_label"><s:property
							value="getText('global.nazool_ward')" />:</td>
					<td class="field" id="nazool_ward"><s:select headerKey="" headerValue="Select"
							list="nazoolWardList" listKey="typeCode" id="nazoolWard"
							listValue="typeDesc" name="nazoolWard"
							cssClass="largecombobox"
							onchange="getNazoolSheetID(this.value);" theme="simple"
							/> <s:fielderror fieldName="nazoolWard"
							theme="igr" cssClass="smallErrorMsg" /></td>
                  
                  
                  <td class="tdLabel"  id="nazool_sheet_no_label"><s:property
							value="getText('global.nazool_sheet_no')" />:</td>
					<td class="field" id="nazool_sheet_no"><s:select headerKey="" headerValue="Select"
							list="nazoolSheetIDList" listKey="typeCode" id="nazoolSheetID"
							listValue="typeDesc" name="nazoolSheetID"
							cssClass="largecombobox" theme="simple"
							/> <s:fielderror fieldName="nazoolSheetID"
							theme="igr" cssClass="smallErrorMsg" /></td>
                  
                  
                  
                  </tr>


				<tr>
					<td colspan="2" class="tdLabel"><s:property value="getText('global.anatherPropertyNew')" />*:</td>
					<td colspan="2" class="field"><s:select headerKey=""
							headerValue="Select" list="anatherPropertyList"
							listKey="typeCode" listValue="typeDesc" name="anotherProperty"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="property_details" theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>

			</table>
			</s:if>



			<div align="center">
			<s:if test="printFlag!=true">
				<s:submit method="addPropertyDetail" cssClass="button"
					value="Submit" theme="simple" />
			</s:if>


				<s:if test="dummyCallNature==true">
					<s:if test="dummyNavigationFlag==true">
						<s:if test="printFlag==true">

							<s:url action="StructureDetailEntryAction.action"
								var="secondToken">

								<s:param name="token_no">
									<s:property value="dummyTokenNo" />
								</s:param>

								<s:param name="dsr_location">
									<s:property value="dummyDsrLocation" />
								</s:param>

								<s:param name="district_id">
									<s:property value="dummyDistrictID" />
								</s:param>

								<s:param name="token_date">
									<s:property value="dummyTokenDate" />
								</s:param>

								<s:param name="dummyDeedID">
									<s:property value="dummyDeedID" />
								</s:param>

								<s:param name="dummyFirstPartyName">
									<s:property value="dummyFirstPartyName" />
								</s:param>


								<s:param name="dummyPresenterName">
									<s:property value="dummyPresenterName" />
								</s:param>

								<s:param name="dummyFirstPartyExecutantCapacity">
									<s:property value="dummyFirstPartyExecutantCapacity" />
								</s:param>


								<s:param name="dummyDeedCategoryId">
									<s:property value="dummyDeedCategoryId" />
								</s:param>


								<s:param name="dummyConsideredAmount">
									<s:property value="dummyConsideredAmount" />
								</s:param>


								<s:param name="dummyERegistrationId">
									<s:property value="dummyERegistrationId" />
								</s:param>


								<s:param name="dummyStampNoWithVal">
									<s:property value="dummyStampNoWithVal" />
								</s:param>


								<s:param name="dummyOriginalDeedTotalPageNo">
									<s:property value="dummyOriginalDeedTotalPageNo" />
								</s:param>

								<s:param name="dummyCallNature">true</s:param>

								<s:param name="dummyTotalStampValue">
									<s:property value="dummyTotalStampValue" />
								</s:param>




							</s:url>

							<s:a href="%{secondToken}">
								<input type="button" name="Next" value="Next" class="button">
							</s:a>
						</s:if>
					</s:if>
				</s:if>




				<input type="button" name="Back" value="Back" class="button"
					onClick="window.location.href='SearchSecondTokenforPropertyEntry.action?event=PROPERTY_DETAIL';">

				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitPropertyDetail';">

			</div>
		</div>
		<s:hidden name="token_date" id="token_date" />
		<s:hidden name="dsr_location" id="dsr_location" />
		<s:hidden name="district_id" id="district_id" />
		<s:hidden name="dummyTokenNo" id="dummyTokenNo" />
		<s:hidden name="dummyDistrictID" id="dummyDistrictID" />
		<s:hidden name="dummyDsrLocation" id="dummyDsrLocation" />
		<s:hidden name="dummyNavigationFlag" id="dummyNavigationFlag" />
		<s:hidden name="dummyTokenDate" id="dummyTokenDate" />
		<s:hidden name="dummyDeedID" id="dummyDeedID" />
		<s:hidden name="dummyFirstPartyName" id="dummyFirstPartyName" />
		<s:hidden name="dummyPresenterName" id="dummyPresenterName" />
		<s:hidden name="dummyFirstPartyExecutantCapacity" id="dummyFirstPartyExecutantCapacity" />
		<s:hidden name="dummyDeedCategoryId" id="dummyDeedCategoryId" />
		<s:hidden name="dummyConsideredAmount" id="dummyConsideredAmount" />
		<s:hidden name="dummyERegistrationId" id="dummyERegistrationId" />
		<s:hidden name="dummyStampNoWithVal" id="dummyStampNoWithVal" />
		<s:hidden name="dummyOriginalDeedTotalPageNo" id="dummyOriginalDeedTotalPageNo" />
		<s:hidden name="dummyCallNature" id="dummyCallNature" />
		<s:hidden name="dummyTotalStampValue" id="dummyTotalStampValue" />
		<s:hidden name="tcp_permission" id="tcp_permission" />
		<s:hidden name="property_permission" id="property_permission" />
		<s:hidden name="rda_permission" id="rda_permission" />
		
		

	</s:form>
</body>
<script>
window.history.forward(0);

$("#khasra1").show(); 
/*	$("#khasra2").show();*/
 
 $("#khasra2").hide();

$("#blockno1").hide();
$("#blockno2").hide();
$("#lr_bhuyia_ri").show();
$("#lr_bhuyia_vill").show();
$("#lr_bhuyia_ri_label").show();
$("#lr_bhuyia_vill_label").show();

$("#nazool_tahasil_label").hide();
$("#nazool_village_label").hide();
$("#nazool_ward_label").hide();
$("#nazool_sheet_no_label").hide();
$("#nazool_tahasil").hide();
$("#nazool_village").hide();
$("#nazool_ward").hide();
$("#nazool_sheet_no").hide();


/*	$("#sheet2").hide(); */

function nojulFunction(tcpValue){
		
	if((tcpValue == 'global_khasra_type_2')||(tcpValue == 'global_khasra_type_3')){
		
		
		try{
		    var formInput= "district_id="+ document.getElementById("district_id").value+'&khasra_type='+ tcpValue;  
		    var options='';   
		      $("#nazoolTahasil").html(options);  
		      $.getJSON('loadNazoolTahasil.action', formInput,function(data) {
		    	options = '<option selected value="">Select</option>';
		    	$.each(data.nazoolTahasilList, function(i,item){
		    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
		        });  
		          
		        $("#nazoolTahasil").html(options);   
		    }); 
		  } catch(Exception)
		  {
			  alert("Error" + Exception);
		  }
		
		

		$("#blockno1").show();
		$("#blockno2").show();
		$("#khasra2").show();
/*		$("#sheet2").show();  */

		$("#khasra1").hide();
/*		$("#khasra2").hide(); */
		 $("#lr_bhuyia_ri").hide();
		 $("#lr_bhuyia_vill").hide();
		 $("#lr_bhuyia_ri_label").hide();
		 $("#lr_bhuyia_vill_label").hide();
		 $("#nazool_tahasil_label").show();
		 $("#nazool_village_label").show();
		 $("#nazool_ward_label").show();
		 $("#nazool_sheet_no_label").show();
		 $("#nazool_tahasil").show();
		 $("#nazool_village").show();
		 $("#nazool_ward").show();
		 $("#nazool_sheet_no").show();
	}else{

		$("#blockno1").hide();
		$("#blockno2").hide();
		$("#khasra2").hide();
/*		$("#sheet2").hide(); */

		$("#khasra1").show();
		$("#lr_bhuyia_ri").show();
		$("#lr_bhuyia_vill").show();
		 $("#lr_bhuyia_ri_label").show();
		 $("#lr_bhuyia_vill_label").show();
		 $("#nazool_tahasil_label").hide();
		 $("#nazool_village_label").hide();
		 $("#nazool_ward_label").hide();
		 $("#nazool_sheet_no_label").hide();
		 $("#nazool_tahasil").hide();
		 $("#nazool_village").hide();
		 $("#nazool_ward").hide();
		 $("#nazool_sheet_no").hide();
/*		$("#khasra2").show(); */
	}
}



	
	function globalAjax(value1, method) {

		try {

			var options = '';
			var blankOption = '<option selected value="">Select</option>';

			if (method == "AREA_TYPE") {
				var formInput = 'area_master_id=' + value1
						+ "&methodName=AREA_TYPE&district_id="
						+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;
				$("#area_type_name").html(options);
				$.getJSON('globalAjax.action', formInput, function(data) {
					options = '<option selected value="">Select</option>';
					$.each(data.globalList, function(i, item) {
						options += '<option value="' + item.typeCode + '">'
								+ item.typeDesc + '</option>';
					});

					$("#area_type_name").html(options);
					$("#ward_hal_no").html(blankOption);
					$("#ward_vill_name").html(blankOption);
					$("#locality_name").html(blankOption);
					$("#mohalla_vill_name").html(blankOption);
					$("#propert_type").html(blankOption);
					$("#tahaseel").html(blankOption);
					$("#revenue_district").html(blankOption);

				});
				document.getElementById("area_volume").value = "";
				document.getElementById("min_val").value = "";

			}

			if (method == "WARD_VILL_NAME") {
				var formInput = 'area_master_id='
						+ document.getElementById("area_master_id").value
						+ "&methodName=WARD_VILL_NAME&area_type_name=" + value1
						+ "&district_id="
						+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;;

				$("#ward_vill_name").html(options);
				$.getJSON('globalAjax.action', formInput, function(data) {
					options = '<option selected value="">Select</option>';
					$.each(data.globalList, function(i, item) {
						options += '<option value="' + item.typeCode + '">'
								+ item.typeDesc + '</option>';
					});

					$("#ward_vill_name").html(options);
					$("#locality_name").html(blankOption);
					$("#mohalla_vill_name").html(blankOption);
					$("#propert_type").html(blankOption);
					$("#min_val").html('');
				});
				document.getElementById("area_volume").value = "";
				document.getElementById("min_val").value = "";
			}

			if (method == "MOHALLA_VILL_NAME") {
				var formInput = 'area_master_id='
						+ document.getElementById("area_master_id").value
						+ "&methodName=MOHALLA_VILL_NAME&area_type_name="
						+ document.getElementById("area_type_name").value
						+ "&ward_vill_name=" + value1 + "&district_id="
						+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;;

				$("#mohalla_vill_name").html(options);
				$.getJSON('globalAjax.action', formInput, function(data) {
					options = '<option selected value="">Select</option>';
					$.each(data.globalList, function(i, item) {
						options += '<option value="' + item.typeCode + '">'
								+ item.typeDesc + '</option>';
					});

					$("#mohalla_vill_name").html(options);
					$("#propert_type").html(blankOption);
					$("#min_val").html('');
				})
				document.getElementById("area_volume").value = "";
				document.getElementById("min_val").value = "";
				;
			}

			if (method == "PROPERTY_TYPE") {
				var formInput = 'area_master_id='
						+ document.getElementById("area_master_id").value
						+ "&methodName=PROPERTY_TYPE&area_type_name="
						+ document.getElementById("area_type_name").value
						+ "&ward_vill_name="
						+ document.getElementById("ward_vill_name").value
						+ "&mohalla_vill_name=" + value1 + "&district_id="
						+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;;
				

				$("#propert_type").html(options);
				$.getJSON('globalAjax.action', formInput, function(data) {
					options = '<option selected value="">Select</option>';
					$.each(data.globalList, function(i, item) {
						options += '<option value="' + item.typeCode + '">'
								+ item.typeDesc + '</option>';
					});

					$("#propert_type").html(options);
					$("#min_val").html('');
				});
				document.getElementById("area_volume").value = "";
				document.getElementById("min_val").value = "";
			}
			
			
			if (method == "FOUR_VALUE") {

				var formInput = 'area_master_id='
					+ document.getElementById("area_master_id").value
					+ "&methodName=FOUR_VALUE&area_type_name="
					+ document.getElementById("area_type_name").value
					+ "&ward_vill_name="
					+ document.getElementById("ward_vill_name").value
					+ "&mohalla_vill_name=" + document.getElementById("mohalla_vill_name").value + "&district_id="
					+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;;
				
				$("#tahaseel").html(options);
				$("#revenue_district").html(options);
				$("#ward_hal_no").html(options);
				$("#locality_name").html(options);
				$.getJSON('globalAjax.action', formInput, function(data) {
					var res = data.four_value.split("~");
					document.getElementById("tahaseel").value =res[0];
					document.getElementById("revenue_district").value = res[1];
					document.getElementById("ward_hal_no").value = res[2];
					document.getElementById("locality_name").value = res[3];
				});
				
				document.getElementById("min_val").value = "";
				document.getElementById("area_volume").value = "";
			}
			
			
			
			

			if (method == "VALUATION") {

				var formInput = 'area_volume='
						+ document.getElementById("area_volume").value
						+ '&area_unit=' + value1
						+ "&methodName=VALUATION&propert_type="
						+ document.getElementById("propert_type").value
						+ "&district_id="
						+ document.getElementById("district_id").value;
				$("#min_val").html(options);
				$.getJSON('globalAjax.action', formInput, function(data) {
					document.getElementById("min_val").value = data.min_val;
				});

			}

		} catch (Exception) {
			alert("Error" + Exception);
		}

	}

	function clearField() {
		document.getElementById("min_val").value = "";
		document.getElementById("area_volume").value = "";
	}

	/* 
	 function addTable(tableID) {
	 var table = document.getElementById(tableID);
	 var rowCount = table.rows.length;
	 var row = table.insertRow(rowCount);
	 var colCount = table.rows[0].cells.length;
	 for (var i = 0; i < colCount; i++) {
	 var newcell = row.insertCell(i);
	 newcell.innerHTML = table.rows[0].cells[i].innerHTML;
	 //alert(newcell.childNodes);
	 switch (newcell.childNodes[0].type) {
	 case "text":
	 newcell.childNodes[0].value = "";
	 break;
	 case "checkbox":
	 newcell.childNodes[0].checked = false;
	 break;
	 case "select-one":
	 newcell.childNodes[0].selectedIndex = 0;
	 break;
	 }
	 }

	 document.getElementById("rowNumber").value = rowCount + 1;

	 }

	 function deleteTable(count, tableID) {

	 var i = count.parentNode.parentNode.rowIndex;
	 var table = document.getElementById(tableID);
	 var noOfRows = table.rows.length;
	 if (noOfRows > 1) {
	 document.getElementById(tableID).deleteRow(i);
	 document.getElementById("rowNumber").value = noOfRows - 1;

	 }

	 else {
	 alert("Minimum one party type is required");

	 }
	 } */


	 function getitsVillage(value)  
		{
		 //alert("getitsVillage==="+value);
			
			  try{
			    var formInput= 'its_revenue_district='+value+"&district_id="+ document.getElementById("district_id").value;  
			    var options='';   
			      $("#its_village_code").html(options);  
			      $.getJSON('loadITSVillageEntry.action', formInput,function(data) {
			    	options = '<option selected value="">Select</option>';
			    	$.each(data.itsVillageList, function(i,item){
			    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
			        });  
			          
			        $("#its_village_code").html(options);   
			    }); 
			  } catch(Exception)
			  {
				  alert("Error" + Exception);
			  }
		}	  			    

	 function changeLabel(value)
	 {

        if(value=="global_land_nazul")  
		 document.getElementById('khasra1').innerHTML="sheet no";
        else
        	document.getElementById('khasra1').innerHTML="खसरा न0";	
		 		 
	 }




	 function getNazoolVillage(value)  
		{
			
			  try{
			    var formInput= 'nazoolTahasil='+value+"&district_id="+ document.getElementById("district_id").value+'&khasra_type='+ document.getElementById("khasra_type").value;  
			    var options='';   
			      $("#nazoolVillage").html(options);  
			      $.getJSON('loadNazoolVillageEntry.action', formInput,function(data) {
			    	options = '<option selected value="">Select</option>';
			    	$.each(data.nazoolVillageList, function(i,item){
			    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
			        });  
			          
			        $("#nazoolVillage").html(options);   
			    }); 
			  } catch(Exception)
			  {
				  alert("Error" + Exception);
			  }
		}	  			    


	 function getNazoolWard(value)  
		{
			
			  try{
			    var formInput='nazoolVillage='+value+'&nazoolTahasil='+document.getElementById("nazoolTahasil").value+"&district_id="+ document.getElementById("district_id").value+'&khasra_type='+ document.getElementById("khasra_type").value;  
			    var options='';   
			      $("#nazoolWard").html(options);  
			      $.getJSON('loadNazoolWardEntry.action', formInput,function(data) {
			    	options = '<option selected value="">Select</option>';
			    	$.each(data.nazoolWardList, function(i,item){
			    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
			        });  
			          
			        $("#nazoolWard").html(options);   
			    }); 
			  } catch(Exception)
			  {
				  alert("Error" + Exception);
			  }
		}	  		


	 function getNazoolSheetID(value)  
		{
			
			  try{
			    var formInput='nazoolWard='+value+'&nazoolVillage='+document.getElementById("nazoolVillage").value+'&nazoolTahasil='+document.getElementById("nazoolTahasil").value+"&district_id="+ document.getElementById("district_id").value+'&khasra_type='+ document.getElementById("khasra_type").value;  
			    var options='';   
			      $("#nazoolSheetID").html(options);  
			      $.getJSON('loadNazoolSheetIDEntry.action', formInput,function(data) {
			    	options = '<option selected value="">Select</option>';
			    	$.each(data.nazoolSheetIDList, function(i,item){
			    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
			        });  
			          
			        $("#nazoolSheetID").html(options);   
			    }); 
			  } catch(Exception)
			  {
				  alert("Error" + Exception);
			  }
		}	  		

	 
	 
</script>


</html>
<%@include file="../commonJsp/footer.inc"%>
