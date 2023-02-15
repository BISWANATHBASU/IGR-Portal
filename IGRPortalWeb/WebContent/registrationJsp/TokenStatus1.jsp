<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<th>प्रस्तुति संख्या</th>
					<th>दिनांक</th>
					<th>पंजियन कार्यालय</th>
					<th>प्रस्तुति विवरणी</th>
					<th>पंजियन विवरणी</th>
					<th>संपति विवरणी</th>
					<th>पक्षकार विवरणी</th>
					<th>विलेख विवरणी</th>
					<th>हस्ताक्षर विवरणी</th>
					<th>अपॉइंटमेंट/ शुल्क</th>
					<th>पुनः अपॉइंटमेंट</th>
					<th>एप्लीकेशन स्थिती</th>
				</tr>
				<%
				Logger log = Logger.getLogger("registrationJsp/TokenStatus.jsp");
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try{
					
					
					con = Datasource.getDataSource();
					con.setAutoCommit(false);
					/**/
					//String sql = "select token_no,token_status,dsr_location_desc from provisional_token where created_by=?";
					String sql = "select pt.token_no,pt.dsr_location_desc,pt.token_date,dt.deed_name, case when et.token_status is null then 'No' else et.token_status end from pipl_cgr_portal.provisional_token pt left outer join pipl_cgr_portal.executed_token et on pt.token_no=et.token_no left outer join pipl_cgr_portal.deed_type dt on pt.deed_type=dt.deed_type_id where pt.created_by=?";
					
					String empID = (String) request.getSession().getAttribute("_EMPCODE");

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

						String entryDone = "&#9989;";
						String entryNotDone = "&#10060;";

						String firstToken = "";
						String secondToken = "";
						String propertyDetail = "";
						String partyDetail = "";
						String deedDetail = "";
						
						String tokenStatus = rs.getString(5);
						if(tokenStatus.equalsIgnoreCase("No")){
							firstToken = entryDone;
							
							secondToken = entryNotDone;
							propertyDetail = entryNotDone;
							partyDetail = entryNotDone;
							deedDetail = entryNotDone;
						}else if(tokenStatus.equalsIgnoreCase("global_p")){
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
						}else if(tokenStatus.equalsIgnoreCase("global_c")){
							firstToken = entryDone;
							secondToken = entryDone;
							propertyDetail = entryDone;
							partyDetail = entryDone;
							deedDetail = entryDone;
							
							tokenStatusData = "Application Canceled";
							bgColor = "bgcolor=red";
						}else{
							firstToken = entryDone;
							secondToken = entryDone;
							propertyDetail = entryDone;
							partyDetail = entryDone;
							deedDetail = entryDone;
						}
				%>
				<tr <%=bgColor%>>
					<td align="right"><%=i%></td>
					<td><%=tokenNo%></td>
					<td><%=tokenDate%></td>
					<td><%=locationName%></td>
					<th><%=firstToken%></th>
					<th><%=secondToken%></th>
					<th><%=propertyDetail%></th>
					<th><%=partyDetail%></th>
					<th><%=deedDetail%></th>
					<th></th>
					<th></th>
					<th></th>
					<th><a href="CancelTokenAction.action?tokenNo=<%=tokenNo%>&tokenDate=<%=tokenDate%>&locationName=<%=locationName%>"><%=tokenStatusData%></a></th>
				</tr>
				<%
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
				
				%>
			</table>
		</div>
		<br />
	</body>
</html>
<%@include file="../commonJsp/footer.inc"%>