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

getRegistryReport();
function getRegistryReport(){
	//alert("====");
	try{
		//alert("Trying getRegistryReport");
		var formInput= 'language=2';
	    $.getJSON('getRegistryReport.action', formInput,function(data) {
	    	//alert("Getting Data From getRegistryReport");
	    	//alert("Muzzakkir="+data.getData);
	    	var arrayData = data.getData.split("#");
	    	//alert(arrayData[1]);
	    	$("#todayRegistryData").text(arrayData[1]);
	    	$("#monthRegistryData").text(arrayData[2]);
	    	$("#yearRegistryData").text(arrayData[3]);
	    	$("#totalRegistryData").text(arrayData[4]);
		});
	}catch(Exception){
		alert("Error" + Exception);
	}
}
</script>
<style>
	.reportContenner{
		border:3px double blue;
		width:220px;
		height:170px;
		float:left;
		margin:10px;
		border-radius:10px;
	}
	.reportContennerHeading{
		text-align:center;
		font-weight:bold;
	}
	.reportContennerData{
		text-align:center;
		margin-top:60px;
		font-size:30px;
	}
	.backGroungBlue{
		background-image: linear-gradient(white, lightblue);
	}
	.backGroungGreen{
		background-image: linear-gradient(white, lightgreen);
	}
</style>

<div style="height:200px;">
	<div class="reportContenner backGroungBlue">
		<div class="reportContennerHeading">Total Documents e-Registered Today</div>
		<hr />
		<div class="reportContennerData" id="todayRegistryData">0</div>
	</div>
	
	<div class="reportContenner backGroungGreen">
		<div class="reportContennerHeading">Total Documents e-Registered<br /> This Month</div>
		<hr />
		<div class="reportContennerData" id="monthRegistryData">0</div>
	</div>
	
	<div class="reportContenner backGroungBlue">
		<div class="reportContennerHeading">Total Documents e-Registered<br /> This Financial Year</div>
		<hr />
		<div class="reportContennerData" id="yearRegistryData">0</div>
	</div>
	
	<div class="reportContenner backGroungGreen">
		<div class="reportContennerHeading">Total Documents e-Registered<br /> &nbsp;</div>
		<hr />
		<div class="reportContennerData" id="totalRegistryData">0</div>
	</div>
	
</div>