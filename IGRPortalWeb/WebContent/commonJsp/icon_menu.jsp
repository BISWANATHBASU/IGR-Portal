<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<div align="center" class="body-contentBG" style="height: 69%; width: 100%; overflow: auto;">
<!--link rel="stylesheet" type="text/css" media="screen" href="/IGRPortalWeb/css/style.css"-->
<%   
	response.setIntHeader("Refresh", 300);
	System.out.println("ICON MENU PAGES");
%>
<title>Welcome </title>
	<style>
		a{
			text-decoration: none;
			color: black;
			font-size:16px;
		}
		.iconWrapper{
			margin-left:10px;
			padding:5px;
			float:left;
			width:200px;
			border:1px solid blue;
			height:200px;
			border-radius:10px;
		}
		.iconWrapper .logoImage{
			height:80px;
			border:0px solid green;
		}
		.iconWrapper .textHeading{
			height:50px;
			border:0px solid red;
		}
		.iconWrapper .textBody{
			height:150px;
			border:0px solid pink;
			text-align:justify;
			font-size:12px;
		}
		.iconWrapper .textLink{
			vertical-align:middle;
			height:70px;
			border:0px solid blue;
		}
	</style>
	<marquee behavior="alternate" scrollamount="3" onmouseover="this.stop();" onmouseout="this.start();"><h2 style="color:blue;">प्री-रजिस्ट्रेशन वेबसाइट में आपका स्वागत है!</h2></marquee>
	<h2>आवश्यक जानकारी</h2>
	<!--s:property value="आवश्यक जानकारी"-->
	<div style="margin: auto; width:1120px; border:0px solid red;">
		<div class="iconWrapper">
			<div class="logoImage"><img src="/IGRPortalWeb/images/stamp_icon.png" alt=""></div>
			<div class="textHeading"><a class="menuItem"	href="/IGRPortalWeb/PropertyDetailEnquiryAction?page_id=2" target="_blank">बाजार मूल्य की गणना</a></div>
			<!--div class="textBody">छत्तीसगढ़ के किसी भी स्थान के लिए एक विशेष भूमि और विशिष्ट क्षेत्र के लिए स्टांप शुल्क की गणना के लिए क्लिक करें</div-->
			<div class="textLink"><br /><a href="/IGRPortalWeb/PropertyDetailEnquiryAction?page_id=2" target="_blank" class="button top">Click Here</a></div>
		</div>
		
		<div class="iconWrapper">
			<div class="logoImage">
				<img src="/IGRPortalWeb/images/price-calcualtion-1.jpg" height="80" alt="">
			</div>
			<div class="textHeading"><a class="menuItem" href="/IGRPortalWeb/StampValueEnquiryAction" target="_blank">मुद्रांक एवं पंजीयन शुल्क की गणना करें</a></div>
			<!--div class="textBody"></div-->
			<div class="textLink"><br /><a href="/IGRPortalWeb/StampValueEnquiryAction" target="_blank" class="button top">Click Here</a></div>
		</div>
		
		<div class="iconWrapper">
			<div class="logoImage">
				<img src="/IGRPortalWeb/images/sample-document-1.jpg" height="80" alt="">
			</div>
			<div class="textHeading"><a class="menuItem" href="/IGRPortalWeb/commonJsp/deedSampleAction.action" target="_blank">दस्तावेजों का प्रारूप</a></div>
			<!--div class="textBody"></div-->
			<div class="textLink"><br /><a href="/IGRPortalWeb/commonJsp/deedSampleAction.action" target="_blank" class="button top">Click Here</a></div>
		</div>
		
		<div class="iconWrapper">
			<div class="logoImage">
				<img src="/IGRPortalWeb/images/template-1.jpg" height="80" alt="">
			</div>
			<div class="textHeading"><a class="menuItem" href="/IGRPortalWeb/commonJsp/documentSampleAction.action" target="_blank">दस्तावेज़ तैयार करें</a></div>
			<!--div class="textBody"></div-->
			<div class="textLink"><br /><a href="/IGRPortalWeb/commonJsp/documentSampleAction.action" target="_blank" class="button top">Click Here</a></div>
		</div>
		
		<div class="iconWrapper">
			<div class="logoImage">
				<img src="/IGRPortalWeb/images/Stamp-1.jpg" height="80" alt="">
			</div>
			<div class="textHeading"><a class="menuItem" href="/IGRPortalWeb/download/Chhattisgarh_ACC.pdf" target="_blank">स्टाम्प वेंडरो की सूची</a></div>
			<!--div class="textBody"></div-->
			<div class="textLink"><br /><a href="/IGRPortalWeb/download/Chhattisgarh_ACC.pdf" class="button top">Click Here</a></div>
		</div>
	</div>
	
	<div style="margin: auto; width:1120px; border:0px solid red; height:10px; clear:both; margin-top:10px; "><br /><hr /></div>
	
	<h2>अन्य सेवाएँ</h2>
	<div style="margin: auto; width:1120px; border:0px solid red;">
		<div class="iconWrapper">
			<div class="logoImage"><img src="/IGRPortalWeb/images/stamp_icon.png" height="80" alt=""></div>
			<div class="textHeading"><a class="menuItem"	href="/IGRPortalWeb/PropertyDetailEnquiryAction?page_id=2" target="_blank">ई-स्टांप खरीदें</a></div>
			<!--div class="textBody">छत्तीसगढ़ के किसी भी स्थान के लिए एक विशेष भूमि और विशिष्ट क्षेत्र के लिए स्टांप शुल्क की गणना के लिए क्लिक करें</div-->
			<div class="textLink"><br /><a href="https://www.shcilestamp.com/OnlineStamping/OlnEsi" target="_blank" class="button top">Click Here</a></div>
		</div>
		<div class="iconWrapper">
			<div class="logoImage"><img src="/IGRPortalWeb/images/stamp_icon.png" height="80" alt=""></div>
			<div class="textHeading"><a class="menuItem"	href="/IGRPortalWeb/PropertyDetailEnquiryAction?page_id=2" target="_blank">ऑनलाइन शुल्क भुगतान</a></div>
			<!--div class="textBody">छत्तीसगढ़ के किसी भी स्थान के लिए एक विशेष भूमि और विशिष्ट क्षेत्र के लिए स्टांप शुल्क की गणना के लिए क्लिक करें</div-->
			<div class="textLink"><br /><a href="https://cg.nic.in/eChallan/" target="_blank" class="button top">Click Here</a></div>
		</div>
		<div class="iconWrapper">
			<div class="logoImage"><img src="/IGRPortalWeb/images/Bhuiyan.png" height="80" alt=""></div>
			<div class="textHeading"><a class="menuItem"	href="/IGRPortalWeb/PropertyDetailEnquiryAction?page_id=2" target="_blank">राजस्व अभिलेख (भुइयां) से खोज<!--भुइयां से जमीन की हक सम्बन्धी जानकारी--></a></div>
			<!--div class="textBody">छत्तीसगढ़ के किसी भी स्थान के लिए एक विशेष भूमि और विशिष्ट क्षेत्र के लिए स्टांप शुल्क की गणना के लिए क्लिक करें</div-->
			<div class="textLink"><br /><a href="/IGRPortalWeb/titleOfLandAction" target="_blank" class="button top">Click Here</a></div>
		</div>
		<div class="iconWrapper">
			<div class="logoImage"><img src="/IGRPortalWeb/images/Land_Search.png" height="80" alt=""></div>
			<div class="textHeading"><a class="menuItem"	href="/IGRPortalWeb/PropertyDetailEnquiryAction?page_id=2" target="_blank">पूर्व पंजीकृत दस्तावेज का खोज<!--पंजीकरण खोज--></a></div>
			<!--div class="textBody">छत्तीसगढ़ के किसी भी स्थान के लिए एक विशेष भूमि और विशिष्ट क्षेत्र के लिए स्टांप शुल्क की गणना के लिए क्लिक करें</div-->
			<div class="textLink"><br /><a href="https://epanjeeyan.cg.gov.in/CGSearch/" target="_blank" class="button top">Click Here</a></div>
		</div>
	</div>
	<!--br />
	<table border=0 width="1100" cellspacing=10 cellpadding=10 bordercolor="blue">
		<tr height="50" valign="top">
			<th width="220">
				
			</th>
			<th width="220">
				<img src="/IGRPortalWeb/images/register_process_icon.png" alt="">
			</th>
			<th width="220">
				<img src="/IGRPortalWeb/images/register_process_icon.png" alt="">
			</th>
			<th width="220">
				<img src="/IGRPortalWeb/images/register_process_icon.png" alt="">
			</th>
			<th width="220">
				<img src="/IGRPortalWeb/images/register_process_icon.png" alt="">
			</th>
		</tr>
		<tr height="50" valign="top">
			<th width="220">
				
			</th>
			<th width="220">
				
			</th>
			<th width="220">
				
			</th>
			<th width="220">
				
			</th>
			<th width="220">
				
			</th>
		</tr>
		<tr height="150" valign="top">
			<th width="220">
				<p style="font-size:10px;">
					
				</p>
			</th>
			<th width="220">
				<p style="font-size:10px;">
					&nbsp;
				</p>
			</th>
			<th width="220">
				<p style="font-size:10px;">
					&nbsp;
				</p>
			</th>
			<th width="220">
				<p style="font-size:10px;">
					&nbsp;
				</p>
			</th>
			<th width="220">
				<p style="font-size:10px;">
					&nbsp;
				</p>
			</th>
		</tr>
		<tr height="50">
			<th width="220">
				
			</th>
			<th width="220">
				
			</th>
			<th width="220">
				
			</th>
			<th width="220">
				
			</th>
			<th width="220">
				
			</th>
		</tr>
		<!--tr>
			<th><a class="menuItem"	href="https://bhuiyan.cg.nic.in/" target="_blank">भूमि रिकॉर्ड सत्यापन</a></th>
			<th><a class="menuItem"	href="https://www.shcilestamp.com/" target="_blank">ई-स्टांप खरीदें</a></th>
		</tr>
		<tr>
			<th><a class="menuItem"	href="https://cg.nic.in/eChallan/" target="_blank">ऑनलाइन शुल्क भुगतान</a></th>
			<!--th><a class="menuItem" href="https://epanjeeyan.cg.gov.in/CGSearch/" target="_blank"></a></th--
		</tr->
	</table-->
</div>
<%@include file="footer.inc" %>
