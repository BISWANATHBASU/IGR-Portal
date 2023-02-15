<!DOCTYPE html>

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
						<li><a href="#">नोटिस</a></li>
						<li class="active"><span>नोटिस विवरण</span></li>
					</ol>				
               </div>
               </article>
                <article class="grid_9">
                   <div class="indent">
                      <h2 class="ind2"><s:property value="notice.notice_about"/></h2>
                      <h3>Notice Date:<s:property value="notice.date_posted"/></h3>
                      <div id="news-display">
               <table border="1" width="100%">
               <tr>
               
               <tr>
               <td>
               <embed src="/IGRPortalWeb/notice_pdf/<s:property value='notice.file_name'/>" type="application/pdf" width="100%" height="600" text="no-file">
               </td>
               </tr>
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