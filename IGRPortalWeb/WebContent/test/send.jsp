<%@page import="java.util.Date"%>
<!--%@page import="Encryption.AESEncrypt"%>
%@page import="Encryption.ChecksumMD5"%-->
<%-- <%@include file="../commonJsp/header.jsp"%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <s:head theme="igr" />
<sx:head />
</head> --%>
<body oncontextmenu="return false;">

<%
/*
System.out.println(request.getParameter("token_date"));
String registrationFee=request.getParameter("registrationFee");
String ref_no=request.getParameter("token_no");
String dsr_location=request.getParameter("dsr_location");
String tran_datetime=new java.util.Date().toString();
String token_date=request.getParameter("token_date");

String req_param="";
req_param="ref_no=T1012222"+"|amount=1"+"|dsr_location=40"+"|token_date="+(new Date())+"|tran_datetime="+(new Date())+"|sp_fees=0|redirect_url=https://www.epanjeeyan.cg.gov.in/IGRPortalWeb/test/receive.jsp|epanjiyan_id=1|eregistration_fees="+1+"|other_fees=0";
ChecksumMD5 checksum=new ChecksumMD5();
String ceckSumValue=checksum.getValue(req_param);
req_param=req_param+"|checkSum="+ceckSumValue;
AESEncrypt encrpt=new Encryption.AESEncrypt();
String path=application.getRealPath("/key/CG_LAND.key");
encrpt.setSecretKey(path);
System.out.println("Request param:"+req_param);
String encElement = encrpt.encryptFile(req_param);
System.out.println("Encrypted Param:"+encElement);
*/
%>

	<div align="center" class="formCaption">Fee Final</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
		<tr>
		<td class="tdLabel"><%-- <s:property
							value="getText('global.Token_No')" /> --%>Token No*:</td>
					<td class="field">%=ref_no%></td>
		</tr>
				<tr>
					<td class="tdLabel"><%-- <s:property
							value="getText('global.registration_fee')" /> --%>Amount Payable(Regitration fee only)*:</td>
					<td class="field">%=registrationFee %></td>
			</table>
			<div align="center">
			<form action="https://merchant.onlinesbi.com/merchant/merchantprelogin.htm" method="post">
			<input type="hidden" value="%=encElement %>" name="encdata">
				<input type="hidden" name="merchant_code" value="CG_LAND">
			<input type="submit" value="Confirm" class="button">
			<input type="button"
					name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitPayment';">
			</form>
					
					
					
					
				
				
			</div>
		</div>


		
</body>



</html>
<%@include file="../commonJsp/footer.inc"%>
