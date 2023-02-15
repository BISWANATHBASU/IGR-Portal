<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>विवादित भूमि</title>
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
						<a href="<s:property value='#indexAction'/>">मुख्य पृष्ठ</a></li>
						<li class="active"><span>विवादित भूमि</span></li>
					</ol>				
               </div>
               </article>
	            <!-- <article class="grid_4" style="margin-top: 20px;">	    -->
	            <article class="grid_9">
                   <div class="indent">
                   <h2 class="ind2">विवादित भूमि </h2>
                   </div> <!-- indent div -->
                   </article>
	            <div align="center" style="text-align: center;"> 
	                      						
						
						  <s:form action="findPDFAction" method="post" theme="simple" namespace="/">
						  <div style="width: 50%;padding: 40px" align="center">
						  
                       		<table width="100%" align="center">
                      			<tr>
                       				<td align="right">जिला कि चयन करे:</td>
                       				<td><s:select list="districtList" headerKey="Select" listKey="typeCode"
							listValue="typeDesc" name="district_id" id="district_id" cssClass="combobox"
							theme="simple" required="true"/> <s:fielderror
							fieldName="district_id" theme="igr" cssClass="smallErrorMsg" /></td>
								</tr>
                       			
                       			<tr>
                       			<td colspan="2" align="center">
                       			<s:if test="pdfFile!=null || pdfFile.length()>0">
                       			<a href="commonSearch/landPDFs/<s:property value='pdfFile'/>" target="_blank" style="color: blue;">सूची देखने के लिए यहां क्लिक करें</a>
                       			</s:if>
                       			<s:actionerror/>
                       			</td>  
                       			</tr>
                       			<tr>
                       			<td colspan="2" align="center"><s:submit value="SHOW"/>&nbsp;<s:reset value="RESET"/>&nbsp;
                       				<input type="button" onclick="window.location.href='/IGRPortalWeb/indexAction';" value="EXIT"/>
                       				</td>
                       				</tr>              			
                       		</table> 
                       		</div>
                       		<br>
                       		<%-- <div class="my_button">
                       				<s:submit value="SHOW"/>&nbsp;<s:reset value="RESET"/>&nbsp;
                       				<input type="button" onclick="window.location.href='/IGRPortalWeb/indexAction';" value="EXIT"/>
                       				<s:url action="indexAction" var="index"/>
                       				<a href="<s:property value='#index'/>">EXIT</a>  
                       		</div>  --%>   <br>                
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
</html>