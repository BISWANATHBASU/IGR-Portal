/**
 * DiversionPlotDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.igr.webservice.LR;

public class DiversionPlotDetails  implements java.io.Serializable {
    private com.igr.webservice.LR.DiversionOwnerDetails[] diversionOwnerDetails;

    private java.lang.String plotno;

    private java.lang.String area_foot;

    private java.lang.String tax_free_area;

    private java.lang.String rights_type_nm;

    private java.lang.String base_tax;

    private java.lang.String base_env_tax;

    private java.lang.String base_dev_tax;

    private java.lang.String remark;

    private java.lang.String department;

    public DiversionPlotDetails() {
    }

    public DiversionPlotDetails(
           com.igr.webservice.LR.DiversionOwnerDetails[] diversionOwnerDetails,
           java.lang.String plotno,
           java.lang.String area_foot,
           java.lang.String tax_free_area,
           java.lang.String rights_type_nm,
           java.lang.String base_tax,
           java.lang.String base_env_tax,
           java.lang.String base_dev_tax,
           java.lang.String remark,
           java.lang.String department) {
           this.diversionOwnerDetails = diversionOwnerDetails;
           this.plotno = plotno;
           this.area_foot = area_foot;
           this.tax_free_area = tax_free_area;
           this.rights_type_nm = rights_type_nm;
           this.base_tax = base_tax;
           this.base_env_tax = base_env_tax;
           this.base_dev_tax = base_dev_tax;
           this.remark = remark;
           this.department = department;
    }


    /**
     * Gets the diversionOwnerDetails value for this DiversionPlotDetails.
     * 
     * @return diversionOwnerDetails
     */
    public com.igr.webservice.LR.DiversionOwnerDetails[] getDiversionOwnerDetails() {
        return diversionOwnerDetails;
    }


    /**
     * Sets the diversionOwnerDetails value for this DiversionPlotDetails.
     * 
     * @param diversionOwnerDetails
     */
    public void setDiversionOwnerDetails(com.igr.webservice.LR.DiversionOwnerDetails[] diversionOwnerDetails) {
        this.diversionOwnerDetails = diversionOwnerDetails;
    }


    /**
     * Gets the plotno value for this DiversionPlotDetails.
     * 
     * @return plotno
     */
    public java.lang.String getPlotno() {
        return plotno;
    }


    /**
     * Sets the plotno value for this DiversionPlotDetails.
     * 
     * @param plotno
     */
    public void setPlotno(java.lang.String plotno) {
        this.plotno = plotno;
    }


    /**
     * Gets the area_foot value for this DiversionPlotDetails.
     * 
     * @return area_foot
     */
    public java.lang.String getArea_foot() {
        return area_foot;
    }


    /**
     * Sets the area_foot value for this DiversionPlotDetails.
     * 
     * @param area_foot
     */
    public void setArea_foot(java.lang.String area_foot) {
        this.area_foot = area_foot;
    }


    /**
     * Gets the tax_free_area value for this DiversionPlotDetails.
     * 
     * @return tax_free_area
     */
    public java.lang.String getTax_free_area() {
        return tax_free_area;
    }


    /**
     * Sets the tax_free_area value for this DiversionPlotDetails.
     * 
     * @param tax_free_area
     */
    public void setTax_free_area(java.lang.String tax_free_area) {
        this.tax_free_area = tax_free_area;
    }


    /**
     * Gets the rights_type_nm value for this DiversionPlotDetails.
     * 
     * @return rights_type_nm
     */
    public java.lang.String getRights_type_nm() {
        return rights_type_nm;
    }


    /**
     * Sets the rights_type_nm value for this DiversionPlotDetails.
     * 
     * @param rights_type_nm
     */
    public void setRights_type_nm(java.lang.String rights_type_nm) {
        this.rights_type_nm = rights_type_nm;
    }


    /**
     * Gets the base_tax value for this DiversionPlotDetails.
     * 
     * @return base_tax
     */
    public java.lang.String getBase_tax() {
        return base_tax;
    }


    /**
     * Sets the base_tax value for this DiversionPlotDetails.
     * 
     * @param base_tax
     */
    public void setBase_tax(java.lang.String base_tax) {
        this.base_tax = base_tax;
    }


    /**
     * Gets the base_env_tax value for this DiversionPlotDetails.
     * 
     * @return base_env_tax
     */
    public java.lang.String getBase_env_tax() {
        return base_env_tax;
    }


    /**
     * Sets the base_env_tax value for this DiversionPlotDetails.
     * 
     * @param base_env_tax
     */
    public void setBase_env_tax(java.lang.String base_env_tax) {
        this.base_env_tax = base_env_tax;
    }


    /**
     * Gets the base_dev_tax value for this DiversionPlotDetails.
     * 
     * @return base_dev_tax
     */
    public java.lang.String getBase_dev_tax() {
        return base_dev_tax;
    }


    /**
     * Sets the base_dev_tax value for this DiversionPlotDetails.
     * 
     * @param base_dev_tax
     */
    public void setBase_dev_tax(java.lang.String base_dev_tax) {
        this.base_dev_tax = base_dev_tax;
    }


    /**
     * Gets the remark value for this DiversionPlotDetails.
     * 
     * @return remark
     */
    public java.lang.String getRemark() {
        return remark;
    }


    /**
     * Sets the remark value for this DiversionPlotDetails.
     * 
     * @param remark
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }


    /**
     * Gets the department value for this DiversionPlotDetails.
     * 
     * @return department
     */
    public java.lang.String getDepartment() {
        return department;
    }


    /**
     * Sets the department value for this DiversionPlotDetails.
     * 
     * @param department
     */
    public void setDepartment(java.lang.String department) {
        this.department = department;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DiversionPlotDetails)) return false;
        DiversionPlotDetails other = (DiversionPlotDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.diversionOwnerDetails==null && other.getDiversionOwnerDetails()==null) || 
             (this.diversionOwnerDetails!=null &&
              java.util.Arrays.equals(this.diversionOwnerDetails, other.getDiversionOwnerDetails()))) &&
            ((this.plotno==null && other.getPlotno()==null) || 
             (this.plotno!=null &&
              this.plotno.equals(other.getPlotno()))) &&
            ((this.area_foot==null && other.getArea_foot()==null) || 
             (this.area_foot!=null &&
              this.area_foot.equals(other.getArea_foot()))) &&
            ((this.tax_free_area==null && other.getTax_free_area()==null) || 
             (this.tax_free_area!=null &&
              this.tax_free_area.equals(other.getTax_free_area()))) &&
            ((this.rights_type_nm==null && other.getRights_type_nm()==null) || 
             (this.rights_type_nm!=null &&
              this.rights_type_nm.equals(other.getRights_type_nm()))) &&
            ((this.base_tax==null && other.getBase_tax()==null) || 
             (this.base_tax!=null &&
              this.base_tax.equals(other.getBase_tax()))) &&
            ((this.base_env_tax==null && other.getBase_env_tax()==null) || 
             (this.base_env_tax!=null &&
              this.base_env_tax.equals(other.getBase_env_tax()))) &&
            ((this.base_dev_tax==null && other.getBase_dev_tax()==null) || 
             (this.base_dev_tax!=null &&
              this.base_dev_tax.equals(other.getBase_dev_tax()))) &&
            ((this.remark==null && other.getRemark()==null) || 
             (this.remark!=null &&
              this.remark.equals(other.getRemark()))) &&
            ((this.department==null && other.getDepartment()==null) || 
             (this.department!=null &&
              this.department.equals(other.getDepartment())));
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
        if (getDiversionOwnerDetails() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDiversionOwnerDetails());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDiversionOwnerDetails(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPlotno() != null) {
            _hashCode += getPlotno().hashCode();
        }
        if (getArea_foot() != null) {
            _hashCode += getArea_foot().hashCode();
        }
        if (getTax_free_area() != null) {
            _hashCode += getTax_free_area().hashCode();
        }
        if (getRights_type_nm() != null) {
            _hashCode += getRights_type_nm().hashCode();
        }
        if (getBase_tax() != null) {
            _hashCode += getBase_tax().hashCode();
        }
        if (getBase_env_tax() != null) {
            _hashCode += getBase_env_tax().hashCode();
        }
        if (getBase_dev_tax() != null) {
            _hashCode += getBase_dev_tax().hashCode();
        }
        if (getRemark() != null) {
            _hashCode += getRemark().hashCode();
        }
        if (getDepartment() != null) {
            _hashCode += getDepartment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DiversionPlotDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionPlotDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diversionOwnerDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionOwnerDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionOwnerDetails"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "DiversionOwnerDetails"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plotno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Plotno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area_foot");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "area_foot"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tax_free_area");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "tax_free_area"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rights_type_nm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "rights_type_nm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("base_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "base_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("base_env_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "base_env_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("base_dev_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "base_dev_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "remark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("department");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bhuiyan.cg.nic.in/", "Department"));
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
