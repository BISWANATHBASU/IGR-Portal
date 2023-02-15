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
					<p style="color:black;font-weight:bold;font-size:16px;text-align:center;">
						<%-- आपके अपाईन्टमेंट  आईडी <u><s:property value="appointmentNoFinal" /></u> दिनांक <u><s:property value="appointmentDate" /></u> समय <u><s:property value="appointmentTimeFinal" /></u>बजे सफलतापूर्वक update सम्पन्न हुआ <br /><br /> --%>
						<%-- 
						आपके द्वारा चयन किया गया ई-पंजीयन कि अपाईन्टमेंट आईडी  <s:property value="appointmentNoFinal" />  पुनः निर्धारित   दिनांक  <s:property value="appointmentDate" />  समय  <s:property value="appointmentTimeFinal" />  बजे सफलता पुर्वक सम्पन्न हुआ |<br /><br />
						 --%>
						
						
						आपके द्वारा चयन किया गया ई-पंजीयन कि अपाईन्टमेंट आईडी  <s:property value="appointmentNoFinal" />  का  ई-स्टाम्प  विवरण सफलता पुर्वक सम्पन्न हुआ |<br /><br />
						
						<%-- <s:property value="appointmentID" /> --%>
						
						<%-- <table border="0" style="color: black;; width:500px;">
							<tr><th colspan="4"><font color="black">आवेदक का विवरण</font></th></tr>
							<% int i = 0; %>
							<s:iterator value="otherPartyList" var="tokenStructureListList">
								<% i++; %>
								<tr>
									<th><%=i%>. </th><td><s:property value="typeCode1" />  का नाम  <<s:property value="typeCode2" /></td>
								</tr>
							</s:iterator>
						</table> --%>
						
						<input type="button" value="अपॉइंटमेंट slip डाउनलोड करें " onClick="window.location.href='servlet/DownloadServlet?filePath=<%=request.getAttribute("fileName").toString()%>';" />
					</p>
					
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