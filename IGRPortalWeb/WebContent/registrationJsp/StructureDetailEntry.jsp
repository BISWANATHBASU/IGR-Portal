<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>संरचना विवरणी</title>
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
			<li class="doneWind"><a href="#">सम्पत्ति का विवरण &#10004;</a></li>
			
			<li class="workingWind"><a href="#">संरचना का विवरण &#9998;</a></li>
			
			<li class="waitingWind"><a href="#">पक्षकार का प्रकार &#10006;</a></li>
			<li class="waitingWind"><a href="#">विलेख का विवरण &#10006;</a></li>
			<li class="waitingWind"><a href="#">अपॉइंटमेंट/ शुल्क &#10006;</a></li>
			<li class="waitingWind"><a href="#">पुनः अपॉइंटमेंट &#10006;</a></li>
		</ul>
	</div>
	<s:form action="addStructureDetail" validate="true"
		namespace="/" method="post">
		<s:token />

		<div align="center" class="formCaption"><s:property value="getText('global.structure_detail_head')" /></div>

		<div align="center">
		
		<s:if test="%{!structureDetailList.isEmpty()}">
		<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Structure Detail:~</caption>
					<tr>
						
						<TD align="center" class="fieldLabel"><s:property value="getText('global.structure_name')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.structure_no')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.floor')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.area_volumn')" /></TD>
					</tr>
					<s:iterator value="structureDetailList" var="structureDetailList">
						<tr>
							<td class="fieldrowwise" align="center"><s:property
									value="structure_name" /></td>
							
								<td class="fieldrowwise" align="center"><s:property
									value="structure_no" /></td>
									
									<td class="fieldrowwise" align="center"><s:property
									value="floor" /></td>
									
									<td class="fieldrowwise" align="right"><s:property
									value="area_volume" /></td>
						</tr>
					</s:iterator>
				</table>
		</s:if>
		
		
		
		
		
		
							<table class="appFormBlock" align="center" cellspacing="2px"
							cellpadding="1px">
							<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />
							<tr>
								<td class="tdLabel"><s:property
										value="getText('global.Token_No')" />*:</td>
								<td class="field"><s:textfield name="token_no"
										cssClass="field readOnlyField" readonly="true"
										theme="simple" maxlength="20" style="background-color: #C0C0C0;">
										<s:fielderror fieldName="token_no" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>

								<td class="tdLabel"><s:property
										value="getText('global.AREA_TYPE')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="areaTypeList" listKey="typeCode"
										id="area_type" listValue="typeDesc" name="area_type" onchange="clearField();"
										cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
										fieldName="area_type" theme="igr" cssClass="smallErrorMsg" /></td>

							</tr>
							<tr>
								<td class="tdLabel"><s:property
										value="getText('global.property_type')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="constractionTypeList"
										listKey="typeCode" listValue="typeDesc"
										name="type_construction" id="type_construction" onchange="clearField();"
										cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
										fieldName="type_construction" theme="igr"
										cssClass="smallErrorMsg" /></td>


								<td class="tdLabel"><s:property
										value="getText('global.structure.uses')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="usesTypeList" listKey="typeCode"
										id="use_construction" listValue="typeDesc" onchange="clearField();"
										name="use_construction" cssClass="largecombobox"
										theme="simple" required="true" /> <s:fielderror
										fieldName="use_construction" theme="igr" cssClass="smallErrorMsg" /></td>

							</tr>

							<tr>
								<td class="tdLabel"><s:property
										value="getText('global.structure_name')" />*:</td>
								<td class="field"><s:textfield name="structure_name"
										cssClass="field" required="true" theme="simple" maxlength="20" placeholder="संरचना/भवन का नाम प्रविष्ट करें">
										<s:fielderror fieldName="structure_name" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>


								<td class="tdLabel"><s:property
										value="getText('global.structure_no')" />*:</td>
								<td class="field"><s:textfield name="structure_no"
										cssClass="field" required="true" theme="simple" maxlength="20" placeholder="संरचना/भवन सं. प्रविष्ट करें">
										<s:fielderror fieldName="structure_no" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>

							</tr>
							
							<tr>
							<td class="tdLabel"><s:property
										value="getText('global.structure_type')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="structureList" listKey="typeCode"
										id="structure" listValue="typeDesc" 
										name="structure" cssClass="largecombobox"
										theme="simple" required="true" /> <s:fielderror
										fieldName="structure" theme="igr" cssClass="smallErrorMsg" /></td>
							
							
							
							<td class="tdLabel"><s:property
										value="getText('global.structure_age')" />*:</td>
								<td class="field"><s:textfield name="ageOfStructure" id="ageOfStructure"
										cssClass="field" required="true" theme="simple" maxlength="4" placeholder="संरचना की आयु प्रविष्ट करें">
										<s:fielderror fieldName="ageOfStructure" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
							
							
							</tr>
							
							<tr>
								<td class="tdLabel"><s:property
										value="getText('global.structure_owner')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="structureList" listKey="typeCode"
										id="structure_owner" listValue="typeDesc" 
										name="structure_owner" cssClass="largecombobox"
										theme="simple" required="true" /> <s:fielderror
										fieldName="structure_owner" theme="igr" cssClass="smallErrorMsg" /><%-- 
										
										<s:textfield name="structure_owner"
										cssClass="field" required="true" theme="simple" maxlength="20">
										<s:fielderror fieldName="structure_owner" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield> --%></td>
							
							
								<td class="tdLabel"><s:property
										value="getText('global.floor')" />*:</td>
								<td class="field"><s:textfield name="floor" id="floor"
										cssClass="field" required="true" theme="simple" maxlength="2"
										onBlur="clearField();" placeholder="तल स्थिति प्रविष्ट करें">
										<s:fielderror fieldName="floor" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>


								
									
									

							</tr>
							<tr>
							
							<td class="tdLabel"><s:property
										value="getText('global.area_volumn')" />*:</td>
								<td class="field"><s:textfield name="area_volume"
										id="area_volume" cssClass="field" required="true"
										theme="simple" maxlength="10" onBlur="clearValue();" placeholder="सोदा किया गया रकवा प्रविष्ट करें">
										<s:fielderror fieldName="area_volume" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
							
							
							
								<td class="tdLabel"><s:property
										value="getText('global.structure_unit')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="structureUnitList" listKey="typeCode"
										id="structure_unit" listValue="typeDesc" name="structure_unit" onchange="calculateValue(this.value);"
										cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
										fieldName="structure_unit" theme="igr" cssClass="smallErrorMsg" /></td>

							</tr>

							<tr>
							<td class="tdLabel"><s:property
										value="getText('global.valuation')" />*:</td>
								<td class="field"><s:textfield name="valuation"
										id="valuation" cssClass="field readOnlyField" readonly="true"
										theme="simple" maxlength="20" placeholder="दस्तावेज का न्यूनतम बाजार मूल्य प्रविष्ट करें">
										<s:fielderror fieldName="valuation" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
							
							
							
								<td  class="tdLabel"><s:property
										value="getText('global.anatherProperty')" />*:</td>
								<td  class="field"><s:select headerKey=""
										headerValue="Select" list="anatherStructureList"
										listKey="typeCode" listValue="typeDesc" name="anotherStructure"
										cssClass="combobox" theme="simple" required="true" /> <s:fielderror
										fieldName="property_details" theme="igr"
										cssClass="smallErrorMsg" /></td>
							</tr>



						</table>
				


			<div align="center">
				<s:submit cssClass="button"
					value="Submit" theme="simple" />
					
					
						<s:if test="dummyCallNature==true">		
					<s:if test="dummyNavigationFlag==true">		
					<s:if test="printFlag==true">
				
				<s:url action="PartyDetailEntryAction.action" var="secondToken">
				
										<s:param name="token_no">
											<s:property value="dummyTokenNo" />
										</s:param>
										
										<s:param name="dsr_location">
											<s:property value="dummyDsrLocation" />
										</s:param>	
										
										<s:param name="district_id">
											<s:property value="district_id" />
										</s:param>
										
										<s:param name="token_date">
											<s:property value="dummyTokenDate" />
										</s:param>
										
										<s:param name="deedID">
											<s:property value="dummyDeedID" />
										</s:param>
										
										<s:param name="party_name">
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
					onClick="window.location.href='SearchSecondTokenforPropertyEntry.action?event=STRUCTURE_DETAIL';">

				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitStructureDetail';">

			</div>
		</div>
		<s:hidden name="token_date" id="token_date" />
		<s:hidden name="dsr_location" id="dsr_location" />
		<s:hidden name="district_id" id="district_id" />
		<s:hidden name="dummyTokenNo" id="dummyTokenNo"/>			
							<s:hidden name="dummyDistrictID" id="dummyDistrictID"/>
							<s:hidden name="dummyDsrLocation" id="dummyDsrLocation"/>
							<s:hidden name="dummyNavigationFlag" id="dummyNavigationFlag"/>
							<s:hidden name="dummyTokenDate" id="dummyTokenDate"/>
							<s:hidden name="dummyDeedID" id="dummyDeedID"/>
							<s:hidden name="dummyFirstPartyName" id="dummyFirstPartyName"/>
		
							<s:hidden name="dummyPresenterName" id="dummyPresenterName"/>			
<s:hidden name="dummyFirstPartyExecutantCapacity" id="dummyFirstPartyExecutantCapacity"/>
<s:hidden name="dummyDeedCategoryId" id="dummyDeedCategoryId"/>
<s:hidden name="dummyConsideredAmount" id="dummyConsideredAmount"/>
<s:hidden name="dummyERegistrationId" id="dummyERegistrationId"/>
<s:hidden name="dummyStampNoWithVal" id="dummyStampNoWithVal"/>
<s:hidden name="dummyOriginalDeedTotalPageNo" id="dummyOriginalDeedTotalPageNo"/>
<s:hidden name="dummyCallNature" id="dummyCallNature"/>
<s:hidden name="dummyTotalStampValue" id="dummyTotalStampValue"/>

	</s:form>
</body>
<script>
window.history.forward(0);

function clearField()
{
	document.getElementById("valuation").value="";
	document.getElementById("area_volume").value="";
}




function clearValue()
{
	document.getElementById("valuation").value="";
}



	function calculateValue(value1) {

		var options = '';
		try {

			var area = document.getElementById("area_volume").value
			if ((area == '') || (isNaN(area)) || (area.trim().length == 0)) {
				alert("Input Area Volume Properly");
				document.getElementById("area_volume").value = "";
				document.getElementById("area_volume").focus();
			}

			else {
				var formInput = 'area_type='
						+ document.getElementById("area_type").value
						+ '&type_construction='
						+ document.getElementById("type_construction").value
						+ '&use_construction='
						+ document.getElementById("use_construction").value
						+ '&area_volume=' + document.getElementById("area_volume").value+"&structure_unit="+value1;

				$("#valuation").html(options);
				$
						.getJSON(
								'structureValuation.action',
								formInput,
								function(data) {
									document.getElementById("valuation").value = data.valuation;
								});
			}

		} catch (Exception) {
			alert("Error" + Exception);
		}

	}
</script>


</html>
<%@include file="../commonJsp/footer.inc"%>
