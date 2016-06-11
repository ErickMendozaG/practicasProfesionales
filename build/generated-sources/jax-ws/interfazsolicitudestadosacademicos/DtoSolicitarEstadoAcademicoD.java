
package interfazsolicitudestadosacademicos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtoSolicitarEstadoAcademicoD complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtoSolicitarEstadoAcademicoD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="legajo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtoSolicitarEstadoAcademicoD", propOrder = {
    "legajo"
})
public class DtoSolicitarEstadoAcademicoD {

    protected int legajo;

    /**
     * Obtiene el valor de la propiedad legajo.
     * 
     */
    public int getLegajo() {
        return legajo;
    }

    /**
     * Define el valor de la propiedad legajo.
     * 
     */
    public void setLegajo(int value) {
        this.legajo = value;
    }

}
