/**
 * ToGetDiversionDetailsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToGetDiversionDetailsResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.DiversionPlotDetails[] toGetDiversionDetailsResult;

    public ToGetDiversionDetailsResponse() {
    }

    public ToGetDiversionDetailsResponse(
           com.igr.webservice.LR.DiversionPlotDetails[] toGetDiversionDetailsResult) {
           this.toGetDiversionDetailsResult = toGetDiversionDetailsResult;
    }


    /**
     * Gets the toGetDiversionDetailsResult value for this ToGetDiversionDetailsResponse.
     * 
     * @return toGetDiversionDetailsResult
     */
    public com.igr.webservice.LR.DiversionPlotDetails[] getToGetDiversionDetailsResult() {
        return toGetDiversionDetailsResult;
    }


    /**
     * Sets the toGetDiversionDetailsResult value for this ToGetDiversionDetailsResponse.
     * 
     * @param toGetDiversionDetailsResult
     */
    public void setToGetDiversionDetailsResult(com.igr.webservice.LR.DiversionPlotDetails[] toGetDiversionDetailsResult) {
        this.toGetDiversionDetailsResult = toGetDiversionDetailsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToGetDiversionDetailsResponse)) return false;
        ToGetDiversionDetailsResponse other = (ToGetDiversionDetailsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.toGetDiversionDetailsResult==null && other.getToGetDiversionDetailsResult()==null) || 
             (this.toGetDiversionDetailsResult!=null &&
              java.util.Arrays.equals(this.toGetDiversionDetailsResult, other.getToGetDiversionDetailsResult())));
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
        if (getToGetDiversionDetailsResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getToGetDiversionDetailsResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getToGetDiversionDetailsResult(), i);
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
        new org.apache.axis.description.TypeDesc(ToGetDiversionDetailsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToGetDiversionDetailsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toGetDiversionDetailsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ToGetDiversionDetailsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionPlotDetails"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionPlotDetails"));
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
