
package interfazsolicitudestadosacademicos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para solicitarEstadoAcademicoDetallado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="solicitarEstadoAcademicoDetallado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dtoSolicitarEstadoAcademicoDetallado" type="{http://InterfazSolicitudEstadosAcademicos/}dtoSolicitarEstadoAcademicoD" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitarEstadoAcademicoDetallado", propOrder = {
    "dtoSolicitarEstadoAcademicoDetallado"
})
public class SolicitarEstadoAcademicoDetallado {

    protected DtoSolicitarEstadoAcademicoD dtoSolicitarEstadoAcademicoDetallado;

    /**
     * Obtiene el valor de la propiedad dtoSolicitarEstadoAcademicoDetallado.
     * 
     * @return
     *     possible object is
     *     {@link DtoSolicitarEstadoAcademicoD }
     *     
     */
    public DtoSolicitarEstadoAcademicoD getDtoSolicitarEstadoAcademicoDetallado() {
        return dtoSolicitarEstadoAcademicoDetallado;
    }

    /**
     * Define el valor de la propiedad dtoSolicitarEstadoAcademicoDetallado.
     * 
     * @param value
     *     allowed object is
     *     {@link DtoSolicitarEstadoAcademicoD }
     *     
     */
    public void setDtoSolicitarEstadoAcademicoDetallado(DtoSolicitarEstadoAcademicoD value) {
        this.dtoSolicitarEstadoAcademicoDetallado = value;
    }

}
