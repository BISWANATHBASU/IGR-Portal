<%@taglib prefix="s" uri="/struts-tags" %>
<%-- <%@ taglib prefix="sx" uri="/struts-dojo-tags"%> --%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<s:set var="NEWS" value="#application['NEWS']"></s:set>
<s:if test="%{NEWS.isEmpty()}">
empty
</s:if>
<s:else>
there are news
</s:else>
<s:iterator value="#application['NEWS']" var='news'>
<s:property value="news_headline"/> 
</s:iterator>

</html>