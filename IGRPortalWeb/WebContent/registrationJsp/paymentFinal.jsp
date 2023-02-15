<!--%@page import="Encryption.AESEncrypt"%>
%@page import="Encryption.ChecksumMD5"%-->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@include file="../commonJsp/header2.jsp"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.igr.commonUtility.Datasource"%>
<%@page import="org.apache.log4j.Logger"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>शुल्क विवरणी</title>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
<s:form action="paymentConfirm"  validate="true" namespace="/" method="post" autocomplete="off">

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

<jsp:useBean id="helper" class="com.igr.commonUtility.CommonHelper" />

	<%
		Logger log = Logger.getLogger("registrationJsp/PaymentFinal.jsp");
		
		String primaryNo = helper.getPrimaryNo();
		String tokenNo = request.getParameter("token_no");
		String districtCode = tokenNo.substring(1,3);
		String[] districtDetail = helper.getDistrictDetail(districtCode).split("@");
		
		String dist_add = districtDetail[0];
		String district = districtDetail[0]+"-"+districtDetail[1];
		String ddocode = districtDetail[2];

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date cdate = new Date();
		String getData = sdf.format(cdate);

		String registration_fee_type = request.getParameter("registration_fee_type");
		String paymentFor = request.getParameter("paymentFor");
		String stampAmount = request.getParameter("stampAmount");
		String registrationFee = request.getParameter("registrationFee");
		
		log.fatal("registration_fee_type="+registration_fee_type);
		log.fatal("paymentFor="+paymentFor);
		log.fatal("stampAmount="+stampAmount);
		log.fatal("<br />registration_fee_type="+registration_fee_type);
		
		//String payButton = request.getParameter("payButton");
		//out.println("Click on payButton1="+payButton);
		
		String major_head = "0030";
		String submajor_head = "02";
		String minor_head = "104";
		String sub_head = "0760";
		
		String payment_type = "";
		String payment_amount = "";
		
		if(paymentFor.equals("stampPayment")){
			major_head = "0030";
			submajor_head = "02";
			minor_head = "102";
			sub_head = "0032";
			payment_type = "Stamp Payment";
			payment_amount = stampAmount;
		}else{
			major_head = "0030";
			submajor_head = "02";
			minor_head = "104";
			sub_head = "0760";
			payment_type = "Registration Fee";
			payment_amount = registrationFee;
		}
		
		String empID = (String)session.getAttribute("_EMPCODE");
		
		String mobileNo = "";
		String emailId = "";
		String userName = "";
		String user_Name = "";
		String address = "";
		String tinNo = "N/A";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			
			con = Datasource.getDataSource();
			con.setAutoCommit(false);
			
			String sql = "select * from user_master where user_id=?";
			log.fatal("SQL="+sql);

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(empID));
			int i = 0;
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mobileNo = rs.getString("mobileno");
				emailId = rs.getString("mailid");
				userName = rs.getString("user_name");
				user_Name = rs.getString("name");
				address = rs.getString("address");
				
				log.fatal("Mobile No="+mobileNo);
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
					log.fatal("Cannot close Resultset after validate PaymentSubmit ", e);
				}
			if (pstmt != null)
				try {
					
					pstmt.close();
				} catch (Exception e) {
					log.fatal("Error in close stmtGet",e);
				}
			
			if (con != null)
				try {
					
					con.close();
				} catch (Exception e) {
					log.fatal("Error in close con",e);
				}
		}
		
	%>

	<div align="center" class="formCaption">Fee Final</div>

		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">
		<tr>
		<td class="tdLabel"><%-- <s:property
							value="getText('global.Token_No')" /> --%>Application No*:</td>
					<td class="field"><s:property value="token_no"/></td>
		</tr>
				<tr>
					<td class="tdLabel"><%-- <s:property
							value="getText('global.registration_fee')" /> --%>Amount Payable(<%=payment_type%><!--Registration fee--> only)*:</td>
					<td class="field"><!--s:property value="registrationFee"/--><%=payment_amount%></td>
			
			
			<div align="center">
			
			
			<%
				if(registration_fee_type.equalsIgnoreCase("e_Challan")){
			%>
                <tr>
                	<input type="hidden" name="sendURL" id="sendURL" value="e_Challan" />
                    <th class="tdLabel">DeptRefNo</th><td class="field"><input type="text" name="DeptRefNo" id="DeptRefNo" value="<%=primaryNo%>" /></td>
                    <th class="tdLabel">userid</th><td  class="field"><input type="text" name="userid" id="userid" value="<%=userName%>" readonly /></td>
                </tr>
                <tr>
                    <th class="tdLabel">Application ID<!--usrname--></th><td  class="field"><input type="text" name="usrname" id="usrname" value="<%=tokenNo%>" readonly /></td><!-- ITS123 -->
                    <th class="tdLabel">name</th><td  class="field"><input type="text" name="name" id="name" value="<%=user_Name%>" readonly /></td>
                </tr>
                <!--tr>
                    <th>Payment Type</th>
                    <td colspan="3">
                    	<select name="payment_type" id="payment_type" onchange="payment_head(this.value)" required="true">
                            <option value="">Payment Type</option>
                            <option value="Registration_Fee">Registration Fee</option>
                    	</select>
                    </td>
                </tr-->
                <tr>
                    <th class="tdLabel">dept</th><td  class="field"><input type="text" name="dept" id="dept" value="05" readonly /></td>
                    <th class="tdLabel">major_head</th><td  class="field"><input type="text" name="major_head" id="major_head" value="0030" readonly /></td>
                </tr>
                <tr>
                    <th class="tdLabel">submajor_head</th><td  class="field"><input type="text" name="submajor_head" id="submajor_head" value="02" readonly /></td>
                    <th class="tdLabel">minor_head</th><td  class="field"><input type="text" name="minor_head" id="minor_head" value="<%=minor_head%>" readonly /></td>
                </tr>

                <tr>
                    <th class="tdLabel">sub_head</th><td  class="field"><input type="text" name="sub_head" id="sub_head" value="<%=sub_head%>" readonly /></td>
                    <th class="tdLabel">add_line1</th><td  class="field"><input type="text" name="add_line1" id="add_line1" value="<%=address%>" readonly /></td>
                </tr>
                <tr>
                    <th class="tdLabel">add_line2</th><td  class="field"><input type="text" name="add_line2" id="add_line2" value="test2" readonly /></td>
                    <th class="tdLabel">add_line3</th><td  class="field"><input type="text" name="add_line3" id="add_line3" value="test3" readonly /></td>
                </tr>
                <tr>
                    <th class="tdLabel">add_line4</th><td  class="field"><input type="text" name="add_line4" id="add_line4" value="test4" readonly /></td>
                    <th class="tdLabel">dist_add</th><td  class="field"><input type="text" name="dist_add" id="dist_add" value="<%=dist_add%>" readonly /></td>
                </tr>
                <tr>
                    <th class="tdLabel">state</th><td  class="field"><input type="text" name="state" id="state" value="CG" readonly /></td>
                    <th class="tdLabel">pincode</th><td  class="field"><input type="text" name="pincode" id="pincode" value="492001" readonly /></td>
                </tr>

                <tr>
                    <th class="tdLabel">email</th><td  class="field"><input type="text" name="email" id="email" value="<%=emailId%>" readonly /></td>
                    <th class="tdLabel">ph_no</th><td  class="field"><input type="text" name="ph_no" id="ph_no" value="<%=mobileNo%>" readonly /></td>
                </tr>
                <tr>
                    <th class="tdLabel">TIN</th><td  class="field"><input type="text" name="TIN" id="TIN" value="<%=tinNo%>" readonly /></td>
                    <th class="tdLabel">district</th>
                    <td  class="field"><input type="text" name="district" id="district" value="<%=district%>" readonly />
                    	<!--select name="district" id="district">
                    		<option>Raipur-11</option>
                    	</select-->
                    </td>
                </tr>
                <tr>
                    <th class="tdLabel">assmt_year</th><td  class="field"><input type="text" name="assmt_year" id="assmt_year" value="2018" readonly /></td>
                    <th class="tdLabel">from_period</th><td  class="field"><input type="text" name="from_period" id="from_period" value="<%=getData%>" readonly /></td>
                </tr>
                <tr>
                    <th class="tdLabel">to_period</th><td  class="field"><input type="text" name="to_period" id="to_period" value="<%=getData%>" readonly /></td>
                    <th class="tdLabel">purpose</th><td  class="field"><input type="text" name="purpose" id="purpose" value="<%=payment_type%>" readonly /></td>
                </tr>

                <tr>
                    <th class="tdLabel">office</th><td  class="field"><input type="text" name="office" id="office" value="office" readonly /></td>
                    <th class="tdLabel">engine_no</th><td  class="field"><input type="text" name="engine_no" id="engine_no" value="N/A" readonly /></td>
                </tr>
                <tr>
                    <th class="tdLabel">chasis_no</th><td  class="field"><input type="text" name="chasis_no" id="chasis_no" value="N/A" readonly /></td>
                    <th class="tdLabel">ddocode</th><td  class="field"><input type="text" name="ddocode" id="ddocode" value="<%=ddocode%>" readonly /></td>
                </tr>
                <tr>
                    <th class="tdLabel">int_code</th><td  class="field"><input type="text" name="int_code" id="int_code" value="IFDEPTIS_IG05" readonly /></td>
                    <th class="tdLabel">Payment Type</th><td  class="field"><input type="text" name="payment_type" id="payment_type" value="<%=payment_type%>" readonly /></td>
                </tr>
				<%
				}else if(registration_fee_type.equalsIgnoreCase("bank")){
				%>
				<input type="hidden" name="sendURL" id="sendURL" value="bank" />
				
				<%
				}else if(registration_fee_type.equalsIgnoreCase("Paid_at_Office")){
				%>
				<input type="hidden" name="sendURL" id="sendURL" value="Paid_at_Office" />
				<%
				}
				%>
			</table>
			<%
			if(!payment_amount.equalsIgnoreCase("0.0")){
			%>
			<!-- <input type="submit" value="Confirm" class="button">  -->
			<s:submit method="paymentConfirm" cssClass="button" value="Confirm"
					theme="simple" />
					
			<!-- <input type="button" name="Confirm" value="Confirm" class="button" onClick="window.location.href='paymentConfirm';">		 -->
			<% } %>
			<input type="button" name="Exit" value="Exit" class="button" onClick="window.location.href='exitPayment';">
			

			
			<s:hidden name="language" id="language" />
		
		<s:hidden name="deed_type_id" id="deed_type_id" />
		<s:hidden name="deed_category_id" id="deed_category_id" />
		<s:hidden name="considered_amount" id="considered_amount" />
		<s:hidden name="doc_min_amount" id="doc_min_amount" />
		<s:hidden name="check_slip_count" id="check_slip_count" />
		<s:hidden name="calculation_on" id="calculation_on" />
		
		<s:hidden name="dsr_location" id="dsr_location" />
		<s:hidden name="token_no" id="token_no" />
		<s:hidden name="registration_fee_type" id="registration_fee_type" />
		<s:hidden name="registrationFee" id="registrationFee" />
		<s:hidden name="registrationFeeType" id="registrationFeeType" />
		<s:hidden name="token_date" id="token_date" />
		<s:hidden name="app_date1" id="app_date1" />
		
		
			
		
		
  <s:hidden name="reportTokenDate" id="reportTokenDate" />
			
			</div>
		
</s:form>		
</body>
</html>
<%@include file="../commonJsp/footer.inc"%>
