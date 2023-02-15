<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="wrapper">
	            <div class="grid_9" style="margin-left: 0;">
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
        	        <li><img alt="" src="/IGRPortalWeb/images/slide_3.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
        	        <li><img alt="" src="/IGRPortalWeb/images/slide_4.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
        	        <li><img alt="" src="/IGRPortalWeb/images/slide_5.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
        	        <li><img alt="" src="/IGRPortalWeb/images/slide_6.jpg">
        	            <div class="flex-caption">
        	                  <div class="inner">
        	                  	<strong></strong>
        	                  	<span></span>
        	                  </div>
        	            </div>
        	        </li>
        	        <li><img alt="" src="/IGRPortalWeb/images/slide_7.jpg">
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
				<!--  div class="grid_4 toppadding">
					<h3>हमारे बारे में</h3>
					<p>ई पंजीयन (संपत्ति की पंजीकरण एप्लीकेशन) सॉफ्टवेयर, नागरिक-केंद्रित सेवाओं को अधिक तेज़ी से और समय पर प्रदान करने के अवसर प्रदान करता है। छत्तीसगढ़ सरकार के उप-पंजीयक के कार्यालय और पंजीकरण विभाग के लिए यह सबसे विशिष्ट रूप से प्रबंधित सॉफ्टवेयर है। इसमें कार्य संस्कृति, सार्वजनिक सेवा को प्रबंधित, तैनात, अद्यतन, लागू करने और सुधारने और वास्तविक समय के वातावरण के भीतर पूरी रिपोर्टिंग प्रदान करने की क्षमता है। कम्प्यूटरीकृत भूमि और संपत्ति पंजीकरण प्रणाली के तहत, पंजीकरण आसान है। यह मूल्यांकन में पारदर्शिता की सुविधा देता है और बिचौलियों को समाप्त करता है कुछ राज्यों को संबंधित प्राधिकरण को आवेदन प्रस्तुत करना पड़ता है, जो आपके क्षेत्र के उप-पंजीयक हो सकता है। आवेदन फॉर्म को या तो ऑनलाइन डाउनलोड किया जा सकता है या संबंधित प्राधिकरण के कार्यालय से प्राप्त किया जा सकता है। विवरण के सत्यापन के बाद, डीड तैयार हो गया है और पंजीकरण प्रक्रिया पूरी हो चुकी है।</p>
					
					<!-- <a href="#" class="button top">Read More</a> -->
				<!-- /div-->
				 <div class="grid_3 toppadding" align="center" border="1"> 
	                      						
						
						  <form method="post" action = "LoginAction"  id="loginForm" autocomplete="off" onsubmit="hashPass();">
						  <input type="hidden" name="js_enabled" id="js_enabled" value="false" />
						 <!--  <input type="hidden" name="password" id="pass" value="false" /> -->
						  <div >
						  <p><s:actionerror/></p>
                       		<table>
                       		<tr><h3>Login</h3></tr>
                       			<tr>
                       				<!--  td width="102">User Name</td-->
                       				<td width=600px height=40px><input type="text" placeholder="User Id" name="userName" required="required"></td>
                       				<br>
								</tr>
                      				<tr>
                       				<!--  td>Password</td-->
                       				<td  width=500px height=40px><input type="password" name="password" placeholder="Password" required="required" id="password"></td>
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
                       				<td  width=500px height=40px><img src="Captcha.jpg" border="0"><%-- <h3><s:property value="ch"/></h3> --%></td>
                       				</tr>
                       				<tr>
                       				<td  width=500px height=40px ><input type="text" placeholder="Captcha" name="captcha" required="required"></td>
								</tr>                    			
                       		</table> 
                       		</div>
                       		<br>
                       		<div class="my_button">
                       		<%-- <input type="hidden" value="<%=session.getAttribute("salt") %>" name="salt"> --%>
                       				
                       				<input type="submit" value="Signin">&nbsp;<input type="reset" value="RESET" >&nbsp;
                       				<s:url action="signupFormAction" var="signup"/>
                       				<a href="<s:property value='#signup'/>">New User</a>  
                       				
                       		</div>    <br>   
                       		             
                        </form>	
                        
                        </div>
		</div>