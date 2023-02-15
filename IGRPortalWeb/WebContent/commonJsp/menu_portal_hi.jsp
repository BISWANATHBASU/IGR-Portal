<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<link href="include/menu.css" rel="stylesheet" type="text/css" />
		<script src="include/menu.js" type="text/javascript"></script>
	</head>
<body>

<div class="menuBar" >
<a class="menuButton" href="homeAction.action">मुख्य पृष्ठ</a> | 
<!--a class="menuButton" href="requiredInformation.action">आवश्यक जानकारी</a-->


<!--a class="menuButton" href="" onclick="return buttonClick(event, 'importantLink');"
    onmouseover="buttonMouseover(event, 'importantLink');">सामान्य जानकारी</a> | -->
    
 <a class="menuButton" href="" onclick="return buttonClick(event, 'otherServices');"
    onmouseover="buttonMouseover(event, 'otherServices');">अन्य सेवाएँ</a> | 
    
<a class="menuButton" href="IssueSecondTokenAction.action">प्री-रजिस्ट्रेशन आवेदन</a> | 
    
<a class="menuButton" href="" onclick="return buttonClick(event, 'transactionMenuEntry');"
    onmouseover="buttonMouseover(event, 'transactionMenuEntry');">प्री-रजिस्ट्रेशन आवेदन</a> | 
    
<a class="menuButton" href="" onclick="return buttonClick(event, 'applicationStatus');"
    onmouseover="buttonMouseover(event, 'applicationStatus');">आवेदन की स्थिति</a>
</div>

<div id="transactionMenuEntry" class="menu" onmouseover="menuMouseover(event)">
	<!-- <a class="menuItem" href="IssueFirstTokenAction.action">आवेदन प्रविष्ट करें</a> -->
	
	<a class="menuItem" href="IssueSecondTokenAction.action">आवेदन एवं पंजीयन स्टाम्प</a><!-- ई पंजीयन टोकन -->
	
	<!-- <a class="menuItem" href="SearchFirstTokenforSecondToken.action">पंजीयन स्टाम्प विवरणी</a> -->
	<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=PROPERTY_DETAIL">सम्पत्ति का विवरण</a>
	<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=STRUCTURE_DETAIL">संरचना का विवरण</a>
	<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=PARTY_DETAIL">पक्षकार का विवरण</a>
	<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=DEED_DETAIL">विलेख का विवरण</a>
	
	<!-- <a class="menuItem"	href="InitiateReportAction.action?reportName=IGR_CHECKSLIP&heading=Check Slip&event=CHECKSLIP">आवेदन प्रविष्ट की प्रिंट</a> -->
	
	<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=DEED_DETAIL_SIGNATURE">प्रविष्ट सत्यापन</a>
	
	<!--a class="menuItem"	href="InitiateReportAction.action?reportPath=/report/IGR_DEED_SCANNED.jasper&reportName=IGR_CHECKSLIP&heading=Check Slip&event=CHECKSLIP">ABC</a-->
	<!--a class="menuItem"	href="InitiateReportAction.action?reportPath=/report/IGR_DEED_SCANNED.jasper&reportName=IGR_CHECKSLIP&heading=Check Slip&event=CHECKSLIP">test</a-->
	
	<!--a class="menuItem" href="DistrictWiseAction.action">नियम 19 च</a-->
</div>

<div id="importantLink" class="menu" onmouseover="menuMouseover(event)">
	<a class="menuItem"	href="/IGRPortalWeb/reckonerSubAction.action" target="_blank">बाजार मूल्य की गणना</a><!-- /IGRPortalWeb/PropertyDetailEnquiryAction?page_id=2 -->
	<a class="menuItem"	href="/IGRPortalWeb/StampValueEnquiryAction" target="_blank">मुद्रांक एवं पंजीयन शुल्क की गणना करें</a>
	<a class="menuItem"	href="/IGRPortalWeb/commonJsp/deedSampleAction.action" target="_blank">विलेख का नमूना</a>
	<a class="menuItem"	href="/IGRPortalWeb/commonJsp/documentSampleAction.action" target="_blank">दस्तावेज़ तैयार करें</a>
	<a class="menuItem"	href="#" target="_blank">स्टाम्प वेंडरो की सूची</a>
</div>



<div id="otherServices" class="menu" onmouseover="menuMouseover(event)">
	<a class="menuItem"	href="https://www.shcilestamp.com/OnlineStamping/OlnEsi" target="_blank">ई-स्टांप खरीदें</a>
	<a class="menuItem"	href="https://cg.nic.in/eChallan/" target="_blank">ऑनलाइन शुल्क भुगतान</a>
	<a class="menuItem"	href="/IGRPortalWeb/titleOfLandAction" target="_blank">राजस्व अभिलेख द्वारा खोज<!--भुइयां से जमीन की हक सम्बन्धी जानकारी--></a>
	<a class="menuItem"	href="https://epanjeeyan.cg.gov.in/CGSearch/" target="_blank">पंजीकरण खोज</a>
</div>



<div id="applicationStatus" class="menu" onmouseover="menuMouseover(event)">
	<a class="menuItem"	href="TokenStatusAction.action">प्री-रजिस्ट्रेशन की स्थिति</a><!-- टोकन -->
	<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=PAYMENT">ई-मूल्यांकन पर्ची/ शुल्क</a><!-- अपॉइंटमेंट -->
	<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=APPOIMENT">अपॉइंटमेंट</a><!-- अपॉइंटमेंट -->
	<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=DATE_EDIT">पुनः अपॉइंटमेंट</a><!-- दिनांक सम्पादित -->
</div>
</body>
