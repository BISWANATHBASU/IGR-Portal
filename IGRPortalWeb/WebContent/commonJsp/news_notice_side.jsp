<article class="grid_3">
                   <div class="indent">
                      <h2 class="ind2">News Update</h2>
                      <div id="newsticker01">
                  	<div class="newsticker-jcarousellite01">
                      <ul class="list p3">
                      <s:if test="%{application['NEWS'].isEmpty()}">
                   		<li>Currently There are No News to display</li>
                   		</s:if>
                   		<s:else>
						<s:iterator value="#application['NEWS']" var="news">
                   		<li>
                   		<s:url action="newsDisplayAction.action" var="newsDisplay">
                   		<s:param name="news_id"><s:property value="news_id"/></s:param>
                   	</s:url>
                   	<a href="<s:property value='#newsDisplay'/>"><s:property value="news_headline"/> 
                   	</a></li>
                   		</s:iterator>
                   		</s:else>
                   	</ul>
                   	</div>
                   	</div>
                   	<s:url action="newsAllAction.action" var="newsAction"></s:url>
                   	<a href="<s:property value='#newsAction'/>" class="button top">View All</a> 
                   </div>
                    <div class="indent">
                      <h2 class="ind2">Notices</h2>
                      <div id="newsticker01">
                  	<div class="newsticker-jcarousellite01">
                      <ul class="list p3">
                      	<s:if test="%{application['NOTICES'].isEmpty()}">
                   		<li>Currently There are no Notice to display</li>
                   		</s:if>
                   		<s:else>
						<s:iterator value="#application['NOTICES']" var="notice">
                   		<li>
                   		<s:url action="noticeDisplayAction" var="noticeDisplay">
                   		<s:param name="notice_id"><s:property value="notice_id"/></s:param>
                   		</s:url>
                   		<a href="<s:property value='#noticeDisplay'/>"><s:property value="notice_about"/></a>
                   		
                   		</li>
                   		
                   		</s:iterator>
                   		</s:else>
                   	</ul>
                   	</div>
                   	</div>
                   	<s:url action="noticeAllAction.action" var="noticeAction"></s:url>
                   	<a href="<s:property value='#noticeAction'/>" class="button top">View All</a>
                   </div>
                </article>