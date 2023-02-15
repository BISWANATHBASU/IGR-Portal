<!DOCTYPE html>

<html lang="en">
<head>
    <title>संरचना मूल्यांकन गणना</title><!-- à¤¸à¤à¤°à¤à¤¨à¤¾ à¤®à¥à¤²à¥à¤¯à¤¾à¤à¤à¤¨ à¤à¤£à¤¨à¤¾ -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/breadcrumb.css">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/mycss.css">
    <%@include file="../commonJsp/include.jsp" %>
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
						<li>
						<s:url action="indexAction" var="index"/>
						<a href="<s:property value='#index'/>">मुख्य पृष्ठ<!--à¤®à¥à¤à¥à¤¯ à¤ªà¥à¤·à¥à¤ --></a></li>
						<li><s:url action="reckonerSubAction" var="rec_sub"/>
						<a href="<s:property value='#rec_sub'/>">रेडी रेकोनर<!--à¤°à¥à¤¡à¥ à¤°à¥à¤à¥à¤¨à¤°--></a></li>
						<li class="active"><span><s:property
							value="getText('global.structure_details_head_portal')" /></span></li>
					</ol>				
               	   </div>
               </article>
               <article class="grid_9">
                   <div class="indent">
                   <h2 class="ind2"><s:property
							value="getText('global.structure_details_head_portal')" /></h2>
                   </div> <!-- indent div -->
                   </article>
                <div class="logincss"> 
                   
                     
             
                      <s:form action="StampValueEnquiryAction" validate="true" method="get"
		namespace="/"  theme="simple">
		<s:token />
					<table width="100%" border="2" >
							<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />
							<tr>
								<td class="tdlabel"><s:property
										value="getText('global.AREA_TYPE')" />*:</td>
								<td class="tdfield"><s:select headerKey=""
										headerValue="Select" list="areaTypeList" listKey="typeCode"
										id="area_type" listValue="typeDesc" name="area_type" onchange="clearField();"
										cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
										fieldName="area_type" theme="igr" cssClass="smallErrorMsg" /></td>
								<td class="tdlabel"><s:property
										value="getText('global.property_type')" />*:</td>
								<td class="tdfield"><s:select headerKey=""
										headerValue="Select" list="constractionTypeList"
										listKey="typeCode" listValue="typeDesc"
										name="type_construction" id="type_construction" onchange="clearField();"
										cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
										fieldName="type_construction" theme="igr"
										cssClass="smallErrorMsg" />
								</td>
							</tr>
							<tr>
								<td class="tdlabel"><s:property
										value="getText('global.structure.uses')" />*:</td>
								<td class="tdfield"><s:select headerKey=""
										headerValue="Select" list="usesTypeList" listKey="typeCode"
										id="use_construction" listValue="typeDesc" onchange="clearField();"
										name="use_construction" cssClass="largecombobox"
										theme="simple" required="true" /> <s:fielderror
										fieldName="use_construction" theme="igr" cssClass="smallErrorMsg" /></td>
									<td class="tdlabel"><s:property
										value="getText('global.structure_type')" />*:</td>
								<td class="tdfield"><s:select headerKey=""
										headerValue="Select" list="structureList" listKey="typeCode"
										id="structure" listValue="typeDesc" 
										name="structure" cssClass="largecombobox"
										theme="simple" required="true" /> <s:fielderror
										fieldName="structure" theme="igr" cssClass="smallErrorMsg" />
								</td>	

							</tr>
							<tr>
							
							<td class="tdlabel"><s:property
										value="getText('global.area_volumn')" />*:</td>
								<td class="tdfield">
								<s:textfield name="area_volume"
										id="area_volume" cssClass="tdfield" required="true"
										theme="simple" maxlength="10">
										<s:fielderror fieldName="area_volume" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
								<td class="tdlabel"><s:property
										value="getText('global.structure_unit')" />*:</td>
								<td class="tdfield">
								
								<s:select headerKey=""
										headerValue="Select" list="structureUnitList" listKey="typeCode"
										id="structure_unit" listValue="typeDesc" name="structure_unit" onchange="calculateValue(this.value);"
										cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
										fieldName="structure_unit" theme="igr" cssClass="smallErrorMsg" /></td>

							</tr>

							<tr>
							<td align="center" ><s:property
										value="getText('global.structure_valuation')" />*:</td>
								<td class="amount_show">
								<div id="valuation_col"></div>
								<s:textfield name="valuation" id="valuation" readonly="true" style="font-size:25px;" />
							<td align="center"><s:property
										value="getText('global.prop_valuation')" />*:</td>
							<td align="center" class="amount_show"><s:property value="#session.min_val"/></td>
										
							</tr>
							<tr>
							<td align="center" colspan="2"><s:property
										value="getText('global.prop_and_struc_valuation')" />*:</td>
								<td class="amount_show" id="total_valuation_col" colspan="2">
								<s:textfield name="total_valuation" id="total_valuation" readonly="true" style="font-size:25px;" />
										</td>
							
							</tr>
							</table>
							<table width="100%" >
							<%--<tr>
	<td colspan="4"><h2 class="ind2"><s:property value="getText('global.stamp_value_head')" /></h2></td>
	</tr>
	 <tr style="background-color:#87BE50; height: 50px; vertical-align: middle;">
	<td style="font-size:20px; text-align: right; color: black;"><s:property value="getText('global.stamp_value')"/>:</td>
	<td id="stamp_value" class="amount_show"><s:textfield id="stamp_value" name="stamp_value" ></s:textfield></td>
	<td style="font-size:20px; text-align: right; color: black;"><s:property value="getText('global.addl_stamp_value')"/>:</td>
	<td id="addl_stamp_value" class="amount_show"><s:textfield id="addl_stamp_value" name="addl_stamp_value" > </s:textfield></td>
	<tr>
	<td colspan="4" style="text-align: center; color: red">IMPORTANT NOTE: à¤®à¥à¤¦à¥à¤°à¤¾à¤à¤ à¤¶à¥à¤²à¥à¤ à¤à¥ à¤à¤£à¤¨à¤¾ à¤®à¥à¤ à¤à¤¿à¤¸à¥ à¤­à¥ à¤ªà¥à¤°à¤à¤¾à¤° à¤à¤¾  à¤à¥à¤ à¤²à¤¾à¤à¥ à¤¨à¤¹à¥à¤  à¤¹à¥ à¤à¤° à¤¯à¥ à¤¸à¤¿à¤°à¥à¤« à¤µà¤¿à¤à¥à¤°à¤¯ à¤µà¤¿à¤²à¥à¤ à¤¸à¥ à¤¸à¤®à¥à¤¬à¤à¤§à¤¿à¤¤ à¤¹à¥à¥¤</td>
	</tr> --%>
	
	<tr>
							<td colspan="4" align="center"><input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='/IGRPortalWeb/reckonerSubAction';">
					<s:submit value="पंजीयन एब मुद्रांक शुल्क तदोपरान्त"></s:submit><!-- à¤ªà¤à¤à¥à¤¯à¤¨ à¤à¤¬ à¤®à¥à¤¦à¥à¤°à¤¾à¤à¤ à¤¶à¥à¤²à¥à¤ à¤¤à¤¦à¥à¤ªà¤°à¤¾à¤¨à¥à¤¤ -->
					</td>
							</tr>
						</table>
			<s:hidden name="token_date" id="token_date" />
		<s:hidden name="dsr_location" id="dsr_location" />
		<s:hidden name="district_id" id="district_id" />
			 <s:hidden name="dummyTokenNo" id="dummyTokenNo"/>			
							<s:hidden name="dummyDistrictID" id="dummyDistrictID"/>
							<s:hidden name="dummyDsrLocation" id="dummyDsrLocation"/>
							<s:hidden name="dummyNavigationFlag" id="dummyNavigationFlag"/>
							<s:hidden name="dummyTokenDate" id="dummyTokenDate"/>
							<s:hidden name="dummyDeedID" id="dummyDeedID"/>
							<s:hidden name="dummyFirstPartyName" id="dummyFirstPartyName"/>
		
							<s:hidden name="dummyPresenterName" id="dummyPresenterName"/>			
<s:hidden name="dummyFirstPartyExecutantCapacity" id="dummyFirstPartyExecutantCapacity"/>
<s:hidden name="dummyDeedCategoryId" id="dummyDeedCategoryId"/>
<s:hidden name="dummyConsideredAmount" id="dummyConsideredAmount"/>
<s:hidden name="dummyERegistrationId" id="dummyERegistrationId"/>
<s:hidden name="dummyStampNoWithVal" id="dummyStampNoWithVal"/>
<s:hidden name="dummyOriginalDeedTotalPageNo" id="dummyOriginalDeedTotalPageNo"/>
<s:hidden name="dummyCallNature" id="dummyCallNature"/>
<s:hidden name="dummyTotalStampValue" id="dummyTotalStampValue"/>
		
		<s:hidden name="documentValue" id="documentValue"/>
		<input type="hidden" name="propertyType" id="propertyType" value='<%=request.getParameter("page_id")%>'/>
					<%System.out.println(request.getParameter("page_id")); %>

	</s:form>
           	  
            		
                      
                      
                   </div> <!-- indent div -->
                
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

function clearField()
{
	document.getElementById("valuation").value="";
	document.getElementById("area_volume").value="";
}


	function calculateValue(value1) {

		var options = '';
		try {

			var area = document.getElementById("area_volume").value;
			//alert("Muzzakkir = area="+area+"<<<");
			if ((area == '') || (isNaN(area)) || (area.trim().length == 0)) {
				alert("Input Area Volume Properly");
				document.getElementById("area_volume").value = "";
				document.getElementById("area_volume").focus();
			}

			else {
				var formInput = 'area_type='
						+ document.getElementById("area_type").value
						+ '&type_construction='
						+ document.getElementById("type_construction").value
						+ '&use_construction='
						+ document.getElementById("use_construction").value
						+ '&area_volume=' + document.getElementById("area_volume").value+"&structure_unit="+value1;

				$("#valuation").html(options);
				$
						.getJSON(
								'structureValuationEnquiry.action',
								formInput,
								function(data) {
									//alert(data.valuation);
									//alert(formInput);
									document.getElementById("valuation").value = data.valuation;
									document.getElementById("total_valuation").value = data.total_valuation;
									document.getElementById("documentValue").value = data.total_valuation;
									//document.getElementById("valuation_col").innerHTML=data.valuation;
									//document.getElementById("total_valuation_col").innerHTML = data.total_valuation;
									//document.getElementById("stamp_value").value = data.stamp_value;
									//document.getElementById("stamp_value").innerHTML=data.stamp_value;
									//document.getElementById("addl_stamp_value").value = data.addl_stamp_value;
									//document.getElementById("addl_stamp_value").innerHTML=data.addl_stamp_value;
								});
			}

		} catch (Exception) {
			alert("Error" + Exception);
		}

	}
</script>
</html>