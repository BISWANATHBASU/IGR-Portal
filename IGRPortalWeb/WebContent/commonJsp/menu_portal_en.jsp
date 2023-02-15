<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <link href="include/menu.css" rel="stylesheet" type="text/css" />
  <script src="include/menu.js" type="text/javascript"></script>
</head>
<body>

<div class="menuBar" >

<a class="menuButton" href="" onclick="return buttonClick(event, 'transactionMenuEntry');"
    onmouseover="buttonMouseover(event, 'transactionMenuEntry');">Transaction Module(Entry)</a>    

<!-- 
<a class="menuButton" href="" onclick="return buttonClick(event, 'transactionMenuEdit');"
    onmouseover="buttonMouseover(event, 'transactionMenuEdit');">Transaction Module(Edit)</a>   -->  
    
    
     
<a class="menuButton" href="" onclick="return buttonClick(event, 'enquiryMenu');"
    onmouseover="buttonMouseover(event, 'enquiryMenu');">Enquiry Module</a>  

<a class="menuButton" href="" onclick="return buttonClick(event, 'searchMenu');"
    onmouseover="buttonMouseover(event, 'searchMenu');">Search Module</a>        
       
</div>



<div id="transactionMenuEntry" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem" href="IssueSecondTokenAction.action">Issue Token</a>
<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=PROPERTY_DETAIL">Property Details</a>
<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=STRUCTURE_DETAIL">Structure Details</a>
<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=PARTY_DETAIL">Party Details</a>
<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=DEED_DETAIL">Deed Detail</a>
<a class="menuItem"	href="SearchSecondTokenforPropertyEntry.action?event=APPOINTMENT">Appointment</a>
<a class="menuItem"	href="InitiateReportAction.action?reportPath=/report/IGR_CHECKSLIP_PORTAL.jasper&reportName=IGR_CHECKSLIP&heading=Check Slip&event=CHECKSLIP">Re-Print Check Slip</a>
</div>


<!-- <div id="transactionMenuEdit" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem"	href="SearchForTransactionEdit.action?event=PROPERTY_DETAIL">Property Details</a>
<a class="menuItem"	href="SearchForTransactionEdit.action?event=STRUCTURE_DETAIL">Structure Details</a>
<a class="menuItem"	href="SearchForTransactionEdit.action?event=PARTY_DETAIL">Party Details</a>
<a class="menuItem"	href="SearchForTransactionEdit.action?event=DEED_DETAIL">Deed Detail</a>
</div> -->

<div id="enquiryMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem"	href="PropertyDetailEnquiryAction.action">Property</a>
</div>

<div id="searchMenu" class="menu" onmouseover="menuMouseover(event)">
 <a class="menuItem"	href="SearchModule.action">Search</a>
</div>
</body>