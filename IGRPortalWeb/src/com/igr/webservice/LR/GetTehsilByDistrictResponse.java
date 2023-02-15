/**
 * GetTehsilByDistrictResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class GetTehsilByDistrictResponse  implements java.io.Serializable {
    private com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult getTehsilByDistrictResult;

    public GetTehsilByDistrictResponse() {
    }

    public GetTehsilByDistrictResponse(
           com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult getTehsilByDistrictResult) {
           this.getTehsilByDistrictResult = getTehsilByDistrictResult;
    }


    /**
     * Gets the getTehsilByDistrictResult value for this GetTehsilByDistrictResponse.
     * 
     * @return getTehsilByDistrictResult
     */
    public com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult getGetTehsilByDistrictResult() {
        return getTehsilByDistrictResult;
    }


    /**
     * Sets the getTehsilByDistrictResult value for this GetTehsilByDistrictResponse.
     * 
     * @param getTehsilByDistrictResult
     */
    public void setGetTehsilByDistrictResult(com.igr.webservice.LR.GetTehsilByDistrictResponseGetTehsilByDistrictResult getTehsilByDistrictResult) {
        this.getTehsilByDistrictResult = getTehsilByDistrictResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTehsilByDistrictResponse)) return false;
        GetTehsilByDistrictResponse other = (GetTehsilByDistrictResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getTehsilByDistrictResult==null && other.getGetTehsilByDistrictResult()==null) || 
             (this.getTehsilByDistrictResult!=null &&
              this.getTehsilByDistrictResult.equals(other.getGetTehsilByDistrictResult())));
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
        if (getGetTehsilByDistrictResult() != null) {
            _hashCode += getGetTehsilByDistrictResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTehsilByDistrictResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">GetTehsilByDistrictResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getTehsilByDistrictResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "GetTehsilByDistrictResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">>GetTehsilByDistrictResponse>GetTehsilByDistrictResult"));
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
