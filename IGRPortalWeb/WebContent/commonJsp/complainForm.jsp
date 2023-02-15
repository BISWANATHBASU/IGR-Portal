<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Complain</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta charset="utf-8">
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" type="text/css" href="../css/breadcrumb.css">
	    <!-- <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/mycss.css"> -->
	    <!-- <script src="/IGRPortalWeb/js/aes.js"></script> -->
	    <!-- <script src="/IGRPortalWeb/js1/md5.min.js"></script> -->
	    <script src="../js/sha256.js"></script>
	    <%@include file="../commonJsp/include.jsp" %>
	    
	    <script>
		    $(function() {
		    	$("#show_hide_1").hide();
		    	//$("#show_hide_2").hide();
		    	
		    	$("#commentText").hide();
		    	
		    	$("#sub_complain_detail").hide();
		    	
		    	$("body").delegate("#complain_detail","change",function(event){
		    		var complainDetail = $("#complain_detail").val();
		    		
		    		try{
		    			//alert(complainDetail);
						
					    var formInput= 'complain_detail='+complainDetail;  
					    var options='';   
					      $("#sub_complain_detail").html(options);  
					      $.getJSON('getSubComplain.action', formInput,function(data) {
					    	  //alert("===========");
					    	options = '<option selected value="">Select</option>';
					    	$.each(data.subComplainList, function(i,item){
					    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
					        });
					    	//options += '<option value="अन्य">अन्य</option>';
					    	//alert(options);
					        $("#sub_complain_detail").html(options);   
					    });
		    		}
					catch(Exception){
						alert("sub_complain_detail Error" + Exception);
					}
		    	});
		    	
		    	$("body").delegate("#complain_detail","change",function(event){
		    		var subComplainDetail = $("#complain_detail").val();
		    		
		    		//alert(subComplainDetail);
                    if(subComplainDetail == "अन्य" || subComplainDetail == "पंजीयन प्रणाली सम्बन्धी सुझाव"){
                    	$("#commentText").show();
        		    	$("#sub_complain_detail").hide();
                    }else{
                    	$("#commentText").hide();
        		    	$("#sub_complain_detail").show();
                    }
                    
		    	});
		    	
		    	//$("body").delegate("#feed_back_category","change",function(event){
                    //var yourCategory = $("#feed_back_category").val();
                    //alert(yourCategory);
                    //if(yourCategory == "Feed Back"){
                    	
        		    	//$("#show_hide_1").show();
        		    	//$("#show_hide_2").hide();
        		    	
        		    	$('input[type=radio][name=webSiteRating]').change(function() {
        		    	    if (this.value == 'Need Improvement') {
        		    	        //alert("Show All");
                            	
                		    	//$("#show_hide_1").show();
                		    	$("#show_hide_2").show();
                		    	$("#sub_complain_detail").hide();
        		    	    }
        		    	    else{
        		    	        //alert("All Hide");
                            	
                		    	//$("#show_hide_1").show();
                		    	$("#show_hide_2").hide();
                		    	$("#sub_complain_detail").show();
        		    	    }
        		    	});
        		    	
                    /*}else if (yourCategory == "Complain"){
        		    	$("#show_hide_1").hide();
        		    	$("#show_hide_2").show();
                    }else{
        		    	$("#show_hide_1").hide();
        		    	$("#show_hide_2").hide();
                    }*/
                    //});
                        //});
		    
		    	
		    });
	    </script>
	    
		<s:head theme="igr" />
		<sx:head />
	</head>
<body oncontextmenu="return false;">

<div class="main">
	<div class="container_12">
	
    <%@include file="../commonJsp/header1.jsp" %>

	<form action="addComplainForm" validate="true" namespace="/" method="post" autocomplete="off">
    <div style="margin-top:0.5em;margin-left:2%;width:96%;border:1px solid black;">
      <div align="center" style="margin-top:20px;">
      
			<s:actionerror theme="igr" cssClass="erroMsg" />
			<s:actionmessage theme="igr" cssClass="infoMsg" cssStyle="color:blue;" />
			
			<h2 style="color:blue;"><u>शिकायत दर्ज करें</u></h2>
			
			<table border="1">
				<tr><th colspan="2"><font color="black">आवेदक का विवरण</font></th></tr>
				<tr>
					<th>Full Name <font color="red">*</font> :- </th>
					<td><s:textfield name="full_name" id="full_name" theme="simple" required="required" pattern="[A-Za-z ]{1,}" /></td>
				</tr>
				<tr>
					<th>Mobile No. <font color="red">*</font> :- </th>
					<td><s:textfield name="mobile_no" id="mobile_no" theme="simple" required="required" pattern="[0-9]{10}" maxlength="10" /></td>
				</tr>
				<tr>
					<th>e-Mail ID <font color="red">*</font> :- </th><!-- "[^@\s]+@[^@\s]+\.[^@\s]+" -->
					<td><s:textfield name="e_mail_id" id="e_mail_id" theme="simple" required="required" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{3,63}$" title="Invalid email address" /></td>
				</tr>
			</table>
			<br /><br />
			
			<table>
				<!--tr><th colspan="2"><font color="black">दरख्वास्त विस्तार</font> </th></tr-->
				<!--tr>
					<th>श्रेणी <font color="red">*</font> :- </th>
					<td>
						<s:select name="feed_back_category" id="feed_back_category" theme="simple" headerKey="-1" headerValue="Select Category" list="#{'Feed Back':'फीडबैक', 'Complain':'शिकायत'}" style="width:200px;" />
					</td>
				</tr-->
				<tr id="show_hide_1">
					<td colspan="2">
						<input type="radio" id="webSiteRating" name="webSiteRating" value="Excellent"> अति उत्कृष्ट
						<input type="radio" id="webSiteRating" name="webSiteRating" value="Average"> औसत
						<input type="radio" id="webSiteRating" name="webSiteRating" value="Satisfactory"> संतोषजनक
						<input type="radio" id="webSiteRating" name="webSiteRating" value="Need Improvement"> सुधार की जरूरत
					</td>
				</tr>
			</table>
			
			
			<table id="show_hide_2">
				<tr><th colspan="2"><font color="black">पंजीकरण सन्दर्भ विवरण</font><s:hidden name="feed_back_category" id="feed_back_category" value="Complain" theme="simple" title="Invalid email address" /> </th></tr>
				<tr>
					<th>ई-पंजीयन आईडी <font color="red">*</font> :- </th>
					<td><s:textfield name="e_registration_id" id="e_registration_id" theme="simple" pattern="[A-Za-z0-9 ]{1,}" /></td>
				</tr>
				<tr>
					<th>कार्यालय का नाम <font color="red">*</font> :- </th>
					<td>
						<s:select name="dsr_location" id="dsr_location" list="dsrLocationList" headerKey="" headerValue="Select कार्यालय" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" />
					</td>
				</tr>
				<tr>
					<th>किस प्रकार की समस्या <font color="red">*</font> :- </th>
					<td>
						
						<s:select name="complain_detail" id="complain_detail" list="complainDetailList" headerKey="" headerValue="Select " listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" />
						<!--s:select name="complain_detail" id="complain_detail" theme="simple" headerKey="" headerValue="Select समस्या" list="complainDetailList" listKey="typeCode" listValue="typeDesc" /-->
						<!-- {'ई-पंजीयन व्यव्स्था':'ई-पंजीयन व्यव्स्था', 'नेटवर्क सम्बन्धी':'नेटवर्क सम्बन्धी', 'ऑपरेटर की व्यवहार':'ऑपरेटर की व्यवहार', 'कर्मचारी / अधिकारी की सहयोगात्मक व्यवहार':'कर्मचारी / अधिकारी की सहयोगात्मक व्यवहार', 'पक्षकारों को दी जा रही जन सुविधाएँ':'पक्षकारों को दी जा रही जन सुविधाएँ', 'पंजीयन प्रणाली सम्बन्धी सुझाव':'पंजीयन प्रणाली सम्बन्धी सुझाव' } -->
						<!--s:select name="sub_complain_detail" id="sub_complain_detail" theme="simple" headerKey="-1" headerValue="उप समस्या का चयन करें" list="{'ई-पंजीयन व्यव्स्था':'ई-पंजीयन व्यव्स्था', 'नेटवर्क सम्बन्धी':'नेटवर्क सम्बन्धी', 'ऑपरेटर की व्यवहार':'ऑपरेटर की व्यवहार', 'कर्मचारी / अधिकारी की सहयोगात्मक व्यवहार':'कर्मचारी / अधिकारी की सहयोगात्मक व्यवहार', 'पक्षकारों को दी जा रही जन सुविधाएँ':'पक्षकारों को दी जा रही जन सुविधाएँ', 'पंजीयन प्रणाली सम्बन्धी सुझाव':'पंजीयन प्रणाली सम्बन्धी सुझाव','अन्य':'अन्य' }" /-->
						
						<s:select  list="subComplainList" listKey="typeCode" listValue="typeDesc" name="sub_complain_detail" id="sub_complain_detail" theme="simple" headerKey="" headerValue="Select" />
					</td>
				</tr>
				
				<tr id="commentText"><th colspan="2"><textarea name="enterComment" id="enterComment" placeholder="Your Comment....." style="height:100px;"></textarea></th></tr>
			</table>
			<br /><br />
			
			<table width="400px;">
				<tr>
					<th colspan="2">
						<input type="submit" value="Submit" /> 
						<input type="button" value="Not Now" onClick="window.location.href='Home.action';">
					</th>
				</tr>
			</table>
			
			<!--table>
				<tr><th colspan="2"><h2>प्रतिक्रिया फॉर्म</h2></th></tr>
				<tr>
					<th>Full Name * :- </th>
					<td><s:textfield name="full_name" id="full_name" theme="simple" required="required" pattern="[A-Za-z ]{1,}" /></td>
				</tr>
				<tr>
					<th>Mobile No. :- </th>
					<td><s:textfield name="mobile_no" id="mobile_no" theme="simple" required="required" pattern="[0-9]{10}" maxlength="10" /></td>
				</tr>
				<tr>
					<th>e-Mail ID :- </th><!-- "[^@\s]+@[^@\s]+\.[^@\s]+" --
					<td><s:textfield name="e_mail_id" id="e_mail_id" theme="simple" required="required" pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{3,63}$" title="Invalid email address" /></td>
				</tr>
				
				<tr><th colspan="2"><h3>आप हमारे वेबसाइट का मूल्यांकन कैसे करेंगे</h3></th></tr>
				<tr>
					<td colspan="2">
						<input type="radio" id="webSiteRating" name="webSiteRating" value="Excellent" required="required"> अति उत्कृष्ट
						<input type="radio" id="webSiteRating" name="webSiteRating" value="Average"> औसत
						<input type="radio" id="webSiteRating" name="webSiteRating" value="Satisfactory"> संतोषजनक
						<input type="radio" id="webSiteRating" name="webSiteRating" value="Need Improvement"> सुधार की जरूरत
					</td>
				</tr>
				
				<tr><th colspan="2"><textarea name="enterComment" id="enterComment" placeholder="Your Comment....." style="height:100px;"></textarea></th></tr>
				<tr><th colspan="2"><input type="submit" value="Submit" /> <input type="button" value="Not Now"></th></tr>
			</table-->
		</div>

	</div>
    </form>
    </div>
	<!--==============================footer=================================-->
     <%@include file="../commonJsp/footer.jsp" %>

</div>
</body>
<script type="text/javascript">
window.history.forward(0);
</script>	
</html>
