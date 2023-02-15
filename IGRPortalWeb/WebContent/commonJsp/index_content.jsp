
		<section id="content">        	
	        	<!-- Index Tabs -->
             <%@include file="../commonJsp/index_tab.jsp" %>
             <div class="wrapper-after">
                
                <!-- Notices, News And Calender -->
                <div class="grid_5">
                   <div class="indent">
                   	<h2 class="ind1">News Update</h2>                    	
					<div id="newsticker">
                  	<div class="newsticker-jcarousellite"> 
                  	 <ul>
                  	 <s:if test="%{getNewsList().isEmpty()|| getNewsList().length()==0}">
                  	 <%System.out.println("no news"); %>
   						<li>
   						<span class="p3 block">Currently There are No News to display</span>
                   	<p>Please Check Back later</p> 
   						
   						</li>
						</s:if>
						<s:else>
						
            			<li>                	
                   	<span class="p3 block"><a href="#" class="font20 hov">Name:<s:property value="name"/> </a></span>
                   	<p>&nbsp;</p> 
                   	</li>  
                   	<li>                  	
                   	<span class="p3 block"><a href="#" class="font20 hov">&nbsp; </a></span>
                   	<p>&nbsp;</p>
                   	</li>  
                   	</s:else> 
                   	 </ul>
                   	 </div>   
                   	 <a href="#" class="button top">View All</a>            	
                   	</div>
                   </div>                   
                </div>
                
                <div class="grid_4">
                   <div class="indent">
                   	<h2 class="ind1">Notices</h2>
                   	<div id="newsticker01">
                  	<div class="newsticker-jcarousellite01">
                   	<ul class="list p3">
                   		<%-- <s:if test="%{getNoticeList().isEmpty()}">
   						<li>Currently There are no Notice to display</li>
						</s:if> --%>

                   		<li><a href="#">Praesent vestibum</a></li>
                   		<li><a href="#">Aenean non</a></li>
                   		<li><a href="#">Hendrerit mauris</a></li>
                   		<li><a href="#">Phasellus</a></li>
                   		<li><a href="#">Natoque penatibus magnis</a></li>
                   		<li><a href="#">Dis parturient montes</a></li>
                   		<li><a href="#">Praesent vestibum</a></li>
                   		<li><a href="#">Aenean non</a></li>
                   		<li><a href="#">Hendrerit mauris</a></li>
                   		<li><a href="#">Phasellus</a></li>
                   		<li><a href="#">Natoque penatibus magnis</a></li>
                   		<li><a href="#">Dis parturient montes</a></li>
                   	</ul> 
                   	</div>
                   	<a href="#" class="button top">View All</a>
                   	</div>                  	
                   </div>
                </div>
                <div class="grid_3">
                   <div class="indent">
                   	<h2 class="ind1">Calendar</h2>
                   	<script type="text/javascript">
						calendar();
					</script>					  
                </div>
                </div>
                <!-- Important Links -->
                <%@include file="../commonJsp/imp_links.jsp" %>
                            
             </div><!--///wrapper-->             
	    </section>