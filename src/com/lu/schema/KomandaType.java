
package com.lu.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KomandaType complex type.
 * 
 * <p>The following com.lu.schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KomandaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Speletaji" type="{}SpeletajiType"/>
 *         &lt;element name="Pamatsastavs" type="{}PamatsastavsType"/>
 *         &lt;element name="Varti" type="{}VartiType"/>
 *         &lt;element name="Sodi" type="{}SodiType"/>
 *         &lt;element name="Mainas" type="{}MainasType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Nosaukums" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KomandaType", propOrder = {
    "speletaji",
    "pamatsastavs",
    "varti",
    "sodi",
    "mainas"
})
public class KomandaType {

    @XmlElement(name = "Speletaji", required = true)
    protected SpeletajiType speletaji;
    @XmlElement(name = "Pamatsastavs", required = true)
    protected PamatsastavsType pamatsastavs;
    @XmlElement(name = "Varti", required = true)
    protected VartiType varti;
    @XmlElement(name = "Sodi", required = true)
    protected SodiType sodi;
    @XmlElement(name = "Mainas", required = true)
    protected MainasType mainas;
    @XmlAttribute(name = "Nosaukums")
    protected String nosaukums;

    /**
     * Gets the value of the speletaji property.
     * 
     * @return
     *     possible object is
     *     {@link SpeletajiType }
     *     
     */
    public SpeletajiType getSpeletaji() {
        return speletaji;
    }

    /**
     * Sets the value of the speletaji property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeletajiType }
     *     
     */
    public void setSpeletaji(SpeletajiType value) {
        this.speletaji = value;
    }

    /**
     * Gets the value of the pamatsastavs property.
     * 
     * @return
     *     possible object is
     *     {@link PamatsastavsType }
     *     
     */
    public PamatsastavsType getPamatsastavs() {
        return pamatsastavs;
    }

    /**
     * Sets the value of the pamatsastavs property.
     * 
     * @param value
     *     allowed object is
     *     {@link PamatsastavsType }
     *     
     */
    public void setPamatsastavs(PamatsastavsType value) {
        this.pamatsastavs = value;
    }

    /**
     * Gets the value of the varti property.
     * 
     * @return
     *     possible object is
     *     {@link VartiType }
     *     
     */
    public VartiType getVarti() {
        return varti;
    }

    /**
     * Sets the value of the varti property.
     * 
     * @param value
     *     allowed object is
     *     {@link VartiType }
     *     
     */
    public void setVarti(VartiType value) {
        this.varti = value;
    }

    /**
     * Gets the value of the sodi property.
     * 
     * @return
     *     possible object is
     *     {@link SodiType }
     *     
     */
    public SodiType getSodi() {
        return sodi;
    }

    /**
     * Sets the value of the sodi property.
     * 
     * @param value
     *     allowed object is
     *     {@link SodiType }
     *     
     */
    public void setSodi(SodiType value) {
        this.sodi = value;
    }

    /**
     * Gets the value of the mainas property.
     * 
     * @return
     *     possible object is
     *     {@link MainasType }
     *     
     */
    public MainasType getMainas() {
        return mainas;
    }

    /**
     * Sets the value of the mainas property.
     * 
     * @param value
     *     allowed object is
     *     {@link MainasType }
     *     
     */
    public void setMainas(MainasType value) {
        this.mainas = value;
    }

    /**
     * Gets the value of the nosaukums property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNosaukums() {
        return nosaukums;
    }

    /**
     * Sets the value of the nosaukums property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNosaukums(String value) {
        this.nosaukums = value;
    }

}
