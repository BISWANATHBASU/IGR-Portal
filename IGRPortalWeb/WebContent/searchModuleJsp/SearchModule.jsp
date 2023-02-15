<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
	<s:form action="SearchModule" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption">
			<s:property value="getText('global.search_module')" />
		</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />

                    <tr>
                    <td class="tdLabel" colspan="2"><s:property
							value="getText('global.district')" />*:</td>
					<td colspan="2"><s:select list="districtList" headerKey="Select" listKey="typeCode"
							listValue="typeDesc" name="districtCode" id="districtCode" cssClass="combobox"
							theme="simple" required="true"  /> <s:fielderror
							fieldName="district_id" theme="igr" cssClass="smallErrorMsg" />
					</td>
					</tr>
                    
                    <tr>
                    <td class="tdLabel" align="left">From Date<br>(dd/MM/yyyy):</td>
					<td><s:textfield id="fromDate" name="fromDate" 
							cssClass="mediumField" theme="simple" maxlength="10" required="true" >
						</s:textfield></td>
						
						
						<td class="tdLabel" align="left">To Date<br>(dd/MM/yyyy):</td>
					<td><s:textfield id="toDate" name="toDate" 
							cssClass="mediumField" theme="simple" maxlength="10" required="true" >
						</s:textfield></td>
                    </tr>
                    
                    <tr>
					<td class="tdLabel"><s:property
							value="getText('global.search_criteria')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="dsrLocationList" listKey="typeCode" listValue="typeDesc"
							name="searchCriteria" cssClass="combobox" theme="simple"
							required="true" /> <s:fielderror fieldName="searchCriteria"
							theme="igr" cssClass="smallErrorMsg" /></td>
							
					<td class="tdLabel" align="left"><s:property
							value="getText('global.search_value')" />*</td>
					<td><s:textfield id="searchValue" name="searchValue"
							cssClass="largeField" theme="simple" maxlength="50"
							required="true">
						</s:textfield> <s:fielderror fieldName="tokenDate" theme="igr"
							cssClass="smallErrorMsg" /></td>
				</tr>
			</table>
			<s:if test="%{!secondTokenTypeList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Token Detail:~</caption>
					<tr>
						<td align="center" class="fieldLabel"><s:property
								value="getText('global.name')" /></td>
						<td align="center" class="fieldLabel"><s:property
								value="getText('global.first_party_name')" /></td>
						<td align="center" class="fieldLabel"><s:property
								value="getText('global.sub_register_office')" /></td>
						<td align="center" class="fieldLabel"><s:property
								value="getText('global.e_registration_id')" /></td>
					</tr>

					<s:iterator value="secondTokenTypeList" var="secondTokenTypeList">
						<tr>
							<td class="longfieldrowwise" align="left"><s:property
									value="typeCode1" />
							</td>

							<td class="longfieldrowwise" align="left"><s:property
									value="typeCode2" />
							</td>

							<td class="fieldrowwise" align="left"><s:property
									value="typeCode3" /></td>
							<td class="fieldrowwise" align="right"><s:property
									value="typeCode9" /></td>
							<td class="fieldrowwise" align="right"><a
								href="servlet/DownloadServlet?filePath=<s:property value="typeCode6"/>"><font
									color="BLUE"><b>Download</b></font></a></td>

						</tr>
					</s:iterator>

				</table>

			</s:if>



			<div align="center">
				<s:submit method="searchModuleData" cssClass="button" value="Find"
					theme="simple" />

				

				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitModuleData';">

			</div>


		</div>

		<s:hidden name="districtCode" id="districtCode" />


	</s:form>
</body>
</html>

<%@include file="../commonJsp/footer.inc"%>
