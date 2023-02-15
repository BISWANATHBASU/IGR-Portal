/**
 * OwnerDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class OwnerDetails  implements java.io.Serializable {
    private java.lang.String ocdname;

    private java.lang.String ocdname1;

    private java.lang.String ofather;

    private java.lang.String ofather1;

    private java.lang.String gender;

    private java.lang.String ocaste_code;

    private java.lang.String ocastenm;

    private java.lang.String oaddr1;

    private java.lang.String mobileno;

    private java.lang.String aadharno;

    private java.lang.String loanbook;

    public OwnerDetails() {
    }

    public OwnerDetails(
           java.lang.String ocdname,
           java.lang.String ocdname1,
           java.lang.String ofather,
           java.lang.String ofather1,
           java.lang.String gender,
           java.lang.String ocaste_code,
           java.lang.String ocastenm,
           java.lang.String oaddr1,
           java.lang.String mobileno,
           java.lang.String aadharno,
           java.lang.String loanbook) {
           this.ocdname = ocdname;
           this.ocdname1 = ocdname1;
           this.ofather = ofather;
           this.ofather1 = ofather1;
           this.gender = gender;
           this.ocaste_code = ocaste_code;
           this.ocastenm = ocastenm;
           this.oaddr1 = oaddr1;
           this.mobileno = mobileno;
           this.aadharno = aadharno;
           this.loanbook = loanbook;
    }


    /**
     * Gets the ocdname value for this OwnerDetails.
     * 
     * @return ocdname
     */
    public java.lang.String getOcdname() {
        return ocdname;
    }


    /**
     * Sets the ocdname value for this OwnerDetails.
     * 
     * @param ocdname
     */
    public void setOcdname(java.lang.String ocdname) {
        this.ocdname = ocdname;
    }


    /**
     * Gets the ocdname1 value for this OwnerDetails.
     * 
     * @return ocdname1
     */
    public java.lang.String getOcdname1() {
        return ocdname1;
    }


    /**
     * Sets the ocdname1 value for this OwnerDetails.
     * 
     * @param ocdname1
     */
    public void setOcdname1(java.lang.String ocdname1) {
        this.ocdname1 = ocdname1;
    }


    /**
     * Gets the ofather value for this OwnerDetails.
     * 
     * @return ofather
     */
    public java.lang.String getOfather() {
        return ofather;
    }


    /**
     * Sets the ofather value for this OwnerDetails.
     * 
     * @param ofather
     */
    public void setOfather(java.lang.String ofather) {
        this.ofather = ofather;
    }


    /**
     * Gets the ofather1 value for this OwnerDetails.
     * 
     * @return ofather1
     */
    public java.lang.String getOfather1() {
        return ofather1;
    }


    /**
     * Sets the ofather1 value for this OwnerDetails.
     * 
     * @param ofather1
     */
    public void setOfather1(java.lang.String ofather1) {
        this.ofather1 = ofather1;
    }


    /**
     * Gets the gender value for this OwnerDetails.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this OwnerDetails.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the ocaste_code value for this OwnerDetails.
     * 
     * @return ocaste_code
     */
    public java.lang.String getOcaste_code() {
        return ocaste_code;
    }


    /**
     * Sets the ocaste_code value for this OwnerDetails.
     * 
     * @param ocaste_code
     */
    public void setOcaste_code(java.lang.String ocaste_code) {
        this.ocaste_code = ocaste_code;
    }


    /**
     * Gets the ocastenm value for this OwnerDetails.
     * 
     * @return ocastenm
     */
    public java.lang.String getOcastenm() {
        return ocastenm;
    }


    /**
     * Sets the ocastenm value for this OwnerDetails.
     * 
     * @param ocastenm
     */
    public void setOcastenm(java.lang.String ocastenm) {
        this.ocastenm = ocastenm;
    }


    /**
     * Gets the oaddr1 value for this OwnerDetails.
     * 
     * @return oaddr1
     */
    public java.lang.String getOaddr1() {
        return oaddr1;
    }


    /**
     * Sets the oaddr1 value for this OwnerDetails.
     * 
     * @param oaddr1
     */
    public void setOaddr1(java.lang.String oaddr1) {
        this.oaddr1 = oaddr1;
    }


    /**
     * Gets the mobileno value for this OwnerDetails.
     * 
     * @return mobileno
     */
    public java.lang.String getMobileno() {
        return mobileno;
    }


    /**
     * Sets the mobileno value for this OwnerDetails.
     * 
     * @param mobileno
     */
    public void setMobileno(java.lang.String mobileno) {
        this.mobileno = mobileno;
    }


    /**
     * Gets the aadharno value for this OwnerDetails.
     * 
     * @return aadharno
     */
    public java.lang.String getAadharno() {
        return aadharno;
    }


    /**
     * Sets the aadharno value for this OwnerDetails.
     * 
     * @param aadharno
     */
    public void setAadharno(java.lang.String aadharno) {
        this.aadharno = aadharno;
    }


    /**
     * Gets the loanbook value for this OwnerDetails.
     * 
     * @return loanbook
     */
    public java.lang.String getLoanbook() {
        return loanbook;
    }


    /**
     * Sets the loanbook value for this OwnerDetails.
     * 
     * @param loanbook
     */
    public void setLoanbook(java.lang.String loanbook) {
        this.loanbook = loanbook;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OwnerDetails)) return false;
        OwnerDetails other = (OwnerDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ocdname==null && other.getOcdname()==null) || 
             (this.ocdname!=null &&
              this.ocdname.equals(other.getOcdname()))) &&
            ((this.ocdname1==null && other.getOcdname1()==null) || 
             (this.ocdname1!=null &&
              this.ocdname1.equals(other.getOcdname1()))) &&
            ((this.ofather==null && other.getOfather()==null) || 
             (this.ofather!=null &&
              this.ofather.equals(other.getOfather()))) &&
            ((this.ofather1==null && other.getOfather1()==null) || 
             (this.ofather1!=null &&
              this.ofather1.equals(other.getOfather1()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.ocaste_code==null && other.getOcaste_code()==null) || 
             (this.ocaste_code!=null &&
              this.ocaste_code.equals(other.getOcaste_code()))) &&
            ((this.ocastenm==null && other.getOcastenm()==null) || 
             (this.ocastenm!=null &&
              this.ocastenm.equals(other.getOcastenm()))) &&
            ((this.oaddr1==null && other.getOaddr1()==null) || 
             (this.oaddr1!=null &&
              this.oaddr1.equals(other.getOaddr1()))) &&
            ((this.mobileno==null && other.getMobileno()==null) || 
             (this.mobileno!=null &&
              this.mobileno.equals(other.getMobileno()))) &&
            ((this.aadharno==null && other.getAadharno()==null) || 
             (this.aadharno!=null &&
              this.aadharno.equals(other.getAadharno()))) &&
            ((this.loanbook==null && other.getLoanbook()==null) || 
             (this.loanbook!=null &&
              this.loanbook.equals(other.getLoanbook())));
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
        if (getOcdname() != null) {
            _hashCode += getOcdname().hashCode();
        }
        if (getOcdname1() != null) {
            _hashCode += getOcdname1().hashCode();
        }
        if (getOfather() != null) {
            _hashCode += getOfather().hashCode();
        }
        if (getOfather1() != null) {
            _hashCode += getOfather1().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getOcaste_code() != null) {
            _hashCode += getOcaste_code().hashCode();
        }
        if (getOcastenm() != null) {
            _hashCode += getOcastenm().hashCode();
        }
        if (getOaddr1() != null) {
            _hashCode += getOaddr1().hashCode();
        }
        if (getMobileno() != null) {
            _hashCode += getMobileno().hashCode();
        }
        if (getAadharno() != null) {
            _hashCode += getAadharno().hashCode();
        }
        if (getLoanbook() != null) {
            _hashCode += getLoanbook().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OwnerDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "OwnerDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ocdname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocdname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ocdname1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocdname1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ofather");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ofather"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ofather1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ofather1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ocaste_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocaste_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ocastenm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ocastenm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oaddr1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "oaddr1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobileno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "mobileno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aadharno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "aadharno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loanbook");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "loanbook"));
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
