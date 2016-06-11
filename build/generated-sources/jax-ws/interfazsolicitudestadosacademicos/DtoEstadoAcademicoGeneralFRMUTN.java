
package interfazsolicitudestadosacademicos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtoEstadoAcademicoGeneralFRMUTN complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtoEstadoAcademicoGeneralFRMUTN">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carrera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoAcademico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaBaja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaIngreso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="legajo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="planEstudio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtoEstadoAcademicoGeneralFRMUTN", propOrder = {
    "carrera",
    "estadoAcademico",
    "fechaBaja",
    "fechaIngreso",
    "legajo",
    "planEstudio"
})
public class DtoEstadoAcademicoGeneralFRMUTN {

    protected String carrera;
    protected String estadoAcademico;
    protected String fechaBaja;
    protected String fechaIngreso;
    protected int legajo;
    protected String planEstudio;

    /**
     * Obtiene el valor de la propiedad carrera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Define el valor de la propiedad carrera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrera(String value) {
        this.carrera = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoAcademico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoAcademico() {
        return estadoAcademico;
    }

    /**
     * Define el valor de la propiedad estadoAcademico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoAcademico(String value) {
        this.estadoAcademico = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaBaja.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaBaja() {
        return fechaBaja;
    }

    /**
     * Define el valor de la propiedad fechaBaja.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaBaja(String value) {
        this.fechaBaja = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaIngreso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Define el valor de la propiedad fechaIngreso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaIngreso(String value) {
        this.fechaIngreso = value;
    }

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

    /**
     * Obtiene el valor de la propiedad planEstudio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanEstudio() {
        return planEstudio;
    }

    /**
     * Define el valor de la propiedad planEstudio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanEstudio(String value) {
        this.planEstudio = value;
    }

}
