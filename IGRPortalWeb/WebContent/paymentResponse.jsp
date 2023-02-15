
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
    	<form name="frm" method="post">
	        <%
	        Logger log = Logger.getLogger("PaymentResponse.jsp");
	        
	        log.fatal("eChallan Response With Data.....");
	        Connection conGet = Datasource.getDataSource();
	        Statement stmtGet = null;
	        ResultSet rs = null;
	        Statement stmtIns = null; 
	        
	        try{
	        
	        	//String secret = "HSUBPMAKM2RCPSCB2K2A2";
	        	
		    	String tr_ref_no = request.getParameter("tr_ref_no");
		    	log.fatal("<br />tr_ref_no="+tr_ref_no);
		    	out.println("<br />tr_ref_no="+tr_ref_no);
		    	
		    	String bank_ref_no = request.getParameter("bank_ref_no");
		    	log.fatal("<br />bank_ref_no="+bank_ref_no);
		    	out.println("<br />bank_ref_no="+bank_ref_no);
		    	
		    	String date_ac = request.getParameter("date_ac");
		    	log.fatal("<br />date_ac="+date_ac);
		    	out.println("<br />date_ac="+date_ac);
		    	
		    	String date_and_time = request.getParameter("date_and_time");
		    	log.fatal("<br />date_and_time="+date_and_time);
		    	out.println("<br />date_and_time="+date_and_time);
		    	
		    	String bankName = request.getParameter("bankName");
		    	log.fatal("<br />bankName="+bankName);
		    	out.println("<br />bankName="+bankName);
		    	
		    	String statusflag = request.getParameter("statusflag");
		    	log.fatal("<br />statusflag="+statusflag);
		    	out.println("<br />statusflag="+statusflag);
		    	
		    	String DeptRefNo = request.getParameter("DeptRefNo");
		    	log.fatal("<br />DeptRefNo="+DeptRefNo);
		    	out.println("<br />DeptRefNo="+DeptRefNo);
		    	
		    	String depositAmount = request.getParameter("amount");
		    	log.fatal("<br />depositAmount="+depositAmount);
		    	out.println("<br />depositAmount="+depositAmount);

		    	stmtGet = conGet.createStatement();
		    	
		    	int slno = 0;
		    	
		    	String getSlno = "select count(slno)+1 as slno from e_challan_response";
		        rs = stmtGet.executeQuery(getSlno);
		        
		    	if(rs.next()){
		    		slno = rs.getInt("slno");
		    	}
		    	
		    	String entryDateTime = m.getDataTime();
		    	
		    	stmtIns = conGet.createStatement();
		    	
		    	String sql = "insert into e_challan_response (slno,deptref_no,tr_ref_no,bank_ref_no,date_ac,date_and_time,bankname,statusflag,entry_date,entry_datetime,depositamount) values("+slno+",'"+DeptRefNo+"','"+tr_ref_no+"','"+bank_ref_no+"','"+date_ac+"','"+date_and_time+"','"+bankName+"','"+statusflag+"',now(),'"+entryDateTime+"','"+depositAmount+"')";
		    	System.out.println("SQL="+sql);
		    	log.fatal("SQL="+sql);
		    	int ins = stmtIns.executeUpdate(sql);
		    	if(ins > 0){
		    		log.fatal("e_challan_response Data Inserted...");
		    		
		    		response.sendRedirect("https://epanjeeyan.cg.gov.in/IGRPortalNew/TokenStatusAction.action");
		    	}
		    	
	        }
		    catch(Exception e){
	        	log.fatal("Exception========="+e);
	        }
	        
	        finally{
				if (conGet != null)
					try {
						conGet.close();
					} catch (Exception e) {
						log.fatal("Cannot close conGet  ", e);
					}
				if (rs != null)
					try {
						rs.close();
					} catch (Exception e) {
						log.fatal("Cannot close rs ", e);
					}
				if (stmtGet != null)
					try {
						stmtGet.close();
					} catch (Exception e) {
						log.fatal("Error in close stmtGet",e);
					}
				if (stmtIns != null)
					try {
						stmtIns.close();
					} catch (Exception e) {
						log.fatal("Error in close stmtIns",e);
					}
			}
	        %>
	        <!--input type="text" name="ecndata" id="ecndata" value="%=finalString%>" /-->
        </form>
    </body>
</html>