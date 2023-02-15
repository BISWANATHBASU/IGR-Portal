<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Date Edit</title>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
	<s:form action="updateAppDate" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption"><s:property
							value="getText('global.date_edit_head')" /></div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />


								
				<tr>
				
				
				
				
				<td class="tdLabel"><s:property value="getText('global.app_date')" />(yyyy-mm-dd):</td>
					<td class="field"><s:textfield name="app_date1"
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
						
								
				</tr>
				
					
			</table>
			
			
			
			<div align="center">
				<s:submit cssClass="button" value="Submit"
					theme="simple" />
				
				<input type="button" name="Back" value="Back" class="button"
					onClick="window.location.href='SearchSecondTokenforPropertyEntry.action?event=DATE_EDIT';">		
					
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitDateEdit';">
					<%-- <s:if test="printFlag==true">
				<input type="button" name="Print" value="Print" class="button"
					onClick="openReport();">	
				</s:if> --%>					
			</div>
		</div>

		
<s:hidden name="language" id="language"/>	
<s:hidden name="empID" id="empID"/>
<s:hidden name="groupID" id="groupID"/>		
<s:hidden name="token_date" id="token_date"/>	
<s:hidden name="token_no" id="token_no"/>		
<%-- <s:hidden name="token_time" id="token_time"/>	
<s:hidden name="dummyTokenDate" id="dummyTokenDate"/>	
<s:hidden name="baseFee" id="baseFee"/>	
<s:hidden name="additionalFee" id="additionalFee"/>	
<s:hidden name="cess" id="cess"/>		
<s:hidden name="permission_no_required" id="permission_no_required"/>	

<s:hidden name="district_id" id="district_id"/>	 --%>	
<s:hidden name="dsr_location" id="dsr_location"/>	
<%-- <s:hidden name="no_total_pages" id="no_total_pages"/> --%>	
		
		
	</s:form>
</body>
<script>
window.history.forward(0);

function alert() {
	alert("Confirm");
	
	
}
</script>

</html>
<%@include file="../commonJsp/footer.inc"%>
