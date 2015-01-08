
package com.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for VTType complex type.
 * 
 * <p>The following com.schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VTType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="Vards" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Uzvards" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VTType", propOrder = {
    "value"
})
public class VTType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Vards")
    protected String vards;
    @XmlAttribute(name = "Uzvards")
    protected String uzvards;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the vards property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVards() {
        return vards;
    }

    /**
     * Sets the value of the vards property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVards(String value) {
        this.vards = value;
    }

    /**
     * Gets the value of the uzvards property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUzvards() {
        return uzvards;
    }

    /**
     * Sets the value of the uzvards property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUzvards(String value) {
        this.uzvards = value;
    }

}
