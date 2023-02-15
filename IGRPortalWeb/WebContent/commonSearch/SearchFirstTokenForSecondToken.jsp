<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>टोकन सूची</title>
<s:head theme="igr" />
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<body oncontextmenu="return false;">
	<s:form action="SearchFirstTokenforSecondToken" validate="true" namespace="/" method="post">
		
		

		<div align="center" class="formCaption">Search Provisional Token</div>
<s:actionerror cssClass="errorMsg"/>
<s:actionmessage cssClass="infoMsg"/>
<% int i=0;%>
		<div align="center"  style="height:100px; width: 100%; overflow-x: hidden">
			<s:if test="%{!tokenModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Provisional Token Detail :~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.Token_Date')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.Token_No')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.name')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.gurdianname')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.address')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.pin')" /></TD>
					</tr>
					<s:iterator value="tokenModelList" var="tokenModelListList">
                                            <% i++;%>
						<tr>
						<td class="fieldrowwise" align="center"><s:date name="token_date" format="dd/MM/yyyy" /></td>
							<td class="fieldrowwise" align="center">
							
										 						
									<s:url action="IssueSecondTokenAction.action" var="secondToken">
										<s:param name="token_no">
											<s:property value="token_no" />
										</s:param>

										<s:param name="presenter_name">
											<s:property value="presenter_name" />
										</s:param>
										
										<s:param name="district_id">
											<s:property value="district_id" />
										</s:param>
									
										<s:param name="dsr_location">
											<s:property value="dsr_location" />
										</s:param>
									
										<s:param name="dsr_location_desc">
											<s:property value="dsr_location_desc" />
										</s:param>
										
										<s:param name="firstTokenDate">
											<s:property value="token_date" />
										</s:param>
										
										<s:param name="deed_type_id">
											<s:property value="deed_type" />
										</s:param>
										
										<s:param name="party_type">
											<s:property value="party_type" />
										</s:param>
										
										<s:param name="property_permission">
											<s:property value="property_permission" />
										</s:param>
										
										<!--s:param name="total_page_no">
											s:property value="original_deed_total_page_no" />
										/s:param-->
										
																			
									</s:url>
									
										<!--%if(i == 1){%-->	
									<s:a href="%{secondToken}">
							<font color="BLUE"><s:property value="token_no" /></font>			
									</s:a>
                                                        <!--%}else{%
                                                        s:property value="token_no" />
                                                        %}%-->
							</td>
							
							
							
							
							<td class="longfieldrowwise" align="left"><s:property
									value="presenter_name" /></td>
							
								<td class="longfieldrowwise" align="left"><s:property
									value="presenter_fh_name" /></td>
									
									<td class="longfieldrowwise" align="left"><s:property
									value="presenter_address" /></td>
							
							<td class="fieldrowwise" align="center"><s:property
									value="presenter_pin" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>


			<br> <br>
			<div align="center">
				<s:submit method="exitSearchSecondTokenForSecondToken" cssClass="button" value="Exit"
					theme="simple" />
			</div>
		</div>
		<s:hidden name="event" />
	</s:form>
</body>

</html>
<%@include file="../commonJsp/footer.inc"%>
