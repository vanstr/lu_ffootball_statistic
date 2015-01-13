
package com.lu.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MainasType complex type.
 * 
 * <p>The following com.lu.schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MainasType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Maina" type="{}MainaType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MainasType", propOrder = {
    "maina"
})
public class MainasType {

    @XmlElement(name = "Maina", required = true)
    protected MainaType maina;

    /**
     * Gets the value of the maina property.
     * 
     * @return
     *     possible object is
     *     {@link MainaType }
     *     
     */
    public MainaType getMaina() {
        return maina;
    }

    /**
     * Sets the value of the maina property.
     * 
     * @param value
     *     allowed object is
     *     {@link MainaType }
     *     
     */
    public void setMaina(MainaType value) {
        this.maina = value;
    }

}
