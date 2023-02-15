/**
 * WebServiceForRegistrationDeptNewLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class WebServiceForRegistrationDeptNewLocator extends org.apache.axis.client.Service implements com.igr.webservice.LR.WebServiceForRegistrationDeptNew {

    public WebServiceForRegistrationDeptNewLocator() {
    }


    public WebServiceForRegistrationDeptNewLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebServiceForRegistrationDeptNewLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebServiceForRegistrationDeptNewSoap12
    private java.lang.String WebServiceForRegistrationDeptNewSoap12_address = "https://bhuiyan.cg.nic.in/WebServiceForRegistrationDeptNew.asmx";

    public java.lang.String getWebServiceForRegistrationDeptNewSoap12Address() {
        return WebServiceForRegistrationDeptNewSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebServiceForRegistrationDeptNewSoap12WSDDServiceName = "WebServiceForRegistrationDeptNewSoap12";

    public java.lang.String getWebServiceForRegistrationDeptNewSoap12WSDDServiceName() {
        return WebServiceForRegistrationDeptNewSoap12WSDDServiceName;
    }

    public void setWebServiceForRegistrationDeptNewSoap12WSDDServiceName(java.lang.String name) {
        WebServiceForRegistrationDeptNewSoap12WSDDServiceName = name;
    }

    public com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap getWebServiceForRegistrationDeptNewSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebServiceForRegistrationDeptNewSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebServiceForRegistrationDeptNewSoap12(endpoint);
    }

    public com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap getWebServiceForRegistrationDeptNewSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap12Stub _stub = new com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap12Stub(portAddress, this);
            _stub.setPortName(getWebServiceForRegistrationDeptNewSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebServiceForRegistrationDeptNewSoap12EndpointAddress(java.lang.String address) {
        WebServiceForRegistrationDeptNewSoap12_address = address;
    }


    // Use to get a proxy class for WebServiceForRegistrationDeptNewSoap
    private java.lang.String WebServiceForRegistrationDeptNewSoap_address = "https://bhuiyan.cg.nic.in/WebServiceForRegistrationDeptNew.asmx";

    public java.lang.String getWebServiceForRegistrationDeptNewSoapAddress() {
        return WebServiceForRegistrationDeptNewSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebServiceForRegistrationDeptNewSoapWSDDServiceName = "WebServiceForRegistrationDeptNewSoap";

    public java.lang.String getWebServiceForRegistrationDeptNewSoapWSDDServiceName() {
        return WebServiceForRegistrationDeptNewSoapWSDDServiceName;
    }

    public void setWebServiceForRegistrationDeptNewSoapWSDDServiceName(java.lang.String name) {
        WebServiceForRegistrationDeptNewSoapWSDDServiceName = name;
    }

    public com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap getWebServiceForRegistrationDeptNewSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebServiceForRegistrationDeptNewSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebServiceForRegistrationDeptNewSoap(endpoint);
    }

    public com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap getWebServiceForRegistrationDeptNewSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoapStub _stub = new com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoapStub(portAddress, this);
            _stub.setPortName(getWebServiceForRegistrationDeptNewSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebServiceForRegistrationDeptNewSoapEndpointAddress(java.lang.String address) {
        WebServiceForRegistrationDeptNewSoap_address = address;
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
            if (com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap12Stub _stub = new com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap12Stub(new java.net.URL(WebServiceForRegistrationDeptNewSoap12_address), this);
                _stub.setPortName(getWebServiceForRegistrationDeptNewSoap12WSDDServiceName());
                return _stub;
            }
            if (com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoapStub _stub = new com.igr.webservice.LR.WebServiceForRegistrationDeptNewSoapStub(new java.net.URL(WebServiceForRegistrationDeptNewSoap_address), this);
                _stub.setPortName(getWebServiceForRegistrationDeptNewSoapWSDDServiceName());
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
        if ("WebServiceForRegistrationDeptNewSoap12".equals(inputPortName)) {
            return getWebServiceForRegistrationDeptNewSoap12();
        }
        else if ("WebServiceForRegistrationDeptNewSoap".equals(inputPortName)) {
            return getWebServiceForRegistrationDeptNewSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "WebServiceForRegistrationDeptNew");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "WebServiceForRegistrationDeptNewSoap12"));
            ports.add(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "WebServiceForRegistrationDeptNewSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebServiceForRegistrationDeptNewSoap12".equals(portName)) {
            setWebServiceForRegistrationDeptNewSoap12EndpointAddress(address);
        }
        else 
if ("WebServiceForRegistrationDeptNewSoap".equals(portName)) {
            setWebServiceForRegistrationDeptNewSoapEndpointAddress(address);
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
