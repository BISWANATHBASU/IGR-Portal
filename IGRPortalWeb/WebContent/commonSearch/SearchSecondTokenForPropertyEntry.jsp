<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>टोकन सूची</title>
<s:head theme="igr" />
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<body oncontextmenu="return false;">
	<s:form action="SearchSecondTokenforDeedEntry" validate="true" namespace="/" method="post">

		<div align="center" class="formCaption">Search Second Token</div>
		<s:actionerror cssClass="errorMsg" />
		<s:actionmessage cssClass="infoMsg" />
		<div align="center" style="height: 100px; width: 100%; overflow-x: hidden">
			<s:if test="%{!tokenModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Token Detail :~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.Token_No')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.Token_Date')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.name')" /></TD>
						<TD align="center" class="fieldLabel"><s:property value="getText('global.first_party_name')" /></TD>
					</tr>
					<s:iterator value="tokenModelList" var="tokenModelListList">
						<tr>
							<td class="fieldrowwise" align="center">
								<s:if test="%{event == 'PROPERTY_DETAIL'}">

									<s:url action="PropertyDetailEntryAction.action" var="propertyDetail">

										<s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>

										<s:param name="token_time">
											<s:property value="token_time" />
										</s:param>

										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>

										<s:param name="district_id">
											<s:property value="district_id" />
										</s:param>

										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>
										
										<s:param name="tcp_permission">
											<s:property value="t_cp_permission"/>
										</s:param>
										
										<s:param name="rda_permission">
											<s:property value="rda_permission"/>
										</s:param>
										
										<s:param name="property_permission">
											<s:property value="property_permission"/>
										</s:param>
										
										<s:param name="deedTypeID">
											<s:property value="deed_type_id"/>
										</s:param>

										<s:param name="dummyCallNature">false</s:param>

									</s:url>
								</s:if> <s:if test="%{event == 'STRUCTURE_DETAIL'}">

									<s:url action="StructureDetailEntryAction.action" var="propertyDetail">

										<s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>

										<s:param name="token_time">
											<s:property value="token_time" />
										</s:param>

										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>

										<s:param name="district_id">
											<s:property value="district_id" />
										</s:param>

										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>

										<s:param name="dummyCallNature">false</s:param>

									</s:url>
								</s:if> <s:if test="%{event == 'PARTY_DETAIL'}">

									<s:url action="PartyDetailEntryAction.action" var="propertyDetail">

										<%-- <s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>

										<s:param name="token_time">
											<s:property value="token_time" />
										</s:param>

										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>

										<s:param name="district_id">
											<s:property value="district_id" />
										</s:param>

										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>

										<s:param name="deed_type_id">
											<s:property value="deed_type_id" />
										</s:param>

										<s:param name="deedID">
											<s:property value="deed_type_id" />
										</s:param>


										<s:param name="party_name">
											<s:property value="first_party_executant_name" />
										</s:param> --%>
										
										<s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>

										<s:param name="token_time">
											<s:property value="token_time" />
										</s:param>

										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>

										<s:param name="district_id">
											<s:property value="district_id" />
										</s:param>

										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>

										<s:param name="deed_type_id">
											<s:property value="deed_type_id" />
										</s:param>

										<s:param name="deedID">
											<s:property value="deed_type_id" />
										</s:param>

										<s:param name="presenter_name">
											<s:property value="presenter_name" />
										</s:param>

										<s:param name="first_party_executant_name">
											<s:property value="first_party_executant_name" />
										</s:param>


										<s:param name="first_party_executant_capacity">
											<s:property value="first_party_executant_capacity" />
										</s:param>

										<s:param name="deed_category_id">
											<s:property value="deed_category_id" />
										</s:param>


										<s:param name="considered_amount">
											<s:property value="considered_amount" />
										</s:param>


										<s:param name="e_registration_code">
											<s:property value="e_registration_id" />
										</s:param>

										<s:param name="presented_stamp_value">
											<s:property value="total_stamp_value" />
										</s:param>

										<s:param name="new_no_of_total_pages">
											<s:property value="original_deed_total_page_no" />
										</s:param>

										<s:param name="no_total_pages">
											<s:property value="original_deed_total_page_no" />
										</s:param>

										<s:param name="dummyCallNature">false</s:param>


									</s:url>
								</s:if> <s:if test="%{event == 'DEED_DETAIL'}">

									<s:url action="DeedDetailEntryAction.action" var="propertyDetail">


										<s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>

										<s:param name="token_time">
											<s:property value="token_time" />
										</s:param>

										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>

										<s:param name="district_id">
											<s:property value="district_id" />
										</s:param>

										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>

										<s:param name="deed_type_id">
											<s:property value="deed_type_id" />
										</s:param>

										<s:param name="deedID">
											<s:property value="deed_type_id" />
										</s:param>

										<s:param name="presenter_name">
											<s:property value="presenter_name" />
										</s:param>

										<s:param name="first_party_executant_name">
											<s:property value="first_party_executant_name" />
										</s:param>


										<s:param name="first_party_executant_capacity">
											<s:property value="first_party_executant_capacity" />
										</s:param>

										<s:param name="deed_category_id">
											<s:property value="deed_category_id" />
										</s:param>


										<s:param name="considered_amount">
											<s:property value="considered_amount" />
										</s:param>


										<s:param name="e_registration_code">
											<s:property value="e_registration_id" />
										</s:param>

										<s:param name="presented_stamp_value">
											<s:property value="total_stamp_value" />
										</s:param>

										<s:param name="new_no_of_total_pages">
											<s:property value="original_deed_total_page_no" />
										</s:param>

										<s:param name="no_total_pages">
											<s:property value="original_deed_total_page_no" />
										</s:param>


									</s:url>
								</s:if> 
								
								
								<s:if test="%{event == 'DATE_EDIT'}">

									<s:url action="DateEditAction.action" var="propertyDetail">


										<s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>

										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>

										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>
										<s:param name="app_date">
											<s:property value="app_date" />
										</s:param>


									</s:url>
								</s:if>
								<s:if test="%{event == 'PAYMENT'}">

									<s:url action="PaymentAction.action" var="propertyDetail">
										<s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>
										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>
										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>
										<s:param name="app_date">
											<s:property value="app_date" />
										</s:param>
									</s:url>
								</s:if>
								<s:if test="%{event == 'APPOIMENT'}">
									<s:url action="AppoimentAction.action" var="propertyDetail">
										<s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>
										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>
										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>
										<s:param name="app_date">
											<s:property value="app_date" />
										</s:param>
									</s:url>
								</s:if>
								
								
								
								
								
								
								
								
								
								
								
								<s:if test="%{event == 'SCAN_UPLOAD'}">

									<s:url action="ScanDocumentUploadAction.action" var="propertyDetail">

										<s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>

										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>

										<s:param name="district_id">
											<s:property value="district_id" />
										</s:param>

										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>

										<s:param name="presenter_name">
											<s:property value="presenter_name" />
										</s:param>


										<s:param name="first_party_executant_name">
											<s:property value="first_party_executant_name" />
										</s:param>


										<s:param name="dummy_pages_no">
											<s:property value="dummy_pages_no" />
										</s:param>


										<s:param name="original_deed_total_page_no">
											<s:property value="original_deed_total_page_no" />
										</s:param>


										<s:param name="support_doc_total_page_no">
											<s:property value="support_doc_total_page_no" />
										</s:param>


										<s:param name="e_registration_id">
											<s:property value="e_registration_id" />
										</s:param>

										<s:param name="considered_amount">
											<s:property value="considered_amount" />
										</s:param>


										<s:param name="paid_amount">
											<s:property value="paid_amount" />
										</s:param>


										<s:param name="due_amount">
											<s:property value="due_amount" />
										</s:param>


										<s:param name="stamp_pages_no">
											<s:property value="stamp_pages_no" />
										</s:param>



									</s:url>
								</s:if> <s:if test="%{event == 'DEED_DETAIL_SIGNATURE'}">

									<s:url action="DeedDetailSignatureAction.action" var="propertyDetail">

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
								</s:if> <s:if test="%{event == 'DATA_VERIFICATION'}">

									<s:url action="DataVerificationAction.action"
										var="propertyDetail">

										<s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>

										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>

										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>
										<s:param name="event">1</s:param>


									</s:url>
									
									
									
									</s:if> <s:if test="%{event == 'NLRMP_VERIFICATION'}">

									<s:url action="NLRMPVerifiction.action"
										var="propertyDetail">

										<s:param name="token_date">
											<s:property value="secondTokenPK.token_date" />
										</s:param>

										<s:param name="token_no">
											<s:property value="secondTokenPK.token_no" />
										</s:param>

										<s:param name="dsr_location">
											<s:property value="secondTokenPK.dsr_location" />
										</s:param>
										<s:param name="event">1</s:param>


									</s:url>
									
									
									
								</s:if> <s:a href="%{propertyDetail}">
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
			
			
			
			
			
			
			
			
			


			<s:if test="%{!deedModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Token Detail :~</caption>
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
					<s:iterator value="deedModelList" var="deedModelList">
					
					
					<s:if test="%{event == 'PAYMENT'}">
							<s:url action="PaymentAction.action" var="feeEntry">

								<s:param name="token_date">
									<s:property value="deedDetailPK.token_date" />
								</s:param>

								<s:param name="token_no">
									<s:property value="deedDetailPK.token_no" />
								</s:param>

								<s:param name="district_id">
									<s:property value="district_id" />
								</s:param>

								<s:param name="dsr_location">
									<s:property value="deedDetailPK.dsr_location" />
								</s:param>

								<s:param name="considered_amount">
									<s:property value="considered_amount" />
								</s:param>


								<s:param name="e_registration_code">
									<s:property value="e_registration_code" />
								</s:param>

								<s:param name="presented_stamp_value">
									<s:property value="presented_stamp_value" />
								</s:param>

								<s:param name="no_total_pages">
									<s:property value="no_total_pages" />
								</s:param>

								<s:param name="doc_min_amount">
									<s:property value="doc_min_amount" />
								</s:param>


								<s:param name="applicable_stamp_value">
									<s:property value="applicable_stamp_value" />
								</s:param>


								<s:param name="presenter_name">
									<s:property value="presenter_name" />
								</s:param>


								<s:param name="first_party_executant_name">
									<s:property value="firstparty_executant_name" />
								</s:param>


								<s:param name="deed_type_id">
									<s:property value="deed_type_id" />
								</s:param>


								<s:param name="deed_category_id">
									<s:property value="deed_category_id" />
								</s:param>


								<s:param name="check_slip_count">
									<s:property value="check_slip_count" />
								</s:param>
								
								


							</s:url>
						</s:if>
					<s:if test="%{event == 'APPOIMENT'}">
							<s:url action="AppoimentAction.action" var="feeEntry">

								<s:param name="token_date">
									<s:property value="deedDetailPK.token_date" />
								</s:param>

								<s:param name="token_no">
									<s:property value="deedDetailPK.token_no" />
								</s:param>

								<s:param name="district_id">
									<s:property value="district_id" />
								</s:param>

								<s:param name="dsr_location">
									<s:property value="deedDetailPK.dsr_location" />
								</s:param>

								<s:param name="considered_amount">
									<s:property value="considered_amount" />
								</s:param>


								<s:param name="e_registration_code">
									<s:property value="e_registration_code" />
								</s:param>

								<s:param name="presented_stamp_value">
									<s:property value="presented_stamp_value" />
								</s:param>

								<s:param name="no_total_pages">
									<s:property value="no_total_pages" />
								</s:param>

								<s:param name="doc_min_amount">
									<s:property value="doc_min_amount" />
								</s:param>


								<s:param name="applicable_stamp_value">
									<s:property value="applicable_stamp_value" />
								</s:param>


								<s:param name="presenter_name">
									<s:property value="presenter_name" />
								</s:param>


								<s:param name="first_party_executant_name">
									<s:property value="firstparty_executant_name" />
								</s:param>


								<s:param name="deed_type_id">
									<s:property value="deed_type_id" />
								</s:param>


								<s:param name="deed_category_id">
									<s:property value="deed_category_id" />
								</s:param>


								<s:param name="check_slip_count">
									<s:property value="check_slip_count" />
								</s:param>
								
								


							</s:url>
						</s:if>
					
					
					
					
					

						<s:if test="%{event == 'FEE_ENTRY'}">
							<s:url action="FeeEntryAction.action" var="feeEntry">

								<s:param name="token_date">
									<s:property value="deedDetailPK.token_date" />
								</s:param>

								<s:param name="token_no">
									<s:property value="deedDetailPK.token_no" />
								</s:param>

								<s:param name="district_id">
									<s:property value="district_id" />
								</s:param>

								<s:param name="dsr_location">
									<s:property value="deedDetailPK.dsr_location" />
								</s:param>

								<s:param name="considered_amount">
									<s:property value="considered_amount" />
								</s:param>


								<s:param name="e_registration_code">
									<s:property value="e_registration_code" />
								</s:param>

								<s:param name="presented_stamp_value">
									<s:property value="presented_stamp_value" />
								</s:param>

								<s:param name="no_total_pages">
									<s:property value="no_total_pages" />
								</s:param>

								<s:param name="doc_min_amount">
									<s:property value="doc_min_amount" />
								</s:param>


								<s:param name="applicable_stamp_value">
									<s:property value="applicable_stamp_value" />
								</s:param>


								<s:param name="presenter_name">
									<s:property value="presenter_name" />
								</s:param>


								<s:param name="first_party_executant_name">
									<s:property value="firstparty_executant_name" />
								</s:param>


								<s:param name="deed_type_id">
									<s:property value="deed_type_id" />
								</s:param>


								<s:param name="deed_category_id">
									<s:property value="deed_category_id" />
								</s:param>


								<s:param name="check_slip_count">
									<s:property value="check_slip_count" />
								</s:param>
								
								


							</s:url>
						</s:if>


						<s:if test="%{event == 'FINAL_DOCUMENT'}">

							<s:url action="FinalDocumentGenerateAction.action" var="feeEntry">

								<s:param name="token_date">
									<s:property value="deedDetailPK.token_date" />
								</s:param>

								<s:param name="token_no">
									<s:property value="deedDetailPK.token_no" />
								</s:param>

								<s:param name="district_id">
									<s:property value="district_id" />
								</s:param>

								<s:param name="dsr_location">
									<s:property value="deedDetailPK.dsr_location" />
								</s:param>

								<s:param name="e_registration_id">
									<s:property value="e_registration_code" />
								</s:param>

								<s:param name="deed_type_id">
									<s:property value="deed_type_id" />
								</s:param>


								<s:param name="check_slip_count">
									<s:property value="check_slip_count" />
								</s:param>



							</s:url>
						</s:if>




						<s:if test="%{event == 'FEE_VERIFICATION'}">

							<s:url action="FeeVerificationAction.action" var="feeEntry">

								<s:param name="token_date">
									<s:property value="deedDetailPK.token_date" />
								</s:param>

								<s:param name="token_no">
									<s:property value="deedDetailPK.token_no" />
								</s:param>

								<s:param name="district_id">
									<s:property value="district_id" />
								</s:param>

								<s:param name="dsr_location">
									<s:property value="deedDetailPK.dsr_location" />
								</s:param>

								<s:param name="e_registration_id">
									<s:property value="e_registration_code" />
								</s:param>

								<s:param name="deed_type_id">
									<s:property value="deed_type_id" />
								</s:param>


								<s:param name="check_slip_count">
									<s:property value="check_slip_count" />
								</s:param>

								<s:param name="event">1</s:param>

							</s:url>
						</s:if>






						<s:if test="%{event == 'CERTIFIED_COPY'}">

							<s:url action="CertifiedCopyGenerateAction.action" var="feeEntry">

								<s:param name="token_date">
									<s:property value="deedDetailPK.token_date" />
								</s:param>

								<s:param name="token_no">
									<s:property value="deedDetailPK.token_no" />
								</s:param>

								<s:param name="district_id">
									<s:property value="district_id" />
								</s:param>

								<s:param name="dsr_location">
									<s:property value="deedDetailPK.dsr_location" />
								</s:param>

								<s:param name="e_registration_id">
									<s:property value="e_registration_code" />
								</s:param>

								<s:param name="deed_type_id">
									<s:property value="deed_type_id" />
								</s:param>


								<s:param name="check_slip_count">
									<s:property value="check_slip_count" />
								</s:param>



							</s:url>
						</s:if>



						<tr>
							<td class="fieldrowwise" align="center"><s:a
									href="%{feeEntry}">
									<font color="BLUE"><s:property value="deedDetailPK.token_no" /></font>
								</s:a></td>
								<td class="fieldrowwise" align="center"><s:date name="deedDetailPK.token_date" format="dd/MM/yyyy" /></td>
								
							<td class="longfieldrowwise" align="left"><s:property
									value="presenter_name" /></td>

							<td class="longfieldrowwise" align="left"><s:property
									value="firstparty_executant_name" /></td>
						</tr>

					</s:iterator>
				</table>
			</s:if>











			<s:if test="%{!feeModelList.isEmpty()}">
				<table class="appFormBlock" align="center" cellspacing="2px"
					cellpadding="1px" width="100%">
					<caption class="formBlockCaption">Token Detail For Scroll
						No. Entry :~</caption>
					<tr>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.Token_No')" /></TD>
								<TD align="center" class="fieldLabel"><s:property
								value="getText('global.Token_Date')" /></TD>
						<TD align="center" class="fieldLabel"><s:property
								value="getText('global.name')" /></TD>
					</tr>
					<s:iterator value="feeModelList" var="feeModelList">

						<s:url action="ScrollNoEntryAction.action" var="scrollNoEntry">

							<s:param name="token_date">
								<s:property value="feeListPK.token_date" />
							</s:param>

							<s:param name="token_no">
								<s:property value="feeListPK.token_no" />
							</s:param>

							<s:param name="district_id">
								<s:property value="district_id" />
							</s:param>

							<s:param name="dsr_location">
								<s:property value="feeListPK.dsr_location" />
							</s:param>

							<s:param name="fee_collection_id">
								<s:property value="fee_collection_id" />
							</s:param>


							<s:param name="party_name">
								<s:property value="party_name" />
							</s:param>

							<s:param name="fee1_amount">
								<s:property value="fee1_amount" />
							</s:param>

							<s:param name="fee2_amount">
								<s:property value="fee2_amount" />
							</s:param>

							<s:param name="visit_fee">
								<s:property value="visit_fee" />
							</s:param>

						</s:url>
						<tr>
							<td class="fieldrowwise" align="center"><s:a
									href="%{scrollNoEntry}">
									<font color="BLUE"><s:property value="feeListPK.token_no" /></font>
								</s:a></td>
								<td class="fieldrowwise" align="center"><s:date name="feeListPK.token_date" format="dd/MM/yyyy" /></td>
							<td class="longfieldrowwise" align="left"><s:property
									value="party_name" /></td>

						</tr>

					</s:iterator>
				</table>
			</s:if>


			<br> <br>
			<div align="center">
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitSecondToken';">
			</div>
		</div>
		<s:hidden name="event" />
	</s:form>
</body>

</html>
<%@include file="../commonJsp/footer.inc"%>
