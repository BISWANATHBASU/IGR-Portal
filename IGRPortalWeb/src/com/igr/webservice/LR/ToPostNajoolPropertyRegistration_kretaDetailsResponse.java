/**
 * ToPostNajoolPropertyRegistration_kretaDetailsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToPostNajoolPropertyRegistration_kretaDetailsResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult toPostNajoolPropertyRegistration_kretaDetailsResult;

    public ToPostNajoolPropertyRegistration_kretaDetailsResponse() {
    }

    public ToPostNajoolPropertyRegistration_kretaDetailsResponse(
           com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult toPostNajoolPropertyRegistration_kretaDetailsResult) {
           this.toPostNajoolPropertyRegistration_kretaDetailsResult = toPostNajoolPropertyRegistration_kretaDetailsResult;
    }


    /**
     * Gets the toPostNajoolPropertyRegistration_kretaDetailsResult value for this ToPostNajoolPropertyRegistration_kretaDetailsResponse.
     * 
     * @return toPostNajoolPropertyRegistration_kretaDetailsResult
     */
    public com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult getToPostNajoolPropertyRegistration_kretaDetailsResult() {
        return toPostNajoolPropertyRegistration_kretaDetailsResult;
    }


    /**
     * Sets the toPostNajoolPropertyRegistration_kretaDetailsResult value for this ToPostNajoolPropertyRegistration_kretaDetailsResponse.
     * 
     * @param toPostNajoolPropertyRegistration_kretaDetailsResult
     */
    public void setToPostNajoolPropertyRegistration_kretaDetailsResult(com.igr.webservice.LR.ToPostNajoolPropertyRegistration_kretaDetailsResponseToPostNajoolPropertyRegistration_kretaDetailsResult toPostNajoolPropertyRegistration_kretaDetailsResult) {
        this.toPostNajoolPropertyRegistration_kretaDetailsResult = toPostNajoolPropertyRegistration_kretaDetailsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToPostNajoolPropertyRegistration_kretaDetailsResponse)) return false;
        ToPostNajoolPropertyRegistration_kretaDetailsResponse other = (ToPostNajoolPropertyRegistration_kretaDetailsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.toPostNajoolPropertyRegistration_kretaDetailsResult==null && other.getToPostNajoolPropertyRegistration_kretaDetailsResult()==null) || 
             (this.toPostNajoolPropertyRegistration_kretaDetailsResult!=null &&
              this.toPostNajoolPropertyRegistration_kretaDetailsResult.equals(other.getToPostNajoolPropertyRegistration_kretaDetailsResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getToPostNajoolPropertyRegistration_kretaDetailsResult() != null) {
            _hashCode += getToPostNajoolPropertyRegistration_kretaDetailsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToPostNajoolPropertyRegistration_kretaDetailsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostNajoolPropertyRegistration_kretaDetailsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toPostNajoolPropertyRegistration_kretaDetailsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostNajoolPropertyRegistration_kretaDetailsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostNajoolPropertyRegistration_kretaDetailsResponse>ToPostNajoolPropertyRegistration_kretaDetailsResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
