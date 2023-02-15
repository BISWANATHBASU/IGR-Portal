<%@page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporter"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporterParameter"%>
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
            function changePaymentMode(){
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
            }
            //$('#feeMode').hide();
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
	
	
	
	<br /><div align="center" class="formCaption">ई-मूल्यांकन पर्ची/ शुल्क</div>
	
	<!--div style="text-align:justify;background-color:lightblue; width:1000px;height:70px;" class="formCaption">
							<!--बाज़ार मूल्य तथा शुल्क की गणना आपके द्वारा उपलब्ध कराये गये दस्ताबेज और जानकारी पर अनुमानित है! परिवर्तन संभव है!--
							<!--आपके द्वारा दस्तावेज के पंजीयन हेतु दिए गया आवेदन को स्वीकृत किया जाता है कृपया शुल्क भुगतान  के विकल्पों का उपयोग कर शुल्क का भुगतान करे  एवं अपॉइंटमेंट लेवे , बाज़ार मूल्य तथा शुल्क की गणना आपके द्वारा उपलब्ध कराये गये दस्ताबेज और जानकारी पर अनुमानित है | वास्तबिक दस्ताबेज कार्यालय पर प्रस्तुत होने पर परिवर्तन संभव है--
						</div-->
	<s:form action="paymentAcept" validate="true" namespace="/" method="post" autocomplete="off">
	<!--s:form action="paymentFinal" validate="true" namespace="/" method="post" autocomplete="off"-->
		<s:token />
		<br />
		
		
		<% 
	
JRHtmlExporter exporter = new JRHtmlExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, request.getAttribute("reportBody"));
exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);  
exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);  
exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD, Boolean.TRUE);  
exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image/");
exporter.exportReport();
%>
		
		
<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
							<%
							Logger log = Logger.getLogger("registrationJsp/Payment.jsp");

							String tokenRemarks = "";
							String getTokenNo = request.getParameter("token_no");
							
							Connection con = null;
							PreparedStatement pstmt = null;
							ResultSet rs = null;
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
							log.fatal("getTokenNo="+getTokenNo+",tokenRemarks="+tokenRemarks);
							//if(!tokenRemarks.equalsIgnoreCase(null) || !tokenRemarks.equalsIgnoreCase("")){
							%>
							<!--tr height="80" valign="top">
								<th colspan="4" bgcolor="skyblue">
									<div style="text-align:justify" class="formCaption">
									</div>
								</th>
							</tr-->
							<% //} %>
				<tr height="80" valign="top">
					<th colspan="4" bgcolor="lightblue">
						<div style="text-align:justify" class="formCaption">
							<!--बाज़ार मूल्य तथा शुल्क की गणना आपके द्वारा उपलब्ध कराये गये दस्ताबेज और जानकारी पर अनुमानित है! परिवर्तन संभव है!-->
							<!--आपके द्वारा दस्तावेज के पंजीयन हेतु दिए गया आवेदन को स्वीकृत किया जाता है कृपया शुल्क भुगतान  के विकल्पों का उपयोग कर शुल्क का भुगतान करे  एवं अपॉइंटमेंट लेवे , बाज़ार मूल्य तथा शुल्क की गणना आपके द्वारा उपलब्ध कराये गये दस्ताबेज और जानकारी पर अनुमानित है | वास्तबिक दस्ताबेज कार्यालय पर प्रस्तुत होने पर परिवर्तन संभव है-->
							
							<!--मेरे द्वारा पक्षकार, संपत्ति एवं संरचना की उपरोक्त प्रविष्ट तथ्यों से मैं सहमत हूँ एवं इसके आधार पर सम्बंधित उप पंजीयक द्वारा निम्नोक्त आंकलित शुल्क विवरणी को अवलोकन किया तथा तदानारूप परवर्ती प्रक्रिया पे अमल करूँगा-->
							
							मेरे द्वारा प्री रजिस्ट्रेशन ID संख्या <u><s:property value="token_no" /></u> के जरिये शुल्क विवरणी, पक्षकार, संपत्ति एवं संरचना की उपरोक्त प्रविष्ट तथ्यों से मैं सहमत हूँ एवं इसके आधार पर सम्बंधित उप पंजीयक द्वारा उपरोक्त  अनुमानित आंकलित शुल्क विवरणी को अवलोकन किया तथा तदानारूप परवर्ती प्रक्रिया पे अमल करूँगा|  वास्तविक दस्तावेज कार्यालय पर प्रस्तुत होने पर परिवर्तन संभव है
						</div>
					</th>
				</tr>
				<tr>
					<th colspan=2>
						<s:submit cssClass="button" value="सहमत" theme="simple" method="paymentAcept"/>
						<!--input type="button" name="paymentAcept" value="सहमत" class="button" onClick="window.location.href='paymentAcept.action';"-->
						<input type="button" name="exitPayment" value="असहमत" class="button" onClick="window.location.href='exitPayment';">
						<!--:submit cssClass="button" value="असहमत" theme="simple" method="exitPayment"/-->
					</th>
				</tr>
	<!--tr><td class="tdLabel"><s:property value="getText('global.registration_fee_type')" />:</td>
						<td class="field">
						
						<!-- ,'SBI_MOPS':'Online Payment' --<!-- ,'SBI_MOPS':'Online' 'Paid_at_Office':'Cash',--
						<s:select headerKey="-1" headerValue="Registration Fee Type" list="#{'Paid_at_Office':'Cash','e_Challan':'e-Challan'}" 
						name="registration_fee_type" id="registration_fee_type" value="2" theme="simple" onchange="changePaymentMode()" />
						
						<s:select headerKey="-1" headerValue="Payment For Type" list="#{'stampPayment':'Stamp Payment','registrationFee':'Registration Fee'}" 
						name="paymentFor" id="paymentFor" value="2" theme="simple" />
						<!--s:select headerKey="" headerValue="Select"
							list="visit_fee_List" listKey="typeCode" id="visit_fee"
							listValue="typeDesc" name="visit_fee" theme="simple" /--
							<s:fielderror fieldName="visit_fee"
							theme="igr" cssClass="smallErrorMsg" /></td></tr></table>
							
							
				<span id="feeMode"><!--  style="display:none;" --
		<div align="center" class="formCaption">Fee Entry</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px"
				cellpadding="1px">
				<s:actionerror theme="igr" cssClass="errorMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />
			


<tr>
	<td class="tdLabel" ><s:property
							value="getText('global.book')" />*:</td>
					<td class="field" ><s:textfield name="bookID" id="bookID"
							cssClass="shortfieldrowwise readOnlyField" readonly="true"
							theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							</s:textfield>
							</td>

<td class="tdLabel" ><s:property
							value="getText('global.Deed_Type_Name')" />*:</td>
					<td class="field" ><s:textfield name="deed_name" id="deed_name"
							cssClass="field readOnlyField" readonly="true"
							theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							</s:textfield>
							</td>

</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.Token_No')" />*:</td>
					<td class="field"><s:textfield name="token_no" id="token_no"
							cssClass="field readOnlyField" readonly="true"
							theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="token_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


					<td class="tdLabel"><s:property value="getText('global.name')" />*:</td>
					<td class="field"><s:textfield name="presenter_name"
							id="presenter_name" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="presenter_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.first_party_name')" />*:</td>
					<td class="field"><s:textfield
							name="first_party_executant_name" id="first_party_executant_name"
							cssClass="field readOnlyField" readonly="true" theme="simple"
							maxlength="20" style="background-color: #C0C0C0;"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="first_party_executant_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><s:property
							value="getText('global.no_total_pages')" />*:</td>
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
					<td class="tdLabel"><s:property
							value="getText('global.considered_amount')" />*:</td>
					<td class="field"><s:textfield name="considered_amount"
							id="considered_amount" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="considered_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


					<td class="tdLabel"><s:property
							value="getText('global.doc_min_amount')" />*:</td>
					<td class="field"><s:textfield name="doc_min_amount"
							id="maximumValuation" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="doc_min_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>


				</tr>


				<tr>


					<td class="tdLabel"><s:property
							value="getText('global.applicable_stamp_value')" />*:</td>
					<td class="field"><s:textfield name="applicable_stamp_value"
							id="applicable_stamp_value" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="applicable_stamp_value" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>

					<td class="tdLabel"><s:property
							value="getText('global.presented_stamp_value')" />*:</td>
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
				</tr> --%




				<tr>
					<td class="tdLabel"><s:property value="getText('global.registration_fee')" />*:</td>
					<td class="field"><s:textfield name="registrationFee"
							id="registrationFee" cssClass="field readOnlyField"
							readonly="true" theme="simple" maxlength="20" style="background-color: #C0C0C0;">
							<s:fielderror fieldName="registrationFee" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						<td class="tdLabel"><!--s:property value="getText('global.app_date')" /--अपॉइंटमेंट दिनांक (yyyy-mm-dd):</td>
					<td class="field"><s:textfield name="app_date1" id="app_date1"
							cssClass="field" theme="simple" required="true"
							maxlength="20" placeholder="अपॉइंटमेंट दिनांक प्रविष्टि करें">
							<s:fielderror fieldName="app_date1" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td-->
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
							theme="igr" cssClass="smallErrorMsg" /></td> --%>

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

				</tr> --%>


			</table>



			<div align="center">
			
			<s:hidden name="bookID" id="bookID" />
			<s:hidden name="deed_name" id="deed_name" />
			<s:hidden name="registrationFee" id="registrationFee" />
			
			<s:hidden name="token_date" />
			<s:hidden name="dsr_location" />
			
			<s:hidden name="token_no" />
			<s:hidden name="district_id" />
			<s:hidden name="considered_amount" />
			<s:hidden name="e_registration_code" />
			<s:hidden name="presented_stamp_value" />
			<s:hidden name="no_total_pages" />
			<s:hidden name="doc_min_amount" />
			<s:hidden name="applicable_stamp_value" />
			<s:hidden name="presenter_name" />
			<s:hidden name="first_party_executant_name" />
			
			<s:hidden name="deed_type_id" id="deed_type_id" />
			<s:hidden name="deed_category_id" id="deed_category_id" />
			<s:hidden name="check_slip_count" id="check_slip_count" />
			
			<s:hidden name="language" id="language" />
			<s:hidden name="token_date" id="token_date" />
			<s:hidden name="dummyTokenDate" id="dummyTokenDate" />
			<s:hidden name="calculation_on" id="calculation_on" />
			
	  		<s:hidden name="reportTokenDate" id="reportTokenDate" />
			<%-- <s:hidden name="registrationFee"></s:hidden> --%>
				<!--s:submit cssClass="button" value="Proceed To Pay" theme="simple" method="paymentFinal" id="payModeBtn"/-->
				<%-- 	
					<s:submit method="addDeclineEntry" cssClass="button" value="Decline"
					theme="simple" /> --%>

				<!-- <input type="button" name="Revise" value="Revise" class="button"
					onClick="OpenFeeUpdate();">  -->
					
				
				<!-- <input type="button" name="Pending" value="Pending" class="button"
					onClick="OpenPending();"> --> 
					
					
					<!--input type="button" name="Exit" value="Exit" class="button" onClick="window.location.href='exitPayment';">
					
					&nbsp;<br /><br /><br /><br /><br /><br /><br /><br /-->
					
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
