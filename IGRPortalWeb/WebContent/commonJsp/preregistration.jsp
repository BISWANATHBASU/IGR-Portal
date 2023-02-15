<!DOCTYPE html>
<html lang="en">
<head>
    <title>साइन अप</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/breadcrumb.css">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/mycss.css">
    <script src="/IGRPortalWeb/js/aes.js"></script>
    <!-- <script src="/IGRPortalWeb/js1/md5.min.js"></script> -->
    <script src="/IGRPortalWeb/js/sha256.js"></script>
    <%@include file="../commonJsp/include.jsp" %>
</head>
<body id="page1" onload="formAutoCompOff();" >

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
						<li>
						<s:url action="indexAction" var="index"/>
						<a href="/IGRPortalWeb/">मुख्य पृष्ठ</a>
						</li>
						<li><a href="#">ई-पंजीयन</a></li>
						<li><a href="/IGRPortalWeb/loginFormAction.action">प्री रेजिस्ट्रेसन</a></li>
						<li class="active"><span>साइन अप</span></li>
					</ol>				
               </div>
               </article>
	            <div class="logincss"> 	   
	            <article  style="margin-top: 60px;">	            						
						<h4>नए उपयोगकर्ता का विवरण प्रदान करें</h4>
						  <s:form action="SignupAction" method="post" theme="simple" onsubmit="return hashText()">
						  <div align="center">
                       		<table width="90%" ><!-- class="login_table" -->
                       			
  <tr>
    <td align="right">Your Name:</td>
    <td><s:textfield name="name" required="true"/> <s:fielderror fieldName="name" theme="simple"/></td>
    <td align="right">&nbsp;&nbsp;Father's Name:</td>
    <td><s:textfield name="fatherName" required="true"/>
    <s:fielderror fieldName="fatherName" theme="simple"/>
    </td>
  </tr>
  <tr>
  	<th colspan=4 style="color:red;">Note :- Enter in Bilingual Hindi through Google IME. <br />नोट :- Google IME के ​​माध्यम से द्विभाषी हिंदी में दर्ज करें।</th>
  </tr>
  <tr>
    <td align="right">Address:</td>
    <td><s:textfield name="address" required="true"/>
    <s:fielderror fieldName="address" theme="simple"/>
    </td>
    <td align="right">&nbsp;&nbsp;User Name:</td>
    <td><s:textfield name="user_name" required="true"/>
    <s:fielderror fieldName="user_name" theme="simple"/>
    </td>
  </tr>
  <tr>
    <td align="right">Enter Password:</td>
    <td><s:password name="user_password" required="true"/>
    <s:fielderror fieldName="user_password" theme="simple"/>
    </td>
     <td align="right">&nbsp;&nbsp;Confirm Password:</td>
    <td><s:password name="confirmPassword" required="true"/>
    <s:fielderror fieldName="confirmPassword" theme="simple"/>
    </td>
  </tr>
  <tr>
  	<th colspan=4 style="color:red;">Note :- Password must have maximum 10 characters and minimum 6 characters<br /> and must contain lower,upper case letter, digit, and one special character (!@#$) Ex. Admin@123</th>
  </tr>
  <tr>
    <td align="right">Gender:</td>
    <td>
    <s:select name="gender" headerKey="-1" headerValue="Please Select" list="#{'Male':'Male','Female':'Female'}"/>
    <s:fielderror fieldName="gender" theme="simple"/>
    <!-- <select name="gender" required>
    <option>Select Please</option>
    <option value="Male">Male</option>
    <option value="Female">Female</option>
    </select> -->
    </td>
    <td align="right">&nbsp;&nbsp;Date Of Birth(dd/MM/yyyy):</td>
    <td><s:textfield name="birthDate"/>
    <s:fielderror fieldName="birthDate" theme="simple"/></td>
  </tr>
  <tr>
    <td align="right">Mobile No:</td>
    <td><s:textfield name="mobileNo" maxlength="10" pattern="[0-9]{10}" required="true" />
    <s:fielderror fieldName="mobileNo" theme="simple"/></td>
    <td align="right">&nbsp;&nbsp;Email ID:</td>
    <td><s:textfield name="mailID"/>
    <s:fielderror fieldName="mailID" theme="simple"/></td>
  </tr>
  <tr>
    <td align="right">Identity Card Type:</td>
    <td><s:select name="cardType" headerKey="-1" headerValue="Please Select" 
    list="#{'Passport':'Passport','Driving License':'Driving License','Voter Card':'Voter Card','Pan Card':'Pan Card','Other':'Other'}"></s:select>
    <s:fielderror fieldName="cardType" theme="simple"/>
    
    </td> 
    <td align="right">&nbsp;&nbsp;Card No:</td>
    <td><s:textfield name="cardNo"/>
    <s:fielderror fieldName="cardNo" theme="simple"/></td>
  </tr>
  <tr>
  <td>&nbsp;</td>
  <td align="right"><img src="Captcha.jpg" border="0"></td>
  <td align="left"><input type="text" name="captcha" required="true"></td>
  <td>&nbsp;</td>
 </tr> 
 </table> 
 </div> 
 <div class="my_button">
 <p align="center"><input type="submit" value="Register"> &nbsp;
  Already Have Account?? 
  <s:url action="loginFormAction" var="login"></s:url>
  <a href="<s:property value='#login'/>">Click Here!!</a>  </p>
  <p align="center"><font color="red"><s:actionmessage/>
  <s:actionerror/></font>
  </p>
  <p align="center"><s:actionerror theme="simple"/></p>
  </div>
  <br>
  <s:hidden name="language" value="2"></s:hidden>
 </s:form>
 </article>
 </div>
	                                         
                <div class="clear"></div>                
	         </div><!--///wrapper-->             
                    
	    </section>
    </div>
	<!--==============================footer=================================-->
     <%@include file="../commonJsp/footer.jsp" %>

</div>

</body>
<script type="text/javascript">
function formAutoCompOff(){
	for (i=0; i<document.forms.length; i++) {
        document.forms[i].setAttribute("AutoComplete","off");
	}
	document.getElementsByName("name")[0].placeholder="Enter in Hindi only";
	document.getElementsByName("fatherName")[0].placeholder="Enter in Hindi Only";
	document.getElementsByName("address")[0].placeholder="Address in english";
	document.getElementsByName("user_name")[0].placeholder="Enter in english only(use for login)";
	document.getElementsByName("user_password")[0].placeholder="Strong Password Needed";
	document.getElementsByName("confirmPassword")[0].placeholder="Confirm Password";
	document.getElementsByName("birthDate")[0].placeholder="dd/MM/yyyy";
	document.getElementsByName("mobileNo")[0].placeholder="10 digit mobile no";
	document.getElementsByName("cardNo")[0].placeholder="Your Identity Card No";
	document.getElementsByName("mailID")[0].placeholder="Your Valid Email ID";
	document.getElementsByName("captcha")[0].placeholder="Enter The Text as appeared in the text at left side";
}

function hashText(){
	
	var strength = 0;
	var a = document.getElementsByName("user_password")[0].value;
	//alert(a);
	//Regular Expressions.
    var regex = new Array();
    regex.push("[A-Z]"); //Uppercase Alphabet.
    regex.push("[a-z]"); //Lowercase Alphabet.
    regex.push("[0-9]"); //Digit.
    regex.push("[!@#$]"); //Special Character.
    var passed = 0;
    
    
    
    if(a.length>=6 && a.length <=10 && new RegExp(regex[0]).test(a) && new RegExp(regex[1]).test(a) && new RegExp(regex[2]).test(a) && new RegExp(regex[3]).test(a)){
    	var password = document.getElementsByName("user_password")[0].value;
    	var confirmPassword = document.getElementsByName("confirmPassword")[0].value;
    	var cardNo = document.getElementsByName("cardNo")[0].value;
    	document.getElementsByName("user_password")[0].value = sha256(password);
    	document.getElementsByName("confirmPassword")[0].value = sha256(confirmPassword);
    	document.getElementsByName("cardNo")[0].value = CryptoJS.AES.encrypt(cardNo,"Bar12345Bar12345");
    	//alert('true');
    	return true;
    }
    else{
    	alert('Password must have maximum 10 characters and minimum 6 characters and must contain lower,upper case letter, digit, and one special character (!@#$)');
    	return false;
    }
	
	
	
	//alert(password+' '+confirmPassword+' '+cardNo);
	//alert(document.getElementsByName("user_password")[0].value);
	//md5('hello');
}
</script>
</html>