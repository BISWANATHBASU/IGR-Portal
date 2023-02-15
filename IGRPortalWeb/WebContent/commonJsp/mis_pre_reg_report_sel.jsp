<!DOCTYPE html>
<html lang="en">
<head>
    <title>Pre-registration Report</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/breadcrumb.css">
    <!-- <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/mycss.css"> -->
    <%@include file="../commonJsp/include.jsp" %>
</head>
<body id="page1">
<div class="main">
	<div class="container_12">
	<!--==============================header=================================-->
	   	<%@include file="../commonJsp/header1.jsp" %>
	<!--==============================content================================-->
	
	<section id="content">        	
	        	<div class="wrapper">
            	<article class="grid_12">
                   <div class="indent">                
					<ol class="breadcrumb breadcrumb-arrow">
						<li><s:url value="indexAction.action" var="indexAction"></s:url>
						<a href="<s:property value='#indexAction'/>">घर</a></li>
						<li><a href="#">एमआईएस</a></li>
						
						<li class="active"><span>प्री रेजिस्ट्रेसन रिपोर्ट</span></li>
					</ol>				
               </div>
               </article>
	            <!-- <article class="grid_4" style="margin-top: 20px;">	    -->
	            <article class="grid_9">
                   <div class="indent">
                   <h2 class="ind2">वर्ष का चयन करें</h2>
                   </div> <!-- indent div -->
                   </article>
	            <div align="center" style="text-align: center;"> 
						  <form action="/IGRPortalWeb/commonJsp/mis_pre_reg_report_final.jsp" method="get" onsubmit="return check();">
						  <div style="width: 50%;padding: 40px" align="center">
                       		<table width="100%" align="center">
                       			<tr>	
                       				<td>वर्ष :</td>
                       				<td>
                       					<select name="year" required="required" id="year">
                       						<option>Select Year</option>
                       						<option value="2017">2017</option>
                       						<option value="2018">2018</option>
                       						<option value="2019">2019</option>
                       					</select>                       					
                       				</td>
                       			</tr>             			
                       		</table> 
                       		</div>
                       		<br>
                       		<div class="my_button">
                       			<input type="submit" value="Show">&nbsp;<input type="reset" value="RESET">&nbsp;
                       		</div>    
                       		<br>                
                        </form>	
                        </div>				
	           <!--  </article>       -->       
                <div class="clear"></div>                
	         </div><!--///wrapper-->                 
	    </section>
    </div>
	<!--==============================footer=================================-->
     <%@include file="../commonJsp/footer.jsp" %>
</div>
</body>
<script type="text/javascript">
function check() {
	var year = document.getElementById('year').selectedIndex;
	//alert(year);
	if(year<=0){
		alert("Please Select a year");
		return false;
	}
	else
		return true;
	
}
</script>
</html>