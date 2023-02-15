<!DOCTYPE html>
<html lang="en">
<head>
    <title>इनपुट फॉर्म</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						<li><s:url value="indexAction.action" var="indexAction"></s:url>
						<a href="/IGRPortalWeb/">मुख्य पृष्ठ</a></li>
						<li><a href="#">डाउनलोड</a></li>
						<li class="active"><span>इनपुट फॉर्म</span></li>
					</ol>				
               </div>
               </article>
                <article class="grid_9">
                   <div class="indent">
                      <h2 class="ind2">इनपुट फॉर्म</h2>
                    <div class="row">                     
                      
                      <div class="col-md-12">
           	  
          	      
          	    <table width="100%" border="0" cellspacing="0" cellpadding="2" class="download-form-table">
            	  <tbody>
            	    <tr>
            	      <td width="68"><img src="/IGRPortalWeb/images/PDF_download.png" alt="download"/></td>
            	      <td  width="280"><a href="/IGRPortalWeb/download/1.pdf" target="_blank">पट्टा बिलेख</a></td>          	      
            	      <td width="68"><img src="/IGRPortalWeb/images/PDF_download.png" alt="download"/></td>
            	      <td><a href="download/2.pdf" target="_blank">कृषि भूमि सम्बधित</a></td>
          	      </tr>
            	    <tr>
            	      <td><img src="/IGRPortalWeb/images/PDF_download.png" alt="download"/></td>
            	      <td><a href="/IGRPortalWeb/download/3.pdf" target="_blank">मकान सम्बधित</a></td>          	     
            	      <td><img src="/IGRPortalWeb/images/PDF_download.png" alt="download"/></td>
            	      <td><a href="/IGRPortalWeb/download/4.pdf" target="_blank">विषेस योजना सम्बधित</a></td>
          	      </tr>
            	    <tr>
            	      <td><img src="/IGRPortalWeb/images/PDF_download.png" alt="download"/></td>
            	      <td><a href="/IGRPortalWeb/download/5.pdf" target="_blank">बंधक सम्बधित</a></td>          	      
            	      <td><img src="/IGRPortalWeb/images/PDF_download.png" alt="download"/></td>
            	      <td><a href="/IGRPortalWeb/download/6.pdf" target="_blank">परिबर्तित भूमि सम्बधित</a></td>
          	      </tr>
            	    <tr>
            	      <td><img src="/IGRPortalWeb/images/PDF_download.png" alt="download"/></td>
            	      <td><a href="/IGRPortalWeb/download/7.pdf" target="_blank">पुस्तक ३ एब ४ सम्बधित</a></td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
          	      </tr>
          	    </tbody>
          	  </table>  
          	      
          	      
           </div>
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
                <!--%@include file="../commonJsp/news_notice_side.jsp" %-->
                   	
             </div><!--///wrapper-->             
	    </section>
       
       
	    
    </div>
	<!--==============================footer=================================-->
     <%@include file="../commonJsp/footer.jsp" %>

</div>

</body>
</html>