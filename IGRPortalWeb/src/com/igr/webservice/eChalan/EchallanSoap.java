/**
 * EchallanSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.eChalan;

public interface EchallanSoap extends java.rmi.Remote {
    public com.igr.webservice.eChalan.Echallan_DS eChallan_srv(java.lang.String tr_refno, java.lang.String dpt) throws java.rmi.RemoteException;
    public com.igr.webservice.eChalan.Echallan_DS eChallanex_srv(java.lang.String tr_refno, java.lang.String dpt) throws java.rmi.RemoteException;
    public com.igr.webservice.eChalan.Echallan_DS eChallandept_srv(java.lang.String tr_refno, java.lang.String dpt) throws java.rmi.RemoteException;
    public com.igr.webservice.eChalan.Echallan_DS eChallanapp_srv(java.lang.String tr_refno) throws java.rmi.RemoteException;
    public com.igr.webservice.eChalan.Echallan_Diffesh eChallandface_srv(java.lang.String tr_refno, java.lang.String dpt, java.lang.String service_no, java.lang.String auth) throws java.rmi.RemoteException;
}
