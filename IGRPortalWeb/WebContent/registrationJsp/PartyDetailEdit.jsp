<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
	<s:form action="PartyDetailEditAction" validate="true" namespace="/" method="post">
		<s:token />

		<div align="center" class="formCaption"><s:property
							value="getText('global.party_detail_head')" /></div>

		<div align="center"></div>
			<table  id="partyDetailTable" class="largeAppFormBlock" align="center" cellspacing="2px" cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />


			
			<tr>		
					<td class="tdLabel"><s:property
							value="getText('global.Deed_Type_Name')" />*:</td>
					<td><s:select list="deedTypeList" listKey="typeCode"
							listValue="typeDesc" name="deed_type_id" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="deed_type_id" theme="igr" cssClass="smallErrorMsg" />
					</td>
					 	
					
					<td class="tdLabel"><s:property
							value="getText('global.party_party_type')" />*:</td>	
					<td><s:select list="partyTypeList" headerKey="" headerValue="Select" listKey="typeCode"
							listValue="typeDesc" name="party_type_id" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="party_type_id" theme="igr" cssClass="smallErrorMsg" />
					</td>
			</tr>
		 	<tr>
			<td class="tdLabel"><s:property value="getText('global.party_party_name')" />*:</td>	
			<td class="field"><s:textfield name="party_name"
						cssClass="field" required="true"
						theme="simple" maxlength="100"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="party_name" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
			<td class="tdLabel"><s:property value="getText('global.relation')" />*:</td>
			<td class="field"><s:select headerKey="" headerValue="Select"
							list="relationList" listKey="typeCode"
							listValue="typeDesc" name="party_fh_rel"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="party_fh_rel" theme="igr"
							cssClass="smallErrorMsg" /></td>			
				
			</tr>
				  
				<tr>
				<td class="tdLabel"><s:property value="getText('global.gurdianname')" />*:</td>
				
				<td class="field"><s:textfield name="party_fh_rel_name"
						cssClass="field" required="true"
						theme="simple" maxlength="100"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="party_fh_rel_name" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
				<td class="tdLabel"><s:property value="getText('global.address')" />*:</td>	
					<td class="field"><s:textfield name="address"
						cssClass="field" required="true"
						theme="simple" maxlength="100"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="address" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
				
				</tr>	
				<tr>
				<td class="tdLabel"><s:property value="getText('global.pan')" />:</td>
				<td class="field"><s:textfield name="pan_no"
						cssClass="field" 
						theme="simple" maxlength="10"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="pan_no" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				<td class="tdLabel"><s:property value="getText('global.ph_no')" />*:</td>
				<td class="field"><s:textfield name="ph_no"
						cssClass="field" required="true"
						theme="simple" maxlength="10"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="ph_no" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>	
					
				</td>	
				</tr>
				<tr>
				<td class="tdLabel"><s:property value="getText('global.profession')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="professionList" listKey="typeCode"
							listValue="typeDesc" name="profession"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="profession" theme="igr"
							cssClass="smallErrorMsg" /></td>
				
				<td class="tdLabel"><s:property value="getText('global.gender')" />*:</td>
					
			
				<td class="field"><s:select headerKey="" headerValue="Select"
							list="sexList" listKey="typeCode"
							listValue="typeDesc" name="gender"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="gender" theme="igr"
							cssClass="smallErrorMsg" /></td>
				
				
				
				</tr>
				
				<tr>
				<td class="tdLabel"><s:property value="getText('global.caste')" />*:</td>
				<td class="field"><s:select headerKey="" headerValue="Select"
							list="casteList" listKey="typeCode"
							listValue="typeDesc" name="caste" onchange="loadSubCaste(this.value);"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="caste" theme="igr"
							cssClass="smallErrorMsg" /></td>
							
			  	<td  class="tdLabel"><s:property value="getText('global.sub_caste')" />:</td>
				<td class="field"><s:select headerKey="" headerValue="Select"
							list="subCasteList" listKey="typeCode"
							listValue="typeDesc" name="sub_cast"
							cssClass="combobox" theme="simple" /> <s:fielderror
							fieldName="sub_cast" theme="igr"
							cssClass="smallErrorMsg" /></td>
				</tr>
				
				
				<tr>
				<td class="tdLabel"><s:property value="getText('global.addressprooftype')" />*:</td>
				<td class="field"><s:select headerKey="" headerValue="Select"
							list="addressprooftypeList" listKey="typeCode"
							listValue="typeDesc" name="address_proof"
							cssClass="combobox" theme="simple" required="true" /> <s:fielderror
							fieldName="address_proof" theme="igr"
							cssClass="smallErrorMsg" /></td>
				<td class="tdLabel"><s:property value="getText('global.addressproofvalue')" />*:</td>
					<td class="field"><s:textfield name="address_proof_value"
						cssClass="field" required="true"
						theme="simple" maxlength="20"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="address_proof_value" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>	
				</tr>
				
				<s:if test="language==1">
				<tr>
				<td class="tdLabel"><s:property value="getText('global.party_name_hindi')" />*:</td>	
			<td class="field"><s:textfield name="party_name_hindi"
						cssClass="field" required="true"
						theme="simple" maxlength="100"
						onblur="javascript:this.value=this.value.toUpperCase();">
						<s:fielderror fieldName="party_name_hindi" theme="igr"
							cssClass="smallErrorMsg" />
					</s:textfield>
				</td>
				
				<td class="tdLabel"><s:property
							value="getText('global.biometric_required')" />*:</td>
						<td  class="field" ><s:select 
							list="biometric_required_list" listKey="typeCode" listValue="typeDesc"
							name="biometric_required" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="biometric_required"
							theme="igr" cssClass="smallErrorMsg" /></td>			
				</tr>
				</s:if>
				
				<s:if test="language==2">
				<tr>
				<td colspan="2" class="tdLabel"><s:property
							value="getText('global.biometric_required')" />*:</td>
						<td colspan="2"  class="field" ><s:select 
							list="biometric_required_list" listKey="typeCode" listValue="typeDesc"
							name="biometric_required" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="biometric_required"
							theme="igr" cssClass="smallErrorMsg" /></td>			
				</tr>
				</s:if>
				
				
	

</table>
<div align="center">
				<s:submit method="editPartyDetail" cssClass="button" value="Update"
					theme="simple" />
					
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitPartyDetailEdit';">
				
			</div>
				<s:hidden name="token_date" id="token_date" />
				<s:hidden name="dsr_location" id="dsr_location" />
				<s:hidden name="token_no" id="token_no" />
				<s:hidden name="partyID" id="partyID" />
				<s:hidden name="addressProofArray" id="addressProofArray" />
				<s:hidden name="deed_category_id" id="deed_category_id" />
				<s:hidden name="considered_amount" id="considered_amount" />
					<s:hidden name="language" id="language" />
				
	</s:form>
</body>
<script type="text/javascript">
window.history.forward(0);


function loadSubCaste(value)  
{
	
	  try{
	    var formInput= 'caste='+value+"&language="+document.getElementById("language").value;  
	    var options='';   
	      $("#sub_cast").html(options);  
	      $.getJSON('loadSubCast.action', formInput,function(data) {
	    	options = '<option selected value="">Select</option>';
	    	$.each(data.subCasteList, function(i,item){
	    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
	        });  
	          
	        $("#deed_category").html(options);   
	    });  
	  }
	  catch(Exception)
	  {
		  alert("Error" + Exception);
	  }
	
	
}	

</script>

</html>
<%@include file="../commonJsp/footer.inc"%>
