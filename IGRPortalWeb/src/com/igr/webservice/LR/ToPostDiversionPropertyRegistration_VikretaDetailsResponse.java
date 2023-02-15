/**
 * ToPostDiversionPropertyRegistration_VikretaDetailsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToPostDiversionPropertyRegistration_VikretaDetailsResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult toPostDiversionPropertyRegistration_VikretaDetailsResult;

    public ToPostDiversionPropertyRegistration_VikretaDetailsResponse() {
    }

    public ToPostDiversionPropertyRegistration_VikretaDetailsResponse(
           com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult toPostDiversionPropertyRegistration_VikretaDetailsResult) {
           this.toPostDiversionPropertyRegistration_VikretaDetailsResult = toPostDiversionPropertyRegistration_VikretaDetailsResult;
    }


    /**
     * Gets the toPostDiversionPropertyRegistration_VikretaDetailsResult value for this ToPostDiversionPropertyRegistration_VikretaDetailsResponse.
     * 
     * @return toPostDiversionPropertyRegistration_VikretaDetailsResult
     */
    public com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult getToPostDiversionPropertyRegistration_VikretaDetailsResult() {
        return toPostDiversionPropertyRegistration_VikretaDetailsResult;
    }


    /**
     * Sets the toPostDiversionPropertyRegistration_VikretaDetailsResult value for this ToPostDiversionPropertyRegistration_VikretaDetailsResponse.
     * 
     * @param toPostDiversionPropertyRegistration_VikretaDetailsResult
     */
    public void setToPostDiversionPropertyRegistration_VikretaDetailsResult(com.igr.webservice.LR.ToPostDiversionPropertyRegistration_VikretaDetailsResponseToPostDiversionPropertyRegistration_VikretaDetailsResult toPostDiversionPropertyRegistration_VikretaDetailsResult) {
        this.toPostDiversionPropertyRegistration_VikretaDetailsResult = toPostDiversionPropertyRegistration_VikretaDetailsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToPostDiversionPropertyRegistration_VikretaDetailsResponse)) return false;
        ToPostDiversionPropertyRegistration_VikretaDetailsResponse other = (ToPostDiversionPropertyRegistration_VikretaDetailsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.toPostDiversionPropertyRegistration_VikretaDetailsResult==null && other.getToPostDiversionPropertyRegistration_VikretaDetailsResult()==null) || 
             (this.toPostDiversionPropertyRegistration_VikretaDetailsResult!=null &&
              this.toPostDiversionPropertyRegistration_VikretaDetailsResult.equals(other.getToPostDiversionPropertyRegistration_VikretaDetailsResult())));
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
        if (getToPostDiversionPropertyRegistration_VikretaDetailsResult() != null) {
            _hashCode += getToPostDiversionPropertyRegistration_VikretaDetailsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToPostDiversionPropertyRegistration_VikretaDetailsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostDiversionPropertyRegistration_VikretaDetailsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toPostDiversionPropertyRegistration_VikretaDetailsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostDiversionPropertyRegistration_VikretaDetailsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostDiversionPropertyRegistration_VikretaDetailsResponse>ToPostDiversionPropertyRegistration_VikretaDetailsResult"));
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
