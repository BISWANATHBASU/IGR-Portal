<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>पक्षकार विवरणी</title>
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
				<li class="doneWind"><a href="#">संरचना का विवरण &#10004;</a></li>
				
				<li class="workingWind"><a href="#">पक्षकार का प्रकार &#9998;</a></li>
				
				<li class="waitingWind"><a href="#">विलेख का विवरण &#10006;</a></li>
				<li class="waitingWind"><a href="#">अपॉइंटमेंट/ शुल्क &#10006;</a></li>
				<li class="waitingWind"><a href="#">पुनः अपॉइंटमेंट &#10006;</a></li>
			</ul>
		</div>
		<s:form action="addPartyDetail" validate="true" namespace="/" method="post">
			<s:token />
	
			<div align="center" class="formCaption">
				<s:if test="printFlag!=true"><s:property value="getText('global.party_detail_head')" /></s:if>
				<s:if test="printFlag==true"><s:property value="getText('global.party_detail_head_success')" /></s:if>
			</div>
	
			<div align="center">
			
			<s:if test="%{!partyDetailList.isEmpty()}">
			<table class="appFormBlock" align="center" cellspacing="2px"
						cellpadding="1px" width="100%">
						<caption class="formBlockCaption">Party Detail:~</caption>
						<tr>
							<TD align="center" class="fieldLabel"><s:property value="getText('global.party_party_name')" /></TD>
							<TD align="center" class="fieldLabel"><s:property value="getText('global.party_party_type')" /></TD>
							
						</tr>
						<s:iterator value="partyDetailList" var="partyDetailList">
							<tr>
								<td class="fieldrowwise" align="Left"><s:property
										value="typeCode" /></td>
								<td class="fieldrowwise" align="Left"><s:property
										value="typeDesc" /></td>
										
										
							</tr>
						</s:iterator>
					</table>
			</s:if>
			<s:if test="printFlag!=true">
				<table  id="partyDetailTable" class="largeAppFormBlock" align="center" cellspacing="2px" cellpadding="1px">
					<s:actionerror theme="igr" cssClass="errorMsg" />
					<s:actionmessage theme="igr" cssClass="infoMsg" />
				<tr>		
						<td class="tdLabel"><s:property
								value="getText('global.Deed_Type_Name')" />*:</td>
						<td class="field"><s:select list="deedTypeList" listKey="typeCode"
								listValue="typeDesc" name="deed_type_id" cssClass="combobox"
								theme="simple" required="true"  style="background-color: #C0C0C0;"/> <s:fielderror
								fieldName="deed_type_id" theme="igr" cssClass="smallErrorMsg" />
						</td>
						<td class="tdLabel"><s:property
								value="getText('global.party_party_type')" />*:</td>	
						<td class="field"><s:select list="partyTypeList" headerKey="" headerValue="Select" listKey="typeCode"
								listValue="typeDesc" name="party_type_id" cssClass="combobox"
								theme="simple" required="true" /> <s:fielderror
								fieldName="party_type_id" theme="igr" cssClass="smallErrorMsg" />
						</td>
				</tr>
			 	<tr>
				<td class="tdLabel"><s:property value="getText('global.party_party_name')" />*:</td>	
				<td class="field"><s:textfield name="party_name"
							cssClass="field" required="true"
							theme="simple" maxlength="100"
							onblur="javascript:this.value=this.value.toUpperCase();" placeholder="पक्षकार का नाम प्रविष्ट करें">
							<s:fielderror fieldName="party_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield>
					</td>	
				<td class="tdLabel"><s:property value="getText('global.relation')" />*:</td>
				<td class="field"><s:select headerKey="" headerValue="Select"
								list="relationList" listKey="typeCode"
								listValue="typeDesc" name="party_fh_rel"
								cssClass="combobox" theme="simple" required="true" /> <s:fielderror
								fieldName="party_fh_rel" theme="igr"
								cssClass="smallErrorMsg" /></td>
				</tr>
					<tr>
					<td class="tdLabel"><s:property value="getText('global.gurdianname')" />*:</td>
					
					<td class="field"><s:textfield name="party_fh_rel_name"
							cssClass="field" required="true" placeholder="पिता/पति का नाम प्रविष्ट करें"
							theme="simple" maxlength="100"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="party_fh_rel_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield>
					</td>	
					<td class="tdLabel"><s:property value="getText('global.address')" />*:</td>	
						<td class="field"><s:textfield name="address"
							cssClass="field" required="true" placeholder="पक्षकार अपना पता प्रविष्ट करें"
							theme="simple" maxlength="100"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="address" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield>
					</td>	
					
					</tr>	
					<tr>
					<td class="tdLabel"><s:property value="getText('global.pan')" />:</td>
					<td class="field"><s:textfield name="pan_no"
							cssClass="field" placeholder="पक्षकार पैन/फार्म 60 प्रविष्ट करें"
							theme="simple" maxlength="10"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="pan_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield>
					<td class="tdLabel"><s:property value="getText('global.ph_no')" />*:</td>
					<td class="field"><s:textfield name="ph_no"
							cssClass="field" required="true" placeholder="पक्षकार फोने न. प्रविष्ट करें"
							theme="simple" maxlength="10" pattern="[0-9]{10}"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="ph_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield>	
						
					</td>	
					</tr>
					<tr>
					<td class="tdLabel"><s:property value="getText('global.profession')" />*:</td>
						<td class="field"><s:select headerKey="" headerValue="Select"
								list="professionList" listKey="typeCode"
								listValue="typeDesc" name="profession"
								cssClass="combobox" theme="simple" required="true" /> <s:fielderror
								fieldName="profession" theme="igr"
								cssClass="smallErrorMsg" /></td>
					
					<td class="tdLabel"><s:property value="getText('global.gender')" />*:</td>
						
				
					<td class="field"><s:select headerKey="" headerValue="Select"
								list="sexList" listKey="typeCode"
								listValue="typeDesc" name="gender"
								cssClass="combobox" theme="simple" required="true" /> <s:fielderror
								fieldName="gender" theme="igr"
								cssClass="smallErrorMsg" /></td>
					
					
					
					</tr>
					
					<tr>
					<td colspan="0.5" class="tdLabel"><s:property value="getText('global.caste')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
								list="casteList" listKey="typeCode"
								listValue="typeDesc" name="caste" onchange="loadValue(this.value);"
								cssClass="combobox" theme="simple" required="true" /> <s:fielderror
								fieldName="caste" theme="igr"
								cssClass="smallErrorMsg" /></td>
								
					
					<td  class="tdLabel"><s:property value="getText('global.sub_caste')" />:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
								list="subCasteList" listKey="typeCode"
								listValue="typeDesc" name="sub_cast" id="sub_cast"
								cssClass="combobox" theme="simple" /> <s:fielderror
								fieldName="sub_cast" theme="igr"
								cssClass="smallErrorMsg" /></td>
					</tr>
					
					
					<tr>
					<td class="tdLabel"><s:property value="getText('global.addressprooftype')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
								list="addressprooftypeList" listKey="typeCode"
								listValue="typeDesc" name="address_proof"
								cssClass="combobox" theme="simple" required="true" /> <s:fielderror
								fieldName="address_proof" theme="igr"
								cssClass="smallErrorMsg" /></td>
					<td class="tdLabel"><s:property value="getText('global.addressproofvalue')" />*:</td>
						<td class="field"><s:textfield name="address_proof_value"
							cssClass="field" required="true" placeholder="संलग्न पहचान पत्र संख्या प्रविष्ट करें"
							theme="simple" maxlength="20"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="address_proof_value" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield>
					</td>	
					</tr>
					
					<s:if test="language==1">
					<tr>
					<td class="tdLabel"><s:property value="getText('global.party_name_hindi')" />*:</td>	
				<td class="field"><s:textfield name="party_name_hindi"
							cssClass="field" required="true" placeholder="पक्षकार अपना नाम हिंदी में प्रविष्ट करें"
							theme="simple" maxlength="100"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="party_name_hindi" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield>
					</td>	
					
						<td class="tdLabel"><s:property
								value="getText('global.anatherProperty')" />*:</td>
							<td  class="field" ><s:select headerKey="" headerValue="Select"
								list="anatherPartyList" listKey="typeCode" listValue="typeDesc"
								name="anotherParty" cssClass="combobox" theme="simple"
								required="true" /> <s:fielderror fieldName="property_details"
								theme="igr" cssClass="smallErrorMsg" /></td>
					</tr>
					
					
					
					<td colspan="2" class="tdLabel"><s:property
								value="getText('global.biometric_required')" />*:</td>
							<td colspan="2" class="field" ><s:select 
								list="biometric_required_list" listKey="typeCode" listValue="typeDesc"
								name="biometric_required" cssClass="combobox" theme="simple"
								required="true" /> <s:fielderror fieldName="biometric_required"
								theme="igr" cssClass="smallErrorMsg" /></td>
					
					
					
					</s:if>
					
					
					
					<s:if test="language==2">
					<tr>
						<td class="tdLabel"><s:property
								value="getText('global.anatherProperty')" />*:</td>
							<td  class="field" ><s:select headerKey="" headerValue="Select"
								list="anatherPartyList" listKey="typeCode" listValue="typeDesc"
								name="anotherParty" cssClass="combobox" theme="simple"
								required="true" /> <s:fielderror fieldName="property_details"
								theme="igr" cssClass="smallErrorMsg" /></td>
								
						<td class="tdLabel"><s:property
								value="getText('global.biometric_required')" />*:</td>
							<td  class="field" ><s:select 
								list="biometric_required_list" listKey="typeCode" listValue="typeDesc"
								name="biometric_required" cssClass="combobox" theme="simple"
								required="true" /> <s:fielderror fieldName="biometric_required"
								theme="igr" cssClass="smallErrorMsg" /></td>		
								
					</tr>
					</s:if>
						
					
	
	</table>
	</s:if>
	<div align="center">
				<s:if test="printFlag!=true">
					<s:submit cssClass="button" value="Submit" theme="simple" />
				</s:if>
						
							<!--:if test="dummyCallNature==true">		
							<:if test="dummyNavigationFlag==true"-->		
						<s:if test="printFlag==true">
					
					<s:url action="DeedDetailEntryAction.action" var="secondToken">
					
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
											
											<s:param name="deed_type_id">
												<s:property value="dummyDeedID" />
											</s:param>
											
											<s:param name="deedID">
												<s:property value="dummyDeedID" />
											</s:param>
											
											<s:param name="first_party_executant_name">
												<s:property value="dummyFirstPartyName" />
											</s:param>
											
											<s:param name="presenter_name">
												<s:property value="dummyPresenterName" />
											</s:param>
											
											<s:param name="first_party_executant_capacity">
												<s:property value="dummyFirstPartyExecutantCapacity" />
											</s:param>
											
											
											<s:param name="deed_category_id">
												<s:property value="dummyDeedCategoryId" />
											</s:param>
											
											
											<s:param name="considered_amount">
												<s:property value="dummyConsideredAmount" />
											</s:param>
											
											
											<s:param name="e_registration_code">
												<s:property value="dummyERegistrationId" />
											</s:param>
											
											
											<s:param name="presented_stamp_value">
												<s:property value="dummyStampNoWithVal" />
											</s:param>
											
											
											<s:param name="no_total_pages">
												<s:property value="dummyOriginalDeedTotalPageNo" />
											</s:param>
											
											<s:param name="new_no_of_total_pages">
												<s:property value="dummyOriginalDeedTotalPageNo" />
											</s:param>
											
											<s:param name="dummyCallNature">true</s:param>
											
											
											<s:param name="presented_stamp_value">
												<s:property value="dummyTotalStampValue" />
											</s:param>
											
											
					</s:url>
					
					<s:a href="%{secondToken}">
						<input type="button" name="Next" value="Next" class="button">
					</s:a>
					</s:if>
				<!--/:if>		
				</:if-->		
						
					
					<input type="button" name="Back" value="Back" class="button"
						onClick="window.location.href='SearchSecondTokenforPropertyEntry.action?event=PARTY_DETAIL';">		
						
					<input type="button" name="Exit" value="Exit" class="button"
						onClick="window.location.href='exitPartyDetail';">
					
				</div>
				</div>
			
				<s:hidden name="token_date" id="token_date" />
				<s:hidden name="dsr_location" id="dsr_location" />
				<s:hidden name="token_no" id="token_no" />
				<s:hidden name="deedID" id="deedID" />
				<s:hidden name="district_id" />
				<s:hidden name="language" id="language" />
				
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
	<script type="text/javascript">
		window.history.forward(0);
		
		function loadValue(value){
			try{
				var formInput= 'castValue='+value+"&language="+document.getElementById("language").value;
				var options='';   
				$("#sub_cast").html(options);
				$.getJSON('loadValue.action', formInput,function(data) {
					options = '<option selected value="">Select</option>';
					$.each(data.subCasteList, function(i,item){
					options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';
					});
						$("#sub_cast").html(options);
					});
				}
			catch(Exception){
				alert("Error" + Exception);
			}
		}
	</script>
</html>
<%@include file="../commonJsp/footer.inc"%>
