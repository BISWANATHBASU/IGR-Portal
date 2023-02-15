<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Details</title>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/breadcrumb.css">
    <!-- <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/mycss.css"> -->
    <!-- <script src="/IGRPortalWeb/js1/md5.min.js"></script> -->
    <script src="/IGRPortalWeb/js/sha256.js"></script>
    <%@include file="../commonJsp/include.jsp" %>
</head>
<script type="text/javascript" language="javascript">

history.pushState(null, null, document.title);
window.addEventListener('popstate', function () {
    history.pushState(null, null, document.title);
});

</script>
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
						<a href="<s:property value='#indexAction'/>">घर<!-- à¤à¤° --><!--Ã Â¤ÂÃ Â¤Â°--></a></li>
						<!--li><a href="#">Ã Â¤Â-Ã Â¤ÂªÃ Â¤ÂÃ Â¤ÂÃ Â¥ÂÃ Â¤Â¯Ã Â¤Â¨</a></li-->
						<li><a href="/IGRPortalWeb/loginFormAction.action">प्री रेजिस्ट्रेसन<!-- à¤ªà¥à¤°à¥ à¤°à¥à¤à¤¿à¤¸à¥à¤à¥à¤°à¥à¤¸à¤¨ --><!--Ã Â¤ÂªÃ Â¥ÂÃ Â¤Â°Ã Â¥Â Ã Â¤Â°Ã Â¥ÂÃ Â¤ÂÃ Â¤Â¿Ã Â¤Â¸Ã Â¥ÂÃ Â¤ÂÃ Â¥ÂÃ Â¤Â°Ã Â¥ÂÃ Â¤Â¸Ã Â¤Â¨--></a></li>
						<li class="active"><span>लॉग इन<!-- à¤²à¥à¤ à¤à¤¨ --><!--Ã Â¤Â²Ã Â¥ÂÃ Â¤Â Ã Â¤ÂÃ Â¤Â¨--></span></li><!-- à¤à¤° à¤-à¤ªà¤à¤à¥à¤¯à¤¨ à¤ªà¥à¤°à¥ à¤°à¥à¤à¤¿à¤¸à¥à¤à¥à¤°à¥à¤¸à¤¨ à¤²à¥à¤ à¤à¤¨ -->
					</ol>				
               </div>
               </article>
	            <!-- <article class="grid_4" style="margin-top: 20px;">	    -->
	            <article class="grid_9">
                   <div class="indent">
                   <h2 class="ind2">लॉगइन विवरण<!-- à¤²à¥à¤à¤à¤¨ à¤µà¤¿à¤µà¤°à¤£ --><!--Ã Â¤Â²Ã Â¥ÂÃ Â¤ÂÃ Â¤ÂÃ Â¤Â¨ Ã Â¤ÂµÃ Â¤Â¿Ã Â¤ÂµÃ Â¤Â°Ã Â¤Â£--></h2>
                   </div> <!-- indent div -->
                   </article>
	            <div align="center" style="text-align: center;"> 
	                      						
						
						  <form method="post" action = "LoginAction"  id="loginForm" autocomplete="off" onsubmit="hashPass();">
						  <input type="hidden" name="js_enabled" id="js_enabled" value="false" />
						 <!--  <input type="hidden" name="password" id="pass" value="false" /> -->
						  <div style="width: 50%;padding: 40px" align="center">
						  <p><s:actionerror/></p>
                       		<table width="100%" align="center">
                       			<tr>
                       				<td width="102">User Name</td>
                       				<td><input type="text" placeholder="User Name" name="userName" required="required"></td>
								</tr>
                      				<tr>
                       				<td>Password</td>
                       				<td><input type="password" name="password" placeholder="Password" required="required" id="password"></td>
								</tr><input type="hidden" name="language" value="2" />
                       			<!--tr>	
                       				<td>Language</td>
                       				<td>
                       					<select name="language" required="required" > - onchange="encryptPassword();" >
                       						<option value="0">Select Language</option>
                       						<option value="2">Hindi</option>
                       						- <option value="1">Eniglish</option> >
                       					</select>                       					
                       				</td>
                       			</tr-->
                       			 <tr>
                       				<td width="102"><img id="captcha_id" src="Captcha.jpg" border="0"><%-- <h3><s:property value="ch"/></h3> --%></td>
                       				
                       				<td><input type="text" placeholder="Captcha" name="captcha" required="required"></td>
								
                       				<th colspan="2">
                       				<a href="loginFormAction">
                       				<img src="/IGRPortalWeb/image/refresh1.png" height=35px alt="Refresh Captcha" title="Refresh Captcha" onClick="document.getElementById('captcha_id').src=Captcha.jpg;"/>
                       				</a>
                       				
                       				</th>
								</tr>
                       		</table> 
                       		</div>
                       		<br>
                       		<div class="my_button">
                       		<%-- <input type="hidden" value="<%=session.getAttribute("salt") %>" name="salt"> --%>
                       				
                       				<input type="submit" value="Signin">&nbsp;<input type="reset" value="RESET" >&nbsp;
                       				<s:url action="signupFormAction" var="signup"/>
                       				<a href="<s:property value='#signup'/>">New User</a>
                       				| 
                       				<s:url action="forgotPasswordFormAction" var="forgotPassword"/>
                       				<a href="<s:property value='forgotPassword'/>">Forgot Password</a>
                       				
                       		</div>    <br>
                       		             
                        </form>	
                        
                        </div>				
	           <!--  </article>       -->       
                <div class="clear"></div>                
	         </div><!--///wrapper-->                 
	    </section>
    </div>
	<!--==============================footer=================================-->
     <%@include file="../commonJsp/footer.jsp" %>
</div>

</body>
<script type="text/javascript">



function encryptPassword(){
	//alert("here");
	var salt = '<%= session.getAttribute("salt") %>';
	//alert(salt);
	var formInput='password='+document.getElementById("password").value;
	var options='';
	var x='';
	try{
	$.getJSON('changePass.action', formInput, function(data) {
		x=data.password;
		document.getElementById("password").value = x;
		}); 
	}catch (e) {
		// TODO: handle exception
		alert("Try again after clearing browser history");
	}
	
}

function hashPass(){
	//alert("in hashPass");
	var salt = '<%= session.getAttribute("salt") %>';
	//alert(salt);
	var pass = document.getElementById("password").value;
	//alert("Text Password="+pass);
	var passMD5 = sha256(pass);
	//alert("SHA256====="+passMD5);
	document.getElementById("password").value = sha256(salt+passMD5);
	//alert(3);
	//alert(document.getElementById("password").value);
	return true;
}


</script>
</html>