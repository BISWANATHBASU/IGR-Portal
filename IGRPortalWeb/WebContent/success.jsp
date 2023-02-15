<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.toml.dp.util.AES128Bit"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.igr.commonUtility.Datasource"%>
<%@page import="com.igr.commonUtility.CommonHelper"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			CommonHelper helper = new CommonHelper();
		
			final Logger log = Logger.getLogger("success.jsp");
			//String Key = "BUEPMt7xhYV/BxluRa39gQ==";
			//String Key = "5EF85IBGSO3qH73Qtgy4eQ==";
			String Key = "asaWAcdV6MW/VySleF1t0w==";
		
			String responseData = request.getParameter("encData");
			log.fatal("Hi Muzzakkir Bank Response Data="+responseData);
			out.println("Hi Muzzakkir Bank Response Data="+responseData);

			String desData = AES128Bit.decrypt(responseData, Key);
			log.fatal("Hi Muzzakkir Bank Response Data after Decroptes.....="+desData);
			out.println("<br />Hi Muzzakkir Bank Response Data after Decroptes.....="+desData);
			
			String[] splitString = desData.split("\\|");

			String dept_tran_id = "";
			String bank_tran_id = "";
			String response_txt = "";
			String tran_amount = "";
			String tran_crancy = "";
			String tran_type = "";

			String tran_other = "";
			String tran_response = "";
			String tran_bank = "";
			String tran_no = "";
			String tran_date = "";
			  
	        //for (String a : arrOfStr){
	        for (int i=0; i<splitString.length; i++){
	            log.fatal("Splited Data="+splitString[i]);
	            out.println("<br />Splited Data="+splitString[i]);
	            
	            if(i == 0){
	            	dept_tran_id = splitString[i];
	            }if(i == 1){
	            	bank_tran_id =  splitString[i];
	            }if(i == 2){
	            	response_txt = splitString[i];
	            }if(i == 3){
	            	tran_amount = splitString[i];
	            }if(i == 4){
	            	tran_crancy = splitString[i];
	            }if(i == 5){
	            	tran_type = splitString[i];
	            }
	            
	            if(i == 6){
	            	tran_other = splitString[i];
	            }if(i == 7){
	            	tran_response = splitString[i];
	            }if(i == 8){
	            	tran_bank = splitString[i];
	            }if(i == 9){
	            	tran_no = splitString[i];
	            }if(i == 10){
	            	tran_date = splitString[i];
	            }
	        }

			Connection conGet = null;
			Connection conIns = null;
			
			//PreparedStatement pstmt = null;
			
			ResultSet rs = null;
			Statement stmtGet = null;
			Statement stmtIns = null;
			 
			try{

	    	conGet = Datasource.getDataSource();//db.getcon();
	    	stmtGet = conGet.createStatement();
	    	
	    	int slno = 0;
	    	
	    	String getSlno = "select count(slno)+1 as slno from sbi_response";
	    	rs = stmtGet.executeQuery(getSlno);
	    	if(rs.next()){
	    		slno = rs.getInt("slno");
	    	}
	    	
	    	
	    	String entryDateTime = helper.getDataTime();
	    	
	    	conIns = Datasource.getDataSource();//db.getcon();
	    	stmtIns = conIns.createStatement();
	    	
	    	String sql = "insert into sbi_response (slno,dept_tran_id,bank_tran_id,response_txt,tran_amount,tran_crancy,tran_type,tran_other,tran_response,tran_bank,tran_no,tran_date,tran_datetime,full_response_text)"
	    			+" values("+slno+",'"+dept_tran_id+"','"+bank_tran_id+"','"+response_txt+"','"+tran_amount+"','"+tran_crancy+"','"+tran_type+"','"+tran_other+"','"+tran_response+"','"+tran_bank+"','"+tran_no+"','"+tran_date+"','"+entryDateTime+"','"+responseData+"')";
	    	System.out.println("SQL="+sql);
	    	int ins = stmtIns.executeUpdate(sql);
	    	if(ins > 0){
	    		log.fatal("Data Inserted...");
	    		out.println("<br />Data Inserted...");
	    	}
	    	

	    	//response.sendRedirect("https://epanjeeyan.cg.gov.in/eChallan/TokenStatusAction.action");
	    	response.sendRedirect("https://epanjeeyan.cg.gov.in/IGRPortalWeb/TokenStatusAction.action");
	    	//response.sendRedirect("http://localhost:8083/IGRPortalWeb/TokenStatusAction.action");
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
				
				if (conGet != null)
					try {
						
						conGet.close();
					} catch (Exception e) {
						log.fatal("Error in close conGet",e);
					}
				
				if (conIns != null)
					try {
						
						conIns.close();
					} catch (Exception e) {
						log.fatal("Error in close conIns",e);
					}
			}
		%>
	</body>
</html>