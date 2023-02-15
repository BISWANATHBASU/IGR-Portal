<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="JavaScript1.2" src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>
<script language="JavaScript1.2" src="<s:url value="/js/jquery.datepick.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<s:url value="/css/jquery.datepick.css"/>">

<script type="text/javascript" language="javascript">
getIndexReport();
function getIndexReport(){
	try{
		var fromDate = $("#fromDate").val();
		var toDate = $("#toDate").val();
		//alert("fromDate="+fromDate+",toDate="+toDate);
		
		if(fromDate == null){
			fromDate = "";
		}
		if(toDate == null){
			toDate = "";
		}
		
		/*var dateStatus = 0;
		var pattern =/^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;
		
		if(fromDate.length != 0 || toDate.length != 0){
			
			if(!fromDate.match(pattern)){
				alert("Please Enter From Date in YYYY-MM-DD");
				dateStatus = 0;
			}else if(!toDate.match(pattern)){
				alert("Please Enter To Date in YYYY-MM-DD");
				dateStatus = 0;
			}else{
				dateStatus = 1;
			}
		}*/

		//alert("fromDate="+fromDate+",toDate="+toDate);
		
		var formInput= 'language=2&fromDate='+fromDate+'&toDate='+toDate;
	    $.getJSON('getIndexReport.action', formInput,function(data) {
	    	//alert("Muzzakkir="+data.getIndexData);
	    	var arrayData = data.getIndexData.split("~");
	    	$("#totalAppointment").text(arrayData[7]);
	    	//alert(arrayData[1]);
	    	$("#indexData1").text(arrayData[5]);
	    	$("#indexData2").text(arrayData[6]);
	    	$("#indexData3").text(arrayData[4]);
	    	
	    	$("#indexData4").text(arrayData[3]);
	    	$("#indexData5").text(arrayData[1]);
	    	$("#indexData6").text(arrayData[2]);
		});
	}catch(Exception){
		alert("Error" + Exception);
	}
}

$(function() {
	//alert("JQuery");
	$('#viewReport').on("click", function(e){
		//alert("Button");

		var fromDate = $("#fromDate").val();
		var toDate = $("#toDate").val();
		//alert("fromDate="+fromDate+",toDate="+toDate);
		
		if(fromDate == null){
			fromDate = "";
		}
		if(toDate == null){
			toDate = "";
		}
		
		var dateStatus = 0;
		var pattern =/^([0-9]{4})\-([0-9]{2})\-([0-9]{2})$/;
		
		if(fromDate.length != 0 || toDate.length != 0){
			
			if(!fromDate.match(pattern)){
				alert("Please Enter From Date in YYYY-MM-DD");
				dateStatus = 0;
			}else if(!toDate.match(pattern)){
				alert("Please Enter To Date in YYYY-MM-DD");
				dateStatus = 0;
			}else{
				dateStatus = 1;
			}
		}

		if(dateStatus == 1){
			getIndexReport();
		}

		if(dateStatus == 0){
			alert("Please Select Date");
		}
	});
	//alert("-------");
	/*$("#fromDate").datepick({
    	//dateFormat:'yyyy-mm-dd',
    	//maxDate: new Date()
    });*/
    $("#fromDate").datepicker({
    	dateFormat: "yy-mm-dd"
    });
	//alert("=====");
});
</script>
					<!--h3>About us</h3-->
					<p style="text-align:justify;">
						<!--E-Registration (Property Registration Application) software provides opportunities to provide citizen-centric services more quickly and on time. 
						This is the most specialized software for the office of the Deputy Registrar of Chhattisgarh Government and the Registration Department. 
						It has the ability to work culture, manage, deploy, update, implement and improve public service and provide full reporting within real-time environments. 
						Under computerized land and property registration system, registration is easy. It facilitates transparency in evaluation and eliminates intermediaries Some states have to submit the application to the concerned authority, which may be the sub-registrar of your area.
						The application form can either be downloaded online or received from the office of the concerned authority. After verification of the details, the deed has been prepared and the registration process has been completed.-->
						
						<!-- 
						E-Registration (Property Registration Application) software provides opportunities to provide citizen-centric services more quickly and on time.
						This is the most notably managed software for the Department of Registration and the Department of Registration of Chhattisgarh Government.
						It has the ability to work culture, manage public, alert, update, implement and improve public service and provide full reporting within real time.
						Under the computerized real estate registration system, registration is easy. It facilitates transparency in evaluation and eliminates the opportunity of intermediaries, in certain states, the concerned authority has to submit the application, which may also be the sub registrar of your area.
						The application form can either be downloaded online or received from the office of the concerned authority. After verification of the details, the deed will be considered ready, and thus the registration process is completed.
						 -->
						
						<!-- E-registration (property registration application) software,
						More citizen-centric services faster and on time
						Provides opportunities to provide. Government of Chhattisgarh
						It is used in the sub-registrar offices of
						Under this, the government gives the citizens a fixed period of time.
						The remaining registered documents are available in the remaining. -->
						<!-- In providing compiled registered documents within
						The remaining are otherwise service provider financial --> 
						
						
						E panjeeyan (Application for property registration) software render 
						faster delivery of citizen centric service in time bound manner. 
						This is being used in the registration offices across the state of 
						Chhattisgarh. Under this, Government is committed to deliver computerised 
						registered document to citizen within a time limit as under (Default for last working day).
						
						<br><font style="color:green; ">The dashboard is updated on a daily basis. The data shown below is for the last working day. Select date windows to see details of other working days.</font>
						<br><font style="color:blue; ">Time limit under Public Service Guarantee -</font>
						<br><font style="color:blue; ">Spot Verification not necessary :  01 day</font>
					    <br><font style="color:blue; ">Spot Verification necessary:  07 days</font>
						
						
						<br />
						<!-- <table border="1" width="100%">
							<tr><th align="left">दस्ताबेज ई पंजीयन की निर्धारितसमयाबधि</th><th align="right"><span id="todayIndexData"></span></th></tr>
							<tr backgroundcolor="gray"><th align="left">कल का कुल दस्ताबेज प्राप्त</th><th align="right"><span id="monthIndexData"></span></th></tr>
							<tr><th align="left">कल का कुल दस्ताबेज पंजीकृत</th><th align="right"><span id="yearIndexData"></span></th></tr>
							<tr><th align="left">औसतन कोम्पुत्रिकित पंजीकरण समय</th><th align="right"><span id="totalIndexData"></span></th></tr>
							<tr><th align="left">मीडियन कोम्पुत्रिकित पंजीकरण समय</th><th align="right"></th></tr>
							
							<tr><th align="left">नुन्यतम कोम्पुत्रिकित पंजीकरण समय</th><th align="right"></th></tr>
							<tr><th align="left">अधिकतम कोम्पुत्रिकित पंजीकरण समय</th><th align="right"></th></tr>
						</table> -->
						
						<div class="bg_001">
							<div style="float:left;width:80%:">Total Appointment Received</div>
							<div style="float:right;width:20%;text-align:right;"><span id="totalAppointment"></span></div>
						</div>
						
						<div class="bg_002">
							<div style="float:left;width:80%:">Total Documents Received</div>
							<div style="float:right;width:20%;text-align:right;"><span id="indexData1"></span></div>
						</div>
						
						<div class="bg_003">
							<div style="float:left;width:80%:">Total Documents Registered</div>
							<div style="float:right;width:20%;text-align:right;"><span id="indexData2"></span></div>
						</div>
						
						<div class="bg_004">
							<div style="float:left;width:80%:">Average Registration Time</div>
							<div style="float:right;width:20%;text-align:right;"><span id="indexData3"></span></div>
						</div>
						
						<div class="bg_001">
							<div style="float:left;width:80%:">Median Registration Time</div>
							<div style="float:right;width:20%;text-align:right;"><span id="indexData4"></span></div>
						</div>
						
						<div class="bg_002">
							<div style="float:left;width:80%:">Minimum Registration Time</div>
							<div style="float:right;width:20%;text-align:right;"><span id="indexData5"></span></div>
						</div>
						
						<div class="bg_003">
							<div style="float:left;width:80%:">Maximum Registration Time</div>
							<div style="float:right;width:20%;text-align:right;"><span id="indexData6"></span></div>
						</div>
						
						<div class="bg_005">
							<div style="float:left;margin-right: 10px;"><input type="text" id="fromDate" name="fromDate" placeholder="From Date YYYY-MM-DD" /></div>
							<div style="float:left;margin-right: 10px;"><input type="text" id="toDate" name="toDate" placeholder="To Date YYYY-MM-DD" /></div>
							<div style="float:right;text-align:right;"><input type="button" id="viewReport" value="View" style="width: 100%;" /></div>
						</div>
						
						<div class="bg_001">
							<div style="float:left;width:100%;font-weight:bold;">Note :- Time is in minutes</div>
						</div>
					</p>