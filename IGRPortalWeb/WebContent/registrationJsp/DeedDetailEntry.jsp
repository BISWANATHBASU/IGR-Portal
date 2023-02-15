<%@page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporter"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporterParameter"%>
<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>विलेख विवरणी</title>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:head theme="igr" />
<sx:head />

        <script type="text/javascript">
            $(function() {
                $('#app_date1').datepick({
                	dateFormat:'yyyy-mm-dd',
                	minDate: new Date()
                });
            });
        </script>
</head>
<body oncontextmenu="return false;">

<%
/* 
JRHtmlExporter exporter = new JRHtmlExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, request.getAttribute("reportBody"));
exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);  
exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);  
exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD, Boolean.TRUE);  
exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image/");
exporter.exportReport();
 */
%>

	<br />
	<div id="workProgress">
		<ul>
			<li class="doneWind"><a href="#">प्रस्तुति विवरणी&#10004;</a></li>
			<li class="doneWind"><a href="#">स्टाम्प विवरणी&#10004;</a></li>
			<li class="doneWind"><a href="#">सम्पत्ति का विवरण &#10004;</a></li>
			<li class="doneWind"><a href="#">संरचना का विवरण &#10004;</a></li>
			<li class="doneWind"><a href="#">पक्षकार का प्रकार &#10004;</a></li>
			
			<li class="workingWind"><a href="#">विलेख का विवरण &#9998;</a></li>
			
			<li class="waitingWind"><a href="#">अपॉइंटमेंट/ शुल्क &#10006;</a></li>
			<li class="waitingWind"><a href="#">पुनः अपॉइंटमेंट &#10006;</a></li>
		</ul>
	</div>
	<s:form action="addDeedDetail" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption">
			<!-- विलेख विवरण -->
			<s:if test="printFlag!=true"><s:property value="getText('global.deed_detail_head')" /></s:if>
			<s:if test="printFlag==true"><s:property value="getText('global.deed_detail_head_success')" /></s:if>
		</div>

		<div align="center">
		
			<s:if test="printFlag!=true">
			<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />


				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Token_No')" />*:</td>
					<td class="field"><s:textfield name="token_no" id="token_no"
							cssClass="readOnlyField" readonly="true"
							theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="token_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


					<td class="tdLabel"><s:property value="getText('global.name')" />*:</td>
					<td class="field"><s:textfield name="presenter_name"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" placeholder="पक्षकार का नाम" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="presenter_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.first_party_name')" />*:</td>
					<td class="field"><s:textfield
							name="first_party_executant_name" 
							cssClass="field readOnlyField" readonly="true"
							theme="simple" maxlength="20" placeholder="प्रथम  पक्षकार का नाम प्रविष्टि करें"
							onblur="javascript:this.value=this.value.toUpperCase();" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="first_party_executant_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><s:property
							value="getText('global.first_capacity')" />*:</td>
					<td class="field"><s:select  headerValue="Select"
							list="firstPartyCapacityList" listKey="typeCode"
							listValue="typeDesc" name="first_party_executant_capacity"
							cssClass="largecombobox readOnlyField" theme="simple" editable="false" /> <s:fielderror
							fieldName="first_party_executant_capacity" theme="igr"
							cssClass="smallErrorMsg" /></td>
				</tr>
				<tr>
								<!--tr>
					<td class="tdLabel">s:property
							value="getText('global.district')" />*:</td>
					<td>s:select list="districtList" listKey="typeCode"
							listValue="typeDesc" name="district_id" cssClass="combobox readOnlyField"
							theme="simple" required="true" onchange="loadDSRLocation(this.value);" /> s:fielderror
							fieldName="district_id" theme="igr" cssClass="smallErrorMsg" />
					</td>

					<td class="tdLabel">s:property
							value="getText('global.sub_register_office')" />*:</td>
					<td>s:select list="dsrLocationList" listKey="typeCode"
							listValue="typeDesc" name="dsr_location" id="dsr_location" cssClass="combobox readOnlyField"
							theme="simple" required="true" /> s:fielderror
							fieldName="dsr_location" theme="igr" cssClass="smallErrorMsg" />
					</td>
				</tr-->
				<tr>
			
				<td class="tdLabel"><s:property
							value="getText('global.Deed_Type_Name')" />*:</td>
					<td class="field"><s:select 
							list="deedTypeList" listKey="typeCode" 
							listValue="typeDesc" name="deed_type_id" cssClass="combobox readOnlyField"
							theme="simple" required="true"  style="background-color: #C0C0C0;"/> <s:fielderror
							fieldName="deed_type_id" theme="igr" cssClass="smallErrorMsg" /></td>		
			
			
				<td class="tdLabel"><s:property
							value="getText('global.Deed_Category')" />*:</td>
					<td class="field"><s:select 
							list="deedCategoryList" listKey="typeCode" 
							listValue="typeDesc" name="deed_category_id" cssClass="combobox readOnlyField"
							theme="simple" required="true" style="background-color: #C0C0C0;" /> <s:fielderror
							fieldName="deed_category_id" theme="igr" cssClass="smallErrorMsg" /></td>		
							
				
				</tr>
				
				<tr>
				<td class="tdLabel"><s:property value="getText('global.considered_amount')" />*:</td>
					<td class="field"><s:textfield name="considered_amount" id="considered_amount"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" placeholder="विलेख में अंकित मूल्य प्रविष्टि करें" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="considered_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
					
					
					
					<td class="tdLabel"><s:property value="getText('global.doc_min_amount')" />*:</td>
					<td class="field"><s:textfield name="doc_min_amount" id="maximumValuation"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" placeholder="दस्तावेज की देय मूल्य प्रविष्टि करें" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="doc_min_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
					
					
					
					
					
				
			
				</tr>
				
				
				<tr>
				
				
					<td class="tdLabel"><s:property value="getText('global.applicable_stamp_value')" />*:</td>
					<td class="field"><s:textfield name="applicable_stamp_value" id="applicable_stamp_value"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" placeholder="देय मुद्रांक शुल्क  तदनुसार प्रविष्टि करें" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="applicable_stamp_value" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				
				<td class="tdLabel"><s:property value="getText('global.presented_stamp_value')" />*:</td>
					<td class="field"><s:textfield name="presented_stamp_value"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" placeholder="संलग्न स्टाम्प मूल्य प्रविष्टि करें" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="presented_stamp_value" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>		
				
				
				
				
				</tr>
				
				
				<tr>
				
				
				<td class="tdLabel"><s:property value="getText('global.no_total_pages')" />*:</td>
					<td class="field"><s:textfield name="new_no_of_total_pages"
							cssClass="shortfieldrowwise" required="true" theme="simple"
							maxlength="20" placeholder="मूल दस्तावेज में कुल पृष्ठों की संख्या प्रविष्टि करें" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="new_no_of_total_pages" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				
				
				<td class="tdLabel"><s:property value="getText('global.permission_no1')" />:</td>
				<td class="field"><s:textfield name="permission_no"
						cssClass="field" placeholder="अनुमति संख्या प्रविष्टि करें"
						theme="simple" maxlength="100"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="permission_no" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield></td>
							
				</tr>
				
				
				<tr>
				
				<td class="tdLabel"><s:property value="getText('global.special_deed_detail')" />:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="specialDeedDetailList" listKey="typeCode" 
							listValue="typeDesc" name="special_deed_detail" cssClass="combobox"
							theme="simple" /> <s:fielderror
							fieldName="special_deed_detail" theme="igr" cssClass="smallErrorMsg" /></td>		
				
				
					<td class="tdLabel"><s:property value="getText('global.rel_last_reg_record')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_record"
							cssClass="field"  theme="simple" placeholder="संबंधित विगत पंजीयन की विवरणी प्रविष्टि करें"
							maxlength="20">
							<s:fielderror fieldName="rel_last_reg_record" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>		
				</tr>
				
				
				<tr>
				
				
				
				<td class="tdLabel"><s:property value="getText('global.rel_last_reg_date')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_date"
							cssClass="field"  theme="simple"
							maxlength="20" placeholder="दिनांक प्रविष्टि करें">
							<s:fielderror fieldName="rel_last_reg_date" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
						
					
					<td class="tdLabel"><s:property value="getText('global.rel_last_reg_no')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_no"
							cssClass="field"  theme="simple"
							maxlength="20" placeholder="पंजीयन संख्या प्रविष्टि करें">
							<s:fielderror fieldName="rel_last_reg_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>			
			
				</tr>
				
				
					<tr>
					
					
						
							
				
				<td class="tdLabel"><s:property value="getText('global.rel_last_reg_pow_of_atr')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_pow_of_atr"
							cssClass="field"  theme="simple"
							maxlength="20" placeholder="संबंधित विगत मुख्तारनामा विवरणी प्रविष्टि करें">
							<s:fielderror fieldName="rel_last_reg_pow_of_atr" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
						
						
					<td class="tdLabel"><s:property value="getText('global.rel_last_reg_pow_of_atr_date')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_pow_of_atr_date"
							cssClass="field"  theme="simple"
							maxlength="20" placeholder="दिनांक प्रविष्टि करें">
							<s:fielderror fieldName="rel_last_reg_pow_of_atr_date" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
							
				</tr>
				
				
				<tr>
				
				
				
				
				<td class="tdLabel"><s:property value="getText('global.rel_last_reg_pow_of_atr_reg_no')" />:</td>
					<td class="field"><s:textfield name="rel_last_reg_pow_of_atr_reg_no"
							cssClass="field" theme="simple"
							maxlength="20" placeholder="पंजीयन संख्या प्रविष्टि करें">
							<s:fielderror fieldName="rel_last_reg_pow_of_atr_reg_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
							<td class="tdLabel"> </td>
				<td class="field"> <s:hidden
							name="e_registration_code" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="22" /></td>	
						
						<!--td class="tdLabel"><s:property
							value="getText('global.e_registration_id')" />*:</td>
				<td class="field"><s:textfield
							name="e_registration_code" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="22">
							<s:fielderror fieldName="e_registration_code" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td-->	
						
								
				</tr>
				
				
				
				<!--tr>
				
				
				
				
				<td class="tdLabel"><s:property value="getText('global.app_date')" />(yyyy-mm-dd):</td>
					<td class="field"><s:textfield name="app_date1" id="app_date1"
							cssClass="field" theme="simple"
							maxlength="20">
							<s:fielderror fieldName="app_date1" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
							<td class="tdLabel"><s:property
							value="getText('global.app_time')" />(HH24:MI):</td>
				<td class="field">
				<s:textfield
							name="hhmm" cssClass="field"
						    theme="simple" maxlength="7">
							<s:fielderror fieldName="hhmm" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield>
						</td>		
						
								
				</tr-->
				<!--tr>
					<td class="tdLabel">s:property
							value="getText('global.remarks')" />:</td>
					<td colspan="3" class="field">s:textfield
							name="remarks" id="remarks" cssClass="longField"
							theme="simple" maxlength="100">
							s:fielderror fieldName="remarks" theme="igr"
								cssClass="smallErrorMsg" />
						/s:textfield></td>
				</tr-->
					
			</table>
			</s:if>
			
			
			
			<div align="center">
			<s:if test="printFlag!=true">
				<s:submit method="addDeedDetail" cssClass="button" value="Submit" theme="simple" />
			</s:if>
				
				<input type="button" name="Back" value="Back" class="button"
					onClick="window.location.href='SearchSecondTokenforPropertyEntry.action?event=DEED_DETAIL';">		
					
				<input type="button" name="Exit" value="Exit" class="button" onClick="window.location.href='exitDeedDetail';">
					<s:if test="printFlag==true">
				<!-- <input type="button" name="Print" value="Print" class="button" onClick="openReport();">	 -->
				
				
				<!-- DeedDetailEntryAction.action -->
				<s:url action="DeedDetailSignatureAction.action" var="secondToken">
				
										<s:param name="token_no">
											<s:property value="dummyTokenNo" />
										</s:param>
										
										<s:param name="token_date">
											<s:property value="dummyTokenDate" />
										</s:param>
										
										<s:param name="dsr_location">
											<s:property value="dummyDSRLocation" />
										</s:param>	
										
										<%-- <s:param name="district_id">
											<s:property value="district_id" />
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
										
										
										<s:param name="presented_stamp_value">
											<s:property value="dummyTotalStampValue" />
										</s:param> --%>
										
										<s:param name="dummyCallNature">true</s:param>
										
										
				</s:url>
				
				<s:a href="%{secondToken}">
					<input type="button" name="Next" value="Next" class="button">			
				</s:a>
				
				
				
				
				</s:if><!-- End Print And Next Button -->					
			</div>
		</div>

		
<s:hidden name="language" id="language" />
<s:hidden name="token_date" id="token_date"/>
<s:hidden name="token_time" id="token_time"/>
<s:hidden name="dummyTokenNo" id="dummyTokenNo"/>
<s:hidden name="dummyTokenDate" id="dummyTokenDate"/>
<s:hidden name="dummyDSRLocation" id="dummyDSRLocation"/>
<s:hidden name="baseFee" id="baseFee"/>
<s:hidden name="additionalFee" id="additionalFee"/>
<s:hidden name="cess" id="cess"/>
<s:hidden name="permission_no_required" id="permission_no_required"/>
<s:hidden name="no_total_pages" id="no_total_pages"/>
<s:hidden name="otherFee" id="otherFee"/>

<s:hidden name="district_id" id="district_id"/>		
<s:hidden name="dsr_location" id="dsr_location"/>	






<s:hidden name="e_registration_code" cssClass="field readOnlyField" readonly="true" theme="simple" maxlength="22" />
		
	</s:form>
</body>
<script>
window.history.forward(0);
/*
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
}*/
function openReport() {
	
	
	var targetString="ReportAction.action?reportPath=/report/IGR_CHECKSLIP.jasper&reportName=IGR_CHECKSLIP&event=NOEVENT&token_no="+document.getElementById("token_no").value+"&token_date="+document.getElementById("dummyTokenDate").value
			window.open(targetString,"","width=400, height=400,menubar=yes,location=1,status=1,scrollbars=yes,resizable=yes");
}
</script>

</html>
<%@include file="../commonJsp/footer.inc"%>
