
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoEstadoProyectoImplementacion implements TipoEstadoProyecto{
    
    private int nroTipoEstadoProyecto;
    private String nombreTipoEstadoProyecto;

    /* Métodos de la Clase TipoEstadoProyectoImplementacion */
    
    /* SET */
    
    @Override
    public void setNroTipoEstadoProyecto(int nroTipoEstadoProyecto) {
        this.nroTipoEstadoProyecto = nroTipoEstadoProyecto;
    }
    
    @Override
    public void setNombreTipoEstadoProyecto(String nombreTipoEstadoProyecto) {
        this.nombreTipoEstadoProyecto = nombreTipoEstadoProyecto;
    }
    
    /* GET */
    
    @Override
    public int getNroTipoEstadoProyecto() {
        return nroTipoEstadoProyecto;
    }
    
    @Override
    public String getNombreTipoEstadoProyecto() {
        return nombreTipoEstadoProyecto;
    }
    
}
