
<!DOCTYPE html>
<html lang="en">
<head>
    <title>जमीन की बाजार मूल्य</title><!--à¤à¤®à¥à¤¨ à¤à¥ à¤¬à¤¾à¤à¤¾à¤° à¤®à¥à¤²à¥à¤¯-->
    <%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/breadcrumb.css">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/mycss.css">
    <%@include file="../commonJsp/include.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    
    
   <%--  <link rel="stylesheet" type="text/css" href="<s:url value="/include/ams.css"/>">
<link rel="stylesheet" type="text/css" href="<s:url value="/include/font-awesome.css"/>">
<link rel="stylesheet" type="text/css" href="<s:url value="/include/menu.css"/>">
	<link rel="stylesheet" type="text/css" href="<s:url value="/include/signature-pad.css"/>">
<script language="JavaScript1.2"
	src="<s:url value="/include/jquery.min.js"/>"></script>
	
<script language="JavaScript1.2" src="<s:url value="/include/signature_pad.js"/>"></script>
<script language="JavaScript1.2" src="<s:url value="/include/AMS.js"/>"></script>
<script language="JavaScript1.2" src="<s:url value="/include/menu.js"/>"></script> --%>


</head>
<body id="page1" oncontextmenu="return false;">

<div class="main">
	<div class="container_12">
	<!--==============================header=================================-->
	   	<%@include file="../commonJsp/header1.jsp" %>
	   	
	   	
	<!--==============================content================================-->
	<section id="content">
             <div class="wrapper">
               <article class="grid_12">
                   <div class="indent">    
                   <ol class="breadcrumb breadcrumb-arrow">
						<li><s:url value="indexAction.action" var="indexAction"></s:url>
						<a href="<s:property value='#indexAction'/>">मुख्य पृष्ठ<!--à¤®à¥à¤à¥à¤¯ à¤ªà¥à¤·à¥à¤ --></a></li>
						<li><a href="/IGRPortalWeb/reckonerSubAction.action">रेडी रेकोनर<!--à¤°à¥à¤¡à¥ à¤°à¥à¤à¥à¤¨à¤°--></a></li>
						<li class="active"><span><s:property value="getText('global.property_details_head_portal')"/></span></li>
					</ol>	            
					<%-- <ol class="breadcrumb breadcrumb-arrow">
						<li>
						<s:url value="indexAction.action" var="indexAction"></s:url>
						<a href="<s:property value='#indexAction'/>">à¤à¤°</a></li>
						<li>
						<s:url action="reckonerSubAction" var="rec_sub"/>
						<a href="<s:property value='#rec_sub'/>">à¤°à¥à¤¡à¥ à¤°à¥à¤à¥à¤¨à¤°</a></li>
						<li class="active"><span><s:property value="getText('global.property_details_head_portal')"/>fvdvd</span></li>
					</ol>	 --%>			
               	   </div>
               </article>
                <article class="grid_9">
                   <div class="indent">
                   <h2 class="ind2"><s:property value="getText('global.property_details_head_portal')" /></h2>
                   </div> <!-- indent div -->
                   </article>
                   <div class="logincss"> 
                      
                      
                      <s:form action="StructureDetailEnquiryAction.action" validate="true" namespace="/" method="get" theme="simple" name="x">
					<s:token />
					<input type="hidden" name="page_id" id="page_id" value='<%=request.getParameter("page_id") %>'/>
					<%System.out.println("Page ID:"+request.getParameter("page_id")); %>
					<table border="2" width="100%" cellspacing="2" cellpadding="2">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />

				<tr>
					<!--td class="tdlabel">s:property value="getText('global.district')" />*:</td-->
					<td class="tdfield"><s:select list="districtList" headerKey="Select" listKey="typeCode"
							listValue="typeDesc" name="district_id" id="district_id" cssClass="combobox"
							theme="simple" required="true" onchange="loadDSRLocationForProperty(this.value);" /> <s:fielderror
							fieldName="district_id" theme="igr" cssClass="smallErrorMsg" />
					</td>
					
					
					<!--td class="tdlabel">s:property value="getText('global.sub_register_office')" />*:</td-->
					<td class="tdfield"><s:select list="dsrLocationList" headerKey="" headerValue="Select" listKey="typeCode"
							listValue="typeDesc" id="dsr_location" name="dsr_location" cssClass="combobox"
							theme="simple" required="true" onchange="loadAreaMaster(this.value);" /> <s:fielderror
							fieldName="dsr_location" theme="igr" cssClass="smallErrorMsg" />
					</td>
				<!--/tr>
				<tr-->
				
				<!--td class="tdlabel">s:property value="getText('global.AREA_TYPE')" />*:</td-->
					<td class="tdfield"><s:select headerKey="" headerValue="Select"
							list="areaTypeList" listKey="typeCodeDesc" id="area_master_id"
							listValue="typeDesc" name="area_master_id"
							onchange="globalAjaxEnquiry(this.value,'AREA_TYPE');"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="area_master_id" theme="igr" cssClass="smallErrorMsg" /></td><!-- largecombobox -->
				
					<!--td class="tdlabel">s:property value="getText('global.AREA_TYPE_NAME')" />*:</td-->
					<td class="tdfield"><s:select headerKey="" headerValue="Select"
							list="areaTypeNameList" listKey="typeCode"
							onchange="globalAjaxEnquiry(this.value,'WARD_VILL_NAME');"
							listValue="typeDesc" name="area_type_name" id="area_type_name"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="area_type_name" theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>
				<tr>

                    <!--td class="tdlabel">s:property value="getText('global.WARD_VILL_NAME')" />*:</td-->
					<td class="tdfield"><s:select headerKey="" headerValue="Select"
							list="wardVillNameList" listKey="typeCode" listValue="typeDesc"
							name="ward_vill_name"
							onchange="globalAjaxEnquiry(this.value,'MOHALLA_VILL_NAME');"
							id="ward_vill_name" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="ward_vill_name"
							theme="igr" cssClass="smallErrorMsg" /></td>
				
					<!--td class="tdlabel">s:property value="getText('global.MOHALLA_VILL_NAME')" />*:</td-->
					<td class="tdfield"><s:select headerKey="" headerValue="Select"
							list="mohallaVillList" listKey="typeCode" id="mohalla_vill_name"
							listValue="typeDesc" name="mohalla_vill_name"
							cssClass="combobox"
							onchange="globalAjaxEnquiry(this.value,'PROPERTY_TYPE');" theme="simple"
							required="true" /> <s:fielderror fieldName="mohalla_vill_name"
							theme="igr" cssClass="smallErrorMsg" /></td>
				<!--/tr>


				<tr-->
				
					<!--td class="tdlabel">s:property value="getText('global.property_type')" />*:</td-->
					<td class="tdfield"><s:select headerKey="" headerValue="Select"
							list="propertyTypeList" id="propert_type" listKey="typeCode"
							listValue="typeDesc" name="propert_type" onchange="globalAjaxEnquiry(this.value,'FOUR_VALUE');"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="propert_type" theme="igr" cssClass="smallErrorMsg" /></td>

				
					
					<!--td class="tdlabel">s:property value="getText('global.tahaseel')" />:</td-->
					<td class="tdfield"><s:textfield name="tahaseel" id="tahaseel"
							style="width:234px;" readonly="true" theme="simple" placeholder="तहसील">
							<s:fielderror fieldName="tahaseel" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td><!-- cssClass="text_field" -->
				</tr>

				<tr>
				
				
				<!--td class="tdlabel">s:property value="getText('global.revenue_district')" />:</td-->
					<td class="tdfield"><s:textfield name="revenue_district" id="revenue_district"
							style="width:234px;" readonly="true" theme="simple" placeholder="ऱा0नि0मंडल">
							<s:fielderror fieldName="revenue_district" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

				
				
					<!--td class="tdlabel">s:property value="getText('global.WRD_HAL_NO')" />:</td-->
					<td class="tdfield"><s:textfield name="ward_hal_no" id="ward_hal_no"
							style="width:234px;" readonly="true" theme="simple" placeholder="वार्ड/हल्का_नं.">
							<s:fielderror fieldName="ward_hal_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


				<!--/tr>
				<tr>
				
					<td class="tdlabel">s:property value="getText('global.LOCALITY_NAME')" />:</td-->
					<td class="tdfield"><s:textfield name="locality_name" id="locality_name"
							style="width:234px;" readonly="true" theme="simple" placeholder="मोहल्ला/कॉलोनी/सोसायटी/मार्ग_का_नाम">
							<s:fielderror fieldName="locality_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
					<td class="tdfield"><s:textfield name="area_volume"
							id="area_volume" style="width:234px;" required="true" theme="simple" placeholder="सोदा किया गया रकवा"
							maxlength="10">
							<s:fielderror fieldName="area_volume" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				
				</tr>

				<tr>
						
						<!--td class="tdlabel">s:property value="getText('global.area_volumn')" />*:</td-->
				
						<!--td class="tdlabel">s:property value="getText('global.area_unit')" />*:</td-->
						<td class="tdfield"><s:select headerKey="" headerValue="Select"
							list="areaUnitList" listKey="typeCode" listValue="typeDesc"
							name="area_unit" cssClass="combobox" theme="simple"
							required="true" onchange="globalAjaxEnquiry(this.value,'VALUATION');" />
						<s:fielderror fieldName="area_unit" theme="igr"
							cssClass="smallErrorMsg" /></td>
					
						<td class="tdlabel" align="center"><s:property
							value="getText('global.valuation')" />*:</td>
						<td class="amount_show" id="min_val_col" >
						
						<s:hidden name="min_val" id="min_val"/>
						
						
							<%-- <s:fielderror fieldName="min_val" theme="igr"
								cssClass="smallErrorMsg" /> --%>
						</td>
				</tr>
				
			</table>
			<s:hidden name="documentValue" id="s_documentValue"/>
					<s:hidden name="propertyType" id="s_propertyType"/>
			<s:hidden name="token_date" id="token_date" />
		<s:hidden name="dummyTokenNo" id="dummyTokenNo" />
		<s:hidden name="dummyDistrictID" id="dummyDistrictID" />
		<s:hidden name="dummyDsrLocation" id="dummyDsrLocation" />
		<s:hidden name="dummyNavigationFlag" id="dummyNavigationFlag" />
		<s:hidden name="dummyTokenDate" id="dummyTokenDate" />
		<s:hidden name="dummyDeedID" id="dummyDeedID" />
		<s:hidden name="dummyFirstPartyName" id="dummyFirstPartyName" />
		<s:hidden name="dummyPresenterName" id="dummyPresenterName" />
		<s:hidden name="dummyFirstPartyExecutantCapacity"
			id="dummyFirstPartyExecutantCapacity" />
		<s:hidden name="dummyDeedCategoryId" id="dummyDeedCategoryId" />
		<s:hidden name="dummyConsideredAmount" id="dummyConsideredAmount" />
		<s:hidden name="dummyERegistrationId" id="dummyERegistrationId" />
		<s:hidden name="dummyStampNoWithVal" id="dummyStampNoWithVal" />
		<s:hidden name="dummyOriginalDeedTotalPageNo"
			id="dummyOriginalDeedTotalPageNo" />
		<s:hidden name="dummyCallNature" id="dummyCallNature" />
		<s:hidden name="language" id="language" />
		
		
			
		
	
	<div>
	<table width="100%">
	<s:if test="%{#parameters.page_id[0]==1}">
	<tr>
	<td colspan="6" align="center"><s:submit value="NEXT"/></td>
	</tr>
	</s:if>
	<s:else>
	<%-- <tr>
	<td colspan="6"><h2 class="ind2"><s:property value="getText('global.stamp_value_head')" /></h2></td>
	</tr>
	<tr style="background-color:#87BE50; height: 50px; vertical-align: middle; color:black;">
	<td style="font-size:20px; text-align: right" ><s:property value="getText('global.stamp_value')"/>:</td>
	<td id="stamp_value" class="amount_show"><s:textfield id="stamp_value" name="stamp_value" ></s:textfield></td>
	<td style="font-size:20px; text-align: right; color:black;" ><s:property value="getText('global.addl_stamp_value')"/>:</td>
	<td id="addl_stamp_value" class="amount_show"><s:textfield id="addl_stamp_value" name="addl_stamp_value" ></s:textfield></td>
	<td style="font-size:20px; text-align: right; color:black;"><s:property value="getText('global.cess_value')"/>:</td>
	<td id="cess_value" class="amount_show"><s:textfield id="cess_value" name="cess_value" ></s:textfield></td>
	</tr>
	<tr>
	<td colspan="6" style="text-align: center; color: red">IMPORTANT NOTE: à¤®à¥à¤¦à¥à¤°à¤¾à¤à¤ à¤¶à¥à¤²à¥à¤ à¤à¥ à¤à¤£à¤¨à¤¾ à¤®à¥à¤ à¤à¤¿à¤¸à¥ à¤­à¥ à¤ªà¥à¤°à¤à¤¾à¤° à¤à¤¾  à¤à¥à¤ à¤²à¤¾à¤à¥ à¤¨à¤¹à¥à¤  à¤¹à¥ à¤à¤° à¤¯à¥ à¤¸à¤¿à¤°à¥à¤« à¤µà¤¿à¤à¥à¤°à¤¯ à¤µà¤¿à¤²à¥à¤ à¤¸à¥ à¤¸à¤®à¥à¤¬à¤à¤§à¤¿à¤¤ à¤¹à¥à¥¤</td>
	</tr> --%>
	<tr>
	<td colspan="6" align="center">
					
					</td>
					</tr>
					</s:else>
	</table>
	</div>
	
	
	</s:form>	
	<s:if test="%{#parameters.page_id[0]==2}">
	<div style="text-align: center; width: 100%">
	<s:form action="StampValueEnquiryAction.action" method="get" theme="simple">
	<table align="center" width='100%'>
	<tr><td align="center">
					
					<input type="button" name="Exit" value="Exit" class="button" id="button_id"
					onClick="window.location.href='/IGRPortalWeb/reckonerSubAction';">
					&nbsp;
					<s:hidden name="documentValue" id="documentValue"/>
					<s:hidden name="propertyType" id="propertyType"/>
					<s:submit value="पंजीयन एब मुद्रांक शुल्क तदोपरान्त"></s:submit>
					<!--:submit value="à¤ªà¤à¤à¥à¤¯à¤¨ à¤à¤¬ à¤®à¥à¤¦à¥à¤°à¤¾à¤à¤ à¤¶à¥à¤²à¥à¤ à¤¤à¤¦à¥à¤ªà¤°à¤¾à¤¨à¥à¤¤">/s:submit-->
					</td>
					</tr>
					</table>
					</s:form>
	</div>
	</s:if>
                 </div>
                 
                      
                   
                
               <!--  <article class="grid_3">
                   <div class="indent">
                      <h2 class="ind2">News Update</h2>
                      <div id="newsticker01">
                  	<div class="newsticker-jcarousellite01">
                      <ul class="list p3">
                   		<li><a href="#">Praesent vestibum porster lore</a></li>
                   		<li><a href="#">Aenean non sren amet</a></li>
                   		<li><a href="#">Hendrerit mauris hasellus</a></li>
                   		<li><a href="#">Natoque penatibus ma</a></li>
                   	</ul>
                   	</div>
                   	</div>
                   	<a href="#" class="button top">Read More</a>
                   </div>
                    <div class="indent">
                      <h2 class="ind2">Notices</h2>
                      <div id="newsticker01">
                  	<div class="newsticker-jcarousellite01">
                      <ul class="list p3">
                   		<li><a href="#">Praesent vestibum porster lore</a></li>
                   		<li><a href="#">Aenean non sren amet</a></li>
                   		<li><a href="#">Hendrerit mauris hasellus</a></li>
                   		<li><a href="#">Natoque penatibus ma</a></li>
                   	</ul>
                   	</div>
                   	</div>
                   	<a href="#" class="button top">Read More</a>
                   </div>
                </article> -->
                   	
             </div><!--///wrapper-->             
	    </section>
       
       
	    
    </div>
	<!--==============================footer=================================-->
     <%@include file="../commonJsp/footer.jsp" %>

</div>

</body>
<script>
	window.history.forward(0);

	function globalAjaxEnquiry(value1, method) {

		try {
//alert
			
			var options = '';
			var blankOption = '<option selected value="">Select</option>';

			if (method == "AREA_TYPE") {
				var formInput = 'area_master_id=' + value1
						+ "&methodName=AREA_TYPE&district_id="
						+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;
				
				$("#area_type_name").html(options);
				$.getJSON('globalAjaxEnquiry.action', formInput, function(data) {
					options = '<option selected value="">Select Area Type</option>';
					$.each(data.globalList, function(i, item) {
						options += '<option value="' + item.typeCode + '">'
								+ item.typeDesc + '</option>';
					});

					$("#area_type_name").html(options);
					$("#ward_hal_no").html(blankOption);
					$("#ward_vill_name").html(blankOption);
					$("#locality_name").html(blankOption);
					$("#mohalla_vill_name").html(blankOption);
					$("#propert_type").html(blankOption);
					$("#tahaseel").html(blankOption);
					$("#revenue_district").html(blankOption);

				});
				document.getElementById("area_volume").value = "";
				document.getElementById("min_val").value = "";

			}

			if (method == "WARD_VILL_NAME") {
				var formInput = 'area_master_id='
						+ document.getElementById("area_master_id").value
						+ "&methodName=WARD_VILL_NAME&area_type_name=" + value1
						+ "&district_id="
						+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;

				$("#ward_vill_name").html(options);
				$.getJSON('globalAjaxEnquiry.action', formInput, function(data) {
					options = '<option selected value="">Select Ward Vill Name</option>';
					$.each(data.globalList, function(i, item) {
						options += '<option value="' + item.typeCode + '">'
								+ item.typeDesc + '</option>';
					});

					$("#ward_vill_name").html(options);
					$("#locality_name").html(blankOption);
					$("#mohalla_vill_name").html(blankOption);
					$("#propert_type").html(blankOption);
					$("#min_val").html('');
				});
				document.getElementById("area_volume").value = "";
				document.getElementById("min_val").value = "";
			}

			if (method == "MOHALLA_VILL_NAME") {
				var formInput = 'area_master_id='
						+ document.getElementById("area_master_id").value
						+ "&methodName=MOHALLA_VILL_NAME&area_type_name="
						+ document.getElementById("area_type_name").value
						+ "&ward_vill_name=" + value1 + "&district_id="
						+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;

				$("#mohalla_vill_name").html(options);
				$.getJSON('globalAjaxEnquiry.action', formInput, function(data) {
					options = '<option selected value="">Select Mohalla Vill Name</option>';
					$.each(data.globalList, function(i, item) {
						options += '<option value="' + item.typeCode + '">'
								+ item.typeDesc + '</option>';
					});

					$("#mohalla_vill_name").html(options);
					$("#propert_type").html(blankOption);
					$("#min_val").html('');
				})
				document.getElementById("area_volume").value = "";
				document.getElementById("min_val").value = "";
				;
			}

			if (method == "PROPERTY_TYPE") {
				var formInput = 'area_master_id='
						+ document.getElementById("area_master_id").value
						+ "&methodName=PROPERTY_TYPE&area_type_name="
						+ document.getElementById("area_type_name").value
						+ "&ward_vill_name="
						+ document.getElementById("ward_vill_name").value
						+ "&mohalla_vill_name=" + value1 + "&district_id="
						+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;
				

				$("#propert_type").html(options);
				$.getJSON('globalAjaxEnquiry.action', formInput, function(data) {
					options = '<option selected value="">Select Property Type</option>';
					$.each(data.globalList, function(i, item) {
						options += '<option value="' + item.typeCode + '">'
								+ item.typeDesc + '</option>';
					});

					$("#propert_type").html(options);
					$("#min_val").html('');
				});
				document.getElementById("area_volume").value = "";
				document.getElementById("min_val").value = "";
			}
			
			
			if (method == "FOUR_VALUE") {

				var formInput = 'area_master_id='
					+ document.getElementById("area_master_id").value
					+ "&methodName=FOUR_VALUE&area_type_name="
					+ document.getElementById("area_type_name").value
					+ "&ward_vill_name="
					+ document.getElementById("ward_vill_name").value
					+ "&mohalla_vill_name=" + document.getElementById("mohalla_vill_name").value + "&district_id="
					+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;
				
				$("#tahaseel").html(options);
				$("#revenue_district").html(options);
				$("#ward_hal_no").html(options);
				$("#locality_name").html(options);
				$.getJSON('globalAjaxEnquiry.action', formInput, function(data) {
					var res = data.four_value.split("~");
					document.getElementById("tahaseel").value =res[0];
					document.getElementById("revenue_district").value = res[1];
					document.getElementById("ward_hal_no").value = res[2];
					document.getElementById("locality_name").value = res[3];
				});
				
				document.getElementById("min_val").value = "";
				document.getElementById("area_volume").value = "";
			}

			if (method == "VALUATION") {

				var formInput = 'area_volume='
						+ document.getElementById("area_volume").value
						+ '&area_unit=' + value1
						+ "&methodName=VALUATION&propert_type="
						+ document.getElementById("propert_type").value
						+ "&district_id="
						+ document.getElementById("district_id").value+"&dsr_location="+document.getElementById("dsr_location").value;
				$("#min_val").html(options);
				$.getJSON('globalAjaxEnquiry.action', formInput, function(data) {
					/* alert(document.getElementById("page_id").value); */
					document.getElementById("min_val").value = data.min_val;
					document.getElementById("min_val_col").innerText=data.min_val;
					document.getElementById("s_propertyType").value = document.getElementById("page_id").value;
					document.getElementById("documentValue").value = data.min_val;
					document.getElementById("propertyType").value = document.getElementById("page_id").value;
					document.getElementById("s_documentValue").value = data.min_val;
					
					
					document.getElementById("stamp_value").value = data.stamp_value;
					document.getElementById("stamp_value").innerText=data.stamp_value;
					document.getElementById("addl_stamp_value").value = data.addl_stamp_value;
					document.getElementById("addl_stamp_value").innerText=data.addl_stamp_value;
					document.getElementById("cess_value").value = data.cess_value;
					document.getElementById("cess_value").innerText=data.cess_value;
					
				});
			}

		} catch (Exception) {
			alert("Error" + Exception);
		}
	}
	
	function loadAreaMaster(value)
	{
		 try{
			    var formInput= 'district_id='+ document.getElementById("district_id").value+"&language="+document.getElementById("language").value+"&dsr_location="+value;
			    var options='';   
			      $("#area_master_id").html(options);  
			      $.getJSON('loadAreaMaster.action', formInput,function(data) {
			    	options = '<option selected value="">Select</option>';
			    	$.each(data.areaTypeList, function(i,item){
			    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
			        });  
			          
			        $("#area_master_id").html(options);   
			    }); 
		
		 }  
		 catch(Exception){
			  alert("Error" + Exception);
		  }
	}
	

	function clearField() {
		document.getElementById("min_val").value = "";
		document.getElementById("area_volume").value = "";
	}


	function loadDSRLocationForProperty(value)
	{
		 try{
			    var formInput= 'district_id='+value+"&language="+document.getElementById("language").value;  

			    var options='';   
			      $("#dsr_location").html(options);  
			     
			      $.getJSON('loadDSRLocationForProperty.action', formInput,function(data) {
			    	options = '<option selected value="">Select Office List</option>';
			    	$.each(data.dsrLocationList, function(i,item){
			    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
			        });  
			          
			        $("#dsr_location").html(options);   
			    }); 
		
		 }  catch(Exception)
		  {
			  alert("Error" + Exception);
		  }
	}
	

	/* 
	 function addTable(tableID) {
	 var table = document.getElementById(tableID);
	 var rowCount = table.rows.length;
	 var row = table.insertRow(rowCount);
	 var colCount = table.rows[0].cells.length;
	 for (var i = 0; i < colCount; i++) {
	 var newcell = row.insertCell(i);
	 newcell.innerHTML = table.rows[0].cells[i].innerHTML;
	 //alert(newcell.childNodes);
	 switch (newcell.childNodes[0].type) {
	 case "text":
	 newcell.childNodes[0].value = "";
	 break;
	 case "checkbox":
	 newcell.childNodes[0].checked = false;
	 break;
	 case "select-one":
	 newcell.childNodes[0].selectedIndex = 0;
	 break;
	 }
	 }

	 document.getElementById("rowNumber").value = rowCount + 1;

	 }

	 function deleteTable(count, tableID) {

	 var i = count.parentNode.parentNode.rowIndex;
	 var table = document.getElementById(tableID);
	 var noOfRows = table.rows.length;
	 if (noOfRows > 1) {
	 document.getElementById(tableID).deleteRow(i);
	 document.getElementById("rowNumber").value = noOfRows - 1;

	 }

	 else {
	 alert("Minimum one party type is required");

	 }
	 } */
</script>
</html>