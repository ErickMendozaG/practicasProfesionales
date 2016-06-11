
package interfazsolicitudestadosacademicos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtoSolicitarEstadoAcademicoG complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtoSolicitarEstadoAcademicoG">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nroDNI" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoDNI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtoSolicitarEstadoAcademicoG", propOrder = {
    "nroDNI",
    "tipoDNI"
})
public class DtoSolicitarEstadoAcademicoG {

    protected int nroDNI;
    protected String tipoDNI;

    /**
     * Obtiene el valor de la propiedad nroDNI.
     * 
     */
    public int getNroDNI() {
        return nroDNI;
    }

    /**
     * Define el valor de la propiedad nroDNI.
     * 
     */
    public void setNroDNI(int value) {
        this.nroDNI = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDNI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDNI() {
        return tipoDNI;
    }

    /**
     * Define el valor de la propiedad tipoDNI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDNI(String value) {
        this.tipoDNI = value;
    }

}
