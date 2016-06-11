
package SistemaPersistencia;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class TipoEstadoContratoAgente extends Agente implements TipoEstadoContrato{
    
    private TipoEstadoContratoImplementacion tipoEstadoContrato;
    
    /* Métodos de la Clase TipoEstadoContratoAgente */

    public void setTipoEstadoContrato(TipoEstadoContratoImplementacion tipoEstadoContrato) {
        this.tipoEstadoContrato = tipoEstadoContrato;
    }
    
    public TipoEstadoContratoImplementacion getTipoEstadoContrato() {
        return tipoEstadoContrato;
    }
    
    /* Métodos Implementados de la Interfaz TipoEstadoContrato */
    
    /* SET */
    
    @Override
    public void setNroTipoEstadoContrato(int nroTipoEstadoContrato){
        tipoEstadoContrato.setNroTipoEstadoContrato(nroTipoEstadoContrato);
        super.setModificado(true);
    }
    
    @Override
    public void setNombreTipoEstadoContrato(String nombreTipoEstadoContrato){
        tipoEstadoContrato.setNombreTipoEstadoContrato(nombreTipoEstadoContrato);
        super.setModificado(true);
    }
    
    /* GET */
    
    @Override
    public int getNroTipoEstadoContrato(){
        return tipoEstadoContrato.getNroTipoEstadoContrato();
    }
    
    @Override
    public String getNombreTipoEstadoContrato(){
        return tipoEstadoContrato.getNombreTipoEstadoContrato();
    }
    
}
