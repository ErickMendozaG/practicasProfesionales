
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoEstadoContratoImplementacion implements TipoEstadoContrato{
    
    private int nroTipoEstadoContrato;
    private String nombreTipoEstadoContrato;
    
    /* Métodos de la Clase TipoEstadoContratoImplementacion */
    
    /* SET */
    
    @Override
    public void setNroTipoEstadoContrato(int nroTipoEstadoContrato) {
        this.nroTipoEstadoContrato = nroTipoEstadoContrato;
    }
    
    @Override
    public void setNombreTipoEstadoContrato(String nombreTipoEstadoContrato) {
        this.nombreTipoEstadoContrato = nombreTipoEstadoContrato;
    }
    
    /* GET */
    
    @Override
    public int getNroTipoEstadoContrato() {
        return nroTipoEstadoContrato;
    }
    
    @Override
    public String getNombreTipoEstadoContrato() {
        return nombreTipoEstadoContrato;
    }
    
}
