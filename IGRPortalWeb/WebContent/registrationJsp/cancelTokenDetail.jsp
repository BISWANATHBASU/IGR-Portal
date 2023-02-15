<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<br />
		<div style="margin: auto; width:1000px; border:0px solid red;">
			<table border="1" style="font-size:12px; width:100%;" id="tableData">
			<%
			String tokenNo = request.getParameter("tokenNo");
			String tokenDate = request.getParameter("tokenDate");
			String locationName = request.getParameter("locationName");
			%>
				<tr class="tableHeading">
					<th>प्रस्तुति संख्या</th><td><%=tokenNo%></td>
					<th>दिनांक</th><td><%=tokenDate%></td>
				</tr>
				<tr class="tableHeading">
					<th>उप-पंजियन कार्यालय</th><td><%=locationName%></td>
					<th> </th><td> </td>
				</tr>
			<%
				Logger log = Logger.getLogger("registrationJsp/cancelTokenDetail.jsp");
				String cancelHeading = "";
				String cancelRemarks = "";

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
	
				try{
					
					con = Datasource.getDataSource();
					
					
					String sql = "select srl,remarks from present_deed_before_refuse where token_no=?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tokenNo);
					int i = 0;
					rs = pstmt.executeQuery();
					while (rs.next()) {
						cancelHeading = rs.getString(1);
						cancelRemarks = rs.getString(2);
						%>
							<tr>
								<th colspan=4 style="color:red;">आपके द्वारा किया गया आवेदन में <u><b>'<%=cancelRemarks%>'</b></u> कमी के कारण संसोधन इत्यादि के लिए बापसी की जा रही है</th>
							</tr>
						<%
					}
					
					String sql1 = "select srl,remarks from present_deed_refuse where token_no=?";
					
					pstmt = con.prepareStatement(sql1);
					pstmt.setString(1, tokenNo);
					//int i = 0;
					rs = pstmt.executeQuery();
					while (rs.next()) {
						cancelHeading = rs.getString(1);
						cancelRemarks = rs.getString(2);
						%>
							<tr>
								<th colspan=4 style="color:red;">आपके द्वारा किया गया आवेदन में <u><b><%=cancelRemarks%></b></u> कमी के कारण संसोधन इत्यादि के लिए बापसी की जा रही है</th>
							</tr>
						<%
					}
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