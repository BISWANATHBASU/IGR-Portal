<header>
	<%@page contentType="text/html" pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
		<style>
			.engFontSize{
				font-size:12px;
				text-transform:none;
				font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
			}
		</style>
	
		    <div class="wrapper">
		    	<!--h1><a href="/IGRPortalWeb/"><img src="/IGRPortalWeb/images/logo.png" height=60px alt=""></a></h1-->
		    	<a href="/IGRPortalWeb/"><img src="/IGRPortalWeb/images/logo.png" height=80px alt=""></a>
		    	<!-- div>E-Panjeeyan Portal
		    	</div-->
		    	<div class="tagline">
		    		 <!--img src="images/digital.png" width="100px" height="100px" /-->
					<div style="float:left;border:0px solid red;">
						&nbsp;
						<!--img src="/IGRPortalWeb/images/Shri_Bhupesh_Baghel_new.jpg" height=60px width =80px; alt="Mr. Bhupesh Baghel">
						<br />Mr. Bhupesh Baghel<br />Hon'ble Chief Minister Chhattisgarh -->
					</div>
					<div style="float:left;border:0px solid green;width:25px;"> &nbsp; </div>
					<div style="float:left;border:0px solid blue;">
						&nbsp;
						<!--img src="/IGRPortalWeb/images/min_rev.jpg" height=60px width =80px; alt="Mr. Jaisingh Agrawal">
						<br />Mr. Jaisingh Agrawal<br />Hon'ble Minister Chhattisgarh-->
					</div>
		    	</div>                
		    </div>
		    <nav>
	        	<ul class="sf-menu">
	            <li class="current"><strong></strong>
	            <s:url action="indexAction" var="home"></s:url>
	            <a href="Home" class="engFontSize">Home Page</a>
	            </li>
	            <!--li><strong></strong>
		            <a href="aboutUsAction" class="engFontSize">About Us</a>
	            </li-->
	            <li class="sub-menu"><strong></strong>
		            <a href="#" class="engFontSize">Pre Registration</a>
	            	<ul>
						<li><a href="preRegProcessAction" class="engFontSize">Pre-Registration Process</a></li>
						<li><a href="download/pre_registration_online_payment.pdf" target="_blank" class="engFontSize">Online Payment Option</a></li>
						<!-- <li><a href="/IGRPortalWeb/download/User_Guide.pdf" target="_blank" class="engFontSize">User Guide</a></li> -->
						<li><a href="/IGRPortalWeb/download/pre-registration-user-manual.pdf" target="_blank" class="engFontSize">User Guide</a></li>
						<li><a href="https://epanjeeyan.cg.gov.in/IGRPortalNew/" class="engFontSize">Pre Registration Login</a></li><!-- loginFormAction -->
					</ul>
	            </li>
	            <!--li class="sub-menu"><strong></strong><a href="#">ई-पंजीयन</a>
                      <ul>
	                     <li>
  						<a href="loginFormAction">प्री रेजिस्ट्रेसन</a></li>
	                     <!-- <a href="/IGRPortalWeb/">प्री रेजिस्ट्रेसन</a></li> -->
	                     <!--li><a href="#">कार्यालय पंजीयन</a></li-->
	                     <!--li><a href="/IGRPortalWeb/download/User_Guide.pdf" target="_blank">यूजर गाइड</a></li> 
	                     <li><a href="/IGRPortalWeb/download/pre_registration_online_payment.pdf" target="_blank">ऑनलाइन भुकतान की प्रक्रिया</a></li--                          
	                 </ul>
                </li-->
	            <!--li class="sub-menu"><strong></strong><a href="#" class="engFontSize">Other Registrations</a>
	            	<ul>
						<li><a href="#" class="engFontSize">Bond Registration</a></li>
						<li><a href="#" class="engFontSize">Co-Operative</a></li>
					</ul>
	            </li-->
	            <li class="sub-menu"><strong></strong><a href="#" class="engFontSize">Registration Process</a>
	            	<ul>
						<!--li><a href="preRegProcessAction" class="engFontSize">Pre-Registration Process</a></li-->
						<li><a href="regProcessAction" class="engFontSize">Process of registration at Registry office</a></li>
						<li><a href="#" class="engFontSize">Process of registering a Bond</a></li>
						<li><a href="download/पंजीयन प्रक्रिया.pdf" class="engFontSize">Registration Process</a></li>
						
	                    <!--li><a href="download/User_Guide.pdf" target="_blank" class="engFontSize">User Guide</a></li-->
	                    <!--li><a href="download/pre_registration_online_payment.pdf" target="_blank" class="engFontSize">Online Payment Option</a></li-->
	                    <!--li><a href="/IGRPortalWeb/commonJsp/feedBackFormAction.action">Feedback Form</a></li-->    
					</ul>
	            </li>
	            <li class="sub-menu"><strong></strong><a href="#" class="engFontSize">Downloads</a>
						<ul>
							<li>
	                     <a href="inputFormAction" class="engFontSize">Input Form</a></li>
	                     <li><s:url action="deedSampleAction" var="deed_sample"></s:url>
	                     <a href="<s:property value='#deed_sample'/>" class="engFontSize">Sample Deed</a></li>
	                     <%-- <li><s:url action="deedSampleAction" var="deed_sample"></s:url>
	                     <a href="<s:property value='#deed_sample'/>">à¤µà¤¿à¤²à¥à¤ à¤¨à¤®à¥à¤¨à¤¾</a></li> --%>
                                    <li><a href="download/Search_Form_Format1.pdf" target="_blank" class="engFontSize">Record Inspection</a></li>
                                    <li><a href="download/indexsearch.pdf" target="_blank" class="engFontSize">Overview of Records</a></li>
                           	  	  	<li><a href="https://www.cgstate.gov.in/web/registration-stamps/" target="_blank" class="engFontSize">Registration Guidelines</a></li>
                           	  	  	<li><a href="download/Fee_Structure_Deed_Types.pdf" target="_blank" class="engFontSize">Stamp Duty and Registration fees details</a></li>
                                    <li><a href="download/Abhipramanit_Pratilipi_Form.pdf" target="_blank" class="engFontSize">Application for certified copy</a></li>
                                    <li><a href="download/RegistratioAct1908.pdf" target="_blank" class="engFontSize"><!--मध्य प्रदेश/-->Chhattisgarh Registration Act, 1943</a></li>
                                    <li><a href="download/StampACT1899.pdf" target="_blank" class="engFontSize"><!--मध्य प्रदेश/-->Chhattisgarh Stamp Rules</a></li>
                                    <li><a href="#" class="engFontSize">Process of Computerized Registration</a></li>
                                    <li><a href="https://rajbhasha.net/drupal514/google+input+offline+Microsoft+hindi+installer" target="_blank" class="engFontSize">Hindi Software</a></li>
                                    <li><a href="download/96_Loksewa_Gauranti_13_07_2017_Citizen_Charter.pdf" target="_blank" class="engFontSize">Loksewa Garanti</a></li>
                                    <li><a href="download/eodb.pdf" target="_blank" class="engFontSize">Regarding searching online documents</a></li>
                                    <li><a href="download/bharmukth pramanpatra prakriya.pdf" target="_blank" class="engFontSize">Procedure for obtaining Encumbrance Certificate</a></li>
						</ul>                            
                 </li>
                 <!-- software/Google-hindi-input-setup.zip -->
                 <!-- https://rajbhasha.net/drupal514/google+input+offline+Microsoft+hindi+installer -->
                 
       
	            <li class="sub-menu"><strong></strong><a href="#" class="engFontSize">MIS</a>
						<ul>
							<!--li><a href="commonJsp/mis_pre_reg_report_sel.jsp" class="engFontSize">Pre Registration</a></li-->
							<!--li><a href="https://epanjeeyan.cg.gov.in/IGRDashboard/" target="_blank" class="engFontSize">Office Report</a></li-->
							<li><a href="https://epanjeeyan.cg.gov.in/IGRMis/" target="_blank" class="engFontSize">MIS</a></li>
						</ul>                            
                 </li>
	            <!-- <li><strong></strong>
		            <a href="feedBackFormAction">Feedback Form</a>
	            </li> -->
	            
	            <li class="sub-menu"><strong></strong><a href="#" class="engFontSize">Other</a>
						<ul>
							<!--li><a href="feedBackFormAction" target="_blank" class="engFontSize">Feedback</a></li-->
							<li><a href="https://www.shcilestamp.com/OnlineStamping/OlnEsi" target="_blank" class="engFontSize">Purchase e-Stamp</a></li>
							<li><a href="https://cg.nic.in/eChallan/" target="_blank" class="engFontSize">Purchase e-Challan</a></li>
							<!--li><a href="/IGRPortalWeb/titleOfLandAction" target="_blank" class="engFontSize">Search by Revenue Record</a></li-->
							<li><a href="https://epanjeeyan.cg.gov.in/BacklogDataEntry/" target="_blank" class="engFontSize">Backlog Entry</a></li>
						</ul>                            
                 </li>
	            <!-- <li><strong></strong><a href="feedBackFormAction">Feedback</a></li> -->
	            <!-- By Arun Sir 08-March-2020 Sunday All Employee Come in Office -->
	            
                 <li class="sub-menu"><strong></strong><a href="#" class="engFontSize">Feedback</a>
					<ul>
						<li><a href="feedBackFormAction.action" class="engFontSize">Feedback </a></li>
						<li><a href="complainFormAction.action" class="engFontSize">Grievance</a></li>
						<li><a href="download/user manual of feedback and complain.pdf" target="_blank" class="engFontSize">User Guide</a></li>
						
					</ul>                            
                 </li>
	            
                 
				<!--li><strong></strong><a href="/IGRPortalWeb/commonJsp/mis_pre_reg_report_sel.jsp">à¤à¤®à¤à¤à¤à¤¸</a></li>
				<li><strong></strong><a href="/portalMIS" target="_blank">à¤à¤®à¤à¤à¤à¤¸</a></li-->
	         </ul>
	         <div class="clear"></div>
	        </nav>
	        <!-- <div id="marquee"><marquee><a href="#">à¤à¤®à¤à¤à¤à¤¸</a></marquee></div> -->
	    </header>