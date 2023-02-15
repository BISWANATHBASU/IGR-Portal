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
	    
		<script language="JavaScript1.2" src="<s:url value="/js/jquery.datepick.js"/>"></script>
		<link rel="stylesheet" type="text/css" href="<s:url value="/css/jquery.datepick.css"/>">
		<link rel="stylesheet" type="text/css" href="<s:url value="/css/workProgress.css"/>">
		
	</head>
	<body>
		<body oncontextmenu="return false;">
		<div class="main">
			<div class="container_12">
				<%@include file="../commonJsp/header1.jsp" %>
				
				<form action="verifyAppointmentNo" validate="true" namespace="/" method="post" autocomplete="off">
					<div style="margin-top:0.5em;margin-left:2%;width:96%;border:1px solid black;">
						<div align="center" style="margin-top:20px;">
							<br />
						
							<s:actionerror theme="igr" cssClass="erroMsg" cssStyle="color:red;font-weight:bold;font-size:20px;" />
							<s:actionmessage theme="igr" cssClass="infoMsg" cssStyle="color:blue;font-weight:bold;font-size:20px;" />
							<br />
							<h2 style="color:blue;"><u>अपॉइंटमेंट रद्द करने हेतु </u></h2>
							<br />
							<table border="1" style="color: black;">
								
								<tr>
									<th><span style="line-height:35px;">Appointment No <font color="red">*</font> :- </span></th>
									<td>
										<s:textfield name="appointmentNoFinal" id="appointmentNoFinal" placeholder="Enter Appointment No" theme="simple" required="required" />
									</td>
								</tr>
								
								<tr>
									<th colspan="2"><br />
										<input type="submit" value="Verify Appointment No" />
									</th>
								</tr>
							</table>
							<br /><br />
							
							<br /><br />
							
						</div>
					</div>
					
				</form>
			</div>
			<!--==============================footer=================================-->
			<%@include file="../commonJsp/footer.jsp" %>
		</div>
	</body>
	<script type="text/javascript">window.history.forward(0);</script>
</html>