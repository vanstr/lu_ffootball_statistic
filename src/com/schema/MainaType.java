
package com.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for MainaType complex type.
 * 
 * <p>The following com.schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MainaType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="Laiks" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Nr1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Nr2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MainaType", propOrder = {
    "value"
})
public class MainaType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Laiks")
    protected String laiks;
    @XmlAttribute(name = "Nr1")
    protected String nr1;
    @XmlAttribute(name = "Nr2")
    protected String nr2;

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
     * Gets the value of the nr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNr1() {
        return nr1;
    }

    /**
     * Sets the value of the nr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNr1(String value) {
        this.nr1 = value;
    }

    /**
     * Gets the value of the nr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNr2() {
        return nr2;
    }

    /**
     * Sets the value of the nr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNr2(String value) {
        this.nr2 = value;
    }

}
