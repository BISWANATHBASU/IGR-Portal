<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <link href="include/menu.css" rel="stylesheet" type="text/css" />
  <script src="include/menu.js" type="text/javascript"></script>
</head>
<body>


<div class="menuBar" >
<a class="menuButton" href="" onclick="return buttonClick(event, 'masterMenuEntry');"
    onmouseover="buttonMouseover(event, 'masterMenuEntry');">Master(Entry)</a>

<!-- <a class="menuButton" href="" onclick="return buttonClick(event, 'masterMenuEdit');"
    onmouseover="buttonMouseover(event, 'masterMenuEdit');">Master(Edit)</a>    

<a class="menuButton" href="" onclick="return buttonClick(event, 'downloadMenu');"
    onmouseover="buttonMouseover(event, 'downloadMenu');">Download</a>
	
<a class="menuButton" href="" onclick="return buttonClick(event, 'uploadMenu');"
    onmouseover="buttonMouseover(event, 'uploadMenu');">Upload</a>
	
<a class="menuButton" href="" onclick="return buttonClick(event, 'reportMenu');"
    onmouseover="buttonMouseover(event, 'reportMenu');">Report/MIS</a>
      
<a class="menuButton" href="" onclick="return buttonClick(event, 'serviceProviderMenu');"
    onmouseover="buttonMouseover(event, 'serviceProviderMenu');">Service Provider Certification</a>   
    
             <a class="menuButton" href="" onclick="return buttonClick(event, 'feeBookMenu');"
    onmouseover="buttonMouseover(event, 'feeBookMenu');">Fee Book</a>  
    
        
    <a class="menuButton" href="" onclick="return buttonClick(event, 'tokenSummaryMenu');"
    onmouseover="buttonMouseover(event, 'tokenSummaryMenu');">Token Summary</a> 
    
    <a class="menuButton" href="" onclick="return buttonClick(event, 'volumeMenu');"
    onmouseover="buttonMouseover(event, 'volumeMenu');">Volume</a>  
    
    
    <a class="menuButton" href="" onclick="return buttonClick(event, 'developerMenu');"
    onmouseover="buttonMouseover(event, 'developerMenu');">Developer Console</a>
 -->                  

</div>


<div id="masterMenuEntry" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem" href="UserCreationEntry.action">Create New User</a>
<a class="menuItem" href="DistrictMasterEntryAction.action">District Master</a>
<a class="menuItem" href="LocationMasterEntryAction.action">Location Master</a>
<a class="menuItem" href="PropertyMasterEntry.action">Property Type Master</a>
<a class="menuItem" href="DeedTypeEntry.action">Deed Type</a>
<a class="menuItem" href="DeedCategoryEntry.action">Deed Category</a>
<a class="menuItem" href="FeeMasterEntry.action">Fee Master</a>
<a class="menuItem" href="PropertyStructureMasterAction.action">Property Structure Master</a>
</div>


<div id="masterMenuEdit" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem" href="UserCreationEdit.action">User</a>
<a class="menuItem" href="DistrictMasterEditAction.action">District Master</a>
<a class="menuItem" href="LocationMasterEditAction.action">Location Master</a>
<a class="menuItem" href="PropertyMasterEdit.action">Property Type Master</a>
<a class="menuItem" href="DeedTypeEdit.action">Deed Type</a>
<a class="menuItem" href="DeedCategoryEdit.action">Deed Category</a>
<a class="menuItem" href="FeeMasterEdit.action">Fee Master</a>
<a class="menuItem" href="PropertyStructureMasterEdit.action">Property Structure Master</a>
<a class="menuItem" href="OperationTimeEdit.action">Operation Time</a>
</div>


<div id="downloadMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem" href="AreaMasterPropertyTypeDownload.action">Area Master</a>
<a class="menuItem" href="AreaMasterLitigatedPropertyTypeDownload.action">Area Master(Litigated)</a>
<a class="menuItem" href="AreaMasterObjectionalPropertyTypeDownload.action">Area Master(Objectional)</a>
<a class="menuItem" href="LRMasterDownload.action">LR Master</a>
</div>

<div id="uploadMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem" href="AreaMasterPropertyTypeUpload.action">Area Master</a>
<a class="menuItem" href="AreaMasterLitigatedPropertyTypeUpload.action">Area Master(Litigated)</a>
<a class="menuItem" href="AreaMasterObjectionalPropertyTypeUpload.action">Area Master(Objectional)</a>
<a class="menuItem" href="PropertyEdit.action">Property Master Value Edit</a>
<a class="menuItem" href="PropertyLitigatedEdit.action">Property Master Value Edit(Litigated)</a>
<a class="menuItem" href="PropertyObjectionalEdit.action">Property Master Value Edit(Objectional)</a>
<a class="menuItem" href="LRMasterUpload.action">LR Master</a>
<a class="menuItem" href="LitigatedPropertyEntry.action">Property Master Khasra No.(Litigated)</a>
<a class="menuItem" href="ObjectionalPropertyEntry.action">Property Master Khasra No.(Objectional)</a>
</div>

<div id="reportMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_IncomeTax.jasper&reportName=IGR_IncomeTax&heading=Income Tax&event=FROMDATE">Income Tax</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_Index_One.jasper&reportName=IGR_Index_One&heading=Index One&event=FROMDATE">Index One</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_Index_Two.jasper&reportName=IGR_Index_Two&heading=Index Two&event=FROMDATE">Index Two</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_DOCUMENT_SUB_REGISTRAR_08.jasper&reportName=IGR_DOCUMENT_SUB_REGISTRAR_08&heading=Document Sub-Registrar&event=YEARMONTH">Document Sub-Registrar</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_PANJIYAN_MUDRANK_05.jasper&reportName=IGR_PANJIYAN_MUDRANK_05&heading=Panjiyan Mudrank&event=YEARMONTH">Panjiyan Mudrank</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_UPKAAR_JANPAD_07.jasper&reportName=IGR_UPKAAR_JANPAD_07&heading=Upkaar Janpad&event=YEARMONTH">Upkaar Janpad</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_35(CH)_13.jasper&reportName=IGR_35(CH)_13&heading=IGR 35(CH)-13&event=YEARMONTH">35(CH)-13</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_HAQ_18.jasper&reportName=IGR_HAQ_18&heading=IGR HAQ 18&event=YEARMONTH">HAQ 18</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_DIV_19.jasper&reportName=IGR_DIV_19&heading=IGR DIV 19&event=YEARMONTH">DIV 19</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_DAAN_20.jasper&reportName=IGR_DAAN_20&heading=IGR DAAN 20&event=YEARMONTH">DAAN 20</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_TIME_TRACKING.jasper&reportName=IGR_TIME_TRACKING_ALL&heading=TIME TRACKING&event=FROMDATESUPERUSER">Time Tracking</a>
</div>


<div id="serviceProviderMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_STATE_TIME_TRACKING.jasper&reportName=IGR_STATE_TIME_TRACKING&heading=IGR_STATE_TIME_TRACKING&event=YEARMONTHSUPERUSER">IGR_STATE_TIME_TRACKING</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_DAILY_TIME_TRACKER.jasper&reportName=IGR_DAILY_TIME_TRACKER&heading=IGR_DAILY_TIME_TRACKER&event=YEARMONTHSUPERUSER">IGR_DAILY_TIME_TRACKER</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_MONTHLY_TIME_TRACKER.jasper&reportName=IGR_MONTHLY_TIME_TRACKER&heading=IGR_MONTHLY_TIME_TRACKER&event=YEARSUPERUSER">IGR_MONTHLY_TIME_TRACKER</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_TRACKING_CUSTOMIZED.jasper&reportName=IGR_TRACKING_CUSTOMIZED&heading=IGR_TRACKING_CUSTOMIZED&event=MULTISELECT">IGR_STATE_TIME_TRACKING_CUSTOMIZED</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_DOC_NOT_UPLOADED.jasper&reportName=Not uploaded scan documents&heading=Not uploaded scan documents&event=FROMDATE">Not uploaded scan documents</a>
</div>

<div id="feeBookMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_Fee_Book.jasper&reportName=IGR_Fee_Book&heading=Fee Book(In short)&event=FROMDATE">In Brief</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_Fee_Book_Final.jasper&reportName=IGR_Fee_Book_Final&heading=Fee Book(In Detail)&event=FROMDATE">In Detail</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_ABHIBHAR_SULK.jasper&reportName=IGR_ABHIBHAR_SULK&heading=SERVICE PROVIDER FEE BOOK&event=FROMDATE">SERVICE PROVIDER FEE BOOK</a>
</div>

<div id="tokenSummaryMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_OP_DASHBOARD_MIS.jasper&reportName=Token_Summary&heading=Token Summary&event=FROMDATE">All Token</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_OP_DASHBOARD_MIS_INCOMPLETE.jasper&reportName=Token_Summary&heading=Token Summary&event=FROMDATE">Incomplete Token</a>
<a class="menuItem"	href="InitiateMISReportAction.action?reportPath=/report/IGR_OP_DASHBOARD_MIS_PENDING.jasper&reportName=Token_Summary&heading=Token Summary&event=FROMDATE">Pending Token</a>
</div>

<div id="volumeMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem" href="VolumeCreationActionSA.action?event=VOLUME_CREATION">Volume Creation</a>
<a class="menuItem" href="VolumeRecreatePermission.action">Permission to Volume Creation</a>
</div>

<div id="developerMenu" class="menu" onmouseover="menuMouseover(event)">
<a class="menuItem" href="MergeAction.action">Merge</a>
<a class="menuItem" href="UploadMergeDocumentAction.action">Upload</a>
</div>



</body>