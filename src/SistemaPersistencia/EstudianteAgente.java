
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstudianteAgente extends Agente implements Estudiante{

    private EstudianteImplementacion estudiante;
    
    private String OIDTipoDocumento;
    private String OIDUniversidadDeEstudiante;
    private boolean heBuscadoTipoDocumento;
    private boolean heBuscadoUniversidadDeEstudiante;
    
    /* Métodos de la Clase EstudianteAgente */
    
    /* SET */
    
    public void setEstudiante(EstudianteImplementacion estudiante) {
        this.estudiante = estudiante;
    }

    public void setOIDTipoDocumento(String OIDTipoDocumento) {
        this.OIDTipoDocumento = OIDTipoDocumento;
    }

    public void setOIDUniversidadDeEstudiante(String OIDUniversidadDeEstudiante) {
        this.OIDUniversidadDeEstudiante = OIDUniversidadDeEstudiante;
    }

    public void setHeBuscadoTipoDocumento(boolean heBuscadoTipoDocumento) {
        this.heBuscadoTipoDocumento = heBuscadoTipoDocumento;
    }

    public void setHeBuscadoUniversidadDeEstudiante(boolean heBuscadoUniversidadDeEstudiante) {
        this.heBuscadoUniversidadDeEstudiante = heBuscadoUniversidadDeEstudiante;
    }
    
    /* GET */
    
    public EstudianteImplementacion getEstudiante() {
        return estudiante;
    }

    public String getOIDTipoDocumento() {
        return OIDTipoDocumento;
    }

    public String getOIDUniversidadDeEstudiante() {
        return OIDUniversidadDeEstudiante;
    }

    public boolean isHeBuscadotipoDocumento() {
        return heBuscadoTipoDocumento;
    }

    public boolean isHeBuscadouniversidadDeEstudiante() {
        return heBuscadoUniversidadDeEstudiante;
    }
    
    /* Métodos Implementados de la Interfaz Estudiante */
    
    /* SET */
    
    @Override
    public void setUniversidadDeEstudiante(Universidad universidadDeEstudiante) {
        estudiante.setUniversidadDeEstudiante(universidadDeEstudiante);
        Agente agente = (Agente) universidadDeEstudiante;
        this.OIDUniversidadDeEstudiante = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void setLegajo(int legajo) {
        estudiante.setLegajo(legajo);
        super.setModificado(true);
    }

    @Override
    public void setNombreEstudiante(String nombreEstudiante) {
        estudiante.setNombreEstudiante(nombreEstudiante);
        super.setModificado(true);
    }

    @Override
    public void setApellidoEstudiante(String apellidoEstudiante) {
        estudiante.setApellidoEstudiante(apellidoEstudiante);
        super.setModificado(true);
    }

    @Override
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        estudiante.setTipoDocumento(tipoDocumento);
        Agente agente = (Agente) tipoDocumento;
        this.OIDTipoDocumento = agente.getOID();
        super.setModificado(true);
    }

    @Override
    public void setNroDocumento(int nroDocumento) {
        estudiante.setNroDocumento(nroDocumento);
        super.setModificado(true);
    }

    @Override
    public void setDomicilioEstudiante(String domicilioEstudiante) {
        estudiante.setDomicilioEstudiante(domicilioEstudiante);
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public Universidad getUniversidadDeEstudiante() {
        
        if (heBuscadoUniversidadDeEstudiante == true){
            return estudiante.getUniversidadDeEstudiante();
        }
        else{
            Universidad univ = (Universidad) FachadaPersistenciaInterna.getInstancia().buscar("Universidad", OIDUniversidadDeEstudiante);
            estudiante.setUniversidadDeEstudiante(univ);
            this.setHeBuscadoUniversidadDeEstudiante(true);
            return univ;
        }  
        
    }

    @Override
    public int getLegajo() {
        return estudiante.getLegajo();
    }

    @Override
    public String getNombreEstudiante() {
        return estudiante.getNombreEstudiante();
    }

    @Override
    public String getApellidoEstudiante() {
        return estudiante.getApellidoEstudiante();
    }

    @Override
    public TipoDocumento getTipoDocumento() {
        
        if (heBuscadoTipoDocumento == true){
            return estudiante.getTipoDocumento();
        }
        else{
            TipoDocumento tipoDoc = (TipoDocumento) FachadaPersistenciaInterna.getInstancia().buscar("TipoDocumento", OIDTipoDocumento);
            estudiante.setTipoDocumento(tipoDoc);
            this.setHeBuscadoTipoDocumento(true);
            return tipoDoc;
        }
        
    }

    @Override
    public int getNroDocumento() {
        return estudiante.getNroDocumento();
    }

    @Override
    public String getDomicilioEstudiante() {
        return estudiante.getDomicilioEstudiante();
    }
    
}
