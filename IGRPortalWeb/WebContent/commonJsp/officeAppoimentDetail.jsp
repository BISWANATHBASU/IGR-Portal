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
	    		/*$("body").delegate("#appointmentDate","change",function(event){
		    		try{
		    			var dsr_location = $("#dsr_location").val();
		    			var appointmentDate = $("#appointmentDate").val();
		    			//alert(dsr_location);
		    			var formInput= 'dsr_location='+dsr_location+"&appointmentDate="+appointmentDate;  
					    var options='';
					      $("#appointmentTime").html(options);
					      $.getJSON('fetchAppTimeList.action', formInput,function(data) {
					    	options = '<option selected value="">उपलब्ध समय का चयन करें</option>';//चुने हुएं दिन में उपलब्ध समय का स्लॉट
					    	$.each(data.appointmentTimeList, function(i,item){
					    		//alert("Get Time");
					    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';
					        });
					        //alert(options);
					        $("#appointmentTime").html(options);   
					    });
		    		}
		    		catch(Exception){
		    			alert("getTimeList Error===>" + Exception);
					}
	            });*/
	    		
	    		$("body").delegate("#deed_type","change",function(event){
		    		try{
		    			var deed_type = $("#deed_type").val();
		    			//alert(district_id);
		    			var formInput= 'deed_type='+deed_type;  
					    var options='';
					      $("#deed_category").html(options);
					      $.getJSON('loadDeedCategoryEdit.action', formInput,function(data) {
					    	  options = '<option selected value="">दस्तावेज प्रकार (वर्गीकरण) चुनें</option>';
					    	$.each(data.deedCategoryList, function(i,item){
					    		//alert("Data List");
					    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';
					        });
					        //alert(options);
					        $("#deed_category").html(options);   
					    });
		    		}
		    		catch(Exception){
		    			alert("getDSRList Error===>" + Exception);
					}
                });
	    		
	    		$("body").delegate("#deed_category","change",function(event){
		    		try{
		    			var deed_type = $("#deed_type").val();
		    			var deed_category = $("#deed_category").val();
		    			//alert(district_id);
		    			var formInput= 'deed_type='+deed_type+'&deed_category='+deed_category;
					    var options='';
					      //$("#deed_category").html(options);
					      $.getJSON('consideredAmountReqEdit.action', formInput,function(data) {
					    	  //alert("");
					    	  //alert(""+data.considered_amount_req);
					    	  $("#considered_amount_req").val(data.considered_amount_req);
					    });
		    		}
		    		catch(Exception){//considered_amount_req
		    			alert("deed_category Error===>" + Exception);
					}
                });
	    		
	    		/*$("body").delegate("#deed_category","change",function(event){
		    		try{
		    			var deed_type = $("#deed_type").val();
		    			var deed_category = $("#deed_category").val();
		    			//alert(district_id);
		    			var formInput= 'deed_type='+deed_type+'&deed_category='+deed_category;
					    var options='';
					      $("#deed_category").html(options);
					      $.getJSON('loadDeedCategoryEdit.action', formInput,function(data) {
					    	  options = '<option selected value="">दस्तावेज प्रकार (वर्गीकरण) चुनें</option>';
					    	$.each(data.deedCategoryList, function(i,item){
					    		//alert("Data List");
					    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';
					        });
					        //alert(options);
					        $("#deed_category").html(options);   
					    });
		    		}
		    		catch(Exception){//considered_amount_req
		    			alert("getDSRList Error===>" + Exception);
					}
                });*/
	    		
	    		$("body").delegate("#considered_amount","blur",function(event){
		    		try{  
		    			var deed_type = $("#deed_type").val();
				        var deed_category = $("#deed_category").val();
		    			var considered_amount = $("#considered_amount").val();
		    			//alert("considered_amount="+considered_amount+"deed_category="+deed_category+",deed_type="+deed_type);
		    			var formInput= 'deed_type='+deed_type+'&deed_category='+deed_category+'&considered_amount='+considered_amount;  
					    var options='';
					      //$("#deed_category").html(options);
					      $.getJSON('calculateStampAmountEdit.action', formInput,function(data) {
					    	  //alert("");
					    	  //alert("==>"+data.calculate_stamp_value+"<==");// data.dsrName
					    	  
					    	  $("#stamp_value").val(data.calculate_stamp_value);
					    	  $("#stamp_value_txt").html(data.calculate_stamp_value);
					    	  
					    });
		    		}
		    		catch(Exception){
		    			alert("considered_amount Error===>" + Exception);
					}
                });
	    	});

			function addStampRow(){
				var rowNo = $("#rowStampNo").val();
				rowNo++;
				var enterTable = document.getElementById("stampTable");
				var row = enterTable.insertRow(rowNo);
				
				var cell1 = row.insertCell(0);
				cell1.innerHTML = "<input type='text' name='estampNo' id='estampNo"+rowNo+"' />";
				
				var cell2 = row.insertCell(1);
				cell2.innerHTML = "<input type='text' name='estampDate' id='estampDate"+rowNo+"' />";
				
				var cell3 = row.insertCell(2);
				cell3.innerHTML = "<input type='text' name='estampAmount' id='estampAmount"+rowNo+"' />";
				
				$("#rowStampNo").val(rowNo);
			}
			
			function removeStampRow(){
				var rowNo = $("#rowStampNo").val();
				
				document.getElementById("stampTable").deleteRow(rowNo);
				
				rowNo--;
				$("#rowStampNo").val(rowNo);
			}
			
			function formValidation(){
				
				var considered_amount = $("#considered_amount").val();
				var considered_amount_req = $("#considered_amount_req").val();
				
				if(considered_amount_req == "true" && considered_amount == "" || considered_amount_req == "true" && considered_amount == "0"){
					alert("विलेख में अंकित मूल्य  प्रविष्टी करें");
					return false;
				}
				else if(validateStamp() == false){
					//alert("");
					return false;
				}
				else if(validateStampValue() == false){
					alert("Please Enter Propert Stamp Value");
					return false;
				}
				else{
					//alert("ALL TRUE");
					var r = confirm("All data are correct press ok ?");
					if (r == true) {
					    //alert("You pressed OK! going Next Page");
					    return true;
					} else {
						//alert("You pressed Cancel!");
					    return false;
					}
					
				}
			}
			
    		var letters = /^[A-Z]+$/;
			var pattern =/^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;
			
			function validateStamp(){
				var rowStampNo = $("#rowStampNo").val();
				
				for(var i=1; i <= rowStampNo; i++){
					//alert("====>>"+i);
					
					//estampNo1/estampDate1/estampAmount1
					
					var estampNo = $("#estampNo"+i).val();
					var estampDate = $("#estampDate"+i).val();
					var estampAmount = $("#estampAmount"+i).val();
					
					var stamp_value = $("#stamp_value").val();
					//alert(stamp_value);
					
					if(stamp_value == "0"){
						if(estampNo != "" || estampNo.length != 20){
							if(estampDate == "" || !estampDate.match(pattern)){
								alert("Please Enter Valid ई-स्टाम्प दिनांक ");
								return false;
							}
						}else{
							return true;
						}
					}else{
						if(estampNo == "" || estampNo.length != 20){
							alert("20 अंको का  ई-स्टाम्प नंबर प्रविष्टी करें");
							return false;
						}
						else if(!estampNo.startsWith("IN-CG")){
							alert("Please Enter Valid ई-स्टाम्प नंबर Start with IN-CG ");
							return false;
						}
						else if(isNaN(estampNo.substring(5,19))){
							alert("Please Enter Valid ई-स्टाम्प नंबर  Numeric Value");
							return false;
						}
						else if(!estampNo.substring(19,20).match(letters)){
							alert("Please Enter Valid ई-स्टाम्प नंबर One Alphabet ");
							return false;
						}
						else if(estampDate == "" || !estampDate.match(pattern)){
							alert("Please Enter Valid ई-स्टाम्प दिनांक ");
							return false;
						}
						else if(estampAmount == "" || isNaN(estampAmount)){
							alert("ई-स्टाम्प मूल्य प्रविष्टी करें");
							return false;
						}
					}
				}
				
				//return true;
			}
			
			function validateStampValue(){
				var rowStampNo = $("#rowStampNo").val();
				var stamp_value = $("#stamp_value").val();
				var totalEStampAmount = 0;
				
				if(stamp_value == "0"){
					return true;
				}else{
					
					for(var i=1; i <= rowStampNo; i++){
						var estampAmount = $("#estampAmount"+i).val();
						
						totalEStampAmount = parseInt(totalEStampAmount) + parseInt(estampAmount);
					}
					//alert("totalEStampAmount="+totalEStampAmount+"====stamp_value"+stamp_value);
					if(totalEStampAmount >= stamp_value){
						return true;
					}
				}
				return false;
			}
	    </script>
	</head>
	<body>
		<body oncontextmenu="return false;">
		<div class="main">
			<div class="container_12">
				<%@include file="../commonJsp/header1.jsp" %>
				
				<form action="updateAppointmentDetail" validate="true" namespace="/" method="post" autocomplete="off" onsubmit="return formValidation();">
					<div style="margin-top:0.5em;margin-left:2%;width:96%;border:1px solid black;">
						<div align="center" style="margin-top:20px;">
						
							<!-- <h2>Help Line No. 0771 491 2523/1800 233 2488</h2> -->
							<br />
						
							<s:actionerror theme="igr" cssClass="erroMsg" cssStyle="color:red;font-weight:bold;font-size:20px;" />
							<s:actionmessage theme="igr" cssClass="infoMsg" cssStyle="color:blue;font-weight:bold;font-size:20px;" />
							<br />
							<h2 style="color:blue;"><u>अपॉइंटमेंट Update<!-- अपॉइंटमेंट पुनः निर्धारण  --><!-- हेतु --></u></h2>
							
							<s:iterator value="appointmentDetailList" var="tokenStructureListList">
							
							<table border="1" style="color: black;">
								<!-- <tr><th colspan="2"><font style="color: black;font-size: 16px;">(केवल दिनांक एवं समय)</font><br />&nbsp;</th></tr> -->
								
								<s:hidden id="appointmentID" name="appointmentID" />
								<s:hidden id="dsr_location" name="dsr_location" />
								<s:hidden id="mobileNo" name="mobileNo" />
								<input type="hidden" id="appointmentDate" name="appointmentDate" value="<s:property value="typeCode8" />" />
									
									<tr>
										<th align="right"><font style="line-height:35px;">पंजीयन जिला &nbsp;  &nbsp; :- </font></th>
										<td style="background-color:gray;"><s:property value="typeCode4" /></td>
									</tr>
									<tr>
										<th align="right"><font style="line-height:35px;">पंजीयन कार्यालय का नाम &nbsp;  &nbsp; :- </font></th>
										<td style="background-color:gray;"><s:property value="typeCode5" /></td>
									</tr>
									
									<!--<tr>
										<th align="right"><font style="line-height:35px;">पुनः निर्धारण हेतु अपाईन्टमेंट का दिन <font color="red">*</font> :- </font></th>
										<td>
											<s:select name="appointmentDate" id="appointmentDate" list="appointmentDateList" headerKey="" headerValue="उपलब्ध अपाईन्टमेंट दिन का चयन करें" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="required" />
										</td>
									</tr>
									
									<tr>
										<th align="right"><font style="line-height:35px;">पुनः निर्धारण हेतु अपाईन्टमेंट दिन में उपलब्ध समय का स्लॉट <font color="red">*</font> :- </font></th>
										<td>
											<s:select name="appointmentTime" id="appointmentTime" list="appointmentTimeList" headerKey="" headerValue="उपलब्ध समय का चयन करें" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="required" />
										</td>
									</tr>-->
									
									<tr>
										<th align="right"><font style="line-height:35px;">दस्तावेज का प्रकार <font color="red">*</font> :- </font></th>
										<td>
											<s:select name="deed_type" id="deed_type" list="deed_typeList" headerKey="" headerValue="दस्तावेज का प्रकार चुनें" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="required" />
										</td>
									</tr>
									
									<tr>
										<th align="right"><font style="line-height:35px;">दस्तावेज प्रकार (वर्गीकरण)<font color="red">*</font> :- </font></th>
										<td>
											<s:select name="deed_category" id="deed_category" list="deed_categoryList" headerKey="" headerValue="दस्तावेज प्रकार (वर्गीकरण) चुनें" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="required" />
										</td>
									</tr>
									
									
								
								<tr>
									<th colspan="2"><font style="color:red;">पंजीयन के दर्मिया किसी अन्य deed टाइप एवं केटेगरी मान्य नहीं होगा तथा अपॉइंटमेंट स्वतः कैंसल हो जायेगा</font>
									
										<s:hidden name="considered_amount_req" id="considered_amount_req" theme="simple" value="" />
									</th>
								</tr>
								
								<tr>
									<th>विलेख में अंकित मूल्य <font color="red">*</font> :- </th>
									<td>
										<s:textfield name="considered_amount" id="considered_amount" theme="simple" placeholder="विलेख में अंकित मूल्य" value="0" />
										<s:hidden name="stamp_value" id="stamp_value" theme="simple" value="0" />
									</td>
								</tr>
								<tr>
									<th>Required Stamp Amount for Appointment <font color="red">*</font> :- </th>
									<td>
										<span style="color:black;" id="stamp_value_txt" />&nbsp;
									</td>
								</tr>
									
								<!-- <tr>
									<th colspan="2"><br /><input type="submit" value="अपाईन्टमेंट Update करें" /></th>
								</tr> -->
							</table>
							<br /><br />
							
							
							<br />
							<font style="color:black;">सम्बंधित ई-स्टाम्प  का विवरण की प्रविष्टी</font>
							<br />
							<table id="stampTable">
								<tr>
									<th>ई-स्टाम्प नंबर<input type="hidden" id="rowStampNo" name="rowStampNo" value="1" /></th>
									<th>ई-स्टाम्प दिनांक<br />(DD/MM/YYYY)</th><th>ई-स्टाम्प मूल्य</th>
								</tr>
								<tr>
									<td><input type="text" id="estampNo1" name="estampNo" maxlength="20" value="<s:property value="typeCode6" />" /></td>
									<td><input type="text" id="estampDate1" name="estampDate" /></td>
									<td><input type="text" id="estampAmount1" name="estampAmount"  value="<s:property value="typeCode7" />" /></td>
									<td>
										<input type="button" value="+" onclick="addStampRow()" />
										<input type="button" value="-" onclick="removeStampRow()" />
									</td>
								</tr>
							</table>
							
							</s:iterator>
							
							<br /><br /><br />
							
							<input type="submit" value="अपाईन्टमेंट Update करें" />
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