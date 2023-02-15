/**
 * ToPostNajoolPropertyRegistration_VikretaDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class ToPostNajoolPropertyRegistration_VikretaDetails  implements java.io.Serializable {
    private java.lang.String recordcode;

    private java.lang.String person_name;

    private java.lang.String father_name;

    private java.lang.String address;

    private java.lang.String mobile_no;

    private java.lang.String olast;

    private java.lang.String pregNo;

    private java.lang.String deptid;

    private java.lang.String key;

    public ToPostNajoolPropertyRegistration_VikretaDetails() {
    }

    public ToPostNajoolPropertyRegistration_VikretaDetails(
           java.lang.String recordcode,
           java.lang.String person_name,
           java.lang.String father_name,
           java.lang.String address,
           java.lang.String mobile_no,
           java.lang.String olast,
           java.lang.String pregNo,
           java.lang.String deptid,
           java.lang.String key) {
           this.recordcode = recordcode;
           this.person_name = person_name;
           this.father_name = father_name;
           this.address = address;
           this.mobile_no = mobile_no;
           this.olast = olast;
           this.pregNo = pregNo;
           this.deptid = deptid;
           this.key = key;
    }


    /**
     * Gets the recordcode value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @return recordcode
     */
    public java.lang.String getRecordcode() {
        return recordcode;
    }


    /**
     * Sets the recordcode value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @param recordcode
     */
    public void setRecordcode(java.lang.String recordcode) {
        this.recordcode = recordcode;
    }


    /**
     * Gets the person_name value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @return person_name
     */
    public java.lang.String getPerson_name() {
        return person_name;
    }


    /**
     * Sets the person_name value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @param person_name
     */
    public void setPerson_name(java.lang.String person_name) {
        this.person_name = person_name;
    }


    /**
     * Gets the father_name value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @return father_name
     */
    public java.lang.String getFather_name() {
        return father_name;
    }


    /**
     * Sets the father_name value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @param father_name
     */
    public void setFather_name(java.lang.String father_name) {
        this.father_name = father_name;
    }


    /**
     * Gets the address value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the mobile_no value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @return mobile_no
     */
    public java.lang.String getMobile_no() {
        return mobile_no;
    }


    /**
     * Sets the mobile_no value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @param mobile_no
     */
    public void setMobile_no(java.lang.String mobile_no) {
        this.mobile_no = mobile_no;
    }


    /**
     * Gets the olast value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @return olast
     */
    public java.lang.String getOlast() {
        return olast;
    }


    /**
     * Sets the olast value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @param olast
     */
    public void setOlast(java.lang.String olast) {
        this.olast = olast;
    }


    /**
     * Gets the pregNo value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @return pregNo
     */
    public java.lang.String getPregNo() {
        return pregNo;
    }


    /**
     * Sets the pregNo value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @param pregNo
     */
    public void setPregNo(java.lang.String pregNo) {
        this.pregNo = pregNo;
    }


    /**
     * Gets the deptid value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @return deptid
     */
    public java.lang.String getDeptid() {
        return deptid;
    }


    /**
     * Sets the deptid value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @param deptid
     */
    public void setDeptid(java.lang.String deptid) {
        this.deptid = deptid;
    }


    /**
     * Gets the key value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @return key
     */
    public java.lang.String getKey() {
        return key;
    }


    /**
     * Sets the key value for this ToPostNajoolPropertyRegistration_VikretaDetails.
     * 
     * @param key
     */
    public void setKey(java.lang.String key) {
        this.key = key;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ToPostNajoolPropertyRegistration_VikretaDetails)) return false;
        ToPostNajoolPropertyRegistration_VikretaDetails other = (ToPostNajoolPropertyRegistration_VikretaDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.recordcode==null && other.getRecordcode()==null) || 
             (this.recordcode!=null &&
              this.recordcode.equals(other.getRecordcode()))) &&
            ((this.person_name==null && other.getPerson_name()==null) || 
             (this.person_name!=null &&
              this.person_name.equals(other.getPerson_name()))) &&
            ((this.father_name==null && other.getFather_name()==null) || 
             (this.father_name!=null &&
              this.father_name.equals(other.getFather_name()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.mobile_no==null && other.getMobile_no()==null) || 
             (this.mobile_no!=null &&
              this.mobile_no.equals(other.getMobile_no()))) &&
            ((this.olast==null && other.getOlast()==null) || 
             (this.olast!=null &&
              this.olast.equals(other.getOlast()))) &&
            ((this.pregNo==null && other.getPregNo()==null) || 
             (this.pregNo!=null &&
              this.pregNo.equals(other.getPregNo()))) &&
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
        if (getRecordcode() != null) {
            _hashCode += getRecordcode().hashCode();
        }
        if (getPerson_name() != null) {
            _hashCode += getPerson_name().hashCode();
        }
        if (getFather_name() != null) {
            _hashCode += getFather_name().hashCode();
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getMobile_no() != null) {
            _hashCode += getMobile_no().hashCode();
        }
        if (getOlast() != null) {
            _hashCode += getOlast().hashCode();
        }
        if (getPregNo() != null) {
            _hashCode += getPregNo().hashCode();
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
        new org.apache.axis.description.TypeDesc(ToPostNajoolPropertyRegistration_VikretaDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", ">ToPostNajoolPropertyRegistration_VikretaDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recordcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "recordcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("person_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "person_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("father_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "father_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile_no");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "mobile_no"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("olast");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "olast"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pregNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "PregNo"));
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
