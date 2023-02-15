/**
 * KhasraDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class KhasraDetails  implements java.io.Serializable {
    private com.igr.webservice.LR.OwnerDetails[] ownerdetails;

    private com.igr.webservice.LR.Revcase[] revCaseDet;

    private java.lang.String villageCode;

    private java.lang.String khasra_No;

    private java.lang.String area;

    private java.lang.String nakshaURL;

    private java.lang.String mortageFlag;

    private java.lang.String bankName;

    private java.lang.String ownerType;

    private java.lang.String signedB1PdfURL;

    private java.lang.String signedP2PdfURL;

    private java.lang.String pendingDeeds;

    private java.lang.String remainingAreaForRegistration;

    public KhasraDetails() {
    }

    public KhasraDetails(
           com.igr.webservice.LR.OwnerDetails[] ownerdetails,
           com.igr.webservice.LR.Revcase[] revCaseDet,
           java.lang.String villageCode,
           java.lang.String khasra_No,
           java.lang.String area,
           java.lang.String nakshaURL,
           java.lang.String mortageFlag,
           java.lang.String bankName,
           java.lang.String ownerType,
           java.lang.String signedB1PdfURL,
           java.lang.String signedP2PdfURL,
           java.lang.String pendingDeeds,
           java.lang.String remainingAreaForRegistration) {
           this.ownerdetails = ownerdetails;
           this.revCaseDet = revCaseDet;
           this.villageCode = villageCode;
           this.khasra_No = khasra_No;
           this.area = area;
           this.nakshaURL = nakshaURL;
           this.mortageFlag = mortageFlag;
           this.bankName = bankName;
           this.ownerType = ownerType;
           this.signedB1PdfURL = signedB1PdfURL;
           this.signedP2PdfURL = signedP2PdfURL;
           this.pendingDeeds = pendingDeeds;
           this.remainingAreaForRegistration = remainingAreaForRegistration;
    }


    /**
     * Gets the ownerdetails value for this KhasraDetails.
     * 
     * @return ownerdetails
     */
    public com.igr.webservice.LR.OwnerDetails[] getOwnerdetails() {
        return ownerdetails;
    }


    /**
     * Sets the ownerdetails value for this KhasraDetails.
     * 
     * @param ownerdetails
     */
    public void setOwnerdetails(com.igr.webservice.LR.OwnerDetails[] ownerdetails) {
        this.ownerdetails = ownerdetails;
    }


    /**
     * Gets the revCaseDet value for this KhasraDetails.
     * 
     * @return revCaseDet
     */
    public com.igr.webservice.LR.Revcase[] getRevCaseDet() {
        return revCaseDet;
    }


    /**
     * Sets the revCaseDet value for this KhasraDetails.
     * 
     * @param revCaseDet
     */
    public void setRevCaseDet(com.igr.webservice.LR.Revcase[] revCaseDet) {
        this.revCaseDet = revCaseDet;
    }


    /**
     * Gets the villageCode value for this KhasraDetails.
     * 
     * @return villageCode
     */
    public java.lang.String getVillageCode() {
        return villageCode;
    }


    /**
     * Sets the villageCode value for this KhasraDetails.
     * 
     * @param villageCode
     */
    public void setVillageCode(java.lang.String villageCode) {
        this.villageCode = villageCode;
    }


    /**
     * Gets the khasra_No value for this KhasraDetails.
     * 
     * @return khasra_No
     */
    public java.lang.String getKhasra_No() {
        return khasra_No;
    }


    /**
     * Sets the khasra_No value for this KhasraDetails.
     * 
     * @param khasra_No
     */
    public void setKhasra_No(java.lang.String khasra_No) {
        this.khasra_No = khasra_No;
    }


    /**
     * Gets the area value for this KhasraDetails.
     * 
     * @return area
     */
    public java.lang.String getArea() {
        return area;
    }


    /**
     * Sets the area value for this KhasraDetails.
     * 
     * @param area
     */
    public void setArea(java.lang.String area) {
        this.area = area;
    }


    /**
     * Gets the nakshaURL value for this KhasraDetails.
     * 
     * @return nakshaURL
     */
    public java.lang.String getNakshaURL() {
        return nakshaURL;
    }


    /**
     * Sets the nakshaURL value for this KhasraDetails.
     * 
     * @param nakshaURL
     */
    public void setNakshaURL(java.lang.String nakshaURL) {
        this.nakshaURL = nakshaURL;
    }


    /**
     * Gets the mortageFlag value for this KhasraDetails.
     * 
     * @return mortageFlag
     */
    public java.lang.String getMortageFlag() {
        return mortageFlag;
    }


    /**
     * Sets the mortageFlag value for this KhasraDetails.
     * 
     * @param mortageFlag
     */
    public void setMortageFlag(java.lang.String mortageFlag) {
        this.mortageFlag = mortageFlag;
    }


    /**
     * Gets the bankName value for this KhasraDetails.
     * 
     * @return bankName
     */
    public java.lang.String getBankName() {
        return bankName;
    }


    /**
     * Sets the bankName value for this KhasraDetails.
     * 
     * @param bankName
     */
    public void setBankName(java.lang.String bankName) {
        this.bankName = bankName;
    }


    /**
     * Gets the ownerType value for this KhasraDetails.
     * 
     * @return ownerType
     */
    public java.lang.String getOwnerType() {
        return ownerType;
    }


    /**
     * Sets the ownerType value for this KhasraDetails.
     * 
     * @param ownerType
     */
    public void setOwnerType(java.lang.String ownerType) {
        this.ownerType = ownerType;
    }


    /**
     * Gets the signedB1PdfURL value for this KhasraDetails.
     * 
     * @return signedB1PdfURL
     */
    public java.lang.String getSignedB1PdfURL() {
        return signedB1PdfURL;
    }


    /**
     * Sets the signedB1PdfURL value for this KhasraDetails.
     * 
     * @param signedB1PdfURL
     */
    public void setSignedB1PdfURL(java.lang.String signedB1PdfURL) {
        this.signedB1PdfURL = signedB1PdfURL;
    }


    /**
     * Gets the signedP2PdfURL value for this KhasraDetails.
     * 
     * @return signedP2PdfURL
     */
    public java.lang.String getSignedP2PdfURL() {
        return signedP2PdfURL;
    }


    /**
     * Sets the signedP2PdfURL value for this KhasraDetails.
     * 
     * @param signedP2PdfURL
     */
    public void setSignedP2PdfURL(java.lang.String signedP2PdfURL) {
        this.signedP2PdfURL = signedP2PdfURL;
    }


    /**
     * Gets the pendingDeeds value for this KhasraDetails.
     * 
     * @return pendingDeeds
     */
    public java.lang.String getPendingDeeds() {
        return pendingDeeds;
    }


    /**
     * Sets the pendingDeeds value for this KhasraDetails.
     * 
     * @param pendingDeeds
     */
    public void setPendingDeeds(java.lang.String pendingDeeds) {
        this.pendingDeeds = pendingDeeds;
    }


    /**
     * Gets the remainingAreaForRegistration value for this KhasraDetails.
     * 
     * @return remainingAreaForRegistration
     */
    public java.lang.String getRemainingAreaForRegistration() {
        return remainingAreaForRegistration;
    }


    /**
     * Sets the remainingAreaForRegistration value for this KhasraDetails.
     * 
     * @param remainingAreaForRegistration
     */
    public void setRemainingAreaForRegistration(java.lang.String remainingAreaForRegistration) {
        this.remainingAreaForRegistration = remainingAreaForRegistration;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KhasraDetails)) return false;
        KhasraDetails other = (KhasraDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ownerdetails==null && other.getOwnerdetails()==null) || 
             (this.ownerdetails!=null &&
              java.util.Arrays.equals(this.ownerdetails, other.getOwnerdetails()))) &&
            ((this.revCaseDet==null && other.getRevCaseDet()==null) || 
             (this.revCaseDet!=null &&
              java.util.Arrays.equals(this.revCaseDet, other.getRevCaseDet()))) &&
            ((this.villageCode==null && other.getVillageCode()==null) || 
             (this.villageCode!=null &&
              this.villageCode.equals(other.getVillageCode()))) &&
            ((this.khasra_No==null && other.getKhasra_No()==null) || 
             (this.khasra_No!=null &&
              this.khasra_No.equals(other.getKhasra_No()))) &&
            ((this.area==null && other.getArea()==null) || 
             (this.area!=null &&
              this.area.equals(other.getArea()))) &&
            ((this.nakshaURL==null && other.getNakshaURL()==null) || 
             (this.nakshaURL!=null &&
              this.nakshaURL.equals(other.getNakshaURL()))) &&
            ((this.mortageFlag==null && other.getMortageFlag()==null) || 
             (this.mortageFlag!=null &&
              this.mortageFlag.equals(other.getMortageFlag()))) &&
            ((this.bankName==null && other.getBankName()==null) || 
             (this.bankName!=null &&
              this.bankName.equals(other.getBankName()))) &&
            ((this.ownerType==null && other.getOwnerType()==null) || 
             (this.ownerType!=null &&
              this.ownerType.equals(other.getOwnerType()))) &&
            ((this.signedB1PdfURL==null && other.getSignedB1PdfURL()==null) || 
             (this.signedB1PdfURL!=null &&
              this.signedB1PdfURL.equals(other.getSignedB1PdfURL()))) &&
            ((this.signedP2PdfURL==null && other.getSignedP2PdfURL()==null) || 
             (this.signedP2PdfURL!=null &&
              this.signedP2PdfURL.equals(other.getSignedP2PdfURL()))) &&
            ((this.pendingDeeds==null && other.getPendingDeeds()==null) || 
             (this.pendingDeeds!=null &&
              this.pendingDeeds.equals(other.getPendingDeeds()))) &&
            ((this.remainingAreaForRegistration==null && other.getRemainingAreaForRegistration()==null) || 
             (this.remainingAreaForRegistration!=null &&
              this.remainingAreaForRegistration.equals(other.getRemainingAreaForRegistration())));
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
        if (getOwnerdetails() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOwnerdetails());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOwnerdetails(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRevCaseDet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRevCaseDet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRevCaseDet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVillageCode() != null) {
            _hashCode += getVillageCode().hashCode();
        }
        if (getKhasra_No() != null) {
            _hashCode += getKhasra_No().hashCode();
        }
        if (getArea() != null) {
            _hashCode += getArea().hashCode();
        }
        if (getNakshaURL() != null) {
            _hashCode += getNakshaURL().hashCode();
        }
        if (getMortageFlag() != null) {
            _hashCode += getMortageFlag().hashCode();
        }
        if (getBankName() != null) {
            _hashCode += getBankName().hashCode();
        }
        if (getOwnerType() != null) {
            _hashCode += getOwnerType().hashCode();
        }
        if (getSignedB1PdfURL() != null) {
            _hashCode += getSignedB1PdfURL().hashCode();
        }
        if (getSignedP2PdfURL() != null) {
            _hashCode += getSignedP2PdfURL().hashCode();
        }
        if (getPendingDeeds() != null) {
            _hashCode += getPendingDeeds().hashCode();
        }
        if (getRemainingAreaForRegistration() != null) {
            _hashCode += getRemainingAreaForRegistration().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KhasraDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "KhasraDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerdetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "ownerdetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "OwnerDetails"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "OwnerDetails"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revCaseDet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "RevCaseDet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Revcase"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Revcase"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("villageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "VillageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("khasra_No");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Khasra_No"));
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
        elemField.setFieldName("nakshaURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "NakshaURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mortageFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "MortageFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "BankName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ownerType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "OwnerType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signedB1PdfURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "SignedB1PdfURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signedP2PdfURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "SignedP2PdfURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pendingDeeds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "PendingDeeds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remainingAreaForRegistration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "RemainingAreaForRegistration"));
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
