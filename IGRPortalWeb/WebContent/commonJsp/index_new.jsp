<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style_new.css" type="text/css" rel="stylesheet" />
         <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/breadcrumb.css">
          <script src="/IGRPortalWeb/js/sha256.js"></script>
        <title>Home</title>
        <link rel="shortcut icon" href="../images/chhattisgarhLogo.png" type="img/png"/>
        
        <script>
            function validateFunction(){
                var userId=document.getElementById("userId").value;
                if(userId==null || userId==""){
                    alert("अपना उपयोगकर्ता नाम दर्ज करें");
                    return false;
                }
                var passWord=document.getElementById("passWord").value;
                if(passWord==null || passWord==""){
                    alert("अपना पासवर्ड दर्ज करें");
                    return false;
                }
                return true;
            }
        </script>
        <script type="text/javascript" language="javascript">  

history.pushState(null, null, document.title);
window.addEventListener('popstate', function () {
    history.pushState(null, null, document.title);
});
    
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/fshare.js"></script>

    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/jssor.js"></script>
    <script type="text/javascript" src="js/jssor.slider.js"></script>
    
    <script type="text/javascript" src="js/FlashScript.js"></script>
    
    <!--<script type="text/javascript" src="js/tagcanvas.min.js"></script>
    <script type="text/javascript" src="js/cloudText.js"></script>-->
    
    <script>
$(function() {

	// grab the initial top offset of the navigation 
	var sticky_navigation_offset_top = $('#manubutton').offset().top;
	
	// our function that decides weather the navigation bar should have "fixed" css position or not.
	var sticky_navigation = function(){
		var scroll_top = $(window).scrollTop(); // our current vertical position from the top
		
		// if we've scrolled more than the navigation, change its position to fixed to stick to top, otherwise change it back to relative
		if (scroll_top > sticky_navigation_offset_top) { 
			$('#manubutton').css({ 'position': 'fixed','z-index':'2','top':0,'max-width':'1024px' });
		} else {
			$('#manubutton').css({ 'position': 'relative' }); 
		}   
	};
	
	// run our function on load
	sticky_navigation();
	
	// and run it again every time you scroll
	$(window).scroll(function() {
		 sticky_navigation();
	});
	
	// NOT required:
	// for this demo disable all links that point to "#"
	$('a[href="#"]').click(function(event){ 
		event.preventDefault(); 
	});
	
});
</script>
        
        
        
        
        
        
    </head>
    <body>
    	<div id="wrapper">
    		<div id="heading">
    			<%@include file="../commonJsp/headingPage.jsp" %>
    		</div><!-- end of heading -->
			
			<div id="manubutton">
				<!-- 
				<div class="linkbtn active"><a href="#">मुख्य पृष्ट</a></div>
		        <div class="linkbtn"><a href="SMSPricing.jsp">ई-पंजीयन</a></div>
		        <div class="linkbtn"><a href="Services.jsp">अन्य पंजीयन</a></div>
		        <div class="linkbtn"><a href="#">पंजीयन की प्रक्रिया</a></div>
		        <div class="linkbtn"><a href="ContactUs.jsp">डाउनलोड</a></div>
		        <div class="linkbtn"><a href="ContactUs.jsp">एम. आई. एस.</a></div>
				 -->
				<jsp:include page="../commonJsp/menu.jsp" />
		    </div><!--end of manubutton-->
    		
    		<div id="maincontent">
    			<div id="flashBanner">
    			
    <div id="slider1_container" style="position: relative; width: 710px; height: 250px; overflow: hidden;">

        <!-- Loading Screen -->
        <div u="loading" style="position: absolute; top: 0px; left: 0px;">
            <div style="filter: alpha(opacity=70); opacity:0.7; position: absolute; display: block; background-color: #000; top: 0px; left: 0px;width: 100%;height:100%;">
            </div>
            <div style="position: absolute; display: block; background: url(images/loading.gif) no-repeat center center; top: 0px; left: 0px;width: 100%;height:100%;">
            </div>
        </div>
        
        <!-- Slides Container -->
        <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 710px; height: 250px; overflow: hidden;">
            
            <%@include file="../commonJsp/flashBanner.jsp" %>
        </div>
        
        <!-- Bullet Navigator Skin Begin -->
        <!-- jssor slider bullet navigator skin 01 -->
        <!-- bullet navigator container -->
        <div u="navigator" class="jssorb01" style="position: absolute; bottom: 16px; right: 10px;">
            <!-- bullet navigator item prototype -->
            <div u="prototype" style="POSITION: absolute; WIDTH: 12px; HEIGHT: 12px;"></div>
        </div>
        <!-- Bullet Navigator Skin End -->
        
        <span u="arrowleft" class="jssora05l" style="width: 40px; height: 40px; top: 123px; left: 8px;">
        </span>
        <!-- Arrow Right -->
        <span u="arrowright" class="jssora05r" style="width: 40px; height: 40px; top: 123px; right: 8px">
        </span>
        <!-- Arrow Navigator Skin End -->
    </div>
    <!-- Jssor Slider End -->
    			
    			
    			
    			<!--Flash Banner--></div>
    			<div id="aboutUs" class="backcolore">
					<div class="backimg"><div class="back"><h3>हमारे बारे में</h3></div></div>
					
					<p style="margin:10px;">
		                <font>&diams;</font> <!--Providing Solution is Established on 2016.-->
		               	 ई पंजीयन (संपत्ति की पंजीकरण एप्लीकेशन) सॉफ्टवेयर, नागरिक-केंद्रित सेवाओं को अधिक तेज़ी से और समय पर प्रदान करने के अवसर प्रदान करता है। छत्तीसगढ़ सरकार के उप-पंजीयक के कार्यालय और पंजीकरण विभाग के लिए यह सबसे विशिष्ट रूप से प्रबंधित सॉफ्टवेयर है। इसमें कार्य संस्कृति, सार्वजनिक सेवा को प्रबंधित, तैनात, अद्यतन, लागू करने और सुधारने और वास्तविक समय के वातावरण के भीतर पूरी रिपोर्टिंग प्रदान करने की क्षमता है। कम्प्यूटरीकृत भूमि और संपत्ति पंजीकरण प्रणाली के तहत, पंजीकरण आसान है।....
		                <div class="readmore"><a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">Read more...</a></div>
		                <!-- यह मूल्यांकन में पारदर्शिता की सुविधा देता है और बिचौलियों को समाप्त करता है कुछ राज्यों को संबंधित प्राधिकरण को आवेदन प्रस्तुत करना पड़ता है, जो आपके क्षेत्र के उप-पंजीयक हो सकता है। आवेदन फॉर्म को या तो ऑनलाइन डाउनलोड किया जा सकता है या संबंधित प्राधिकरण के कार्यालय से प्राप्त किया जा सकता है। विवरण के सत्यापन के बाद, डीड तैयार हो गया है और पंजीकरण प्रक्रिया पूरी हो चुकी है। -->
				               	 
		            </p>
		        </div>
    		</div>
    		
      
      
			
			<div id="manubutton">
				<marquee behavior="alternate" scrollamount="6" onmouseover="this.stop();" onmouseout="this.start();" style="min-height:18px; line-height:18px;font-size: 15px;color: black">
                   Welcome to e-Panjiyan Web Portal
                </marquee>
		    </div><!--end of manubutton-->
    	
    	
      <div id="maincontent">
          <div id="leftcont" class="backcolore">
              <div class="backimg"><div class="back"><h3>रेडी रेकोनर </h3></div></div>
              <br />
              <!--div style="width:100%;">
                  <center><img src="images/stamp_icon.png" /></center>
              </div-->
              <br />
			<p style="margin:10px;">
                <font>&diams;</font>
                छत्तीसगढ़ के किसी भी स्थान के लिए एक विशेष भूमि और विशिष्ट क्षेत्र के लिए स्टांप शुल्क की गणना के लिए क्लिक करें
			</p>
			
			<ol style="margin-left:20px;font-size: 12px;font-weight:bold;">
			  <li><a href="/IGRPortalWeb/PropertyDetailEnquiryAction?page_id=2" target="_blank">जमीन की बाजार मूल्य</a></li>
			  <li><a href="/IGRPortalWeb/PropertyDetailEnquiryAction?page_id=1" target="_blank">जमीन की बाजार मूल्य संरचना का सहित</a></li>
			  <li><a href="/IGRPortalWeb/StampValueEnquiryAction" target="_blank">मुद्रांक एब पंजीयन शुल्क</a></li>
			</ol> 
         </div>
          <div id="leftcont2" class="backcolore">
              <div class="backimg"><div class="back"><h3>जमीन की हक सम्बंधी खोज<!--प्रतिबंधित जमीन--></h3></div></div>
              <br />
              <!--div style="width:100%;">
                  <center><img src="images/land_search_icon.png" /></center>
              </div-->
              <br />
			<p style="margin:10px;">
                <font>&diams;</font>
             <!--   आपत्तिजनक भूमि की खोज जो या तो नहीं बेचा जा सकता हैं। इस श्रेणी के अंतर्गत भूमि खोज करने के लिए|-->
              खसरा पांचसाला एबम खतियानी , नजूल संधारण खसरा , परिबर्तित भूमि संधारण खसरा संबंधित भूमि विवरण देखें ! 
			</p>
			<br /><br />
			&nbsp; &nbsp; <a href="titleOfLandAction">Click Me</a>
         </div>
         
    	
         <div id="medillcont" class="backcolore">
            <div class="backimg"><div class="back"><h3>विवादित भूमि </h3></div></div>
              <br />
              <!--div style="width:100%;">
                  <center><img src="images/register_process_icon.png" /></center>
              </div-->
              <br />
			<p style="margin:10px;">
                <font>&diams;</font>
               विवादित भूमि की खोज जो नहीं बेचा जा सकता हैं। इस श्रेणी के अंतर्गत भूमि खोज करने के लिए|
			</p>
			<br /><br />
			&nbsp; &nbsp; <a href="DisputedLandAction" target="_blank">Click Me</a>
         </div>
         
         <div id="rightcont" class="backcolore">
             <!--  form method="post" action="loginCode.jsp" onsubmit="return validateFunction();" autocomplete="off"-->
               <form method="post" action = "LoginAction"  id="loginForm" autocomplete="off" onsubmit="hashPass();">
               <input type="hidden" name="js_enabled" id="js_enabled" value="false" />
                 <div class="backimg"><div class="back"><h3><!-- Member Login -->पंजीकरण खोज हेतु लॉगिन करें!<!-- विवरणी --></h3></div></div>
                 <center>
                 <table border="0">
                 <%
        String getMsg=request.getParameter("msg");
                if(getMsg==null){}else{
	
	            String eror="Wrong Employee Code or Password";
	            
                 %>
                 <tr>
                     <td><div class="entrytext" style="color:red;"><h3><%=eror%></h3></div></td>
                 </tr>
                 <% } %>
                 <!--  >tr>
                     <td><div class="entrytext"><h3 style="text-align: left; font-size: 12px;">उपयोगकर्ता नाम<!-- Username --</h3></div></td>
                 </tr-->
                 <tr>
                 	<td><input type="text" class="txtbox" name="userName" id="userName" placeholder="अपना उपयोगकर्ता नाम दर्ज करें" /></td>
                 </tr>
                 <!--  >tr>
                     <td><div class="entrytext"><h3 style="text-align: left; font-size: 12px;">पासवर्ड<!-- Password --</h3></div></td>
                 </tr-->
                 <tr>
                 	<td><input type="password" class="txtbox" name="password" id="password" placeholder="अपना पासवर्ड दर्ज करें" /></td>
                 </tr><input type="hidden" name="language" value="2" />
                 <tr>
                 	<td ><img src="Captcha.jpg" border="0"><%-- <h3><s:property value="ch"/></h3> --%></td>
                 	</tr>
                 	<tr>
                    <td><input type="text" class="txtbox" placeholder="Captcha" name="captcha" required="required"></td>
				</tr>
                 <tr>
                 	<!--  >td align="right"><input type="submit" value="Login" class="button white" /></td-->
                 </tr>
                 </table>
                 </center>
                 <div class="my_button">
                       		<%-- <input type="hidden" value="<%=session.getAttribute("salt") %>" name="salt"> --%>
                       				
                       				<input type="submit" value="Signin"  class="button white">&nbsp;<input type="reset"  class="button white" value="RESET" >&nbsp;
                       				<s:url action="signupFormAction"  var="signup"/>
                       				<a href="<s:property value='#signup'/>">New User</a>  
                       				
                       		</div>
             </form>
         </div>
      </div><!--end of maincontent-->
      
      <div id="manubutton">
         
         <div style="float:left;"><h3>Copy Right &copy; 2016 </h3></div>
         <div style="float:right;"><h3>Powered By :-</h3></div>
      </div><!--end of manubutton-->
    		
    		
    	</div><!-- end of wrapper -->
    	
    	
   
   <div id="light" class="white_content">
       	हमारे बारे में
       
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">
           (X)
       </a>
       <br /><br />
<font style="font-size:12px;">
	ई पंजीयन (संपत्ति की पंजीकरण एप्लीकेशन) सॉफ्टवेयर, नागरिक-केंद्रित सेवाओं को अधिक तेज़ी से और समय पर प्रदान करने के अवसर प्रदान करता है। छत्तीसगढ़ सरकार के उप-पंजीयक के कार्यालय और पंजीकरण विभाग के लिए यह सबसे विशिष्ट रूप से प्रबंधित सॉफ्टवेयर है। इसमें कार्य संस्कृति, सार्वजनिक सेवा को प्रबंधित, तैनात, अद्यतन, लागू करने और सुधारने और वास्तविक समय के वातावरण के भीतर पूरी रिपोर्टिंग प्रदान करने की क्षमता है। कम्प्यूटरीकृत भूमि और संपत्ति पंजीकरण प्रणाली के तहत, पंजीकरण आसान है। यह मूल्यांकन में पारदर्शिता की सुविधा देता है और बिचौलियों को समाप्त करता है कुछ राज्यों को संबंधित प्राधिकरण को आवेदन प्रस्तुत करना पड़ता है, जो आपके क्षेत्र के उप-पंजीयक हो सकता है। आवेदन फॉर्म को या तो ऑनलाइन डाउनलोड किया जा सकता है या संबंधित प्राधिकरण के कार्यालय से प्राप्त किया जा सकता है।
</font>

   </div>
   
   <div id="fade" class="black_overlay"></div>
   
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
    </body>
</html>