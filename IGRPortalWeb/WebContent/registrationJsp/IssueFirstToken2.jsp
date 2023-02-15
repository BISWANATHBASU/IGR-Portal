<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
	<s:form action="IssueFirstTokenAction" validate="true" namespace="/"
		method="post" enctype="multipart/form-data">
		<s:token />

		<div align="center" class="formCaption"><s:property
							value="getText('global.first_token_head')" /></div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />


				<tr>
				<td class="tdLabel"><s:property value="getText('global.name')" />*:</td>
				<td class="field"><s:textfield name="presenter_name"
						cssClass="field" required="true"
						theme="simple" maxlength="100"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="presenter_name" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
				
				<td class="tdLabel"><s:property value="getText('global.party_type_name')" />*:</td>
				<td class="field"><s:select headerKey="" headerValue="Select"
							list="party_type_List" listKey="typeCode" listValue="typeDesc"
							name="party_type" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="party_type"
							theme="igr" cssClass="smallErrorMsg" /></td>
				
						
				</tr>
				<tr>
			
			<td class="tdLabel"><s:property value="getText('global.relation')" />*:</td>
				<td class="field"><!--s:select headerKey="" headerValue="Select"
							list="relationList" listKey="typeCode"
							listValue="typeDesc" name="presenter_fh_rel"
							cssClass="combobox" theme="simple" required="true" /--> <s:fielderror
							fieldName="presenter_fh_rel" theme="igr"
							cssClass="smallErrorMsg" /></td>
			
				<td class="tdLabel"><s:property value="getText('global.gurdianname')" />*:</td>
				<td class="field"><s:textfield name="presenter_fh_name"
						cssClass="field" required="true"
						theme="simple" maxlength="100"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="presenter_fh_name" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
				</tr>

				<tr>
			
				<td class="tdLabel"><s:property value="getText('global.address')" />*:</td>
				<td class="field"><s:textfield name="presenter_address"
						cssClass="field" required="true"
						theme="simple" maxlength="100"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="presenter_address" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
			
					<td class="tdLabel"><s:property
							value="getText('global.state')" />*:</td>
					<td  class="field" ><s:select list="stateList" listKey="typeCode" listValue="typeDesc"
							name="presenter_state" cssClass="largecombobox" theme="simple"
							required="true" /> <s:fielderror fieldName="presenter_state"
							theme="igr" cssClass="smallErrorMsg" /></td>
							
				</tr>
				
				<tr>
				  <td class="tdLabel"><s:property value="getText('global.pin')" />:</td>
				<td class="field"><s:textfield name="presenter_pin"
						cssClass="field" 
						theme="simple" maxlength="6">
						<s:fielderror fieldName="presenter_pin" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
				
				
 <td class="tdLabel"><s:property value="getText('global.district')" />*:</td>
<td class="field">
<s:select 				list="districtList" listKey="typeCode" listValue="typeDesc"
							name="district_id" cssClass="combobox" theme="simple"
							id="district_id"
							onchange="loadDSRLocation(this.value);"
							required="true" /> <s:fielderror fieldName="district_id"
							theme="igr" cssClass="smallErrorMsg" />
</td>
</tr>

<tr>
<td class="tdLabel"><s:property
							value="getText('global.phone_no')" />*:</td>
			  <td class="field"><s:textfield name="presenter_phone_no"
						cssClass="field" 
						theme="simple" maxlength="10" required="true">
						<s:fielderror fieldName="presenter_phone_no" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	

							
	
				
		
				  <td class="tdLabel"><s:property value="getText('global.email_id')" />:</td>
				<td class="field"><s:textfield name="presenter_email_id"
						cssClass="field" 
						theme="simple" maxlength="100">
						<s:fielderror fieldName="presenter_email_id" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	





</tr>




<tr>
 <td class="tdLabel"><s:property value="getText('global.sub_register_office')" />*:</td>
<td class="field">
<s:select 				list="dsrLocationList" listKey="typeCode" listValue="typeDesc"
							name="dsr_location" cssClass="combobox" theme="simple"
							id="dsr_location"
							required="true" /> <s:fielderror fieldName="dsr_location"
							theme="igr" cssClass="smallErrorMsg" />
</td>


<td class="tdLabel"><s:property
							value="getText('global.Deed_Type_Name')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="deedTypeList" listKey="typeCodeDesc"
							listValue="typeDesc" name="deed_type_id" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="deed_type_id" theme="igr" cssClass="smallErrorMsg" /></td>		
			
</tr>


<tr>
				 
				 <td class="tdLabel"><s:property
							value="getText('global.total_page_no')" />*:</td>
					<td class="field"><s:textfield name="total_page_no" id="total_page_no" 
							cssClass="shortfieldrowwise" required="true" 
							theme="simple" maxlength="5">
							<s:fielderror fieldName="total_page_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
						<td class="tdLabel">दस्तावेज अपलोड करें *:</td>
						<td><s:file name="fileUpload" label="File" size="40" theme="simple" /></td>
                 </tr>
				
			</table>

			<div align="center">
				<s:submit method="addFirstToken" cssClass="button" value="Submit" theme="simple" />
				<s:if test="printFlag==true">
				
				<s:url action="IssueSecondTokenAction.action" var="secondToken">
				
										<s:param name="token_no">
											<s:property value="dummyTokenNo" />
										</s:param>
				
										<s:param name="presenter_name">
											<s:property value="dummyPresenterName" />
										</s:param>	
										
										<s:param name="party_type">
											<s:property value="dummyPartyType" />
										</s:param>	
										
										
										<s:param name="dsr_location">
											<s:property value="dummyDsrLocation" />
										</s:param>	
										
										
											<s:param name="firstTokenDate">
											<s:property value="dummyTokenDate" />
										</s:param>	
				</s:url>
				
				<s:a href="%{secondToken}">
				<input type="button" name="Next" value="Next" class="button">			
				</s:a>
				<input type="button" name="Print" value="Print" class="button"
					onClick="openReport();">	
				</s:if>
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitSecondToken';">			
			</div>
			
<s:hidden name="dummyTokenNo" id="dummyTokenNo"/>
<s:hidden name="dummyTokenDate" id="dummyTokenDate"/>
<s:hidden name="dummyPresenterName" id="dummyPresenterName"/>			
<s:hidden name="dummyDsrLocation" id="dummyDsrLocation"/>
<s:hidden name="dummyPartyType" id="dummyPartyType"/>
<s:hidden name="dummyTokenDateReport" id="dummyTokenDateReport"/>
<s:hidden name="token_no" id="token_no"/>
<s:hidden name="language" id="language"/>
				
	</s:form>
</body>

<script>
window.history.forward(0);


function openReport() {
	
	
	var targetString="ReportAction.action?reportPath=/report/IGR_FIRST_TOKEN_SINGLE.jasper&reportName=IGR_FIRST_TOKEN&event=NOEVENT&token_no="+document.getElementById("dummyTokenNo").value+"&token_date="+document.getElementById("dummyTokenDateReport").value
			window.open(targetString,"","width=400, height=400,menubar=yes,location=1,status=1,scrollbars=yes,resizable=yes");
}

function loadDSRLocation(value){
    //alert("loadDSRLocation="+value);
    try{
        var formInput= 'district_id='+value+"&language="+document.getElementById("language").value;  
        var options='';   
          $("#dsr_location").html(options);  
          $.getJSON('loadDSRLocation.action', formInput,function(data) {
            options = '<option selected value="">Select</option>';
            $.each(data.dsrLocationList, function(i,item){
                //alert("item.typeDesc="+item.typeDesc);
                options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
            });
            //alert(options);

            $("#dsr_location").html(options);   
        }); 

    }  catch(Exception){
        alert("Error" + Exception);
    }
}
</script>

</html>

<%@include file="../commonJsp/footer.inc"%>
