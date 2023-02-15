<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
<%
for(String s:response.getHeaderNames()){
	System.out.println(s);
}
%>
