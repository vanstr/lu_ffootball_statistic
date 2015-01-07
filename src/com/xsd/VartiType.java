
package com.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VartiType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VartiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VG" type="{}VGType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VartiType", propOrder = {
    "vg"
})
public class VartiType {

    @XmlElement(name = "VG", required = true)
    protected VGType vg;

    /**
     * Gets the value of the vg property.
     * 
     * @return
     *     possible object is
     *     {@link VGType }
     *     
     */
    public VGType getVG() {
        return vg;
    }

    /**
     * Sets the value of the vg property.
     * 
     * @param value
     *     allowed object is
     *     {@link VGType }
     *     
     */
    public void setVG(VGType value) {
        this.vg = value;
    }

}
