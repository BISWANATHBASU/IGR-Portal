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
<%@include file="../commonJsp/include.jsp"%>

<script language="JavaScript1.2"
	src="<s:url value="/js/jquery.datepick.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/css/jquery.datepick.css"/>">
<link rel="stylesheet" type="text/css"
	href="<s:url value="/css/workProgress.css"/>">

<script>
	$(function() {

		var letters = /^[A-Z]+$/;
		var pattern = /^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/;

		$("body").delegate("#goBack", "click", function(event) {
			$("#popupBox1").hide();
			
		});

		$("#popupBox1").hide();
		$("#myDiv").hide();
		$("#anotherentry").hide();
		$("#view_div").hide();
		$("#dsr_div").hide();

		//$("#e_stamp_detail").hide();

		function validateStamp() {
			var rowStampNo = $("#rowStampNo").val();

			for (var i = 1; i <= rowStampNo; i++) {
				//alert("====>>"+i);

				//estampNo1/estampDate1/estampAmount1

				var estampNo = $("#estampNo" + i).val();
				var estampDate = $("#estampDate" + i).val();
				var estampAmount = $("#estampAmount" + i).val();

				var stamp_value = $("#stamp_value").val();
				//alert(stamp_value);

				if (stamp_value == "0") {
					return true;
				} else {
					if (estampNo == "" || estampNo.length != 20) {
						alert("20 अंको का  ई-स्टाम्प नंबर प्रविष्टी करें");
						return false;
					} else if (!estampNo.startsWith("IN-CG")) {
						alert("Please Enter Valid ई-स्टाम्प नंबर Start with IN-CG ");
						return false;
					} else if (isNaN(estampNo.substring(5, 19))) {
						alert("Please Enter Valid ई-स्टाम्प नंबर  Numeric Value");
						return false;
					} else if (!estampNo.substring(19, 20).match(letters)) {
						alert("Please Enter Valid ई-स्टाम्प नंबर One Alphabet ");
						return false;
					} else if (estampDate == "" || !estampDate.match(pattern)) {
						alert("Please Enter Valid ई-स्टाम्प दिनांक ");
						return false;
					} else if (estampAmount == "" || isNaN(estampAmount)) {
						alert("ई-स्टाम्प मूल्य प्रविष्टी करें");
						return false;
					}
				}
			}

			return true;
		}

		function validateStampValue() {
			var rowStampNo = $("#rowStampNo").val();
			var stamp_value = $("#stamp_value").val();
			var totalEStampAmount = 0;

			if (stamp_value == "0") {
				return true;
			} else {

				for (var i = 1; i <= rowStampNo; i++) {
					var estampAmount = $("#estampAmount" + i).val();

					totalEStampAmount = parseInt(totalEStampAmount)
							+ parseInt(estampAmount);
				}
				//alert("totalEStampAmount="+totalEStampAmount+"====stamp_value"+stamp_value);
				if (totalEStampAmount >= stamp_value) {
					return true;
				}
			}
			return false;
		}

		$("body")
				.delegate(
						"#popupBotton",
						"click",
						function(event) {
							try {
								//alert("");

								var valueData = "";

								var party_type = $("#party_type").val();
								var fullName = $("#fullName").val();
								var fatherName = $("#fatherName").val();
								var mobileNo = $("#mobileNo").val();
								var complateAddress = $("#complateAddress")
										.val();

								var district_id = $("#district_id").val();
								var dsr_location = $("#dsr_location").val();
								var locationName = "";

								var appointmentDate = $("#appointmentDate")
										.val();
								var appointmentTime = $("#appointmentTime")
										.val().split("-");
								var firstPartyMobileNo = $(
										"#firstPartyMobileNo").val();
								var secondPartyMobileNo = $(
										"#secondPartyMobileNo").val();

								var e_stamp_no = $("#e_stamp_no").val();
								var e_stamp_amount = $("#e_stamp_amount").val();

								var deed_type = $("#deed_type").val();
								var deed_category = $("#deed_category").val();
								var considered_amount = $("#considered_amount")
										.val();
								var considered_amount_req = $(
										"#considered_amount_req").val();

								var deedTypeData = $("#deedType").prop(
										'checked');//.val().split("~");

								if (party_type == "") {
									alert("पक्षकार का प्रकार चुनें");
								} else if (fullName == "") {
									alert("अपाईन्टमेंट लेने वाले का नाम प्रविष्टी करें");
								} else if (fatherName == "") {
									alert("पिता का नाम प्रविष्टी करें");
								} else if (mobileNo == "" || isNaN(mobileNo)
										|| mobileNo.length != 10) {
									alert("10 अंको का मोबाईल नंबर (अंग्रेजी में)")
								} else if (mobileNo == "0000000000"){
								  alert("मोबाईल नंबर अमान्य");
								}else if (mobileNo == "1111111111"){
								  alert("मोबाईल नंबर अमान्य");
								}else if (mobileNo == "2222222222"){
								  alert("मोबाईल नंबर अमान्य");
								}else if (mobileNo == "3333333333"){
								  alert("मोबाईल नंबर अमान्य");
								}else if (mobileNo == "4444444444"){
								  alert("मोबाईल नंबर अमान्य");
								}else if (mobileNo == "5555555555"){
								  alert("मोबाईल नंबर अमान्य");
								}else if (mobileNo == "6666666666"){
								  alert("मोबाईल नंबर अमान्य");
								}else if (mobileNo == "7777777777"){
								  alert("मोबाईल नंबर अमान्य");
								}else if (mobileNo == "8888888888"){
								  alert("मोबाईल नंबर अमान्य");
								}else if (mobileNo == "9999999999"){
								  alert("मोबाईल नंबर अमान्य");
								} else if (complateAddress == "") {
									alert("पूर्ण पता प्रविष्टी करें");
								} else if (district_id == "") {
									alert("पंजीयन जिले का चयन करें");
								} else if (dsr_location == "") {
									alert("पंजीयन कार्यालय का नाम चयन करें");
								} else if (appointmentDate == "") {
									alert("उपलब्ध अपाईन्टमेंट दिन का चयन करें");
								} else if (appointmentTime == "") {
									alert("उपलब्ध समय का चयन करें");
								} else if (deed_type == "") {
									alert("दस्तावेज का प्रकार का चयन करें");
								} else if (deed_category == "") {
									alert("दस्तावेज प्रकार (वर्गीकरण) का चयन करें");
								} else if (considered_amount_req == "true"
										&& considered_amount == ""
										|| considered_amount_req == "true"
										&& considered_amount == "0") {
									alert("विलेख में अंकित मूल्य  प्रविष्टी करें");
								}
								
								else if (validateStamp() == false) {
									//alert("");
								} else if (validateStampValue() == false) {
									alert("Please Enter Propert Stamp Value");
								}

								
								else {
									if (deedTypeData == false) {
										alert("यदि पंजीयन के समय ई-स्टाम्प सर्टिफिकेट नंबर सही नहीं पाया जाता है तो आपका अपॉइंटमेंट अमान्य होगा I तथा भिन्न ई-स्टाम्प वाले दस्तावेजो को पंजीयन हेतु स्वीकार नहीं किया जायेगा");
									}
									$("#popupBox1").show();

									var formInput = 'dsr_location='
											+ dsr_location;
									$
											.getJSON(
													'fetchLocationName.action',
													formInput,
													function(data) {
														locationName += data.dsrName;
														//alert("Location Name="+locationName);

														valueData = "<div style='text-align: center;'>-: अपाईन्टमेंट पुष्ठीकरण सम्बंधित :-</div><br />";//कन्फर्ममेसन

														valueData += "<div style='text-align: justify;'>आपके द्वारा चयन किया गया अपाईन्टमेंट दिनांक "
																+ appointmentDate
																+ " समय "
																+ appointmentTime[0]
																+ " बजे उपलब्ध है, निर्धारित अपाईन्टमेंट में नियमानुसार सम्यक रूप से स्टाम्पित मूल दस्तावेज सहित,";

														valueData += "निम्नलिखित व्यक्तियो  के साथ उप पंजीयक कार्यालय "
																+ locationName
																+ " में दस्तावेज़ पंजीयन हेतु उपस्थित होवें ,</div><br />";

														valueData += "1. "
																+ party_type
																+ " का नाम "
																+ fullName
																+ " <br />";

														var rowNo = $("#rowNo")
																.val();
														//alert("=="+rowNo);

														var slno = 1;
														var firstParty = 0;
														var secondParty = 0;
														var witnesParty = 0;

														var firstMobile = 0;
														var secondMobile = 0;

														if (party_type == "प्रथम पक्षकार") {
															firstParty++;
															if (mobileNo != null
																	|| mobileNo != "") {
																firstMobile++;

																if (firstPartyMobileNo == "0") {
																	$(
																			"#firstPartyMobileNo")
																			.val(
																					mobileNo);
																}
															}
															//alert("First Mobile No="+mobileNo+"<Count="+firstMobile+"-");
														}
														if (party_type == "द्वितीय पक्षकार") {
															secondParty++;
															if (mobileNo != null
																	|| mobileNo != "") {
																secondMobile++;

																if (secondPartyMobileNo == "0") {
																	$(
																			"#secondPartyMobileNo")
																			.val(
																					mobileNo);
																}
															}
															//alert("Second Mobile No="+mobileNo+"<Count="+secondMobile+"-");
														}

														for (var i = 1; i <= rowNo; i++) {
															slno++;
															var partyName = $(
																	"#partyName"
																			+ i)
																	.val();
															var partyFather = $(
																	"#partyFather"
																			+ i)
																	.val();
															var partyAddress = $(
																	"#partyAddress")
																	.val();
															var partyType = $(
																	"#partyType"
																			+ i)
																	.val();
															var partyMobileNo = $(
																	"#partyMobileNo"
																			+ i)
																	.val();

															if (partyType == "प्रथम पक्षकार") {
																firstParty++;

																if (partyMobileNo == ""
																		|| isNaN(partyMobileNo)
																		|| partyMobileNo.length != 10) {//partyMobileNo != null || partyMobileNo != ""

																} else {
																	firstMobile++;

																	var firstPartyMobileData = $(
																			"#firstPartyMobileNo")
																			.val();
																	//alert("1st Mobile No="+firstPartyMobileData);
																	if (firstPartyMobileData == "0") {
																		$(
																				"#firstPartyMobileNo")
																				.val(
																						partyMobileNo);
																	}
																}
																//alert("FirstpartyMobileNo="+partyMobileNo+",Count="+firstMobile+"=");
															}
															if (partyType == "द्वितीय पक्षकार") {
																secondParty++;

																if (partyMobileNo == ""
																		|| isNaN(partyMobileNo)
																		|| partyMobileNo.length != 10) {//partyMobileNo != null || partyMobileNo != ""

																} else {
																	secondMobile++;

																	var secontPartyMobileData = $(
																			"#secondPartyMobileNo")
																			.val();
																	//alert("2nd Mobile No="+secontPartyMobileData);
																	if (secontPartyMobileData == "0") {
																		$(
																				"#secondPartyMobileNo")
																				.val(
																						partyMobileNo);
																	}
																}
																//alert("SecondpartyMobileNo="+partyMobileNo+",Count="+secondMobile+"=");
															}
															if (partyType == "गवाह") {
																witnesParty++;
															}

															if (partyName == ""
																	|| partyFather == ""
																	|| partyAddress == "") {
																$("#viewData")
																		.html(
																				"");
																alert("सम्बंधित अन्य पक्षकारों में लाइन क्रमक  "
																		+ i
																		+ " की प्रविष्टी");
																$("#popupBox1")
																		.hide();
															}

															//alert(partyType+"Ka Name "+partyName);
															valueData += slno
																	+ ". "
																	+ partyType
																	+ " का नाम "
																	+ partyName
																	+ " <br />";
														}
								
														if (firstParty == 0
																|| secondParty == 0
																|| witnesParty == 0) {
															$("#viewData")
																	.html("");
															alert("कम से कम एक प्रथम पक्षकार, एक द्वितीय पक्षकार और एक गवाह का प्रविष्टी जरुरी है!");
															$("#popupBox1")
																	.hide();
														}
														if (firstMobile == 0
																|| secondMobile == 0) {
															$("#viewData")
																	.html("");
															alert("कम से कम एक प्रथम पक्षकार और एक द्वितीय पक्षकार का मोबाइल न प्रविष्टी जरुरी है!");
															$("#popupBox1")
																	.hide();
															if (firstMobile == secondMobile ){
																$("#viewData")
																.html("");
														      alert(" पक्षकार और द्वितीय पक्षकार का मोबाइल न समान नहीं होना चाहिए !");
														      $("#popupBox1")
																.hide();
															}
														} else {

								
															valueData += "<br /><input type='button' id='goBack' value='पीछे जाएँ' style='float:left;' />";
															valueData += " &nbsp; &nbsp; &nbsp; &nbsp; <input type='submit' value='अपाईन्टमेंट बुक करें' /> ";
								
															$("#viewData")
																	.html(
																			valueData);
														}
													});
								}
							} catch (Exception) {
								alert("Error" + Exception);
							}
						});

		
		
		/* $("body")
				.delegate(
						"#tahsilName",
						"change",
						function(event) {
							try {
								var district_id = $("#district_id").val();
								var appointmentDate = $("#appointmentDate")
										.val();
								var tahsilName = $("#tahsilName").val().split('~');
								var tahsilNameName = tahsilName[0];
								//alert(district_id);
								var formInput = 'district_id=' + district_id
										+ '&tahsilName=' + tahsilNameName
										+ '&appointmentDate=' + appointmentDate;
                                
								var options = '';
								$("#dsr_location").html(options);
								$
										.getJSON(
												'loadDSRLocationApp.action',formInput,function(data) {
													options = '<option selected value="">जिले के पंजीयन कार्यालय का नाम (चयन करें)</option>';
													$
															.each(
																	data.dsrLocationList,
																	function(i,
																			item) {
																		//alert("Data List");
																		options += '<option value="' + item.typeCode + '">'
																				+ item.typeDesc
																				+ '</option>';
																	});
													//alert(options);
													$("#dsr_location").html(
															options);
												});
							} catch (Exception) {
								alert("getDSRList Error===>" + Exception);
							}
						});
 */
		$("body")
				.delegate(
						"#district_id",
						"change",
						function(event) {
							try {
								var district_id = $("#district_id").val();
								//alert(district_id);
								var formInput = 'district_id=' + district_id
										+ "&language=2";
								var options = '';
								$("#tahsilName").html(options);
								$
										.getJSON(
												'loadTahsilApp.action',
												formInput,
												function(data) {
													options = '<option selected value="">जिले के तहसील का नाम (चयन करें)</option>';
													$
															.each(
																	data.tahsilList,
																	function(i,
																			item) {
																		//alert("Data List");
																		options += '<option value="' + item.typeCode + '">'
																				+ item.typeDesc
																				+ '</option>';
																	});
													//alert(options);
													$("#tahsilName").html(
															options);
												});
							} catch (Exception) {
								alert("getTahsilList Error===>" + Exception);
							}
						});

		
		
		
		
		
		
/* 
		$("body")
				.delegate(
						"#dsr_location",
						"change",
						function(event) {
							try {
								var dsr_location = $("#dsr_location").val();
								var appointmentDate = $("#appointmentDate")
										.val();
								//alert(dsr_location);
								var formInput = 'dsr_location=' + dsr_location
										+ "&appointmentDate=" + appointmentDate;
								var options = '';
								$("#appointmentTime").html(options);
								$("#appointmentTime1").html(options);
								$
										.getJSON(
												'fetchAppTimeList.action',
												formInput,
												function(data) {
													options = '<option selected value="">उपलब्ध समय का चयन करें</option>';//चुने हुएं दिन में उपलब्ध समय का स्लॉट
													$
															.each(
																	data.appointmentTimeList,
																	function(i,
																			item) {
																		//alert("Get Time");
																		options += '<option value="' + item.typeCode + '">'
																				+ item.typeDesc
																				+ '</option>';
																	});
													//alert(options);
													$("#appointmentTime").html(
															options);
													$("#appointmentTime1").html(
															options);
												});
							} catch (Exception) {
								alert("getTimeList Error===>" + Exception);
							}
						});
		 */
		
		
		

		$("body")
				.delegate(
						"#deed_type",
						"change",
						function(event) {
							try {
								var deed_type = $("#deed_type").val();
								//alert(district_id);
								var formInput = 'deed_type=' + deed_type;
								var options = '';
								$("#deed_category").html(options);
								$
										.getJSON(
												'loadDeedCategory.action',
												formInput,
												function(data) {
													options = '<option selected value="">दस्तावेज प्रकार (वर्गीकरण) चुनें</option>';
													$
															.each(
																	data.dsrLocationList,
																	function(i,
																			item) {
																		//alert("Data List");
																		options += '<option value="' + item.typeCode + '">'
																				+ item.typeDesc
																				+ '</option>';
																	});
													//alert(options);
													$("#deed_category").html(
															options);
												});
							} catch (Exception) {
								alert("getDSRList Error===>" + Exception);
							}
						});

		$("body").delegate(
				"#deed_category",
				"change",
				function(event) {
					try {
						var deed_type = $("#deed_type").val();
						var deed_category = $("#deed_category").val();
						//alert(district_id);
						var formInput = 'deed_type=' + deed_type
								+ '&deed_category=' + deed_category;
						var options = '';
						//$("#deed_category").html(options);
						$.getJSON('consideredAmountReq.action', formInput,
								function(data) {
									//alert("");
									//alert(""+data.considered_amount_req);
									$("#considered_amount_req").val(
											data.considered_amount_req);
								});
					} catch (Exception) {//considered_amount_req
						alert("deed_category Error===>" + Exception);
					}
				});
		
		
		$("body").delegate(
				"#deed_category1",
				"change",
				function(event) {
					try {
						var deed_type = $("#deed_type1").val();
						var deed_category = $("#deed_category1").val();
						//alert(district_id);
						var formInput = 'deed_type=' + deed_type
								+ '&deed_category=' + deed_category;
						var options = '';
						//$("#deed_category").html(options);
						$.getJSON('consideredAmountReq.action', formInput,
								function(data) {
									//alert("");
									//alert(""+data.considered_amount_req);
									$("#considered_amount_req1").val(
											data.considered_amount_req);
								});
					} catch (Exception) {//considered_amount_req
						alert("deed_category Error===>" + Exception);
					}
				});

		$("body").delegate(
				"#considered_amount",
				"blur",
				function(event) {
					try {
						var deed_type = $("#deed_type").val();
						var deed_category = $("#deed_category").val();
						var considered_amount = $("#considered_amount").val();
						//alert("considered_amount="+considered_amount+"deed_category="+deed_category+",deed_type="+deed_type);
						var formInput = 'deed_type=' + deed_type
								+ '&deed_category=' + deed_category
								+ '&considered_amount=' + considered_amount;
						var options = '';
						//$("#deed_category").html(options);
						$.getJSON('calculateStampAmount.action', formInput,
								function(data) {
									//alert("");
									//alert("==>"+data.calculate_stamp_value+"<==");// data.dsrName

									$("#stamp_value").val(
											data.calculate_stamp_value);
									$("#stamp_value_txt").html(
											data.calculate_stamp_value);

								});
					} catch (Exception) {
						alert("considered_amount Error===>" + Exception);
					}
				});
		
		
		$("body").delegate(
				"#considered_amount1",
				"blur",
				function(event) {
					try {
						var deed_type = $("#deed_type1").val();
						var deed_category = $("#deed_category1").val();
						var considered_amount = $("#considered_amount1").val();
						//alert("considered_amount="+considered_amount+"deed_category="+deed_category+",deed_type="+deed_type);
						var formInput = 'deed_type=' + deed_type
								+ '&deed_category=' + deed_category
								+ '&considered_amount=' + considered_amount;
						var options = '';
						//$("#deed_category").html(options);
						$.getJSON('calculateStampAmount.action', formInput,
								function(data) {
									//alert("");
									//alert("==>"+data.calculate_stamp_value+"<==");// data.dsrName

									$("#stamp_value1").val(
											data.calculate_stamp_value);
									$("#stamp_value_txt1").html(
											data.calculate_stamp_value);

								});
					} catch (Exception) {
						alert("considered_amount1 Error===>" + Exception);
					}
				});

		

	});

	function addRow() {
		var rowNo = $("#rowNo").val();
		rowNo++;
		var enterTable = document.getElementById("enterTable");
		var row = enterTable.insertRow(rowNo);

		var cell1 = row.insertCell(0);
		cell1.innerHTML = "<input type='text' name='abc' id='abc' required='true' value="+rowNo+" size='2' />";

		var cell2 = row.insertCell(1);
		cell2.innerHTML = "<input type='text' name='partyName' id='partyName"+rowNo+"' required='true' />";

		var cell3 = row.insertCell(2);
		cell3.innerHTML = "<input type='text' name='partyFather' id='partyFather"+rowNo+"' required='true' />";

		var cell4 = row.insertCell(3);
		cell4.innerHTML = "<input type='text' name='partyAddress' id='partyAddress"+rowNo+"' required='true' />";

		var cell5 = row.insertCell(4);
		cell5.innerHTML = "<input type='text' name='partyMobileNo' id='partyMobileNo"+rowNo+"' pattern='[0-9]{10}' maxlength='10'  />";

		var cell6 = row.insertCell(5);
		cell6.innerHTML = "<select name='partyType' id='partyType"+rowNo+"' required='true' style='height:33px;'><option value='प्रथम पक्षकार'>प्रथम पक्षकार</option><option value='द्वितीय पक्षकार'>द्वितीय पक्षकार</option><option value='गवाह'>गवाह</option><option value='वाहन चालक'>वाहन चालक</option></select>";

		$("#rowNo").val(rowNo);
	}

	function addRow1() {
		var rowNo = $("#rowNo1").val();
		rowNo++;
		var enterTable = document.getElementById("enterTable1");
		var row = enterTable.insertRow(rowNo);

		var cell1 = row.insertCell(0);
		cell1.innerHTML = "<input type='text' name='abc1' id='abc1'  value="+rowNo+" size='2' />";

		var cell2 = row.insertCell(1);
		cell2.innerHTML = "<input type='text' name='partyName1' id='partyName1"+rowNo+"' />";

		var cell3 = row.insertCell(2);
		cell3.innerHTML = "<input type='text' name='partyFather1' id='partyFather1"+rowNo+"'  />";

		var cell4 = row.insertCell(3);
		cell4.innerHTML = "<input type='text' name='partyAddress1' id='partyAddress1"+rowNo+"' />";

		var cell5 = row.insertCell(4);
		cell5.innerHTML = "<input type='text' name='partyMobileNo1' id='partyMobileNo1"+rowNo+"' pattern='[0-9]{10}' maxlength='10'  />";

		var cell6 = row.insertCell(5);
		cell6.innerHTML = "<select name='partyType1' id='partyType1"+rowNo+"' required='true' style='height:33px;'><option value='प्रथम पक्षकार'>प्रथम पक्षकार</option><option value='द्वितीय पक्षकार'>द्वितीय पक्षकार</option><option value='गवाह'>गवाह</option><option value='वाहन चालक'>वाहन चालक</option></select>";
        
		$("#rowNo1").val(rowNo);
	}

	function removeRow() {
		var rowNo = $("#rowNo").val();

		document.getElementById("enterTable").deleteRow(rowNo);

		rowNo--;
		$("#rowNo").val(rowNo);
	}
	function removeRow1() {
		var rowNo = $("#rowNo1").val();

		document.getElementById("enterTable1").deleteRow(rowNo);

		rowNo--;
		$("#rowNo1").val(rowNo);
	}

	function addStampRow() {
		var rowNo = $("#rowStampNo").val();
		rowNo++;
		var enterTable = document.getElementById("stampTable");
		var row = enterTable.insertRow(rowNo);

		var cell1 = row.insertCell(0);
		cell1.innerHTML = "<input type='text' name='estampNo' id='estampNo"+rowNo+"' maxlength='20' />";

		var cell2 = row.insertCell(1);
		cell2.innerHTML = "<input type='text' name='estampDate' id='estampDate"+rowNo+"' />";

		var cell3 = row.insertCell(2);
		cell3.innerHTML = "<input type='text' name='estampAmount' id='estampAmount"+rowNo+"' />";

		$("#rowStampNo").val(rowNo);
	}

	function addStampRow1() {

		var rowNo = $("#rowStampNo1").val();
		rowNo++;
		var enterTable = document.getElementById("stampTable1");
		var row = enterTable.insertRow(rowNo);

		var cell1 = row.insertCell(0);
		cell1.innerHTML = "<input type='text' name='estampNo1' id='estampNo1"+rowNo+"' maxlength='20' />";

		var cell2 = row.insertCell(1);
		cell2.innerHTML = "<input type='text' name='estampDate1' id='estampDate1"+rowNo+"' />";

		var cell3 = row.insertCell(2);
		cell3.innerHTML = "<input type='text' name='estampAmount1' id='estampAmount1"+rowNo+"' />";

		$("#rowStampNo1").val(rowNo);
	}

	function removeStampRow() {
		var rowNo = $("#rowStampNo").val();

		document.getElementById("stampTable").deleteRow(rowNo);

		rowNo--;
		$("#rowStampNo").val(rowNo);
	}

	function removeStampRow1() {
		var rowNo = $("#rowStampNo1").val();

		document.getElementById("stampTable1").deleteRow(rowNo);

		rowNo--;
		$("#rowStampNo1").val(rowNo);
	}

	function showAnotherEntry(Value) {

		if (Value == 'yes') {
			$("#myDiv").show();
			
		} else
			$("#myDiv").hide();
		    
	}

	function showPatta(Value) {

		{
			if ((Value == '165') || (Value == '181') || (Value == '113'))
				$("#anotherentry").show();
			else
				$("#anotherentry").hide();

		}
	}
	
	
	
	function getView(value){
		
		var tahsilName =value.split('~');
		var tahsilNameName = tahsilName[1];
		document.getElementById("tahsil_view_tag").value=tahsilNameName;
		
		if(tahsilNameName == 'Y')
		{
	    	$("#view_div").show();
		}
		else
		{
			$("#view_div").hide();
			document.getElementById("view_tag").value = "N";
			updateDsr();
		}
		  	
		
		
	}
	
	
	
	function updateDsr() {
		try{

			
			var district_id = $("#district_id").val();
			var appointmentDate = $("#appointmentDate")
					.val();
			var tahsilName = $("#tahsilName").val().split('~');
			var tahsilNameName = tahsilName[0];
			//alert(district_id);
			var formInput = 'district_id=' + district_id
					+ '&tahsilName=' + tahsilNameName
					+ '&appointmentDate=' + appointmentDate
					+ '&tahsil_view_tag='+document.getElementById("tahsil_view_tag").value 
					+ '&view_tag='+document.getElementById("view_tag").value;
			
			
            
			var options = '';
			$("#dsr_location").html(options);
			
			
			$.getJSON('loadDSRLocationApp.action', formInput, function(data) {
				document.getElementById("dsr_location").value=data.dsr_location;
				
				updateAppTime(data.dsr_location);
			});
			
			
			
			
		}
		catch(Exception)
		{
          alert(Exception);
			}

	}
	
	
	
	
	function updateAppTime(Value) {
		
		try{

			
			var dsr_location =Value;
			var appointmentDate = $("#appointmentDate")
					.val();
			//alert(dsr_location);
			var formInput = 'dsr_location=' + dsr_location
					+ "&appointmentDate=" + appointmentDate;
			var options = '';
			
			
			
			$("#appointmentTime").html(options);
			$("#appointmentTime1").html(options);
			
			
			$
			.getJSON(
					'fetchAppTimeList.action',
					formInput,
					function(data) {
						options = '<option selected value="">उपलब्ध समय का चयन करें</option>';//चुने हुएं दिन में उपलब्ध समय का स्लॉट
						$
								.each(
										data.appointmentTimeList,
										function(i,
												item) {
											//alert("Get Time");
											options += '<option value="' + item.typeCode + '">'
													+ item.typeDesc
													+ '</option>';
										});
						//alert(options);
						$("#appointmentTime").html(
								options);
						$("#appointmentTime1").html(
								options);
					});
                   
		}
		catch(Exception)
		{
          alert(Exception);
	  }

	}
	
	
	
</script>
<style>
#popupBox1 {
	z-index: 1;
	background-color: lightblue;
	position: fixed;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
}

#viewData {
	z-index: 2;
	background-color: white;
	color: black;
	position: relative;
	/*position: fixed;*/
	top: 0%;
	left: 25%;
	width: 40%;
	min-height: 40%;
	padding: 16px;
}
</style>
</head>
<body oncontextmenu="return false;">
	<div class="main">
		<div class="container_12">
			<%@include file="../commonJsp/header1.jsp"%>

			<form action="takeAppointment" validate="true" namespace="/"
				method="post" autocomplete="off">

				<s:token />
				<div
					style="margin-top: 0.5em; margin-left: 2%; width: 96%; border: 1px solid black;">
					<div align="center" style="margin-top: 20px;">

						<h2>Help Line No. 0771 491 2523/1800 233 2488</h2>
						<br />

						<s:actionerror theme="igr" cssClass="erroMsg"
							cssStyle="color:red;font-weight:bold;font-size:20px;" />
						<s:actionmessage theme="igr" cssClass="infoMsg"
							cssStyle="color:blue;font-weight:bold;font-size:20px;" />

						<h2 style="color: blue;">
							<u>पंजीयन हेतु अपॉइंटमेंट</u>
						</h2>
						<br />

						<table border="1">
							<tr>
								<th colspan="4"><font color="black">आवेदक का विवरण</font></th>
							</tr>

							<tr>
								<th>पक्षकार का प्रकार<font color="red">*</font> :-
								</th>
								<td><s:select name="party_type" id="party_type"
										list="partyTypeList" headerKey="" headerValue="चयन करें"
										listKey="typeCode" listValue="typeDesc" cssClass="combobox"
										theme="simple" required="required" /></td>

								<th>अपाईन्टमेंट लेने वाले का नाम <font color="red">*</font>
									:-
								</th>
								<td><s:textfield name="fullName" id="fullName"
										theme="simple" required="required"
										placeholder="अपाईन्टमेंट लेने वाले पक्षकार का नाम (हिंदी में)"
										maxlength="100" /></td>
							</tr>
							<tr>

								<th>पिता का नाम <font color="red">*</font> :-
								</th>
								<td><s:textfield name="fatherName" id="fatherName"
										theme="simple" required="required" placeholder="पिता का नाम"
										maxlength="100" /></td>

								<th>मोबाईल नंबर <font color="red">*</font> :-
								</th>
								<td><s:textfield name="mobileNo" id="mobileNo"
										theme="simple" required="required"
										placeholder="10 अंको का मोबाईल नंबर (अंग्रेजी में)"
										pattern="[0-9]{10}" maxlength="10" /></td>
							</tr>
							<tr>
								<th>पूर्ण पता <font color="red">*</font> :-
								</th>
								<td><s:textfield name="complateAddress"
										id="complateAddress" theme="simple" required="required"
										placeholder="मकान नंबर मोहल्ला, तहसील, जिला सहित (हिंदी में)"
										maxlength="200" /></td>


								<th>अपाईन्टमेंट का दिन <font color="red">*</font> :-
								</th>
								<td><s:select name="appointmentDate" id="appointmentDate"
										list="appointmentDateList" headerKey=""
										headerValue="उपलब्ध अपाईन्टमेंट दिन का चयन करें"
										listKey="typeCode" listValue="typeDesc" cssClass="combobox"
										theme="simple" required="required" /></td>




							</tr>
							
							
                             <tr id='dsr_div'>
                             <th>पूर्ण पता <font color="red">*</font> :-
								</th>
                             <td><s:textfield name="dsr_location" id="dsr_location"
										theme="simple" 
										
										maxlength="100" /></td>
                             </tr>

						


							<tr>


								<th>पंजीयन जिला <font color="red">*</font> :-
								</th>
								<td><s:select name="district_id" id="district_id"
										list="districtList" headerKey=""
										headerValue="पंजीयन जिले का चयन करें" listKey="typeCode"
										listValue="typeDesc" cssClass="combobox" theme="simple"
										required="required" /></td>


								<th>तहसील का नाम <font color="red">*</font> :-
								</th>
								<td><s:select name="tahsilName" id="tahsilName"
										list="tahsilList" headerKey=""
										headerValue="जिले के तहसील का नाम (चयन करें)"
										listKey="typeCode" listValue="typeDesc" cssClass="combobox"
										theme="simple" required="required"
										onchange="getView(this.value);" /></td>



							</tr>

							<tr id='view_div'>
								<th>क्या अपॉइंटमेंट जिला मुख्यालय SR में लेना है ?<font
									color="red">*</font> :-
								<td><select name="view_tag" id="view_tag"
									onChange="updateDsr();">
										<option value="">Select</option>
										<option value="Y">हां</option>
										<option value="N">नहीं</option>
								</select></td>
							</tr>

							<tr>

								<th>अपाईन्टमेंट दिन में उपलब्ध समय का स्लॉट <font
									color="red">*</font> :-
								</th>
								<td><s:select name="appointmentTime" id="appointmentTime"
										list="appointmentTimeList" headerKey=""
										headerValue="उपलब्ध समय का चयन करें" listKey="typeCode"
										listValue="typeDesc" cssClass="combobox" theme="simple"
										required="required" /></td>
								<th colspan="2">
									<%-- <s:checkbox name="deedType" id="deedType" theme="simple"/>अगर आप वसीयतनामा विलेख के लिए अपॉइंटमेंट ले रहे है तो यहाँ क्लीक करे। --%>
								</th>
							</tr>



							<tr id="deed_list">
								<th>दस्तावेज का प्रकार <font color="red">*</font> :-
								</th>
								<td><s:select name="deed_type" id="deed_type"
										list="deed_typeList" headerKey=""
										headerValue="दस्तावेज का प्रकार चुनें" listKey="typeCode"
										listValue="typeDesc" cssClass="combobox" theme="simple"
										required="required" /></td>
								<th>दस्तावेज प्रकार (वर्गीकरण) <font color="red">*</font>
									:-
								</th>
								<td><s:select name="deed_category" id="deed_category"
										list="deed_categoryList" headerKey=""
										headerValue="दस्तावेज प्रकार (वर्गीकरण) चुनें"
										listKey="typeCode" listValue="typeDesc" cssClass="combobox"
										theme="simple" required="required"
										onchange="showPatta(this.value);" /></td>
							</tr>

							<tr>
								<th colspan="4"><font style="color: red;">पंजीयन के
										दर्मिया किसी अन्य deed टाइप एवं केटेगरी मान्य नहीं होगा तथा
										अपॉइंटमेंट स्वतः कैंसल हो जायेगा </font> </br> <font style="color: blue;">नोट:
										प्रतिलेख और दूसरी प्रति के लिए अपॉइंटमेंट लेने की आवश्यकता
										नहीं है।</font> <s:hidden name="considered_amount_req"
										id="considered_amount_req" theme="simple" value="" /></th>
							</tr>

							<tr>
								<th>विलेख में अंकित मूल्य <font color="red">*</font> :- <br />
									<font style="color: red;">(टिप :- बाजार मूल्य अथवा
										लेन-देन का मूल्य में से जो अधिक है)</font>
								</th>
								<td><s:textfield name="considered_amount"
										id="considered_amount" theme="simple"
										placeholder="विलेख में अंकित मूल्य" value="0" /> <s:hidden
										name="stamp_value" id="stamp_value" theme="simple" value="0" />
								</td>
								<th>Required Stamp Amount for Appointment <font color="red">*</font>
									:-
								</th>
								<td><span style="color: black;" id="stamp_value_txt" /></td>
							</tr>


							<tr id="anotherentry">
								<th>लीज के साथ <font color="red">*</font> :-
								<td><select name="another_entry" id="another_entry"
									onchange="showAnotherEntry(this.value)">
										<option value="">Select</option>
										<option value="yes">हां</option>
										<option value="no">नहीं</option>
								</select></td>
							</tr>


						</table>

						<br /> <font style="color: black;">सम्बंधित ई-स्टाम्प का
							विवरण की प्रविष्टी</font> <br />
						<table id="stampTable" align="center">
							<tr>
								<th>ई-स्टाम्प नंबर<input type="hidden" id="rowStampNo"
									name="rowStampNo" value="1" /></th>
								<th>ई-स्टाम्प दिनांक<br />(DD/MM/YYYY)
								</th>
								<th>ई-स्टाम्प मूल्य</th>
							</tr>
							<tr>
								<td><input type="text" id="estampNo1" name="estampNo"
									maxlength="20" /></td>
								<td><input type="text" id="estampDate1" name="estampDate" /></td>
								<td><input type="text" id="estampAmount1"
									name="estampAmount" /></td>
								<td><input type="button" value="+" onclick="addStampRow()" />
									<input type="button" value="-" onclick="removeStampRow()" /></td>
							</tr>
						</table>

						<br /> <br /> <font style="color: black;">सम्बंधित अन्य
							पक्षकारों का विवरण की प्रविष्टी</font> <br /> <font
							style="color: black;">(एक एक करके प्रबिष्ट करें)</font> <br />

						<table id="enterTable">
							<tr>
								<th>सरल क्रमांक</th>
								<th>पक्षकारों और गवाहों<br /> का नाम
								</th>
								<th>पिता का नाम</th>
								<th>पूर्ण पता (मकान नंबर मोहल्ला,<br /> तहसील, जिला सहित)
								</th>
								<th>मोबाईल नंबर</th>
								<th>पक्षकार/गवाह का प्रकार</th>
							</tr>
							<tr>
								<td><input type="text" name="abc" id="abc" required="true"
									value="1" size="2" /></td>
								<td><input type="text" name="partyName" id="partyName1" /></td>
								<td><input type="text" name="partyFather" id="partyFather1" /></td>
								<td><input type="text" name="partyAddress"
									id="partyAddress1" /></td>
								<td><input type="text" name="partyMobileNo"
									id="partyMobileNo1" pattern="[0-9]{10}" maxlength="10" /></td>
								<td><select name="partyType" id="partyType1"
									style="height: 33px;">
										<!-- <option value="">Select Type</option> -->
										<option value="प्रथम पक्षकार">प्रथम पक्षकार</option>
										<option value="द्वितीय पक्षकार">द्वितीय पक्षकार</option>
										<option value="गवाह">गवाह</option>
										<option value="वाहन चालक">वाहन चालक</option>
								</select></td>
								<td><input type="button" value="+" onclick="addRow()" /> <input
									type="button" value="-" onclick="removeRow()" /> <s:hidden
										name="rowNo" id="rowNo" value="1" /> <s:hidden
										name="firstPartyMobileNo" id="firstPartyMobileNo" value="0" />
									<s:hidden name="secondPartyMobileNo" id="secondPartyMobileNo"
										value="0" /></td>
							</tr>
						</table>

						<br />







						<div id="myDiv"
							style="background-color: lightblue; border-color: coral;">


							<table border="1">
								<tr>
									<th colspan="4"><font color="black">आवेदक का विवरण</font></th>
								</tr>

								<tr>
									<th>पक्षकार का प्रकार<font color="red">*</font> :-
									</th>
									<td><s:select name="party_type1" id="party_type1"
											list="partyTypeList" headerKey="" headerValue="चयन करें"
											listKey="typeCode" listValue="typeDesc" cssClass="combobox"
											theme="simple" /></td>

									<th>अपाईन्टमेंट लेने वाले का नाम <font color="red">*</font>
										:-
									</th>
									<td><s:textfield name="fullName1" id="fullName1"
											theme="simple"
											placeholder="अपाईन्टमेंट लेने वाले पक्षकार का नाम (हिंदी में)"
											maxlength="100" /></td>
								</tr>
								<tr>

									<th>पिता का नाम <font color="red">*</font> :-
									</th>
									<td><s:textfield name="fatherName1" id="fatherName1"
											theme="simple" placeholder="पिता का नाम" maxlength="100" /></td>

									<th>मोबाईल नंबर <font color="red">*</font> :-
									</th>
									<td><s:textfield name="mobileNo1" id="mobileNo1"
											theme="simple"
											placeholder="10 अंको का मोबाईल नंबर (अंग्रेजी में)"
											pattern="[0-9]{10}" maxlength="10" /></td>
								</tr>
								<tr>
									<th>पूर्ण पता <font color="red">*</font> :-
									</th>
									<td><s:textfield name="complateAddress1"
											id="complateAddress1" theme="simple"
											placeholder="मकान नंबर मोहल्ला, तहसील, जिला सहित (हिंदी में)"
											maxlength="200" /></td>


									<th>अपाईन्टमेंट दिन में उपलब्ध समय का स्लॉट <font
										color="red">*</font> :-
									</th>
									<td><s:select name="appointmentTime1"
											id="appointmentTime1" list="appointmentTimeList" headerKey=""
											headerValue="उपलब्ध समय का चयन करें" listKey="typeCode"
											listValue="typeDesc" cssClass="combobox" theme="simple" /></td>




								</tr>



								<tr id="deed_list">
									<th>दस्तावेज का प्रकार <font color="red">*</font> :-
									</th>
									<td><s:select name="deed_type1" id="deed_type1"
											list="deed_typeList1" headerKey=""
											headerValue="दस्तावेज का प्रकार चुनें" listKey="typeCode"
											listValue="typeDesc" cssClass="combobox" theme="simple" /></td>
									<th>दस्तावेज प्रकार (वर्गीकरण) <font color="red">*</font>
										:-
									</th>
									<td><s:select name="deed_category1" id="deed_category1"
											list="deed_categoryList1" headerKey=""
											headerValue="दस्तावेज प्रकार (वर्गीकरण) चुनें"
											listKey="typeCode" listValue="typeDesc" cssClass="combobox"
											theme="simple" /></td>
								</tr>

								<tr>
									<th colspan="4"><font style="color: red;">पंजीयन के
											दर्मिया किसी अन्य deed टाइप एवं केटेगरी मान्य नहीं होगा तथा
											अपॉइंटमेंट स्वतः कैंसल हो जायेगा</font> <s:hidden
											name="considered_amount_req1" id="considered_amount_req1"
											theme="simple" value="" /></th>
								</tr>

								<tr>
									<th>विलेख में अंकित मूल्य <font color="red">*</font> :- <br />
										<font style="color: red;">(टिप :- बाजार मूल्य अथवा
											लेन-देन का मूल्य में से जो अधिक है)</font>
									</th>
									<td><s:textfield name="considered_amount1"
											id="considered_amount1" theme="simple"
											placeholder="विलेख में अंकित मूल्य" value="0" /> <s:hidden
											name="stamp_value1" id="stamp_value1" theme="simple"
											value="0" /></td>
									<th>Required Stamp Amount for Appointment <font
										color="red">*</font> :-
									</th>
									<td><span style="color: black;" id="stamp_value_txt1" />
									</td>
								</tr>


							</table>



							<br /> <font style="color: black;">सम्बंधित ई-स्टाम्प का
								विवरण की प्रविष्टी</font> <br />
							<table id="stampTable1">
								<tr>
									<th>ई-स्टाम्प नंबर<input type="hidden" id="rowStampNo1"
										name="rowStampNo1" value="1" /></th>
									<th>ई-स्टाम्प दिनांक<br />(DD/MM/YYYY)
									</th>
									<th>ई-स्टाम्प मूल्य</th>
								</tr>
								<tr>
									<td><input type="text" id="estampNo1" name="estampNo1"
										maxlength="20" /></td>
									<td><input type="text" id="estampDate1" name="estampDate1" /></td>
									<td><input type="text" id="estampAmount1"
										name="estampAmount1" /></td>
									<td><input type="button" value="+"
										onclick="addStampRow1()" /> <input type="button" value="-"
										onclick="removeStampRow1()" /></td>
								</tr>
							</table>

							<br /> <br /> <font style="color: black;">सम्बंधित अन्य
								पक्षकारों का विवरण की प्रविष्टी</font> <br /> <font
								style="color: black;">(एक एक करके प्रबिष्ट करें)</font> <br />

							<table id="enterTable1">
								<tr>
									<th>सरल क्रमांक</th>
									<th>पक्षकारों और गवाहों<br /> का नाम
									</th>
									<th>पिता का नाम</th>
									<th>पूर्ण पता (मकान नंबर मोहल्ला,<br /> तहसील, जिला सहित)
									</th>
									<th>मोबाईल नंबर</th>
									<th>पक्षकार/गवाह का प्रकार</th>
								</tr>
								<tr>
									<td><input type="text" name="abc1" id="abc"
										required="true" value="1" size="2" /></td>
									<td><input type="text" name="partyName1" id="partyName11" /></td>
									<td><input type="text" name="partyFather1"
										id="partyFather11" /></td>
									<td><input type="text" name="partyAddress1"
										id="partyAddress11" /></td>
									<td><input type="text" name="partyMobileNo1"
										id="partyMobileNo11" pattern="[0-9]{10}" maxlength="10" /></td>
									<td><select name="partyType1" id="partyType11"
										style="height: 33px;">
											<!-- <option value="">Select Type</option> -->
											<option value="प्रथम पक्षकार">प्रथम पक्षकार</option>
											<option value="द्वितीय पक्षकार">द्वितीय पक्षकार</option>
											<option value="गवाह">गवाह</option>
											<option value="वाहन चालक">वाहन चालक</option>
									</select></td>
									<td><input type="button" value="+" onclick="addRow1()" />
										<input type="button" value="-" onclick="removeRow1()" /> <s:hidden
											name="rowNo1" id="rowNo1" value="1" /> <s:hidden
											name="firstPartyMobileNo1" id="firstPartyMobileNo11" /> <s:hidden
											name="secondPartyMobileNo1" id="secondPartyMobileNo11" /></td>
								</tr>
							</table>

							<br />

							<s:hidden name="tahsil_view_tag" id="tahsil_view_tag" />
                            

						</DIV>

						<!-- <input type="submit" value="अपाईन्टमेंट बुक करें" /> -->



						<input type="button" id="popupBotton" value="अपाईन्टमेंट बुक करें" />
						<!--  onclick="viewBox()" -->


						<br /> <br /> <br />
						<h3 style="color: red; margin: 20px;">
							<!-- <b>नोट :-</b> अनावश्यक अपॉइंटमेंट बुक न करेI किसी बुक किया हुआ अपॉइंटमेंट को अगर अनावश्यक पाया जायेगा तथा समय पर नहीं आते हुए पाया जायेगा,
								 तब सबंधित मोबाइल नंबर से अगले सात दिन तक अपॉइंटमेंट बुकिंग सॉफ्टवेर के द्वारा स्वतः बंद कर दी जाएगीI</h3> -->

							<!-- <b>नोट:-</b>अनावश्यक अपॉइंटमेंट बुक न करे किसी बुक किया गया अपॉइंटमेंट को अगर अनावश्यक पाया जायेगा तथा समय पर नहींआते हुय पाया जायगा
								  तब सम्बन्धित मोबाइल नंबर से अगले सात दिनों तक अपॉइंटमेंट बुकिंग सॉफ्टवेर के द्वारा स्वत: बंद कर दिया जायगी | -->

							<b>नोट:-</b>अनावश्यक अपॉइंटमेंट बुक न करे, किसी बुक किया गया
							अपॉइंटमेंट को अगर अनावश्यक पाया जायेगा तथा समय पर नहीं आते हुये
							पाया जायेगा, तब सम्बन्धित मोबाइल नंबर से अगले सात दिनों तक
							अपॉइंटमेंट बुकिंग बंद कर दिया जायेगा | <br />
					</div>
				</div>

				<div id="popupBox1">
					<div id="viewData"></div>
				</div>

			</form>

		</div>
		<!--==============================footer=================================-->
		<%@include file="../commonJsp/footer.jsp"%>
	</div>

</body>


</html>