<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <%@ taglib prefix="sx" uri="/struts-dojo-tags"%> --%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%String cacheReq=null;%>
<% if (cacheReq==null){
/*** for cache control********/
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Expires","01 jan 1900");%>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="cache-control" content="no-store">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<%}%>
<link rel="stylesheet" type="text/css" href="<s:url value="/include/ams.css"/>">
<link rel="stylesheet" type="text/css" href="<s:url value="/include/font-awesome.css"/>">
<link rel="stylesheet" type="text/css" href="<s:url value="/include/menu.css"/>">
	<link rel="stylesheet" type="text/css" href="<s:url value="/include/signature-pad.css"/>">
<script language="JavaScript1.2"
	src="<s:url value="/include/jquery.min.js"/>"></script>
<script language="JavaScript1.2" src="<s:url value="/include/signature_pad.js"/>"></script>
<script language="JavaScript1.2" src="<s:url value="/include/AMS.js"/>"></script>
<script language="JavaScript1.2" src="<s:url value="/include/menu.js"/>"></script>

<script language="JavaScript1.2" src="<s:url value="/js/jquery.datepick.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<s:url value="/css/jquery.datepick.css"/>">
<link rel="stylesheet" type="text/css" href="<s:url value="/css/workProgress.css"/>">
<body style="margin-top: 5px; margin-left: 10px;">

	<%
		String dispName = (String) request.getSession().getAttribute(
				"DISPLAYNAME");
		
		String branchName = (String) request.getSession().getAttribute(
			"LOCATIONNAME");
		if(branchName==null || branchName.trim().length()==0){
			branchName="";
		}
		String groupName = (String) request.getSession().getAttribute(
				"_USERGROUP");
		System.out.println(groupName);
		String language= (String) request.getSession().getAttribute("_LANGUAGE");
		if((groupName == null)||(groupName.trim().length() ==0)) 
			response.sendRedirect("/commonJsp/login.jsp");
	%>
	<div align="center">
		<div id="appContainer" class="body-contentBG" style="width: 100%; border: 1px solid midnightblue;">
		<div class="header-content">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tbody>
				<tr>
				  <td width="125"><img src="<%= request.getContextPath() %>/image/logo.png" alt="User" /></td>
				  
				  <td>
					<div align="left" class="appHeader">
						<font face="Curlz MT" size="15"><b><I>e</I></b></font><font face="Blackadder ITC" size="6"><b><i>-Panjeeyan</i></b></font> 
					</div>
				  </td>
				  <td>
					<div class="userIntro">
					<div class="header_right">
						<div id="user_nav">
							<ul>
								<li class="user_thumbs"><span class="icon"><img src="<%= request.getContextPath() %>/image/user_thumb.png" alt="User" /></span></li>
								<li class="user_info">
								<ul class="navigation">
									<a class="main" href="#url">Welcome : <% out.print(dispName); %>, <%out.print(branchName); %></a>
									<li class="n1"><i class="fa fa-power-off fa-fw" aria-hidden="true"></i>&nbsp;&nbsp;<a href="logOut">Logout</a></li>
								</ul>                   
								</li>
							</ul>
						</div>
					</div>				
					</div>					
				  </td>
				</tr>
			  </tbody>
			</table>
		</div>
		<div align="left">
					<%
						if(language.equals("1") && groupName.equals("1")) {
					%>
					<%@include file="menu_portal_en.jsp"%>
					<%
						} else if(language.equals("2")&& groupName.equals("1")) {

						%>
					<%@include file="menu_portal_hi1.jsp"%>
					<%
						}else if(language.equals("1") && groupName.equals("2")) {
							%>
							<%@include file="menu_super_admin_en.jsp"%>
							<%
								} else if(language.equals("2")&& groupName.equals("2")) {
								%>
							<%@include file="menu_super_admin_hi.jsp"%>
							<%} %>
				</div>	
			
			<!-- div align="left">
			
			</div-->
		