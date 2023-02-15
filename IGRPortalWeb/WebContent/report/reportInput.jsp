<%@include file="../commonJsp/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>रिपोर्ट</title>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr"/>
</head>
<body oncontextmenu="return false;">
<s:form action="InitiateReportAction" validate="true" namespace="/" method ="post" >  

<div align="center" class="formCaption">Initiate Report</div>



<div align="center">
<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px" width="100%">
<s:actionerror/>
<s:actionmessage/>
<caption class="formBlockCaption"><s:property value="heading"/></caption>

<s:if test="%{event=='CHECKSLIP'}">
<tr>
<td class="tdLabel" align="left">Token Date<br>(dd/MM/yyyy):</td>
					<td><s:textfield id="tokenDate" name="tokenDate" 
							cssClass="mediumField" theme="simple" maxlength="10" placeholder="दिनांक प्रविष्ट करें">
						</s:textfield></td>
						
<td class="tdLabel" align="right">Application No.<br>:</td>
					<td><s:textfield id="tokenNo" name="tokenNo" placeholder="एप्लीकेशन न. प्रविष्ट करें"
							cssClass="field" theme="simple" maxlength="17">
						</s:textfield></td>
						
</tr>
</s:if>


</table>

<br>
  <br>
<div align="center">
 <%-- <input type="button" class="button" name="Show" value="Show" onclick="openReport('ReportAction.action?reportPath=<s:property value="reportPath"/>&reportName=<s:property value="reportName"/>')"/> --%>
 <input type="button" class="button" name="Show" value="Show" onclick="openReport('ReportAction.action?reportName=<s:property value="reportName"/>')"/>
 <s:submit method="exitReport" cssClass="button" value="Exit"  theme="simple"/>
</div>

</div>
<s:hidden name="heading" />
<s:hidden name="reportPath" />
<s:hidden name="reportName" />
<s:hidden name="event" id="eventID" />
</s:form>
</body>
<script>
function openReport(targetString) {
	
	
	 if(document.getElementById("eventID").value=='NOEVENT' ){
		 targetString+="&DOWNLOAD=N";
		 window.open(targetString,"","width=700, height=600,menubar=yes,location=1,status=1,scrollbars=yes,resizable=yes");
		}
	
	 else if(document.getElementById("eventID").value=='CHECKSLIP' ){
		 targetString+="&DOWNLOAD=N&token_no="+document.getElementById("tokenNo").value+"&token_date="+document.getElementById("tokenDate").value+"&token_date="+document.getElementById("tokenDate").value;
		 window.open(targetString,"","width=700, height=600,menubar=yes,location=1,status=1,scrollbars=yes,resizable=yes");
		}



}
</script>
</html>
<%@include file="../commonJsp/footer.inc"%>
