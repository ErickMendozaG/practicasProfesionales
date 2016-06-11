
package interfazsolicitudestadosacademicos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the interfazsolicitudestadosacademicos package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SolicitarEstadoAcademicoGeneral_QNAME = new QName("http://InterfazSolicitudEstadosAcademicos/", "solicitarEstadoAcademicoGeneral");
    private final static QName _SolicitarEstadoAcademicoGeneralResponse_QNAME = new QName("http://InterfazSolicitudEstadosAcademicos/", "solicitarEstadoAcademicoGeneralResponse");
    private final static QName _SolicitarEstadoAcademicoDetallado_QNAME = new QName("http://InterfazSolicitudEstadosAcademicos/", "solicitarEstadoAcademicoDetallado");
    private final static QName _SolicitarEstadoAcademicoDetalladoResponse_QNAME = new QName("http://InterfazSolicitudEstadosAcademicos/", "solicitarEstadoAcademicoDetalladoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: interfazsolicitudestadosacademicos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolicitarEstadoAcademicoDetallado }
     * 
     */
    public SolicitarEstadoAcademicoDetallado createSolicitarEstadoAcademicoDetallado() {
        return new SolicitarEstadoAcademicoDetallado();
    }

    /**
     * Create an instance of {@link SolicitarEstadoAcademicoDetalladoResponse }
     * 
     */
    public SolicitarEstadoAcademicoDetalladoResponse createSolicitarEstadoAcademicoDetalladoResponse() {
        return new SolicitarEstadoAcademicoDetalladoResponse();
    }

    /**
     * Create an instance of {@link SolicitarEstadoAcademicoGeneralResponse }
     * 
     */
    public SolicitarEstadoAcademicoGeneralResponse createSolicitarEstadoAcademicoGeneralResponse() {
        return new SolicitarEstadoAcademicoGeneralResponse();
    }

    /**
     * Create an instance of {@link SolicitarEstadoAcademicoGeneral }
     * 
     */
    public SolicitarEstadoAcademicoGeneral createSolicitarEstadoAcademicoGeneral() {
        return new SolicitarEstadoAcademicoGeneral();
    }

    /**
     * Create an instance of {@link DtoEstadoAcademicoGeneralFRMUTN }
     * 
     */
    public DtoEstadoAcademicoGeneralFRMUTN createDtoEstadoAcademicoGeneralFRMUTN() {
        return new DtoEstadoAcademicoGeneralFRMUTN();
    }

    /**
     * Create an instance of {@link DtoSolicitarEstadoAcademicoD }
     * 
     */
    public DtoSolicitarEstadoAcademicoD createDtoSolicitarEstadoAcademicoD() {
        return new DtoSolicitarEstadoAcademicoD();
    }

    /**
     * Create an instance of {@link DtoEstadoAcademicoDetalladoFRMUTN }
     * 
     */
    public DtoEstadoAcademicoDetalladoFRMUTN createDtoEstadoAcademicoDetalladoFRMUTN() {
        return new DtoEstadoAcademicoDetalladoFRMUTN();
    }

    /**
     * Create an instance of {@link DtoSolicitarEstadoAcademicoG }
     * 
     */
    public DtoSolicitarEstadoAcademicoG createDtoSolicitarEstadoAcademicoG() {
        return new DtoSolicitarEstadoAcademicoG();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitarEstadoAcademicoGeneral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://InterfazSolicitudEstadosAcademicos/", name = "solicitarEstadoAcademicoGeneral")
    public JAXBElement<SolicitarEstadoAcademicoGeneral> createSolicitarEstadoAcademicoGeneral(SolicitarEstadoAcademicoGeneral value) {
        return new JAXBElement<SolicitarEstadoAcademicoGeneral>(_SolicitarEstadoAcademicoGeneral_QNAME, SolicitarEstadoAcademicoGeneral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitarEstadoAcademicoGeneralResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://InterfazSolicitudEstadosAcademicos/", name = "solicitarEstadoAcademicoGeneralResponse")
    public JAXBElement<SolicitarEstadoAcademicoGeneralResponse> createSolicitarEstadoAcademicoGeneralResponse(SolicitarEstadoAcademicoGeneralResponse value) {
        return new JAXBElement<SolicitarEstadoAcademicoGeneralResponse>(_SolicitarEstadoAcademicoGeneralResponse_QNAME, SolicitarEstadoAcademicoGeneralResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitarEstadoAcademicoDetallado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://InterfazSolicitudEstadosAcademicos/", name = "solicitarEstadoAcademicoDetallado")
    public JAXBElement<SolicitarEstadoAcademicoDetallado> createSolicitarEstadoAcademicoDetallado(SolicitarEstadoAcademicoDetallado value) {
        return new JAXBElement<SolicitarEstadoAcademicoDetallado>(_SolicitarEstadoAcademicoDetallado_QNAME, SolicitarEstadoAcademicoDetallado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitarEstadoAcademicoDetalladoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://InterfazSolicitudEstadosAcademicos/", name = "solicitarEstadoAcademicoDetalladoResponse")
    public JAXBElement<SolicitarEstadoAcademicoDetalladoResponse> createSolicitarEstadoAcademicoDetalladoResponse(SolicitarEstadoAcademicoDetalladoResponse value) {
        return new JAXBElement<SolicitarEstadoAcademicoDetalladoResponse>(_SolicitarEstadoAcademicoDetalladoResponse_QNAME, SolicitarEstadoAcademicoDetalladoResponse.class, null, value);
    }

}
