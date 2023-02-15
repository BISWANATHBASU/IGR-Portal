<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
	<s:form action="PropertyDetailEditAction" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption"><s:property
							value="getText('global.property_detail_head')" /></div>

		<div align="center">
			<table class="appFormBlock" id="propertyDetailTable" align="center"
				cellspacing="2px" cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Token_No')" />*:</td>
					<td class="field"><s:textfield name="token_no" id="token_no"
							cssClass="shortfieldrowwise readOnlyField" readonly="true"
							theme="simple" maxlength="20">
							<s:fielderror fieldName="token_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><s:property
							value="getText('global.AREA_TYPE')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="areaTypeList" listKey="typeDesc" id="area_master_id"
							listValue="typeDesc" name="area_master_id"
							onchange="globalAjaxEdit(this.value,'AREA_TYPE');"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="area_master_id" theme="igr" cssClass="smallErrorMsg" /></td>

				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.AREA_TYPE_NAME')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="areaTypeNameList" listKey="typeCode"
							onchange="globalAjaxEdit(this.value,'TAHASEEL');"
							listValue="typeDesc" name="area_type_name" id="area_type_name"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="area_type_name" theme="igr" cssClass="smallErrorMsg" /></td>



					<td class="tdLabel"><s:property
							value="getText('global.tahaseel')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="tahaseelList" listKey="typeCode" id="tahaseel"
							listValue="typeDesc" name="tahaseel"
							onchange="globalAjaxEdit(this.value,'REVENUE_DISTRICT');"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="tahaseel" theme="igr" cssClass="smallErrorMsg" /></td>

				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.revenue_district')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="revenueDistrictList" listKey="typeCode"
							id="revenue_district" listValue="typeDesc"
							name="revenue_district"
							onchange="globalAjaxEdit(this.value,'WARD_HALL_NO');"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="revenue_district" theme="igr" cssClass="smallErrorMsg" /></td>


					<td class="tdLabel"><s:property
							value="getText('global.WRD_HAL_NO')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="wardHallNoList" listKey="typeCode" id="ward_hal_no"
							listValue="typeDesc" name="ward_hal_no"
							onchange="globalAjaxEdit(this.value,'WARD_VILL_NAME');"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="ward_hal_no" theme="igr" cssClass="smallErrorMsg" /></td>

				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.WARD_VILL_NAME')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="wardVillNameList" listKey="typeCode" listValue="typeDesc"
							name="ward_vill_name"
							onchange="globalAjaxEdit(this.value,'LOCALITY_NAME');"
							id="ward_vill_name" cssClass="largecombobox" theme="simple"
							required="true" /> <s:fielderror fieldName="ward_vill_name"
							theme="igr" cssClass="smallErrorMsg" /></td>


					<td class="tdLabel"><s:property
							value="getText('global.LOCALITY_NAME')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="localityNameList" listKey="typeCode" id="locality_name"
							listValue="typeDesc"
							onchange="globalAjaxEdit(this.value,'MOHALLA_VILL_NAME');"
							name="locality_name" cssClass="largecombobox" theme="simple"
							required="true" /> <s:fielderror fieldName="locality_name"
							theme="igr" cssClass="smallErrorMsg" /></td>

				</tr>
				<tr>

					<td class="tdLabel"><s:property
							value="getText('global.MOHALLA_VILL_NAME')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="mohallaVillList" listKey="typeCode" id="mohalla_vill_name"
							listValue="typeDesc" name="mohalla_vill_name"
							cssClass="largecombobox"
							onchange="globalAjaxEdit(this.value,'PROPERTY_TYPE');"
							theme="simple" required="true" /> <s:fielderror
							fieldName="mohalla_vill_name" theme="igr"
							cssClass="smallErrorMsg" /></td>



					<td class="tdLabel"><s:property
							value="getText('global.property_type')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="propertyTypeList" id="propert_type" listKey="typeCode"
							listValue="typeDesc" name="propert_type" onchange="clearField();"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="propert_type" theme="igr" cssClass="smallErrorMsg" /></td>

				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.khata_no')" />:</td>
					<td class="field"><s:textfield name="khata_no"
							cssClass="field"  theme="simple" maxlength="20">
							<s:fielderror fieldName="khata_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

	<td class="tdLabel"><s:property
										value="getText('global.khasra_no')" />*:</td>
								<td class="field"><s:textfield name="khasra_no"
										cssClass="field"  theme="simple" maxlength="50" required="true">
										<s:fielderror fieldName="khasra_no" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
									</tr>
									
									 
									
									<tr>
									<td class="tdLabel"><s:property
										value="getText('global.loan_book_no')" />:</td>
								<td class="field"><s:textfield name="loan_book_no"
										cssClass="field"  theme="simple" maxlength="50">
										<s:fielderror fieldName="loan_book_no" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
									

					<td class="tdLabel"><s:property
							value="getText('global.plot_no')" />:</td>
					<td class="field"><s:textfield name="plot_no" cssClass="field"
							 theme="simple" maxlength="20">
							<s:fielderror fieldName="plot_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

				</tr>
				
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.configuration_land')" />:</td>
						<td  class="field" ><s:select headerKey="" headerValue="Select"
							list="configurationLandList" listKey="typeCode" listValue="typeDesc"
							name="configuration_land" cssClass="combobox" theme="simple"
							 /> <s:fielderror fieldName="configuration_land"
							theme="igr" cssClass="smallErrorMsg" /></td>
							
							
							<td class="tdLabel"><s:property
							value="getText('global.purpose_land')" />:</td>
						<td  class="field" ><s:select headerKey="" headerValue="Select"
							list="purposeLandList" listKey="typeCode" listValue="typeDesc"
							name="purpose_land" cssClass="combobox" theme="simple"
							/> <s:fielderror fieldName="purpose_land"
							theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>
							
				
				
				<tr>

					<td class="tdLabel"><s:property
							value="getText('global.area_volumn')" />*:</td>
					<td class="field"><s:textfield name="area_volume"
							id="area_volume" cssClass="field" required="true" theme="simple"
							maxlength="10">
							<s:fielderror fieldName="area_volume" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
							<td class="tdLabel"><s:property
							value="getText('global.area_unit')" />*:</td>
						<td  class="field" ><s:select headerKey="" headerValue="Select"
							list="areaUnitList" listKey="typeCode" listValue="typeDesc"
							name="area_unit" cssClass="combobox" theme="simple"
							required="true"
							onchange="globalAjaxEdit(this.value,'VALUATION');"/>
							 <s:fielderror fieldName="area_unit"
							theme="igr" cssClass="smallErrorMsg" /></td>
						
					</tr>

						<tr>

					<td class="tdLabel"><s:property
							value="getText('global.valuation')" />*:</td>
					<td  class="field"><s:textfield name="min_val" id="min_val"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20">
							<s:fielderror fieldName="min_val" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
					<td  class="tdLabel"><s:property
										value="getText('global.rent')" />:</td>
								<td  class="field"><s:textfield name="rent" id="rent"
										cssClass="field"  theme="simple"
										maxlength="20">
										<s:fielderror fieldName="rent" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>			
						
						
				</tr>
				
				<tr>
				<td class="tdLabel"><s:property value="getText('global.no_of_tubewell')" />:</td>
					<td class="field"><s:textfield name="no_of_tubewell" id="no_of_tubewell"
							cssClass="field" theme="simple" maxlength="2">
							<s:fielderror fieldName="no_of_tubewell" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
						
				<td class="tdLabel"><s:property value="getText('global.no_of_well')" />:</td>
					<td class="field"><s:textfield name="no_of_well" id="no_of_well"
							cssClass="field" theme="simple" maxlength="2">
							<s:fielderror fieldName="no_of_well" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>		


				</tr>
				
				
				
				<tr>
								<td class="tdLabel"><s:property
										value="getText('global.north_boundary')" />:</td>
								<td colspan="3" class="field"><s:textfield name="north_boundary" id="north_boundary"
										cssClass="longField"  theme="simple"
										maxlength="100">
										<s:fielderror fieldName="north_boundary" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
							
							
							</tr>
							
							<tr>
								<td class="tdLabel"><s:property
										value="getText('global.east_boundary')" />:</td>
								<td colspan="3" class="field"><s:textfield name="east_boundary" id="east_boundary"
										cssClass="longField"  theme="simple"
										maxlength="100">
										<s:fielderror fieldName="east_boundary" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
							
							
							</tr>
							
							
							<tr>
								<td class="tdLabel"><s:property
										value="getText('global.south_boundary')" />:</td>
								<td colspan="3" class="field"><s:textfield name="south_boundary" id="south_boundary"
										cssClass="longField"  theme="simple"
										maxlength="100">
										<s:fielderror fieldName="south_boundary" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
							
							
							</tr>
							
							
							<tr>
								<td class="tdLabel"><s:property
										value="getText('global.west_boundary')" />:</td>
								<td colspan="3" class="field"><s:textfield name="west_boundary" id="west_boundary"
										cssClass="longField"  theme="simple"
										maxlength="100">
										<s:fielderror fieldName="west_boundary" theme="igr"
											cssClass="smallErrorMsg" />
									</s:textfield></td>
							
							
							</tr>
							
							



			</table>



			<div align="center">
				<s:submit method="editPropertyDetail" cssClass="button"
					value="Update" theme="simple" />

				 <input type="button" name="Exit"
					value="Exit" class="button"
					onClick="window.location.href='exitPropertyDetailEdit';">

			</div>
		</div>
		<s:hidden name="token_date" id="token_date" />
		<s:hidden name="dsr_location" id="dsr_location" />
		<s:hidden name="district_id" id="district_id" />
		<s:hidden name="propertyID" id="propertyID" />
		<s:hidden name="areaIDValue" id="areaIDValue" />
		<s:hidden name="deed_type_id" id="deed_type_id" />
		<s:hidden name="deed_category_id" id="deed_category_id" />
		<s:hidden name="considered_amount" id="considered_amount" />
		






	</s:form>
</body>
<script>
window.history.forward(0);



	function globalAjaxEdit(value1, method) {

		try {
			
			var options = '';
			var blankOption = '<option selected value="">Select</option>';

			if (method == "AREA_TYPE") {
				var formInput = 'area_master_id=' + value1
						+ "&methodName=AREA_TYPE&district_id="
						+ document.getElementById("district_id").value;
				
				$("#area_type_name").html(options);
				$.getJSON('globalAjaxEdit.action', formInput, function(data) {
					options = '<option selected value="">Select</option>';
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

			if (method == "TAHASEEL") {
				var formInput ='area_master_id='
					+ document.getElementById("area_master_id").value
					+  '&area_type_name=' + value1
						+ "&methodName=TAHASEEL&district_id="
						+ document.getElementById("district_id").value;
				
				
				$("#tahaseel").html(options);
				$
						.getJSON(
								'globalAjaxEdit.action',
								formInput,
								function(data) {
									options = '<option selected value="">Select</option>';
									$
											.each(
													data.globalList,
													function(i, item) {
														options += '<option value="' + item.typeCode + '">'
																+ item.typeDesc
																+ '</option>';
													});

									$("#tahaseel").html(options);
									$("#ward_hal_no").html(blankOption);
									$("#ward_vill_name").html(blankOption);
									$("#locality_name").html(blankOption);
									$("#mohalla_vill_name").html(blankOption);
									$("#propert_type").html(blankOption);
									$("#revenue_district").html(blankOption);
									

								});
				document.getElementById("area_volume").value="";
				document.getElementById("min_val").value="";

			}

			if (method == "REVENUE_DISTRICT") {
				var formInput = 'area_master_id='
					+ document.getElementById("area_master_id").value
					+'&area_type_name=' +document.getElementById("area_type_name").value
						+ "&methodName=REVENUE_DISTRICT&district_id="
						+ document.getElementById("district_id").value
						+ "&tahaseel="+value1;

				
				$("#revenue_district").html(options);
				$
						.getJSON(
								'globalAjaxEdit.action',
								formInput,
								function(data) {
									options = '<option selected value="">Select</option>';
									$
											.each(
													data.globalList,
													function(i, item) {
														options += '<option value="' + item.typeCode + '">'
																+ item.typeDesc
																+ '</option>';
													});

									$("#revenue_district").html(options);
									$("#ward_hal_no").html(blankOption);
									$("#ward_vill_name").html(blankOption);
									$("#locality_name").html(blankOption);
									$("#mohalla_vill_name").html(blankOption);
									$("#propert_type").html(blankOption);
								
								});
				document.getElementById("area_volume").value="";
				document.getElementById("min_val").value="";

			}


			

			if (method == "WARD_HALL_NO") {
				var formInput ='area_master_id='
					+ document.getElementById("area_master_id").value
					+ "&methodName=WARD_HALL_NO&area_type_name=" + document.getElementById("area_type_name").value
					+ "&district_id="
					+ document.getElementById("district_id").value
					+ "&tahaseel="
					+ document.getElementById("tahaseel").value
					+ "&revenue_district="+value1;
				
				$("#ward_hal_no").html(options);
				$.getJSON('globalAjaxEdit.action', formInput, function(data) {
					options = '<option selected value="">Select</option>';
					$.each(data.globalList, function(i, item) {
						options += '<option value="' + item.typeCode + '">'
								+ item.typeDesc + '</option>';
					});

					$("#ward_hal_no").html(options);
					$("#ward_vill_name").html(blankOption);
					$("#locality_name").html(blankOption);
					$("#mohalla_vill_name").html(blankOption);
					$("#propert_type").html(blankOption);
					$("#min_val").html('');
				});
				document.getElementById("area_volume").value = "";
				document.getElementById("min_val").value = "";
			}

			if (method == "WARD_VILL_NAME") {
				var formInput = 'area_master_id='
					+ document.getElementById("area_master_id").value
					+ "&methodName=WARD_VILL_NAME&area_type_name="
					+ document.getElementById("area_type_name").value
					+ "&ward_hal_no=" + value1 + "&district_id="
					+ document.getElementById("district_id").value
					+ "&tahaseel="
					+ document.getElementById("tahaseel").value
					+ "&revenue_district="
					+ document.getElementById("revenue_district").value;
				
				$("#ward_vill_name").html(options);
				$.getJSON('globalAjaxEdit.action', formInput, function(data) {
					options = '<option selected value="">Select</option>';
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

			if (method == "LOCALITY_NAME") {

				var formInput =  'area_master_id='
					+ document.getElementById("area_master_id").value
					+ "&methodName=LOCALITY_NAME&area_type_name="
					+ document.getElementById("area_type_name").value
					+ "&ward_hal_no="
					+ document.getElementById("ward_hal_no").value
					+ "&ward_vill_name=" + value1 + "&district_id="
					+ document.getElementById("district_id").value
					+ "&tahaseel="
					+ document.getElementById("tahaseel").value
					+ "&revenue_district="
					+ document.getElementById("revenue_district").value;
				
				$("#locality_name").html(options);
				$.getJSON('globalAjaxEdit.action', formInput, function(data) {
					options = '<option selected value="">Select</option>';
					$.each(data.globalList, function(i, item) {
						options += '<option value="' + item.typeCode + '">'
								+ item.typeDesc + '</option>';
					});

					$("#locality_name").html(options);
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
					+ "&ward_hal_no="
					+ document.getElementById("ward_hal_no").value
					+ "&ward_vill_name="
					+ document.getElementById("ward_vill_name").value
					+ "&locality_name=" + value1 + "&district_id="
					+ document.getElementById("district_id").value
					+ "&tahaseel="
					+ document.getElementById("tahaseel").value
					+ "&revenue_district="
					+ document.getElementById("revenue_district").value;
				
				$("#mohalla_vill_name").html(options);
				$.getJSON('globalAjaxEdit.action', formInput, function(data) {
					options = '<option selected value="">Select</option>';
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
					+ "&ward_hal_no="
					+ document.getElementById("ward_hal_no").value
					+ "&ward_vill_name="
					+ document.getElementById("ward_vill_name").value
					+ "&locality_name="
					+ document.getElementById("locality_name").value
					+ "&mohalla_vill_name=" + value1 + "&district_id="
					+ document.getElementById("district_id").value
					+ "&tahaseel="
					+ document.getElementById("tahaseel").value
					+ "&revenue_district="
					+ document.getElementById("revenue_district").value;
				
				$("#propert_type").html(options);
				$.getJSON('globalAjaxEdit.action', formInput, function(data) {
					options = '<option selected value="">Select</option>';
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

			if (method == "VALUATION") {

				var formInput = 'area_volume=' + document.getElementById("area_volume").value+'&area_unit='+value1
						+ "&methodName=VALUATION&propert_type="
						+ document.getElementById("propert_type").value
						+ "&district_id="
						+ document.getElementById("district_id").value;
				
				$("#min_val").html(options);
				$.getJSON('globalAjaxEdit.action', formInput, function(data) {
					document.getElementById("min_val").value = data.min_val;
				});

			}

		} catch (Exception) {
			alert("Error" + Exception);
		}

	}

	function clearField() {
		document.getElementById("min_val").value = "";
		document.getElementById("area_volume").value = "";
	}
</script>


</html>
<%@include file="../commonJsp/footer.inc"%>
