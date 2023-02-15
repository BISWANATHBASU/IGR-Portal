<%@page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporter"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporterParameter"%>
<%@include file="../commonJsp/header2.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>

<body oncontextmenu="return false;">
	<s:form action="DeedDetailSignatureAction" validate="true" namespace="/"
		method="post">
		<s:token />

<% 
	
JRHtmlExporter exporter = new JRHtmlExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, request.getAttribute("reportBody"));
exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);  
exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);  
exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD, Boolean.TRUE);  
exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image/");
exporter.exportReport();
%>


<br>
<br>

<div align="center">
			
					
					
						<input type="button" name="Verified" value="Verified" class="button"
					onClick="OpenFeeUpdate()"> 
					
					
				<%-- 	<s:submit method="signatureDeed" cssClass="button" value="Verified"
					theme="simple" /> --%>
					
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitDeedDetailSignature';">
								
			</div>
			  <s:hidden name="token_no" id="token_no" />
	        <s:hidden name="token_date" id="token_date" />
	         <s:hidden name="reportTokenDate" id="reportTokenDate" />
            <s:hidden name="dsr_location" id="dsr_location" />
            <s:hidden name="reportTokenDate" id="reportTokenDate" />
			
		
            
          
</s:form>
</body>
</html>
<%@include file="../commonJsp/footer.inc"%>

<script>

function OpenFeeUpdate() {

	

	var options = '';
	try {
		var formInput = 'token_no='
				+ document.getElementById("token_no").value
				+ '&token_date='
				+ document.getElementById("token_date").value
				+'&dsr_location='
				+ document.getElementById("dsr_location").value;
	        
		$
				.getJSON(
						'signatureDeed.action',
						formInput,
						function(data) {
							alert(data.responseData);
							//window.location.href = "exitSecondToken.action?actionmessage=Data Varified, Please Submit Document in Concern Office";
							window.location.href = "exitSecondToken.action?actionmessage=आपके द्वारा दस्तावेज के पंजीयन हेतु उपलब्ध कराये गये दस्ताबेज और जानकारी तथा  आवेदन सम्बंधित कार्यालय में बाज़ार मूल्य, शुल्क की गणना तथा जाँच हतु भेजा गया";
							
						});
	
		
	}

	catch (Exception) {
		alert("Error" + Exception);
	}

}

</script>
