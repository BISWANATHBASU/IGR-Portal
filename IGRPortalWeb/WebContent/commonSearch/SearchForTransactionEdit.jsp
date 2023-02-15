<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>टोकन सूची</title>
<s:head theme="igr" />
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<body oncontextmenu="return false;">
	<s:form action="SearchForTransactionEdit" validate="true"
		namespace="/" method="post">

		<div align="center" class="formCaption">Search Second Token Edit</div>
		<s:actionerror cssClass="errorMsg" />
		<s:actionmessage cssClass="infoMsg" />
		<div align="center"
			style="height: 100px; width: 100%; overflow-x: hidden">
			<s:if test="%{!tokenModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Token
						Detail :~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.Token_No')" /></TD>
						
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.Token_Date')" /></TD>		
								
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.name')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.first_party_name')" /></TD>
					</tr>
					<s:iterator value="tokenModelList" id="tokenModelListList">
						<tr>
							<td class="fieldrowwise" align="center">
							
							<s:if test="%{event == 'PROPERTY_DETAIL'}">
									
							<s:url 	action="SearchForTransactionDetailsEdit.action" id="propertyDetail">
									<s:param name="tokenDate">
										<s:property value="secondTokenPK.token_date" />
									</s:param>

									<s:param name="tokenNo">
										<s:property value="secondTokenPK.token_no" />
									</s:param>

									<s:param name="dsrLocation">
										<s:property value="secondTokenPK.dsr_location" />
									</s:param>
									
									<s:param name="event">
									<s:property value="event" />
									</s:param>
									
									<s:param name="deed_type_id">
									<s:property value="deed_type_id" />
									</s:param>
									
									<s:param name="deed_category_id">
									<s:property value="deed_category_id" />
									</s:param>
									
									
										<s:param name="considered_amount">
									<s:property value="considered_amount" />
									</s:param>
									
								</s:url>
								</s:if>
								
								
								<s:if test="%{event == 'STRUCTURE_DETAIL'}">
									
							<s:url 	action="SearchForTransactionDetailsEdit.action" id="propertyDetail">
									<s:param name="tokenDate">
										<s:property value="secondTokenPK.token_date" />
									</s:param>

									<s:param name="tokenNo">
										<s:property value="secondTokenPK.token_no" />
									</s:param>

									<s:param name="dsrLocation">
										<s:property value="secondTokenPK.dsr_location" />
									</s:param>
									
									<s:param name="event">
									<s:property value="event" />
									</s:param>
									
									<s:param name="deed_type_id">
									<s:property value="deed_type_id" />
									</s:param>
									
									<s:param name="deed_category_id">
									<s:property value="deed_category_id" />
									</s:param>
									
									
										<s:param name="considered_amount">
									<s:property value="considered_amount" />
									</s:param>
									
								</s:url>
								</s:if>
								
								
									<s:if test="%{event == 'PARTY_DETAIL'}">
									
							<s:url 	action="SearchForTransactionDetailsEdit.action" id="propertyDetail">
									<s:param name="tokenDate">
										<s:property value="secondTokenPK.token_date" />
									</s:param>

									<s:param name="tokenNo">
										<s:property value="secondTokenPK.token_no" />
									</s:param>

									<s:param name="dsrLocation">
										<s:property value="secondTokenPK.dsr_location" />
									</s:param>
									
									<s:param name="event">
									<s:property value="event" />
									</s:param>
									
									<s:param name="deed_type_id">
									<s:property value="deed_type_id" />
									</s:param>
									
									<s:param name="deed_category_id">
									<s:property value="deed_category_id" />
									</s:param>
									
									
										<s:param name="considered_amount">
									<s:property value="considered_amount" />
									</s:param>
									
								</s:url>
								</s:if>
								
								
								
									<s:if test="%{event == 'DEED_DETAIL'}">
									
							<s:url 	action="SearchForTransactionDetailsEdit.action" id="propertyDetail">
									<s:param name="tokenDate">
										<s:property value="secondTokenPK.token_date" />
									</s:param>

									<s:param name="tokenNo">
										<s:property value="secondTokenPK.token_no" />
									</s:param>

									<s:param name="dsrLocation">
										<s:property value="secondTokenPK.dsr_location" />
									</s:param>
									
									<s:param name="event">
									<s:property value="event" />
									</s:param>
									
									<s:param name="deed_type_id">
									<s:property value="deed_type_id" />
									</s:param>
									
									<s:param name="deed_category_id">
									<s:property value="deed_category_id" />
									</s:param>
									
									
										<s:param name="considered_amount">
									<s:property value="considered_amount" />
									</s:param>
									
								</s:url>
								</s:if>
								
								
								
									<s:if
									test="%{event == 'SIGNATURE'}">
									
							<s:url 	action="SignatureEntryAction.action" id="propertyDetail">
									<s:param name="token_date">
										<s:property value="secondTokenPK.token_date" />
									</s:param>

									<s:param name="token_no">
										<s:property value="secondTokenPK.token_no" />
									</s:param>

									<s:param name="dsr_location">
										<s:property value="secondTokenPK.dsr_location" />
									</s:param>
									
								</s:url>
								</s:if>
								
								
								
								<s:if
									test="%{event == 'BIOMETRIC'}">
									
							<s:url 	action="BiometricAction.action" id="propertyDetail">
									<s:param name="token_date">
										<s:property value="secondTokenPK.token_date" />
									</s:param>

									<s:param name="token_no">
										<s:property value="secondTokenPK.token_no" />
									</s:param>

									<s:param name="dsr_location">
										<s:property value="secondTokenPK.dsr_location" />
									</s:param>
									
								</s:url>
								</s:if>
								
								
								
								
								 <s:a href="%{propertyDetail}">
									<font color="BLUE"><s:property value="secondTokenPK.token_no" /></font>
								</s:a></td>
								
									<td class="fieldrowwise" align="center"><s:date name="secondTokenPK.token_date" format="dd/MM/yyyy" /></td>
							<td class="longfieldrowwise" align="left"><s:property
									value="presenter_name" /></td>

							<td class="longfieldrowwise" align="left"><s:property
									value="first_party_executant_name" /></td>


						</tr>
					</s:iterator>
				</table>
			</s:if>

<s:hidden name="event" id="event" />
			<br> <br>
			<div align="center">
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitSecondTokenEdit';">
			</div>
		</div>
		<s:hidden name="event" />
	</s:form>
</body>

</html>
<%@include file="../commonJsp/footer.inc"%>
