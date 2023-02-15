
    <script src="/IGRPortalWeb/js/sha256.js"></script>
    <%@include file="../commonJsp/include.jsp" %>

<script type="text/javascript" language="javascript">  

history.pushState(null, null, document.title);
window.addEventListener('popstate', function () {
    history.pushState(null, null, document.title);
});

</script>

<div class="grid_5"><!-- grid_5 -->
                   <div class="indent">
                   	<h2 class="ind1">News Update</h2>                    	
					<div id="newsticker">
                  	<div class="newsticker-jcarousellite"> 
                  	 <ul>
                  	 <s:set var="NEWS" value="#application['NEWS']"></s:set>
                  	 <s:if test="%{NEWS.isEmpty()}">
                  	 <%System.out.println("no news"); %>
   						<li>
   						<span class="p3 block">Currently There are No News to display</span>
                   	<p>Please Check Back later</p> 
   						
   						</li>
						</s:if>
						<s:else>
						<s:iterator value="#application['NEWS']" var="news">
            			<li>                	
                   	<span class="p3 block">
                   	
                   	<s:url action="newsDisplayAction.action" var="newsDisplay">
                   		<s:param name="news_id"><s:property value="news_id"/></s:param>
                   	</s:url>
                   	<a href="<s:property value='#newsDisplay'/>" class="font20 hov">
                   	<s:property value="news_headline"/> 
                   	</a>
                   	
                   	</span>
                   	<p><s:property value="brief_content"/></p> 
                   	</li>  
                   	</s:iterator>
                   	</s:else> 
                   	 </ul>
                   	 </div>   
                   	 <s:url action="newsAllAction.action" var="newsAction"></s:url>
                   	<a href="<s:property value='#newsAction'/>" class="button top">View All</a>            	
                   	</div>
                   </div>                   
                </div>
                
                <div class="grid_4"><!-- grid_4 -->
                   <div class="indent">
                   	<h2 class="ind1">Notices</h2>
                   	<div id="newsticker01">
                  	<div class="newsticker-jcarousellite01">
                   	<ul class="list p3">
                   		<s:set var="NOTICES" value="#application['NOTICES']"></s:set>
                   		<s:if test="%{NOTICES.isEmpty()}">
                   		<%System.out.println("no notices"); %>
   						<li>Currently There are no Notice to display</li>
   						<li>Please Check Back Later</li>
						</s:if>
						<s:else>
						<s:iterator value="#application['NOTICES']" var="notice">
						
                   		<li>
                   		<s:url action="noticeDisplayAction" var="noticeDisplay">
                   		<s:param name="notice_id"><s:property value="notice_id"/></s:param>
                   		</s:url>
                   		<a href="<s:property value='#noticeDisplay'/>"><s:property value="notice_about"/></a>
                   		
                   		</li>
                   		</s:iterator>
                   		</s:else>
                   		<!-- <li><a href="#">Praesent vestibum</a></li>
                   		<li><a href="#">Aenean non</a></li>
                   		<li><a href="#">Hendrerit mauris</a></li>
                   		<li><a href="#">Phasellus</a></li>
                   		<li><a href="#">Natoque penatibus magnis</a></li>
                   		<li><a href="#">Dis parturient montes</a></li>
                   		<li><a href="#">Praesent vestibum</a></li>
                   		<li><a href="#">Aenean non</a></li>
                   		<li><a href="#">Hendrerit mauris</a></li>
                   		<li><a href="#">Phasellus</a></li>
                   		<li><a href="#">Natoque penatibus magnis</a></li>
                   		<li><a href="#">Dis parturient montes</a></li> -->
                   	</ul> 
                   	</div>
                   	<s:url action="noticeAllAction.action" var="noticeAction"></s:url>
                   	<a href="<s:property value='#noticeAction'/>" class="button top">View All</a>
                   	</div>                  	
                   </div>
                </div>
                <div class="grid_3">
                   <div class="indent">
                   	<h2 class="ind1">Calendar</h2>
                   	<script type="text/javascript">
						calendar();
					</script>					  
                </div>
                </div>
                
                <!--div class="grid_3">
                	
	<section id="content">        	
	        	<div class="wrapper">
            	<!--article class="grid_12">
                   <div class="indent">                
					<ol class="breadcrumb breadcrumb-arrow">
						<li><s:url value="indexAction.action" var="indexAction"></s:url>
						<a href="<s:property value='#indexAction'/>">घर</a></li>
						<li><a href="#">ई-पंजीयन</a></li>
						<li><a href="/IGRPortalWeb/loginFormAction.action">प्री रेजिस्ट्रेसन</a></li>
						<li class="active"><span>लॉग इन</span></li>
					</ol>				
               </div>
               </article-->
	            <!-- <article class="grid_4" style="margin-top: 20px;">
	            <article class="grid_9">
                   <div class="indent">
                   <h2 class="ind2">लॉगइन विवरण</h2>
                   </div> <!-- indent div
                   </article>
	            <div align="center" style="text-align: center;"> 
	                      						
						
						  <form method="post" action = "LoginAction"  id="loginForm" autocomplete="off" onsubmit="hashPass();">
						  <input type="hidden" name="js_enabled" id="js_enabled" value="false" />
						 <!--  <input type="hidden" name="password" id="pass" value="false" />
						  <div style="width:100%;" align="center">
						  <p><s:actionerror/></p>
                       		<table width="100%" align="center">
                       			<tr>
                       				<!--td width="102">User Name</td--
                       				<td><input type="text" placeholder="User Name" name="userName" required="required" style="width:220px;"></td>
								</tr>
                      				<tr>
                       				<!--td>Password</td--
                       				<td><input type="password" name="password" placeholder="Password" required="required" id="password" style="width:220px;"></td>
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
                       			</tr--
                       			 <tr>
                       				<td><img src="Captcha.jpg" border="0"><%-- <h3><s:property value="ch"/></h3> --%></td>
								</tr>   
                       			 <tr>
                       				<td><input type="text" placeholder="Captcha" name="captcha" required="required" style="width:220px;"></td>
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
	           <!--  </article>       --
                <div class="clear"></div>                
	         </div><!--///wrapper--            
	    </section>
                </div-->
                
                

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