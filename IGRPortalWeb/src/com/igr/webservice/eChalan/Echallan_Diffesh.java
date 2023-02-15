/**
 * Echallan_Diffesh.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.eChalan;

public class Echallan_Diffesh  implements java.io.Serializable {
    private java.lang.String authuser;

    private java.lang.String service_no;

    private java.lang.String comment;

    private java.lang.String update;

    public Echallan_Diffesh() {
    }

    public Echallan_Diffesh(
           java.lang.String authuser,
           java.lang.String service_no,
           java.lang.String comment,
           java.lang.String update) {
           this.authuser = authuser;
           this.service_no = service_no;
           this.comment = comment;
           this.update = update;
    }


    /**
     * Gets the authuser value for this Echallan_Diffesh.
     * 
     * @return authuser
     */
    public java.lang.String getAuthuser() {
        return authuser;
    }


    /**
     * Sets the authuser value for this Echallan_Diffesh.
     * 
     * @param authuser
     */
    public void setAuthuser(java.lang.String authuser) {
        this.authuser = authuser;
    }


    /**
     * Gets the service_no value for this Echallan_Diffesh.
     * 
     * @return service_no
     */
    public java.lang.String getService_no() {
        return service_no;
    }


    /**
     * Sets the service_no value for this Echallan_Diffesh.
     * 
     * @param service_no
     */
    public void setService_no(java.lang.String service_no) {
        this.service_no = service_no;
    }


    /**
     * Gets the comment value for this Echallan_Diffesh.
     * 
     * @return comment
     */
    public java.lang.String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this Echallan_Diffesh.
     * 
     * @param comment
     */
    public void setComment(java.lang.String comment) {
        this.comment = comment;
    }


    /**
     * Gets the update value for this Echallan_Diffesh.
     * 
     * @return update
     */
    public java.lang.String getUpdate() {
        return update;
    }


    /**
     * Sets the update value for this Echallan_Diffesh.
     * 
     * @param update
     */
    public void setUpdate(java.lang.String update) {
        this.update = update;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Echallan_Diffesh)) return false;
        Echallan_Diffesh other = (Echallan_Diffesh) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authuser==null && other.getAuthuser()==null) || 
             (this.authuser!=null &&
              this.authuser.equals(other.getAuthuser()))) &&
            ((this.service_no==null && other.getService_no()==null) || 
             (this.service_no!=null &&
              this.service_no.equals(other.getService_no()))) &&
            ((this.comment==null && other.getComment()==null) || 
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
            ((this.update==null && other.getUpdate()==null) || 
             (this.update!=null &&
              this.update.equals(other.getUpdate())));
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
        if (getAuthuser() != null) {
            _hashCode += getAuthuser().hashCode();
        }
        if (getService_no() != null) {
            _hashCode += getService_no().hashCode();
        }
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        if (getUpdate() != null) {
            _hashCode += getUpdate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Echallan_Diffesh.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "Echallan_Diffesh"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authuser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "authuser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service_no");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "service_no"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "comment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("update");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "update"));
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
