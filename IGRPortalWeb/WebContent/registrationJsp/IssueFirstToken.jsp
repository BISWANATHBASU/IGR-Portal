
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="../commonJsp/header2.jsp"%>
<html>
<head>
<title>प्रस्तुति विवरणी</title>
<s:head theme="igr" />
<sx:head />
</head>
<body oncontextmenu="return false;">
	<br />
	<div id="workProgress">
		<ul>
			<li class="workingWind"><a href="#">प्रस्तुति विवरणी &#9998;</a></li>
			
			<li class="waitingWind"><a href="#">स्टाम्प विवरणी&#10006;</a></li>
			<li class="waitingWind"><a href="#">सम्पत्ति का विवरण &#10006;</a></li>
			<li class="waitingWind"><a href="#">संरचना का विवरण &#10006;</a></li>
			<li class="waitingWind"><a href="#">पक्षकार का प्रकार &#10006;</a></li>
			<li class="waitingWind"><a href="#">विलेख का विवरण &#10006;</a></li>
			<li class="waitingWind"><a href="#">अपॉइंटमेंट/ शुल्क &#10006;</a></li>
			<li class="waitingWind"><a href="#">पुनः अपॉइंटमेंट &#10006;</a></li>
		</ul>
	</div>
	<s:form action="addFirstToken" validate="true" namespace="/" method="post" enctype = "multipart/form-data">
            <s:token />
            
                <s:if test="nextFlag!=true">
	            <div align="center" class="formCaption">
	                <s:property value="getText('global.firstToken')" />
	            </div>
         		</s:if>
         		<s:if test="nextFlag==true">
         		<div align="center" class="formCaption">
	                <s:property value="getText('global.firstTokenSuccess')" />
	                <font color="blue" size="3"> <s:text name="%{messageValue}"  /></font>
	                
                    <s:actionerror theme="igr" cssClass="erroMsg" />
                    <s:actionmessage theme="igr" cssClass="infoMsg" />
                    
	            </div>
         		</s:if>
         		
         		<s:if test="nextFlag!=true">
            <div align="center">
                <table class="appFormBlock" align="center" cellspacing="2px" cellpadding="1px">

                    <tr>
                        <td colspan="4">
                            <font color="blue" size="3"> <s:text name="%{messageValue}"  /></font>
                        </td>
                    </tr>
                    
                    <tr>
                        <td class="tdLabel">
                            <s:property value="getText('global.Deed_Type_Name')" />*:</td>
                        <td class="field">
                            <s:select name="deedType" list="deedTypeList" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" />
                            <s:fielderror fieldName="deedType" theme="igr" cssClass="smallErrorMsg" />
                        </td>
                        <td class="tdLabel"><s:property value="getText('global.name')" />*:</td>
                        <td class="field">
                            <s:textfield name="presenterName" cssClass="field" required="true" theme="simple" maxlength="100" placeholder="हिंदी में नाम प्रविष्टि कीजिये">
                                <s:fielderror fieldName="presenterName" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.party_party_type')" />*:</td>
                        <td class="field">
                            <!--s:select name="partyType" list="partyTypeList" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" /-->
                            <s:select name="party_type" list="party_type_List" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" />
                            <s:fielderror fieldName="party_type" theme="igr" cssClass="smallErrorMsg" />
                        </td>
                        <td class="tdLabel"><s:property value="getText('global.relation')" />*:</td>
                        <td class="field">
                            <s:select name="relativeType" list="relativeTypeList" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" />
                            <s:fielderror fieldName="relativeType" theme="igr" cssClass="smallErrorMsg" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.gurdianname')" />*:</td>
                        <td class="field">
                            <s:textfield name="relativeName" cssClass="field" required="true" theme="simple" maxlength="100" placeholder="हिंदी में पिता / माता का नाम प्रविष्टि ">
                                <s:fielderror fieldName="relativeName" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                        <td class="tdLabel"><s:property value="getText('global.address')" />*:</td>
                        <td class="field">
                            <s:textfield name="presenterAddress" cssClass="field" required="true" theme="simple" maxlength="100" placeholder="हिंदी में  अपना पता  प्रविष्टि कीजिये">
                                <s:fielderror fieldName="presenterAddress" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.state')" />*:</td>
                        <td class="field">
                            <s:select name="presenterState" list="stateList" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" />
                            <s:fielderror fieldName="presenterState" theme="igr" cssClass="smallErrorMsg" />
                        </td>
                        <td class="tdLabel">
                            <s:property value="getText('global.district')" />*:</td>
                        <td class="field">
                            <s:select name="district_id" id="district_id" list="districtList" onchange="loadDSRLocation(this.value);" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" />
                            <s:fielderror fieldName="district_id" theme="igr" cssClass="smallErrorMsg" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.sub_register_office')" />*:</td>
                        <td class="field">
                            <s:select name="dsrLocation" id="dsr_location" list="dsrLocationList" headerKey="" headerValue="Select" listKey="typeCode" listValue="typeDesc" cssClass="combobox" theme="simple" required="true" />
                            <s:fielderror fieldName="dsrLocation" theme="igr" cssClass="smallErrorMsg" />
                        </td>
                        <td class="tdLabel"><s:property value="getText('global.pin')" />*:</td>
                        <td class="field">
                            <s:textfield name="presenterPinCode" cssClass="field" required="true" theme="simple" maxlength="6"
                             pattern="[0-9]{6}" title="6 Digit Pin Code" placeholder="डाक न. प्रविष्टि कीजिये">
                                <s:fielderror fieldName="presenterPinCode" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.ph_no')" />*:</td>
                        <td class="field">
                            <s:textfield name="presenterMobileNo" cssClass="field" required="true" theme="simple" maxlength="10"
                             pattern="[0-9]{10}" title="10 Digit Mobile No" placeholder="मोबाइल न. प्रविष्टि कीजिये">
                                <s:fielderror fieldName="presenterMobileNo" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                        <td class="tdLabel"><s:property value="getText('global.user_mail')" />*:</td>
                        <td class="field">
                            <s:textfield name="presentereMailId" cssClass="field" required="true" theme="simple" maxlength="100" placeholder="ई-मेल प्रविष्टि कीजिये">
                                <s:fielderror fieldName="presentereMailId" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdLabel"><s:property value="getText('global.document')" />*:</td>
                        <td class="field">
                            <s:file name="uploadDoc" cssClass="field" required="true" theme="simple" maxlength="100">
                                <s:fielderror fieldName="uploadDoc" theme="igr" cssClass="smallErrorMsg" />
                            </s:file>
                        </td>
                        <td class="tdLabel">&nbsp;</td>
                        <td class="field">&nbsp;</td>
                        <!--td class="tdLabel"><s:property value="getText('global.total_pages')" />*:</td>
                        <td class="field">
                            <s:textfield name="totalPages" cssClass="field" required="true" theme="simple" maxlength="100"
                             pattern="[0-9]{1,}" title="Only Digit 0-9"  placeholder="PDF की संख्या प्रविष्टि कीजिये">
                                <s:fielderror fieldName="totalPages" theme="igr" cssClass="smallErrorMsg" />
                            </s:textfield>
                        </td-->
                    </tr>
                    <tr>
                    	<th class="field" colspan=4 style="color:red;text-align:left;">
                    		नोट :- अपलोड किये जाने वाले pdf के पेजों की संख्या सम संख्या होनी चाहिय !<br />
                    		Note :- Number of pdf pages to upload should be even number
                    		<!--नोट: - कृपया इनपुट पेज की गिनती जो अपलोड की हुई पीडीएफ फाइल के पेज काउंट के बराबर होनी चाहिए। <br />
                    		Note:- Please Input page count which should be equal to Page count of Uploaded PDF file.-->
                    	</th>
                    </tr>
                    
                </table>
            </div>
            </s:if>

<s:hidden name="language" id="language"/>

<s:hidden name="dummyTokenNo" id="dummyTokenNo"/>
<s:hidden name="dummyPresenterName" id="dummyPresenterName"/>
<s:hidden name="dummyDistrictID" id="dummyDistrictID"/>
<s:hidden name="dummyDsrLocation" id="dummyDsrLocation"/>
<s:hidden name="dummyTokenDate" id="dummyTokenDate"/>
<s:hidden name="dummyDeedID" id="dummyDeedID"/>

<s:hidden name="dummyPartyType" id="dummyPartyType"/>
<s:hidden name="dummyPropertyPermission" id="dummyPropertyPermission"/>
<s:hidden name="dummyDsrLocationDesc" id="dummyDsrLocationDesc"/>

                        
                        <div align="center">
                        <s:if test="nextFlag!=true">
                            <s:submit cssClass="button" value="Submit" theme="simple" />
                            </s:if>
                            
					<s:if test="nextFlag==true">
					<!-- SearchFirstTokenForSecondToken.action -->
				
				<s:url action="IssueSecondTokenAction.action" var="secondToken">
				
				<s:date name="token_date" format="dd/MM/yyyy" />
				
										<s:param name="token_no">
											<s:property value="dummyTokenNo" />
										</s:param>
										<s:param name="presenter_name">
											<s:property value="dummyPresenterName" />
										</s:param>
										<s:param name="dsr_location">
											<s:property value="dummyDsrLocation" />
										</s:param>
										<s:param name="dsr_location_desc">
											<s:property value="dummyDsrLocationDesc" />
										</s:param>
										<s:param name="district_id">
											<s:property value="dummyDistrictID" />
										</s:param>
										<s:param name="firstTokenDate">
											<s:property value="dummyTokenDate" />
										</s:param>
										<s:param name="deed_type_id">
											<s:property value="dummyDeedID" />
										</s:param>
										<s:param name="party_type">
											<s:property value="dummyPartyType" />
										</s:param>
										<s:param name="property_permission">
											<s:property value="dummyPropertyPermission" />
										</s:param>

										<s:param name="dummyCallNature">true</s:param>
										
				</s:url>
				
				<s:a href="%{secondToken}">
				<input type="button" name="Next" value="Next" class="button">			
				</s:a>
				</s:if>
                        </div>
	</s:form>
</body>
<script type="text/javascript">

window.history.forward(0);
$("#tcp_div_1").hide();
$("#tcp_div_2").hide();
function loadDSRLocation(value){
    //alert("loadDSRLocation="+value);
    try{
        var formInput= 'district_id='+value+"&language="+document.getElementById("language").value;  
        var options='';   
          $("#dsr_location").html(options);  
          $.getJSON('loadDSRLocation.action', formInput,function(data) {
            options = '<option selected value="">Select</option>';
            //alert(options);
            $.each(data.dsrLocationList, function(i,item){
                //alert("item.typeDesc="+item.typeDesc);
                options += '<option value="' + item.typeCode + '">' + item.typeDesc + '</option>';  
            });  

            $("#dsr_location").html(options);   
        }); 

    }  catch(Exception){
        alert("Error" + Exception);
    }
}
</script>
</html>
<%@include file="../commonJsp/footer.inc"%>
