<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Executed Token</title>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:head theme="igr" />
<sx:head />
<script>
	$(function() {
	    $('#t_cp_date').datepick({dateFormat:'dd/mm/yyyy'});
	});
	
	$(function() {
	    $('#property_permission_date').datepick({dateFormat:'dd/mm/yyyy'});
	});
	
	$(function() {
	    $('#rda_permission_date').datepick({dateFormat:'dd/mm/yyyy'});
	});
</script>
</head>
<body oncontextmenu="return false;">
	<br />
	<div id="workProgress">
		<ul>
			<li class="doneWind"><a href="#">प्रस्तुति विवरणी&#10004;</a></li>
			<li class="workingWind"><a href="#">स्टाम्प विवरणी&#9998;</a></li>
			<li class="waitingWind"><a href="#">सम्पत्ति का विवरण &#10006;</a></li>
			<li class="waitingWind"><a href="#">संरचना का विवरण &#10006;</a></li>
			<li class="waitingWind"><a href="#">पक्षकार का प्रकार &#10006;</a></li>
			<li class="waitingWind"><a href="#">विलेख का विवरण &#10006;</a></li>
			<li class="waitingWind"><a href="#">अपॉइंटमेंट/ शुल्क &#10006;</a></li>
			<li class="waitingWind"><a href="#">पुनः अपॉइंटमेंट &#10006;</a></li>
		</ul>
	</div>
	<s:form action="addSecondToken" validate="true" namespace="/"
		method="post" enctype="multipart/form-data">
		<s:token />

		<div align="center" class="formCaption">
			<s:if test="printFlag!=true"><s:property value="getText('global.second_token_head')" /></s:if>
			<s:if test="printFlag==true">
				<s:property value="getText('global.second_token_head_success')" />
				<br />
				<br />
				<br />
				<font color="blue" size="3"> <s:text name="%{messageValue}"  /></font>
			</s:if>
		</div>




		<div align="center">
		<s:if test="printFlag!=true">
			<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">
				<s:actionerror theme="igr" cssClass="erroMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />

<tr><td colspan="4">
<font color="blue" size="3"> <s:text name="%{messageValue}"  /></font>
</td></tr>

				
				<tr>
			
				<td class="tdLabel"><s:property
							value="getText('global.Deed_Type_Name')" />*:</td>
					<td class="field"><%-- <s:hidden name="deed_type_id" id="deed_type_id" theme="simple" />
					<s:textfield name="deed_type_name" theme="simple" readonly="true" style="background-color: #C0C0C0;" />
					<s:hidden name="deed_type_data" theme="simple" /> --%>
					<s:select headerKey="" headerValue="Select"
							list="deedTypeList" listKey="typeCodeDesc" onchange="loadDeedCategory(this.value);"
							listValue="typeDesc" name="deed_type_id" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="deed_type_id" theme="igr" cssClass="smallErrorMsg" /></td>		
			
			
				<td class="tdLabel"><s:property value="getText('global.Deed_Category')" /> (वर्गीकरण)*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="deedCategoryList" listKey="typeCode" id="deed_category"  onchange="showOldDeed(this.value);"
							listValue="typeDesc" name="deed_category_id" cssClass="combobox"
							theme="simple" required="true"  /> <s:fielderror
							fieldName="deed_category_id" theme="igr" cssClass="smallErrorMsg" /></td>
							
				
				</tr>
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.state')" />*:</td>
                        <td class="field">
                            <s:select name="presenterState" list="stateList" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" />
                            <s:fielderror fieldName="presenterState" theme="igr" cssClass="smallErrorMsg" />
                        </td>
                        <td class="tdLabel">
                            <s:property value="getText('global.district')" />*:</td>
                        <td class="field">
                            <s:select name="district_id" id="district_id" list="districtList" onchange="loadDSRLocation(this.value);" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" />
                            <s:fielderror fieldName="district_id" theme="igr" cssClass="smallErrorMsg" />
                        </td>
                    </tr>

				<tr>

					<td class="tdLabel"><s:property
							value="getText('global.sub_register_office')" />*:</td>
					<td class="field"><%-- <s:hidden name="dsr_location" theme="simple" readonly="true" style="background-color: #C0C0C0;" />
					<s:textfield name="dsr_location_desc" theme="simple" readonly="true" style="background-color: #C0C0C0;" /> --%>
					<s:select list="dsrLocationList" listKey="typeCode"
							listValue="typeDesc" name="dsr_location" id="dsr_location" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="dsr_location" theme="igr" cssClass="smallErrorMsg" />
					</td>


					<td class="tdLabel"><%-- <s:property value="getText('global.name')" /> --%>प्रस्तुतकर्ता का नाम*:</td>
					<td class="field"><s:textfield name="presenter_name"
							cssClass="field readOnlyField" theme="simple"
							maxlength="100">
							<s:fielderror fieldName="presenter_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
					
				</tr>
				<%-- <tr><td class="tdLabel"><s:property
							value="getText('global.district')" />*:</td>
					<td class="field"><s:hidden name="district_id" theme="simple" />
					<s:textfield name="district_id_name" theme="simple" readonly="true" style="background-color: #C0C0C0;" />
					<s:select list="districtList" listKey="typeCode"
							listValue="typeDesc" name="district_id" cssClass="combobox"
							theme="simple" required="true" onchange="loadDSRLocation(this.value);" /> <s:fielderror
							fieldName="district_id" theme="igr" cssClass="smallErrorMsg" />
					</td>
					<td class="tdLabel"><s:property
							value="getText('global.Token_No')" />*:</td>
					<td class="field"><s:textfield name="token_no"
							cssClass="readOnlyField" readonly="true"
							theme="simple" maxlength="100" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="token_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr> --%>
				<tr>
					<%-- <td class="tdLabel"><!--s:property value="getText('global.first_party_name')" /-->प्रस्तुतकर्ता का नाम *:</td>
					<td class="field">
					
					<s:textfield
							name="first_party_executant_name" cssClass="field"
							required="true" theme="simple" maxlength="100"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="first_party_executant_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td> --%>

                        <td class="tdLabel"><s:property value="getText('global.party_party_type')" />*:</td>
                        <td class="field">
                            <!--s:select name="partyType" list="partyTypeList" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" /-->
                            <s:select name="party_type" list="party_type_List" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" />
                            <s:fielderror fieldName="party_type" theme="igr" cssClass="smallErrorMsg" />
                        </td>
					<td class="tdLabel"><s:property
							value="getText('global.first_capacity')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="firstPartyCapacityList" listKey="typeCode"
							listValue="typeDesc" name="first_party_executant_capacity"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="first_party_executant_capacity" theme="igr"
							cssClass="smallErrorMsg" /></td>
				</tr>
				<!-- From Party Details -->
				
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.relation')" />*:</td>
                        <td class="field">
                            <s:select name="relativeType" list="relativeTypeList" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" />
                            <s:fielderror fieldName="relativeType" theme="igr" cssClass="smallErrorMsg" />
                        </td>
                        <td class="tdLabel"><s:property value="getText('global.gurdianname')" />*:</td>
                        <td class="field">
                            <s:textfield name="relativeName" cssClass="field" required="true" theme="simple" maxlength="100" placeholder="हिंदी में पिता / माता का नाम प्रविष्टि ">
                                <s:fielderror fieldName="relativeName" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.address')" />*:</td>
                        <td class="field">
                            <s:textfield name="presenterAddress" cssClass="field" required="true" theme="simple" maxlength="100" placeholder="हिंदी में  अपना पता  प्रविष्टि कीजिये">
                                <s:fielderror fieldName="presenterAddress" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                        <td class="tdLabel"><s:property value="getText('global.pin')" />*:</td>
                        <td class="field">
                            <s:textfield name="presenterPinCode" cssClass="field" required="true" theme="simple" maxlength="6"
                             pattern="[0-9]{6}" title="6 Digit Pin Code" placeholder="डाक न. प्रविष्टि कीजिये">
                                <s:fielderror fieldName="presenterPinCode" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                    </tr>
                    
                    <!-- <tr>
                        <td class="tdLabel">&nbsp;</td>
                        <td class="field">&nbsp;</td>
                        <td class="tdLabel">&nbsp;</td>
                        <td class="field">&nbsp;</td>
                    </tr> -->
                    
                    
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.ph_no')" />*:</td>
                        <td class="field">
                            <s:textfield name="presenterMobileNo" cssClass="field" required="true" theme="simple" maxlength="10"
                             pattern="[0-9]{10}" title="10 Digit Mobile No" placeholder="मोबाइल न. प्रविष्टि कीजिये">
                                <s:fielderror fieldName="presenterMobileNo" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                        <td class="tdLabel"><s:property value="getText('global.user_mail')" />*:</td>
                        <td class="field">
                            <s:textfield name="presentereMailId" cssClass="field" required="true" theme="simple" maxlength="100" placeholder="ई-मेल प्रविष्टि कीजिये">
                                <s:fielderror fieldName="presentereMailId" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                    </tr>
                    <!-- From Party Details -->
				
				<tr>
				<td  class="tdLabel"><s:property
							value="getText('global.deed_state')" />*:</td>
					<td class="field" colspan=3><s:select headerKey=""
							headerValue="Select" list="deedStateList" id="deedState" onchange="tcpYesFunction(this.value);"
							listKey="typeCode" listValue="typeDesc" name="deedState"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="deedState" theme="igr" cssClass="smallErrorMsg" /></td>		
				</tr>
				<tr id='tcp_div_1'>
				<td class="tdLabel">पत्र क्रमांक *:</td>
					<td class="field"><s:textfield name="t_cp_no" id="t_cp_no"
							cssClass="field"  theme="simple" maxlength="5">
							<s:fielderror fieldName="t_cp_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
							
							
				<td class="tdLabel"><s:property value="getText('global.tcp_date')" />*:</td>
					<td class="field"><s:textfield name="t_cp_date" id="t_cp_date"
							cssClass="field"  theme="simple" maxlength="10" placeholder='dd/mm/yyyy'>
							<s:fielderror fieldName="t_cp_date" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>			
				</tr>
				
				<tr id='tcp_div_2'>
					<td class="tdLabel">T&amp;CP द्वारा मेमो पत्र अपलोड करें *:</td>
					<td class="field"><s:file name="memofileUpload" size="40" theme="simple" /></td>
					<td class="tdLabel">T&amp;CP द्वारा नक्सा अपलोड करें *:</td>
					<td class="field"><s:file name="nakshafileUpload" size="40" theme="simple" /></td>
				
				</tr>
				
				
								
				<tr id='pro_div_1'>
				<td class="tdLabel"><s:property value="getText('global.permission_no')" /></td>
					<td class="field"><s:textfield name="property_permission_no" id="property_permission_no"
							cssClass="field"  theme="simple" maxlength="5">
							<s:fielderror fieldName="property_permission_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
							
							
				<td class="tdLabel"><s:property value="getText('global.permission_date')" />*:</td>
					<td class="field"><s:textfield name="property_permission_date" id="property_permission_date"
							cssClass="field"  theme="simple" maxlength="10" placeholder='dd/mm/yyyy'>
							<s:fielderror fieldName="property_permission_date" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>			
				</tr>
				
				<tr id='pro_div_2'>
					<td class="tdLabel">कलेक्टर द्वारा जारी आपसी सहमति से क्रय / भू-अर्जन सम्बंधी विवरणी पत्र अपलोड करें *:</td>
					<td class="field"><s:file name="propertymemofileUpload" size="40" theme="simple" /></td>
					<td class="tdLabel">कलेक्टर द्वारा जारी आपसी सहमति से क्रय / भू-अर्जन सम्बंधी एकीकृत नक्शा अपलोड करें *:</td>
					<td class="field"><s:file name="propertynakshafileUpload" size="40" theme="simple" /></td>
				
				</tr>
				
				
				
				<tr id='rda_div_1'>
				<td class="tdLabel"><s:property value="getText('global.letter_no')" /> *:</td>
					<td class="field"><s:textfield name="rda_permission_no" id="rda_permission_no"
							cssClass="field"  theme="simple" maxlength="5">
							<s:fielderror fieldName="rda_permission_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
							
							
				<td class="tdLabel"><s:property value="getText('global.rda_date')" /> *:</td>
					<td class="field"><s:textfield name="rda_permission_date" id="rda_permission_date"
							cssClass="field"  theme="simple" maxlength="10" placeholder='dd/mm/yyyy'>
							<s:fielderror fieldName="rda_permission_date" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>			
				</tr>
				
				<tr id='rda_div_2'>
					<td class="tdLabel">RDA/CGHB/ पुर्व SADA क्षेत्र द्वारा निर्गत अनापत्ति पत्र (NOC)अपलोड करे *:</td>
					<td class="field"><s:file name="rdamemofileUpload" size="40" theme="simple" /></td>
					<td class="tdLabel">RDA/CGHB/ पुर्व SADA क्षेत्र द्वारा निर्गत अनुमोदित नक्शा अपलोड करे *:</td>
					<td class="field"><s:file name="rdanakshafileUpload" size="40" theme="simple" /></td>
				
				</tr>
							
								
			
				<tr>
				<td class="tdLabel"><s:property
							value="getText('global.stamp_type')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="stampTypeList" listKey="typeCode"
							listValue="typeDesc" name="stamp_type" id="stamp_type"
							cssClass="combobox" theme="simple" onchange="clearValue(this.value);" /> <s:fielderror
							fieldName="stamp_type" theme="igr"
							cssClass="smallErrorMsg" /></td>
				
				
							<td class="tdLabel"><s:property
							value="getText('global.total_stamp_value')" />*:</td>
					<td class="field"><s:textfield name="total_stamp_value" id="total_stamp_value"
							cssClass="field" required="true"  theme="simple" maxlength="100" placeholder="कुल मुद्रांक प्रविष्टी कीजिय">
							<s:fielderror fieldName="total_stamp_value" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
					
				</tr>
				
				<tr>
				
					<td class="tdLabel"><span id="stamp_pages_hed"><s:property value="getText('global.stamp_pages')" />*:</span></td>
					<td class="field"><span id="stamp_pages_txt"><s:textfield name="stamp_pages_no" id="stamp_pages_no"
							cssClass="shortfieldrowwise" 
							theme="simple" maxlength="3" onblur="setValue(this);" placeholder="स्टाम्प पेज प्रविष्टी कीजिय">
							<s:fielderror fieldName="stamp_pages_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></span></td>
				
				
					<td class="tdLabel"><span id="treasury_stamp_page_hed"><s:property value="getText('global.treasury_stamp_pages')" />*:</span></td>
					<td class="field"><span id="treasury_stamp_page_txt"><s:textfield name="treasury_stamp_page_no" id="treasury_stamp_page_no"
							cssClass="shortfieldrowwise" theme="simple" maxlength="3" placeholder="कोषागार स्टाम्प प्रविष्टी कीजिय">
							<s:fielderror fieldName="treasury_stamp_page_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></span></td>
							
						
				</tr>
				
				<tr>
				
								
						<td class="tdLabel"><span id="chalan_page_hed"><s:property value="getText('global.chalan_page_no')" />*:</span></td>
					<td class="field"><span id="chalan_page_txt"><s:textfield name="chalan_page_no" id="chalan_page_no"
							cssClass="shortfieldrowwise" theme="simple" maxlength="3" onblur="setValue(this);" placeholder="चलान पेज प्रविष्टी कीजिय">
							<s:fielderror fieldName="chalan_page_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></span></td>
		
				<td class="tdLabel"><s:property
							value="getText('global.considered_amount')" />:</td>
					<td class="field"><s:textfield
							name="considered_amount" id="considered_amount" cssClass="field"
							 theme="simple" maxlength="20" placeholder="विलेख में अंकित मूल्य प्रविष्टी कीजिय">
							<s:fielderror fieldName="considered_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				
				<!--td class="tdLabel">s:property value="getText('global.total_page_no')" />*:</td>
					<td class="field">s:textfield name="total_page_no" id="total_page_no" 
							cssClass="shortfieldrowwise" required="true"
							theme="simple" maxlength="5">
							s:fielderror fieldName="total_page_no" theme="igr"
								cssClass="smallErrorMsg" />
							/s:textfield>
						</td-->
				
				
						
					</tr>
				
				
				
				<tr>
		
		
					<td class="tdLabel"><s:property
							value="getText('global.deal_amount')" />*:</td>
					<td class="field"><s:textfield
							name="dealing_amount" id="dealing_amount" cssClass="field"
							required="true" theme="simple" maxlength="20" placeholder="प्रतिफल की राशि प्रविष्टी कीजिय">
							<s:fielderror fieldName="dealing_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
				
								
				
				<td class="tdLabel"><s:property
							value="getText('global.paid_amount1')" />*:</td>
					<td class="field"><s:textfield
							name="paid_amount" id="paid_amount" cssClass="field"
							required="true" theme="simple" maxlength="20" placeholder="प्राप्त राशि प्रविष्टी कीजिय">
							<s:fielderror fieldName="paid_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
				</tr>
				<tr>
				
				
				<td class="tdLabel"><%-- <s:property
							value="getText('global.e_registration_id')" /> --%></td>
				<td class="field"><%-- <s:textfield
							name="e_registration_id" cssClass="field readOnlyField"
							theme="simple" maxlength="19" readonly="true"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="e_registration_id" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield> --%></td>
				
				
				<td class="tdLabel"><s:property
							value="getText('global.aa_rate')" />:</td>
				<td class="field"><s:textfield
							name="aa_rent" id="aa_rent" cssClass="field readOnlyField"
							theme="simple" maxlength="20" value="0" readonly="true" placeholder="वार्षिक क्षेत्र दर प्रविष्टी कीजिय">
							<s:fielderror fieldName="aa_rent" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
						
						
				</tr>
				<tr>
			
						
				
					<td class="tdLabel"><s:property
							value="getText('global.premium_amount')" />:</td>
				<td class="field"><s:textfield
							name="premium_amount" id="premium_amount" cssClass="field readOnlyField"
							theme="simple" maxlength="20" value="0" readonly="true" placeholder="प्रीमियम राशिप्रविष्टी कीजिय">
							<s:fielderror fieldName="premium_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				
			
				<td class="tdLabel"><s:property
							value="getText('global.cost_of_building')" />:</td>
				<td class="field"><s:textfield
							name="cost_of_building" id="cost_of_building" cssClass="field readOnlyField"
							theme="simple" maxlength="20" value="0" readonly="true" placeholder="भवन की लागत">
							<s:fielderror fieldName="cost_of_building" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
				</tr>
				
				<!--tr>
			
			
			
					<td class="tdLabel"><!--s:property
							value="getText('global.input_form')" />*:--</td>
					<td  class="field"><!--s:select headerKey=""
							headerValue="Select" list="inputFormList"
							listKey="typeCode" listValue="typeDesc" name="input_form"
							cssClass="combobox" theme="simple" required="true" /> s:fielderror
							fieldName="input_form" theme="igr" cssClass="smallErrorMsg" /--</td>
							
				</tr-->
				
				<!--tr>
				
				<td  class="tdLabel">s:property
							value="getText('global.complete_document')" />*:</td>
					<td  class="field"><s:select headerKey=""
							headerValue="Select" list="completeDocumentList"
							listKey="typeCode" listValue="typeDesc" name="complete_document"
							cssClass="combobox" theme="simple" required="true" /> s:fielderror
							fieldName="complete_document" theme="igr" cssClass="smallErrorMsg" /></td>		
							
				
				<td  class="tdLabel">कार्यालय द्वारा सत्यापित इनपुट फॉर्म अपलोड करें ! *:</td>
				 <td  class="field"><s:file name="fileUpload"  size="40" theme="simple" /></td>
                 </tr-->
				
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.document')" />*:</td>
                        <td class="field">
                            <s:file name="uploadDoc" cssClass="field" required="true" theme="simple" maxlength="100">
                                <s:fielderror fieldName="uploadDoc" theme="igr" cssClass="smallErrorMsg" />
                            </s:file>
                        </td>
                        <!-- <td class="tdLabel">&nbsp;</td>
                        <td class="field">&nbsp;</td> -->
                        <td class="tdLabel"><s:property value="getText('global.total_pages')" />*:</td>
                        <td class="field">
                            <s:textfield name="total_page_no" cssClass="field" required="true" theme="simple" maxlength="100"
                             pattern="[0-9]{1,}" title="Only Digit 0-9"  placeholder="PDF की संख्या प्रविष्टि कीजिये">
                                <s:fielderror fieldName="total_page_no" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                    </tr>
                    <tr>
                    	<th class="field" colspan=4 style="color:red;text-align:left;">
                    		नोट :- अपलोड किये जाने वाले pdf के पेजों की संख्या सम संख्या होनी चाहिय !<br />
                    		Note :- Number of pdf pages to upload should be even number
                    		<!--नोट: - कृपया इनपुट पेज की गिनती जो अपलोड की हुई पीडीएफ फाइल के पेज काउंट के बराबर होनी चाहिए। <br />
                    		Note:- Please Input page count which should be equal to Page count of Uploaded PDF file.-->
                    	</th>
                    </tr>
			</table>
			</s:if>
			
			<div align="center" id="oldDeed">
			</div>
		
			<div align="center" style="height: 200px; overflow-x: hidden" id="results">
			</div>
			
<s:hidden name="property_permission" id="property_permission" />	
<s:hidden name="t_cp_permission" id="t_cp_permission" />	
<s:hidden name="rda_permission" id="rda_permission" />	

<%-- <s:hidden name="total_page_no" id="total_page_no" cssClass="shortfieldrowwise" required="true" theme="simple" maxlength="5" /> --%>

 <s:hidden name="language" id="language"/>	
 <s:hidden name="firstTokenDate" id="firstTokenDate"/>			
<s:hidden name="rowNumber" id="rownumber"/>
<s:hidden name="party_type" id="party_type"/>
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
<s:hidden name="dummyTotalStampValue" id="dummyTotalStampValue"/>

<s:hidden name="dummyAa_rent" id="dummyAa_rent"/>
<s:hidden name="dummyPremium_amount" id="dummyPremium_amount"/>
<s:hidden name="dummyCost_of_building" id="dummyCost_of_building"/>
<s:hidden name="dummytcppermission" id="dummytcppermission"/>
<s:hidden name="dummypropertypermission" id="dummypropertypermission"/>
<s:hidden name="dummyrdapermission" id="dummyrdapermission"/>




			<div align="center">
				<s:if test="printFlag!=true">
				<s:submit method="addSecondToken" cssClass="button" value="Submit" theme="simple" />
				</s:if>
					
			<s:if test="dummyNavigationFlag==true">
					<s:if test="printFlag==true">
				
				<s:url action="PropertyDetailEntryAction.action" var="secondToken">
				
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
											<s:property value="total_stamp_value" />
										</s:param>
										
										
										<s:param name="dummyOriginalDeedTotalPageNo">
											<s:property value="dummyOriginalDeedTotalPageNo" />
										</s:param>
										
										<s:param name="dummyTotalStampValue">
											<s:property value="dummyTotalStampValue" />
										</s:param>
										
										
										<s:param name="dummyAa_rent">
											<s:property value="dummyAa_rent" />
										</s:param>
										
										
										<s:param name="dummyPremium_amount">
											<s:property value="dummyPremium_amount" />
										</s:param>
										
										<s:param name="dummyCost_of_building">
											<s:property value="dummyCost_of_building" />
										</s:param>
										
										
										
										
										<s:param name="tcp_permission">
											<s:property value="dummytcppermission" />
										</s:param>
										
										
										<s:param name="property_permission">
											<s:property value="dummypropertypermission" />
										</s:param>
										
										<s:param name="rda_permission">
											<s:property value="dummyrdapermission" />
										</s:param>
										
										
										
										
										<s:param name="dummyCallNature">true</s:param>
										
									
										
										
										
				</s:url>
				
				<s:a href="%{secondToken}">
				<input type="button" name="Next" value="Next" class="button">			
				</s:a>
				</s:if>
			</s:if>
					
						<s:if test="dummyNavigationFlag==false">		
					<s:if test="printFlag==true">
				
				<s:url action="PartyDetailEntryAction.action" var="partyToken">
				
										<s:param name="token_no">
											<s:property value="dummyTokenNo" />
										</s:param>
										
										<s:param name="dsr_location">
											<s:property value="dummyDsrLocation" />
										</s:param>	
										
										<s:param name="districtID">
											<s:property value="dummyDistrictID" />
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
										
											<s:param name="dummyAa_rent">
											<s:property value="dummyAa_rent" />
										</s:param>
										
										
										<s:param name="dummyPremium_amount">
											<s:property value="dummyPremium_amount" />
										</s:param>
										
										<s:param name="dummyCost_of_building">
											<s:property value="dummyCost_of_building" />
										</s:param>
										
										<s:param name="tcp_permission">
											<s:property value="dummytcppermission" />
										</s:param>
										
										<s:param name="property_permission">
											<s:property value="dummypropertypermission" />
										</s:param>
										
										<s:param name="rda_permission">
											<s:property value="dummyrdapermission" />
										</s:param>
										
										<s:param name="dummyCallNature">true</s:param>
										
										
				</s:url>
				
				<s:a href="%{partyToken}">
				<input type="button" name="Next" value="Next" class="button">			
				</s:a>
				</s:if>
			</s:if>		
					
				
					
					
				<input type="button" name="Back" value="Back" class="button"
					onClick="window.location.href='SearchFirstTokenforSecondToken.action';">		
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitSecondToken';">
				
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">

window.history.forward(0);


function loadDSRLocation(value){
    //alert("loadDSRLocation="+value);
    try{
        var formInput= 'district_id='+value+"&language="+document.getElementById("language").value;  
        var options='';   
          $("#dsr_location").html(options);  
          $.getJSON('loadDSRLocation.action', formInput,function(data) {
            options = '<option selected value="">Select</option>';
            //alert(options);
            $.each(data.dsrLocationList, function(i,item){
                //alert("item.typeDesc="+item.typeDesc);
                options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
            });  

            $("#dsr_location").html(options);   
        }); 

    }  catch(Exception){
        alert("Error" + Exception);
    }
}

$("#tcp_div_1").hide();
$("#tcp_div_2").hide();
$("#pro_div_1").hide();
$("#pro_div_2").hide();
$("#rda_div_1").hide();
$("#rda_div_2").hide();


function tcpYesFunction(tcpValue){
	
	
	if(tcpValue == 'global_deed_type_1'){
		alert("टाउन एंड कंट्री प्लानिंग  द्वारा निर्गत मेमो का पत्रांक एवं दिनाक प्रविष्ट करें तथा नक्सा एवं पत्रांक अपलोड करें !");
		$("#tcp_div_1").show();
		$("#tcp_div_2").show();
		$("#pro_div_1").hide();
		$("#pro_div_2").hide();
		$("#rda_div_1").hide();
		$("#rda_div_2").hide();
		document.getElementById("t_cp_permission").value='true';
		document.getElementById("property_permission").value='false';
		document.getElementById("rda_permission").value='false';
		
	}else if(tcpValue == 'global_deed_type_2'){
		$("#tcp_div_1").hide();
		$("#tcp_div_2").hide();
		$("#pro_div_1").show();
		$("#pro_div_2").show();
		$("#rda_div_1").hide();
		$("#rda_div_2").hide();
		document.getElementById("t_cp_permission").value='false';
		document.getElementById("property_permission").value='true';
		document.getElementById("rda_permission").value='false';
	}
	else if(tcpValue == 'global_deed_type_4'){
		$("#tcp_div_1").hide();
		$("#tcp_div_2").hide();
		$("#pro_div_1").hide();
		$("#pro_div_2").hide();
		$("#rda_div_1").show();
		$("#rda_div_2").show();
		document.getElementById("t_cp_permission").value='false';
		document.getElementById("property_permission").value='false';
		document.getElementById("rda_permission").value='true';
	}
	
	else
		{
		$("#tcp_div_1").hide();
		$("#tcp_div_2").hide();
		$("#pro_div_1").hide();
		$("#pro_div_2").hide();
		$("#rda_div_1").hide();
		$("#rda_div_2").hide();
		document.getElementById("t_cp_permission").value='false';
		document.getElementById("property_permission").value='false';
		document.getElementById("rda_permission").value='false';
		}
}


function showOldDeed(deedTypeID){
	var options= ' ';
	if(deedTypeID=='201')
		{
		 options='<table id="oldDeed" class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">';       
		 options+= '<caption class="formBlockCaption">Old Registration Details</caption>';
		 options+='<tr><td class="tdLabel" align="center"><s:property value="getText('global.deed_no')" />:</td>';
		 options+='<td class="field"><input type="text" name="old_deed_no" id="old_deed_no" maxlength="10" class="field"></td>';
		 options+='<td class="tdLabel" align="center"><s:property value="getText('global.date')" />:</td>';
		 options+='<td class="field"><input type="text" name="old_deed_date" id="old_deed_date" maxlength="10" class="field"></td></tr>';
		 options+='<tr><td class="tdLabel" align="center"><s:property value="getText('global.registration_fee')" />:</td>';
		 options+='<td class="field"><input type="text" name="old_registration_fee" id="old_registration_fee" maxlength="10" class="field"></td>';
		 options+='<td class="tdLabel" align="center"><s:property value="getText('global.receipt_no')" />:</td>';
		 options+='<td class="field"><input type="text" name="old_receipt_no" id="old_receipt_no" maxlength="10" class="field"></td></tr>';
		 options+='<tr><td class="tdLabel" align="center"><s:property value="getText('global.Stamp_Value')" />:</td>';
		 options+='<td class="field"><input type="text" name="old_stamp_fee" id="old_stamp_fee" maxlength="10" class="field"></td></tr';
		 options+='</table>';
		}

	$("#oldDeed").html(options);
	}

	function setValue(noOfPages) {
		
	var formInput = 'stamp_pages_no='+ noOfPages.value;
	var options= ' ';

	//alert(document.getElementById("stamp_type").value);
	
	if((document.getElementById("stamp_type").value=='global-estamp')||(document.getElementById("stamp_type").value=='global-estamp-treasurystamp'))
		{
		
	if((!isNaN(noOfPages.value))&&(noOfPages.value>0)){

		$.getJSON('loadStampNoValue.action', formInput, function(data) {
			if(data.rowNumber>0){
            options='<table id="stampNoValue" class="shortAppFormBlock" align="center" cellspacing="2px" cellpadding="1px">';       
			options+='<caption class="formBlockCaption">e-Stamp No and e-Stamp Value</caption>';
			options+='<tr><td class="tdLabel" align="center"><s:property value="getText('global.stamp_no')" />:</td><td class="tdLabel" align="center"><s:property value="getText('global.stamp_value')" />:</td><td class="tdLabel" align="center"><s:property value="getText('global.Stamp_Date')" />:</td></tr>';		
			
			
			for(var i=0;i<data.rowNumber;i++)
				{
				options+='<tr><td><input type="text" name="stamp_no" id="stamp_no" maxlength="25" class="field" onblur="javascript:this.value=this.value.toUpperCase();"></td>';
				options+='<td><input type="text" name="stamp_value" id="stamp_value" maxlength="10" class="field"></td>';
				options+='<td><input type="text" name="stamp_date" id="stamp_date" maxlength="10" class="field"></td></tr>';
				}
			}
			 document.getElementById("rownumber").value=data.rowNumber;
			 options+='</table>';
			$("#results").html(options);
			});
        
        
	}
	else{
		$("#results").html(options);
		}
	
		}
	else if(document.getElementById("stamp_type").value=='global-treasurystamp')
		{
		$("#results").html(options);
		document.getElementById("stamp_pages_no").value='';
		document.getElementById("stamp_pages_no").readOnly=true;
		document.getElementById("stamp_pages_no").className="shortfieldrowwise readOnlyField";
		}

	/*else if(document.getElementById("stamp_type").value=='global-chalan'){

		if((!isNaN(noOfPages.value))&&(noOfPages.value>0)){

			$.getJSON('loadStampNoValue.action', formInput, function(data) {
				if(data.rowNumber>0){
		            options='<table id="stampNoValue" class="shortAppFormBlock" align="center" cellspacing="2px" cellpadding="1px">';       
					options+= '<caption class="formBlockCaption">Chalan No and Value</caption>';
					options+='<tr><td class="tdLabel" align="center"><s:property value="getText('global.chalan_no')" />:</td><td class="tdLabel" align="center"><s:property value="getText('global.chalan_value')" />:</td></tr>';		
					
					for(var i=0;i<data.rowNumber;i++ ){
						options+='<tr><td><input type="text" name="chalan_no" id="chalan_no" maxlength="25" class="field" onblur="javascript:this.value=this.value.toUpperCase();"></td>';
						options+='<td><input type="text" name="chalan_value" id="chalan_value" maxlength="10" class="field"></td>';;
					}
				}
				document.getElementById("rownumber").value=data.rowNumber;
				options+='</table>';
				$("#results").html(options);
			});
	        
		}
		else{
			$("#results").html(options);
		}
		document.getElementById("stamp_pages_no").value='';
		document.getElementById("stamp_pages_no").readOnly=true;
		document.getElementById("stamp_pages_no").className="shortfieldrowwise readOnlyField";
		}*/
	
	else if((document.getElementById("stamp_type").value=='global-eChalan'))
	{
		
		if((!isNaN(noOfPages.value))&&(noOfPages.value>0)){

			$.getJSON('loadStampNoValue.action', formInput, function(data) {
				if(data.rowNumber>0){
	            options='<table id="stampNoValue" class="shortAppFormBlock" align="center" cellspacing="2px" cellpadding="1px">';       
				options+= '<caption class="formBlockCaption">e-Chalan</caption>';
				options+='<tr><td class="tdLabel" align="center">e-Chalan No:</td><td class="tdLabel" align="center">e-Chalan Amount:</td><td class="tdLabel" align="center">e-Chalan Date:</td></tr>';		

				for(var i=0;i<data.rowNumber;i++ )
					{
					options+='<tr><td><input type="text" name="stamp_no" id="stamp_no" maxlength="25" class="field" onblur="javascript:this.value=this.value.toUpperCase();"></td>';
					options+='<td><input type="text" name="stamp_value" id="stamp_value" maxlength="10" class="field"></td>';
					options+='<td><input type="text" name="stamp_date" id="stamp_date" maxlength="10" class="field"></td></tr>';
					}
				}
				 document.getElementById("rownumber").value=data.rowNumber;
				 options+='</table>';
				$("#results").html(options);
				});
	        
	        
		}
	}

	/*else if(document.getElementById("stamp_type").value=='global-eChalanWeb'){
		
		//alert("");
		var btn = confirm("If you are Pay Online,\nPress Ok ");
		//alert("Button Value="+btn);
		if(btn == true){
			options="<table id='stampNoValue' class='shortAppFormBlock' align='center' cellspacing='2px' cellpadding='1px'>";
			options+='<tr><td class="tdLabel" align="center" colspan=2><s:property value="getText('global.eChalanWeb')" /></td></tr>';
			options+='<tr><td class="tdLabel" align="center"><s:property value="getText('global.eChalanAmount')" /></td><td><input type="text" name="eChallanAmount" id="eChallanAmount" /></td></tr>';
			options+='<tr><td><input type="text" name="userid" id="userid" value="userid" /></td><td><input type="text" name="usrname" id="usrname" value="usrname" /></td></tr>';
			options+='<tr><td><input type="text" name="name" id="name" value="name" /></td><td><input type="text" name="dept" id="dept" value="05" /></td></tr>';
			options+='<tr><td><input type="text" name="major_head" id="major_head" value="0030" /></td><td><input type="text" name="submajor_head" id="submajor_head" value="02" /></td></tr>';
			options+='<tr><td><input type="text" name="minor_head" id="minor_head" value="102" /></td><td><input type="text" name="submajor_head" id="submajor_head" value="02" /></td></tr>';
			options+='<tr><td><input type="text" name="sub_head" id="sub_head" value="0032" /></td><td><input type="text" name="add_line1" id="add_line1" value="add_line1" /></td></tr>';
			options+='<tr><td><input type="text" name="add_line2" id="add_line2" value="add_line2" /></td><td><input type="text" name="add_line3" id="add_line3" value="add_line3" /></td></tr>';
			options+='<tr><td><input type="text" name="add_line4" id="add_line4" value="add_line4" /></td><td><input type="text" name="dist_add" id="dist_add" value="dist_add" /></td></tr>';
			options+='<tr><td><input type="text" name="state" id="state" value="CG" /></td><td><input type="text" name="pincode" id="pincode" value="492001" /></td></tr>';
			options+='<tr><td><input type="text" name="email" id="email" value="dushyantsahu31@gmail.com" /></td><td><input type="text" name="ph_no" id="ph_no" value="9907948015" /></td></tr>';
			options+="</table>";
		}else{
			
		}
		/*if((!isNaN(noOfPages.value))&&(noOfPages.value>0)){

			$.getJSON('loadStampNoValue.action', formInput, function(data) {
				if(data.rowNumber>0){
		            options='<table id="stampNoValue" class="shortAppFormBlock" align="center" cellspacing="2px" cellpadding="1px">';       
					options+= '<caption class="formBlockCaption">Chalan No and Value</caption>';
					options+='<tr><td class="tdLabel" align="center"><s:property value="getText('global.chalan_no')" />:</td><td class="tdLabel" align="center"><s:property value="getText('global.chalan_value')" />:</td></tr>';		

					//for(var i=0;i<data.rowNumber;i++ ){
					for(var i=0;i<data.rowNumber;i++){
						options+='<tr><td><input type="text" name="chalan_no" id="chalan_no" maxlength="25" class="field" onblur="javascript:this.value=this.value.toUpperCase();"></td>';
						options+='<td><input type="text" name="chalan_value" id="chalan_value" maxlength="10" class="field"></td>';;
					}
				}
				document.getElementById("rownumber").value=data.rowNumber;
				options+='</table>';
				$("#results").html(options);
			});
	        
		}
		else{
			$("#results").html(options);
		}*
		
		$("#results").html(options);
		document.getElementById("stamp_pages_no").value='';
		document.getElementById("stamp_pages_no").readOnly=true;
		document.getElementById("stamp_pages_no").className="shortfieldrowwise readOnlyField";
		}
		*/
	}




		document.getElementById("stamp_pages_hed").style.display="none";
		document.getElementById("stamp_pages_txt").style.display="none";

		document.getElementById("treasury_stamp_page_hed").style.display="none";
		document.getElementById("treasury_stamp_page_txt").style.display="none";

		document.getElementById("chalan_page_hed").style.display="none";
		document.getElementById("chalan_page_txt").style.display="none";


	function clearValue(stampType) {
		var options= ' ';
		//alert(stampType);
           if(stampType=='global-treasurystamp'){
   			document.getElementById("stamp_pages_no").value='';
			document.getElementById("stamp_pages_no").readOnly=true;
			document.getElementById("stamp_pages_no").className="shortfieldrowwise readOnlyField";
			
			document.getElementById("chalan_page_no").value='';
			document.getElementById("chalan_page_no").readOnly=true;
			document.getElementById("chalan_page_no").className="shortfieldrowwise readOnlyField";
			
			document.getElementById("treasury_stamp_page_no").value='';
   			document.getElementById("treasury_stamp_page_no").readOnly=false;
   			document.getElementById("treasury_stamp_page_no").className="shortfieldrowwise";

   			document.getElementById("stamp_pages_hed").style.display="none";
   			document.getElementById("stamp_pages_txt").style.display="none";

   			document.getElementById("treasury_stamp_page_hed").style.display="";
   			document.getElementById("treasury_stamp_page_txt").style.display="";

   			document.getElementById("chalan_page_hed").style.display="none";
   			document.getElementById("chalan_page_txt").style.display="none";
			
			$("#results").html(options);
			}
           
           else  if(stampType=='global-estamp' || stampType=='global-eChalan' || stampType=='global-eChalanWeb'){
      	    document.getElementById("stamp_pages_no").value='';
 			document.getElementById("stamp_pages_no").readOnly=false;
 			document.getElementById("stamp_pages_no").className="shortfieldrowwise";
 			
 			document.getElementById("treasury_stamp_page_no").value='';
			document.getElementById("treasury_stamp_page_no").readOnly=true;
			document.getElementById("treasury_stamp_page_no").className="shortfieldrowwise readOnlyField";


			document.getElementById("chalan_page_no").value='';
			document.getElementById("chalan_page_no").readOnly=true;
			document.getElementById("chalan_page_no").className="shortfieldrowwise readOnlyField";

   			document.getElementById("stamp_pages_hed").style.display="";
   			document.getElementById("stamp_pages_txt").style.display="";

   			document.getElementById("treasury_stamp_page_hed").style.display="none";
   			document.getElementById("treasury_stamp_page_txt").style.display="none";

   			document.getElementById("chalan_page_hed").style.display="none";
   			document.getElementById("chalan_page_txt").style.display="none";
 			
 			 }  

           else if(stampType=='global-chalan'){
      	    document.getElementById("stamp_pages_no").value='';
 			document.getElementById("stamp_pages_no").readOnly=true;
 			document.getElementById("stamp_pages_no").className="shortfieldrowwise readOnlyField";
 			
 			document.getElementById("treasury_stamp_page_no").value='';
			document.getElementById("treasury_stamp_page_no").readOnly=true;
			document.getElementById("treasury_stamp_page_no").className="shortfieldrowwise readOnlyField";


			document.getElementById("chalan_page_no").value='';
			document.getElementById("chalan_page_no").readOnly=false;
			document.getElementById("chalan_page_no").className="shortfieldrowwise";

   			document.getElementById("stamp_pages_hed").style.display="none";
   			document.getElementById("stamp_pages_txt").style.display="none";

   			document.getElementById("treasury_stamp_page_hed").style.display="none";
   			document.getElementById("treasury_stamp_page_txt").style.display="none";

   			document.getElementById("chalan_page_hed").style.display="";
   			document.getElementById("chalan_page_txt").style.display="";
 			
 			 }  
           
			 	
           
           else{
        	document.getElementById("stamp_pages_no").value='';
   			document.getElementById("stamp_pages_no").readOnly=false;
   			document.getElementById("stamp_pages_no").className="shortfieldrowwise";
   			
   			document.getElementById("treasury_stamp_page_no").value='';
   			document.getElementById("treasury_stamp_page_no").readOnly=false;
   			document.getElementById("treasury_stamp_page_no").className="shortfieldrowwise";


   			document.getElementById("chalan_page_no").value='';
			document.getElementById("chalan_page_no").readOnly=true;
			document.getElementById("chalan_page_no").className="shortfieldrowwise readOnlyField";

   			document.getElementById("stamp_pages_hed").style.display="";
   			document.getElementById("stamp_pages_txt").style.display="";

   			document.getElementById("treasury_stamp_page_hed").style.display="";
   			document.getElementById("treasury_stamp_page_txt").style.display="";

   			document.getElementById("chalan_page_hed").style.display="none";
   			document.getElementById("chalan_page_txt").style.display="none";
   			
   			 }  		
			}

	//loadDeedCategory();
	function loadDeedCategory(value){
	//function loadDeedCategory(){
		//alert("loadDeedCategory()");
		  try{
			  
			  
		    var formInput= 'deed_type_id='+value+"&language="+document.getElementById("language").value;  
		    var options='';   
		      $("#deed_category").html(options);  
		      $.getJSON('loadCategory.action', formInput,function(data) {
		    	options = '<option selected value="">Select</option>';
		    	$.each(data.deedCategoryList, function(i,item){
		    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
		        });  
		          
		        $("#deed_category").html(options);   
		    }); 
		      
		     var deedNumber=value.split("-");
		     
		     //var deedNumber = document.getElementById("deed_type_id").value;
		     //alert("deedNumber="+deedNumber);
		     if((deedNumber[0]=="74")||(deedNumber[0]=="153")){
			 //if((deedNumber=="74")||(deedNumber=="153")){
		    	    document.getElementById("considered_amount").value='0';
					document.getElementById("considered_amount").readOnly=true;
					document.getElementById("considered_amount").className="field readOnlyField";
		    	 
					
					document.getElementById("dealing_amount").value='0';
					document.getElementById("dealing_amount").readOnly=true;
					document.getElementById("dealing_amount").className="field readOnlyField";
					
					
					document.getElementById("paid_amount").value='0';
					document.getElementById("paid_amount").readOnly=true;
					document.getElementById("paid_amount").className="field readOnlyField";
					
					
					document.getElementById("aa_rent").value='';
		   			document.getElementById("aa_rent").readOnly=false;
		   			document.getElementById("aa_rent").className="field";
		   			
		   			
		   			document.getElementById("premium_amount").value='';
		   			document.getElementById("premium_amount").readOnly=false;
		   			document.getElementById("premium_amount").className="field";
		   			
		   			
		   			document.getElementById("cost_of_building").value='';
		   			document.getElementById("cost_of_building").readOnly=false;
		   			document.getElementById("cost_of_building").className="field";
		    	 
		    	 }
		     
		     else 
		    	 {
		    	 
		    	 
		    	    document.getElementById("aa_rent").value='0';
					document.getElementById("aa_rent").readOnly=true;
					document.getElementById("aa_rent").className="field readOnlyField";
		    	 
					
					document.getElementById("premium_amount").value='0';
					document.getElementById("premium_amount").readOnly=true;
					document.getElementById("premium_amount").className="field readOnlyField";
					
					
					document.getElementById("cost_of_building").value='0';
					document.getElementById("cost_of_building").readOnly=true;
					document.getElementById("cost_of_building").className="field readOnlyField";
					
					
					document.getElementById("paid_amount").value='';
		   			document.getElementById("paid_amount").readOnly=false;
		   			document.getElementById("paid_amount").className="field";
		   			
		   			
		   			document.getElementById("considered_amount").value='';
		   			document.getElementById("considered_amount").readOnly=false;
		   			document.getElementById("considered_amount").className="field";
		   			
		   			
		   			document.getElementById("dealing_amount").value='';
		   			document.getElementById("dealing_amount").readOnly=false;
		   			document.getElementById("dealing_amount").className="field";
		    	 
		    	 }
		      
		  }
		  catch(Exception)
		  {
			  alert("Error" + Exception);
		  }
		
		
	}	
</script>	
</html>
<%@include file="../commonJsp/footer.inc"%>
