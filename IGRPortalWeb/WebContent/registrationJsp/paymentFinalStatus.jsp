<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
	<head>
	    <title>शुल्क विवरणी</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    
	    <%@include file="../commonJsp/include.jsp" %>
	    <link rel="stylesheet" type="text/css" href="<s:url value="/include/ams.css"/>">
		<link rel="stylesheet" type="text/css" href="<s:url value="/include/font-awesome.css"/>">
		<link rel="stylesheet" type="text/css" href="<s:url value="/include/menu.css"/>">
		<link rel="stylesheet" type="text/css" href="<s:url value="/include/signature-pad.css"/>">
		<script language="JavaScript1.2" src="<s:url value="/include/jquery.min.js"/>"></script>
		
		<script language="JavaScript1.2" src="<s:url value="/include/signature_pad.js"/>"></script>
		<script language="JavaScript1.2" src="<s:url value="/include/AMS.js"/>"></script>
		<script language="JavaScript1.2" src="<s:url value="/include/menu.js"/>"></script>
	</head>
	<body id="page1" oncontextmenu="return false;">
	<br />
	<div id="workProgress">
		<ul>
			<li class="doneWind"><a href="#">प्रस्तुति विवरणी&#10004;</a></li>
			<li class="doneWind"><a href="#">स्टाम्प विवरणी&#10004;</a></li>
			<li class="doneWind"><a href="#">सम्पत्ति का विवरण &#10004;</a></li>
			<li class="doneWind"><a href="#">संरचना का विवरण &#10004;</a></li>
			<li class="doneWind"><a href="#">पक्षकार का प्रकार &#10004;</a></li>
			<li class="doneWind"><a href="#">विलेख का विवरण &#10004;</a></li>
			
			<li class="workingWind"><a href="#">अपॉइंटमेंट/ शुल्क &#9998;</a></li>
			
			<li class="waitingWind"><a href="#">पुनः अपॉइंटमेंट &#10006;</a></li>
		</ul>
	</div>
		
		<div class="main">
			<div class="container_12">
		<header>
			    <div class="wrapper">
			    	<h1><a href="/IGRPortalWeb/"><img src="/IGRPortalWeb/images/logo.png" alt=""></a><span></span></h1>
			    	<div class="tagline">
			    		<p>E-Panjeeyan Portal</p> 
			    	</div>                
			    </div>
			    <section id="content">
			    <div align="center" class="formCaption">Payment Status</div>
	
			<div align="center">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px">
					<tr>
						<td class="tdLabel">Transaction Reference No:</td>
						<td class="field"><s:property value="sbi_ref_no"/></td>
					</tr>
					<tr>
						<td class="tdLabel">Application No:</td>
						<td class="field"><s:property value="token_no"/></td>
					</tr>
					<tr>
						<td class="tdLabel">Amount Paid:</td>
						<td class="field"><s:property value="amount_paid"/></td>
					</tr>
					<tr>
						<td class="tdLabel">Bank:</td>
						<td class="field"><s:property value="bank_name"/></td>
					</tr>
					<tr>
						<td class="tdLabel">Payment Method:</td>
						<td class="field"><s:property value="payment_method"/><td>
					</tr>
					<tr>
						<td class="tdLabel">Transaction Status:</td>
						<td class="field"><s:property value="tran_status_desc"/><td>
					</tr>
					<tr>
					<td colspan="2" class="tdLabel">Please Login to print the payslip</td>
					</tr>
				</table>
				<div align="center">
				
				<input type="button" 
						name="Home" value="Home" class="button"
						onClick="window.location.href='indexAction';">
				</div>
			</div>
			    </section>
		    </header>
		    </div>
		    <!--==============================footer=================================-->
	     <%@include file="../commonJsp/footer.jsp" %>
		    </div>
	</body>
</html>