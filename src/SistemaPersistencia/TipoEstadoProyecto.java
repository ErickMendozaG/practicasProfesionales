
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface TipoEstadoProyecto {
    
    /* SET */
    
    public void setNroTipoEstadoProyecto(int nroTipoEstadoProyecto);
    public void setNombreTipoEstadoProyecto(String nombreTipoEstadoProyecto);
    
    /* GET */
    
    public int getNroTipoEstadoProyecto();
    public String getNombreTipoEstadoProyecto();
    
}
