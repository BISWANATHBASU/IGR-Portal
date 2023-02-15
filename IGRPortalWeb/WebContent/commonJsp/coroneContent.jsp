
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Office Application Appointment</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" type="text/css" href="../css/breadcrumb.css">
	    <script src="../js/sha256.js"></script>
	    <%@include file="../commonJsp/include.jsp" %>
	    
	    <script>
		    function boxdisable(){
		    	//window.location = "officeAppoiment";
		    	$("#goNext").show();
		    }

		    $(function() {
		    	$("#goNext").hide();
		    	
	    		$("#firstList").show();
	    		$("#secondList").hide();
	    		$("#thirdList").hide();
	    		
	    		$("body").delegate("#showSecondList,#showSecondList1","click",function(event){
	    			//alert("123456789");
		    		$("#firstList").hide();
		    		$("#secondList").show();
		    		$("#thirdList").hide();
                });
	    		
	    		$("body").delegate("#showThirdList","click",function(event){
		    		$("#firstList").hide();
		    		$("#secondList").hide();
		    		$("#thirdList").show();
                });

	    		$("body").delegate("#showFirstList","click",function(event){
		    		$("#firstList").show();
		    		$("#secondList").hide();
		    		$("#thirdList").hide();
                });
		    });
    		
	    </script>
	    
	</head>
	<body oncontextmenu="return false;">
		<div class="main">
			<div class="container_12">
				<%@include file="../commonJsp/header1.jsp" %>
				
				<div style="margin:auto;width:90%;">
				<h2 style="text-align: center;">Help Line No. 0771 491 2523/1800 233 2488</h2>
				<br />
				<!-- <h2 style="text-align:center;">छत्तीसगढ़ सरकार द्वारा कोरोना संक्रमण के दरमियाँ ई पंजीयन प्रक्रिया की  सुरक्षित एवं निर्बाध सेवा बनाये रखने हेतु दी गयी दिशानिर्देश</h2> -->
				<!-- <h2 style="text-align:center;">छत्तीसगढ़ सरकार द्वारा कोरोना संक्रमण से बचाव को ध्यान में रखते हुये, सुरक्षित एवं निर्बाध ई-पंजीयन सेवा प्रदान करने के सम्बन्ध में दिशा-निर्देश</h2> -->
				<h2 style="text-align:center;">निर्बाध ई पंजीयन सेवा प्रदान के सम्बंध में दिशा-निदेश</h2>
				
				<br />
				
				<img src="images/arogya_app.jpg" height="200" />
				<img src="images/HAND_SANITIZER.png" height="200" />
				<img src="images/MASK.jpg" height="200" />

				<br />
				<br />
				
				<!-- <table style="font-size:15px;color:black;" id="firstList">
					<tr><th colspan="2" style="font-size:15px">(क) आनलाईन अपाईन्टमेंट बुक कराना सम्बन्धी</th></tr>
					<tr><th colspan="2">&nbsp;</th></tr>
					<tr><td width="25">1.</td><td style="text-align:justify;">पंजीयन कार्यालयों में उपस्थित होने वाले लोगों की संख्या को नियंत्रित करने के लिये केवल उन्ही लोगों को प्रवेश की अनुमति होगी जिन्होने पंजीयन हेतु आनलाईन अपाईन्टमेंट लिया हो हो। इस हेतु विभाग द्वारा तैयार पोर्टल/मोबाइल एप (https://epanjeeyan.cg.gov.in/) पर जाकर इच्छुक पक्षकार को अपना आनलाईन अपाईन्टमेंट बुक कराना होगा। पंजीयन के दौरान अधिकृत पक्षकार एवं गवाह के अलावा अन्य लोगों को प्रवेश की अनुमति नहीं होगी।<br />&nbsp;<br /></td></tr>
					<tr><td>2.</td><td style="text-align:justify;">सोशल डिस्टेंसिग का पालन करने हेतु केवल उन्ही लोगों को कार्यालय में प्रवेश दिया जायेगा जिनके पास पंजीयन कार्यालय में उपस्थित होने के लिये अपाईंटमेंट लिया हुआ हैं ।<br />&nbsp;<br /></td></tr>
					<tr><td>3.</td><td style="text-align:justify;">अपॉइंटमेंट बुकिंग केवल प्रस्तुत होनेवाले दस्ताबेज के पक्षकारो एवं उनके मोबाइल न. के एंट्री से ही होगा, किसी अन्य वेक्ति की नाम या मोबाइल न. से नहीं होगा एवं ई पंजीयन के दरमियाँ इसी नाम एवं मोबाइल न. से मिलान सॉफ्टवेर द्वारा स्वतः की जाएगी I<br />&nbsp;<br /></td></tr>
					<tr><td>4.</td><td style="text-align:justify;">इस वैश्विक महामारी के घढ़ी में सरकार की आग्रह हैं की केवल पूर्ण रूप से प्रस्तुत दस्ताबेज (जिसमे उचित स्टाम्प लगा हो, सबंधित कागजात पूरी हो) एवं पक्षकारो की सॉफ्टवेर द्वारा निर्गत किया गया अपॉइंटमेंट समय पर उपलब्धता सुनिश्चित होने पर ही अपॉइंटमेंट बुक करेI अनावश्यक अपॉइंटमेंट बुक न करे I किसी बुक किया हुआ अपॉइंटमेंट को अगर अनावश्यक पाया जायेगा तथा समय पर नहीं आते हुएं पाया जायेगा तब सबंधित मोबाइल न. से अगले सात दिन तक अपॉइंटमेंट बुकिंग सॉफ्टवेर के द्वारा स्वतः बंद कर दी जाएगी I<br />&nbsp;<br /></td></tr>
					<tr><td>5.</td><td style="text-align:justify;">सोशल डिस्टेंसिग को प्रोत्साहित करने हेतु एवं कार्यालय में सल्प समय व्येतित करने हेतु सरकार की आग्रह हैं की पक्षकार “प्री रजिस्ट्रेशन एवं ई पेमेंट” की सुबिधा का ज्यादा से ज्यादा उपयोग करे I<br />&nbsp;<br /></td></tr>
					<tr><th colspan="2"><input type="button" id="showSecondList" value="आगे जाएँ" /></th></tr>
				</table> -->
				
				<table style="font-size:15px;color:black;" id="firstList">
					<tr><th colspan="2" style="font-size:15px">(क) आनलाईन अपाईन्टमेंट बुक करने सम्बन्धी</th></tr>
					<tr><th colspan="2">&nbsp;</th></tr>
					<tr><td width="25">1.</td><td style="text-align:justify;">पंजीयन कार्यालयों में उपस्थित होने वाले लोगों की संख्या को नियंत्रित करने के लिये केवल उन्ही को प्रवेश की अनुमति होगी, जिन्होने पंजीयन हेतु आनलाईन अपाईन्टमेंट लिया हो। इस हेतु इच्छुक पक्षकार को विभाग द्वारा तैयार ऑनलाइन पोर्टल/मोबाइल-एप (<a href="https://epanjeeyan.cg.gov.in" target="_blank">https://epanjeeyan.cg.gov.in</a>) पर जाकर अपना आनलाईन अपाईन्टमेंट बुक करने करें. कृपया यहाँ सभी पक्षकारों और गवाहों की जानकारी दर्ज कर उपलब्ध अपाईन्टमेंट स्लॉट <b>(दिनांक एवं समय)</b> का चयन करें. इस प्रक्रिया से जनित अपाईन्टमेंट स्लिप के साथ निर्धारित समय पर पंजीयन कार्यालय में उपस्थित होवें। पंजीयन के दौरान पक्षकार एवं गवाह के अलावा अन्य लोगों को प्रवेश की अनुमति नहीं होगी।<br />&nbsp;<br /></td></tr>
					<tr><td>2.</td><td style="text-align:justify;">अपॉइंटमेंट बुकिंग केवल, प्रस्तुत होने वाले दस्ताबेज के पक्षकारो एवं उनके मोबाइल नंबर के एंट्री से ही होगा, किसी अन्य व्यक्ति के नाम या मोबाइल नंबर से नहीं होगाI ई पंजीयन के दौरान इसी नाम एवं मोबाइल नंबर से मिलान सॉफ्टवेर द्वारा स्वतः की जाएगी I<br />&nbsp;<br /></td></tr>
					<tr><td>3.</td><td style="text-align:justify;">केवल पूर्ण रूप से तैयार दस्ताबेज  (जिसमे उचित स्टाम्प लगा हो, सबंधित कागजात पूरी हो) होने पर ही पक्षकार, पंजीयन हेतु अपॉइंटमेंट बुक करेI अनावश्यक अपॉइंटमेंट बुक न करेI किसी बुक किया हुआ अपॉइंटमेंट को अगर अनावश्यक पाया जायेगा तथा समय पर नहीं आते हुए पाया जायेगा, तब सबंधित मोबाइल नंबर से अगले सात दिन तक अपॉइंटमेंट बुकिंग सॉफ्टवेर के द्वारा ब्लाक कर दिया जायेगा |<br />&nbsp;<br /></td></tr>
					
					<tr><td colspan="2"><input type="button" id="showSecondList" value="आगे जाएँ" style="float:right;" /></td></tr>
				</table>
				
				<!-- <table style="font-size:15px;color:black;" id="secondList">
					<tr><th colspan="2" style="font-size:15px">(ख) सोशल डिसटेंसिंग एवं स्वस्थ सुरक्षा सम्बन्धी</th></tr>
					<tr><th colspan="2">&nbsp;</th></tr>
					<tr><td>6.</td><td style="text-align:justify;">पंजीयन कार्यालय में उपस्थित होने वाले प्रत्येक पक्षकार/गवाह/अधिकारी/कर्मचारी को अपने मोबाईल में आरोग्य सेतु मोबाईल एप इन्सटाल करना होगा ताकि पंजीयन के दौरान किसी प्रकार के संभावित कोरोना वासरस के संक्रमण के स्रोत को ट्रेक किया जा सके। कार्यालय प्रवेश के दरमियाँ इसकी जाँच होगी I<br />&nbsp;<br /></td></tr>
					<tr><td>7.</td><td style="text-align:justify;">सभी अधिकारी/कर्मचारियों हैंड ग्लव्स तथा मास्क लगाकर ही कार्यालय में कार्य संपादित करेंगे । नगर निगम के माध्यम से प्रतिदिन पंजीयन कार्यालय को प्रारंभ करने के पूर्व तथा बंद करने के पश्चात सेनेटाइज कराये जाने एवं साफ-सफाई की आवश्यक व्यवस्था किया जा रहा हैं। पंजीयन कार्यालय में सोशल डिस्टेंसिंग बनाये रखने के लिये आवश्यक मार्किंग किया गया हैं।<br />&nbsp;<br /></td></tr>
					<tr><td>8.</td><td style="text-align:justify;">बिना मास्क के किसी भी पक्षकार अथवा गवाहों को पंजीयन कार्यालय में प्रवेश करने नहीं  दिया जायेगा, मास्क न होने पर रुमाल/साफ़ कपढ़े से मुह को ढकना होगा I पंजीयन प्रक्रिया के दौरान पक्षकारों को सोशल डिस्टेंसिग का पालन किया जाना अनिवार्य है। इस हेतु पंजीयन कक्ष में एक बार में केवल एक दस्तावेज से संबंधित पक्षकारों/गवाहों को प्रवेश दिया जायेगा  बाद के क्रम से संबंधित पक्षकारों को प्रतीक्षा हाल में बैठना होगा। अगले क्रम के पक्षकारों को पंजीयन कक्ष में तभी प्रवेश दिया जायेगा जब पहले क्रम के पक्षकार पंजीयन कक्ष से बाहर चले जायेंगे। जिन पक्षकारों का पंजीयन हो चुका है उन्हे और पंजीयन कार्यालय में रूकने की अनुमति न दि जाएगी ।<br />&nbsp;<br /></td></tr>
					<tr><td>9.</td><td style="text-align:justify;">पंजीयन प्रक्रिया के दौरान बायोमेट्रिक अथवा सिग्नेचर पेड के इस्तेमाल के पूर्व उपलब्ध सेनेटाईजर के द्वारा पक्षकारों/गवाहो को  हाथों को भलीभांति सेनेटाईज करना होगा <br />&nbsp;<br /></td></tr>
					<tr><th colspan="2"><input type="button" id="showThirdList" value="आगे जाएँ" /></th></tr>
				</table> -->
				
				<table style="font-size:15px;color:black;" id="secondList">
					<tr><th colspan="2" style="font-size:15px">(ख) सोशल डिसटेंसिंग एवं स्वास्थ सुरक्षा सम्बन्धी</th></tr>
					<tr><th colspan="2">&nbsp;</th></tr>
					<tr><td>4.</td><td style="text-align:justify;">पंजीयन कार्यालय में उपस्थित होने वाले प्रत्येक पक्षकार/गवाह/अधिकारी/कर्मचारी को अपने मोबाईल में आरोग्य सेतु मोबाईल एप इन्सटाल करना होगा ताकि पंजीयन के दौरान किसी प्रकार के संभावित कोरोना वासरस के संक्रमण के स्रोत को ट्रेस किया जा सके, कार्यालय प्रवेश के दौरान इसकी जाँच होगीI<br />&nbsp;<br /></td></tr>
					<tr><td>5.</td><td style="text-align:justify;">पंजीयन कार्यालय में उपस्थित होने वाले प्रत्येक पक्षकार/गवाह को बिना मास्क के प्रवेश करने अनुमति नहीं दी जाएगी . मास्क न होने पर रुमाल/साफ़ कपढ़े से मुह को ढकना होगा I पंजीयन प्रक्रिया के दौरान पक्षकारों को सोशल डिस्टेंसिग का पालन किया जाना अनिवार्य है। इस हेतु पंजीयन कक्ष में एक बार में केवल एक दस्तावेज से संबंधित पक्षकारों/गवाहों को प्रवेश दिया जायेगा  बाद के क्रम से संबंधित पक्षकारों को प्रतीक्षा हाल में बैठना होगा। अगले क्रम के पक्षकारों को पंजीयन कक्ष में तभी प्रवेश दिया जायेगा जब पहले क्रम के पक्षकार पंजीयन कक्ष से बाहर चले जायेंगे। जिन पक्षकारों का पंजीयन हो चुका है उन्हे और पंजीयन कार्यालय में रूकने की अनुमति नहीं होगी ।<br />&nbsp;<br /></td></tr>
					<tr><td>6.</td><td style="text-align:justify;">पंजीयन प्रक्रिया के दौरान बायोमेट्रिक अथवा सिग्नेचर पेड के इस्तेमाल के दौरान  सेनेटाईजर के द्वारा पक्षकारों/गवाहो के हाथों को भलीभांति सेनेटाईज करना होगाI<br />&nbsp;<br /></td></tr>
					
					<tr><td colspan="2"><input type="button" id="showFirstList" value="पीछे जाएँ" style="float:left;" /> &nbsp; <input type="button" id="showThirdList" value="आगे जाएँ" style="float:right;" /></td></tr>
				</table>
				
				<!-- <table style="font-size:15px;color:black;" id="thirdList">
					<tr><th colspan="2" style="font-size:15px">(ग) सरकारी पालिसी सम्बन्धी</th></tr>
					<tr><th colspan="2">&nbsp;</th></tr>
					<tr><td>10.</td><td style="text-align:justify;">वर्ष 2019-20 की गाईड लाईन दरों को मई-2020 तक यथावत रखा गया है, जिससे कि पंजीयन कार्यालयों में अनावश्यक भीड़ की स्थिति निर्मित न हो।<br />&nbsp;<br /></td></tr>
					<tr><td>11.</td><td style="text-align:justify;">मुख्यालय में दीगर तहसील की रजिस्ट्री पर प्रतिबंध होगा, संबंधित पंजीयन कार्यालय में ही पंजीयन कराया जा सकेगा।<br />&nbsp;<br /></td></tr>
					<tr><td>12.</td><td style="text-align:justify;">ई-स्टाम्प की व्यवस्था के लिए सभी जिलो में स्टाॅक होल्डिग कार्पोरेशन के ई-स्टाम्प सेंटर एवं ए0सी0सी0 (अधिकृत संग्रहण केन्द्र) खुले रहेगे।<br />&nbsp;<br /></td></tr>
					<tr><td>13.</td><td style="text-align:justify;">पंजीयन कार्य से संबंधित अनुज्ञप्तिधारी दस्तावेज लेखक/स्टाम्प वेण्डर को उनके स्वंय के कार्यस्थल में आने-जाने के लिए पास की व्यवस्था किया जायेगा ।<br />&nbsp;<br /></td></tr>
					<tr><td>14.</td><td style="text-align:justify;">रायपुर/बिलासपुर/दुर्ग में टोकन नम्बर के क्रमानुसार प्रतिदिन प्रत्येक उप पंजीयक मात्र ३०  दस्तावेजों का पंजीयन करेगें।<br />&nbsp;<br /></td></tr>
					<tr><td>15.</td><td style="text-align:justify;">रायपुर/दुर्ग/बिलासपुर पंजीयन कार्यालयों में प्रतिदिन पंजीयन कार्य संपादित किया जाएगा। शेष पंजीयन कार्यालयों में अल्टरनेट एक दिन उपरान्त या आवश्यकतानुसार पंजीयन कार्य किये जा सकेंगे।<br />&nbsp;<br /></td></tr>
					
					<tr>
						<th colspan="2">
							<br />
							<input style="width: 18px; height: 18px; " type="checkbox" onClick="boxdisable();" name="checkbox" id="checkbox" />
							<b style="color:black;font-size:18px;">उपरोक्त को पढ़कर समझकर पंजीयन हेतु अपॉइंटमेंट बुक कर रहा हूँ|</b> 
							
							<a href="officeAppoiment" style="color:blue;" id="goNext">आगे जाएँ!</a>
							<input type="button" id="goNext" value="आगे जाएँ" onClick="window.location.href='officeAppoiment.action';" />
						</th>
					</tr>
				</table> -->
				
				<table style="font-size:15px;color:black;" id="thirdList">
					<tr><th colspan="2" style="font-size:15px">(ग) शासकीय निति सम्बन्धी<!-- सरकारी पालिसी सम्बन्धी --></th></tr>
					<tr><th colspan="2">&nbsp;</th></tr>
					<tr><td>7.</td><td style="text-align:justify;">मुख्यालय में दीगर तहसील की रजिस्ट्री कराये जाने पर पुर्णतः प्रतिबंध होगा, संबंधित पंजीयन कार्यालय में ही पंजीयन कराया जा सकेगा।<br />&nbsp;<br /></td></tr>
					<tr><td>8.</td><td style="text-align:justify;">ई-स्टाम्प की व्यवस्था के लिए सभी जिलो में स्टाक होल्डिग कार्पोरेशन के ई-स्टाम्प सेंटर एवं ए0सी0सी0 (अधिकृत संग्रहण केन्द्र) खुले रहेगे।<!--  ऑनलाइन e-stamp लेने के लिये  <a href="https://www.shcilestamp.com/OnlineStamping/OlnEsi" style="color:blue;" target="_blank">https://www.shcilestamp.com/OnlineStamping/OlnEsi</a> को देखें | --> <a href="download/ListOfACCToBeAllowed.pdf" target="_blank" style="color:blue;">तालिका देखे<!-- इस अवधि में कार्यालय की सूची --></a><br />&nbsp;<br /></td></tr>
					<tr><td>9.</td><td style="text-align:justify;">पंजीयन कार्य से संबंधित अनुज्ञप्तिधारी दस्तावेज लेखक/स्टाम्प वेण्डर को उनके स्वंय के कार्यस्थल में आने-जाने के लिए पास की व्यवस्था किया जायेगा।<br />&nbsp;<br /></td></tr>
					<!-- <tr><td>10.</td><td style="text-align:justify;">पंजीयन कार्यालय में अनावश्यक भीड़ को नियंत्रित करने के लिए राज्य के सभी पंजीयक कार्यालयों को तीन वर्गों में विभाजित किया गया है. वर्ग 'अ' से सम्बंधित पंजीयन कार्यालय सप्ताह के सभी कार्यदिवस में खुले रहेंगे. वर्ग 'ब' से सम्बंधित पंजीयन कार्यालय सप्ताह में केवल दो दिन अर्थात बुधवार एवं शुक्रवार को खुले रहेंगे. वर्ग 'स' से सम्बंधित पंजीयन कार्यालय सप्ताह में केवल एक दिन अर्थात बुधवार को ही खुले रहेंगे. पंजीयन कार्यालय वर्गीकरण की सूची वेबसाइट में देखा जा सकता है| <a href="download/Office_list_with_red_zone_circular.pdf" target="_blank" style="color:blue;">पंजीयन कार्यालय वर्गीकरण की सूची देखे  पंजीयन कार्यालय का सूची देखें </a><br />&nbsp;<br /></td></tr> -->
					
					<tr><td colspan="2"><input type="button" id="showSecondList1" value="पीछे जाएँ" style="float:left;" /></td></tr>
					
					<tr>
						<th colspan="2">
							<br />
							<input style="width: 18px; height: 18px; " type="checkbox" onClick="boxdisable();" name="checkbox" id="checkbox" />
							<!-- <b style="color:black;font-size:18px;">उपरोक्त को पढ़कर समझकर पंजीयन हेतु अपॉइंटमेंट बुक कर रहा हूँ|</b>  -->
							
							<!-- <b style="color:black;font-size:18px;">उपरोक्त को पढ़कर समझकर पंजीयन हेतु अपॉइंटमेंट बुक करें</b> -->
							<b style="color:black;font-size:18px;">उपरोक्त (क,ख एवं ग) को पढकर समझकर पंजीयन हेतु अपॉइंटमेंट बुक करे |</b>
							
							<!-- <a href="officeAppoiment" style="color:blue;" id="goNext">आगे जाएँ!</a> -->
							<input type="button" id="goNext" value="आगे जाएँ" onClick="window.location.href='officeAppoiment.action';" />
						</th>
					</tr>
				</table>
				
				
				</div>
			</div>
			<!--==============================footer=================================-->
			<%@include file="../commonJsp/footer.jsp" %>
		</div>
	</body>
	
	<script type="text/javascript">window.history.forward(0);</script>
</html>