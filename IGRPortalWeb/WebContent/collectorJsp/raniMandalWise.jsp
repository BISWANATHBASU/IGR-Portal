
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
		
		<%@page import="com.igr.commonUtility.CommonHelper"%>
	</head>
	<body oncontextmenu="return false;">
		<%
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int i = 0;
			String districtName = "";
			Logger log = Logger.getLogger("collectorJsp/raniMandalWise.jsp");
			CommonHelper helper = new CommonHelper();
		%>
		<table border="1" class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">
			<%
				try{
				con = Datasource.getDataSource();
				if (con != null) {
					con.setAutoCommit(false);
						
					pstmt = con.prepareStatement("select district_id,district_name from district_master where lang_code='2' and is_active='true' and district_id='63'");
					
					rs = pstmt.executeQuery();
					if (rs.next()) {
						i++;
						int districtId = rs.getInt("district_id");
						districtName = rs.getString("district_name");
						String locationList = helper.getOfficeList(districtId);
						String dataCount = helper.getDCReport(locationList);
						
						String backColor =  "";
						
						if(i%2 == 0){
							backColor =  "class=tdLabel";
						}else{
							backColor =  "class=field";
						}
						%>
						<tr class="tdLabel">
							<th colspan="5">पंजीयन हेतु प्रस्तुत बाटांकन के प्रकरण जिसमे जिले को कारवाही किया जाना है</th>
						</tr>
						<tr class="field">
							<th colspan="5">रानीमण्डल <%=districtName%></th>
						</tr>
						<tr class=tdLabel>
							<th>क्रम संख्या</th>
							<th>कुल बापस किये गए प्रकरण</th><th>बाटांकन कर निरंकित प्रकरण  </th>
							<th>शेष प्रकरण</th><th>सबसे पुराना प्रकरण</th>
						</tr>
						<tr <%=backColor%>>
							<td><%=i%></td><td><a href="PatwariHalkaNoWiseAction.action"><%=dataCount%></a></td>
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