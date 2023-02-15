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
					      $.getJSON('resendFirstOTP.action', formInput,function(data) {
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
				
				/* $("#verifyOTP").one('click', function (event) {  
		        	event.preventDefault();
		        	//do something
		        	$(this).prop('disabled', true);
			    }); */
			});
		</script>
	</head>
	<body>
		<body oncontextmenu="return false;">
		<div class="main">
			<div class="container_12">
				<%@include file="../commonJsp/header1.jsp" %>
				
				<form action="verifyAppointmentOTP" validate="true" namespace="/" method="post" autocomplete="off">
				
					<s:token />
					<div style="margin-top:0.5em;margin-left:2%;width:96%;border:1px solid black;">
						<div align="center" style="margin-top:20px;">
							<br />
						
							<s:actionerror theme="igr" cssClass="erroMsg" cssStyle="color:red;font-weight:bold;font-size:20px;" />
							<s:actionmessage theme="igr" cssClass="infoMsg" cssStyle="color:blue;font-weight:bold;font-size:20px;" />
							<br />
							<h2 style="color:blue;"><u>ओ टी पी </u></h2>
							
							<table border="1" style="color: black;">
							
								<s:hidden id="party_type" name="party_type" theme="simple" />
								<s:hidden id="fullName" name="fullName" theme="simple" />
								<s:hidden id="fatherName" name="fatherName" theme="simple" />
								<s:hidden id="mobileNo" name="mobileNo" theme="simple" />
								<s:hidden id="complateAddress" name="complateAddress" theme="simple" /><br />
								
								<s:hidden id="district_id" name="district_id" theme="simple" />
								<s:hidden id="dsr_location" name="dsr_location" theme="simple" />
								<s:hidden id="appointmentDate" name="appointmentDate" theme="simple" />
								<s:hidden id="appointmentTime" name="appointmentTime" theme="simple" />
								
								<s:hidden id="e_stamp_no" name="e_stamp_no" theme="simple" />
								<s:hidden id="e_stamp_amount" name="e_stamp_amount" theme="simple" />
								<s:hidden id="deedType" name="deedType" theme="simple" />
								
								<s:hidden id="rowNo" name="rowNo" theme="simple" />
								<s:hidden id="rowStampNo" name="rowStampNo" theme="simple" />
								
								<s:hidden id="deed_type" name="deed_type" theme="simple" />
								<s:hidden id="deed_category" name="deed_category" theme="simple" />
								<s:hidden id="considered_amount" name="considered_amount" theme="simple" />
								<s:hidden id="stamp_value" name="stamp_value" theme="simple" />
								<s:hidden id="considered_amount_req" name="considered_amount_req" theme="simple" />
								
								<s:hidden id="appointmentNoFinal" name="appointmentNoFinal" theme="simple" />
								<s:hidden id="firstPartyMobileNo" name="firstPartyMobileNo" theme="simple" />
								<s:hidden id="secondPartyMobileNo" name="secondPartyMobileNo" theme="simple" />
								<s:hidden id="another_entry" name="another_entry" theme="simple" />
								
								
								
								
								<s:hidden id="party_type1" name="party_type1" theme="simple" />
								<s:hidden id="fullName1" name="fullName1" theme="simple" />
								<s:hidden id="fatherName1" name="fatherName1" theme="simple" />
								<s:hidden id="mobileNo1" name="mobileNo1" theme="simple" />
								<s:hidden id="complateAddress1" name="complateAddress1" theme="simple" />
								
								<s:hidden id="appointmentTime1" name="appointmentTime1" theme="simple" />
								
								<s:hidden id="e_stamp_no1" name="e_stamp_no1" theme="simple" />
								<s:hidden id="e_stamp_amount1" name="e_stamp_amount1" theme="simple" />
								<s:hidden id="deedType1" name="deedType1" theme="simple" />
								
								<s:hidden id="rowNo1" name="rowNo1" theme="simple" />
								<s:hidden id="rowStampNo1" name="rowStampNo1" theme="simple" />
								
								<s:hidden id="deed_type1" name="deed_type1" theme="simple" />
								<s:hidden id="deed_category1" name="deed_category1" theme="simple" />
								<s:hidden id="considered_amount1" name="considered_amount1" theme="simple" />
								<s:hidden id="stamp_value1" name="stamp_value1" theme="simple" />
								<s:hidden id="considered_amount_req1" name="considered_amount_req1" theme="simple" />
								
								<s:hidden id="appointmentNoFinal1" name="appointmentNoFinal1" theme="simple" />
								<s:hidden id="firstPartyMobileNo1" name="firstPartyMobileNo1" theme="simple" />
								<s:hidden id="secondPartyMobileNo1" name="secondPartyMobileNo1" theme="simple" />
								
								
								
								<%
								
								try{
									
								
									String[] partyNameValues = request.getParameterValues("partyName");
									int len = partyNameValues.length;
									System.out.println("=====Length="+len);
									
									String[] partyFatherValues = request.getParameterValues("partyFather");
									String[] partyAddressValues = request.getParameterValues("partyAddress");
									String[] partyMobileNoValues = request.getParameterValues("partyMobileNo");
									String[] partyTypeValues = request.getParameterValues("partyType");
									
									int rowNo = Integer.parseInt(request.getParameter("rowNo"));
									for(int i = 0; i < len; i++){
										
										String partyName = partyNameValues[i];
										String partyFather = partyFatherValues[i];
										String partyAddress = partyAddressValues[i];
										String partyMobileNo = partyMobileNoValues[i];
										String partyType = partyTypeValues[i];
										System.out.println("=====partyName="+partyName);
								%>
								
								<input type="hidden" id="partyName" name="partyName" value="<%=partyName%>" />
								<input type="hidden" id="partyFather" name="partyFather" value="<%=partyFather%>" />
								<input type="hidden" id="partyAddress" name="partyAddress" value="<%=partyAddress%>" />
								<input type="hidden" id="partyMobileNo" name="partyMobileNo" value="<%=partyMobileNo%>" />
								<input type="hidden" id="partyType" name="partyType" value="<%=partyType%>" />
								
								<%
									}
									
									
									String[] partyNameValues1 = request.getParameterValues("partyName1");
									
									int len1 = partyNameValues1.length;
									System.out.println("=====Length="+len1);
									
									String[] partyFatherValues1 = request.getParameterValues("partyFather1");
									System.out.println("1");
									String[] partyAddressValues1 = request.getParameterValues("partyAddress1");
									System.out.println("2");
									String[] partyMobileNoValues1 = request.getParameterValues("partyMobileNo1");
									System.out.println("3");
									String[] partyTypeValues1 = request.getParameterValues("partyType1");
									System.out.println("4");
									
									int rowNo1 = Integer.parseInt(request.getParameter("rowNo1"));
									for(int i = 0; i < len1; i++){
										System.out.println("11");
										String partyName1 = partyNameValues1[i];
										System.out.println("12"+partyName1);
										String partyFather1 = partyFatherValues1[i];
										System.out.println("13"+partyFather1);
										String partyAddress1 = partyAddressValues1[i];
										System.out.println("14"+partyAddress1);
										String partyMobileNo1 = partyMobileNoValues1[i];
										System.out.println("15"+partyMobileNo1);
										String partyType1 = partyTypeValues1[i];
										System.out.println("=====partyName="+partyName1);
								%>
								
								<input type="hidden" id="partyName1" name="partyName1" value="<%=partyName1%>" />
								<input type="hidden" id="partyFather1" name="partyFather1" value="<%=partyFather1%>" />
								<input type="hidden" id="partyAddress1" name="partyAddress1" value="<%=partyAddress1%>" />
								<input type="hidden" id="partyMobileNo1" name="partyMobileNo1" value="<%=partyMobileNo1%>" />
								<input type="hidden" id="partyType1" name="partyType1" value="<%=partyType1%>" />
								
								<%
									}
									
									

									String[] estampNoValues = request.getParameterValues("estampNo");
									String[] estampDateValues = request.getParameterValues("estampDate");
									String[] estampAmountValues = request.getParameterValues("estampAmount");
									
									int stampLen = estampNoValues.length;
									System.out.println("=====stampLen="+stampLen);
									for(int j = 0; j < stampLen; j++){
										String estampNo = estampNoValues[j];
										String estampDate = estampDateValues[j];
										String estampAmount= estampAmountValues[j];
										%>
											<input type="hidden" id="estampNo" name="estampNo" value="<%=estampNo%>" />
											<input type="hidden" id="estampDate" name="estampDate" value="<%=estampDate%>" />
											<input type="hidden" id="estampAmount" name="estampAmount" value="<%=estampAmount%>" />
										<%
									}
									
									

									String[] estampNoValues1 = request.getParameterValues("estampNo1");
									String[] estampDateValues1 = request.getParameterValues("estampDate1");
									String[] estampAmountValues1 = request.getParameterValues("estampAmount1");
									
									int stampLen1 = estampNoValues1.length;
									System.out.println("=====stampLen="+stampLen);
									for(int j = 0; j < stampLen1; j++){
										String estampNo1 = estampNoValues1[j];
										String estampDate1 = estampDateValues1[j];
										String estampAmount1= estampAmountValues1[j];
										
										%>
										<input type="hidden" id="estampNo1" name="estampNo1" value="<%=estampNo1%>" />
										<input type="hidden" id="estampDate1" name="estampDate1" value="<%=estampDate1%>" />
										<input type="hidden" id="estampAmount1" name="estampAmount1" value="<%=estampAmount1%>" />
									<%
								}
								}catch(Exception e)
								{
									e.printStackTrace();
								}
									
									
								%>
								
								<tr id="otpmsg">
									<th colspan="2"><font color="red">OTP Resent Successfully</font></th>
								</tr>
								
								<%-- <tr>
									<th colspan="2"><font color="green">Your OTP <s:property value="otpText" /></font></th>
								</tr> --%>
								
								<tr>
									<th>Enter OTP <font color="red">*</font> :- </th>
									<td>
										<s:textfield name="otpVarify" id="otpVarify" theme="simple" required="required" pattern="[0-9]{6}" maxlength="6" />
									</td>
								</tr>
								
								<tr>
									<th colspan="2"><br />
										<!-- <input type="button" value="Resend Otp" id="resendOTP" /> -->
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