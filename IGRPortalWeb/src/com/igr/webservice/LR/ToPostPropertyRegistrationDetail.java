/**
 * ToPostPropertyRegistrationDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToPostPropertyRegistrationDetail  implements java.io.Serializable {
    private java.lang.String villcode;

    private java.lang.String khasrano;

    private java.lang.String area;

    private java.lang.String regno;

    private java.util.Calendar regdate;

    private java.lang.String regdoc;

    private java.lang.String deptid;

    private java.lang.String key;

    public ToPostPropertyRegistrationDetail() {
    }

    public ToPostPropertyRegistrationDetail(
           java.lang.String villcode,
           java.lang.String khasrano,
           java.lang.String area,
           java.lang.String regno,
           java.util.Calendar regdate,
           java.lang.String regdoc,
           java.lang.String deptid,
           java.lang.String key) {
           this.villcode = villcode;
           this.khasrano = khasrano;
           this.area = area;
           this.regno = regno;
           this.regdate = regdate;
           this.regdoc = regdoc;
           this.deptid = deptid;
           this.key = key;
    }


    /**
     * Gets the villcode value for this ToPostPropertyRegistrationDetail.
     * 
     * @return villcode
     */
    public java.lang.String getVillcode() {
        return villcode;
    }


    /**
     * Sets the villcode value for this ToPostPropertyRegistrationDetail.
     * 
     * @param villcode
     */
    public void setVillcode(java.lang.String villcode) {
        this.villcode = villcode;
    }


    /**
     * Gets the khasrano value for this ToPostPropertyRegistrationDetail.
     * 
     * @return khasrano
     */
    public java.lang.String getKhasrano() {
        return khasrano;
    }


    /**
     * Sets the khasrano value for this ToPostPropertyRegistrationDetail.
     * 
     * @param khasrano
     */
    public void setKhasrano(java.lang.String khasrano) {
        this.khasrano = khasrano;
    }


    /**
     * Gets the area value for this ToPostPropertyRegistrationDetail.
     * 
     * @return area
     */
    public java.lang.String getArea() {
        return area;
    }


    /**
     * Sets the area value for this ToPostPropertyRegistrationDetail.
     * 
     * @param area
     */
    public void setArea(java.lang.String area) {
        this.area = area;
    }


    /**
     * Gets the regno value for this ToPostPropertyRegistrationDetail.
     * 
     * @return regno
     */
    public java.lang.String getRegno() {
        return regno;
    }


    /**
     * Sets the regno value for this ToPostPropertyRegistrationDetail.
     * 
     * @param regno
     */
    public void setRegno(java.lang.String regno) {
        this.regno = regno;
    }


    /**
     * Gets the regdate value for this ToPostPropertyRegistrationDetail.
     * 
     * @return regdate
     */
    public java.util.Calendar getRegdate() {
        return regdate;
    }


    /**
     * Sets the regdate value for this ToPostPropertyRegistrationDetail.
     * 
     * @param regdate
     */
    public void setRegdate(java.util.Calendar regdate) {
        this.regdate = regdate;
    }


    /**
     * Gets the regdoc value for this ToPostPropertyRegistrationDetail.
     * 
     * @return regdoc
     */
    public java.lang.String getRegdoc() {
        return regdoc;
    }


    /**
     * Sets the regdoc value for this ToPostPropertyRegistrationDetail.
     * 
     * @param regdoc
     */
    public void setRegdoc(java.lang.String regdoc) {
        this.regdoc = regdoc;
    }


    /**
     * Gets the deptid value for this ToPostPropertyRegistrationDetail.
     * 
     * @return deptid
     */
    public java.lang.String getDeptid() {
        return deptid;
    }


    /**
     * Sets the deptid value for this ToPostPropertyRegistrationDetail.
     * 
     * @param deptid
     */
    public void setDeptid(java.lang.String deptid) {
        this.deptid = deptid;
    }


    /**
     * Gets the key value for this ToPostPropertyRegistrationDetail.
     * 
     * @return key
     */
    public java.lang.String getKey() {
        return key;
    }


    /**
     * Sets the key value for this ToPostPropertyRegistrationDetail.
     * 
     * @param key
     */
    public void setKey(java.lang.String key) {
        this.key = key;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToPostPropertyRegistrationDetail)) return false;
        ToPostPropertyRegistrationDetail other = (ToPostPropertyRegistrationDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.villcode==null && other.getVillcode()==null) || 
             (this.villcode!=null &&
              this.villcode.equals(other.getVillcode()))) &&
            ((this.khasrano==null && other.getKhasrano()==null) || 
             (this.khasrano!=null &&
              this.khasrano.equals(other.getKhasrano()))) &&
            ((this.area==null && other.getArea()==null) || 
             (this.area!=null &&
              this.area.equals(other.getArea()))) &&
            ((this.regno==null && other.getRegno()==null) || 
             (this.regno!=null &&
              this.regno.equals(other.getRegno()))) &&
            ((this.regdate==null && other.getRegdate()==null) || 
             (this.regdate!=null &&
              this.regdate.equals(other.getRegdate()))) &&
            ((this.regdoc==null && other.getRegdoc()==null) || 
             (this.regdoc!=null &&
              this.regdoc.equals(other.getRegdoc()))) &&
            ((this.deptid==null && other.getDeptid()==null) || 
             (this.deptid!=null &&
              this.deptid.equals(other.getDeptid()))) &&
            ((this.key==null && other.getKey()==null) || 
             (this.key!=null &&
              this.key.equals(other.getKey())));
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
        if (getVillcode() != null) {
            _hashCode += getVillcode().hashCode();
        }
        if (getKhasrano() != null) {
            _hashCode += getKhasrano().hashCode();
        }
        if (getArea() != null) {
            _hashCode += getArea().hashCode();
        }
        if (getRegno() != null) {
            _hashCode += getRegno().hashCode();
        }
        if (getRegdate() != null) {
            _hashCode += getRegdate().hashCode();
        }
        if (getRegdoc() != null) {
            _hashCode += getRegdoc().hashCode();
        }
        if (getDeptid() != null) {
            _hashCode += getDeptid().hashCode();
        }
        if (getKey() != null) {
            _hashCode += getKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ToPostPropertyRegistrationDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostPropertyRegistrationDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("villcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Villcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("khasrano");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Khasrano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Area"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regdate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regdoc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Regdoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deptid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "deptid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("key");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "key"));
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
