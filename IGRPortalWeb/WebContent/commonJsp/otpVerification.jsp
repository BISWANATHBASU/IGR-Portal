<!DOCTYPE html>
<html lang="en">
<head>
    <title>Forgot Password Details</title>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/breadcrumb.css">
    <script src="/IGRPortalWeb/js/sha256.js"></script>
    <%@include file="../commonJsp/include.jsp" %>
</head>

<body id="page1">

<div class="main">
	<div class="container_12">
	<!--==============================header=================================-->
	   	<%@include file="../commonJsp/header1.jsp" %>
	<!--==============================content================================-->
	
	<section id="content">        	
	        	<div class="wrapper">
            	<article class="grid_12">
                   <div class="indent">                
					<ol class="breadcrumb breadcrumb-arrow">
						<li><s:url value="indexAction.action" var="indexAction"></s:url>
						<a href="<s:property value='#indexAction'/>">घर</a></li>
						<li><a href="/IGRPortalWeb/forgotPasswordFormAction.action">Forgot Password</a></li>
						<li class="active"><span>Forgot Password</span></li>
					</ol>				
               </div>
               </article>
	            <article class="grid_9">
                   <div class="indent">
                   <h2 class="ind2">Verify OTP</h2>
                   </div>
                   </article>
	            <div align="center" style="text-align: center;"> 
	                      						
						
						  <form method="post" action = "optVerification"  id="loginForm" autocomplete="off">
						  <input type="hidden" name="js_enabled" id="js_enabled" value="false" />
						  <div style="width: 50%;padding: 40px" align="center">
						  <s:actionerror theme="igr" cssClass="erroMsg" />
                       		<table width="100%" align="center">
                       			<tr>
                       				<td>Enter OTP</td>
                       				<td><input type="text" placeholder="OTP" name="otpText" required="true"></td>
								</tr>
                       		</table> 
                       		</div>
                       		<br>
                       		<div class="my_button">
                       				
                       				<input type="submit" value="Verify OTP">&nbsp;<input type="reset" value="RESET" >&nbsp;
                       				
                       		</div>    <br>
                       		             
                        </form>	
                        
                        </div>
                <div class="clear"></div>                
	         </div><!--///wrapper-->                 
	    </section>
    </div>
	<!--==============================footer=================================-->
     <%@include file="../commonJsp/footer.jsp" %>
</div>

</body>
</html>