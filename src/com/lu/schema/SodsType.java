
package com.lu.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for SodsType complex type.
 * 
 * <p>The following com.lu.schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SodsType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="Laiks" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Nr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SodsType", propOrder = {
    "value"
})
public class SodsType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Laiks")
    protected String laiks;
    @XmlAttribute(name = "Nr")
    protected String nr;

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
     * Gets the value of the laiks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaiks() {
        return laiks;
    }

    /**
     * Sets the value of the laiks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaiks(String value) {
        this.laiks = value;
    }

    /**
     * Gets the value of the nr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNr() {
        return nr;
    }

    /**
     * Sets the value of the nr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNr(String value) {
        this.nr = value;
    }

}
