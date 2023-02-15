/**
 * ToPostPropertyRegistrationVikretaDetailResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToPostPropertyRegistrationVikretaDetailResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult toPostPropertyRegistrationVikretaDetailResult;

    public ToPostPropertyRegistrationVikretaDetailResponse() {
    }

    public ToPostPropertyRegistrationVikretaDetailResponse(
           com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult toPostPropertyRegistrationVikretaDetailResult) {
           this.toPostPropertyRegistrationVikretaDetailResult = toPostPropertyRegistrationVikretaDetailResult;
    }


    /**
     * Gets the toPostPropertyRegistrationVikretaDetailResult value for this ToPostPropertyRegistrationVikretaDetailResponse.
     * 
     * @return toPostPropertyRegistrationVikretaDetailResult
     */
    public com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult getToPostPropertyRegistrationVikretaDetailResult() {
        return toPostPropertyRegistrationVikretaDetailResult;
    }


    /**
     * Sets the toPostPropertyRegistrationVikretaDetailResult value for this ToPostPropertyRegistrationVikretaDetailResponse.
     * 
     * @param toPostPropertyRegistrationVikretaDetailResult
     */
    public void setToPostPropertyRegistrationVikretaDetailResult(com.igr.webservice.LR.ToPostPropertyRegistrationVikretaDetailResponseToPostPropertyRegistrationVikretaDetailResult toPostPropertyRegistrationVikretaDetailResult) {
        this.toPostPropertyRegistrationVikretaDetailResult = toPostPropertyRegistrationVikretaDetailResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToPostPropertyRegistrationVikretaDetailResponse)) return false;
        ToPostPropertyRegistrationVikretaDetailResponse other = (ToPostPropertyRegistrationVikretaDetailResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.toPostPropertyRegistrationVikretaDetailResult==null && other.getToPostPropertyRegistrationVikretaDetailResult()==null) || 
             (this.toPostPropertyRegistrationVikretaDetailResult!=null &&
              this.toPostPropertyRegistrationVikretaDetailResult.equals(other.getToPostPropertyRegistrationVikretaDetailResult())));
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
        if (getToPostPropertyRegistrationVikretaDetailResult() != null) {
            _hashCode += getToPostPropertyRegistrationVikretaDetailResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToPostPropertyRegistrationVikretaDetailResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationVikretaDetailResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toPostPropertyRegistrationVikretaDetailResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationVikretaDetailResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationVikretaDetailResponse>ToPostPropertyRegistrationVikretaDetailResult"));
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
