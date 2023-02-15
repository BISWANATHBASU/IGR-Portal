<!DOCTYPE html>
<html lang="en">
	<head>
	    <title>हमारे बारे में</title>
	    <meta charset="utf-8">
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" type="text/css" href="/IGRPortalWeb/css/breadcrumb.css">
    <script src="/IGRPortalWeb/js/sha256.js"></script>
    <%@include file="../commonJsp/include.jsp" %>
    
    <script>
    	function languageFunction(val){
    		alert(val);
    		//return true;
    		
    		var url = "aboutUsAction.action?langCod=" + langCod;//document.getElementById('langCod').value;
            document.getElementById("frm").setAttribute('action', url);
    	}
    </script>
	</head>
	<body id="page1">
		
		<div class="main">
		
			<div class="container_12">
					
				<form name="frm" method="post" action="aboutUsAction.action"></form>
				<div style="float:right;">
					<a href="/IGRPortalWeb/aboutUsAction?langCod=2">Hindi</a> | 
					<a href="/IGRPortalWeb/aboutUsAction?langCod=1">English</a>
				</div>
			<%
				String langCode = (String)request.getSession().getAttribute("langCode");
				String langCod = request.getParameter("langCod");
			
				System.out.println("Before Session langCode=="+langCode+"<<langCod="+langCod+">>");
				
				if(langCode == null && langCod == null){
					session.setAttribute("langCode", "2");
				}else if(langCode == null && langCod != null || langCode == "" && langCod != "" || langCode.equals("") && !langCod.equals("")){
					session.setAttribute("langCode", langCod);
				}else if(langCode != null && langCod == null || langCode != "" && langCod == "" || !langCode.equals("") && langCod.equals("")){
					session.setAttribute("langCode", langCode);
				}else if(langCode != null && langCod != null || langCode != "" && langCod != "" || !langCode.equals("") && !langCod.equals("")){
					session.setAttribute("langCode", langCod);
				}else{
					session.setAttribute("langCode", langCod);
				}
		
				langCode = (String)request.getSession().getAttribute("langCode");
				
				System.out.println("After Session langCode=="+langCode+"<<langCod="+langCod+">>");
				if(langCode == null || langCode == "2" || langCode.equals("") || langCode.equals("2")){
					%><%@include file="../commonJsp/header1.jsp" %><%
				}else{
					%><%@include file="../commonJsp/header1_eng.jsp" %><%
				}
			%>
			<!--==============================content================================-->
				
				
				
				
				<div style="padding:10px">
					<%
						if(langCode == null || langCode == "2" || langCode.equals("") || langCode.equals("2")){
							%>
								<%@include file="../commonJsp/aboutUsHin.jsp"%>
							<%
						}else{
							%>
								<%@include file="../commonJsp/aboutUsEng.jsp"%>
							<%
						}
					%>
					
				</div>
		    
		    <section id="content">
             <div class="wrapper-after">
                <%@include file="../commonJsp/imp_links.jsp"%>
             </div><!--///wrapper-->
             </section>
             
		    </div>
		    
			<!--==============================footer=================================-->
		     <%@include file="../commonJsp/footer.jsp" %>
		</div>
		
	</body>
</html>