/**
 * ToGetDiversionDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToGetDiversionDetails  implements java.io.Serializable {
    private java.lang.String plotno;

    private java.lang.String recordcode;

    public ToGetDiversionDetails() {
    }

    public ToGetDiversionDetails(
           java.lang.String plotno,
           java.lang.String recordcode) {
           this.plotno = plotno;
           this.recordcode = recordcode;
    }


    /**
     * Gets the plotno value for this ToGetDiversionDetails.
     * 
     * @return plotno
     */
    public java.lang.String getPlotno() {
        return plotno;
    }


    /**
     * Sets the plotno value for this ToGetDiversionDetails.
     * 
     * @param plotno
     */
    public void setPlotno(java.lang.String plotno) {
        this.plotno = plotno;
    }


    /**
     * Gets the recordcode value for this ToGetDiversionDetails.
     * 
     * @return recordcode
     */
    public java.lang.String getRecordcode() {
        return recordcode;
    }


    /**
     * Sets the recordcode value for this ToGetDiversionDetails.
     * 
     * @param recordcode
     */
    public void setRecordcode(java.lang.String recordcode) {
        this.recordcode = recordcode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToGetDiversionDetails)) return false;
        ToGetDiversionDetails other = (ToGetDiversionDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.plotno==null && other.getPlotno()==null) || 
             (this.plotno!=null &&
              this.plotno.equals(other.getPlotno()))) &&
            ((this.recordcode==null && other.getRecordcode()==null) || 
             (this.recordcode!=null &&
              this.recordcode.equals(other.getRecordcode())));
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
        if (getPlotno() != null) {
            _hashCode += getPlotno().hashCode();
        }
        if (getRecordcode() != null) {
            _hashCode += getRecordcode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToGetDiversionDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToGetDiversionDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plotno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "plotno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recordcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "recordcode"));
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
