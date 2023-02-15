<!DOCTYPE html>
<%@page isErrorPage="true" %>
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <%@include file="../commonJsp/include.jsp" %>
</head>
<body id="page1" oncontextmenu="return false;">
<%System.out.println(exception); %>

<div class="main">
	<div class="container_12">
<header>
		    <div class="wrapper">
		    	<h1><a href="/IGRPortalWeb/"><img src="/IGRPortalWeb/images/logo.png" alt=""></a><span></span></h1>
		    	<div class="tagline">
		    		<p>E-Panjeeyan Portal</p> 
		    	</div>                
		    </div>
		    <section id="content">
		    <img alt="Session Terminated. PLease go to HOME" src="images/error_page.png"/>
		    <!-- <div class="tagline">
		    		<p>E-Panjeeyan Portal</p> 
		    	</div>  -->
		    </section>
	    </header>
	    </div>
	    <!--==============================footer=================================-->
     <%@include file="../commonJsp/footer.jsp" %>
	    </div>
	    </body>