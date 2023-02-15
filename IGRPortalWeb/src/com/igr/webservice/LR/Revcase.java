/**
 * Revcase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class Revcase  implements java.io.Serializable {
    private java.lang.String revenueofficeName;

    private java.lang.String revenueCaseNo;

    public Revcase() {
    }

    public Revcase(
           java.lang.String revenueofficeName,
           java.lang.String revenueCaseNo) {
           this.revenueofficeName = revenueofficeName;
           this.revenueCaseNo = revenueCaseNo;
    }


    /**
     * Gets the revenueofficeName value for this Revcase.
     * 
     * @return revenueofficeName
     */
    public java.lang.String getRevenueofficeName() {
        return revenueofficeName;
    }


    /**
     * Sets the revenueofficeName value for this Revcase.
     * 
     * @param revenueofficeName
     */
    public void setRevenueofficeName(java.lang.String revenueofficeName) {
        this.revenueofficeName = revenueofficeName;
    }


    /**
     * Gets the revenueCaseNo value for this Revcase.
     * 
     * @return revenueCaseNo
     */
    public java.lang.String getRevenueCaseNo() {
        return revenueCaseNo;
    }


    /**
     * Sets the revenueCaseNo value for this Revcase.
     * 
     * @param revenueCaseNo
     */
    public void setRevenueCaseNo(java.lang.String revenueCaseNo) {
        this.revenueCaseNo = revenueCaseNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Revcase)) return false;
        Revcase other = (Revcase) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.revenueofficeName==null && other.getRevenueofficeName()==null) || 
             (this.revenueofficeName!=null &&
              this.revenueofficeName.equals(other.getRevenueofficeName()))) &&
            ((this.revenueCaseNo==null && other.getRevenueCaseNo()==null) || 
             (this.revenueCaseNo!=null &&
              this.revenueCaseNo.equals(other.getRevenueCaseNo())));
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
        if (getRevenueofficeName() != null) {
            _hashCode += getRevenueofficeName().hashCode();
        }
        if (getRevenueCaseNo() != null) {
            _hashCode += getRevenueCaseNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Revcase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Revcase"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revenueofficeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "RevenueofficeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revenueCaseNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "RevenueCaseNo"));
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
