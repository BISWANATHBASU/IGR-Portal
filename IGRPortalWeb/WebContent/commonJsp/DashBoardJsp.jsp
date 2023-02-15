<%@page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporter"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporterParameter"%>
<%@ page language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <%@ taglib prefix="sx" uri="/struts-dojo-tags"%> --%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
	<s:form action="DashBoardAction" validate="true" namespace="/"
		method="post">
		<s:token />
<%
JRHtmlExporter exporter = new JRHtmlExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, request.getAttribute("reportBody"));
exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);  
exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);  
exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD, Boolean.TRUE);  
exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image/");
exporter.exportReport();
%>
</s:form>
</body>
</html>