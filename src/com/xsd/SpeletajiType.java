
package com.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpeletajiType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpeletajiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Speletajs" type="{}SpeletajsType" maxOccurs="unbounded" minOccurs="16"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeletajiType", propOrder = {
    "speletajs"
})
public class SpeletajiType {

    @XmlElement(name = "Speletajs", required = true)
    protected List<SpeletajsType> speletajs;

    /**
     * Gets the value of the speletajs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the speletajs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpeletajs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpeletajsType }
     * 
     * 
     */
    public List<SpeletajsType> getSpeletajs() {
        if (speletajs == null) {
            speletajs = new ArrayList<SpeletajsType>();
        }
        return this.speletajs;
    }

}
