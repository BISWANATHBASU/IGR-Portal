<%@include file="header.jsp" %>
<%System.out.println("Error page"); %>
<table align="center" height="400px">
  <tr valign="top" align="left">
    <td>
</td>
  <td>
<font color="RED">${exception}</font>
</td>
  </tr>
</table>
<%@include file="footer.inc" %>