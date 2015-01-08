
package com.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.schema package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of com.schema derived interfaces
 * and classes representing the binding of com.schema
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Spele_QNAME = new QName("", "Spele");

    /**
     * Create a new ObjectFactory that can be used to create new instances of com.schema derived classes for package: com.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SpeleType }
     * 
     */
    public SpeleType createSpeleType() {
        return new SpeleType();
    }

    /**
     * Create an instance of {@link VartiType }
     * 
     */
    public VartiType createVartiType() {
        return new VartiType();
    }

    /**
     * Create an instance of {@link PType }
     * 
     */
    public PType createPType() {
        return new PType();
    }

    /**
     * Create an instance of {@link TType }
     * 
     */
    public TType createTType() {
        return new TType();
    }

    /**
     * Create an instance of {@link MainaType }
     * 
     */
    public MainaType createMainaType() {
        return new MainaType();
    }

    /**
     * Create an instance of {@link PamatsastavsType }
     * 
     */
    public PamatsastavsType createPamatsastavsType() {
        return new PamatsastavsType();
    }

    /**
     * Create an instance of {@link VTType }
     * 
     */
    public VTType createVTType() {
        return new VTType();
    }

    /**
     * Create an instance of {@link SodiType }
     * 
     */
    public SodiType createSodiType() {
        return new SodiType();
    }

    /**
     * Create an instance of {@link SodsType }
     * 
     */
    public SodsType createSodsType() {
        return new SodsType();
    }

    /**
     * Create an instance of {@link KomandaType }
     * 
     */
    public KomandaType createKomandaType() {
        return new KomandaType();
    }

    /**
     * Create an instance of {@link MainasType }
     * 
     */
    public MainasType createMainasType() {
        return new MainasType();
    }

    /**
     * Create an instance of {@link SpeletajiType }
     * 
     */
    public SpeletajiType createSpeletajiType() {
        return new SpeletajiType();
    }

    /**
     * Create an instance of {@link VGType }
     * 
     */
    public VGType createVGType() {
        return new VGType();
    }

    /**
     * Create an instance of {@link SpeletajsType }
     * 
     */
    public SpeletajsType createSpeletajsType() {
        return new SpeletajsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpeleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Spele")
    public JAXBElement<SpeleType> createSpele(SpeleType value) {
        return new JAXBElement<SpeleType>(_Spele_QNAME, SpeleType.class, null, value);
    }

}
