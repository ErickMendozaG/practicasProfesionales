
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public interface TipoEstadoContrato {
    
    /* SET */
    
    public void setNroTipoEstadoContrato(int nroTipoEstadoContrato);
    public void setNombreTipoEstadoContrato(String nombreTipoEstadoContrato);
    
    /* GET */
    
    public int getNroTipoEstadoContrato();
    public String getNombreTipoEstadoContrato();
}
