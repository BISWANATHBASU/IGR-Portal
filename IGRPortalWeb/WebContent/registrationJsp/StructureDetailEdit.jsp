<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
	<s:form action="StructureDetailEditAction" validate="true"
		namespace="/" method="post">
		<s:token />

		<div align="center" class="formCaption"><s:property
							value="getText('global.structure_detail_head')" /></div>

		<div align="center">
							<table class="appFormBlock" align="center" cellspacing="2px"
							cellpadding="1px">
							<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />
							<tr>
								<td class="tdLabel"><s:property
										value="getText('global.Token_No')" />*:</td>
								<td class="field"><s:textfield name="token_no"
										cssClass="shortfieldrowwise readOnlyField" readonly="true"
										theme="simple" maxlength="20">
										<s:fielderror fieldName="token_no" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>

								<td class="tdLabel"><s:property
										value="getText('global.AREA_TYPE')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="areaTypeList" listKey="typeCode"
										id="area_type" listValue="typeDesc" name="area_type" onchange="clearField();"
										cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
										fieldName="area_type" theme="igr" cssClass="smallErrorMsg" /></td>

							</tr>
							<tr>
								<td class="tdLabel"><s:property
										value="getText('global.property_type')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="constractionTypeList"
										listKey="typeCode" listValue="typeDesc"
										name="type_construction" id="type_construction" onchange="clearField();"
										cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
										fieldName="area_type_name" theme="igr"
										cssClass="smallErrorMsg" /></td>


								<td class="tdLabel"><s:property
										value="getText('global.structure.uses')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="usesTypeList" listKey="typeCode"
										id="use_construction" listValue="typeDesc" onchange="clearField();"
										name="use_construction" cssClass="largecombobox"
										theme="simple" required="true" /> <s:fielderror
										fieldName="ward_hal_no" theme="igr" cssClass="smallErrorMsg" /></td>

							</tr>

							<tr>
								<td class="tdLabel"><s:property
										value="getText('global.structure_name')" />*:</td>
								<td class="field"><s:textfield name="structure_name"
										cssClass="field" required="true" theme="simple" maxlength="20">
										<s:fielderror fieldName="structure_name" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>


								<td class="tdLabel"><s:property
										value="getText('global.structure_no')" />*:</td>
								<td class="field"><s:textfield name="structure_no"
										cssClass="field" required="true" theme="simple" maxlength="20">
										<s:fielderror fieldName="structure_no" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>

							</tr>
							
							<tr>
							<td class="tdLabel"><s:property
										value="getText('global.structure_type')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="structureList" listKey="typeCode"
										id="structure" listValue="typeDesc" 
										name="structure" cssClass="largecombobox"
										theme="simple" required="true" /> <s:fielderror
										fieldName="structure" theme="igr" cssClass="smallErrorMsg" /></td>
							
							
							
							<td class="tdLabel"><s:property
										value="getText('global.structure_age')" />*:</td>
								<td class="field"><s:textfield name="ageOfStructure" id="ageOfStructure"
										cssClass="field" required="true" theme="simple" maxlength="4">
										<s:fielderror fieldName="ageOfStructure" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
							
							
							</tr>
							
							<tr>
							
							<td class="tdLabel"><s:property
										value="getText('global.structure_owner')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="structureList" listKey="typeCode"
										id="structure_owner" listValue="typeDesc" 
										name="structure_owner" cssClass="largecombobox"
										theme="simple" required="true" /> <s:fielderror
										fieldName="structure_owner" theme="igr" cssClass="smallErrorMsg" /><%-- 
								
								<s:textfield name="structure_owner"
										cssClass="field" required="true" theme="simple" maxlength="20">
										<s:fielderror fieldName="structure_owner" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield> --%></td>
							
							
								<td class="tdLabel"><s:property
										value="getText('global.floor')" />*:</td>
								<td class="field"><s:textfield name="floor" id="floor"
										cssClass="field" required="true" theme="simple" maxlength="10"
										onBlur="clearField();">
										<s:fielderror fieldName="floor" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>


								

							</tr>
							<tr>
							<td class="tdLabel"><s:property
										value="getText('global.area_volumn')" />*:</td>
								<td class="field"><s:textfield name="area_volume"
										id="area_volume" cssClass="field" required="true"
										theme="simple" maxlength="10" onBlur="clearValue();">
										<s:fielderror fieldName="area_volume" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
							
							
							
							<td class="tdLabel"><s:property
										value="getText('global.structure_unit')" />*:</td>
								<td class="field"><s:select headerKey=""
										headerValue="Select" list="structureUnitList" listKey="typeCode"
										id="structure_unit" listValue="typeDesc" name="structure_unit" onchange="calculateValueEdit(this.value);"
										cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
										fieldName="structure_unit" theme="igr" cssClass="smallErrorMsg" /></td>
							
							

								
							</tr>

							<tr>
							<td colspan="2" class="tdLabel"><s:property
										value="getText('global.valuation')" />*:</td>
								<td colspan="2" class="field"><s:textfield name="valuation"
										id="valuation" cssClass="field readOnlyField" readonly="true"
										theme="simple" maxlength="20">
										<s:fielderror fieldName="valuation" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
							
							</tr>


						</table>
				


			<div align="center">
				<s:submit method="editStructureDetail" cssClass="button"
					value="Update" theme="simple" />

			
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitStructureDetailEdit';">

			</div>
		</div>
		<s:hidden name="token_date" id="token_date" />
		<s:hidden name="dsr_location" id="dsr_location" />
		<s:hidden name="district_id" id="district_id" />
		<s:hidden name="structureID" id="structureID" />
		<s:hidden name="deed_type_id" id="deed_type_id" />
		<s:hidden name="deed_category_id" id="deed_category_id" />
		<s:hidden name="considered_amount" id="considered_amount" />
	</s:form>
</body>
<script>
window.history.forward(0);


function clearField()
{
	document.getElementById("valuation").value="";
	document.getElementById("area_volume").value="";
}


function clearValue()
{
	document.getElementById("valuation").value="";
}

	function calculateValueEdit(value1) {

		var options = '';
		try {

			var area = document.getElementById("area_volume").value
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
								'structureValuationEdit.action',
								formInput,
								function(data) {
									document.getElementById("valuation").value = data.valuation;
								});
			}

		} catch (Exception) {
			alert("Error" + Exception);
		}

	}
</script>


</html>
<%@include file="../commonJsp/footer.inc"%>
