
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!--jsp:useBean id="db" class="mybean.DbconUAT" /-->
<jsp:useBean id="m" class="com.igr.commonUtility.CommonHelper" />
<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.igr.commonUtility.Datasource"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>e-Challan Payment Module</title>
    </head>
    <body>
    	<form name="frm" method="post" action="Side2SideSend.jsp">
	        <%
	        	Logger log = Logger.getLogger("registrationJsp/PaymentResponse.jsp");
	        	String secret = "HSUBPMAKM2RCPSCB2K2A2";
	        	
	        	//String tr_ref_no
		    	String tr_ref_no = request.getParameter("tr_ref_no");
		    	out.println("<br />tr_ref_no="+tr_ref_no);
		    	String bank_ref_no = request.getParameter("bank_ref_no");
		    	out.println("<br />bank_ref_no="+bank_ref_no);
		    	
		    	String date_ac = request.getParameter("date_ac");
		    	out.println("<br />date_ac="+date_ac);
		    	String date_and_time = request.getParameter("date_and_time");
		    	out.println("<br />date_and_time="+date_and_time);
		    	
		    	String bankName = request.getParameter("bankName");
		    	out.println("<br />bankName="+bankName);
		    	String statusflag = request.getParameter("statusflag");
		    	out.println("<br />statusflag="+statusflag);
		    	
		    	String DeptRefNo = request.getParameter("DeptRefNo");
		    	out.println("<br />DeptRefNo="+DeptRefNo);

		    	Connection conGet = Datasource.getDataSource();//db.getcon();
		    	Statement stmtGet = conGet.createStatement();
		    	
		    	int slno = 0;
		    	
		    	String getSlno = "select count(slno)+1 as slno from e_challan_response";
		    	ResultSet rs = stmtGet.executeQuery(getSlno);
		    	if(rs.next()){
		    		slno = rs.getInt("slno");
		    	}
		    	rs.close();
		    	stmtGet.close();
		    	conGet.close();
		    	
		    	String entryDateTime = m.getDataTime();
		    	
		    	Connection conIns = Datasource.getDataSource();//db.getcon();
		    	Statement stmtIns = conIns.createStatement();
		    	
		    	String sql = "insert into e_challan_response (slno,deptref_no,tr_ref_no,bank_ref_no,date_ac,date_and_time,bankname,statusflag,entry_date,entry_datetime) values("+slno+",'"+DeptRefNo+"','"+tr_ref_no+"','"+bank_ref_no+"','"+date_ac+"','"+date_and_time+"','"+bankName+"','"+statusflag+"',now(),'"+entryDateTime+"')";
		    	System.out.println("SQL="+sql);
		    	int ins = stmtIns.executeUpdate(sql);
		    	if(ins > 0){
		    		log.fatal("Data Inserted...");
		    	}
		    	stmtIns.close();
		    	conIns.close();
	        %>
	        <!--input type="text" name="ecndata" id="ecndata" value="%=finalString%>" /-->
        </form>
    </body>
</html>