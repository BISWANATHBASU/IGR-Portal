<!--%@page import="Encryption.AESEncrypt"%>
%@page import="Encryption.ChecksumMD5"%-->


<html>
<head>

<title>Insert title here</title>
</head>
<body>
<%
/*
String req_data="token_no=T6304406072017001|amount=1|redirect_url=https://www.epanjeeyan.cg.gov.in/IGRPortalWeb/test/receive_dv.jsp";
ChecksumMD5 checksum=new ChecksumMD5();
String ceckSumValue=checksum.getValue(req_data);
req_data=req_data+"|checkSum="+ceckSumValue;
AESEncrypt encrpt=new Encryption.AESEncrypt();
String path=application.getRealPath("/key/CG_LAND.key");
encrpt.setSecretKey(path);
System.out.println("Request param:"+req_data);
String encElement = encrpt.encryptFile(req_data);
System.out.println("Encrypted Param:"+encElement);
*/
%>
<form action="https://www.onlinesbi.com/thirdparties/doubleverification.htm" method="post">
			<input type="hidden" value="%=encElement %>" name="encdata">
				<input type="hidden" name="merchant_code" value="CG_LAND">
			<input type="submit" value="Confirm">
			
			</form>
</body>
</html>