<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.Enumeration"%>
<!--%@page import="Encryption.AESEncrypt"%>
%@page import="Encryption.ChecksumMD5"%-->
<%-- <%@include file="../commonJsp/header.jsp"%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <s:head theme="igr" />
<sx:head /> --%>
</head>
<!-- <body oncontextmenu="return false;"> -->

<%
String sbi_ref_no="";
String amount_paid="";
String token_no="";
String payment_status="";
String payment_desc="";
String token_date="";
String tran_date="";
String encData="";
String decData="";
try{
//out.println("Encrypted data:"+request.getParameter("encdata"));
encData=request.getParameter("encdata");
out.println(encData);
/*
AESEncrypt encrpt=new Encryption.AESEncrypt();
String path=application.getRealPath("/key/CG_LAND.key");
encrpt.setSecretKey(path);
decData=encrpt.decryptFile(encData);
StringTokenizer tokens=new StringTokenizer(decData, "|");
List<String> list=new ArrayList<String>();
while(tokens.hasMoreElements()){
	//System.out.println(tokens.nextToken());
	list.add(tokens.nextToken());
}

try{
if(list.size()>0){
	sbi_ref_no=(list.get(0)).split("=")[1];
}
if(list.size()>1){
	amount_paid=(list.get(1)).split("=")[1];
}
if(list.size()>2){
	token_no=(list.get(2)).split("=")[1];
}
if(list.size()>3){
	payment_status=(list.get(3)).split("=")[1];
}
if(list.size()>4){
	payment_desc=(list.get(4)).split("=")[1];
}
if(list.size()>5){
	token_date=(list.get(5)).split("=")[1];
	String pattern="MM/dd/yy";
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	Date d=sdf.parse("5/26/17");
	token_date=d.toString();
}
if(list.size()>7){
	tran_date=(list.get(7)).split("=")[1];
}

}catch(Exception e){
	out.println(e);
}*/
}catch(Exception e){
	out.println(e);
}

%>

	<div align="center" class="formCaption">Payment Status</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
		
		

				<tr>
					<td class="tdLabel">Transaction Reference No:</td>
					<td class="field">%=sbi_ref_no%></td>
				</tr>
				<tr>
					<td class="tdLabel">Token No:</td>
					<td class="field">%=token_no%></td>
				</tr>
				<tr>
					<td class="tdLabel">Amount Paid:</td>
					<td class="field">%=amount_paid%></td>
				</tr>
				<tr>
					<td class="tdLabel">Token Date:</td>
					<td class="field">%=token_date%></td>
				</tr>
				<tr>
					<td class="tdLabel">Transaction Date:</td>
					<td class="field">%=tran_date%></td>
				</tr>
				<tr>
					<td class="tdLabel" colspan=2>%=decData %></td>
					
				</tr>
<tr>

</tr>

			</table>



			<div align="center">
			
			<input type="button"
					name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitPayment';">
			
					
					
					
					
				
				
			</div>
		</div>


		
</body>



</html>
<%@include file="../commonJsp/footer.inc"%>
