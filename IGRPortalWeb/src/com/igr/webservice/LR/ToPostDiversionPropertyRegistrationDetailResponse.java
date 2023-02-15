/**
 * ToPostDiversionPropertyRegistrationDetailResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToPostDiversionPropertyRegistrationDetailResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult toPostDiversionPropertyRegistrationDetailResult;

    public ToPostDiversionPropertyRegistrationDetailResponse() {
    }

    public ToPostDiversionPropertyRegistrationDetailResponse(
           com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult toPostDiversionPropertyRegistrationDetailResult) {
           this.toPostDiversionPropertyRegistrationDetailResult = toPostDiversionPropertyRegistrationDetailResult;
    }


    /**
     * Gets the toPostDiversionPropertyRegistrationDetailResult value for this ToPostDiversionPropertyRegistrationDetailResponse.
     * 
     * @return toPostDiversionPropertyRegistrationDetailResult
     */
    public com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult getToPostDiversionPropertyRegistrationDetailResult() {
        return toPostDiversionPropertyRegistrationDetailResult;
    }


    /**
     * Sets the toPostDiversionPropertyRegistrationDetailResult value for this ToPostDiversionPropertyRegistrationDetailResponse.
     * 
     * @param toPostDiversionPropertyRegistrationDetailResult
     */
    public void setToPostDiversionPropertyRegistrationDetailResult(com.igr.webservice.LR.ToPostDiversionPropertyRegistrationDetailResponseToPostDiversionPropertyRegistrationDetailResult toPostDiversionPropertyRegistrationDetailResult) {
        this.toPostDiversionPropertyRegistrationDetailResult = toPostDiversionPropertyRegistrationDetailResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToPostDiversionPropertyRegistrationDetailResponse)) return false;
        ToPostDiversionPropertyRegistrationDetailResponse other = (ToPostDiversionPropertyRegistrationDetailResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.toPostDiversionPropertyRegistrationDetailResult==null && other.getToPostDiversionPropertyRegistrationDetailResult()==null) || 
             (this.toPostDiversionPropertyRegistrationDetailResult!=null &&
              this.toPostDiversionPropertyRegistrationDetailResult.equals(other.getToPostDiversionPropertyRegistrationDetailResult())));
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
        if (getToPostDiversionPropertyRegistrationDetailResult() != null) {
            _hashCode += getToPostDiversionPropertyRegistrationDetailResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToPostDiversionPropertyRegistrationDetailResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostDiversionPropertyRegistrationDetailResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toPostDiversionPropertyRegistrationDetailResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostDiversionPropertyRegistrationDetailResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostDiversionPropertyRegistrationDetailResponse>ToPostDiversionPropertyRegistrationDetailResult"));
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
