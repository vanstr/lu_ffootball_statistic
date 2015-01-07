
package com.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for SpeletajsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpeletajsType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="Nr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Vards" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Uzvards" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Loma" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeletajsType", propOrder = {
    "value"
})
public class SpeletajsType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Nr")
    protected String nr;
    @XmlAttribute(name = "Vards")
    protected String vards;
    @XmlAttribute(name = "Uzvards")
    protected String uzvards;
    @XmlAttribute(name = "Loma")
    protected String loma;

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

    /**
     * Gets the value of the loma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoma() {
        return loma;
    }

    /**
     * Sets the value of the loma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoma(String value) {
        this.loma = value;
    }

}
