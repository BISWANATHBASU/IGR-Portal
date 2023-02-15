<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Office Application Appointment</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" type="text/css" href="../css/breadcrumb.css">
	    <script src="../js/sha256.js"></script>
	    <%@include file="../commonJsp/include.jsp" %>
	    
	    <script>
		    function boxdisable(){
		    	window.location = "officeAppoiment";
		    }
	    </script>
	    
	</head>
	<body oncontextmenu="return false;">
		<div class="main">
			<div class="container_12">
				<%@include file="../commonJsp/header1.jsp" %>
				
				<div style="margin:auto;width:90%;">
				<h2 style="text-align: center;">Help Line No. 0771 491 2523/1800 233 2488</h2>
				
				<br /><br />
				<br /><br />
				
				<p style="color:black;font-size:20px;text-align:justify;line-height: 1.5;">
					आपके द्वारा चयन किया गया अपाईन्टमेंट  आईडी <s:property value="appointmentNoFinal" /> दिनांक <s:property value="appointmentDate" /> समय <s:property value="appointmentTimeFinal" />बजे सफलतापूर्वक सम्पन्न हुआ, निर्धारित अपाईन्टमेंट में नियमानुसार सम्यक रूप से स्टाम्पित मूल दस्तावेज सहित, 
					निम्नलिखित व्यक्तियो  के साथ उप पंजीयक कार्यालय <s:property value="dsrName" /> में दस्तावेज़ पंजीयन हेतु उपस्थित होवें ,<br /><br />
					
					<% int i = 1; %>
					
					<table style="color:black;text-align:left;font-size:20px; width:500px;">
						<tr><td width="30"><%=i%>.</td><td><s:property value="party_type" />  का नाम  <s:property value="fullName" /></td></tr>
						
						<s:iterator value="otherPartyList" var="tokenStructureListList">
							<% i++; %>
						<tr>
							<td><%=i%>.</td><td><s:property value="typeCode_3" />  का नाम  <s:property value="typeCode_1" /></td>
						</tr>
						</s:iterator>
					</table>
					
				</p>
				
				
		  
			    <s:if test='(appointmentNoFinal1.length() > 0)'>		
				<p style="color:black;font-size:20px;text-align:justify;line-height: 1.5;">
					आपके द्वारा चयन किया गया अपाईन्टमेंट  आईडी <s:property value="appointmentNoFinal1" /> दिनांक <s:property value="appointmentDate" /> समय <s:property value="appointmentTime1" />बजे सफलतापूर्वक सम्पन्न हुआ, निर्धारित अपाईन्टमेंट में नियमानुसार सम्यक रूप से स्टाम्पित मूल दस्तावेज सहित, 
					निम्नलिखित व्यक्तियो  के साथ उप पंजीयक कार्यालय <s:property value="dsrName" /> में दस्तावेज़ पंजीयन हेतु उपस्थित होवें ,<br /><br />
					
					
					
				</p>
			</s:if>	
				
				
				
				
				<br /><br />
				<br /><br />
				<!-- <a href="Home" style="color:black">मुख्या पृष्ठ में जाएँ</a> -->
					
				<input type="button" value="अपॉइंटमेंट slip डाउनलोड करें " onClick="window.location.href='servlet/DownloadServlet?filePath=<%=request.getAttribute("fileName").toString()%>';" />
				  <s:if test='(appointmentNoFinal1.length() > 0)'>		
				<input type="button" value="अपॉइंटमेंट slip डाउनलोड करें " onClick="window.location.href='servlet/DownloadServlet?filePath=<%=request.getAttribute("fileName1").toString()%>';" />
				</s:if>
				<br /><br />
				
				<br /><br />
				
				<br /><br />
				<br /><br />
				</div>
			</div>
			<!--==============================footer=================================-->
			<%@include file="../commonJsp/footer.jsp" %>
		</div>
	</body>
	
	<script type="text/javascript">window.history.forward(0);</script>
</html>