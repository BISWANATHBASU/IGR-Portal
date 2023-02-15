<!DOCTYPE html>

	<%@page contentType="text/html" pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <style type="text/css">
    .blink {
      animation: blinker 2s linear infinite;
      color: red;
      font-size: 25px;
      font-weight: bold;
      font-family: sans-serif;
      }
      @keyframes blinker {  
      50% { opacity: 0; }
      }
      .blink-one {
      animation: blinker-one 1s linear infinite;
      }
      @keyframes blinker-one {  
      0% { opacity: 0; }
      }
      .blink-two {
      animation: blinker-two 2.5s linear infinite;
      }
      @keyframes blinker-two {  
      100% { opacity: 0; }
      }
      
      
div#co-box {
	border: 2px solid #ddd;
	background: #dedede;
	padding: 30px 5px 25px;
}

div#co-box {
    border: 2px solid #ddd;
    background: #dedede;
    padding: 10px 5px 25px;
}
.text-box-co1 {
    font-size: 30px;
    text-align: center;
    color: #ddd;
}
.co-img-box {
    margin: 10px 0 20px;
}
.text-box-co2 {
    font-size: 18px;
    text-align: center;
    color: #565555;
}
.text-box-co {
    text-align: center;
    font-size: 24px;
    line-height: 42px;
}
.text-box-co1 a {
    color: #0337cc;
}
@media only screen and (max-width: 600px) {
.text-box-co {
    font-size: 22px;
}
.co-img-box{
	margin-bottom:10px;
}
 .text-box-co1 {
    font-size: 22px;}
.text-box-co2 {
    font-size: 14px;
}
div#co-box {
    padding: 10px;
}
}

      
    </style>
    
    <%@include file="../commonJsp/include.jsp" %>
    <script>
    	function languageFunction(val){
    		alert(val);
    		//return true;
    		
    		var url = "homeAction.action?langCod=" + langCod;//document.getElementById('langCod').value;
            document.getElementById("frm").setAttribute('action', url);
    	}
    </script>
</head>
<body id="page1" onload="loadNews();" oncontextmenu="return false;"><!--  -->

<div class="main">
	<div class="container_12">
	<form name="frm" method="post" action="homeAction.action"></form>
	<div style="float:right;">
		<!--a href="#" onclick="languageFunction(2)">Hindi</a> | 
		<a href="#" onclick="languageFunction(1)">English</a> |-->
		<a href="Home?langCod=2">Hindi</a> | 
		<a href="Home?langCod=1">English</a>
	</div>
	
	<!--==============================header=================================-->
	<%
		String langCode = (String)request.getSession().getAttribute("langCode");
		String langCod = request.getParameter("langCod");
	
		System.out.println("Before Session langCode=="+langCode+"<<langCod="+langCod+">>");
		
		if(langCode == null && langCod == null){// || langCode == "" && langCod == "" || langCode.equals("") && langCod.equals("")
			session.setAttribute("langCode", "2");
		}else if(langCode == null && langCod != null || langCode == "" && langCod != "" || langCode.equals("") && !langCod.equals("")){
			session.setAttribute("langCode", langCod);
		}else if(langCode != null && langCod == null || langCode != "" && langCod == "" || !langCode.equals("") && langCod.equals("")){
			session.setAttribute("langCode", langCode);
		}else if(langCode != null && langCod != null || langCode != "" && langCod != "" || !langCode.equals("") && !langCod.equals("")){
			session.setAttribute("langCode", langCod);
		}else{
			session.setAttribute("langCode", langCod);
		}
		
		langCode = (String)request.getSession().getAttribute("langCode");
		
		System.out.println("After Session langCode=="+langCode+"<<langCod="+langCod+">>");
		if(langCode == null || langCode == "2" || langCode.equals("") || langCode.equals("2")){
			%><%@include file="../commonJsp/header1.jsp" %><%
		}else{
			%><%@include file="../commonJsp/header1_eng.jsp" %><%
		}
	%>
	<!--==============================content================================-->
	<%
		if(langCode == null || langCode == "2" || langCode.equals("") || langCode.equals("2")){
			%><%@include file="../commonJsp/slider.jsp" %><%
		}else{
			%><%@include file="../commonJsp/slider_eng.jsp" %><%
		}
	%>
		    <div id="co-box">
		    	
		    	<div class="text-box-co1" style="margin-top:5px;">
		    		<img src="images/new.gif" style="margin-top: -10px;" width="35px"><a href="https://epanjeeyan.cg.gov.in/IGRPortalNew/" style="color: red;">तत्काल अपॉइंटमेंट लेने के लिए प्री रजिस्ट्रेशन से आवेदन करे | </a>
		    	</div>
	
				<div class="text-box-co1" style="margin-top:20px;"><img src="images/new.gif" style="margin-top: -10px;" width="35px"><a href="coronaContent">पंजीयन हेतु अपॉइंटमेंट बुक करे</a></div>
				
				<div class="text-box-co">
					<a href="searchAppointmentID?page=pdf"> &nbsp; अपॉइंटमेंट डाउनलोड हेतु</a>
				</div>
				
				<br /><br />
				
				<div class="text-box-co2">
				<!-- <div class="co-img-box"><a href="download/CG-Registration.apk" title="Download Android Mobile App"><img src="images/ePanjeeyanMobileApp.png" style="height: 50px;"></a></div> -->
				<div class="text-box-co2">अपॉइंटमेंट बुकिंग हेतु एंड्राइड एप्प डाउनलोड करें</div>
				</div>
				
				<div class="text-box-co1" style="margin: 20px 0;"> 
					<img src="images/new.gif" style="margin-top: -10px;" width="35px"><a href="http://epanjeeyan.cg.gov.in/CGSearch/" target="_blank">सर्च एवं नकल हेतु</a>
				</div>
		    	
				<!-- <div class="text-box-co">
					<a href="cencelAppointmentID"> अपॉइंटमेंट रद्द करने हेतु</a>
				</div> -->
		    	
			</div>
			<!-- End -->
		    	
		    	
	<section id="content">
		<%@include file="../commonJsp/registryReport.jsp" %>
	</section>
    
    <section id="content">
	        	<!-- Index Tabs -->
	<%
		if(langCode == null || langCode == "2" || langCode.equals("") || langCode.equals("2")){
			%><%@include file="../commonJsp/index_tab.jsp" %><%
		}else{
			%><%@include file="../commonJsp/index_tab_eng.jsp" %><%
		}
	%>
             
             
             <div class="wrapper-after">
                
                <!-- Notices, News And Calender -->
                
                <!-- Important Links -->
                <%@include file="../commonJsp/imp_links.jsp"%>
                            
             </div><!--///wrapper-->             
	    </section>
       
       
	    
    </div>
	<!--==============================footer=================================-->
     <%@include file="../commonJsp/footer.jsp" %>

</div>

</body>

	

</html>