<%@page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporter"%>
<%@page import="net.sf.jasperreports.engine.export.JRHtmlExporterParameter"%>
<%@include file="header.jsp" %>
<table align="center" height="30px" width="100%">
  <tr valign="top" align="left">
    <td>
    <s:actionerror  theme="igr" cssClass="errorMsg"/>
    <s:actionmessage theme="igr" cssClass="infoMsg"/>
        </td>
  </tr>
</table>
<br><br>
<div align="center"
			style="height: 60%; width: 100%; overflow: auto;">
		
	
			<%
			
			String actionmessage = request.getParameter("actionmessage");
			if(actionmessage != null){
				out.println(""+actionmessage);
			}
			
   response.setIntHeader("Refresh", 300);%>

 <s:action name="DashBoardAction" executeResult="false"/>
 		
<% 
if(request.getAttribute("reportBody")!=null){
JRHtmlExporter exporter = new JRHtmlExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, request.getAttribute("reportBody"));
exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD, Boolean.TRUE);
exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image/");
exporter.exportReport();
}
%> 

</div>
<br><br>
<%@include file="footer.inc" %>