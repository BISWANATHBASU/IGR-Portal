/**
 * ToPostNajoolPropertyRegistration_VikretaDetailsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToPostNajoolPropertyRegistration_VikretaDetailsResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult toPostNajoolPropertyRegistration_VikretaDetailsResult;

    public ToPostNajoolPropertyRegistration_VikretaDetailsResponse() {
    }

    public ToPostNajoolPropertyRegistration_VikretaDetailsResponse(
           com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult toPostNajoolPropertyRegistration_VikretaDetailsResult) {
           this.toPostNajoolPropertyRegistration_VikretaDetailsResult = toPostNajoolPropertyRegistration_VikretaDetailsResult;
    }


    /**
     * Gets the toPostNajoolPropertyRegistration_VikretaDetailsResult value for this ToPostNajoolPropertyRegistration_VikretaDetailsResponse.
     * 
     * @return toPostNajoolPropertyRegistration_VikretaDetailsResult
     */
    public com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult getToPostNajoolPropertyRegistration_VikretaDetailsResult() {
        return toPostNajoolPropertyRegistration_VikretaDetailsResult;
    }


    /**
     * Sets the toPostNajoolPropertyRegistration_VikretaDetailsResult value for this ToPostNajoolPropertyRegistration_VikretaDetailsResponse.
     * 
     * @param toPostNajoolPropertyRegistration_VikretaDetailsResult
     */
    public void setToPostNajoolPropertyRegistration_VikretaDetailsResult(com.igr.webservice.LR.ToPostNajoolPropertyRegistration_VikretaDetailsResponseToPostNajoolPropertyRegistration_VikretaDetailsResult toPostNajoolPropertyRegistration_VikretaDetailsResult) {
        this.toPostNajoolPropertyRegistration_VikretaDetailsResult = toPostNajoolPropertyRegistration_VikretaDetailsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToPostNajoolPropertyRegistration_VikretaDetailsResponse)) return false;
        ToPostNajoolPropertyRegistration_VikretaDetailsResponse other = (ToPostNajoolPropertyRegistration_VikretaDetailsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.toPostNajoolPropertyRegistration_VikretaDetailsResult==null && other.getToPostNajoolPropertyRegistration_VikretaDetailsResult()==null) || 
             (this.toPostNajoolPropertyRegistration_VikretaDetailsResult!=null &&
              this.toPostNajoolPropertyRegistration_VikretaDetailsResult.equals(other.getToPostNajoolPropertyRegistration_VikretaDetailsResult())));
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
        if (getToPostNajoolPropertyRegistration_VikretaDetailsResult() != null) {
            _hashCode += getToPostNajoolPropertyRegistration_VikretaDetailsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToPostNajoolPropertyRegistration_VikretaDetailsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostNajoolPropertyRegistration_VikretaDetailsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toPostNajoolPropertyRegistration_VikretaDetailsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostNajoolPropertyRegistration_VikretaDetailsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostNajoolPropertyRegistration_VikretaDetailsResponse>ToPostNajoolPropertyRegistration_VikretaDetailsResult"));
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
