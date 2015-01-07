
package com.xsd;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for SpeleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpeleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VT" type="{}VTType"/>
 *         &lt;element name="T" type="{}TType" maxOccurs="2" minOccurs="2"/>
 *         &lt;element name="Komanda" type="{}KomandaType" maxOccurs="2" minOccurs="2"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Laiks" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Vieta" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Skatitaji" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeleType", propOrder = {
    "vt",
    "t",
    "komanda"
})
public class SpeleType {

    @XmlElement(name = "VT", required = true)
    protected VTType vt;
    @XmlElement(name = "T", required = true)
    protected List<TType> t;
    @XmlElement(name = "Komanda", required = true)
    protected List<KomandaType> komanda;
    @XmlAttribute(name = "Laiks")
    protected String laiks;
    @XmlAttribute(name = "Vieta")
    protected String vieta;
    @XmlAttribute(name = "Skatitaji")
    protected String skatitaji;

    /**
     * Gets the value of the vt property.
     * 
     * @return
     *     possible object is
     *     {@link VTType }
     *     
     */
    public VTType getVT() {
        return vt;
    }

    /**
     * Sets the value of the vt property.
     * 
     * @param value
     *     allowed object is
     *     {@link VTType }
     *     
     */
    public void setVT(VTType value) {
        this.vt = value;
    }

    /**
     * Gets the value of the t property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the t property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TType }
     * 
     * 
     */
    public List<TType> getT() {
        if (t == null) {
            t = new ArrayList<TType>();
        }
        return this.t;
    }

    /**
     * Gets the value of the komanda property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the komanda property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKomanda().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KomandaType }
     * 
     * 
     */
    public List<KomandaType> getKomanda() {
        if (komanda == null) {
            komanda = new ArrayList<KomandaType>();
        }
        return this.komanda;
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
     * Gets the value of the vieta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVieta() {
        return vieta;
    }

    /**
     * Sets the value of the vieta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVieta(String value) {
        this.vieta = value;
    }

    /**
     * Gets the value of the skatitaji property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkatitaji() {
        return skatitaji;
    }

    /**
     * Sets the value of the skatitaji property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkatitaji(String value) {
        this.skatitaji = value;
    }

}
