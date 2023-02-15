<!DOCTYPE html>
<html>
	<head>
		<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<style>
		.menuTag {
			background-color: lightblue;
		    z-index: 1;
		    float: left;
		}
		.menuTag a {
		    text-decoration: none;
		    color: blue;/*#01addb;*/
		    font-size: 12px;
		    padding: 5px;
		    display:inline-block;
		}
		ul {
			display: inline;
			margin: 0;
		    padding: 0;
		    z-index: 1;
		}
		ul li {
			display: inline-block;
			min-width: 120px;
		}
		ul li:hover {
			background: #01addb;/*#555*/
		}
		ul li:hover a {
			color: white;
		}
		ul li:hover ul {
			display: block;
		}
		ul li ul {
		    position: absolute;
		    width: 180px;
		    display: none;
		}
		ul li ul li {
			background: #555;
			display: block; 
			text-align:left;
			
		}
		ul li ul li a {
			display:block !important;
		} 
		ul li ul li:hover {
			background: #666;
		}
		</style>
	</head>
	<body>
	
	<div class="menuTag">
	  <ul>
	    <li>
	      <!--<a href="#">मुख्य पृष्ट</a-->
	      
	            <s:url action="indexAction" var="home"></s:url>
	            <a href="/IGRPortalWeb/">मुख्य पृष्ठ</a>
	    </li>
	  </ul>
	  <ul>
	    <li>
	      <a href="#">ई-पंजीयन</a>
	      <ul>
	        <li><a href="#">प्री रेजिस्ट्रेसन</a></li>
	        <!-- li><a href="#">कार्यालय पंजीयन</a></li>
	        <li><a href="#">यूजर गाइड</a></li>
	        <li><a href="#">ऑनलाइन भुकतान की प्रक्रिया</a></li-->
	      </ul>
	    </li>
	  </ul>
	  
	  <ul>
	    <li>
	      <a href="#">अन्य पंजीयन</a>
	      <ul>
	        <li><a href="#">बंध पत्र</a></li>
	        <li><a href="#">को-ऑपरेटिव</a></li>
	      </ul>
	    </li>
	  </ul>
	  
	  <ul>
	    <li>
	      <a href="#">पंजीयन की प्रक्रिया</a>
	      <ul>
	        <li><a href="preRegProcessAction">प्री रेजिस्ट्रेसन की प्रक्रिया</a></li>
	        <li><a href="regProcessAction">कार्यालय में पंजीयन की प्रक्रिया</a></li>
	        <li><a href="#">बंध पत्र की प्रक्रिया</a></li>
			<li><a href="/IGRPortalWeb/download/User_Guide.pdf" target="_blank">यूजर गाइड</a></li> 
			<li><a href="/IGRPortalWeb/download/pre_registration_online_payment.pdf" target="_blank">ऑनलाइन भुकतान की प्रक्रिया</a></li>
	      </ul>
	    </li>
	  </ul>
	  
	  <ul>
	    <li>
	      <a href="#">डाउनलोड</a>
	      <ul>
	        <li><a href="inputFormAction">इनपुट फॉर्म</a></li>
	        <li><s:url action="deedSampleAction" var="deed_sample"></s:url>
	        <a href="<s:property value='#deed_sample'/>">विलेख नमूना</a></li>
	        <!--li><a href="#">विलेख नमूना</a></li-->
	        <li><a href="/IGRPortalWeb/download/Search_Form_Format1.pdf" target="_blank">अभिलेख निरीक्षण</a></li>
	        <li><a href="/IGRPortalWeb/download/indexsearch.pdf" target="_blank">अभिलेख अबोलोकोन</a></li>
	        <li><a href="https://www.cgstate.gov.in/web/registration-stamps/" target="_blank">गाइड लाइन पंजी</a></li>
	        <li><a href="/IGRPortalWeb/download/Fee_Structure_Deed_Types.pdf" target="_blank">विलेखवार मुद्रांक एवं पंजीयन शुल्क विवरणी</a></li>
	        <li><a href="/IGRPortalWeb/download/Abhipramanit_Pratilipi_Form.pdf" target="_blank">प्रमाणित प्रतिलिपि का आवेदन पत्र</a></li>
	        <li><a href="/IGRPortalWeb/download/RegistratioAct1908.pdf" target="_blank">मध्य प्रदेश/छत्तीसगढ़ रजिस्ट्रेशनकारण नियम 1943</a></li>
	        <li><a href="/IGRPortalWeb/download/StampACT1899.pdf" target="_blank">मध्य प्रदेश/छत्तीसगढ़ स्टाम्प नियम</a></li>
	        <li><a href="#">कंप्यूटरीकृत पंजीयन नियम</a></li>
	        <li><a href="/IGRPortalWeb/software/Google-hindi-input-setup.zip" target="_blank">हिंदी सॉफ्टवेर</a></li>
	      </ul>
	    </li>
	  </ul>
	  <ul>
	    <li>
	      <a href="#">एम. आई. एस.</a>
	      <ul>
			<li><a href="/IGRPortalWeb/commonJsp/mis_pre_reg_report_sel.jsp">प्री रेजिस्ट्रेसन</a></li>
			<li><a href="https://epanjeeyan.cg.gov.in/IGRDashboard/" target="_blank">ऑफिस रिपोर्ट</a></li>
	      </ul>
	    </li>
	  </ul>
	  <ul>
	    <li>
	      <a href="https://epanjeeyan.cg.gov.in/CGSearch/" target="_blank">पंजीकरण खोज</a>
	    <li>
	  </ul>
	</div>
	
	</body>
</html>
