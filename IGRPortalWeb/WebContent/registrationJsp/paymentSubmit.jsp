<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="../commonJsp/header2.jsp"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.igr.commonUtility.Datasource"%>
<%@page import="com.toml.dp.util.AES128Bit"%>
<%@page import="com.igr.commonUtility.CommonHelper"%>
<%@page import="org.apache.log4j.Logger"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>शुल्क विवरणी</title>
		<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<s:head theme="igr" />
		<sx:head />
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
		<%
			final Logger log = Logger.getLogger("registrationJsp/paymentSubmit.jsp");
			
			String sendURL = request.getParameter("sendURL");
		
			log.fatal("sendURL===="+sendURL);
		
			String dsr_location = request.getParameter("dsr_location");
			String token_no = request.getParameter("token_no");
			String registrationFee = request.getParameter("registrationFee");
			String token_date = request.getParameter("token_date");
			String app_date1 = request.getParameter("app_date1");

			String districtName = "";
			String dsrLocationName = "";
			String appTime = "";
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Statement stmtGet = null;
			Statement stmtIns = null;
			
			String MerchantId = "1000675";//"1000356";
			String OperatingMode = "DOM";
			String MerchantCountry = "IN";
			String MerchantCurrency = "INR";
			String PostingAmount = registrationFee;//"100";
	
			String OtherDetails = "other";
			
			//String SuccessURL = "https://epanjeeyan.cg.gov.in/eChallan/success.jsp";
			//String FailURL = "https://epanjeeyan.cg.gov.in/eChallan/fail.jsp";
			
			String SuccessURL = "https://epanjeeyan.cg.gov.in/IGRPortalWeb/success.jsp";
			String FailURL = "https://epanjeeyan.cg.gov.in/IGRPortalWeb/fail.jsp";
			
			//String SuccessURL = "http://localhost:8083/IGRPortalWeb/success.jsp";
			//String FailURL = "http://localhost:8083/IGRPortalWeb/fail.jsp";
			
			String AggregatorId = "SBIEPAY";
			
			CommonHelper helper = new CommonHelper();
			AES128Bit a = new AES128Bit();
			String MerchantOrderNo = helper.getPrimaryNo();//"Date Time";//Unique
	
			String MerchantCustomerID = "T44001";
			String Paymode = "NB";
			String Accesmedium = "ONLINE";
			String TransactionSource = "ONLINE";
			 
			try{
				
				con = Datasource.getDataSource();
				con.setAutoCommit(false);
				/**/
				//String sql = "select token_no,token_status,dsr_location_desc from provisional_token where created_by=?";
				String sql = "select dm.district_name,dl.location_desc,et.app_time from dsr_location dl join district_master dm on dl.district_id=dm.district_id and dl.lang_code=2 and dl.isactive=true join pipl_cgr_portal.executed_token et on et.dsr_location=dl.dsr_location and et.lang_code=2 where dl.dsr_location=? and et.token_no=?";
				
				//String empID = (String) request.getSession().getAttribute("_EMPCODE");

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(dsr_location));
				pstmt.setString(2, token_no);
				int i = 0;
				rs = pstmt.executeQuery();
				while (rs.next()) {
					districtName = rs.getString(1);
					dsrLocationName = rs.getString(2);
					appTime = rs.getString(3);
				}
				con.commit();
				
			}catch(Exception e){
				System.out.println("Exception========="+e);
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
						log.fatal("Error in close pstmt",e);
					}
				
				if (con != null)
					try {
						
						con.close();
					} catch (Exception e) {
						log.fatal("Error in close con",e);
					}
			}
			if(sendURL.equalsIgnoreCase("bank")){
				try
				
				{
					
				
				//String merchIdVal = MerchantId;

		    	con = Datasource.getDataSource();//db.getcon();
		    	stmtGet = con.createStatement();
		    	
		    	int slno = 0;
		    	
		    	String getSlno = "select count(slno)+1 as slno from sbi_request";
		    	rs = stmtGet.executeQuery(getSlno);
		    	if(rs.next()){
		    		slno = rs.getInt("slno");
		    	}

		    	
		    	stmtIns = con.createStatement();
		    	String entryDateTime = helper.getDataTime();
		    	
		    	String sql = "insert into sbi_request (slno,dept_tran_id,token_no,tran_date,tran_datetime)"
		    			+" values("+slno+",'"+MerchantOrderNo+"','"+token_no+"',now(),'"+entryDateTime+"')";
		    	System.out.println("SQL="+sql);
		    	int ins = stmtIns.executeUpdate(sql);
		    	if(ins > 0){
		    		log.fatal("Data Inserted...");
		    		out.println("<br />Data Inserted...");
		    	}
		    	
				}
		    	catch(Exception e){
					System.out.println("Exception========="+e);
				}
				finally{
					if (rs != null)
						try {
							
							rs.close();
						} catch (Exception e) {
							log.fatal("Cannot close Resultset after validate PaymentSubmit ", e);
						}
					if (stmtIns != null)
						try {
							
							stmtIns.close();
						} catch (Exception e) {
							log.fatal("Cannot close Resultset after validate PaymentSubmit ", e);
						}
					if (stmtGet != null)
						try {
							
							stmtGet.close();
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
		    	
		    	

				//String MultiAccountInstructionDtls  = "50|INR|TCO||50|INR|AAT";
				String requestparameter = MerchantId+"|"+OperatingMode+"|"+MerchantCountry+"|"+MerchantCurrency+"|"+PostingAmount+"|"+OtherDetails+"|"+SuccessURL+"|"+FailURL+"|"+AggregatorId+"|"+MerchantOrderNo+"|"+MerchantCustomerID+"|"+Paymode+"|"+Accesmedium+"|"+TransactionSource;
				
				String MultiAccountInstructionDtls  = PostingAmount+"|INR|CRSD";//||0|INR|AAT";
				
				//String Key = "BUEPMt7xhYV/BxluRa39gQ==";
				String Key = "asaWAcdV6MW/VySleF1t0w==";

				String EncryptTrans = AES128Bit.encrypt(requestparameter, Key);
				String MultEncryptTrans = AES128Bit.encrypt(MultiAccountInstructionDtls, Key);
				
				EncryptTrans = EncryptTrans.replaceAll("\n","");
				MultEncryptTrans = MultEncryptTrans.replaceAll("\n","");
				
				log.fatal("Encript Trans Data="+EncryptTrans);
				log.fatal("Multipale Encript Trans Data="+MultEncryptTrans);
				
				
		%>
		<!-- https://merchant.onlinesbi.com/merchant/merchantprelogin.htm -->
		<!--form action="https://merchant.onlinesbi.com/merchant/merchantprelogin.htm" method="post" id="sub"-->
		<!--form action="https://test.sbiepay.com/secure/AggregatorHostedListener" method="post" id="sub" name="ecom"-->
		<form action="https://www.sbiepay.com/secure/AggregatorHostedListener" method="post" id="sub" name="ecom">
		
		<h1>Data Sending Bank Side.</h1>
			<!--Encrypt Trans :- --><input type="hidden" name="EncryptTrans" value="<%=EncryptTrans%>"><br />
			<!--Multi Encrypt Trans :- --><input type="hidden" name="MultiAccountInstructionDtls" value="<%=MultEncryptTrans%>"><br />
			<!--input type="text" name="EncryptbillingDetails" value="%=EncryptbillingDetails%>">
			<input type="text" name="EncryptshippingDetais" value="%=EncryptshippingDetais%>">
			<!--input type="hidden" name="EncryptpaymentDetails" value="%= EncryptpaymentDetails %>"-->
			Marchent Id :- 1000675<input type="hidden" name="merchIdVal" value ="1000675" readonly="true"/><br />
		
		<!--input type=text value='<s:property value='encElement'/>' name="encdata">
		<input type="text" name="merchant_code" value="CG_LAND"-->
		</form>
		<%
			}else if(sendURL.equalsIgnoreCase("e_Challan")){
				log.fatal("Data Sending In ");
		%>
		<form action="https://cg.nic.in/eChallan/getDept05ParameterEnc.jsp" method="post" id="sub">
		<!--form action="https://cg.nic.in/eChallan/getDept05ParameterEnc_live.jsp"name="frm" method="post" id="sub"-->
			    	<input type="hidden" name="encdata" id="encdata" value="<s:property value='encElement'/>" />
			    	<img src="../images/loading.gif" width="50px" /> 
		</form>
		<%
			}else{// if(sendURL.equalsIgnoreCase("CASH_DEP")){
		%>
		<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">
		
		<div align="center" class="formCaption">Fee Entry Confirmation</div>
		
		<tr>
			<th bgcolor="skyblue">
				<h1><!--Your Payment-->Your Appointment Successfully Done.</h1>
				<div align="center" class="formCaption">
				<!--चेकस्लिप --><br /><br />
				 एप्लीकेशन आईडी :- <u><%=token_no%></u> आप का अपॉइंटमेंट दिनाकं:- <u><%=app_date1%></u> <br />
				 समय:- <u><%=appTime%></u>  पर  जिला:- <u><%=districtName%></u> उप पजियक कार्यालय :- <u><%=dsrLocationName%></u>  <br />
				 में संपूर्ण मूल दस्तावेजो एवं गवाहों के साथ उपस्थित होवें |
				</div>
				<br /><br /><br />
				<br /><br /><br />
			</th>
		</tr>
		</table>
			<!--Your Payment Successfully Done.-->
		<%
			}
		%>
		<script type="text/javascript">
		/*var r = confirm("Press OK For Payment");
		  if (r == true) {
			  document.getElementById('sub').submit();
		  } else {
		    //txt = "You pressed Cancel!";
		  }*/
			document.getElementById('sub').submit(); 
		</script>
		
		<!-- https://merchant.onlinesbi.com/merchant/merchantprelogin.htm -->
		<!-- http://localhost:2222/HelloWorld/receive.jsp -->
	</body>
</html>
<%@include file="../commonJsp/footer.inc"%>