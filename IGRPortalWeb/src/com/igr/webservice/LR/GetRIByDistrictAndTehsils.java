/**
 * GetRIByDistrictAndTehsils.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class GetRIByDistrictAndTehsils  implements java.io.Serializable {
    private java.lang.String distno;

    private java.lang.String tehsilno;

    public GetRIByDistrictAndTehsils() {
    }

    public GetRIByDistrictAndTehsils(
           java.lang.String distno,
           java.lang.String tehsilno) {
           this.distno = distno;
           this.tehsilno = tehsilno;
    }


    /**
     * Gets the distno value for this GetRIByDistrictAndTehsils.
     * 
     * @return distno
     */
    public java.lang.String getDistno() {
        return distno;
    }


    /**
     * Sets the distno value for this GetRIByDistrictAndTehsils.
     * 
     * @param distno
     */
    public void setDistno(java.lang.String distno) {
        this.distno = distno;
    }


    /**
     * Gets the tehsilno value for this GetRIByDistrictAndTehsils.
     * 
     * @return tehsilno
     */
    public java.lang.String getTehsilno() {
        return tehsilno;
    }


    /**
     * Sets the tehsilno value for this GetRIByDistrictAndTehsils.
     * 
     * @param tehsilno
     */
    public void setTehsilno(java.lang.String tehsilno) {
        this.tehsilno = tehsilno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRIByDistrictAndTehsils)) return false;
        GetRIByDistrictAndTehsils other = (GetRIByDistrictAndTehsils) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.distno==null && other.getDistno()==null) || 
             (this.distno!=null &&
              this.distno.equals(other.getDistno()))) &&
            ((this.tehsilno==null && other.getTehsilno()==null) || 
             (this.tehsilno!=null &&
              this.tehsilno.equals(other.getTehsilno())));
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
        if (getDistno() != null) {
            _hashCode += getDistno().hashCode();
        }
        if (getTehsilno() != null) {
            _hashCode += getTehsilno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRIByDistrictAndTehsils.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">GetRIByDistrictAndTehsils"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Distno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tehsilno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Tehsilno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
