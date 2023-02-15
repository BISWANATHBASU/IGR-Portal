
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		
		<%@page import="java.sql.Connection"%>
		<%@page import="java.sql.ResultSet"%>
		<%@page import="java.sql.SQLException"%>
		<%@page import="java.sql.PreparedStatement"%>
		<%@page import="org.apache.log4j.Logger"%>
		
		<%@page import="com.igr.commonUtility.Datasource"%>
		<%@include file="../commonJsp/header.jsp"%>
		<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<s:head theme="igr" />
		<sx:head />
		
		<script>
			function abc(){
				var url = "IssueFirstTokenAction.action";
			}
		</script>
		<style>
			.tableHeading{
				font-size:11px;
				background-color:lightblue;
			}
			.tableDataOdd{
				font-size:11px;
				background-color:#F0FFFF;
			}
			.tableDataEven{
				font-size:11px;
				background-color:#F5F5DC;
			}
		</style>
		
		<%@page import="com.igr.commonUtility.CommonHelper"%>
	</head>
	<body oncontextmenu="return false;">
		<%
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int i = 0;
			
			CommonHelper helper = new CommonHelper();
			Logger log = Logger.getLogger("collectorJsp/patwariHalkaNoWise.jsp");
		%>
		<table border="1" align="center" cellspacing="2px" cellpadding="1px" width="1024">
			<tr class="tableHeading">
				<th colspan="7">पंजीयन हेतु प्रस्तुत बाटांकन के प्रकरण जिसमे जिले को कारवाही किया जाना है</th>
			</tr>
			<tr class="tableHeading">
				<th colspan="7">पटवारी हल्का न. %=dsr_location%></th>
			</tr>
			<tr class=tableHeading>
				<th>क्रम संख्या</th>
				<th></th><th></th>
				<th>पता</th><th>फोने न.</th>
				<th>संपति विवरणी</th><th></th>
			</tr>
			<%
				try
			{
				con = Datasource.getDataSource();
				if (con != null) {
					con.setAutoCommit(false);

					//pstmt = con.prepareStatement("select district_id,district_name from district_master where lang_code='2' and is_active='true' and district_id='63'");
					pstmt = con.prepareStatement("select * from present_deed_refuse where srl in ('नियम 19-(च)','नियम 19-(घ)') and dsr_location in (44,45,46,47,57,58,59)");
					
					rs = pstmt.executeQuery();
					while (rs.next()) {
						i++;
						int dsr_location = rs.getInt("dsr_location");
						String token_date = rs.getString("token_date");
						String token_no = rs.getString("token_no");

						String partyName = helper.getPartyDetail(dsr_location, token_date, token_no);
						String localityName = helper.getPropertyDetail(dsr_location, token_date, token_no);
						
						String backColor =  "";
						
						if(i%2 == 0){
							backColor =  "class=tableDataEven";
						}else{
							backColor =  "class=tableDataOdd";
						}
						%>
						<tr <%=backColor%>>
							<td><%=i%></td><td><%=token_date%></td>
							<td><%=partyName%></td>
							<td><%=localityName%></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<%
					}
				}
				else {
					//message = 0 + "Database Operation Failed.Contact IT.14";
					System.out.println("Database Operation Failed.Contact IT.14");
				}
				
				con.commit();
				
			}
			catch(Exception e)
			{
				log.fatal("Exception --- ", e);
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
	</body>
</html>
<%@include file="../commonJsp/footer.inc"%>