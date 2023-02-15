/**
 * ToPostPropertyRegistrationDetailResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToPostPropertyRegistrationDetailResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult toPostPropertyRegistrationDetailResult;

    public ToPostPropertyRegistrationDetailResponse() {
    }

    public ToPostPropertyRegistrationDetailResponse(
           com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult toPostPropertyRegistrationDetailResult) {
           this.toPostPropertyRegistrationDetailResult = toPostPropertyRegistrationDetailResult;
    }


    /**
     * Gets the toPostPropertyRegistrationDetailResult value for this ToPostPropertyRegistrationDetailResponse.
     * 
     * @return toPostPropertyRegistrationDetailResult
     */
    public com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult getToPostPropertyRegistrationDetailResult() {
        return toPostPropertyRegistrationDetailResult;
    }


    /**
     * Sets the toPostPropertyRegistrationDetailResult value for this ToPostPropertyRegistrationDetailResponse.
     * 
     * @param toPostPropertyRegistrationDetailResult
     */
    public void setToPostPropertyRegistrationDetailResult(com.igr.webservice.LR.ToPostPropertyRegistrationDetailResponseToPostPropertyRegistrationDetailResult toPostPropertyRegistrationDetailResult) {
        this.toPostPropertyRegistrationDetailResult = toPostPropertyRegistrationDetailResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToPostPropertyRegistrationDetailResponse)) return false;
        ToPostPropertyRegistrationDetailResponse other = (ToPostPropertyRegistrationDetailResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.toPostPropertyRegistrationDetailResult==null && other.getToPostPropertyRegistrationDetailResult()==null) || 
             (this.toPostPropertyRegistrationDetailResult!=null &&
              this.toPostPropertyRegistrationDetailResult.equals(other.getToPostPropertyRegistrationDetailResult())));
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
        if (getToPostPropertyRegistrationDetailResult() != null) {
            _hashCode += getToPostPropertyRegistrationDetailResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToPostPropertyRegistrationDetailResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationDetailResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toPostPropertyRegistrationDetailResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationDetailResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationDetailResponse>ToPostPropertyRegistrationDetailResult"));
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
