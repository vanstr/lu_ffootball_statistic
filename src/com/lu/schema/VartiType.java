
package com.lu.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VartiType complex type.
 * 
 * <p>The following com.lu.schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VartiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VG" type="{}VGType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VartiType", propOrder = {
    "vg"
})
public class VartiType {

    @XmlElement(name = "VG")
    protected List<VGType> vg;

    /**
     * Gets the value of the vg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVG().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VGType }
     * 
     * 
     */
    public List<VGType> getVG() {
        if (vg == null) {
            vg = new ArrayList<VGType>();
        }
        return this.vg;
    }

}
