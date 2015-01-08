
package com.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SodiType complex type.
 * 
 * <p>The following com.schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SodiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sods" type="{}SodsType" maxOccurs="unbounded" minOccurs="0"/>
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

    @XmlElement(name = "Sods")
    protected List<SodsType> sods;

    /**
     * Gets the value of the sods property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sods property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSods().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SodsType }
     * 
     * 
     */
    public List<SodsType> getSods() {
        if (sods == null) {
            sods = new ArrayList<SodsType>();
        }
        return this.sods;
    }

}
