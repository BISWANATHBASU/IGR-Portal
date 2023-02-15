/**
 * WebServiceForRegistrationDeptNewSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public interface WebServiceForRegistrationDeptNewSoap extends java.rmi.Remote {
    public com.igr.webservice.LR.GetDistrictDetailResponseGetDistrictDetailResult getDistrictDetail() throws java.rmi.RemoteException;
    public com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult getTehsilByDistrict(java.lang.String distno) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.GetRIByDistrictAndTehsilsResponseGetRIByDistrictAndTehsilsResult getRIByDistrictAndTehsils(java.lang.String distno, java.lang.String tehsilno) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.GetVillageCodeResponseGetVillageCodeResult getVillageCode(java.lang.String distno, java.lang.String tehsilno, java.lang.String rino) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.KhasraDetails[] toGetDataofKhasra(java.lang.String districtno, java.lang.String tehsilno, java.lang.String rino, java.lang.String villageno, java.lang.String khasraNo) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult toPostPropertyRegistrationDetail(java.lang.String villcode, java.lang.String khasrano, java.lang.String area, java.lang.String regno, java.util.Calendar regdate, java.lang.String regdoc, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetailResponseToPostPropertyRegistrationOwnerDetailResult toPostPropertyRegistrationOwnerDetail(java.lang.String villcode, java.lang.String khasrano, java.lang.String ocdname, java.lang.String ocdname1, java.lang.String oFather, java.lang.String oFather1, java.lang.String gender, java.lang.String ocaste, java.lang.String ocastenm, java.lang.String oaddress, java.lang.String aadharNo, java.lang.String mobileNo, java.lang.String loanBook, java.lang.String regno, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult toPostPropertyRegistrationOwnerDetail_Tocheck(java.lang.String villcode, java.lang.String khasrano, java.lang.String ocdname, java.lang.String ocdname1, java.lang.String oFather, java.lang.String oFather1, java.lang.String gender, java.lang.String ocaste, java.lang.String ocastenm, java.lang.String oaddress, java.lang.String mobileNo, java.lang.String aadharNo, java.lang.String loanBook, java.lang.String regno, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult toPostPropertyRegistrationVikretaDetail(java.lang.String villcode, java.lang.String khasrano, java.lang.String ocdname, java.lang.String ocdname1, java.lang.String oFather, java.lang.String oFather1, java.lang.String gender, java.lang.String ocaste, java.lang.String ocastenm, java.lang.String oaddress, java.lang.String mobileNo, java.lang.String aadharNo, java.lang.String loanBook, java.lang.String regno, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.PlotDetails[] toGetNajoolDetails(java.lang.String plotno, java.lang.String recordcode) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.DiversionPlotDetails[] toGetDiversionDetails(java.lang.String plotno, java.lang.String recordcode) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.ToPostNajoolPropertyRegistrationDetailResponseToPostNajoolPropertyRegistrationDetailResult toPostNajoolPropertyRegistrationDetail(java.lang.String recordcode, java.lang.String plotno, java.lang.String area, java.lang.String taxfreeArea, java.lang.String basetax, java.lang.String baseenvtax, java.lang.String basedevtax, java.lang.String regno, java.util.Calendar regdate, java.lang.String regdoc, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult toPostNajoolPropertyRegistration_kretaDetails(java.lang.String recordcode, java.lang.String person_name, java.lang.String father_name, java.lang.String address, java.lang.String mobile_no, java.lang.String olast, java.lang.String pregNo, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult toPostNajoolPropertyRegistration_VikretaDetails(java.lang.String recordcode, java.lang.String person_name, java.lang.String father_name, java.lang.String address, java.lang.String mobile_no, java.lang.String olast, java.lang.String pregNo, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult toPostDiversionPropertyRegistrationDetail(java.lang.String recordcode, java.lang.String plotno, java.lang.String area, java.lang.String taxfreeArea, java.lang.String basetax, java.lang.String baseenvtax, java.lang.String basedevtax, java.lang.String regno, java.util.Calendar regdate, java.lang.String regdoc, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult toPostDiversionPropertyRegistration_kretaDetails(java.lang.String recordcode, java.lang.String person_name, java.lang.String father_name, java.lang.String address, java.lang.String mobile_no, java.lang.String olast, java.lang.String pregNo, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException;
    public com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult toPostDiversionPropertyRegistration_VikretaDetails(java.lang.String recordcode, java.lang.String person_name, java.lang.String father_name, java.lang.String address, java.lang.String mobile_no, java.lang.String olast, java.lang.String pregNo, java.lang.String deptid, java.lang.String key) throws java.rmi.RemoteException;
}
