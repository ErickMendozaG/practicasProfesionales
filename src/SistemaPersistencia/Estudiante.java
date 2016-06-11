
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface Estudiante {
   
    /* SET */
    
    abstract public void setUniversidadDeEstudiante(Universidad universidadDeEstudiante);
    abstract public void setLegajo(int legajo);
    abstract public void setNombreEstudiante(String nombreEstudiante);
    abstract public void setApellidoEstudiante(String apellidoEstudiante);
    abstract public void setTipoDocumento(TipoDocumento tipoDocumento);
    abstract public void setNroDocumento(int nroDocumento);
    abstract public void setDomicilioEstudiante(String domicilioEstudiante);

    /* GET */
    
    abstract public Universidad getUniversidadDeEstudiante();
    abstract public int getLegajo();
    abstract public String getNombreEstudiante();
    abstract public String getApellidoEstudiante();
    abstract public TipoDocumento getTipoDocumento();
    abstract public int getNroDocumento();
    abstract public String getDomicilioEstudiante();
    
}
