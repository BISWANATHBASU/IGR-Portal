<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="/IGRPortalWeb/js/sha256.js"></script>
    <%@include file="../commonJsp/include.jsp" %>
</head>
<script type="text/javascript" language="javascript">  

history.pushState(null, null, document.title);
window.addEventListener('popstate', function () {
    history.pushState(null, null, document.title);
});
</script>
<div class="wrapper" >
		
				<!--div class="grid_4 toppadding"  >
				<!--
					<h3>हमारे बारे में</h3>
					<p>ई पंजीयन (संपत्ति की पंजीकरण एप्लीकेशन) सॉफ्टवेयर, नागरिक-केंद्रित सेवाओं को अधिक तेज़ी से और समय पर प्रदान करने के अवसर प्रदान करता है। छत्तीसगढ़ सरकार के उप-पंजीयक के कार्यालय और पंजीकरण विभाग के लिए यह सबसे विशिष्ट रूप से प्रबंधित सॉफ्टवेयर है। इसमें कार्य संस्कृति, सार्वजनिक सेवा को प्रबंधित, तैनात, अद्यतन, लागू करने और सुधारने और वास्तविक समय के वातावरण के भीतर पूरी रिपोर्टिंग प्रदान करने की क्षमता है। कम्प्यूटरीकृत भूमि और संपत्ति पंजीकरण प्रणाली के तहत, पंजीकरण आसान है। यह मूल्यांकन में पारदर्शिता की सुविधा देता है और बिचौलियों को समाप्त करता है कुछ राज्यों को संबंधित प्राधिकरण को आवेदन प्रस्तुत करना पड़ता है, जो आपके क्षेत्र के उप-पंजीयक हो सकता है। आवेदन फॉर्म को या तो ऑनलाइन डाउनलोड किया जा सकता है या संबंधित प्राधिकरण के कार्यालय से प्राप्त किया जा सकता है। विवरण के सत्यापन के बाद, डीड तैयार हो गया है और पंजीकरण प्रक्रिया पूरी हो चुकी है।</p>
					--
					<!-- <a href="#" class="button top">Read More</a> --
					 
	<section id="content" >        	
	        	<div class="wrapper" >
	            <!-- <article class="grid_4" style="margin-top: 20px;">	    --
	            <article class="grid_9">
	            
	           
                   <div class="indent">
					<div style="float:left;border:0px solid red;">
						<img src="/IGRPortalWeb/images/Shri_Bhupesh_Baghel_new.jpg" height=100px width =100px; alt="श्री भूपेश बघेल">
						<br />श्री भूपेश बघेल<br />माननीय मुख्यमंत्री छत्तीसगढ़ 
					</div>
					<div style="float:left;border:0px solid green;width:25px;"> &nbsp; </div>
					<div style="float:left;border:0px solid blue;">
						<img src="/IGRPortalWeb/images/min_rev.jpg" height=100px width =100px; alt="श्री जयसिंह अग्रवाल">
						<br />श्री जयसिंह अग्रवाल<br />माननीय मंत्री छत्तीसगढ़
					</div>
                   
                   </div> <!-- indent div --
                   </article>
                   
	            <div align="center" style="text-align: center;" >
						  <form method="post" action = "LoginAction"  id="loginForm" autocomplete="off" onsubmit="hashPass();">
						  <input type="hidden" name="js_enabled" id="js_enabled" value="false" />
                       		<table width="100%" align="center" border="0">
                       			<tr>
                       				<th><s:actionerror/></th>
								</tr>
                       			<tr>
                       				<th><h3>मेम्बर  लॉगइन</h3></th>
								</tr>
                       			<tr>
                       				<td><input type="text" placeholder="User Name" name="userName" required="required" style="width:300px;"></td>
								</tr>
                      			<tr>
                       				<td><input type="password" name="password" placeholder="Password" required="required" id="password" style="width:300px;"></td>
								</tr><input type="hidden" name="language" value="2" />
                       			<tr>
                       				<td width="102"><img src="Captcha.jpg" border="0"><%-- <h3><s:property value="ch"/></h3> --%></td>
								</tr>   
                       			<tr>
                       				<td><input type="text" placeholder="Captcha" name="captcha" required="required" style="width:300px;"></td>
								</tr>    
                       			 <tr>
                       				<th>
                       					<input type="submit" value="Signin">&nbsp;<input type="reset" value="RESET" >&nbsp;
                       					<s:url action="signupFormAction" var="signup"/>
                       					<a href="<s:property value='#signup'/>">New User</a>
                       				</th>
								</tr>                    			
                       		</table>
                        </form>	
                        
                        </div>		
                        		
	           <!--  </article>       --
                <div class="clear" style="border:1px solid red;"> jhgjh </div> 
                             
	         </div><!--///wrapper--
	    </section>
					
				</div-->
		
		<div class="row" >
	            <div class="grid_7" ><!-- style="margin-left: 0;" -->
	            <div class="main-slider">
        	<div class="flexslider clearfix">
        	      <ul class="slides">
        	        <!--li><img alt="" src="/IGRPortalWeb/images/slide_1.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	            </li>
        	        <li><img alt="" src="/IGRPortalWeb/images/slide_2.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	            </li-->
        	        <li><img alt="" src="/IGRPortalWeb/image/001.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
        	        <!-- <li><img alt="" src="/IGRPortalWeb/image/002.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li> -->
        	        <li><img alt="" src="/IGRPortalWeb/image/003.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
        	        <li><img alt="" src="/IGRPortalWeb/image/004.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
        	        <li><img alt="" src="/IGRPortalWeb/image/005.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
					<li><img alt="" src="/IGRPortalWeb/image/006.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
					<li><img alt="" src="/IGRPortalWeb/image/007.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
					<li><img alt="" src="/IGRPortalWeb/image/008.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
					<li><img alt="" src="/IGRPortalWeb/image/009.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
        	      </ul>
        	</div>
        </div>
				</div>
		
		
		<div class="grid_5 toppadding">
			<%@include file="../commonJsp/aboutUsEng.jsp"%>
					<!--h3>About us</h3>
					<p style="text-align:justify;">
						E-Registration (Property Registration Application) software provides opportunities to provide citizen-centric services more quickly and on time. 
						This is the most specialized software for the office of the Deputy Registrar of Chhattisgarh Government and the Registration Department. 
						It has the ability to work culture, manage, deploy, update, implement and improve public service and provide full reporting within real-time environments. 
						Under computerized land and property registration system, registration is easy. It facilitates transparency in evaluation and eliminates intermediaries Some states have to submit the application to the concerned authority, which may be the sub-registrar of your area.
						The application form can either be downloaded online or received from the office of the concerned authority. After verification of the details, the deed has been prepared and the registration process has been completed.
					</p-->
		</div><!-- About Us Pages -->
		</div>
	</div>
		<hr />
		
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