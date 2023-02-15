<!DOCTYPE html>
<html lang="en">
<head>
    <title>New Password Details</title>
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
						<li class="active"><span>New Password</span></li>
					</ol>
               </div>
               </article>
	            <article class="grid_9">
                   <div class="indent">
                   <h2 class="ind2">New Password</h2>
                   </div>
                   </article>
	            <div align="center" style="text-align: center;"> 

						  <form method="post" action = "newPassword"  id="loginForm" autocomplete="off" onsubmit="return hashPass();">
						  <div style="width: 50%;padding: 40px" align="center">
						  <s:actionerror theme="igr" cssClass="erroMsg" />
                       		<table width="100%" align="center">
                       			<tr>
                       				<td>New Password</td>
                       				<td><input type="password" placeholder="New Password" name="newPassword" id="newPassword" required="true"></td>
								</tr>
                      				<tr>
                       				<td>Confirm Password</td>
                       				<td><input type="password" placeholder="Confirm Password" name="confirmPassword" id="confirmPassword" required="true"></td>
								</tr> 
                       		</table> 
                       		</div>
                       		<br>
                       		<div class="my_button">
                       				
                       				<input type="submit" value="Update Password">&nbsp;<input type="reset" value="RESET" >&nbsp;
                       				
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

<script>
function hashPass(){
	var newPassword = document.getElementById("newPassword").value;
	
	var regex = new Array();
    regex.push("[A-Z]"); //Uppercase Alphabet.
    regex.push("[a-z]"); //Lowercase Alphabet.
    regex.push("[0-9]"); //Digit.
    regex.push("[!@#$]"); //Special Character.
    var passed = 0;
    
    //alert("New Password"+newPassword);
    
    if(newPassword.length>=6 && newPassword.length <=10 && new RegExp(regex[0]).test(newPassword) && new RegExp(regex[1]).test(newPassword) && new RegExp(regex[2]).test(newPassword) && new RegExp(regex[3]).test(newPassword)){
    	
    	var confirmPassword = document.getElementById("confirmPassword").value;
    	//alert("New Password="+newPassword+",Confirm Password="+confirmPassword);
    	if(newPassword == confirmPassword){
    		var passMD5 = sha256(newPassword);
    		document.getElementById("newPassword").value = passMD5;//sha256(salt+passMD5);
    		return true;
    	}else{
    		alert("Please Enter Same Password");
    		return false;
    	}
    	
    }else{
		alert('Password must have maximum 10 characters and minimum 6 characters and must contain lower,upper case letter, digit, and one special character (!@#$)');
		return false;
	}
}
</script>

</html>