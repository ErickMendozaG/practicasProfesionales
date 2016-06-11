
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstudianteImplementacion implements Estudiante{
 
    private int legajo;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private int nroDocumento;
    private String domicilioEstudiante;
    
    private TipoDocumento tipoDocumento;
    private Universidad universidadDeEstudiante;

    /* Métodos de la Interfaz EstudianteImplementacion */
    
    /* SET */
    
    @Override
    public void setUniversidadDeEstudiante(Universidad universidadDeEstudiante) {
        this.universidadDeEstudiante = universidadDeEstudiante;
    }
    
    @Override
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    
    @Override
    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }
    
    @Override
    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }
    
    @Override
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    @Override
    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
    
    @Override
    public void setDomicilioEstudiante(String domicilioEstudiante) {
        this.domicilioEstudiante = domicilioEstudiante;
    }

    /* GET */
    
    @Override
    public Universidad getUniversidadDeEstudiante() {
        return universidadDeEstudiante;
    }
    
    @Override
    public int getLegajo() {
        return legajo;
    }
    
    @Override
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }
    
    @Override
    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }
    
    @Override
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
    
    @Override
    public int getNroDocumento() {
        return nroDocumento;
    }
    
    @Override
    public String getDomicilioEstudiante() {
        return domicilioEstudiante;
    }
    
}
