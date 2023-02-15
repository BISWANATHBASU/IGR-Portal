/**
 * ToPostPropertyRegistrationOwnerDetail_TocheckResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToPostPropertyRegistrationOwnerDetail_TocheckResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult toPostPropertyRegistrationOwnerDetail_TocheckResult;

    public ToPostPropertyRegistrationOwnerDetail_TocheckResponse() {
    }

    public ToPostPropertyRegistrationOwnerDetail_TocheckResponse(
           com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult toPostPropertyRegistrationOwnerDetail_TocheckResult) {
           this.toPostPropertyRegistrationOwnerDetail_TocheckResult = toPostPropertyRegistrationOwnerDetail_TocheckResult;
    }


    /**
     * Gets the toPostPropertyRegistrationOwnerDetail_TocheckResult value for this ToPostPropertyRegistrationOwnerDetail_TocheckResponse.
     * 
     * @return toPostPropertyRegistrationOwnerDetail_TocheckResult
     */
    public com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult getToPostPropertyRegistrationOwnerDetail_TocheckResult() {
        return toPostPropertyRegistrationOwnerDetail_TocheckResult;
    }


    /**
     * Sets the toPostPropertyRegistrationOwnerDetail_TocheckResult value for this ToPostPropertyRegistrationOwnerDetail_TocheckResponse.
     * 
     * @param toPostPropertyRegistrationOwnerDetail_TocheckResult
     */
    public void setToPostPropertyRegistrationOwnerDetail_TocheckResult(com.igr.webservice.LR.ToPostPropertyRegistrationOwnerDetail_TocheckResponseToPostPropertyRegistrationOwnerDetail_TocheckResult toPostPropertyRegistrationOwnerDetail_TocheckResult) {
        this.toPostPropertyRegistrationOwnerDetail_TocheckResult = toPostPropertyRegistrationOwnerDetail_TocheckResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToPostPropertyRegistrationOwnerDetail_TocheckResponse)) return false;
        ToPostPropertyRegistrationOwnerDetail_TocheckResponse other = (ToPostPropertyRegistrationOwnerDetail_TocheckResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.toPostPropertyRegistrationOwnerDetail_TocheckResult==null && other.getToPostPropertyRegistrationOwnerDetail_TocheckResult()==null) || 
             (this.toPostPropertyRegistrationOwnerDetail_TocheckResult!=null &&
              this.toPostPropertyRegistrationOwnerDetail_TocheckResult.equals(other.getToPostPropertyRegistrationOwnerDetail_TocheckResult())));
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
        if (getToPostPropertyRegistrationOwnerDetail_TocheckResult() != null) {
            _hashCode += getToPostPropertyRegistrationOwnerDetail_TocheckResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToPostPropertyRegistrationOwnerDetail_TocheckResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationOwnerDetail_TocheckResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toPostPropertyRegistrationOwnerDetail_TocheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToPostPropertyRegistrationOwnerDetail_TocheckResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>ToPostPropertyRegistrationOwnerDetail_TocheckResponse>ToPostPropertyRegistrationOwnerDetail_TocheckResult"));
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
