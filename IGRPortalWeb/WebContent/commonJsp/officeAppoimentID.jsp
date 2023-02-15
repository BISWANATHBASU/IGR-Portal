<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="org.apache.log4j.Logger"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Office Application Appointment</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" type="text/css" href="../css/breadcrumb.css">
	    <script src="../js/sha256.js"></script>
	    <%@include file="../commonJsp/include.jsp" %>
	    
		<script language="JavaScript1.2" src="<s:url value="/js/jquery.datepick.js"/>"></script>
		<link rel="stylesheet" type="text/css" href="<s:url value="/css/jquery.datepick.css"/>">
		<link rel="stylesheet" type="text/css" href="<s:url value="/css/workProgress.css"/>">
		
		<script>
	    	$(function() {
	    		//alert("==");
	    		$("body").delegate("#downloadBtn","click",function(event){
	    			var appointmentIDDownload = $("#appointmentIDDownload").val();
	    			//alert("======"+appointmentID);
	    			
	    			if(appointmentIDDownload == ""){
	    				alert("पहले लिए गए अपॉइंटमेंट बुकिंग आईडी");
	    			}else{
	    				var pdfPath = $("#pdfPath").val();
	    				//alert(pdfPath);
	    				
	    				var formInput= "appointmentNoFinal="+appointmentIDDownload;
	    				$.getJSON('regeneratePDF.action', formInput,function(data) {
	    					//alert("===>"+data.getData+"<===");
					    	if(data.getData == 1){
				    			
				    			var file_path = pdfPath + "" + "APPOINTMENT_SLIP" + "_" + appointmentIDDownload + ".pdf";
				    			//alert(file_path);
				    			
				    			window.open("servlet/DownloadServlet?filePath="+file_path);
					    	}
					    	else{
					    		alert("Please Enter a Valid Appointment No");
					    	}
					    });
	    			}
	    		});
			});
		</script>
	</head>
	<body>
		<body oncontextmenu="return false;">
		<div class="main">
			<div class="container_12">
				<%@include file="../commonJsp/header1.jsp" %>
				
					<div style="margin-top:0.5em;margin-left:2%;width:96%;border:1px solid black;">
						<div align="center" style="margin-top:20px;">
						
							<!-- <h2>Help Line No. 0771 491 2523/1800 233 2488</h2> -->
							<br />
						
							<s:actionerror theme="igr" cssClass="erroMsg" cssStyle="color:red;font-weight:bold;font-size:20px;" />
							<s:actionmessage theme="igr" cssClass="infoMsg" cssStyle="color:blue;font-weight:bold;font-size:20px;" />
							
							<%
								final Logger log = Logger.getLogger("officeAppointmentID.jsp");
								String pageType = request.getParameter("page");
								log.fatal("Page ="+pageType);
								//if(pageType.equalsIgnoreCase("view")){
									%>
									<%-- 
									<form action="searchAppointmentDetail" validate="true" namespace="/" method="post" autocomplete="off">
									<h2 style="color:blue;"><u>अपॉइंटमेंट update</u></h2>
									
									<table border="1" style="color:black;">
										<!-- <tr><th colspan="2"><font style="color:black;font-size:16px;">(केवल दिनांक एवं समय)</font><br />&nbsp; </th></tr> -->
										<tr>
											<th style="font-size:16px;"><font style="line-height:35px;">पहले लिए गए अपॉइंटमेंट बुकिंग आईडी<font color="red">*</font> :- </font></th>
											<td><s:textfield name="appointmentID" id="appointmentID" theme="simple" required="required" maxlength="100" /></td>
										</tr>
										<tr>
											<th colspan="2">
												<br /><input type="submit" value="आगे जाएँ" /><br />
											</th>
										</tr>
									</table>
									</form>
									<% } else if(pageType.equalsIgnoreCase("edit")){
										%>
										
										<form action="searchAppointmentReschedule" validate="true" namespace="/" method="post" autocomplete="off">
										<h2 style="color:blue;"><u>अपॉइंटमेंट संशोधन</u></h2>
										
										<table border="1" style="color:black;">
											<tr><th colspan="2"><font style="color:black;font-size:16px;">(केवल दिनांक एवं समय)</font><br />&nbsp; </th></tr>
											<tr>
												<th style="font-size:16px;"><font style="line-height:35px;">पहले लिए गए अपॉइंटमेंट बुकिंग आईडी<font color="red">*</font> :- </font></th>
												<td><s:textfield name="appointmentID" id="appointmentID" theme="simple" required="required" maxlength="100" /></td>
											</tr>
											<tr>
												<th colspan="2">
													<br /><input type="submit" value="आगे जाएँ" /><br />
												</th>
											</tr>
										</table>
										</form>
										<% } else{ %>
							<br /> --%>
							<h2 style="color:blue;"><u>अपॉइंटमेंट पुनः डाउनलोड हेतु</u></h2>
							
							<table border="1" style="color:black;">
								<!-- <tr><th colspan="2"><font style="color:black;font-size:16px;">(केवल दिनांक एवं समय)</font><br />&nbsp; </th></tr> -->
								<tr>
									<th style="font-size:16px;"><font style="line-height:35px;">पहले लिए गए अपॉइंटमेंट बुकिंग आईडी<font color="red">*</font> :- </font></th>
									
									<td>
										<s:textfield name="appointmentIDDownload" id="appointmentIDDownload" theme="simple" maxlength="100" />
										<s:hidden name="pdfPath" id="pdfPath" theme="simple" />
									</td>
								</tr>
								<tr>
									<th colspan="2">
										<br /><input type="button" value="अपॉइंटमेंट डाउनलोड " id="downloadBtn" />
									</th>
								</tr>
							</table>
							<% //} %>
							<br /><br />
							
							<br /><br />
							
							
							
						</div>
					</div>
					
			</div>
			<!--==============================footer=================================-->
			<%@include file="../commonJsp/footer.jsp" %>
		</div>
	</body>
	<script type="text/javascript">window.history.forward(0);</script>
</html>