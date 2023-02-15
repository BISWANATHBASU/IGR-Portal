<!DOCTYPE html>
<html lang="en">
<head>
    <title>प्रतिक्रिया फॉर्म</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
						<li class="active"><span>प्रतिक्रिया फॉर्म</span></li>
					</ol>				
               </div>
               </article>
	            <div class="logincss"> 	   
	            <article  style="margin-top: 60px;">	            						
						<h4>प्रतिक्रिया फॉर्म</h4><!--  action="SignupAction" onsubmit="return hashText()" -->
						  <s:form method="post" theme="simple">
						  <div align="center">
                       		<table width="90%" cellspacing=10 cellpadding=5 border=0><!-- class="login_table" -->
                       		
                       		<tr>
                       			<td>
                       				<s:textfield name="name"/> <s:fielderror fieldName="name" theme="simple"/>
                       			</td>
                       			<td>
                       				<s:textfield name="mobileNo"/> <s:fielderror fieldName="mobileNo" theme="simple"/>
                       			</td>
                       			<td>
                       				<s:textfield name="mailID"/> <s:fielderror fieldName="mailID" theme="simple"/>
                       			</td>
                       			<td>&nbsp;</td>
                       		</tr>
                       			
				  <!--tr>
				    <td align="right">Your Name:</td>
				    <td></td>
				    <td align="right">&nbsp;&nbsp;Father's Name:</td>
				    <td><s:textfield name="fatherName"/>
				    <s:fielderror fieldName="fatherName" theme="simple"/>
				    </td>
				  </tr>
				  <tr>
				    <td align="right">Address:</td>
				    <td><s:textfield name="address"/>
				    <s:fielderror fieldName="address" theme="simple"/>
				    </td>
				    <td align="right">&nbsp;&nbsp;User Name:</td>
				    <td><s:textfield name="user_name"/>
				    <s:fielderror fieldName="user_name" theme="simple"/>
				    </td>
				  </tr-->
				  
				  
				  <tr>
				  	<td colspan=4>1. ई-पंजियन वेबसाइट के बारे में आप क्या सोचते हैं?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'बहुत_मददगार':'बहुत मददगार','संतोषजनक':'संतोषजनक','असंतोषजनक':'असंतोषजनक'}" name="question_1"></s:radio></td>
				  </tr>
				  <tr>
				  	<td colspan=4>2. क्या ई-पंजियन साइट आपको दस्तावेज़ पंजीकरण के ऑनलाइन आवेदन जमा करने में मदद करती है?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'बहुत_मददगार':'बहुत मददगार','संतोषजनक':'संतोषजनक','असंतोषजनक':'असंतोषजनक'}" name="question_2"></s:radio></td>
				  </tr>
				  <tr>
				  	<td colspan=4>3. ऑनलाइन दस्तावेज़ पंजीकरण आवेदन के बारे में अपने दोस्तों को बताने की कितनी संभावना है?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'बहुत_संभावना_है':'बहुत संभावना है','संभावित':'संभावित','शायद':'शायद'}" name="question_3"></s:radio></td>
				  </tr>
				  
				  
				  <tr>
				  	<td colspan=4>4. क्या आपने संपत्ति मूल्यांकन सुविधा का उपयोग किया है?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'हाँ':'हाँ','नहीं':'नहीं'}" name="question_4"></s:radio></td>
				  </tr>
				  <tr>
				  	<td colspan=4>5. क्या आपने ई-निरीक्षण / खोज सुविधा का उपयोग किया है?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'हाँ':'हाँ','नहीं':'नहीं'}" name="question_5"></s:radio></td>
				  </tr>
				  <tr>
				  	<td colspan=4>6. क्या आपने डीएलसी दर सूचना सुविधा का उपयोग किया है?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'हाँ':'हाँ','नहीं':'नहीं'}" name="question_6"></s:radio></td>
				  </tr>
				  <tr>
				  	<td colspan=4>7. क्या आपने ऑनलाइन टाइम स्लॉट बुकिंग सुविधा का उपयोग किया है?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'हाँ':'हाँ','नहीं':'नहीं'}" name="question_7"></s:radio></td>
				  </tr>
				  <tr>
				  	<td colspan=4>8. क्या आपने ऑनलाइन ट्रैक / दस्तावेज़ स्थिति सुविधा का उपयोग किया है?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'हाँ':'हाँ','नहीं':'नहीं'}" name="question_8"></s:radio></td>
				  </tr>
				  
				  
				  <tr>
				  	<td colspan=4>9. क्या आपने दस्तावेज़ वार फीस / छूट सुविधा का उपयोग किया है?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'हाँ':'हाँ','नहीं':'नहीं'}" name="question_9"></s:radio></td>
				  </tr>
				  <tr>
				  	<td colspan=4>10. क्या आपने डाउनलोड पंजीकृत दस्तावेज़ (स्व) सुविधा का उपयोग किया है?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'हाँ':'हाँ','नहीं':'नहीं'}" name="question_10"></s:radio></td>
				  </tr>
				  
				  
				  <tr>
				  	<td colspan=4>11. आपने कितनी बार ई-पंजियन वेबसाइट का उपयोग किया?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'प्रतिदिन':'प्रतिदिन','प्रतिमास':'प्रतिमास','वार्षिक':'वार्षिक','जब_भी_आवश्यकता_हो':'जब भी आवश्यकता हो'}" name="question_11"></s:radio></td>
				  </tr>
				  <tr>
				  	<td colspan=4>12. आपने ई-पंजियन वेबसाइट के बारे में कैसे सुना?</td>
				  </tr>
				  <tr>
				  	<td colspan=4><s:radio list="#{'ऑनलाइन_खोज':'ऑनलाइन खोज','उप_पंजीयक_कार्यालय':'उप पंजीयक कार्यालय','मित्र':'मित्र','अन्य_स्रोत':'अन्य स्रोत'}" name="question_12"></s:radio></td>
				  </tr>
				  
				  
				  <tr>
				  	<td colspan=4>13. आप ई-पंजियन वेबसाइट पर निम्नलिखित सेवाओं का मूल्यांकन कैसे करेंगे?</td>
				  </tr>
				  <tr>
				  	<td colspan=4>
				  		<table border=1 cellspacing=0 width="100%" cellpadding="5">
				  			<tr>
					  			<td>संपत्ति के मूल्यांकन</td>
					  			<td><s:radio list="#{'असंतुष्ट_करना':'असंतुष्ट करना','निष्पक्ष':'निष्पक्ष','संतुष्ट_करना':'संतुष्ट करना','बहुत_संतुष्ट_हैं':'बहुत संतुष्ट हैं'}" name="question_13_1"></s:radio></td>
				  			</tr>
				  			
				  			<tr>
					  			<td>संपत्ति के मूल्यांकन</td>
					  			<td><s:radio list="#{'असंतुष्ट_करना':'असंतुष्ट करना','निष्पक्ष':'निष्पक्ष','संतुष्ट_करना':'संतुष्ट करना','बहुत_संतुष्ट_हैं':'बहुत संतुष्ट हैं'}" name="question_13_2"></s:radio></td>
				  			</tr>
				  			<tr>
					  			<td>डीएलसी दर की जानकारी</td>
					  			<td><s:radio list="#{'असंतुष्ट_करना':'असंतुष्ट करना','निष्पक्ष':'निष्पक्ष','संतुष्ट_करना':'संतुष्ट करना','बहुत_संतुष्ट_हैं':'बहुत संतुष्ट हैं'}" name="question_13_3"></s:radio></td>
				  			</tr>
				  			<tr>
					  			<td>ऑनलाइन टाइम स्लॉट बुकिंग</td>
					  			<td><s:radio list="#{'असंतुष्ट_करना':'असंतुष्ट करना','निष्पक्ष':'निष्पक्ष','संतुष्ट_करना':'संतुष्ट करना','बहुत_संतुष्ट_हैं':'बहुत संतुष्ट हैं'}" name="question_13_4"></s:radio></td>
				  			</tr>
				  			<tr>
					  			<td>ऑनलाइन ट्रैक / दस्तावेज़ की स्थिति</td>
					  			<td><s:radio list="#{'असंतुष्ट_करना':'असंतुष्ट करना','निष्पक्ष':'निष्पक्ष','संतुष्ट_करना':'संतुष्ट करना','बहुत_संतुष्ट_हैं':'बहुत संतुष्ट हैं'}" name="question_13_5"></s:radio></td>
				  			</tr>
				  			<tr>
					  			<td>दस्तावेज़ वार फीस / छूट</td>
					  			<td><s:radio list="#{'असंतुष्ट_करना':'असंतुष्ट करना','निष्पक्ष':'निष्पक्ष','संतुष्ट_करना':'संतुष्ट करना','बहुत_संतुष्ट_हैं':'बहुत संतुष्ट हैं'}" name="question_13_6"></s:radio></td>
				  			</tr>
				  			
				  			
				  			
				  			
				  			<tr>
					  			<td>पंजीकृत दस्तावेज (स्व) डाउनलोड करें</td>
					  			<td><s:radio list="#{'असंतुष्ट_करना':'असंतुष्ट करना','निष्पक्ष':'निष्पक्ष','संतुष्ट_करना':'संतुष्ट करना','बहुत_संतुष्ट_हैं':'बहुत संतुष्ट हैं'}" name="question_13_7"></s:radio></td>
				  			</tr>
				  			<tr>
					  			<td>संपादन योग्य / डाउनलोड करने योग्य विलेख प्रपत्र</td>
					  			<td><s:radio list="#{'असंतुष्ट_करना':'असंतुष्ट करना','निष्पक्ष':'निष्पक्ष','संतुष्ट_करना':'संतुष्ट करना','बहुत_संतुष्ट_हैं':'बहुत संतुष्ट हैं'}" name="question_13_8"></s:radio></td>
				  			</tr>
				  			<tr>
					  			<td>ऑनलाइन दस्तावेज़ जमा करने के लिए मदद</td>
					  			<td><s:radio list="#{'असंतुष्ट_करना':'असंतुष्ट करना','निष्पक्ष':'निष्पक्ष','संतुष्ट_करना':'संतुष्ट करना','बहुत_संतुष्ट_हैं':'बहुत संतुष्ट हैं'}" name="question_13_9"></s:radio></td>
				  			</tr>
				  		</table>
				  	</td>
				  </tr>
				  
				  
				  
				  
				  <!--tr>
				    <td align="right">Enter Password:</td>
				    <td><s:password name="user_password"/>
				    <s:fielderror fieldName="user_password" theme="simple"/>
				    </td>
				     <td align="right">&nbsp;&nbsp;Confirm Password:</td>
				    <td><s:password name="confirmPassword"/>
				    <s:fielderror fieldName="confirmPassword" theme="simple"/>
				    </td>
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
				    </select> --
				    </td>
				    <td align="right">&nbsp;&nbsp;Date Of Birth(dd/MM/yyyy):</td>
				    <td><s:textfield name="birthDate"/>
				    <s:fielderror fieldName="birthDate" theme="simple"/></td>
				  </tr>
				  <tr>
				    <td align="right">Mobile No:</td>
				    <td><s:textfield name="mobileNo" />
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
				  <td align="right"><img src="Captcha.jpg" border="0"></td>
				  <td align="left"><input type="text" name="captcha" required="required"></td>
				  <td>&nbsp;</td>
				  <td>&nbsp;</td>
				 </tr-->
				 <tr><th colspan=4><input type="submit" value="Submit"></th></tr>
				 </table> 
				 </div> 
				 <div class="my_button">
				 
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
	/*document.getElementsByName("fatherName")[0].placeholder="Enter in Hindi Only";
	document.getElementsByName("address")[0].placeholder="Address in english";
	document.getElementsByName("user_name")[0].placeholder="Enter in english only(use for login)";
	document.getElementsByName("user_password")[0].placeholder="Strong Password Needed";
	document.getElementsByName("confirmPassword")[0].placeholder="Confirm Password";
	document.getElementsByName("birthDate")[0].placeholder="dd/MM/yyyy";
	*/
	document.getElementsByName("mobileNo")[0].placeholder="10 digit mobile no";
	//document.getElementsByName("cardNo")[0].placeholder="Your Identity Card No";
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