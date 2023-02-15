<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />

     <script type="text/javascript">
	     $(function() {
	         $('#app_date1').datepick({
	         	dateFormat:'dd/mm/yyyy',
	         	minDate: +1//new Date()
	         });
	     });
     </script>
</head>
<body oncontextmenu="return false;">
	<s:form action="addAppoimentEntry" validate="true" namespace="/" method="post">
		<s:token />

		<div align="center" class="formCaption">अपॉइंटमेंट <!--उत्पादन--></div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />
				
				<tr>
					<td class="tdLabel">प्री रजिस्ट्रेशन ID:</td>
					<td class="field"><s:property value="token_no" /></td>
				</tr>
				<!--tr>
					<td class="tdLabel">दिनांक:</td>
					<td class="field"><s:property value="token_date" /></td>
				</tr-->
				<tr>
					<td class="tdLabel"><!--s:property value="getText('global.app_date')" /-->अपॉइंटमेंट दिनांक (dd/mm/yyy):</td>
					<td class="field">
						<s:textfield name="app_date1" id="app_date1" cssClass="field" theme="simple" maxlength="20" required="true">
							<s:fielderror fieldName="app_date1" theme="igr" cssClass="smallErrorMsg" />
						</s:textfield>
					</td>
				</tr>
			</table>
			
			<s:hidden name="bookID" id="bookID" cssClass="shortfieldrowwise readOnlyField" readonly="true"
				theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="deed_name" id="deed_name" cssClass="field readOnlyField" readonly="true"
				theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="token_no" id="token_no" cssClass="field readOnlyField" readonly="true"
				theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="presenter_name" id="presenter_name" cssClass="field readOnlyField"
				readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="first_party_executant_name" id="first_party_executant_name" cssClass="field readOnlyField" readonly="true" theme="simple"
				maxlength="20" style="background-color: #C0C0C0;" onblur="javascript:this.value=this.value.toUpperCase();" />
			<s:hidden name="no_total_pages" id="no_total_pages" cssClass="shortfieldrowwise readOnlyField" readonly="true"
				theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="considered_amount" id="considered_amount" cssClass="field readOnlyField"
				readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="doc_min_amount" id="maximumValuation" cssClass="field readOnlyField"
				readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="applicable_stamp_value" readonly="true" theme="simple"
				maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="presented_stamp_value" id="presented_stamp_value" cssClass="field readOnlyField"
				readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="registrationFee" id="registrationFee" cssClass="field readOnlyField"
				readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			
			<br /><br /><br />
			
			<div align="center">
				<s:submit method="addAppoimentEntry" cssClass="button" value="Submit" theme="simple" />
				
				<!--input type="button" name="Back" value="Back" class="button" onClick="window.location.href='SearchSecondTokenforPropertyEntry.action?event=DEED_DETAIL';"-->		
					
				<input type="button" name="Exit" value="Exit" class="button" onClick="window.location.href='exitDeedDetail';">
				
				<s:if test="printFlag==true">
					<input type="button" name="Print" value="Print" class="button" onClick="openReport();">	
				</s:if>					
			</div>
		
		<br /><br /><br />
		</div>
		
		<s:hidden name="language" id="language" />
		<s:hidden name="token_date" id="token_date" />
		<s:hidden name="dummyTokenDate" id="dummyTokenDate" />
		<s:hidden name="deed_type_id" id="deed_type_id" />
		<s:hidden name="deed_category_id" id="deed_category_id" />
		<s:hidden name="check_slip_count" id="check_slip_count" />
		<s:hidden name="calculation_on" id="calculation_on" />
		<s:hidden name="reportTokenDate" id="reportTokenDate" />
		
		<s:hidden name="dsr_location" id="dsr_location" />
		
	</s:form>
</body>
<script>
window.history.forward(0);

paymentChange();
function paymentChange(){
	$("#paymentTypeId").hide();
}
function openReport() {
	
	
	var targetString="ReportAction.action?reportPath=/report/IGR_CHECKSLIP.jasper&reportName=IGR_CHECKSLIP&event=NOEVENT&token_no="+document.getElementById("token_no").value+"&token_date="+document.getElementById("dummyTokenDate").value
			window.open(targetString,"","width=400, height=400,menubar=yes,location=1,status=1,scrollbars=yes,resizable=yes");
}
</script>

</html>
<%@include file="../commonJsp/footer.inc"%>