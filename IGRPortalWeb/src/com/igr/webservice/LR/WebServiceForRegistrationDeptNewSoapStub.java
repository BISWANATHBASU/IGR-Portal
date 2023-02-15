/**
 * WebServiceForRegistrationDeptNewSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class WebServiceForRegistrationDeptNewSoapStub extends org.apache.axis.client.Stub implements com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[17];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDistrictDetail");
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>GetDistrictDetailResponse>GetDistrictDetailResult"));
        oper.setReturnClass(com.igr.webservice.LR.GetDistrictDetailResponseGetDistrictDetailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "GetDistrictDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTehsilByDistrict");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Distno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>GetTehsilByDistrictResponse>GetTehsilByDistrictResult"));
        oper.setReturnClass(com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "GetTehsilByDistrictResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetRIByDistrictAndTehsils");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Distno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Tehsilno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>GetRIByDistrictAndTehsilsResponse>GetRIByDistrictAndTehsilsResult"));
        oper.setReturnClass(com.igr.webservice.LR.GetRIByDistrictAndTehsilsResponseGetRIByDistrictAndTehsilsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "GetRIByDistrictAndTehsilsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetVillageCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Distno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Tehsilno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Rino"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>GetVillageCodeResponse>GetVillageCodeResult"));
        oper.setReturnClass(com.igr.webservice.LR.GetVillageCodeResponseGetVillageCodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "GetVillageCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToGetDataofKhasra");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Districtno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Tehsilno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Rino"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Villageno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "KhasraNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ArrayOfKhasraDetails"));
        oper.setReturnClass(com.igr.webservice.LR.KhasraDetails[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToGetDataofKhasraResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "KhasraDetails"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToPostPropertyRegistrationDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Villcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Khasrano"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Area"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regdate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regdoc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationDetailResponse>ToPostPropertyRegistrationDetailResult"));
        oper.setReturnClass(com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToPostPropertyRegistrationOwnerDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Villcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Khasrano"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocdname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocdname1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "oFather"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "oFather1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "gender"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocaste"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocastenm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "oaddress"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "AadharNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "MobileNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "LoanBook"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationOwnerDetailResponse>ToPostPropertyRegistrationOwnerDetailResult"));
        oper.setReturnClass(com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetailResponseToPostPropertyRegistrationOwnerDetailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationOwnerDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToPostPropertyRegistrationOwnerDetail_Tocheck");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Villcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Khasrano"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocdname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocdname1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "oFather"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "oFather1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "gender"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocaste"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocastenm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "oaddress"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "MobileNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "AadharNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "LoanBook"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationOwnerDetail_TocheckResponse>ToPostPropertyRegistrationOwnerDetail_TocheckResult"));
        oper.setReturnClass(com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationOwnerDetail_TocheckResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToPostPropertyRegistrationVikretaDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Villcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Khasrano"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocdname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocdname1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "oFather"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "oFather1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "gender"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocaste"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocastenm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "oaddress"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "MobileNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "AadharNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "LoanBook"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationVikretaDetailResponse>ToPostPropertyRegistrationVikretaDetailResult"));
        oper.setReturnClass(com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationVikretaDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToGetNajoolDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "plotno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "recordcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ArrayOfPlotDetails"));
        oper.setReturnClass(com.igr.webservice.LR.PlotDetails[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToGetNajoolDetailsResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "PlotDetails"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToGetDiversionDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "plotno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "recordcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ArrayOfDiversionPlotDetails"));
        oper.setReturnClass(com.igr.webservice.LR.DiversionPlotDetails[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToGetDiversionDetailsResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionPlotDetails"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToPostNajoolPropertyRegistrationDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "recordcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "plotno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Area"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "taxfreeArea"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "basetax"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "baseenvtax"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "basedevtax"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regdate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regdoc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostNajoolPropertyRegistrationDetailResponse>ToPostNajoolPropertyRegistrationDetailResult"));
        oper.setReturnClass(com.igr.webservice.LR.ToPostNajoolPropertyRegistrationDetailResponseToPostNajoolPropertyRegistrationDetailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostNajoolPropertyRegistrationDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToPostNajoolPropertyRegistration_kretaDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "recordcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "person_name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "father_name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "address"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "mobile_no"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "olast"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "PregNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostNajoolPropertyRegistration_kretaDetailsResponse>ToPostNajoolPropertyRegistration_kretaDetailsResult"));
        oper.setReturnClass(com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostNajoolPropertyRegistration_kretaDetailsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToPostNajoolPropertyRegistration_VikretaDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "recordcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "person_name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "father_name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "address"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "mobile_no"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "olast"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "PregNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostNajoolPropertyRegistration_VikretaDetailsResponse>ToPostNajoolPropertyRegistration_VikretaDetailsResult"));
        oper.setReturnClass(com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostNajoolPropertyRegistration_VikretaDetailsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToPostDiversionPropertyRegistrationDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "recordcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "plotno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Area"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "taxfreeArea"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "basetax"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "baseenvtax"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "basedevtax"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regdate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regdoc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostDiversionPropertyRegistrationDetailResponse>ToPostDiversionPropertyRegistrationDetailResult"));
        oper.setReturnClass(com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostDiversionPropertyRegistrationDetailResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToPostDiversionPropertyRegistration_kretaDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "recordcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "person_name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "father_name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "address"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "mobile_no"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "olast"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "PregNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostDiversionPropertyRegistration_kretaDetailsResponse>ToPostDiversionPropertyRegistration_kretaDetailsResult"));
        oper.setReturnClass(com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostDiversionPropertyRegistration_kretaDetailsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ToPostDiversionPropertyRegistration_VikretaDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "recordcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "person_name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "father_name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "address"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "mobile_no"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "olast"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "PregNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostDiversionPropertyRegistration_VikretaDetailsResponse>ToPostDiversionPropertyRegistration_VikretaDetailsResult"));
        oper.setReturnClass(com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostDiversionPropertyRegistration_VikretaDetailsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

    }

    public WebServiceForRegistrationDeptNewSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public WebServiceForRegistrationDeptNewSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public WebServiceForRegistrationDeptNewSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>GetDistrictDetailResponse>GetDistrictDetailResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.GetDistrictDetailResponseGetDistrictDetailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>GetRIByDistrictAndTehsilsResponse>GetRIByDistrictAndTehsilsResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.GetRIByDistrictAndTehsilsResponseGetRIByDistrictAndTehsilsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>GetTehsilByDistrictResponse>GetTehsilByDistrictResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>GetVillageCodeResponse>GetVillageCodeResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.GetVillageCodeResponseGetVillageCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostDiversionPropertyRegistration_kretaDetailsResponse>ToPostDiversionPropertyRegistration_kretaDetailsResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostDiversionPropertyRegistration_VikretaDetailsResponse>ToPostDiversionPropertyRegistration_VikretaDetailsResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostDiversionPropertyRegistrationDetailResponse>ToPostDiversionPropertyRegistrationDetailResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostNajoolPropertyRegistration_kretaDetailsResponse>ToPostNajoolPropertyRegistration_kretaDetailsResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostNajoolPropertyRegistration_VikretaDetailsResponse>ToPostNajoolPropertyRegistration_VikretaDetailsResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostNajoolPropertyRegistrationDetailResponse>ToPostNajoolPropertyRegistrationDetailResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostNajoolPropertyRegistrationDetailResponseToPostNajoolPropertyRegistrationDetailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationDetailResponse>ToPostPropertyRegistrationDetailResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationOwnerDetail_TocheckResponse>ToPostPropertyRegistrationOwnerDetail_TocheckResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationOwnerDetailResponse>ToPostPropertyRegistrationOwnerDetailResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetailResponseToPostPropertyRegistrationOwnerDetailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationVikretaDetailResponse>ToPostPropertyRegistrationVikretaDetailResult");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">DataSet");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.DataSet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">GetRIByDistrictAndTehsils");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.GetRIByDistrictAndTehsils.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">GetRIByDistrictAndTehsilsResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.GetRIByDistrictAndTehsilsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">GetTehsilByDistrict");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.GetTehsilByDistrict.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">GetTehsilByDistrictResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.GetTehsilByDistrictResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">GetVillageCode");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.GetVillageCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">GetVillageCodeResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.GetVillageCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToGetDataofKhasra");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToGetDataofKhasra.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToGetDataofKhasraResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToGetDataofKhasraResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToGetDiversionDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToGetDiversionDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToGetDiversionDetailsResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToGetDiversionDetailsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToGetNajoolDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToGetNajoolDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToGetNajoolDetailsResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToGetNajoolDetailsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostDiversionPropertyRegistration_kretaDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostDiversionPropertyRegistration_kretaDetailsResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostDiversionPropertyRegistration_VikretaDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostDiversionPropertyRegistration_VikretaDetailsResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostDiversionPropertyRegistrationDetail");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostDiversionPropertyRegistrationDetailResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostNajoolPropertyRegistration_kretaDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostNajoolPropertyRegistration_kretaDetailsResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostNajoolPropertyRegistration_VikretaDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostNajoolPropertyRegistration_VikretaDetailsResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostNajoolPropertyRegistrationDetail");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostNajoolPropertyRegistrationDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostNajoolPropertyRegistrationDetailResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostNajoolPropertyRegistrationDetailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationDetail");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationDetailResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationOwnerDetail");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationOwnerDetail_Tocheck");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_Tocheck.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationOwnerDetail_TocheckResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationOwnerDetailResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationVikretaDetail");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationVikretaDetailResponse");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ArrayOfDiversionOwnerDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.DiversionOwnerDetails[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionOwnerDetails");
            qName2 = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionOwnerDetails");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ArrayOfDiversionPlotDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.DiversionPlotDetails[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionPlotDetails");
            qName2 = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionPlotDetails");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ArrayOfKhasraDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.KhasraDetails[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "KhasraDetails");
            qName2 = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "KhasraDetails");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ArrayOfNajoolOwnerDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.NajoolOwnerDetails[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "NajoolOwnerDetails");
            qName2 = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "NajoolOwnerDetails");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ArrayOfOwnerDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.OwnerDetails[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "OwnerDetails");
            qName2 = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "OwnerDetails");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ArrayOfPlotDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.PlotDetails[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "PlotDetails");
            qName2 = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "PlotDetails");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ArrayOfRevcase");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.Revcase[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Revcase");
            qName2 = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Revcase");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionOwnerDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.DiversionOwnerDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionPlotDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.DiversionPlotDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "KhasraDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.KhasraDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "NajoolOwnerDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.NajoolOwnerDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "OwnerDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.OwnerDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "PlotDetails");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.PlotDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Revcase");
            cachedSerQNames.add(qName);
            cls = com.igr.webservice.LR.Revcase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.igr.webservice.LR.GetDistrictDetailResponseGetDistrictDetailResult getDistrictDetail() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/GetDistrictDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "GetDistrictDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.GetDistrictDetailResponseGetDistrictDetailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.GetDistrictDetailResponseGetDistrictDetailResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.GetDistrictDetailResponseGetDistrictDetailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult getTehsilByDistrict(java.lang.String distno) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/GetTehsilByDistrict");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "GetTehsilByDistrict"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {distno});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.GetRIByDistrictAndTehsilsResponseGetRIByDistrictAndTehsilsResult getRIByDistrictAndTehsils(java.lang.String distno, java.lang.String tehsilno) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/GetRIByDistrictAndTehsils");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "GetRIByDistrictAndTehsils"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {distno, tehsilno});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.GetRIByDistrictAndTehsilsResponseGetRIByDistrictAndTehsilsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.GetRIByDistrictAndTehsilsResponseGetRIByDistrictAndTehsilsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.GetRIByDistrictAndTehsilsResponseGetRIByDistrictAndTehsilsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.GetVillageCodeResponseGetVillageCodeResult getVillageCode(java.lang.String distno, java.lang.String tehsilno, java.lang.String rino) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/GetVillageCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "GetVillageCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {distno, tehsilno, rino});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.GetVillageCodeResponseGetVillageCodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.GetVillageCodeResponseGetVillageCodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.GetVillageCodeResponseGetVillageCodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.KhasraDetails[] toGetDataofKhasra(java.lang.String districtno, java.lang.String tehsilno, java.lang.String rino, java.lang.String villageno, java.lang.String khasraNo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToGetDataofKhasra");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToGetDataofKhasra"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {districtno, tehsilno, rino, villageno, khasraNo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.KhasraDetails[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.KhasraDetails[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.KhasraDetails[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult toPostPropertyRegistrationDetail(java.lang.String villcode, java.lang.String khasrano, java.lang.String area, java.lang.String regno, java.util.Calendar regdate, java.lang.String regdoc, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToPostPropertyRegistrationDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {villcode, khasrano, area, regno, regdate, regdoc, deptid, key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetailResponseToPostPropertyRegistrationOwnerDetailResult toPostPropertyRegistrationOwnerDetail(java.lang.String villcode, java.lang.String khasrano, java.lang.String ocdname, java.lang.String ocdname1, java.lang.String oFather, java.lang.String oFather1, java.lang.String gender, java.lang.String ocaste, java.lang.String ocastenm, java.lang.String oaddress, java.lang.String aadharNo, java.lang.String mobileNo, java.lang.String loanBook, java.lang.String regno, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToPostPropertyRegistrationOwnerDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationOwnerDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {villcode, khasrano, ocdname, ocdname1, oFather, oFather1, gender, ocaste, ocastenm, oaddress, aadharNo, mobileNo, loanBook, regno, deptid, key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetailResponseToPostPropertyRegistrationOwnerDetailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetailResponseToPostPropertyRegistrationOwnerDetailResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetailResponseToPostPropertyRegistrationOwnerDetailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult toPostPropertyRegistrationOwnerDetail_Tocheck(java.lang.String villcode, java.lang.String khasrano, java.lang.String ocdname, java.lang.String ocdname1, java.lang.String oFather, java.lang.String oFather1, java.lang.String gender, java.lang.String ocaste, java.lang.String ocastenm, java.lang.String oaddress, java.lang.String mobileNo, java.lang.String aadharNo, java.lang.String loanBook, java.lang.String regno, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToPostPropertyRegistrationOwnerDetail_Tocheck");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationOwnerDetail_Tocheck"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {villcode, khasrano, ocdname, ocdname1, oFather, oFather1, gender, ocaste, ocastenm, oaddress, mobileNo, aadharNo, loanBook, regno, deptid, key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult toPostPropertyRegistrationVikretaDetail(java.lang.String villcode, java.lang.String khasrano, java.lang.String ocdname, java.lang.String ocdname1, java.lang.String oFather, java.lang.String oFather1, java.lang.String gender, java.lang.String ocaste, java.lang.String ocastenm, java.lang.String oaddress, java.lang.String mobileNo, java.lang.String aadharNo, java.lang.String loanBook, java.lang.String regno, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToPostPropertyRegistrationVikretaDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationVikretaDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {villcode, khasrano, ocdname, ocdname1, oFather, oFather1, gender, ocaste, ocastenm, oaddress, mobileNo, aadharNo, loanBook, regno, deptid, key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.PlotDetails[] toGetNajoolDetails(java.lang.String plotno, java.lang.String recordcode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToGetNajoolDetails");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToGetNajoolDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {plotno, recordcode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.PlotDetails[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.PlotDetails[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.PlotDetails[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.DiversionPlotDetails[] toGetDiversionDetails(java.lang.String plotno, java.lang.String recordcode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToGetDiversionDetails");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToGetDiversionDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {plotno, recordcode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.DiversionPlotDetails[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.DiversionPlotDetails[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.DiversionPlotDetails[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.ToPostNajoolPropertyRegistrationDetailResponseToPostNajoolPropertyRegistrationDetailResult toPostNajoolPropertyRegistrationDetail(java.lang.String recordcode, java.lang.String plotno, java.lang.String area, java.lang.String taxfreeArea, java.lang.String basetax, java.lang.String baseenvtax, java.lang.String basedevtax, java.lang.String regno, java.util.Calendar regdate, java.lang.String regdoc, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToPostNajoolPropertyRegistrationDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostNajoolPropertyRegistrationDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {recordcode, plotno, area, taxfreeArea, basetax, baseenvtax, basedevtax, regno, regdate, regdoc, deptid, key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.ToPostNajoolPropertyRegistrationDetailResponseToPostNajoolPropertyRegistrationDetailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.ToPostNajoolPropertyRegistrationDetailResponseToPostNajoolPropertyRegistrationDetailResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.ToPostNajoolPropertyRegistrationDetailResponseToPostNajoolPropertyRegistrationDetailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult toPostNajoolPropertyRegistration_kretaDetails(java.lang.String recordcode, java.lang.String person_name, java.lang.String father_name, java.lang.String address, java.lang.String mobile_no, java.lang.String olast, java.lang.String pregNo, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToPostNajoolPropertyRegistration_kretaDetails");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostNajoolPropertyRegistration_kretaDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {recordcode, person_name, father_name, address, mobile_no, olast, pregNo, deptid, key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult toPostNajoolPropertyRegistration_VikretaDetails(java.lang.String recordcode, java.lang.String person_name, java.lang.String father_name, java.lang.String address, java.lang.String mobile_no, java.lang.String olast, java.lang.String pregNo, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToPostNajoolPropertyRegistration_VikretaDetails");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostNajoolPropertyRegistration_VikretaDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {recordcode, person_name, father_name, address, mobile_no, olast, pregNo, deptid, key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult toPostDiversionPropertyRegistrationDetail(java.lang.String recordcode, java.lang.String plotno, java.lang.String area, java.lang.String taxfreeArea, java.lang.String basetax, java.lang.String baseenvtax, java.lang.String basedevtax, java.lang.String regno, java.util.Calendar regdate, java.lang.String regdoc, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToPostDiversionPropertyRegistrationDetail");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostDiversionPropertyRegistrationDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {recordcode, plotno, area, taxfreeArea, basetax, baseenvtax, basedevtax, regno, regdate, regdoc, deptid, key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult toPostDiversionPropertyRegistration_kretaDetails(java.lang.String recordcode, java.lang.String person_name, java.lang.String father_name, java.lang.String address, java.lang.String mobile_no, java.lang.String olast, java.lang.String pregNo, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToPostDiversionPropertyRegistration_kretaDetails");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostDiversionPropertyRegistration_kretaDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {recordcode, person_name, father_name, address, mobile_no, olast, pregNo, deptid, key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult toPostDiversionPropertyRegistration_VikretaDetails(java.lang.String recordcode, java.lang.String person_name, java.lang.String father_name, java.lang.String address, java.lang.String mobile_no, java.lang.String olast, java.lang.String pregNo, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://bhuiyan.cg.nic.in/ToPostDiversionPropertyRegistration_VikretaDetails");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostDiversionPropertyRegistration_VikretaDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {recordcode, person_name, father_name, address, mobile_no, olast, pregNo, deptid, key});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
