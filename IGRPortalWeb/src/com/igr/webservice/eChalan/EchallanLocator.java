/**
 * EchallanLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.eChalan;

public class EchallanLocator extends org.apache.axis.client.Service implements com.igr.webservice.eChalan.Echallan {

    public EchallanLocator() {
    }


    public EchallanLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EchallanLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for echallanSoap12
    private java.lang.String echallanSoap12_address = "https://ekoshonline.cg.nic.in/echws/echallan.asmx";

    public java.lang.String getechallanSoap12Address() {
        return echallanSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String echallanSoap12WSDDServiceName = "echallanSoap12";

    public java.lang.String getechallanSoap12WSDDServiceName() {
        return echallanSoap12WSDDServiceName;
    }

    public void setechallanSoap12WSDDServiceName(java.lang.String name) {
        echallanSoap12WSDDServiceName = name;
    }

    public com.igr.webservice.eChalan.EchallanSoap getechallanSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(echallanSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getechallanSoap12(endpoint);
    }

    public com.igr.webservice.eChalan.EchallanSoap getechallanSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.igr.webservice.eChalan.EchallanSoap12Stub _stub = new com.igr.webservice.eChalan.EchallanSoap12Stub(portAddress, this);
            _stub.setPortName(getechallanSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setechallanSoap12EndpointAddress(java.lang.String address) {
        echallanSoap12_address = address;
    }


    // Use to get a proxy class for echallanSoap
    private java.lang.String echallanSoap_address = "https://ekoshonline.cg.nic.in/echws/echallan.asmx";

    public java.lang.String getechallanSoapAddress() {
        return echallanSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String echallanSoapWSDDServiceName = "echallanSoap";

    public java.lang.String getechallanSoapWSDDServiceName() {
        return echallanSoapWSDDServiceName;
    }

    public void setechallanSoapWSDDServiceName(java.lang.String name) {
        echallanSoapWSDDServiceName = name;
    }

    public com.igr.webservice.eChalan.EchallanSoap getechallanSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(echallanSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getechallanSoap(endpoint);
    }

    public com.igr.webservice.eChalan.EchallanSoap getechallanSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.igr.webservice.eChalan.EchallanSoapStub _stub = new com.igr.webservice.eChalan.EchallanSoapStub(portAddress, this);
            _stub.setPortName(getechallanSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setechallanSoapEndpointAddress(java.lang.String address) {
        echallanSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.igr.webservice.eChalan.EchallanSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.igr.webservice.eChalan.EchallanSoap12Stub _stub = new com.igr.webservice.eChalan.EchallanSoap12Stub(new java.net.URL(echallanSoap12_address), this);
                _stub.setPortName(getechallanSoap12WSDDServiceName());
                return _stub;
            }
            if (com.igr.webservice.eChalan.EchallanSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.igr.webservice.eChalan.EchallanSoapStub _stub = new com.igr.webservice.eChalan.EchallanSoapStub(new java.net.URL(echallanSoap_address), this);
                _stub.setPortName(getechallanSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("echallanSoap12".equals(inputPortName)) {
            return getechallanSoap12();
        }
        else if ("echallanSoap".equals(inputPortName)) {
            return getechallanSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "echallan");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "echallanSoap12"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "echallanSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("echallanSoap12".equals(portName)) {
            setechallanSoap12EndpointAddress(address);
        }
        else 
if ("echallanSoap".equals(portName)) {
            setechallanSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
