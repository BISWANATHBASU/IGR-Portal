/**
 * ToGetDataofKhasraResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToGetDataofKhasraResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.KhasraDetails[] toGetDataofKhasraResult;

    public ToGetDataofKhasraResponse() {
    }

    public ToGetDataofKhasraResponse(
           com.igr.webservice.LR.KhasraDetails[] toGetDataofKhasraResult) {
           this.toGetDataofKhasraResult = toGetDataofKhasraResult;
    }


    /**
     * Gets the toGetDataofKhasraResult value for this ToGetDataofKhasraResponse.
     * 
     * @return toGetDataofKhasraResult
     */
    public com.igr.webservice.LR.KhasraDetails[] getToGetDataofKhasraResult() {
        return toGetDataofKhasraResult;
    }


    /**
     * Sets the toGetDataofKhasraResult value for this ToGetDataofKhasraResponse.
     * 
     * @param toGetDataofKhasraResult
     */
    public void setToGetDataofKhasraResult(com.igr.webservice.LR.KhasraDetails[] toGetDataofKhasraResult) {
        this.toGetDataofKhasraResult = toGetDataofKhasraResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToGetDataofKhasraResponse)) return false;
        ToGetDataofKhasraResponse other = (ToGetDataofKhasraResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.toGetDataofKhasraResult==null && other.getToGetDataofKhasraResult()==null) || 
             (this.toGetDataofKhasraResult!=null &&
              java.util.Arrays.equals(this.toGetDataofKhasraResult, other.getToGetDataofKhasraResult())));
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
        if (getToGetDataofKhasraResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getToGetDataofKhasraResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getToGetDataofKhasraResult(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToGetDataofKhasraResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToGetDataofKhasraResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toGetDataofKhasraResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToGetDataofKhasraResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "KhasraDetails"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "KhasraDetails"));
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
