<%@include file="../commonJsp/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
	<s:form action="addSecondToken" validate="true" namespace="/"
		method="post">
		<s:token />

		<div align="center" class="formCaption"><s:property
							value="getText('global.second_token_head')" /></div>
		<div align="center">
			<table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">
				<s:actionerror theme="igr" cssClass="erroMsg" />
				<s:actionmessage theme="igr" cssClass="infoMsg" />

<tr><td colspan="4">
<font color="blue" size="3"> <s:text name="%{messageValue}"  /></font>
</td></tr>
				<tr>
					<td class="tdLabel"><s:property value="getText('global.name')" />*:</td>
					<td class="field"><s:textfield name="presenter_name"
							cssClass="field" required="true" theme="simple"
							maxlength="100">
							<s:fielderror fieldName="presenter_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						<td class="tdLabel"><s:property
							value="getText('global.first_party_name')" />*:</td>
					<td class="field">
					
					<s:textfield
							name="first_party_executant_name" cssClass="field"
							required="true" theme="simple" maxlength="100"
							onblur="javascript:this.value=this.value.toUpperCase();">
							<s:fielderror fieldName="first_party_executant_name" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>
				<tr>
					

					<td class="tdLabel"><s:property
							value="getText('global.first_capacity')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="firstPartyCapacityList" listKey="typeCode"
							listValue="typeDesc" name="first_party_executant_capacity"
							cssClass="largecombobox" theme="simple" required="true" /> <s:fielderror
							fieldName="first_party_executant_capacity" theme="igr"
							cssClass="smallErrorMsg" /></td>
					<td class="tdLabel"><s:property
							value="getText('global.district')" />*:</td>
					<td><s:select list="districtList" listKey="typeCode"
							listValue="typeDesc" name="district_id" cssClass="combobox"
							theme="simple" required="true" onchange="loadDSRLocation(this.value);"/> <s:fielderror
							fieldName="district_id" theme="igr" cssClass="smallErrorMsg" />
					</td>
				</tr>

				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.sub_register_office')" />*:</td>
					<td><s:select list="dsrLocationList" listKey="typeCode"
							listValue="typeDesc" name="dsr_location" id="dsr_location" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="dsr_location" theme="igr" cssClass="smallErrorMsg" />
					</td>
					
					<td class="tdLabel"><s:property
							value="getText('global.Deed_Type_Name')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="deedTypeList" listKey="typeCodeDesc" onchange="loadDeedCategory(this.value);"
							listValue="typeDesc" name="deed_type_id" cssClass="combobox"
							theme="simple" required="true" /> <s:fielderror
							fieldName="deed_type_id" theme="igr" cssClass="smallErrorMsg" /></td>
				</tr>
				
				<tr>
							
				<td class="tdLabel"><s:property
							value="getText('global.Deed_Category')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="deedCategoryList" listKey="typeCode" id="deed_category"
							listValue="typeDesc" name="deed_category_id" cssClass="combobox"
							theme="simple" required="true"  /> <s:fielderror
							fieldName="deed_category_id" theme="igr" cssClass="smallErrorMsg" /></td>
				<td class="tdLabel"><s:property
							value="getText('global.stamp_type')" />*:</td>
					<td class="field"><s:select headerKey="" headerValue="Select"
							list="stampTypeList" listKey="typeCode"
							listValue="typeDesc" name="stamp_type" id="stamp_type"
							cssClass="combobox" theme="simple" onchange="clearValue(this.value);" /> <s:fielderror
							fieldName="stamp_type" theme="igr"
							cssClass="smallErrorMsg" /></td>
				
				</tr>
				
				
				
				<tr>
				<td class="tdLabel"><s:property
							value="getText('global.total_stamp_value')" />*:</td>
					<td class="field"><s:textfield name="total_stamp_value" id="total_stamp_value"
							cssClass="field" required="true"  theme="simple" maxlength="100">
							<s:fielderror fieldName="total_stamp_value" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				<td class="tdLabel"><s:property
							value="getText('global.stamp_pages')" />*:</td>
					<td class="field"><s:textfield name="stamp_pages_no" id="stamp_pages_no"
							cssClass="shortfieldrowwise" 
							theme="simple" maxlength="2" onblur="setValue(this);">
							<s:fielderror fieldName="stamp_pages_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				</tr>
				
				<tr>
					<td class="tdLabel"><s:property
							value="getText('global.treasury_stamp_pages')" />*:</td>
					<td class="field"><s:textfield name="treasury_stamp_page_no" id="treasury_stamp_page_no"
							cssClass="shortfieldrowwise" 
							theme="simple" maxlength="2">
							<s:fielderror fieldName="treasury_stamp_page_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
					<td class="tdLabel"><s:property
							value="getText('global.total_page_no')" />*:</td>
					<td class="field"><s:textfield name="total_page_no" id="total_page_no" 
							cssClass="shortfieldrowwise" required="true" 
							theme="simple" maxlength="5">
							<s:fielderror fieldName="total_page_no" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>		
						
						
				</tr>
				
				<tr>
						
				
				
				<td class="tdLabel"><s:property
							value="getText('global.considered_amount')" />:</td>
					<td class="field"><s:textfield
							name="considered_amount" id="considered_amount" cssClass="field"
							 theme="simple" maxlength="20">
							<s:fielderror fieldName="considered_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
						<td class="tdLabel"><s:property
							value="getText('global.deal_amount')" />*:</td>
					<td class="field"><s:textfield
							name="dealing_amount" id="dealing_amount" cssClass="field"
							required="true" theme="simple" maxlength="20">
							<s:fielderror fieldName="dealing_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
						
					</tr>
	
				<tr>
	
				<td class="tdLabel"><s:property
							value="getText('global.paid_amount')" />*:</td>
					<td class="field"><s:textfield
							name="paid_amount" id="paid_amount" cssClass="field"
							required="true" theme="simple" maxlength="20">
							<s:fielderror fieldName="paid_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
				<td class="tdLabel"><s:property
							value="getText('global.aa_rate')" />:</td>
				<td class="field"><s:textfield
							name="aa_rent" id="aa_rent" cssClass="field readOnlyField"
							theme="simple" maxlength="20" value="0" readonly="true">
							<s:fielderror fieldName="aa_rent" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
				</tr>
				<tr>
				
					<td class="tdLabel"><s:property
							value="getText('global.premium_amount')" />:</td>
				<td class="field"><s:textfield
							name="premium_amount" id="premium_amount" cssClass="field readOnlyField"
							theme="simple" maxlength="20" value="0" readonly="true">
							<s:fielderror fieldName="premium_amount" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>
				
				
				
				<td class="tdLabel"><s:property
							value="getText('global.cost_of_building')" />:</td>
				<td class="field"><s:textfield
							name="cost_of_building" id="cost_of_building" cssClass="field readOnlyField"
							theme="simple" maxlength="20" value="0" readonly="true">
							<s:fielderror fieldName="cost_of_building" theme="igr"
								cssClass="smallErrorMsg" />
						</s:textfield></td>	
				</tr>
				
			</table>
			
		
			<div align="center" style="height: 200px; overflow-x: hidden" id="results">
			</div>
			
			
 <s:hidden name="language" id="language"/>	
 <s:hidden name="firstTokenDate" id="firstTokenDate"/>			
<s:hidden name="rowNumber" id="rownumber"/>
<s:hidden name="party_type" id="party_type"/>
 <s:hidden name="dummyTokenNo" id="dummyTokenNo"/>			
<s:hidden name="dummyDistrictID" id="dummyDistrictID"/>
<s:hidden name="dummyDsrLocation" id="dummyDsrLocation"/>
<s:hidden name="dummyNavigationFlag" id="dummyNavigationFlag"/>
<s:hidden name="dummyTokenDate" id="dummyTokenDate"/>
<s:hidden name="dummyDeedID" id="dummyDeedID"/>
<s:hidden name="dummyFirstPartyName" id="dummyFirstPartyName"/>

<s:hidden name="dummyPresenterName" id="dummyPresenterName"/>			
<s:hidden name="dummyFirstPartyExecutantCapacity" id="dummyFirstPartyExecutantCapacity"/>
<s:hidden name="dummyDeedCategoryId" id="dummyDeedCategoryId"/>
<s:hidden name="dummyConsideredAmount" id="dummyConsideredAmount"/>
<s:hidden name="dummyERegistrationId" id="dummyERegistrationId"/>
<s:hidden name="dummyStampNoWithVal" id="dummyStampNoWithVal"/>
<s:hidden name="dummyOriginalDeedTotalPageNo" id="dummyOriginalDeedTotalPageNo"/>
<s:hidden name="dummyTotalStampValue" id="dummyTotalStampValue"/>

<s:hidden name="dummyAa_rent" id="dummyAa_rent"/>
<s:hidden name="dummyPremium_amount" id="dummyPremium_amount"/>
<s:hidden name="dummyCost_of_building" id="dummyCost_of_building"/>





			<div align="center">
				<s:submit cssClass="button" value="Submit"
					theme="simple" />
					<%-- <s:submit action="addSecondToken" cssClass="button" value="Submit"
					theme="simple" /> --%>
					
			<s:if test="dummyNavigationFlag==true">		
					<s:if test="printFlag==true">
				
				<s:url action="PropertyDetailEntryAction.action" var="secondToken">
				
										<s:param name="token_no">
											<s:property value="dummyTokenNo" />
										</s:param>
										
										<s:param name="dsr_location">
											<s:property value="dummyDsrLocation" />
										</s:param>	
										
										<s:param name="district_id">
											<s:property value="dummyDistrictID" />
										</s:param>
										
										<s:param name="token_date">
											<s:property value="dummyTokenDate" />
										</s:param>
										
										<s:param name="dummyDeedID">
											<s:property value="dummyDeedID" />
										</s:param>
										
										<s:param name="dummyFirstPartyName">
											<s:property value="dummyFirstPartyName" />
										</s:param>
										
										
										<s:param name="dummyPresenterName">
											<s:property value="dummyPresenterName" />
										</s:param>
										
										<s:param name="dummyFirstPartyExecutantCapacity">
											<s:property value="dummyFirstPartyExecutantCapacity" />
										</s:param>
										
										
										<s:param name="dummyDeedCategoryId">
											<s:property value="dummyDeedCategoryId" />
										</s:param>
										
										
										<s:param name="dummyConsideredAmount">
											<s:property value="dummyConsideredAmount" />
										</s:param>
										
										
										<s:param name="dummyERegistrationId">
											<s:property value="dummyERegistrationId" />
										</s:param>
										
										
										<s:param name="dummyStampNoWithVal">
											<s:property value="total_stamp_value" />
										</s:param>
										
										
										<s:param name="dummyOriginalDeedTotalPageNo">
											<s:property value="dummyOriginalDeedTotalPageNo" />
										</s:param>
										
										<s:param name="dummyTotalStampValue">
											<s:property value="dummyTotalStampValue" />
										</s:param>
										
										
										<s:param name="dummyAa_rent">
											<s:property value="dummyAa_rent" />
										</s:param>
										
										
										<s:param name="dummyPremium_amount">
											<s:property value="dummyPremium_amount" />
										</s:param>
										
										<s:param name="dummyCost_of_building">
											<s:property value="dummyCost_of_building" />
										</s:param>
										
										
										
										<s:param name="dummyCallNature">true</s:param>
										
										
										
										
				</s:url>
				
				<s:a href="%{secondToken}">
				<input type="button" name="Next" value="Next" class="button">			
				</s:a>
				</s:if>
			</s:if>		
					
						<s:if test="dummyNavigationFlag==false">		
					<s:if test="printFlag==true">
				
				<s:url action="PartyDetailEntryAction.action" var="partyToken">
				
										<s:param name="token_no">
											<s:property value="dummyTokenNo" />
										</s:param>
										
										<s:param name="dsr_location">
											<s:property value="dummyDsrLocation" />
										</s:param>	
										
										<s:param name="district_id">
											<s:property value="dummyDistrictID" />
										</s:param>
										
										<s:param name="token_date">
											<s:property value="dummyTokenDate" />
										</s:param>
										
										<s:param name="deedID">
											<s:property value="dummyDeedID" />
										</s:param>
										
										<s:param name="party_name">
											<s:property value="dummyFirstPartyName" />
										</s:param>
										
										
										<s:param name="dummyPresenterName">
											<s:property value="dummyPresenterName" />
										</s:param>
										
										<s:param name="dummyFirstPartyExecutantCapacity">
											<s:property value="dummyFirstPartyExecutantCapacity" />
										</s:param>
										
										
										<s:param name="dummyDeedCategoryId">
											<s:property value="dummyDeedCategoryId" />
										</s:param>
										
										
										<s:param name="dummyConsideredAmount">
											<s:property value="dummyConsideredAmount" />
										</s:param>
										
										
										<s:param name="dummyERegistrationId">
											<s:property value="dummyERegistrationId" />
										</s:param>
										
										
										<s:param name="dummyStampNoWithVal">
											<s:property value="dummyStampNoWithVal" />
										</s:param>
										
										
										<s:param name="dummyOriginalDeedTotalPageNo">
											<s:property value="dummyOriginalDeedTotalPageNo" />
										</s:param>
										
											<s:param name="dummyAa_rent">
											<s:property value="dummyAa_rent" />
										</s:param>
										
										
										<s:param name="dummyPremium_amount">
											<s:property value="dummyPremium_amount" />
										</s:param>
										
										<s:param name="dummyCost_of_building">
											<s:property value="dummyCost_of_building" />
										</s:param>
										
										<s:param name="dummyCallNature">true</s:param>
										
										
				</s:url>
				
				<s:a href="%{partyToken}">
				<input type="button" name="Next" value="Next" class="button">			
				</s:a>
				</s:if>
			</s:if>				
				<input type="button" name="Exit" value="Exit" class="button"
					onClick="window.location.href='exitSecondToken';">
				
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">

window.history.forward(0);

	function setValue(noOfPages) {
		
	var formInput = 'stamp_pages_no='+ noOfPages.value;
	var options= ' ';

	if((document.getElementById("stamp_type").value=='global-estamp')||(document.getElementById("stamp_type").value=='global-estamp-treasurystamp'))
		{
		
	if((!isNaN(noOfPages.value))&&(noOfPages.value>0)){

         if(noOfPages.value<=2){
		$.getJSON('loadStampNoValue.action', formInput, function(data) {
			if(data.rowNumber>0){
            options='<table id="stampNoValue" class="shortAppFormBlock" align="center" cellspacing="2px" cellpadding="1px">';       
			options+= '<caption class="formBlockCaption">e-Stamp No and e-Stamp Value</caption>';
			options+='<tr><td class="tdLabel" align="center"><s:property value="getText('global.stamp_no')" />:</td><td class="tdLabel" align="center"><s:property value="getText('global.stamp_value')" />:</td><td class="tdLabel" align="center"><s:property value="getText('global.Stamp_Date')" />:</td></tr>';		
			
			
			for(var i=0;i<data.rowNumber;i++ )
				{
				options+='<tr><td><input type="text" name="stamp_no" id="stamp_no" maxlength="25" class="field" onblur="javascript:this.value=this.value.toUpperCase();"></td>';
				options+='<td><input type="text" name="stamp_value" id="stamp_value" maxlength="10" class="field"></td>';
				options+='<td><input type="text" name="stamp_date" id="stamp_date" maxlength="10" class="field"></td></tr>';
				}
			}
			 document.getElementById("rownumber").value=data.rowNumber;
			 options+='</table>';
			$("#results").html(options);
			});
         }
         else{
              alert("e-Stamp Count can't be greater than 2");
              document.getElementById("stamp_pages_no").value='';
              document.getElementById("stamp_pages_no").focus();
             }
	}
	else{
		$("#results").html(options);
		} 
	
		}
	else if(document.getElementById("stamp_type").value=='global-treasurystamp')
		{
		$("#results").html(options);
		document.getElementById("stamp_pages_no").value='';
		document.getElementById("stamp_pages_no").readOnly=true;
		document.getElementById("stamp_pages_no").className="shortfieldrowwise readOnlyField";
		}		
		}


	function clearValue(stampType) {
		var options= ' ';
           if(stampType=='global-treasurystamp')
			{
   			document.getElementById("stamp_pages_no").value='';
			document.getElementById("stamp_pages_no").readOnly=true;
			document.getElementById("stamp_pages_no").className="shortfieldrowwise readOnlyField";
			$("#results").html(options);
			}
           else
             {
        	document.getElementById("stamp_pages_no").value='';
   			document.getElementById("stamp_pages_no").readOnly=false;
   			document.getElementById("stamp_pages_no").className="shortfieldrowwise";
   			 }  		
			}
	
	
	function loadDeedCategory(value)  
	{
		
		  try{
		    var formInput= 'deed_type_id='+value+"&language="+document.getElementById("language").value;  
		    var options='';   
		      $("#deed_category").html(options);  
		      $.getJSON('loadCategory.action', formInput,function(data) {
		    	options = '<option selected value="">Select</option>';
		    	$.each(data.deedCategoryList, function(i,item){
		    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
		        });  
		          
		        $("#deed_category").html(options);   
		    }); 
		      
		     var deedNumber=value.split("-");
		     
		     
		     if((deedNumber[0]=="74")||(deedNumber[0]=="153"))
		    	 {
		    	    document.getElementById("considered_amount").value='0';
					document.getElementById("considered_amount").readOnly=true;
					document.getElementById("considered_amount").className="field readOnlyField";
		    	 
					
					document.getElementById("dealing_amount").value='0';
					document.getElementById("dealing_amount").readOnly=true;
					document.getElementById("dealing_amount").className="field readOnlyField";
					
					
					document.getElementById("paid_amount").value='0';
					document.getElementById("paid_amount").readOnly=true;
					document.getElementById("paid_amount").className="field readOnlyField";
					
					
					document.getElementById("aa_rent").value='';
		   			document.getElementById("aa_rent").readOnly=false;
		   			document.getElementById("aa_rent").className="field";
		   			
		   			
		   			document.getElementById("premium_amount").value='';
		   			document.getElementById("premium_amount").readOnly=false;
		   			document.getElementById("premium_amount").className="field";
		   			
		   			
		   			document.getElementById("cost_of_building").value='';
		   			document.getElementById("cost_of_building").readOnly=false;
		   			document.getElementById("cost_of_building").className="field";
		    	 
		    	 }
		     
		     else 
		    	 {
		    	 
		    	 
		    	    document.getElementById("aa_rent").value='0';
					document.getElementById("aa_rent").readOnly=true;
					document.getElementById("aa_rent").className="field readOnlyField";
		    	 
					
					document.getElementById("premium_amount").value='0';
					document.getElementById("premium_amount").readOnly=true;
					document.getElementById("premium_amount").className="field readOnlyField";
					
					
					document.getElementById("cost_of_building").value='0';
					document.getElementById("cost_of_building").readOnly=true;
					document.getElementById("cost_of_building").className="field readOnlyField";
					
					
					document.getElementById("paid_amount").value='';
		   			document.getElementById("paid_amount").readOnly=false;
		   			document.getElementById("paid_amount").className="field";
		   			
		   			
		   			document.getElementById("considered_amount").value='';
		   			document.getElementById("considered_amount").readOnly=false;
		   			document.getElementById("considered_amount").className="field";
		   			
		   			
		   			document.getElementById("dealing_amount").value='';
		   			document.getElementById("dealing_amount").readOnly=false;
		   			document.getElementById("dealing_amount").className="field";
		    	 
		    	 }
		      
		  }
		  catch(Exception)
		  {
			  alert("Error" + Exception);
		  }
		
		
	}	
	
	function loadDSRLocation(value)
	{
		 try{
			    var formInput= 'district_id='+value+"&language="+document.getElementById("language").value;  
			    var options='';   
			      $("#dsr_location").html(options);  
			      $.getJSON('loadDSRLocation.action', formInput,function(data) {
			    	options = '<option selected value="">Select</option>';
			    	$.each(data.dsrLocationList, function(i,item){
			    		options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
			        });  
			          
			        $("#dsr_location").html(options);   
			    }); 
		
		 }  catch(Exception)
		  {
			  alert("Error" + Exception);
		  }
	}
</script>	
</html>
<%@include file="../commonJsp/footer.inc"%>
