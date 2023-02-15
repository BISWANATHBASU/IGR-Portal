
<%@include file="../commonJsp/header2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>शुल्क विवरणी</title>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:head theme="igr" />
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.igr.commonUtility.Datasource"%>
<%@page import="org.apache.log4j.Logger"%>
<sx:head />
        <script type="text/javascript">
            $(function() {
                $('#app_date1').datepick({
                	dateFormat:'yyyy-mm-dd',
                	minDate: +1//new Date()
                });
            });
            /*function changePaymentMode(){
            	//alert("Muzzakkir");
            	var regFeeType = $('#registration_fee_type').val();
            	//alert(regFeeType);
				//feeMode
            	if(regFeeType == 'Paid_at_Office'){
            		$('#feeMode').show();
            		$('#payModeBtn').val('Submit');
            	}else if(regFeeType == 'e_Challan' || regFeeType == 'SBI_MOPS'){
            		$('#feeMode').show();
            		$('#payModeBtn').val('Proceed To Pay');
            	}else{
            		 $('#feeMode').hide();
            		 $('#payModeBtn').val('Submit');
            	}
            }*/
            //$('#feeMode').hide();
            
            function changePaymentMode(changeVal,selectValue){
            	//alert(changeVal+"<=>"+selectValue);
            	if(selectValue == "e_Challan" || selectValue == "bank"){
            		$('#'+changeVal).show();
            		$('#'+changeVal+"Txt").hide();
            	}else{
            		$('#'+changeVal).hide();
            		$('#'+changeVal+"Txt").show();
            	}
            }
            
            function formSybmit(btnValue,listValue){
            	//alert(""+btnValue+"<>"+listValue);
            	$('#paymentFor').val(btnValue);
            	var lstVal = $('#'+listValue).val();
            	//alert(lstVal);
            	$('#registration_fee_type').val(lstVal);
            	return true;
            }
        </script>
        
</head>
<body oncontextmenu="return false;">
	<br />
	<div id="workProgress">
		<ul>
			<li class="doneWind"><a href="#">प्रस्तुति विवरणी&#10004;</a></li>
			<li class="doneWind"><a href="#">स्टाम्प विवरणी&#10004;</a></li>
			<li class="doneWind"><a href="#">सम्पत्ति का विवरण &#10004;</a></li>
			<li class="doneWind"><a href="#">संरचना का विवरण &#10004;</a></li>
			<li class="doneWind"><a href="#">पक्षकार का प्रकार &#10004;</a></li>
			<li class="doneWind"><a href="#">विलेख का विवरण &#10004;</a></li>
			
			<li class="workingWind"><a href="#">अपॉइंटमेंट/ शुल्क &#9998;</a></li>
			
			<li class="waitingWind"><a href="#">पुनः अपॉइंटमेंट &#10006;</a></li>
		</ul>
	</div>
	
	
	
	<br /><!--div align="center" class="formCaption">ई-मूल्यांकन पर्ची/ शुल्क</div-->
	
	<!--div style="text-align:justify;background-color:lightblue; width:1000px;height:100px;" class="formCaption">
							<!--बाज़ार मूल्य तथा शुल्क की गणना आपके द्वारा उपलब्ध कराये गये दस्ताबेज और जानकारी पर अनुमानित है! परिवर्तन संभव है!--
							आपके द्वारा दस्तावेज के पंजीयन हेतु दिए गया आवेदन को स्वीकृत किया जाता है कृपया शुल्क भुगतान  के विकल्पों का उपयोग कर शुल्क का भुगतान करे  एवं अपॉइंटमेंट लेवे , बाज़ार मूल्य तथा शुल्क की गणना आपके द्वारा उपलब्ध कराये गये दस्ताबेज और जानकारी पर अनुमानित है | वास्तबिक दस्ताबेज कार्यालय पर प्रस्तुत होने पर परिवर्तन संभव है
						</div-->
	<s:form action="paymentFinal" validate="true" namespace="/" method="post" autocomplete="off" target="_blank">
		<s:token />
		<br />
		
		

		
		
<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
							<%
							Logger log = Logger.getLogger("registrationJsp/PaymentNew.jsp");
							Connection con = null;
							PreparedStatement pstmt = null;
							ResultSet rs = null;
							String tokenRemarks = "";
							String getTokenNo = request.getParameter("token_no");
							try{
								
								
								con = Datasource.getDataSource();
								con.setAutoCommit(false);
								
								String sql = "select remarks from fee_collection_portal where token_no=?";
								log.fatal("SQL="+sql);

								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, getTokenNo);
								int i = 0;
								rs = pstmt.executeQuery();
								while (rs.next()) {
									tokenRemarks = rs.getString(1);
									log.fatal(tokenRemarks);
								}
								con.commit();
							}catch(Exception e){
								log.fatal("Exception========="+e);
							}
							
							finally{
								if (rs != null)
									try {
										
										rs.close();
									} catch (Exception e) {
										log.fatal("Cannot close Resultset after validate Get DsrName ", e);
									}
								if (pstmt != null)
									try {
										
										pstmt.close();
									} catch (Exception e) {
										log.fatal("Error in close pstmt",e);
									}
								
								if (con != null)
									try {
										
										con.close();
									} catch (Exception e) {
										log.fatal("Error in close con",e);
									}
							}
							
							
							//String applicable_stamp_value = request.getParameter("applicable_stamp_value");
							//String presented_stamp_value = request.getParameter("presented_stamp_value");
							
							double applicable_stamp_value = Double.parseDouble(request.getParameter("applicable_stamp_value"));
							double presented_stamp_value = Double.parseDouble(request.getParameter("presented_stamp_value"));
							double registrationFee = Double.parseDouble(request.getParameter("registrationFee"));
							
							double stampAmount = 0;
							
							if(applicable_stamp_value >= presented_stamp_value){
								stampAmount = applicable_stamp_value - presented_stamp_value;
							}
							
							log.fatal("getTokenNo="+getTokenNo+",tokenRemarks="+tokenRemarks);
							
							log.fatal("stampAmount="+stampAmount+",registrationFee="+registrationFee);
							//if(!tokenRemarks.equalsIgnoreCase(null) || !tokenRemarks.equalsIgnoreCase("")){
							%>
							<input type="hidden" name="stampAmount" value="<%=stampAmount%>" />
							<!--tr height="80" valign="top">
								<th colspan="4" bgcolor="skyblue">
									<div style="text-align:justify" class="formCaption">
									</div>
								</th>
							</tr-->
							<% //} %>
				<!--tr height="80" valign="top">
					<th colspan="4" bgcolor="lightblue">
						<div style="text-align:justify" class="formCaption">
							<!--बाज़ार मूल्य तथा शुल्क की गणना आपके द्वारा उपलब्ध कराये गये दस्ताबेज और जानकारी पर अनुमानित है! परिवर्तन संभव है!--
							<!--आपके द्वारा दस्तावेज के पंजीयन हेतु दिए गया आवेदन को स्वीकृत किया जाता है कृपया शुल्क भुगतान  के विकल्पों का उपयोग कर शुल्क का भुगतान करे  एवं अपॉइंटमेंट लेवे , बाज़ार मूल्य तथा शुल्क की गणना आपके द्वारा उपलब्ध कराये गये दस्ताबेज और जानकारी पर अनुमानित है | वास्तबिक दस्ताबेज कार्यालय पर प्रस्तुत होने पर परिवर्तन संभव है--
							
							मेरे द्वारा पक्षकार, संपत्ति एवं संरचना की उपरोक्त प्रविष्ट तथ्यों से मैं सहमत हूँ एवं इसके आधार पर सम्बंधित उप पंजीयक द्वारा निम्नोक्त आंकलित शुल्क विवरणी को अवलोकन किया तथा तदानारूप परवर्ती प्रक्रिया पे अमल करूँगा
						</div>
					</th>
				</tr-->
	<!--tr><td class="tdLabel"><!--:property value="getText('global.registration_fee_type')" /--शुल्क भुगतान का माध्यम:</td>
						<td class="field">
						
						<!-- ,'SBI_MOPS':'Online Payment' --><!-- ,'SBI_MOPS':'Online' 'Paid_at_Office':'Cash',Registration --
						<s:select headerKey="-1" headerValue="Fee Type" list="#{'Paid_at_Office':'Cash','e_Challan':'e-Challan'}" 
						name="registration_fee_type" id="registration_fee_type" value="2" theme="simple" /><!--  onchange="changePaymentMode()" --
						
						</td><td class="tdLabel">Payment For:</td>
						<td class="field">
						
						<s:select headerKey="-1" headerValue="Select" list="#{'stampPayment':'Stamp Fee','registrationFee':'Registration Fee'}" 
						name="paymentFor" id="paymentFor" value="2" theme="simple" />
						<!--s:select headerKey="" headerValue="Select"
							list="visit_fee_List" listKey="typeCode" id="visit_fee"
							listValue="typeDesc" name="visit_fee" theme="simple" /--
							<s:fielderror fieldName="visit_fee"
							theme="igr" cssClass="smallErrorMsg" /> </td></tr></table-->
							
							
				<span id="feeMode"><!--  style="display:none;" -->
		<div align="center" class="formCaption">ई पेमेंट के जरिये भुगतान <!--Fee Entry--></div>

		<div align="center">
		
			<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />
				
				<tr>
					<th class="field">शुल्क प्रकार</th>
					<th class="field">मूल्य (रु में)</th>
					<th class="field">भुगतान  विधि</th>
					<th class="field">प्रक्रिया (लंबित/तत्काल)<!--Cash/e stamp/ treasury stamp होने पर लम्बित e challan होने पर pay--></th>
				</tr>
				
				<tr>
					<th class="field">आंकलित देय मुद्रांक </th>
					<th class="field"><%=stampAmount%></th>
					<th class="field">
						<% if(stampAmount == 0.0) {}else{%>
						<s:select headerKey="-1" headerValue="Select" list="#{'Paid_at_Office':'Cash','e_Challan':'e-Challan','e_stamp':'e-Stamp','treasury_stamp':'Treasury Stamp','bank':'Bank'}" 
						name="stamp_fee_list" id="stamp_fee_list" value="2" theme="simple" onchange="changePaymentMode('payModeBtn1',this.value)" /><!-- ,this.value -->
						<!--Cash/e stamp/ treasury stamp/ e challan-->
						<% } %>
					</th>
					<th class="field">
						<s:submit cssClass="button" value="Pay" theme="simple" method="paymentFinal" onclick="return formSybmit('stampPayment','stamp_fee_list');" id="payModeBtn1" style="display:none;"/>
						<div id="payModeBtn1Txt" style="display:none;">लंबित</div>
					</th>
				</tr>
				
				<tr>
					<th class="field">पंजीयन शुल्क</th>
					<th class="field"><s:property value="registrationFee" /></th>
					<th class="field">
						<% if(registrationFee == 0.0) {}else{%>
						<s:select headerKey="-1" headerValue="Select" list="#{'Paid_at_Office':'Cash','e_Challan':'e-Challan','e_stamp':'e-Stamp','treasury_stamp':'Treasury Stamp','bank':'Bank'}" 
						name="registration_fee_list" id="registration_fee_list" value="2" theme="simple" onchange="changePaymentMode('payModeBtn2',this.value)" /><!--  -->
						<!--Cash/e stamp/ treasury stamp/ e challan-->
						<% } %>
						<input type="hidden" name="paymentFor" id="paymentFor" value="registrationFee" />
						<input type="hidden" name="registration_fee_type" id="registration_fee_type" value="" />
					</th>
					<th class="field">
						<s:submit cssClass="button" value="Pay" theme="simple" method="paymentFinal" onclick="return formSybmit('registrationFee','registration_fee_list');" id="payModeBtn2" style="display:none;"/>
						<div id="payModeBtn2Txt" style="display:none;">लंबित</div>
					</th>
				</tr>
			</table>
			
			<s:hidden name="bookID" id="bookID" cssClass="shortfieldrowwise readOnlyField" readonly="true"
				theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="deed_name" id="deed_name" cssClass="field readOnlyField" readonly="true"
				theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="token_no" id="token_no" cssClass="field readOnlyField" readonly="true"
				theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="presenter_name" id="presenter_name" cssClass="field readOnlyField"
				readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="first_party_executant_name" id="first_party_executant_name" cssClass="field readOnlyField" readonly="true" theme="simple"
				maxlength="20" style="background-color: #C0C0C0;" onblur="javascript:this.value=this.value.toUpperCase();" />
			<s:hidden name="no_total_pages" id="no_total_pages" cssClass="shortfieldrowwise readOnlyField" readonly="true"
				theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="considered_amount" id="considered_amount" cssClass="field readOnlyField"
				readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="doc_min_amount" id="maximumValuation" cssClass="field readOnlyField"
				readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="applicable_stamp_value" readonly="true" theme="simple"
				maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="presented_stamp_value" id="presented_stamp_value" cssClass="field readOnlyField"
				readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
			<s:hidden name="registrationFee" id="registrationFee" cssClass="field readOnlyField"
				readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;" />
		
			<!--table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />
			


<tr>
	<td class="tdLabel" ><!--:property value="getText('global.book')" /--प्रस्तुति पुस्तक न.*:</td>
					<td class="field" ><s:textfield name="bookID" id="bookID"
							cssClass="shortfieldrowwise readOnlyField" readonly="true"
							theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							</s:textfield>
							</td>

<td class="tdLabel" ><!--:property value="getText('global.Deed_Type_Name')" /--दस्तावेज का प्रकार*:</td>
					<td class="field" ><s:textfield name="deed_name" id="deed_name"
							cssClass="field readOnlyField" readonly="true"
							theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							</s:textfield>
							</td>

</tr>

				<tr>
					<td class="tdLabel"><!--:property value="getText('global.Token_No')" /--एप्लीकेशन ई. डी.*:</td>
					<td class="field"><s:textfield name="token_no" id="token_no"
							cssClass="field readOnlyField" readonly="true"
							theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="token_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


					<!--td class="tdLabel">s:property value="getText('global.name')" />*:</td>
					<td class="field">s:hidden name="presenter_name"
							id="presenter_name" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							s:fielderror fieldName="presenter_name" theme="igr" cssClass="smallErrorMsg" />
						/s:hidden></td>
				</tr>
				<tr>
					<td class="tdLabel">s:property value="getText('global.first_party_name')" />*:</td>
					<td class="field">s:hidden name="first_party_executant_name" id="first_party_executant_name"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" style="background-color: #C0C0C0;"
							onblur="javascript:this.value=this.value.toUpperCase();">
							s:fielderror fieldName="first_party_executant_name" theme="igr" cssClass="smallErrorMsg" />
						/s:hidden></td--

					<td class="tdLabel">
						<!--:property value="getText('global.no_total_pages')" /--मूल दस्तावेज में पृष्ठों की संख्या *:
						<s:hidden name="presenter_name" id="presenter_name" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="presenter_name" theme="igr" cssClass="smallErrorMsg" />
						</s:hidden>
						<s:hidden name="first_party_executant_name" id="first_party_executant_name"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" style="background-color: #C0C0C0;"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="first_party_executant_name" theme="igr" cssClass="smallErrorMsg" />
						</s:hidden>
					</td>
					<td class="field"><s:textfield name="no_total_pages" id="no_total_pages"
							cssClass="shortfieldrowwise readOnlyField" readonly="true"
							theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="no_total_pages" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

				</tr>
				<%-- <tr>

					<td class="tdLabel"><s:property
							value="getText('global.district')" />*:</td>
					<td><s:select list="districtList" listKey="typeCode"
							listValue="typeDesc" name="district_id" id="district_id"
							cssClass="combobox readOnlyField" theme="simple" required="true" />
						<s:fielderror fieldName="district_id" theme="igr"
							cssClass="smallErrorMsg" /></td>

					<td class="tdLabel"><s:property
							value="getText('global.sub_register_office')" />*:</td>
					<td><s:select list="dsrLocationList" listKey="typeCode"
							listValue="typeDesc" name="dsr_location" id="dsr_location"
							cssClass="combobox readOnlyField" theme="simple" required="true" />
						<s:fielderror fieldName="dsr_location" theme="igr"
							cssClass="smallErrorMsg" /></td>
				</tr> --%>

				<tr>
					<td class="tdLabel"><!--:property value="getText('global.considered_amount')" /--विलेख में अंकित मूल्य*:</td>
					<td class="field"><s:textfield name="considered_amount"
							id="considered_amount" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="considered_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


					<td class="tdLabel"><!--:property value="getText('global.doc_min_amount')" /--दस्तावेज की देय मूल्य*:</td>
					<td class="field"><s:textfield name="doc_min_amount"
							id="maximumValuation" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="doc_min_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


				</tr>


				<tr>


					<td class="tdLabel"><!--:property value="getText('global.applicable_stamp_value')" /--देय मुद्रांक शुल्क तदनुसार*:</td>
					<td class="field"><s:textfield name="applicable_stamp_value"
							id="applicable_stamp_value" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="applicable_stamp_value" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><!--:property value="getText('global.presented_stamp_value')" /--संलग्न स्टाम्प मूल्य*:</td>
					<td class="field"><s:textfield name="presented_stamp_value" id="presented_stamp_value"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="presented_stamp_value" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

				</tr>


				<%-- <tr>
					<td class="tdLabel"><s:property
							value="getText('global.e_registration_id')" />*:</td>
					<td class="field"><s:textfield name="e_registration_code" id="e_registration_code"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="22">
							<s:fielderror fieldName="e_registration_code" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><s:property
							value="getText('global.sp_fee')" />*:</td>
					<td class="field"><s:textfield name="spFee" id="spFee"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20">
							<s:fielderror fieldName="spFee" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr> --%>




				<tr>
					<td class="tdLabel"><!--:property value="getText('global.registration_fee')" /--पंजीयन शुल्क*:</td>
					<td class="field"><s:textfield name="registrationFee"
							id="registrationFee" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="registrationFee" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						<td class="tdLabel"><!--s:property value="getText('global.app_date')" /--अपॉइंटमेंट दिनांक (yyyy-mm-dd):</td>
					<td class="field"><s:textfield name="app_date1" id="app_date1"
							cssClass="field" theme="simple"
							maxlength="20" placeholder="अपॉइंटमेंट दिनांक प्रविष्टि करें">
							<s:fielderror fieldName="app_date1" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td><!--  required="true" -->
							<!--td class="tdLabel"> <!--s:property value="getText('global.app_time')" />(HH24:MI):--></td>
				<!--  td class="field"--> 
				<!--s:textfield
							name="hhmm" cssClass="field"
						    theme="simple" maxlength="7">
							s:fielderror fieldName="hhmm" theme="igr"
								cssClass="smallErrorMsg" />
						/s:textfield-->
						<!-- /td-->
						
						
						<!--  -->

					<%-- <td class="tdLabel"><s:property
							value="getText('global.visit_fee')" />:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="visit_fee_List" listKey="typeCode" id="visit_fee"
							listValue="typeDesc" name="visit_fee" cssClass="largecombobox"
							theme="simple" /> <s:fielderror fieldName="visit_fee"
							theme="igr" cssClass="smallErrorMsg" /></td> --%

				</tr>
				
				<!--tr>
					<td colspan=4>
					</td>
				</tr-->
				
				
				<%-- <tr>
					<td class="tdLabel"><s:property
							value="getText('global.digar_tahasil_fee')" />:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="digar_tahasil_fee_List" listKey="typeCode" id="visit_fee"
							listValue="typeDesc" name="digar_tahasil_fee" cssClass="combobox"
							theme="simple" /> <s:fielderror fieldName="visit_fee"
							theme="igr" cssClass="smallErrorMsg" /></td>

				</tr> --%


			</table-->



			<div align="center">
			<s:hidden name="token_date"></s:hidden>
			<s:hidden name="dsr_location"></s:hidden>
			<%-- <s:hidden name="registrationFee"></s:hidden> --%>
				<!--s:submit cssClass="button" value="Proceed To Pay" theme="simple" method="paymentFinal" id="payModeBtn"/-->
				<%-- 	
					<s:submit method="addDeclineEntry" cssClass="button" value="Decline"
					theme="simple" /> --%>

				<!-- <input type="button" name="Revise" value="Revise" class="button"
					onClick="OpenFeeUpdate();">  -->
					
				
				<!-- <input type="button" name="Pending" value="Pending" class="button"
					onClick="OpenPending();"> --> 
					
					
					<input type="button" name="Exit" value="Exit" class="button" onClick="window.location.href='exitPayment';">
					
					&nbsp;<br /><br /><br /><br /><br /><br /><br /><br />
					
				<%-- <s:if test="printFlag==true">
					<input type="button" name="Print" value="Print" class="button"
						onClick="openReport();">
				</s:if> --%>
				
				<%-- <s:submit method="editPermissionFee" cssClass="button" value="Permission To Edit"
					theme="simple" />
					
						<s:if test="fileName.length() > 0">	
					<a href="servlet/DownloadServlet?filePath=<s:property value="fileName"/>"><font color="BLUE"><b>DR Data Download</b></font></a>					
				</s:if>	 --%>
				
			</div>
		</div>
 </span>

		<s:hidden name="language" id="language" />
		<s:hidden name="token_date" id="token_date" />
		<s:hidden name="dummyTokenDate" id="dummyTokenDate" />
		<s:hidden name="deed_type_id" id="deed_type_id" />
		<s:hidden name="deed_category_id" id="deed_category_id" />
		<s:hidden name="check_slip_count" id="check_slip_count" />
		<s:hidden name="calculation_on" id="calculation_on" />
		<s:hidden name="dsr_location" id="dsr_location" />
		
  <s:hidden name="reportTokenDate" id="reportTokenDate" />







	</s:form>
</body>

<script>
	window.history.forward(0);

	function openReport() {

		var targetString = "ReportAction.action?reportPath=/report/IGR_FEE_RECEIPT.jasper&reportName=IGR_FEESLIP&event=NOEVENT&token_no="
				+ document.getElementById("token_no").value
				+ "&token_date="
				+ document.getElementById("dummyTokenDate").value;
		window
				.open(
						targetString,
						"",
						"width=400, height=400,menubar=yes,location=1,status=1,scrollbars=yes,resizable=yes");

	}

	function OpenFeeUpdate() {
		try{

			var targetString = "FeeEntryUpdateAction.action?token_no="
				+ document.getElementById("token_no").value + "&dummyTokenDate="
				+ document.getElementById("dummyTokenDate").value
				+ "&presenter_name="
				+ document.getElementById("presenter_name").value
				+ "&first_party_executant_name="
				+ document.getElementById("first_party_executant_name").value 
				+"&no_total_pages="+document.getElementById("no_total_pages").value
				+"&considered_amount="+document.getElementById("considered_amount").value
				+"&doc_min_amount="+document.getElementById("maximumValuation").value
				+"&applicable_stamp_value="+document.getElementById("applicable_stamp_value").value
				+"&presented_stamp_value="+document.getElementById("presented_stamp_value").value
				+"&e_registration_code="+document.getElementById("e_registration_code").value
				+"&spFee="+document.getElementById("spFee").value
				+"&registrationFee="+document.getElementById("registrationFee").value
				+"&deed_type_id="+document.getElementById("deed_type_id").value
				+"&deed_category_id="+document.getElementById("deed_category_id").value; 
			
		
			
		window.open(targetString, "_self");
		}
		catch(Exception)
		{
          alert(Exception);
			}

	}


	function OpenPending() {
		try{



			var targetString = "PendingDetailEntryAction.action?token_no="
				+ document.getElementById("token_no").value + "&dummyTokenDate="
				+ document.getElementById("dummyTokenDate").value
				+ "&presenter_name="
				+ document.getElementById("presenter_name").value
				+ "&first_party_executant_name="
				+ document.getElementById("first_party_executant_name").value 
				+"&deed_type_id="+document.getElementById("deed_type_id").value
				+"&deed_category_id="+document.getElementById("deed_category_id").value
				+"&presented_stamp_value="+document.getElementById("presented_stamp_value").value
				+"&dsr_location="+document.getElementById("dsr_location").value; 

			
			
		
			
		window.open(targetString, "_self");
		}
		catch(Exception)
		{
          alert(Exception);
			}

	}
</script>

</html>
<%@include file="../commonJsp/footer.inc"%>
