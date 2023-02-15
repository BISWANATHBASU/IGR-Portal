<%@taglib prefix="s" uri="/struts-tags" %>
<%-- <%@ taglib prefix="sx" uri="/struts-dojo-tags"%> --%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<link rel="icon" href="/IGRPortalWeb/images/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="/IGRPortalWeb/images/favicon.ico" type="image/x-icon" /> 
       
    <link rel="stylesheet" type="text/css" media="screen" href="/IGRPortalWeb/css/style.css">
    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/calender.css">
    
        
    <script type="text/javascript" src="/IGRPortalWeb/js/jquery.js"></script>
    <script type="text/javascript" src="/IGRPortalWeb/js/superfish.js"></script>    
     <script type="text/javascript" src="/IGRPortalWeb/js/jquery.responsivemenu.js"></script>
	 <script type="text/javascript" src="/IGRPortalWeb/js/jquery.mobilemenu.js"></script>     
	 <!--slide show js-->	 
	 <script type="text/javascript" src="/IGRPortalWeb/js/jquery.flexslider.js"></script>
	 <script type="text/javascript" src="/IGRPortalWeb/js/jquery.easing.1.3.js"></script>
	 <script src="/IGRPortalWeb/js/script.js"></script>	 
	<script src="/IGRPortalWeb/js/jcarousellite_1.0.1c4.js" type="text/javascript"></script>
 	
	 <script type="text/javascript">
		  $(window).load(function() {			
	   	    jQuery('.flexslider').flexslider({
					animation: "slide",			
					slideshow: true,			
					slideshowSpeed: 7000,
					animationDuration: 600,
					prevText: "",
					nextText: "",
					controlNav: true		
				}) 								
	        });
	 </script>
<!--// Datepicker//-->

<!--// News Scroller//-->
<script type="text/javascript">
$(function() {
	$(".newsticker-jcarousellite").jCarouselLite({
		vertical: true,
		hoverPause:true,
		visible: 2,
		auto:500,
		speed:1000
	});
});
</script>
<script type="text/javascript">	
$(function() {
	$(".newsticker-jcarousellite01").jCarouselLite({
		vertical: true,
		hoverPause:true,
		visible: 2,
		auto:500,
		speed:1000
	});
});
</script>	
<script src="/IGRPortalWeb/js/calender.js"></script>	
	<!--[if lt IE 8]>
   <div style=' clear: both; text-align:center; position: relative;'>
     <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
       <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
    </a>
  </div>
<![endif]-->
    <!--[if lt IE 9]>
   	<script type="text/javascript" src="js/html5.js"></script>
    	<link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
    <![endif]-->
    