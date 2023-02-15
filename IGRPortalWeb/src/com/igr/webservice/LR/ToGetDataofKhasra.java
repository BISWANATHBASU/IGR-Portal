/**
 * ToGetDataofKhasra.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToGetDataofKhasra  implements java.io.Serializable {
    private java.lang.String districtno;

    private java.lang.String tehsilno;

    private java.lang.String rino;

    private java.lang.String villageno;

    private java.lang.String khasraNo;

    public ToGetDataofKhasra() {
    }

    public ToGetDataofKhasra(
           java.lang.String districtno,
           java.lang.String tehsilno,
           java.lang.String rino,
           java.lang.String villageno,
           java.lang.String khasraNo) {
           this.districtno = districtno;
           this.tehsilno = tehsilno;
           this.rino = rino;
           this.villageno = villageno;
           this.khasraNo = khasraNo;
    }


    /**
     * Gets the districtno value for this ToGetDataofKhasra.
     * 
     * @return districtno
     */
    public java.lang.String getDistrictno() {
        return districtno;
    }


    /**
     * Sets the districtno value for this ToGetDataofKhasra.
     * 
     * @param districtno
     */
    public void setDistrictno(java.lang.String districtno) {
        this.districtno = districtno;
    }


    /**
     * Gets the tehsilno value for this ToGetDataofKhasra.
     * 
     * @return tehsilno
     */
    public java.lang.String getTehsilno() {
        return tehsilno;
    }


    /**
     * Sets the tehsilno value for this ToGetDataofKhasra.
     * 
     * @param tehsilno
     */
    public void setTehsilno(java.lang.String tehsilno) {
        this.tehsilno = tehsilno;
    }


    /**
     * Gets the rino value for this ToGetDataofKhasra.
     * 
     * @return rino
     */
    public java.lang.String getRino() {
        return rino;
    }


    /**
     * Sets the rino value for this ToGetDataofKhasra.
     * 
     * @param rino
     */
    public void setRino(java.lang.String rino) {
        this.rino = rino;
    }


    /**
     * Gets the villageno value for this ToGetDataofKhasra.
     * 
     * @return villageno
     */
    public java.lang.String getVillageno() {
        return villageno;
    }


    /**
     * Sets the villageno value for this ToGetDataofKhasra.
     * 
     * @param villageno
     */
    public void setVillageno(java.lang.String villageno) {
        this.villageno = villageno;
    }


    /**
     * Gets the khasraNo value for this ToGetDataofKhasra.
     * 
     * @return khasraNo
     */
    public java.lang.String getKhasraNo() {
        return khasraNo;
    }


    /**
     * Sets the khasraNo value for this ToGetDataofKhasra.
     * 
     * @param khasraNo
     */
    public void setKhasraNo(java.lang.String khasraNo) {
        this.khasraNo = khasraNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToGetDataofKhasra)) return false;
        ToGetDataofKhasra other = (ToGetDataofKhasra) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.districtno==null && other.getDistrictno()==null) || 
             (this.districtno!=null &&
              this.districtno.equals(other.getDistrictno()))) &&
            ((this.tehsilno==null && other.getTehsilno()==null) || 
             (this.tehsilno!=null &&
              this.tehsilno.equals(other.getTehsilno()))) &&
            ((this.rino==null && other.getRino()==null) || 
             (this.rino!=null &&
              this.rino.equals(other.getRino()))) &&
            ((this.villageno==null && other.getVillageno()==null) || 
             (this.villageno!=null &&
              this.villageno.equals(other.getVillageno()))) &&
            ((this.khasraNo==null && other.getKhasraNo()==null) || 
             (this.khasraNo!=null &&
              this.khasraNo.equals(other.getKhasraNo())));
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
        if (getDistrictno() != null) {
            _hashCode += getDistrictno().hashCode();
        }
        if (getTehsilno() != null) {
            _hashCode += getTehsilno().hashCode();
        }
        if (getRino() != null) {
            _hashCode += getRino().hashCode();
        }
        if (getVillageno() != null) {
            _hashCode += getVillageno().hashCode();
        }
        if (getKhasraNo() != null) {
            _hashCode += getKhasraNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToGetDataofKhasra.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToGetDataofKhasra"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("districtno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Districtno"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rino");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Rino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("villageno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Villageno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("khasraNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "KhasraNo"));
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
