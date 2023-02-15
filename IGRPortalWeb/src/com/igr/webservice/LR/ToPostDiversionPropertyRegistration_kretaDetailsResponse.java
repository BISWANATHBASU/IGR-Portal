/**
 * ToPostDiversionPropertyRegistration_kretaDetailsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToPostDiversionPropertyRegistration_kretaDetailsResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult toPostDiversionPropertyRegistration_kretaDetailsResult;

    public ToPostDiversionPropertyRegistration_kretaDetailsResponse() {
    }

    public ToPostDiversionPropertyRegistration_kretaDetailsResponse(
           com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult toPostDiversionPropertyRegistration_kretaDetailsResult) {
           this.toPostDiversionPropertyRegistration_kretaDetailsResult = toPostDiversionPropertyRegistration_kretaDetailsResult;
    }


    /**
     * Gets the toPostDiversionPropertyRegistration_kretaDetailsResult value for this ToPostDiversionPropertyRegistration_kretaDetailsResponse.
     * 
     * @return toPostDiversionPropertyRegistration_kretaDetailsResult
     */
    public com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult getToPostDiversionPropertyRegistration_kretaDetailsResult() {
        return toPostDiversionPropertyRegistration_kretaDetailsResult;
    }


    /**
     * Sets the toPostDiversionPropertyRegistration_kretaDetailsResult value for this ToPostDiversionPropertyRegistration_kretaDetailsResponse.
     * 
     * @param toPostDiversionPropertyRegistration_kretaDetailsResult
     */
    public void setToPostDiversionPropertyRegistration_kretaDetailsResult(com.igr.webservice.LR.ToPostDiversionPropertyRegistration_kretaDetailsResponseToPostDiversionPropertyRegistration_kretaDetailsResult toPostDiversionPropertyRegistration_kretaDetailsResult) {
        this.toPostDiversionPropertyRegistration_kretaDetailsResult = toPostDiversionPropertyRegistration_kretaDetailsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToPostDiversionPropertyRegistration_kretaDetailsResponse)) return false;
        ToPostDiversionPropertyRegistration_kretaDetailsResponse other = (ToPostDiversionPropertyRegistration_kretaDetailsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.toPostDiversionPropertyRegistration_kretaDetailsResult==null && other.getToPostDiversionPropertyRegistration_kretaDetailsResult()==null) || 
             (this.toPostDiversionPropertyRegistration_kretaDetailsResult!=null &&
              this.toPostDiversionPropertyRegistration_kretaDetailsResult.equals(other.getToPostDiversionPropertyRegistration_kretaDetailsResult())));
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
        if (getToPostDiversionPropertyRegistration_kretaDetailsResult() != null) {
            _hashCode += getToPostDiversionPropertyRegistration_kretaDetailsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToPostDiversionPropertyRegistration_kretaDetailsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostDiversionPropertyRegistration_kretaDetailsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toPostDiversionPropertyRegistration_kretaDetailsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostDiversionPropertyRegistration_kretaDetailsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostDiversionPropertyRegistration_kretaDetailsResponse>ToPostDiversionPropertyRegistration_kretaDetailsResult"));
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
