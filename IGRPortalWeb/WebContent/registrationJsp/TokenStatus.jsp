
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="../commonJsp/header.jsp"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.igr.commonUtility.Datasource"%>
<%@page import="org.apache.log4j.Logger"%>
<html>
	<head>
		<title>टोकन की स्थिति</title>
		<s:head theme="igr" />
		<sx:head />
		<style>
			#tableData tr:hover, .tableHeading{
				background-color:lightblue;
			}
		</style>
	</head>
	<body oncontextmenu="return false;">
		<h2>आवेदन की स्थिति</h2>
		<!--s:property value="टोकन की स्थिति" /-->
		<div style="margin: auto; width:1300px; border:0px solid red;">
			<table border="1" style="font-size:12px; width:100%;" id="tableData">
				<tr class="tableHeading">
					<th>क्रमांक संख्या</th>
					<th>प्री रजिस्ट्रेशन ID</th>
					<th>दिनांक</th>
					<th>पंजियन कार्यालय</th>
					<th>पक्षकार द्वारा प्रविष्टी की स्थिति</th>
					<th>उप पंजीयक द्वारा शुल्क आंकलन की स्थिति</th>
					<th>पक्षकार द्वारा भुगतान की स्थिति (लंबित/PAID)</th>
					<th>प्री अपॉइंटमेंट डेट</th>
					<th>पुनः अपॉइंटमेंट</th>
					<th>ID की बैधता</th>
					<th>पंजीयन की सम्पूर्णता की स्थिति (लंबित/सम्पूर्ण)</th>
				</tr>
				<%
				Logger log = Logger.getLogger("registrationJsp/TokenStatus.jsp");
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try{
					
					
					con = Datasource.getDataSource();
					con.setAutoCommit(false);
					
					//String sql = "select token_no,token_status,dsr_location_desc from provisional_token where created_by=?";
					//String sql = "select pt.token_no,pt.dsr_location_desc,pt.token_date,dt.deed_name, case when et.token_status is null then 'No' else et.token_status end,et.valid_upto,cast(et.app_date as date),et.app_time from pipl_cgr_portal.provisional_token pt left outer join pipl_cgr_portal.executed_token et on pt.token_no=et.token_no left outer join pipl_cgr_portal.deed_type dt on pt.deed_type=dt.deed_type_id where pt.created_by=?";
					
					String sql = "select pt.token_no,pt.dsr_location_desc,pt.token_date,dt.deed_name, "
						+" case when et.token_status is null then 'No' else et.token_status end, "
						+" coalesce(to_char(et.valid_upto,'DD/MM/YYYY'),''),coalesce(to_char(et.app_date,'DD/MM/YYYY'),''),coalesce(et.app_time,''), "
						+" case when e_res.deptref_no is null then 'लंबित' else 'Paid' end "
						+" from pipl_cgr_portal.provisional_token pt left outer join pipl_cgr_portal.executed_token et on pt.token_no=et.token_no " 
						+" left outer join pipl_cgr_portal.deed_type dt on pt.deed_type=dt.deed_type_id "
						+" left outer join pipl_cgr_portal.e_challan_request e_req on pt.token_no=e_req.usrname "
						+" left outer join pipl_cgr_portal.e_challan_response e_res on e_req.deptref_no=e_res.deptref_no "
						+" where pt.created_by=? group by pt.token_no,pt.dsr_location_desc,pt.token_date,dt.deed_name, "
						+" et.token_status, "
						+" et.valid_upto,et.app_date,et.app_time, "
						+" e_res.deptref_no ORDER BY token_date DESC";
					
					String empID = (String) request.getSession().getAttribute("_EMPCODE");
					
					log.fatal("Token Status="+sql+",empID="+empID);

					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, Integer.parseInt(empID));
					int i = 0;
					rs = pstmt.executeQuery();
					while (rs.next()) {
						i++;

						String tokenNo = rs.getString(1);
						String locationName = rs.getString(2);
						String tokenDate = rs.getString(3);
						String tokenStatusData = "";
						String bgColor = "";
						String valideUpto = rs.getString(6);

						String appDate = rs.getString(7);
						String appTime = rs.getString(8);

						String entryDone = "&#9989;";
						String entryNotDone = "&#10060;";

						/*String firstToken = "";
						String secondToken = "";
						String propertyDetail = "";
						String partyDetail = "";
						String deedDetail = "";*/
						
						String partyEntry = "";
						String registrationFee = "";
						String appoimentTime = appDate+" "+appTime;
						String partyPayment = rs.getString(9);
						
						/*if(partyPayment == null || partyPayment.equalsIgnoreCase("No")){
							partyPayment = "लंबित";
						}*/
						
						String tokenStatus = rs.getString(5);
						if(tokenStatus.equalsIgnoreCase("No") || tokenStatus.equalsIgnoreCase("global_p") || tokenStatus.equalsIgnoreCase("global_pd") || tokenStatus.equalsIgnoreCase("global_pt") || tokenStatus.equalsIgnoreCase("global_dd") || tokenStatus.equalsIgnoreCase("global_ds")){
							
							partyEntry = entryDone;
							registrationFee = entryNotDone;
							
						}/*else if(tokenStatus.equalsIgnoreCase("global_p")){
							firstToken = entryDone;
							secondToken = entryDone;
							
							propertyDetail = entryNotDone;
							partyDetail = entryNotDone;
							deedDetail = entryNotDone;
						}else if(tokenStatus.equalsIgnoreCase("global_pd")){
							firstToken = entryDone;
							secondToken = entryDone;
							propertyDetail = entryDone;
							
							partyDetail = entryNotDone;
							deedDetail = entryNotDone;
						}else if(tokenStatus.equalsIgnoreCase("global_pt")){
							firstToken = entryDone;
							secondToken = entryDone;
							propertyDetail = entryDone;
							partyDetail = entryDone;
							
							deedDetail = entryNotDone;
						}else if(tokenStatus.equalsIgnoreCase("global_dd")){
							firstToken = entryDone;
							secondToken = entryDone;
							propertyDetail = entryDone;
							partyDetail = entryDone;
							deedDetail = entryDone;
						}*/else if(tokenStatus.equalsIgnoreCase("global_fc")){
							/*firstToken = entryDone;
							secondToken = entryDone;
							propertyDetail = entryDone;
							partyDetail = entryDone;
							deedDetail = entryDone;*/
							
							partyEntry = entryDone;
							registrationFee = entryDone;
						}else if(tokenStatus.equalsIgnoreCase("global_c")){
							/*firstToken = entryDone;
							secondToken = entryDone;
							propertyDetail = entryDone;
							partyDetail = entryDone;
							deedDetail = entryDone;*/
							
							partyEntry = entryNotDone;
							registrationFee = entryNotDone;
							
							tokenStatusData = "Application Canceled";
							bgColor = "bgcolor=red";
						}else{
							/*firstToken = entryDone;
							secondToken = entryDone;
							propertyDetail = entryDone;
							partyDetail = entryDone;
							deedDetail = entryDone;*/
							
							partyEntry = entryNotDone;
							registrationFee = entryNotDone;
						}
				%>
				<tr <%=bgColor%>>
					<td align="right"><%=i%></td>
					<td><%=tokenNo%></td>
					<td><%=tokenDate%></td>
					<td><%=locationName%></td>
					<th><%=partyEntry%></th>
					<th><%=registrationFee%></th>
					
					<th><%=partyPayment%></th>
					<th><%=appoimentTime%></th>
					<th></th>
					<th><%=valideUpto%></th>
					<th><a href="CancelTokenAction.action?tokenNo=<%=tokenNo%>&tokenDate=<%=tokenDate%>&locationName=<%=locationName%>"><%=tokenStatusData%></a></th>
				</tr>
				<%
					}con.commit();
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
				
				%>
			</table>
		</div>
		<br />
	</body>
</html>
<%@include file="../commonJsp/footer.inc"%>