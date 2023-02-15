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
		<script>
			$(function() {
				$("#otpmsg").hide();
				$("body").delegate("#resendOTP","click",function(event){
		    		try{
		    			var mobileNo = $("#mobileNo").val();
		    			//alert(dsr_location);
		    			var formInput= "mobileNo="+mobileNo;  
					    var options='';
					      //$("#appointmentTime").html(options);
					      $.getJSON('resendReappointOTP.action', formInput,function(data) {
					    	  //alert("===>"+data.getData+"<===");
					    	  if(data.getData == 1){
					    		  $("#otpmsg").show();
					    		  $("#resendOTP").hide();
					    	  }
					    });
		    		}
		    		catch(Exception){
		    			alert("getTimeList Error===>" + Exception);
					}
	            });
				
				$("#verifyOTP").one('click', function (event) {  
		        	event.preventDefault();
		        	//do something
		        	$(this).prop('disabled', true);
			    });
			});
		</script>
	</head>
	<body>
		<body oncontextmenu="return false;">
		<div class="main">
			<div class="container_12">
				<%@include file="../commonJsp/header1.jsp" %>
				
				<form action="verifiedOTP" validate="true" namespace="/" method="post" autocomplete="off">
					<div style="margin-top:0.5em;margin-left:2%;width:96%;border:1px solid black;">
						<div align="center" style="margin-top:20px;">
							<br />
						
							<s:actionerror theme="igr" cssClass="erroMsg" cssStyle="color:red;font-weight:bold;font-size:20px;" />
							<s:actionmessage theme="igr" cssClass="infoMsg" cssStyle="color:blue;font-weight:bold;font-size:20px;" />
							<br />
							<h2 style="color:blue;"><u>ओ टी पी </u></h2>
							
							<table border="1" style="color: black;">
								
								<s:hidden id="appointmentID" name="appointmentID" />
								<s:hidden id="dsr_location" name="dsr_location" />
								<s:hidden id="mobileNo" name="mobileNo" />
								
								<tr id="otpmsg">
									<th colspan="2"><font color="red">OTP Resent Successfully</font></th>
								</tr>
								
								<tr>
									<th>Enter OTP <font color="red">*</font> :- </th>
									<td>
										<s:textfield name="otpVarify" id="otpVarify" theme="simple" required="required" pattern="[0-9]{6}" maxlength="6" />
									</td>
								</tr>
								
								<tr>
									<th colspan="2"><br />
										<input type="button" value="Resend Otp" id="resendOTP" />
										<input type="submit" value="Verify Otp" id="verifyOTP" />
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