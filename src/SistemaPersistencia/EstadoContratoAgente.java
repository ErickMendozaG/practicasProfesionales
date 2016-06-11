
package SistemaPersistencia;

import java.sql.Date;
import java.sql.Time;

/* @author MACROSOFT:
  
   * CARO, Erica
   * FERREYRA, Cristian
   * MENDOZA, Erick
   * PONCE, Vanesa
  
*/

public class EstadoContratoAgente extends Agente implements EstadoContrato{

    private EstadoContratoImplementacion estadocontrato;
    
    private String OIDTipoEstadoContrato;
    private boolean heBuscadoTipoEstadoContrato;
    
    private String OIDContrato;/* es para la relacion*/

       
    /* Métodos de la Clase EstadoContratoAgente */
    
    /* SET */
    
    public void setEstadocontrato(EstadoContratoImplementacion estadocontrato) {
        this.estadocontrato = estadocontrato;
    }

    public void setOIDTipoEstadoContrato(String OIDTipoEstadoContrato) {
        this.OIDTipoEstadoContrato = OIDTipoEstadoContrato;
    }

    public void setHeBuscadoTipoEstadoContrato(boolean heBuscadoTipoEstadoContrato) {
        this.heBuscadoTipoEstadoContrato = heBuscadoTipoEstadoContrato;
    }

    public void setOIDContrato(String OIDContrato) {
        this.OIDContrato = OIDContrato;
        super.setModificado(true);
    }
           
    /* GET */
    
    public EstadoContratoImplementacion getEstadocontrato() {
        return estadocontrato;
    }

    public String getOIDTipoEstadoContrato() {
        return OIDTipoEstadoContrato;
    }

    public boolean isHeBuscadotipoEstadoContrato() {
        return heBuscadoTipoEstadoContrato;
    }

    public String getOIDContrato() {
        return OIDContrato;
    }
     
    /* Métodos Implementados de la Interfaz EstadoContrato */
    
    /* SET */
    
    @Override
    public void setFechaEstadoContrato(Date fechaEstadoContrato) {
        estadocontrato.setFechaEstadoContrato(fechaEstadoContrato);
        super.setModificado(true);
    }

    @Override
    public void setHoraEstadoContrato(Time horaEstadoContrato) {
        estadocontrato.setHoraEstadoContrato(horaEstadoContrato);
        super.setModificado(true);
    }

    @Override
    public void setTipoEstadoContrato(TipoEstadoContrato tipoEstadoContrato) {
        estadocontrato.setTipoEstadoContrato(tipoEstadoContrato);
        super.setModificado(true);
    }

    /* GET */
    
    @Override
    public Date getFechaEstadoContrato() {
        return estadocontrato.getFechaEstadoContrato();
    }

    @Override
    public Time getHoraEstadoContrato() {
        return estadocontrato.getHoraEstadoContrato();
    }

    @Override
    public TipoEstadoContrato getTipoEstadoContrato() {
        
        if (heBuscadoTipoEstadoContrato == true){
            return estadocontrato.getTipoEstadoContrato();
        }
        else{
            TipoEstadoContrato tipoEstContr = (TipoEstadoContrato) FachadaPersistenciaInterna.getInstancia().buscar("TipoEstadoContrato", OIDTipoEstadoContrato);
            estadocontrato.setTipoEstadoContrato(tipoEstContr);
            this.setHeBuscadoTipoEstadoContrato(true);
            return tipoEstContr;
        }
        
    }
    
}
