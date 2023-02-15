<!DOCTYPE html>

<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>मुद्रांक तदोपरान्त</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/breadcrumb.css">
    <!-- <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/mycss.css"> -->
    <%@include file="../commonJsp/include.jsp" %>
</head>
<body id="page1" oncontextmenu="return false;">

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
						<a href="<s:property value='#indexAction'/>">मुख्य पृष्ठ</a></li>
						<li><a href="/IGRPortalWeb/reckonerSubAction.action">रेडी रेकोनर</a></li>
						<li class="active"><span>मुद्रांक एब पंजीयन शुल्क</span></li>
					</ol>				
               </div>
               </article>
	            <!-- <article class="grid_4" style="margin-top: 20px;">	    -->
	            <article class="grid_9">
                   <div class="indent">
                   <h2 class="ind2">मुद्रांक एवं पंजीयन शुल्क</h2>
                   </div> <!-- indent div -->
                   </article>
	            <div align="center" style="text-align: center;"> 
	                      						
						
						  <s:form action="" method="post" theme="simple">
						  <div style="width: 50%;padding: 40px" align="center">
						  
                       		<table align="center">
                       			<tr>
                       				<td>दस्तावेज का न्यूनतम बाजार मूल्य*:</td>
                       				<td>
                       				<s:if test="%{documentValue!=null && propertyType!=null}">
                       				<%System.out.println("document value not null"); %>
                       					<s:textfield name="documentValue" id="doc_value" readonly="true"/>
                       					</s:if>
                       				<s:else>
                       				<%System.out.println("document value null"); %>
                       					<s:textfield name="documentValue" id="doc_value" readonly="false"/>
                       				</s:else>
                       				
                       				</td>
								</tr>
                      				<tr>
                       				<td>संपत्ति प्रकार*:</td>
                       				<td>
                       				<s:if test="%{documentValue!=null && propertyType!=null}">
                       				<s:if test='%{propertyType.equals("1")}'>
                       				<s:hidden name="propertyType" id="prop_type"></s:hidden>
                       				<s:textfield value="संरचना सहित" readonly="true"></s:textfield>
                       				</s:if>
                       				<s:elseif test='%{propertyType.equals("2")}'>
                       				<s:hidden name="propertyType" id="prop_type"></s:hidden>
                       				<s:textfield value="संरचना बिना" readonly="true"></s:textfield>
                       				</s:elseif>
                       				</s:if>
                       				<s:else>
                       				<s:select headerKey="" headerValue="Select" 
                       				name="propertyType" list="#{'1':'संरचना सहित','2':'संरचना बिना'}" id="prop_type"/>
                       				</s:else>
                       				</td>
								</tr>
                       			<tr>	
                       				<td>विलेख प्रकार*:</td>
                       				<td>
                       					<s:select headerKey="" headerValue="Select"
							list="deedTypeList" listKey="typeCodeDesc" onchange="loadDeedCategory(this.value);"
							listValue="typeDesc" name="deed_type_id" id="deed_type_id"
							theme="simple" required="true" /> <s:fielderror
							fieldName="deed_type_id" theme="igr" cssClass="smallErrorMsg" />                   					
                       				</td>
                       			</tr> 
                       			<tr>
							
				<td>दस्तावेज प्रकार*:</td>
					<td><s:select headerKey="" headerValue="Select"
							list="deedCategoryList" listKey="typeCode" id="deed_category"
							listValue="typeDesc" name="deed_category_id"
							theme="simple" required="true"  onchange="findStampValue(this.value);"/> <s:fielderror
							fieldName="deed_category_id" theme="igr" cssClass="smallErrorMsg" /></td>
							</tr>
                       	<tr>
                       	<td>मुद्रांक शुल्क*:</td>
							<td><s:textfield name="stamp_value" id="stamp_value"></s:textfield>
                       	</tr> 
                       	<tr>
                       	<td>जनपद / न.मि. / न. पा. / न. प. शुल्क*:</td>
							<td><s:textfield name="addl_stamp_value" id="addl_stamp_value"></s:textfield>
                       	</tr>
                       	<tr>
                       	<td>उपकर*:</td>
							<td><s:textfield name="cessValue" id="cess_value"></s:textfield>
                       	</tr>   
                       	<tr>
                       	<td>पंजीयन शुल्क *:</td>
							<td><s:textfield name="registrationFees" id="registrationFees"></s:textfield>
                       	</tr>           
                       	<tr>
                       	<td colspan="2"><div style="text-align: center; color: red">Note: ** अतिरिक्त 60 रुपए प्रति पृष्ठ दर से !</div></td>
                       	</tr>       			
                       		</table> 
                       		</div>
                       		<br>
                       		<div class="my_button">
                       				
                       				<input type="button" name="Exit" value="Exit" class="button" id="button_id"
					onClick="window.location.href='/IGRPortalWeb/reckonerSubAction';">
                       		</div>    <br> 
                       		<s:hidden name="language" id="language"/>               
                        </s:form>	
                        
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
window.history.forward(0);
function loadDeedCategory(value)  
{
	
	  try{
	    var formInput= 'deed_type_id='+value+"&language="+document.getElementById("language").value;  
	    var options='';   
	      $("#deed_category").html(options);  
	      $.getJSON('loadDeedCategoryEnq.action', formInput,function(data) {
	    	options = '<option selected value="">Select</option>';
	    	$.each(data.deedCategoryList, function(i,item){
	    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
	        });  
	          
	        $("#deed_category").html(options);   
	    }); 
	  }  catch(Exception)
		  {
			  alert("Error" + Exception);
		  }
		
		
	}	
function findStampValue(value){
	
	try{
		var formInput = 'deed_category_id='+ value
			+ '&documentValue=' + document.getElementById("doc_value").value
			+'&propertyType=' + document.getElementById("prop_type").value 
			+ '&deed_type_id='+ 	document.getElementById("deed_type_id").value;
	/* $("#stamp_value").html(options); */
	$.getJSON('findStampValue.action', formInput, function(data) {
		document.getElementById("stamp_value").value = data.stampValue;
		document.getElementById("addl_stamp_value").value = data.addlStampValue;
		document.getElementById("cess_value").value = data.cessValue;
		document.getElementById("registrationFees").value = data.registrationFees;
		
	});
	}catch(Exception){
		alert("Error" + Exception);
	}
}
</script>
</html>