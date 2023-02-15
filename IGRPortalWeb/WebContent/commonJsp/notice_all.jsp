<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%-- <%@ taglib prefix="sx" uri="/struts-dojo-tags"%> --%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html lang="en">
<head>
    <title>नोटिस</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/breadcrumb.css">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/mycss.css">
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
						<li><a href="/IGRPortalWeb/">मुख्य पृष्ठ</a></li>
						<!-- <li><a href="#">पंजीयन की प्रक्रिया</a></li> -->
						<li class="active"><span>नोटिस</span></li>
					</ol>				
               </div>
               </article>
                <article class="grid_9">
                   <div class="indent">
                      <h2 class="ind2">नोटिस</h2>
                      
                      
                      
                      <div class="col-md-12">
           	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
            	  <tbody>
            	    <tr>
            	      <td>
                      	<ol class="regprocess-list">
                      	<s:if test="%{application['NOTICES'].isEmpty()}">
                      	<li>Currently There are No News to display</li>
                      	</s:if>
                      	<s:else>
						<s:iterator value="#application['NOTICES']" var="notice">
                        	<li><a href="notice_display.jsp?notice_id=%{#notice.notice_id}"><s:property value="notice_about"/></a></li>
                        	</s:iterator>
                        	</s:else>
                        	
                        </ol>
                      </td>
            	      <td valign="top">&nbsp;</td> 
          	      </tr>            	    
          	    </tbody>
          	  </table>
            </div>
                      
                      
                   </div>
                </article>
                <!-- <article class="grid_3">
                   <div class="indent">
                      <h2 class="ind2">News Update</h2>
                      <div id="newsticker01">
                  	<div class="newsticker-jcarousellite01">
                      <ul class="list p3">
                   		<li><a href="#">Praesent vestibum porster lore</a></li>
                   		<li><a href="#">Aenean non sren amet</a></li>
                   		<li><a href="#">Hendrerit mauris hasellus</a></li>
                   		<li><a href="#">Natoque penatibus ma</a></li>
                   	</ul>
                   	</div>
                   	</div>
                   	<a href="#" class="button top">Read More</a>
                   </div>
                    <div class="indent">
                      <h2 class="ind2">Notices</h2>
                      <div id="newsticker01">
                  	<div class="newsticker-jcarousellite01">
                      <ul class="list p3">
                   		<li><a href="#">Praesent vestibum porster lore</a></li>
                   		<li><a href="#">Aenean non sren amet</a></li>
                   		<li><a href="#">Hendrerit mauris hasellus</a></li>
                   		<li><a href="#">Natoque penatibus ma</a></li>
                   	</ul>
                   	</div>
                   	</div>
                   	<a href="#" class="button top">Read More</a>
                   </div>
                </article> -->
                   	
             </div><!--///wrapper-->             
	    </section>
       
       
	    
    </div>
	<!--==============================footer=================================-->
     <%@include file="../commonJsp/footer.jsp" %>

</div>

</body>
</html>