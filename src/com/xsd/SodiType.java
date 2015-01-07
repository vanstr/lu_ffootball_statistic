
package com.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SodiType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SodiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sods" type="{}SodsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SodiType", propOrder = {
    "sods"
})
public class SodiType {

    @XmlElement(name = "Sods", required = true)
    protected SodsType sods;

    /**
     * Gets the value of the sods property.
     * 
     * @return
     *     possible object is
     *     {@link SodsType }
     *     
     */
    public SodsType getSods() {
        return sods;
    }

    /**
     * Sets the value of the sods property.
     * 
     * @param value
     *     allowed object is
     *     {@link SodsType }
     *     
     */
    public void setSods(SodsType value) {
        this.sods = value;
    }

}
