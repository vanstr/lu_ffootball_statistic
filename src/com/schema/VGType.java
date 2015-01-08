
package com.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VGType complex type.
 * 
 * <p>The following com.schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VGType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="P" type="{}PType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Laiks" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Nr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Sitiens" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VGType", propOrder = {
    "p"
})
public class VGType {

    @XmlElement(name = "P")
    protected List<PType> p;
    @XmlAttribute(name = "Laiks")
    protected String laiks;
    @XmlAttribute(name = "Nr")
    protected String nr;
    @XmlAttribute(name = "Sitiens")
    protected String sitiens;

    /**
     * Gets the value of the p property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the p property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PType }
     * 
     * 
     */
    public List<PType> getP() {
        if (p == null) {
            p = new ArrayList<PType>();
        }
        return this.p;
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

    /**
     * Gets the value of the sitiens property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSitiens() {
        return sitiens;
    }

    /**
     * Sets the value of the sitiens property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSitiens(String value) {
        this.sitiens = value;
    }

}
